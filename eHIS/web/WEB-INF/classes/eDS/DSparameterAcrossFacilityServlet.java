/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eDS;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import webbeans.eCommon.ConnectionManager;

/**
 * Servlet implementation class DSparameterAcrossFacilityServlet
 */
public class DSparameterAcrossFacilityServlet extends HttpServlet {
    // Checkstyle Violation commented by Munisekhar
	//private static final long serialVersionUID = 1L;
	PrintWriter out;
	java.util.Properties prop;
	HttpSession session;
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	HashMap support_data = new HashMap();
	String msg="";

	StringBuffer sb = new StringBuffer();
	String facility_id="",str_user_id="",str_client_ip_address="",login_user="",locale="",deptCode="",uomCode="",mode="";
	Boolean isUpdateSuccess=false;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public DSparameterAcrossFacilityServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String error_value = "0" ;
		String error = "";
	    // Checkstyle Violation commented by Munisekhar
		//boolean flag=true;
		session = request.getSession(false);
		this.prop = (java.util.Properties) session.getValue("jdbc");
		this.facility_id = (String) request.getParameter("facilityId");
		if(facility_id == null) facility_id="";
		str_user_id      = (String) session.getValue("login_user");
		if(str_user_id == null) str_user_id="";
		str_client_ip_address = prop.getProperty("client_ip_address");
		login_user = prop.getProperty( "login_user" ) ;
		if(str_client_ip_address == null) str_client_ip_address="";
		if(login_user == null) login_user="";
		locale = prop.getProperty("LOCALE");

		try {
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/html;charset=UTF-8");
			this.out = response.getWriter();

			this.deptCode=(String)request.getParameter("deptCode");
			this.uomCode=(String)request.getParameter("uomCode");
			this.mode=(String)request.getParameter("mode");
			System.out.println("mode"+mode+"**************");

			con	=	ConnectionManager.getConnection(request);

			if(mode.equals("modify")) {
				String strQuery="update DS_PARAM set DEPT_CODE=?, ENERGY_UOM=?, ADDED_BY_ID=?, ADDED_DATE=?, ADDED_FACILITY_ID=?, ADDED_AT_WS_NO=?, MODIFIED_BY_ID=?, MODIFIED_DATE=?, MODIFIED_FACILITY_ID=?, MODIFIED_AT_WS_NO=? where SL_NO=1";
				pstmt = con.prepareStatement(strQuery);
				pstmt.setString(1,deptCode);
				pstmt.setString(2,uomCode);
				pstmt.setString(3,login_user);
				pstmt.setTimestamp(4,new  java.sql.Timestamp(System.currentTimeMillis()));
				pstmt.setString(5,facility_id);
				pstmt.setString(6,str_client_ip_address);
				pstmt.setString(7,login_user);
				pstmt.setTimestamp(8,new  java.sql.Timestamp(System.currentTimeMillis()));
				pstmt.setString(9,facility_id);
				pstmt.setString(10,str_client_ip_address);


				int row=pstmt.executeUpdate();
				if (row >0)
				{
					isUpdateSuccess = true;
				}
			}

			else if(mode.equals("insert")) {
				String strQuery="INSERT INTO DS_PARAM (DEPT_CODE, ENERGY_UOM, ADDED_BY_ID, ADDED_DATE, ADDED_FACILITY_ID, ADDED_AT_WS_NO, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_FACILITY_ID, MODIFIED_AT_WS_NO, SL_NO) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
				pstmt = con.prepareStatement(strQuery);
				pstmt.setString(1,deptCode);
				pstmt.setString(2,uomCode);
				pstmt.setString(3,login_user);
				pstmt.setTimestamp(4,new  java.sql.Timestamp(System.currentTimeMillis()));
				pstmt.setString(5,facility_id);
				pstmt.setString(6,str_client_ip_address);
				pstmt.setString(7,login_user);
				pstmt.setTimestamp(8,new  java.sql.Timestamp(System.currentTimeMillis()));
				pstmt.setString(9,facility_id);
				pstmt.setString(10,str_client_ip_address);
				pstmt.setInt(11,1);

				int row=pstmt.executeUpdate();
				if (row >0)
				{
					isUpdateSuccess = true;
				}
			}

			if (isUpdateSuccess) {
				error_value = "1" ;
				error = "APP-SM0070 Operation Completed Successfully ....";
			}
			else error = "Record has not been saved. Please try again";
			response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode(error,"UTF-8"  )+"&err_value="+error_value );
		}
		catch(SQLException sqle) {
			System.err.println("exception in DSparameterAcrossFacility" + sqle.toString());
			sqle.printStackTrace();
			isUpdateSuccess = false;
		}
		catch(Exception e) {
			System.err.println("exception in DSparameterAcrossFacility" + e.toString());
			e.printStackTrace();
			isUpdateSuccess = false;
		}
		finally {
			try {
				pstmt.close();
				if(isUpdateSuccess)con.commit();
				else con.rollback();
				//con.close();
				if(con!=null)ConnectionManager.returnConnection(con,request); //Common-ICN-0052
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
