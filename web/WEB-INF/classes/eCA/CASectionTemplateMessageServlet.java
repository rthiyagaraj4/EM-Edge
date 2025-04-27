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
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import javax.naming.*;
import javax.rmi.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;
import eCommon.SingleTabHandler.*;

public class CASectionTemplateMessageServlet extends javax.servlet.http.HttpServlet
{
	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	}

	public  void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
req= new XSSRequestWrapper(req); //MOHE-SCF-0153
res.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
res.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		Connection  con = null ;
		PrintWriter out = null;

		try
		{
			out = res.getWriter();
			con	=	ConnectionManager.getConnection(req);
			insert(req, res, out, con);
		}
		catch(Exception e)
		{
			if(con!=null) ConnectionManager.returnConnection(con);
			out.println(e.toString());
			
		}
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		PrintWriter out = null;
	
		try
		{
			out = res.getWriter();
			doPost(req, res);		
		}
		catch(Exception e)	
		{	
			out.println("Exception in invoking doPost Method");
			e.printStackTrace();
		}
	}

	private void insert(HttpServletRequest req, HttpServletResponse res, PrintWriter out, Connection con)
	{	
		PreparedStatement ps = null;
		ResultSet rs = null;
		java.util.Properties p;

		String sql					= "";
		String comp_id				= "";
		String label_id				= "";
		String lable_desc			= "";
		String label_type			= "";
		String discr_msr_id			= "";
//		String eff_status			= "";
		String facilityId			= "";
		String srlnoVal				= "";
		String client_ip_address	= "";
//		String section_id             = "";
		
		int  srlNo = 0;

		HttpSession session;
		session = req.getSession(false);
		
		p					= (java.util.Properties) session.getValue( "jdbc" ) ;
		facilityId			= (String) session.getValue( "facility_id" ) ;
		client_ip_address	=  p.getProperty("client_ip_address");

		try
		{
			
			lable_desc   = req.getParameter("MessageVal");
			label_type   = req.getParameter("label_type");
			if (!label_type.equals("T"))
			{
				comp_id		 = req.getParameter("comp_id");
			}
			else if (label_type.equals("T"))
			{
				comp_id		 = req.getParameter("section_code");

			}
			discr_msr_id = comp_id;
			sql = "SELECT COUNT(*) total FROM CA_TEMPLATE_LABEL WHERE DISCR_MSR_ID= ? AND LABEL_TYPE = ?";
			ps = con.prepareStatement(sql);

			ps.setString(1,comp_id);
			ps.setString(2,label_type);
			
			rs = ps.executeQuery();
		
			while(rs.next())
			{
				srlNo = rs.getInt("total") + 1;
				srlnoVal = String.valueOf(srlNo);
			}

			if(rs != null)rs.close();
			if(ps != null)ps.close();
		
			
			label_id = comp_id.trim()+"_"+label_type.trim()+srlnoVal;

			label_id = label_id.trim();
				

		String addedById			= (String) p.getProperty( "login_user" ) ;
		String modifiedById			= addedById ;
		
		String addedFacilityId			= facilityId;
		String modifiedFacilityId		= addedFacilityId ;
		String addedAtWorkstation		= client_ip_address;
		String modifiedAtWorkstation	= addedAtWorkstation ;
		

		HashMap tabdata=new HashMap();
		tabdata.put("LABEL_ID",label_id);
		tabdata.put("LABEL_DESC",lable_desc);
		tabdata.put("LABEL_TYPE",label_type);
		tabdata.put("DISCR_MSR_ID",discr_msr_id);
		tabdata.put("EFF_STATUS","E");
		tabdata.put("ADDED_BY_ID",addedById);
		tabdata.put("ADDED_DATE",new  java.sql.Timestamp(System.currentTimeMillis()));
		tabdata.put("ADDED_FACILITY_ID", facilityId);
		tabdata.put("ADDED_AT_WS_NO",addedAtWorkstation);
		tabdata.put("MODIFIED_BY_ID",modifiedById);
		tabdata.put("MODIFIED_DATE",new  java.sql.Timestamp(System.currentTimeMillis()));
		tabdata.put("MODIFIED_FACILITY_ID",modifiedFacilityId);
		tabdata.put("MODIFIED_AT_WS_NO",modifiedAtWorkstation );

		String [] dupflds = {"LABEL_ID"};

		boolean local_ejbs = false;
		String tabname="CA_TEMPLATE_LABEL";
		if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
			
			Object argArray[] = new Object[4];
			argArray[0] = p;
			argArray[1] = tabdata;
			argArray[2] = dupflds;
			argArray[3] = tabname;

			Class [] paramArray = new Class[4];
			paramArray[0] = p.getClass();
			paramArray[1] = tabdata.getClass();
			paramArray[2] = dupflds.getClass();
			paramArray[3] = tabname.getClass();

			java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);

			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

			tabdata.clear();
			boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
			
//			String error = (String) results.get("error") ;
			
			String error_value = "0" ;
			
			
			if ( inserted )
			{
			 error_value = "1" ;
			
			out.println("<script src='../eCA/js/SectionTemplate.js' language='javascript'></script>");
			out.println("<script>self.closewPromthnt(\""+label_id+"\",\""+lable_desc+"\")</script>");
			
			}
			
			results.clear();
			//res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error ,"UTF-8") +"&err_value="+error_value);
		}
		catch(Exception e)
		{
			//out.println("Exception in Insert Block :"+e.toString());//common-icn-0181
			
			e.printStackTrace();

		}
		finally 
		{
		if(con!=null) ConnectionManager.returnConnection(con);

		}
	}
}
