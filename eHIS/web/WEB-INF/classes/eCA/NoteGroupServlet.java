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
import java.util.Hashtable;
import java.util.Properties;
import javax.servlet.*;
import javax.servlet.http.*;
import webbeans.eCommon.MessageManager;

public class NoteGroupServlet extends HttpServlet 
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
        {   req.setCharacterEncoding("UTF-8");
            res.setContentType("text/html; charset=UTF-8");
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
		String note_group_id;
		String note_group_desc;
		String applic_task;
		String applic_task_comb;
		String transcription_yn;
		String cutoff_period;
		String note_encounter;
		String role_base;
		String precondition_recording;
		String report_header;
		String eff_status;
		String facilityId;
		String client_ip_address;
		String addedById;
		String modifiedById;
		String addedAtWorkstation;
		String modifiedAtWorkstation;
		String system_define="U";
		
		HttpSession session;
        
		session		= req.getSession(false);
		
		p					= (Properties)session.getValue("jdbc");
	    facilityId			= (String) session.getValue("facility_id");
	    client_ip_address	= (String) p.getProperty("client_ip_address");
	    modifiedById		= (String) p.getProperty("login_user") != null ? p.getProperty("login_user") : "";
	    addedById			= (String) p.getProperty("login_user") != null ? p.getProperty("login_user") : "";
		
		modifiedAtWorkstation = client_ip_address != null ? client_ip_address : "";
        addedAtWorkstation = client_ip_address != null ? client_ip_address : "";

		try
        {
			note_group_id			= req.getParameter("note_group_id") != null ? req.getParameter("note_group_id") : "";
			note_group_desc			= req.getParameter("note_group_desc") != null ? req.getParameter("note_group_desc") : "";
			applic_task_comb				= req.getParameter("applic_task") != null ? req.getParameter("applic_task") : "";
			note_encounter			= req.getParameter("note_encounter") != null ? req.getParameter("note_encounter") : "";
			role_base				= req.getParameter("role_base") != null ? req.getParameter("role_base") : "N";
			precondition_recording	= req.getParameter("precondition_recording") != null ? req.getParameter("precondition_recording") : "";
			report_header			= req.getParameter("report_header") != null ? req.getParameter("report_header") : "";
			eff_status				= req.getParameter("eff_status") != null ? req.getParameter("eff_status") :"D";
			cutoff_period			= req.getParameter("cutoff_period") != null ? req.getParameter("cutoff_period") : "";
			transcription_yn			= req.getParameter("transcription_yn") != null ? req.getParameter("transcription_yn") : "N";
			String []splitarray = applic_task_comb.split("~");
			applic_task=splitarray[0];
			//transcription_yn=splitarray[1];
		
			
			tabdata.put( "NOTE_GROUP" ,note_group_id);
			tabdata.put("NOTE_GROUP_DESC",note_group_desc);
			tabdata.put("APPL_TASK_ID",applic_task);
			tabdata.put("SYS_USER_DEF_IND",system_define);
			tabdata.put("NEW_NOTE_ALLOWED_YN","Y");
			tabdata.put("NO_OF_REC_PER_ENC",note_encounter);
			tabdata.put("ROLE_BASED_ACCESS_YN",role_base);
			tabdata.put("PRE_COND_FOR_REC",precondition_recording);
			tabdata.put("REPORT_HEADER",report_header);
			tabdata.put("TRANSCRIPTION_YN",transcription_yn);
			tabdata.put("CUT_OFF_DAYS",cutoff_period);
			tabdata.put("EFF_STATUS",eff_status);
			tabdata.put("ADDED_BY_ID", addedById);
			tabdata.put("ADDED_DATE", new Timestamp(System.currentTimeMillis()));
			tabdata.put("ADDED_FACILITY_ID", facilityId);
			tabdata.put("ADDED_AT_WS_NO", addedAtWorkstation);
			tabdata.put("MODIFIED_BY_ID", modifiedById);
			tabdata.put("MODIFIED_DATE", new Timestamp(System.currentTimeMillis()));
			tabdata.put("MODIFIED_FACILITY_ID", facilityId);
			tabdata.put("MODIFIED_AT_WS_NO", modifiedAtWorkstation);
			           
            String as[] = {"NOTE_GROUP"};
			
            boolean flag = false;
            String s = "CA_NOTE_GROUP";

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
            
			String error_Mesg = (String)hashmap.get("error");
            String error_value = "0";
            
			if(flag1)
                error_value = "1";

			hashmap.clear();
            res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + URLEncoder.encode(error_Mesg,"UTF-8") + "&err_value=" + error_value);
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
	
		String note_group_id;
		String old_note_group_id;
		String note_group_desc;
		String applic_task;
		String note_encounter;
		String role_base;
		String precondition_recording;
		String report_header;
		String eff_status;
		String applic_task_comb;
		String transcription_yn;
		String cutoff_period;
		String facilityId;
		String client_ip_address;
		String addedById;
		String modifiedById;
		String addedAtWorkstation;
		String modifiedAtWorkstation;
		String system_user_define1; 

		
		HttpSession session;
        
		session = req.getSession(false);
		
		p					= (Properties)session.getValue("jdbc");
		facilityId			= (String) session.getValue("facility_id");
	    client_ip_address	= (String) p.getProperty("client_ip_address");
	    modifiedById		= (String) p.getProperty("login_user") != null ? p.getProperty("login_user") : "";
	    addedById			= (String) p.getProperty("login_user") != null ? p.getProperty("login_user") : "";
		
		modifiedAtWorkstation = client_ip_address != null ? client_ip_address : "";
        addedAtWorkstation = client_ip_address != null ? client_ip_address : "";

		try
        {
			old_note_group_id			= req.getParameter("old_note_group_id") != null ? req.getParameter("old_note_group_id") : "";
			note_group_id				= req.getParameter("note_group_id1") != null ? req.getParameter("note_group_id1") : "";
			note_group_desc				= req.getParameter("note_group_desc1") != null ? req.getParameter("note_group_desc1") : "";
			applic_task_comb					= req.getParameter("applic_task1") != null ? req.getParameter("applic_task1") : "";
			note_encounter				= req.getParameter("note_encounter1") != null ? req.getParameter("note_encounter1") : "";
			role_base					= req.getParameter("role_base1") != null ? req.getParameter("role_base1") : "N";
			precondition_recording		= req.getParameter("precondition_recording1") != null ? req.getParameter("precondition_recording1") : "";
			report_header				= req.getParameter("report_header1") != null ? req.getParameter("report_header1") : "";
			system_user_define1			= req.getParameter("system_user_define1") != null ? req.getParameter("system_user_define1") : "";
			eff_status					= req.getParameter("eff_status1") != null ? req.getParameter("eff_status1") :"D";
			//applic_task_comb				= req.getParameter("applic_task") != null ? req.getParameter("applic_task") : "";
			cutoff_period			= req.getParameter("cutoff_period") != null ? req.getParameter("cutoff_period") : "";
			transcription_yn			= req.getParameter("transcription_yn") != null ? req.getParameter("transcription_yn") : "N";
			String []splitarray = applic_task_comb.split("~");
			applic_task=splitarray[0];
			//transcription_yn=splitarray[1];
		
			tabdata.put( "NOTE_GROUP" ,note_group_id);
			tabdata.put("NOTE_GROUP_DESC",note_group_desc);
			tabdata.put("APPL_TASK_ID",applic_task);
			tabdata.put("SYS_USER_DEF_IND",system_user_define1);
			tabdata.put("NEW_NOTE_ALLOWED_YN","Y");
			tabdata.put("NO_OF_REC_PER_ENC",note_encounter);
			tabdata.put("ROLE_BASED_ACCESS_YN",role_base);
			tabdata.put("PRE_COND_FOR_REC",precondition_recording);
			tabdata.put("REPORT_HEADER",report_header);
			tabdata.put("EFF_STATUS",eff_status);
			tabdata.put("TRANSCRIPTION_YN",transcription_yn);
			tabdata.put("CUT_OFF_DAYS",cutoff_period);
			tabdata.put("ADDED_BY_ID", addedById);
			tabdata.put("ADDED_DATE", new Timestamp(System.currentTimeMillis()));
			tabdata.put("ADDED_FACILITY_ID", facilityId);
			tabdata.put("ADDED_AT_WS_NO", addedAtWorkstation);
			tabdata.put("MODIFIED_BY_ID", modifiedById);
			tabdata.put("MODIFIED_DATE", new Timestamp(System.currentTimeMillis()));
			tabdata.put("MODIFIED_FACILITY_ID", facilityId);
			tabdata.put("MODIFIED_AT_WS_NO", modifiedAtWorkstation);


            HashMap hashmap = new HashMap();
            hashmap.put("note_group", old_note_group_id);
            boolean flag = false;
            String s = "ca_note_group";

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
            
			String error_Mesg = (String)hashmap1.get("error");
            String error_value = "0";
            
			if(flag1)
                error_value = "1";

			
			hashmap1.clear();
            res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + URLEncoder.encode(error_Mesg,"UTF-8") + "&err_value=" + error_value);
        }
        catch(Exception exception)
        {
           // out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : " + exception.toString());//common-icn-0181
           exception.printStackTrace();
        }
    }

 private void delete(HttpServletRequest req, HttpServletResponse res, PrintWriter out)
    {
		Properties p;
		HashMap tabdata= new HashMap();	
		String note_group_id;
		String note_group_desc;
		String applic_task;
		String note_encounter;
		String role_base;
		String precondition_recording;
		String report_header;
		String eff_status;
		String applic_task_comb;
		String transcription_yn;
		String cutoff_period;
		String facilityId;
		String client_ip_address;
		String addedById;
		String modifiedById;
		String addedAtWorkstation;
		String modifiedAtWorkstation;
		String system_define="U";
		HttpSession session;

        session = req.getSession(false);
		
		p					= (Properties)session.getValue("jdbc");
		String locale		= (String) p.getProperty("LOCALE");
		facilityId			= (String) session.getValue("facility_id");
	    client_ip_address	= (String) p.getProperty("client_ip_address");
	    modifiedById		= (String) p.getProperty("login_user") != null ? p.getProperty("login_user") : "";
		addedById			= (String) p.getProperty("login_user") != null ? p.getProperty("login_user") : "";
	    
		modifiedAtWorkstation = client_ip_address != null ? client_ip_address : "";
        addedAtWorkstation = client_ip_address != null ? client_ip_address : "";

		try
        {
			note_group_id			= req.getParameter("note_group_id1") != null ? req.getParameter("note_group_id1") : "";
			note_group_desc			= req.getParameter("note_group_desc1") != null ? req.getParameter("note_group_desc1") : "";
			applic_task				= req.getParameter("applic_task1") != null ? req.getParameter("applic_task1") : "";
			note_encounter			= req.getParameter("note_encounter1") != null ? req.getParameter("note_encounter1") : "";
			role_base				= req.getParameter("role_base1") != null ? req.getParameter("role_base1") : "N";
			precondition_recording	= req.getParameter("precondition_recording1") != null ? req.getParameter("precondition_recording1") : "";
			report_header			= req.getParameter("report_header1") != null ? req.getParameter("report_header1") : "";
			eff_status				= req.getParameter("eff_status") != null ? req.getParameter("eff_status") :"D";
			applic_task_comb				= req.getParameter("applic_task") != null ? req.getParameter("applic_task") : "";
			cutoff_period			= req.getParameter("cutoff_period") != null ? req.getParameter("cutoff_period") : "";
			transcription_yn			= req.getParameter("transcription_yn") != null ? req.getParameter("transcription_yn") : "N";
			String []splitarray = applic_task_comb.split("~");
			applic_task=splitarray[0];
						
		
		tabdata.put("NOTE_GROUP" ,note_group_id);
		tabdata.put("NOTE_GROUP_DESC",note_group_desc);
		tabdata.put("APPL_TASK_ID",applic_task);
		tabdata.put("SYS_USER_DEF_IND",system_define);
		tabdata.put("NEW_NOTE_ALLOWED_YN","Y");
		tabdata.put("NO_OF_REC_PER_ENC",note_encounter);
		tabdata.put("ROLE_BASED_ACCESS_YN",role_base);
		tabdata.put("PRE_COND_FOR_REC",precondition_recording);
		tabdata.put("REPORT_HEADER",report_header);
		tabdata.put("EFF_STATUS",eff_status);
		tabdata.put("TRANSCRIPTION_YN",transcription_yn);
		tabdata.put("CUT_OFF_DAYS",cutoff_period);
		tabdata.put("ADDED_BY_ID", addedById);
        tabdata.put("ADDED_DATE", new Timestamp(System.currentTimeMillis()));
        tabdata.put("ADDED_FACILITY_ID", facilityId);
        tabdata.put("ADDED_AT_WS_NO", addedAtWorkstation);
		tabdata.put("MODIFIED_BY_ID", modifiedById);
        tabdata.put("MODIFIED_DATE", new Timestamp(System.currentTimeMillis()));
        tabdata.put("MODIFIED_FACILITY_ID", facilityId);
        tabdata.put("MODIFIED_AT_WS_NO", modifiedAtWorkstation);
		

        HashMap hashmap = new HashMap();
		hashmap.put("note_group", note_group_id);
		boolean flag = false;
		String s = "ca_note_group";

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

		String error_Mesg = (String)hashmap1.get("error");
		String error_value = "0";

		if(flag1)
			error_value = "1";

		hashmap1.clear();
		
		if(!flag1)
		{
			Hashtable hashError = new Hashtable();
			hashError	= MessageManager.getMessage(locale, "NOTE_IN_USE","CA");
			error_Mesg	= (String) hashError.get("message");
		}
		
		res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + URLEncoder.encode(error_Mesg,"UTF-8") + "&err_value="+ error_value);
            
       }
	catch(Exception exception)
	{
		//out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : " + exception.toString());//common-icn-0181
		exception.printStackTrace();
	}
 }
}
