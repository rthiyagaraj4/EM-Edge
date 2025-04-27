/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eOP;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;
import webbeans.eCommon.ConnectionManager;
import webbeans.eCommon.MessageManager;

public class CatalogForClinicServlet extends HttpServlet implements
		SingleThreadModel {

	public CatalogForClinicServlet() {
		con = null;
		can_commit = true;
		updrecs = 0;
		updrecs102 = 0;
		addedById = "";
		addedAtWorkstation = "";
		addedFacilityId = "";
		modifiedById = "";
		modifiedAtWorkstation = "";
		modifiedFacilityId = "";
		dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	}

	public void init(ServletConfig servletconfig) throws ServletException {
		super.init(servletconfig);
	}

	public void doPost(HttpServletRequest httpservletrequest,
			HttpServletResponse httpservletresponse) throws ServletException,
			IOException {

		session = httpservletrequest.getSession(false);
		facilityId = (String) session.getValue("facility_id");
		p = (Properties) session.getValue("jdbc");
		locale = p.getProperty("LOCALE");
		client_ip_address = p.getProperty("client_ip_address");

		try {

			httpservletrequest.setCharacterEncoding("UTF-8");
			httpservletresponse.setContentType("text/html;charset=UTF-8");
			out = httpservletresponse.getWriter();
			con = ConnectionManager.getConnection(httpservletrequest);

			InsertStatGrpNationDetail(httpservletrequest);

			if (can_commit) {
				con.commit();
				/*Hashtable hashtable = MessageManager.getMessage(locale,"RECORD_INSERTED", "SM");
				String s = (String) hashtable.get("message");
				httpservletresponse
						.sendRedirect("../eCommon/jsp/error.jsp?err_num="
								+ URLEncoder.encode(s,"UTF-8") + "&err_value=1");
				hashtable.clear();*/
				httpservletresponse.sendRedirect("../eCommon/jsp/error.jsp?err_num=&err_value=1");
			} else {
				con.rollback();
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		} finally {
			ConnectionManager.returnConnection(con, httpservletrequest);
		}
	}

	private void InsertStatGrpNationDetail(HttpServletRequest httpservletrequest)
			throws SQLException {
		can_commit = true;
		addedById = p.getProperty("login_user");
		String s = dateFormat.format(new java.util.Date());
		modifiedById = addedById;
		String s1 = s;
		addedFacilityId = facilityId;
		modifiedFacilityId = addedFacilityId;
		addedAtWorkstation = client_ip_address;
		modifiedAtWorkstation = addedAtWorkstation;
		String s2 = httpservletrequest.getParameter("stat_group");
		if (s2 == null)
			s2 = "";
		String s33 = httpservletrequest.getParameter("stat_group1");
		String locn = httpservletrequest.getParameter("locn");
		if (s33 == null)
			s33 = "";
		if (locn == null)
			locn = "";
		String delsql = "";
		String s3 = httpservletrequest.getParameter("insert_to_db");
		if (s3 == null)
			s3 = "";
		delsql = "delete from op_catalog_for_clinic where clinic_code =? and order_catalog_code= ? and facility_id= ? and CARE_LOCN_TYPE_IND = ? ";
		try {
			String recsetelmnt6 = "";
			HashMap al = (HashMap) session.getValue("arrlis");
			s666 = "select order_catalog_code from or_order_catalog where long_desc = ?";
			pstmt = con.prepareStatement(s666);
			delpstmt = con.prepareStatement(delsql);
			Collection cln = al.values();
			Iterator enum6 = cln.iterator();
			while (enum6.hasNext()) {
				recsetelmnt6 = (String) enum6.next();
				if (recsetelmnt6 == null)
					recsetelmnt6 = "";
				pstmt.setString(1, recsetelmnt6);
				r66 = pstmt.executeQuery();
				if (r66 != null) {
					while (r66.next()) {
						ordfin = r66.getString("order_catalog_code");
						delpstmt.setString(1, s2);
						delpstmt.setString(2, ordfin);
						delpstmt.setString(3, facilityId);
						delpstmt.setString(4, locn);
						delpstmt.executeUpdate();
					}
				}
				if (r66 != null)
					r66.close();
			}
			if (pstmt != null)
				pstmt.close();
			if (delpstmt != null)
				delpstmt.close();
			al.clear();
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			s54 = "select order_catalog_code from or_order_catalog where long_desc = ?";
			pstmt = con.prepareStatement(s54);
			Statement statement102 = con.createStatement();
			delpstmt = con.prepareStatement(delsql);
			HashMap serviceRecSet = null;
			serviceRecSet = (HashMap) session.getValue("StatNationalId");
			Collection coln = serviceRecSet.values();
			Iterator enumer = coln.iterator();
			while (enumer.hasNext()) {
				recsetelmnt = (String) enumer.next();
				if (recsetelmnt == null)
					recsetelmnt = "";
				pstmt.setString(1, recsetelmnt);
				r3 = pstmt.executeQuery();
				if (r3 != null) {
					while (r3.next()) {
						ordcatins = r3.getString("order_catalog_code");
						delpstmt.setString(1, s2);
						delpstmt.setString(2, ordcatins);
						delpstmt.setString(3, facilityId);
						delpstmt.setString(4, locn);
						delpstmt.executeUpdate();
					}
				}
				if (r3 != null)
					r3.close();
				String s111 = "insert into op_catalog_for_clinic (CARE_LOCN_TYPE_IND,facility_id,clinic_code,order_catalog_code,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID) values ('"
						+ locn
						+ "','"
						+ facilityId
						+ "','"
						+ s2
						+ "','"
						+ ordcatins
						+ "', '"
						+ addedById
						+ "', "
						+ "to_date('"
						+ s
						+ "','yyyy-mm-dd'), "
						+ "'"
						+ addedAtWorkstation
						+ "', '"
						+ addedFacilityId
						+ "', '"
						+ modifiedById
						+ "', "
						+ "to_date('"
						+ s1
						+ "','yyyy-mm-dd'), "
						+ "'"
						+ modifiedAtWorkstation
						+ "', '"
						+ modifiedFacilityId
						+ "')\t";
						
				updrecs102 = statement102.executeUpdate(s111);
				if (updrecs102 == 0) {
					can_commit = false;
					return;
				}
			}

			if (delpstmt != null)
				delpstmt.close();
			if (pstmt != null)
				pstmt.close();
			if (statement102 != null)
				statement102.close();
			serviceRecSet.clear();
		} catch (Exception e) {
			e.printStackTrace();
		}

		tokeniseForSql(s2, s3, locn, delsql);
		try {
			st5 = con.createStatement();
			statement1 = con.createStatement();
			StringTokenizer stringtokenizer1 = new StringTokenizer(s3, "~");
			if (stringtokenizer1 != null)
				while (stringtokenizer1.hasMoreTokens()) {
					String flag3 = "D";
					String s5 = stringtokenizer1.nextToken();
					StringTokenizer stringtokenizer3 = new StringTokenizer(s5,
							"|");
					if (stringtokenizer3.hasMoreTokens()) {
						String s7 = stringtokenizer3.nextToken();
						String s9 = stringtokenizer3.nextToken();
						s54 = "select order_catalog_code from op_catalog_for_clinic where clinic_code = '"
								+ s2
								+ "' and CARE_LOCN_TYPE_IND ='"
								+ locn
								+ "'";
						rs5 = st5.executeQuery(s54);
						if (rs5 != null) {
							while (rs5.next()) {
								orc = rs5.getString("order_catalog_code");
								if (orc.equals(s33))
									flag3 = "E";
								else
									flag3 = "D";
							}
						}
						if (rs5 != null)
							rs5.close();
						if ((s9.equals("Y")) && (flag3.equals("D"))) {
							String s11 = "insert into op_catalog_for_clinic (CARE_LOCN_TYPE_IND,facility_id,clinic_code,order_catalog_code,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID) values ('"
									+ locn
									+ "','"
									+ facilityId
									+ "','"
									+ s2
									+ "','"
									+ s7
									+ "', '"
									+ addedById
									+ "', "
									+ "to_date('"
									+ s
									+ "','yyyy-mm-dd'), "
									+ "'"
									+ addedAtWorkstation
									+ "', '"
									+ addedFacilityId
									+ "', '"
									+ modifiedById
									+ "', "
									+ "to_date('"
									+ s1
									+ "','yyyy-mm-dd'), "
									+ "'"
									+ modifiedAtWorkstation
									+ "', '"
									+ modifiedFacilityId + "')\t";
							updrecs = statement1.executeUpdate(s11);
							
							if (updrecs == 0) {
								can_commit = false;
								return;
							}
						}
					}
				}
		} catch (Exception exception1) {
			
				exception1.printStackTrace();
		} finally {
			if (statement1 != null)
				statement1.close();
			if (st5 != null)
				st5.close();
		}
	}

	public void tokeniseForSql(String s2, String s3, String locn, String delsql) {
		try {
			String s4 = "";
			String s6 = "";
			delpstmt = con.prepareStatement(delsql);
			StringTokenizer stringtokenizer = new StringTokenizer(s3, "~");
			if (stringtokenizer != null)
				while (stringtokenizer.hasMoreTokens()) {
					s4 = stringtokenizer.nextToken();
					StringTokenizer stringtokenizer2 = new StringTokenizer(s4,
							"|");
					if (stringtokenizer2.hasMoreTokens()) {
						s6 = stringtokenizer2.nextToken();
						delpstmt.setString(1, s2);
						delpstmt.setString(2, s6);
						delpstmt.setString(3, facilityId);
						delpstmt.setString(4, locn);
						updrecs = delpstmt.executeUpdate();
					}
				}
			if (delpstmt != null)
				delpstmt.close();
		} catch (Exception exception) {
			out.print("JS Delete  failed " + exception);
			exception.printStackTrace();
		}
	}

	Connection con;

	boolean can_commit;

	PrintWriter out;

	Properties p;

	int updrecs;

	int updrecs102;

	String facilityId;

	String s54 = "";

	String client_ip_address;

	HttpSession session;

	String addedById;

	String s666;

	String addedAtWorkstation;

	String addedFacilityId;

	String modifiedById;

	String modifiedAtWorkstation;

	String modifiedFacilityId;

	SimpleDateFormat dateFormat;

	Statement st5;

	Statement statement1;

	PreparedStatement pstmt = null;

	PreparedStatement delpstmt = null;

	ResultSet rs5;

	ResultSet r3;

	ResultSet r66;

	String recsetelmnt = "";

	String ordcatins = "";

	String orc = "";

	String ordfin = "";

	String locale = "";

}
