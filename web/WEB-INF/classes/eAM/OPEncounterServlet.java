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

import eAM.OPEncounter.* ;

//import oracle.aurora.jndi.sess_iiop.ServiceCtx ;


public class OPEncounterServlet extends javax.servlet.http.HttpServlet	{
PrintWriter out;
java.util.Properties p;
//int year;
int  nextnum ;
String effectiveDateFrom ;
String effectiveDateTo ;
String effectiveStatus ;
String facilityId;
String client_ip_address ;

//java.util.Hashtable env			;
//String serviceURL				;
//String objectName				;



public void init(ServletConfig config) throws ServletException	{
	super.init(config);
	}
public synchronized void doPost(HttpServletRequest req, HttpServletResponse res)
        throws javax.servlet.ServletException,IOException
	{


	HttpSession session = req.getSession(false);
	this.facilityId = (String)session.getValue("facility_id") ;
	this.p = (java.util.Properties) session.getValue( "jdbc" ) ;
	this.client_ip_address = p.getProperty("client_ip_address");
	/*
	env		= (java.util.Hashtable) session.getValue( "env" ) ;
	serviceURL 	= (String) session.getValue( "serviceURL" ) ;
	objectName 	= "/test/OPEncounterManager" ;
*/
	try {
		this.out = res.getWriter();
		String operation = req.getParameter("function");

	if ( operation.equals("insert") )
		insertOPEncounter(req, res);
	if ( operation.equals("modify"))
			modifyOPEncounter(req, res);
	}
	catch (Exception e)	{
		out.println(e.toString());
		}
	}
/*public void doGet(HttpServletRequest req, HttpServletResponse res)
 	throws javax.servlet.ServletException,IOException
	{
	try	{
	this.out = res.getWriter();
	res.setContentType("text/html");
	out.println("<html><head><link rel='stylesheet' type ='text/css' href='../eCommon/html/IeStyle.css'></link><script language='javascript' src='../eMP/js/NamePrefix.js'></script></head><frameset rows='42,*,50'><frame name='commontoolbarFrame'	src='../eCommon/jsp/commonToolbar.jsp?function_name=Name Prefix' frameborder=0 scrolling='no' noresize> <frame name='f_query_add_mod' src='../eCommon/html/blank.html' frameborder=0><frame name='messageFrame'	src='../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto'></frameset></html> ");
	}
	catch(Exception e)	{	}
	}*/
private void modifyOPEncounter(HttpServletRequest req, HttpServletResponse res)	{
	try {
		res.setContentType("text/html");
	//year=Integer.parseInt(req.getParameter("year").trim());
	nextnum = Integer.parseInt(req.getParameter("next_num").trim());
	effectiveDateFrom = req.getParameter("eff_date_from");
	effectiveDateTo = req.getParameter("eff_date_to");
	effectiveStatus = req.getParameter("eff_status");
	if ( effectiveStatus == null )
		effectiveStatus="D";


	/*InitialContext context =  new InitialContext() ;
	Object homeObject = context.lookup("java:comp/env/OPEncounter");
	OPEncounterManagerHome opEncounterManagerHome = (OPEncounterManagerHome) PortableRemoteObject.narrow(homeObject ,OPEncounterManagerHome.class) ;
	OPEncounterManagerRemote opEncounterManagerRemote = opEncounterManagerHome.create();
	java.util.Hashtable results = opEncounterManagerRemote.updateEncounter(	p,
						nextnum,
						effectiveDateFrom,effectiveDateTo,
						effectiveStatus,facilityId,
						client_ip_address) ;*/



				boolean local_ejbs = false;
		
					if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

					Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/OPEncounter",OPEncounterManagerHome.class,local_ejbs);
					Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
		
					Object argArray[] = new Object[1];
					Class [] paramArray = new Class[1];
					HashMap hmParams = new HashMap();
					
					hmParams.put("p",p);
					hmParams.put("nextnum",new Integer(nextnum));
					hmParams.put("effectiveDateFrom",effectiveDateFrom);
					hmParams.put("effectiveDateTo",effectiveDateTo);
					hmParams.put("effectiveStatus",effectiveStatus);
					hmParams.put("facilityId",facilityId);
					hmParams.put("client_ip_address",client_ip_address);
	
					argArray[0] = hmParams;
					paramArray[0] = hmParams.getClass();

					java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("updateEncounter",paramArray)).invoke(busObj,argArray);
	
					(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

					boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
			String error = (String) results.get("error") ;
			String error_value = "0" ;
           
			 hmParams.clear();
			if ( inserted )
			{
				error_value = "1" ;
				res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8"  ) + "&err_value=" + error_value );
			}
			else
			{
				error = (String) results.get("error") ;
				res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" +java.net.URLEncoder.encode( error ,"UTF-8" ) );
			}
			//res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error ) );
            
			results.clear();

			} catch ( Exception e ) {
				out.println(e.getMessage());
				out.println(e.toString());
				e.printStackTrace();
			}
		}

private void insertOPEncounter(HttpServletRequest req, HttpServletResponse res)	{
	try {
	res.setContentType("text/html");
	//year=Integer.parseInt(req.getParameter("year").trim());
	nextnum = Integer.parseInt(req.getParameter("next_num").trim());
	effectiveDateFrom = req.getParameter("eff_date_from");
	effectiveDateTo = req.getParameter("eff_date_to");
	effectiveStatus = req.getParameter("eff_status");

	if ( effectiveStatus == null )
			effectiveStatus="D";

	/*InitialContext context =  new InitialContext(  ) ;
	Object homeObject = context.lookup("java:comp/env/OPEncounter");
	OPEncounterManagerHome opEncounterManagerHome = (OPEncounterManagerHome) PortableRemoteObject.narrow(homeObject ,OPEncounterManagerHome.class) ;
	OPEncounterManagerRemote opEncounterManagerRemote = opEncounterManagerHome.create();
	java.util.Hashtable results = opEncounterManagerRemote.insertEncounter(	p,
						nextnum,
						effectiveDateFrom,effectiveDateTo,
						effectiveStatus,facilityId,
						client_ip_address) ;*/

		boolean local_ejbs = false;
		
					if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

					Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/OPEncounter",OPEncounterManagerHome.class,local_ejbs);
					Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
		
					Object argArray[] = new Object[1];
					Class [] paramArray = new Class[1];
					HashMap hmParams = new HashMap();
					
					hmParams.put("p",p);
					hmParams.put("nextnum",new Integer(nextnum));
					hmParams.put("effectiveDateFrom",effectiveDateFrom);
					hmParams.put("effectiveDateTo",effectiveDateTo);
					hmParams.put("effectiveStatus",effectiveStatus);
					hmParams.put("facilityId",facilityId);
					hmParams.put("client_ip_address",client_ip_address);
	
					argArray[0] = hmParams;
					paramArray[0] = hmParams.getClass();

					java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("insertEncounter",paramArray)).invoke(busObj,argArray);
	
					(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

					boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
					String error = (String) results.get("error") ;
					String error_value = "0" ;

                     hmParams.clear();

					if ( inserted )
					{
						error_value = "1" ;
						res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8"  ) + "&err_value=" + error_value );
					}
					else
					{
						error = (String) results.get("error") ;
						res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" +java.net.URLEncoder.encode( error,"UTF-8"  ) );
					}
					//res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error ) );

                     
			         results.clear();
					} catch ( Exception e ) {
						out.println(e.getMessage());
						out.println(e.toString());
						e.printStackTrace();
			}
	}
}
