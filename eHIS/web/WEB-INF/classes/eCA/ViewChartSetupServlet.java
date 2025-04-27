/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eCA; 

import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.naming.*;
import javax.rmi.*;
import java.net.*;
import java.util.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import webbeans.eCommon.*;

public class ViewChartSetupServlet extends HttpServlet
{
	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	}
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws javax.servlet.ServletException,IOException
	{
		PrintWriter out = null;
	
		try{
			out = response.getWriter();
			doPost(request,response);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException,IOException
	{
		
		response.setContentType("text/html; charset=UTF-8");
	
		PrintWriter out = null;
		
		try{
			out = response.getWriter();
			String mode = request.getParameter("mode")==null?"":request.getParameter("mode");			
			mode = "insert";		
			if(mode.equals("insert")) insert(request,response, out);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public void insert(HttpServletRequest request, HttpServletResponse response, PrintWriter out)
	{
		java.util.Properties p;
		HttpSession session;

		Connection con = null;
		PreparedStatement ps = null;	
		PreparedStatement ps1 = null;
		Statement stm = null;
		ResultSet rs = null;

		String chart_id = "";
		int noOfRows = 0;
		//String discr_msr_id = "";//Checkstyle
		String facility_id = "";
		String login_id = "";
		String client_ip_address = "";
		String locale= "";
		int rowsCount = 0;
		int index = 0;
		//DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");//Checkstyle
		//java.util.Date dt=new java.util.Date();//Checkstyle
		try{
			session = request.getSession(false);
			p = (java.util.Properties) session.getValue("jdbc");
			
			locale = (String) p.getProperty("LOCALE");

			facility_id		= ((String) session.getValue("facility_id"))==null?"":((String) session.getValue("facility_id"));
			client_ip_address		= p.getProperty("client_ip_address");
			login_id			= (p.getProperty("login_user")==null)?"":p.getProperty("login_user");
			
			chart_id=(String)request.getParameter("viewChart");
			noOfRows = Integer.parseInt((String)request.getParameter("noOfRows"));
			con = ConnectionManager.getConnection(request);
			
			stm = con.createStatement();
			stm.execute("delete from CA_VIEW_CHART_CONFIG WHERE CHART_ID='"+chart_id+"'");	
			if(stm!=null)stm.close();
			for(int i=0;i<noOfRows;i++){
				
				String seqOrder		= (String)request.getParameter("r"+i+"OrderSeq");
				String DisMsrId		= (String)request.getParameter("r"+i+"DisMsrId");
				String DisFormat	= (String)request.getParameter("r"+i+"format");
				if("G".equals(((String)request.getParameter("r"+i+"format")))||"T".equals(((String)request.getParameter("r"+i+"format")))){
					index++;
					String DisOrder		= (String)request.getParameter("r"+i+"DisOrder");
				String xScal		= "";
				String yScal		= "";
				String yMin			= "";
				String yMax			= "";
				if("G".equals(((String)request.getParameter("r"+i+"format")))){
					xScal	= (String)request.getParameter("r"+i+"t6XS");
					yScal	= (String)request.getParameter("r"+i+"t7YS");
					yMin		= (String)request.getParameter("r"+i+"t8minY");
						yMax		= (String)request.getParameter("r"+i+"t9maxY");
				}
					
					ps1 = con.prepareStatement("INSERT INTO CA_VIEW_CHART_CONFIG VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
					
					ps1.setString(1,chart_id);
					ps1.setString(2,DisMsrId);
					ps1.setString(3,seqOrder);
					ps1.setString(4,DisOrder);
					ps1.setString(5,DisFormat);
					ps1.setString(6,xScal);
					ps1.setString(7,yScal);
					ps1.setString(8,yMin);
					ps1.setString(9,yMax);
					ps1.setString(10,"A");
					ps1.setString(11,login_id);
					ps1.setTimestamp(12,new java.sql.Timestamp(System.currentTimeMillis()));
					ps1.setString(13,client_ip_address);
					ps1.setString(14,facility_id);
					ps1.setString(15,login_id);
					ps1.setTimestamp(16,new java.sql.Timestamp(System.currentTimeMillis()));
					ps1.setString(17,client_ip_address);
					ps1.setString(18,facility_id);
					//System.out.println("--------------------------->Before Insert.");
					rowsCount = rowsCount+ps1.executeUpdate();
					//System.out.println("---------------------------->After Insert.");
					if(ps1 != null)ps1.close();	
			}
			}
			
			if(index!=0 && rowsCount!=0 && index==rowsCount){
				con.commit();
				Hashtable tabdata = MessageManager.getMessage(locale,"RECORD_INSERTED","CA");
				String errorMsg= (String) tabdata.get("message");
				tabdata.clear();
				response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num="+java.net.URLEncoder.encode(errorMsg,"UTF-8")+"&err_value=1");
			}else{
				try{
					con.rollback();
				}
				catch(Exception ee){
					ee.printStackTrace();
				}
				response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=Error&err_value=0");
			}
		}catch(Exception e){
			try{
				con.rollback();
			}
			catch(Exception ee){
				ee.printStackTrace();
			}
			e.printStackTrace();
		}finally{
			try{
				rs.close();
				ps1.close();
				ps.close();
				con.close();
			}
			catch(Exception ee){
				ee.printStackTrace();
			}
		}
		
	}
}
