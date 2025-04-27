/*Created by Ashwini on 22-Jan-2018 for ML-MMOH-CRF-0779*/
package eIP;

import java.sql.*;
import java.io.*;
import java.net.URLEncoder;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import javax.naming.*;
import javax.rmi.*;
import webbeans.eCommon.*;
import eCommon.SingleTabHandler.*;

public class AdmissionFormServlet extends HttpServlet
{

    PrintWriter out;
    Properties p;
    String admission_form_code;
    String longDesc;
    String shortDesc;
	String specialty;
	String byDefault;
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
            out = httpservletresponse.getWriter();
            String s = httpservletrequest.getParameter("function1");
            if(s.equals("insert"))
                insertAdmissionForm(httpservletrequest, httpservletresponse);
            if(s.equals("modify"))
                modifyAdmissionForm(httpservletrequest, httpservletresponse);
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
			httpservletrequest.setCharacterEncoding("UTF-8");
            httpservletresponse.setContentType("text/html;charset=UTF-8");
			String s = httpservletrequest.getParameter("function1");
            if(s.equals("insert"))
                insertAdmissionForm(httpservletrequest, httpservletresponse);
            if(s.equals("modify"))
                modifyAdmissionForm(httpservletrequest, httpservletresponse);
        }
        catch(Exception exception) { /* System.out.println(exception.getMessage()); */ exception.printStackTrace();}
    }

    private void modifyAdmissionForm(HttpServletRequest httpservletrequest, HttpServletResponse httpservletresponse)
    {
        try
        {
            admission_form_code = httpservletrequest.getParameter("admission_form_code");
            longDesc = httpservletrequest.getParameter("long_desc");
            shortDesc = httpservletrequest.getParameter("short_desc");
			specialty = httpservletrequest.getParameter("speciality_code");
			byDefault = httpservletrequest.getParameter("by_default");
			if(byDefault == null)
                byDefault = "N";
            effectiveStatus = httpservletrequest.getParameter("eff_status");
            if(effectiveStatus == null)
                effectiveStatus = "D";
            String added_by_id = p.getProperty("login_user");
            String modified_by_id = added_by_id;
            String addedFacilityId = facilityId;
            String modified_facility_id = addedFacilityId;
            String added_at_ws_no = client_ip_address;
            String modified_at_ws_no = added_at_ws_no;
			Timestamp modified_date = new Timestamp(System.currentTimeMillis() );
            HashMap hashmap = new HashMap();
            hashmap.put("long_desc", longDesc);
            hashmap.put("short_desc", shortDesc);
			hashmap.put("specialty_code", specialty);
            hashmap.put("by_default", byDefault);
            hashmap.put("eff_status", effectiveStatus);
            hashmap.put("added_by_id", added_by_id);
            hashmap.put("modified_by_id", modified_by_id);
            hashmap.put("modified_date", modified_date);
            hashmap.put("modified_facility_id", modified_facility_id);
            hashmap.put("modified_at_ws_no", modified_at_ws_no);
            hashmap.put("admission_form_code", admission_form_code);
			HashMap condflds=new HashMap();
			condflds.put("admission_form_code",admission_form_code);
			String tableName = "IP_ADMISSION_FORM";
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
            httpservletresponse.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + URLEncoder.encode(error,"UTF-8") + "&err_value=" + error_value);
			if ( hashmap != null) hashmap.clear();
			if ( results != null) results.clear();
			if ( condflds != null) condflds.clear();
        }
        catch(Exception exception)
        {
            /* out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : " + exception.toString());
            out.println("Values sent are : <br>");
            out.println(admission_form_code + " " + longDesc + " " + shortDesc + " " + specialty + " " + byDefault + " " + effectiveStatus); */
			exception.printStackTrace();
        }
    }

    private void insertAdmissionForm(HttpServletRequest httpservletrequest, HttpServletResponse httpservletresponse)
    {
        try
        {
            admission_form_code = httpservletrequest.getParameter("admission_form_code");
            longDesc = httpservletrequest.getParameter("long_desc");
            shortDesc = httpservletrequest.getParameter("short_desc");
			specialty = httpservletrequest.getParameter("speciality_code");
			byDefault = httpservletrequest.getParameter("by_default");
			if(byDefault == null)
                byDefault = "N";
            effectiveStatus = httpservletrequest.getParameter("eff_status");
            if(effectiveStatus == null)
                effectiveStatus = "D";
            String added_by_id = p.getProperty("login_user");
            String modified_by_id = added_by_id;
            String addedFacilityId = facilityId;
            String modified_facility_id = addedFacilityId;
            String added_at_ws_no = client_ip_address;
            String modified_at_ws_no = added_at_ws_no;
			Timestamp added_date = new Timestamp(System.currentTimeMillis() );
			Timestamp modified_date = new Timestamp(System.currentTimeMillis() );
            HashMap tabdata = new HashMap();
            tabdata.put("admission_form_code", admission_form_code);
            tabdata.put("long_desc", longDesc);
            tabdata.put("short_desc", shortDesc);
			tabdata.put("specialty_code", specialty);
            tabdata.put("by_default", byDefault);
            tabdata.put("eff_status", effectiveStatus);
            tabdata.put("added_by_id", added_by_id);
            tabdata.put("added_date", added_date);
            tabdata.put("added_facility_id", facilityId);
            tabdata.put("added_at_ws_no", added_at_ws_no);
            tabdata.put("modified_by_id", modified_by_id);
            tabdata.put("modified_date", modified_date);
            tabdata.put("modified_facility_id", modified_facility_id);
            tabdata.put("modified_at_ws_no", modified_at_ws_no);
            
			String dupflds[]={"admission_form_code"};
			String tableName = "IP_ADMISSION_FORM";

            boolean local_ejbs = false;

			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[] = new Object[4];
			argArray[0] = p;
			argArray[1] = tabdata;
			argArray[2] = dupflds;
			argArray[3] = tableName;

			Class [] paramArray = new Class[4];
			paramArray[0] = p.getClass();
			paramArray[1] = tabdata.getClass();
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

            httpservletresponse.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + URLEncoder.encode(error,"UTF-8") + "&err_value=" + error_value);

			if ( results != null) results.clear();
			if ( tabdata != null) tabdata.clear();
        }
        catch(Exception exception)
        {
           /*  out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : " + exception.toString());
            out.println("Values sent are : <br>");
            out.println(admission_form_code + " " + longDesc + " " + shortDesc + " " + specialty + " " + byDefault + " " + effectiveStatus); */
			exception.printStackTrace();
        }
    }
}