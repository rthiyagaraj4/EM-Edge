/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
 package eMR;

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
import com.ehis.eslp.ServiceLocator;

import eCommon.SingleTabHandler.*;

public class AgentforAllergenServlet extends HttpServlet implements SingleThreadModel
{
	
    PrintWriter out;
    Properties p;
	HashMap tabdata;	
	String adverse_code;
	String short_desc;
	String long_desc;
	/*
	String ADV_EVENT_TYPE_IND1_YN;
	String ADV_EVENT_TYPE_IND2_YN;
	String ADV_EVENT_TYPE_IND3_YN;
	String ADV_EVENT_TYPE_IND4_YN;
	*/
	String facilityId;
	String addedById;
	//String addedBydate;
	String modifiedById;
	String addedAtWorkstation;
	String modifiedAtWorkstation;
	//String user_define;
	String client_ip_address;
	String eff_status;
	String causitive_code;
	String mode;
	String addedDate;
	String adv_sel_val="";
	//Hashtable message=null;
	//Connection conn = null; //Commented for checkstyle
	java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "yyyy-MM-dd" ) ;
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
       client_ip_address = p.getProperty("client_ip_address");
       modifiedById = p.getProperty("login_user") != null ? p.getProperty("login_user") : "";
       modifiedAtWorkstation = client_ip_address != null ? client_ip_address : "";
	   req.setCharacterEncoding("UTF-8");
	   res.setContentType("text/html;charset=UTF-8");
       tabdata = new HashMap();
        try
        {
			req.setCharacterEncoding("UTF-8");
			res.setContentType("text/html;charset=UTF-8");
           // res.setContentType("text/html");
            out = res.getWriter();
            mode = req.getParameter("mode") != null ? req.getParameter("mode") : "";
            if(mode.trim().equalsIgnoreCase("insert"))
                insert(req, res);
			 if(mode.trim().equalsIgnoreCase("modify"))
             modify(req, res);

				
        }
        catch(Exception e)
        {
            out.println(e.toString());
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
            System.out.println("Exception in invoking doPost Method");
			e.printStackTrace(System.err);
        }
    }

	private void insert(HttpServletRequest req, HttpServletResponse res)
    {
		addedById = p.getProperty("login_user") != null ? p.getProperty("login_user") : "";
        addedAtWorkstation = client_ip_address != null ? client_ip_address : "";
		//String locale = p.getProperty("LOCALE");
        try
        {
			//conn = ConnectionManager.getConnection(req); //Commented for checkstyle

			adverse_code=req.getParameter("adv_agnt_code_val");
			if(adverse_code ==null) adverse_code="";
			//System.out.println("adverse_code:"+adverse_code);
			causitive_code =req.getParameter("code_val");
			if(causitive_code ==null) causitive_code="";
			//System.out.println("causitive_code:"+causitive_code);
			short_desc=req.getParameter("Short_desc");
			if(short_desc ==null) short_desc="";
			//System.out.println("short_desc:"+short_desc);
			long_desc=req.getParameter("long_desc");
			if(long_desc ==null) long_desc="";
			//System.out.println("long_desc:"+long_desc);
			adv_sel_val=req.getParameter("sel_rec_type");
			if(adv_sel_val ==null) adv_sel_val="";
			//System.out.println("adv_sel_val:"+adv_sel_val);
			
			eff_status =req.getParameter("eff_status");
			//if(eff_status ==null) eff_status="E";
			if(eff_status ==null || eff_status.equals("")) eff_status="D";
			//System.out.println("eff_status:"+eff_status);

			addedDate				= dateFormat.format( new java.util.Date() ) ;
			java.sql.Date added_date1		= java.sql.Date.valueOf( addedDate ) ;
			java.sql.Date added_date		= new java.sql.Date(added_date1.parse(added_date1.toLocaleString())-(added_date1.getTimezoneOffset()*60*1000) ) ;
			
			tabdata.put( "ALLERGEN_CODE",causitive_code);
			tabdata.put("SHORT_DESC",short_desc);
			tabdata.put("LONG_DESC",long_desc);
			tabdata.put( "ADV_EVENT_TYPE_CODE",adverse_code);
			tabdata.put("ADV_EVENT_TYPE_IND",adv_sel_val);
			tabdata.put("EFF_STATUS",eff_status);
			tabdata.put("ADDED_BY_ID",addedById);
			tabdata.put("ADDED_DATE",added_date);
			tabdata.put("ADDED_AT_WS_NO", addedAtWorkstation);
			tabdata.put("ADDED_FACILITY_ID", facilityId);
			tabdata.put("MODIFIED_BY_ID", modifiedById);
			tabdata.put("MODIFIED_DATE", added_date);
			tabdata.put("MODIFIED_FACILITY_ID", facilityId);
			tabdata.put("MODIFIED_AT_WS_NO", modifiedAtWorkstation);
				
			           
            String as[] = {"ALLERGEN_CODE"};
			
            boolean flag = false;
            String s = "MR_ALLERGEN";
            if(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") != null && getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))
            flag = true;
            Object obj = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler", eCommon.SingleTabHandler.SingleTabHandlerManagerHome.class, flag);
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
            boolean flag1 = ((Boolean)hashmap.get("status")).booleanValue();
            String s1 = (String)hashmap.get("error");
			//String error_value="";
				String s2 = "0";
            if(flag1)
			{
                s2 = "1";
				 res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + URLEncoder.encode(s1,"UTF-8") + "&err_value=" + s2);
			}
            else
			{
                s1 = (String)hashmap.get("error");
				s1 = (String)hashmap.get("error");
		//	message= MessageManager.getMessage( locale,"RECORD_INSERTED","SM" ) ;
			//String error=(String) message.get("message");
			//error_value = "1" ;
            res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + URLEncoder.encode(s1,"UTF-8") + "&err_value=" + s2);
			}
			hashmap.clear();
        }
        catch(Exception e)
        {
            out.println("<h3> Exception raise by Servlet ...So Record Not inserted </h3> Foll: Error Received : " + e.toString());
			e.printStackTrace(System.err);
        }finally
		{
			try
			{
				
				//if(conn !=null) ConnectionManager.returnConnection(conn,req); //Commented for checkstyle	
			}
			catch (Exception e)
			{
			}
		}
    }

	private void modify(HttpServletRequest req, HttpServletResponse res)
    {
		addedById = p.getProperty("login_user") != null ? p.getProperty("login_user") : "";
        addedAtWorkstation = client_ip_address != null ? client_ip_address : "";
		//String locale = p.getProperty("LOCALE");
        try
        {
			//conn = ConnectionManager.getConnection(req); //Commented for checkstyle
			adverse_code=req.getParameter("adv_agnt_code_val");
			if(adverse_code ==null) adverse_code="";
			//System.out.println("adverse_code:"+adverse_code);
			causitive_code =req.getParameter("code_val");
			if(causitive_code ==null) causitive_code="";
			//System.out.println("causitive_code:"+causitive_code);
			short_desc=req.getParameter("Short_desc");
			if(short_desc ==null) short_desc="";
			//System.out.println("short_desc:"+short_desc);
			long_desc=req.getParameter("long_desc");
			if(long_desc ==null) long_desc="";
			//System.out.println("long_desc:"+long_desc);
			adv_sel_val=req.getParameter("sel_rec_type");
			if(adv_sel_val ==null) adv_sel_val="";
			//System.out.println("adv_sel_val:"+adv_sel_val);
			eff_status =req.getParameter("eff_status");
			if(eff_status ==null || eff_status.equals("")) eff_status="D";
			//System.out.println("eff_status:"+eff_status);

			addedDate				= dateFormat.format( new java.util.Date() ) ;
			java.sql.Date added_date1		= java.sql.Date.valueOf( addedDate ) ;
			java.sql.Date added_date		= new java.sql.Date(added_date1.parse(added_date1.toLocaleString())-(added_date1.getTimezoneOffset()*60*1000) ) ;
		
			tabdata.put( "ALLERGEN_CODE",causitive_code);
			tabdata.put("SHORT_DESC",short_desc);
			tabdata.put("LONG_DESC",long_desc);
			tabdata.put( "ADV_EVENT_TYPE_CODE",adverse_code);
			tabdata.put("ADV_EVENT_TYPE_IND",adv_sel_val);
			tabdata.put("EFF_STATUS",eff_status);
			tabdata.put("ADDED_BY_ID",addedById);
			tabdata.put("ADDED_DATE",added_date);
			tabdata.put("ADDED_AT_WS_NO", addedAtWorkstation);
			tabdata.put("ADDED_FACILITY_ID", facilityId);
			tabdata.put("MODIFIED_BY_ID", modifiedById);
			tabdata.put("MODIFIED_DATE", added_date);
			tabdata.put("MODIFIED_FACILITY_ID", facilityId);
			tabdata.put("MODIFIED_AT_WS_NO", modifiedAtWorkstation);

			
			HashMap hashmap = new HashMap();
            hashmap.put("ALLERGEN_CODE", causitive_code);
            boolean flag = false;
            String s = "MR_ALLERGEN";
            if(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") != null && getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))
                flag = true;
            Object obj =com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler", eCommon.SingleTabHandler.SingleTabHandlerManagerHome.class, flag);
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
            boolean flag1 = ((Boolean)hashmap1.get("status")).booleanValue();
            String s1 = (String)hashmap1.get("error");
            String s2 = "0";
			//String error_value="";
            if(flag1)
			{
                s2 = "1";
				//out.println("<script>location.href =\"../eCommon/jsp/error.jsp?err_num=" +java.net.URLEncoder.encode( error,"UTF-8" )+ "&err_value=" + error_value +"\"</script>");
				 res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + URLEncoder.encode(s1,"UTF-8") + "&err_value=" + s2);
			}
            else
			{
            s1 = (String)hashmap1.get("error");
            s1 = (String)hashmap1.get("error");	
			// message= MessageManager.getMessage( locale,"RECORD_EXISTS","SM" ) ;
			//String error=(String) message.get("message");
			//error_value = "1" ;
		   res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + URLEncoder.encode(s1,"UTF-8") + "&err_value=" + s2);
		   out.println("<script>alert(parent.frames(1).name);</script>");
			}

hashmap.clear();
hashmap1.clear();
        }
        catch(Exception e)
        {
            out.println("<h3> Exception raise by Servlet ...So Record Not inserted </h3> Foll: Error Received : " + e.toString());
			e.printStackTrace(System.err);
        }finally
		{
			try
			{
				
				//if(conn !=null) ConnectionManager.returnConnection(conn,req);	//Commented for checkstyle
			}
			catch (Exception e)
			{
			}
		}
    }
}
