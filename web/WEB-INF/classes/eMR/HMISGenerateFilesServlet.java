/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eMR;

import java.net.URLEncoder;
import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import webbeans.eCommon.ConnectionManager;
import webbeans.eCommon.MessageManager;
import javax.servlet.http.HttpSession;

public class HMISGenerateFilesServlet extends HttpServlet
{
    
    PrintWriter out;
	String error ="";
	java.util.Properties p;
	String error_val ="";
    HttpSession session;
	Connection con;
	CallableStatement stmt;
	String locale="";

	public void init(ServletConfig servletconfig)throws ServletException
    {
        super.init(servletconfig);
    }

	public synchronized void doPost(HttpServletRequest httpservletrequest, HttpServletResponse httpservletresponse)throws ServletException, IOException
    {
		session = httpservletrequest.getSession(false);
		p			= (java.util.Properties) session.getAttribute( "jdbc" ) ;
		locale = p.getProperty("LOCALE");
     
		try
		{
			httpservletrequest.setCharacterEncoding("UTF-8");
			httpservletresponse.setContentType("text/html;charset=UTF-8");
			out = httpservletresponse.getWriter();
			out.println("<html>");
			out.println("<body>");

			insertHMISMasters(httpservletrequest, httpservletresponse);

		}
		catch(Exception exception)
		{
			out.println(exception.toString());
		}
   	}
 
	private void insertHMISMasters(HttpServletRequest httpservletrequest, HttpServletResponse httpservletresponse)
	{
		

		try
		{
			boolean flag=false; 
			String result = "";
			String hmis_hospital = httpservletrequest.getParameter("hmis_hospital");
			int index = hmis_hospital.indexOf("|");
			int i = 0;
			String facility_id1 = hmis_hospital.substring(i,index);
			i = index + 1;
			index = hmis_hospital.length();
			String hospital_code = hmis_hospital.substring(i,index);


			String hmis_state = httpservletrequest.getParameter("hmis_state");

			String hmis_file_type = httpservletrequest.getParameter("hmis_file_type")==null?"":httpservletrequest.getParameter("hmis_file_type");

			String discharge_date = httpservletrequest.getParameter("discharge_date")==null?"":httpservletrequest.getParameter("discharge_date");

			String census_date = httpservletrequest.getParameter("census_date")==null?"":httpservletrequest.getParameter("census_date");

			String maternitymonth = httpservletrequest.getParameter("maternity_month")==null?"":httpservletrequest.getParameter("maternity_month");

			String maternityyear = httpservletrequest.getParameter("maternityyear")==null?"":httpservletrequest.getParameter("maternityyear");


			try
			{
				con = ConnectionManager.getConnection(httpservletrequest);

				if(hmis_file_type.equalsIgnoreCase("PD103"))
				{
					stmt = con.prepareCall("{call medicom_hmis_int.daily_census(?,?,?,?,?)}");
					stmt.setString( 1,  facility_id1);
					stmt.setString( 2,  hospital_code);
					stmt.setString( 3,  hmis_state);
					stmt.setString( 4,  census_date);
					stmt.registerOutParameter( 5,java.sql.Types.VARCHAR);
					stmt.execute();
					result = stmt.getString(5);
					flag = true;
					stmt.close();
				}
				if(hmis_file_type.equalsIgnoreCase("PD301"))
				{
					stmt = con.prepareCall("{call medicom_hmis_int.daily_discharges(?,?,?,?,?)}");
					stmt.setString( 1,  facility_id1);
					stmt.setString( 2,  hospital_code);
					stmt.setString( 3,  hmis_state);
					stmt.setString( 4,  discharge_date);
					stmt.registerOutParameter( 5,java.sql.Types.VARCHAR);
					stmt.execute();
					result = stmt.getString(5);
					flag = true;
					stmt.close();
				}				

				if(hmis_file_type.equalsIgnoreCase("PD205"))
				{
					stmt = con.prepareCall("{call medicom_hmis_int.monthly_maternity_census(?,?,?,?,?,?)}");
					stmt.setString( 1,  facility_id1);
					stmt.setString( 2,  hospital_code);
					stmt.setString( 3,  hmis_state);
					stmt.setString( 4,  maternitymonth);
					stmt.setString( 5,  maternityyear);
					stmt.registerOutParameter( 6,java.sql.Types.VARCHAR);
					stmt.execute();
					result = stmt.getString(6);
					flag = true;
					stmt.close();
				}
				if((result.equals("1"))&&(flag==true))
				{
					con.commit();
					
					java.util.Hashtable message = MessageManager.getMessage( locale, "RECORD_MODIFIED","SM" ) ;
					String msg = (String) message.get("message");
					error=msg;
					error_val ="1";
					httpservletresponse.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + URLEncoder.encode(error) + "&err_value=" + error_val);
				}
				else
				{
					con.commit();
					error = result ;
					error_val ="1";
					httpservletresponse.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + URLEncoder.encode(error) + "&err_value=" + error_val);
				}
			
			if(stmt != null) stmt.close();
			}catch(Exception ee)
			{
				error = ee.toString() ;
				error_val ="1";
				httpservletresponse.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + URLEncoder.encode(error) + "&err_value=" + error_val);
			}
			finally
			{
					if(con != null) ConnectionManager.returnConnection(con,httpservletrequest);
			}
		}catch(Exception e1){	out.println(e1.toString());	}
	}
}
			


