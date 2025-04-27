/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/****** Last Modified Date Time 9/22/2005 12:31 PM ******/
package eMP;

import eCommon.SingleTabHandler.SingleTabHandlerManagerHome;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Properties;
import javax.naming.InitialContext;
import javax.rmi.PortableRemoteObject;
import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import eCommon.XSSRequestWrapper;//Added by Kamatchi S for security issue against COMMON-ICN-0187

/*** @todo Class data members should be moved to method level scope ***/

public class PostalServlet extends javax.servlet.http.HttpServlet	{
PrintWriter out;

java.util.Properties p;
String postalcode;
String longDesc ;
String shortDesc ;
String res_town_code;
String effectiveDateFrom ;
String effectiveDateTo ;
String effectiveStatus ;
String facilityId;
String client_ip_address ;

	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	}

	public synchronized void doPost(HttpServletRequest req, HttpServletResponse res)
        throws javax.servlet.ServletException,IOException
	{
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");	
		//Added by Kamatchi S for security issue against COMMON-ICN-0187
		req = new XSSRequestWrapper(req);
		res.addHeader("X-XSS-Protection", "1; mode=block");
		res.addHeader("X-Content-Type-Options", "nosniff");
		//Added by Kamatchi S for security issue against COMMON-ICN-0187 END 
		HttpSession session = req.getSession(false);
		this.facilityId = (String)session.getValue("facility_id") ;
		this.p = (java.util.Properties) session.getValue( "jdbc" ) ;
		this.client_ip_address = p.getProperty("client_ip_address");
		
		try
		{
			this.out = res.getWriter();
			String operation = req.getParameter("function");

			if ( operation.equals("insert") )
				insertPostal(req, res);
			if ( operation.equals("modify"))
					modifyPostal(req, res);
		}
		catch (Exception e)
		{
			//out.println(e.toString());
			e.printStackTrace();//Added by Kamatchi S for security issue against COMMON-ICN-0187
		}
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res)
 	throws javax.servlet.ServletException,IOException
	{
		try
		{
			req.setCharacterEncoding("UTF-8");
			res.setContentType("text/html;charset=UTF-8");
			this.out = res.getWriter();


			String url = "../eCommon/jsp/MstCodeToolbar.jsp?" ;
			String params = req.getQueryString() ;
			String source = url + params ;
			
			//out.println("<html><head><link rel='stylesheet' type ='text/css' href='../eCommon/html/IeStyle.css'></link><script language='javascript' src='../eMP/js/Postal.js'></script></head><frameset rows='42,*,50'><frame name='commontoolbarFrame'	src='"+source+"' frameborder=0 scrolling='no' noresize> <frame name='f_query_add_mod' src='../eCommon/html/blank.html' frameborder=0><frame name='messageFrame'	src='../eCommon/jsp/MstCodeError.jsp' frameborder=0 noresize scrolling='auto'></frameset></html> ");
			out.println("<html><head><link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link><script language='javascript' src='../eMP/js/Postal.js'></script></head><iframe name='commontoolbarFrame' id='commontoolbarFrame' src='"+source+"' frameborder=0 scrolling='no' noresize style='height:8vh;width:100vw'></iframe><iframe name='f_query_add_mod' id='f_query_add_mod' src='../eCommon/html/blank.html' frameborder=0 scrolling=no style='height:80vh;width:100vw'></iframe><iframe name='messageFrame' id='messageFrame' src='../eCommon/jsp/MstCodeError.jsp' frameborder=0 noresize scrolling='auto' style='height:12vh;width:100vw'></iframe></html> ");
		}
		catch(Exception e)	{	}

	}

private void modifyPostal(HttpServletRequest httpservletrequest, HttpServletResponse httpservletresponse)
    {
        try
        {
            postalcode = httpservletrequest.getParameter("postal_code");
            res_town_code = httpservletrequest.getParameter("res_town_code");
            longDesc = httpservletrequest.getParameter("long_desc");
            shortDesc = httpservletrequest.getParameter("short_desc");
            effectiveStatus = httpservletrequest.getParameter("eff_status");
            if(effectiveStatus == null)
                effectiveStatus = "D";
            String s = p.getProperty("login_user");

            String s2 = s;

            String s4 = facilityId;
            String s5 = client_ip_address;
            String s6 = s5;
            
			HashMap hashtable = new HashMap();
            hashtable.put("long_desc", longDesc);
            hashtable.put("res_town_code", res_town_code);
            hashtable.put("short_desc", shortDesc);
            hashtable.put("eff_status", effectiveStatus);
            hashtable.put("modified_by_id", s2);
            hashtable.put("modified_date", new Timestamp(System.currentTimeMillis()));
            hashtable.put("modified_facility_id", s4);
            hashtable.put("modified_at_ws_no", s6);
            HashMap hashtable1 = new HashMap();
            hashtable1.put("postal_code", postalcode);

			boolean local_ejbs = isLocalEJB();
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[] = new Object[4];
			argArray[0] = p;
			argArray[1] = hashtable;
			argArray[2] = hashtable1;
			argArray[3] = "MP_POSTAL_CODE";

			Class [] paramArray = new Class[4];
			paramArray[0] = p.getClass(); ;
			paramArray[1] = hashtable.getClass();
			paramArray[2] = hashtable1.getClass();
			paramArray[3] = String.class;
			
			java.util.HashMap hashtable2 = (HashMap)(busObj.getClass().getMethod("update",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
			
			hashtable.clear();
			hashtable1.clear();

            boolean flag = ((Boolean)hashtable2.get("status")).booleanValue();
			String s8 = (String)hashtable2.get("error");
            String s7 = (String)hashtable2.get("error");
			hashtable2.clear();
            if(flag)
            {
                String s10 = "1";
                httpservletresponse.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode(s7,"UTF-8") + "&err_value=" + s10);
            } else
            {
                
                httpservletresponse.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode(s8, "UTF-8"));
            }
        }
        catch(Exception exception)
        {
			exception.printStackTrace();//Added by Kamatchi S for security issue against COMMON-ICN-0187
            //out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : " + exception.toString());
            ///out.println("Values sent are : <br>");
            //out.println(res_town_code + " " + longDesc + " " + shortDesc + " " + effectiveDateFrom + " " + effectiveDateTo + " " + effectiveStatus);
        }
    }

	private void insertPostal(HttpServletRequest req, HttpServletResponse res)
	{
		try
		{
			postalcode		= req.getParameter("postal_code");
			longDesc		= req.getParameter("long_desc");
			shortDesc		= req.getParameter("short_desc");
			res_town_code		= req.getParameter("res_town_code");
			
			effectiveStatus = req.getParameter("eff_status");

			if ( effectiveStatus == null )
					effectiveStatus="D";

			String addedById = p.getProperty( "login_user" ) ;

			String modifiedById = addedById ;

			String addedFacilityId=facilityId;
			String modifiedFacilityId = addedFacilityId ;
			String addedAtWorkstation=client_ip_address;
			String modifiedAtWorkstation = addedAtWorkstation ;

			HashMap tabdata=new HashMap();
			tabdata.put("postal_code",postalcode);
			tabdata.put("long_desc",longDesc);
			tabdata.put("short_desc",shortDesc);
			tabdata.put("res_town_code",res_town_code);

			tabdata.put("eff_status",effectiveStatus);

			tabdata.put("added_by_id",addedById);
			tabdata.put("added_date",new  java.sql.Timestamp(System.currentTimeMillis()));
			tabdata.put("added_facility_id", facilityId);
			tabdata.put("added_at_ws_no",addedAtWorkstation);
			tabdata.put("modified_by_id",modifiedById);
			tabdata.put("modified_date",new  java.sql.Timestamp(System.currentTimeMillis()));
			tabdata.put("modified_facility_id",modifiedFacilityId);
			tabdata.put("modified_at_ws_no",modifiedAtWorkstation );

			String dupflds[]={"postal_code"};

			boolean local_ejbs = isLocalEJB();
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[] = new Object[4];
			argArray[0] = p;
			argArray[1] = tabdata;
			argArray[2] = dupflds;
			argArray[3] = "MP_POSTAL_CODE";

			Class [] paramArray = new Class[4];
			paramArray[0] = p.getClass(); ;
			paramArray[1] = tabdata.getClass();
			paramArray[2] = dupflds.getClass();
			paramArray[3] = String.class;
			
			java.util.HashMap results = (HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
	

			boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;

			String error = (String) results.get("error") ;
			String error_value = "0" ;
			tabdata.clear();
			results.clear();
			if ( inserted )
			{
				 error_value = "1" ;
				 res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8") + "&err_value=" + error_value );
			}
			else
			{
				 res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" +java.net.URLEncoder.encode( error, "UTF-8") );
			}
		}
		catch ( Exception e )
		{
			//out.println("<h3> Exception raise by Servlet ...So Record Not Inserted </h3> Foll: Error Received : "+e.toString());
			e.printStackTrace();
		}
	}
	boolean isLocalEJB(){
		ServletContext context = getServletConfig().getServletContext();
		if ((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) 
				return true;
		else
				return false;
	}
}
