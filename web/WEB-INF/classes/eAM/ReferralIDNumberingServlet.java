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

import eAM.ReferralIDNumbering.* ;

//import oracle.aurora.jndi.sess_iiop.ServiceCtx ;


public class ReferralIDNumberingServlet extends javax.servlet.http.HttpServlet	{
PrintWriter out;

java.util.Properties p;
int year_num;
int  next_referral_num ;

String facilityId;
String client_ip_address ;

//java.util.Hashtable env			;
///String serviceURL				;
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
		insertReferralIDNumbering(req, res);
	if ( operation.equals("modify"))
			modifyReferralIDNumbering(req, res);
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
private void modifyReferralIDNumbering(HttpServletRequest req, HttpServletResponse res)	{
	try {
		res.setContentType("text/html");
	year_num=Integer.parseInt(req.getParameter("year_num").trim());
	next_referral_num = Integer.parseInt(req.getParameter("next_referral_num").trim());

	/*InitialContext context =  new InitialContext() ;
	Object homeObject = context.lookup("java:comp/env/ReferralIDNumbering");
	ReferralIDNumberingHome ReferralIDNumberingHome = (ReferralIDNumberingHome) PortableRemoteObject.narrow(homeObject ,ReferralIDNumberingHome.class) ;
	ReferralIDNumberingRemote ReferralIDNumberingRemote = ReferralIDNumberingHome.create();
	java.util.Hashtable results = ReferralIDNumberingRemote.updateReferralIDNumbering(p,
						year_num,next_referral_num,
						facilityId,
						client_ip_address) ;*/




						   boolean local_ejbs = false;
		
			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE")))
				local_ejbs = true;

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/ReferralIDNumbering",ReferralIDNumberingHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);







			HashMap hashmap = new HashMap();
				hashmap.put("p",p);
				hashmap.put("year_num",new Integer(year_num));
				hashmap.put("next_referral_num",new Integer(next_referral_num));
				hashmap.put("addedFacilityId",facilityId);
				hashmap.put("addedAtWorkstation",client_ip_address);



				
				Object argArray[] = new Object[1];
				argArray[0] =hashmap;
			
			

				Class [] paramArray = new Class[1];
				paramArray[0] =hashmap.getClass();
			


			java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("updateReferralIDNumbering",paramArray)).invoke(busObj,argArray);

			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);



		boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
			String error = (String) results.get("error") ;
			String error_value = "0" ;
//out.println(inserted);
//out.println("error "+error);
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
			hashmap.clear();
			results.clear();
			//res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error ) );


			} catch ( Exception e ) {
				out.println(e.getMessage());
				out.println(e.toString());
				e.printStackTrace();
			}
		}

private void insertReferralIDNumbering(HttpServletRequest req, HttpServletResponse res)	{
	try {
	res.setContentType("text/html");
	year_num=Integer.parseInt(req.getParameter("year_num").trim());
	next_referral_num = Integer.parseInt(req.getParameter("next_referral_num").trim());

	/*InitialContext context =  new InitialContext(  ) ;
	Object homeObject = context.lookup("java:comp/env/ReferralIDNumbering");
	ReferralIDNumberingHome ReferralIDNumberingHome = (ReferralIDNumberingHome) PortableRemoteObject.narrow(homeObject ,ReferralIDNumberingHome.class) ;
	ReferralIDNumberingRemote ReferralIDNumberingRemote = ReferralIDNumberingHome.create();
	java.util.Hashtable results = ReferralIDNumberingRemote.insertReferralIDNumbering(p,
						year_num,next_referral_num,facilityId,
						client_ip_address) ;*/

	   boolean local_ejbs = false;
		
			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE")))
				local_ejbs = true;

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/ReferralIDNumbering",ReferralIDNumberingHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
		
			HashMap hashmap = new HashMap();
				hashmap.put("p",p);
				hashmap.put("year_num",new Integer(year_num));
				hashmap.put("next_referral_num",new Integer(next_referral_num));
				hashmap.put("addedFacilityId",facilityId);
				hashmap.put("addedAtWorkstation",client_ip_address);

				
				Object argArray[] = new Object[1];
				argArray[0] =hashmap;
			
			

				Class [] paramArray = new Class[1];
				paramArray[0] =hashmap.getClass();
			
		

			java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("insertReferralIDNumbering",paramArray)).invoke(busObj,argArray);

			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);


		boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
					String error = (String) results.get("error") ;
					String error_value = "0" ;

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
					hashmap.clear();
			        results.clear();
					//res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error ) );


					} catch ( Exception e ) {
						out.println(e.getMessage());
						out.println(e.toString());
						e.printStackTrace();
			}
	}
}
