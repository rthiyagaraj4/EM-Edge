/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eOP.OPClinicService;

import java.rmi.*;
import javax.ejb.*;
import java.util.*;
import java.sql.*;
import javax.naming.*;
import javax.rmi.*;
import webbeans.eCommon.*;


/**
*
* @ejb.bean
*	name="OPClinicService"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="OPClinicService"
*	local-jndi-name="OPClinicService"
*	impl-class-name="eOP.OPClinicService.OPClinicServiceManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eOP.OPClinicService.OPClinicServiceManagerLocal"
*	remote-class="eOP.OPClinicService.OPClinicServiceManagerRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eOP.OPClinicService.OPClinicServiceManagerLocalHome"
*	remote-class="eOP.OPClinicService.OPClinicServiceManagerHome"
*	generate= "local,remote"
*
*
*/


public class OPClinicServiceManager implements SessionBean {

	Connection con = null;

	PreparedStatement pstmt;

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
	
	
	public java.util.HashMap ServiceAddModify(Properties p, HashMap tabdata) {

		java.util.HashMap results = new java.util.HashMap();
		locale = p.getProperty("LOCALE");
		String added_by_id = (String) tabdata.get("modified_by_id");

		String client_ip_address = (String) tabdata.get("modified_at_ws_no");
		Integer totCount = (Integer) tabdata.get("totCount");
		int totalCount = totCount.intValue();
		StringBuffer sb = new StringBuffer();
		String clinic_code = "";
		String dept_code = "";
		clinic_code = (String) tabdata.get("clinic_code");
		dept_code = (String) tabdata.get("dept_code");
		String clinic_type = (String) tabdata.get("clinic_type");
		String care_ind = (String) tabdata.get("care_ind");

		String facility_id = (String) tabdata.get("facilityId");
		boolean result = true;

		try {
			con = ConnectionManager.getConnection(p);
			con.setAutoCommit(false);
			try {
				String sql = "";

				int res = 0;

				if (!dept_code.equals("")) {
					sql = "delete from OP_CLINIC_FOR_SERVICE where  clinic_code='"
							+ clinic_code
							+ "' and FACILITY_ID ='"
							+ facility_id
							+ "' and DEPT_CODE=nvl('"
							+ dept_code
							+ "',dept_code)  and clinic_type='"
							+ clinic_type
							+ "' and CARE_LOCN_TYPE_IND='" + care_ind + "' ";
				} else {
					sql = "delete from OP_CLINIC_FOR_SERVICE where  clinic_code='"
							+ clinic_code
							+ "' and FACILITY_ID ='"
							+ facility_id
							+ "' and clinic_type='"
							+ clinic_type
							+ "' and CARE_LOCN_TYPE_IND='" + care_ind + "' ";
				}
				pstmt = con.prepareStatement(sql);
				res = pstmt.executeUpdate();
				if (res > 0)
					result = true;
				else
					result = false;

				if (pstmt != null)
					pstmt.close();

			} catch (Exception e) {
				e.printStackTrace();
			}
			StringBuffer sqli = new StringBuffer();
			sqli.setLength(0);

			for (int i = 0; i < totalCount; i++) {
				String service_code = (String) tabdata.get("chk" + i);
				String department_code = (String) tabdata.get("dept" + i);
				sqli.setLength(0);
				sqli.append("Insert into OP_CLINIC_FOR_SERVICE ");
				sqli.append("(FACILITY_ID, ");
				sqli.append("clinic_code, ");
				sqli.append("SERVICE_CODE, ");
				sqli.append("DEPT_CODE, ");
				sqli.append("ADDED_BY_ID, ");
				sqli.append("ADDED_DATE, ");
				sqli.append("ADDED_AT_WS_NO,");
				sqli.append("ADDED_FACILITY_ID, ");
				sqli.append("MODIFIED_BY_ID, ");
				sqli.append("MODIFIED_DATE, ");
				sqli.append("MODIFIED_AT_WS_NO, ");
				sqli.append(" MODIFIED_FACILITY_ID , ");
				sqli.append("CARE_LOCN_TYPE_IND, ");
				sqli.append("CLINIC_TYPE ) ");
				sqli.append("values ( ");
				sqli.append(" '" + facility_id + "', '" + clinic_code + "', '"
						+ service_code + "', '" + department_code + "', '"
						+ added_by_id + "', sysdate, '" + client_ip_address
						+ "', '" + facility_id + "', '" + added_by_id
						+ "', sysdate, '" + client_ip_address + "','"
						+ facility_id + "','" + care_ind + "','" + clinic_type
						+ "' ) ");
				pstmt = con.prepareStatement(sqli.toString());

				/*
				 * pstmt.setString(1,facility_id);
				 * pstmt.setString(2,clinic_code); pstmt.setString(3,
				 * service_code ); pstmt.setString(4, department_code );
				 * pstmt.setString (5, added_by_id); pstmt.setString(6,
				 * client_ip_address) ; pstmt.setString(7, facility_id ) ;
				 * pstmt.setString(8, added_by_id ) ; pstmt.setString(9,
				 * client_ip_address) ; pstmt.setString(10, facility_id ) ;
				 * pstmt.setString(11, care_ind ) ; pstmt.setString(12,
				 * clinic_type ) ;
				 */
				int res1 = pstmt.executeUpdate();

				if (res1 > 0)
					result = true;
				else
					result = false;
				if (pstmt != null)
					pstmt.close();
				sqli.setLength(0);
			}

			if (result) {
				con.commit();
			    java.util.Hashtable message = MessageManager.getMessage(locale,"RECORD_INSERTED", "SM");
				sb.append((String) message.get("message"));
			} else {
				con.rollback();
				
			}

			tabdata.clear();
			// message.clear();
		} catch (Exception ee) {
			sb.append("Error in main try block " + ee.getMessage());
			ee.printStackTrace();
		} finally {
			if (con != null)
				ConnectionManager.returnConnection(con, p);
		}
		
		results.put("status", new Boolean(result));
		results.put("error", sb.toString());
		return results;
	}
} // end session bean
