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

import eSM.FuncForRespGrp.*;

public class FuncForRespGrpServlet extends javax.servlet.http.HttpServlet{

PrintWriter out;
Properties p;
String facilityId ;
public void init(ServletConfig config) throws ServletException{
		super.init(config);
	}
public synchronized void doPost(HttpServletRequest req, HttpServletResponse res)
        throws javax.servlet.ServletException,IOException
	{    
	    req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
		HttpSession session		= req.getSession(true);
		this.p			  		= (java.util.Properties) session.getValue( "jdbc" ) ;
	try {
			this.out = res.getWriter();
			modify(req, res);
		}catch (Exception e)
			{
				//out.println(e.toString());
				e.printStackTrace();
			}
    }
private void modify(HttpServletRequest req, HttpServletResponse res)	{ 
	try {
			Enumeration enum1 	=	req.getParameterNames();
			ArrayList RM = new ArrayList();
			ArrayList RF=new ArrayList();
			ArrayList RC=new ArrayList();
			ArrayList AM=new ArrayList();
			ArrayList AF=new ArrayList();
			ArrayList AC=new ArrayList();
			int rc=0;
			int ac=0;
			while (enum1.hasMoreElements())
			{
					String param_name=(String)enum1.nextElement();
					String substr_param = param_name.substring(0,2);
					  if(substr_param .equals("RC") || substr_param.equals("AC") )
					 {
						String param_num = param_name.substring(2,param_name.length() );

						if(substr_param.equals("RC"))
						{
							RC.add(req.getParameter(param_name));
							RM.add(req.getParameter("RM"+param_num));
							RF.add(req.getParameter("RF"+param_num));
							rc++;
						}
						else
						{
							AC.add(req.getParameter(param_name));
							AM.add(req.getParameter("AM"+param_num));
							AF.add(req.getParameter("AF"+param_num));
							ac++;
						}
					 }
			}

				boolean local_ejbs = false;
		
				if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

				Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/FuncForRespGrpManager",FuncForRespGrpHome.class,local_ejbs);
				Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
		
				HashMap argMap=new HashMap ();
				argMap.put("p",p);
				argMap.put("RM",RM);
				argMap.put("RF",RF);
				argMap.put("RC",RC);
				argMap.put("AM",AM);
				argMap.put("AF",AF);
				argMap.put("AC",AC);
				argMap.put("resp_group_id",req.getParameter("resp_group_id")== null ?"":req.getParameter("resp_group_id"));
				argMap.put("facilityId",facilityId);
				argMap.put("client_ip_address",p.getProperty("client_ip_address")== null ?"":p.getProperty("client_ip_address"));
				
				Object argArray[] = new Object[1];
				argArray[0] =argMap ;
					
				Class [] paramArray = new Class[1];

				paramArray[0] = argMap.getClass();

				java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("update",paramArray)).invoke(busObj,argArray);

				(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

				boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
				String error = (String) results.get("error") ;
				String error_value = "0" ;

				if ( inserted ) 
				{
					
					error_value = "1" ;
				}
				else
					{
						
						error = (String) results.get("error") ;
					}

					res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8" ) + "&err_value=" + error_value );
					RM.clear();
					RF.clear();
					RC.clear();
					AM.clear();
					AF.clear();
					AC.clear();
					argMap.clear();
					results.clear();


		} catch ( Exception e ) {
			/*out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
			out.println( "Values sent are : <br>" ) ; */
			e.printStackTrace();

			} 
	}//E.O.Method
}
