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

import webbeans.eCommon.ConnectionManager;
import webbeans.eCommon.MessageManager;

import java.io.*;
import java.lang.reflect.Method;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Properties;
import javax.servlet.*;
import javax.servlet.http.*;

public class CAReasonCodeServlet extends HttpServlet 
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
	  //System.out.println(" do Post: 1");
        try
        {	
			req.setCharacterEncoding("UTF-8");
            res.setContentType("text/html;charset=UTF-8");
            out = res.getWriter();

			String mode = req.getParameter("mode") != null ? req.getParameter("mode") : "";
			//System.out.println(" do Post: 1"+mode);
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
    	System.out.println("-----insert");
		Properties prop;
		HashMap tabdata;	
		//System.out.println(" insert:: 1");
		//
		String facilityId;
		String client_ip_address;
		HttpSession session;
		String eff_status;
		String reason_code;
		String reason_desc;
		String description;
		String addedById;
		String modifiedById;
		String addedAtWorkstation;
		String modifiedAtWorkstation;
		
		session = req.getSession(false);
		prop = (java.util.Properties) session.getValue( "jdbc" ) ;
		String locale = (String) prop.getProperty("LOCALE");
		facilityId = (String)session.getValue("facility_id");
		client_ip_address = prop.getProperty("client_ip_address");
		modifiedById = prop.getProperty("login_user") != null ? prop.getProperty("login_user") : "";
		modifiedAtWorkstation = client_ip_address != null ? client_ip_address : "";
	    addedById =prop.getProperty("login_user") != null ? prop.getProperty("login_user") : "";
        addedAtWorkstation = client_ip_address != null ? client_ip_address : "";
        reason_code = req.getParameter("reason_code1") != null ? req.getParameter("reason_code1") : "";
    	reason_desc = req.getParameter("reason_desc1") != null ? req.getParameter("reason_desc1") : "";
    	description = req.getParameter("reason_description1") != null ? req.getParameter("reason_description1") : "";
		eff_status = req.getParameter("eff_status1") != null ? req.getParameter("eff_status1") :"D";
		//SimpleDateFormat formatter = new SimpleDateFormat("dd/mm/yyyy");
		//Date date = new Date(); 
        Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs= null;
        try
        {
        	//System.out.println("Connection");
        	
        	con=ConnectionManager.getConnection(req);
        	//System.out.println("Connected");
        	
        	pstmt = con.prepareStatement("INSERT INTO CA_REASON_CODE(REASON_CODE,REASON_DESC,REASON_TEXT,EFF_STATUS,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID)"
        			+"VALUES(?,?,?,?,?,sysdate,?,?,?,sysdate,?,?)");
    		
        	pstmt.setString(1, reason_code);
			pstmt.setString(2, reason_desc);
			pstmt.setString(3, description);
			pstmt.setString(4, eff_status);
			pstmt.setString(5,addedById);
			//pstmt.setString(6,formatter.format(date))
			//pstmt.setString(7,formatter.format(date));
			pstmt.setString(6, addedAtWorkstation);
			pstmt.setString(7, facilityId);
			pstmt.setString(8, modifiedById);
			pstmt.setString(9, modifiedAtWorkstation);
			pstmt.setString(10, facilityId); 
			int rec = pstmt.executeUpdate();
			//System.out.println(rec+ "Record Inserted ");
			if(pstmt!=null)
				pstmt.close();
			con.commit();			
			String error = getMessage(locale, "RECORD_INSERTED","CA") ;	
			//System.out.println("RECORD_INSERTED");
			res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error ,"UTF-8") +"&err_value=1");
	       }
        catch(Exception e)
        {
            out.println("<h3> Exception raise by Servlet ...So Record Not inserted </h3> Foll: Error Received : " + e.toString());
            try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
        }finally{
			try{
				if(con!=null) ConnectionManager.returnConnection(con,req);		
			}catch(Exception e){}
		}
    }

    private void modify(HttpServletRequest req, HttpServletResponse res, PrintWriter out)
    { 
    	//System.out.println(" modify");
        Properties p;
		HashMap tabdata;	
		String eff_status;
		String reason_code;
		String reason_desc;
		String description;
		String applicable_to_rep_yn = "N";
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
		 //System.out.println(" modify 2");
		tabdata = new HashMap();
		addedById = p.getProperty("login_user") != null ? p.getProperty("login_user") : "";
        addedAtWorkstation = client_ip_address != null ? client_ip_address : "";
        try
        {
        	  reason_code = req.getParameter("reason_code1") != null ? req.getParameter("reason_code1") : "";
          	reason_desc = req.getParameter("reason_desc1") != null ? req.getParameter("reason_desc1") : "";
          	description = req.getParameter("reason_description1") != null ? req.getParameter("reason_description1") : "";
			//disclaimer_text = req.getParameter("disclaimer_text1") != null ? req.getParameter("disclaimer_text1") : "";
			eff_status = req.getParameter("eff_status1") != null ? req.getParameter("eff_status1") :"D";
			//applicable_to_rep_yn = req.getParameter("applicable_to_rep_yn") != null ? req.getParameter("applicable_to_rep_yn") :"N";
			tabdata.put( "REASON_CODE" ,reason_code);
			tabdata.put("REASON_DESC",reason_desc);
			tabdata.put("REASON_TEXT",description);
			tabdata.put("EFF_STATUS",eff_status);
			//tabdata.put("applicable_to_rep_yn",applicable_to_rep_yn);
			tabdata.put("ADDED_BY_ID", addedById);
			tabdata.put("ADDED_DATE", new Timestamp(System.currentTimeMillis()));
			tabdata.put("ADDED_FACILITY_ID", facilityId);
			tabdata.put("ADDED_AT_WS_NO", addedAtWorkstation);
			tabdata.put("MODIFIED_BY_ID", modifiedById);
			tabdata.put("MODIFIED_DATE", new Timestamp(System.currentTimeMillis()));
			tabdata.put("MODIFIED_FACILITY_ID", facilityId);
			tabdata.put("MODIFIED_AT_WS_NO", modifiedAtWorkstation);
            
            HashMap hashmap = new HashMap();
            hashmap.put("REASON_CODE",reason_code);
            boolean flag = false;
            String s = "CA_REASON_CODE";
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
			
			hashmap1.clear();
            res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + URLEncoder.encode(s1,"UTF-8") + "&err_value=" + s2);
        }
        catch(Exception exception)
        {
            out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : " + exception.toString());
            exception.printStackTrace();
        }
    }
	
	 private String getMessage(String locale, String messageId, String moduleId)
		{
	        java.util.Hashtable message = MessageManager.getMessage(locale,messageId,moduleId);
			String mesg = (String) message.get("message");
			message.clear();
	        return(mesg) ;
	    }

}
