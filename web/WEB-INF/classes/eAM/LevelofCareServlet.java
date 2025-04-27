/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eAM;

import eCommon.SingleTabHandler.SingleTabHandlerManagerHome;
import eCommon.SingleTabHandler.SingleTabHandlerManagerRemote;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.sql.Timestamp;
import java.util.*;
import java.util.Properties;
import javax.naming.InitialContext;
import javax.rmi.PortableRemoteObject;
import javax.servlet.*;
import javax.servlet.http.*;
import webbeans.eCommon.ConnectionManager;

public class LevelofCareServlet extends HttpServlet
    implements SingleThreadModel
{

    PrintWriter out;
    HttpSession session;
    Properties p;
    String facilityId;
    String client_ip_address;
    String level_of_care_code;
    String level_of_care_desc;
    String level_of_care_indicator;
    String eff_status;
   // static Class class$eCommon$SingleTabHandler$SingleTabHandlerManagerHome; /* synthetic field */

    public LevelofCareServlet()
    {
        out = null;
        session = null;
        p = null;
        facilityId = "";
        client_ip_address = "";
        level_of_care_code = "";
        level_of_care_desc = "";
        level_of_care_indicator = "";
        eff_status = "";
    }

    public void init(ServletConfig servletconfig)
        throws ServletException
    {
        super.init(servletconfig);
    }

    public void doPost(HttpServletRequest httpservletrequest, HttpServletResponse httpservletresponse)
        throws ServletException, IOException
    {
       //String s = "";
        try
        {
            httpservletresponse.setContentType("text/html");
            out = httpservletresponse.getWriter();
            session = httpservletrequest.getSession(false);
            p = (Properties)session.getValue("jdbc");
            facilityId = (String)session.getValue("facility_id");
            client_ip_address = p.getProperty("client_ip_address");
            String s1 = httpservletrequest.getParameter("function_name");
            if(s1.equals("insert"))
            {
                insertLevelofCare(httpservletrequest, httpservletresponse);
            }
            if(s1.equals("modify"))
            {
                modifyLevelofCare(httpservletrequest, httpservletresponse);
            }
        }
        catch(Exception exception)
        {
            out.println("Exception" + exception);
        }
    }

    private void insertLevelofCare(HttpServletRequest httpservletrequest, HttpServletResponse httpservletresponse)
    {
        try
        {
            level_of_care_code = httpservletrequest.getParameter("level_of_care_code");
            level_of_care_desc = httpservletrequest.getParameter("level_of_care_desc");
            level_of_care_indicator = httpservletrequest.getParameter("level_of_care_indicator");
            eff_status = httpservletrequest.getParameter("eff_status");
            if(eff_status == null || eff_status.equals("null"))
            {
                eff_status = "D";
            }
            String s = p.getProperty("login_user");
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
           // String s1 = s;
            Timestamp timestamp1 = new Timestamp(System.currentTimeMillis());
            String s2 = facilityId;
            String s3 = s2;
            String s4 = client_ip_address;
            String s5 = s4;
            HashMap hashtable = new HashMap();
            hashtable.put("level_of_care_code", level_of_care_code);
            hashtable.put("level_of_care_desc", level_of_care_desc);
            hashtable.put("level_of_care_indicator", level_of_care_indicator);
            hashtable.put("eff_status",eff_status);
            hashtable.put("added_by_id",s);
            hashtable.put("added_date",timestamp);
            hashtable.put("added_at_ws_no",s4);
            hashtable.put("added_facility_id", s2);
            hashtable.put("modified_by_id", s3);
            hashtable.put("modified_date", timestamp1);
            hashtable.put("modified_facility_id", s3);
            hashtable.put("modified_at_ws_no", s5);
            String as[] = {
                "level_of_care_code"
            };
          /*  InitialContext initialcontext = new InitialContext();
            Object obj = initialcontext.lookup("java:comp/env/SingleTabHandler");
            SingleTabHandlerManagerHome singletabhandlermanagerhome = (SingleTabHandlerManagerHome)PortableRemoteObject.narrow(obj, class$eCommon$SingleTabHandler$SingleTabHandlerManagerHome != null ? class$eCommon$SingleTabHandler$SingleTabHandlerManagerHome : (class$eCommon$SingleTabHandler$SingleTabHandlerManagerHome = _mthclass$(("eCommon.SingleTabHandler.SingleTabHandlerManagerHome"
))));
            SingleTabHandlerManagerRemote singletabhandlermanagerremote = singletabhandlermanagerhome.create();
            Hashtable hashtable1 = singletabhandlermanagerremote.insert(p, hashtable, as,"am_level_of_care");
			*/
			boolean local_ejbs = false;
		
			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE")))
				local_ejbs = true;

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);


			Object argArray[] = new Object[4];
				//argArray[0] =hashmap;
				String table_name="am_level_of_care";
				argArray[0] =p;
				argArray[1] =hashtable;
				argArray[2] =as;
				argArray[3] =table_name;

				Class [] paramArray = new Class[4];
				//paramArray[0] =hashmap.getClass();
					paramArray[0] =p.getClass();
					paramArray[1] =hashtable.getClass();
					paramArray[2] =as.getClass();
					paramArray[3] =table_name.getClass();

		

			java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);

			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

			



            boolean flag = ((Boolean)results.get("status")).booleanValue();
            String s6 = (String)results.get("error");
          //  String s8 = "0";
		  hashtable.clear();
		  
            if(flag)
            {
                String s9 = "1";
                httpservletresponse.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + URLEncoder.encode(s6,"UTF-8" ) + "&err_value=" + s9);
            } else
            {
                String s7 = (String)results.get("error");
                httpservletresponse.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + URLEncoder.encode(s7,"UTF-8" ));
            }results.clear();
        }
        catch(Exception exception)
        {
       //     out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Rece
//ived :") + exception.toString());
         //   out.println(zkmToString("Values sent are : <br>"));
          //  out.println(level_of_care_code + " " + level_of_care_desc + " " + eff_status);
exception.printStackTrace();
        }
    }

    private void modifyLevelofCare(HttpServletRequest httpservletrequest, HttpServletResponse httpservletresponse)
    {
        java.sql.Connection connection = null;
		  HashMap hashtable = new HashMap();
        try
        {
            connection = ConnectionManager.getConnection(httpservletrequest);
            level_of_care_code = httpservletrequest.getParameter("level_of_care_code");
            level_of_care_desc = httpservletrequest.getParameter("level_of_care_desc");
            level_of_care_indicator = httpservletrequest.getParameter("level_of_care_indicator");
            eff_status = httpservletrequest.getParameter("eff_status");
            if(eff_status == null || eff_status.equals("null"))
            {
                eff_status = "D";
            }
        //    String s = p.getProperty("login_user");
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            String s1 = facilityId;
            String s2 = client_ip_address;
            String s3 = s2;
            hashtable.put("level_of_care_desc", level_of_care_desc);
            hashtable.put("level_of_care_indicator", level_of_care_indicator);
            hashtable.put("eff_status", eff_status);
            hashtable.put("modified_by_id", s1);
            hashtable.put("modified_date", timestamp);
            hashtable.put("modified_facility_id", s1);
            hashtable.put("modified_at_ws_no", s3);
            HashMap hashtable1 = new HashMap();
            hashtable1.put("level_of_care_code", level_of_care_code);

          /*  InitialContext initialcontext = new InitialContext();
            Object obj = initialcontext.lookup("java:comp/env/SingleTabHandler");
            SingleTabHandlerManagerHome singletabhandlermanagerhome = (SingleTabHandlerManagerHome)PortableRemoteObject.narrow(obj, class$eCommon$SingleTabHandler$SingleTabHandlerManagerHome != null ? class$eCommon$SingleTabHandler$SingleTabHandlerManagerHome : (class$eCommon$SingleTabHandler$SingleTabHandlerManagerHome = _mthclass$(zkmToString("eCommon.SingleTabHandler.SingleTabHandlerManagerHome"
))));
            SingleTabHandlerManagerRemote singletabhandlermanagerremote = singletabhandlermanagerhome.create();
            Hashtable hashtable2 = singletabhandlermanagerremote.update(p, hashtable, hashtable1, "am_level_of_care");
			*/

			boolean local_ejbs = false;
		
			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE")))
				local_ejbs = true;

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);


			
				Object argArray[] = new Object[4];
				//argArray[0] =hashmap;
				String table_name="am_level_of_care";
				argArray[0] =p;
				argArray[1] =hashtable;
				argArray[2] =hashtable1;
				argArray[3] =table_name;

				Class [] paramArray = new Class[4];
				//paramArray[0] =hashmap.getClass();
					paramArray[0] =p.getClass();
					paramArray[1] =hashtable.getClass();
					paramArray[2] =hashtable1.getClass();
					paramArray[3] =table_name.getClass();

		

			java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("update",paramArray)).invoke(busObj,argArray);

			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);



            boolean flag = ((Boolean)results.get("status")).booleanValue();
            String s4 = (String)results.get("error");
        //    String s6 = "0";
            if(flag)
            {
                String s7 = "1";
                httpservletresponse.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + URLEncoder.encode(s4,"UTF-8" ) + "&err_value=" + s7);
            } else
            {
                String s5 = (String)results.get("error");
                httpservletresponse.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + URLEncoder.encode(s5,"UTF-8" ));
            }
			hashtable.clear();
			results.clear();
			hashtable1.clear();
        }
        catch(Exception exception)
        {
           exception.printStackTrace();
        }
        finally
        {
            out.print("level_of_care_indicator" + level_of_care_indicator + "<BR>");
            if(connection != null)
            {
                ConnectionManager.returnConnection(connection, httpservletrequest);
            }
        }
    }

  /*  static Class _mthclass$(String s)
    {
        try
        {
            return Class.forName(s);
        }
        catch(ClassNotFoundException classnotfoundexception)
        {
            throw new NoClassDefFoundError(classnotfoundexception.getMessage());
        }
    }*/


}

   
