/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law. 
 ******************************************************************************/
package eOP.PatCheckout;

import blopin.*;
import java.util.HashMap;
import java.util.Hashtable;
import java.rmi.*;
import javax.ejb.*;
import java.sql.*;
import javax.naming.*;
import javax.rmi.*;
import webbeans.eCommon.*;
import eCommon.Common.*;
import java.util.Map.Entry;

/**
*
* @ejb.bean
*	name="PatCheckoutManager"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="PatCheckoutManager"
*	local-jndi-name="PatCheckoutManager"
*	impl-class-name="eOP.PatCheckout.PatCheckoutManager"
*
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject"
*	local-class="eOP.PatCheckout.PatCheckoutManagerLocal"
*	remote-class="eOP.PatCheckout.PatCheckoutManagerRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome"
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eOP.PatCheckout.PatCheckoutManagerLocalHome"
*	remote-class="eOP.PatCheckout.PatCheckoutManagerHome"
*	generate= "local,remote"
*
*
*/

public class PatCheckoutManager implements SessionBean {
	Connection con;

	ResultSet rs;

	PreparedStatement pstmt = null;

	CallableStatement cs = null;

	PreparedStatement updpstmt	= null;
	PreparedStatement prstmt	= null;
	ResultSet rsset				= null;
	PreparedStatement pstmtacc	= null;
	ResultSet rsacc				= null;
	PreparedStatement pstmtaud	= null;
	ResultSet rsaud				= null;
	PreparedStatement pstmtaudatr	= null;
	ResultSet rsaudatr				= null;
	PreparedStatement pstmtaudatr1	= null;
	ResultSet rsaudatr1				= null;

	StringBuffer stringBuffer = new StringBuffer();

	StringBuffer P_UPDATE = new StringBuffer();

	StringBuffer findSql = new StringBuffer();

	String QS_UPDATE = "";

	String x_disp_req_for_mds_yn = "";

	String L_diag_yn = "N";

	String L_disp_yn = "N";

	String L_note_yn = "N";

	String L_mds_complete_yn = "N";

	String x_pract_type = "";

	String x_spl_code = "";

	String sl_ref_no = "";

	String facilityId = "";

	String p_patient_id = "";

	String p_locn_type = "";

	String p_locn_code = "";

	String encounter_id = "";

	String p_practitioner_id = "";

	String x_circumstance_of_injury = "";

	String x_attending_practitioner = "";

	String x_inv_ordered1 = "";

	String x_inv_ordered2 = "";

	String x_inv_ordered3 = "";

	String x_disposition_date_time = "";

	String x_disposition_type = "";

	String x_tocomeback = "";

	String x_comebackon = "";

	String invokeRecallForAE = ""; //Added by Ashwini on 18-Dec-2017 for ML-MMOH-CRF-0657

	String x_reason = "";

	String x_instructionsrecall = "";

	String x_conclude_episode_notes = "";

	String x_conclude_episode_start_date = "";

	String x_conclude_episode_end_date = "";

	String pract_assigned_yn = "";

	String concluded_yn = "";

	String addedFacilityId = "";

	String addedAtWorkstation = "";       

	String prn_visit_yn = "";

	String prn_visit_before = "";

	String module_id = "";

	String ae_treatment_area_code = "";

	String p_queue_date = "";

	String SickLeaveRecordFlag = "";

	String LeaveFrom = "";

	String LeaveTo = "";

	String FitForDuty = "";

	String FitonDuty = "";

	String CertIssued = "";

	String AuthorizedById = "";

	String remarks = "";

	String DECEASED_YN = "";

	String mcNo = "";

	String employmentDetails = "";

	String issued_date = "";

	String certificate_type = "";

	String strBLInstallYN = "";

	String medical_yn = "";

	String surgical_yn = "";

	String mlc_yn = "";

	String deceased_date_time = "";

	String released_date_time = "";

	String pm_yn = "";

	String high_risk_yn = "N";

	String brought_dead_yn = "N";

	String did_yn = "N"; //Added by Thamizh selvi on 28th Nov 2017 against ML-MMOH-CRF-0783

	String episode_id = "";

	String episode_visit_num = "";

	/*Added by Thamizh selvi on 27th Mar 2018 against ML-MMOH-CRF-0646 Start*/
	String osccYn			= "N";
	String OandGYn			= "N";
	String traumaYn			= "N";
	String nonEmergYn		= "N";
	String mechInjCode		= "";
	String mechInjSubCode	= "";
	/*End*/

	//Added by Ashwini on 22-Oct-2024 for ML-MMOH-CRF-1742
	Boolean isDeceasedDiagClassDeathRegAppl = false;
	String deceased_yn = "N";
	String deceased_date = "";
	String term_set_id = "";
	String term_code = "";
	String occur_srl_no = "";
	String accession_num_work_related = "";
	String audit_term_set_id = "";
	String audit_term_code = "";
	String audit_occur_srl_no = "";
	String audit_attr_updated = "";
	String audit_prev_attr_value = "";
	String attr_column_name = "";
	int nResult = 0;
	StringBuffer sbsql = new StringBuffer("");

	boolean flag = false;

	int res = 0;

	int acnt = 0;

	int count = 0;

	String reasonCode = "";

	String userId = "";

	String p_episode_type = "";

	String p_visit_id = "";

	String p_episode_id = "";

	String bed_no = "";
	String patient_class="";//Mahesh
	//Mahesh start 
	String visit_status="";
		String service_code="";
		String subservice_code="";
	//	String visit_adm_date_time="";
		String start_date_time="";
		String last_visit_date="";
		String last_visit_fu_reqd_yn="";
		String last_visit_num="";
		String end_date_time="";
		String episode_status="";
		String ae_episode_yn="";
		String practitioner_id="";
		int  episode_serv_cnt=0;
		int  last_visit_serv_cnt=0;
		
	//End
	String multi_speciality_yn = "N";//Added for the CRF - Bru-HIMS-CRF-198

	//String remarks = "";	
	/*Below line added for this CRF Bru-HIMS-CRF-133*/
	String isPatientEncMovement="";
    String Sydate="";
	//End Bru-HIMS-CRF-133
	
	//Added for HSA-CRF-0306.1
	ResultSet rest=null;
	CallableStatement cstmt=null;
	String errmsg="";
	
	//Added for AAKH-CRF-0179 by Ajay Hatwate on 23-08-2023
	String death_reg_form_accession_num = "";
	String isDeathRegisterFormAppl = "";
	String enable_death_reg_form = "N";
	
	//Added by Ajay Hatwate ML-MMOH-CRF-1653
	String caseType = "";
	
	java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat(
			"yyyy-MM-dd");

	//public final String RECORD_MODIFIED = "RECORD_MODIFIED";

	//public final String CERT_RECORD_ALREADY_EXISTS = "CERT_RECORD_ALREADY_EXISTS";

	//public final String MC_NO_ALREADY_EXISTS = "MC_NO_ALREADY_EXISTS";

	SessionContext ctx;

	public void ejbCreate() {
	}

	public void ejbRemove() {
	}

	public void ejbActivate() {
	}

	public void ejbPassivate() {
	}

	public void setSessionContext(SessionContext context) {
		this.ctx = context;
	}

	/**
	 *Method to insert single record
	 *@param properties Connection Properties
	 *@param hashaMap Record data
	 *@param as data for duplication check
	 *@param s Table Name
	 *@return HashMap holding the transaction details
	*/
	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/

	public java.util.HashMap updatePatCheckout(java.util.Properties p,
			java.util.HashMap tabdata)

	{

		java.util.HashMap results = new java.util.HashMap();

		boolean result = false;
		String strBLMessage = "0";
		String fm_install_yn = "";
		String locale = p.getProperty("LOCALE");
		facilityId = (String) tabdata.get("facilityId");
		p_patient_id = (String) tabdata.get("p_patient_id");
		p_locn_type = (String) tabdata.get("p_locn_type");
		p_locn_code = (String) tabdata.get("p_locn_code");
		encounter_id = (String) tabdata.get("encounter_id");
		p_practitioner_id = (String) tabdata.get("p_practitioner_id");
		x_circumstance_of_injury = (String) tabdata
				.get("x_circumstance_of_injury");
		x_attending_practitioner = (String) tabdata
				.get("x_attending_practitioner");

		x_inv_ordered1 = (String) tabdata.get("x_inv_ordered1");
		x_inv_ordered2 = (String) tabdata.get("x_inv_ordered2");
		x_inv_ordered3 = (String) tabdata.get("x_inv_ordered3");
		x_disposition_date_time = (String) tabdata
				.get("x_disposition_date_time");
		x_disposition_type = (String) tabdata.get("x_disposition_type");
		x_tocomeback = (String) tabdata.get("x_tocomeback");
		x_comebackon = (String) tabdata.get("x_comebackon");
		//Added by Ashwini on 18-Dec-2017 for ML-MMOH-CRF-0657
		invokeRecallForAE = (String) tabdata.get("invokeRecallForAE");
		x_reason = (String) tabdata.get("x_reason");
		x_instructionsrecall = (String) tabdata.get("x_instructionsrecall");
		x_conclude_episode_notes = (String) tabdata
				.get("x_conclude_episode_notes");
		x_conclude_episode_start_date = (String) tabdata
				.get("x_conclude_episode_start_date");
		x_conclude_episode_end_date = (String) tabdata
				.get("x_conclude_episode_end_date");
		pract_assigned_yn = (String) tabdata.get("pract_assigned_yn");
		concluded_yn = (String) tabdata.get("concluded_yn");
		addedFacilityId = facilityId;
		addedAtWorkstation = (String) tabdata.get("client_ip_address");
		prn_visit_yn = (String) tabdata.get("prn_visit_yn");
		prn_visit_before = (String) tabdata.get("prn_visit_before");
		module_id = (String) tabdata.get("x_module_id");
		ae_treatment_area_code = (String) tabdata
				.get("x_ae_treatment_area_code");
		p_queue_date = (String) tabdata.get("p_queue_date");
		SickLeaveRecordFlag = (String) tabdata.get("SickLeaveRecordFlag");
		LeaveFrom = (String) tabdata.get("LeaveFrom");
		LeaveTo = (String) tabdata.get("LeaveTo");
		FitForDuty = (String) tabdata.get("FitForDuty");
		FitonDuty = (String) tabdata.get("FitonDuty");
		CertIssued = (String) tabdata.get("CertIssued");
		AuthorizedById = (String) tabdata.get("AuthorizedById");
		remarks = (String) tabdata.get("remarks");
		DECEASED_YN = (String) tabdata.get("DECEASED_YN");
		mcNo = (String) tabdata.get("mcNo");
		employmentDetails = (String) tabdata.get("employmentDetails");
		issued_date = (String) tabdata.get("issued_date");
		certificate_type = (String) tabdata.get("certificate_type");
		strBLInstallYN = (String) tabdata.get("bl_install_yn");
		medical_yn = (String) tabdata.get("medical_yn");
		surgical_yn = (String) tabdata.get("surgical_yn");
		mlc_yn = (String) tabdata.get("mlc_yn");
		deceased_date_time = (String) tabdata.get("deceased_date_time");
		released_date_time = (String) tabdata.get("released_date_time");
		pm_yn = (String) tabdata.get("pm_yn");
		high_risk_yn = (String) tabdata.get("high_risk_yn");
		brought_dead_yn = (String) tabdata.get("brought_dead_yn");
		episode_id = (String) tabdata.get("episode_id");
		episode_visit_num = (String) tabdata.get("episode_visit_num");
		multi_speciality_yn = (String) tabdata.get("multi_speciality_yn");//Added for the CRF - Bru-HIMS-CRF-0198
		//Mahesh
		patient_class=(String) tabdata.get("patient_class");
		//visit_compl_days=(String) tabdata.get("visit_compl_days");		
	//	if(patient_class.equals("EM"))
	//	mode := 'EC';
	//	if(patient_class.equals("OP"))
	//	mode := 'OC';
		
		visit_status=(String) tabdata.get("visit_status");	
		service_code=(String) tabdata.get("service_code");	
		subservice_code=(String) tabdata.get("subservice_code");	
	//	visit_adm_date_time=(String) tabdata.get("visit_adm_date_time");	
		start_date_time=(String) tabdata.get("start_date_time");	
		last_visit_date=(String) tabdata.get("last_visit_date");	
		last_visit_fu_reqd_yn=(String) tabdata.get("last_visit_fu_reqd_yn");	
		last_visit_num=(String) tabdata.get("last_visit_num");	
		end_date_time=(String) tabdata.get("end_date_time");	
		episode_status=(String) tabdata.get("episode_status");	
		ae_episode_yn=(String) tabdata.get("ae_episode_yn");	
		practitioner_id=(String) tabdata.get("practitioner_id");	
		episode_serv_cnt=(Integer) tabdata.get("episode_serv_cnt");
		last_visit_serv_cnt=(Integer) tabdata.get("last_visit_serv_cnt");
		did_yn = (String) tabdata.get("didYn"); //Added by Thamizh selvi on 28th Nov 2017 against ML-MMOH-CRF-0783
		
		/*Added by Thamizh selvi on 27th Mar 2018 against ML-MMOH-CRF-0646 Start*/
		mechInjCode		= checkForNull((String) tabdata.get("mech_injury_catg_code"));
		mechInjSubCode	= checkForNull((String) tabdata.get("mech_injury_subcatg_code"));
		traumaYn		= checkForDefault((String) tabdata.get("traumaYn"), "N");
		osccYn			= checkForDefault((String) tabdata.get("osccYn"), "N");
		OandGYn			= checkForDefault((String) tabdata.get("OandGYn"), "N");
		nonEmergYn		= checkForDefault((String) tabdata.get("nonEmergYn"), "N");
		/*End*/

		//End
		StringBuffer sb = new StringBuffer("");

		String addedById = p.getProperty("login_user");
		String addedDate = dateFormat.format(new java.util.Date());
		String modifiedById = addedById;
		String modifiedDate = addedDate;
		String modifiedFacilityId = addedFacilityId;
		String modifiedAtWorkstation = addedAtWorkstation;

		Date added_date = Date.valueOf(addedDate);
		Date modified_date = Date.valueOf(modifiedDate);
		String episode_type = "";
		long p_encounter_id;

		String billgenlater = "";
		String billtotalamt = "";
		String billdoctype  = "";
		String billdocnum	= "";

		String str_bill_prt_format_YN = "N";
		String str_bill_prt_format_vals = "";
		String pgm_id ="";
		String session_id ="";
		String pgm_date ="";
		String mpi_id_rep = "";
		
		/*Below line added for this CRF Bru-HIMS-CRF-133*/
		 isPatientEncMovement			= (String) tabdata.get("isPatientEncMovement"); 
		 Sydate			            = (String) tabdata.get("Sydate"); 
		//End Bru-HIMS-CRF-133
		/*Below line added for AAKH-CF-0179 */
		isDeathRegisterFormAppl = (String) tabdata.get("isDeathRegisterFormAppl");
		enable_death_reg_form = (String) tabdata.get("enable_death_reg_form");
		if(isDeathRegisterFormAppl.equals("true")){
				death_reg_form_accession_num = (String) tabdata.get("death_reg_form_accession_num");
		}
		/* END AAKH-CRF-0179 */
		//Added by Ajay Hatwate for ML-MMOH-CRF-1653
		caseType = (String) tabdata.get("case_type");

	

		try {
			p_encounter_id = (Long.valueOf(encounter_id)).longValue();
			con = ConnectionManager.getConnection(p);

			x_disp_req_for_mds_yn = (String) tabdata.get("dispReqd");

			findSql.setLength(0);
			P_UPDATE.setLength(0);

			if (x_disp_req_for_mds_yn.equals("Y")) {
				if (!(x_disposition_type == null || x_disposition_type
						.equals(""))) {
					L_disp_yn = "Y";
				}
			} else {
				L_disp_yn = "Y";
			}
			if (L_note_yn.equals("Y") && L_diag_yn.equals("Y")
					&& L_disp_yn.equals("Y")) {
				L_mds_complete_yn = "Y";
			}
			try {
				findSql.append("UPDATE PR_ENCOUNTER set VISIT_STATUS = '07', PREV_VISIT_STATUS = VISIT_STATUS, 						CANCEL_CHECKOUT_REMARKS = null, CANCEL_DISCH_DATE = null, CANCEL_CHECKOUT_BY_ID = null, CANCEL_CHECKOUT_REASON_CODE = null, ");
				if (pract_assigned_yn.equals("Y")) {
					findSql.append(" ATTEND_PRACTITIONER_ID = '"
							+ x_attending_practitioner + "', PREV_PRACTITIONER_ID = ATTEND_PRACTITIONER_ID, ");
				}
				if (DECEASED_YN.equals("Y")) {
					findSql.append("DECEASED_DATE_TIME=to_date('"
							+ deceased_date_time + "','dd/mm/yyyy hh24:mi'), PREV_DECEASED_DATE_TIME = DECEASED_DATE_TIME, ");
				}
				//Added by Sangeetha on 10/may/17 for ML-MMOH-CRF-0628
				if (DECEASED_YN.equals("N")) {
					findSql.append("DECEASED_DATE_TIME='', PREV_DECEASED_DATE_TIME = DECEASED_DATE_TIME, ");
				}
               
			    /*Below query modified for this incident [62496]*/                  
            
				findSql.append("DISPOSITION_TYPE = ?, RECALL_YN = ?, "); 

				/*Added by Ashwini on 18-Dec-2017 for ML-MMOH-CRF-0657*/
				if(module_id.equals("AE") && invokeRecallForAE.equals("Y"))
				{
				findSql.append(" RECALL_DATE = TO_DATE(?,'DD/MM/YYYY HH24:MI'), ");
				}else
				{
				findSql.append(" RECALL_DATE = TO_DATE(?,'DD/MM/YYYY'), ");
				}
				/*End ML-MMOH-CRF-0657*/

				findSql.append(" CIRCUMSTANCE_OF_INJURY_CODE = ?,");
				findSql.append(" MDS_COMPLETE_YN = ?,  modified_by_id = ?, modified_date = sysdate,");
				findSql.append(" discharge_date_time = to_date('"							+ x_disposition_date_time + "','dd/mm/yyyy hh24:mi:ss'), modified_facility_id = ?, modified_at_ws_no = ?, prn_visit_yn = ? ,");
				findSql.append(" prn_visit_before = to_date( ? ,'dd/mm/yyyy'), MEDICAL_YN=?, SURGICAL_YN=?, MLC_YN=?, BODY_RELEASE_DATE_TIME=to_date(?,'dd/mm/yyyy hh24:mi'), PM_YN=?, DISCH_PRACTITIONER_ID=?, HIGH_RISK_YN=?, BROUGHT_DEAD_YN=? ,VISIT_STATUS_SET_BY_USER = ?, VISIT_STATUS_SET_ON_DATE = sysdate, PREV_BROUGHT_DEAD_YN = BROUGHT_DEAD_YN,PREV_MLC_YN = MLC_YN ,PREV_PM_YN = PM_YN,RECALL_REASON_CODE =?, DID_YN=?, PREV_DID_YN = DID_YN "); //Modified by Thamizh selvi on 28th Nov 2017 against ML-MMOH-CRF-0783
				
				/*Added by Thamizh selvi on 27th Mar 2018 against ML-MMOH-CRF-0646 Start*/
				findSql.append(", trauma_yn = ?, oscc_yn = ?, o_and_g_yn = ?, non_emerg_yn = ? ");
				if(osccYn.equals("Y"))
					findSql.append(" , mech_injury_catg_code = ?, mech_injury_subcatg_code = ? ");
				/*End*/
				if(mlc_yn.equals("Y"))				{
					findSql.append(", MARKED_BY_ID ='"+modifiedById+"',MARKED_DATE = sysdate ");
				} else { /*Thursday, January 13, 2011 ,SRR20056-SCF-6415 [IN:025852],point 11*/
					findSql.append(", MARKED_BY_ID ='',MARKED_DATE = '' ");
				}
				// ends SRR20056-SCF-6415 [IN:025852]
				//Added by Ajay Hatwate for AAKH-CRF-0179 on 23-08-2023 
				if(isDeathRegisterFormAppl.equals("true") && enable_death_reg_form.equals("Y")){
					findSql.append(", death_reg_form_accession_num = ? ");
				}
				findSql.append(", case_type = ? ");//Added by Ajay Hatwate for ML-MMOH-CRF-1653
				findSql.append("  where FACILITY_ID = ? and ENCOUNTER_ID = ? ");

				pstmt = con.prepareStatement(findSql.toString());
				pstmt.setString(1, x_disposition_type);
				pstmt.setString(2, x_tocomeback);
				pstmt.setString(3, x_comebackon);
				pstmt.setString(4, x_circumstance_of_injury);
				pstmt.setString(5, L_mds_complete_yn);
				pstmt.setString(6, modifiedById);
				pstmt.setString(7, modifiedFacilityId);
				pstmt.setString(8, modifiedAtWorkstation);
				pstmt.setString(9, prn_visit_yn);
				pstmt.setString(10, prn_visit_before);
				pstmt.setString(11, medical_yn);
				pstmt.setString(12, surgical_yn);
				pstmt.setString(13, mlc_yn);
				pstmt.setString(14, released_date_time);
				pstmt.setString(15, pm_yn);
				pstmt.setString(16, x_attending_practitioner);
				pstmt.setString(17, high_risk_yn);
				pstmt.setString(18, brought_dead_yn);
				pstmt.setString(19, modifiedById);
				pstmt.setString(20, x_reason);
				pstmt.setString(21, did_yn);//Added by Thamizh selvi on 28th Nov 2017 against ML-MMOH-CRF-0783
				/*Added by Thamizh selvi on 27th Mar 2018 against ML-MMOH-CRF-0646 Start*/
				pstmt.setString(22, traumaYn);
				pstmt.setString(23, osccYn);
				pstmt.setString(24, OandGYn);
				pstmt.setString(25, nonEmergYn);
				if(osccYn.equals("Y")){
					pstmt.setString(26, mechInjCode);
					pstmt.setString(27, mechInjSubCode);
					if(isDeathRegisterFormAppl.equals("true") && enable_death_reg_form.equals("Y")){
						pstmt.setString(28, death_reg_form_accession_num);
						pstmt.setString(29, caseType);//Added by Ajay Hatwate for ML-MMOH-CRF-1653
						pstmt.setString(30, facilityId);
						pstmt.setLong(31, p_encounter_id);
					}else{
					pstmt.setString(28, caseType);//Added by Ajay Hatwate for ML-MMOH-CRF-1653				
					pstmt.setString(29, facilityId);
					pstmt.setLong(30, p_encounter_id);
					}
				}else{/*End*/
					if(isDeathRegisterFormAppl.equals("true") && enable_death_reg_form.equals("Y")){
						pstmt.setString(26, death_reg_form_accession_num);
						pstmt.setString(27, caseType);//Added by Ajay Hatwate for ML-MMOH-CRF-1653
						pstmt.setString(28, facilityId);
						pstmt.setLong(29, p_encounter_id);
					}else{
					pstmt.setString(26, caseType);//Added by Ajay Hatwate for ML-MMOH-CRF-1653
					pstmt.setString(27, facilityId);
					pstmt.setLong(28, p_encounter_id);
					}
				}
				res = pstmt.executeUpdate();

				if (pstmt != null)
					pstmt.close();

				if (res != 0) {
					flag = true;
				} else {
					//sb.append("...UPDATE PR_ENCOUNTER   res " + res);
					con.rollback();
					flag = false;

				}

				if (findSql.length() > 0)
					findSql.delete(0, findSql.length());
			} catch (Exception e)
				{
				e.printStackTrace();
				try {
					con.rollback();
					flag = false;
				} catch (Exception roll) {
			roll.printStackTrace();

				}

			}


			if (flag) {
				if (x_tocomeback.equals("Y") || concluded_yn.equals("Y")) {
					P_UPDATE.append("UPDATE OP_EPISODE_FOR_SERVICE set ");
					if (x_tocomeback.equals("Y")) {
						P_UPDATE.append("LAST_VISIT_FU_REQD_YN = 'Y', ");
					} else {
						P_UPDATE.append("LAST_VISIT_FU_REQD_YN = 'N', ");
					}
					if (concluded_yn.equals("Y")) {
						P_UPDATE.append(" EPISODE_STATUS    = '08', ");
						P_UPDATE.append(" EPISODE_NOTES     =  '"
								+ x_conclude_episode_notes
								+"', END_DATE_TIME     = TO_DATE('"
								+ x_conclude_episode_end_date
								+ "','DD/MM/YYYY HH24:MI'), ");
					}
					P_UPDATE.append(" modified_by_id = ?, modified_date = ?, modified_facility_id = ?, modified_at_ws_no = ? ");
					P_UPDATE.append(" where operating_facility_id   = ? and episode_id =? ");


					pstmt = con.prepareStatement(P_UPDATE.toString());

					//pstmt.setString(1, x_conclude_episode_notes);
					pstmt.setString(1, modifiedById);
					pstmt.setDate(2, modified_date);
					pstmt.setString(3,modifiedFacilityId);
					pstmt.setString(4,modifiedAtWorkstation);
					pstmt.setString(5,facilityId);
					pstmt.setString(6,episode_id);


					int res5 = pstmt.executeUpdate();
					if (res5 != 0) {
						flag = true;
					} else {
						//sb.append("UPDATE OP_EPISODE_FOR_SERVICE res5=" + res5
						//		+ "rows updated");
						//con.rollback();
						flag = false;
						//Mahesh added
						if (P_UPDATE.length() > 0)
							P_UPDATE.delete(0, P_UPDATE.length());  //added by Sangeetha for MMS-DM-SCF-0303
						
						try
						{
						if (!flag)
							{
							if(episode_serv_cnt==0)
								{
								//P_UPDATE.append("insert into op_episode_for_service(PATIENT_ID,OPERATING_FACILITY_ID,  CLINIC_CODE,SERVICE_CODE,SUBSERVICE_CODE,START_DATE_TIME,LAST_ENCOUNTER_ID,LAST_VISIT_DATE,LAST_VISIT_FU_REQD_YN, LAST_VISIT_NUM,END_DATE_TIME,EPISODE_STATUS ,AE_EPISODE_YN ,ADDED_BY_ID, ADDED_DATE,		ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID, MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID,EPISODE_ID)values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?,?)");

								P_UPDATE.append("insert into op_episode_for_service(PATIENT_ID,OPERATING_FACILITY_ID,  CLINIC_CODE,SERVICE_CODE,SUBSERVICE_CODE,START_DATE_TIME,LAST_ENCOUNTER_ID,LAST_VISIT_DATE,LAST_VISIT_FU_REQD_YN, LAST_VISIT_NUM,END_DATE_TIME,EPISODE_STATUS ,AE_EPISODE_YN ,ADDED_BY_ID, ADDED_DATE,		ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID, MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID,EPISODE_ID)values (?,?,?,?,?,to_date(?,'dd/mm/yyyy hh24:mi:ss'),?,to_date(?,'dd/mm/yyyy hh24:mi:ss'),?,?,to_date(?,'dd/mm/yyyy hh24:mi:ss'),?,?,?,SYSDATE,?,?,?,SYSDATE,?,?,?)");  //modified by Sangeetha for MMS-DM-SCF-0303 

								pstmt = con.prepareStatement(P_UPDATE.toString());
								pstmt.setString(1,p_patient_id);
								pstmt.setString(2,facilityId);
								pstmt.setString(3,p_locn_code);
								pstmt.setString(4,service_code);
								pstmt.setString(5,subservice_code);
								pstmt.setString(6,start_date_time);
								pstmt.setLong(7,p_encounter_id);
								pstmt.setString(8,last_visit_date);
								pstmt.setString(9,last_visit_fu_reqd_yn);
								pstmt.setString(10,last_visit_num);
								pstmt.setString(11,end_date_time);
								pstmt.setString(12,episode_status);
								pstmt.setString(13,ae_episode_yn);
								pstmt.setString(14,modifiedById);
								pstmt.setString(15,modifiedAtWorkstation);
								pstmt.setString(16,modifiedFacilityId);
								pstmt.setString(17,modifiedById);
								pstmt.setString(18,modifiedAtWorkstation);
								pstmt.setString(19,modifiedFacilityId);
								pstmt.setString(20,episode_id);
								int cnt = pstmt.executeUpdate();
								
								if(cnt==0)
									{
									sb.append("INSERT op_episode_for_service cnt= "
											+ cnt + "rows updated");
									con.rollback();
									flag = false;
									}
								else
									{
									flag = true;
									}
								if (pstmt != null)
								pstmt.close();	
								if (P_UPDATE.length() > 0)
							P_UPDATE.delete(0, P_UPDATE.length());
								}
							else
								{
								//Mahesh today
								P_UPDATE.append("select last_encounter_id,last_visit_num,last_visit_date,episode_id from op_episode_for_service where operating_facility_id = ? and patient_id= ? and service_code=? ");
								
								pstmt = con.prepareStatement(P_UPDATE.toString());
								pstmt.setString(1,facilityId);
								pstmt.setString(2,p_patient_id);
								pstmt.setString(3,service_code);
								rs = pstmt.executeQuery();
								long v_last_encounter_id;
								String v_last_visit_num="";
								//String  v_last_visit_date=""; //Commented for checkstyle
								String  v_episode_id="";
								if(rs.next())
									{
									v_last_encounter_id=rs.getLong("last_encounter_id");
									v_last_visit_num=rs.getString("v_last_visit_num");
									//v_last_visit_date=rs.getString("last_encounter_id");
									v_episode_id=rs.getString("episode_id");
									}
								if(rs!=null) rs.close();
								if(pstmt!=null) pstmt.close();
								//if(v_last_encounter_id)
								//End today
								//System.err.println("595,cnt===========>"+cnt);
							//	if(cnt==0)
								//pstmt.setLong(1,p_encounter_id);
								//pstmt.setString(2,p_patient_id);
								//pstmt.setString(3,last_visit_num);
								//pstmt.setLong(22, p_encounter_id);
								//if(!last_encounter_id)
								
								P_UPDATE.append("update op_episode_for_service set last_encounter_id = ?,last_visit_date = ?,last_visit_num = ?,MODIFIED_BY_ID =?,MODIFIED_DATE = SYSDATE,MODIFIED_AT_WS_NO = ?,MODIFIED_FACILITY_ID = ? where operating_facility_id = ? and patient_id= ? and service_code=?");
								
								pstmt = con.prepareStatement(P_UPDATE.toString());
								pstmt.setLong(1,p_encounter_id);
								pstmt.setString(2,last_visit_date);
								pstmt.setString(3,last_visit_num);
								pstmt.setString(4,modifiedById);
								pstmt.setString(5,modifiedAtWorkstation);
								pstmt.setString(6,modifiedFacilityId);
								pstmt.setString(7,facilityId);
								pstmt.setString(8,p_patient_id);
								pstmt.setString(9,service_code);
								int cnt = pstmt.executeUpdate();
								
								if(cnt==0)
									{
									sb.append("Update op_episode_for_service cnt= "
											+ cnt + "rows updated");
									con.rollback();
									flag = false;
									}
								else
									{
									flag = true;
									}
								if (pstmt != null)
								pstmt.close();	
								if (P_UPDATE.length() > 0)
								P_UPDATE.delete(0, P_UPDATE.length());
								}
							}
							}
						catch(Exception e)	
							{
							e.printStackTrace();
							
							}
						//Mahesh ends
					}
					P_UPDATE.setLength(0);
					if (pstmt != null)
						pstmt.close();
					if (P_UPDATE.length() > 0)
						P_UPDATE.delete(0, P_UPDATE.length());
				} // end of if
			} else {
				con.rollback();
				flag = false;
			}
			
			if (flag) 
					{
					P_UPDATE.append("UPDATE OP_LAST_VISIT_FOR_SERVICE set ");

					/*Added by Ashwini on 18-Dec-2017 for ML-MMOH-CRF-0657*/
					if(module_id.equals("AE") && invokeRecallForAE.equals("Y"))
					{
					P_UPDATE.append(" RECALL_DATE = TO_DATE(?,'DD/MM/YYYY HH24:MI'), ");
					}else
					{
					P_UPDATE.append(" RECALL_DATE = TO_DATE(?,'DD/MM/YYYY'), ");
					}
					/*End ML-MMOH-CRF-0657*/

					P_UPDATE.append(" RECALL_REASON = ?, ");
					P_UPDATE.append(" modified_by_id = ?, modified_date = ?, modified_facility_id = ?, modified_at_ws_no  = ? , ATTEND_PRACTITIONER_ID = ? ");
					P_UPDATE.append(" where OPERATING_FACILITY_ID = ? and ENCOUNTER_ID = ? ");
					pstmt = con.prepareStatement(P_UPDATE.toString());
					pstmt.setString(1, x_comebackon);
					pstmt.setString(2, x_reason);
					pstmt.setString(3, modifiedById);
					pstmt.setDate(4, modified_date);
					pstmt.setString(5, modifiedFacilityId);
					pstmt.setString(6, modifiedAtWorkstation);
					pstmt.setString(7, x_attending_practitioner);
					pstmt.setString(8, facilityId);
					pstmt.setLong(9, p_encounter_id);


					int res2 = pstmt.executeUpdate();
					if (res2 == 0) {
					//	sb.append("UPDATE OP_LAST_VISIT_FOR_SERVICE res2= "
					//			+ res2 + "rows updated");
					//	con.rollback();
						flag = false;
						//Mahesh Starts
						if (P_UPDATE.length() > 0)
							P_UPDATE.delete(0, P_UPDATE.length());  //added by Sangeetha for MMS-DM-SCF-0303
						
						try
							{
						if(!flag)
							{
							if(last_visit_serv_cnt==0)
								{
								P_UPDATE.append("INSERT INTO op_last_visit_for_service(patient_id, operating_facility_id, service_code, encounter_id, added_by_id, added_date,added_at_ws_no, added_facility_id,modified_by_id, modified_date, modified_at_ws_no,modified_facility_id, visit_adm_date_time,assign_care_locn_code, patient_class,ATTEND_PRACTITIONER_ID)  VALUES (?, ?,?,?, ?, SYSDATE,?,?,?, SYSDATE, ?, ?,to_date(?,'dd/mm/yyyy hh24:mi:ss'),?, ?,?)");   //Modified by Sangeetha for MMS-DM-SCF-0303

								pstmt = con.prepareStatement(P_UPDATE.toString());
								pstmt.setString(1,p_patient_id);
								pstmt.setString(2,facilityId);
								pstmt.setString(3,service_code);
								pstmt.setLong(4,p_encounter_id);
								pstmt.setString(5,modifiedById);
								pstmt.setString(6,modifiedAtWorkstation);
								pstmt.setString(7,modifiedFacilityId);
								pstmt.setString(8,modifiedById);
								pstmt.setString(9,modifiedAtWorkstation);
								pstmt.setString(10,modifiedFacilityId);
								pstmt.setString(11,start_date_time);
								pstmt.setString(12,p_locn_code);
								pstmt.setString(13,patient_class);
								pstmt.setString(14,practitioner_id);       //added by Sangeetha for MMS-DM-SCF-0303
								int cnt = pstmt.executeUpdate();

								if(cnt==0)
									{
									sb.append("INSERT op_last_visit_for_service cnt= "
											+ cnt + "rows updated");
									con.rollback();
									flag = false;
									}
								else
									{
									flag = true;
									}
								if (pstmt != null)
								pstmt.close();	
								if (P_UPDATE.length() > 0)
								P_UPDATE.delete(0, P_UPDATE.length());
								}
							else
								{
								P_UPDATE.append("UPDATE op_last_visit_for_service  SET encounter_id = ?,                visit_adm_date_time = to_date(?,'dd/mm/yyyy hh24:mi:ss'),assign_care_locn_code = ?,patient_class = ?,                        modified_by_id = ?,modified_date = SYSDATE,modified_at_ws_no = ?,                         modified_facility_id = ?  WHERE operating_facility_id = ? AND patient_id = ?  AND service_code = ?");
								
								pstmt = con.prepareStatement(P_UPDATE.toString());
								pstmt.setLong(1,p_encounter_id);
								pstmt.setString(2,start_date_time);
								pstmt.setString(3,p_locn_code);
								pstmt.setString(4,patient_class);
								pstmt.setString(5,modifiedById);
								pstmt.setString(6,modifiedAtWorkstation);
								pstmt.setString(7,modifiedFacilityId);
								pstmt.setString(8,facilityId);
								pstmt.setString(9,p_patient_id);
								pstmt.setString(10,service_code);
								int cnt = pstmt.executeUpdate();
								
								if(cnt==0)
									{
									sb.append("Update op_last_visit_for_service cnt= "
											+ cnt + "rows updated");
									con.rollback();
									flag = false;
									}
								else
									{
									flag = true;
									}
								if (pstmt != null)
								pstmt.close();	
								if (P_UPDATE.length() > 0)
								P_UPDATE.delete(0, P_UPDATE.length());
								}
							}
								}
						catch(Exception e)	
							{
							e.printStackTrace();
							
							}
						//Mahesh End	
						
					} else {
						flag = true;
					}
					P_UPDATE.setLength(0);
					if (pstmt != null)
						pstmt.close();
					P_UPDATE.setLength(0);
				//}
			} //if
			else {
				con.rollback();
				flag = false;
			}

			if (flag) {
			
			        /*Below line added for this CRF Bru-HIMS-CRF-133*/
			   		
				if(eOP.QMSInterface.isSiteSpecific(con,"OP","PATENC_MOVEMENT")&&isPatientEncMovement.equals("true")&& p_queue_date.equals(Sydate)){	
                String op_update="UPDATE OP_PATIENT_QUEUE set CURR_LOCN_CODE=?, CURR_LOCN_TYPE=? where facility_id = ?  and PATIENT_ID = ?";
								
				pstmt = con.prepareStatement(op_update);
				pstmt.setString(1, "");
				pstmt.setString(2, "");
				pstmt.setString(3, facilityId);
				pstmt.setString(4, p_patient_id);
				int updateque=pstmt.executeUpdate();
				
				if(pstmt!=null) pstmt.close();
				}
				//End Bru-HIMS-CRF-133	
			
			    /*Below query modified for this incident [62496]*/ 
			            
				P_UPDATE.append("UPDATE OP_PATIENT_QUEUE set CONS_SRVC_END_DATE_TIME = TO_DATE(?,'DD/MM/YYYY HH24:MI:SS'), PREV_VISIT_STATUS = QUEUE_STATUS, CANCEL_CHECKOUT_REMARKS = null, CANCEL_CHECKOUT_DATE = null, CANCEL_CHECKOUT_BY_ID = null,CANCEL_CHECKOUT_REASON_CODE = null, QUEUE_STATUS = '07', PRACTITIONER_ID='"+x_attending_practitioner+"', PREV_PRACTITIONER_ID = PRACTITIONER_ID, ");
				P_UPDATE.append(" modified_by_id = ?, modified_date = ?, modified_facility_id = ?, modified_at_ws_no = ?, ");
				P_UPDATE.append("MEDICAL_YN=?,SURGICAL_YN=?,MLC_YN=?,BODY_RELEASE_DATE_TIME=to_date(?,'dd/mm/yyyy hh24:mi'),PM_YN=? ,HIGH_RISK_YN=?,DISCHARGE_DATE_TIME=to_date('" + x_disposition_date_time + "','dd/mm/yyyy hh24:mi:ss'),DISPOSITION_TYPE=?,BROUGHT_DEAD_YN=?,RECALL_YN=?, ");

				/*Added by Ashwini on 18-Dec-2017 for ML-MMOH-CRF-0657*/
				if(module_id.equals("AE") && invokeRecallForAE.equals("Y"))
				{
				P_UPDATE.append(" RECALL_DATE = TO_DATE(?,'DD/MM/YYYY HH24:MI'), "); 
				}else
				{
				P_UPDATE.append(" RECALL_DATE = TO_DATE(?,'DD/MM/YYYY'), ");
				}
				/*End ML-MMOH-CRF-0657*/

				P_UPDATE.append(" RECALL_REASON_CODE=?,PREV_BROUGHT_DEAD_YN = BROUGHT_DEAD_YN,PREV_MLC_YN = MLC_YN,PREV_PM_YN = PM_YN, DID_YN=?, PREV_DID_YN = DID_YN");//Modified by Thamizh selvi on 28th Nov 2017 against ML-MMOH-CRF-0783
				
				/*Added by Thamizh selvi on 28th Mar 2018 against ML-MMOH-CRF-0646 Start*/
				P_UPDATE.append(", trauma_yn = ?, oscc_yn = ?, o_and_g_yn = ?, non_emerg_yn = ? ");
				if(osccYn.equals("Y"))
					P_UPDATE.append(" , mech_injury_catg_code = ?, mech_injury_subcatg_code = ? ");
				/*End*/
				if (DECEASED_YN.equals("Y")) {
					P_UPDATE.append(",DECEASED_DATE_TIME=to_date('"
							+ deceased_date_time + "','dd/mm/yyyy hh24:mi'),PREV_DECEASED_DATE_TIME = DECEASED_DATE_TIME ");
				}
				//Added by Sangeetha on 10/may/17 for ML-MMOH-CRF-0628
				if (DECEASED_YN.equals("N")) {
					P_UPDATE.append(",DECEASED_DATE_TIME='',PREV_DECEASED_DATE_TIME = DECEASED_DATE_TIME ");
				}
				P_UPDATE.append(" where facility_id = ?  and encounter_id = ? ");


				pstmt = con.prepareStatement(P_UPDATE.toString());
				pstmt.setString(1, x_disposition_date_time);
				pstmt.setString(2, modifiedById);
				pstmt.setDate(3, modified_date);
				pstmt.setString(4, modifiedFacilityId);
				pstmt.setString(5, modifiedAtWorkstation);
				pstmt.setString(6, medical_yn);
				pstmt.setString(7, surgical_yn);
				pstmt.setString(8, mlc_yn);
				pstmt.setString(9, released_date_time);
				pstmt.setString(10, pm_yn);
				pstmt.setString(11, high_risk_yn);
				pstmt.setString(12, x_disposition_type);
				pstmt.setString(13, brought_dead_yn);
				pstmt.setString(14, x_tocomeback);
				pstmt.setString(15, x_comebackon);
				pstmt.setString(16, x_reason);
				pstmt.setString(17, did_yn);//Added by Thamizh selvi on 28th Nov 2017 against ML-MMOH-CRF-0783
				/*Added by Thamizh selvi on 27th Mar 2018 against ML-MMOH-CRF-0646 Start*/
				pstmt.setString(18, traumaYn);
				pstmt.setString(19, osccYn);
				pstmt.setString(20, OandGYn);
				pstmt.setString(21, nonEmergYn);
				if(osccYn.equals("Y")){
					pstmt.setString(22, mechInjCode);
					pstmt.setString(23, mechInjSubCode);
					pstmt.setString(24, facilityId);
					pstmt.setLong(25, p_encounter_id);
				}else{/*End*/
					pstmt.setString(22, facilityId);
					pstmt.setLong(23, p_encounter_id);
				}
				int res4 = pstmt.executeUpdate();

				if (res4 != 0) {
					flag = true;
				} else {
					sb.append("UPDATE OP_PATIENT_QUEUE res4=" + res4
							+ "rows updated");
					con.rollback();
					flag = false;
				}
				P_UPDATE.setLength(0);

				if (pstmt != null) pstmt.close();
				
			
				
				
			} //if
			else {
				con.rollback();
				flag = false;
			}
			
			String  Check_deceased="";
			String  check_decsd_Date="";
			try{

			String sql = "SELECT DECEASED_YN, DECEASED_DATE from MP_PATIENT WHERE  PATIENT_ID='"+p_patient_id+"'";
			
			pstmt= con.prepareStatement(sql);
			rs	= pstmt.executeQuery();
					
			while(rs!=null && rs.next()){
			Check_deceased=rs.getString("DECEASED_YN");
			check_decsd_Date=rs.getString("DECEASED_DATE");

			
			}
			
		}catch(Exception ex){
			System.err.println("Exception in Deceased try- "+ex.getMessage());
			ex.printStackTrace();
		}finally{
			try{
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
			}catch(Exception ex){
				System.err.println("Exception in Deceased - "+ex.getMessage());
				ex.printStackTrace();
			}
		    }	  

			/***** added on 10/22/2003 for updating MP_PATIENT with deceased_yn*****/
			if (flag) {
				if (DECEASED_YN.equals("Y")) {
					try {
						if (module_id.equals("AE")) {

							cs = con.prepareCall("{call MP_AUDIT_FUNCTION.ASSIGN_VALUE('AE_CHECK_OUT')}");
						} else {

							cs = con.prepareCall("{call MP_AUDIT_FUNCTION.ASSIGN_VALUE('SEARCH_FOR_CHKOUT')}");
						}
						cs.execute();
						if (cs != null)
							cs.close();
					} catch (Exception e) {
						flag = false;
						sb.append("Procedure-MP_AUDIT_FUNCTION:"+ e.toString());
						e.printStackTrace();
					}

					if (flag) {

						String MP_UPDATE = "update mp_patient set DECEASED_YN = 'Y', ACTIVE_YN='N' , DECEASED_DATE =to_date(?,'dd/mm/yyyy hh24:mi') , modified_by_id = ?, modified_date = sysdate, modified_facility_id = ? , modified_at_ws_no = ?,DECEASED_FACILITY_ID=?,DECEASED_ENCOUNTER_ID=? where PATIENT_ID = ? ";

						pstmt = con.prepareStatement(MP_UPDATE);
						pstmt.setString(1, deceased_date_time);
						pstmt.setString(2, modifiedById);
						pstmt.setString(3, modifiedFacilityId);
						pstmt.setString(4, modifiedAtWorkstation);
						pstmt.setString(5, facilityId);
						pstmt.setLong(6, p_encounter_id);
						pstmt.setString(7, p_patient_id);

						int retval = pstmt.executeUpdate();

						if (retval == 0) {
							sb.append("update mp_patient set deceased retval="
									+ retval + "values updated");
							con.rollback();
							flag = false;
						}
						if (pstmt != null)
							pstmt.close();
						flag = true;
					} //if
					else {
						con.rollback();
						flag = false;
					}
				}
				//START Added by Sangeetha on 10/may/17 for ML-MMOH-CRF-0628
				else if (DECEASED_YN.equals("N") && Check_deceased.equals("N") && check_decsd_Date == null) {
		
					if (flag) {

						String MP_UPDATE = "update mp_patient set DECEASED_YN = 'N', ACTIVE_YN='Y' , DECEASED_DATE ='' , modified_by_id = ?, modified_date = sysdate, modified_facility_id = ? , modified_at_ws_no = ? where PATIENT_ID = ? ";//Modified by Thamizh selvi against GHL-SCF-1331 on 8th May 2018

						pstmt = con.prepareStatement(MP_UPDATE);
						//pstmt.setString(1, deceased_date_time);//Commented by Thamizh selvi on 8th May 2018 against GHL-SCF-1331
						pstmt.setString(1, modifiedById);
						pstmt.setString(2, modifiedFacilityId);
						pstmt.setString(3, modifiedAtWorkstation);
						//Below code commented against GHL-SCF-1331 on 8th May 2018 by Thamizh selvi 
						//pstmt.setString(5, facilityId);
						//pstmt.setLong(6, p_encounter_id);
						pstmt.setString(4, p_patient_id);

						int retval = pstmt.executeUpdate();

						if (retval == 0) {
							sb.append("update mp_patient set deceased retval="
									+ retval + "values updated");
							con.rollback();
							flag = false;
						}
						if (pstmt != null)
							pstmt.close();
						flag = true;
					} //if
					else {
						con.rollback();
						flag = false;
					}
				}
				//END Added by Sangeetha on 10/may/17 for ML-MMOH-CRF-0628
			}
			if (flag) {
				if (SickLeaveRecordFlag.equals("Y")) {
					java.util.Hashtable message = MessageManager.getMessage(
							locale, "CODE_ALREADY_EXISTS", "Common");

					String msg1 = (String) message.get("message");
					message.clear();
					java.util.Hashtable message2 = MessageManager.getMessage(
							locale, "MC_NO_ALREADY_EXISTS", "OP");

					String msg2 = (String) message2.get("message");
					message2.clear();

					try {
						pstmt = con
								.prepareStatement("Select '1' from pr_sick_leave_register where added_facility_id = ? and mc_no = ? and patient_id = ? and trunc(leave_from) = trunc(to_date(?,'dd/mm/yyyy hh24:mi')) and trunc(leave_to) = trunc(to_date(?,'dd/mm/yyyy hh24:mi'))");

						pstmt.setString(1, facilityId);
						pstmt.setString(2, mcNo);
						pstmt.setString(3, p_patient_id);
						pstmt.setString(4, LeaveFrom);
						pstmt.setString(5, LeaveTo);

						rs = pstmt.executeQuery();

						if (rs != null && rs.next()) {
							sb.append(msg1);
							flag = false;
						}

						if (rs != null)
							rs.close();
						if (pstmt != null)
							pstmt.close();

						if (flag) {
							pstmt = con
									.prepareStatement("Select '1' from pr_sick_leave_register where mc_no = ?");

							pstmt.setString(1, mcNo);
							rs = pstmt.executeQuery();

							if (rs != null && rs.next()) {
								sb.append(msg2);
								flag = false;
							}

							if (rs != null)
								rs.close();
							if (pstmt != null)
								pstmt.close();
						}
					} catch (Exception e) {
						sb
								.append("Exception while checking duplicate medical certificate:");
						e.printStackTrace();
						flag = false;
					}

					if (flag) {
						pstmt = con
								.prepareStatement("select PR_SICK_LEAVE_REGISTER_SEQ.NEXTVAL  from dual");
						rs = pstmt.executeQuery();
						if (rs.next()) {
							sl_ref_no = rs.getString(1);
						}
						if (rs != null)
							rs.close();
						if (pstmt != null)
							pstmt.close();

						QS_UPDATE = "insert into pr_sick_leave_register (sl_ref_no, patient_id, facility_id, encounter_id, leave_from, leave_to, fit_for_duty, cert_issued, authorized_by_id, remarks, added_by_id, added_date, added_at_ws_no, added_facility_id, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID, fit_on_duty, mc_no, employment_details, follow_up_date,cert_issued_date,cert_type) values(?,?,?,?,to_date(?,'dd/mm/yyyy hh24:mi'),to_date(?,'dd/mm/yyyy hh24:mi'),?,?,?,?,?,?,?,?,?,?,?,?,to_date(?,'dd/mm/yyyy'),?,?,to_date(?,'dd/mm/yyyy'),to_date(?,'dd/mm/yyyy'),?) ";
						pstmt = con.prepareStatement(QS_UPDATE);

						pstmt.setString(1, sl_ref_no);
						pstmt.setString(2, p_patient_id);
						pstmt.setString(3, facilityId);
						pstmt.setLong(4, p_encounter_id);
						pstmt.setString(5, LeaveFrom);
						pstmt.setString(6, LeaveTo);
						pstmt.setString(7, FitForDuty);
						pstmt.setString(8, CertIssued);
						pstmt.setString(9, AuthorizedById);
						pstmt.setString(10, remarks);
						pstmt.setString(11, addedById);
						pstmt.setDate(12, added_date);
						pstmt.setString(13, addedAtWorkstation);
						pstmt.setString(14, addedFacilityId);
						pstmt.setString(15, modifiedById);
						pstmt.setDate(16, modified_date);
						pstmt.setString(17, modifiedAtWorkstation);
						pstmt.setString(18, modifiedFacilityId);
						pstmt.setString(19, FitonDuty);
						pstmt.setString(20, mcNo);
						pstmt.setString(21, employmentDetails);
						pstmt.setString(22, x_comebackon);
						pstmt.setString(23, issued_date);
						pstmt.setString(24, certificate_type);
						int res5 = pstmt.executeUpdate();

						if (res5 != 0) {
							flag = true;
						} else {
							sb.append("insert into pr_sick_leave_register res5"
									+ res5 + "rows inserted+");
							con.rollback();
							flag = false;
						}

						if (pstmt != null)
							pstmt.close();
					}
				}
			} else {
				con.rollback();
				flag = false;
			}
			//CRF - 198 start		
			// The status in PR_ENCOUNTER_JOINT_CONSULT will be updated to 'C' during checkout
			if(flag && multi_speciality_yn.equals("Y")){
				P_UPDATE.append("UPDATE PR_ENCOUNTER_JOINT_CONSULT set status='C', ");
				P_UPDATE.append(" modified_by_id = ?, modified_date = ?, modified_facility_id = ?, modified_at_ws_no  = ? ");
				P_UPDATE.append(" where FACILITY_ID = ? and ENCOUNTER_ID = ? ");
				pstmt = con.prepareStatement(P_UPDATE.toString());
				
				pstmt.setString(1, modifiedById);
				pstmt.setDate(2, modified_date);
				pstmt.setString(3, modifiedFacilityId);
				pstmt.setString(4, modifiedAtWorkstation);
				
				pstmt.setString(5, facilityId);
				pstmt.setLong(6, p_encounter_id);


				int res2 = pstmt.executeUpdate();
				
				P_UPDATE.setLength(0);
				if (pstmt != null)
					pstmt.close();
			}
			if (flag) { 
				if (module_id.equals("AE")) { 
					if (!ae_treatment_area_code.equals("")) {
						try {

							String sqlaecalc = "{call AE_CALC_QUEUE_SUMM(?,?,?,?,?,?,?)}";
							cs = con.prepareCall(sqlaecalc);
							cs.setString(1, facilityId);
							cs.setString(2, p_queue_date);
							cs.setString(3, p_locn_type);
							cs.setString(4, p_locn_code);
							cs.setString(5, ae_treatment_area_code);
							cs.setString(6, addedById);
							cs.registerOutParameter(7, java.sql.Types.VARCHAR);
							cs.execute();
							String err_val = cs.getString(7);

							if (err_val == null) {
								err_val = "Null Value";
								sb.append("call AE_CALC_QUEUE_SUMM err_val:"
										+ err_val);
							}
							if (err_val.equalsIgnoreCase("NO_ERROR")) {
								flag = true;
							} else {
								con.rollback();
								flag = false;
								sb.append(err_val);
							}
							if (cs != null)
								cs.close();
						} catch (Exception e1) {
							sb.append(e1.toString() + ":AE_CALC_QUEUE_SUMM");
							e1.printStackTrace();
						} finally {
							if (cs != null)
								cs.close();
						}
					}
				} else {
					flag = true;
				}
			} else {
				con.rollback();
				flag = false;
			}

			if (flag) {				

				String sql16 = "select install_yn from sm_module where module_id = 'FM' "; 			  

				pstmt = con.prepareStatement(sql16);
				rs = pstmt.executeQuery();
				if (rs != null && rs.next()) {
					fm_install_yn = rs.getString(1);
				}
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();

				if (fm_install_yn.equals("Y")) {

					try {
							String sqlfmlocn = "{call FM_MOV_FILE_TO_INCOMPL_FS_LOCN(?,?,?,?,?,?,?)}";
							cs = con.prepareCall(sqlfmlocn);
							cs.setString(1, facilityId);
							cs.setString(2, p_patient_id);
							cs.setString(3, p_locn_type);
							cs.setString(4, p_locn_code);
							cs.setString(5, addedById);
							cs.setString(6, addedAtWorkstation);
							cs.registerOutParameter(7, java.sql.Types.VARCHAR);
							cs.execute();
							String err_val = cs.getString(7);

							if (err_val == null) {
								flag = true;
							}
							else {
								con.rollback();
								flag = false;
								sb.append(err_val);
							}
							if (cs != null)
								cs.close();
						} catch (Exception e1) {
							flag = false;
							sb.append(e1.toString() + ":FM_MOV_FILE_TO_INCOMPL_FS_LOCN");
							e1.printStackTrace();
						} finally {
							if (cs != null)
								cs.close();
						}

					/*

					try {
						if (stringBuffer.length() > 0)
							stringBuffer.delete(0, stringBuffer.length());
						stringBuffer
								.append("Select A.DFLT_INCOMPLETE_FS_LOCN_CODE,B.LOCN_IDENTITY,b.holder_name  from fm_parameter a,fm_storage_locn b  where a.facility_id = b.facility_id and DFLT_INCOMPLETE_FS_LOCN_CODE  = b.fs_locn_code and b.facility_id ='");
						stringBuffer.append(facilityId);
						stringBuffer.append("' ");
						pstmt = con.prepareStatement(stringBuffer.toString());
						rs = pstmt.executeQuery();

						if (rs != null && rs.next()) {
							dflt_incomplete_fs_locn_code = rs.getString(1);
							dflt_incomplete_fs_locn_identity = rs.getString(2);
							holder_name = rs.getString(3);
						}
						if (rs != null)
							rs.close();
						if (pstmt != null)
							pstmt.close();

						if (dflt_incomplete_fs_locn_code == null)
							dflt_incomplete_fs_locn_code = "";
						if (dflt_incomplete_fs_locn_identity == null)
							dflt_incomplete_fs_locn_identity = "";
						if (holder_name == null)
							holder_name = "";

						if (dflt_incomplete_fs_locn_code != "") {
							if (stringBuffer.length() > 0)
								stringBuffer.delete(0, stringBuffer.length());

							//stringBuffer.append("Select file_no, volume_no from fm_curr_locn where facility_id = '");
							//stringBuffer.append(facilityId);
							//stringBuffer.append("' and patient_id = '");
							//stringBuffer.append(p_patient_id);
							//stringBuffer.append("'");


							stringBuffer
									.append("Select file_no, volume_no, CURR_FS_LOCN_CODE from fm_curr_locn where facility_id = '");
							stringBuffer.append(facilityId);
							stringBuffer.append("' and patient_id = '");
							stringBuffer.append(p_patient_id);
							stringBuffer.append("'");

							pstmt = con.prepareStatement(stringBuffer
									.toString());
							rs = pstmt.executeQuery();
							if (rs != null && rs.next()) {
								file_no = rs.getString(1);
								volume_no = rs.getString(2);
								curr_fs_locn_code = rs.getString(3);
							}

							if (rs != null)
								rs.close();
							if (pstmt != null)
								pstmt.close();

							if (file_no == null)
								file_no = "";
							if (volume_no == null)
								volume_no = "";

							if (stringBuffer.length() > 0)
								stringBuffer.delete(0, stringBuffer.length());

							stringBuffer.append("select DEST_FS_LOCN_CODE from fm_movement_log where facility_id='"+facilityId+"' and patient_id='"+p_patient_id+"' and file_no='"+file_no+"' and volume_no='"+volume_no+"' and added_date=(select max(added_date) from fm_movement_log where facility_id='"+facilityId+"' and patient_id='"+p_patient_id+"' and file_no='"+file_no+"' and volume_no='"+volume_no+"')");

							pstmt = con.prepareStatement(stringBuffer.toString());
							rs = pstmt.executeQuery();

							if (rs != null && rs.next()) {
								dest_fs_locn_code = rs.getString("DEST_FS_LOCN_CODE")==null?"":rs.getString("DEST_FS_LOCN_CODE");
							}

							stringBuffer.setLength(0);

							if (rs != null)
								rs.close();
							if (pstmt != null)
								pstmt.close();

							if (stringBuffer.length() > 0)
								stringBuffer.delete(0, stringBuffer.length());
							stringBuffer
									.append("Select b.MR_LOCATION_CODE,c.locn_identity from  fm_curr_locn a, op_clinic b,fm_storage_locn c  where a.curr_fs_locn_code = b.MR_LOCATION_CODE and a.facility_id = b.facility_id and a.curr_facility_id = c.facility_id and a.curr_fs_locn_code = c.fs_locn_code and a.facility_id ='");
							stringBuffer.append(facilityId);
							stringBuffer.append("' and a.file_no = '");
							stringBuffer.append(file_no);
							stringBuffer.append("' and a.volume_no = '");
							stringBuffer.append(volume_no);
							stringBuffer.append("' and b.clinic_code = '");
							stringBuffer.append(p_locn_code);
							stringBuffer.append("' ");

							pstmt = con.prepareStatement(stringBuffer
									.toString());
							rs = pstmt.executeQuery();

							if (rs != null && rs.next()) {
								fm_fs_locn_code = rs.getString(1);
								fm_fs_locn_identity = rs.getString(2);
							}

							stringBuffer.setLength(0);
							if (rs != null)
								rs.close();
							if (pstmt != null)
								pstmt.close();

							if (fm_fs_locn_code == null)
								fm_fs_locn_code = "";
							if (fm_fs_locn_identity == null)
								fm_fs_locn_identity = "";

							//if (fm_fs_locn_code != "") {

							if ( (!( dest_fs_locn_code == null || dest_fs_locn_code.equals("null") ) )&& 	  (curr_fs_locn_code.equals(dest_fs_locn_code) ))
							{

								sql16 = "insert into fm_movement_log(facility_id, file_no, sent_date_time, patient_id, src_facility_id, src_fs_locn_code, src_locn_identity, src_user_id, dest_facility_id, rec_date_time, dest_fs_locn_code, dest_locn_identity, dest_user_id, movement_type, src_mr_locn_yn, dest_mr_locn_yn, added_by_id, added_date, added_at_ws_no, added_facility_id, modified_by_id, modified_date, modified_at_ws_no, modified_facility_id,volume_no) values( ?,?,sysdate,?,?,?,?,?,?,sysdate,?,?,?,'F','N','N',?,sysdate,?,?,?,sysdate,?,?,?)";

								pstmt = con.prepareStatement(sql16);
								pstmt.setString(1, facilityId);
								pstmt.setString(2, file_no);
								pstmt.setString(3, p_patient_id);
								pstmt.setString(4, facilityId);
								pstmt.setString(5, fm_fs_locn_code);
								pstmt.setString(6, fm_fs_locn_identity);
								pstmt.setString(7, addedById);
								pstmt.setString(8, facilityId);
								pstmt
										.setString(9,
												dflt_incomplete_fs_locn_code);
								pstmt.setString(10,
										dflt_incomplete_fs_locn_identity);
								pstmt.setString(11, addedById);
								pstmt.setString(12, addedById);
								pstmt.setString(13, addedAtWorkstation);
								pstmt.setString(14, facilityId);
								pstmt.setString(15, addedById);
								pstmt.setString(16, addedAtWorkstation);
								pstmt.setString(17, facilityId);
								pstmt.setString(18, volume_no);
								res = pstmt.executeUpdate();
								if (res > 0) {
									flag = true;
								} else {
									flag = false;
									sb
											.append("Error in while insert into fm_movement_log");
								}

								if (pstmt != null)
									pstmt.close();

								if (flag) {
									if (stringBuffer.length() > 0)
										stringBuffer.delete(0, stringBuffer.length());

									stringBuffer.append("update fm_curr_locn set iss_date_time = sysdate, curr_facility_id =?,curr_file_status='O', curr_fs_locn_code=?, curr_fs_locn_identity=?, curr_holder_user_id=?, last_movement_date_time = sysdate,");
									stringBuffer.append("prev_facility_id=?, prev_fs_locn_code=?,");
									stringBuffer.append(" modified_by_id = ?, modified_date = sysdate, modified_at_ws_no = ?, modified_facility_id = ? where facility_id = ? and file_no =? and volume_no =?");

									pstmt = con.prepareStatement(stringBuffer
											.toString());
									pstmt.setString(1, facilityId);
									pstmt.setString(2,
											dflt_incomplete_fs_locn_code);
									pstmt.setString(3,
											dflt_incomplete_fs_locn_identity);
									pstmt.setString(4, holder_name);
									pstmt.setString(5, facilityId);
									pstmt.setString(6, fm_fs_locn_code);
									pstmt.setString(7, addedById);
									pstmt.setString(8, addedAtWorkstation);
									pstmt.setString(9, facilityId);
									pstmt.setString(10, facilityId);
									pstmt.setString(11, file_no);
									pstmt.setString(12, volume_no);
									res = pstmt.executeUpdate();
									if (res > 0) {
										flag = true;
									} else {
										flag = false;
										sb
												.append("Error in while update fm_curr_locn");
									}
									stringBuffer.setLength(0);
									if (pstmt != null)
										pstmt.close();
								}
							}
						}
					} catch (Exception exp) {
						
					}
				*/

				}
			}// fm_install

			if(flag) {
				try	{
					cs = con.prepareCall("{call MP_AUDIT_FUNCTION.UPDATE_ENCOUNTER(?,?,?,?,?,?,?)}");
					cs.setString(1, facilityId);
					cs.setLong(2, p_encounter_id);
					if (module_id.equals("AE")) {
						cs.setString(3, "EM");
					} else {
						cs.setString(3, "OP");
					}  					
					cs.setString(4, p_patient_id);
					cs.setString(5, "07");
					cs.setString(6,modifiedById );
					cs.setString(7, modifiedAtWorkstation);
					cs.execute();
				} catch (Exception e) {
					e.printStackTrace();
					flag = false;
					sb.append("Error in call MP_AUDIT_FUNCTION.UPDATE_ENCOUNTER... ");
				}
			}

			try {
				if (strBLInstallYN.equalsIgnoreCase("Y")) {
					if (flag) {
						if (pract_assigned_yn.equals("Y")) {
							try {

								String sqlbl = "{call BL_UPDATE_VISIT_FOR_PHYSICIAN(?,?,?,?,?,?,?,?)}";
								cs = con.prepareCall(sqlbl);
								cs.setString(1, facilityId);
								cs.setString(2, p_patient_id);
								cs.setString(3, episode_id);
								cs.setString(4, episode_visit_num);
								cs.setString(5, x_attending_practitioner);
								cs.registerOutParameter(6,
										java.sql.Types.VARCHAR);
								cs.registerOutParameter(7,
										java.sql.Types.VARCHAR);
								cs.registerOutParameter(8,
										java.sql.Types.VARCHAR);


								cs.execute();

								String err_lev = cs.getString(6);
								if (err_lev == null)
									err_lev = "";

								String err_val = cs.getString(8);
								if (err_val == null)
									err_val = "";
								if (err_val.equalsIgnoreCase("")) {
									flag = true;
								} else {
									con.rollback();
									flag = false;
									sb.append(err_val);
								}
								if (cs != null)
									cs.close();
							} catch (Exception e1) {
								sb.append(e1.toString()
										+ ":BL_UPDATE_VISIT_FOR_PHYSICIAN");
							}
							if (cs != null)
								cs.close();
						}
						if (module_id.equals("AE")) {
							episode_type = "E";
						} else {
							episode_type = "O";
						}

						Hashtable hashtableBL = new Hashtable();

						hashtableBL.put("module_id", module_id);
						hashtableBL.put("episode_type", episode_type);
						hashtableBL.put("facility_id", facilityId);
						hashtableBL.put("patient_id", p_patient_id);
						hashtableBL.put("p_locn_type", p_locn_type);
						hashtableBL.put("p_locn_code", p_locn_code);
						hashtableBL.put("p_encounter_id", "" + p_encounter_id);
						hashtableBL.put("episode_id", episode_id);
						hashtableBL.put("visit_id", episode_visit_num);
						hashtableBL.put("login_user", addedById);
						hashtableBL
								.put("client_ip_address", addedAtWorkstation);
						hashtableBL.put("p_practitioner_id", p_practitioner_id);
						hashtableBL.put("x_conclude_episode_start_date",
								x_conclude_episode_start_date);
						hashtableBL.put("x_conclude_episode_end_date",
								x_conclude_episode_end_date);
						hashtableBL.put("pract_assigned_yn", pract_assigned_yn);
						hashtableBL.put("concluded_yn", concluded_yn);
						hashtableBL.put("addedFacilityId", addedFacilityId);
						hashtableBL.put("addedAtWorkstation",
								addedAtWorkstation);
						hashtableBL.put("prn_visit_yn", prn_visit_yn);
						hashtableBL.put("prn_visit_before", prn_visit_before);
						hashtableBL.put("ae_treatment_area_code",
								ae_treatment_area_code);
						hashtableBL.put("p_queue_date", p_queue_date);
						hashtableBL.put("SickLeaveRecordFlag",
								SickLeaveRecordFlag);
						hashtableBL.put("AuthorizedById", AuthorizedById);
						hashtableBL.put("remarks", remarks);
						hashtableBL.put("locale",locale );
						hashtableBL.put("function_id","CHECKOUT_VISIT" );
                        hashtableBL.put("fin_dtls", tabdata.get("fin_dtls"));
						hashtableBL.put("visit_type_code", tabdata.get("visit_type_code"));
						/*
						Scrum related crf-362 added for AE bed calculation
						*/
						hashtableBL.put("ae_treatment_area_code", tabdata.get("ae_treatment_area_code"));

						BLOPCheckOut blCheckout = new BLOPCheckOut();

						Hashtable resultsBL = blCheckout.billPatientService(p,
								con, hashtableBL);

						boolean boolBLStatus = ((Boolean) (resultsBL
								.get("status"))).booleanValue();
						flag = boolBLStatus;

						strBLMessage = (String) resultsBL.get("message");

						billgenlater = (String) (resultsBL.get("billgenlater"));
						billtotalamt = (String) (resultsBL.get("billtotalamt"));
						billdoctype = (String) (resultsBL.get("billdoctype"));
						billdocnum = (String) (resultsBL.get("billdocnum"));

						str_bill_prt_format_YN = (String)(resultsBL.get("bill_prt_format_YN"));
						str_bill_prt_format_vals = (String)(resultsBL.get("bill_prt_format_vals"));
						pgm_id = (String)(resultsBL.get("pgm_id"));
						session_id = (String)(resultsBL.get("session_id"));
						pgm_date = (String)(resultsBL.get("pgm_date"));
						mpi_id_rep = (String)(resultsBL.get("mpi_id_rep"));

						if (boolBLStatus == false) {
							sb.append((String) resultsBL.get("error"));
						}
						if (boolBLStatus == true) {
							if (strBLMessage != null) {
								if ((strBLMessage.trim().equals(""))) {
								}
							} else {
								strBLMessage = "0";
							}
						}
						hashtableBL.clear();
						resultsBL.clear();
					}
				}
			} catch (Exception exceptionBL) {
				flag = false;
				sb.append(" Error in BL " + exceptionBL.toString());
				exceptionBL.printStackTrace();
			}
			tabdata.clear();

			if (flag) {
				result = true;
				con.commit();
				con.setAutoCommit(true);
				java.util.Hashtable message = MessageManager.getMessage(locale,
						"RECORD_MODIFIED", "SM");
				sb.append((String) message.get("message"));

				message.clear();
			} else {
				con.rollback();
				flag = false;
				result = false;
			}
			/*Below line added for this  HSA-CRF-0306.1*/
			boolean siteSpecific=CommonBean.isSiteSpecific(con,"FM","CURRENT_FS_LOCATION");
			
			if(siteSpecific){
			/*String fileno="";
			String SqlString="select file_no from pr_encounter where facility_id = ? and encounter_id = ? and discharge_date_time is not null";
						
			pstmt = con.prepareStatement(SqlString);
			pstmt.setString(1, facilityId);
			pstmt.setLong(2, p_encounter_id);
			rest=pstmt.executeQuery();
			if(rest!=null && rest.next()){
			  fileno=rest.getString(1)==null?"":rest.getString(1);
			 }
			 
			 System.err.println("p_locn_code===>"+p_locn_code);
			 
			 System.err.println("currencounterid===>"+currencounterid);
			 System.err.println("p_locn_code===>"+p_patient_id);
			 System.err.println("p_locn_code===>"+p_locn_code);
			  		
			 if (rest != null)rest.close();
			 if (pstmt != null)pstmt.close();
              if(siteSpecific && !fileno.equals(""))*/	
            
			 //int currencounterid=Integer.parseInt(encounter_id);
			 //System.err.println("PatCheckoutManager.java currencounterid===>"+currencounterid);
			
			  
                cstmt = con.prepareCall("{call sm_day_return_date_proc(?,?,?,?,?,?,?,?)}");				
				cstmt.setString(1, "");
				cstmt.setString(2, facilityId);
				cstmt.setString(3, "DISCHARGE");
				cstmt.setString(4, "");	
                cstmt.setString(5, p_patient_id);	
                cstmt.setString(6, p_locn_code);
                //cstmt.setInt(7, currencounterid);	
                cstmt.setLong(7, p_encounter_id);				
				cstmt.registerOutParameter(8,java.sql.Types.VARCHAR);
				cstmt.execute();					
				errmsg=cstmt.getString(8); 
				
			}
           	
			//End HSA-CRF-0306.1
			if(cstmt!=null) cstmt.close();	//Added for checkstyle
			
		} catch (Exception e) {
			sb.append(e.toString() + "<br>");
			e.printStackTrace();
			try {
				con.rollback();
				flag = false;
			} catch (Exception ce) {
				sb.append(e.toString());
				sb.append(ce.toString() + "<br>");
				e.printStackTrace();
			}
		} finally {
			P_UPDATE.setLength(0);
			findSql.setLength(0);
			if (con != null) {
				try {
					if (con != null)
						ConnectionManager.returnConnection(con, p);
				} catch (Exception ee) {
					try {
						con.rollback();
						flag = false;
					} catch (Exception ce) {
					}
				}
			}
		}// finally
		results.put("status", new Boolean(result));
		results.put("error", sb.toString());
		results.put("bl_message", strBLMessage);
		results.put("sl_ref_no", sl_ref_no);
		results.put("billgenlater", billgenlater);
		results.put("billtotalamt", billtotalamt);
		results.put("billdoctype", billdoctype);
		results.put("billdocnum", billdocnum);

		results.put("bill_prt_format_YN", str_bill_prt_format_YN);
		results.put("bill_prt_format_vals", str_bill_prt_format_vals);
		results.put("pgm_id", pgm_id);
		results.put("session_id", session_id);
		results.put("pgm_date", pgm_date);
		results.put("mpi_id_rep", mpi_id_rep);
		return results;
	}



	/**
	 *Method to insert single record
	 *@param properties Connection Properties
	 *@param hashaMap Record data
	 *@param as data for duplication check
	 *@param s Table Name
	 *@return HashMap holding the transaction details
	*/
	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/
	public java.util.HashMap updateCancelCheckout(java.util.Properties p,
			java.util.HashMap tabdata)

	{

		java.util.HashMap results = new java.util.HashMap();
		boolean result = false;
		String locale = p.getProperty("LOCALE");

		facilityId = (String) tabdata.get("facilityId");
		encounter_id = (String) tabdata.get("encounter_id");
		reasonCode = (String) tabdata.get("reasonCode");
		userId = (String) tabdata.get("userId");
		remarks = (String) tabdata.get("remarks");
		addedAtWorkstation = (String) tabdata.get("client_ip_address");

		strBLInstallYN = (String) tabdata.get("bl_install_yn");
		p_patient_id = (String) tabdata.get("p_patient_id");
		p_episode_type = (String) tabdata.get("p_episode_type");
		p_visit_id = (String) tabdata.get("p_visit_id");
		p_episode_id = (String) tabdata.get("p_episode_id");

		bed_no = (String) tabdata.get("bed_no");
    	String deceased_yn =  (String) tabdata.get("deceased_yn");		
		module_id =  (String) tabdata.get("module_id");
		multi_speciality_yn =  (String) tabdata.get("multi_speciality_yn");//Added for the CRF - Bru-HIMS-CRF-0198

		String visit_type_ind =  (String) tabdata.get("visit_type_ind");
		String appt_ref_no =  (String) tabdata.get("appt_ref_no");
		String alcn_criteria =  "";
		String forced_appt_yn =  (String) tabdata.get("forced_appt_yn");
		String pat_cat = (String) tabdata.get("pat_cat");
		String referral_value = (String) tabdata.get("referral_value");
		String oaresult = "";
		String oacnt = (String) tabdata.get("oacnt");

		String addedById = p.getProperty("login_user");
		//String addedDate = dateFormat.format(new java.util.Date());
		String modifiedById = addedById;
		String modifiedFacilityId = facilityId;
		String modifiedAtWorkstation = addedAtWorkstation;
		
		//Added by Jeyachitra - ML-MMOH-CRF 1742
		HashMap<String, String> prev_RecDiag_Data = new HashMap<String, String>();
		HashMap<String, String> curr_RecDiag_Data = new HashMap<String, String>();
		
		StringBuffer sb = new StringBuffer("");
		long p_encounter_id;

		try
		{
			con = ConnectionManager.getConnection(p);
			con.setAutoCommit(false);
			//boolean isForAdmission = CommonBean.isSiteSpecific(con, "AE", "AE_FOR_ADMISSION_TAB");//Added by Kamatchi S for ML-MMOH-CRF-1972

			isDeceasedDiagClassDeathRegAppl = eCommon.Common.CommonBean.isSiteSpecific(con,"MR","DECEASED_DIAG_CLASS_DEATH_REG");//Added by Ashwini on 22-Oct-2024 for ML-MMOH-CRF-1742

			p_encounter_id = (Long.valueOf(encounter_id)).longValue();
			findSql.setLength(0);
			P_UPDATE.setLength(0);

			//Added by Ashwini on 22-Oct-2024 for ML-MMOH-CRF-1742
			if(isDeceasedDiagClassDeathRegAppl){
				String sqlpatid = " SELECT deceased_yn, to_char(deceased_date,'dd/mm/yyyy hh24:mi:ss') deceased_date FROM mp_patient WHERE patient_id = ? ";

				prstmt = con.prepareStatement(sqlpatid);
				prstmt.setString(1,p_patient_id);
				rsset = prstmt.executeQuery();

				if(rsset!=null && rsset.next()){
					deceased_yn	= rsset.getString("deceased_yn")==null?"N":rsset.getString("deceased_yn");
					deceased_date = rsset.getString("deceased_date")==null?"":rsset.getString("deceased_date");
				}

				if(rsset != null) rsset.close();
				if(prstmt != null) prstmt.close();
			}

				findSql.append("UPDATE PR_ENCOUNTER set VISIT_STATUS = PREV_VISIT_STATUS , CANCEL_CHECKOUT_REMARKS = ?, CANCEL_DISCH_DATE = sysdate, CANCEL_CHECKOUT_BY_ID = ?, CANCEL_CHECKOUT_REASON_CODE = ?, MODIFIED_BY_ID = ?, MODIFIED_DATE = sysdate,  MODIFIED_FACILITY_ID = ?, MODIFIED_AT_WS_NO = ?, ASSIGN_BED_NUM = ?, DECEASED_DATE_TIME=PREV_DECEASED_DATE_TIME,DISPOSITION_TYPE=NULL,RECALL_YN='N',RECALL_DATE=NULL,DISCHARGE_DATE_TIME=NULL,BODY_RELEASE_DATE_TIME=NULL, DISCH_PRACTITIONER_ID=NULL,  CIRCUMSTANCE_OF_INJURY_CODE=NULL, MEDICAL_YN='N', SURGICAL_YN='N', MLC_YN=PREV_MLC_YN, PM_YN=PREV_PM_YN, HIGH_RISK_YN='N', BROUGHT_DEAD_YN=PREV_BROUGHT_DEAD_YN, VISIT_STATUS_SET_BY_USER = ?, VISIT_STATUS_SET_ON_DATE = sysdate,RECALL_REASON_CODE = NULL, DID_YN = PREV_DID_YN WHERE FACILITY_ID = ? AND ENCOUNTER_ID = ?");



				pstmt = con.prepareStatement(findSql.toString());
				pstmt.setString(1, remarks);
				pstmt.setString(2, userId);
				pstmt.setString(3, reasonCode);
				pstmt.setString(4, modifiedById);
				pstmt.setString(5, modifiedFacilityId);
				pstmt.setString(6, modifiedAtWorkstation);
				pstmt.setString(7, bed_no);
				pstmt.setString(8, modifiedById);
				pstmt.setString(9, facilityId);
				pstmt.setLong(10, p_encounter_id);


				int res10 = pstmt.executeUpdate();

				if (pstmt != null)
					pstmt.close();

				if (res10 != 0) {
					flag = true;
				} else {

					con.rollback();
					flag = false;
				}
				if (findSql.length() > 0)
					findSql.delete(0, findSql.length());

				if(flag)
				{
					
					P_UPDATE.append("UPDATE OP_PATIENT_QUEUE set QUEUE_STATUS = PREV_VISIT_STATUS, CANCEL_CHECKOUT_REMARKS = ?, CANCEL_CHECKOUT_DATE = sysdate, CANCEL_CHECKOUT_BY_ID = ?, CANCEL_CHECKOUT_REASON_CODE = ?, MODIFIED_BY_ID = ?, MODIFIED_DATE = sysdate, MODIFIED_FACILITY_ID = ?, MODIFIED_AT_WS_NO = ?, AE_BED_NO = ?,CONS_SRVC_END_DATE_TIME=NULL,BODY_RELEASE_DATE_TIME=NULL,DISCHARGE_DATE_TIME=NULL,DISPOSITION_TYPE=NULL,RECALL_YN='N',RECALL_DATE=NULL, RECALL_REASON_CODE=NULL, MEDICAL_YN='N',SURGICAL_YN='N',MLC_YN = PREV_MLC_YN,PM_YN = PREV_PM_YN, HIGH_RISK_YN='N',PRACTITIONER_ID=PREV_PRACTITIONER_ID,BROUGHT_DEAD_YN = PREV_BROUGHT_DEAD_YN,DECEASED_DATE_TIME = PREV_DECEASED_DATE_TIME, DID_YN = PREV_DID_YN WHERE FACILITY_ID = ? and ENCOUNTER_ID = ?");
					//below line commented bcoz if cancel AE check out done for the patient having status wating for admission its need to retain to  that state only but it go to consultation started status bcoz we updating null value in PENDNG_ADMISSION_DATE_TIME
					//P_UPDATE.append("UPDATE OP_PATIENT_QUEUE set QUEUE_STATUS = PREV_VISIT_STATUS, CANCEL_CHECKOUT_REMARKS = ?, CANCEL_CHECKOUT_DATE = sysdate, CANCEL_CHECKOUT_BY_ID = ?, CANCEL_CHECKOUT_REASON_CODE = ?, MODIFIED_BY_ID = ?, MODIFIED_DATE = sysdate, MODIFIED_FACILITY_ID = ?, MODIFIED_AT_WS_NO = ?, AE_BED_NO = ?,CONS_SRVC_END_DATE_TIME=NULL,BODY_RELEASE_DATE_TIME=NULL,DISCHARGE_DATE_TIME=NULL,DISPOSITION_TYPE=NULL,RECALL_YN='N',RECALL_DATE=NULL, RECALL_REASON_CODE=NULL, MEDICAL_YN='N',SURGICAL_YN='N',MLC_YN = PREV_MLC_YN,PM_YN = PREV_PM_YN, HIGH_RISK_YN='N',PRACTITIONER_ID=PREV_PRACTITIONER_ID,BROUGHT_DEAD_YN = PREV_BROUGHT_DEAD_YN,DECEASED_DATE_TIME = PREV_DECEASED_DATE_TIME, DID_YN = PREV_DID_YN ,PENDNG_ADMISSION_DATE_TIME=NULL WHERE FACILITY_ID = ? and ENCOUNTER_ID = ?");
					
				
					pstmt = con.prepareStatement(P_UPDATE.toString());
					pstmt.setString(1, remarks);
					pstmt.setString(2, userId);
					pstmt.setString(3, reasonCode);
					pstmt.setString(4, modifiedById);
					pstmt.setString(5, modifiedFacilityId);
					pstmt.setString(6, modifiedAtWorkstation);
					pstmt.setString(7, bed_no);
					pstmt.setString(8, facilityId);
					pstmt.setLong(9, p_encounter_id);



					int res11 = pstmt.executeUpdate();
					

					if (pstmt != null)
					pstmt.close();

					if (res11 != 0) {
						
					flag = true;
				} else {
					sb.append("UPDATE OP_PATIENT_QUEUE res=" + res11
								+ "rows updated");
					con.rollback();
					flag = false;
					
				}
				if (P_UPDATE.length() > 0)
					P_UPDATE.delete(0, P_UPDATE.length());


				} else {
				con.rollback();
				flag = false;
				
				}

				tabdata.clear();

				//below line commented bcoz if cancel AE check out done for the patient having status wating for admission its need to retain to  that state only but it go to consultation started status bcoz we updating null value in PENDNG_ADMISSION_DATE_TIME
				/*
				if(flag && isForAdmission && module_id.equals("AE"))
						{
						try {
						P_UPDATE.append("UPDATE AE_CURRENT_PATIENT SET  PENDNG_ADMISSION_DATE_TIME = NULL  WHERE FACILITY_ID = ? and ENCOUNTER_ID = ? ");
						pstmt = con.prepareStatement(P_UPDATE.toString());
						pstmt.setString(1, facilityId);
						pstmt.setLong(2, p_encounter_id);
						int res11 = pstmt.executeUpdate();
						if (pstmt != null)
						pstmt.close();
						if (res11 != 0) {
						flag = true;
						} 
						}
						catch(Exception e)
						{
						e.printStackTrace();
						}
						
						
						if (P_UPDATE.length() > 0)
					   P_UPDATE.delete(0, P_UPDATE.length());
						}*/

				if(flag)
				{

				//	P_UPDATE.append("UPDATE OP_EPISODE_FOR_SERVICE SET EPISODE_STATUS='01',LAST_VISIT_FU_REQD_YN='N', EPISODE_NOTES=NULL, END_DATE_TIME=NULL, MODIFIED_BY_ID =?, MODIFIED_DATE= sysdate, MODIFIED_AT_WS_NO =?, MODIFIED_FACILITY_ID=?  WHERE OPERATING_FACILITY_ID = '"+facilityId+"' AND EPISODE_ID = ? AND EPISODE_STATUS = '08'");


					P_UPDATE.append("UPDATE OP_EPISODE_FOR_SERVICE SET EPISODE_STATUS='01',LAST_VISIT_FU_REQD_YN='N', EPISODE_NOTES=NULL, END_DATE_TIME=NULL, MODIFIED_BY_ID =?, MODIFIED_DATE= sysdate, MODIFIED_AT_WS_NO =?, MODIFIED_FACILITY_ID=?  WHERE OPERATING_FACILITY_ID = '"+facilityId+"' AND EPISODE_ID = ? ");

					pstmt = con.prepareStatement(P_UPDATE.toString());

					pstmt.setString(1, modifiedById);
					pstmt.setString(2, modifiedAtWorkstation);
					pstmt.setString(3, modifiedFacilityId);
					pstmt.setInt(4, Integer.parseInt(p_episode_id));


					//int res14 = pstmt.executeUpdate();

					pstmt.executeUpdate();
					

					if (pstmt != null)
					pstmt.close();

					/*if (res14 != 0) {
					flag = true;
					} else {
					sb.append("UPDATE OP_EPISODE_FOR_SERVICE res=" + res14
								+ "rows updated");
					con.rollback();
					flag = false;
					}*/

					if (P_UPDATE.length() > 0)
					P_UPDATE.delete(0, P_UPDATE.length());


				}else {
				con.rollback();
				flag = false;
				
				}


				if(flag)
				{

					P_UPDATE.append("UPDATE OP_LAST_VISIT_FOR_SERVICE SET RECALL_DATE=NULL, RECALL_REASON=NULL,MODIFIED_BY_ID =?, MODIFIED_DATE= sysdate, MODIFIED_AT_WS_NO =?, MODIFIED_FACILITY_ID=? WHERE OPERATING_FACILITY_ID = '"+facilityId+"' AND ENCOUNTER_ID = ?");

					pstmt = con.prepareStatement(P_UPDATE.toString());


					pstmt.setString(1, modifiedById);
					pstmt.setString(2, modifiedAtWorkstation);
					pstmt.setString(3, modifiedFacilityId);
					pstmt.setLong(4, p_encounter_id);

					pstmt.executeUpdate();

					//int res15 = pstmt.executeUpdate();

					if (pstmt != null)
					pstmt.close();

					/*if (res15 != 0) {
					flag = true;
					} else {
					sb.append("UPDATE OP_LAST_VISIT_FOR_SERVICE res=" + res15
								+ "rows updated");
					con.rollback();
					flag = false;
					}*/

					if (P_UPDATE.length() > 0)
					P_UPDATE.delete(0, P_UPDATE.length());


				}else {
				con.rollback();
				flag = false;
				}

				if (deceased_yn.equalsIgnoreCase("Y"))
				{
					if(flag)
					{

					try {
						if (module_id.equals("AE")) {

							cs = con.prepareCall("{call MP_AUDIT_FUNCTION.ASSIGN_VALUE('AE_CANCEL_CHECKOUT')}");
						} else {

							cs = con.prepareCall("{call MP_AUDIT_FUNCTION.ASSIGN_VALUE('OP_CANCEL_CHECKOUT')}");
						}
						cs.execute();
						if (cs != null)
							cs.close();
					} catch (Exception e) {
						flag = false;
						sb.append("Procedure-MP_AUDIT_FUNCTION:"+ e.toString());
					}


						P_UPDATE.append("DELETE FROM MR_DEATH_REGISTER_DIAG_DTL WHERE  FACILITY_ID='"+facilityId+"' AND ENCOUNTER_ID= ?");

						pstmt = con.prepareStatement(P_UPDATE.toString());

						pstmt.setLong(1, p_encounter_id);

						//int res16 = pstmt.executeUpdate();
						
						pstmt.executeUpdate();
						

						if (pstmt != null)
						pstmt.close();


						if (P_UPDATE.length() > 0)
						P_UPDATE.delete(0, P_UPDATE.length());


						P_UPDATE.append("DELETE FROM MR_DEATH_REGISTER_HDR WHERE  FACILITY_ID='"+facilityId+"' AND ENCOUNTER_ID= ?");

						pstmt = con.prepareStatement(P_UPDATE.toString());
						pstmt.setLong(1, p_encounter_id);
						//int res17 = pstmt.executeUpdate();
						pstmt.executeUpdate();
						if (pstmt != null)
						pstmt.close();


						if (P_UPDATE.length() > 0)
						P_UPDATE.delete(0, P_UPDATE.length());


						//P_UPDATE.append("UPDATE MP_PATIENT A SET DECEASED_YN = 'N', ACTIVE_YN='Y' , DECEASED_DATE = NULL, MODIFIED_BY_ID =?, MODIFIED_DATE= sysdate, MODIFIED_AT_WS_NO =?, MODIFIED_FACILITY_ID=? WHERE  PATIENT_ID='"+p_patient_id+"' AND DECEASED_FACILITY_ID='"+facilityId+"' AND DECEASED_ENCOUNTER_ID= ? and (select prev_brought_dead_yn from pr_encounter where facility_id=a.DECEASED_FACILITY_ID and encounter_id=a.DECEASED_ENCOUNTER_ID)='N'");

						// Query modified for SRR20056-SCF-6253 IN025570 & SRR20056-SCF-6258 IN025583 on 20.12.2010 by Jithesh

						P_UPDATE.append("UPDATE MP_PATIENT A SET DECEASED_YN = 'N', ACTIVE_YN='Y' , DECEASED_DATE = NULL, MODIFIED_BY_ID =?, MODIFIED_DATE= sysdate, MODIFIED_AT_WS_NO =?, MODIFIED_FACILITY_ID=? WHERE  PATIENT_ID='"+p_patient_id+"'");
						
						pstmt = con.prepareStatement(P_UPDATE.toString());

						pstmt.setString(1, modifiedById);
						pstmt.setString(2, modifiedAtWorkstation);
						pstmt.setString(3, modifiedFacilityId);
						//pstmt.setLong(4, p_encounter_id);					
						

						int res18 = pstmt.executeUpdate();
						//pstmt.executeUpdate();
						
						if(res18 == 0){
							flag=false;
							sb.append("Error in call update MP_PATIENT ... ");
						}
						if (pstmt != null)
						pstmt.close();


						if (P_UPDATE.length() > 0)
						P_UPDATE.delete(0, P_UPDATE.length());





					}else {
						con.rollback();
						flag = false;
					}
				}




			//referral and waitlist
			if(flag)
				{
					P_UPDATE.append("UPDATE PR_REFERRAL_REGISTER SET STATUS='N', MODIFIED_BY_ID =?, MODIFIED_DATE= sysdate, MODIFIED_AT_WS_NO =?, MODIFIED_FACILITY_ID=? WHERE FROM_FACILITY_ID='"+facilityId+"' AND FROM_ENCOUNTER_ID= ? AND STATUS='O'");

					pstmt = con.prepareStatement(P_UPDATE.toString());

					pstmt.setString(1, modifiedById);
					pstmt.setString(2, modifiedAtWorkstation);
					pstmt.setString(3, modifiedFacilityId);
					pstmt.setLong(4, p_encounter_id);

					//int res12 = pstmt.executeUpdate();

					pstmt.executeUpdate();

					if (pstmt != null)
					pstmt.close();

					if (P_UPDATE.length() > 0)
					P_UPDATE.delete(0, P_UPDATE.length());



					P_UPDATE.append("UPDATE PR_WAIT_LIST SET WAIT_LIST_STATUS='C', MODIFIED_BY_ID =?, MODIFIED_DATE= sysdate, MODIFIED_AT_WS_NO =?, MODIFIED_FACILITY_ID=? WHERE FROM_FACILITY_ID='"+facilityId+"' AND FROM_ENCOUNTER_ID= ? AND WAIT_LIST_STATUS='O'");

					pstmt = con.prepareStatement(P_UPDATE.toString());

					pstmt.setString(1, modifiedById);
					pstmt.setString(2, modifiedAtWorkstation);
					pstmt.setString(3, modifiedFacilityId);
					pstmt.setLong(4, p_encounter_id);

					//int res13 = pstmt.executeUpdate();

					pstmt.executeUpdate();

					if (pstmt != null)
					pstmt.close();


					if (P_UPDATE.length() > 0)
					P_UPDATE.delete(0, P_UPDATE.length());



				}else {
				con.rollback();
				flag = false;
				}
				
				if(flag)
				{
					if(oacnt.equals("Y"))
					{
					String sqloa = "{call OA_CANCEL_APPOINTMENT(?,?,?,?,?,?,?,?,?,?,?,?)}";
					cs = con.prepareCall(sqloa);
					cs.setString(1, facilityId);
					cs.setString(2, appt_ref_no);
					cs.setString(3, visit_type_ind);
					cs.setString(4, reasonCode);
					cs.setString(5, alcn_criteria);
					cs.setString(6, pat_cat);
					cs.setString(7, modifiedFacilityId);
					cs.setString(8, modifiedAtWorkstation);
					cs.setString(9, forced_appt_yn);
					cs.setString(10, modifiedById);
					cs.registerOutParameter(11,Types.VARCHAR);
				//	cs.setString(12, referral_value);   Commented the code for IN025229 by Suresh M on 25.11.2010
					cs.setString(12,"N");
					cs.execute();

					oaresult=cs.getString(11);

					if (oaresult == null) {
							flag = true;
					}
					else {
						con.rollback();
						flag = false;
						sb.append(oaresult);
					}
					if (cs != null)
						cs.close();
				}
				}else {
				con.rollback();
				flag = false;
				}
				//CRF - 198 start
				// The status in PR_ENCOUNTER_JOINT_CONSULT will be updated to 'O' during cancel checkout
				if(flag && multi_speciality_yn.equals("Y")){
					
						P_UPDATE.append("UPDATE PR_ENCOUNTER_JOINT_CONSULT set status='O', ");
						P_UPDATE.append(" modified_by_id = ?, modified_date = sysdate, modified_facility_id = ?, modified_at_ws_no  = ? ");
						P_UPDATE.append(" where FACILITY_ID = ? and ENCOUNTER_ID = ? ");
						pstmt = con.prepareStatement(P_UPDATE.toString());
						
						pstmt.setString(1, modifiedById);
						
						pstmt.setString(2, modifiedFacilityId);
						pstmt.setString(3, modifiedAtWorkstation);
						
						pstmt.setString(4, facilityId);
						pstmt.setLong(5, p_encounter_id);


						int res2 = pstmt.executeUpdate();
						
						P_UPDATE.setLength(0);
						if (pstmt != null)
							pstmt.close();
					
				}
				//CRF - 198 End
				if(flag) {
				try	{
						cs = con.prepareCall("{call MP_AUDIT_FUNCTION.UPDATE_ENCOUNTER(?,?,?,?,?,?,?)}");
						cs.setString(1, facilityId);
						cs.setLong(2, p_encounter_id);
						if (module_id.equals("AE")) {
							cs.setString(3, "EM");
						} else {
							cs.setString(3, "OP");
						}  					
						cs.setString(4, p_patient_id);
						cs.setString(5, "04");
						cs.setString(6,modifiedById );
						cs.setString(7, modifiedAtWorkstation);
						cs.execute();
				    } catch (Exception e) {
						e.printStackTrace();
						flag = false;
						sb.append("Error in call updateCancelCheckout MP_AUDIT_FUNCTION.UPDATE_ENCOUNTER... ");
				    }
			}

			//INSERT INTO OA_APPT_DEL_TR/DELETE FROm OA_APPT

			//Added by Ashwini on 22-Oct-2024 for ML-MMOH-CRF-1742
			if(isDeceasedDiagClassDeathRegAppl){

				if(flag)
				{
					if(("Y").equals(deceased_yn)){
						
						String sqldiag = " SELECT * FROM pr_diagnosis_enc_dtl WHERE patient_id = ? AND encounter_id = ? AND facility_id = ? AND recorded_date_time >= to_date(?,'dd/mm/yyyy hh24:mi:ss') ";

						prstmt = con.prepareStatement(sqldiag);
						prstmt.setString(1,p_patient_id);
						prstmt.setLong(2,p_encounter_id);
						prstmt.setString(3,facilityId);
						prstmt.setString(4,deceased_date);
						rsset = prstmt.executeQuery();

						while(rsset.next()){
							
							term_set_id	= rsset.getString("term_set_id")==null?"":rsset.getString("term_set_id");
							term_code = rsset.getString("term_code")==null?"":rsset.getString("term_code");
							occur_srl_no = rsset.getString("occur_srl_no")==null?"":rsset.getString("occur_srl_no");

							if(!term_code.equals("")){

							if(sbsql.length() > 0)
								  sbsql.delete(0, sbsql.length());
							
							sbsql.append(" UPDATE pr_diagnosis SET curr_status = 'E', curr_remarks = 'Checkout Cancelled', modified_by_id = ?,  modified_date = sysdate, modified_facility_id = ?, modified_at_ws_no = ?  WHERE patient_id  = ? AND term_set_id = ? AND term_code = ? AND occur_srl_no = ? and curr_facility_id = ? and curr_encounter_id = ? ");
							
							updpstmt = con.prepareStatement( sbsql.toString() );
							updpstmt.setString	( 1, modifiedById ) ;
							updpstmt.setString	( 2, modifiedFacilityId ) ;
							updpstmt.setString	( 3, modifiedAtWorkstation ) ;
							updpstmt.setString	( 4, p_patient_id ) ;
							updpstmt.setString	( 5, term_set_id ) ;
							updpstmt.setString	( 6, term_code ) ;
							updpstmt.setString	( 7, occur_srl_no ) ;
							updpstmt.setString	( 8, facilityId ) ;
							updpstmt.setLong	( 9, p_encounter_id ) ;
							nResult = updpstmt.executeUpdate() ;
							
							if(nResult > 0)
								flag = true;
							else
								flag = false;

							if(updpstmt != null) updpstmt.close();

							if(flag){

								if(sbsql.length() > 0)
								  sbsql.delete(0, sbsql.length());
								
								sbsql.append(" UPDATE pr_diagnosis_enc_dtl SET status = 'E', remarks = 'Checkout Cancelled', modified_by_id = ?,  modified_date = sysdate, modified_facility_id = ?, modified_at_ws_no = ?  WHERE patient_id  = ? AND term_set_id = ? AND term_code = ? AND occur_srl_no = ? AND facility_id = ? AND encounter_id = ? ");
								
								updpstmt = con.prepareStatement( sbsql.toString() );
								updpstmt.setString	( 1, modifiedById ) ;
								updpstmt.setString	( 2, modifiedFacilityId ) ;
								updpstmt.setString	( 3, modifiedAtWorkstation ) ;
								updpstmt.setString	( 4, p_patient_id ) ;
								updpstmt.setString	( 5, term_set_id ) ;
								updpstmt.setString	( 6, term_code ) ;
								updpstmt.setString	( 7, occur_srl_no ) ;
								updpstmt.setString	( 8, facilityId ) ;
								updpstmt.setLong	( 9, p_encounter_id ) ;
								nResult = updpstmt.executeUpdate() ;
								
								if(nResult > 0)
									flag = true;
								else
									flag = false;

								if(updpstmt != null) updpstmt.close();
							}

							if(flag){

								if(sbsql.length() > 0)
								  sbsql.delete(0, sbsql.length());
								
								sbsql.append(" UPDATE pr_diagnosis_status SET status = 'E', remarks = 'Checkout Cancelled', modified_by_id = ?,  modified_date = sysdate, modified_facility_id = ?, modified_at_ws_no = ?  WHERE patient_id  = ? AND term_set_id = ? AND term_code = ? AND occur_srl_no = ? AND facility_id = ? AND encounter_id = ? ");
								
								updpstmt = con.prepareStatement( sbsql.toString() );
								updpstmt.setString	( 1, modifiedById ) ;
								updpstmt.setString	( 2, modifiedFacilityId ) ;
								updpstmt.setString	( 3, modifiedAtWorkstation ) ;
								updpstmt.setString	( 4, p_patient_id ) ;
								updpstmt.setString	( 5, term_set_id ) ;
								updpstmt.setString	( 6, term_code ) ;
								updpstmt.setString	( 7, occur_srl_no ) ;
								updpstmt.setString	( 8, facilityId ) ;
								updpstmt.setLong	( 9, p_encounter_id ) ;
								nResult = updpstmt.executeUpdate() ;
								
								if(nResult > 0)
									flag = true;
								else
									flag = false;

								if(updpstmt != null) updpstmt.close();
							}

							if(flag){

								String sqlaccnum = " SELECT accession_num_work_related FROM pr_diagnosis WHERE patient_id = ? AND term_set_id = ? AND term_code = ? AND occur_srl_no = ? AND curr_encounter_id = ? AND curr_facility_id = ? AND added_date >= to_date(?,'dd/mm/yyyy hh24:mi:ss') ";

								pstmtacc = con.prepareStatement(sqlaccnum);
								pstmtacc.setString(1,p_patient_id);
								pstmtacc.setString(2,term_set_id);
								pstmtacc.setString(3,term_code);
								pstmtacc.setString(4,occur_srl_no);
								pstmtacc.setLong(5,p_encounter_id);
								pstmtacc.setString(6,facilityId);
								pstmtacc.setString(7,deceased_date);
								rsacc = pstmtacc.executeQuery();

								if(rsacc!=null && rsacc.next()){
									
									accession_num_work_related = rsacc.getString("accession_num_work_related")==null?"":rsacc.getString("accession_num_work_related");

									if(!accession_num_work_related.equals("")){

										if(sbsql.length() > 0)
											  sbsql.delete(0, sbsql.length());
										
										sbsql.append(" UPDATE ca_encntr_note SET event_status = '9', event_status_caption = 'In Error', marked_in_error_by_id = ?, marked_in_error_date_time = SYSDATE, modified_by_id = ?, modified_date = SYSDATE, modified_at_ws_no = ?, modified_facility_id = ? WHERE accession_num = ? ");
										
										updpstmt = con.prepareStatement( sbsql.toString() );
										updpstmt.setString	( 1, modifiedById ) ;
										updpstmt.setString	( 2, modifiedById ) ;
										updpstmt.setString	( 3, modifiedAtWorkstation ) ;
										updpstmt.setString	( 4, modifiedFacilityId ) ;
										updpstmt.setString	( 5, accession_num_work_related ) ;
										nResult = updpstmt.executeUpdate() ;
										
										if(nResult > 0)
											flag = true;
										else
											flag = false;

										if(updpstmt != null) updpstmt.close();
									}
								}

								if(rsacc != null) rsacc.close();
								if(pstmtacc != null) pstmtacc.close();
							}
							}
						}

						if(rsset != null) rsset.close();
						if(prstmt != null) prstmt.close();

						if(flag){

							String sqlaudit = " SELECT DISTINCT term_set_id, term_code, occur_srl_no FROM mr_rec_diag_audit_trial WHERE patient_id = ? AND encounter_id = ? AND facility_id = ? AND added_date >= to_date (?, 'dd/mm/yyyy hh24:mi:ss') ";

							pstmtaud = con.prepareStatement(sqlaudit);
							pstmtaud.setString(1,p_patient_id);
							pstmtaud.setLong(2,p_encounter_id);
							pstmtaud.setString(3,facilityId);
							pstmtaud.setString(4,deceased_date);
							rsaud = pstmtaud.executeQuery();

							while(rsaud.next()){
								
								audit_term_set_id = rsaud.getString("term_set_id")==null?"":rsaud.getString("term_set_id");
								audit_term_code = rsaud.getString("term_code")==null?"":rsaud.getString("term_code");
								audit_occur_srl_no = rsaud.getString("occur_srl_no")==null?"":rsaud.getString("occur_srl_no");

								if(!audit_term_code.equals("")){

								String sqlauditatr = " SELECT attr_updated, prev_attr_value FROM mr_rec_diag_audit_trial t WHERE (t.attr_updated, t.added_date) IN ( SELECT attr_updated, MIN (added_date) FROM mr_rec_diag_audit_trial WHERE patient_id = ? AND encounter_id = ? AND facility_id = ? AND term_set_id = ? AND term_code = ? AND occur_srl_no = ? AND added_date >= TO_DATE (?, 'dd/mm/yyyy hh24:mi:ss') GROUP BY attr_updated) AND patient_id = ? AND encounter_id = ? AND facility_id = ? AND term_set_id = ? AND term_code = ? AND occur_srl_no = ? ";

								pstmtaudatr = con.prepareStatement(sqlauditatr);
								pstmtaudatr.setString(1,p_patient_id);
								pstmtaudatr.setLong(2,p_encounter_id);
								pstmtaudatr.setString(3,facilityId);
								pstmtaudatr.setString(4,audit_term_set_id);
								pstmtaudatr.setString(5,audit_term_code);
								pstmtaudatr.setString(6,audit_occur_srl_no);
								pstmtaudatr.setString(7,deceased_date);
								pstmtaudatr.setString(8,p_patient_id);
								pstmtaudatr.setLong(9,p_encounter_id);
								pstmtaudatr.setString(10,facilityId);
								pstmtaudatr.setString(11,audit_term_set_id);
								pstmtaudatr.setString(12,audit_term_code);
								pstmtaudatr.setString(13,audit_occur_srl_no);
								rsaudatr = pstmtaudatr.executeQuery();

								while(rsaudatr.next()){
									
									audit_attr_updated = rsaudatr.getString("attr_updated")==null?"":rsaudatr.getString("attr_updated");
									audit_prev_attr_value = rsaudatr.getString("prev_attr_value")==null?"":rsaudatr.getString("prev_attr_value");

									//getpreviousdata for audit trail Added by Jeyachitra for ML-MMOH-CRF-1742
									pstmtaudatr1 = con.prepareStatement( "SELECT a.term_code, a.diag_class_code, a.nature, a.severity, a.accuracy_code, a.priority, TO_CHAR(b.onset_date, 'dd/mm/yyyy hh24:mi') onset_date, a.enc_stage, TO_CHAR(b.curr_status_date, 'dd/mm/yyyy') status_date, a.status, a.remarks FROM pr_diagnosis_enc_dtl a, pr_diagnosis b WHERE a.patient_id = b.patient_id AND a.term_set_id = b.term_set_id AND a.term_code = b.term_code AND a.occur_srl_no = b.occur_srl_no AND a.patient_id = ? AND a.term_set_id = ? AND a.encounter_id = ? AND a.term_code = ? AND a.occur_srl_no = ? AND a.facility_id = ?" );	

									pstmtaudatr1.setString (1,p_patient_id);
									pstmtaudatr1.setString (2,audit_term_set_id);
									pstmtaudatr1.setLong (3,p_encounter_id);
									pstmtaudatr1.setString (4,audit_term_code);
									pstmtaudatr1.setString (5,audit_occur_srl_no);
									pstmtaudatr1.setString (6,facilityId);

									rsaudatr1 = pstmtaudatr1.executeQuery();

									if(rsaudatr1 != null && rsaudatr1.next())
									{
										prev_RecDiag_Data.put("Diagnosis_Code" ,checkForNull(rsaudatr1.getString("term_code")));
										prev_RecDiag_Data.put("Diagnosis_Classification",checkForNull(rsaudatr1.getString("diag_class_code")));
										prev_RecDiag_Data.put("Nature", checkForNull(rsaudatr1.getString("nature")));
										prev_RecDiag_Data.put("Severity", checkForNull(rsaudatr1.getString("severity")));
										prev_RecDiag_Data.put("Accuracy", checkForNull(rsaudatr1.getString("accuracy_code")));
										prev_RecDiag_Data.put("Priority", checkForNull(rsaudatr1.getString("priority")));
										prev_RecDiag_Data.put("Onset_Date", checkForNull(rsaudatr1.getString("onset_date")));
										prev_RecDiag_Data.put("Encounter_Stage", checkForNull(rsaudatr1.getString("enc_stage")));
										prev_RecDiag_Data.put("As_On_Date", checkForNull(rsaudatr1.getString("status_date")));
										prev_RecDiag_Data.put("Status", checkForNull(rsaudatr1.getString("status")));
										prev_RecDiag_Data.put("Diagnosis_Remarks", checkForNull(rsaudatr1.getString("remarks")));
									}
									
									if(rsaudatr1 != null) rsaudatr1.close();
									if(pstmtaudatr1 != null) pstmtaudatr1.close();

									if(audit_attr_updated.equals("Diagnosis_Classification") || audit_attr_updated.equals("Nature") || audit_attr_updated.equals("Severity") || audit_attr_updated.equals("Accuracy") || audit_attr_updated.equals("Priority") || audit_attr_updated.equals("Onset_Date") || audit_attr_updated.equals("Encounter_Stage") || audit_attr_updated.equals("As_On_Date") || audit_attr_updated.equals("Status") || audit_attr_updated.equals("Diagnosis_Remarks")){
					
									String current_attr_value = audit_prev_attr_value;
									
									for(Entry<String, String> k : prev_RecDiag_Data.entrySet())
									{
										String key = k.getKey();
										String prev_value = checkForNull(k.getValue());
											
										if(key.equalsIgnoreCase(audit_attr_updated))
										{
											pstmtaudatr1 = con.prepareStatement( "INSERT INTO mr_rec_diag_audit_trial (patient_id, term_set_id, term_code, occur_srl_no, facility_id, encounter_id, attr_updated, cur_attr_value, prev_attr_value, added_by_id, added_date, added_at_ws_no, added_facility_id, modified_by_id, modified_date, modified_at_ws_no, modified_facility_id ) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, SYSDATE, ?, ?, ?, SYSDATE, ?, ? )" );	
											pstmtaudatr1.setString (1,p_patient_id);
											pstmtaudatr1.setString (2,audit_term_set_id);
											pstmtaudatr1.setString (3,audit_term_code);
											pstmtaudatr1.setString (4,audit_occur_srl_no);
											pstmtaudatr1.setString (5,facilityId);
											pstmtaudatr1.setLong (6,p_encounter_id);
											pstmtaudatr1.setString (7,key);
											pstmtaudatr1.setString (8,current_attr_value);
											pstmtaudatr1.setString (9,prev_value);
											pstmtaudatr1.setString (10,addedById);
											pstmtaudatr1.setString (11,addedAtWorkstation);
											pstmtaudatr1.setString (12,facilityId);
											pstmtaudatr1.setString (13,modifiedById);
											pstmtaudatr1.setString (14,modifiedAtWorkstation);
											pstmtaudatr1.setString (15,facilityId);
											nResult = pstmtaudatr1.executeUpdate();

											if(nResult > 0)
												flag = true;
											else
												flag = false;
											
											if(pstmtaudatr1 != null) pstmtaudatr1.close();
										}
									}
									}

									if(flag){

									if(audit_attr_updated.equals("Diagnosis_Classification") || audit_attr_updated.equals("Nature") || audit_attr_updated.equals("Severity") || audit_attr_updated.equals("Accuracy") || audit_attr_updated.equals("Priority") || audit_attr_updated.equals("Onset_Date") || audit_attr_updated.equals("As_On_Date") || audit_attr_updated.equals("Status") || audit_attr_updated.equals("Diagnosis_Remarks")){

									if(audit_attr_updated.equals("Diagnosis_Classification"))
										attr_column_name = "diag_class_code";
									if(audit_attr_updated.equals("Nature"))
										attr_column_name = "curr_nature";
									if(audit_attr_updated.equals("Severity"))
										attr_column_name = "curr_severity";
									if(audit_attr_updated.equals("Accuracy"))
										attr_column_name = "curr_accuracy_code";
									if(audit_attr_updated.equals("Priority"))
										attr_column_name = "curr_priority";
									if(audit_attr_updated.equals("Onset_Date"))
										attr_column_name = "onset_date";
									if(audit_attr_updated.equals("As_On_Date"))
										attr_column_name = "curr_status_date";
									if(audit_attr_updated.equals("Status"))
										attr_column_name = "curr_status";
									if(audit_attr_updated.equals("Diagnosis_Remarks"))
										attr_column_name = "curr_remarks";
									
									if(sbsql.length() > 0)
										  sbsql.delete(0, sbsql.length());
									
									sbsql.append(" UPDATE pr_diagnosis SET "+attr_column_name+" = '"+audit_prev_attr_value+"', modified_by_id = ?,  modified_date = sysdate, modified_facility_id = ?, modified_at_ws_no = ?  WHERE patient_id  = ? AND term_set_id = ? AND term_code = ? AND occur_srl_no = ? and curr_facility_id = ? and curr_encounter_id = ? ");
									
									updpstmt = con.prepareStatement( sbsql.toString() );
									updpstmt.setString	( 1, modifiedById ) ;
									updpstmt.setString	( 2, modifiedFacilityId ) ;
									updpstmt.setString	( 3, modifiedAtWorkstation ) ;
									updpstmt.setString	( 4, p_patient_id ) ;
									updpstmt.setString	( 5, audit_term_set_id ) ;
									updpstmt.setString	( 6, audit_term_code ) ;
									updpstmt.setString	( 7, audit_occur_srl_no ) ;
									updpstmt.setString	( 8, facilityId ) ;
									updpstmt.setLong	( 9, p_encounter_id ) ;
									nResult = updpstmt.executeUpdate() ;
									
									if(nResult > 0)
										flag = true;
									else
										flag = false;

									if(updpstmt != null) updpstmt.close();
									
									}
									}

									if(flag){

									if(audit_attr_updated.equals("Diagnosis_Classification") || audit_attr_updated.equals("Nature") || audit_attr_updated.equals("Severity") || audit_attr_updated.equals("Accuracy") || audit_attr_updated.equals("Priority") || audit_attr_updated.equals("Encounter_Stage") || audit_attr_updated.equals("As_On_Date") || audit_attr_updated.equals("Status") || audit_attr_updated.equals("Diagnosis_Remarks")){

									if(audit_attr_updated.equals("Diagnosis_Classification"))
										attr_column_name = "diag_class_code";
									if(audit_attr_updated.equals("Nature"))
										attr_column_name = "nature";
									if(audit_attr_updated.equals("Severity"))
										attr_column_name = "severity";
									if(audit_attr_updated.equals("Accuracy"))
										attr_column_name = "accuracy_code";
									if(audit_attr_updated.equals("Priority"))
										attr_column_name = "priority";
									if(audit_attr_updated.equals("Encounter_Stage"))
										attr_column_name = "enc_stage";
									if(audit_attr_updated.equals("As_On_Date"))
										attr_column_name = "status_date";
									if(audit_attr_updated.equals("Status"))
										attr_column_name = "status";
									if(audit_attr_updated.equals("Diagnosis_Remarks"))
										attr_column_name = "remarks";
									
									if(sbsql.length() > 0)
										  sbsql.delete(0, sbsql.length());
									
									sbsql.append(" UPDATE pr_diagnosis_enc_dtl SET "+attr_column_name+" = '"+audit_prev_attr_value+"', modified_by_id = ?,  modified_date = sysdate, modified_facility_id = ?, modified_at_ws_no = ?  WHERE patient_id  = ? AND term_set_id = ? AND term_code = ? AND occur_srl_no = ? and facility_id = ? and encounter_id = ? ");
									
									updpstmt = con.prepareStatement( sbsql.toString() );
									updpstmt.setString	( 1, modifiedById ) ;
									updpstmt.setString	( 2, modifiedFacilityId ) ;
									updpstmt.setString	( 3, modifiedAtWorkstation ) ;
									updpstmt.setString	( 4, p_patient_id ) ;
									updpstmt.setString	( 5, audit_term_set_id ) ;
									updpstmt.setString	( 6, audit_term_code ) ;
									updpstmt.setString	( 7, audit_occur_srl_no ) ;
									updpstmt.setString	( 8, facilityId ) ;
									updpstmt.setLong	( 9, p_encounter_id ) ;
									nResult = updpstmt.executeUpdate() ;
									
									if(nResult > 0)
										flag = true;
									else
										flag = false;

									if(updpstmt != null) updpstmt.close();
									
									}
									}

									if(flag){

									if(audit_attr_updated.equals("Nature") || audit_attr_updated.equals("Severity") || audit_attr_updated.equals("Accuracy") || audit_attr_updated.equals("Priority") || audit_attr_updated.equals("As_On_Date") || audit_attr_updated.equals("Status") || audit_attr_updated.equals("Diagnosis_Remarks")){

									if(audit_attr_updated.equals("Nature"))
										attr_column_name = "nature";
									if(audit_attr_updated.equals("Severity"))
										attr_column_name = "severity";
									if(audit_attr_updated.equals("Accuracy"))
										attr_column_name = "accuracy_code";
									if(audit_attr_updated.equals("Priority"))
										attr_column_name = "priority";
									if(audit_attr_updated.equals("As_On_Date"))
										attr_column_name = "status_date";
									if(audit_attr_updated.equals("Status"))
										attr_column_name = "status";
									if(audit_attr_updated.equals("Diagnosis_Remarks"))
										attr_column_name = "remarks";
									
									if(sbsql.length() > 0)
										  sbsql.delete(0, sbsql.length());
									
									sbsql.append(" UPDATE pr_diagnosis_status SET "+attr_column_name+" = '"+audit_prev_attr_value+"', modified_by_id = ?,  modified_date = sysdate, modified_facility_id = ?, modified_at_ws_no = ?  WHERE patient_id  = ? AND term_set_id = ? AND term_code = ? AND occur_srl_no = ? and facility_id = ? and encounter_id = ? ");

									updpstmt = con.prepareStatement( sbsql.toString() );
									updpstmt.setString	( 1, modifiedById ) ;
									updpstmt.setString	( 2, modifiedFacilityId ) ;
									updpstmt.setString	( 3, modifiedAtWorkstation ) ;
									updpstmt.setString	( 4, p_patient_id ) ;
									updpstmt.setString	( 5, audit_term_set_id ) ;
									updpstmt.setString	( 6, audit_term_code ) ;
									updpstmt.setString	( 7, audit_occur_srl_no ) ;
									updpstmt.setString	( 8, facilityId ) ;
									updpstmt.setLong	( 9, p_encounter_id ) ;
									nResult = updpstmt.executeUpdate() ;
									
									if(nResult > 0)
										flag = true;
									else
										flag = false;

									if(updpstmt != null) updpstmt.close();
									
									}
									}
								}

								if(rsaudatr != null) rsaudatr.close();
								if(pstmtaudatr != null) pstmtaudatr.close();
							}
							}

							if(rsaud != null) rsaud.close();
							if(pstmtaud != null) pstmtaud.close();
						}
					}
				}
			}

				try {
				if (strBLInstallYN.equalsIgnoreCase("Y")) {
					if (flag) {
						try
						{
						String sqlbl = "{call BLVISITCANCEL.Revert_charges_for_Checkout(?,?,?,?,?,?,?,?,?,?,?)}";
						cs = con.prepareCall(sqlbl);
						cs.setString(1, facilityId);
						cs.setString(2, p_patient_id);
						cs.setInt(3, Integer.parseInt(p_episode_id));
						cs.setInt(4, Integer.parseInt(p_visit_id));
						cs.setString(5, p_episode_type);
						cs.setLong(6, p_encounter_id);
						cs.setString(7, userId);
						cs.setString(8, modifiedAtWorkstation);
						cs.registerOutParameter(9,java.sql.Types.VARCHAR);
						cs.registerOutParameter(10,java.sql.Types.VARCHAR);
						cs.registerOutParameter(11,java.sql.Types.VARCHAR);
						cs.execute();

						String err_lev = cs.getString(9);
						String err_txt = cs.getString(11);
						String sys_msg_id = cs.getString(10); 

						if (err_lev == null)
							err_lev = "";

						if (err_txt == null)
							err_txt = "";

						if (sys_msg_id == null)
							sys_msg_id = "";


						if (sys_msg_id.equalsIgnoreCase("")) {
							flag = true;
						} else {
							con.rollback();
							flag = false;
							java.util.Locale loc = new java.util.Locale(locale);
							java.util.ResourceBundle messages = java.util.ResourceBundle.getBundle("eBL.resources.Messages",loc);
							String blmessage = (String) messages.getString(sys_msg_id);
							sb.append(blmessage);
						}
						if(flag)
						{
						if (err_txt.equalsIgnoreCase("") && !err_lev.equals("10")) {
							flag = true;
						} else {
							con.rollback();
							flag = false;
							sb.append(err_txt);
						}
						}else
						{
							con.rollback();
							flag = false;
						}

						if (cs != null)
							cs.close();

						} catch (Exception e1) {
								sb.append(e1.toString()
										+ ":BLVISITCANCEL");
							}
							if (cs != null)
								cs.close();


					}
				  }
				}catch (Exception exceptionBL) {
				flag = false;
				sb.append(" Error in BL " + exceptionBL.toString());
				}
				tabdata.clear();

				if (flag) {
				result = true;
				con.commit();
				con.setAutoCommit(true);
				java.util.Hashtable message = MessageManager.getMessage(locale,
						"RECORD_MODIFIED", "SM");
				sb.append((String) message.get("message"));

				message.clear();
				}
				 else {
				con.rollback();
				flag = false;
				result = false;
				}

		} catch (Exception e) {
			sb.append(e.toString() + "<br>");
			e.printStackTrace();

			try {
				con.rollback();
				flag = false;
			} catch (Exception ce) {
				sb.append(e.toString());
				sb.append(ce.toString() + "<br>");
				e.printStackTrace();
			}
		 } finally {
			P_UPDATE.setLength(0);
			findSql.setLength(0);
			if (con != null) {
				try {
					if (con != null)
						ConnectionManager.returnConnection(con, p);
				} catch (Exception ee) {
					try {
						con.rollback();
						flag = false;
					} catch (Exception ce) {
					}
				}
			}
		}// finally

		results.put("status", new Boolean(result));
		results.put("error", sb.toString());
		return results;

	}

	public static String checkForNull(String inputString)
	{
		return ( ((inputString == null) || (inputString.equals("null"))) ? "" : inputString );
	}
	public static String checkForDefault(String inputString, String defaultValue){
		return(((inputString == null) || (inputString.equals("null")) ) ? defaultValue : inputString);
	}
}
