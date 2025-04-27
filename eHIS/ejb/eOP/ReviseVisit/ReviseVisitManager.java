/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eOP.ReviseVisit;

import blopin.*;
import java.rmi.*;
import javax.ejb.*;
import java.sql.*;
import javax.naming.*;
import javax.rmi.*;
import java.util.*;
import webbeans.eCommon.*;
//import eOP.QMSInterface;

/**
*
* @ejb.bean 
*	name="ReviseVisit"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="ReviseVisit"
*	local-jndi-name="ReviseVisit"
*	impl-class-name="eOP.ReviseVisit.ReviseVisitManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eOP.ReviseVisit.ReviseVisitLocal"
*	remote-class="eOP.ReviseVisit.ReviseVisitRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eOP.ReviseVisit.ReviseVisitLocalHome"
*	remote-class="eOP.ReviseVisit.ReviseVisitHome"
*	generate= "local,remote"
*
*
*/

public class ReviseVisitManager implements SessionBean {

	Connection conn;

	PreparedStatement pstmt = null;

	//ResultSet	rs_qnum;

	CallableStatement cstmt = null;

//	public final String RECORD_INSERTED = "RECORD_INSERTED";

	int result0 = 0;

	int result3 = 0;

	int result4 = 0;

	int result5 = 0;

	int result6 = 1;

	int r = 1;

	int z = 1;

	int res7 = 1;

	String facilityId = "";

	String L_practitioner_id = "";

	//int L_queuenum = 0;
	String L_queuenum="0";//Maheshwaran K changed for ML-BRU-CRF-0628.11	

	SessionContext ctx;

	java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat(
			"yyyy-MM-dd");

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

	public java.util.HashMap insertReviseVisit(java.util.Properties p,
			java.util.HashMap tabdata, java.util.Hashtable BLtabdata) {

		StringBuffer sbredirect = new StringBuffer();
		StringBuffer debug_buffer = new StringBuffer();
		HashMap rethash = new HashMap();
		boolean insertable = true;
		String strBLMessage = "0";

		String billgenlater = "";
		String billtotalamt = "";

		String str_bill_prt_format_YN = "N";
		String pgm_id ="";
		String session_id ="";
		String pgm_date ="";
		String mpi_id_rep = "";
		String qms_interfaced_yn="N";
		String queue_num="";
		String addedById="";
		String modifiedAtWorkstation="";
		String patientid="";
		String eid="";
		String modifiedFacilityId="";
		
		String Sydate="";//this line added for this CRF Bru-HIMS-CRF-133
		String queuestatus="";//this line added for this CRF Bru-HIMS-CRF-133
		
		try {

			conn = ConnectionManager.getConnection(p);
			this.conn.setAutoCommit(false);
			String locale = p.getProperty("LOCALE");
			patientid = (String) tabdata.get("patient_id");			
			Sydate = (String) tabdata.get("Sysdate");	//this line added for this CRF Bru-HIMS-CRF-133	
            
			queuestatus = (String) tabdata.get("queuestatus");	//this line added for this CRF Bru-HIMS-CRF-133	
			
			
			String referral_id = (String) tabdata.get("referal_id");
			String referral_id_old = (String) tabdata.get("referral_id_old");
			if (referral_id == null)referral_id = "";			
			if (referral_id_old == null)referral_id_old = "";			
			String appt_id = (String) tabdata.get("appt_ref_no");
			eid = (String) tabdata.get("l_encounter_id");
			String assign_q_num_by = (String) tabdata.get("assign_q_num_by");
			String cur_locn_code = (String) tabdata.get("cur_locn_code");
			String cur_locn_type = (String) tabdata.get("cur_locn_type");
			String asn_locn_code = "";
			String asn_care_locn_type = (String) tabdata
					.get("asn_care_locn_type");
			String room_num = (String) tabdata.get("room_num");
			String chg_flag = (String) tabdata.get("chg_flag");

			String cur_visit_type_code = (String) tabdata
					.get("cur_visit_type_code");
			String asn_visit_type_code = (String) tabdata
					.get("asn_visit_type_code");
			if (asn_visit_type_code == null)
				asn_visit_type_code = "";
			String service_code = (String) tabdata.get("cur_service_code");
			String assignedServiceCode = (String) tabdata
					.get("assignedServiceCode");
			String assignedSubServiceCode = (String) tabdata
					.get("assignedSubServiceCode");			

			String specialty_code = (String) tabdata.get("cur_specialty_code");
			String identatcheckin = (String) tabdata.get("ident_at_checkin");
			String cur_practitioner_id = (String) tabdata
					.get("cur_practitioner_id");

			if (cur_practitioner_id == null || cur_practitioner_id.equals("*ALL"))
				cur_practitioner_id = "";

			String cur_team_id = (String) tabdata.get("cur_team_id");
			String cur_pract_type = (String) tabdata.get("cur_pract_type");
			if (cur_pract_type == null)
				cur_pract_type = "*";

			String asn_practitioner_id = (String) tabdata.get("asn_pract_id");

			if (asn_practitioner_id == null || asn_practitioner_id.equals("*ALL"))
				asn_practitioner_id = "";

			//if (asn_practitioner_id.equals(""))
			//	asn_practitioner_id = cur_practitioner_id;

			String op_episode_id = (String) tabdata.get("last_episode_no");
			if (op_episode_id == null)
				op_episode_id = "";
			String op_episode_visit_num = (String) tabdata.get("last_visit_no");
			if (op_episode_visit_num == null)
				op_episode_visit_num = "";

			String other_res_type = (String) tabdata.get("other_res_type");
			String other_res_code = (String) tabdata.get("other_res_code");
			String appt_walk_ind = (String) tabdata.get("appt_walk_ind");
			String queue_date = (String) tabdata.get("queue_date");
			queue_num = (String) tabdata.get("queue_num");
			qms_interfaced_yn = (String) tabdata.get("qms_interfaced_yn");
			String queue_id = (String) tabdata.get("queue_id");
			
			//int q_num = Integer.parseInt(queue_num.trim());
			String q_num =queue_num.trim();//Maheshwaran K changed for ML-BRU-CRF-0628.11	

			String assign_care_locn_code1 = (String) tabdata
					.get("asn_locn_code");
			debug_buffer.append("assign_care_locn_code1"
					+ assign_care_locn_code1);
			if (assign_care_locn_code1 != null) {
				asn_locn_code = assign_care_locn_code1.substring(0,
						assign_care_locn_code1.indexOf("|"));
			}

			String ambulatory_status = (String) tabdata
					.get("ambulatory_status");
			String h_visit_type_ind = (String) tabdata.get("h_visit_type_ind");
			String revise_reason_code = (String) tabdata
					.get("revise_reason_code");
			
			/*Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114*/
			String other_remarks = (String) tabdata.get("other_remarks"); 
			String contact_reason_code = (String) tabdata.get("contact_reason_code"); 
			String other_reason_remarks = (String) tabdata.get("other_reason_remarks"); 
			/*End ML-MMOH-CRF-1114*/

			String unlinkapptcaseyn = (String) tabdata.get("unlinkapptcaseyn");
			facilityId = (String) tabdata.get("facilityId");
			StringBuffer sql4 = new StringBuffer();
			StringBuffer sql10 = new StringBuffer();

			String bl_interface_yn = (String) tabdata.get("bl_interface_yn");
			if (bl_interface_yn == null)
				bl_interface_yn = "N";

			if (appt_id == null)
				appt_id = "";

			String queID = "";
			addedById = p.getProperty("login_user");
			String addedDate = dateFormat.format(new java.util.Date());
			String modifiedById = addedById;
			String modifiedDate = addedDate;
			String addedFacilityId = facilityId;
			modifiedFacilityId = addedFacilityId;
			String addedAtWorkstation = (String) tabdata
					.get("client_ip_address");
			modifiedAtWorkstation = addedAtWorkstation;

			java.sql.Date added_date = java.sql.Date.valueOf(addedDate);
			java.sql.Date modified_date = java.sql.Date.valueOf(modifiedDate);			


			// Queue numbering starts here..

			if(insertable)	
			{
				try 
				{
					if (other_res_type.equals(""))
						other_res_type = "*";
					if (other_res_code.equals(""))
						other_res_code = "*ALL";

					if (identatcheckin.equals("P"))
						L_practitioner_id = asn_practitioner_id;
					else {
						if (asn_practitioner_id == null
								|| asn_practitioner_id.equals(""))
							L_practitioner_id = "*ALL";
						else
							L_practitioner_id = asn_practitioner_id;
					}					
					
					if (room_num.equals(""))
						room_num = "*ALL";					
			
					if(assign_q_num_by.equals("M"))
					{
						L_queuenum = q_num;
						queID = queue_id;
						result3 = 1;
					}
					else if(assign_q_num_by.equals("S"))
					{
						if (chg_flag.equals("Y") || q_num.equals("0")) {//Maheshwaran K changed for ML-BRU-CRF-0628.11	

							try {

								//int quenum = 0;	
								String quenum = "0";//Maheshwaran K changed for ML-BRU-CRF-0628.11		
								if(qms_interfaced_yn.equals("N")){
								cstmt = conn.prepareCall("{call OP_QUEUE_NUM_FOR_LOCN_PRC(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
								cstmt.setString(1, facilityId);
								cstmt.setString(2, queue_date);

								if (!cur_locn_type.equals(asn_care_locn_type))
									cstmt.setString(3, asn_care_locn_type);
								else
									cstmt.setString(3, cur_locn_type);

								if (!cur_locn_code.equals(asn_locn_code))
									cstmt.setString(4, asn_locn_code);
								else
									cstmt.setString(4, cur_locn_code);

								cstmt.setString(5, L_practitioner_id);
								cstmt.setString(6, room_num);
								cstmt.setString(7, other_res_type);
								cstmt.setString(8, other_res_code);
								cstmt.setString(9, appt_walk_ind);
								cstmt.setString(10, addedById);
								cstmt.setString(11, addedAtWorkstation);
								//cstmt.setInt(12, q_num);
								cstmt.setString(12, q_num);//Maheshwaran K changed for ML-BRU-CRF-0628.11	
								
								cstmt.setString(13, queue_id);
								cstmt.registerOutParameter(14, java.sql.Types.VARCHAR);
								//cstmt.registerOutParameter(15, java.sql.Types.INTEGER);
								cstmt.registerOutParameter(15, java.sql.Types.VARCHAR);//Maheshwaran K changed for ML-BRU-CRF-0628.11	
								cstmt.execute();
								queID = cstmt.getString(14);
								//quenum = cstmt.getInt(15);
								quenum = cstmt.getString(15);//Maheshwaran K changed for ML-BRU-CRF-0628.11	

								if (queID == null || queID.equals("null"))
									queID = "";

								//if (quenum >= 0) {
								if (quenum.equals("0") || !quenum.equals("-1") || !quenum.equals("-2")) {	//Maheshwaran K changed for ML-BRU-CRF-0628.11	
									result3 = 1;
									L_queuenum = quenum;

								} else if (quenum.equals("-1")) {//Maheshwaran K changed for ML-BRU-CRF-0628.11	
									insertable = false;
									result3 = 0;
								  java.util.Hashtable message = MessageManager.getMessage(locale,
								  "QUEUE_ID_NOT_ATTACHED", "OP");
								  sbredirect.append((String) message.get("message"));
								  message.clear();
						
									
								} else if (quenum.equals("-2")) {//Maheshwaran K changed for ML-BRU-CRF-0628.11	
									insertable = false;
									result3 = 0;
									java.util.Hashtable message = MessageManager.getMessage(locale,
								  "QUEUE_NUM_CTRL_NOT_DEFINED", "OP");
								   sbredirect.append((String) message.get("message"));
								   message.clear();
									
								}

								if (cstmt != null)
									cstmt.close();
								}
							} catch (Exception e) {
								insertable = false;
								result3 = 0;
								e.printStackTrace();
							}

						} else {
							queID = queue_id;
							result3 = 1;
						}
					}
				} catch (Exception e) {
				insertable = false;
				result3 = 0;
				e.printStackTrace();
				}
			}						
			// Ends here..
			if(insertable)
			{
				try {
					
					sql4.append(" Update PR_ENCOUNTER set ");
					sql4.append(" revise_reason_code         ='"
							+ revise_reason_code + "' ,");
					sql4.append(" episode_id                  ='" + op_episode_id
							+ "' ,          ");
					sql4.append(" op_episode_visit_num        ='"
							+ op_episode_visit_num + "',");
					sql4.append(" ambulatory_status           ='"
							+ ambulatory_status + "',");
					sql4.append(" team_id           ='" + cur_team_id + "',");

					if (!cur_locn_code.equals(asn_locn_code)) {
						sql4.append(" assign_care_locn_code = '" + asn_locn_code
								+ "' ,     ");
						sql4.append(" assign_care_locn_type = '"
								+ asn_care_locn_type + "', ");
						sql4.append(" PAT_CURR_LOCN_CODE = '" + asn_locn_code
								+ "' ,     ");
						sql4.append(" PAT_CURR_LOCN_TYPE = '" + asn_care_locn_type
								+ "', ");
					}

					sql4.append("assign_room_num='" + room_num + "', ");
					sql4.append("referral_id='" + referral_id + "', ");

					if (!cur_practitioner_id.equals(asn_practitioner_id))
						sql4.append("attend_practitioner_id = '"
								+ asn_practitioner_id + "',");
					else
						sql4.append("attend_practitioner_id = '"
								+ cur_practitioner_id + "',");

					if (!cur_visit_type_code.equals(asn_visit_type_code)
							&& (!asn_visit_type_code.equals(""))) {
						sql4.append(" visit_adm_type = '" + asn_visit_type_code
								+ "' ,      ");
						sql4.append(" visit_adm_type_ind = '" + h_visit_type_ind
								+ "' ,  ");
					} else {
						sql4.append(" visit_adm_type = '" + cur_visit_type_code
								+ "' ,      ");
						sql4.append(" visit_adm_type_ind = '" + h_visit_type_ind
								+ "' ,  ");
					}

					if (unlinkapptcaseyn.equals("Y"))
						sql4.append(" Appt_id = null, appt_case_yn ='W',    ");

					if (!service_code.equals(assignedServiceCode))
						sql4.append(" service_code = '" + assignedServiceCode
								+ "' ,  subservice_code = '"
								+ assignedSubServiceCode + "' ,");
					else
						sql4.append(" subservice_code = '" + assignedSubServiceCode
								+ "' ,");

					sql4.append(" OTHER_RES_CLASS='" + other_res_type
							+ "' ,OTHER_RESOURCE_ID='" + other_res_code
							+ "',QUEUE_ID='" + queID + "' , ");

					sql4.append(" modified_by_id = ?, modified_date = sysdate, modified_facility_id=?, modified_at_ws_no=? , revise_visit_remarks = ? , contact_reason_code = ?, other_reason_remarks = ?   ");
					sql4.append(" where encounter_id = ? and facility_id = ? ");
					pstmt = conn.prepareStatement(sql4.toString());

					pstmt.setString(1, modifiedById );
					pstmt.setString(2, modifiedFacilityId);
					pstmt.setString(3, modifiedAtWorkstation);
					pstmt.setString(4, other_remarks);
					pstmt.setString(5, contact_reason_code);
					pstmt.setString(6, other_reason_remarks);
					pstmt.setString(7, eid);
					pstmt.setString(8, facilityId);

					result0 = pstmt.executeUpdate();

					if (result0 == 0)
						insertable = false;
					else
						insertable = true;
					if (pstmt != null)
						pstmt.close();

					sql4.setLength(0);
				} catch (Exception eThree) {
					
					if (pstmt != null) {
						result0 = pstmt.getUpdateCount();
						pstmt.close();
						pstmt = null;
					} else
							result0 = 0;

					if (result0 == 0)
						insertable = false;

					sbredirect.append("Problem at eThree :" + eThree);
				}
			}

			if (insertable) {

				try {
					
					String oplastservsql = "update op_last_visit_for_service set ASSIGN_CARE_LOCN_CODE=?,ATTEND_PRACTITIONER_ID=?,SUBSERVICE_CODE=?, modified_date=sysdate, modified_facility_id=?, modified_at_ws_no=? , modified_by_id =? where OPERATING_FACILITY_ID=? and PATIENT_ID=? and SERVICE_CODE=?";
					pstmt = conn.prepareStatement(oplastservsql);
					if (!cur_locn_code.equals(asn_locn_code))
						pstmt.setString(1, asn_locn_code);
					else
						pstmt.setString(1, cur_locn_code);
					if (!cur_practitioner_id.equals(asn_practitioner_id))
						pstmt.setString(2, asn_practitioner_id);
					else
						pstmt.setString(2, cur_practitioner_id);
					pstmt.setString(3, assignedSubServiceCode);
					pstmt.setString(4, modifiedFacilityId);
					pstmt.setString(5, modifiedAtWorkstation);
					pstmt.setString(6, modifiedById);
					pstmt.setString(7, facilityId);
					pstmt.setString(8, patientid);
					pstmt.setString(9, service_code);

					int servres = pstmt.executeUpdate();

					if (servres != 0)
						insertable = true;
					else
						insertable = false;

					if (pstmt != null)
						pstmt.close();

				} catch (Exception e) {
					insertable = false;
					e.printStackTrace();
				}
			}

			if(insertable)
			{
				try {
					
					StringBuffer OPPatientQueueUpdateSQL = new StringBuffer();
					OPPatientQueueUpdateSQL
							.append(" Update  op_patient_queue set ");
					if (chg_flag.equals("Y") || q_num == "0") {
						OPPatientQueueUpdateSQL.append("queue_num ='" + L_queuenum
								+ "', ");
					}
					//Modified by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114
					OPPatientQueueUpdateSQL
							.append("locn_type = ? , locn_code = ? ,  practitioner_id = nvl(?,'*ALL'), room_num = nvl(?,'*ALL'), OTHER_RES_CLASS=?,OTHER_RESOURCE_ID=?,QUEUE_ID=? ,REVISE_REASON_CODE=?,EPISODE_ID=?,OP_EPISODE_VISIT_NUM=? ,VISIT_TYPE_CODE=?,VISIT_TYPE_IND=?,SERVICE_CODE=?,SUBSERVICE_CODE=?,PAT_CURR_LOCN_TYPE=?,PAT_CURR_LOCN_CODE=?, modified_date=sysdate, modified_facility_id=?, modified_at_ws_no=? , modified_by_id =?, referral_id = ?, revise_visit_remarks = ? , contact_reason_code = ?, other_reason_remarks = ? where  facility_id = ?  and encounter_id=? ");
					pstmt = conn.prepareStatement(OPPatientQueueUpdateSQL
							.toString());

					if (!cur_locn_type.equals(asn_care_locn_type))
						pstmt.setString(1, asn_care_locn_type);
					else
						pstmt.setString(1, cur_locn_type);

					if (!cur_locn_code.equals(asn_locn_code))
						pstmt.setString(2, asn_locn_code);
					else
						pstmt.setString(2, cur_locn_code);

					pstmt.setString(3, L_practitioner_id);
					pstmt.setString(4, room_num);
					pstmt.setString(5, other_res_type);
					pstmt.setString(6, other_res_code);
					pstmt.setString(7, queID);

					pstmt.setString(8, revise_reason_code);
					pstmt.setString(9, op_episode_id);
					pstmt.setString(10, op_episode_visit_num);

					if (!cur_visit_type_code.equals(asn_visit_type_code)
							&& (!asn_visit_type_code.equals(""))) {
						pstmt.setString(11, asn_visit_type_code);
						pstmt.setString(12, h_visit_type_ind);
					} else {
						pstmt.setString(11, cur_visit_type_code);
						pstmt.setString(12, h_visit_type_ind);
					}
					if (!service_code.equals(assignedServiceCode))
						pstmt.setString(13, assignedServiceCode);
					else
						pstmt.setString(13, service_code);

					pstmt.setString(14, assignedSubServiceCode);

					if (!cur_locn_type.equals(asn_care_locn_type))
						pstmt.setString(15, asn_care_locn_type);
					else
						pstmt.setString(15, cur_locn_type);

					if (!cur_locn_code.equals(asn_locn_code))
						pstmt.setString(16, asn_locn_code);
					else
						pstmt.setString(16, cur_locn_code);

					pstmt.setString(17, modifiedFacilityId);
					pstmt.setString(18, modifiedAtWorkstation);
					pstmt.setString(19, modifiedById);
					pstmt.setString(20, referral_id);
					/*Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114*/
					pstmt.setString(21, other_remarks); 
					pstmt.setString(22, contact_reason_code); 
					pstmt.setString(23, other_reason_remarks); 
					/*End ML-MMOH-CRF-1114*/
					pstmt.setString(24, facilityId);
					pstmt.setString(25, eid);
					
					result4 = pstmt.executeUpdate();
					if (pstmt != null)
						pstmt.close();

					OPPatientQueueUpdateSQL.setLength(0);
					
					
				 /*Below line added for this CRF Bru-HIMS-CRF-133*/	                     
					  
				if(eOP.QMSInterface.isSiteSpecific(conn,"OP","PATENC_MOVEMENT") && queue_date.equals(Sydate)){						
						cstmt = conn.prepareCall("{call PR_ENC_MVMNT(?,?,?,?,?)}");
						cstmt.setString(1, facilityId);
						cstmt.setString(2, patientid);
						cstmt.setString(3, eid);
						cstmt.setString(4, queuestatus);
						cstmt.registerOutParameter(5, java.sql.Types.VARCHAR);
						cstmt.execute();		
						String err_pr_enc_mvmnt= cstmt.getString(5);
												
						if (cstmt != null){
							cstmt.close();
						}							 
				}
			 //End Bru-HIMS-CRF-133
					
					
				} catch (Exception eTen) {
					if (pstmt != null) {
						result4 = pstmt.getUpdateCount();
						pstmt.close();
						pstmt = null;
					} else {
						result4 = 0;
						sbredirect.append("Problem at eTen :" + eTen);
					}
				}	
			}

			if(insertable)
			{
				try 
				{
					if (unlinkapptcaseyn.equals("Y")) 
					{
						
						pstmt = conn.prepareStatement(" update oa_appt set encounter_id = null, appt_status ='1', modified_date=sysdate, modified_facility_id=?, modified_at_ws_no=? , modified_by_id =? where facility_id =? and Appt_ref_no =?  ");

						pstmt.setString(1, modifiedFacilityId);
						pstmt.setString(2, modifiedAtWorkstation);
						pstmt.setString(3, modifiedById);
						pstmt.setString(4, facilityId);
						pstmt.setString(5, appt_id);

						res7 = pstmt.executeUpdate();
						if (res7 == 0)
							insertable = false;
						else
							insertable = true;

						if (pstmt != null)
							pstmt.close();
					}
				} catch (Exception eTwo) {
					if (pstmt != null) {
						res7 = pstmt.getUpdateCount();
					} else
						res7 = 0;

					if (res7 == 0)
						insertable = false;

					sbredirect.append("Problem at eTwo :" + eTwo);

				}
			}
			if(insertable)
			{
				cur_pract_type = "";
			
				if (cur_pract_type.equals("MD") || cur_pract_type.equals("SG")
						|| cur_pract_type.equals("PS")
						|| cur_pract_type.equals("DN")) {
					try {
						StringBuffer prEncounterPractDelete = new StringBuffer();
						prEncounterPractDelete
								.append(" Delete from pr_encounter_pract  ");
						prEncounterPractDelete
								.append(" where operating_facility_id = ? ");
						prEncounterPractDelete.append(" and encounter_id = ?  ");
						prEncounterPractDelete
								.append(" and practitioner_role ='1' ");
						prEncounterPractDelete
								.append(" and nvl(practitioner_id,'*ALL') = nvl(?,'*ALL') ");
						pstmt = conn.prepareStatement(prEncounterPractDelete
								.toString());
						pstmt.setString(1, facilityId);
						pstmt.setString(2, eid);
						pstmt.setString(3, cur_practitioner_id);
						z = pstmt.executeUpdate();
						if (z == 0)
							insertable = false;
						else
							insertable = true;

						if (pstmt != null)
							pstmt.close();
						prEncounterPractDelete.setLength(0);

						try {
							if (insertable) {								

								sql10.append(" insert into pr_encounter_pract  ");
								sql10
										.append(" (operating_facility_id , encounter_id, practitioner_id, ");
								sql10
										.append(" practitioner_role ,specialty_code,remarks,        ");
								sql10
										.append(" added_by_id , added_date,                         ");
								sql10
										.append(" added_facility_id  ,  added_at_ws_no ,            ");
								sql10
										.append(" modified_by_id  ,modified_date ,                  ");
								sql10
										.append(" modified_facility_id, modified_at_ws_no )         ");
								sql10
										.append(" values (?,?,?,?,?,?,?,?,?,?,?,?,?,?) ");

								pstmt = conn.prepareStatement(sql10.toString());
								pstmt.setString(1, facilityId);
								pstmt.setString(2, eid);
								if (!cur_practitioner_id
										.equals(asn_practitioner_id))
									pstmt.setString(3, asn_practitioner_id);
								else
									pstmt.setString(3, cur_practitioner_id);

								pstmt.setString(4, "1");
								pstmt.setString(5, specialty_code);
								pstmt.setString(6, null);
								pstmt.setString(7, addedById);
								pstmt.setDate(8, added_date);
								pstmt.setString(9, addedFacilityId);
								pstmt.setString(10, addedAtWorkstation);
								pstmt.setString(11, modifiedById);
								pstmt.setDate(12, modified_date);
								pstmt.setString(13, modifiedFacilityId);
								pstmt.setString(14, modifiedAtWorkstation);

								r = pstmt.executeUpdate();
								if (r == 0)
									insertable = false;
								else
									insertable = true;
							}

							sql10.setLength(0);

							if (pstmt != null)
								pstmt.close();

						} catch (Exception eFive) {
							if (pstmt != null)
								r = pstmt.getUpdateCount();
							else
								r = 0;
							if (r == 0)
								insertable = false;

							sbredirect.append("Problem at eFive :" + eFive);
						}

					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}	
			if(insertable)
			{
				try 
				{								
						  if(!(referral_id_old.equals("")) && referral_id!=referral_id_old){
						  //Added Audit column
							pstmt = conn.prepareStatement(" update  pr_referral_register set status = 'O',referred_in_func=null, modified_by_id = ? , modified_date = sysdate ,modified_at_ws_no = ? , modified_facility_id = ?  where referral_id = ?  ");
							
							//Added Audit column
							pstmt.setString(1, modifiedById);
							pstmt.setString(2, modifiedAtWorkstation);
							pstmt.setString(3, modifiedFacilityId);							
							pstmt.setString(4, referral_id_old);
							result6 = pstmt.executeUpdate();
							if (result6 == 0)
								insertable = false;
							else
								insertable = true;
							if (pstmt != null)
								pstmt.close();
						} 
						if(!(referral_id.equals(""))){
						//Added Audit column
						pstmt = conn.prepareStatement(" update  pr_referral_register set status = 'C' , referred_in_func = 2, modified_by_id = ? , modified_date = sysdate ,modified_at_ws_no = ? , modified_facility_id = ?  where referral_id = ?  ");
							//Added Audit column
							pstmt.setString(1, modifiedById);
							pstmt.setString(2, modifiedAtWorkstation);
							pstmt.setString(3, modifiedFacilityId);
							pstmt.setString(4, referral_id);
							result5 = pstmt.executeUpdate();
							if (result5 == 0)
								insertable = false;
							else
								insertable = true;
							if (pstmt != null)
								pstmt.close();
					}
				} catch (Exception eTwo) {
					if (pstmt != null) {
						result5 = pstmt.getUpdateCount();						
					} else
						result5 = 0;
					if (result5 == 0)
						insertable = false;

					sbredirect.append("Transaction Failed in pr_referral_register update query");

				}
			}
			if(insertable)
			{
				try {

					if (bl_interface_yn.equalsIgnoreCase("Y")) {						

						Hashtable hashtableBL = new Hashtable();
						hashtableBL = BLtabdata;
						hashtableBL.put("episode_id", op_episode_id.trim());
						hashtableBL.put("visit_id", op_episode_visit_num.trim());
						hashtableBL.put("clinic_code", asn_locn_code); // This clinic code is used for the interfacing part.
						hashtableBL.put("episode_type", "O");
						hashtableBL.put("module_id", "OP");
						hashtableBL.put("addedById", addedById);
						hashtableBL.put("addedAtWorkstation", addedAtWorkstation);
						hashtableBL.put("locale", locale);
						hashtableBL.put("function_id", "REVISE_VISIT");
						
						BLOPReviseVisit blRevise = new BLOPReviseVisit();
						Hashtable resultsBL = blRevise.billPatientService(p, conn,
								hashtableBL);

						boolean boolBLStatus = ((Boolean) (resultsBL.get("status")))
								.booleanValue();
						insertable = boolBLStatus;

						billgenlater = (String) (resultsBL.get("billgenlater"));						
						billtotalamt = (String) (resultsBL.get("billtotalamt"));

						str_bill_prt_format_YN = (String)(resultsBL.get("bill_prt_format_YN"));
						pgm_id = (String)(resultsBL.get("pgm_id"));
						session_id = (String)(resultsBL.get("session_id"));
						pgm_date = (String)(resultsBL.get("pgm_date"));
						mpi_id_rep = (String)(resultsBL.get("mpi_id_rep"));

						strBLMessage = (String) resultsBL.get("message");
						if (boolBLStatus == false) {
							sbredirect.append((String) resultsBL.get("error"));
						}
						if (boolBLStatus == true) {
							if (strBLMessage != null) {
								if (!(strBLMessage.equals(""))) {
								}
							} else {
								strBLMessage = "0";
							}
						}
						hashtableBL.clear();
						resultsBL.clear();
					}
				} catch (Exception exceptionBL) {
					insertable = false;
					sbredirect.append(" Error in BL " + exceptionBL);
				}
			}			

			if (insertable) {
				if (result0 != 0 && result3 != 0 && result4 != 0) {
					conn.commit();
					conn.setAutoCommit(true);
					java.util.Hashtable message = MessageManager.getMessage(
							locale, "RECORD_INSERTED", "SM");
					sbredirect.append((String) message.get("message"));
					message.clear();
				} else {
					insertable = false;
					conn.rollback();
					conn.setAutoCommit(true);
					
					/*if(qms_interfaced_yn.equals("Y")){
						System.out.println("Revise Visit rolled back - cancelQMSQueueNum called");
						cancelQMSQueueNum(queue_num,(String)tabdata.get("customerID"),addedById,modifiedAtWorkstation,modifiedFacilityId,(String)tabdata.get("sessionID"),patientid,eid,conn);
				}*/
				}
			}
			tabdata.clear();
			BLtabdata.clear();
		} catch (Exception e) {
			try {
				conn.rollback();
				conn.setAutoCommit(true);
				
				/*if(qms_interfaced_yn.equals("Y")){
					System.out.println("Revise Visit rolled back - cancelQMSQueueNum called");
					cancelQMSQueueNum(queue_num,(String)tabdata.get("customerID"),addedById,modifiedAtWorkstation,modifiedFacilityId,(String)tabdata.get("sessionID"),patientid,eid,conn);
				}*/
				e.printStackTrace();
				sbredirect.append("Problem in Main Catch :" + e + ":"
						+ e.getMessage());
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		} finally {
			if (conn != null)
				ConnectionManager.returnConnection(conn, p);
		}

		rethash.put("status", new Boolean(insertable));
		rethash.put("error", sbredirect.toString());

		rethash.put("billgenlater", billgenlater);
		rethash.put("billtotalamt", billtotalamt);

		rethash.put("bill_prt_format_YN", str_bill_prt_format_YN);
		rethash.put("pgm_id", pgm_id);
		rethash.put("session_id", session_id);
		rethash.put("pgm_date", pgm_date);
		rethash.put("mpi_id_rep", mpi_id_rep);

		if (strBLMessage == null) {
			strBLMessage = "0";
		}
		rethash.put("bl_message", strBLMessage);
		return rethash;
	}
	
	/*public static void cancelQMSQueueNum(String queue_num, String siteID,String addedById,String modifiedAtWorkstation,String modifiedFacilityId, String sessionId,String patient_id,String encounterId1,Connection con){
		try{
			java.util.HashMap audit_params=new java.util.HashMap();
			audit_params.put("siteID",siteID);
			audit_params.put("loggedUser",addedById);
			audit_params.put("clientMachine",modifiedAtWorkstation);
			audit_params.put("facilityID",modifiedFacilityId);
			audit_params.put("sessionID",sessionId);
			audit_params.put("patientID",patient_id);
			audit_params.put("encounterID",encounterId1);
			System.out.println("Before sending param to QMSInterface cancelTicket from ReviseVisit : "+audit_params.toString());
			eOP.QMSInterface.cancelQueueNumber(queue_num,audit_params,con);
		}catch(Exception ex){
			System.out.println("Error during call to QMS");
			ex.printStackTrace();
		}
	}*/
}
