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
package eIPAD.chartsummary.activeproblems.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import eIPAD.chartsummary.activeproblems.dao.ProblemsDiagnosisDAO;
import eIPAD.chartsummary.activeproblems.request.ComplaintSfsRequest;
import eIPAD.chartsummary.activeproblems.request.DiagnosisSfsRequest;
import eIPAD.chartsummary.activeproblems.request.ProblemsDiagnosisRequest;
import eIPAD.chartsummary.activeproblems.response.ComplaintDetailsResponse;
import eIPAD.chartsummary.activeproblems.response.ComplaintSfsResponse;
import eIPAD.chartsummary.activeproblems.response.ComplaintSpecialtyListResponse;
import eIPAD.chartsummary.activeproblems.response.DiagAnatomicalSiteResponse;
import eIPAD.chartsummary.activeproblems.response.DiagnosisAccuracyResponse;
import eIPAD.chartsummary.activeproblems.response.DiagnosisClassificationResponse;
import eIPAD.chartsummary.activeproblems.response.DiagnosisComplaintResponse;
import eIPAD.chartsummary.activeproblems.response.DiagnosisCustomGroupResponse;
import eIPAD.chartsummary.activeproblems.response.DiagnosisDetailsResponse;
import eIPAD.chartsummary.activeproblems.response.DiagnosisSetResponse;
import eIPAD.chartsummary.activeproblems.response.DiagnosisSfsResponse;
import eIPAD.chartsummary.activeproblems.response.DiagnosisValidationResponse;
import eIPAD.chartsummary.activeproblems.response.ProblemsDiagnosisResponse;
import eIPAD.chartsummary.activeproblems.healthobject.AnatomicalSiteHO;
import eIPAD.chartsummary.activeproblems.healthobject.ComplaintDetailsHO;
import eIPAD.chartsummary.activeproblems.healthobject.ComplaintSfsHO;
import eIPAD.chartsummary.activeproblems.healthobject.ComplaintSpecialtyHO;
import eIPAD.chartsummary.activeproblems.healthobject.DiagnosisAccuracyHO;
import eIPAD.chartsummary.activeproblems.healthobject.DiagnosisClassificationHO;
import eIPAD.chartsummary.activeproblems.healthobject.DiagnosisComplaintHO;
import eIPAD.chartsummary.activeproblems.healthobject.DiagnosisCustomGroupHO;
import eIPAD.chartsummary.activeproblems.healthobject.DiagnosisDetailsHO;
import eIPAD.chartsummary.activeproblems.healthobject.DiagnosisSetHO;
import eIPAD.chartsummary.activeproblems.healthobject.DiagnosisSfsHO;
import eIPAD.chartsummary.activeproblems.healthobject.ProblemsDiagnosisHO;
import eIPAD.chartsummary.common.daoimpl.GenericDAOImpl;
import eIPAD.chartsummary.common.healthobject.PatContext;
import eIPAD.chartsummary.common.response.ErrorInfo;
import eIPAD.chartsummary.common.response.Errors;
import eIPAD.chartsummary.encounterlist.bc.EncounterListBC;
import eIPAD.chartsummary.encounterlist.healthobject.EncounterHO;
import eIPAD.chartsummary.encounterlist.request.EncounterListRequest;
import eIPAD.chartsummary.encounterlist.response.EncounterListResponse;

/**
 * @author SaraswathiR 
 *
 */
public class ProblemsDiagnosisDAOImpl extends GenericDAOImpl implements ProblemsDiagnosisDAO {

	/* (non-Javadoc)
	 * @see eIPAD.chartsummary.activeproblems.dao.ProblemsDiagnosisDAO#getActiveProblemsAndDiagnosis(eIPAD.chartsummary.activeproblems.request.ProblemsDiagnosisRequest)
	 */
	public ProblemsDiagnosisResponse getActiveProblemsAndDiagnosis(ProblemsDiagnosisRequest request) {
		ProblemsDiagnosisResponse response = new ProblemsDiagnosisResponse();
		ErrorInfo errorInfo;
		String locale = "en";
		
		if(request != null){
			PatContext rPatContext = request.getPatientContext();
			if(rPatContext != null){
				locale = (rPatContext.getLocale() == null || rPatContext.getLocale().equals("")) ? "en": rPatContext.getLocale();				
				String patientId = rPatContext.getPatientId();
				String encounterId =(rPatContext.getSelectedEncounterId() == null || rPatContext.getSelectedEncounterId().equals("")) ? rPatContext.getEncounterId() : rPatContext.getSelectedEncounterId();
				String facilityId = rPatContext.getFacilityId();
				String pracType = rPatContext.getPracType();
				String practId = rPatContext.getClinicianId();
				boolean showSensitive = request.isShowSensitive();
				//indicate if sensitive data is shown or hidden
				if(showSensitive){
					response.setSensitiveDataShown(true);
				}
				else{
					response.setSensitiveDataShown(false);
				}
				ArrayList<ProblemsDiagnosisHO> problemsDiagnosisArrayList = new ArrayList<ProblemsDiagnosisHO>();
				Connection con = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				
				StringBuffer problemsDiagnosisQuery = new StringBuffer("");
				problemsDiagnosisQuery.append("SELECT encounter_id, diagnosisproblem, description, recorded_by, added_date, compl_count, enc_count, sensitive_yn, onsetdate, datetime, severity, accuracy, termSetId, termSetDesc, curr_accuracy_ind, occur_srl_no, ");
				problemsDiagnosisQuery.append(" enc_stage, status, currenstate FROM ((SELECT NULL AS encounter_id, a.complaint_id diagnosisproblem, complaint_desc description, added_by_id recorded_by, added_date, 'Z' AS ");
				problemsDiagnosisQuery.append(" sensitive_yn, TO_CHAR (a.added_date, 'dd/mm/yyyy') onsetdate, ");
				problemsDiagnosisQuery.append(" NULL AS compl_count, NULL AS enc_count, NULL AS datetime, NULL AS severity, NULL AS accuracy, NULL as termSetId, NULL AS termSetDesc,  NULL AS curr_accuracy_ind, NULL AS occur_srl_no, NULL AS enc_stage, NULL AS status, 'PROBLEM' AS ");
				problemsDiagnosisQuery.append(" currenstate FROM ca_encntr_chief_complaint a WHERE a.facility_id = '"+facilityId+"' AND a.encounter_id = '"+encounterId+"') UNION (SELECT e.encounter_id encounter_id, a.term_code diagnosisproblem, ");
				problemsDiagnosisQuery.append(" a.term_code_short_desc description, a.curr_practitioner_id recorded_by, e.recorded_date_time added_date, c.sensitive_yn, TO_CHAR (a.onset_date, 'dd/mm/yyyy') onsetdate, (SELECT count(*) ");
				problemsDiagnosisQuery.append(" FROM PR_DIAGNOSIS_COMPL_ENC_DTL WHERE   ENCOUNTER_ID = '"+encounterId+"' AND  FACILITY_ID = '"+facilityId+"' AND  TERM_CODE = a.term_code and OCCUR_SRL_NO = a.occur_srl_no) AS compl_count, (SELECT ");
				problemsDiagnosisQuery.append(" count(DISTINCT s.ENCOUNTER_ID) FROM PR_DIAGNOSIS_STATUS s, PR_DIAGNOSIS t WHERE s.patient_id = '"+patientId+"'  AND s.patient_id = t.patient_id and s.term_set_id = t.term_set_id and ");
				problemsDiagnosisQuery.append(" s.term_code = t.term_code AND s.OCCUR_SRL_NO=t.OCCUR_SRL_NO AND s.term_set_id = a.term_set_id AND s.term_code = a.term_code AND s.facility_id ='"+facilityId+"' AND t.CURR_STATUS ='A') AS enc_count, ");
				problemsDiagnosisQuery.append(" TO_CHAR (e.recorded_date_time, 'dd/mm/yyyy hh24:mi:ss' ) datetime, a.curr_severity severity, (SELECT mr_get_desc.mr_accuracy (a.curr_accuracy_code, '2', '2' ) short_desc FROM ");
				problemsDiagnosisQuery.append(" mr_accuracy WHERE accuracy_code = a.curr_accuracy_code) accuracy, b.TERM_SET_ID termSetId, b.TERM_SET_DESC termSetDesc, a.curr_accuracy_ind curr_accuracy_ind, a.occur_srl_no occur_srl_no, e.enc_stage enc_stage, a.curr_status status, 'DIAGNOSIS' AS currenstate FROM ");
				problemsDiagnosisQuery.append(" pr_diagnosis a, mr_term_set b, mr_term_code c, pr_diagnosis_enc_dtl e WHERE a.patient_id = '"+patientId+"' AND a.patient_id = e.patient_id AND a.term_set_id = e.term_set_id AND ");
				problemsDiagnosisQuery.append(" a.occur_srl_no = e.occur_srl_no AND a.term_code = e.term_code AND a.onset_facility_id = e.facility_id AND a.onset_encounter_id = e.encounter_id AND e.encounter_id = '"+encounterId+"' AND ");
				problemsDiagnosisQuery.append(" EXISTS ( SELECT 1 FROM mr_term_set_for_facility WHERE facility_id = '"+facilityId+"' AND term_set_id = a.term_set_id) ");
				problemsDiagnosisQuery.append(" AND EXISTS ( SELECT 1 FROM mr_term_set_for_pract_type WHERE pract_type = '"+pracType+"' AND term_set_id = a.term_set_id) AND EXISTS ( SELECT 1 FROM mr_term_set_for_specialty WHERE ");
				problemsDiagnosisQuery.append(" specialty_code IN ( SELECT specialty_code FROM pr_encounter WHERE facility_id = '"+facilityId+"' AND encounter_id = '"+encounterId+"') AND term_set_id = a.term_set_id) AND (   EXISTS ( SELECT 1 FROM ");
				problemsDiagnosisQuery.append(" mr_term_set_for_pract ib WHERE practitioner_id = '"+practId+"' AND term_set_id = a.term_set_id) OR NOT EXISTS (SELECT 1 FROM mr_term_set_for_pract WHERE practitioner_id = '"+practId+"') ) AND ");
				problemsDiagnosisQuery.append(" b.term_set_id(+) = a.term_set_id AND e.status !='E' AND c.term_set_id(+) = a.term_set_id AND c.term_code(+) = a.term_code)) ORDER BY added_date DESC ");
				
				/*Query backup compl count for problems selected as null currently
				 * problemsDiagnosisQuery.append("SELECT encounter_id, diagnosisproblem, description, recorded_by, added_date, compl_count, enc_count, sensitive_yn, onsetdate, datetime, severity, accuracy, curr_accuracy_ind, ");
				problemsDiagnosisQuery.append(" enc_stage, status, currenstate FROM ((SELECT NULL AS encounter_id, a.complaint_id diagnosisproblem, complaint_desc description, added_by_id recorded_by, added_date, 'Z' AS ");
				problemsDiagnosisQuery.append(" sensitive_yn, TO_CHAR (a.added_date, 'dd/mm/yyyy') onsetdate, (SELECT count(*) FROM PR_DIAGNOSIS_COMPL_ENC_DTL WHERE COMPLAINT_ID =a.complaint_id AND  ENCOUNTER_ID = '"+encounterId+"' AND ");
				problemsDiagnosisQuery.append(" FACILITY_ID = '"+facilityId+"') compl_count, NULL AS enc_count, NULL AS datetime, NULL AS severity, NULL AS accuracy, NULL AS curr_accuracy_ind, NULL AS enc_stage, NULL AS status, 'PROBLEM' AS ");
				problemsDiagnosisQuery.append(" currenstate FROM ca_encntr_chief_complaint a WHERE a.facility_id = '"+facilityId+"' AND a.encounter_id = '"+encounterId+"') UNION (SELECT e.encounter_id encounter_id, a.term_code diagnosisproblem, ");
				problemsDiagnosisQuery.append(" a.term_code_short_desc description, a.curr_practitioner_id recorded_by, e.recorded_date_time added_date, c.sensitive_yn, TO_CHAR (a.onset_date, 'dd/mm/yyyy') onsetdate, (SELECT count(*) ");
				problemsDiagnosisQuery.append(" FROM PR_DIAGNOSIS_COMPL_ENC_DTL WHERE   ENCOUNTER_ID = '"+encounterId+"' AND  FACILITY_ID = '"+facilityId+"' AND  TERM_CODE = a.term_code and OCCUR_SRL_NO = a.occur_srl_no) AS compl_count, (SELECT ");
				problemsDiagnosisQuery.append(" count(DISTINCT s.ENCOUNTER_ID) FROM PR_DIAGNOSIS_STATUS s, PR_DIAGNOSIS t WHERE s.patient_id = '"+patientId+"'  AND s.patient_id = t.patient_id and s.term_set_id = t.term_set_id and ");
				problemsDiagnosisQuery.append(" s.term_code = t.term_code AND s.OCCUR_SRL_NO=t.OCCUR_SRL_NO AND s.term_set_id = a.term_set_id AND s.term_code = a.term_code AND s.facility_id ='"+facilityId+"' AND t.CURR_STATUS ='A') AS enc_count, ");
				problemsDiagnosisQuery.append(" TO_CHAR (e.recorded_date_time, 'dd/mm/yyyy hh24:mi:ss' ) datetime, a.curr_severity severity, (SELECT mr_get_desc.mr_accuracy (a.curr_accuracy_code, '2', '2' ) short_desc FROM ");
				problemsDiagnosisQuery.append(" mr_accuracy WHERE accuracy_code = a.curr_accuracy_code) accuracy, a.curr_accuracy_ind curr_accuracy_ind, e.enc_stage enc_stage, a.curr_status status, 'DIAGNOSIS' AS currenstate FROM ");
				problemsDiagnosisQuery.append(" pr_diagnosis a, mr_term_set b, mr_term_code c, pr_diagnosis_enc_dtl e WHERE a.patient_id = '"+patientId+"' AND a.patient_id = e.patient_id AND a.term_set_id = e.term_set_id AND ");
				problemsDiagnosisQuery.append(" a.occur_srl_no = e.occur_srl_no AND a.term_code = e.term_code AND a.onset_facility_id = e.facility_id AND a.onset_encounter_id = e.encounter_id AND e.encounter_id = '"+encounterId+"' AND ");
				problemsDiagnosisQuery.append(" EXISTS ( SELECT 1 FROM mr_term_set_for_facility WHERE facility_id = '"+facilityId+"' AND term_set_id = a.term_set_id) ");
				problemsDiagnosisQuery.append(" AND EXISTS ( SELECT 1 FROM mr_term_set_for_pract_type WHERE pract_type = '"+pracType+"' AND term_set_id = a.term_set_id) AND EXISTS ( SELECT 1 FROM mr_term_set_for_specialty WHERE ");
				problemsDiagnosisQuery.append(" specialty_code IN ( SELECT specialty_code FROM pr_encounter WHERE facility_id = '"+facilityId+"' AND encounter_id = '"+encounterId+"') AND term_set_id = a.term_set_id) AND (   EXISTS ( SELECT 1 FROM ");
				problemsDiagnosisQuery.append(" mr_term_set_for_pract ib WHERE practitioner_id = '"+practId+"' AND term_set_id = a.term_set_id) OR NOT EXISTS (SELECT 1 FROM mr_term_set_for_pract WHERE practitioner_id = '"+practId+"') ) AND ");
				problemsDiagnosisQuery.append(" b.term_set_id(+) = a.term_set_id AND e.status !='E' AND c.term_set_id(+) = a.term_set_id AND c.term_code(+) = a.term_code)) ORDER BY added_date DESC ");
				 */
				//"SELECT encounter_id, diagnosisproblem, description, recorded_by, added_date, compl_count, sensitive_yn, onsetdate, datetime, severity, accuracy, status, currenstate FROM ((SELECT NULL AS encounter_id, a.complaint_id diagnosisproblem, complaint_desc description, added_by_id recorded_by, added_date, 'Z' AS sensitive_yn, TO_CHAR (a.added_date, 'dd/mm/yyyy') onsetdate, (SELECT count(*) FROM PR_DIAGNOSIS_COMPL_ENC_DTL WHERE COMPLAINT_ID =a.complaint_id AND  ENCOUNTER_ID = ? AND  FACILITY_ID = ?) compl_count, NULL AS datetime, NULL AS severity, NULL AS accuracy, NULL AS status, 'problems' AS currenstate FROM ca_encntr_chief_complaint a WHERE a.facility_id = ? AND a.encounter_id = ?) UNION (SELECT e.encounter_id encounter_id, a.term_code diagnosisproblem, a.term_code_short_desc description, a.curr_practitioner_id recorded_by, e.recorded_date_time added_date, c.sensitive_yn, TO_CHAR (a.onset_date, 'dd/mm/yyyy') onsetdate, (SELECT count(*) FROM PR_DIAGNOSIS_COMPL_ENC_DTL WHERE   ENCOUNTER_ID = ? AND  FACILITY_ID = ? AND  TERM_CODE = a.term_code and OCCUR_SRL_NO = a.occur_srl_no) AS compl_count, TO_CHAR (e.recorded_date_time, 'dd/mm/yyyy hh24:mi:ss' ) datetime, DECODE (a.curr_severity, 'D', 'Moderate', 'L', 'Mild', 'S', 'Severe', 'E', 'Extreme' ) severity, (SELECT mr_get_desc.mr_accuracy (a.curr_accuracy_code, ?, '2' ) short_desc FROM mr_accuracy WHERE accuracy_code = a.curr_accuracy_code) accuracy, DECODE (a.curr_status, 'A', 'Active', 'R', 'Resolved', 'X', 'Revoked', 'E', 'In Error' ) status, 'diagnosis' AS currenstate FROM pr_diagnosis a, mr_term_set b, mr_term_code c, pr_diagnosis_enc_dtl e WHERE a.patient_id = ? AND a.patient_id = e.patient_id AND a.term_set_id = e.term_set_id AND a.occur_srl_no = e.occur_srl_no AND a.term_code = e.term_code AND a.onset_facility_id = e.facility_id AND a.onset_encounter_id = e.encounter_id AND e.encounter_id = ? AND EXISTS ( SELECT 1 FROM mr_term_set_for_facility WHERE facility_id = ? AND term_set_id = a.term_set_id) AND EXISTS ( SELECT 1 FROM mr_term_set_for_pract_type WHERE pract_type = ? AND term_set_id = a.term_set_id) AND EXISTS ( SELECT 1 FROM mr_term_set_for_specialty WHERE specialty_code IN ( SELECT specialty_code FROM pr_encounter WHERE facility_id = ? AND encounter_id = ?) AND term_set_id = a.term_set_id) AND (   EXISTS ( SELECT 1 FROM mr_term_set_for_pract ib WHERE practitioner_id = ? AND term_set_id = a.term_set_id) OR NOT EXISTS (SELECT 1 FROM mr_term_set_for_pract WHERE practitioner_id = ?) ) AND b.term_set_id(+) = a.term_set_id AND c.term_set_id(+) = a.term_set_id AND c.term_code(+) = a.term_code)) ORDER BY added_date DESC";
				
				try{
					con = createConnection();
					if(con == null){
						errorInfo = new ErrorInfo();
						errorInfo.setErrorType(Errors.COMMON_SQL_EXCEPTION,locale);
						response.getErrorsList().add(errorInfo);
					}
					else{
						pstmt=con.prepareStatement(problemsDiagnosisQuery.toString());
						rs = pstmt.executeQuery();
						if(rs == null){
							errorInfo = new ErrorInfo();
							errorInfo.setErrorType(Errors.COMMON_SQL_EXCEPTION,locale);
							response.getErrorsList().add(errorInfo);
						}
						else{
							String encounter_id;
							String diagProbCode;
							String diagProbDesc;
							String recordedByPrac;
							String addedDate;
							int complCount = 0;
							int encCount = 0;
							String sensitiveYN;
							String onsetDate;
							String recordedDateTime;
							String severity;
							String accuracy;
							String termSetId;
							String termSetDesc;
							String currentAccuracyInd;
							String occurSrlNo;
							String encounterStage;
							String status;
							String currentState;
							boolean sensitiveDataPresent = false;
							int sensitiveDataCount = 0;
							while(rs.next())
							{
								sensitiveYN=rs.getString("sensitive_yn")==null?"":rs.getString("sensitive_yn");
								if(sensitiveYN.equals("Y")){
									sensitiveDataPresent = true;
									sensitiveDataCount++;
								}
								
								if(!sensitiveYN.equals("Y") || (sensitiveYN.equals("Y") && showSensitive)){
									encounter_id=rs.getString("encounter_id")==null?"":rs.getString("encounter_id");
									diagProbCode=rs.getString("diagnosisproblem")==null?"":rs.getString("diagnosisproblem");
									diagProbDesc=rs.getString("description")==null?"":rs.getString("description");
									recordedByPrac=rs.getString("recorded_by")==null?"":rs.getString("recorded_by");
									addedDate=rs.getString("added_date")==null?"":rs.getString("added_date");
									complCount=rs.getInt("compl_count");
									encCount=rs.getInt("enc_count");
									
									onsetDate=rs.getString("onsetdate")==null?"":rs.getString("onsetdate");
									recordedDateTime=rs.getString("datetime")==null?"":rs.getString("datetime");
									severity=rs.getString("severity")==null?"":rs.getString("severity");
									accuracy=rs.getString("accuracy")==null?"":rs.getString("accuracy");
									termSetId=rs.getString("termSetId")==null?"":rs.getString("termSetId");
									termSetDesc=rs.getString("termSetDesc")==null?"":rs.getString("termSetDesc");
									currentAccuracyInd=rs.getString("curr_accuracy_ind")==null?"":rs.getString("curr_accuracy_ind");
									occurSrlNo=rs.getString("occur_srl_no")==null?"":rs.getString("occur_srl_no");
									encounterStage=rs.getString("enc_stage")==null?"":rs.getString("enc_stage");
									status=rs.getString("status")==null?"":rs.getString("status");
									currentState=rs.getString("currenstate")==null?"":rs.getString("currenstate");
									
									ProblemsDiagnosisHO problemsDiagnosisHO = new ProblemsDiagnosisHO();
									problemsDiagnosisHO.setEncounterId(encounter_id);
									problemsDiagnosisHO.setDiagProbCode(diagProbCode);
									problemsDiagnosisHO.setDiagProbDesc(diagProbDesc);
									problemsDiagnosisHO.setRecordedByPrac(recordedByPrac);
									problemsDiagnosisHO.setAddedDate(addedDate);
									problemsDiagnosisHO.setComplCount(complCount);
									problemsDiagnosisHO.setEncounterCount(encCount);
									problemsDiagnosisHO.setSensitiveYN(sensitiveYN);
									problemsDiagnosisHO.setOnsetDate(onsetDate);
									problemsDiagnosisHO.setRecordedDateTime(recordedDateTime);
									problemsDiagnosisHO.setSeverity(severity);
									problemsDiagnosisHO.setAccuracy(accuracy);
									problemsDiagnosisHO.setTermSetId(termSetId);
									problemsDiagnosisHO.setTermSetDesc(termSetDesc);
									problemsDiagnosisHO.setCurrentAccuracyInd(currentAccuracyInd);
									problemsDiagnosisHO.setOccurSrlNo(occurSrlNo);
									problemsDiagnosisHO.setEncounterStage(encounterStage);
									problemsDiagnosisHO.setStatus(status);
									problemsDiagnosisHO.setCurrentState(currentState);
									
									problemsDiagnosisArrayList.add(problemsDiagnosisHO);
								}
							}
							
							response.setProblemsDiagnosisList(problemsDiagnosisArrayList);
							response.setSensitiveDataPresent(sensitiveDataPresent);
							response.setSensitiveDiagnosisCount(sensitiveDataCount);
							if(problemsDiagnosisArrayList.size() <= 0){
								errorInfo = new ErrorInfo();
								errorInfo.setErrorType(Errors.PROBLEMSDIAGNOSIS_EMPTY_DATA,locale);
								response.getErrorsList().add(errorInfo);
							}
							else{
								errorInfo = new ErrorInfo();
								errorInfo.setErrorType(Errors.COMMON_SUCCESS,locale);
								response.getErrorsList().add(errorInfo);
							}
						}
					}
				}
				catch(SQLException e){
					System.out.println("A database exception occurred while fetching problems and diagnosis details" +e);
					errorInfo = new ErrorInfo();
					errorInfo.setErrorType(Errors.COMMON_SQL_EXCEPTION,locale);
					response.getErrorsList().add(errorInfo);
				}
				catch(Exception e){
					errorInfo = new ErrorInfo();
					errorInfo.setErrorType(Errors.COMMON_NULL_EXCEPTION,locale);
					response.getErrorsList().add(errorInfo);
				}
				finally{
					int conCloseFailure = closeConnection(con,pstmt,rs);
					
				}
			}
			else{
				errorInfo = new ErrorInfo();
				errorInfo.setErrorType(Errors.COMMON_NULL_REQUEST,locale);
				response.getErrorsList().add(errorInfo);
			}
		}
		else 
		{
			errorInfo = new ErrorInfo();
			errorInfo.setErrorType(Errors.COMMON_NULL_REQUEST,locale);
			response.getErrorsList().add(errorInfo);
		}
		
		return response;
	}
	
	public int isUserAuthorizedForSensitiveDate(PatContext patientContext, String password){
		int authorized = 0; 
		if(patientContext == null || password == null){
			authorized = -1;
			return authorized;
		}
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String facilityId = patientContext.getFacilityId() == null?"":patientContext.getFacilityId();
		String clinicianId = patientContext.getClinicianId() == null?"":patientContext.getClinicianId(); 
		
		String authorizationQuery = "Select VW_SEN_DIAG_FOR_CONS_PAT_YN access_rights_yn from mr_user_access_rights where appl_user_id ='"+clinicianId+"' and facility_id='"+facilityId+"' and upper(app_password.decrypt(SEN_DIAG_PASSWORD))='"+password+"'";
		//0 - Unauthorized   1 - Authorized  -1 - Failure/Exception
		try{
			con = createConnection();
			if(con == null){
				authorized = -1;
			}
			else{
				pstmt=con.prepareStatement(authorizationQuery.toString());
				rs = pstmt.executeQuery();
				if(rs == null){
					authorized = -1;
				}
				else{
					if(rs.next()){
						String result = rs.getString("access_rights_yn");
						if(result.equals("Y")){
							authorized = 1;
						}
						else {
							authorized = 0;
						}
					}
					else{
						authorized = 0;
					}
				}
			}
		}
		catch(SQLException e){
			authorized = -1;
			System.out.println("An SQLException occured while running authorize query");
			e.printStackTrace();
		}
		catch(Exception e){
			System.out.println("An Exception occured while in the ProblemsDiagnosis Authorize method ");
			e.printStackTrace();
		}
		finally{
			int conCloseFailure = closeConnection(con,pstmt,rs);
		}
		return authorized;
	}
	
	/*
	 * Query taken from /eCA/jsp/ChartSummaryActiveProblemsD.jsp
	 */
	public ProblemsDiagnosisResponse getLinkedProblemsForDiagnosis(PatContext patientContext, String termSetId, String diagCode, String termSetDesc, String occurSrlNo){
		ProblemsDiagnosisResponse response = new ProblemsDiagnosisResponse();
		ErrorInfo errorInfo;
		String locale = (patientContext.getLocale() == null || patientContext.getLocale() == "") ? "en": patientContext.getLocale();
		String encounterId = (patientContext.getSelectedEncounterId() == null || patientContext.getSelectedEncounterId().equals("")) ? patientContext.getEncounterId() : patientContext.getSelectedEncounterId();
		String facilityId = patientContext.getFacilityId();
		
		ArrayList<ProblemsDiagnosisHO> problemsDiagnosisArrayList = new ArrayList<ProblemsDiagnosisHO>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		if(termSetId==null || termSetId.equals("")){
			errorInfo = new ErrorInfo();
			errorInfo.setErrorType(Errors.COMMON_NULL_REQUEST,locale);
			response.getErrorsList().add(errorInfo);
		}
		else if(diagCode==null || diagCode.equals("")){
			errorInfo = new ErrorInfo();
			errorInfo.setErrorType(Errors.COMMON_NULL_REQUEST,locale);
			response.getErrorsList().add(errorInfo);
		}
		else if(occurSrlNo==null || occurSrlNo.equals("")){
			errorInfo = new ErrorInfo();
			errorInfo.setErrorType(Errors.COMMON_NULL_REQUEST,locale);
			response.getErrorsList().add(errorInfo);
		}
		else{
			StringBuffer linkedProbsQuery = new StringBuffer("");
			linkedProbsQuery.append("select a.complaint_id complaint_id, CA_GET_DESC.CA_CHIEF_COMPLAINT(a.complaint_id,'"+locale+"','2') complaint_text,to_char(a.onset_date,'dd/mm/yyyy HH24:MI') ");
			linkedProbsQuery.append("onset_datetime_str from pr_diagnosis_compl_enc_dtl a where a.facility_id='"+facilityId+"' and a.encounter_id='"+encounterId+"' and a.term_set_id='"+termSetId+"' and ( a.term_code = '"+diagCode+"' or  a.term_code_short_desc = '"+termSetDesc+"') ");
			linkedProbsQuery.append("AND OCCUR_SRL_NO ='"+occurSrlNo+"' order by a.onset_date desc");
			
			try{
				con = createConnection();
				if(con == null){
					errorInfo = new ErrorInfo();
					errorInfo.setErrorType(Errors.COMMON_SQL_EXCEPTION,locale);
					response.getErrorsList().add(errorInfo);
				}
				else{
					pstmt=con.prepareStatement(linkedProbsQuery.toString());
					rs = pstmt.executeQuery();
					if(rs == null){
						errorInfo = new ErrorInfo();
						errorInfo.setErrorType(Errors.COMMON_SQL_EXCEPTION,locale);
						response.getErrorsList().add(errorInfo);
					}
					else{
						String complaintId;
						String complaintDesc;
						String onsetDate;
						while(rs.next())
						{
							complaintId=rs.getString("complaint_id")==null?"":rs.getString("complaint_id");
							complaintDesc=rs.getString("complaint_text")==null?"":rs.getString("complaint_text");
							onsetDate=rs.getString("onset_datetime_str")==null?"":rs.getString("onset_datetime_str");
							ProblemsDiagnosisHO problemsDiagnosisHO = new ProblemsDiagnosisHO();
							problemsDiagnosisHO.setDiagProbCode(complaintId);
							problemsDiagnosisHO.setDiagProbDesc(complaintDesc);
							problemsDiagnosisHO.setOnsetDate(onsetDate);
							problemsDiagnosisHO.setSensitiveYN("Z");
							problemsDiagnosisHO.setCurrentState("PROBLEM");
							
							problemsDiagnosisArrayList.add(problemsDiagnosisHO);
						}
						response.setProblemsDiagnosisList(problemsDiagnosisArrayList);
						if(problemsDiagnosisArrayList.size() <= 0){
							errorInfo = new ErrorInfo();
							errorInfo.setErrorType(Errors.COMMON_EMPTY_DATA,locale);
							response.getErrorsList().add(errorInfo);
						}
						else{
							errorInfo = new ErrorInfo();
							errorInfo.setErrorType(Errors.COMMON_SUCCESS,locale);
							response.getErrorsList().add(errorInfo);
						}
					}
				}
			}
			catch(SQLException e){
				System.out.println("A database exception occurred while fetching problems and diagnosis details" +e);
				errorInfo = new ErrorInfo();
				errorInfo.setErrorType(Errors.COMMON_SQL_EXCEPTION,locale);
				response.getErrorsList().add(errorInfo);
			}
			catch(Exception e){
				errorInfo = new ErrorInfo();
				errorInfo.setErrorType(Errors.COMMON_NULL_EXCEPTION,locale);
				response.getErrorsList().add(errorInfo);
			}
			finally{
				int conCloseFailure = closeConnection(con,pstmt,rs);
			}
	}	
		return response;
	}
	
	/*
	 * Query taken from /eCA/jsp/ChartSummaryActiveProblemsEncDetails.jsp
	 */
	public EncounterListResponse getLinkedEncountersForDiagnosis(PatContext patientContext, String termSetId, String diagCode, String status){
		EncounterListResponse response = new EncounterListResponse();
		ErrorInfo errorInfo;
		
		String locale = (patientContext.getLocale() == null || patientContext.getLocale() == "") ? "en": patientContext.getLocale();
		String patientId = patientContext.getPatientId(); 
		String facilityId = patientContext.getFacilityId();
		
		ArrayList<EncounterHO> EncountersArrayList = new ArrayList<EncounterHO>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		if(termSetId==null || termSetId.equals("")){
			errorInfo = new ErrorInfo();
			errorInfo.setErrorType(Errors.COMMON_NULL_REQUEST,locale);
			response.getErrorsList().add(errorInfo);
		}
		else if(diagCode==null || diagCode.equals("")){
			errorInfo = new ErrorInfo();
			errorInfo.setErrorType(Errors.COMMON_NULL_REQUEST,locale);
			response.getErrorsList().add(errorInfo);
		}
		else if(status==null || status.equals("")){
			errorInfo = new ErrorInfo();
			errorInfo.setErrorType(Errors.COMMON_NULL_REQUEST,locale);
			response.getErrorsList().add(errorInfo);
		}
		else{
			StringBuffer linkedEncountersQuery = new StringBuffer("");
			linkedEncountersQuery.append("SELECT DISTINCT a.ENCOUNTER_ID encounter_id, e.PATIENT_CLASS patient_class, TO_CHAR (e.visit_adm_date_time, 'DD/MM/YYYY hh24:mi') visit_date, ");
			linkedEncountersQuery.append("(SELECT short_name FROM am_practitioner_lang_vw    WHERE practitioner_id = e.attend_practitioner_id and language_id = '"+locale+"') as practShortName FROM ");
			linkedEncountersQuery.append("PR_DIAGNOSIS_STATUS A, pr_encounter e, PR_DIAGNOSIS b WHERE A.patient_id = '"+patientId+"' AND a.patient_id = e.patient_id AND a.patient_id = b.patient_id AND ");
			linkedEncountersQuery.append("a.ENCOUNTER_ID = e.ENCOUNTER_ID and a.term_set_id = b.term_set_id and a.term_code = b.term_code AND a.OCCUR_SRL_NO=b.OCCUR_SRL_NO AND a.term_set_id = '"+termSetId+"' ");
			linkedEncountersQuery.append("AND a.term_code = '"+diagCode+"' AND a.facility_id = '"+facilityId+"' AND B.CURR_STATUS = '"+status+"' ORDER BY to_date(visit_date,'DD/MM/YYYY hh24:mi') desc");
			
			
			try{
				con = createConnection();
				if(con == null){
					errorInfo = new ErrorInfo();
					errorInfo.setErrorType(Errors.COMMON_SQL_EXCEPTION,locale);
					response.getErrorsList().add(errorInfo);
				}
				else{
					pstmt=con.prepareStatement(linkedEncountersQuery.toString());
					rs = pstmt.executeQuery();
					if(rs == null){
						errorInfo = new ErrorInfo();
						errorInfo.setErrorType(Errors.COMMON_SQL_EXCEPTION,locale);
						response.getErrorsList().add(errorInfo);
					}
					else{
						String linkedEncounterId;
						String patientClass;
						String visitDate;
						String practShortName;
						while(rs.next())
						{
							linkedEncounterId=rs.getString("encounter_id")==null?"":rs.getString("encounter_id");
							patientClass=rs.getString("patient_class")==null?"":rs.getString("patient_class");
							visitDate=rs.getString("visit_date")==null?"":rs.getString("visit_date");
							practShortName=rs.getString("practShortName")==null?"":rs.getString("practShortName");
							EncounterHO encounterHO = new EncounterHO();
							encounterHO.setEncounterId(linkedEncounterId);
							encounterHO.setPatientClass(patientClass);
							encounterHO.setVisitDate(visitDate);
							encounterHO.setPractShortName(practShortName);
							
							EncountersArrayList.add(encounterHO);
						}
						response.setEncounterList(EncountersArrayList);
						if(EncountersArrayList.size() <= 0){
							errorInfo = new ErrorInfo();
							errorInfo.setErrorType(Errors.COMMON_EMPTY_DATA,locale);
							response.getErrorsList().add(errorInfo);
						}
						else{
							errorInfo = new ErrorInfo();
							errorInfo.setErrorType(Errors.COMMON_SUCCESS,locale);
							response.getErrorsList().add(errorInfo);
						}
					}
				}
			}
			catch(SQLException e){
				System.out.println("A database exception occurred while fetching Linked encounter details" +e);
				errorInfo = new ErrorInfo();
				errorInfo.setErrorType(Errors.COMMON_SQL_EXCEPTION,locale);
				response.getErrorsList().add(errorInfo);
			}
			catch(Exception e){
				errorInfo = new ErrorInfo();
				errorInfo.setErrorType(Errors.COMMON_NULL_EXCEPTION,locale);
				response.getErrorsList().add(errorInfo);
			}
			finally{
				int conCloseFailure = closeConnection(con,pstmt,rs);
			}
		}
			
		return response;
	}
	
	/*
	 * Query taken from RecDiagnosisAddModify.jsp
	 * 
	 */
	public DiagnosisSetResponse getDiagnosisSetList(PatContext patientContext){
		
		DiagnosisSetResponse response = new DiagnosisSetResponse();
		ErrorInfo errorInfo;
		String locale = "en";
		
		if(patientContext != null){
			String practType = patientContext.getPracType();
			String practID = patientContext.getClinicianId();
			String facilityId = patientContext.getFacilityId();
			//String encounterId = (patientContext.getSelectedEncounterId() == null || patientContext.getSelectedEncounterId().equals("")) ? patientContext.getEncounterId() : patientContext.getSelectedEncounterId();
			String encounterId = patientContext.getEncounterId();
			locale = (patientContext.getLocale() == null || patientContext.getLocale().equals("")) ? "en": patientContext.getLocale();
			
			ArrayList<DiagnosisSetHO> diagnosisSetList = new ArrayList<DiagnosisSetHO>();
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			StringBuffer diagSetQuery = new StringBuffer("");
			diagSetQuery.append("select a.term_set_id,(SELECT b.dflt_term_set_yn FROM mr_term_set_for_pract_type b,am_practitioner c WHERE b.pract_type = '"+practType+"' AND b.term_set_id = a.term_set_id ");
			diagSetQuery.append(" AND c.practitioner_id = '"+practID+"' AND c.pract_type = b.pract_type) default_pract_type,(SELECT b.dflt_term_set_yn FROM mr_term_set_for_pract_type d, ");
			diagSetQuery.append(" mr_term_set_for_pract b, am_practitioner c WHERE d.term_set_id = b.term_set_id AND d.pract_type = '"+practType+"' AND b.practitioner_id = '"+practID+"'  AND ");
			diagSetQuery.append(" c.practitioner_id = b.practitioner_id AND c.pract_type = d.pract_type AND a.term_set_id = d.term_set_id) default_pract,");
			diagSetQuery.append(" priority_appl_yn || '=' || nature_appl_yn || '=' || severity_appl_yn || '=' || onset_type_appl_yn || '=' || factors_appl_yn || '=' || notification_appl_yn || '=' || enc_stage_appl_yn term_set_id1, ");
			diagSetQuery.append(" mr_get_desc.mr_term_set(a.term_set_id,'"+locale+"',1)term_set_desc ,free_text_applicable_yn from MR_TERM_SET a where exists (select 1 from MR_TERM_SET_FOR_FACILITY ");
			diagSetQuery.append(" where facility_id = '"+facilityId+"' and term_set_id = a.term_set_id) and exists (select 1 from MR_TERM_SET_FOR_PRACT_TYPE where pract_type = '"+practType+"' and term_set_id = a.term_set_id) and ");
			diagSetQuery.append(" exists (select 1 from MR_TERM_SET_FOR_SPECIALTY where specialty_code in (select specialty_code from PR_ENCOUNTER where facility_id = '"+facilityId+"' and encounter_id = '"+encounterId+"' )  and ");
			diagSetQuery.append(" term_set_id = a.term_set_id) and (exists (select 1 from MR_TERM_SET_FOR_PRACT ib where practitioner_id = '"+practID+"' and  term_set_id = a.term_set_id) or ");
			diagSetQuery.append(" not exists (select 1 from MR_TERM_SET_FOR_PRACT where practitioner_id = '"+practID+"' )) and eff_status = 'E' and diag_spec_yn = 'Y' order by term_set_desc ");

			try{
				con = createConnection();
				if(con == null){
					errorInfo = new ErrorInfo();
					errorInfo.setErrorType(Errors.COMMON_SQL_EXCEPTION,locale);
					response.getErrorsList().add(errorInfo);
				}
				else{
					pstmt=con.prepareStatement(diagSetQuery.toString());
					rs = pstmt.executeQuery();
					if(rs == null){
						errorInfo = new ErrorInfo();
						errorInfo.setErrorType(Errors.COMMON_SQL_EXCEPTION,locale);
						response.getErrorsList().add(errorInfo);
					}
					else{
						String diagSetId;
						String diagSetDesc;
						boolean defaultDiagSet;
						String applicableFields;
						boolean freeTextDiagnosis;
						while(rs.next())
						{
							diagSetId=rs.getString("term_set_id")==null?"":rs.getString("term_set_id");
							diagSetDesc=rs.getString("term_set_desc")==null?"":rs.getString("term_set_desc");
							defaultDiagSet=rs.getString("default_pract")!=null && rs.getString("default_pract").equals("Y")?true:false;
							applicableFields=rs.getString("term_set_id1")==null?"":rs.getString("term_set_id1");
							freeTextDiagnosis=rs.getString("free_text_applicable_yn")!=null && rs.getString("free_text_applicable_yn").equals("Y")?true:false;
							
							DiagnosisSetHO diagnosisSetHO = new DiagnosisSetHO();
							diagnosisSetHO.setCode(diagSetId);
							diagnosisSetHO.setDesc(diagSetDesc);
							diagnosisSetHO.setDefaultValue(defaultDiagSet);
							diagnosisSetHO.setApplicableFields(applicableFields);
							diagnosisSetHO.setFreeTextDiagnosis(freeTextDiagnosis);
							diagnosisSetList.add(diagnosisSetHO);
							
							if(defaultDiagSet){
								response.setDefaultValue(diagSetId);
							}
						}
						
						response.setDiagnosisSetList(diagnosisSetList);
						if(diagnosisSetList.size() <= 0){
							errorInfo = new ErrorInfo();
							errorInfo.setErrorType(Errors.COMMON_EMPTY_DATA,locale);
							response.getErrorsList().add(errorInfo);
						}
						else{
							errorInfo = new ErrorInfo();
							errorInfo.setErrorType(Errors.COMMON_SUCCESS,locale);
							response.getErrorsList().add(errorInfo);
						}
					}
				}
			}
			catch(SQLException e){
				System.out.println("A database exception occurred while fetching problems and diagnosis details" +e);
				errorInfo = new ErrorInfo();
				errorInfo.setErrorType(Errors.COMMON_SQL_EXCEPTION,locale);
				response.getErrorsList().add(errorInfo);
			}
			catch(Exception e){
				errorInfo = new ErrorInfo();
				errorInfo.setErrorType(Errors.COMMON_NULL_EXCEPTION,locale);
				response.getErrorsList().add(errorInfo);
			}
			finally{
				int conCloseFailure = closeConnection(con,pstmt,rs);
			}
		}
		else{
			errorInfo = new ErrorInfo();
			errorInfo.setErrorType(Errors.COMMON_NULL_REQUEST,locale);
			response.getErrorsList().add(errorInfo);
		}
		return response;
	}
	
	/*
	 * Query taken from eMR selectProblem.jsp
	 * 
	 */
	public DiagnosisClassificationResponse getDiagnosisClassificationList(PatContext patientContext, String diagSetId){
		
		DiagnosisClassificationResponse response = new DiagnosisClassificationResponse();
		ErrorInfo errorInfo;
		String locale = "en";
		
		if(patientContext != null && diagSetId != null && !diagSetId.equals("")){
			locale = (patientContext.getLocale() == null || patientContext.getLocale().equals("")) ? "en": patientContext.getLocale();
			
			ArrayList<DiagnosisClassificationHO> diagClassificationList = new ArrayList<DiagnosisClassificationHO>();
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			StringBuffer diagClassQuery = new StringBuffer("");
			diagClassQuery.append("SELECT A.DIAG_CLASS_CODE, mr_get_desc.mr_diag_class(a.diag_class_code,'"+locale+"','2')SHORT_DESC,DIAG_CLASS_TYPE, ");
			diagClassQuery.append(" B.DEFAULT_STATUS FROM MR_DIAG_CLASS A, MR_DIAG_CLASS_DTL B WHERE A.DIAG_CLASS_CODE = B.DIAG_CLASS_CODE AND ");
			diagClassQuery.append(" B.TERM_SET_ID='"+diagSetId+"' AND A.EFF_STATUS='E' ORDER BY SHORT_DESC");
			
			try{
				con = createConnection();
				if(con == null){
					errorInfo = new ErrorInfo();
					errorInfo.setErrorType(Errors.COMMON_SQL_EXCEPTION,locale);
					response.getErrorsList().add(errorInfo);
				}
				else{
					pstmt=con.prepareStatement(diagClassQuery.toString());
					rs = pstmt.executeQuery();
					if(rs == null){
						errorInfo = new ErrorInfo();
						errorInfo.setErrorType(Errors.COMMON_SQL_EXCEPTION,locale);
						response.getErrorsList().add(errorInfo);
					}
					else{
						String diagClassCode;
						String diagClassDesc;
						String diagClassType;
						boolean defaultDiagClass;
						while(rs.next())
						{
							diagClassCode=rs.getString("diag_class_code")==null?"":rs.getString("diag_class_code");
							diagClassDesc=rs.getString("SHORT_DESC")==null?"":rs.getString("SHORT_DESC");
							diagClassType=rs.getString("DIAG_CLASS_TYPE")==null?"":rs.getString("DIAG_CLASS_TYPE");
							defaultDiagClass=rs.getString("DEFAULT_STATUS")!=null && rs.getString("DEFAULT_STATUS").equals("Y")?true:false;
							
							DiagnosisClassificationHO diagnosisClassificationHO = new DiagnosisClassificationHO();
							diagnosisClassificationHO.setCode(diagClassCode);
							diagnosisClassificationHO.setDesc(diagClassDesc);
							diagnosisClassificationHO.setType(diagClassType);
							diagnosisClassificationHO.setDefaultValue(defaultDiagClass);
							diagClassificationList.add(diagnosisClassificationHO);
							
							if(defaultDiagClass){
								response.setDefaultValue(diagClassCode);
							}
							
						}
						
						response.setDiagClassificationList(diagClassificationList);
						if(diagClassificationList.size() <= 0){
							errorInfo = new ErrorInfo();
							errorInfo.setErrorType(Errors.COMMON_EMPTY_DATA,locale);
							response.getErrorsList().add(errorInfo);
						}
						else{
							errorInfo = new ErrorInfo();
							errorInfo.setErrorType(Errors.COMMON_SUCCESS,locale);
							response.getErrorsList().add(errorInfo);
						}
					}
				}
			}
			catch(SQLException e){
				System.out.println("A database exception occurred while fetching problems and diagnosis details" +e);
				errorInfo = new ErrorInfo();
				errorInfo.setErrorType(Errors.COMMON_SQL_EXCEPTION,locale);
				response.getErrorsList().add(errorInfo);
			}
			catch(Exception e){
				errorInfo = new ErrorInfo();
				errorInfo.setErrorType(Errors.COMMON_NULL_EXCEPTION,locale);
				response.getErrorsList().add(errorInfo);
			}
			finally{
				int conCloseFailure = closeConnection(con,pstmt,rs);
			}
		}
		else{
			errorInfo = new ErrorInfo();
			errorInfo.setErrorType(Errors.COMMON_NULL_REQUEST,locale);
			response.getErrorsList().add(errorInfo);
		}
		return response;
	}
	
	/*
	 * Query taken from eMR selectProblem.jsp
	 * 
	 */
	public DiagnosisComplaintResponse getDiagnosisComplaintsList(PatContext patientContext, String diagSetId ){
		
		DiagnosisComplaintResponse response = new DiagnosisComplaintResponse();
		ErrorInfo errorInfo;
		String locale = "en";
		String facilityId;
		String encounterId;
		
		if(patientContext != null && diagSetId != null && !diagSetId.equals("")){
			locale = (patientContext.getLocale() == null || patientContext.getLocale().equals("")) ? "en": patientContext.getLocale();
			facilityId = patientContext.getFacilityId();
			//encounterId = (patientContext.getSelectedEncounterId() == null || patientContext.getSelectedEncounterId().equals("")) ? patientContext.getEncounterId() : patientContext.getSelectedEncounterId();
			encounterId = patientContext.getEncounterId();
			ArrayList<DiagnosisComplaintHO> diagComplaintList = new ArrayList<DiagnosisComplaintHO>();
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			StringBuffer diagComplaintQuery = new StringBuffer("");
			diagComplaintQuery.append("select a.complaint_id complaint_id, complaint_desc, CA_GET_DESC.CA_CHIEF_COMPLAINT(a.complaint_id,'"+locale+"','2') complaint_text, ");
			diagComplaintQuery.append(" a.remarks, to_char(a.onset_datetime,'dd/mm/yyyy HH24:MI') onset_datetime_str from ca_encntr_chief_complaint a where a.facility_id='"+facilityId+"' and  ");
			diagComplaintQuery.append(" a.encounter_id='"+encounterId+"' and a.complaint_id not in (select complaint_id from pr_diagnosis_compl_enc_dtl b  where ");
			diagComplaintQuery.append(" b.facility_id='"+facilityId+"' and b.encounter_id='"+encounterId+"' and b.term_set_id='"+diagSetId+"' ) order by a.onset_datetime desc ");
			
			
			try{
				con = createConnection();
				if(con == null){
					errorInfo = new ErrorInfo();
					errorInfo.setErrorType(Errors.COMMON_SQL_EXCEPTION,locale);
					response.getErrorsList().add(errorInfo);
				}
				else{
					pstmt=con.prepareStatement(diagComplaintQuery.toString());
					rs = pstmt.executeQuery();
					if(rs == null){
						errorInfo = new ErrorInfo();
						errorInfo.setErrorType(Errors.COMMON_SQL_EXCEPTION,locale);
						response.getErrorsList().add(errorInfo);
					}
					else{
						String diagCompCode;
						String diagCompDesc;
						while(rs.next())
						{
							diagCompCode=rs.getString("complaint_id")==null?"":rs.getString("complaint_id");
							diagCompDesc=rs.getString("complaint_text")==null?"":rs.getString("complaint_text");
							
							DiagnosisComplaintHO diagnosisComplaintHO = new DiagnosisComplaintHO();
							diagnosisComplaintHO.setCode(diagCompCode);
							diagnosisComplaintHO.setDesc(diagCompDesc);
							diagComplaintList.add(diagnosisComplaintHO);
			
							
						}
						
						response.setComplaintsList(diagComplaintList);
						if(diagComplaintList.size() <= 0){
							errorInfo = new ErrorInfo();
							errorInfo.setErrorType(Errors.COMMON_EMPTY_DATA,locale);
							response.getErrorsList().add(errorInfo);
						}
						else{
							errorInfo = new ErrorInfo();
							errorInfo.setErrorType(Errors.COMMON_SUCCESS,locale);
							response.getErrorsList().add(errorInfo);
						}
					}
				}
			}
			catch(SQLException e){
				System.out.println("A database exception occurred while fetching problems and diagnosis details" +e);
				errorInfo = new ErrorInfo();
				errorInfo.setErrorType(Errors.COMMON_SQL_EXCEPTION,locale);
				response.getErrorsList().add(errorInfo);
			}
			catch(Exception e){
				errorInfo = new ErrorInfo();
				errorInfo.setErrorType(Errors.COMMON_NULL_EXCEPTION,locale);
				response.getErrorsList().add(errorInfo);
			}
			finally{
				int conCloseFailure = closeConnection(con,pstmt,rs);
			}
		}
		else{
			errorInfo = new ErrorInfo();
			errorInfo.setErrorType(Errors.COMMON_NULL_REQUEST,locale);
			response.getErrorsList().add(errorInfo);
		}
		return response;
	}
	/*
	 * Query taken from eMR selectProblem.jsp
	 * THis method is used to get the Complaints list for an existing Diagnosis for Modify usecase
	 */
	public DiagnosisComplaintResponse getDiagnosisComplaintsListExisting(PatContext patientContext, String diagSetId, String diagCode, String occurSrlNo){
		
		DiagnosisComplaintResponse response = new DiagnosisComplaintResponse();
		ErrorInfo errorInfo;
		String locale = "en";
		String facilityId;
		String encounterId;
		if(patientContext != null && diagSetId != null && !diagSetId.equals("")){
			locale = (patientContext.getLocale() == null || patientContext.getLocale().equals("")) ? "en": patientContext.getLocale();
			facilityId = patientContext.getFacilityId();
			encounterId = (patientContext.getSelectedEncounterId() == null || patientContext.getSelectedEncounterId().equals("")) ? patientContext.getEncounterId() : patientContext.getSelectedEncounterId();
			//encounterId = patientContext.getEncounterId();
			ArrayList<DiagnosisComplaintHO> diagComplaintList = new ArrayList<DiagnosisComplaintHO>();
			ArrayList<String> existingComplaints = new ArrayList<String>();
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			PreparedStatement e_pstmt = null;
			ResultSet e_rs = null;
			
			StringBuffer existDiagComplaintQuery = new StringBuffer("select a.complaint_id complaint_id, CA_GET_DESC.CA_CHIEF_COMPLAINT(a.complaint_id,'"+locale+"','2') complaint_text, ");
			existDiagComplaintQuery.append(" to_char(a.onset_date,'dd/mm/yyyy HH24:MI') onset_datetime_str from pr_diagnosis_compl_enc_dtl a where a.encounter_id='"+encounterId+"' and ");
			existDiagComplaintQuery.append(" a.facility_id='"+facilityId+"' and  a.term_set_id='"+diagSetId+"' and a.occur_srl_no='"+occurSrlNo+"'and a.term_code = '"+diagCode+"' order by a.onset_date desc ");
			
			StringBuffer diagComplaintQuery = new StringBuffer("");
			diagComplaintQuery.append("select a.complaint_id complaint_id, complaint_desc, CA_GET_DESC.CA_CHIEF_COMPLAINT(a.complaint_id,'"+locale+"','2') complaint_text, ");
			diagComplaintQuery.append(" a.remarks, to_char(a.onset_datetime,'dd/mm/yyyy HH24:MI') onset_datetime_str from ca_encntr_chief_complaint a where a.facility_id='"+facilityId+"' and  ");
			diagComplaintQuery.append(" a.encounter_id='"+encounterId+"' and a.complaint_id not in (select complaint_id from pr_diagnosis_compl_enc_dtl b  where ");
			diagComplaintQuery.append(" b.facility_id='"+facilityId+"' and b.encounter_id='"+encounterId+"' and b.term_set_id='"+diagSetId+"' ) order by a.onset_datetime desc ");
			
			
			try{
				con = createConnection();
				if(con == null){
					errorInfo = new ErrorInfo();
					errorInfo.setErrorType(Errors.COMMON_SQL_EXCEPTION,locale);
					response.getErrorsList().add(errorInfo);
				}
				else{
					//Selected Complaints
					e_pstmt=con.prepareStatement(existDiagComplaintQuery.toString());
					e_rs = e_pstmt.executeQuery();
					if(e_rs == null){
						errorInfo = new ErrorInfo();
						errorInfo.setErrorType(Errors.COMMON_SQL_EXCEPTION,locale);
						response.getErrorsList().add(errorInfo);
					}
					else{
						String diagCompCode;
						String diagCompDesc;
						while(e_rs.next())
						{
							diagCompCode=e_rs.getString("complaint_id")==null?"":e_rs.getString("complaint_id");
							diagCompDesc=e_rs.getString("complaint_text")==null?"":e_rs.getString("complaint_text");
							
							DiagnosisComplaintHO diagnosisComplaintHO = new DiagnosisComplaintHO();
							diagnosisComplaintHO.setCode(diagCompCode);
							diagnosisComplaintHO.setDesc(diagCompDesc);
							diagComplaintList.add(diagnosisComplaintHO);
							existingComplaints.add(diagCompCode);
							
						}
						response.setSelectedComplaints(existingComplaints);
						/*response.setComplaintsList(diagComplaintList);
						if(diagComplaintList.size() <= 0){
							errorInfo = new ErrorInfo();
							errorInfo.setErrorType(Errors.COMMON_EMPTY_DATA,locale);
							response.getErrorsList().add(errorInfo);
						}
						else{
							errorInfo = new ErrorInfo();
							errorInfo.setErrorType(Errors.COMMON_SUCCESS,locale);
							response.getErrorsList().add(errorInfo);
						}*/
					}
					
					//Non selected
					pstmt=con.prepareStatement(diagComplaintQuery.toString());
					rs = pstmt.executeQuery();
					if(rs == null){
						errorInfo = new ErrorInfo();
						errorInfo.setErrorType(Errors.COMMON_SQL_EXCEPTION,locale);
						response.getErrorsList().add(errorInfo);
					}
					else{
						String diagCompCode;
						String diagCompDesc;
						while(rs.next())
						{
							diagCompCode=rs.getString("complaint_id")==null?"":rs.getString("complaint_id");
							diagCompDesc=rs.getString("complaint_text")==null?"":rs.getString("complaint_text");
							
							DiagnosisComplaintHO diagnosisComplaintHO = new DiagnosisComplaintHO();
							diagnosisComplaintHO.setCode(diagCompCode);
							diagnosisComplaintHO.setDesc(diagCompDesc);
							diagComplaintList.add(diagnosisComplaintHO);
			
							
						}
						
						response.setComplaintsList(diagComplaintList);
						if(diagComplaintList.size() <= 0){
							errorInfo = new ErrorInfo();
							errorInfo.setErrorType(Errors.COMMON_EMPTY_DATA,locale);
							response.getErrorsList().add(errorInfo);
						}
						else{
							errorInfo = new ErrorInfo();
							errorInfo.setErrorType(Errors.COMMON_SUCCESS,locale);
							response.getErrorsList().add(errorInfo);
						}
					}
				}
			}
			catch(SQLException e){
				System.out.println("A database exception occurred while fetching problems and diagnosis details" +e);
				errorInfo = new ErrorInfo();
				errorInfo.setErrorType(Errors.COMMON_SQL_EXCEPTION,locale);
				response.getErrorsList().add(errorInfo);
			}
			catch(Exception e){
				errorInfo = new ErrorInfo();
				errorInfo.setErrorType(Errors.COMMON_NULL_EXCEPTION,locale);
				response.getErrorsList().add(errorInfo);
			}
			finally{
				int conCloseFailure = closeConnection(con,pstmt,rs);
				conCloseFailure = closeConnection(e_rs);
				conCloseFailure = closeConnection(e_pstmt);
			}
		}
		else{
			errorInfo = new ErrorInfo();
			errorInfo.setErrorType(Errors.COMMON_NULL_REQUEST,locale);
			response.getErrorsList().add(errorInfo);
		}
		return response;
	}


	/*
	 * Query taken from RecDiagnosisAddModify.jsp
	 * 
	 */
	public DiagnosisAccuracyResponse getDiagnosisAccuracyList(PatContext patientContext){
		
		DiagnosisAccuracyResponse response = new DiagnosisAccuracyResponse();
		ErrorInfo errorInfo;
		String locale = "en";
		
		if(patientContext != null){
			locale = (patientContext.getLocale() == null || patientContext.getLocale().equals("")) ? "en": patientContext.getLocale();
			String patientClass = patientContext.getPatientClass();
			ArrayList<DiagnosisAccuracyHO> diagAccuracyList = new ArrayList<DiagnosisAccuracyHO>();
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			StringBuffer diagAccuracyQuery = new StringBuffer("");
			diagAccuracyQuery.append("select a.accuracy_indicator accuracy_ind, a.accuracy_code, a.short_desc,b.DFLT_VALUE_YN from MR_ACCURACY_LANG_VW a , mr_term_set_crit_for_pc b where ");
			diagAccuracyQuery.append(" a.language_id='"+locale+"' and a.eff_status='E' AND a.accuracy_code=b.accuracy_code and b.patient_class='"+patientClass+"' and b.criteria='ACCURACY' order by a.short_desc ");
			
			try{
				con = createConnection();
				if(con == null){
					errorInfo = new ErrorInfo();
					errorInfo.setErrorType(Errors.COMMON_SQL_EXCEPTION,locale);
					response.getErrorsList().add(errorInfo);
				}
				else{
					pstmt=con.prepareStatement(diagAccuracyQuery.toString());
					rs = pstmt.executeQuery();
					if(rs == null){
						errorInfo = new ErrorInfo();
						errorInfo.setErrorType(Errors.COMMON_SQL_EXCEPTION,locale);
						response.getErrorsList().add(errorInfo);
					}
					else{
						String accuracyCode;
						String accuracyDesc;
						String accuracyInd;
						boolean defaultAccuracy;
						while(rs.next())
						{
							accuracyCode=rs.getString("accuracy_code")==null?"":rs.getString("accuracy_code");
							accuracyDesc=rs.getString("short_desc")==null?"":rs.getString("short_desc");
							accuracyInd=rs.getString("accuracy_ind")==null?"":rs.getString("accuracy_ind");
							defaultAccuracy=rs.getString("DFLT_VALUE_YN")!=null && rs.getString("DFLT_VALUE_YN").equals("Y")?true:false;
							
							DiagnosisAccuracyHO diagnosisAccuracyHO = new DiagnosisAccuracyHO();
							diagnosisAccuracyHO.setCode(accuracyCode);
							diagnosisAccuracyHO.setDesc(accuracyDesc);
							diagnosisAccuracyHO.setAccInd(accuracyInd);
							diagnosisAccuracyHO.setDefaultValue(defaultAccuracy);
							diagAccuracyList.add(diagnosisAccuracyHO);
							
							if(defaultAccuracy){
								response.setDefaultValue(accuracyCode);
							}
							
						}
						
						response.setDiagAccuracyList(diagAccuracyList);
						if(diagAccuracyList.size() <= 0){
							errorInfo = new ErrorInfo();
							errorInfo.setErrorType(Errors.COMMON_EMPTY_DATA,locale);
							response.getErrorsList().add(errorInfo);
						}
						else{
							errorInfo = new ErrorInfo();
							errorInfo.setErrorType(Errors.COMMON_SUCCESS,locale);
							response.getErrorsList().add(errorInfo);
						}
					}
				}
			}
			catch(SQLException e){
				System.out.println("A database exception occurred while fetching problems and diagnosis details" +e);
				errorInfo = new ErrorInfo();
				errorInfo.setErrorType(Errors.COMMON_SQL_EXCEPTION,locale);
				response.getErrorsList().add(errorInfo);
			}
			catch(Exception e){
				errorInfo = new ErrorInfo();
				errorInfo.setErrorType(Errors.COMMON_NULL_EXCEPTION,locale);
				response.getErrorsList().add(errorInfo);
			}
			finally{
				int conCloseFailure = closeConnection(con,pstmt,rs);
			}
		}
		else{
			errorInfo = new ErrorInfo();
			errorInfo.setErrorType(Errors.COMMON_NULL_REQUEST,locale);
			response.getErrorsList().add(errorInfo);
		}
		return response;
	}
	

	/*
	 * Query taken from RecDiagnosisValidation.jsp
	 * 
	 */
	public DiagAnatomicalSiteResponse getDiagnosisAnatomicalSiteList(PatContext patientContext, boolean oralCavity){
		
		DiagAnatomicalSiteResponse response = new DiagAnatomicalSiteResponse();
		ErrorInfo errorInfo;
		String locale = "en";
		String oralCavityStr = "N";
		
		if(patientContext != null){
			locale = (patientContext.getLocale() == null || patientContext.getLocale().equals("")) ? "en": patientContext.getLocale();
			if(oralCavity){
				oralCavityStr = "Y";
			}
			ArrayList<AnatomicalSiteHO> diagAnatomicalSiteList = new ArrayList<AnatomicalSiteHO>();
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			StringBuffer diagAnatomicalQuery = new StringBuffer("");
			diagAnatomicalQuery.append("select anatomical_site_code,am_get_desc.am_anatomical_site(anatomical_site_code,'"+locale+"',2)short_desc ");
			diagAnatomicalQuery.append(" from am_anatomical_site where oral_cavity_yn = '"+oralCavityStr+"' and eff_status = 'E' order by short_desc");
			
			try{
				con = createConnection();
				if(con == null){
					errorInfo = new ErrorInfo();
					errorInfo.setErrorType(Errors.COMMON_SQL_EXCEPTION,locale);
					response.getErrorsList().add(errorInfo);
				}
				else{
					pstmt=con.prepareStatement(diagAnatomicalQuery.toString());
					rs = pstmt.executeQuery();
					if(rs == null){
						errorInfo = new ErrorInfo();
						errorInfo.setErrorType(Errors.COMMON_SQL_EXCEPTION,locale);
						response.getErrorsList().add(errorInfo);
					}
					else{
						String code;
						String desc;
						while(rs.next())
						{
							code=rs.getString("anatomical_site_code")==null?"":rs.getString("anatomical_site_code");
							desc=rs.getString("short_desc")==null?"":rs.getString("short_desc");
							
							AnatomicalSiteHO anatomicalSiteHO = new AnatomicalSiteHO();
							anatomicalSiteHO.setCode(code);
							anatomicalSiteHO.setDesc(desc);
							diagAnatomicalSiteList.add(anatomicalSiteHO);
							
						}
						
						response.setDiagAnatomicalSiteList(diagAnatomicalSiteList);
						if(diagAnatomicalSiteList.size() <= 0){
							errorInfo = new ErrorInfo();
							errorInfo.setErrorType(Errors.COMMON_EMPTY_DATA,locale);
							response.getErrorsList().add(errorInfo);
						}
						else{
							errorInfo = new ErrorInfo();
							errorInfo.setErrorType(Errors.COMMON_SUCCESS,locale);
							response.getErrorsList().add(errorInfo);
						}
					}
				}
			}
			catch(SQLException e){
				System.out.println("A database exception occurred while fetching problems and diagnosis details" +e);
				errorInfo = new ErrorInfo();
				errorInfo.setErrorType(Errors.COMMON_SQL_EXCEPTION,locale);
				response.getErrorsList().add(errorInfo);
			}
			catch(Exception e){
				errorInfo = new ErrorInfo();
				errorInfo.setErrorType(Errors.COMMON_NULL_EXCEPTION,locale);
				response.getErrorsList().add(errorInfo);
			}
			finally{
				int conCloseFailure = closeConnection(con,pstmt,rs);
			}
		}
		else{
			errorInfo = new ErrorInfo();
			errorInfo.setErrorType(Errors.COMMON_NULL_REQUEST,locale);
			response.getErrorsList().add(errorInfo);
		}
		return response;
	}
	
	/*
	 * Query is present in the response object
	 * 
	 */
	public DiagnosisSfsResponse getDiagnosisCodeList(DiagnosisSfsRequest req){
		DiagnosisSfsResponse response = new DiagnosisSfsResponse();
		ErrorInfo errorInfo;
			ArrayList<DiagnosisSfsHO> diagnosisSfsHOList = new ArrayList<DiagnosisSfsHO>();
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String locale = req.getLocale();
			String diagSfsQuery = req.getQuery().getSfsQuery();
			
			try{
				con = createConnection();
				if(con == null){
					errorInfo = new ErrorInfo();
					errorInfo.setErrorType(Errors.COMMON_SQL_EXCEPTION,locale);
					response.getErrorsList().add(errorInfo);
				}
				else{
					pstmt=con.prepareStatement(diagSfsQuery);
					rs = pstmt.executeQuery();
					if(rs == null){
						errorInfo = new ErrorInfo();
						errorInfo.setErrorType(Errors.COMMON_SQL_EXCEPTION,locale);
						response.getErrorsList().add(errorInfo);
					}
					else{
						String code;
						String desc;
						String sensitiveYN;
						while(rs.next())
						{
							code=rs.getString("code")==null?"":rs.getString("code");
							desc=rs.getString("description")==null?"":rs.getString("description");
							sensitiveYN = rs.getString("SENSITIVE_YN")==null?"":rs.getString("SENSITIVE_YN");
							
							DiagnosisSfsHO diagnosisSfsHO = new DiagnosisSfsHO();
							diagnosisSfsHO.setCode(code);
							diagnosisSfsHO.setDescription(desc);
							diagnosisSfsHO.setSensitiveYN(sensitiveYN);
							diagnosisSfsHOList.add(diagnosisSfsHO);
							
						}
						
						response.setDiagnosisSfsList(diagnosisSfsHOList);
						if(diagnosisSfsHOList.size() <= 0){
							errorInfo = new ErrorInfo();
							errorInfo.setErrorType(Errors.COMMON_EMPTY_DATA,locale);
							response.getErrorsList().add(errorInfo);
						}
						else{
							errorInfo = new ErrorInfo();
							errorInfo.setErrorType(Errors.COMMON_SUCCESS,locale);
							response.getErrorsList().add(errorInfo);
						}
					}
				}
			}
			catch(SQLException e){
				System.out.println("A database exception occurred while fetching problems and diagnosis details" +e);
				errorInfo = new ErrorInfo();
				errorInfo.setErrorType(Errors.COMMON_SQL_EXCEPTION,locale);
				response.getErrorsList().add(errorInfo);
			}
			catch(Exception e){
				errorInfo = new ErrorInfo();
				errorInfo.setErrorType(Errors.COMMON_NULL_EXCEPTION,locale);
				response.getErrorsList().add(errorInfo);
			}
			finally{
				int conCloseFailure = closeConnection(con,pstmt,rs);
			}

		return response;
	}
	/*
	 * Query is present in the response object
	 * 
	 */
	public ComplaintSfsResponse getComplaintCodeList(ComplaintSfsRequest req){
		ComplaintSfsResponse response = new ComplaintSfsResponse();
		ErrorInfo errorInfo;
			ArrayList<ComplaintSfsHO> complaintSfsList = new ArrayList<ComplaintSfsHO>();
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String locale = req.getLocale();
			String complSfsQuery = req.getQuery().getSfsQuery();
			
			try{
				con = createConnection();
				if(con == null){
					errorInfo = new ErrorInfo();
					errorInfo.setErrorType(Errors.COMMON_SQL_EXCEPTION,locale);
					response.getErrorsList().add(errorInfo);
				}
				else{
					pstmt=con.prepareStatement(complSfsQuery);
					rs = pstmt.executeQuery();
					if(rs == null){
						errorInfo = new ErrorInfo();
						errorInfo.setErrorType(Errors.COMMON_SQL_EXCEPTION,locale);
						response.getErrorsList().add(errorInfo);
					}
					else{
						String code;
						String desc;
						String complaintText;
						while(rs.next())
						{
							code=rs.getString("code")==null?"":rs.getString("code");
							desc=rs.getString("description")==null?"":rs.getString("description");
							complaintText = rs.getString("COMPLAINT_TEXT")==null?"":rs.getString("COMPLAINT_TEXT");
							
							ComplaintSfsHO complaintSfsHO = new ComplaintSfsHO();
							complaintSfsHO.setCode(code);
							complaintSfsHO.setDescription(desc);
							complaintSfsHO.setComplaintText(complaintText);
							complaintSfsList.add(complaintSfsHO);
							
						}
						
						response.setComplaintSfsList(complaintSfsList);
						if(complaintSfsList.size() <= 0){
							errorInfo = new ErrorInfo();
							errorInfo.setErrorType(Errors.COMMON_EMPTY_DATA,locale);
							response.getErrorsList().add(errorInfo);
						}
						else{
							errorInfo = new ErrorInfo();
							errorInfo.setErrorType(Errors.COMMON_SUCCESS,locale);
							response.getErrorsList().add(errorInfo);
						}
					}
				}
			}
			catch(SQLException e){
				System.out.println("A database exception occurred while fetching details for Complaints SFS" +e);
				errorInfo = new ErrorInfo();
				errorInfo.setErrorType(Errors.COMMON_SQL_EXCEPTION,locale);
				response.getErrorsList().add(errorInfo);
			}
			catch(Exception e){
				errorInfo = new ErrorInfo();
				errorInfo.setErrorType(Errors.COMMON_NULL_EXCEPTION,locale);
				response.getErrorsList().add(errorInfo);
			}
			finally{
				int conCloseFailure = closeConnection(con,pstmt,rs);
			}

		return response;
	}
	/*
	 * Query taken from eMR GroupHeading.jsp
	 * 
	 */
	public DiagnosisCustomGroupResponse getDiagnosisCustomGroupList(PatContext patientContext, String diagSetId, String specialtyCode){
		
		DiagnosisCustomGroupResponse response = new DiagnosisCustomGroupResponse();
		ErrorInfo errorInfo;
		String locale = "en";
		String facilityId;
		String encounterId;
		String practID;
		if(patientContext != null && diagSetId != null && !diagSetId.equals("")){
			locale = (patientContext.getLocale() == null || patientContext.getLocale().equals("")) ? "en": patientContext.getLocale();
			facilityId = patientContext.getFacilityId();
			practID = patientContext.getClinicianId();
			//encounterId = (patientContext.getSelectedEncounterId() == null || patientContext.getSelectedEncounterId().equals("")) ? patientContext.getEncounterId() : patientContext.getSelectedEncounterId();
			encounterId = patientContext.getEncounterId();
			ArrayList<DiagnosisCustomGroupHO> diagCustomList = new ArrayList<DiagnosisCustomGroupHO>();
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			StringBuffer diagCustListQuery = new StringBuffer("");
			diagCustListQuery.append("select a.term_group_id diag_group_code , a.term_group_desc diag_group_desc from MR_TERM_GROUP_HDR a where a.term_set_id = '"+diagSetId+"' and  ");
			diagCustListQuery.append(" ( a.index_type_yn = 'N' or exists ( select 1 from MR_CUSTOM_LIST_TERM_GROUP_DTL where term_set_id = a.term_set_id and ");
			diagCustListQuery.append(" term_group_id = a.term_group_id and index_type='P' and practitioner_id = '"+practID+"' ) or exists ( select 1 from MR_CUSTOM_LIST_TERM_GROUP_DTL where ");
			diagCustListQuery.append(" term_set_id = a.term_set_id and term_group_id = a.term_group_id and index_type='S' and speciality_code = '"+specialtyCode+"'  AND (speciality_code = (select SPECIALTY_CODE from ");
			diagCustListQuery.append(" pr_encounter where facility_id = '"+facilityId+"' and encounter_id = '"+encounterId+"'))  )) and eff_status='E' order by 2 ");
			
			
			try{
				con = createConnection();
				if(con == null){
					errorInfo = new ErrorInfo();
					errorInfo.setErrorType(Errors.COMMON_SQL_EXCEPTION,locale);
					response.getErrorsList().add(errorInfo);
				}
				else{
					pstmt=con.prepareStatement(diagCustListQuery.toString());
					rs = pstmt.executeQuery();
					if(rs == null){
						errorInfo = new ErrorInfo();
						errorInfo.setErrorType(Errors.COMMON_SQL_EXCEPTION,locale);
						response.getErrorsList().add(errorInfo);
					}
					else{
						String diagCompCode;
						String diagCompDesc;
						while(rs.next())
						{
							diagCompCode=rs.getString("diag_group_code")==null?"":rs.getString("diag_group_code");
							diagCompDesc=rs.getString("diag_group_desc")==null?"":rs.getString("diag_group_desc");
							
							DiagnosisCustomGroupHO diagnosisCustomGroupHO = new DiagnosisCustomGroupHO();
							diagnosisCustomGroupHO.setCode(diagCompCode);
							diagnosisCustomGroupHO.setDesc(diagCompDesc);
							diagCustomList.add(diagnosisCustomGroupHO);
			
							
						}
						
						response.setDiagnosisCustomList(diagCustomList);
						if(diagCustomList.size() <= 0){
							errorInfo = new ErrorInfo();
							errorInfo.setErrorType(Errors.COMMON_EMPTY_DATA,locale);
							response.getErrorsList().add(errorInfo);
						}
						else{
							errorInfo = new ErrorInfo();
							errorInfo.setErrorType(Errors.COMMON_SUCCESS,locale);
							response.getErrorsList().add(errorInfo);
						}
					}
				}
			}
			catch(SQLException e){
				System.out.println("A database exception occurred while fetching problems and diagnosis details" +e);
				errorInfo = new ErrorInfo();
				errorInfo.setErrorType(Errors.COMMON_SQL_EXCEPTION,locale);
				response.getErrorsList().add(errorInfo);
			}
			catch(Exception e){
				errorInfo = new ErrorInfo();
				errorInfo.setErrorType(Errors.COMMON_NULL_EXCEPTION,locale);
				response.getErrorsList().add(errorInfo);
			}
			finally{
				int conCloseFailure = closeConnection(con,pstmt,rs);
			}
		}
		else{
			errorInfo = new ErrorInfo();
			errorInfo.setErrorType(Errors.COMMON_NULL_REQUEST,locale);
			response.getErrorsList().add(errorInfo);
		}
		return response;
	}
	
	public DiagnosisValidationResponse checkActiveDiagnosisExists(PatContext patientContext, String diagSetId, String diagnosisCode){
		
		String patientId;
		int result = 0;
		ErrorInfo errorInfo;
		String locale = "en";
		
		DiagnosisValidationResponse response = new DiagnosisValidationResponse();
		if(patientContext != null && diagnosisCode != null && !diagnosisCode.equals("") && diagSetId != null && !diagSetId.equals("")){
			patientId = patientContext.getPatientId();
			locale = (patientContext.getLocale() == null || patientContext.getLocale().equals("")) ? "en": patientContext.getLocale();
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			StringBuffer diagExistsQuery = new StringBuffer("");
			diagExistsQuery.append("select 1 from pr_diagnosis  where patient_id = '"+patientId+"'  and TERM_SET_ID='"+diagSetId+"' and TERM_CODE='"+diagnosisCode+"'   and CURR_STATUS ='A' AND TERM_CODE NOT IN '*OTH'");
			
			
			try{
				con = createConnection();
				if(con == null){
					errorInfo = new ErrorInfo();
					errorInfo.setErrorType(Errors.COMMON_SQL_EXCEPTION,locale);
					response.getErrorsList().add(errorInfo);
					response.setValidationResult(-1);
				}
				else{
					pstmt=con.prepareStatement(diagExistsQuery.toString());
					rs = pstmt.executeQuery();
					if(rs == null){
						errorInfo = new ErrorInfo();
						errorInfo.setErrorType(Errors.COMMON_SQL_EXCEPTION,locale);
						response.getErrorsList().add(errorInfo);
						response.setValidationResult(-1);
					}
					else{
						while(rs.next())
						{
							result=rs.getInt(1);
						}
						errorInfo = new ErrorInfo();
						errorInfo.setErrorType(Errors.COMMON_SUCCESS,locale);
						response.getErrorsList().add(errorInfo);
						if(result==1){
							response.setValidationResult(0); //Validation failure, since an active diagnosis of same code exists already
						}else{
							response.setValidationResult(1); //Validation Succeeded. No such active diagnosis exists already
						}
						
					}
				}
			}
			catch(SQLException e){
				System.out.println("A database exception occurred while fetching problems and diagnosis details" +e);
				errorInfo = new ErrorInfo();
				errorInfo.setErrorType(Errors.COMMON_SQL_EXCEPTION,locale);
				response.getErrorsList().add(errorInfo);
				response.setValidationResult(-1);
			}
			catch(Exception e){
				errorInfo = new ErrorInfo();
				errorInfo.setErrorType(Errors.COMMON_NULL_EXCEPTION,locale);
				response.getErrorsList().add(errorInfo);
				response.setValidationResult(-1);
			}
			finally{
				int conCloseFailure = closeConnection(con,pstmt,rs);
			}
		}
		else{
			errorInfo = new ErrorInfo();
			errorInfo.setErrorType(Errors.COMMON_NULL_REQUEST,locale);
			response.getErrorsList().add(errorInfo);
			response.setValidationResult(-1);
		}
		return response;
		
		
	}
	
	public DiagnosisValidationResponse checkPrimaryDiagnosisExists(PatContext patientContext, String diagSetId){
		
		String encounterId;
		String facilityId;
		int result = 0;
		ErrorInfo errorInfo;
		String locale = "en";
		DiagnosisValidationResponse response = new DiagnosisValidationResponse();
		if(patientContext != null && diagSetId != null && !diagSetId.equals("")){
			encounterId = patientContext.getEncounterId();
			facilityId = patientContext.getFacilityId();
			locale = (patientContext.getLocale() == null || patientContext.getLocale().equals("")) ? "en": patientContext.getLocale();
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			StringBuffer diagExistsQuery = new StringBuffer("");
			diagExistsQuery.append("select count(*) from pr_diagnosis_enc_dtl a, MR_DIAG_CLASS b where a.FACILITY_ID='"+facilityId+"' AND a.ENCOUNTER_ID='"+encounterId+"' and ");
			diagExistsQuery.append(" a.term_set_id='"+diagSetId+"' and a.DIAG_CLASS_CODE=b.DIAG_CLASS_CODE and b.DIAG_CLASS_TYPE='PD'  and a.STATUS ='A' ");
			
			
			try{
				con = createConnection();
				if(con == null){
					errorInfo = new ErrorInfo();
					errorInfo.setErrorType(Errors.COMMON_SQL_EXCEPTION,locale);
					response.getErrorsList().add(errorInfo);
					response.setValidationResult(-1);
				}
				else{
					pstmt=con.prepareStatement(diagExistsQuery.toString());
					rs = pstmt.executeQuery();
					if(rs == null){
						errorInfo = new ErrorInfo();
						errorInfo.setErrorType(Errors.COMMON_SQL_EXCEPTION,locale);
						response.getErrorsList().add(errorInfo);
						response.setValidationResult(-1);
					}
					else{
						while(rs.next())
						{
							result=rs.getInt(1);
						}
						errorInfo = new ErrorInfo();
						errorInfo.setErrorType(Errors.COMMON_SUCCESS,locale);
						response.getErrorsList().add(errorInfo);
						if(result>=1){
							response.setValidationResult(0); //Validation failure, since an active diagnosis of same code exists already
						}else{
							response.setValidationResult(1); //Validation Succeeded. No such active diagnosis exists already
						}
						
					}
				}
			}
			catch(SQLException e){
				System.out.println("A database exception occurred while fetching problems and diagnosis details" +e);
				errorInfo = new ErrorInfo();
				errorInfo.setErrorType(Errors.COMMON_SQL_EXCEPTION,locale);
				response.getErrorsList().add(errorInfo);
				response.setValidationResult(-1);
			}
			catch(Exception e){
				errorInfo = new ErrorInfo();
				errorInfo.setErrorType(Errors.COMMON_NULL_EXCEPTION,locale);
				response.getErrorsList().add(errorInfo);
				response.setValidationResult(-1);
			}
			finally{
				int conCloseFailure = closeConnection(con,pstmt,rs);
			}
		}
		else{
			errorInfo = new ErrorInfo();
			errorInfo.setErrorType(Errors.COMMON_NULL_REQUEST,locale);
			response.getErrorsList().add(errorInfo);
			response.setValidationResult(-1);
		}
		return response;
		
		
	}
	
	/**
	 * Get the details of existing diagnosis for MODIFY usecase
	 * @param patientContext
	 * @param diagSetId
	 * @param diagCode
	 * @param occurSrlNo
	 * @return
	 */
	public DiagnosisDetailsResponse getDiagnosisDetails(PatContext patientContext, String diagSetId, String diagCode, String occurSrlNo){
		DiagnosisDetailsHO diagnosisDetails = new DiagnosisDetailsHO();
		DiagnosisDetailsResponse response = new DiagnosisDetailsResponse();
		String locale = "en";
		ErrorInfo errorInfo;
		
			if(patientContext != null && diagSetId != null && diagCode != null && occurSrlNo != null){
				String patientId = patientContext.getPatientId();
				locale = (patientContext.getLocale() == null || patientContext.getLocale().equals("")) ? "en": patientContext.getLocale();
				
				Connection con = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				
				StringBuffer diagnosisDetailsQuery = new StringBuffer("");
				diagnosisDetailsQuery.append("select a.accession_num,a.patient_id,a.term_set_id,a.term_code, a.TERM_CODE_SHORT_DESC, a.code_indicator,to_char(a.onset_date,'dd/mm/rrrr hh24:mi') onset_date, ");
				diagnosisDetailsQuery.append(" a.curr_severity, a.curr_onset_type,a.onset_nature,a.curr_facility_id,a.curr_encounter_id,a.curr_practitioner_id ,a.curr_practitioner_reln_id, ");
				diagnosisDetailsQuery.append(" a.curr_locn_type,a.curr_locn_code,a.curr_nature,a.curr_priority,a.curr_accuracy_code,a.curr_accuracy_ind, a.curr_remarks, a.curr_status, ");
				diagnosisDetailsQuery.append(" to_char(a.curr_status_date,'dd/mm/rrrr') status_date ,nvl(c.diff_group_id,'0') diff_group_id,b.high_risk_code, a.anatomical_site , a.applicable_side , ");
				diagnosisDetailsQuery.append(" a.diag_class_code,a.anatomical_site_code, d.PRACTITIONER_RELN_ID, d.remarks, d.LOCN_CODE, d.NOTIFICATION_CODE, d.cause_of_death_yn, d.ENC_STAGE, ");
				diagnosisDetailsQuery.append(" d.LOCN_TYPE,a.OCCUR_SRL_NO from PR_DIAGNOSIS a, MR_TERM_CODE b , PR_DIFFERENTIAL_DIAGNOSIS c, PR_DIAGNOSIS_ENC_DTL d where a.term_code=b.term_code   and ");
				diagnosisDetailsQuery.append(" a.term_set_id = b.term_set_id  and c.term_code(+) = a.term_code  and c.OCCUR_SRL_NO(+) = a.OCCUR_SRL_NO and c.term_set_id(+) = a.term_set_id and  ");
				diagnosisDetailsQuery.append(" c.patient_id(+) = a.patient_id and a.term_code = d.term_code and a.term_set_id = d.term_set_id and a.patient_id = d.patient_id and a.OCCUR_SRL_NO = d.OCCUR_SRL_NO and  ");
				diagnosisDetailsQuery.append(" a.patient_id = '"+patientId+"' and a.term_code='"+diagCode+"' and a.term_set_id='"+diagSetId+"' and a.OCCUR_SRL_NO='"+occurSrlNo+"'");
				
				
				try{
					con = createConnection();
					if(con == null){
						errorInfo = new ErrorInfo();
						errorInfo.setErrorType(Errors.COMMON_SQL_EXCEPTION,locale);
						response.getErrorsList().add(errorInfo);
					}
					else{
						pstmt=con.prepareStatement(diagnosisDetailsQuery.toString());
						rs = pstmt.executeQuery();
						if(rs == null){
							errorInfo = new ErrorInfo();
							errorInfo.setErrorType(Errors.COMMON_SQL_EXCEPTION,locale);
							response.getErrorsList().add(errorInfo);
						}
						else{
							String accessionNum;
							String relationshipId;
							String diagClassCode;
							//String associatedCodes;
							String practId;
							//String diagSetId;
							String remarks;
							String locnCode;
							String onsetType;
							String facilityId;
							String anatomicalSiteCode;
							String codeIndicator;
							String nature;
							//String evidencedBy;
							String priority;
							String diagDesc;
							String highRiskCode;
							//String diagCode; 
							String notifiableCode;
							String encounterId;
							String causeOfDeathYN;
							String status;
							String onsetDate;
							//String complaintIds;
							String accuracyInd;
							String accuracyCode;
							String severity;
							String encounterStage;
							String diffGrpId;
							String applicableSide;
							//String occurSrlNo;
							String statusDate;
							String anatomicalSite;
							String locnType;
							
							if(rs.next()){
								
								accessionNum = rs.getString("accession_num")==null?"":rs.getString("accession_num");
								diagnosisDetails.setAccessionNum(accessionNum);
								relationshipId = rs.getString("PRACTITIONER_RELN_ID")==null?"":rs.getString("PRACTITIONER_RELN_ID");
								diagnosisDetails.setRelationshipId(relationshipId);
								diagClassCode = rs.getString("diag_class_code")==null?"":rs.getString("diag_class_code");
								diagnosisDetails.setDiagClassCode(diagClassCode);
								practId = rs.getString("curr_practitioner_id")==null?"":rs.getString("curr_practitioner_id");
								diagnosisDetails.setPractId(practId);
								diagSetId = rs.getString("term_set_id")==null?"":rs.getString("term_set_id");
								diagnosisDetails.setDiagSetId(diagSetId);
								remarks = rs.getString("remarks")==null?"":rs.getString("remarks");
								diagnosisDetails.setRemarks(remarks);
								locnCode = rs.getString("LOCN_CODE")==null?"":rs.getString("LOCN_CODE");
								diagnosisDetails.setLocnCode(locnCode);
								onsetType = rs.getString("curr_onset_type")==null?"":rs.getString("curr_onset_type");
								diagnosisDetails.setOnsetType(onsetType);
								facilityId = rs.getString("curr_facility_id")==null?"":rs.getString("curr_facility_id");
								diagnosisDetails.setFacilityId(facilityId);
								anatomicalSiteCode = rs.getString("anatomical_site_code")==null?"":rs.getString("anatomical_site_code");
								diagnosisDetails.setAnatomicalSiteCode(anatomicalSiteCode);
								codeIndicator = rs.getString("code_indicator")==null?"":rs.getString("code_indicator");
								diagnosisDetails.setCodeIndicator(codeIndicator);
								nature = rs.getString("onset_nature")==null?"":rs.getString("onset_nature");
								diagnosisDetails.setNature(nature);
								priority = rs.getString("curr_priority")==null?"":rs.getString("curr_priority");
								diagnosisDetails.setPriority(priority);
								diagDesc = rs.getString("TERM_CODE_SHORT_DESC")==null?"":rs.getString("TERM_CODE_SHORT_DESC");
								diagnosisDetails.setDiagDesc(diagDesc);
								highRiskCode = rs.getString("high_risk_code")==null?"":rs.getString("high_risk_code");
								diagnosisDetails.setHighRiskCode(highRiskCode);
								diagCode = rs.getString("term_code")==null?"":rs.getString("term_code");
								diagnosisDetails.setDiagCode(diagCode);
								notifiableCode = rs.getString("NOTIFICATION_CODE")==null?"":rs.getString("NOTIFICATION_CODE");
								diagnosisDetails.setNotifiableCode(notifiableCode);
								encounterId = rs.getString("curr_encounter_id")==null?"":rs.getString("curr_encounter_id");
								diagnosisDetails.setEncounterId(encounterId);
								causeOfDeathYN = rs.getString("cause_of_death_yn")==null?"":rs.getString("cause_of_death_yn");
								diagnosisDetails.setCauseOfDeathYN(causeOfDeathYN);
								status = rs.getString("curr_status")==null?"":rs.getString("curr_status");
								diagnosisDetails.setStatus(status);
								onsetDate = rs.getString("onset_date")==null?"":rs.getString("onset_date");
								diagnosisDetails.setOnsetDate(onsetDate);
								//complaintIds = rs.getString("
								accuracyInd = rs.getString("curr_accuracy_ind")==null?"":rs.getString("curr_accuracy_ind");
								diagnosisDetails.setAccuracyInd(accuracyInd);
								accuracyCode = rs.getString("curr_accuracy_code")==null?"":rs.getString("curr_accuracy_code");
								diagnosisDetails.setAccuracyCode(accuracyCode);
								severity = rs.getString("curr_severity")==null?"":rs.getString("curr_severity");
								diagnosisDetails.setSeverity(severity);
								encounterStage = rs.getString("ENC_STAGE")==null?"":rs.getString("ENC_STAGE");
								diagnosisDetails.setEncounterStage(encounterStage);
								diffGrpId = rs.getString("diff_group_id")==null?"":rs.getString("diff_group_id");
								diagnosisDetails.setDiffGrpId(diffGrpId);
								applicableSide = rs.getString("applicable_side")==null?"":rs.getString("applicable_side");
								diagnosisDetails.setApplicableSide(applicableSide);
								occurSrlNo = rs.getString("OCCUR_SRL_NO")==null?"":rs.getString("OCCUR_SRL_NO");
								diagnosisDetails.setOccurSrlNo(occurSrlNo);
								statusDate = rs.getString("status_date")==null?"":rs.getString("status_date");
								diagnosisDetails.setStatusDate(statusDate);
								anatomicalSite = rs.getString("anatomical_site")==null?"":rs.getString("anatomical_site");
								diagnosisDetails.setAnatomicalSite(anatomicalSite);
								locnType = rs.getString("LOCN_TYPE")==null?"":rs.getString("LOCN_TYPE");
								diagnosisDetails.setLocnType(locnType);
								
								
								
								errorInfo = new ErrorInfo();
								errorInfo.setErrorType(Errors.COMMON_SUCCESS,locale);
								response.getErrorsList().add(errorInfo);
							}else{
								errorInfo = new ErrorInfo();
								errorInfo.setErrorType(Errors.COMMON_EMPTY_DATA,locale);
								response.getErrorsList().add(errorInfo);
							}
							
							response.setDiagnosisDetails(diagnosisDetails);
						}
					}
				}
				catch(SQLException e){
					System.out.println("A database exception occurred while fetching problems and diagnosis details" +e);
					errorInfo = new ErrorInfo();
					errorInfo.setErrorType(Errors.COMMON_SQL_EXCEPTION,locale);
					response.getErrorsList().add(errorInfo);
				}
				catch(Exception e){
					errorInfo = new ErrorInfo();
					errorInfo.setErrorType(Errors.COMMON_NULL_EXCEPTION,locale);
					response.getErrorsList().add(errorInfo);
				}
				finally{
					int conCloseFailure = closeConnection(con,pstmt,rs);
					
				}
			}
			else{
				errorInfo = new ErrorInfo();
				errorInfo.setErrorType(Errors.COMMON_NULL_REQUEST,locale);
				response.getErrorsList().add(errorInfo);
			}
		return response;
		
	}
	
	public DiagnosisValidationResponse checkComplaintExists(PatContext patientContext, String complCode){
		
		int result = 0;
		ErrorInfo errorInfo;
		String locale = "en";
		String encounterId;
		String facilityId;
		
		DiagnosisValidationResponse response = new DiagnosisValidationResponse();
		if(patientContext != null && complCode != null && !complCode.equals("")){
			encounterId = patientContext.getEncounterId();
			facilityId = patientContext.getFacilityId();
			locale = (patientContext.getLocale() == null || patientContext.getLocale().equals("")) ? "en": patientContext.getLocale();
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			StringBuffer complExistsQuery = new StringBuffer("");
			complExistsQuery.append("select 1 from ca_encntr_chief_complaint 	where complaint_id = '"+complCode+"' and facility_id = '"+facilityId+"' and encounter_id = '"+encounterId+"'");
			
			
			try{
				con = createConnection();
				if(con == null){
					errorInfo = new ErrorInfo();
					errorInfo.setErrorType(Errors.COMMON_SQL_EXCEPTION,locale);
					response.getErrorsList().add(errorInfo);
					response.setValidationResult(-1);
				}
				else{
					pstmt=con.prepareStatement(complExistsQuery.toString());
					rs = pstmt.executeQuery();
					if(rs == null){
						errorInfo = new ErrorInfo();
						errorInfo.setErrorType(Errors.COMMON_SQL_EXCEPTION,locale);
						response.getErrorsList().add(errorInfo);
						response.setValidationResult(-1);
					}
					else{
						while(rs.next())
						{
							result=rs.getInt(1);
						}
						errorInfo = new ErrorInfo();
						errorInfo.setErrorType(Errors.COMMON_SUCCESS,locale);
						response.getErrorsList().add(errorInfo);
						if(result==1){
							response.setValidationResult(0); //Validation failure, since an active diagnosis of same code exists already
						}else{
							response.setValidationResult(1); //Validation Succeeded. No such active diagnosis exists already
						}
						
					}
				}
			}
			catch(SQLException e){
				System.out.println("A database exception occurred while fetching problems and diagnosis details" +e);
				errorInfo = new ErrorInfo();
				errorInfo.setErrorType(Errors.COMMON_SQL_EXCEPTION,locale);
				response.getErrorsList().add(errorInfo);
				response.setValidationResult(-1);
			}
			catch(Exception e){
				errorInfo = new ErrorInfo();
				errorInfo.setErrorType(Errors.COMMON_NULL_EXCEPTION,locale);
				response.getErrorsList().add(errorInfo);
				response.setValidationResult(-1);
			}
			finally{
				int conCloseFailure = closeConnection(con,pstmt,rs);
			}
		}
		else{
			errorInfo = new ErrorInfo();
			errorInfo.setErrorType(Errors.COMMON_NULL_REQUEST,locale);
			response.getErrorsList().add(errorInfo);
			response.setValidationResult(-1);
		}
		return response;
	}
	
	public ComplaintSpecialtyListResponse getComplaintSpecialtyList(PatContext patientContext){
		
		ComplaintSpecialtyListResponse response = new ComplaintSpecialtyListResponse();
		ErrorInfo errorInfo;
		String locale = "en";
		if(patientContext != null){
			locale = (patientContext.getLocale() == null || patientContext.getLocale().equals("")) ? "en": patientContext.getLocale();
			ArrayList<ComplaintSpecialtyHO> specialtyList = new ArrayList<ComplaintSpecialtyHO>();
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			StringBuffer specialtyListQuery = new StringBuffer("");
			specialtyListQuery.append("SELECT A.SPECIALITY_CODE CODE, A.SHORT_DESC DESCRIPTION FROM AM_SPECIALITY A WHERE EFF_STATUS = 'E'  ORDER BY 2 ");
			
			try{
				con = createConnection();
				if(con == null){
					errorInfo = new ErrorInfo();
					errorInfo.setErrorType(Errors.COMMON_SQL_EXCEPTION,locale);
					response.getErrorsList().add(errorInfo);
				}
				else{
					pstmt=con.prepareStatement(specialtyListQuery.toString());
					rs = pstmt.executeQuery();
					if(rs == null){
						errorInfo = new ErrorInfo();
						errorInfo.setErrorType(Errors.COMMON_SQL_EXCEPTION,locale);
						response.getErrorsList().add(errorInfo);
					}
					else{
						String specialtyCode;
						String specialtyDesc;
						while(rs.next())
						{
							specialtyCode=rs.getString("CODE")==null?"":rs.getString("CODE");
							specialtyDesc=rs.getString("DESCRIPTION")==null?"":rs.getString("DESCRIPTION");
							
							ComplaintSpecialtyHO complaintSpecialtyHO = new ComplaintSpecialtyHO();
							complaintSpecialtyHO.setSpecialtyCode(specialtyCode);
							complaintSpecialtyHO.setSpecialtyDesc(specialtyDesc);
							specialtyList.add(complaintSpecialtyHO);
			
							
						}
						
						response.setSpecialtyList(specialtyList);
						if(specialtyList.size() <= 0){
							errorInfo = new ErrorInfo();
							errorInfo.setErrorType(Errors.COMMON_EMPTY_DATA,locale);
							response.getErrorsList().add(errorInfo);
						}
						else{
							errorInfo = new ErrorInfo();
							errorInfo.setErrorType(Errors.COMMON_SUCCESS,locale);
							response.getErrorsList().add(errorInfo);
						}
					}
				}
			}
			catch(SQLException e){
				System.out.println("A database exception occurred while fetching specialty details for Complaints" +e);
				errorInfo = new ErrorInfo();
				errorInfo.setErrorType(Errors.COMMON_SQL_EXCEPTION,locale);
				response.getErrorsList().add(errorInfo);
			}
			catch(Exception e){
				errorInfo = new ErrorInfo();
				errorInfo.setErrorType(Errors.COMMON_NULL_EXCEPTION,locale);
				response.getErrorsList().add(errorInfo);
			}
			finally{
				int conCloseFailure = closeConnection(con,pstmt,rs);
			}
		}
		else{
			errorInfo = new ErrorInfo();
			errorInfo.setErrorType(Errors.COMMON_NULL_REQUEST,locale);
			response.getErrorsList().add(errorInfo);
		}
		return response;
	}
	
	public ComplaintDetailsResponse getComplaintDetails(PatContext patientContext, String complaintCode){
		
		ComplaintDetailsResponse response = new ComplaintDetailsResponse();
		ErrorInfo errorInfo;
		String locale = "en";
		String encounterId;
		String facilityId;
		if(patientContext != null){
			encounterId =(patientContext.getSelectedEncounterId() == null || patientContext.getSelectedEncounterId().equals("")) ? patientContext.getEncounterId() : patientContext.getSelectedEncounterId();
			locale = (patientContext.getLocale() == null || patientContext.getLocale().equals("")) ? "en": patientContext.getLocale();
			facilityId = patientContext.getFacilityId();
			ComplaintDetailsHO complaintDetails = new ComplaintDetailsHO();
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			StringBuffer complDetailsQuery = new StringBuffer("");
			complDetailsQuery.append("select COMPLAINT_ID, COMPLAINT_DESC, to_char(ONSET_DATETIME,'dd/mm/rrrr hh24:mi') ONSET_DATE, REMARKS, ENCOUNTER_ID, FACILITY_ID  from ");
			complDetailsQuery.append(" ca_encntr_chief_complaint where encounter_id='"+encounterId+"' and facility_id='"+facilityId+"' and complaint_id='"+complaintCode+"' ");
			try{
				con = createConnection();
				if(con == null){
					errorInfo = new ErrorInfo();
					errorInfo.setErrorType(Errors.COMMON_SQL_EXCEPTION,locale);
					response.getErrorsList().add(errorInfo);
				}
				else{
					pstmt=con.prepareStatement(complDetailsQuery.toString());
					rs = pstmt.executeQuery();
					if(rs == null){
						errorInfo = new ErrorInfo();
						errorInfo.setErrorType(Errors.COMMON_SQL_EXCEPTION,locale);
						response.getErrorsList().add(errorInfo);
					}
					else{
						String complaintDesc;
						String onsetDate;
						String remarks;
						if(rs.next()){
							complaintCode=rs.getString("COMPLAINT_ID")==null?"":rs.getString("COMPLAINT_ID");
							complaintDesc=rs.getString("COMPLAINT_DESC")==null?"":rs.getString("COMPLAINT_DESC");
							onsetDate=rs.getString("ONSET_DATE")==null?"":rs.getString("ONSET_DATE");
							remarks=rs.getString("REMARKS")==null?"":rs.getString("REMARKS");
							facilityId=rs.getString("FACILITY_ID")==null?"":rs.getString("FACILITY_ID");
							encounterId=rs.getString("ENCOUNTER_ID")==null?"":rs.getString("ENCOUNTER_ID");
							complaintDetails.setComplaintCode(complaintCode);
							complaintDetails.setComplaintDesc(complaintDesc);
							complaintDetails.setOnsetDate(onsetDate);
							complaintDetails.setRemarks(remarks);
							complaintDetails.setFacilityId(facilityId);
							complaintDetails.setEncounterId(encounterId);
							response.setComplaintDetails(complaintDetails);
							errorInfo = new ErrorInfo();
							errorInfo.setErrorType(Errors.COMMON_SUCCESS,locale);
							response.getErrorsList().add(errorInfo);
						}
						else{
							errorInfo = new ErrorInfo();
							errorInfo.setErrorType(Errors.COMMON_EMPTY_DATA,locale);
							response.getErrorsList().add(errorInfo);
						}
					}
				}
			}
			catch(SQLException e){
				System.out.println("A database exception occurred while fetching specialty details for Complaints" +e);
				errorInfo = new ErrorInfo();
				errorInfo.setErrorType(Errors.COMMON_SQL_EXCEPTION,locale);
				response.getErrorsList().add(errorInfo);
			}
			catch(Exception e){
				errorInfo = new ErrorInfo();
				errorInfo.setErrorType(Errors.COMMON_NULL_EXCEPTION,locale);
				response.getErrorsList().add(errorInfo);
			}
			finally{
				int conCloseFailure = closeConnection(con,pstmt,rs);
			}
		}
		else{
			errorInfo = new ErrorInfo();
			errorInfo.setErrorType(Errors.COMMON_NULL_REQUEST,locale);
			response.getErrorsList().add(errorInfo);
		}
		return response;
	}
	
	

}


