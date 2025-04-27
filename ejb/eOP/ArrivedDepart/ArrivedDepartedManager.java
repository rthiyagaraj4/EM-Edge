/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eOP.ArrivedDepart;

import java.io.PrintStream;
import blopin.*;
import java.rmi.*;
import javax.ejb.*;
import java.sql.*;
import javax.naming.*;
import javax.rmi.*;
import webbeans.eCommon.*;

/**
*
* @ejb.bean
*	name="ArrivedDepartedManager"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="ArrivedDepartedManager"
*	local-jndi-name="ArrivedDepartedManager"
*	impl-class-name="eOP.ArrivedDepart.ArrivedDepartedManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eOP.ArrivedDepart.ArrivedDepartedManagerLocal"
*	remote-class="eOP.ArrivedDepart.ArrivedDepartedManagerRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eOP.ArrivedDepart.ArrivedDepartedManagerLocalHome"
*	remote-class="eOP.ArrivedDepart.ArrivedDepartedManagerHome"
*	generate= "local,remote"
*
*
*/


public class ArrivedDepartedManager implements SessionBean {
	java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat(
			"yyyy-MM-dd");

	Connection con;

	PreparedStatement pstmt = null;

	ResultSet rs = null;

	String sql = "";

	String srl_no = "";

	String locale = "";

	//public final String RECORD_MODIFIED = "RECORD_MODIFIED";

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
	
	public java.util.HashMap updateArrivedpat(java.util.Properties p,
			java.util.HashMap tabdata) {
		locale = p.getProperty("LOCALE");
		java.util.HashMap results = new java.util.HashMap();
		boolean result = false;
		boolean updatable = true;
		int res = 0;
		StringBuffer sb = new StringBuffer("");
		String facilityId = (String) tabdata.get("addedFacilityId");
		String patientid = (String) tabdata.get("patientid");
		String patientclass = (String) tabdata.get("patientclass");
		String encounterid1 = (String) tabdata.get("p_encounter_id");
		long encounterid = (Long.valueOf(encounterid1.trim())).longValue();
		String encounterdatetime = (String) tabdata.get("encounterdatetime");
		String locntype = (String) tabdata.get("locntype");
		String locncode = (String) tabdata.get("locncode");
		String userlocncode = (String) tabdata.get("userlocncode");
		String userlocntype = (String) tabdata.get("userlocntype");
		String addedFacilityId = (String) tabdata.get("addedFacilityId");
		String addedAtWorkstation = (String) tabdata.get("addedAtWorkstation");
		String addedById = p.getProperty("login_user");
		//String addedDate = dateFormat.format(new java.util.Date());
		String modifiedById = addedById;
		//String modifiedDate = addedDate;
		String modifiedFacilityId = addedFacilityId;
		String modifiedAtWorkstation = addedAtWorkstation;
		//Date modified_date = Date.valueOf(modifiedDate);
		try {
			con = ConnectionManager.getConnection(p);
			
			if (updatable) {
				try {
					
					con.setAutoCommit(false);
					sql = "update pr_encounter set PAT_CURR_LOCN_TYPE=?,PAT_CURR_LOCN_CODE=?,PAT_TRN_TIME=sysdate,ADDED_AT_WS_NO=?,ADDED_FACILITY_ID=?, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=?, MODIFIED_DATE = sysdate, MODIFIED_BY_ID = ? where encounter_id=? and patient_class=? and facility_id=?";
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, userlocntype);
					pstmt.setString(2, userlocncode);
					pstmt.setString(3, addedAtWorkstation);
					pstmt.setString(4, addedFacilityId);
					pstmt.setString(5, modifiedAtWorkstation);
					pstmt.setString(6, modifiedFacilityId);
					pstmt.setString(7, modifiedById);
					pstmt.setLong(8, encounterid);
					pstmt.setString(9, patientclass);
					pstmt.setString(10, facilityId);
					res = pstmt.executeUpdate();
					if (res != 0) {
						updatable = true;
					} else {
						sb.append("Insert into pr_encounter Arrived res=" + res
								+ "rows inserted");
						updatable = false;
					}
					if (pstmt != null)
						pstmt.close();
					tabdata.clear();
				} catch (Exception e) {
					
					if (pstmt != null)
						pstmt.close();
					updatable = false;
				}
			}

			if (updatable) {

				if (patientclass.equals("OP") || patientclass.equals("EM")) {
					
						String sql1 = "";
						int res1 = 0;
						try {
							
							sql1 = "update op_patient_queue set PAT_CURR_LOCN_TYPE=?,PAT_CURR_LOCN_CODE=?,PAT_TRN_TIME=sysdate,MODIFIED_BY_ID=?,MODIFIED_DATE=sysdate,MODIFIED_AT_WS_NO=?,MODIFIED_FACILITY_ID=? where encounter_id=? and facility_id=?";
							pstmt = con.prepareStatement(sql1);
							pstmt.setString(1, userlocntype);
							pstmt.setString(2, userlocncode);
							pstmt.setString(3, modifiedById);
							pstmt.setString(4, modifiedAtWorkstation);
							pstmt.setString(5, modifiedFacilityId);
							pstmt.setLong(6, encounterid);
							pstmt.setString(7, facilityId);							

							res1 = pstmt.executeUpdate();
							if (res1 == 0)
								updatable = false;
							else
								updatable = true;
							if (pstmt != null)
								pstmt.close();
						} catch (Exception e) {
							e.printStackTrace();
							updatable = false;
							
						}
				}
			}			

			if (updatable) {
				try {
					con.setAutoCommit(false);
					pstmt = con
							.prepareStatement("SELECT MAX(to_number(SRL_NO))+1 srl_no FROM PR_PATIENT_MOVEMENT  WHERE FACILITY_ID = ? and encounter_id = ? GROUP BY PATIENT_ID");
					pstmt.setString(1, facilityId);
					pstmt.setLong(2, encounterid);
					rs = pstmt.executeQuery();
					if (rs != null) {
						while (rs.next()) {
							srl_no = rs.getString("srl_no");
						}
					}
					if (rs != null)
						rs.close();
					if (pstmt != null)
						pstmt.close();
				} catch (Exception e) {
					e.printStackTrace();
					updatable = false;
				}
			}
			if (updatable) {
				try {
					
					con.setAutoCommit(false);
					sql = "Insert into pr_patient_movement(facility_id,encounter_id,srl_no,patient_id,patient_class,movement_type,from_locn_type,from_locn_code,from_time,to_locn_type,to_locn_code,to_time,ADDED_AT_WS_NO,ADDED_FACILITY_ID,modified_by_id,modified_date,modified_at_ws_no,modified_facility_id,ADDED_BY_ID,ADDED_DATE)values(?,?,?,?,?,'A',?,?,to_date(?,'dd/mm/yyyy hh24:mi'),?,?,sysdate,?,?,?,sysdate,?,?,?,sysdate)";
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, facilityId);
					pstmt.setLong(2, encounterid);
					pstmt.setString(3, srl_no);
					pstmt.setString(4, patientid);
					pstmt.setString(5, patientclass);
					pstmt.setString(6, locntype);
					pstmt.setString(7, locncode);
					pstmt.setString(8, encounterdatetime);
					pstmt.setString(9, userlocntype);
					pstmt.setString(10, userlocncode);
					pstmt.setString(11, addedAtWorkstation);
					pstmt.setString(12, addedFacilityId);
					pstmt.setString(13, modifiedById);				
					pstmt.setString(14, modifiedAtWorkstation);
					pstmt.setString(15, modifiedFacilityId);
					pstmt.setString(16, addedById);
					res = pstmt.executeUpdate();
					if (res != 0) {
						updatable = true;
					} else {
						sb
								.append("Insert into pr_patient_movement Arrived res="
										+ res + "rows inserted");
						updatable = false;
					}
					if (pstmt != null)
						pstmt.close();
					res = 0;
				} catch (Exception e) {
					if (pstmt != null)
						pstmt.close();
					e.printStackTrace();
					updatable = false;
				}
			}

			if (updatable) {
				result = true;
				con.setAutoCommit(false);

				java.util.Hashtable message = MessageManager.getMessage(locale,
						"RECORD_MODIFIED", "SM");
				sb.append((String) message.get("message"));
				con.commit();
				message.clear();
			} else {
				con.rollback();
				
				updatable = false;
				result = false;
			}
		} catch (Exception e) {
			sb.append(e.toString() + "<br>");
			e.printStackTrace();
			updatable = false;
			try {
				con.rollback();
			} catch (Exception ce) {
				ce.printStackTrace();
			}
		} finally {
			if (con != null)
				ConnectionManager.returnConnection(con, p);
		}
		results.put("status", new Boolean(result));
		results.put("error", sb.toString());
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
	
	public java.util.HashMap updateDepartedpat(java.util.Properties p,
			java.util.HashMap tabdata) {
		locale = p.getProperty("LOCALE");
		java.util.HashMap results = new java.util.HashMap();
		boolean result = false;
		boolean updatable = true;
		int res = 0;
		locale = p.getProperty("LOCALE");
		StringBuffer sb = new StringBuffer("");
		String facilityId = (String) tabdata.get("addedFacilityId");
		String patientid = (String) tabdata.get("patientid");
		String patientclass = (String) tabdata.get("patientclass");
		String encounterid1 = (String) tabdata.get("p_encounter_id");
		long encounterid = (Long.valueOf(encounterid1.trim())).longValue();
		String pat_trn_time = (String) tabdata.get("pat_trn_time");
		String locntype = (String) tabdata.get("locntype");
		String locncode = (String) tabdata.get("locncode");
		String userlocncode = (String) tabdata.get("userlocncode");
		String userlocntype = (String) tabdata.get("userlocntype");
		String addedFacilityId = (String) tabdata.get("addedFacilityId");
		String addedAtWorkstation = (String) tabdata.get("addedAtWorkstation");
		String addedById = p.getProperty("login_user");
		//String addedDate = dateFormat.format(new java.util.Date());
		String modifiedById = addedById;
		//String modifiedDate = addedDate;
		String modifiedFacilityId = addedFacilityId;
		String modifiedAtWorkstation = addedAtWorkstation;
		String move_reason = (String) tabdata.get("move_reason");
		//Date modified_date = Date.valueOf(modifiedDate);
		try {
			con = ConnectionManager.getConnection(p);			

			if (updatable) {
				String upenc = "";
				try {
					
					upenc = "update pr_encounter set MOVEMENT_REASON_CODE=?,MODIFIED_BY_ID=?,MODIFIED_DATE=sysdate,MODIFIED_AT_WS_NO=?,MODIFIED_FACILITY_ID=? where encounter_id=? and patient_class=? and facility_id=? ";
					pstmt = con.prepareStatement(upenc);
					pstmt.setString(1, move_reason);
					pstmt.setString(2, modifiedById);
					pstmt.setString(3, modifiedAtWorkstation);
					pstmt.setString(4, modifiedFacilityId);
					pstmt.setLong(5, encounterid);
					pstmt.setString(6, patientclass);
					pstmt.setString(7, facilityId);

					int cnt = pstmt.executeUpdate();
					if (cnt != 0)
						updatable = true;
					else
						updatable = false;
					if (pstmt != null)
						pstmt.close();
				} catch (Exception e) {
					e.printStackTrace();
					updatable = false;
					
				}
				tabdata.clear();
			}

			if (updatable) {

				if (patientclass.equals("OP") || patientclass.equals("EM")) {
					
					String oppatq = "";
					int cnt1 = 0;
					try {
						
						oppatq = "update op_patient_queue set MOVEMENT_REASON_CODE=?,MODIFIED_BY_ID=?,MODIFIED_DATE=sysdate,MODIFIED_AT_WS_NO=?,MODIFIED_FACILITY_ID=?  where encounter_id=? and facility_id=? ";
						pstmt = con.prepareStatement(oppatq);
						pstmt.setString(1, move_reason);
						pstmt.setString(2, modifiedById);
						pstmt.setString(3, modifiedAtWorkstation);
						pstmt.setString(4, modifiedFacilityId);
						pstmt.setLong(5, encounterid);
						pstmt.setString(6, facilityId);
						
						cnt1 = pstmt.executeUpdate();
						if (cnt1 == 0)
							updatable = false;
						else
							updatable = true;
						if (pstmt != null)
							pstmt.close();
					} catch (Exception e) {
						e.printStackTrace();
						updatable = false;
						
					}

				}
			}

			if (updatable) {
				try {
					pstmt = con
							.prepareStatement("SELECT MAX(to_number(SRL_NO))+1 srl_no FROM PR_PATIENT_MOVEMENT  WHERE FACILITY_ID = ? and encounter_id = ? GROUP BY PATIENT_ID");
					pstmt.setString(1, facilityId);
					pstmt.setLong(2, encounterid);
					rs = pstmt.executeQuery();
					if (rs != null) {
						while (rs.next()) {
							srl_no = rs.getString("srl_no");
						}
					}
					if (rs != null)
						rs.close();
					if (pstmt != null)
						pstmt.close();
				} catch (Exception e) {
					e.printStackTrace();
					updatable = false;
				}
			}

			if (updatable) {
				try {
					
					con.setAutoCommit(false);
					sql = "Insert into pr_patient_movement(facility_id,encounter_id,srl_no,patient_id,patient_class,movement_type,from_locn_type,from_locn_code,from_time,to_locn_type,to_locn_code,to_time,ADDED_AT_WS_NO,ADDED_FACILITY_ID,modified_by_id,modified_date,modified_at_ws_no,modified_facility_id,ADDED_BY_ID,ADDED_DATE,MOVEMENT_REASON_CODE)values(?,?,?,?,?,'D',?,?,to_date(?,'dd/mm/yyyy hh24:mi'),?,?,sysdate,?,?,?,sysdate,?,?,?,sysdate,?)";

					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, facilityId);
					pstmt.setLong(2, encounterid);
					pstmt.setString(3, srl_no);
					pstmt.setString(4, patientid);
					pstmt.setString(5, patientclass);
					pstmt.setString(6, userlocntype);
					pstmt.setString(7, userlocncode);
					pstmt.setString(8, pat_trn_time);
					pstmt.setString(9, locntype);
					pstmt.setString(10, locncode);
					pstmt.setString(11, addedAtWorkstation);
					pstmt.setString(12, addedFacilityId);
					pstmt.setString(13, modifiedById);				
					pstmt.setString(14, modifiedAtWorkstation);
					pstmt.setString(15, modifiedFacilityId);
					pstmt.setString(16, addedById);
					pstmt.setString(17, move_reason);
					res = pstmt.executeUpdate();

					if (res != 0) {
						updatable = true;
					} else {
						sb
								.append("Insert into pr_patient_movement Departed res="
										+ res + "rows inserted");
						updatable = false;
					}
					if (pstmt != null)
						pstmt.close();
					res = 0;
				} catch (Exception e) {
					if (pstmt != null)
						pstmt.close();
					e.printStackTrace();
					updatable = false;
				}
			}

			if (updatable) {
				result = true;
				con.setAutoCommit(false);
				java.util.Hashtable message = MessageManager.getMessage(locale,
						"RECORD_MODIFIED", "SM");
				sb.append((String) message.get("message"));
				con.commit();
				message.clear();
			} else {
				con.rollback();
				
				updatable = false;
				result = false;
			}

		} catch (Exception e) {
			sb.append(e.toString() + "<br>");
			e.printStackTrace();
			updatable = false;
			try {
				con.rollback();
			} catch (Exception excpt) {
			}
		} finally {
			if (con != null)
				ConnectionManager.returnConnection(con, p);
		}
		results.put("status", new Boolean(result));
		results.put("error", sb.toString());
		return results;
	}
}
