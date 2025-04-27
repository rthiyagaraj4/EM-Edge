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

public class EmailRepControlSetupServlet extends HttpServlet 
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
		String module_id="";
		String report_id="";
		String subject_text="";
		String disclimer_id="";
		String email_to_pat_id_yn="N";
		String pat_body_text_ref="";
		String very_reqd_pat_yn="N";
		String email_to_regd_id_yn="N";
		String regd_id_body_text_ref="";
		String very_reqd_regd_id_yn="N";
		String email_to_any_id_yn="N";
		String any_id_body_text_ref="";	
		String very_reqd_any_id_yn="N";
		String very_reqd_conf_result_yn="N";		
		String facilityId="";
		String client_ip_address="";
		String addedById="";
		String modifiedById="";
		String addedAtWorkstation="";
		String modifiedAtWorkstation="";
		String recipients_id="";  //Bru-HIMS-CRF-024 [Ramesh]
		String url_text="";  //Bru-HIMS-CRF-024 [Ramesh]
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
			module_id = req.getParameter("module_id") == null ? "": req.getParameter("module_id") ;
			report_id = req.getParameter("report_id") == null ? "": req.getParameter("report_id") ;
			subject_text = req.getParameter("subject_text") == null ? "": req.getParameter("subject_text");
			disclimer_id = req.getParameter("disclimer_id") == null ? "": req.getParameter("disclimer_id") ;			
			email_to_pat_id_yn = req.getParameter("email_to_pat_id_yn")== null ? "N": req.getParameter("email_to_pat_id_yn");
			pat_body_text_ref = req.getParameter("pat_body_text_ref")== null ? "": req.getParameter("pat_body_text_ref");
			very_reqd_pat_yn = req.getParameter("very_reqd_pat_yn") == null ? "N": req.getParameter("very_reqd_pat_yn");
			email_to_regd_id_yn = req.getParameter("email_to_regd_id_yn") == null ? "N": req.getParameter("email_to_regd_id_yn") ;
			regd_id_body_text_ref = req.getParameter("regd_id_body_text_ref") == null ? "": req.getParameter("regd_id_body_text_ref") ;
			very_reqd_regd_id_yn = req.getParameter("very_reqd_regd_id_yn") == null ? "N": req.getParameter("very_reqd_regd_id_yn") ;			
			email_to_any_id_yn = req.getParameter("email_to_any_id_yn")== null ? "N": req.getParameter("email_to_any_id_yn");
			any_id_body_text_ref = req.getParameter("any_id_body_text_ref")== null ? "": req.getParameter("any_id_body_text_ref");
			very_reqd_any_id_yn = req.getParameter("very_reqd_any_id_yn") == null ? "N": req.getParameter("very_reqd_any_id_yn") ;
			very_reqd_conf_result_yn = req.getParameter("very_reqd_conf_result_yn") == null ? "N":req.getParameter("very_reqd_conf_result_yn") ;
			recipients_id= req.getParameter("recipients_id") == null ? "": req.getParameter("recipients_id") ;  //Bru-HIMS-CRF-024 [Ramesh]
			url_text= req.getParameter("url_text") == null ? "": req.getParameter("url_text") ;  //Bru-HIMS-CRF-024 [Ramesh]

			tabdata.put("module_id" ,module_id);
			tabdata.put("report_id",report_id);

			tabdata.put("subject_text",subject_text);
			tabdata.put("disclimer_id",disclimer_id);			
			tabdata.put("email_to_pat_id_yn",email_to_pat_id_yn);
			tabdata.put("pat_body_text_ref",pat_body_text_ref);
			tabdata.put("very_reqd_pat_yn",very_reqd_pat_yn);
			tabdata.put("email_to_regd_id_yn",email_to_regd_id_yn);
			tabdata.put("regd_id_body_text_ref",regd_id_body_text_ref);
			tabdata.put("very_reqd_regd_id_yn",very_reqd_regd_id_yn);
			tabdata.put("email_to_any_id_yn",email_to_any_id_yn);
			tabdata.put("any_id_body_text_ref",any_id_body_text_ref);
			tabdata.put("very_reqd_any_id_yn",very_reqd_any_id_yn);
			tabdata.put("very_reqd_conf_result_yn",very_reqd_conf_result_yn);
			
			tabdata.put("ADDED_BY_ID", addedById);
			tabdata.put("ADDED_DATE", new Timestamp(System.currentTimeMillis()));
			tabdata.put("ADDED_FACILITY_ID", facilityId);
			tabdata.put("ADDED_AT_WS_NO", addedAtWorkstation);
			tabdata.put("MODIFIED_BY_ID", modifiedById);
			tabdata.put("MODIFIED_DATE", new Timestamp(System.currentTimeMillis()));
			tabdata.put("MODIFIED_FACILITY_ID", facilityId);
			tabdata.put("MODIFIED_AT_WS_NO", modifiedAtWorkstation);
			tabdata.put("recipients_id",recipients_id);	 //Bru-HIMS-CRF-024 [Ramesh]
			tabdata.put("url_text",url_text);	 //Bru-HIMS-CRF-024 [Ramesh]         
            String as[] = {"module_id","report_id"};
			
            boolean flag = false;
            String s = "SM_REPORT_MAIL_INFO";
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
           // out.println("<h3> Exception raise by Servlet ...So Record Not inserted </h3> Foll: Error Received : " + e.toString());//common-icn-0181
            
			e.printStackTrace();
        }
    }

    private void modify(HttpServletRequest req, HttpServletResponse res, PrintWriter out)
    {
		Properties p;
		HashMap tabdata= new HashMap();	
	
		String module_id="";
		String report_id="";
		String subject_text="";
		String disclimer_id="";
		String email_to_pat_id_yn="N";
		String pat_body_text_ref="";
		String very_reqd_pat_yn="N";
		String email_to_regd_id_yn="N";
		String regd_id_body_text_ref="";
		String very_reqd_regd_id_yn="N";
		String email_to_any_id_yn="N";
		String any_id_body_text_ref="";
		String very_reqd_any_id_yn="N";
		String very_reqd_conf_result_yn="N";
		String recipients_id="";  //Bru-HIMS-CRF-024 [Ramesh]
		String url_text="";  //Bru-HIMS-CRF-024 [Ramesh]
		String facilityId="";
		String client_ip_address="";
		String addedById="";
		String modifiedById="";
		String addedAtWorkstation="";
		String modifiedAtWorkstation="";
		
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
			module_id = req.getParameter("module_id") == null ? "": req.getParameter("module_id");
			report_id = req.getParameter("report_id")== null ? "": req.getParameter("report_id");
			subject_text = req.getParameter("subject_text") == null ? "": req.getParameter("subject_text");
			disclimer_id = req.getParameter("disclimer_id") == null ? "": req.getParameter("disclimer_id");			
			email_to_pat_id_yn = req.getParameter("email_to_pat_id_yn")== null ? "N": req.getParameter("email_to_pat_id_yn");
			pat_body_text_ref = req.getParameter("pat_body_text_ref")== null ? "": req.getParameter("pat_body_text_ref");
			very_reqd_pat_yn = req.getParameter("very_reqd_pat_yn")== null ? "N": req.getParameter("very_reqd_pat_yn");
			email_to_regd_id_yn = req.getParameter("email_to_regd_id_yn")== null ? "N": req.getParameter("email_to_regd_id_yn");
			regd_id_body_text_ref = req.getParameter("regd_id_body_text_ref")== null ? "": req.getParameter("regd_id_body_text_ref");
			very_reqd_regd_id_yn = req.getParameter("very_reqd_regd_id_yn") == null ? "N": req.getParameter("very_reqd_regd_id_yn");			
			email_to_any_id_yn = req.getParameter("email_to_any_id_yn") == null ? "N": req.getParameter("email_to_any_id_yn") ;
			any_id_body_text_ref = req.getParameter("any_id_body_text_ref") == null ? "": req.getParameter("any_id_body_text_ref") ;
			very_reqd_any_id_yn = req.getParameter("very_reqd_any_id_yn") == null ? "N": req.getParameter("very_reqd_any_id_yn");
			very_reqd_conf_result_yn = req.getParameter("very_reqd_conf_result_yn") == null ? "N":req.getParameter("very_reqd_conf_result_yn") ;
			recipients_id= req.getParameter("recipients_id") == null ? "": req.getParameter("recipients_id") ;  //Bru-HIMS-CRF-024 [Ramesh]
			url_text= req.getParameter("url_text") == null ? "": req.getParameter("url_text") ;  //Bru-HIMS-CRF-024 [Ramesh]

			tabdata.put("subject_text",subject_text);
			tabdata.put("disclimer_id",disclimer_id);			
			tabdata.put("email_to_pat_id_yn",email_to_pat_id_yn);
			tabdata.put("pat_body_text_ref",pat_body_text_ref);
			tabdata.put("very_reqd_pat_yn",very_reqd_pat_yn);
			tabdata.put("email_to_regd_id_yn",email_to_regd_id_yn);
			tabdata.put("regd_id_body_text_ref",regd_id_body_text_ref);
			tabdata.put("very_reqd_regd_id_yn",very_reqd_regd_id_yn);
			tabdata.put("email_to_any_id_yn",email_to_any_id_yn);
			tabdata.put("any_id_body_text_ref",any_id_body_text_ref);
			tabdata.put("very_reqd_any_id_yn",very_reqd_any_id_yn);
			tabdata.put("very_reqd_conf_result_yn",very_reqd_conf_result_yn);

			tabdata.put("ADDED_BY_ID", addedById);
			tabdata.put("ADDED_DATE", new Timestamp(System.currentTimeMillis()));
			tabdata.put("ADDED_FACILITY_ID", facilityId);
			tabdata.put("ADDED_AT_WS_NO", addedAtWorkstation);
			tabdata.put("MODIFIED_BY_ID", modifiedById);
			tabdata.put("MODIFIED_DATE", new Timestamp(System.currentTimeMillis()));
			tabdata.put("MODIFIED_FACILITY_ID", facilityId);
			tabdata.put("MODIFIED_AT_WS_NO", modifiedAtWorkstation);
			tabdata.put("recipients_id",recipients_id);	 //Bru-HIMS-CRF-024 [Ramesh]	
			tabdata.put("url_text",url_text);	 //Bru-HIMS-CRF-024 [Ramesh]   
				
				            
            HashMap hashmap = new HashMap();
            hashmap.put("module_id", module_id);
			hashmap.put("report_id", report_id);			
            boolean flag = false;
            String s = "SM_REPORT_MAIL_INFO";
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
            //out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : " + exception.toString());//common-icn-0181
            exception.printStackTrace();
        }
    }
}
