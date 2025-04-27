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
import eSM.MenuAccessRights.*;


public class AccessRightsMenuFuncServlet extends javax.servlet.http.HttpServlet
{
	PrintWriter out;
	Properties p;
	String facilityId ;
	String client_ip_address ;
	int Pval = 0;

	HttpSession session;

	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	}

	public synchronized void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		session = req.getSession(false);
		this.p = (java.util.Properties) session.getValue( "jdbc" ) ;
		this.facilityId = (String) session.getValue( "facility_id" ) ;
		client_ip_address = p.getProperty("client_ip_address");

		try
		{
			req.setCharacterEncoding("UTF-8");
		    res.setContentType("text/html;charset=UTF-8");
			this.out = res.getWriter();
			updateAccessRightsFunc(req, res);
		}
		catch(Exception e)
		{
			out.println(e.toString());
		}
	}

	private void updateAccessRightsFunc(HttpServletRequest req, HttpServletResponse res)
	{
		try
		{
			Pval	=	Integer.parseInt(req.getParameter("Pval"));

			String arrVals[] = { "ins","upd","del","qry","prn","optionsequenceno","functionid","menuid","subfunctionvalues" };

			String insertaccessyn[] 	= new String[Pval+1];
			String updateaccessyn[] 	= new String[Pval+1];
			String deleteaccessyn[] 	= new String[Pval+1];
			String queryonlyaccessyn[] 	= new String[Pval+1];
			String printaccessyn[] 		= new String[Pval+1];
			String optionsequenceno[] 	= new String[Pval+1];
			String functionid[] 		= new String[Pval+1];
			String menuid[] 			= new String[Pval+1];
			String subfunctionvalues[]	= new String[Pval+1];

			for (int y = 1; y<=Pval;y++ )
			 {
				insertaccessyn[y] 		= req.getParameter(arrVals[0]+y);
					if(insertaccessyn[y]==null) 	 insertaccessyn[y] ="N";

				updateaccessyn[y] 		= req.getParameter(arrVals[1]+y);
					if(updateaccessyn[y]==null) 	 updateaccessyn[y] ="N";

				deleteaccessyn[y] 		= req.getParameter(arrVals[2]+y);
					if(deleteaccessyn[y] == null)	 deleteaccessyn[y] ="N";

				queryonlyaccessyn[y]	= req.getParameter(arrVals[3]+y);
					if(queryonlyaccessyn[y] == null) queryonlyaccessyn[y] ="N";

				printaccessyn[y] 		= req.getParameter(arrVals[4]+y);
					if(printaccessyn[y] == null)	 printaccessyn[y] ="N";

				optionsequenceno[y] = req.getParameter(arrVals[5]+y);
					if(optionsequenceno[y] == null)	 optionsequenceno[y] ="";

				functionid[y]	= req.getParameter(arrVals[6]+y);
					if(functionid[y] == null)	 functionid[y] ="";

				menuid[y] 		= req.getParameter(arrVals[7]+y);
					if(menuid[y] == null)	 menuid[y] ="";

				subfunctionvalues[y] = req.getParameter(arrVals[8]+y);
					if(subfunctionvalues[y] == null)	 subfunctionvalues[y] ="";
			 }

			boolean local_ejbs = false;
		
			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/MenuAccessRightsManager",MenuAccessRightsHome.class,local_ejbs);
			
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
			
			Integer PvalInt=new Integer(Pval);
			HashMap argMap=new HashMap();
			argMap.put("p",p);
			argMap.put("insertaccessyn",insertaccessyn);
			argMap.put("updateaccessyn",updateaccessyn);
			argMap.put("deleteaccessyn",deleteaccessyn);
			argMap.put("printaccessyn",printaccessyn);
			argMap.put("queryonlyaccessyn",queryonlyaccessyn);
			argMap.put("functionid",functionid);
			argMap.put("menuid",menuid);
			argMap.put("Pval",PvalInt);
			argMap.put("optionsequenceno",optionsequenceno);
			argMap.put("facilityId",facilityId);
			argMap.put("client_ip_address",client_ip_address);
			argMap.put("subfunctionvalues",subfunctionvalues);
			

			Object argArray[] = new Object[1];
			argArray[0] = argMap;
			
			Class [] paramArray = new Class[1];
			paramArray[0] = argMap.getClass();

			java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("updateMenuAccessRights",paramArray)).invoke(busObj,argArray);
            
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);


			argMap.clear();

			String error = (String) results.get("error") ;
			error = (String) results.get("error") ;

			results.clear();
			
			
			res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8" ) );

		}catch ( Exception e )
		 {
			out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
			out.println( "Values sent are : <br>") ;
		 }
	}
}
