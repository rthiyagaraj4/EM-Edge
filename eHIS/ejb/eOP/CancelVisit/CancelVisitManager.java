/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eOP.CancelVisit;

import blopin.*;
import java.sql.*;
import javax.naming.*;
import webbeans.eCommon.*;
import java.io.*;
import java.io.PrintStream;
import java.rmi.RemoteException;
import java.util.Calendar;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Properties;
import javax.ejb.CreateException;
import javax.ejb.*;
import javax.naming.*;
import javax.rmi.*;
import webbeans.eCommon.*;

/**
*
* @ejb.bean
*	name="CancelVisitManager"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="CancelVisitManager"
*	local-jndi-name="CancelVisitManager"
*	impl-class-name="eOP.CancelVisit.CancelVisitManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eOP.CancelVisit.CancelVisitManagerLocal"
*	remote-class="eOP.CancelVisit.CancelVisitManagerRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eOP.CancelVisit.CancelVisitManagerLocalHome"
*	remote-class="eOP.CancelVisit.CancelVisitManagerHome"
*	generate= "local,remote"
*
*
*/


public class CancelVisitManager implements SessionBean {

	Connection con;

	PreparedStatement pstmt;

	PreparedStatement pstmt1;

	CallableStatement cs = null;

	String bl_interfaced_yn = "";

	ResultSet rs;

	ResultSet rs3;

	String locale = "";

	StringBuffer sql = new StringBuffer();

	//public final String RECORD_MODIFIED = "RECORD_MODIFIED";

	public void ejbCreate() {
	}

	public void ejbRemove() {
	}

	public void ejbActivate() {
	}

	public void ejbPassivate() {
	}

	public void setSessionContext(SessionContext context) {
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

	public java.util.HashMap updateCancelVisit(java.util.Properties p,
			java.util.HashMap VisitData, java.util.Hashtable BLVisitData) {
		String strBLMessage = "0";
		java.util.HashMap results = new java.util.HashMap();
		locale = p.getProperty("LOCALE");
		boolean updatable = true;
		StringBuffer sb = new StringBuffer("");
		String addedById = p.getProperty("login_user"); 
		String addedFacilityId = (String) VisitData.get("facility_id");
		String addedAtWorkstation = (String) VisitData.get("workstation");
		String modifiedById = addedById;
		String modifiedFacilityId = (String) VisitData.get("facility_id");
		String modifiedAtWorkstation = (String) VisitData.get("workstation");
		String cancel_reason_code = (String) VisitData.get("cancel_reason_code");
		String cancel_visit_remarks = (String) VisitData.get("other_remarks"); //Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114
		String appointment_no = (String) VisitData.get("appointment_no");
		String multi_speciality_yn = (String) VisitData.get("multi_speciality_yn");
		//Added for the SCF - ML-BRU-SCF-1157 - Begin
		String module_id = (String) VisitData.get("module_id");//Added for the SCF - ML-BRU-SCF-1157
		String patient_class="OP";
		if(module_id.equals("AE")){
			patient_class="EM";
		}
		//Added for the SCF - ML-BRU-SCF-1157 - End
		int no_of_rows = 0;

		if (updatable) {

			try {

				con = ConnectionManager.getConnection(p);
				con.setAutoCommit(false);

				sql.append("update pr_encounter set visit_status      = ?,");
				sql.append("visit_status_set_on_date      = sysdate,");
				sql.append("visit_status_set_by_user      = ?,");
				sql.append("visit_status_set_reason       = ?,");
				sql.append("modified_by_id    = ?,");
				sql.append("modified_date     = sysdate,");
				sql.append("modified_facility_id  = ?,");
				sql.append("modified_at_ws_no = ?,");
				sql.append("cancel_reason_code = ?, ");
				sql.append("cancel_visit_remarks = ? "); //Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114
				sql.append("where facility_id     = ? ");
				sql.append("and  encounter_id = ?");

				pstmt = con.prepareStatement(sql.toString());
				pstmt.setString(1, "99");
				pstmt.setString(2, addedById);
				pstmt.setString(3, (String) VisitData.get("reason"));
				pstmt.setString(4, modifiedById);
				pstmt.setString(5, modifiedFacilityId);
				pstmt.setString(6, modifiedAtWorkstation);
				pstmt.setString(7, cancel_reason_code);
				pstmt.setString(8, cancel_visit_remarks); //Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114
				pstmt.setString(9, modifiedFacilityId);
				pstmt.setLong(10, Long.parseLong((String) VisitData
						.get("encounter_id")));/*original data*/

				no_of_rows = pstmt.executeUpdate();

				if (no_of_rows == 0)
					updatable = false;
				else
					updatable = true;

				if (pstmt != null)
					pstmt.close();

				sql.delete(0, sql.length());

			} catch (Exception e) {
				e.printStackTrace();
				
			}
		}

		if (updatable) {

			try {

					sql.setLength(0);
				sql.append("select last_visit_num from ");
				sql.append("  op_episode_for_service  where  episode_id  =? and  service_code    =?  and operating_facility_id= ? and patient_id = ? ");
				pstmt = con.prepareStatement(sql.toString()) ;
				pstmt.setString(1,(String)VisitData.get("episode_id") ) ;
				pstmt.setString(2,(String)VisitData.get("service_code"));
				pstmt.setString(3,addedFacilityId);
				pstmt.setString(4,(String)VisitData.get("patient_id"));
				rs = pstmt.executeQuery() ;
				int lastVisitNum=0;
				if(rs!=null)
				{
					while(rs.next())
						lastVisitNum=rs.getInt("last_visit_num");
				}
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				sql.setLength(0);
				if (lastVisitNum== 01)
				{
					sql.setLength(0);
					
					sql.append("update op_episode_for_service set ");
					sql.append(" episode_status =?, modified_by_id = ?, modified_date = sysdate, modified_facility_id  = ?, modified_at_ws_no = ? ");
					sql.append(" where episode_id =? ");
					sql.append(" and service_code    = ? ");
					sql.append(" and operating_facility_id   =? ");
					sql.append(" and patient_id=? ");
					//sql.append(" and    patient_id=? and last_visit_num = '01' ");

					pstmt = con.prepareStatement(sql.toString());
					pstmt.setString(1, "99");
					pstmt.setString(2, modifiedById);
					pstmt.setString(3, modifiedFacilityId);
					pstmt.setString(4, modifiedAtWorkstation);
					pstmt.setString(5, (String) VisitData.get("episode_id"));
					pstmt.setString(6, (String) VisitData.get("service_code"));
					pstmt.setString(7, addedFacilityId);
					pstmt.setString(8, (String) VisitData.get("patient_id"));

					no_of_rows = pstmt.executeUpdate();

					if (no_of_rows == 0)
						updatable = false;
					else
						updatable = true;

					if (pstmt != null)
						pstmt.close();

					sql.setLength(0);
				}
			} catch (Exception e1) {
				sb.append(e1.getMessage() + "op episode service <br>");
				e1.printStackTrace();
			}
		}

		if (updatable) {
			try {
				boolean updatable1 = false;
				sql.setLength(0);
				sql.append("delete  from op_last_visit_for_service ");
				sql.append(" where  patient_id      =? ");
				sql.append(" and    service_code        =? ");
				sql
						.append(" and    operating_facility_id   =? and encounter_id =?");

				pstmt = con.prepareStatement(sql.toString());
				pstmt.setString(1, (String) VisitData.get("patient_id"));
				pstmt.setString(2, (String) VisitData.get("service_code"));
				pstmt.setString(3, addedFacilityId);
				pstmt.setString(4, (String) VisitData.get("encounter_id"));

				no_of_rows = pstmt.executeUpdate();

				if (no_of_rows == 0)
					updatable1 = false;
				else
					updatable1 = true;

				if (pstmt != null)
					pstmt.close();
				sql.setLength(0);

				if (updatable1) {

					sql.append("select   patient_id, facility_id, service_code,");
					sql.append("encounter_id, to_char(recall_date,'dd/mm/yyyy hh24:mi') recall_date,recall_reason ,to_char(VISIT_ADM_DATE_TIME,'dd/mm/yyyy hh24:mi') VISIT_ADM_DATE_TIME,ASSIGN_CARE_LOCN_CODE,ATTEND_PRACTITIONER_ID,REFERRAL_ID,SUBSERVICE_CODE ");
					sql	.append(" from  pr_encounter  where     patient_id = ?  and facility_id= ? ");
					sql.append(" and   service_code= ?  and  patient_class='"+patient_class+"' and  visit_adm_date_time in ");
					sql.append("(select max(visit_adm_date_time) from pr_encounter     where patient_id = ? ");
					sql.append(" and  patient_class='"+patient_class+"' and  encounter_id    != ?  and  facility_id= ? and   service_code    = ? and visit_status !='99') ");

					pstmt = con.prepareStatement(sql.toString());

					pstmt.setString(1, (String) VisitData.get("patient_id"));
					pstmt.setString(2, addedFacilityId);
					pstmt.setString(3, (String) VisitData.get("service_code"));
					pstmt.setString(4, (String) VisitData.get("patient_id"));
					pstmt.setLong(5, Long.parseLong((String) VisitData
							.get("encounter_id")));
					pstmt.setString(6, addedFacilityId);
					pstmt.setString(7, (String) VisitData.get("service_code"));

					rs3 = pstmt.executeQuery();

					String patientID = "";
					String facilityID = "";
					String servicecode = "";
					long encounterid;
					String recalldate = "";
					String recallreason = "";
					String visitDateTime = "";
					String assignCarelocCode = "";
					String attendPractID = "";
					String refID = "";
					String subservCode = "";

					sql.delete(0, sql.length());
					sql.setLength(0);

					if (rs3.next()) {
						patientID = rs3.getString("patient_id");
						facilityID = rs3.getString("facility_id");
						servicecode = rs3.getString("service_code");
						encounterid = rs3.getLong("encounter_id");
						recalldate = rs3.getString("recall_date");
						if (recalldate == null)
							recalldate = "";
						recallreason = rs3.getString("recall_reason");
						visitDateTime = rs3.getString("VISIT_ADM_DATE_TIME");
						assignCarelocCode = rs3
								.getString("ASSIGN_CARE_LOCN_CODE");
						attendPractID = rs3.getString("ATTEND_PRACTITIONER_ID");
						refID = rs3.getString("REFERRAL_ID");
						if (refID == null)
							refID = "";
						subservCode = rs3.getString("SUBSERVICE_CODE");
						if (subservCode == null)
							subservCode = "";

						try {							

							sql.setLength(0);
							sql
									.append("insert into op_last_visit_for_service ");
							sql.append("(patient_id,operating_facility_id,");
							sql
									.append("service_code,encounter_id,recall_date,");
							sql.append("recall_srvc_item_code,recall_reason,");
							sql.append("added_by_id,       added_date, ");
							sql.append("added_facility_id, added_at_ws_no, ");
							sql.append("modified_by_id,     modified_date, ");
							sql
									.append("modified_facility_id,  modified_at_ws_no,VISIT_ADM_DATE_TIME,ASSIGN_CARE_LOCN_CODE,ATTEND_PRACTITIONER_ID,PATIENT_CLASS,REFERRAL_ID,SUBSERVICE_CODE) ");
							sql
									.append("values (?,?,?,?,to_date(?,'dd/mm/yyyy hh24:mi'),?,?,?,sysdate,?,?,?,sysdate,?,?,to_date(?,'dd/mm/yyyy hh24:mi'),?,?,'"+patient_class+"',?,?)");//Query modified for the SCF - ML-BRU-SCF -1157

							pstmt1 = con.prepareStatement(sql.toString());
							pstmt1.setString(1, patientID);
							pstmt1.setString(2, facilityID);
							pstmt1.setString(3, servicecode);
							pstmt1.setLong(4, encounterid);
							pstmt1.setString(5, recalldate);
							pstmt1.setString(6, null);
							pstmt1.setString(7, recallreason);
							pstmt1.setString(8, addedById);
							pstmt1.setString(9, addedFacilityId);
							pstmt1.setString(10, addedAtWorkstation);
							pstmt1.setString(11, modifiedById);
							pstmt1.setString(12, modifiedFacilityId);
							pstmt1.setString(13, modifiedAtWorkstation);
							pstmt1.setString(14, visitDateTime);
							pstmt1.setString(15, assignCarelocCode);
							pstmt1.setString(16, attendPractID);
							pstmt1.setString(17, refID);
							pstmt1.setString(18, subservCode);

							no_of_rows = pstmt1.executeUpdate();

							if (no_of_rows == 0)
								updatable = false;
							else
								updatable = true;

							if (pstmt1 != null)
								pstmt1.close();
						} catch (Exception e) {
							e.printStackTrace();
							updatable = false;
							
						}
					}
				}
				if (rs3 != null)
					rs3.close();
				if (pstmt != null)
					pstmt.close();
				sql.setLength(0);
			} catch (Exception e2) {
				e2.printStackTrace();
				updatable = false;
				
			}
		}

		if (updatable) {

			try {
				String referral_id = (String) VisitData.get("referral_id");
				String delink_referral = (String) VisitData
						.get("delink_referral");
				if (!referral_id.equals("") && !delink_referral.equals("")) {					

					sql.append("Update pr_referral_register ");
					sql.append("set status='O' , ");
					sql.append("close_encounter_id=null, referred_in_func=null , modified_by_id = ?, modified_date = sysdate, modified_facility_id  = ?, modified_at_ws_no = ? ");
					sql.append("where referral_id='" + referral_id + "' ");

					pstmt = con.prepareStatement(sql.toString());

					pstmt.setString(1, modifiedById);
					pstmt.setString(2, modifiedFacilityId);
					pstmt.setString(3, modifiedAtWorkstation);

					int rs_ref = 0;
					rs_ref = pstmt.executeUpdate();

					if (rs_ref != 0)
						updatable = true;
					else
						updatable = false;

					sql.delete(0, sql.length());
				}

				if (pstmt != null)
					pstmt.close();
			} catch (Exception e) {
				sb.append("Exception @ Callable Statement" + e);
				e.printStackTrace();
				
			}
		}

		if (updatable) {
			try {
				
				sql.setLength(0);

				sql.append("update op_patient_queue set queue_status = '99' ,CANCEL_REASON_CODE ='"
								+ cancel_reason_code + "' ");
				sql.append(" , modified_by_id = ?, modified_date = sysdate, modified_facility_id  = ?, modified_at_ws_no = ?, cancel_visit_remarks = ? where encounter_id ="
						+ (String) VisitData.get("encounter_id") + " ");
				sql.append("and   facility_id         = '" + addedFacilityId
						+ "' "); //Modified by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114
				
				pstmt = con.prepareStatement(sql.toString());
				pstmt.setString(1,modifiedById);
				pstmt.setString(2,modifiedFacilityId);
				pstmt.setString(3,modifiedAtWorkstation);
				pstmt.setString(4,cancel_visit_remarks); //Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114

				no_of_rows = pstmt.executeUpdate();

				if (no_of_rows == 0)
					updatable = false;
				else
					updatable = true;

				if (pstmt != null)
					pstmt.close();
				sql.setLength(0);
			} catch (Exception e7) {
				updatable = false;
				sb.append(e7.getMessage() + " Before Patient Queue <br>="
						+ updatable + "-");
				e7.printStackTrace();
				
			}
		}

		if(updatable) {
				try	{
					cs = con.prepareCall("{call MP_AUDIT_FUNCTION.UPDATE_ENCOUNTER(?,?,?,?,?,?,?)}");
					cs.setString(1, addedFacilityId);					
					cs.setLong(2, Long.parseLong((String) VisitData.get("encounter_id")));
					if((String)VisitData.get("module_id") == "OP"){					
						cs.setString(3, "OP");	
					} else {
						cs.setString(3, "EM");	
					}
					cs.setString(4, (String)VisitData.get("patient_id"));
					cs.setString(5, "99");
					cs.setString(6,modifiedById);
					cs.setString(7,modifiedAtWorkstation);
					cs.execute();
					if(cs!=null)
						cs.close();
				} catch (Exception e) {
					e.printStackTrace();
					updatable = false;	
					sb.append(e.getMessage() + " AT MP_AUDIT_FUNCTION.UPDATE_ENCOUNTER <br>="
						+ updatable + "-");
				}
			}

		if (updatable) {

			if (!(appointment_no.equals(""))) {
				try {

					sql.setLength(0);

					sql.append("update oa_appt set appt_status = ?,ENCOUNTER_ID=null, ");
					sql.append("modified_by_id    = ?,");
					sql.append("modified_date     = sysdate,");
					sql.append("modified_facility_id  = ?,");
					sql.append("modified_at_ws_no = ?");
					sql.append("where facility_id = ?");
					sql.append("and appt_ref_no = ?");

					pstmt = con.prepareStatement(sql.toString());
					pstmt.setString(1, "1");
					pstmt.setString(2, modifiedById);
					pstmt.setString(3, modifiedFacilityId);
					pstmt.setString(4, modifiedAtWorkstation);
					pstmt.setString(5, modifiedFacilityId);
					pstmt.setString(6, appointment_no);

					int updates = pstmt.executeUpdate();

					if (updates != 0)
						updatable = true;
					else
						updatable = false;

					if (pstmt != null)
						pstmt.close();

					sql.setLength(0);

				} catch (Exception eoa) {
					eoa.printStackTrace();
				}
			}
		}
		//CRF -198 start
		// The status in PR_EMCOUNTER_JOINT_CONSULT will be updated to 'X' when a visit is cancelled for all the resources mapped to this encounter
		if(updatable && multi_speciality_yn.equals("Y")){
			try{
			sql.setLength(0);

			sql.append("update PR_ENCOUNTER_JOINT_CONSULT set status = 'X', ");
			sql.append("modified_by_id    = ?,");
			sql.append("modified_date     = sysdate,");
			sql.append("modified_facility_id  = ?,");
			sql.append("modified_at_ws_no = ?");
			sql.append("where facility_id = ?");
			sql.append("and encounter_id = ?");

			pstmt = con.prepareStatement(sql.toString());
			
			pstmt.setString(1, modifiedById);
			pstmt.setString(2, modifiedFacilityId);
			pstmt.setString(3, modifiedAtWorkstation);
			pstmt.setString(4, modifiedFacilityId);
			pstmt.setString(5, (String) VisitData.get("encounter_id"));

			int updates = pstmt.executeUpdate(); 
			
			if(pstmt!=null) pstmt.close(); //Added for checkstyle
			}catch(Exception e){
				e.printStackTrace();
			}
			
		}
		//CRF -198 End
		 
		
					
		if(updatable)
		{
			bl_interfaced_yn = (String) VisitData.get("bl_interfaced_yn");
			String vno = (String) VisitData.get("op_episode_visit_num");
			if (vno == null)
				vno = "0";

			if (vno.length() > 4)
				vno = vno.substring(0, 3);

			try {

				if (updatable) {

					if (bl_interfaced_yn.equalsIgnoreCase("Y")) {

						Hashtable hashtableBL = new Hashtable();
						hashtableBL = BLVisitData;
						hashtableBL.put("moduleId", (String) BLVisitData
								.get("module_id"));
						hashtableBL.put("visit_id", vno.trim());
						hashtableBL.put("episode_type", (String) BLVisitData
								.get("episode_type"));
						hashtableBL.put("login_user", addedById);
						hashtableBL.put("client_ip_address", addedAtWorkstation);
						hashtableBL.put("bl_installed_yn", bl_interfaced_yn);
						hashtableBL.put("locale", locale);
						
						BLOPCancelVisit blCancel = new BLOPCancelVisit();
						Hashtable resultsBLCancel = blCancel.billPatientService(p,
								con, hashtableBL);

						boolean boolBLStatus = ((Boolean) (resultsBLCancel
								.get("status"))).booleanValue();

						updatable = boolBLStatus;
						strBLMessage = (String) resultsBLCancel.get("message");
						if (boolBLStatus == false) {
							sb.append((String) resultsBLCancel.get("error"));
						}

						if (boolBLStatus == true) {
							if (strBLMessage != null) {
								if (!(strBLMessage.equals(""))) {
									sb.append(((String) resultsBLCancel
											.get("message"))
											+ "<BR>");
								}

							} else {
								strBLMessage = "0";
							}
						}
						resultsBLCancel.clear();
						hashtableBL.clear();
					}
				}

			} catch (Exception exceptionBL) {
				updatable = false;
				sb.append("BL Exception " + exceptionBL);
				exceptionBL.printStackTrace();

			}
		}

		sql.delete(0, sql.length());	

		try {

			if (updatable) {

				java.util.Hashtable message = MessageManager.getMessage(locale,
						"RECORD_MODIFIED", "SM");
				sb.append((String) message.get("message"));
				con.commit();
				con.setAutoCommit(true);
				message.clear();
			} else {
				con.rollback();
			}
			VisitData.clear();
			BLVisitData.clear();
		} catch (Exception e8) {
			sb.append(e8.getMessage() + " last try <br>");
			e8.printStackTrace();
			try {
				con.rollback();
			} catch (Exception ee) {
				ee.printStackTrace();
			}
		}

		finally {
			if (con != null)
				ConnectionManager.returnConnection(con, p);
		}
		results.put("status", new Boolean(updatable));
		results.put("error", sb.toString());
		if (strBLMessage == null) {
			strBLMessage = " ";
		}
		results.put("bl_message", strBLMessage);
		return results;
	}
}
