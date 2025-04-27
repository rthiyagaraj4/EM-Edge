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
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

import eCA.SplChartKey.SplChartKeyHome;

public class SplChartKeyServlet extends HttpServlet 
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
		String splChartType			= "";
		String splChartGroup		= "";
		String valueUnit			= "";
		String xAxis_element		= "";
		String addedById			= "";
		String addedAtWsNo			= "";
		String addedFacilityId		= ""; 
		String modifiedById			= "";
		String modifiedAtWsNo		= "";
		String modifiedFacilityId	= "";

		String locale				= "";
		ArrayList keySet			= null;

		boolean localEjb			= false;
		
		HttpSession session			= null;

        session						= req.getSession(false);

	    Properties p				= null;

		p							= (Properties)session.getValue("jdbc");
		locale						= (String) p.getProperty("LOCALE");
		
		addedById			=	p.getProperty("login_user") != null ? p.getProperty("login_user") : "";
		addedAtWsNo			=	p.getProperty("client_ip_address") != null ? p.getProperty("client_ip_address") : "";
        addedFacilityId     =   (String)session.getValue("facility_id");

		modifiedById		=	addedById;
		modifiedAtWsNo		=	addedAtWsNo;
		modifiedFacilityId	=	addedFacilityId;
		
        try
        {
			splChartType	= req.getParameter("spl_chart_type") != null ? req.getParameter("spl_chart_type") : "";
			splChartGroup	= req.getParameter("spl_chart_group") != null ? req.getParameter("spl_chart_group") : "";
			valueUnit		= req.getParameter("unit") != null ? req.getParameter("unit") : "";
			xAxis_element	= req.getParameter("xAxis_element") == null ? "*K":req.getParameter("xAxis_element") ;

			if(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") != null && getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))
	             localEjb = true;
            
			String strCount = req.getParameter("rec_count") != null ? req.getParameter("rec_count") : "0";
			int recCount =  Integer.parseInt(strCount);
			

			keySet = new ArrayList();
			
			HashMap keyMap = null;

			String startValue	= "";
			String endValue		= "";
			String keyValue		= "";
			
			for(int i=1;i<=recCount;i++)
			{
				startValue = req.getParameter("start_value"+i) != null ? req.getParameter("start_value"+i) : "";
				endValue   = req.getParameter("end_value"+i) != null ? req.getParameter("end_value"+i) : "";
		
				if(startValue==null || startValue.equals("") || endValue==null || endValue.equals("") )
					continue;
			
				keyValue   = endValue;
				keyMap = new HashMap();
				
				keyMap.put("start_value",startValue);
				keyMap.put("end_value",endValue);
				keyMap.put("key_value",keyValue);
				keySet.add(keyMap);
			}

			HashMap tabdata= new HashMap();	
			HashMap hashmap = null;
			
			tabdata.put("added_by_id",addedById);
			tabdata.put("added_facility_id",addedFacilityId);
			tabdata.put("added_at_ws_no",addedAtWsNo);
			tabdata.put("spl_chart_type",splChartType);
			tabdata.put("spl_chart_group",splChartGroup);
			tabdata.put("value_unit",valueUnit);
			tabdata.put("xAxis_element",xAxis_element);
			tabdata.put("key_set",keySet);
			tabdata.put("locale",locale);

			Object obj  = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SplChartKey", SplChartKeyHome.class, localEjb);
		    Object obj1 = obj.getClass().getMethod("create", null).invoke(obj, null);
			Object aobj[] = new Object[2];

			aobj[0] = p;
		    aobj[1] = tabdata;
			
			Class aclass[] = new Class[2];
		    aclass[0] = p.getClass();
	        aclass[1] = tabdata.getClass();
	        
			hashmap = (HashMap) obj1.getClass().getMethod("insertSplChartKey", aclass).invoke(obj1, aobj);
  		    tabdata.clear();

            boolean flag = ((Boolean)hashmap.get("status")).booleanValue();

			String s1	 = (String)hashmap.get("error");
            String s2	 = "0";
            
			if(flag)
                s2 = "1";
			
			hashmap.clear();
            res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + URLEncoder.encode(s1,"UTF-8") + "&err_value=" + s2);
        }
        catch(Exception e)
        {
           // out.println("<h3> Exception raise by SplChartKeyServlet ...So Record Not inserted </h3> Foll: Error Received : " + e.toString());//common-icn-0181
            
			e.printStackTrace();
        }
    }

	private void modify(HttpServletRequest req, HttpServletResponse res, PrintWriter out)
    {
	}

    private void delete(HttpServletRequest req, HttpServletResponse res, PrintWriter out)
    {
    }
}
