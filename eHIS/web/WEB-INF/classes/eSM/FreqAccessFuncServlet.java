/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eSM;

import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import java.util.*;
import javax.naming.*;
import javax.rmi.*;
import java.util.*;

import eSM.FreqAccessFunc.* ;

public class FreqAccessFuncServlet extends javax.servlet.http.HttpServlet	{

PrintWriter out;
java.util.Properties p;
String client_ip_address ;
String serviceURL;
String appl_user_id    ;       
String resp_id      ;          
String checkval;


public void init(ServletConfig config) throws ServletException	
{
	super.init(config);
}

public synchronized void doPost(HttpServletRequest req, HttpServletResponse res)
        throws javax.servlet.ServletException,IOException
{
	res.setContentType("text/html;charset=UTF-8");
	req.setCharacterEncoding("UTF-8");

	HttpSession session = req.getSession(false);
	
	this.p = (java.util.Properties) session.getValue( "jdbc" ) ;
	this.client_ip_address = p.getProperty("client_ip_address");
	try 
	{
		this.out = res.getWriter();
		
		 appl_user_id = req.getParameter("Log_user");
		 resp_id = req.getParameter("responsibility_id");
		 String operation = req.getParameter("operation");
		 String operationDelete = req.getParameter("operationDelete");
		 
		  if ( operation.equals("insert") )
			{
				checkval = req.getParameter("checkval");
				
				if ((checkval !=null) && (!checkval.equals("")))
				{
					insertFreqAccessFunc(req, res);
				}
			}
		 
		 if ( operationDelete.equals("delete") )
		{
			 
			 checkval = req.getParameter("checkval1");
			 if ((checkval !=null) && (!checkval.equals("")))
		 		deleteFreqAccessFunc(req, res);
		}
	}
catch (Exception e)	
{
		out.println(e.toString());
	}
}

	private void insertFreqAccessFunc(HttpServletRequest req, HttpServletResponse res)	{
	try {
			
			
			boolean local_ejbs = false;
			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

				Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/FreqAccessFunc",FreqAccessFuncHome.class,local_ejbs);
				Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
				
				Object argArray[] = new Object[1];
				HashMap argMap=new HashMap();
				argMap.put("p",p);
				argMap.put("appl_user_id",appl_user_id);
				argMap.put("resp_id",resp_id);
				argMap.put("checkval",checkval);
				argMap.put("addedAtWorkstation",client_ip_address);
				argArray[0] = argMap;
						
				
				Class [] paramArray = new Class[1];
				paramArray[0] = argMap.getClass();
			

				java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("insertFreqAccessFunc",paramArray)).invoke(busObj,argArray);

				(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
				boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;

				String error = (String) results.get("error") ;
				String error_value = "0" ;
		if ( inserted ) 
				{
					error_value = "1" ;
					res.sendRedirect("../eSM/jsp/FreqAccessFuncError.jsp?err_num=" + java.net.URLEncoder.encode( error , "UTF-8") + "&err_value=" + error_value );
				}
				else 
				{
					res.sendRedirect("../eSM/jsp/FreqAccessFuncError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8" )  );
				}

                argMap.clear();
				results.clear();
		} catch ( Exception e ) {
			out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
			out.println( "Values sent are : <br>" ) ;

			}
	}


private void deleteFreqAccessFunc(HttpServletRequest req, HttpServletResponse res)	{
	try {

			boolean local_ejbs = false;
			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

				Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/FreqAccessFunc",FreqAccessFuncHome.class,local_ejbs);
				Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
				
				Object argArray[] = new Object[1];
				HashMap argMap=new HashMap();
				argMap.put("p",p);
				argMap.put("appl_user_id",appl_user_id);
				argMap.put("resp_id",resp_id);
				argMap.put("checkval",checkval);
				argMap.put("addedAtWorkstation",client_ip_address);
				argArray[0] = argMap;
						
				
				Class [] paramArray = new Class[1];
				paramArray[0] = argMap.getClass();
			

				java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("deleteFreqAccessFunc",paramArray)).invoke(busObj,argArray);

				(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);


				boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
				String error = (String) results.get("error") ;
				String error_value = "0" ;

				if ( inserted ) 
				{
					error_value = "1" ;
					
					res.sendRedirect("../eSM/jsp/FreqAccessFuncError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8" ) + "&err_value=" + error_value );
				}
				else 
				{
					res.sendRedirect("../eSM/jsp/FreqAccessFuncError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8" )  );
				}
                argMap.clear();
				results.clear();

		} catch ( Exception e ) {
			out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
			out.println( "Values sent are : <br>" ) ;

			}
	}
} 
