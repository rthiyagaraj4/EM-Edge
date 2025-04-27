/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eCA.PatProblem;

import java.rmi.* ;
import javax.ejb.* ;
import java.sql.* ;

public interface PatProblemManagerRemote extends EJBObject {

public java.util.HashMap insertPatProblem(
								java.util.Properties p,
								String 	x_patient_id,
								String 	x_diag_code,
								String 	x_record_type,
								String 	x_cause_indicator,
								String 	x_diag_code_scheme,
								String 	x_diag_desc,
								String 	x_tab_list_no,
								String 	x_analysis_code,
								String 	x_primary_yn,
								String 	x_notifiable_yn,
								String 	x_sensitive_yn,
								String 	x_onset_date,
								String 	x_onset_practitioner_id,
								String 	x_onset_locn_code,
								String 	x_onset_locn_type,
								String 	x_onset_encounter_id,
								String 	x_problem_status,
								String 	client_ip_address,
								String 	x_facility_id,
								String  x_term_id,
								String x_diag_stage,
								String x_remarks,
								String x_diag_type,
								String x_significant_yn,
								String x_accession_num,
								String x_authorize,
								String x_recordedby_id,
								String x_reviwedby_id,
								String x_authorizepract_id,
								String x_associate_codes,
								String x_practitioner_id,
								String x_locn_code,
								String x_locn_type,
								String x_oper_num,
								String locale
								)	throws RemoteException;

public java.util.HashMap updatePatProblem(
							java.util.Properties p,
							String x_patient_id			,
							String x_srl_no				,
							String x_close_date			,
							String x_close_practitioner_id	,
							String x_close_locn_code		,
							String x_close_locn_type		,
							String   x_close_encounter_id	,
							String x_problem_status		,
							String client_ip_address		,
							String x_facility_id,
							//String x_diag_desc,
							//String x_Sec_Hdg_Code,
							//String x_logical_seq_no,
							String x_remarks,
							String x_diag_type,
							String 	x_primary_yn,
							String x_significant_yn,
							String x_diag_stage,
							String	errorRemarks,
							String x_accession_num,
							String x_authorize,
							String x_recordedby_id,
							String x_reviwedby_id,
							String x_authorizepract_id,
							String x_associate_codes,
							String x_diag_code,
							String x_practitioner_id,
							String x_locn_code,
							String x_locn_type,
							String x_include_enc,
							String locale

							) throws RemoteException;

public  java.util.HashMap FromCompleteVisit(
													java.util.Properties p,
													String patient_id,
													String facilityid,
													String encounter_id,
													String modified_ws,
													String locale
													)throws RemoteException;
}

