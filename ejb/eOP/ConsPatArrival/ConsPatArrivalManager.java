/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eOP.ConsPatArrival;

import java.rmi.*;
import javax.ejb.*;
import java.sql.*;
import javax.naming.*;
import javax.rmi.*;
import webbeans.eCommon.*;
//import eOP.QMSInterface;

/**
*
* @ejb.bean
*	name="ConsPatArrivalManager"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="ConsPatArrivalManager"
*	local-jndi-name="ConsPatArrivalManager"
*	impl-class-name="eOP.ConsPatArrival.ConsPatArrivalManager"
*
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject"
*	local-class="eOP.ConsPatArrival.ConsPatArrivalLocal"
*	remote-class="eOP.ConsPatArrival.ConsPatArrivalRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome"
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eOP.ConsPatArrival.ConsPatArrivalLocalHome"
*	remote-class="eOP.ConsPatArrival.ConsPatArrivalHome"
*	generate= "local,remote"
*
*
*/

public class ConsPatArrivalManager implements SessionBean {

	java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat(
			"yyyy-MM-dd");

	String addedById = "";

	String locale = "";

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

	public java.util.HashMap updateConsPatArrival(java.util.Properties p,
			java.util.HashMap tabdata) {

		locale						= p.getProperty("LOCALE");
		java.util.HashMap results   = new java.util.HashMap();
		boolean result				= false;
		boolean insertable			= true;

		StringBuffer sb						= new StringBuffer("");
		String facilityId					= (String) tabdata.get("addedFacilityId");
		String ws_no						= p.getProperty("client_ip_address");
		String p_queue_status				= (String) tabdata.get("p_queue_status");
		String encounterId1					= (String) tabdata.get("encntr_id");
		long encounterId					= Long.parseLong(encounterId1);
		String p_queue_date					= (String) tabdata.get("p_queue_date");
		String p_locn_type					= (String) tabdata.get("p_locn_type");
		String p_pract_id					= (String) tabdata.get("p_pract_id");
		String p_locn_code					= (String) tabdata.get("p_locn_code");
		String p_revert_to_checkin			= (String) tabdata.get("revert_to_check_in");
		String room_num						= (String) tabdata.get("room_num");
		String room_change					= (String) tabdata.get("room_change");
		String addedFacilityId				= (String) tabdata.get("addedFacilityId");
		String addedAtWorkstation			= (String) tabdata.get("addedAtWorkstation");
		/*Below line added for this CRF Bru-HIMS-CRF-133  [IN:034536]*/
		String patientid			        = (String) tabdata.get("p_patient_id"); 
		String curr_locntype			    = (String) tabdata.get("curr_locntype"); 
		String curr_locncode			    = (String) tabdata.get("curr_locncode"); 
		String isPatientEncMovement			= (String) tabdata.get("isPatientEncMovement"); 
		String Sydate			            = (String) tabdata.get("Sydate"); 
		
		int res2 = 0;	int serial_no = 0;	int count=0; int pr_enc_movmt=0;
        ResultSet rs_manage_pat=null;		
		boolean isPatEncMovement=false;	
		String queue_date_chk="";
        /*if(!p_queue_date.equals(""))
          queue_date_chk = dateFormat.format(p_queue_date);	*/
		  
		/*End this CRF Bru-HIMS-CRF-133  [IN:034536]*/
		String modifiedById					= p.getProperty("login_user");
		String modifiedDate					= dateFormat.format(new java.util.Date());
		Date modified_date					= Date.valueOf(modifiedDate);
		String modifiedFacilityId			= addedFacilityId;
		String modifiedAtWorkstation		= addedAtWorkstation;
		String prev_attend_practitioner_id  = "";
		String prev_assign_care_locn_code   = "";
		String prev_assign_room_num			= "";
		String prev_visit_adm_type			= "";
		String prev_visit_adm_type_ind		= "";
		String prev_subservice_code			= "";
		String prev_queue_id			= "";
		String qms_interfaced_yn	= (String) tabdata.get("qms_interfaced_yn");
		String queue_num		= (String) tabdata.get("queue_num");
		if (ws_no == null)
			ws_no = "";

		addedById = p.getProperty("login_user");

		//added by Himanshu Saxena for ML-BRU-CRF-0628.11 on 24-05-2023 Started 
		// assigned_qnum  Casted from int To String 
		
		// int assigned_qnum = 0;
		String assigned_qnum="0";
		
		//added by Himanshu Saxena for ML-BRU-CRF-0628.11 on 24-05-2023 End 
			
		
		Connection con = null;
		CallableStatement cstmt = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt1 = null;


		try {

			StringBuffer sql = new StringBuffer();
			int res = 0;
			//int L_queuenum = 1;
			String L_queuenum="1";
			//int quenum = 0;
			String quenum = "0";
			String que_id = "";
			
			String err_pr_enc_mvmnt=""; //this line added for this CRFBru-HIMS-CRF-133 


			


			//added by Himanshu Saxena for ML-BRU-CRF-0628.11 on 24-05-2023 Started 
			// Queue number Casted from int To String 
			//int q_num				= Integer.parseInt(queue_num.trim());
			String q_num            = queue_num.trim();
			//added by Himanshu Saxena for ML-BRU-CRF-0628.11 on 24-05-2023 Ended
			String appt_walk_in		= (String) tabdata.get("appt_walk_in");
			String other_res_type	= (String) tabdata.get("other_res_type");
			String other_res_code	= (String) tabdata.get("other_res_code");
			String queue_id			= (String) tabdata.get("queue_id");
			String assign_q_num_by	= (String) tabdata.get("assign_q_num_by");

			try	{

					con = ConnectionManager.getConnection(p);
					con.setAutoCommit(false);
					String PREncounterSQL = "";
					PREncounterSQL = "Select prev_assign_care_locn_code,prev_attend_practitioner_id, prev_assign_room_num,prev_visit_adm_type,prev_visit_adm_type_ind,prev_subservice_code,queue_id from pr_encounter where  encounter_id = ? and facility_id = ? ";
					pstmt = con.prepareStatement(PREncounterSQL);
					pstmt.setLong(1, encounterId);
					pstmt.setString(2, facilityId);
					ResultSet rsPR = pstmt.executeQuery();
					if (rsPR != null && rsPR.next()) {
						prev_attend_practitioner_id = (rsPR
								.getString("prev_attend_practitioner_id") == null) ? "*ALL"
								: rsPR.getString("prev_attend_practitioner_id");
						prev_assign_care_locn_code = (rsPR
								.getString("prev_assign_care_locn_code") == null) ? ""
								: rsPR.getString("prev_assign_care_locn_code");
						prev_assign_room_num = (rsPR.getString("prev_assign_room_num") == null) ? ""
								: rsPR.getString("prev_assign_room_num");

						prev_visit_adm_type = (rsPR.getString("prev_visit_adm_type") == null) ? ""
								: rsPR.getString("prev_visit_adm_type");
						prev_visit_adm_type_ind = (rsPR
								.getString("prev_visit_adm_type_ind") == null) ? ""
								: rsPR.getString("prev_visit_adm_type_ind");
						prev_subservice_code = (rsPR.getString("prev_subservice_code") == null) ? ""
								: rsPR.getString("prev_subservice_code");
						prev_queue_id = (rsPR.getString("queue_id") == null) ? ""
								: rsPR.getString("queue_id");
					}

					if (rsPR != null)
						rsPR.close();
					if (pstmt != null)
						pstmt.close();
			}
			catch (Exception e) {
				e.printStackTrace();
			}

			if (insertable) {

						if(assign_q_num_by.equals("M"))
						{
							que_id = queue_id;
							assigned_qnum = q_num;


							if (p_pract_id == null || p_pract_id.equals(""))
								p_pract_id = "*ALL";
							if (room_num == null || room_num.equals(""))
								room_num = "*ALL";
							if (other_res_type.equals(""))
								other_res_type = "*";
							if (other_res_code.equals(""))
								other_res_code = "*ALL";
						}
						else if(assign_q_num_by.equals("S"))
						{
							
							//added by Himanshu Saxena for ML-BRU-CRF-0628.11 on 24-05-2023 Started 
							//old code ifcondition if ((p_revert_to_checkin.equals("Y") && q_num != 0)|| (!room_change.equals(""))|| (!p_revert_to_checkin.equals("Y") && q_num == 0))
								
							if ((p_revert_to_checkin.equals("Y") && !q_num.equals("0"))
								|| (!room_change.equals(""))
								|| (!p_revert_to_checkin.equals("Y") && q_num.equals("0"))) {

							//added by Himanshu Saxena for ML-BRU-CRF-0628.11 on 24-05-2023 End 
								try {

									if (p_revert_to_checkin.equals("Y") )
									{
										p_pract_id=prev_attend_practitioner_id;
										room_num=prev_assign_room_num;
										//queue_id=prev_queue_id;
									}
									else
									{
										if (p_pract_id == null || p_pract_id.equals(""))
												p_pract_id = "*ALL";
										if (room_num == null || room_num.equals(""))
												room_num = "*ALL";
									}

									if (p_revert_to_checkin.equals("Y") || !room_change.equals(""))
									{
										queue_id=prev_queue_id;
									}


									if (other_res_type.equals(""))
											other_res_type = "*";
									if (other_res_code.equals(""))
										other_res_code = "*ALL";
	
									if(qms_interfaced_yn.equals("N")){
									cstmt = con
										.prepareCall("{call OP_QUEUE_NUM_FOR_LOCN_PRC(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
												cstmt.setString(1, facilityId);
												cstmt.setString(2, p_queue_date);
												cstmt.setString(3, p_locn_type);
												cstmt.setString(4, p_locn_code);
												cstmt.setString(5, p_pract_id);
												cstmt.setString(6, room_num);
												cstmt.setString(7, other_res_type);
												cstmt.setString(8, other_res_code);
												cstmt.setString(9, appt_walk_in);
												cstmt.setString(10, addedById);
												cstmt.setString(11, ws_no);
												
												//added by Himanshu Saxena for ML-BRU-CRF-0628.11 on 24-05-2023 Started 
												//cstmt.setInt(12, q_num);
												cstmt.setString(12, q_num);
												//added by Himanshu Saxena for ML-BRU-CRF-0628.11 on 24-05-2023 Ends 
												
												cstmt.setString(13, queue_id);
												cstmt.registerOutParameter(14, java.sql.Types.VARCHAR);
												//cstmt.registerOutParameter(15, java.sql.Types.INTEGER); //added by Himanshu Saxena for ML-BRU-CRF-0628.11 on 24-05-2023 Ends 
												
												cstmt.registerOutParameter(15, java.sql.Types.VARCHAR);

												cstmt.execute();
												que_id = cstmt.getString(14); 
												
												//quenum = cstmt.getInt(15); 
												quenum = cstmt.getString(15);
								

												if (que_id == null || que_id.equals("null"))
													que_id = "";

												//if (quenum >= 0)
													if (quenum.equals("0") || !quenum.equals("-1") || !quenum.equals("-2"))
													{
													insertable = true;
													L_queuenum = quenum;
												} //else if (quenum == -1) 
													else if (quenum.equals("-1"))
												{
													insertable = false;
													java.util.Hashtable message = MessageManager.getMessage(locale,
												  "QUEUE_ID_NOT_ATTACHED", "OP");
												   sb.append((String) message.get("message"));
												   message.clear();

												} //else if (quenum == -2)
													else if (quenum.equals("-2"))
													{
													insertable = false;
													java.util.Hashtable message = MessageManager.getMessage(locale,
												  "QUEUE_NUM_CTRL_NOT_DEFINED", "OP");
												   sb.append((String) message.get("message"));
												   message.clear();
												}

												if (cstmt != null)
													cstmt.close();
												}
											} catch (Exception e) {
												e.printStackTrace();
												insertable = false;
												
											}
									} else {
										que_id = queue_id;
									}							
						}
			}

			if (insertable) {
				if (p_queue_status.equals("01")
						|| p_revert_to_checkin.equals("Y")) {
					if (p_queue_status.equals("01")) {

						if (insertable) {
							try {

								String sql1 = "update pr_encounter set assign_room_num = ?, visit_status='02', OTHER_RES_CLASS = ?, OTHER_RESOURCE_ID = ?, QUEUE_ID = ?, modified_by_id = ?, modified_date = sysdate, modified_facility_id = ?, modified_at_ws_no = ? where encounter_id = ? and facility_id = ? ";

								pstmt1 = con.prepareStatement(sql1);

								pstmt1.setString(1, room_num);
								pstmt1.setString(2, other_res_type);
								pstmt1.setString(3, other_res_code);
								pstmt1.setString(4, que_id);
								pstmt1.setString(5, modifiedById);
								// Code Commented for IN022870 by Suresh M on 28-July-2010
								//pstmt1.setDate(6, modified_date);
								pstmt1.setString(6, modifiedFacilityId);
								pstmt1.setString(7, modifiedAtWorkstation);
								pstmt1.setLong(8, encounterId);
								pstmt1.setString(9, facilityId);

								res = pstmt1.executeUpdate();
								if (res != 0)
									insertable = true;
								else {
									insertable = false;
									String msgVal = "Error while UPDATING PR_ENCOUNTER ";
									sb.append(msgVal);
								}
								if (pstmt1 != null)
									pstmt1.close();
							} catch (Exception e) {
								insertable = false;
								sb.append("Exception while inserting into PR_ENCOUNTER :"+ e);
								e.printStackTrace();
							}
						}

						if (insertable) {

						try {
							
							/*Below line added for this CRF Bru-HIMS-CRF-133*/							
							if(eOP.QMSInterface.isSiteSpecific(con,"OP","PATENC_MOVEMENT") && isPatientEncMovement.equals("true") && p_queue_date.equals(Sydate)){
							     System.err.println("facilityId===>"+facilityId);
							     System.err.println("patientid===>"+patientid);
								 System.err.println("encounterId1===>"+encounterId1);
							    cstmt = con.prepareCall("{call PR_ENC_MVMNT(?,?,?,?,?)}");
							    cstmt.setString(1, facilityId);
							    cstmt.setString(2, patientid);
							    cstmt.setString(3, encounterId1);
								cstmt.setString(4, "02");
								cstmt.registerOutParameter(5, java.sql.Types.VARCHAR);
								System.err.println("Before execute line no377===>");
								cstmt.execute();								
								System.err.println("After execute line no377===>");
								err_pr_enc_mvmnt= cstmt.getString(5);
								System.err.println("err_pr_enc_mvmnt===>"+err_pr_enc_mvmnt);
								if (cstmt != null){
									cstmt.close();
								}							 
							 }
							 //End Bru-HIMS-CRF-133
							
							 System.out.println("isPatEncMovement====>"+isPatEncMovement);
							
					
							//End this CRF Bru-HIMS-CRF-133

							sql.append(" update OP_PATIENT_QUEUE set queue_status = '02', arrive_date_time = sysdate, room_num = ?, ");
							//sql.append(" queue_status = '02',");
							//sql.append(" arrive_date_time      = sysdate,");
							//sql.append(" room_num         = ?, ");
							if(assign_q_num_by.equals("M"))
							{
								sql.append(" queue_num = '" + assigned_qnum + "', ");
							}
							else if(assign_q_num_by.equals("S"))
							{
								//added by Himanshu Saxena for ML-BRU-CRF-0628.11 on 24-05-2023 Started 
								// old ifcondition if ((!room_change.equals("")) || (q_num == 0))
								
								if ((!room_change.equals("")) || (q_num.equals("0"))) {
								//added by Himanshu Saxena for ML-BRU-CRF-0628.11 on 24-05-2023 Ends 
									sql.append(" queue_num = '" + L_queuenum + "', ");
								}
							}
							sql.append(" modified_by_id = ?, modified_date = ?, modified_facility_id  = ?, modified_at_ws_no = ?, OTHER_RES_CLASS = ?, OTHER_RESOURCE_ID = ?, QUEUE_ID	= ? where facility_id = ? and encounter_id      = ? ");

							/*
							sql.append(" modified_date         = ?,");
							sql.append(" modified_facility_id  = ?,");
							sql.append(" modified_at_ws_no     = ?, ");
							sql.append(" OTHER_RES_CLASS		= ?, ");
							sql.append(" OTHER_RESOURCE_ID     = ?, ");
							sql.append(" QUEUE_ID				= ?	 ");
							sql.append(" where facility_id     = ? ");
							sql.append(" and encounter_id      = ? ");
							*/

							pstmt = con.prepareStatement(sql.toString());
							if (room_num == null || room_num.equals(""))
								room_num = "*ALL";
							pstmt.setString(1, room_num);
							pstmt.setString(2, modifiedById);
							pstmt.setDate(3, modified_date);
							pstmt.setString(4, modifiedFacilityId);
							pstmt.setString(5, modifiedAtWorkstation);
							pstmt.setString(6, other_res_type);
							pstmt.setString(7, other_res_code);
							pstmt.setString(8, que_id);
							pstmt.setString(9, facilityId);
							pstmt.setLong(10, encounterId);

							res = pstmt.executeUpdate();

							if (pstmt != null)pstmt.close();
							if (res != 0){
							insertable = true;						
										
							}else {
								insertable = false;
								String msgVal = "Error While UPDATING OP_PATIENT_QUEUE";
								sb.append(msgVal);
							}
							sql.setLength(0);
						} catch (Exception e) {
							insertable = false;
							sb.append("Exception while first updating  OP_PATIENT_QUEUE :"+ e);
							e.printStackTrace();
						}

						}


					}

					//try {


				if (p_revert_to_checkin.equals("Y"))
				{

					sql.setLength(0);

					if (insertable) {

							try {
								res = 0;

								String sql1 = " update pr_encounter set visit_status='01',assign_care_locn_code=prev_assign_care_locn_code,assign_room_num=prev_assign_room_num,subservice_code=prev_subservice_code,attend_practitioner_id=prev_attend_practitioner_id,visit_adm_type=prev_visit_adm_type,visit_adm_type_ind=prev_visit_adm_type_ind, modified_by_id = ?, modified_date = sysdate, modified_facility_id = ?, modified_at_ws_no = ?, QUEUE_ID	= ? where encounter_id = ? and facility_id = ? ";
								
								pstmt = con.prepareStatement(sql1);

								pstmt.setString(1, modifiedById);
							// Code Commented for IN022870 by Suresh M on 28-July-2010
								// pstmt.setDate(2, modified_date);
								pstmt.setString(2, modifiedFacilityId);
								pstmt.setString(3, modifiedAtWorkstation);
								pstmt.setString(4, que_id);
								pstmt.setLong(5, encounterId);
								pstmt.setString(6, facilityId);

								res = pstmt.executeUpdate();

								if (res != 0)
									insertable = true;
								else {
									insertable = false;
									String msgVal = "Error while UPDATING PR_ENCOUNTER";
									sb.append(msgVal);
								}

								if (pstmt != null)
									pstmt.close();
							} catch (Exception e) {
								insertable = false;
								sb.append("Exception while updating PR_ENCOUNTER 222:"+ e);
								e.printStackTrace();
							}

						}


						if (insertable) {

							try
							{

							String upd_opq_sql = " update OP_PATIENT_QUEUE set queue_status = '01', room_num = nvl(?,'*ALL'), locn_code =?, practitioner_id =?, queue_num = ?, arrive_date_time = null, modified_by_id = ?, modified_date = ?, modified_facility_id = ?, modified_at_ws_no = ?, QUEUE_ID = ?, VISIT_TYPE_CODE =?, VISIT_TYPE_IND = ?, SUBSERVICE_CODE = ? where facility_id = ? and encounter_id = ? ";

							/*
							sql.append(" queue_status          = '01',");
							sql.append(" room_num                = nvl(?,'*ALL'), ");
							sql.append(" locn_code =?, ");
							sql.append(" practitioner_id =?,");
							sql.append(" queue_num = ?, ");
							sql.append(" arrive_date_time      = null,");
							sql.append(" modified_by_id        = ?,");
							sql.append(" modified_date         = ?,");
							sql.append(" modified_facility_id  = ?,");
							sql.append(" modified_at_ws_no     = ? , QUEUE_ID = ? , ");
							sql.append(" VISIT_TYPE_CODE = '"
									+ prev_visit_adm_type + "', ");
							sql.append(" VISIT_TYPE_IND ='"
									+ prev_visit_adm_type_ind + "' ,");
							sql.append(" SUBSERVICE_CODE ='"
									+ prev_subservice_code + "' ");
							sql.append(" where facility_id     = ? ");
							sql.append(" and encounter_id      = ? ");
							*/

							pstmt = con.prepareStatement(upd_opq_sql);
							pstmt.setString(1, prev_assign_room_num);
							pstmt.setString(2, prev_assign_care_locn_code);
							pstmt.setString(3, prev_attend_practitioner_id);

							if(assign_q_num_by.equals("M"))
							{
								//pstmt.setInt(4, 0);
								pstmt.setString(4, "0");
							}
							else if(assign_q_num_by.equals("S"))
							{
								//pstmt.setInt(4, L_queuenum);
								pstmt.setString(4, L_queuenum);
							}

							pstmt.setString(5, modifiedById);
							pstmt.setDate(6, modified_date);
							pstmt.setString(7, modifiedFacilityId);
							pstmt.setString(8, modifiedAtWorkstation);
							pstmt.setString(9, que_id);
							pstmt.setString(10, prev_visit_adm_type);
							pstmt.setString(11, prev_visit_adm_type_ind);
							pstmt.setString(12, prev_subservice_code);
							pstmt.setString(13, facilityId);
							pstmt.setLong(14, encounterId);

							res = pstmt.executeUpdate();

							if (pstmt != null)
								pstmt.close();
							sql.setLength(0);

							if (res != 0)
								insertable = true;
							else {
								insertable = false;
								String msgVal = "Error while UPDATING OP_PATIENT_QUEUE";
								sb.append(msgVal);
							}

							} catch (Exception e) {
								insertable = false;
								sb.append("Exception while updating OP_PATIENT_QUEUE :"+ e);
								e.printStackTrace();
							}

							}
						}

				} else {

					if(insertable) {

						try {
							sql.setLength(0);

						sql.append("update OP_PATIENT_QUEUE set queue_status = decode(?,'05','06',?), room_num = nvl(?,'*ALL'), ");

						/*
						sql.append(" queue_status            = decode(?,'05','06',?),");
						sql.append(" room_num                = nvl(?,'*ALL'), ");
						*/

						if(assign_q_num_by.equals("M"))
						{
							sql.append(" queue_num = '" + assigned_qnum + "', ");
						}
						else if(assign_q_num_by.equals("S"))
						{
							if ((!room_change.equals("")) || (q_num.equals("0"))) {
								sql.append(" queue_num = '" + L_queuenum + "', ");
							}
						}
						sql.append(" subs_arrive_date_time = sysdate, modified_by_id = ?, modified_date = ?, modified_facility_id = ?, modified_at_ws_no = ? where facility_id = ? and encounter_id = ? ");

						/*
						sql.append(" where   facility_id     = ? ");
						sql.append(" and encounter_id        = ? ");
						*/

						pstmt = con.prepareStatement(sql.toString());
						pstmt.setString(1, p_queue_status);
						pstmt.setString(2, p_queue_status);
						pstmt.setString(3, room_num);
						pstmt.setString(4, modifiedById);
						pstmt.setDate(5, modified_date);
						pstmt.setString(6, modifiedFacilityId);
						pstmt.setString(7, modifiedAtWorkstation);
						pstmt.setString(8, facilityId);
						pstmt.setLong(9, encounterId);



						res = pstmt.executeUpdate();
						if (pstmt != null)
							pstmt.close();

						sql.setLength(0);

						if (res != 0)
							insertable = true;
						else {
							insertable = false;
							String msgVal = "Error while UPDATING OP_PATIENT_QUEUE";
							sb.append(msgVal);
						}

					} catch (Exception e) {
						insertable = false;
						sb.append("Exception while updating  OP_PATIENT_QUEUE for queue_status not equal to one or check-in revert :"		+ e);
						e.printStackTrace();
					}

				}

				}
			}

			if (insertable) {
				result = true;
				con.commit();
				java.util.Hashtable message = MessageManager.getMessage(locale,
						"RECORD_MODIFIED", "SM");
				sb.append((String) message.get("message"));
				message.clear();
			} else {
				con.rollback();
				result = false;
				//call QMS cancel here
				/*if(qms_interfaced_yn.equals("Y")){
					System.err.println("ConsPatArrival rolled back - cancelQMSQueueNum called");
					cancelQMSQueueNum(queue_num,(String)tabdata.get("customerID"),addedById,modifiedAtWorkstation,modifiedFacilityId,(String)tabdata.get("sessionID"),(String)tabdata.get("p_patient_id"),encounterId1,con);
				}*/
			}
			tabdata.clear();
		} catch (Exception e) {
			sb.append(e.getMessage() + "<br>");
			e.printStackTrace();
			try {
				con.rollback();
				/*if(qms_interfaced_yn.equals("Y")){
					System.err.println("ConsPatArrival rolled back - cancelQMSQueueNum called");
					cancelQMSQueueNum(queue_num,(String)tabdata.get("customerID"),addedById,modifiedAtWorkstation,modifiedFacilityId,(String)tabdata.get("sessionID"),(String)tabdata.get("p_patient_id"),encounterId1,con);
				}*/
			} catch (Exception ee) {
				ee.printStackTrace();
			}

		} finally {
			try {
				if (pstmt1 != null)
					pstmt1.close();
				if (pstmt != null)
					pstmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			if (con != null)
				ConnectionManager.returnConnection(con, p);
		}

		results.put("status", new Boolean(result));
		results.put("error", sb.toString());
		return results;
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
			System.out.println("In QMS - Before sending param to QMSInterface cancelTicket : "+audit_params.toString());
			eOP.QMSInterface.cancelQueueNumber(queue_num,audit_params,con);
		}catch(Exception ex){
			System.out.println("Error during call to QMS");
			ex.printStackTrace();
		}
	}*/
}
