/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eXB;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;
import javax.servlet.RequestDispatcher;
import java.util.Properties;
import java.util.Date;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import webbeans.eCommon.ConnectionManager;
import webbeans.eCommon.MessageManager;
import eXH.XHDBAdapter;

/**
 * Class used to update billing parameter setup
 */
public class BillingParamSetupServlet extends HttpServlet
{
	HttpSession session = null;

	/**
	 * Do post method which implements the functionalities for billing parameter setup
	 * @param  HttpServletRequest request
	 * @param  HttpServletResponse response
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	{
		session = request.getSession(false);
		PrintWriter out = response.getWriter();
		Properties properties = (Properties) session.getValue("jdbc");	
		String locale  = properties.getProperty("LOCALE");
		String statusMsg = null;

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		try
		{
			statusMsg = updateParams(request, locale, properties);
		}
		catch(Exception  exp)
		{
			exp.printStackTrace(System.err);
		}
		
		out.println("parent.f_query_add_mod.location.href='../../eXB/jsp/BillingParamSetupAdmin.jsp'");
        RequestDispatcher reqDis = session.getServletContext().getRequestDispatcher("/eXB/jsp/RefreshPage.jsp?action=eXB/jsp/BillingParamSetupAdmin.jsp&statusMsg="+statusMsg);		
		reqDis.forward(request,response);
	}

	/**
	 * updateParams method is used to update billing parameter
	 * @param  HttpServletRequest request
	 * @param  String locale
	 */
	private String updateParams(HttpServletRequest request, String locale, Properties properties)
	{
		Connection connection = null;
		Statement stmt = null;
		ResultSet rs = null;

		String dataChkQry = "SELECT 1 FROM xf_ss_priv_default_values";
		String statusMsg = null;
		boolean isDataExists = false;

		try
		{
			if(connection == null) connection = ConnectionManager.getConnection(properties);
			stmt = connection.createStatement();
			rs = stmt.executeQuery(dataChkQry);

			if(rs.next()) isDataExists = true;

			statusMsg = processParamData(request, locale, isDataExists, properties);

			return statusMsg;
		}
		catch(Exception exp)
		{
			exp.printStackTrace(System.err);		
		}
		finally
		{
			try
			{
				if(stmt != null) stmt.close();
				if(rs != null) rs.close();
				if(connection != null) ConnectionManager.returnConnection(connection);
			}
			catch(Exception fexp)
			{
				fexp.printStackTrace(System.err);
			}
		}
		return statusMsg;
	}

	private synchronized String processParamData(HttpServletRequest request, String locale, boolean isDataExists, Properties properties)
	{
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String qry = null;
		String statusMsg = null;
		MessageManager mm = new MessageManager();
		java.util.Hashtable<String,String> mesg = null;

		try
		{
			if(isDataExists)
			{
				qry = "UPDATE xf_ss_priv_default_values SET def_ss_blng_grp_id = ?,def_ss_cust_group_code = ?,def_ss_cust_code = ?,def_ss_policy_type_code = ?,def_ss_policy_num_ind = ?,def_ss_policy_number = ?,modified_by_id = ?,modified_date = ?,modified_at_ws_no = ?,def_ss_ref_source_code_sub = ?,auth_process_user_id=?";
			}
			else
			{
				qry = "INSERT INTO xf_ss_priv_default_values (def_ss_blng_grp_id, def_ss_cust_group_code, def_ss_cust_code, def_ss_policy_type_code, def_ss_policy_num_ind, def_ss_policy_number, modified_by_id, modified_date, modified_at_ws_no, def_ss_ref_source_code_sub,auth_process_user_id, added_by_id, added_date, added_at_ws_no) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			}

			if(connection == null) connection = ConnectionManager.getConnection(properties);

			pstmt = connection.prepareStatement(qry);
			pstmt.setString(1, XHDBAdapter.checkNull(request.getParameter("blngGrpID")));
			pstmt.setString(2, XHDBAdapter.checkNull(request.getParameter("custGrpCode")));
			pstmt.setString(3, XHDBAdapter.checkNull(request.getParameter("custCode")));
			pstmt.setString(4, XHDBAdapter.checkNull(request.getParameter("polTypeCode")));
			pstmt.setString(5, XHDBAdapter.checkNull(request.getParameter("polNoInd")));
			pstmt.setString(6, XHDBAdapter.checkNull(request.getParameter("policyNo")));
			pstmt.setString(7, (String)session.getValue("login_user"));
			pstmt.setTimestamp(8, new java.sql.Timestamp(new Date().getTime()));
			pstmt.setString(9, properties.getProperty("client_ip_address"));
			pstmt.setString(10, XHDBAdapter.checkNull(request.getParameter("refSourceCodeSub")));
			pstmt.setString(11, XHDBAdapter.checkNull(request.getParameter("userID")));
			
			if(!isDataExists)
			{
				pstmt.setString(12, (String)session.getValue("login_user"));
				pstmt.setTimestamp(13, new java.sql.Timestamp(new Date().getTime()));
				pstmt.setString(14, properties.getProperty("client_ip_address"));
			}			

			int recUpdated = pstmt.executeUpdate();

			if(recUpdated > 0) 
			{
				connection.commit();
				mesg = mm.getMessage(locale, "XH1001", "XH") ;
				statusMsg = ((String) mesg.get("message"));
			}
			else 
			{
				connection.rollback();
				mesg = mm.getMessage(locale, "XH1000", "XH") ;
				statusMsg = ((String) mesg.get("message"));
			}			

			return statusMsg;
		}
		catch(Exception exp)
		{
			exp.printStackTrace(System.err);
			mesg = mm.getMessage(locale, "XH1000", "XH") ;
			statusMsg = ((String) mesg.get("message"));
		}
		finally
		{
			try
			{
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(connection != null) ConnectionManager.returnConnection(connection);	
				mesg.clear();
			}
			catch(Exception fexp)
			{
				fexp.printStackTrace(System.err);
			}
		}
		return statusMsg;
	}
}
