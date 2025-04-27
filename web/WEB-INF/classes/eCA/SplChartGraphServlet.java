/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eCA;

import com.ehis.eslp.ServiceLocator;
import java.io.*;
import java.lang.reflect.Method;
import java.net.URLEncoder;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Properties;
import javax.servlet.*;
import javax.servlet.http.*;

public class SplChartGraphServlet extends HttpServlet 
{
    public void init(ServletConfig servletconfig)
        throws ServletException
    {
        super.init(servletconfig);
    }

    public  void doPost(HttpServletRequest req, HttpServletResponse res)
        throws ServletException, IOException
    {
		PrintWriter out = null;
		try
        {
            req.setCharacterEncoding("UTF-8");
			res.setContentType("text/html;charset=UTF-8");	
            out = res.getWriter();
            String mode = req.getParameter("mode") != null ? req.getParameter("mode") : "";
            if(mode.trim().equalsIgnoreCase("insert"))
                insert(req, res, out);
            if(mode.trim().equalsIgnoreCase("update"))
                modify(req, res, out);
            if(mode.trim().equalsIgnoreCase("delete"))
                delete(req, res, out);
        }
        catch(Exception e)
        {
            out.println(e.toString());
            
			e.printStackTrace();
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
            
			e.printStackTrace();
        }
    }

    private void insert(HttpServletRequest req, HttpServletResponse res, PrintWriter out)
    {
		Properties p;
		HashMap tabdata= new HashMap();	

		String spl_chart_type;
		String spl_chart_group;
		String graph_code;
		String graph_desc;
		String x_axis;
		String y_axis;
		String eff_status;
		
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
		addedById = p.getProperty("login_user") != null ? p.getProperty("login_user") : "";
        addedAtWorkstation = client_ip_address != null ? client_ip_address : "";
	
		try
        {
			spl_chart_type = req.getParameter("spl_chart_type") != null ? req.getParameter("spl_chart_type") : "";
			spl_chart_group = req.getParameter("spl_chart_group") != null ? req.getParameter("spl_chart_group") : "";

			graph_code = req.getParameter("graph_code") != null ? req.getParameter("graph_code") : "";
			graph_desc = req.getParameter("graph_desc") != null ? req.getParameter("graph_desc") : "";
			
			x_axis = req.getParameter("x_axis") != null ? req.getParameter("x_axis") : "";
			y_axis = req.getParameter("y_axis") != null ? req.getParameter("y_axis") : "";
			eff_status = req.getParameter("eff_status") != null ? req.getParameter("eff_status") :"D";
			
			tabdata.put("SPL_CHART_TYPE" ,spl_chart_type);
			tabdata.put("SPL_CHART_TYPE_GRP_ID",spl_chart_group);
			tabdata.put("GRAPH_CODE",graph_code);
			tabdata.put("GRAPH_DESC",graph_desc);
			
			tabdata.put("X_AXIS_ELEMENT_TYPE",x_axis);
			tabdata.put("Y_AXIS_ELEMENT_TYPE",y_axis);
			tabdata.put("EFF_STATUS",eff_status);
			
			tabdata.put("ADDED_BY_ID", addedById);
			tabdata.put("ADDED_DATE", new Timestamp(System.currentTimeMillis()));
			tabdata.put("ADDED_FACILITY_ID", facilityId);
			tabdata.put("ADDED_AT_WS_NO", addedAtWorkstation);
			tabdata.put("MODIFIED_BY_ID", modifiedById);
			tabdata.put("MODIFIED_DATE", new Timestamp(System.currentTimeMillis()));
			tabdata.put("MODIFIED_FACILITY_ID", facilityId);
			tabdata.put("MODIFIED_AT_WS_NO", modifiedAtWorkstation);
				
			           
            String as[] = {"SPL_CHART_TYPE","SPL_CHART_TYPE_GRP_ID","GRAPH_CODE"};
			
            boolean flag = false;
            String s = "CA_SPL_CHART_GRAPH";
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
            else
                s1 = (String)hashmap.get("error");
				s1 = (String)hashmap.get("error");
			hashmap.clear();
            res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + URLEncoder.encode(s1,"UTF-8") + "&err_value=" + s2);
        }
        catch(Exception e)
        {
            out.println("<h3> Exception raise by Servlet ...So Record Not inserted </h3> Foll: Error Received : " + e.toString());
            
			e.printStackTrace();
        }
    }

    private void modify(HttpServletRequest req, HttpServletResponse res, PrintWriter out)
    {
		Properties p;
		HashMap tabdata= new HashMap();	
	
		String spl_chart_type;
		String spl_chart_group;
		String graph_code;
		String graph_desc;
		String x_axis;
		String y_axis;
		String eff_status;
	
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
   		addedById = p.getProperty("login_user") != null ? p.getProperty("login_user") : "";
        addedAtWorkstation = client_ip_address != null ? client_ip_address : "";
   
		try
        {
			spl_chart_type = req.getParameter("spl_chart_type1") != null ? req.getParameter("spl_chart_type1") : "";
			spl_chart_group = req.getParameter("spl_chart_group1") != null ? req.getParameter("spl_chart_group1") : "";

			graph_code = req.getParameter("graph_code1") != null ? req.getParameter("graph_code1") : "";
			graph_desc = req.getParameter("graph_desc1") != null ? req.getParameter("graph_desc1") : "";
			
			x_axis = req.getParameter("x_axis1") != null ? req.getParameter("x_axis1") : "";
			y_axis = req.getParameter("y_axis1") != null ? req.getParameter("y_axis1") : "";
			eff_status = req.getParameter("eff_status1") != null ? req.getParameter("eff_status1") :"D";
		
			tabdata.put("SPL_CHART_TYPE" ,spl_chart_type);
			tabdata.put("SPL_CHART_TYPE_GRP_ID",spl_chart_group);
			tabdata.put("GRAPH_CODE",graph_code);
			tabdata.put("GRAPH_DESC",graph_desc);
			tabdata.put("X_AXIS_ELEMENT_TYPE",x_axis);
			tabdata.put("Y_AXIS_ELEMENT_TYPE",y_axis);
			tabdata.put("EFF_STATUS",eff_status);


			tabdata.put("ADDED_BY_ID", addedById);
			tabdata.put("ADDED_DATE", new Timestamp(System.currentTimeMillis()));
			tabdata.put("ADDED_FACILITY_ID", facilityId);
			tabdata.put("ADDED_AT_WS_NO", addedAtWorkstation);
			tabdata.put("MODIFIED_BY_ID", modifiedById);
			tabdata.put("MODIFIED_DATE", new Timestamp(System.currentTimeMillis()));
			tabdata.put("MODIFIED_FACILITY_ID", facilityId);
			tabdata.put("MODIFIED_AT_WS_NO", modifiedAtWorkstation);
				
				            
            HashMap hashmap = new HashMap();
            hashmap.put("SPL_CHART_TYPE", spl_chart_type);
			hashmap.put("SPL_CHART_TYPE_GRP_ID", spl_chart_group);
			hashmap.put("GRAPH_CODE",graph_code);
            boolean flag = false;
            String s = "CA_SPL_CHART_GRAPH";
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
			hashmap.clear();
			tabdata.clear();
            boolean flag1 = ((Boolean)hashmap1.get("status")).booleanValue();
            String s1 = (String)hashmap1.get("error");
            String s2 = "0";
            if(flag1)
                s2 = "1";
            else
                s1 = (String)hashmap1.get("error");
            s1 = (String)hashmap1.get("error");
			hashmap1.clear();
            res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + URLEncoder.encode(s1,"UTF-8") + "&err_value=" + s2);
        }
        catch(Exception exception)
        {
          //  out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : " + exception.toString());//common-icn-0181
            exception.printStackTrace();
        }
    }

    private void delete(HttpServletRequest req, HttpServletResponse res, PrintWriter out)
    {
		Properties p;
		HashMap tabdata= new HashMap();	

	    String spl_chart_type;
		String spl_chart_group;
		String graph_code;
		String graph_desc;
		String x_axis;
		String y_axis;
		String eff_status;
		
		String facilityId;
		String client_ip_address;
		String addedById;
		String modifiedById;
		String addedAtWorkstation;
		String modifiedAtWorkstation;
		String locale = "";
		
		
		HttpSession session;
        session = req.getSession(false);
		p = (Properties)session.getValue("jdbc");
		locale			= (String) p.getProperty("LOCALE");
		facilityId = (String)session.getValue("facility_id");
	    client_ip_address = p.getProperty("client_ip_address");
	    modifiedById = p.getProperty("login_user") != null ? p.getProperty("login_user") : "";
	    modifiedAtWorkstation = client_ip_address != null ? client_ip_address : "";
		addedById = p.getProperty("login_user") != null ? p.getProperty("login_user") : "";
        addedAtWorkstation = client_ip_address != null ? client_ip_address : "";
        
		try
        {
			spl_chart_type = req.getParameter("spl_chart_type") != null ? req.getParameter("spl_chart_type") : "";
			spl_chart_group = req.getParameter("spl_chart_group") != null ? req.getParameter("spl_chart_group") : "";
			graph_code = req.getParameter("graph_code") != null ? req.getParameter("graph_code") : "";
			graph_desc = req.getParameter("graph_desc") != null ? req.getParameter("graph_desc") : "";
			
			x_axis = req.getParameter("x_axis") != null ? req.getParameter("x_axis") : "";
			y_axis = req.getParameter("y_axis") != null ? req.getParameter("y_axis") : "";
			eff_status = req.getParameter("eff_status") != null ? req.getParameter("eff_status") :"D";
		
			tabdata.put("SPL_CHART_TYPE" ,spl_chart_type);
			tabdata.put("SPL_CHART_TYPE_GRP_ID",spl_chart_group);

			tabdata.put("GRAPH_CODE",graph_code);
			tabdata.put("GRAPH_DESC",graph_desc);
			tabdata.put("X_AXIS_ELEMENT_TYPE",x_axis);
			tabdata.put("Y_AXIS_ELEMENT_TYPE",y_axis);
			tabdata.put("EFF_STATUS",eff_status);
				
			tabdata.put("ADDED_BY_ID", addedById);
			tabdata.put("ADDED_DATE", new Timestamp(System.currentTimeMillis()));
			tabdata.put("ADDED_FACILITY_ID", facilityId);
			tabdata.put("ADDED_AT_WS_NO", addedAtWorkstation);
			tabdata.put("MODIFIED_BY_ID", modifiedById);
			tabdata.put("MODIFIED_DATE", new Timestamp(System.currentTimeMillis()));
			tabdata.put("MODIFIED_FACILITY_ID", facilityId);
			tabdata.put("MODIFIED_AT_WS_NO", modifiedAtWorkstation);
		    
            HashMap hashmap = new HashMap();
            hashmap.put("SPL_CHART_TYPE", spl_chart_type);
			hashmap.put("SPL_CHART_TYPE_GRP_ID", spl_chart_group);
			hashmap.put("GRAPH_CODE",graph_code);
            boolean flag = false;
            String s = "CA_SPL_CHART_GRAPH";
            if(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") != null && getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))
                flag = true;
            Object obj = ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler", eCommon.SingleTabHandler.SingleTabHandlerManagerHome.class, flag);
            Object obj1 = obj.getClass().getMethod("create", null).invoke(obj, null);
            Object aobj[] = new Object[3];
            aobj[0] = p;
            aobj[1] = hashmap;
            aobj[2] = s;
            Class aclass[] = new Class[3];
            aclass[0] = p.getClass();
            aclass[1] = hashmap.getClass();
            aclass[2] = s.getClass();
            HashMap hashmap1 = (HashMap)obj1.getClass().getMethod("delete", aclass).invoke(obj1, aobj);
            obj1.getClass().getMethod("remove", null).invoke(obj1, null);
			hashmap.clear();
            boolean flag1 = ((Boolean)hashmap1.get("status")).booleanValue();
            String s1 = (String)hashmap1.get("error");
            String s3 = "0";
            if(flag1)
                s3 = "1";
            else
                s1 = (String)hashmap1.get("error");
            s1 = (String)hashmap1.get("error");
			hashmap1.clear();
            if(flag1)
            {
				
                res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + URLEncoder.encode(s1,"UTF-8") + "&err_value=" + s3);
            } 
			else
            {
                String s2 = "APP-CA0056 This SplChartGraph in use, cannot be deleted...";
                res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + URLEncoder.encode(s2,"UTF-8") + "&err_value=1");
            }
        }
        catch(Exception exception)
        {
            //out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : " + exception.toString());common-icn-0181
            exception.printStackTrace();
        }
    }
}
