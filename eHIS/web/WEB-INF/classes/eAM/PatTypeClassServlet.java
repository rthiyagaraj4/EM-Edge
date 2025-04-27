/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eAM;
import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import javax.naming.*;
import javax.rmi.*;
import java.util.*;

import eAM.PatTypeClass.*;

public class PatTypeClassServlet extends javax.servlet.http.HttpServlet
{
	PrintWriter out;
	
	java.util.Properties p;
	String patienttype;
	String selectedpatientclass[];
	String dummy[] = {"novalue"};
	String facilityId ;
	String client_ip_address ;
	//String serviceURL;
	//String objectName;
	HttpSession session;

	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	}

	public synchronized void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		session = req.getSession(false);		
		this.facilityId = (String) session.getValue( "facility_id" ) ;
		this.p = (java.util.Properties) session.getValue( "jdbc" ) ;
		this.client_ip_address = p.getProperty("client_ip_address");
		/*serviceURL=(String) session.getValue("serviceURL");
		objectName="/test/PatTypeClassManager";*/

		try
		{
			res.setContentType("text/html");
			this.out = res.getWriter();
			String operation = req.getParameter("function");

			if ( operation.equals("insert") )   insertPatTypeClass(req, res);
		}
		catch(Exception e)
		{
			out.println(e.toString());
		}
	}

	/*public void doGet(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		try
		{
			this.out = res.getWriter();
			res.setContentType("text/html");
			out.println("<html><head><link rel='stylesheet' type ='text/css' href='../eCommon/html/IeStyle.css'></link><script language='javascript' src='/eCIS/mp/js/Occupation.js'></script></head><frameset rows='60,*,50'><frame name='commontoolbarFrame' src='../eCommon/jsp/MstCodeToolbar.jsp?function_name=Occupation' frameborder=0 scrolling='no' noresize><frame name='f_query_add_mod' src='../eCommon/html/blank.html' frameborder=0><frame name='messageFrame' src='../eCommon/jsp/MstCodeError.jsp' frameborder=0 noresize scrolling='auto'></frameset></html> ");
		}
		catch(Exception e)	{	}
	}*/

	private void insertPatTypeClass(HttpServletRequest req, HttpServletResponse res)
	{
		try
		{
			patienttype				= req.getParameter("patient_type");
			selectedpatientclass	= req.getParameterValues("selected_patient_class");

			/*java.util.Hashtable env = new java.util.Hashtable() ;
			env.put( Context.URL_PKG_PREFIXES, "oracle.aurora.jndi" ) ;

			InitialContext ic = new InitialContext( env );
			InitialContext context = new InitialContext();
			Object homeObject = context.lookup("java:comp/env/PatTypeClass");
			final PatTypeClassManagerHome genderManagerHome  = (PatTypeClassManagerHome) PortableRemoteObject.narrow(homeObject ,PatTypeClassManagerHome.class);
			final PatTypeClassManagerRemote genderManagerRemote = genderManagerHome.create();

			final java.util.Hashtable results;
			if (selectedpatientclass != null)
			results = genderManagerRemote.insertPatTypeClass(p,
												patienttype,selectedpatientclass,
												facilityId,client_ip_address);
			else
			results = genderManagerRemote.insertPatTypeClass(p,
												patienttype,dummy,
												facilityId,client_ip_address);*/




			boolean local_ejbs = false;
		
					if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

					Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/PatTypeClass",PatTypeClassManagerHome.class,local_ejbs);
					Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
							
					HashMap hmParams = new HashMap();
					hmParams.put("p",p);
					hmParams.put("patienttype",patienttype);
					hmParams.put("selectedpatientclass",selectedpatientclass);
					hmParams.put("facilityId",facilityId);
					hmParams.put("client_ip_address",client_ip_address);
					
					Object argArray[] = new Object[1];
					Class [] paramArray = new Class[1];
					paramArray[0] = hmParams.getClass();

					java.util.HashMap results;
		
					if (selectedpatientclass != null){
						argArray[0] = hmParams;
						 results = (java.util.HashMap)(busObj.getClass().getMethod("create",paramArray)).invoke(busObj,argArray);
						(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
					}else{
						 hmParams.put("dummy",dummy);
						 argArray[0] = hmParams;
						 results = (java.util.HashMap)(busObj.getClass().getMethod("create",paramArray)).invoke(busObj,argArray);
						(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
					}	
				
		
					boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;

					String error = (String) results.get("error") ;
					String error_value = "1" ;
					if ( inserted )
					{
					 error_value = "1" ;
//						 res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error ) + "&err_value=" + error_value );
					}
					else
					{
					 error = (String) results.get("error") ;
//						 res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" +java.net.URLEncoder.encode( error ) );
					}

					hmParams.clear();
					results.clear();

					res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8"  ) + "&err_value=" + error_value );

				}catch ( Exception e ){
					out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
					out.println( "Values sent are : <br>" ) ;
					out.println( patienttype);
				}
		}
}
