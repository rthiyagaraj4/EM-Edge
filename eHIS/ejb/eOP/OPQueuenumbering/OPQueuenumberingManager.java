/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eOP.OPQueuenumbering;

import java.rmi.*;
import javax.ejb.*;
import java.sql.*;
import javax.naming.*;
import javax.rmi.*;
import webbeans.eCommon.*;


/**
*
* @ejb.bean
*	name="OPQueuenumbering"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="OPQueuenumbering"
*	local-jndi-name="OPQueuenumbering"
*	impl-class-name="eOP.OPQueuenumbering.OPQueuenumberingManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eOP.OPQueuenumbering.OPQueuenumberingManagerLocal"
*	remote-class="eOP.OPQueuenumbering.OPQueuenumberingManagerRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eOP.OPQueuenumbering.OPQueuenumberingManagerLocalHome"
*	remote-class="eOP.OPQueuenumbering.OPQueuenumberingManagerHome"
*	generate= "local,remote"
*
*
*/

public class OPQueuenumberingManager implements SessionBean {
	Connection con;

	PreparedStatement pstmt;

	java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat(
			"yyyy-MM-dd");

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
	public java.util.HashMap insertQueuenumbering(java.util.Properties p,
			java.util.HashMap tabdata) {

		java.util.HashMap results = new java.util.HashMap();

		boolean result = false;
		boolean insertable = true;

		String locale = p.getProperty("LOCALE");
		String facilityId = (String) tabdata.get("facilityId");
		String locntype = (String) tabdata.get("locntype");
		String locncode = (String) tabdata.get("locncode");
		String pracid = (String) tabdata.get("pracid");
		String roomid = (String) tabdata.get("roomid");
		String room_no = (String) tabdata.get("room_no1");
		String otherresource = (String) tabdata.get("otherresource");
		String walkin = (String) tabdata.get("walk_in");
		String referral = (String) tabdata.get("referral");
		String appointment = (String) tabdata.get("appointment");
		String addedFacilityId = (String) tabdata.get("AddedfacilityId");
		String addedAtWorkstation = (String) tabdata.get("client_ip_address");

		StringBuffer sb = new StringBuffer("");

		String sql = "insert into OP_QUEUE_NUM_FOR_LOCN( facility_id, locn_type, locn_code, practitioner_id, other_res_class, WALK_IN_QUEUE_ID, REFERRAL_QUEUE_ID, APPT_QUEUE_ID, added_by_id, added_date, added_facility_id, added_at_ws_no, modified_by_id, modified_date, modified_facility_id, modified_at_ws_no,other_resource_id,room_num ) values ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?)";

		String addedById = p.getProperty("login_user");
		String addedDate = dateFormat.format(new java.util.Date());
		String modifiedById = addedById;
		String modifiedDate = addedDate;
		String modifiedFacilityId = addedFacilityId;
		String modifiedAtWorkstation = addedAtWorkstation;
		Date added_date = Date.valueOf(addedDate);
		Date modified_date = Date.valueOf(modifiedDate);
		try {

			con = ConnectionManager.getConnection(p);
			String duplicateSql = "select * from  OP_QUEUE_NUM_FOR_LOCN where facility_id = ? and locn_type = ? and locn_code = ? and practitioner_id = NVL(?,'*ALL') and room_num = NVL(?,'*ALL') and OTHER_RES_CLASS = NVL(?,'*') and OTHER_RESOURCE_ID=NVL(?,'*ALL') ";
			pstmt = con.prepareStatement(duplicateSql);

			pstmt.setString(1, facilityId);
			pstmt.setString(2, locntype);
			pstmt.setString(3, locncode);
			pstmt.setString(4, pracid);
			pstmt.setString(5, room_no);
			pstmt.setString(6, otherresource);
			pstmt.setString(7, roomid);

			ResultSet rs = pstmt.executeQuery();
			if (rs != null) {
				if (rs.next()) {
					insertable = false;

					java.util.Hashtable message = MessageManager.getMessage(
							locale, "CODE_ALREADY_EXISTS", "Common");
					sb.append((String) message.get("message"));
					con.commit();
					message.clear();
				}
			}
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();

		} catch (Exception e) {
			insertable = false;
			sb.append(e + "<br>");
			e.printStackTrace();
			if (con != null) {
				try {
					if (con != null)
						ConnectionManager.returnConnection(con, p);
				} catch (Exception ee) {
					try {
						con.rollback();
					} catch (Exception ce) {
					}

				}
			}
		}

		if (insertable) {
			try {
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, facilityId);
				pstmt.setString(2, locntype);
				pstmt.setString(3, locncode);
				pstmt.setString(4, pracid);
				pstmt.setString(5, otherresource);
				pstmt.setString(6, walkin);
				pstmt.setString(7, referral);
				pstmt.setString(8, appointment);
				pstmt.setString(9, addedById);
				pstmt.setDate(10, added_date);
				pstmt.setString(11, addedFacilityId);
				pstmt.setString(12, addedAtWorkstation);
				pstmt.setString(13, modifiedById);
				pstmt.setDate(14, modified_date);
				pstmt.setString(15, modifiedFacilityId);
				pstmt.setString(16, modifiedAtWorkstation);
				pstmt.setString(17, roomid);
				pstmt.setString(18, room_no);
				int res = pstmt.executeUpdate();

				if (res != 0) {
					result = true;
					java.util.Hashtable message = MessageManager.getMessage(
							locale, "RECORD_INSERTED", "SM");
					sb.append((String) message.get("message"));

					con.commit();
					message.clear();
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
				}
			}

			finally {
				if (con != null) {
					try {
						ConnectionManager.returnConnection(con, p);
					} catch (Exception ee) {
					}
				}
			}
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
	public java.util.HashMap updateQueuenumbering(java.util.Properties p,
			java.util.HashMap tabdata) {
		String locale = p.getProperty("LOCALE");
		java.util.HashMap results = new java.util.HashMap();
		boolean result = false;
		String facilityId = (String) tabdata.get("facilityId");
		String locntype = (String) tabdata.get("locntype");
		String locncode = (String) tabdata.get("locncode");
		String pracid = (String) tabdata.get("pracid");
		String roomid = (String) tabdata.get("roomid");

		String room_no = (String) tabdata.get("room_no1");
		String otherresource = (String) tabdata.get("otherresource");
		String walkin = (String) tabdata.get("walk_in");
		String referral = (String) tabdata.get("referral");
		String appointment = (String) tabdata.get("appointment");
		String addedFacilityId = (String) tabdata.get("AddedfacilityId");
		String addedAtWorkstation = (String) tabdata.get("client_ip_address");

		StringBuffer sb = new StringBuffer("");

		String sql1 = "update OP_QUEUE_NUM_FOR_LOCN set WALK_IN_QUEUE_ID   = ?,REFERRAL_QUEUE_ID=?,APPT_QUEUE_ID=?, modified_by_id   = ?, modified_date   = ?, modified_facility_id  = ?, modified_at_ws_no  = ? where facility_id = ? and locn_type    = ? and locn_code = ? and practitioner_id   = ? and room_num   = ? and OTHER_RES_CLASS=? and OTHER_RESOURCE_ID=?";

		String modifiedById = p.getProperty("login_user");
		String modifiedDate = dateFormat.format(new java.util.Date());
		Date modified_date = Date.valueOf(modifiedDate);
		String modifiedFacilityId = addedFacilityId;
		String modifiedAtWorkstation = addedAtWorkstation;

		try {

			con = ConnectionManager.getConnection(p);
			pstmt = con.prepareStatement(sql1);
			pstmt.setString(1, walkin);
			pstmt.setString(2, referral);
			pstmt.setString(3, appointment);
			pstmt.setString(4, modifiedById);
			pstmt.setDate(5, modified_date);
			pstmt.setString(6, modifiedFacilityId);
			pstmt.setString(7, modifiedAtWorkstation);
			pstmt.setString(8, facilityId);
			pstmt.setString(9, locntype);
			pstmt.setString(10, locncode);
			pstmt.setString(11, pracid);
			pstmt.setString(12, room_no);
			pstmt.setString(13, otherresource);
			pstmt.setString(14, roomid);

			int res = pstmt.executeUpdate();
			if (res != 0) {
				result = true;
				java.util.Hashtable message = MessageManager.getMessage(locale,
						"RECORD_MODIFIED", "SM");
				sb.append((String) message.get("message"));

				con.commit();
				message.clear();
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
			}
		} finally {
			if (con != null) {
				try {
					ConnectionManager.returnConnection(con, p);
				} catch (Exception ee) {
				}
			}
		}

		results.put("status", new Boolean(result));
		results.put("error", sb.toString());
		return results;
	}
}
