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
import eCA.SplChartRef.SplChartRefHome;

public class SplChartRefServlet extends HttpServlet 
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
            String mode = req.getParameter("mode") != null ? req.getParameter("mode") : "insert";
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
		String splChartType 	= null;
		String splChartGroup    = null;
		String elementType 		= null;
		String xAxis_element	= null;
		String gender 			= null;
		
		String addedById		= null;
		String addedAtWsNo		= null;
		String addedFacilityId	= null; 
		String modifiedById		= null;
		String modifiedAtWsNo	= null;
		String modifiedFacilityId = null;
		String header1			= "";
		String header2			= "";
		String header3			= "";
		String header4			= "";
		String header5			= "";
		String header6			= "";
		String header7			= "";
		String header8			= "";
		String header9			= "";
		String header10			= "";
		String header11			= "";
		String header12			= "";
				
		ArrayList keySet = null;
		
		boolean localEjb = false;
	
		HttpSession session = null;
        session = req.getSession(false);
	    Properties p;
		p = (Properties)session.getValue("jdbc");
		String locale			= (String) p.getProperty("LOCALE");
		
		addedById			=	p.getProperty("login_user") != null ? p.getProperty("login_user") : "";
		addedAtWsNo			=	p.getProperty("client_ip_address") != null ? p.getProperty("client_ip_address") : "";
        addedFacilityId     =   (String)session.getValue("facility_id");
		modifiedById		=	addedById;
		modifiedAtWsNo		=	addedAtWsNo;
		modifiedFacilityId	=	addedFacilityId;
		
        try
        {	
			header1 = req.getParameter("header1") != null ? req.getParameter("header1") : "";
			header2 = req.getParameter("header2") != null ? req.getParameter("header2") : "";
			header3	 = req.getParameter("header3") != null ? req.getParameter("header3") : "";
			header4	= req.getParameter("header4") != null ? req.getParameter("header4") : "";
			header5	= req.getParameter("header5") != null ? req.getParameter("header5") : "";
			header6	= req.getParameter("header6") != null ? req.getParameter("header6") : "";
			header7	= req.getParameter("header7") != null ? req.getParameter("header7") : "";
			header8 = req.getParameter("header8") != null ? req.getParameter("header8") : "";
			header9	= req.getParameter("header9") != null ? req.getParameter("header9") : "";
			header10 = req.getParameter("header10") != null ? req.getParameter("header10") : "";
			header11= req.getParameter("header11") != null ? req.getParameter("header11") : "";
			header12= req.getParameter("header12") != null ? req.getParameter("header12") : "";
			header1="P".concat(header1);
			header2="P".concat(header2);
			header3="P".concat(header3);
			header4="P".concat(header4);
			header5="P".concat(header5);
			header6="P".concat(header6);
			header7="P".concat(header7);
			header8="P".concat(header8);
			header9="P".concat(header9);
			header10="P".concat(header10);
			header11="P".concat(header11);
			header12="P".concat(header12);
			

			splChartType = req.getParameter("spl_chart_type") != null ? req.getParameter("spl_chart_type") : "";
			splChartGroup = req.getParameter("spl_chart_group") != null ? req.getParameter("spl_chart_group") : "";
			elementType	 = req.getParameter("element_type") != null ? req.getParameter("element_type") : "";
			gender		 = req.getParameter("gender") != null ? req.getParameter("gender") : "";
			xAxis_element  = req.getParameter("xAxis_element") == null ? "*K" :req.getParameter("xAxis_element");
			if(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") != null && getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))
             localEjb = true;
            
			String strCount = req.getParameter("rec_count") != null ? req.getParameter("rec_count") : "0";
			int recCount =  Integer.parseInt(strCount);
			
			keySet = new ArrayList();
			HashMap keyMap = null;
			LinkedHashMap prefMap = new LinkedHashMap();			

				prefMap.put("PREF1",header1);
				prefMap.put("PREF2",header2);
				prefMap.put("PREF3",header3);
				prefMap.put("PREF4",header4);
				prefMap.put("PREF5",header5);
				prefMap.put("PREF6",header6);
				prefMap.put("PREF7",header7);
				prefMap.put("PREF8",header8);
				prefMap.put("PREF9",header9);
				prefMap.put("PREF10",header10);
				prefMap.put("PREF11",header11);
				prefMap.put("PREF12",header12);

			String keyValue = null;
			String medianValue = null;
			String variationValue = null;
			String transValue = null;			

			for(int i=1;i<=recCount;i++)
			{
				keyValue    = req.getParameter("key_value"+i) != null ? req.getParameter("key_value"+i) : "";
				if(keyValue==null || keyValue.equals(""))
					continue;
				medianValue = req.getParameter("median_value"+i) != null ? req.getParameter("median_value"+i) : "";
				variationValue = req.getParameter("variation_value"+i) != null ? req.getParameter("variation_value"+i) : "";
				transValue = req.getParameter("trans_value"+i) != null ? req.getParameter("trans_value"+i) : "";
			   String PREF1 = req.getParameter("p1_value"+i) != null ? req.getParameter("p1_value"+i) : "";
			   String PREF2 = req.getParameter("p2_value"+i) != null ? req.getParameter("p2_value"+i) : "";
			   String PREF3 = req.getParameter("p3_value"+i) != null ? req.getParameter("p3_value"+i) : "";
			   String PREF4 = req.getParameter("p4_value"+i) != null ? req.getParameter("p4_value"+i) : "";
			   String PREF5 = req.getParameter("p5_value"+i) != null ? req.getParameter("p5_value"+i) : "";
			   String PREF6 = req.getParameter("p6_value"+i) != null ? req.getParameter("p6_value"+i) : "";
			   String PREF7 = req.getParameter("p7_value"+i) != null ? req.getParameter("p7_value"+i) : "";
			   String PREF8 = req.getParameter("p8_value"+i) != null ? req.getParameter("p8_value"+i) : "";
			   String PREF9 = req.getParameter("p9_value"+i) != null ? req.getParameter("p9_value"+i) : "";
			   String PREF10 = req.getParameter("p10_value"+i) != null ? req.getParameter("p10_value"+i) : "";
			   String PREF11 = req.getParameter("p11_value"+i) != null ? req.getParameter("p11_value"+i) : "";
			   String PREF12 = req.getParameter("p12_value"+i) != null ? req.getParameter("p12_value"+i) : "";	   
			

				keyMap = new HashMap();

				keyMap.put("key_value",keyValue);
				keyMap.put("median_value",medianValue);
				keyMap.put("variation_value",variationValue);
				keyMap.put("trans_value",transValue);

				keyMap.put("p1_value",PREF1);
				keyMap.put("p2_value",PREF2);
				keyMap.put("p3_value",PREF3);
				keyMap.put("p4_value",PREF4);
				keyMap.put("p5_value",PREF5);
				keyMap.put("p6_value",PREF6);
				keyMap.put("p7_value",PREF7);
				keyMap.put("p8_value",PREF8);
				keyMap.put("p9_value",PREF9);
				keyMap.put("p10_value",PREF10);
				keyMap.put("p11_value",PREF11);
				keyMap.put("p12_value",PREF12);

				keySet.add(keyMap);
			}

			
			HashMap tabdata= new HashMap();	
			HashMap hashmap = null;

			tabdata.put("added_by_id",addedById);
			tabdata.put("added_facility_id",addedFacilityId);
			tabdata.put("added_at_ws_no",addedAtWsNo);
			tabdata.put("spl_chart_type",splChartType);
			tabdata.put("spl_chart_group",splChartGroup);
			tabdata.put("element_type",elementType);
			tabdata.put("xAxis_element",xAxis_element);
			tabdata.put("gender",gender);			

			tabdata.put("prefMap",prefMap);

			tabdata.put("key_set",keySet);
			tabdata.put("locale",locale);


	        Object obj  = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SplChartRef", SplChartRefHome.class, localEjb);
		    Object obj1 = obj.getClass().getMethod("create", null).invoke(obj, null);

			Object aobj[] = new Object[2];
			aobj[0] = p;
		    aobj[1] = tabdata;
        
			Class aclass[] = new Class[2];
		    aclass[0] = p.getClass();
	        aclass[1] = tabdata.getClass();

	        hashmap = (HashMap) obj1.getClass().getMethod("insertSplChartRef", aclass).invoke(obj1, aobj);
  		    tabdata.clear();
				
		    boolean flag = ((Boolean)hashmap.get("status")).booleanValue();

			String s1	 = (String)hashmap.get("error");
            String s2	 = "0";
            if(flag)
                s2 = "1";
            else
                s1 = (String)hashmap.get("error");
			hashmap.clear();
            res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + URLEncoder.encode(s1,"UTF-8") + "&err_value=" + s2);
        }
        catch(Exception e)
        {
            out.println("<h3> Exception raise by SplChartRefServlet ...So Record Not inserted </h3> Foll: Error Received : " + e.toString());
            
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
