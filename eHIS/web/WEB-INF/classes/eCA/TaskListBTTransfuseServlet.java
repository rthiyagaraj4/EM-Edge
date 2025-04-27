/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eCA ;

import java.sql.*;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.naming.*;
import javax.rmi.*;

import webbeans.eCommon.*;
import webbeans.eCommon.MessageManager;
import com.ehis.util.DateUtils;

public class TaskListBTTransfuseServlet extends HttpServlet
{
	public void init(ServletConfig cfg) throws ServletException
	{
		super.init(cfg);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, java.io.IOException
    {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		java.io.PrintWriter out = response.getWriter();
		HttpSession session	=	null;
        session		=	request.getSession(true) ;

		try
        {
			record(request,response,session,out);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			
		}
	}

	private void record(HttpServletRequest request, HttpServletResponse response, HttpSession session, PrintWriter out)
	{
		java.util.Properties p;
		Connection con = null;
		CallableStatement cstmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		session						= request.getSession(false);
		p							= (java.util.Properties) session.getValue("jdbc") ;
		String locale				= p.getProperty("LOCALE");
		String client_ip_address	= (String) p.getProperty("client_ip_address");
		String login_user			= (String) p.getProperty("login_user");

		String facility_id = request.getParameter("facility_id") == null ? "" : request.getParameter("facility_id");
		String specimen_no = request.getParameter("specimen_no") == null ? "" : request.getParameter("specimen_no");
		String patient_id = request.getParameter("patient_id") == null ? "" : request.getParameter("patient_id");
		String unit_no = request.getParameter("unit_no") == null ? "" : request.getParameter("unit_no");
		String product_code = request.getParameter("product_code") == null ? "" : request.getParameter("product_code");
		String transfuse_pract_id1 = request.getParameter("transfuse_pract_id1") == null ? "" : request.getParameter("transfuse_pract_id1");
		String transfuse_pract_id2 = request.getParameter("transfuse_pract_id2") == null ? "" : request.getParameter("transfuse_pract_id2");
		String check_pract_id = request.getParameter("check_pract_id") == null ? "" : request.getParameter("check_pract_id");
		String start_date_time = request.getParameter("start_date_time") == null ? "" : request.getParameter("start_date_time");
		String end_date_time = request.getParameter("end_date_time") == null ? "" : request.getParameter("end_date_time");
		String current_vol = request.getParameter("current_vol") == null ? "" : request.getParameter("current_vol");
		String reaction_code = request.getParameter("reaction_code") == null ? "" : request.getParameter("reaction_code");
		String remarks = request.getParameter("remarks") == null ? "" : request.getParameter("remarks");
		remarks = remarks.replace('\"','\n');
		String location_code = request.getParameter("location_code") == null ? "" : request.getParameter("location_code");
		String partial_check = request.getParameter("partial_check") == null ? "" : request.getParameter("partial_check");
		String partial_trans_code = request.getParameter("partial_trans_code") == null ? "" : request.getParameter("partial_trans_code");

		String checked_user = "";
		String transfuse_user1 = "";
		String transfuse_user2 = "";

		try
		{
			/* Added by Kishore kumar N, 12/05/2010 for incident 21239 */
			start_date_time = DateUtils.convertDate(start_date_time+":00", "DMYHMS", locale, "en");
			end_date_time = DateUtils.convertDate(end_date_time+":00", "DMYHMS", locale, "en");
			/* ends here.*/

			con = ConnectionManager.getConnection(request);

			String sql = "SELECT APPL_USER_ID FROM SM_APPL_USER WHERE FUNC_ROLE_ID = ? ";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,check_pract_id);
			rs = pstmt.executeQuery();
			if(rs.next())
			{
				checked_user = rs.getString(1) == null ? "" : rs.getString(1);
			}
			if(rs != null) rs.close();

			pstmt.setString(1,transfuse_pract_id1);
			rs = pstmt.executeQuery();
			if(rs.next())
			{
				transfuse_user1 = rs.getString(1) == null ? "" : rs.getString(1);
			}
			if(rs != null) rs.close();

			pstmt.setString(1,transfuse_pract_id2);
			rs = pstmt.executeQuery();
			if(rs.next())
			{
				transfuse_user2 = rs.getString(1) == null ? "" : rs.getString(1);
			}
			if(pstmt != null) pstmt.close();
			if(rs != null) rs.close();

			cstmt = con.prepareCall("{call BT_TRANSFUSE_COMMIT.main(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}" );

			cstmt.setString(1,facility_id);
			cstmt.setString(2,specimen_no);
			cstmt.setString(3,patient_id);
			cstmt.setString(4,unit_no);
			cstmt.setString(5,product_code);
			cstmt.setString(6,client_ip_address);
			cstmt.setString(7,login_user);
			cstmt.setString(8,transfuse_user1);
			cstmt.setString(9,transfuse_user2);
			cstmt.setString(10,checked_user);
			cstmt.setString(11,start_date_time);
			cstmt.setString(12,end_date_time);
			cstmt.setString(13,current_vol);
			cstmt.setString(14,reaction_code);
			cstmt.setString(15,remarks);
			cstmt.setString(16,location_code);
			cstmt.registerOutParameter(17,Types.VARCHAR);
			cstmt.registerOutParameter(18,Types.VARCHAR);
			cstmt.setString(19,partial_check);
			cstmt.setString(20,partial_trans_code);
			cstmt.execute();

			if(cstmt != null) cstmt.close();

			con.commit();

			MessageManager mm = new MessageManager();
			final java.util.Hashtable mesg = mm.getMessage(locale,"RECORD_INSERTED","CA");
			String errorMsg = (String) mesg.get("message");
			out.println("<script>alert('"+errorMsg+"')</script>");
			out.println("<script>window.close();</script>");
		}
		catch(Exception e)
		{
			try
			{
				con.rollback();
			}
			catch(Exception exc)
			{
				exc.printStackTrace();
			}
			e.printStackTrace();
			
		}
		finally
		{
			try
			{
				if(con != null) ConnectionManager.returnConnection(con,request);
			}
			catch(Exception exc)
			{
				exc.printStackTrace();
			}
		}
	}

}
