/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eOP.VisitTypeClinic;

import java.io.PrintStream;
import blopin.*;
import java.rmi.*;
import javax.ejb.*;
import java.sql.*;
import java.util.*;
import javax.naming.*;
import javax.rmi.*;
import webbeans.eCommon.*;


/**
*
* @ejb.bean
*	name="VisitTypeClinic"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="VisitTypeClinic"
*	local-jndi-name="VisitTypeClinic"
*	impl-class-name="eOP.VisitTypeClinic.VisitTypeClinicManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eOP.VisitTypeClinic.VisitTypeClinicLocal"
*	remote-class="eOP.VisitTypeClinic.VisitTypeClinicRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eOP.VisitTypeClinic.VisitTypeClinicLocalHome"
*	remote-class="eOP.VisitTypeClinic.VisitTypeClinicHome"
*	generate= "local,remote"
*
*
*/

public class VisitTypeClinicManager implements SessionBean {

	Connection con;

	PreparedStatement pstmt = null;

	StringBuffer sql = new StringBuffer();

	String locale = "";

//	public final String RECORD_MODIFIED = "RECORD_MODIFIED";

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

	public java.util.HashMap InsertVisitType(java.util.Properties p,
			HashMap tabdata)

	{

		java.util.HashMap results = new java.util.HashMap();
		boolean result = false;
		boolean updatable = true;
		int res = 0;
		StringBuffer sb = new StringBuffer();
		locale = p.getProperty("LOCALE");
		try {
			con = ConnectionManager.getConnection(p);
			con.setAutoCommit(false);

			if (updatable) {

				sql
						.append("Insert into op_visit_type(FACILITY_ID, VISIT_TYPE_CODE, LONG_DESC, SHORT_DESC, VISIT_TYPE_IND, MAX_APPT_DURATION, MAX_APPT_SLOTS, EFF_STATUS, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID, ORDER_CATALOG_CRITERIA,rd_appl_yn,COLOR_INDICATOR,virtual_consultation)values(?,?,?,?,?,?,?,?,?,sysdate,?,?,?,sysdate,?,?,?,?,?,?)");

				pstmt = con.prepareStatement(sql.toString());
				pstmt.setString(1, (String) tabdata.get("facility_id"));
				pstmt.setString(2, (String) tabdata.get("Visit_Type_code"));
				pstmt.setString(3, (String) tabdata.get("long_desc"));
				pstmt.setString(4, (String) tabdata.get("short_desc"));
				pstmt.setString(5, (String) tabdata.get("visit_type_ind"));
				pstmt.setString(6, (String) tabdata.get("max_appt_duration"));
				pstmt.setString(7, (String) tabdata.get("max_appt_slots"));
				pstmt.setString(8, (String) tabdata.get("eff_status"));
				pstmt.setString(9, (String) tabdata.get("added_by_id"));
				pstmt.setString(10, (String) tabdata.get("added_at_ws_no"));
				pstmt.setString(11, (String) tabdata.get("added_facility_id"));
				pstmt.setString(12, (String) tabdata.get("modified_by_id"));
				pstmt.setString(13, (String) tabdata.get("added_at_ws_no"));
				pstmt.setString(14, (String) tabdata.get("modified_facility_id"));
				pstmt.setString(15, (String) tabdata.get("ORDER_CATALOG_CRITERIA"));
				pstmt.setString(16, (String) tabdata.get("rd_appl_yn"));
				pstmt.setString(17, (String) tabdata.get("COLOR_INDICATOR"));
				pstmt.setString(18, (String) tabdata.get("virtual_consultation"));//<!--added by Himanshu Saxena for ML-MMOH-CRF-1930 (U2) on 18-04-2023 Started -->
				res = pstmt.executeUpdate();
				if (res != 0)
					updatable = true;
				else
					updatable = false;
			}
			if (updatable) {
				con.commit();
				result = true;
				java.util.Hashtable message = MessageManager.getMessage(locale,
						"RECORD_INSERTED", "SM");
				sb.append((String) message.get("message"));
				message.clear();
			} else {
				con.rollback();
				result = false;
			}

			if (pstmt != null)
				pstmt.close();
			sql.setLength(0);
			tabdata.clear();
		} catch (Exception e) {

			sb.append(e.toString() + "<br>");
			e.printStackTrace();
			try {
				
				con.rollback();
				updatable = false;
			} catch (Exception ce) {
				sb.append(e.toString());
				sb.append(ce.toString() + "<br>");
				e.printStackTrace();
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

	public java.util.HashMap UpdateVisitType(java.util.Properties p,
			HashMap tabdata)

	{
		java.util.HashMap results = new java.util.HashMap();
		boolean result = false;
		boolean updatable = true;
		locale = p.getProperty("LOCALE");
		int res = 0;
		StringBuffer sb = new StringBuffer("");
		try {
			con = ConnectionManager.getConnection(p);
			con.setAutoCommit(false);
			if (updatable) {
				sql
						.append("update op_visit_type set LONG_DESC=?, SHORT_DESC=?, MAX_APPT_DURATION=?, MAX_APPT_SLOTS=?,  EFF_STATUS=?, MODIFIED_BY_ID=?, MODIFIED_DATE=sysdate, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=?, ORDER_CATALOG_CRITERIA=?,rd_appl_yn=?,COLOR_INDICATOR=?,virtual_consultation=?  where facility_id=? and visit_type_code=?");
				pstmt = con.prepareStatement(sql.toString());
				pstmt.setString(1, (String) tabdata.get("long_desc"));
				pstmt.setString(2, (String) tabdata.get("short_desc"));
				pstmt.setString(3, (String) tabdata.get("max_appt_duration"));
				pstmt.setString(4, (String) tabdata.get("max_appt_slots"));
				pstmt.setString(5, (String) tabdata.get("eff_status"));
				pstmt.setString(6, (String) tabdata.get("modified_by_id"));
				pstmt.setString(7, (String) tabdata.get("added_at_ws_no"));
				pstmt.setString(8, (String) tabdata.get("modified_facility_id"));
				pstmt.setString(9, (String) tabdata.get("ORDER_CATALOG_CRITERIA"));
				pstmt.setString(10, (String) tabdata.get("rd_appl_yn"));
				pstmt.setString(11, (String) tabdata.get("COLOR_INDICATOR")); 
				pstmt.setString(12, (String) tabdata.get("virtual_consultation"));//<!--added by Himanshu Saxena for ML-MMOH-CRF-1930 (U2) on 18-04-2023 Started -->
				pstmt.setString(13, (String) tabdata.get("facility_id"));
				pstmt.setString(14, (String) tabdata.get("Visit_Type_code"));
				

				res = pstmt.executeUpdate();
				if (res != 0)
					updatable = true;
				else
					updatable = false;
			}
			if (updatable) {
				con.commit();
				result = true;
				java.util.Hashtable message = MessageManager.getMessage(locale,
						"RECORD_MODIFIED", "SM");
				sb.append((String) message.get("message"));
				message.clear();
			} else {
				con.rollback();
				updatable = false;
				result = false;
			}

			if (pstmt != null)
				pstmt.close();
			sql.setLength(0);
			tabdata.clear();

		} catch (Exception e) {
			sb.append(e.toString() + "<br>");
			e.printStackTrace();
			try {
				con.rollback();
			} catch (Exception ce) {
				sb.append(e.toString());
				sb.append(ce.toString() + "<br>");
				e.printStackTrace();
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
