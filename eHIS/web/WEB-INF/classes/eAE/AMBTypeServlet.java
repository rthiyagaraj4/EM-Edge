/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
 package eAE;

import com.ehis.eslp.ServiceLocator;
import java.io.*;
import java.lang.reflect.Method;
import java.net.URLEncoder;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Properties;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.naming.*;
import javax.rmi.*;
import java.util.*;
import webbeans.eCommon.*;
import java.sql.*;


public class AMBTypeServlet extends HttpServlet 
{
    public void init(ServletConfig servletconfig)
        throws ServletException
    {
        super.init(servletconfig);
    }

    public void doPost(HttpServletRequest req, HttpServletResponse res)
        throws ServletException, IOException
    {
			PrintWriter out = null;
	
        try
        {
            res.setContentType("text/html");
            out = res.getWriter();
            String mode = req.getParameter("mode") != null ? req.getParameter("mode") : "";
	        if(mode.trim().equalsIgnoreCase("insert"))
                insert(req, res, out);
            if(mode.trim().equalsIgnoreCase("update"))
                modify(req, res, out);
           
        }
        catch(Exception e)
        {
            out.println(e.toString());
            System.out.println("Exception 1 from AMBTypeServlet.java : "+e.toString());
			e.printStackTrace(System.err);
        }
    }

    public void doGet(HttpServletRequest req, HttpServletResponse res)
        throws ServletException, IOException
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
            System.out.println("Exception in invoking doPost Method of AMBTypeServlet.java : "+e.toString());
			e.printStackTrace(System.err);
        }
    }

    private void insert(HttpServletRequest req, HttpServletResponse res, PrintWriter out)
    {
		Properties p;
		HashMap tabdata;	
		String amb_service_type;
		String long_desc;
		String short_desc;
		String eff_status;
		/*String mode;*/
		String facilityId;
		String client_ip_address;
		String addedById;
		String modifiedById;
		String addedAtWorkstation;
		String modifiedAtWorkstation;
		String locale;
		HttpSession session;
		session = req.getSession(false);
		p = (Properties)session.getValue("jdbc");
		facilityId = (String)session.getValue("facility_id");
		client_ip_address = p.getProperty("client_ip_address");
		locale = p.getProperty("LOCALE");
		modifiedById = p.getProperty("login_user") != null ? p.getProperty("login_user") : "";
		modifiedAtWorkstation = client_ip_address != null ? client_ip_address : "";
		Connection con=null;
		PreparedStatement pstmt=null;
		
		
		tabdata = new HashMap();
		addedById = p.getProperty("login_user") != null ? p.getProperty("login_user") : "";
        addedAtWorkstation = client_ip_address != null ? client_ip_address : "";
		String s1="";
        String s2 = "0";	
        try
        {
			amb_service_type = req.getParameter("amb_service_type") != null ? req.getParameter("amb_service_type") : "";
			long_desc = req.getParameter("long_desc") != null ? req.getParameter("long_desc") : "";
			short_desc = req.getParameter("short_desc") != null ? req.getParameter("short_desc") : "";
			eff_status = req.getParameter("eff_status") != null ? req.getParameter("eff_status") :"D";
			try{
				con=ConnectionManager.getConnection(req);
				pstmt = con.prepareStatement("INSERT INTO AE_AMB_SERVICE_TYPE (AMB_SERVICE_TYPE,LONG_DESC,SHORT_DESC,NO_RESOURCE,NO_EQIUPMENT,EFF_STATUS,ADDED_BY_ID,ADDED_DATE,ADDED_FACILITY_ID,ADDED_AT_WS_NO,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_FACILITY_ID,MODIFIED_AT_WS_NO) VALUES (?,?,?,NULL,NULL,?,?,SYSDATE,?,?,?,SYSDATE,?,?)");
				pstmt.setString(1,amb_service_type);
				pstmt.setString(2,long_desc);
				pstmt.setString(3,short_desc);
				pstmt.setString(4,eff_status);
				pstmt.setString(5,addedById);
				pstmt.setString(6,facilityId);
				pstmt.setString(7,addedAtWorkstation);				
				pstmt.setString(8,modifiedById);
				pstmt.setString(9,facilityId);
				pstmt.setString(10,modifiedAtWorkstation);
				int count = pstmt.executeUpdate();
				
				if(count>0){
					s2 = "1";
					//s1="APP-SM0001 Operation Completed Successfully ....";
					java.util.Hashtable message1 = MessageManager.getMessage(locale, "RECORD_INSERTED", "SM");
					s1 = ((String) message1.get("message"));
					message1.clear();
					con.commit();
				}else{
					s1="Insert failed";
					con.rollback();
				}
			}catch(Exception e){
				//System.out.println("@@ Exception in AMBTypeServlet.java="+e);				
				if(e.toString().contains("AE_AMB_SERVICE_TYPE_PK")){
				     Hashtable message = MessageManager.getMessage(locale, "CODE_ALREADY_EXISTS","Common");


					 String error_msg = (String)message.get("message");					
					 res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode( error_msg,"UTF-8"));
					 message.clear();
			    } else	{	 
				  e.printStackTrace();
			   }	
			}finally{	
				tabdata.clear();
				if(pstmt!=null) pstmt.close();
				if(con!=null) ConnectionManager.returnConnection(con,req);
			}
			res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode( s1 ) + "&err_value=" + s2 );
        }
        catch(Exception e)
        {
            //out.println("<h3> Exception raise by Servlet ...So Record Not inserted </h3> Foll: Error Received : " + e.toString());
            System.out.println("<h3> Exception raise by Servlet ...So Record Not inserted </h3> Foll: Error Received : " + e.toString());
			e.printStackTrace(System.err);
        }
    }

	 private void modify(HttpServletRequest req, HttpServletResponse res, PrintWriter out)
    {
         Properties p;
		HashMap tabdata;	
		String amb_service_type = "";

		String long_desc = "";
		String short_desc = "";
		String eff_status = "";
		String facilityId;
		String client_ip_address;
		String addedById;
		String modifiedById;
		String addedAtWorkstation;
		String modifiedAtWorkstation;
		String locale;
		HttpSession session;
		session = req.getSession(false);
		p = (Properties)session.getValue("jdbc");
		facilityId = (String)session.getValue("facility_id");
		locale = p.getProperty("LOCALE");
		client_ip_address = p.getProperty("client_ip_address");
		modifiedById = p.getProperty("login_user") != null ? p.getProperty("login_user") : "";
		modifiedAtWorkstation = client_ip_address != null ? client_ip_address : "";

		tabdata = new HashMap();
		addedById = p.getProperty("login_user") != null ? p.getProperty("login_user") : "";
        addedAtWorkstation = client_ip_address != null ? client_ip_address : "";
		
		Connection con=null;
		PreparedStatement pstmt=null;
		String s1="";
        String s2 = "0";	
        try
        {

			amb_service_type = req.getParameter("amb_service_type") != null ? req.getParameter("amb_service_type") : "";
			long_desc = req.getParameter("long_desc") != null ? req.getParameter("long_desc") : "";
			short_desc = req.getParameter("short_desc") != null ? req.getParameter("short_desc") : "";
			eff_status = req.getParameter("eff_status") != null ? req.getParameter("eff_status") :"D";
			try{
				con=ConnectionManager.getConnection(req);
				pstmt = con.prepareStatement("UPDATE  AE_AMB_SERVICE_TYPE SET LONG_DESC=?,SHORT_DESC=?,EFF_STATUS=?,MODIFIED_BY_ID=?,MODIFIED_DATE=SYSDATE,MODIFIED_FACILITY_ID=?,MODIFIED_AT_WS_NO=? where AMB_SERVICE_TYPE=?");
				
				pstmt.setString(1,long_desc);
				pstmt.setString(2,short_desc);
				pstmt.setString(3,eff_status);
				pstmt.setString(4,modifiedById);
				pstmt.setString(5,facilityId);
				pstmt.setString(6,modifiedAtWorkstation);
				pstmt.setString(7,amb_service_type);
				int count = pstmt.executeUpdate();
				
				if(count>0){
					s2 = "1";
					//s1="APP-SM0001 Operation Completed Successfully ....";
					java.util.Hashtable message = MessageManager.getMessage(locale, "RECORD_MODIFIED", "SM");
					s1 = ((String) message.get("message"));
					message.clear();
					con.commit();
				}else{
					s1="Update failed";
					con.rollback();
				}
			}catch(Exception e){
				System.out.println("@@ Exception in AMBTypeServlet.java="+e);
				e.printStackTrace();
			}finally{	
				tabdata.clear();
				if(pstmt!=null) pstmt.close();
				if(con!=null) ConnectionManager.returnConnection(con,req);
			}
						res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode( s1 ) + "&err_value=" + s2 );
        }
        catch(Exception exception)
        {
           // out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : " + exception.toString());
            System.out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : " + exception.toString());
        }
    }

}
