/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
 package eMP;

import com.ehis.eslp.ServiceLocator;
import java.io.*;
import java.lang.reflect.Method;
import java.net.URLEncoder;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Properties;
import javax.servlet.*;
import javax.servlet.http.*;
import webbeans.eCommon.*;
import java.sql.*;
import java.util.*;


public class genPatWithNatIdServlet extends HttpServlet implements SingleThreadModel
{
	
    PrintWriter out;
    Properties p;
	String patientId;
	String nationalId;
	String facilityId;
	String newPatientId;
	String loginUser;
	String client_ip_address;
	String locale;

	
	Hashtable message=null;
	Connection con = null;

    public void init(ServletConfig servletconfig)
        throws ServletException
    {
        super.init(servletconfig);
    }

    public synchronized void doPost(HttpServletRequest req, HttpServletResponse res)
        throws ServletException, IOException
    {

		HttpSession session;
        session = req.getSession(false);
        p = (Properties)session.getValue("jdbc");
		facilityId = (String)session.getValue("facility_id");
		loginUser = p.getProperty("login_user");
		locale = p.getProperty("LOCALE");
		client_ip_address = p.getProperty("client_ip_address");
		
        try
        {
			req.setCharacterEncoding("UTF-8");
			res.setContentType("text/html;charset=UTF-8");
            out = res.getWriter();
            insert(req, res);
        }
        catch(Exception e)
        {
            //out.println(e.toString());
			e.printStackTrace(System.err);
        }
    }
	  public void doGet(HttpServletRequest req, HttpServletResponse res)
        throws ServletException, IOException
    {
        try
        {
	        doPost(req, res);
        }
        catch(Exception e)
        {
			e.printStackTrace(System.err);
        }
    }

	private void insert(HttpServletRequest req, HttpServletResponse res) {


		String errormsg="";
		CallableStatement cstmt=null;

		String error	= "";
		boolean flag=false;
        try {
		
			con = ConnectionManager.getConnection(req);
			patientId=req.getParameter("patientId");
			if(patientId ==null) 
				patientId="";

			nationalId=req.getParameter("nationalId");
			if(nationalId ==null) 
				nationalId="";

			if(!patientId.equals("") && !nationalId.equals("")){
				cstmt=con.prepareCall("{call mp_create_patient_and_merge(?,?,?,?,?,?,?)}");
				cstmt.setString(1,patientId);
				cstmt.setString(2,facilityId);
				cstmt.setString(3,nationalId);
				cstmt.setString(4,loginUser);
				cstmt.setString(5,client_ip_address);
				cstmt.registerOutParameter(6,java.sql.Types.VARCHAR);
				cstmt.registerOutParameter(7,java.sql.Types.VARCHAR);
				cstmt.execute();
				errormsg=cstmt.getString(7);
				if(errormsg ==null) 
					errormsg="";
			
				
				if(errormsg.equals("")) {
					flag	= true;
					newPatientId	= cstmt.getString(6);
				
				}
				
				if(flag) {
					java.util.Hashtable message = MessageManager.getMessage(locale, "RECORD_INSERTED", "SM");
					error = ((String) message.get("message"));
					message.clear();
					error	= error+" New Patient ID : "+newPatientId+"";
				}else {
					error	= "Operation failed."+errormsg+"";
				 }
				res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8") + "&err_value=1"  );
			}

	if(cstmt != null) cstmt.close(); //Added for checkstyle
	 } catch(Exception e) {
            //out.println("<h3> Exception raise by Servlet ...So Record Not inserted </h3> Foll: Error Received : " + e.toString());
			e.printStackTrace(System.err);
        } finally {
			try	{
				if(con != null) ConnectionManager.returnConnection(con,req);
		

			}catch(Exception e) {
			}

		}
    }

}
