/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eOP.VisitRegistration; 

import java.sql.*;
import javax.naming.*;
import javax.rmi.*;
import java.rmi.RemoteException;
import javax.ejb.*;
import java.util.*;
import java.sql.*;
import blopin.*;
import webbeans.eCommon.*;
import eCommon.Common.*;


/**
*
* @ejb.bean
*	name="VisitRegistration"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="VisitRegistration"
*	local-jndi-name="VisitRegistration"
*	impl-class-name="eOP.VisitRegistration.VisitRegistrationManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eOP.VisitRegistration.VisitRegistrationLocal"
*	remote-class="eOP.VisitRegistration.VisitRegistrationRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eOP.VisitRegistration.VisitRegistrationLocalHome"
*	remote-class="eOP.VisitRegistration.VisitRegistrationHome"
*	generate= "local,remote"
*
*
*/


public class VisitRegistrationManager implements SessionBean {

	//Connection con;

	//PreparedStatement stmt;

	//PreparedStatement stmtc;

	//PreparedStatement stmt2;

	//CallableStatement statement;

	//CallableStatement cstmt = null;

	//PreparedStatement pstmt;

	//Statement st = null;

	SessionContext ctx;

	//ResultSet rs = null;

	//ResultSet rs1 = null;

	//ResultSet rs2 = null;

	//ResultSet rset = null;

	
	/*The below variables are moved from class level variable to local level variable
	boolean insertable = false;

	String locale = "";

	String encounterid = ""; */

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

	public java.util.HashMap insert(Properties p, HashMap tabdata,
			HashMap prencounter, HashMap prencounterdetail, Hashtable tabdata1,
			Hashtable prencounter1, Hashtable prencounterdetail1) {

		Connection con = null;
		PreparedStatement stmt = null;
		CallableStatement cstmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ResultSet rset = null;
		
		String 	encounterid 	= "";
		boolean 	insertable 		= false;
		String 	locale 			= "";
		 String smartCardFunc	= "";//Maheshwaran K added for AAKH-CRF-0175 as on 23-08-2023
		String vst_regn_date_time = (String) tabdata.get("vst_regn_date_time"); 
		String isPractoApptYn = (String) tabdata.get("isPractoApptYn"); 
		String self_chkin_appt_yn = (String) tabdata.get("self_chkin_appt_yn"); //Added by Dharma on 24th Feb 2020 against MO-CRF-20155
		String isAllowRegForSameService = (String) tabdata.get("isAllowRegForSameService");

		//Added by Ashwini on 23-Sep-2022 for TH-KW-CRF-0020.1
		String isQMSInOPVisitRegAppl = (String) tabdata.get("isQMSInOPVisitRegAppl");
		String common_queue_status = (String) tabdata.get("common_queue_status");
		String common_queue_status_msg = (String) tabdata.get("common_queue_status_msg");
		String common_queue_id = (String) tabdata.get("common_queue_id");
		String common_queue_no = (String) tabdata.get("common_queue_no");
		String common_queue_issue_dt_tm = (String) tabdata.get("common_queue_issue_dt_tm");
		String common_queue_called_dt_tm = (String) tabdata.get("common_queue_called_dt_tm");
		String virtual_queue_status = (String) tabdata.get("virtual_queue_status");
		String virtual_queue_status_msg = (String) tabdata.get("virtual_queue_status_msg");
		String virtual_queue_id = (String) tabdata.get("virtual_queue_id");
		String virtual_queue_no = (String) tabdata.get("virtual_queue_no");
		String virtual_queue_issue_dt_tm = (String) tabdata.get("virtual_queue_issue_dt_tm");
		String virtual_queue_called_dt_tm = (String) tabdata.get("virtual_queue_called_dt_tm");

		locale = p.getProperty("LOCALE");
		String refferal_id = (prencounter.get("referral_id") == null ? "": (String) prencounter.get("referral_id"));
		
		//Added for this CRF GDOH-CRF-0129
		String referral_toid="";
		String assigncare_loctype_ind = (String) prencounter.get("assigncare_loctype_ind");
		String assigncare_locacode = (String) prencounter.get("assigncare_locacode");
		Boolean isReferral =false; 		
		
		//End GDOH-CRF-0129
		
		String form60_YN= (String) prencounter.get("form60_YN"); //Added by Sangeetha for KDAH-CRF-0347 on 14/apr/17

		String other_remarks = (String) prencounter.get("other_remarks"); //Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114
		
		StringBuffer sb = new StringBuffer("");
		java.util.HashMap results = new java.util.HashMap();
		boolean result = false;
		String billdoctype = "";
		String billdocnum = "";
		String billgenlater = "";
		String billtotalamt = "";
		String strMessage = "0";
		String episodeno = "";
		String visitnum = "";
		ArrayList packageseqno = new ArrayList();//added for package billing
		String package_enabled_yn="";
		String pkg_codes_for_disc="";

		String str_bill_prt_format_YN = "N";
		String str_bill_prt_format_vals = "";
		String pgm_id ="";
		String session_id ="";
		String pgm_date ="";
		String mpi_id_rep = "";
		String multi_speciality_yn = "N";//Added for the CRF Bru-HIMS-CRF-0198

		try {

			//Set enum01 = tabdata.keySet();
			//Iterator objiterator = enum01.iterator();
			//String fields = "";
			String ws_no = p.getProperty("client_ip_address");

			String appt_status = "";
			String appt_time = "";
			String request_id = "";


			if (ws_no == null)
				ws_no = "";

			int cnt = 0;
			int count1 = 0;//Added for ML-MMOH-SCF-1981 by Kamatchi S 
			int count2 = 0;//Added for ML-MMOH-SCF-1981 by Kamatchi S

			con = ConnectionManager.getConnection(p);

			con.setAutoCommit(false);
			//int numoffields = 0;
			smartCardFunc	= CommonBean.isSiteSpecificforBiometric(con);//Maheshwaran K added for AAKH-CRF-0175 as on 23-08-2023
            /*Below line added for this CRF GDOH-CRF-0129*/
			isReferral=CommonBean.isSiteSpecific(con, "IP","REGISTER_REFERRAL");
		    if(isReferral && !assigncare_loctype_ind.equals("")){
		        referral_toid = assigncare_loctype_ind+"$"+assigncare_locacode;
		    }
			//End this CRF GDOH-CRF-0129
			
			if(!tabdata.get("appt_id").equals(""))
			{
			     String refno="SELECT to_char(appt_time,'dd/mm/yyyy hh24:mi'), appt_status, mr_request_id, REFERRAL_ID FROM oa_appt WHERE APPT_REF_NO = ? and FACILITY_ID =?";	 				

				 if(pstmt!=null) pstmt.close();
				 pstmt   = con.prepareStatement(refno);
				 pstmt.setString(1,(String)tabdata.get("appt_id"));
				 pstmt.setString(2, (String)tabdata.get("facility_id"));
				 rset = pstmt.executeQuery(); 
				 if(rset!=null && rset.next())
				 {
						appt_time = rset.getString(1);
						appt_status = rset.getString(2);
						request_id = rset.getString(3);
						refferal_id=rset.getString("REFERRAL_ID")==null?"":rset.getString("REFERRAL_ID");
				 }	else{
					 /*Added By Dharma on 26th Nov 2014 against HSA-SCF-0145 [IN:051698] Start*/
					 insertable = false;
				
					 sb.append("NO_REC_ON_OA_APPT");
					 /*Added By Dharma on 26th Nov 2014 against HSA-SCF-0145 [IN:051698] End*/
				 }
				 if(rset!=null) rset.close();
			}

			String sql = "";
			//StringBuffer tabdataFields = new StringBuffer();
			StringBuffer sqlBillEPi = new StringBuffer();
			/*
			while (objiterator.hasNext()) {
				tabdataFields.append((String) objiterator.next() + ",");
				numoffields++;
			}
			fields = tabdataFields.toString();
			tabdataFields = null;
			*/

			Object[] obj;
			//enum01 = tabdata.keySet();
			//objiterator = enum01.iterator();			
			String patientClass = "";
			String l_practitioner_id = "";
			String room_num = "";			
			String oldepisodeno = "";
			String refStatus = "";
			
			String epi_type = "";
			String op_episode_yn = "";

			patientClass = (String) prencounter.get("pat_class");

			prencounter.remove("pat_class");
			if (patientClass == null)
				patientClass = "OP";

			String msg = "N";
			String msgEncounter = "N";

			try {
				visitnum = (String) prencounter.get("op_episode_visit_num");
				
				if (visitnum == null)
					visitnum = "0001";
				if (visitnum.length() > 4)
					visitnum = visitnum.substring(0, 3);
				op_episode_yn = (String) tabdata.get("new_episode_yn");
				
				if (Integer.parseInt(visitnum) > 1) {
					episodeno = (String) tabdata.get("op_episode_id");
					if (episodeno == null || episodeno.equals(""))
						episodeno = "";
				}
				
				String errmsg = "";
				
				
				if ((tabdata.get("bl_install_yn").equals("Y"))
						&& !(episodeno.equals(""))) {
					sqlBillEPi
							.append("SELECT EPISODE_TYPE epi_type FROM BL_EPISODE_FIN_DTLS WHERE  OPERATING_FACILITY_ID = ? AND EPISODE_ID = ?");
					if (pstmt != null)
						pstmt.close();
					pstmt = con.prepareStatement(sqlBillEPi.toString());
					pstmt.setString(1, (String) tabdata.get("facility_id"));
					pstmt.setString(2, episodeno);
					rset = pstmt.executeQuery();
					if (rset != null && rset.next()) {
						epi_type = rset.getString("epi_type");
					}
					
					if (!epi_type.equals("O")) {
						episodeno = "";
						visitnum = "0001";
						op_episode_yn = "Y";
					}
					if (rset != null)
						rset.close();
					if (pstmt != null)
						pstmt.close();
					if ((sqlBillEPi != null) && (sqlBillEPi.length() > 0)) {
						sqlBillEPi.delete(0, sqlBillEPi.length());
					}
				}
				

				try {
					cstmt = con
							.prepareCall("{call PR_GENERATE_ENCOUNTER_ID(?,?,?,?,?,?,?,?,?,?)}");
					
					
					cstmt.setString(1, episodeno);
					cstmt.setString(2, visitnum);
					cstmt.setString(3, (String) tabdata.get("facility_id"));
					cstmt.setString(4, (String) tabdata.get("added_by_id"));
					cstmt.setString(5, ws_no);
					cstmt.registerOutParameter(6, java.sql.Types.VARCHAR);
					cstmt.registerOutParameter(7, java.sql.Types.VARCHAR);
					cstmt.registerOutParameter(8, java.sql.Types.VARCHAR);
					cstmt.registerOutParameter(9, java.sql.Types.VARCHAR);
					cstmt.registerOutParameter(10, java.sql.Types.VARCHAR);

					cstmt.execute();

					errmsg = cstmt.getString(9);
					if (errmsg == null)
						errmsg = "";
					msgEncounter = cstmt.getString(10);
					if (msgEncounter == null)
						msgEncounter = "N";

					if (errmsg.equals("")) {
						if (msgEncounter.equals("Y")) {
							insertable = false;
						} else {
							encounterid = cstmt.getString(8);
							if (encounterid == null)
								encounterid = "";
							episodeno = cstmt.getString(6);
							if (episodeno == null)
								episodeno = "";
							visitnum = cstmt.getString(7);
							if (visitnum == null)
								visitnum = "";
							insertable = true;

							
							
							
						}
					} else {
						insertable = false;
						sb.append(errmsg);
					}

					if (cstmt != null)
						cstmt.close();

				} catch (Exception e) {
					insertable = false;
					e.printStackTrace();
				}
				String buildepisoderule = (String) tabdata
						.get("build_episode_rule");
				String serviceCd = (String) tabdata.get("service_code");
				String ct_date = "";
				
				//added by mujafar for testing ML-MMOH-CRF-1437

				if(isAllowRegForSameService.equals("true"))
				{
					if (insertable) {
					try {
						String chkSql = "select '1' from op_patient_queue where facility_id = ? and  locn_code = ?  and patient_id = ? and service_code = ?  and queue_status < '07' ";

						stmt = con.prepareStatement(chkSql);
						stmt.setString(1, (String) tabdata.get("facility_id"));
						stmt.setString(2, (String) tabdata.get("assign_care_locn_code"));
						stmt.setString(3, (String) tabdata.get("patient_id"));
						stmt.setString(4, (String) tabdata.get("service_code"));
						rs = stmt.executeQuery();

						if (rs != null) {
							if (rs.next()) {
								insertable = false;
								msg = "Y";
							}
						} else {
							insertable = true;
							msg = "N";
						}
						if (rs != null)
							rs.close();
						if (stmt != null)
							stmt.close();

					} catch (Exception e) {
						e.printStackTrace();
						insertable = false;
						
					}
				}

				}
				else
				{
				if (insertable) {
					try {
						String chkSql = "select '1' from op_patient_queue where facility_id = ?  and patient_id = ? and service_code = ?  and queue_status < '07' ";

						stmt = con.prepareStatement(chkSql);
						stmt.setString(1, (String) tabdata.get("facility_id"));
						stmt.setString(2, (String) tabdata.get("patient_id"));
						stmt.setString(3, (String) tabdata.get("service_code"));
						rs = stmt.executeQuery();

						if (rs != null) {
							if (rs.next()) {
								insertable = false;
								msg = "Y";
							}
						} else {
							insertable = true;
							msg = "N";
						}
						if (rs != null)
							rs.close();
						if (stmt != null)
							stmt.close();

					} catch (Exception e) {
						e.printStackTrace();
						insertable = false;
						
					}
				}
				}
				
			
				
				/*  added by mujafar for ML-MMOH-CRF-1437  */
				
				//numoffields = 0;
				//fields = "";
				String l_subservice_code = "";

				if ((String) tabdata.get("subservice_code") != null)
					l_subservice_code =  (String) tabdata.get("subservice_code") ; //Modified by S.Sathish for IN022172 on June 17, 2010
				else
					l_subservice_code = "null";

				// Queue num Generation Starts here

				String identificationcheck = (String) tabdata
						.get("ident_at_checkin");
				if (identificationcheck == null)
					identificationcheck = "X";
			//Maheshwaran K changed Integer to String for ML-BRU-CRF-0628.11
			//	int l_quenum = 0;
			//	int quenum = 0;
				String l_quenum = "0";
				String quenum = "0";
				String queID = "";

				String p_id = "";
				String other_res_class = "";
				String other_res_code = "";

				other_res_class = (String) tabdata.get("other_res_type");
				other_res_code = (String) tabdata.get("other_res_code");

				if (insertable) {

					if (identificationcheck.equals("P")
							|| prencounter.get("attend_practitioner_id") != null)
						l_practitioner_id = (String) prencounter
								.get("attend_practitioner_id");
					else
						l_practitioner_id = "*ALL";

					if (prencounter.get("attend_practitioner_id").equals(""))
						l_practitioner_id = "*ALL";

					room_num = (String) tabdata.get("room_no");

					p_id = (String) prencounter.get("appt_case_yn");

					ct_date = (String) tabdata.get("ct_date");

					if (!refferal_id.equals("") && !tabdata.get("appt_id").equals(""))
						p_id = "A";
					else if (!refferal_id.equals("") && tabdata.get("appt_id").equals(""))
						p_id = "R";

					if (room_num.equals(""))
						room_num = "*ALL";

					if (other_res_class.equals(""))
						other_res_class = "*";
					if (other_res_code.equals(""))
						other_res_code = "*ALL";

					try {						

						String assign_q_num_by = ((String) tabdata.get("assign_q_num_by"));							
						
						if(assign_q_num_by.equals("S"))
						{								
								
								//String qms_interfaced_yn=eOP.QMSInterface.isClinicQMSInterfaced( (String) prencounter.get("assign_care_locn_code"),(String) tabdata.get("facility_id"),con);
								String qms_interfaced_yn=((String) tabdata.get("qms_interfaced_yn"));

								
								if(qms_interfaced_yn.equals("N")){								
								cstmt = con
										.prepareCall("{call OP_QUEUE_NUM_FOR_LOCN_PRC(?,?,?,?,?,?,?,?,?,?,?,null,null,?,?)}");
								cstmt.setString(1, (String) tabdata.get("facility_id"));
								cstmt.setString(2, ct_date);
								cstmt.setString(3, (String) prencounter
										.get("assign_care_locn_type"));
								cstmt.setString(4, (String) prencounter
										.get("assign_care_locn_code"));
								cstmt.setString(5, l_practitioner_id);
								cstmt.setString(6, room_num);
								cstmt.setString(7, other_res_class);
								cstmt.setString(8, other_res_code);
								cstmt.setString(9, p_id);
								cstmt
										.setString(10, (String) tabdata
												.get("added_by_id"));
								cstmt.setString(11, ws_no);
								cstmt.registerOutParameter(12, java.sql.Types.VARCHAR);
							//	cstmt.registerOutParameter(13, java.sql.Types.INTEGER);
								cstmt.registerOutParameter(13, java.sql.Types.VARCHAR);//Maheshwaran K changed Integer to String for ML-BRU-CRF-0628.11

								cstmt.execute();
								queID = cstmt.getString(12);
								//quenum = cstmt.getInt(13);
								quenum = cstmt.getString(13);//Maheshwaran K changed Integer to String for ML-BRU-CRF-0628.11

								if (queID == null || queID.equals("")
										|| queID.equals("null"))
									queID = "";

								//if (quenum >= 0) {//Maheshwaran K changed Integer to String for ML-BRU-CRF-0628.11
								if (quenum.equals("0") || !quenum.equals("-1") || !quenum.equals("-2")) {	
									insertable = true;
									l_quenum = quenum;
								} else if (quenum.equals("-1")) {
									insertable = false;
									
								  java.util.Hashtable message = MessageManager.getMessage(locale,
								  "QUEUE_ID_NOT_ATTACHED", "OP");
								   sb.append((String) message.get("message"));
								   message.clear();								
									
								} else {
									insertable = false;
									java.util.Hashtable message = MessageManager.getMessage(locale,
								  "QUEUE_NUM_CTRL_NOT_DEFINED", "OP");
								   sb.append((String) message.get("message"));
								   message.clear();	 
								}

								if (cstmt != null)
									cstmt.close();
								}
						}
					} catch (Exception e) {
						insertable = false;
						
						sb.append(e.toString());
						e.printStackTrace();
					}

				}

				// Ends here

				if (insertable) {
					try {
						//Below line modified from 52 to 53 for the CRF GDOH-CRF-0129
						//Modified by Sangeetha for KDAH-CRF-0347 on 14/apr/17	
						obj = new Object[55];
						
						StringBuffer prEncounterSQL = new StringBuffer();
						prEncounterSQL.append("insert into pr_encounter(facility_id,patient_id,appt_id,visit_adm_type,visit_adm_type_facility_id,visit_adm_type_ind,assign_care_locn_type,assign_care_locn_code,attend_practitioner_id,referral_id,specialty_code,contact_reason_code,appt_case_yn,ancillary_yn,ambulatory_status,op_episode_visit_num,recall_yn,mds_complete_yn,backdated_yn,visit_status,added_by_id,added_facility_id,added_at_ws_no,modified_by_id,modified_facility_id,modified_at_ws_no,encounter_id,patient_class,HOSP_MAIN,HOSP_SUB,CARD_ID,EXPIRY_DATE,PRIVL_TYPE_CODE,visit_adm_date_time,episode_id,service_code,subservice_code,new_op_episode_yn,assign_room_num,assign_room_type,PAT_TRN_TIME,PAT_CURR_LOCN_CODE,PAT_CURR_LOCN_TYPE,INVITATION_NO,PREV_ASSIGN_CARE_LOCN_CODE,PREV_ASSIGN_ROOM_NUM ,PREV_SUBSERVICE_CODE, PREV_ATTEND_PRACTITIONER_ID,PREV_VISIT_ADM_TYPE , PREV_VISIT_ADM_TYPE_IND,OTHER_RES_CLASS,OTHER_RESOURCE_ID,QUEUE_ID,referred_locn_code,FORM60_YN,other_reason_remarks");	//Modified by Sangeetha for KDAH-CRF-0347 on 14/apr/17					
						//Above line modified for the CRF GDOH-CRF-0129
						//Modified by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114

						if ((tabdata.get("bl_interface_yn").equals("Y"))
								&& (tabdata.get("upd_user_flag").equals("Y"))) {
							prEncounterSQL
									.append(",credit_auth_user_id, credit_auth_remarks");
						}

						//prEncounterSQL.append(") values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,");
                        //Below line modified for the CRF GDOH-CRF-0129
						//Modified by Sangeetha for KDAH-CRF-0347 on 14/apr/17	
						prEncounterSQL.append(") values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,To_Date(?,'dd/mm/yyyy'),?,To_Date(?,'dd/mm/yyyy hh24:mi:ss'),?,?,?,?,?,?,sysdate,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? ");//modified by Srinivasrao Yeluri on 22/02/2012 for Incident no 29368
						//Modified by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114

						//"?,?,?,?,?,To_Date(?,'dd/mm/yyyy'),?,To_Date(?,'dd/mm/yyyy hh24:mi'),?,?,?,?,?,?,sysdate,?,?,?,?,?,?,?,?,?,?,?"
						/*
						prEncounterSQL.append(encounterid
								+ ",'"
								+ patientClass
								+ "','"
								+(String) tabdata.get("p_hosp_main")
								+ "','"
								+(String) tabdata.get("p_hosp_sub")
								+ "','"
								+(String) tabdata.get("p_card_id")
								+ "',To_Date('"+(String) tabdata.get("p_expiry_date")+"','dd/mm/yyyy')"								
								+ ",'"
								+(String) tabdata.get("p_privl_type_code")								
								+ "',To_Date('"+vst_regn_date_time+"','dd/mm/yyyy hh24:mi'),'"
								+ episodeno
								+ "','"
								+ (String) tabdata.get("service_code")
								+ "',"
								+ l_subservice_code
								+ ",'"
								+ op_episode_yn
								+ "','"
								+ (String) tabdata.get("room_no")
								+ "','"
								+ (String) tabdata.get("room_type")
								+ "',sysdate,'"
								+ (String) prencounter
										.get("assign_care_locn_code")
								+ "','"
								+ (String) prencounter
										.get("assign_care_locn_type")
								+ "','"
								+ (String) tabdata.get("invitation_no")
								+ "' ,'"
								+ (String) prencounter
										.get("assign_care_locn_code")
								+ "','"
								+ (String) tabdata.get("room_no")
								+ "',"
								+ l_subservice_code
								+ ",'"
								+ (String) prencounter
										.get("attend_practitioner_id")
								+ "','"
								+ (String) prencounter.get("visit_adm_type")
								+ "','"
								+ (String) prencounter
										.get("visit_adm_type_ind") + "','"
								+ (String) tabdata.get("other_res_type")
								+ "','"
								+ (String) tabdata.get("other_res_code")
								+ "','" + queID + "' ");

								*/

						if ((tabdata.get("bl_interface_yn").equals("Y"))
								&& (tabdata.get("upd_user_flag").equals("Y"))) {
							prEncounterSQL.append(",'"
									+ (String) tabdata.get("user_id") + "','"
									+ (String) tabdata.get("remarks") + "',");
						}

						sql = prEncounterSQL.toString();

						sql = (sql.substring(0, (sql.length() - 1))) + ")";

						prEncounterSQL.setLength(0);
						
						if (stmt != null)
							stmt.close();

						stmt = con.prepareStatement(sql);					

						obj[0] = prencounter.get("facility_id");
						obj[1] = prencounter.get("patient_id");
						obj[2] = prencounter.get("appt_id");
						obj[3] = prencounter.get("visit_adm_type");
						obj[4] = prencounter.get("visit_adm_type_facility_id");
						obj[5] = prencounter.get("visit_adm_type_ind");
						obj[6] = prencounter.get("assign_care_locn_type");
						obj[7] = prencounter.get("assign_care_locn_code");
						obj[8] = prencounter.get("attend_practitioner_id");
						obj[9] = refferal_id;
						obj[10] = prencounter.get("specialty_code");
						obj[11] = prencounter.get("contact_reason_code");
						obj[12] = prencounter.get("appt_case_yn");
						obj[13] = prencounter.get("ancillary_yn");
						obj[14] = prencounter.get("ambulatory_status");
						//obj[15] = prencounter.get("op_episode_visit_num");
						obj[15] = visitnum ;
						obj[16] = prencounter.get("recall_yn");
						obj[17] = prencounter.get("mds_complete_yn");
						obj[18] = prencounter.get("backdated_yn");
						obj[19] = prencounter.get("visit_status");
						obj[20] = prencounter.get("added_by_id");
						obj[21] = prencounter.get("added_facility_id");
						obj[22] = prencounter.get("added_at_ws_no");
						obj[23] = prencounter.get("modified_by_id");
						obj[24] = prencounter.get("modified_facility_id");
						obj[25] = prencounter.get("modified_at_ws_no");

						obj[26] = encounterid;
						obj[27] = patientClass;
						obj[28] = tabdata.get("p_hosp_main");
						obj[29] = tabdata.get("p_hosp_sub");
						obj[30] = tabdata.get("p_card_id");
						obj[31] = tabdata.get("p_expiry_date");
						obj[32] = tabdata.get("p_privl_type_code");
						obj[33] = vst_regn_date_time;
						obj[34] = episodeno;
						obj[35] = tabdata.get("service_code");
						obj[36] = l_subservice_code;
						obj[37] = op_episode_yn;
						obj[38] = tabdata.get("room_no");
						obj[39] = tabdata.get("room_type");
						obj[40] = prencounter.get("assign_care_locn_code");
						obj[41] = prencounter.get("assign_care_locn_type");
						obj[42] = tabdata.get("invitation_no");
						obj[43] = prencounter.get("assign_care_locn_code");
						obj[44] = tabdata.get("room_no");
						obj[45] = l_subservice_code;
						obj[46] = prencounter.get("attend_practitioner_id");
						obj[47] = prencounter.get("visit_adm_type");
						obj[48] = prencounter.get("visit_adm_type_ind");
						obj[49] = tabdata.get("other_res_type");
						obj[50] = tabdata.get("other_res_code");
						obj[51] = queID;
						//Below line added for the CRF GDOH-CRF-0129
						obj[52] = referral_toid;
						obj[53] = form60_YN; //Added by Sangeetha for KDAH-CRF-0347 on 14/apr/17	
						obj[54] = other_remarks; //Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114

						stmt = setData(stmt, obj);
						cnt = stmt.executeUpdate();
						if (stmt != null)
							stmt.close();
					} catch (Exception ePR) {
						insertable = false;
						//sb.append("Exception while insering into PR_Encounter:"+ ePR);
						ePR.printStackTrace();
						//Added for ML-MMOH-SCF-1981 by Kamatchi S
						String err_msg = ePR.getMessage();
						if(err_msg.contains("PR_ENCOUNTER_PK"))
						{
						con.rollback();
						String pr_data = "select * from (select episode_id,TO_CHAR(visit_adm_date_time,'dd/mm/yyyy hh24:mi') visit_adm_date_time ,encounter_id , service_code, facility_id,patient_id,assign_care_locn_code,patient_class,op_episode_visit_num from pr_encounter where facility_id = ? and episode_id = ? order by added_date desc) WHERE ROWNUM = 1";

						String enc_id = "";
						String eps_id = "";
						String fac_id = "";
						String pat_id = "";
						String ser_cod = "";
						String visit_adm_date_time = "";
						String assign_care_locn_code = "";
						String patient_class = "";
						String op_episode_visit_num = "";
						
						stmt = con.prepareStatement(pr_data);
						stmt.setString(1, (String) tabdata.get("facility_id"));
						stmt.setString(2, (String) tabdata.get("op_episode_id"));
						
						rs = stmt.executeQuery();
						
						if (rs != null) {
							if (rs.next()) {
								enc_id = rs.getString("encounter_id");
								fac_id = rs.getString("facility_id");
								pat_id = rs.getString("patient_id");
								ser_cod = rs.getString("service_code");
								eps_id = rs.getString("episode_id");
								visit_adm_date_time = rs.getString("visit_adm_date_time");
								assign_care_locn_code = rs.getString("assign_care_locn_code");
								patient_class = rs.getString("patient_class");
								op_episode_visit_num = rs.getString("op_episode_visit_num");
							}
						} 

						if (rs != null)
							rs.close();
						if (stmt != null)
							stmt.close();

						String 	update_opEpisodeService  = "update op_episode_for_service set last_encounter_id = ?,last_visit_date = To_Date('"+visit_adm_date_time+"','dd/mm/yyyy hh24:mi:ss'),last_visit_num = '"+op_episode_visit_num+"',MODIFIED_BY_ID =?,MODIFIED_DATE = SYSDATE,MODIFIED_AT_WS_NO = ?,MODIFIED_FACILITY_ID = ? where operating_facility_id = ? and episode_id = ? and patient_id= ? and service_code=?  ";

						Object[] obj1 = new Object[8];
						obj1[0] = enc_id;
						obj1[1] = prencounter.get("modified_by_id");
						obj1[2] = prencounter.get("modified_at_ws_no");
						obj1[3] = prencounter.get("modified_facility_id");						
						obj1[4] = fac_id;
						obj1[5] = eps_id;
						obj1[6] = pat_id;
						obj1[7] = ser_cod;
						
						pstmt = con.prepareStatement(update_opEpisodeService.toString());
						pstmt = setData(pstmt, obj1);
						count1 = pstmt.executeUpdate();

						if (pstmt != null)
							pstmt.close();
						
						String 	update_opLastService = "UPDATE op_last_visit_for_service SET encounter_id = ?,visit_adm_date_time = To_Date('"+visit_adm_date_time+"','dd/mm/yyyy hh24:mi:ss'),assign_care_locn_code = ?,patient_class = ?,modified_by_id = ?,modified_date = SYSDATE,modified_at_ws_no = ?,modified_facility_id = ? WHERE operating_facility_id = ? and patient_id = ? AND service_code = ?";

						Object[] obj2 = new Object[9];

						obj2[0] = enc_id;
						obj2[1] = assign_care_locn_code;
						obj2[2] =  patientClass;
						obj2[3] = (String) tabdata.get("modified_by_id");
						obj2[4] = (String) tabdata.get("modified_at_ws_no");
						obj2[5] = (String) tabdata.get("modified_facility_id");
						obj2[6] = fac_id;
						obj2[7] = pat_id;
						obj2[8] = ser_cod;
						
						stmt = con.prepareStatement(update_opLastService.toString());
						stmt = setData(stmt, obj2);
						count2 = stmt.executeUpdate();

						if (stmt != null)
							stmt.close();

						if (count1 != 0 && count2!= 0){							
							con.commit();
							
							prencounter.put("op_episode_visit_num", String.valueOf(Integer.parseInt(op_episode_visit_num) + 1));

							java.util.HashMap res =  insert(p,tabdata,prencounter,prencounterdetail,tabdata1,prencounter1,prencounterdetail1);
							
							return res;
							
						}
						}
						//Added for ML-MMOH-SCF-1981 by Kamatchi S END
						// Update the record	
					}
					if (cnt != 0) {
						insertable = true;
					} else {
						insertable = false;						
						sb.append("ERROR_IN_INSERTING_INTO PR_ENCOUNTER");					
					}
				}

				if (insertable) {
					
					
					if (!(buildepisoderule.equals("X"))
							&& !(serviceCd.equals(""))) {
						HashMap ret = opparamforfacilityservice(tabdata,p,con);
						
						boolean retval = ((Boolean) ret.get("status"))
								.booleanValue();
						insertable = retval;
						
						oldepisodeno = (String) tabdata.get("old_episode_id");
						if (oldepisodeno == null || oldepisodeno.equals(""))
							oldepisodeno = "";
						if (insertable) {
							ret = opepisodeforservice(tabdata, prencounter,
									visitnum, episodeno, oldepisodeno, p,con);
							retval = ((Boolean) ret.get("status"))
									.booleanValue();
							encounterid = (String)ret.get("encounterid");
							insertable = retval;
							
						}
						ret.clear();
					}
				} 
				
				if (insertable) {
					try {

						String inviteNo = (String) tabdata.get("invitation_no");
						Object[] obj_w = new Object[6];

						if (!inviteNo.equals("")) {						

							String update_waitList = " UPDATE PR_WAIT_LIST SET ENCOUNTER_ID = ?, WAIT_LIST_STATUS = 'V', MODIFIED_BY_ID = ?, MODIFIED_DATE = sysdate, MODIFIED_AT_WS_NO = ?, MODIFIED_FACILITY_ID = ? WHERE FACILITY_ID = ? AND INVITATION_NUMBER = ? ";							

							obj_w[0] = encounterid;
							obj_w[1] = (String) tabdata.get("modified_by_id");							
							obj_w[2] = (String) tabdata.get("modified_at_ws_no");
							obj_w[3] = (String) tabdata.get("modified_facility_id");
							obj_w[4] = (String) tabdata.get("facility_id");
							obj_w[5] = inviteNo;

							stmt = con.prepareStatement(update_waitList);
							stmt = setData(stmt, obj_w);
							int waitResult = stmt.executeUpdate();

							if (waitResult != 0)
								insertable = true;
							else
								insertable = false;

							if (stmt != null)
								stmt.close();

						}

					} catch (Exception e) {
						insertable = false;
						e.printStackTrace();
					}
				}
				if (insertable) {
					String wait_list_flag = (String) tabdata
							.get("wait_list_flag");
					try {
						if (wait_list_flag.equals("Y")) {							

							Object[] obj_w1 = new Object[6];

							String update_waitList1 = " UPDATE PR_WAIT_LIST SET ENCOUNTER_ID =?, MODIFIED_BY_ID = ?, MODIFIED_DATE = sysdate, MODIFIED_AT_WS_NO = ?, MODIFIED_FACILITY_ID = ? WHERE FACILITY_ID = ? and patient_id = ? and WAIT_LIST_STATUS = 'I' and ENCOUNTER_ID is null and rownum < 2 ";

							obj_w1[0] = encounterid;
							obj_w1[1] = (String) tabdata.get("modified_by_id");							
							obj_w1[2] = (String) tabdata.get("modified_at_ws_no");
							obj_w1[3] = (String) tabdata.get("modified_facility_id");
							obj_w1[4] = (String) tabdata.get("facility_id");
							obj_w1[5] = (String) tabdata.get("patient_id");
							
							stmt = con.prepareStatement(update_waitList1);
							stmt = setData(stmt, obj_w1);
							int waitResult1 = stmt.executeUpdate();

							if (waitResult1 != 0)
								insertable = true;
							else
								insertable = false;

							if (stmt != null)
								stmt.close();
						}
					} catch (Exception e) {
						insertable = false;
						e.printStackTrace();
					}
				}
				if (insertable) {
					// search for the record in op_last_visit_for_service
					try {
						sql = "select '1' from op_last_visit_for_service"
								+ " where operating_facility_id=? and service_code=?"
								+ " and patient_id=?";

						Object[] obj1 = new Object[3];
						obj1[0] = tabdata.get("facility_id");
						obj1[1] = tabdata.get("service_code");
						obj1[2] = tabdata.get("patient_id");

						stmt = con.prepareStatement(sql);
						stmt = setData(stmt, obj1);
						rs = stmt.executeQuery();

						if (!rs.next()) {							

							sql = "insert into op_last_visit_for_service (operating_facility_id, Encounter_id, service_code, patient_id, added_by_id, added_date, added_facility_id, added_at_ws_no, modified_by_id, modified_date, modified_facility_id, modified_at_ws_no, VISIT_ADM_DATE_TIME, ASSIGN_CARE_LOCN_CODE, ATTEND_PRACTITIONER_ID, PATIENT_CLASS, REFERRAL_ID, SUBSERVICE_CODE)  values(?,?,?,?,?,sysdate,?,?,?,sysdate,?,?,To_Date('"+vst_regn_date_time+"','dd/mm/yyyy hh24:mi:ss'),?,?,?,?,?)";//modified by Srinivasrao Yeluri on 22/02/2012 for Incident no 29368

							obj = new Object[15];

							obj[0] = (String) tabdata.get("facility_id");
							obj[1] = (String) encounterid;
							obj[2] = (String) tabdata.get("service_code");
							obj[3] = (String) tabdata.get("patient_id");
							obj[4] = (String) tabdata.get("added_by_id");
							obj[5] = (String) tabdata.get("added_facility_id");
							obj[6] = (String) tabdata.get("added_at_ws_no");
							obj[7] = (String) tabdata.get("modified_by_id");
							obj[8] = (String) tabdata
									.get("modified_facility_id");
							obj[9] = (String) tabdata.get("modified_at_ws_no");
							obj[10] = (String) prencounter
									.get("assign_care_locn_code");
							obj[11] = (String) prencounter
									.get("attend_practitioner_id");
							obj[12] = patientClass;
							obj[13] = refferal_id;
							obj[14] = (String) tabdata.get("subservice_code");

						} else {							

							// Update the record
							sql = " update op_last_visit_for_service set encounter_id=?,recall_date=null,recall_reason=null,VISIT_ADM_DATE_TIME = To_Date('"+vst_regn_date_time+"','dd/mm/yyyy hh24:mi:ss'), ASSIGN_CARE_LOCN_CODE = ?, ATTEND_PRACTITIONER_ID = ?, PATIENT_CLASS = ?, REFERRAL_ID = ?, SUBSERVICE_CODE = ?, MODIFIED_BY_ID = ?, MODIFIED_DATE = sysdate, MODIFIED_AT_WS_NO = ?, MODIFIED_FACILITY_ID = ? where operating_facility_id=? and service_code=? and patient_id=? ";//modified by Srinivasrao Yeluri on 22/02/2012 for Incident no 29368

							obj = new Object[12];

							obj[0] = (String) encounterid;
							obj[1] = (String) prencounter.get("assign_care_locn_code");
							obj[2] = (String) prencounter.get("attend_practitioner_id");
							obj[3] =  patientClass;
							obj[4] =  refferal_id;
							obj[5] = (String) tabdata.get("subservice_code");
							obj[6] = (String) tabdata.get("modified_by_id");
							obj[7] = (String) tabdata.get("modified_at_ws_no");
							obj[8] = (String) tabdata.get("modified_facility_id");
							obj[9] = (String) tabdata.get("facility_id");
							obj[10] = (String) tabdata.get("service_code");
							obj[11] = (String) tabdata.get("patient_id");
						}

						stmt = con.prepareStatement(sql);
						stmt = setData(stmt, obj);
						cnt = stmt.executeUpdate();

						if (cnt != 0)
							insertable = true;
						else {
							insertable = false;
							String msgVal = "Error While UPDATING OP_LAST_VISIT_FOR_SERVICE";
							sb.append(msgVal);
						}

						if (rs != null)
							rs.close();
						if (stmt != null)
							stmt.close();
					} catch (Exception exc11) {
						insertable = false;
						sb.append("Exception at OP_LAST_VISIT_FOR_SERVICE :"
								+ exc11);
						exc11.printStackTrace();

					}
				}

				if (insertable && !refferal_id.equals("")) {

					try {						

							sql = " update pr_referral_register a set STATUS='C', REFERRED_IN_FUNC = 2 , CLOSE_ENCOUNTER_ID= ?, MODIFIED_BY_ID = ?, MODIFIED_DATE = sysdate, MODIFIED_AT_WS_NO = ?, MODIFIED_FACILITY_ID = ? where a.referral_id = ? ";
						/*
							if(!tabdata.get("appt_id").equals(""))
							{
								sql = sql+ "and a.referral_id = (Select referral_id from oa_appt b where b.facility_id = ? and a.referral_id = b.referral_id and b.appt_status = '1' and a.status = 'C') ";
							}									
						*/
							obj = new Object[6];							
							obj[0] = encounterid;
							obj[1] = (String) tabdata.get("modified_by_id");							
							obj[2] = (String) tabdata.get("modified_at_ws_no");
							obj[3] = (String) tabdata.get("modified_facility_id");
							obj[4] = refferal_id;
/*
							if(!tabdata.get("appt_id").equals(""))
							{
								obj[5] = (String) tabdata.get("facility_id");
							}				
*/

							stmt = con.prepareStatement(sql);
							stmt = setData(stmt, obj);

							if (stmt.executeUpdate() > 0)
								insertable = true;
							else {
								insertable = false;
								String msgVal = "Error While UPDATING PR_REFERRAL_REGISTER";
								sb.append(msgVal);
							}

							if (stmt != null)
								stmt.close();						
					} catch (Exception exc12) {
						insertable = false;
						sb
								.append("Exception while updating PR_REFERRAL_REGISTER :"
										+ exc12);
						exc12.printStackTrace();
					}					
				}

				if (insertable) {
					if (!tabdata.get("appt_id").equals("")) {				

						if (appt_status.equals("A")) {
							insertable = false;
						}

						if (insertable) {
							if (request_id != null) {
								try {
									
									String mr_report = "update mr_report_request_hdr set patient_id =?, MODIFIED_BY_ID = ?, MODIFIED_DATE = sysdate, MODIFIED_AT_WS_NO = ?, MODIFIED_FACILITY_ID = ? where facility_id = ? and request_id =? ";
									stmt = con.prepareStatement(mr_report);

									stmt.setString(1, (String) tabdata.get("patient_id"));
									stmt.setString(2, (String) tabdata.get("modified_by_id"));									
									stmt.setString(3, (String) tabdata.get("modified_at_ws_no"));
									stmt.setString(4, (String) tabdata.get("modified_facility_id"));
									stmt.setString(5, (String) tabdata.get("facility_id"));
									stmt.setString(6, request_id);
									int mcnt = stmt.executeUpdate();
									if (mcnt == 0)
										insertable = false;
									else
										insertable = true;
									if (stmt != null)
										stmt.close();
								} catch (Exception e) {
									insertable = false;
									e.printStackTrace();
								}
								try {
									if (insertable) {									

										String mrRequest = "insert into mr_report_request_dtl(FACILITY_ID, REQUEST_ID, SRL_NO, REQUESTOR_CODE, PATIENT_ID, ENCOUNTER_ID, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID) values(?,?,1,null,?,?,?,sysdate,?,?,?,sysdate,?,?) ";
										stmt = con.prepareStatement(mrRequest);
										stmt.setString(1, (String) tabdata
												.get("facility_id"));
										stmt.setString(2, request_id);
										stmt.setString(3, (String) tabdata
												.get("patient_id"));
										stmt.setString(4, encounterid);
										stmt.setString(5, (String) tabdata
												.get("added_by_id"));
										stmt.setString(6, (String) tabdata
												.get("added_at_ws_no"));
										stmt.setString(7, (String) tabdata
												.get("added_facility_id"));
										stmt.setString(8, (String) tabdata
												.get("modified_by_id"));
										stmt.setString(9, (String) tabdata
												.get("modified_at_ws_no"));
										stmt.setString(10, (String) tabdata
												.get("modified_facility_id"));
										int mcnt1 = stmt.executeUpdate();
										if (mcnt1 == 0)
											insertable = false;
										else
											insertable = true;
										if (stmt != null)
											stmt.close();
									}
								} catch (Exception e) {
									insertable = false;
									e.printStackTrace();
								}
							}
						}
						
						//sql = "insert into op_patient_queue (facility_id,queue_date,queue_shift,locn_type,locn_code, queue_num,patient_id,practitioner_id,room_num,appt_or_walk_in_ind,appt_id,appt_time,encounter_id,check_in_date_time, queue_status, added_by_id,added_date,added_facility_id,added_at_ws_no,  modified_by_id,modified_date,modified_facility_id,modified_at_ws_no,QUEUE_ID,OTHER_RES_CLASS,OTHER_RESOURCE_ID,VISIT_TYPE_IND,VISIT_TYPE_CODE,SERVICE_CODE  ,SUBSERVICE_CODE ,PAT_CURR_LOCN_CODE ,PAT_CURR_LOCN_TYPE,SPECIALITY_CODE ,REFERRAL_ID,EPISODE_ID,OP_EPISODE_VISIT_NUM,INVITATION_NO,CONTACT_REASON_CODE ) values(?,To_Date('"+vst_regn_date_time+"','dd/mm/yyyy hh24:mi'),'*ALL',?,?,"+ l_quenum+ ",?,?,?,?,?,to_date('"+ appt_time+ "','dd/mm/rrrr hh24:mi'),'"+ encounterid	+ "', To_Date('"+vst_regn_date_time+"', 'dd/mm/yyyy hh24:mi'), '01', ?, sysdate,?,?,?,sysdate,?,?,'"+ queID + "',?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
						//self_chkin_appt_yn Added by Dharma on 24th Feb 2020 against MO-CRF-20155
						//Modified by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114
						sql = "insert into op_patient_queue (facility_id,queue_date,queue_shift,locn_type,locn_code,"
								+ " queue_num,patient_id,practitioner_id,room_num,appt_or_walk_in_ind,appt_id,appt_time,encounter_id,check_in_date_time,"
								+ " queue_status, added_by_id,added_date,added_facility_id,added_at_ws_no, "
								+ " modified_by_id,modified_date,modified_facility_id,modified_at_ws_no,QUEUE_ID,OTHER_RES_CLASS,OTHER_RESOURCE_ID,VISIT_TYPE_IND,VISIT_TYPE_CODE,SERVICE_CODE  ,SUBSERVICE_CODE ,PAT_CURR_LOCN_CODE ,PAT_CURR_LOCN_TYPE,SPECIALITY_CODE ,REFERRAL_ID,EPISODE_ID,OP_EPISODE_VISIT_NUM,INVITATION_NO,CONTACT_REASON_CODE,other_reason_remarks,self_chkin_yn )"
								+ " values(?,To_Date('"+vst_regn_date_time+"','dd/mm/yyyy hh24:mi:ss'),'*ALL',?,?,"
								+ l_quenum
								+ ",?,?,?,?,?,to_date('"
								+ appt_time
								+ "','dd/mm/rrrr hh24:mi'),'"
								+ encounterid
								+ "',To_Date('"+vst_regn_date_time+"','dd/mm/yyyy hh24:mi:ss'),'01',?,sysdate,?,?,?,sysdate,?,?,'"
								+ queID + "',?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,'"+self_chkin_appt_yn+"')";//modified by Srinivasrao Yeluri on 22/02/2012 for Incident no 29368

					} else {

								//sql = "insert into op_patient_queue (facility_id,queue_date,queue_shift,locn_type,locn_code, queue_num,patient_id,practitioner_id,room_num,appt_or_walk_in_ind,appt_id,appt_time,encounter_id,check_in_date_time, queue_status, added_by_id,added_date,added_facility_id,added_at_ws_no,  modified_by_id,modified_date,modified_facility_id,modified_at_ws_no,QUEUE_ID,OTHER_RES_CLASS,OTHER_RESOURCE_ID ,VISIT_TYPE_IND,VISIT_TYPE_CODE ,SERVICE_CODE  ,SUBSERVICE_CODE ,PAT_CURR_LOCN_CODE ,PAT_CURR_LOCN_TYPE   ,SPECIALITY_CODE ,REFERRAL_ID,EPISODE_ID ,OP_EPISODE_VISIT_NUM ,INVITATION_NO,CONTACT_REASON_CODE ) values(?,To_Date('"+vst_regn_date_time+"','dd/mm/yyyy hh24:mi'),'*ALL',?,?,"+ l_quenum+ ",?,?,?,?,?,null,'"+ encounterid+ "',To_Date('"+vst_regn_date_time+"','dd/mm/yyyy h24:mi'), '01', ?, sysdate,?,?,?,sysdate,?,?,'" + queID + "',?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
								//self_chkin_appt_yn Added by Dharma on 24th Feb 2020 against MO-CRF-20155
								
								//Modified by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114
								sql = "insert into op_patient_queue (facility_id,queue_date,queue_shift,locn_type,locn_code,"
								+ " queue_num,patient_id,practitioner_id,room_num,appt_or_walk_in_ind,appt_id,appt_time,encounter_id,check_in_date_time,"
								+ " queue_status, added_by_id,added_date,added_facility_id,added_at_ws_no, "
								+ " modified_by_id,modified_date,modified_facility_id,modified_at_ws_no,QUEUE_ID,OTHER_RES_CLASS,OTHER_RESOURCE_ID ,VISIT_TYPE_IND,VISIT_TYPE_CODE ,SERVICE_CODE  ,SUBSERVICE_CODE ,PAT_CURR_LOCN_CODE ,PAT_CURR_LOCN_TYPE   ,SPECIALITY_CODE ,REFERRAL_ID,EPISODE_ID ,OP_EPISODE_VISIT_NUM ,INVITATION_NO,CONTACT_REASON_CODE,other_reason_remarks,self_chkin_yn )"
								+ " values(?,To_Date('"+vst_regn_date_time+"','dd/mm/yyyy hh24:mi:ss'),'*ALL',?,?,"
								+ l_quenum
								+ ",?,?,?,?,?,null,'"
								+ encounterid
								+ "',To_Date('"+vst_regn_date_time+"','dd/mm/yyyy hh24:mi:ss'),'01',?,sysdate,?,?,?,sysdate,?,?,'"
								+ queID + "',?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,'"+self_chkin_appt_yn+"')";//modified by Srinivasrao Yeluri on 22/02/2012 for Incident no 29368
					}
					if (insertable) {
						try {

							obj = new Object[29];

							obj[0] = (String) tabdata.get("facility_id");
							obj[1] = (String) prencounter
									.get("assign_care_locn_type");
							obj[2] = (String) prencounter
									.get("assign_care_locn_code");
							obj[3] = (String) tabdata.get("patient_id");
							obj[4] = l_practitioner_id;
							obj[5] = room_num;
							obj[6] = (String) prencounter.get("appt_case_yn");
							obj[7] = (String) prencounter.get("appt_id");
							obj[8] = (String) tabdata.get("added_by_id");
							obj[9] = (String) tabdata.get("added_facility_id");
							obj[10] = (String) tabdata.get("added_at_ws_no");
							obj[11] = (String) tabdata.get("modified_by_id");
							obj[12] = (String) tabdata
									.get("modified_facility_id");
							obj[13] = (String) tabdata.get("modified_at_ws_no");
							obj[14] = (String) tabdata.get("other_res_type");
							obj[15] = (String) tabdata.get("other_res_code");
							obj[16] = (String) prencounter
									.get("visit_adm_type_ind");
							obj[17] = (String) prencounter
									.get("visit_adm_type");
							obj[18] = (String) tabdata.get("service_code");
							obj[19] = (String) tabdata.get("subservice_code");
							obj[20] = (String) prencounter
									.get("assign_care_locn_code");
							obj[21] = (String) prencounter
									.get("assign_care_locn_type");
							obj[22] = (String) prencounter
									.get("specialty_code");
							obj[23] = refferal_id;
							obj[24] = episodeno;
							//obj[25] = (String) prencounter.get("op_episode_visit_num");
							obj[25] = visitnum;
							obj[26] = (String) tabdata.get("invitation_no");
							obj[27] = (String) prencounter
									.get("contact_reason_code");
							obj[28] = other_remarks; //Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114
							
							stmt = con.prepareStatement(sql);
							stmt = setData(stmt, obj);
							cnt = stmt.executeUpdate();

							if (cnt != 0)
								insertable = true;
							else {
								insertable = false;								
								sb.append("ERROR IN INSERTING INTO OP_PATIENT_QUEUE");
							}
							if (stmt != null)
								stmt.close();
						} catch (Exception exc17) {
							insertable = false;
							sb
									.append("Exception while inserting OP_PATIENT_QUEUE :"
											+ exc17);
							exc17.printStackTrace();
						}
					}
				}

			if (insertable) {

					if( (prencounter.get("appt_case_yn").equals("A")) || (appt_status.equals("1") && (!refferal_id.equals(""))) )
					{
						try
						{
							obj = new Object[6];

							obj[0] = encounterid;							
							obj[1] = (String) tabdata.get("modified_by_id");							
							obj[2] = (String) tabdata.get("modified_at_ws_no");
							obj[3] = (String) tabdata.get("modified_facility_id");
							obj[4] = (String) tabdata.get("facility_id");							

							sql = "update oa_appt set encounter_id=?, appt_status='A',MODIFIED_BY_ID = ?, MODIFIED_DATE = sysdate, MODIFIED_AT_WS_NO = ?, MODIFIED_FACILITY_ID = ? where ";

							if(prencounter.get("appt_case_yn").equals("A"))
							{
								sql=sql+"facility_id=? and appt_ref_no=?";	
								
								obj[5] = (String) prencounter.get("appt_id");
								
							}
							else if(appt_status.equals("1") && (!refferal_id.equals("")))
							{
								sql=sql+"facility_id=? and REFERRAL_ID = ?";

								obj[5] = refferal_id;
								
							}							

							stmt = con.prepareStatement(sql);
							stmt = setData(stmt,obj);
							cnt = stmt.executeUpdate();

							if (cnt != 0)
								insertable = true;
							else {
								insertable = false;
								String msgVal = "Error While UPDATING OA_APPT";
								sb.append(msgVal);
							}

							if (stmt != null)
								stmt.close();

						} catch (Exception exc25) {
							insertable = false;
							sb.append("Exception while updating OA_APPT :"
									+ exc25);
							exc25.printStackTrace();
						}		
				}	
				else
					insertable = true;				
				}

			//Changes for the Bru-HIMS-CRF-0198 - start
			
			if(insertable){
				try{
					multi_speciality_yn=(String) tabdata.get("multi_speciality_yn")==null?"N":(String) tabdata.get("multi_speciality_yn");
					if(multi_speciality_yn.equals("Y") && prencounter.get("appt_case_yn").equals("A")){
					String appt_ref= (String) prencounter.get("appt_id");
					ArrayList<String> sec_pract_id=new ArrayList<String>();
					ArrayList<String> spec_code=new ArrayList<String>();
					String sec_pract_sql="select distinct RESOURCE_ID,(select primary_speciality_code from am_practitioner where PRACTITIONER_ID=a.resource_id) spec_code from oa_resource_for_appt a where appt_ref_no='"+appt_ref+"' and resource_class='P' and facility_id='"+(String) tabdata.get("facility_id")+"' and resource_id not in ('"+prencounter.get("attend_practitioner_id")+"')";
					PreparedStatement multipstmt=con.prepareStatement(sec_pract_sql);
					ResultSet multirs=multipstmt.executeQuery();
					while(multirs.next()){
						sec_pract_id.add(multirs.getString("RESOURCE_ID"));
						spec_code.add(multirs.getString("spec_code"));
					}
					if(multipstmt!=null) multipstmt.close();
					if(multirs!=null) multirs.close();
					
					String multiSpecialitySql = "insert into PR_ENCOUNTER_JOINT_CONSULT (FACILITY_ID,ENCOUNTER_ID,PRACTITIONER_ID,LINKED_YN,STATUS,SPECIALTY_CODE,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID)values(?,?,?,?,?,?,?,sysdate,?,?,?,sysdate,?,?) ";
					multipstmt = con.prepareStatement( multiSpecialitySql);
					if(sec_pract_id.size()>0){
						for(int pract_count=0;pract_count<sec_pract_id.size();pract_count++){
							multipstmt.setString(1,(String) tabdata.get("facility_id"));
							multipstmt.setString(2,encounterid);
							multipstmt.setString(3,sec_pract_id.get(pract_count));
							multipstmt.setString(4,"Y");
							multipstmt.setString(5,"O");
							multipstmt.setString(6,spec_code.get(pract_count));
							multipstmt.setString(7, (String) tabdata.get("modified_by_id"));
							multipstmt.setString(8, (String) tabdata.get("modified_at_ws_no"));
							multipstmt.setString(9, (String) tabdata.get("facility_id"));
							multipstmt.setString(10, (String) tabdata.get("modified_by_id"));
							multipstmt.setString(11, (String) tabdata.get("modified_at_ws_no"));
							multipstmt.setString(12, (String) tabdata.get("facility_id"));
							multipstmt.addBatch();
						}
						int resultArr[]=multipstmt.executeBatch();
						if(resultArr.length>0){
							insertable=true;
						}else{
							insertable = false;
							String msgVal = "Error While Inserting into PR_ENCOUNTER_JOINT_CONSULT";
							sb.append(msgVal);
						}						
					}
					if(multipstmt!=null) multipstmt.close();
					if(multirs!=null) multirs.close();
				}
				}catch(SQLException e){
					insertable = false;
					String msgVal = "";
					if(e.getErrorCode()==20101){
						String sqlerrm=e.getMessage();
						int index=sqlerrm.lastIndexOf("PR_JOINT_CONSULT_TRG_ERR");
						if(index!=-1){
							msgVal=sqlerrm.substring(index+25,sqlerrm.indexOf("\n"));
						}else{
							msgVal="Exception while inserting into PR_ENCOUNTER_JOINT_CONSULT";
						}
						sb.append(msgVal);
					}								
					e.printStackTrace();
				}catch(Exception e){
					insertable = false;
					String msgVal = "Exception While inserting into PR_ENCOUNTER_JOINT_CONSULT";
					sb.append(msgVal);
					e.printStackTrace();
				}
				finally{
				}
			}
			//Chagnes for the Bru-HIMS-CRF-0198 - end
				if (insertable) {

				try {
					if ((tabdata.get("bl_install_yn").equals("Y"))
							&& (insertable == true)) {

						Hashtable blTabdata = tabdata1;
						blTabdata.put("appt_status", appt_status);
						blTabdata.put("episodeno", episodeno);
						blTabdata.put("new_episode_yn_val", op_episode_yn);
						blTabdata.put("new_episode_yn", op_episode_yn);
						blTabdata.put("episode_id", episodeno);
						blTabdata.put("encounterid",encounterid);
						blTabdata.put("visit_date_time",vst_regn_date_time);
						
						if (!visitnum.equals("")) {
							blTabdata.put("episode_visit_no", visitnum);
						} else {
							blTabdata.put("episode_visit_no", "1");
						}
						blTabdata.put("module_id", "OP");
						if (!visitnum.equals("")) {
							prencounter.put("op_episode_visit_num", visitnum);
						} else {
							prencounter.put("op_episode_visit_num", "1");
						}
						if (!visitnum.equals("")) {
							prencounter1.put("op_episode_visit_num", visitnum);
						} else {
							prencounter1.put("op_episode_visit_num", "1");
						}
						BLOPVisit blopVisit = new BLOPVisit();

						Hashtable resultsBL = blopVisit.billPatientService(p,
								con, blTabdata, prencounter1,
								prencounterdetail1);
						boolean boolRes = ((Boolean) (resultsBL.get("status")))
								.booleanValue();
						
						String doctype = (String) (resultsBL.get("billdoctype"));
						String docnum = (String) (resultsBL.get("billdocnum"));						
						String genlater = (String) (resultsBL.get("billgenlater"));						
						String totalamt = (String) (resultsBL.get("billtotalamt"));						
						packageseqno		= (ArrayList) (resultsBL.get("packageseqno"));	//Added for package billing							
						package_enabled_yn	= (String) (resultsBL.get("package_enabled_yn"));	//Added for package billing	
						pkg_codes_for_disc	= (String) (resultsBL.get("pkg_codes_for_disc"));	//Added for package billing							

						str_bill_prt_format_YN = (String)(resultsBL.get("bill_prt_format_YN"));
						str_bill_prt_format_vals = (String)(resultsBL.get("bill_prt_format_vals"));
						pgm_id = (String)(resultsBL.get("pgm_id"));
						session_id = (String)(resultsBL.get("session_id"));
						pgm_date = (String)(resultsBL.get("pgm_date"));
						mpi_id_rep = (String)(resultsBL.get("mpi_id_rep"));

						result = boolRes;
						
						billdoctype = doctype;
						billdocnum = docnum;
						billgenlater = genlater;
						billtotalamt = totalamt;

						strMessage = "";

						if (boolRes == false) {
							insertable = false;
							sb.append((String) resultsBL.get("error"));
						}

						if (boolRes == true) {
							insertable = true;
							strMessage = (String) resultsBL.get("message");
							if (strMessage != null) {
								if (!tabdata.get("mod_id").equals("MP")) {
									if (!strMessage.equalsIgnoreCase("null")) {
										sb.append("<u>" + strMessage
												+ "</u><br></FONT>");
									}
								} else {
									sb.append(strMessage + " ");
								}
							}

						}
						//blTabdata.clear();
						resultsBL.clear();
					}
				} catch (Exception e) {
					insertable = false;
					// con.rollback() ;
					e.printStackTrace();
					sb.append(e.getMessage() + "<br>");
					
				} finally {
				}

				if (con == null) {
					
				}

				}
// Commented By Sridhar Reddy to provide OrderEntry Screen for Satya Sai Change on 14.02.2011	and this logic is move to VisitRegistrationServlet.java at 1809 Line		
			/*	if (insertable) {
					String cs = "";
					String p_order_id = "";
					String catalog_code = (String) tabdata.get("order_catalog_code");					
					try {

						if (!(catalog_code.equals(""))) {			

							cstmt = con
									.prepareCall("{call Or_Insert_Order_Multi_Line (to_char(sysdate,'dd/mm/rrrr hh24:mi'),?,'OP',?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");

							cstmt.setString(1, checkForNull((String) tabdata.get("order_catalog_code")));
							cstmt.setString(2, checkForNull((String) tabdata.get("facility_id")));
							cstmt.setString(3, checkForNull((String) tabdata.get("patient_id")));
							cstmt.setString(4, patientClass);
							cstmt.setString(5, encounterid);
							cstmt.setString(6, episodeno);
							cstmt.setString(7, visitnum);
							cstmt.setString(8, checkForNull((String) prencounter.get("assign_care_locn_type")));
							cstmt.setString(9, checkForNull((String) prencounter.get("assign_care_locn_code")));
							cstmt.setString(10,checkForNull((String) prencounter.get("attend_practitioner_id")));
							cstmt.setString(11, checkForNull((String) tabdata.get("added_by_id")));
							cstmt.setString(12, checkForNull((String) tabdata.get("added_at_ws_no")));

							cstmt.registerOutParameter(13, java.sql.Types.VARCHAR);
							cstmt.registerOutParameter(14, java.sql.Types.NUMERIC);
							cstmt.registerOutParameter(15, java.sql.Types.VARCHAR);
							cstmt.registerOutParameter(16, java.sql.Types.VARCHAR);

							cstmt.setString(17, checkForNull((String) tabdata.get("order_id")));
							cstmt.execute();
							cs = cstmt.getString(16);
							p_order_id = cstmt.getString(13);

							if (cs == null)
								cs = "";

							if(p_order_id == null)
								p_order_id = "";							

							if(!p_order_id.equals("")){
								insertable = true;
							}
							else{
								insertable = false;
								sb.append("Error in OR_ORDER_CATALOG procedure..." + cs);
							}*/

							/*
							if (cs.equals("")) {
								insertable = true;

							} else {
								insertable = false;

							
								java.util.Hashtable message = MessageManager
										.getMessage(con, cs);
								String msgVal = ((String) message
										.get("message"));
								msgVal = msgVal.substring(0,
										msgVal.length() - 4);
								sb.append(msgVal + " OR_ORDER_CATALOG" + cs);
								message.clear();

							}
							*/
					/*	}
						if (cstmt != null)
							cstmt.close();
					} catch (Exception e) {
						insertable = false;
						e.printStackTrace();
					}
				}*/

				if (insertable) {
					try {						

						cstmt = con.prepareCall("{call MP_AUDIT_FUNCTION.ASSIGN_VALUE('VISIT_REGISTRATION')}");
						cstmt.execute();

						if (cstmt != null)
							cstmt.close();

					} catch (Exception e) {
						insertable = false;
						e.printStackTrace();
						sb
								.append("Procedure-MP_AUDIT_FUNCTION:"
										+ e.toString());
						

					}
				}
				
				//Added by Ashwini on 23-Sep-2022 for TH-KW-CRF-0020.1
				if(isQMSInOPVisitRegAppl.equals("true"))
				{
					if (insertable) {
						
						try {						

							String qms_sql = " INSERT INTO op_qms_queue_dtls (facility_id, encounter_id, common_queue_id, common_queue_no, common_queue_issue_dt_tm, common_queue_called_dt_tm, virtual_queue_id, virtual_queue_no, virtual_queue_issue_dt_tm, virtual_queue_called_dt_tm, room_num, added_by_id, added_date, added_at_ws_no, added_facility_id, modified_by_id, modified_date, modified_at_ws_no, modified_facility_id ) VALUES (?, ?, ?, ?, TO_DATE (?, 'dd/mm/yyyy hh24:mi:ss'), TO_DATE (?, 'dd/mm/yyyy hh24:mi:ss'), ?, ?, TO_DATE (?, 'dd/mm/yyyy hh24:mi:ss'), TO_DATE (?, 'dd/mm/yyyy hh24:mi:ss'), ?, ?, SYSDATE, ?, ?, ?, SYSDATE, ?, ? ) ";

							stmt = con.prepareStatement(qms_sql);
							stmt.setString(1, (String) tabdata.get("facility_id"));
							stmt.setString(2, encounterid);
							stmt.setString(3, common_queue_id);
							stmt.setString(4, common_queue_no);
							stmt.setString(5, common_queue_issue_dt_tm);
							stmt.setString(6, common_queue_called_dt_tm);
							stmt.setString(7, virtual_queue_id);
							stmt.setString(8, virtual_queue_no);
							stmt.setString(9, virtual_queue_issue_dt_tm);
							stmt.setString(10, virtual_queue_called_dt_tm);
							stmt.setString(11, room_num);
							stmt.setString(12, (String) tabdata.get("added_by_id"));
							stmt.setString(13, (String) tabdata.get("added_at_ws_no"));
							stmt.setString(14, (String) tabdata.get("added_facility_id"));
							stmt.setString(15, (String) tabdata.get("modified_by_id"));
							stmt.setString(16, (String) tabdata.get("modified_at_ws_no"));
							stmt.setString(17, (String) tabdata.get("modified_facility_id"));
							
							int rcnt = stmt.executeUpdate();
							if (rcnt == 0)
								insertable = false;
							else
								insertable = true;

							if (stmt != null) stmt.close();

						} catch (Exception e) {
							String err_msg = e.getMessage();
							System.err.println("Error in inserting op_qms_queue_dtls: "+err_msg);
							insertable = false;
							e.printStackTrace();
							sb.append("Error in inserting op_qms_queue_dtls: "+e.toString());
						}
					}

					if (insertable) {

						String responseTxt="";
						String p_response="";
						String errorCode="";
						String errorMsg="";
						CallableStatement ostmt = null;
						
						try {						

							ostmt = con.prepareCall("{ CALL XHQMS.XH_QMS_AUDIT(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }" );
							ostmt.setString(1,"VSTREG");
							ostmt.setString(2,(String) tabdata.get("facility_id"));
							ostmt.setString(3,common_queue_id);
							ostmt.setString(4,common_queue_no);
							ostmt.setString(5,common_queue_issue_dt_tm);
							ostmt.setString(6,common_queue_called_dt_tm);
							ostmt.setString(7,(String) tabdata.get("patient_id"));
							ostmt.setString(8,encounterid);
							ostmt.setString(9,encounterid);
							ostmt.setString(10,common_queue_status);
							ostmt.setString(11,common_queue_status_msg);
							ostmt.setString(12,(String) tabdata.get("user_id"));
							ostmt.registerOutParameter(13,java.sql.Types.VARCHAR);
							ostmt.registerOutParameter(14,java.sql.Types.VARCHAR);
							ostmt.registerOutParameter(15,java.sql.Types.VARCHAR);

							ostmt.execute();

							p_response = ostmt.getString(13);
							errorCode = ostmt.getString(14);
							errorMsg = ostmt.getString(15);
							
							if((errorMsg != null) && (errorMsg.trim().length()>0)){
								responseTxt = errorMsg;	
							}else{
								if(errorCode=="S" || "S".equalsIgnoreCase(errorCode)){
									 responseTxt = p_response;
								}else{
									 responseTxt = p_response;
								}
							}

							if (ostmt != null) ostmt.close();

							System.err.println("XHQMS.XH_QMS_AUDIT responseTxt "+responseTxt);
							System.err.println("XHQMS.XH_QMS_AUDIT errorCode "+errorCode);
							System.err.println("XHQMS.XH_QMS_AUDIT errorMsg "+errorMsg);

						} catch (Exception e) {
							String err_msg = e.getMessage();
							System.err.println("Error in inserting Common Queue Details in XHQMS.XH_QMS_AUDIT: "+err_msg);
							insertable = false;
							e.printStackTrace();
							sb.append("Error in inserting Common Queue Details in XHQMS.XH_QMS_AUDIT: "+e.toString());
						}
					}

					if (insertable) {

						String responseTxt="";
						String p_response="";
						String errorCode="";
						String errorMsg="";
						CallableStatement ostmt = null;
						
						try {						

							ostmt = con.prepareCall("{ CALL XHQMS.XH_QMS_AUDIT(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }" );
							ostmt.setString(1,"VSTREG");
							ostmt.setString(2,(String) tabdata.get("facility_id"));
							ostmt.setString(3,virtual_queue_id);
							ostmt.setString(4,virtual_queue_no);
							ostmt.setString(5,virtual_queue_issue_dt_tm);
							ostmt.setString(6,virtual_queue_called_dt_tm);
							ostmt.setString(7,(String) tabdata.get("patient_id"));
							ostmt.setString(8,encounterid);
							ostmt.setString(9,encounterid);
							ostmt.setString(10,virtual_queue_status);
							ostmt.setString(11,virtual_queue_status_msg);
							ostmt.setString(12,(String) tabdata.get("user_id"));
							ostmt.registerOutParameter(13,java.sql.Types.VARCHAR);
							ostmt.registerOutParameter(14,java.sql.Types.VARCHAR);
							ostmt.registerOutParameter(15,java.sql.Types.VARCHAR);

							ostmt.execute();

							p_response = ostmt.getString(13);
							errorCode = ostmt.getString(14);
							errorMsg = ostmt.getString(15);
							
							if((errorMsg != null) && (errorMsg.trim().length()>0)){
								responseTxt = errorMsg;	
							}else{
								if(errorCode=="S" || "S".equalsIgnoreCase(errorCode)){
									 responseTxt = p_response;
								}else{
									 responseTxt = p_response;
								}
							}

							if (ostmt != null) ostmt.close();

							System.err.println("XHQMS.XH_QMS_AUDIT responseTxt "+responseTxt);
							System.err.println("XHQMS.XH_QMS_AUDIT errorCode "+errorCode);
							System.err.println("XHQMS.XH_QMS_AUDIT errorMsg "+errorMsg);

						} catch (Exception e) {
							String err_msg = e.getMessage();
							System.err.println("Error in inserting Virtual Queue Details in XHQMS.XH_QMS_AUDIT: "+err_msg);
							insertable = false;
							e.printStackTrace();
							sb.append("Error in inserting Virtual Queue Details in XHQMS.XH_QMS_AUDIT: "+e.toString());
						}
					}
				}

				// The following procedure call inserted by Smita Unnikrishnan
				// on 24/03/04 for updating the contact details values in the MP
				// table
				//Below Condition Modified By Dharma on 2nd July 2020 against SKR-SCF-1380 & 1381
				//if (insertable && isPractoApptYn.equals("N")) {
				if (insertable && !isPractoApptYn.equals("Y")) {
					String cs = "0";
					try {					

						//cstmt = con.prepareCall("{call MP_PAT_ADD_UPDATE(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
						
						int posCnt = 0;
						
						cstmt = con.prepareCall("{call MP_AUDIT_FUNCTION.UPDATE_ADDRESS_ENCOUNTER(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}"); 
										   
						cstmt.setString( ++posCnt , checkForNull((String) tabdata
								.get("facility_id"))); 						
						cstmt.setString( ++posCnt , encounterid); 
						cstmt.setString( ++posCnt , patientClass);
						cstmt.setString( ++posCnt , checkForNull((String) tabdata
								.get("patient_id"))); 						
						cstmt.setString( ++posCnt , checkForNull((String) tabdata
								.get("res_tel_no")));
						cstmt.setString( ++posCnt , checkForNull((String) tabdata
								.get("oth_contact_no")));
						cstmt.setString( ++posCnt , checkForNull((String) tabdata
								.get("res_area_code")));
						cstmt.setString( ++posCnt , checkForNull((String) tabdata
								.get("res_town_code")));
						cstmt.setString( ++posCnt , checkForNull((String) tabdata
								.get("res_region_code")));
						cstmt.setString( ++posCnt , checkForNull((String) tabdata
								.get("email_id")));	
						cstmt.setString( ++posCnt , checkForNull((String) tabdata
								.get("res_addr_line1")));
						cstmt.setString( ++posCnt , checkForNull((String) tabdata
								.get("res_addr_line2")));
						cstmt.setString( ++posCnt , checkForNull((String) tabdata
								.get("res_addr_line3")));
						cstmt.setString( ++posCnt , checkForNull((String) tabdata
								.get("res_addr_line4"))); 
						cstmt.setString( ++posCnt , checkForNull((String) tabdata
								.get("postal_code")));
						cstmt.setString( ++posCnt , checkForNull((String) tabdata
								.get("country_code")));
						cstmt.setString( ++posCnt , checkForNull((String) tabdata
								.get("mail_addr_line1")));
						cstmt.setString( ++posCnt , checkForNull((String) tabdata
								.get("mail_addr_line2")));
						cstmt.setString( ++posCnt , checkForNull((String) tabdata
								.get("mail_addr_line3")));
						cstmt.setString( ++posCnt , checkForNull((String) tabdata
								.get("mail_addr_line4")));
						cstmt.setString( ++posCnt , checkForNull((String) tabdata
								.get("mail_area_code")));
						cstmt.setString( ++posCnt , checkForNull((String) tabdata
								.get("mail_town_code")));
						cstmt.setString( ++posCnt , checkForNull((String) tabdata
								.get("mail_postal_code")));
						cstmt.setString( ++posCnt , checkForNull((String) tabdata
								.get("mail_region_code")));
						cstmt.setString( ++posCnt , checkForNull((String) tabdata
								.get("mail_country_code")));
						/*Added by Thamizh selvi on 29th Jan 2018 against ML-MMOH-CRF-0601 Start*/
						cstmt.setString( ++posCnt , checkForNull((String) tabdata
								.get("altAddrLine1")));
						cstmt.setString( ++posCnt , checkForNull((String) tabdata
								.get("altAddrLine2")));
						cstmt.setString( ++posCnt , checkForNull((String) tabdata
								.get("altAddrLine3")));
						cstmt.setString( ++posCnt , checkForNull((String) tabdata
								.get("altAddrLine4")));
						cstmt.setString( ++posCnt , checkForNull((String) tabdata
								.get("altAreaCode")));
						cstmt.setString( ++posCnt , checkForNull((String) tabdata
								.get("altTownCode")));
						cstmt.setString( ++posCnt , checkForNull((String) tabdata
								.get("altPostalCode")));
						cstmt.setString( ++posCnt , checkForNull((String) tabdata
								.get("altRegionCode")));
						cstmt.setString( ++posCnt , checkForNull((String) tabdata
								.get("altCountryCode")));
						/*End*/
						cstmt.setString( ++posCnt , checkForNull((String) tabdata
								.get("modified_by_id")));
						cstmt.setString( ++posCnt , checkForNull((String) tabdata
								.get("modified_at_ws_no")));
						cstmt.registerOutParameter( ++posCnt , java.sql.Types.VARCHAR); 
						
						cstmt.execute();
						cs = cstmt.getString(posCnt); 					

						if (cs.equals("1")) {
							insertable = true;
							//added changes for HSA-CRF-0226 [IN:050599]
							String upt_contact_dtls_oa_yn=checkForNull((String)tabdata.get("upt_contact_dtls_oa_yn"));
							if(upt_contact_dtls_oa_yn.equals("Y")){
							String  appt_count="select count(*)apt_cnt from oa_appt where patient_id='"+checkForNull((String)tabdata.get("patient_id"))+"' and APPT_DATE>= to_date(sysdate,'DD MM YY')";
									if(rset!=null) rset.close();
		                            if(stmt!=null) stmt.close();
									stmt = con.prepareStatement(appt_count);
									rset=stmt.executeQuery();
									int apt_cnt=0;
									if(rset != null && rset.next()){
									apt_cnt=rset.getInt("apt_cnt");
									   }
									if(apt_cnt > 0){
								StringBuffer update_app_contact_dtl = new StringBuffer();
								update_app_contact_dtl.append("update oa_appt set res_tel_no='"+checkForNull((String) tabdata
								.get("res_tel_no"))+"', oth_contact_no='"+checkForNull((String) tabdata
								.get("oth_contact_no"))+"',email_id='"+checkForNull((String) tabdata
								.get("email_id"))+"', res_addr_line1='"+checkForNull((String) tabdata.get("res_addr_line1")).replaceAll("'","''")+"', res_addr_line2='"+checkForNull((String) tabdata.get("res_addr_line2")).replaceAll("'","''")+"',res_addr_line3='"+checkForNull((String) tabdata.get("res_addr_line3")).replaceAll("'","''")+"', res_addr_line4='"+checkForNull((String) tabdata.get("res_addr_line4")).replaceAll("'","''")+"',postal_code='"+checkForNull((String) tabdata.get("postal_code"))+"',modified_date=sysdate,modified_facility_id='"+ checkForNull((String) tabdata.get("facility_id"))+"',modified_by_id='"+checkForNull((String) tabdata
								.get("modified_by_id"))+"', modified_at_ws_no='"+checkForNull((String) tabdata
								.get("modified_at_ws_no"))+"',RES_AREA_CODE='"+checkForNull((String) tabdata
								.get("res_area_code"))+"',RES_TOWN_CODE='"+checkForNull((String) tabdata
								.get("res_town_code"))+"',RES_REGION_CODE='"+checkForNull((String) tabdata
								.get("res_region_code"))+"',MAIL_ADDR_LINE1='"+checkForNull((String) tabdata.get("mail_addr_line1")).replaceAll("'","''")+"',MAIL_ADDR_LINE2='"+checkForNull((String) tabdata.get("mail_addr_line2")).replaceAll("'","''")+"',MAIL_ADDR_LINE3='"+checkForNull((String) tabdata.get("mail_addr_line3")).replaceAll("'","''")+"',MAIL_ADDR_LINE4='"+checkForNull((String) tabdata.get("mail_addr_line4")).replaceAll("'","''")+"',MAIL_AREA_CODE='"+checkForNull((String) tabdata.get("mail_area_code"))+"',MAIL_TOWN_CODE='"+checkForNull((String) tabdata.get("mail_town_code"))+"',MAIL_REGION_CODE='"+checkForNull((String) tabdata
								.get("mail_region_code"))+"',MAIL_POSTAL_CODE='"+checkForNull((String) tabdata
								.get("mail_postal_code"))+"',MAIL_COUNTRY_CODE='"+checkForNull((String) tabdata
								.get("mail_country_code"))+"',RES_COUNTRY_CODE='"+checkForNull((String) tabdata
								.get("country_code"))+"',ALT_ADDR_LINE1='"+checkForNull((String) tabdata.get("altAddrLine1")).replaceAll("'","''")+"',ALT_ADDR_LINE2='"+checkForNull((String) tabdata.get("altAddrLine2")).replaceAll("'","''")+"',ALT_ADDR_LINE3='"+checkForNull((String) tabdata.get("altAddrLine3")).replaceAll("'","''")+"',ALT_ADDR_LINE4='"+checkForNull((String) tabdata.get("altAddrLine4")).replaceAll("'","''")+"',ALT_AREA_CODE='"+checkForNull((String) tabdata.get("altAreaCode"))+"',ALT_TOWN_CODE='"+checkForNull((String) tabdata.get("altTownCode"))+"',ALT_REGION_CODE='"+checkForNull((String) tabdata
								.get("altRegionCode"))+"',ALT_POSTAL_CODE='"+checkForNull((String) tabdata
								.get("altPostalCode"))+"',ALT_COUNTRY_CODE='"+checkForNull((String) tabdata
								.get("altCountryCode"))+"' where patient_id='"+checkForNull((String) tabdata
								.get("patient_id"))+"' and APPT_DATE>= to_date(sysdate,'DD MM YY')");//Modified by Thamizh selvi on 29th Jan 2018 against ML-MMOH-CRF-0601
							if(stmt!=null)stmt.close();
					        stmt=con.prepareStatement(update_app_contact_dtl.toString());
					        stmt.executeUpdate();
							update_app_contact_dtl.setLength(0);
							}
							}
							//end  of HSA-CRF-0226 [IN:050599]
						} else {
							insertable = false;
							String msgVal = "Error While UPDATING MP_PAT_ADD";
							System.err.println("Error While UPDATING MP_PAT_ADD:"
										+ msgVal);
							sb.append(msgVal); 
						}

						if (cstmt != null)
							cstmt.close();
					} catch (Exception e) {

						e.printStackTrace();
						insertable = false;
						System.err.println("Procedure-MP_PAT_ADD_UPDATE:"
										+ e.toString());
						sb.append("Procedure-MP_PAT_ADD_UPDATE:"
										+ e.toString());
						
					} 
				}

	//Maheshwaran K added for AAKH-CRF-0175 as on 23-08-2023
	//Starts
	try 
		{
		String biometric_reason=checkForNull((String)tabdata.get("biometric_reason"));
		if(insertable && smartCardFunc.equals("01") && !biometric_reason.equals(""))
			{
			String status=CommonBean.insertReasonforBiometric(con,checkForNull((String) tabdata.get("facility_id")),"OP_REG_VISIT",checkForNull((String) tabdata.get("patient_id")),encounterid,(String) prencounter.get("assign_care_locn_code"),biometric_reason,checkForNull((String) tabdata.get("modified_at_ws_no")),checkForNull((String) tabdata.get("modified_by_id")));
			if(status.equals("S"))
				{
				insertable	= true;	
				}
			else {
				insertable	= false;
				}	
			} 
		}
	catch(Exception e)
		{
		insertable	= false;
		e.printStackTrace();
		}
	//Ends
				//Changes done on 25/4/2013 for Billing issue - start
				if (insertable) {				
					if ((tabdata.get("bl_install_yn").equals("Y"))
							&& (insertable == true)) {
						try{
						String bl_cnt_visitnum="";
						if (!visitnum.equals("")) {
							bl_cnt_visitnum=visitnum;
						} else {
							bl_cnt_visitnum= "1";
						}
						String bl_count_sql="select count(*) from bl_visit_fin_dtls where patient_id = '"+(String) tabdata.get("patient_id")+"'  and episode_id = "+episodeno+"  and visit_id ="+bl_cnt_visitnum+" and episode_type = 'O' and OPERATING_FACILITY_ID = '"+(String) tabdata.get("facility_id")+"'";
						PreparedStatement bl_count_stmt = con.prepareStatement(bl_count_sql);	
						ResultSet bl_count_rs=bl_count_stmt.executeQuery();
						int bl_fin_cnt=0;
						while(bl_count_rs.next()){
							bl_fin_cnt=bl_count_rs.getInt(1);
						}
						if (bl_fin_cnt > 0){
							insertable=true;
						}else{
							insertable=false;
							sb.append("Transaction could not be completed.  Please try again... ");
						}
						if (bl_count_stmt != null) bl_count_stmt.close(); //Added for checkstyle
						if (bl_count_rs != null) bl_count_rs.close(); //Added for checkstyle
					}catch(Exception bl_exception){
						System.err.println(bl_exception.getMessage());
						bl_exception.printStackTrace();						
						insertable=false;
						sb.append("Transaction could not be completed.  Please try again... ");
					}
				}
				}
				//Changes done on 25/4/2013 for Billing issue - end

				if (insertable) {
					result = true;

					con.commit();
					java.util.Hashtable message1 = MessageManager.getMessage(
							locale, "VISIT_REGN_COMPL", "OP");
					String msgVal = ((String) message1.get("message"));
					if (!tabdata.get("mod_id").equals("MP")) {
						msgVal = msgVal.substring(0, msgVal.length());

						sb.append(msgVal + "<B><FONT SIZE=4>" + encounterid
								+ "</B></FONT>");
					} else {

						sb.append(msgVal + " " + encounterid);
					}
					
					//Added by Ashwini on 23-Sep-2022 for TH-KW-CRF-0020.1
					if(isQMSInOPVisitRegAppl.equals("true"))
					{
						if(virtual_queue_status.equals("S")){
							java.util.Hashtable succ_msg = MessageManager.getMessage(locale, "NEW_QUEUE_SUCCESS", "OP");
							String succ_msgVal = ((String) succ_msg.get("message"));
							sb.append("</br>" + succ_msgVal);
							succ_msg.clear();
						}else{
							java.util.Hashtable fail_msg = MessageManager.getMessage(locale, "NEW_QUEUE_FAILED", "OP");
							String fail_msgVal = ((String) fail_msg.get("message"));
							sb.append("</br>" + fail_msgVal);
							fail_msg.clear();
						}
					}

					if (stmt != null)
						stmt.close();
					message1.clear();
				} else {
					// Added by Muthu on 28/06/2010 Issue :- Internal report window should not be called if the transaction fails.
					result = false;
					con.rollback();

					if (msg.equals("Y")) {
                        	java.util.Hashtable message = MessageManager.getMessage(locale,
						  "OPEN_VISIT_STATUS_FOR_SERVICE", "OP");
				           sb.append((String) message.get("message"));
						   message.clear();
						
						
					} else if (msgEncounter.equals("Y")) {

						java.util.Hashtable message = MessageManager
								.getMessage(locale, "ENC_ID_REACHED_MAX",
										"Common");
						sb.append((String) message.get("message"));
						message.clear();

					} else {
						if (appt_status.equals("A")) {
							java.util.Hashtable message = MessageManager
									.getMessage(locale,
											"VISIT_REGISTERED_FOR_APPT", "OP");
							sb.append((String) message.get("message"));
							message.clear();
						} else if (refStatus.equals("C")) {
							java.util.Hashtable message = MessageManager
									.getMessage(locale,
											"VISIT_REGISTERED_FOR_REFERRAL",
											"OP");
							sb.append((String) message.get("message"));
							message.clear();
						}
					}
				}
			} catch (Exception e1) {
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
				}

				result = false;
				sb.append(e1);
			}

			tabdata.clear();
			prencounter.clear();
			prencounterdetail.clear();
			tabdata1.clear();
			prencounter1.clear();
			prencounterdetail1.clear();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			if (con != null)
				ConnectionManager.returnConnection(con, p);
			if (con != null) {
				try {

					//if (st != null)
					//	st.close();

					//if (statement != null)
					//	statement.close();
					//if (stmtc != null)
					//	stmtc.close();
					if (stmt != null)
						stmt.close();
					if(rset!=null) 
						rset.close();//Added by kamatchi for Checkstyle
				} catch (Exception ee) {
				}

			}
		}

		// ENDS HERE

		results.put("status", new Boolean(result));
		results.put("error", sb.toString());

		// ML-04-START
		if (billdoctype != null || billdoctype != "") {

			results.put("billdoctype", billdoctype);
			results.put("billdocnum", billdocnum);

		}
		results.put("billgenlater", billgenlater);
		results.put("billtotalamt", billtotalamt);
		results.put("packageseqno", packageseqno);
		results.put("package_enabled_yn", package_enabled_yn);
		results.put("pkg_codes_for_disc", pkg_codes_for_disc);

		results.put("bill_prt_format_YN", str_bill_prt_format_YN);
		results.put("bill_prt_format_vals", str_bill_prt_format_vals);
		results.put("pgm_id", pgm_id);
		results.put("session_id", session_id);
		results.put("pgm_date", pgm_date);
		results.put("mpi_id_rep", mpi_id_rep);

		// ML-04-END

		results.put("p_encounter_id", encounterid);
		results.put("p_episode_id", episodeno);
		results.put("p_episode_visit_num", visitnum);

		// mod#05 Added the bl_message param
		if (strMessage == null) {
			strMessage = "0";
		}

		results.put("bl_message", strMessage);

		//packageseqno.clear();

		return results;
	}

	public java.util.HashMap opparamforfacilityservice(

	HashMap paramdata, Properties p,Connection con) {

		//Connection con = null; 
		ResultSet rs_facility = null;

		java.util.HashMap results = new java.util.HashMap();
		PreparedStatement pstmt = null;
		StringBuffer sb = new StringBuffer("");
		String sql = "";
		int cnt = 0;
		PreparedStatement mystat 	= null;
		boolean 	inserted 				= true;
		try {

			//con = ConnectionManager.getConnection(p);

			sql = "select build_episode_rule from op_param_for_facility_service where operating_facility_id=? and service_code=?";
			Object[] obj1 = new Object[2];

			obj1[0] = paramdata.get("facility_id");
			obj1[1] = paramdata.get("service_code");
			
			pstmt = con.prepareStatement(sql);

			
			

			pstmt = setData(pstmt, obj1);
			rs_facility = pstmt.executeQuery();			

		
			if (rs_facility != null && !rs_facility.next()) {	
				
				

		
				obj1 = new Object[11];

				sql = "insert into op_param_for_facility_service (operating_facility_id,service_code,build_episode_rule, episode_close_days_fu,episode_close_days_wo_fu, added_by_id, added_date,added_facility_id,added_at_ws_no,  modified_by_id,modified_date,modified_facility_id,modified_at_ws_no ) values (?,?,?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?)"; 
				
				obj1[0] = (String) paramdata.get("facility_id");
				obj1[1] = (String) paramdata.get("service_code");
				obj1[2] = (String) paramdata.get("build_episode_rule");
				obj1[3] = (String) paramdata.get("episode_close_days_fu");
				obj1[4] = (String) paramdata.get("episode_close_days_wo_fu");
				obj1[5] = (String) paramdata.get("added_by_id");
				obj1[6] = (String) paramdata.get("added_facility_id");
				obj1[7] = (String) paramdata.get("added_at_ws_no");
				obj1[8] = (String) paramdata.get("modified_by_id");
				obj1[9] = (String) paramdata.get("modified_facility_id");
				obj1[10] = (String) paramdata.get("modified_at_ws_no");				

				mystat = con.prepareStatement(sql);
				mystat = setData(mystat, obj1);
				cnt = mystat.executeUpdate();
				
				
				if (cnt != 0)
					inserted = true;
				else {
					inserted = false;				
					sb.append("Error in inserting to  OP_PARAM_FOR_FACILITY_SERVICE");					
				}

				if (mystat != null)
					mystat.close();
			}

			if (rs_facility != null)
				rs_facility.close();
			if (pstmt != null)
				pstmt.close();
			

		} catch (Exception exc3) {
			inserted = false;

			sb.append("Exception while inserting into OP_PARAM_FOR_FACILITY_SERVICE :"
							+ exc3);
			
			exc3.printStackTrace();
		} finally {
			//if (con != null)
				//ConnectionManager.returnConnection(con, p);
		}

		results.put("status", new Boolean(inserted));
		results.put("error", sb.toString());
		return results;
	}

	// The below method access modifier is changed as private 
	private java.util.HashMap opepisodeforservice(

	HashMap episodedata, HashMap episodeencounter, String visitnum,
			String episodeno, String oldepisodeno, Properties p,Connection con) {

		//Connection con = null; 

		String vst_regn_date_time = (String) episodedata.get("vst_regn_date_time"); 
		String visit_type_derv_rule="";//Added for the SCF - MMS-SCF-0082
		PreparedStatement pstmt = null;

		java.util.HashMap results = new java.util.HashMap();

		StringBuffer sb = new StringBuffer("");
		StringBuffer sql = new StringBuffer();
		sql.setLength(0);
		int cnt = 0;
		boolean 	ins_upd_episode  	= true;
		String 	encounterid 	= "";
		try {
			//con = ConnectionManager.getConnection(p);
			String buildepisoderule = (String) episodedata
					.get("build_episode_rule");
			encounterid = episodeno + visitnum;

			if (oldepisodeno == null || oldepisodeno.equals(""))
				oldepisodeno = "";
			
			if (visitnum.equals("0001")) {
				try {
					if (buildepisoderule.equals("S")) {						

						  //sql.setLength(0);
						String ins_sql = "insert into op_episode_for_service(patient_id,operating_facility_id,episode_id, clinic_code,service_code, start_date_time,episode_status, last_encounter_id, last_visit_date,last_visit_num,added_by_id,added_date,added_facility_id,added_at_ws_no,   modified_by_id,modified_date,modified_facility_id,modified_at_ws_no,subservice_code,LAST_VISIT_FU_REQD_YN,BLNG_GRP_ID,CUST_CODE,CUST_GRP_CODE,POLICY_TYPE_CODE) values(?,?,?,?,?,To_Date('"+vst_regn_date_time+"','dd/mm/yyyy hh24:mi:ss'),'01',?,To_Date('"+vst_regn_date_time+"','dd/mm/yyyy hh24:mi:ss'),1,?,sysdate,?,?,?,sysdate,?,?,?,'N',?,?,?,?) ";//modified by Srinivasrao Yeluri on 22/02/2012 for Incident no 29368

						//sql.append("start_date_time,episode_status, last_encounter_id, last_visit_date,last_visit_num,");

						//sql.append("added_by_id,added_date,added_facility_id,added_at_ws_no,   modified_by_id,modified_date,modified_facility_id,modified_at_ws_no,subservice_code,LAST_VISIT_FU_REQD_YN)");

						//sql.append("values(?,?,?,?,?,sysdate,'01',?,To_Date('"+vst_regn_date_time+"','dd/mm/yyyy hh24:mi'),1,?,sysdate,?,?,?,sysdate,?,?,?,'N')");						

						Object[] obj = new Object[18];
						obj[0] = (String) episodedata.get("patient_id");
						obj[1] = (String) episodedata.get("facility_id");
						obj[2] = (String) episodeno;
						obj[3] = (String) episodeencounter
								.get("assign_care_locn_code");
						obj[4] = (String) episodedata.get("service_code");
						obj[5] = encounterid;
						obj[6] = (String) episodedata.get("added_by_id");
						obj[7] = (String) episodedata.get("added_facility_id");
						obj[8] = (String) episodedata.get("added_at_ws_no");
						obj[9] = (String) episodedata.get("modified_by_id");
						obj[10] = (String) episodedata
								.get("modified_facility_id");
						obj[11] = (String) episodedata.get("modified_at_ws_no");
						obj[12] = (String) episodedata.get("subservice_code");
						obj[13] = (String) episodedata.get("blng_grp_id");
						obj[14] = (String) episodedata.get("cust_code");
						obj[15] = (String) episodedata.get("cust_grp_code");
						obj[16] = (String) episodedata.get("subservice_code");
						
						pstmt = con.prepareStatement(ins_sql);
						pstmt = setData(pstmt, obj);
					}
					cnt = pstmt.executeUpdate();

					if (cnt != 0)
						ins_upd_episode = true;
					else {
						ins_upd_episode = false;					
						sb.append("Error in inserting into OP_EPISODE_FOR_SERVICE");						
					}

					if (pstmt != null)
						pstmt.close();

				} catch (Exception e) {
					e.printStackTrace();
					ins_upd_episode = false;
					sb
							.append("Exception in inserting in OP_EPISODE_FOR_SERVICE :"
									+ e);
					
				}
				if (pstmt != null)
					pstmt.close();

				sql.setLength(0);
				/* 
				String sqlc = "";
				if (insertable) {
					if (buildepisoderule.equals("S")) {
						try {							

							sqlc = "update op_episode_for_service set episode_status='99', MODIFIED_BY_ID =?, MODIFIED_DATE = sysdate, MODIFIED_AT_WS_NO = ?, MODIFIED_FACILITY_ID	= ? where operating_facility_id = ? and service_code = ? and episode_id !=? and patient_id = ? and episode_status = '01'";

							Object[] obj = new Object[7];
							obj[0] = (String) episodedata.get("modified_by_id");
							obj[1] = (String) episodedata.get("modified_at_ws_no");
							obj[2] = (String) episodedata.get("modified_facility_id");
							obj[3] = (String) episodedata.get("facility_id");
							obj[4] = (String) episodedata.get("service_code");
							obj[5] = episodeno;
							obj[6] = (String) episodedata.get("patient_id");
							
							pstmt = con.prepareStatement(sqlc);

							pstmt = setData(pstmt, obj);

							cnt = pstmt.executeUpdate();

							if (cnt != 0)
								insertable = true;
							else
								insertable = false;

							//if (stmtc != null)
							//	stmtc.close();
						} catch (Exception exc6) {
							insertable = false;
							sb
									.append("Exception while Updating op_episode_for_service :"
											+ exc6);
							
						}
					}
				} */
			} else {
				try {
					if (buildepisoderule.equals("S")) {

						visit_type_derv_rule= (String) episodedata.get("visit_type_derv_rule")==null?"S":(String) episodedata.get("visit_type_derv_rule");//Added for the SCF - MMS-SCF-0082 
						sql.setLength(0);

						sql.append("update op_episode_for_service set last_encounter_id = ?, 	last_visit_date = To_Date('"+vst_regn_date_time+"','dd/mm/yyyy hh24:mi:ss'), last_visit_num = last_visit_num +1,BLNG_GRP_ID=?,CUST_CODE=?,CUST_GRP_CODE=?,POLICY_TYPE_CODE=?, MODIFIED_BY_ID =?, MODIFIED_DATE = sysdate, MODIFIED_AT_WS_NO = ?, MODIFIED_FACILITY_ID	= ? where operating_facility_id = ? ");
						//Added for the SCF - MMS-SCF-0082 - start
						if(!visit_type_derv_rule.equals("B")){
							sql.append(" and service_code = ? ");
						}
						//Added for the SCF - MMS-SCF-0082 - end
						sql.append(" and episode_id =? and patient_id = ?");//modified by Srinivasrao Yeluri on 22/02/2012 for Incident no 29368

						Object[] obj = new Object[12];
						obj[0] = encounterid;
						obj[1] = (String) episodedata.get("blng_grp_id");
						obj[2] = (String) episodedata.get("cust_code");
						obj[3] = (String) episodedata.get("cust_grp_code");
						obj[4] = (String) episodedata.get("policy_type_code");
						obj[5] = (String) episodedata.get("modified_by_id");
						obj[6] = (String) episodedata.get("modified_at_ws_no");
						obj[7] = (String) episodedata.get("modified_facility_id");						
						obj[8] = (String) episodedata.get("facility_id");
						//Added for the SCF - MMS-SCF-0082 - start
						if(!visit_type_derv_rule.equals("B")){
							obj[9] = (String) episodedata.get("service_code");
							obj[10] = oldepisodeno;
							obj[11] = (String) episodedata.get("patient_id");	
						}else{
							obj[9] = oldepisodeno;
							obj[10] = (String) episodedata.get("patient_id");	
						}
						//Added for the SCF - MMS-SCF-0082 - end
						pstmt = con.prepareStatement(sql.toString());
						pstmt = setData(pstmt, obj);

					}
					cnt = pstmt.executeUpdate();
					if (cnt != 0)
						ins_upd_episode = true;
					else{
						ins_upd_episode = false;
						sb.append("Error in Updating into OP_EPISODE_FOR_SERVICE");			
					}


					if (pstmt != null)
						pstmt.close();
				} catch (Exception ee) {
					ee.printStackTrace();
				}
				if (pstmt != null)
					pstmt.close();
			}
			sql.setLength(0);

		} catch (Exception e) {
			ins_upd_episode = false;

			sb.append("Exception in method of OP_EPISODE_FOR_SERVICE :" + e);
			e.printStackTrace();

		} finally {
			//if (con != null)
			//	ConnectionManager.returnConnection(con, p);
		}
		results.put("encounterid",encounterid);
		results.put("status", new Boolean(ins_upd_episode));
		results.put("error", sb.toString());
		return results;
	}

	private PreparedStatement setData(PreparedStatement stmt, Object[] obj) {
		try {
			for (int i = 0; i < obj.length; i++) {
				if (obj[i] instanceof java.sql.Date) {

					if (obj[i] instanceof java.sql.Date)
						stmt.setDate((i + 1), (java.sql.Date) obj[i]);
				}

				if (obj[i] instanceof String) {
					if (((String) obj[i]).equalsIgnoreCase("null"))
						stmt.setString((i + 1), null);
					else if ((String) obj[i] == null)
						stmt.setString((i + 1), null);
					else
						stmt.setString((i + 1), (String) obj[i]);
				}

				if (obj[i] instanceof Integer) {
					stmt.setInt((i + 1), (((Integer) obj[i]).intValue()));
				}

				if (obj[i] instanceof Long) {
					stmt.setLong((i + 1), (((Long) obj[i]).longValue()));
				}

				if (obj[i] instanceof Double) {
					stmt.setDouble((i + 1), (((Double) obj[i]).doubleValue()));
				}

				if (obj[i] instanceof Float) {
					stmt.setFloat((i + 1), (((Float) obj[i]).floatValue()));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return (stmt);
	}

	private String checkForNull(String inputString) {
		return ((inputString == null) || inputString.equals("null")) ? ""
				: inputString;
	}
}
