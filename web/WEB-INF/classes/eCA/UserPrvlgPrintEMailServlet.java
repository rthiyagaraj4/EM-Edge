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

public class UserPrvlgPrintEMailServlet extends HttpServlet
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
		String error_value = "0";
		int k = 0;

		session = request.getSession(false);
		p = (java.util.Properties)session.getValue("jdbc");
		String locale = (String) p.getProperty("LOCALE");
		addedFacilityId = (String)session.getValue("facility_id") == null ? "" : (String)session.getValue("facility_id");
		respID = (String)session.getValue("responsibility_id") == null ? "" : (String)session.getValue("responsibility_id");
		clientIpAddress = p.getProperty("client_ip_address") == null ? "" : p.getProperty("client_ip_address");
		addedById = (p.getProperty("login_user")==null)?"":p.getProperty("login_user");

		String prvlgId = request.getParameter("privilegeFor") == null ? "" : request.getParameter("privilegeFor");
		String noteTypeId = request.getParameter("patMedicalReport") == null ? "" : request.getParameter("patMedicalReport");

		Connection con = null;
		PreparedStatement ps = null;

		String sql = "insert into CA_PMR_USER_PRIVILAGES (PRIVILAGE_ID, NOTE_TYPE_ID, RESPONSIBILITY_ID, PRACTITIONER_ID, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID) values (?,?,?,?,?,sysdate,?,?,?,sysdate,?,?)";
		String sqlDel = "delete CA_PMR_USER_PRIVILAGES where NOTE_TYPE_ID = ? and PRIVILAGE_ID = ?";

		try
		{
			PatientBannerGroupLine usrPrvlgBean = (PatientBannerGroupLine) com.ehis.persist.PersistenceHelper.getObjectFromBean("usrPrvlgBean","usrPrvlgBean",session);

			ArrayList list = usrPrvlgBean.returnList1();			
			con = ConnectionManager.getConnection(request);
			
			ps = con.prepareStatement(sqlDel);
			ps.setString(1,noteTypeId);
			ps.setString(2,prvlgId);
			ps.executeUpdate();

			if(ps != null) ps.close();

			ps = con.prepareStatement(sql);

			if (list.size() > 0)
			{	
				for(int i =0;i<list.size();i++)
				{
					ps.setString(1,prvlgId);
					ps.setString(2,noteTypeId);
					ps.setString(3,respID);
					ps.setString(4,(String)list.get(i));
					ps.setString(5,addedById);
					ps.setString(6,clientIpAddress);
					ps.setString(7,addedFacilityId);
					ps.setString(8,addedById);
					ps.setString(9,clientIpAddress);
					ps.setString(10,addedFacilityId);

					k = ps.executeUpdate();
				}
			}else{
				k = 1;
			}

			if(k > 0) error_value = "1";

			if(error_value.equals("1"))
			{
				Hashtable tabdata = MessageManager.getMessage(locale,"RECORD_INSERTED","CA");
				String errorMsg= (String) tabdata.get("message");
				tabdata.clear();			response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num="+java.net.URLEncoder.encode(errorMsg,"UTF-8")+"&err_value=1");
				con.commit();
			}
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
			
			//out.println("Exception in try - insert of UserPrvlgPrintEMailServlet.java -"+ee.toString());//common-icn-0181
			ee.printStackTrace();
		}
		finally
		{
			try
			{
				if(ps !=null) ps.close();
			}
			catch (Exception ee)
			{
			}
			
			if(con != null) ConnectionManager.returnConnection(con,request);
		}
	}
}//end of class
