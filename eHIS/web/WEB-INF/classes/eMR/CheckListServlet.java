/*Created by Ashwini on 01-Nov-2017 for ML-MMOH-CRF-0707*/
package eMR;

import java.sql.Timestamp;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.*;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import eCommon.SingleTabHandler.*;

import eCommon.XSSRequestWrapper;


public class CheckListServlet extends HttpServlet
{

    PrintWriter out;
    Properties p;
    String chk_list_code;
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
                insertCheckList(httpservletrequest, httpservletresponse);
            if(s.equals("modify"))
                modifyCheckList(httpservletrequest, httpservletresponse);
        }
        catch(Exception exception)
        {
           // out.println(exception.toString());
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
			
			httpservletrequest= new XSSRequestWrapper(httpservletrequest);
			httpservletresponse.addHeader("X-XSS-Protection", "1; mode=block");
			httpservletresponse.addHeader("X-Content-Type-Options", "nosniff");
			
			String s = httpservletrequest.getParameter("function");
            if(s.equals("insert"))
                insertCheckList(httpservletrequest, httpservletresponse);
            if(s.equals("modify"))
                modifyCheckList(httpservletrequest, httpservletresponse);
        }
        catch(Exception exception) { /* System.out.println(exception.getMessage()); */ exception.printStackTrace();}
    }

    private void modifyCheckList(HttpServletRequest httpservletrequest, HttpServletResponse httpservletresponse)
    {
        try
        {
            chk_list_code = httpservletrequest.getParameter("chk_list_code");
            longDesc = httpservletrequest.getParameter("long_desc");
            shortDesc = httpservletrequest.getParameter("short_desc");
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
            hashmap.put("eff_status", effectiveStatus);
            hashmap.put("added_by_id", added_by_id);
            hashmap.put("modified_by_id", modified_by_id);
            hashmap.put("modified_date", modified_date);
            hashmap.put("modified_facility_id", modified_facility_id);
            hashmap.put("modified_at_ws_no", modified_at_ws_no);
            hashmap.put("chk_list_code", chk_list_code);
			 
			HashMap condflds=new HashMap();
			condflds.put("chk_list_code",chk_list_code);
			String tableName = "CHK_LIST_MEDICAL_REPORT";
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
            out.println(chk_list_code + " " + longDesc + " " + shortDesc + " " + effectiveStatus); */
			
			exception.printStackTrace();
        }
    }

    private void insertCheckList(HttpServletRequest httpservletrequest, HttpServletResponse httpservletresponse)
    {
        try
        {
            chk_list_code = httpservletrequest.getParameter("chk_list_code");
			
            longDesc = httpservletrequest.getParameter("long_desc");
            shortDesc = httpservletrequest.getParameter("short_desc");
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
            tabdata.put("chk_list_code", chk_list_code);
            tabdata.put("long_desc", longDesc);
            tabdata.put("short_desc", shortDesc);
            tabdata.put("eff_status", effectiveStatus);
            tabdata.put("added_by_id", added_by_id);
            tabdata.put("added_date", added_date);
            tabdata.put("added_facility_id", facilityId);
            tabdata.put("added_at_ws_no", added_at_ws_no);
            tabdata.put("modified_by_id", modified_by_id);
            tabdata.put("modified_date", modified_date);
            tabdata.put("modified_facility_id", modified_facility_id);
            tabdata.put("modified_at_ws_no", modified_at_ws_no);
			
			String dupflds[]={"chk_list_code"};
			String tableName = "CHK_LIST_MEDICAL_REPORT";

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
            /* out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : " + exception.toString());
            out.println("Values sent are : <br>");
            out.println(chk_list_code + " " + longDesc + " " + shortDesc + " " + effectiveStatus); */
			
			exception.printStackTrace();
        }
    }
	
	// added by mujafar for ML-MMOH-CRF-0762 start
	public String checkForNull(String inputString)
	{
		return((inputString == null) ? "" : inputString);
	}
		public String checkForNull(String inputString, String Defaultstr)
	{
		return((inputString == null) ? Defaultstr : inputString);
	}
// added by mujafar for ML-MMOH-CRF-0762 end
   
}