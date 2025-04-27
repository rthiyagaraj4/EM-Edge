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

public class AmbulanceNatureServlet extends HttpServlet 
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
            System.out.println("Exception 1 from NoteDisclaimerServlet.java : "+e.toString());
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
            System.out.println("Exception in invoking doPost Method of NoteDisclaimerServlet.java : "+e.toString());
			e.printStackTrace(System.err);
        }
    }

    private void insert(HttpServletRequest req, HttpServletResponse res, PrintWriter out)
    {
		Properties p;
		HashMap tabdata;	
		String amb_nature_code;
	//	String old_amb_nature_code;
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
		HttpSession session;
		session = req.getSession(false);
		p = (Properties)session.getValue("jdbc");
		facilityId = (String)session.getValue("facility_id");
		client_ip_address = p.getProperty("client_ip_address");
		modifiedById = p.getProperty("login_user") != null ? p.getProperty("login_user") : "";
		modifiedAtWorkstation = client_ip_address != null ? client_ip_address : "";

		tabdata = new HashMap();
		addedById = p.getProperty("login_user") != null ? p.getProperty("login_user") : "";
        addedAtWorkstation = client_ip_address != null ? client_ip_address : "";
        try
        {
			amb_nature_code = req.getParameter("amb_nature_code") != null ? req.getParameter("amb_nature_code") : "";
			long_desc = req.getParameter("long_desc") != null ? req.getParameter("long_desc") : "";
			short_desc = req.getParameter("short_desc") != null ? req.getParameter("short_desc") : "";
			eff_status = req.getParameter("eff_status") != null ? req.getParameter("eff_status") :"D";
			
			tabdata.put( "AMB_NATURE_CODE" ,amb_nature_code);
			tabdata.put("LONG_DESC",long_desc);
			tabdata.put("SHORT_DESC",short_desc);			
			tabdata.put("ADDED_BY_ID", addedById);
			tabdata.put("ADDED_DATE", new Timestamp(System.currentTimeMillis()));
			tabdata.put("ADDED_FACILITY_ID", facilityId);
			tabdata.put("ADDED_AT_WS_NO", addedAtWorkstation);
			tabdata.put("MODIFIED_BY_ID", modifiedById);
			tabdata.put("MODIFIED_DATE", new Timestamp(System.currentTimeMillis()));
			tabdata.put("MODIFIED_FACILITY_ID", facilityId);
			tabdata.put("MODIFIED_AT_WS_NO", modifiedAtWorkstation);
			tabdata.put("EFF_STATUS",eff_status);
				
			           
            String as[] = {"AMB_NATURE_CODE"};
			
            boolean flag = false;
            String s = "AE_AMB_NATURE";
            if(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") != null && getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))
            flag = true;
            Object obj = ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler", eCommon.SingleTabHandler.SingleTabHandlerManagerHome.class, flag);
            Object obj1 = obj.getClass().getMethod("create", null).invoke(obj, null);
            Object aobj[] = new Object[4];
            aobj[0] = p;
            aobj[1] = tabdata;
            aobj[2] = as;
            aobj[3] = s;
            Class aclass[] = new Class[4];
            aclass[0] = p.getClass();
            aclass[1] = tabdata.getClass();
            aclass[2] = as.getClass();
            aclass[3] = s.getClass();
            HashMap hashmap = (HashMap)obj1.getClass().getMethod("insert", aclass).invoke(obj1, aobj);
            obj1.getClass().getMethod("remove", null).invoke(obj1, null);
			tabdata.clear();
            boolean flag1 = ((Boolean)hashmap.get("status")).booleanValue();
            String s1 = (String)hashmap.get("error");
            String s2 = "0";
            if(flag1)
                s2 = "1";
           // else
               // s1 = (String)hashmap.get("error");
				//s1 = (String)hashmap.get("error");
			hashmap.clear();
           // res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + URLEncoder.encode(s1) + "&err_value=" + s2);
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
		String amb_nature_code = "";
		//String old_amb_nature_code = "";
		String long_desc = "";
		String short_desc = "";
		String eff_status = "";
		String facilityId;
		String client_ip_address;
		String addedById;
		String modifiedById;
		String addedAtWorkstation;
		String modifiedAtWorkstation;
		HttpSession session;
		session = req.getSession(false);
		p = (Properties)session.getValue("jdbc");
		facilityId = (String)session.getValue("facility_id");
		client_ip_address = p.getProperty("client_ip_address");
		modifiedById = p.getProperty("login_user") != null ? p.getProperty("login_user") : "";
		modifiedAtWorkstation = client_ip_address != null ? client_ip_address : "";

		tabdata = new HashMap();
		addedById = p.getProperty("login_user") != null ? p.getProperty("login_user") : "";
        addedAtWorkstation = client_ip_address != null ? client_ip_address : "";
        try
        {
		//	old_amb_nature_code = req.getParameter("old_amb_nature_code") != null ? req.getParameter("old_amb_nature_code") : "";
			amb_nature_code = req.getParameter("amb_nature_code") != null ? req.getParameter("amb_nature_code") : "";
			long_desc = req.getParameter("long_desc") != null ? req.getParameter("long_desc") : "";
			short_desc = req.getParameter("short_desc") != null ? req.getParameter("short_desc") : "";
			eff_status = req.getParameter("eff_status") != null ? req.getParameter("eff_status") :"D";
		
			tabdata.put( "AMB_NATURE_CODE" ,amb_nature_code);
			tabdata.put("LONG_DESC",long_desc);
			tabdata.put("SHORT_DESC",short_desc);		
			tabdata.put("ADDED_BY_ID", addedById);
			tabdata.put("ADDED_DATE", new Timestamp(System.currentTimeMillis()));
			tabdata.put("ADDED_FACILITY_ID", facilityId);
			tabdata.put("ADDED_AT_WS_NO", addedAtWorkstation);
			tabdata.put("MODIFIED_BY_ID", modifiedById);
			tabdata.put("MODIFIED_DATE", new Timestamp(System.currentTimeMillis()));
			tabdata.put("MODIFIED_FACILITY_ID", facilityId);
			tabdata.put("MODIFIED_AT_WS_NO", modifiedAtWorkstation);
			tabdata.put("EFF_STATUS",eff_status);
				
            
            HashMap hashmap = new HashMap();
            hashmap.put("AMB_NATURE_CODE", amb_nature_code);
            boolean flag = false;
            String s = "AE_AMB_NATURE";
            if(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") != null && getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))
                flag = true;
            Object obj = ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler", eCommon.SingleTabHandler.SingleTabHandlerManagerHome.class, flag);
            Object obj1 = obj.getClass().getMethod("create", null).invoke(obj, null);
            Object aobj[] = new Object[4];
            aobj[0] = p;
            aobj[1] = tabdata;
            aobj[2] = hashmap;
            aobj[3] = s;
            Class aclass[] = new Class[4];
            aclass[0] = p.getClass();
            aclass[1] = tabdata.getClass();
            aclass[2] = hashmap.getClass();
            aclass[3] = s.getClass();
            HashMap hashmap1 = (HashMap)obj1.getClass().getMethod("update", aclass).invoke(obj1, aobj);
            obj1.getClass().getMethod("remove", null).invoke(obj1, null);
			tabdata.clear();
			hashmap.clear();
            boolean flag1 = ((Boolean)hashmap1.get("status")).booleanValue();
            String s1 = (String)hashmap1.get("error");
            String s2 = "0";
            if(flag1)
                s2 = "1";
          //  else
              //  s1 = (String)hashmap1.get("error");
         //   s1 = (String)hashmap1.get("error");
			hashmap1.clear();
         //   res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + URLEncoder.encode(s1) + "&err_value=" + s2);
						res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode( s1 ) + "&err_value=" + s2 );
        }
        catch(Exception exception)
        {
           // out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : " + exception.toString());
            System.out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : " + exception.toString());
        }
    }

}
