/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
 package eCA;

import java.sql.*;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import webbeans.eCommon.*;

public class UserPrvlgToVeryEmailServlet extends HttpServlet
{
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException
	{
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		PrintWriter out = null;

		try
		{
			out = response.getWriter();
			insert(request,response,out);
		}
		catch (Exception e)
		{
			
			e.printStackTrace();
		}
	}

	private void insert(HttpServletRequest request, HttpServletResponse response,PrintWriter out)
	{
		Properties p;
		HttpSession session;

		String addedById = "";
		String addedFacilityId = "";
		String clientIpAddress = "";
		String respID = "";
		int [] insertCounts			= null;
		boolean insert_flag=true;

		session = request.getSession(false);
		p = (java.util.Properties)session.getValue("jdbc");
		String locale = (String) p.getProperty("LOCALE");
		addedFacilityId = (String)session.getValue("facility_id") == null ? "" : (String)session.getValue("facility_id");
		respID = (String)session.getValue("responsibility_id") == null ? "" : (String)session.getValue("responsibility_id");
		clientIpAddress = p.getProperty("client_ip_address") == null ? "" : p.getProperty("client_ip_address");
		addedById = (p.getProperty("login_user")==null)?"":p.getProperty("login_user");

		String module_id = request.getParameter("module_id") == null ? "" : request.getParameter("module_id");
		String report_id = request.getParameter("report_id") == null ? "" : request.getParameter("report_id");
		Connection con = null;
		PreparedStatement ps = null;

		String sql = "insert into SM_MAIL_AUTH_USER (module_id, report_id, user_id, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID) values (?,?,?,?,sysdate,?,?,?,sysdate,?,?)";
		String sqlDel = "delete SM_MAIL_AUTH_USER where module_id = ? and report_id = ?";

		try
		{
			UserPrvlgToVeryEmailBean UserPrvlgToVeryEmailBean = (UserPrvlgToVeryEmailBean) com.ehis.persist.PersistenceHelper.getObjectFromBean("UserPrvlgToVeryEmailBean","UserPrvlgToVeryEmailBean",session);
			ArrayList list = UserPrvlgToVeryEmailBean.getUserList();
			
			con = ConnectionManager.getConnection(request);
			
			ps = con.prepareStatement(sqlDel);
			ps.setString(1,module_id);
			ps.setString(2,report_id);
			ps.executeUpdate();
			
			if(ps != null) ps.close();

			ps = con.prepareStatement(sql);
			
			if(list.size()>0){
				for(int i =0;i<list.size();i++)
				{
					ps.setString(1,module_id);
					ps.setString(2,report_id);
					ps.setString(3,(String)list.get(i));
					ps.setString(4,addedById);
					ps.setString(5,clientIpAddress);
					ps.setString(6,addedFacilityId);
					ps.setString(7,addedById);
					ps.setString(8,clientIpAddress);
					ps.setString(9,addedFacilityId);
					ps.addBatch();
				}
				insertCounts = ps.executeBatch();
				
				if(ps != null) ps.close();

				for (int k=0;k<insertCounts.length ;k++ )
				{
					if(insertCounts[k]<0  && insertCounts[k] != -2 )
					{
						insert_flag=false;
						break;
					}
					else
						insert_flag=true;
				}
			}
			if(insert_flag)
			{
				Hashtable tabdata = MessageManager.getMessage(locale,"RECORD_INSERTED","CA");
				String errorMsg= (String) tabdata.get("message");
				tabdata.clear();			response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num="+java.net.URLEncoder.encode(errorMsg,"UTF-8")+"&err_value=1");
				con.commit();
			}else{
				con.rollback();
				Hashtable tabdata = MessageManager.getMessage(locale, "FAILED_TRANSACTION","CA");
				String msg= (String) tabdata.get("message");
				response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" +java.net.URLEncoder.encode(msg,"UTF-8") + "&err_value=0");
			}
			/*}else{
				Hashtable tabdata = MessageManager.getMessage(locale, "USER_NOT_BLANK","CA");
				String msg= (String) tabdata.get("message");
				response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" +java.net.URLEncoder.encode(msg,"UTF-8") + "&err_value=0");
			}*/
		}
		catch(Exception ee)
		{
			try
			{
				con.rollback();	
			}
			catch (Exception rb)
			{
			}
			
			out.println("Exception in try - insert of UserPrvlgPrintEMailServlet.java -"+ee.toString());
			ee.printStackTrace();
		}
		finally
		{
			if(con != null) ConnectionManager.returnConnection(con,request);
		}
	}
}//end of class
