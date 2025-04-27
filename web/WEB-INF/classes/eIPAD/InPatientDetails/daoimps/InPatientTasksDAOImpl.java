/**
 * 
 */
package eIPAD.InPatientDetails.daoimps;

import java.sql.*;
import java.text.*;
import java.util.ArrayList;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import webbeans.eCommon.ConnectionManager;
import eIPAD.InPatientDetails.request.*;
import eIPAD.InPatientDetails.dao.*;
import eIPAD.InPatientDetails.ho.*;
import eIPAD.InPatientDetails.response.*;
import eIPAD.chartsummary.common.daoimpl.*;
import eIPAD.chartsummary.common.healthobject.*;
import eIPAD.chartsummary.common.response.*;
import eOR.FutureOrder;
import eOR.OrderEntryBillingQueryBean;
/**
 * @author saraswathir
 *
 */
public class InPatientTasksDAOImpl extends GenericDAOImpl implements InPatientTasksDAO {
	
	private PatientTaskItem getPatientChargeConsultationTask(InPatientTaskRequest taskRequest,  HttpServletRequest request){
		FutureOrder FutureBeanObj = (FutureOrder) com.ehis.persist.PersistenceHelper.getBeanObject("Or_FutureOrder","eOR.FutureOrder",request);
		OrderEntryBillingQueryBean orderEntryBillBean=(eOR.OrderEntryBillingQueryBean) FutureBeanObj.getOrderEntryBillBean();
		PatientTaskItem patientChargeConsultationTask = new PatientTaskItem();
		ErrorInfo oErrInfo = new ErrorInfo();
		//taskRequest.getPatientContext().getEncounterId();//use this to get param values for queries
		Connection con = null;
		PreparedStatement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String locale = "";
		String strPractId = "";
		String facilityId = "";
		String encounterId = "";
		String control="";
		String sqlStr = "";
		String max_cons_per_pract = "";
		String max_cons_per_splty = "";
		String cons_back_date = "";
		String amd_cons_list = "";
		String min_cons_duration = "";
		String max_regular_cons = "";
		String max_referral_cons = "";
		String cons_date = "";
		String cons_time = "";
		String control_value = "";
		String control_val_chrg = "";
		String catalogCode = "";
		String patientId = "";
		int totalRecCount = 0;
		HashMap bill_dtls = null;
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		cons_date = df.format(new java.util.Date());
		DateFormat df1 = new SimpleDateFormat("HH:mm");
		cons_time = df1.format(new java.util.Date());
		ArrayList BillChargeInfo = null;
		if(taskRequest != null) {
			PatContext oPatContext = taskRequest.getPatientContext();
			if(oPatContext != null) {
				strPractId = checkForNull(oPatContext.getClinicianId());
				facilityId = checkForNull(oPatContext.getFacilityId());
				encounterId = checkForNull(oPatContext.getEncounterId());
				patientId = checkForNull(oPatContext.getPatientId());
				locale = checkForNull(oPatContext.getLocale());
				control="select MAX_CONS_PER_PRACT MAX_CONS_PER_PRACT,MAX_CONS_PER_SPLTY MAX_CONS_PER_SPLTY,CONS_BACK_DATE CONS_BACK_DATE,AMD_CONS_LIST AMD_CONS_LIST,MIN_CONS_DURATION MIN_CONS_DURATION, MAX_REGULAR_CONS MAX_REGULAR_CONS, MAX_REFERRAL_CONS MAX_REFERRAL_CONS from ca_cons_param";
				
				sqlStr = 		"Select"
								+ " case when (select count(*) from ca_cons_list_hdr ia, ca_cons_list_dtl ib WHERE ia.practitioner_id LIKE ? AND ia.cons_date = TO_DATE (?, 'DD/MM/YYYY') AND ib.cons_ref_id = ia.cons_ref_id AND ib.facility_id = b.FACILITY_ID AND ib.encounter_id = b.ENCOUNTER_ID and ib.cons_status = 'C' AND NOT EXISTS (SELECT 1 FROM PR_REFERRAL_REGISTER WHERE PATIENT_ID = ib.PATIENT_ID AND FROM_ENCOUNTER_ID =ib.ENCOUNTER_ID AND BEDSIDE_REFERRAL_YN ='Y' AND TO_PRACT_ID = ? AND ROWNUM=1 )) >= ? THEN 'REGLR' ELSE case when (select count(*) from ca_cons_list_hdr ia, ca_cons_list_dtl ib WHERE ia.practitioner_id LIKE ? AND ia.cons_date = TO_DATE (?, 'DD/MM/YYYY') AND ib.cons_ref_id = ia.cons_ref_id AND ib.facility_id = b.FACILITY_ID AND ib.encounter_id = b.ENCOUNTER_ID and ib.cons_status = 'C' AND EXISTS (SELECT 1 FROM PR_REFERRAL_REGISTER WHERE PATIENT_ID = ib.PATIENT_ID AND FROM_ENCOUNTER_ID =ib.ENCOUNTER_ID AND BEDSIDE_REFERRAL_YN ='Y' AND TO_PRACT_ID = ? AND ROWNUM=1 )) >= ? THEN 'REFRL' ELSE '' END END control_val_chrg_complete, "
								+ " case when (select count(*) from ca_cons_list_hdr ia, ca_cons_list_dtl ib WHERE ia.practitioner_id LIKE ? AND ia.cons_date = TO_DATE (?, 'DD/MM/YYYY') AND ib.cons_ref_id = ia.cons_ref_id AND ib.facility_id = b.FACILITY_ID AND ib.encounter_id = b.ENCOUNTER_ID and ib.cons_status = 'C') >= ? THEN 'PRACT' ELSE CASE WHEN (select count(*) from ca_cons_list_hdr ia, ca_cons_list_dtl ib WHERE SPECIALITY_CODE LIKE b.specialty_code AND ia.cons_date = TO_DATE (?, 'DD/MM/YYYY') AND ib.cons_ref_id = ia.cons_ref_id AND ib.facility_id = b.FACILITY_ID AND ib.encounter_id = b.ENCOUNTER_ID and ib.cons_status = 'C') >= ? THEN 'SPLTY' ELSE '' END END control_val_complete, "
								+ " ca_get_cons_list_control (b.attend_practitioner_id,"
								+ " b.specialty_code,"
								+ " ?,"
								+ " b.facility_id,"
								+ " b.encounter_id,"
								+ " ?,"
								//+ " ? + (select count(*) from ca_cons_list_hdr ia, ca_cons_list_dtl ib WHERE ia.practitioner_id LIKE ? AND ia.cons_date = TO_DATE (?, 'DD/MM/YYYY') AND ib.cons_ref_id = ia.cons_ref_id AND ib.facility_id = ? AND ib.encounter_id = ? and ib.cons_status = 'P'),"
								+ " ?,"
								//+ " ? + (select count(*) from ca_cons_list_hdr ia, ca_cons_list_dtl ib WHERE ia.practitioner_id LIKE ? AND ia.cons_date = TO_DATE (?, 'DD/MM/YYYY') AND ib.cons_ref_id = ia.cons_ref_id AND ib.facility_id = ? AND ib.encounter_id = ? and ib.cons_status = 'P'),"
								+ " ?,"
								+ " ?"
								+ " ) control_value,"
								//+ " CA_GET_CONS_CHRG_CONTROL(?,b.FACILITY_ID,b.ENCOUNTER_ID,? + (select count(*) from ca_cons_list_hdr ia, ca_cons_list_dtl ib WHERE ia.practitioner_id LIKE ? AND ia.cons_date = TO_DATE (?, 'DD/MM/YYYY') AND ib.cons_ref_id = ia.cons_ref_id AND ib.facility_id = ? AND ib.encounter_id = ? and ib.cons_status = 'P'),? + (select count(*) from ca_cons_list_hdr ia, ca_cons_list_dtl ib WHERE ia.practitioner_id LIKE ? AND ia.cons_date = TO_DATE (?, 'DD/MM/YYYY') AND ib.cons_ref_id = ia.cons_ref_id AND ib.facility_id = ? AND ib.encounter_id = ? and ib.cons_status = 'P')) control_val_chrg, "
								+ " CA_GET_CONS_CHRG_CONTROL(?,b.FACILITY_ID,b.ENCOUNTER_ID,?,?) control_val_chrg, "
								+ " b.encounter_id"
								+ " FROM ip_open_encounter b"
								+ " WHERE b.facility_id = ?"
                                + " AND b.encounter_id = ?"
                                + " AND NOT EXISTS ("
								+ " SELECT 1"
								+ " FROM ca_cons_list_hdr ia, ca_cons_list_dtl ib"
								+ " WHERE ia.practitioner_id LIKE ?"
								+ " AND ia.cons_date = TO_DATE (?, 'DD/MM/YYYY')"
								+ " AND ib.cons_ref_id = ia.cons_ref_id"
								+ " AND ib.facility_id = ?"
								+ " AND ib.encounter_id = ?"
								+ " AND TO_DATE (TO_CHAR (cons_date, 'DD/MM/YYYY') || ' '"
								+ " || cons_time,"
								+ " 'DD/MM/YYYY HH24:MI'"
                         		+ " ) BETWEEN   TO_DATE (? || ' ' || ?,"
                                + " 'DD/MM/YYYY HH24:MI'"
                                + " )"
                                + " - (? / 1440)"
                                + " AND   TO_DATE (? || ' ' || ?,"
                                + " 'DD/MM/YYYY HH24:MI'"
                                + " )"
                                + " + (? / 1440) and ib.cons_status = 'C' )"; 
				try																					  
				{
					con =  createConnection();
					pstmt = con.prepareStatement(control);
					rs = pstmt.executeQuery();
					while(rs.next())
					{
						max_cons_per_pract = rs.getString("MAX_CONS_PER_PRACT");
						max_cons_per_splty = rs.getString("MAX_CONS_PER_SPLTY");
						cons_back_date = rs.getString("CONS_BACK_DATE");
						amd_cons_list = rs.getString("AMD_CONS_LIST");
						min_cons_duration = rs.getString("MIN_CONS_DURATION");
						max_regular_cons = rs.getString("MAX_REGULAR_CONS");
						max_referral_cons = rs.getString("MAX_REFERRAL_CONS");
					}
					if(rs!=null) 
						rs.close();
					if(pstmt!=null)
						pstmt.close();
					int queryParamCntr = 0;
					stmt = con.prepareStatement(sqlStr.toString(),ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
					stmt.setString(++queryParamCntr,strPractId);
					stmt.setString(++queryParamCntr,cons_date);
					stmt.setString(++queryParamCntr,strPractId);
					stmt.setString(++queryParamCntr,max_regular_cons);
					stmt.setString(++queryParamCntr,strPractId);
					stmt.setString(++queryParamCntr,cons_date);
					stmt.setString(++queryParamCntr,strPractId);
					stmt.setString(++queryParamCntr,max_referral_cons);
					stmt.setString(++queryParamCntr,strPractId);
					stmt.setString(++queryParamCntr,cons_date);
					stmt.setString(++queryParamCntr,max_cons_per_pract);
					stmt.setString(++queryParamCntr,cons_date);
					stmt.setString(++queryParamCntr,max_cons_per_splty);
					stmt.setString(++queryParamCntr,cons_date);
					stmt.setString(++queryParamCntr,cons_time);
					stmt.setString(++queryParamCntr,max_cons_per_pract);
					/*stmt.setString(++queryParamCntr,strPractId);
					stmt.setString(++queryParamCntr,cons_date);
					stmt.setString(++queryParamCntr,facilityId);
					stmt.setString(++queryParamCntr,encounterId);*/
					stmt.setString(++queryParamCntr,max_cons_per_splty);
					/*stmt.setString(++queryParamCntr,strPractId);
					stmt.setString(++queryParamCntr,cons_date);
					stmt.setString(++queryParamCntr,facilityId);
					stmt.setString(++queryParamCntr,encounterId);*/
					stmt.setString(++queryParamCntr,min_cons_duration);
					stmt.setString(++queryParamCntr,strPractId);
					stmt.setString(++queryParamCntr,max_regular_cons);
					/*stmt.setString(++queryParamCntr,strPractId);
					stmt.setString(++queryParamCntr,cons_date);
					stmt.setString(++queryParamCntr,facilityId);
					stmt.setString(++queryParamCntr,encounterId);*/
					stmt.setString(++queryParamCntr,max_referral_cons);
					/*stmt.setString(++queryParamCntr,strPractId);
					stmt.setString(++queryParamCntr,cons_date);
					stmt.setString(++queryParamCntr,facilityId);
					stmt.setString(++queryParamCntr,encounterId);*/
					stmt.setString(++queryParamCntr,facilityId);
					stmt.setString(++queryParamCntr,encounterId);
					stmt.setString(++queryParamCntr,strPractId);
					stmt.setString(++queryParamCntr,cons_date);
					stmt.setString(++queryParamCntr,facilityId);
					stmt.setString(++queryParamCntr,encounterId);
					stmt.setString(++queryParamCntr,cons_date);
					stmt.setString(++queryParamCntr,cons_time);
					stmt.setString(++queryParamCntr,min_cons_duration);
					stmt.setString(++queryParamCntr,cons_date);
					stmt.setString(++queryParamCntr,cons_time);
					stmt.setString(++queryParamCntr,min_cons_duration); 
					rs = stmt.executeQuery();
					if(rs.next()) {
						control_value = checkForNull(rs.getString("control_val_complete"));
						control_val_chrg = checkForNull(rs.getString("control_val_chrg_complete"));
						totalRecCount	=	rs.getRow();
					}
				}catch(Exception e) {
					e.printStackTrace();
					System.out.println("Error in Control query-->" + e);
				}finally {
					try {
						if(con != null) ConnectionManager.returnConnection(con);
						if(rs!=null) 
							rs.close();
						if(stmt!=null)
							stmt.close();
					}catch(Exception e) {
						e.printStackTrace();
						System.out.println("Error in closing connection: " + e);
					}
				}
			}
		}
		String taskDesc = "";
		if(totalRecCount == 1) {
			
			HashMap setBills_dtls			= null;
			String catalogQuery = "select CA_GET_CONS_CATALOG(?,'') catalog from dual";
			try{
				con =  createConnection();
				pstmt = con.prepareStatement(catalogQuery);
				pstmt.setString(1, strPractId);
				rs = pstmt.executeQuery();
				
				
				
				if(rs.next()){
					catalogCode = rs.getString("catalog");
				}
				if(catalogCode != null && !catalogCode.equals("")){
					bill_dtls = (HashMap)orderEntryBillBean.getOrderBillDtls(patientId+encounterId+catalogCode);
					if(bill_dtls!=null){
						String service_panel_code  = checkForNull((String)bill_dtls.get("serv_panel_code"));
						String service_panel_ind     = checkForNull((String)bill_dtls.get("serv_panel_ind"));
						String error_text = (String)bill_dtls.get("error_text");
						if(!error_text.equals("") || (service_panel_code.equals("")&&service_panel_ind.equals(""))){
							patientChargeConsultationTask.setTaskPending(false);
							taskDesc = "Billing error:: " + error_text;
						}else{
							patientChargeConsultationTask.setTaskPending(true);
							taskDesc = "Patient charging available";
						}
					}else{
						
						
						String quantity = "1";
						String order_id = "";
						String order_line_num = "";
						String patient_class= "IP";
						BillChargeInfo = orderEntryBillBean.getBillChargeDetails(quantity,catalogCode,cons_date, locale, order_id, order_line_num,patientId,encounterId,patient_class,strPractId) ;
						String[] billing_details = null;
						
						
						if(BillChargeInfo!=null)
						{
							for( int k=0 ; k< BillChargeInfo.size() ; k++ ) 
							{
								billing_details 	= (String[])BillChargeInfo.get(k);
								setBills_dtls		= new HashMap();
								setBills_dtls.put("charged_yn"       , billing_details[1]);
								setBills_dtls.put("total_payable"    , billing_details[2]);
								setBills_dtls.put("patient_payable"  , billing_details[3]);
								setBills_dtls.put("quantity"         , "1");
								setBills_dtls.put("incl_excl_action" , billing_details[4]);
								setBills_dtls.put("incl_excl_action_orginal" , billing_details[16]);
								setBills_dtls.put("preapp_yn"        , billing_details[5]);
								setBills_dtls.put("patient_paid_amt" , billing_details[6]);
								setBills_dtls.put("bl_panel_str"     , billing_details[0]);
								setBills_dtls.put("serv_panel_ind"   , billing_details[10]);
								setBills_dtls.put("serv_panel_code"  , billing_details[11]);
								setBills_dtls.put("p_episode_type"	 , billing_details[13]);
								setBills_dtls.put("p_episode_id"	 , billing_details[14]);
								setBills_dtls.put("p_visit_id"		 , billing_details[15]);
								setBills_dtls.put("Future_order_yn"		 , billing_details[17]);
								setBills_dtls.put("error_text"		 , billing_details[9]);
								orderEntryBillBean.setOrderBillDtls(patientId+encounterId+catalogCode, setBills_dtls);
							}
							bill_dtls = (HashMap)orderEntryBillBean.getOrderBillDtls(patientId+encounterId+catalogCode);
							if(bill_dtls!=null){
								String service_panel_code  = checkForNull((String)bill_dtls.get("serv_panel_code"));
								String service_panel_ind     = checkForNull((String)bill_dtls.get("serv_panel_ind"));
								String error_text = (String)bill_dtls.get("error_text");
								if(!error_text.equals("") || (service_panel_code.equals("")&&service_panel_ind.equals(""))){
									patientChargeConsultationTask.setTaskPending(false);
									taskDesc = "Billing error:: " + error_text;
								}else{
									patientChargeConsultationTask.setTaskPending(true);
									taskDesc = "Patient charging available but unable to getting billing dets";
								}
							}
							
						}else{
							patientChargeConsultationTask.setTaskPending(true);
							taskDesc = "Patient charging available but unable to getting billing dets";
						}
					}
				}else{
					patientChargeConsultationTask.setTaskPending(true);
					taskDesc = "Patient charging available";
				}
			}catch(Exception e) {
				patientChargeConsultationTask.setTaskPending(false);
				taskDesc = "Exception occurred while getting the catalog code";
			}finally {
				try {
					if(con != null) ConnectionManager.returnConnection(con);
					if(rs!=null) 
						rs.close();
					if(stmt!=null)
						stmt.close();
				}catch(Exception e) {
					e.printStackTrace();
					System.out.println("Error in closing connection: " + e);
				}
			}
			
			
		}
		else{
			patientChargeConsultationTask.setTaskPending(false);
			taskDesc = "No Record to update since time not elapsed";
		}
		if(!control_value.equals("") || !control_val_chrg.equals(""))
		{
			patientChargeConsultationTask.setTaskPending(false);
		}
		if(control_value.equals("PRACT"))
		{
			/*String practQuery = "select count(*) from ca_cons_list_hdr ia, ca_cons_list_dtl ib WHERE ia.practitioner_id LIKE ? AND ia.cons_date = TO_DATE (?, 'DD/MM/YYYY') AND ib.cons_ref_id = ia.cons_ref_id AND ib.facility_id = ? AND ib.encounter_id = ? and ib.cons_status = 'C'";
			con = createConnection();
			pstmt = con.prepareStatement(practQuery);xxx
			int queryParamCntr = 0;
			pstmt = con.prepareStatement(sqlStr.toString(),ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			stmt.setString(++queryParamCntr,strPractId);
			pstmt.setString(++queryParamCntr,cons_date);
			stmt.setString(++queryParamCntr,facilityId);
			stmt.setString(++queryParamCntr,encounterId);
			rs = pstmt.executeQuery();*/
			oErrInfo.setErrorMessage("Exceed Max no of Cons by same Practitioner");
			taskDesc = "Exceed Max no of Cons by same Practitioner";
		}
		else if(control_value.equals("SPLTY"))
		{
			oErrInfo.setErrorMessage("Exceed Max no of Cons by same Speciality");
			taskDesc = "Exceed Max no of Cons by same Speciality";
		}
		if(control_val_chrg.equals("REGLR")){
			oErrInfo.setErrorMessage("Exceed Max no of Regular Consultations by Practitioner");
			taskDesc = "Exceed Max no of Regular Consultations by Practitioner";
		}
		if(control_val_chrg.equals("REFRL")){
			oErrInfo.setErrorMessage("Exceed Max no of Referral Consultations by Practitioner");
			taskDesc = "Exceed Max no of Referral Consultations by Practitioner";
		}
		patientChargeConsultationTask.setTaskDescription(taskDesc);
		return patientChargeConsultationTask;
	}
	
	private PatientTaskItem getPatientInsuranceAuthorizationPendingTask(InPatientTaskRequest taskRequest){
		PatientTaskItem patInsuranceTask = new PatientTaskItem();
		patInsuranceTask.setTaskPending(true);
		patInsuranceTask.setTaskDetails("DUMMY");
		patInsuranceTask.setTaskDescription("DAO not yet implemented");
		return patInsuranceTask;
	}
	
	public InPatientTaskResponse getInPatientPendingTasks(InPatientTaskRequest taskRequest, HttpServletRequest request){
		InPatientTaskResponse taskResponse = new InPatientTaskResponse();
		PatientTaskItem chargeConsTask = getPatientChargeConsultationTask(taskRequest, request);
		PatientTaskItem insuranceAuthTask = getPatientInsuranceAuthorizationPendingTask(taskRequest);
		taskResponse.setChargeConsultationTask(chargeConsTask);
		taskResponse.setInsuranceAuthorizationFormTask(insuranceAuthTask);
		return taskResponse;
	}
	
	
	
	public TransactionResponse getPerformChargePatient(InPatientTaskRequest taskRequest, HttpServletRequest request){
		TransactionResponse transactionResponse = new TransactionResponse();
		FutureOrder FutureBeanObj = (FutureOrder) com.ehis.persist.PersistenceHelper.getBeanObject("Or_FutureOrder","eOR.FutureOrder",request);
		OrderEntryBillingQueryBean orderEntryBillBean=(eOR.OrderEntryBillingQueryBean) FutureBeanObj.getOrderEntryBillBean();
		ErrorInfo errorInfo = new ErrorInfo();
		Connection con = null;
		Connection con1 = null;
		Connection con2 = null;
		Connection con3 = null;
		Connection con4 = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		PreparedStatement pstmt3 = null;
		PreparedStatement pstmt4 = null;
		PreparedStatement pstmt5 = null;
		PreparedStatement pstmt6 = null;
		CallableStatement cstmt = null;
		CallableStatement cstmt_bl_ext_charge_stage = null;
		CallableStatement cstmt_billing_ext = null;
		Statement stmt = null;
		ResultSet rs = null;
		ResultSet rs1 = null;
		ResultSet rs2 = null;
		ResultSet rs4 = null;
		ResultSet rs6 = null;
		HashMap bill_dtls = null;
		String[] billing_details = null;
		HashMap setBills_dtls = null;
		ArrayList BillChargeInfo = null;
		String locale = "";
		String strPractId = "";
		String facilityId = "";
		String encounterId = "";
		String cons_date = "";
		String cons_time = "";
		String cons_sec = "";
		String cons_list_desc = "";
		String consult_date_time = "";
		String insertHdrSql = "";
		String loginuserid = "";
		String client_ip_address = "";
		String specialtyCode = "";
		String patientId = "";
		String catalog = "";
		String patientClass = "";
		String cons_ref_id = "";
		String episode_visit_num = "";
		String sourceCode = "";
		String sourceType = "";
		String p_out_order_id = "";
		String p_out_order_line_num = "";
		String p_facility_id = "";
		String p_err_message = "";
		String catalog_desc = "";
		String p_total_amt = "";
		String incl_excl_action = "";
		String incl_excl_action_orginal = "";
		String Future_order_yn = "";
		String incl_excl_action_reason = "";
		String bl_panel_str = "";
		String error_message = "";
		String charge_type_code = "";
		String err_code = "";
		String sys_message_id = "";
		String err_message = "";
		String order_id = "";
		String order_line_num = "";
		String specSql = "";
		String patient_payable = "";
		String approval = "";
		int nInsStat=0;
		int[] nInsStat1 = null;
		int[] nInsStat2 = null;
		int errcount = 0;
		int errorcount = 0;
		Boolean insFlag = false;
		Boolean updFlag = false;
		Boolean cmtFlag = false;
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		cons_date = df.format(new java.util.Date());
		DateFormat df1 = new SimpleDateFormat("HH:mm");
		cons_time = df1.format(new java.util.Date());
		DateFormat df2 = new SimpleDateFormat("ddMMyyHHmmss");
		cons_sec = df2.format(new java.util.Date());
		consult_date_time = cons_date + " " + cons_time;
		cons_list_desc = cons_sec + "MOB";
		if(taskRequest != null) {
			PatContext oPatContext = taskRequest.getPatientContext();
			if(oPatContext != null) {
				strPractId = checkForNull(oPatContext.getClinicianId());
				facilityId = checkForNull(oPatContext.getFacilityId());
				encounterId = checkForNull(oPatContext.getEncounterId());
				locale = checkForNull(oPatContext.getLocale());
				loginuserid = checkForNull(oPatContext.getLoggedInUser());
				patientId = checkForNull(oPatContext.getPatientId());
				client_ip_address = checkForNull(taskRequest.getClientIpAddress());
				try {
					con4 = createConnection();
					specSql = "select specialty_code from pr_encounter where encounter_id='"+encounterId+"'";
					stmt = con4.prepareStatement(specSql);
					rs4 = stmt.executeQuery(specSql);
					while(rs4.next()) {
						specialtyCode = checkForNull(rs4.getString("specialty_code"));
					}
				}catch(Exception e) {
					e.printStackTrace();
					System.out.println("Error in getting Specialty Code: " + e);
				}finally {
					try {
						if(rs4 != null) rs4.close();
						if(stmt != null) stmt.close();
						if(con4 != null) ConnectionManager.returnConnection(con4);
					}catch(Exception e) {
						e.printStackTrace();
						System.out.println("Error in closing connection: " + e);
					}
				}
				try {
					con2 =  createConnection();
					insertHdrSql = "INSERT INTO ca_cons_list_hdr"
									+ " (cons_ref_id, cons_list_desc, practitioner_id, cons_date,"
									+ " cons_time, facility_id, create_type, created_user_id,"
									+ " created_date, cons_status, added_by_id, added_date,"
									+ " added_at_ws_no, added_facility_id, modified_by_id,"
									+ " modified_date, modified_at_ws_no, modified_facility_id,"
									+ " specialty_code"
									+ " )"
									+ " VALUES (ca_cons_list_hdr_seq.NEXTVAL, ?, ?, TO_DATE (?, 'DD/MM/YYYY'),"
									+ " ?, ?, ?, ?,"
									+ " SYSDATE, ?, ?, SYSDATE,"
									+ " ?, ?, ?,"
									+ " SYSDATE, ?, ?,"
									+ " ?"
									+ " )";
					pstmt3 = con2.prepareStatement(insertHdrSql);
					pstmt3.setString(1,cons_list_desc);
					pstmt3.setString(2,strPractId);
					pstmt3.setString(3,cons_date);
					pstmt3.setString(4,cons_time);
					pstmt3.setString(5,facilityId);
					pstmt3.setString(6,"P");
					pstmt3.setString(7,loginuserid);
					pstmt3.setString(8,"P");
					pstmt3.setString(9,loginuserid);
					pstmt3.setString(10,client_ip_address);
					pstmt3.setString(11,facilityId);
					pstmt3.setString(12,loginuserid);
					pstmt3.setString(13,client_ip_address);
					pstmt3.setString(14,facilityId);
					pstmt3.setString(15,specialtyCode);
					nInsStat = pstmt3.executeUpdate();
					if(pstmt3 != null) pstmt3.close();
					if(nInsStat>0)
					{
						String insertDtlSql = "INSERT INTO ca_cons_list_dtl"
												+ " (cons_ref_id, facility_id, encounter_id, patient_id,"
												+ " speciality_code, cons_status, order_id, line_no, completed_date,"
												+ " completed_user_id, added_by_id, added_date, added_at_ws_no,"
												+ " added_facility_id, modified_by_id, modified_date,"
												+ " modified_at_ws_no, modified_facility_id"
												+ " )"
												+ " VALUES (ca_cons_list_hdr_seq.CURRVAL, ?, ?, ?,"
												+ " ?, ?, ?, ?, ?,"
												+ " ?, ?, SYSDATE, ?,"
												+ " ?, ?, SYSDATE,"
												+ " ?, ?"
												+ " )";
						pstmt4=con2.prepareStatement(insertDtlSql);
						pstmt4.setString(1,facilityId);
						pstmt4.setString(2,encounterId);
						pstmt4.setString(3,patientId);
						pstmt4.setString(4,specialtyCode);
						pstmt4.setString(5,"P");
						pstmt4.setString(6,"");
						pstmt4.setString(7,"");
						pstmt4.setString(8,"");
						pstmt4.setString(9,"");
						pstmt4.setString(10,loginuserid);
						pstmt4.setString(11,client_ip_address);
						pstmt4.setString(12,facilityId);
						pstmt4.setString(13,loginuserid);
						pstmt4.setString(14,client_ip_address);
						pstmt4.setString(15,facilityId);
						pstmt4.addBatch();
						nInsStat1 = pstmt4.executeBatch();
						if(nInsStat1[0]<0  && nInsStat1[0] != -2)
						{
							insFlag = false;
						}
						else
						{ 
							insFlag = true;
						}
						
					}
					if(insFlag)
					{ 		
						con2.commit();
						cmtFlag = true;
						System.out.println("Inserted");
					}
					else
					{
						con2.rollback();
						cmtFlag = false;
						System.out.println("Not Inserted");
					}
					if(pstmt4 != null) pstmt4.close();
				}catch(Exception e) {
					e.printStackTrace();
					System.out.println("Error in Insertion Query: " + e);
				}finally {
					if(con2 != null) ConnectionManager.returnConnection(con2);
				}
				try
				{
					con = createConnection();
					String catalogQuery =" select CA_GET_CONS_CATALOG(?,?) catalog from dual";
					pstmt = con.prepareStatement(catalogQuery);
					pstmt.setString(1,strPractId);
					pstmt.setString(2,specialtyCode);
					rs = pstmt.executeQuery();
					 while (rs.next())
					 {
						catalog = checkForNull(rs.getString("catalog"));
					 }
					 if(rs != null) rs.close();
					 if(pstmt != null) pstmt.close();
					 if(!catalog.equals(""))
					 {
						 String  sql = "select CONS_REF_ID from CA_CONS_LIST_HDR where FACILITY_ID=? and PRACTITIONER_ID = ? and CONS_DATE= to_date(?,'dd/mm/yyyy') and CONS_TIME= ?";
						 pstmt1 = con.prepareStatement(sql);
						 pstmt1.setString(1,facilityId);
						 pstmt1.setString(2,strPractId);
						 pstmt1.setString(3,cons_date);
						 pstmt1.setString(4,cons_time);
						 rs1 = pstmt1.executeQuery();
						 while (rs1.next())
						 {
							 cons_ref_id= checkForNull(rs1.getString("CONS_REF_ID"));
						 }
					 }
					}catch(Exception e )
					{
						e.printStackTrace();
						System.out.println("Exception caught in CA_GET_CONS_CATALOG:" + e);
					}finally {
						try {
							if(rs1 != null) rs1.close();
							if(pstmt1 != null) pstmt1.close();
							if(con != null) ConnectionManager.returnConnection(con);
						}catch(Exception e) {
							e.printStackTrace();
							System.out.println("Error in closing connection: " + e);
						}
					}
				try {
					con1 = createConnection();
					String visitQuery = "SELECT a.patient_class p_patient_class,"
										+ " a.pat_curr_locn_type source_type,"
										+ " a.pat_curr_locn_code source_code,"
										+ " a.op_episode_visit_num episode_visit_num,"
										+ " d.order_id order_id,d.line_no order_line_num"
										+ " FROM ca_cons_list_dtl d, ip_open_encounter e, pr_encounter a"
										+ " WHERE d.cons_ref_id = ?"
										+ " AND d.patient_id = e.patient_id"
										+ " AND d.encounter_id = e.encounter_id"
										+ " AND d.facility_id = e.facility_id"
										+ " AND a.facility_id = d.facility_id"
										+ " AND a.patient_id = d.patient_id"
										+ " AND a.encounter_id = d.encounter_id"
										+ " AND 'Y' ="
										+ " or_get_access_rule (e.facility_id,"
										+ " e.encounter_id,"
										+ " 'CN',"
										+ " e.patient_class,"
										+ " TO_CHAR (e.admission_date_time,"
										+ " 'DD/MM/YYYY HH24:MI'"
										+ " ),"
										+ " (SELECT TO_CHAR (discharge_date_time,"
                                        + " 'DD/MM/YYYY HH24:MI'"
                                        + " )"
                                        + " FROM pr_encounter"
                                        + " WHERE facility_id = e.facility_id"
                                        + " AND encounter_id = e.encounter_id),"
                                        + " (SELECT TO_CHAR (dis_adv_date_time,"
                                        + " 'DD/MM/YYYY HH24:MI'"
                                        + " )"
                                        + " FROM ip_discharge_advice"
                                        + " WHERE facility_id = e.facility_id"
                                        + " AND encounter_id = e.encounter_id"
                                        + " AND dis_adv_status IN ('0', '1')"
                                        + " AND ROWNUM <= 1)"
                                        + " )";
					pstmt2 = con1.prepareStatement(visitQuery);
					pstmt2.setString(1,cons_ref_id);
					rs2 = pstmt2.executeQuery();
					while(rs2 != null && rs2.next()) {
						patientClass = checkForNull(rs2.getString("p_patient_class"));
						sourceType = checkForNull(rs2.getString("source_type"));
						sourceCode = checkForNull(rs2.getString("source_code"));
						episode_visit_num = checkForNull(rs2.getString("episode_visit_num"));
						order_id = checkForNull(rs2.getString("order_id"));
						order_line_num = checkForNull(rs2.getString("order_line_num"));
					}
				}catch(Exception e) {
					e.printStackTrace();
					System.out.println("Error in getting episode_visit_num: " + e);
				}finally {
					try {
						if(rs2!=null) rs2.close();
						if(pstmt2 != null) pstmt2.close();
						if(con1 != null) ConnectionManager.returnConnection(con1);
					}catch(Exception e) {
						e.printStackTrace();
						System.out.println("Error in closing connection: " + e);
					}
				}
				if(cmtFlag) {
					try {
						con3 = createConnection();
						String updateDtlSql = "UPDATE ca_cons_list_dtl"
												+ " SET cons_status = 'C',"
												+ " completed_date = SYSDATE,"
												+ " completed_user_id = ?,"
												+ " order_id = ?,"
												+ " line_no = ?"
												+ " WHERE cons_ref_id = ? AND facility_id = ? AND encounter_id = ?";
						pstmt5=con3.prepareStatement(updateDtlSql);
						cstmt=con3.prepareCall("{call OR_INSERT_ORDER_OTH_MODULE ( ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,NULL)}");
						cstmt.setString( 1, consult_date_time);
						cstmt.setString( 2, catalog);
						cstmt.setString( 3, "OR");
						cstmt.setString( 4, facilityId);
						cstmt.setString( 5, patientId);
						cstmt.setString( 6, patientClass);
						cstmt.setString( 7, encounterId);
						cstmt.setString( 8, encounterId);
						cstmt.setString( 9, episode_visit_num);
						cstmt.setString( 10, sourceType);
						cstmt.setString( 11, sourceCode);
						cstmt.setString( 12, strPractId);
						cstmt.setString( 13, loginuserid);
						cstmt.setString( 14, client_ip_address);
						cstmt.registerOutParameter(15,java.sql.Types.VARCHAR);
						cstmt.registerOutParameter(16,java.sql.Types.NUMERIC);
						cstmt.registerOutParameter(17,java.sql.Types.VARCHAR);
						cstmt.registerOutParameter(18,java.sql.Types.VARCHAR);
						cstmt.execute() ;
						p_out_order_id = checkForNull(cstmt.getString(15)); 
						p_out_order_line_num = checkForNull(cstmt.getString(16)); 
						p_facility_id = checkForNull(cstmt.getString(17)); 
						p_err_message = checkForNull(cstmt.getString(18)); 
						if(!p_out_order_id.equals(""))
						{
							pstmt5.clearParameters();		
							pstmt5.setString(1,loginuserid);
							pstmt5.setString(2,p_out_order_id);
							pstmt5.setString(3,p_out_order_line_num);
							pstmt5.setString(4,cons_ref_id);
							pstmt5.setString(5,facilityId);
							pstmt5.setString(6,encounterId);
							pstmt5.addBatch();
							nInsStat2 = pstmt5.executeBatch();
							if(nInsStat2[0]<0  && nInsStat2[0] != -2) {
								updFlag = false;
							}else { 
								updFlag = true;
							}
							if(updFlag)
							{ 		
								pstmt6=con3.prepareStatement("select short_desc description from or_order_catalog where order_catalog_code=?");
								pstmt6.clearParameters();		
								pstmt6.setString(1,catalog);
								rs6=pstmt6.executeQuery();
								while(rs6!=null && rs6.next())
								{
									catalog_desc=rs6.getString("description");
								}
								BillChargeInfo = orderEntryBillBean.getBillChargeDetails("1",catalog,consult_date_time, locale, order_id, order_line_num,patientId,encounterId,patientClass,strPractId);
								if(BillChargeInfo!=null)
								{
									for( int k=0 ; k< BillChargeInfo.size() ; k++ ) 
									{
										billing_details 	= (String[])BillChargeInfo.get(k);
										setBills_dtls		= new HashMap();
										setBills_dtls.put("charged_yn"       , billing_details[1]);
										setBills_dtls.put("total_payable"    , billing_details[2]);
										setBills_dtls.put("patient_payable"  , billing_details[3]);
										setBills_dtls.put("quantity"         , "1");
										setBills_dtls.put("incl_excl_action" , billing_details[4]);
										setBills_dtls.put("incl_excl_action_orginal" , billing_details[16]);
										setBills_dtls.put("preapp_yn"        , billing_details[5]);
										setBills_dtls.put("patient_paid_amt" , billing_details[6]);
										setBills_dtls.put("bl_panel_str"     , billing_details[0]);
										setBills_dtls.put("serv_panel_ind"   , billing_details[10]);
										setBills_dtls.put("serv_panel_code"  , billing_details[11]);
										setBills_dtls.put("p_episode_type"	 , billing_details[13]);
										setBills_dtls.put("p_episode_id"	 , billing_details[14]);
										setBills_dtls.put("p_visit_id"		 , billing_details[15]);
										setBills_dtls.put("Future_order_yn"		 , billing_details[17]);
										setBills_dtls.put("error_text"		 , billing_details[9]);
										orderEntryBillBean.setOrderBillDtls(patientId+encounterId+catalog, setBills_dtls);
									}
								}
								try
								{
									cstmt_bl_ext_charge_stage=con3.prepareCall("{CALL OR_BL_ORDER_CATALOG_LINE( ? ,? ,?, ?, ?, ? ,? ,?, ?, ?, ? ,? ,?, ?, ?, ? ,? , ?, ?, ?, ?, ?, ?, ?, ?,?,?,?)}");
									cstmt_bl_ext_charge_stage.setString(1,((String)facilityId));	
									cstmt_bl_ext_charge_stage.setString(2,((String)patientId));
									cstmt_bl_ext_charge_stage.setString(3,((String)encounterId));
									cstmt_bl_ext_charge_stage.setString( 4,((String)patientClass)) ; 	
									cstmt_bl_ext_charge_stage.setString( 5,(String)p_out_order_id) ;
									cstmt_bl_ext_charge_stage.setString( 6,(String)p_out_order_line_num) ;	
									cstmt_bl_ext_charge_stage.setString( 7,(String)catalog) ;	
									cstmt_bl_ext_charge_stage.setString( 8,(String)catalog_desc ) ;	
									cstmt_bl_ext_charge_stage.setString(9, consult_date_time ) ;
									cstmt_bl_ext_charge_stage.setString(10,"1") ;
									bill_dtls=(HashMap)orderEntryBillBean.getOrderBillDtls(patientId+encounterId+catalog);
									System.out.println(bill_dtls);
									if(bill_dtls != null)
									{
										p_total_amt	= (String)bill_dtls.get("total_payable");
										incl_excl_action = (String)bill_dtls.get("incl_excl_action");
										incl_excl_action_orginal = (String)bill_dtls.get("incl_excl_action_orginal");
										Future_order_yn	= (String)bill_dtls.get("Future_order_yn");
										patient_payable = (String)bill_dtls.get("patient_payable");
										approval = (String)bill_dtls.get("preapp_yn");
										if(incl_excl_action.equals(incl_excl_action_orginal))
										{
											incl_excl_action="";
										}
										else
										{
											incl_excl_action = (String)bill_dtls.get("incl_excl_action");
										}
										if("Y".equals(approval)) {
											approval = "Yes";
										}else if("N".equals(approval)) {
											approval = "No";
										}
										incl_excl_action_reason	= (String)bill_dtls.get("incl_excl_action_reason");
										bl_panel_str = (String)bill_dtls.get("bl_panel_str");
									}
									cstmt_bl_ext_charge_stage.setString(11,(String)p_total_amt);																		
									cstmt_bl_ext_charge_stage.setString(12,(String)strPractId);
									cstmt_bl_ext_charge_stage.setString(13,(String)incl_excl_action);	
									cstmt_bl_ext_charge_stage.setString(14,(checkForNull((String)incl_excl_action_reason)));
									cstmt_bl_ext_charge_stage.setString(15,bl_panel_str.trim()); 
									cstmt_bl_ext_charge_stage.setString(16,"N");
									cstmt_bl_ext_charge_stage.setString(17,"N");
									cstmt_bl_ext_charge_stage.setString(18,"N");
									cstmt_bl_ext_charge_stage.setString(19,"N");
									cstmt_bl_ext_charge_stage.setString(20,"Y");
									cstmt_bl_ext_charge_stage.setString(21, "N");
									cstmt_bl_ext_charge_stage.setString(22, "N");
									cstmt_bl_ext_charge_stage.setString(23, "N");
									cstmt_bl_ext_charge_stage.setString(24, "N");
									cstmt_bl_ext_charge_stage.setString(25, ((String)loginuserid));
									cstmt_bl_ext_charge_stage.setString(26, ((String)client_ip_address));
									cstmt_bl_ext_charge_stage.registerOutParameter( 27,  Types.VARCHAR );
									cstmt_bl_ext_charge_stage.registerOutParameter( 28,  Types.VARCHAR );
									cstmt_bl_ext_charge_stage.execute();
									error_message = checkForNull(cstmt_bl_ext_charge_stage.getString(27));
									charge_type_code = checkForNull(cstmt_bl_ext_charge_stage.getString(28));	
									if(! error_message.equals(""))
									{
										errcount++;
									}
									if(errcount==0)
									{
										cstmt_billing_ext = con3.prepareCall("{ CALL BL_PROC_FOR_EXT_SERVICE_MP.PROCESS_INTERFACED_REC( ? ,? ,?, ?, ?, ? ,? ,?, ?, ?, ? ,? ,?)}");
										cstmt_billing_ext.clearParameters();
										cstmt_billing_ext.setString(1,((String)facilityId));
										cstmt_billing_ext.setString(2,((String)patientId));
										cstmt_billing_ext.setString(3, "I");
										cstmt_billing_ext.setString(4,encounterId);
										cstmt_billing_ext.setString(5,episode_visit_num);
										cstmt_billing_ext.setString(6,p_out_order_id);  
										cstmt_billing_ext.setString(7,"OR");
										cstmt_billing_ext.setString(8,null);
										cstmt_billing_ext.setString(9,((String)loginuserid));
										cstmt_billing_ext.setString(10,((String)client_ip_address));
										cstmt_billing_ext.registerOutParameter( 11,Types.VARCHAR ) ;
										cstmt_billing_ext.registerOutParameter( 12,Types.VARCHAR ) ;
										cstmt_billing_ext.registerOutParameter( 13,Types.VARCHAR ) ;
										cstmt_billing_ext.execute();
										err_code = checkForNull(cstmt_billing_ext.getString(11));
										sys_message_id = checkForNull(cstmt_billing_ext.getString(12));
										err_message	= checkForNull(cstmt_billing_ext.getString(13));
										if(!err_code.equals("") || !err_message.equals(""))
										{
											errorcount++;
										}
										else if(!sys_message_id.equals(""))
										{
											errorcount++;
										}
									}
									if ( errorcount >0 ) 
									{
										con3.rollback();
									}
									else
									{
										con3.commit();
										System.out.println("Updated");
									}
								}
								catch(Exception be)
								{
									be.printStackTrace() ;
								}
							}
						}else {
							con3.rollback();
						}
					}catch(Exception e) {
						e.printStackTrace();
						System.out.println("Not updated");
						System.out.println("Error in Update Query: " + e);
					}finally {
						try {
							if(rs6 != null) rs6.close();
							if(pstmt6 != null) pstmt6.close();
							if(pstmt5 != null) pstmt5.close();
							if(con3 != null) ConnectionManager.returnConnection(con2);
							if(cstmt_billing_ext!=null) cstmt_billing_ext.close();
							if(cstmt!=null) cstmt.close();
						}catch(Exception e) {
							e.printStackTrace();
							System.out.println("Error in closing connection: " + e);
						}
					}

					transactionResponse.setTransactionResult(TransactionResponse.SUCCESS);
					errorInfo.setErrorMessage("Consultation Charges are Posted. Total: Rs " + p_total_amt + " Patient: Rs " 
												+ patient_payable + " Approval Required: " + approval + ".");
					transactionResponse.getErrorsList().add(errorInfo);
				}else {
					transactionResponse.setTransactionResult(TransactionResponse.FAILURE);
					errorInfo.setErrorMessage("Transaction could not be completed");
					transactionResponse.getErrorsList().add(errorInfo);
				}
			}
		}
		return transactionResponse;
	}
	
	private String checkForNull(String strParam)
    {
            String str ="";
            if(strParam!=null && strParam.length() > 0)
            str = strParam;
            return str;
    }
}
