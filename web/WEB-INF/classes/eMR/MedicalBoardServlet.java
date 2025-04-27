/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
@Funciton name: Medical Board CodeSetup
@Parameter: From AddModifyMedicalBoard.jsp
Insert/Modify into mr_medical_board Table
*/
package eMR;

import java.io.IOException;
import java.sql.Timestamp;
import java.io.PrintWriter;
import java.net.URLEncoder;
//import java.text.SimpleDateFormat;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import eCommon.SingleTabHandler.*;

import eCommon.XSSRequestWrapper;

public class MedicalBoardServlet extends HttpServlet
{
    PrintWriter out;
    Properties p;
    String MedBoardcode;
    String medical_board_type_code;
    String longDesc;
    String shortDesc;
    String effectiveStatus;
    String facilityId;
    String client_ip_address;
     HttpSession session;
	 public void init(ServletConfig servletconfig)
        throws ServletException
    {
        super.init(servletconfig);
    }

    public synchronized void doPost(HttpServletRequest httpservletrequest, HttpServletResponse httpservletresponse)
        throws ServletException, IOException
    {
        session = httpservletrequest.getSession(false);
        facilityId = (String)session.getValue("facility_id");
        p = (Properties)session.getValue("jdbc");
        client_ip_address = p.getProperty("client_ip_address");
        try
        {
            httpservletrequest.setCharacterEncoding("UTF-8");
			httpservletresponse.setContentType("text/html;charset=UTF-8");
			
			httpservletrequest= new XSSRequestWrapper(httpservletrequest);
			httpservletresponse.addHeader("X-XSS-Protection", "1; mode=block");
			httpservletresponse.addHeader("X-Content-Type-Options", "nosniff");
			
            out = httpservletresponse.getWriter();
            String s = httpservletrequest.getParameter("function");
            if(s.equals("insert"))
                insertMedBoard(httpservletrequest, httpservletresponse);
            if(s.equals("modify"))
                modifyMedBoard(httpservletrequest, httpservletresponse);
        }
        catch(Exception exception)
        {
            //out.println(exception.toString());
			
			exception.printStackTrace();
        }
    }

    public void doGet(HttpServletRequest httpservletrequest, HttpServletResponse httpservletresponse)
        throws ServletException, IOException
    {
        try
        {
            out = httpservletresponse.getWriter();
			String s = httpservletrequest.getParameter("function");
            if(s.equals("insert"))
                insertMedBoard(httpservletrequest, httpservletresponse);
            if(s.equals("modify"))
                modifyMedBoard(httpservletrequest, httpservletresponse);
        }
        catch(Exception exception) { /* System.out.println(exception.getMessage()); */ exception.printStackTrace();}
    }

    private void modifyMedBoard(HttpServletRequest httpservletrequest, HttpServletResponse httpservletresponse)
    {
        try
        {
            MedBoardcode = httpservletrequest.getParameter("medical_board_code");
            longDesc = httpservletrequest.getParameter("long_desc");
            medical_board_type_code = httpservletrequest.getParameter("medical_board_type_code");
            shortDesc = httpservletrequest.getParameter("short_desc");
            effectiveStatus = httpservletrequest.getParameter("eff_status");
            if(effectiveStatus == null)
                effectiveStatus = "D";
            String added_by_id = p.getProperty("login_user");
            String modified_by_id = added_by_id;
            String facility_id = facilityId;
            String modified_facility_id = facility_id;
            String added_at_ws_no = client_ip_address;
            String modified_at_ws_no = added_at_ws_no;
			//Timestamp added_date = new Timestamp(System.currentTimeMillis() );
			Timestamp modified_date = new Timestamp(System.currentTimeMillis() );
            HashMap hashmap = new HashMap();
			hashmap.put("MED_BOARD_TYPE_CODE", medical_board_type_code);
            hashmap.put("long_desc", longDesc);
            hashmap.put("short_desc", shortDesc);
            hashmap.put("eff_status", effectiveStatus);
            hashmap.put("added_by_id", added_by_id);
            hashmap.put("modified_by_id", modified_by_id);
            hashmap.put("modified_date", modified_date);
            hashmap.put("modified_facility_id", modified_facility_id);
            hashmap.put("modified_at_ws_no", modified_at_ws_no);
			HashMap condflds=new HashMap();
			condflds.put("medical_board_code",MedBoardcode);
			
			String tableName = "mr_medical_board";

            boolean local_ejbs = false;

            if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[] = new Object[4];
			argArray[0] = p;
			argArray[1] = hashmap;
			argArray[2] = condflds;
			argArray[3] = tableName;

			Class [] paramArray = new Class[4];
			paramArray[0] = p.getClass();
			paramArray[1] = hashmap.getClass();
			paramArray[2] = condflds.getClass();
			paramArray[3] = tableName.getClass();

			HashMap results = (HashMap)(busObj.getClass().getMethod("update",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
            boolean flag = ((Boolean)results.get("status")).booleanValue();
            String error = (String)results.get("error");
            String error_value = "0";
            if(flag)
                error_value = "1";
            else
                error = (String)results.get("error");
            httpservletresponse.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + URLEncoder.encode(error, "UTF-8") + "&err_value=" + error_value);

			if ( hashmap != null) hashmap.clear();
			if ( results != null) results.clear();
			if ( condflds != null) condflds.clear();
        }
        catch(Exception exception)
        {
           /*  out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : " + exception.toString());
            out.println("Values sent are : <br>");
            out.println(MedBoardcode + " " + longDesc + " " + shortDesc + " " + effectiveStatus); */
			
			exception.printStackTrace();
        }
    }

    private void insertMedBoard(HttpServletRequest httpservletrequest, HttpServletResponse httpservletresponse)
    {
        try
        {
            MedBoardcode = httpservletrequest.getParameter("medical_board_code");
            longDesc = httpservletrequest.getParameter("long_desc");
            medical_board_type_code = httpservletrequest.getParameter("medical_board_type_code");
		    shortDesc = httpservletrequest.getParameter("short_desc");
            effectiveStatus = httpservletrequest.getParameter("eff_status");
			if(effectiveStatus == null)
                effectiveStatus = "D";
            String added_by_id = p.getProperty("login_user");
            String modified_by_id = added_by_id;
            String facility_id = facilityId;
            String modified_facility_id = facility_id;
            String added_at_ws_no = client_ip_address;
            String modified_at_ws_no = added_at_ws_no;
			Timestamp added_date = new Timestamp(System.currentTimeMillis() );
			Timestamp modified_date = new Timestamp(System.currentTimeMillis() );
            HashMap hashmap = new HashMap();
            hashmap.put("MEDICAL_BOARD_CODE", MedBoardcode);
            hashmap.put("MED_BOARD_TYPE_CODE", medical_board_type_code);
			hashmap.put("LONG_DESC", longDesc);
            hashmap.put("SHORT_DESC", shortDesc);
            hashmap.put("EFF_STATUS", effectiveStatus);
            hashmap.put("ADDED_BY_ID",added_by_id);
            hashmap.put("ADDED_DATE", added_date);
            hashmap.put("ADDED_FACILITY_ID", facilityId);
            hashmap.put("ADDED_AT_WS_NO", added_at_ws_no);
            hashmap.put("MODIFIED_BY_ID", modified_by_id);
            hashmap.put("MODIFIED_DATE", modified_date);
            hashmap.put("MODIFIED_FACILITY_ID", modified_facility_id);
            hashmap.put("MODIFIED_AT_WS_NO", modified_at_ws_no);
            String dupflds[]={"MEDICAL_BOARD_CODE"};
			String tableName = "MR_MEDICAL_BOARD";

			boolean local_ejbs = false;
			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[] = new Object[4];
			argArray[0] = p;
			argArray[1] = hashmap;
			argArray[2] = dupflds;
			argArray[3] = tableName;

			Class [] paramArray = new Class[4];
			paramArray[0] = p.getClass();
			paramArray[1] = hashmap.getClass();
			paramArray[2] = dupflds.getClass();
			paramArray[3] = tableName.getClass();
			HashMap results = (HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
          
			boolean flag = ((Boolean)results.get("status")).booleanValue();
            String error = (String)results.get("error");
			String error_value = "0";
            if(flag)
                error_value = "1";
            else
                error = (String)results.get("error");
            error = (String)results.get("error");
            httpservletresponse.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + URLEncoder.encode(error,"UTF-8") + "&err_value=" + error_value);
			if ( hashmap != null) hashmap.clear();
			if ( results != null) results.clear();
		}
        catch(Exception exception)
        {
           /*  out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : " + exception.toString());
            out.println("Values sent are : <br>");
            out.println(MedBoardcode + " " + longDesc + " " + shortDesc + " " + effectiveStatus + " "+medical_board_type_code); */
			
			exception.printStackTrace();
        }
    }

    
}
