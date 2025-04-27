/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eOP.OPPractitionerClinic;

import java.rmi.*;
import javax.ejb.*;
import java.sql.*;
import javax.naming.*;
import javax.rmi.*;
import webbeans.eCommon.*;

/**
*
* @ejb.bean
*	name="OPPractitionerClinic"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="OPPractitionerClinic"
*	local-jndi-name="OPPractitionerClinic"
*	impl-class-name="eOP.OPPractitionerClinic.PractitionerClinicManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eOP.OPPractitionerClinic.PractitionerClinicManagerLocal"
*	remote-class="eOP.OPPractitionerClinic.PractitionerClinicManagerRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eOP.OPPractitionerClinic.PractitionerClinicManagerLocalHome"
*	remote-class="eOP.OPPractitionerClinic.PractitionerClinicManagerHome"
*	generate= "local,remote"
*
*
*/



public class PractitionerClinicManager implements SessionBean {
	Connection con;

	PreparedStatement pstmt;

	String addedById = "";

	String modifiedById = "";

	String modifiedFacilityId = "";

	String modifiedAtWorkstation = "";

	String locale = "";

	//public final String CODE_ALREADY_EXISTS = "CODE_ALREADY_EXISTS";

	//public final String RECORD_INSERTED = "RECORD_INSERTED";

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

	/*
	 * This function is used to insert the Practitioner details for a particular
	 * Clinic into the table OP_pract_for_clinic. If these details are already
	 * there then it displays "CODE ALREADY EXISTS" otherwise It inserts the
	 * data into the database and displays "successfully inserted".
	 * 
	 */
	
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
	public java.util.HashMap insertClinic(java.util.Properties p,
			java.util.HashMap tabdata) {
		locale = p.getProperty("LOCALE");
		java.util.HashMap results = new java.util.HashMap();
		boolean result = false;
		boolean insertable = true;
		String callfunc = (String) tabdata.get("callfunction");
		StringBuffer sb = new StringBuffer("");
		StringBuffer insertSB = new StringBuffer();
		insertSB.setLength(0);
		insertSB
				.append("insert into op_pract_for_clinic( facility_id, working_day_1, working_day_2, working_day_3, working_day_4, working_day_5, working_day_6, working_day_7,");
		insertSB
				.append("EM_VISIT_TYPE_APPL_YN, FI_VISIT_TYPE_APPL_YN, FU_VISIT_TYPE_APPL_YN, RT_VISIT_TYPE_APPL_YN, SR_VISIT_TYPE_APPL_YN, CS_VISIT_TYPE_APPL_YN,added_by_id,	added_date, added_facility_id, added_at_ws_no, modified_by_id,	modified_date, modified_facility_id, modified_at_ws_no, ");
		insertSB
				.append("WORKING_WEEK_1_DAY_1, WORKING_WEEK_1_DAY_2, WORKING_WEEK_1_DAY_3, WORKING_WEEK_1_DAY_4, WORKING_WEEK_1_DAY_5, WORKING_WEEK_1_DAY_6, WORKING_WEEK_1_DAY_7, WORKING_WEEK_2_DAY_1, WORKING_WEEK_2_DAY_2, WORKING_WEEK_2_DAY_3, WORKING_WEEK_2_DAY_4, WORKING_WEEK_2_DAY_5, WORKING_WEEK_2_DAY_6, WORKING_WEEK_2_DAY_7, WORKING_WEEK_3_DAY_1, 		WORKING_WEEK_3_DAY_2, WORKING_WEEK_3_DAY_3, WORKING_WEEK_3_DAY_4, WORKING_WEEK_3_DAY_5, WORKING_WEEK_3_DAY_6, WORKING_WEEK_3_DAY_7, WORKING_WEEK_4_DAY_1, WORKING_WEEK_4_DAY_2, WORKING_WEEK_4_DAY_3, WORKING_WEEK_4_DAY_4, WORKING_WEEK_4_DAY_5, WORKING_WEEK_4_DAY_6, WORKING_WEEK_4_DAY_7, WORKING_WEEK_5_DAY_1, WORKING_WEEK_5_DAY_2, WORKING_WEEK_5_DAY_3, WORKING_WEEK_5_DAY_4, WORKING_WEEK_5_DAY_5, WORKING_WEEK_5_DAY_6, WORKING_WEEK_5_DAY_7,");
		insertSB
				.append("WORKING_WEEK_APPL_DAY_1, WORKING_WEEK_APPL_DAY_2, WORKING_WEEK_APPL_DAY_3, WORKING_WEEK_APPL_DAY_4, WORKING_WEEK_APPL_DAY_5, WORKING_WEEK_APPL_DAY_6, WORKING_WEEK_APPL_DAY_7,");
		insertSB
				.append("clinic_code,practitioner_id,EFF_STATUS,care_locn_type_ind,resource_class");
		if (callfunc.equals("Resource_unit")) {
			insertSB.append(",resource_type");
		}
		insertSB
				.append(") values(?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, sysdate, ?,?,?, sysdate, ?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?, ");
		if (callfunc.equals("Pract_for_clinic")) {
			insertSB.append("?,'C','P')");
		} else if (callfunc.equals("Resource_unit")) {
			insertSB.append("?,?,?,?)");
		}
		addedById = p.getProperty("login_user");
		modifiedById = addedById;
		modifiedFacilityId = (String) tabdata.get("addedFacilityId");
		modifiedAtWorkstation = (String) tabdata.get("addedAtWorkstation");
		try {
			con = ConnectionManager.getConnection(p);
			final String duplicateSql = "select clinic_code from op_pract_for_clinic where facility_id = ? and clinic_code = ? and practitioner_id = ?";
			pstmt = con.prepareStatement(duplicateSql);
			pstmt.setString(1, (String) tabdata.get("addedFacilityId"));
			if (callfunc.equals("Pract_for_clinic")) {
				pstmt.setString(2, (String) tabdata.get("clinic"));
				pstmt.setString(3, (String) tabdata.get("practitioner"));
			} else if (callfunc.equals("Resource_unit")) {
				pstmt.setString(2, (String) tabdata.get("resunit"));
				pstmt.setString(3, (String) tabdata.get("resname"));
			}
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				
				insertable = false;
				java.util.Hashtable message = MessageManager.getMessage(locale,
						"CODE_ALREADY_EXISTS", "Common");
				sb.append((String) message.get("message"));
				message.clear();
			}
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
		} catch (Exception e) {
			insertable = false;
			e.printStackTrace();
		}
		if (insertable) {
			try {

				int res = InsertData(callfunc, insertSB, tabdata);

				if (res != 0) {
					result = true;
					java.util.Hashtable message = MessageManager.getMessage(
							locale, "RECORD_INSERTED", "SM");
					sb.append((String) message.get("message"));
					con.commit();
					message.clear();
				} else {
					result = false;
					con.rollback();
				}
				if (pstmt != null)
					pstmt.close();
				tabdata.clear();
			} catch (Exception e) {
				sb.append(e.getMessage() + "<br>");
				try {
					con.rollback();
				} catch (Exception ee) {
					ee.printStackTrace();
				}
			} finally {
				if (con != null)
					ConnectionManager.returnConnection(con, p);
			}
		}
		insertSB.setLength(0);
		results.put("status", new Boolean(result));
		results.put("error", sb.toString());
		return results;
	}

	
	
	public int InsertData(String callfunc, StringBuffer insertSB,
			java.util.HashMap tabdata) {
		int rest = 0;

		try {
			pstmt = con.prepareStatement(insertSB.toString());
			pstmt.setString(1, (String) tabdata.get("addedFacilityId"));
			pstmt.setString(2, (String) tabdata.get("working_day_1"));
			pstmt.setString(3, (String) tabdata.get("working_day_2"));
			pstmt.setString(4, (String) tabdata.get("working_day_3"));
			pstmt.setString(5, (String) tabdata.get("working_day_4"));
			pstmt.setString(6, (String) tabdata.get("working_day_5"));
			pstmt.setString(7, (String) tabdata.get("working_day_6"));
			pstmt.setString(8, (String) tabdata.get("working_day_7"));
			pstmt.setString(9, (String) tabdata.get("emergency"));
			pstmt.setString(10, (String) tabdata.get("first"));
			pstmt.setString(11, (String) tabdata.get("follow"));
			pstmt.setString(12, (String) tabdata.get("routine"));
			pstmt.setString(13, (String) tabdata.get("series"));
			pstmt.setString(14, (String) tabdata.get("consult"));
			pstmt.setString(15, addedById);
			pstmt.setString(16, (String) tabdata.get("addedFacilityId"));
			pstmt.setString(17, (String) tabdata.get("addedAtWorkstation"));
			pstmt.setString(18, modifiedById);
			pstmt.setString(19, modifiedFacilityId);
			pstmt.setString(20, modifiedAtWorkstation);
			pstmt.setString(21, (String) tabdata.get("WORKING_WEEK_1_DAY_1"));
			pstmt.setString(22, (String) tabdata.get("WORKING_WEEK_1_DAY_2"));
			pstmt.setString(23, (String) tabdata.get("WORKING_WEEK_1_DAY_3"));
			pstmt.setString(24, (String) tabdata.get("WORKING_WEEK_1_DAY_4"));
			pstmt.setString(25, (String) tabdata.get("WORKING_WEEK_1_DAY_5"));
			pstmt.setString(26, (String) tabdata.get("WORKING_WEEK_1_DAY_6"));
			pstmt.setString(27, (String) tabdata.get("WORKING_WEEK_1_DAY_7"));
			pstmt.setString(28, (String) tabdata.get("WORKING_WEEK_2_DAY_1"));
			pstmt.setString(29, (String) tabdata.get("WORKING_WEEK_2_DAY_2"));
			pstmt.setString(30, (String) tabdata.get("WORKING_WEEK_2_DAY_3"));
			pstmt.setString(31, (String) tabdata.get("WORKING_WEEK_2_DAY_4"));
			pstmt.setString(32, (String) tabdata.get("WORKING_WEEK_2_DAY_5"));
			pstmt.setString(33, (String) tabdata.get("WORKING_WEEK_2_DAY_6"));
			pstmt.setString(34, (String) tabdata.get("WORKING_WEEK_2_DAY_7"));
			pstmt.setString(35, (String) tabdata.get("WORKING_WEEK_3_DAY_1"));
			pstmt.setString(36, (String) tabdata.get("WORKING_WEEK_3_DAY_2"));
			pstmt.setString(37, (String) tabdata.get("WORKING_WEEK_3_DAY_3"));
			pstmt.setString(38, (String) tabdata.get("WORKING_WEEK_3_DAY_4"));
			pstmt.setString(39, (String) tabdata.get("WORKING_WEEK_3_DAY_5"));
			pstmt.setString(40, (String) tabdata.get("WORKING_WEEK_3_DAY_6"));
			pstmt.setString(41, (String) tabdata.get("WORKING_WEEK_3_DAY_7"));
			pstmt.setString(42, (String) tabdata.get("WORKING_WEEK_4_DAY_1"));
			pstmt.setString(43, (String) tabdata.get("WORKING_WEEK_4_DAY_2"));
			pstmt.setString(44, (String) tabdata.get("WORKING_WEEK_4_DAY_3"));
			pstmt.setString(45, (String) tabdata.get("WORKING_WEEK_4_DAY_4"));
			pstmt.setString(46, (String) tabdata.get("WORKING_WEEK_4_DAY_5"));
			pstmt.setString(47, (String) tabdata.get("WORKING_WEEK_4_DAY_6"));
			pstmt.setString(48, (String) tabdata.get("WORKING_WEEK_4_DAY_7"));
			pstmt.setString(49, (String) tabdata.get("WORKING_WEEK_5_DAY_1"));
			pstmt.setString(50, (String) tabdata.get("WORKING_WEEK_5_DAY_2"));
			pstmt.setString(51, (String) tabdata.get("WORKING_WEEK_5_DAY_3"));
			pstmt.setString(52, (String) tabdata.get("WORKING_WEEK_5_DAY_4"));
			pstmt.setString(53, (String) tabdata.get("WORKING_WEEK_5_DAY_5"));
			pstmt.setString(54, (String) tabdata.get("WORKING_WEEK_5_DAY_6"));
			pstmt.setString(55, (String) tabdata.get("WORKING_WEEK_5_DAY_7"));
			pstmt
					.setString(56, (String) tabdata
							.get("WORKING_WEEK_APPL_DAY_1"));
			pstmt
					.setString(57, (String) tabdata
							.get("WORKING_WEEK_APPL_DAY_2"));
			pstmt
					.setString(58, (String) tabdata
							.get("WORKING_WEEK_APPL_DAY_3"));
			pstmt
					.setString(59, (String) tabdata
							.get("WORKING_WEEK_APPL_DAY_4"));
			pstmt
					.setString(60, (String) tabdata
							.get("WORKING_WEEK_APPL_DAY_5"));
			pstmt
					.setString(61, (String) tabdata
							.get("WORKING_WEEK_APPL_DAY_6"));
			pstmt
					.setString(62, (String) tabdata
							.get("WORKING_WEEK_APPL_DAY_7"));
			if (callfunc.equals("Pract_for_clinic")) {
				pstmt.setString(63, (String) tabdata.get("clinic"));
				pstmt.setString(64, (String) tabdata.get("practitioner"));
				pstmt.setString(65, (String) tabdata.get("effstatus"));

			} else if (callfunc.equals("Resource_unit")) {
				pstmt.setString(63, (String) tabdata.get("resunit"));
				pstmt.setString(64, (String) tabdata.get("resname"));
				pstmt.setString(65, (String) tabdata.get("effstatus"));
				String care_ind = (String) tabdata.get("unittype");
				if (care_ind.equals("Y"))
					pstmt.setString(66, "D");
				else
					pstmt.setString(66, (String) tabdata.get("unittype"));
				pstmt.setString(67, (String) tabdata.get("resclass"));
				pstmt.setString(68, (String) tabdata.get("restype"));
			}
			rest = pstmt.executeUpdate();
			if (pstmt != null)
				pstmt.close();
		} catch (Exception e) {
			rest = 0;
			e.printStackTrace();
		}
		tabdata.clear();
		return rest;
	}

	/*
	 * This function is used to Update the Practitioner details for a particular
	 * Clinic and insert into the table OP_pract_for_clinic.
	 * 
	 */
	
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
	
	public java.util.HashMap updateClinic(java.util.Properties p,
			java.util.HashMap tabdata) {
		java.util.HashMap results = new java.util.HashMap();
		boolean result = false;
		boolean updatable = true;
		String callfunc = (String) tabdata.get("callfunction");
		locale = p.getProperty("LOCALE");
		StringBuffer sb = new StringBuffer("");
		StringBuffer modifySB = new StringBuffer("");
		modifySB.append("update op_pract_for_clinic set ");
		modifySB
				.append(" working_day_1 =?, working_day_2 =?, working_day_3 =?, working_day_4 =?, working_day_5     =?, working_day_6 =?, working_day_7 =?,");
		modifySB
				.append("EM_VISIT_TYPE_APPL_YN =?, FI_VISIT_TYPE_APPL_YN =?, FU_VISIT_TYPE_APPL_YN =?, RT_VISIT_TYPE_APPL_YN =?, SR_VISIT_TYPE_APPL_YN =?, CS_VISIT_TYPE_APPL_YN =?, ");
		modifySB
				.append(" MODIFIED_AT_WS_NO =?, MODIFIED_FACILITY_ID =?, modified_by_id	=?, modified_date =sysdate,");
		modifySB
				.append(" WORKING_WEEK_1_DAY_1 = ?, WORKING_WEEK_1_DAY_2 = ?, WORKING_WEEK_1_DAY_3 = ?, WORKING_WEEK_1_DAY_4 = ?, WORKING_WEEK_1_DAY_5 = ?, WORKING_WEEK_1_DAY_6 = ?, WORKING_WEEK_1_DAY_7 = ?, WORKING_WEEK_2_DAY_1 = ?, WORKING_WEEK_2_DAY_2 = ?,  WORKING_WEEK_2_DAY_3 = ?, WORKING_WEEK_2_DAY_4 = ?, WORKING_WEEK_2_DAY_5 = ?,  WORKING_WEEK_2_DAY_6 = ?, WORKING_WEEK_2_DAY_7 = ?, WORKING_WEEK_3_DAY_1 = ?, WORKING_WEEK_3_DAY_2 = ?, WORKING_WEEK_3_DAY_3 = ?, WORKING_WEEK_3_DAY_4 = ?,  WORKING_WEEK_3_DAY_5 = ?, WORKING_WEEK_3_DAY_6 = ?, WORKING_WEEK_3_DAY_7 = ?,  WORKING_WEEK_4_DAY_1 = ?, WORKING_WEEK_4_DAY_2 = ?, WORKING_WEEK_4_DAY_3 = ?,  WORKING_WEEK_4_DAY_4 = ?, WORKING_WEEK_4_DAY_5 = ?, WORKING_WEEK_4_DAY_6 = ?,  WORKING_WEEK_4_DAY_7 = ?, WORKING_WEEK_5_DAY_1 = ?, WORKING_WEEK_5_DAY_2 = ?, WORKING_WEEK_5_DAY_3 = ?, WORKING_WEEK_5_DAY_4 = ?, WORKING_WEEK_5_DAY_5 = ?, WORKING_WEEK_5_DAY_6 = ?, WORKING_WEEK_5_DAY_7 = ?, WORKING_WEEK_APPL_DAY_1 = ?, WORKING_WEEK_APPL_DAY_2 = ?, WORKING_WEEK_APPL_DAY_3 = ?, WORKING_WEEK_APPL_DAY_4 = ?, WORKING_WEEK_APPL_DAY_5 = ?, WORKING_WEEK_APPL_DAY_6 = ?, WORKING_WEEK_APPL_DAY_7 = ?, EFF_STATUS	=?, ");

		if (callfunc.equals("Pract_for_clinic")) {
			modifySB.append(" care_locn_type_ind = 'C', resource_class = 'P'");
		} else if (callfunc.equals("Resource_unit")) {
			modifySB
					.append(" care_locn_type_ind = ?, resource_class = ?, resource_type = ? ");
		}
		modifySB
				.append("where clinic_code = ? and facility_id=? and practitioner_id=?");

		modifiedById = p.getProperty("login_user");
		if (updatable) {
			try {
				con = ConnectionManager.getConnection(p);
				pstmt = con.prepareStatement(modifySB.toString());
				pstmt.setString(1, (String) tabdata.get("working_day_1"));
				pstmt.setString(2, (String) tabdata.get("working_day_2"));
				pstmt.setString(3, (String) tabdata.get("working_day_3"));
				pstmt.setString(4, (String) tabdata.get("working_day_4"));
				pstmt.setString(5, (String) tabdata.get("working_day_5"));
				pstmt.setString(6, (String) tabdata.get("working_day_6"));
				pstmt.setString(7, (String) tabdata.get("working_day_7"));
				pstmt.setString(8, (String) tabdata.get("emergency"));
				pstmt.setString(9, (String) tabdata.get("first"));
				pstmt.setString(10, (String) tabdata.get("follow"));
				pstmt.setString(11, (String) tabdata.get("routine"));
				pstmt.setString(12, (String) tabdata.get("series"));
				pstmt.setString(13, (String) tabdata.get("consult"));
				pstmt.setString(14, (String) tabdata
						.get("modifiedAtWorkstation"));
				pstmt.setString(15, (String) tabdata.get("modifiedFacilityId"));
				pstmt.setString(16, modifiedById);
				pstmt.setString(17, (String) tabdata
						.get("working_week_1_day_1"));
				pstmt.setString(18, (String) tabdata
						.get("working_week_1_day_2"));
				pstmt.setString(19, (String) tabdata
						.get("working_week_1_day_3"));
				pstmt.setString(20, (String) tabdata
						.get("working_week_1_day_4"));
				pstmt.setString(21, (String) tabdata
						.get("working_week_1_day_5"));
				pstmt.setString(22, (String) tabdata
						.get("working_week_1_day_6"));
				pstmt.setString(23, (String) tabdata
						.get("working_week_1_day_7"));
				pstmt.setString(24, (String) tabdata
						.get("working_week_2_day_1"));
				pstmt.setString(25, (String) tabdata
						.get("working_week_2_day_2"));
				pstmt.setString(26, (String) tabdata
						.get("working_week_2_day_3"));
				pstmt.setString(27, (String) tabdata
						.get("working_week_2_day_4"));
				pstmt.setString(28, (String) tabdata
						.get("working_week_2_day_5"));
				pstmt.setString(29, (String) tabdata
						.get("working_week_2_day_6"));
				pstmt.setString(30, (String) tabdata
						.get("working_week_2_day_7"));
				pstmt.setString(31, (String) tabdata
						.get("working_week_3_day_1"));
				pstmt.setString(32, (String) tabdata
						.get("working_week_3_day_2"));
				pstmt.setString(33, (String) tabdata
						.get("working_week_3_day_3"));
				pstmt.setString(34, (String) tabdata
						.get("working_week_3_day_4"));
				pstmt.setString(35, (String) tabdata
						.get("working_week_3_day_5"));
				pstmt.setString(36, (String) tabdata
						.get("working_week_3_day_6"));
				pstmt.setString(37, (String) tabdata
						.get("working_week_3_day_7"));
				pstmt.setString(38, (String) tabdata
						.get("working_week_4_day_1"));
				pstmt.setString(39, (String) tabdata
						.get("working_week_4_day_2"));
				pstmt.setString(40, (String) tabdata
						.get("working_week_4_day_3"));
				pstmt.setString(41, (String) tabdata
						.get("working_week_4_day_4"));
				pstmt.setString(42, (String) tabdata
						.get("working_week_4_day_5"));
				pstmt.setString(43, (String) tabdata
						.get("working_week_4_day_6"));
				pstmt.setString(44, (String) tabdata
						.get("working_week_4_day_7"));
				pstmt.setString(45, (String) tabdata
						.get("working_week_5_day_1"));
				pstmt.setString(46, (String) tabdata
						.get("working_week_5_day_2"));
				pstmt.setString(47, (String) tabdata
						.get("working_week_5_day_3"));
				pstmt.setString(48, (String) tabdata
						.get("working_week_5_day_4"));
				pstmt.setString(49, (String) tabdata
						.get("working_week_5_day_5"));
				pstmt.setString(50, (String) tabdata
						.get("working_week_5_day_6"));
				pstmt.setString(51, (String) tabdata
						.get("working_week_5_day_7"));
				pstmt.setString(52, (String) tabdata
						.get("working_week_appl_day_1"));
				pstmt.setString(53, (String) tabdata
						.get("working_week_appl_day_2"));
				pstmt.setString(54, (String) tabdata
						.get("working_week_appl_day_3"));
				pstmt.setString(55, (String) tabdata
						.get("working_week_appl_day_4"));
				pstmt.setString(56, (String) tabdata
						.get("working_week_appl_day_5"));
				pstmt.setString(57, (String) tabdata
						.get("working_week_appl_day_6"));
				pstmt.setString(58, (String) tabdata
						.get("working_week_appl_day_7"));
				pstmt.setString(59, (String) tabdata.get("effstatus"));
				if (callfunc.equals("Pract_for_clinic")) {
					pstmt.setString(60, (String) tabdata.get("clinic"));
					pstmt.setString(61, (String) tabdata
							.get("modifiedFacilityId"));
					pstmt.setString(62, (String) tabdata.get("practitioner"));

				} else if (callfunc.equals("Resource_unit")) {
					String care_ind = (String) tabdata.get("unittype");
					if (care_ind.equals("Y"))
						pstmt.setString(60, "D");
					else
						pstmt.setString(60, (String) tabdata.get("unittype"));

					pstmt.setString(61, (String) tabdata.get("resclass"));
					pstmt.setString(62, (String) tabdata.get("restype"));
					pstmt.setString(63, (String) tabdata.get("resunit"));
					pstmt.setString(64, (String) tabdata
							.get("modifiedFacilityId"));
					pstmt.setString(65, (String) tabdata.get("resname"));
				}
				int res = pstmt.executeUpdate();
				if (res != 0) {
					result = true;
					java.util.Hashtable message = MessageManager.getMessage(
							locale, "RECORD_MODIFIED", "SM");
					sb.append((String) message.get("message"));

					con.commit();
					message.clear();
				} else {
					result = false;
					con.rollback();
				}
				if (pstmt != null)
					pstmt.close();
				tabdata.clear();
			} catch (Exception e) {
				sb.append(e.getMessage() + "<br>");
				e.printStackTrace();
				try {
					con.rollback();
				} catch (Exception ee) {
					ee.printStackTrace();
				}
			} finally {
				if (con != null)
					ConnectionManager.returnConnection(con, p);
			}
		}
		modifySB.setLength(0);
		results.put("status", new Boolean(result));
		results.put("error", sb.toString());
		return results;
	}
}
