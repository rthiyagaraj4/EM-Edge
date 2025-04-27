/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
Sr No        Version           Incident        SCF/CRF             Developer Name
-----------------------------------------------------------------------------------
1            V201103            074099         NMC-JD-CRF-0011.1       Muthukumar N
-----------------------------------------------------------------------------------
*/

package eBL;

import java.lang.reflect.Method;
import java.net.*;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.*;
import javax.naming.InitialContext;
import javax.rmi.PortableRemoteObject;
import eBL.PkgParameters.*;
import eBL.*;	 
import com.ehis.persist.*;
import java.sql.*;
import webbeans.eCommon.*;
import java.util.ArrayList ;
import eCommon.Common.*;
import com.ehis.eslp.ServiceLocator;

public class PkgParametersServlet extends javax.servlet.http.HttpServlet
{
	PrintWriter out;
	java.util.Properties p;
	HashMap results;
	String facilityId="";
	String client_ip_address="";
	String login_user="";
	String slmt_ind="",adm_rec_flag="";
	String locale = "";
	HashMap tabdata=null;
	HttpSession session;
	String mode="";
	java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "yyyy-MM-dd" ) ;

	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	}

	public synchronized void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{	
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
		session = req.getSession(false);
		this.p = (java.util.Properties) session.getValue( "jdbc" ) ;
		facilityId = (String) session.getValue( "facility_id" ) ;
		client_ip_address = this.p.getProperty("client_ip_address");
		login_user = this.p.getProperty( "login_user" ) ;
		locale = this.p.getProperty("LOCALE") ;
		try
		{
			this.out = res.getWriter();
			modifyData(req, res);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			out.println(e.toString());
		}
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException{
		doPost(req,res);
	}

	private HashMap populateTabData(HttpServletRequest req, HttpServletResponse res)
	{
		String pkgStatus = checkForNull(req.getParameter("pkgStatus"));
		String pkgBkDateD = checkForNull(req.getParameter("pkgBkDateD"));
		String glSmryYN = checkForNull(req.getParameter("glSmryYN"));
		//String glSmry = checkForNull(req.getParameter("glSmry"));
		String valdDForOrd = checkForNull(req.getParameter("valdDForOrd"));
		String autoRefundYN = checkForNull(req.getParameter("autoRefundYN"));
		String valdRefundD = checkForNull(req.getParameter("valdRefundD"));
		String unAvaldSrvCode = checkForNull(req.getParameter("unAvaldSrvCode"));
		String pat_dep_for_pkg_code = checkForNull(req.getParameter("pat_dep_for_pkg_code"));
		
		String pkgServiceLimitBy = checkForNull(req.getParameter("pkgServiceLimitBy"));//Added V190617-Aravindh/MMS-DM-CRF-0129.1
		String dailyPkgLimitYN = checkForNull(req.getParameter("dailyPkgLimitChk"));//Added V190617-Aravindh/MMS-DM-CRF-0129.1
		if("on".equals(dailyPkgLimitYN)) {
			dailyPkgLimitYN = "Y";
		} else {
			dailyPkgLimitYN = "N";
		}
		String dailyPkgLimitBy = checkForNull(req.getParameter("dailyPkgLimitSlct"));//Added V190617-Aravindh/MMS-DM-CRF-0129.1

		//Added against V200612-MuthuN/MMS-QH-CRF-0128.1-US001 & US004 Starts		
		String pkgCustDiscNewPkgYN = checkForNull(req.getParameter("pkgCustDiscNewPkgYN"));
		String pkgCustDiscByPlcyYN = checkForNull(req.getParameter("pkgCustDiscByPlcyYN"));
		//Added against V200612-MuthuN/MMS-QH-CRF-0128.1-US001 & US004 Ends		
		
		//28.08.2020 changes 
		String PkgLimitIndBy = checkForNull(req.getParameter("currPkgLimitIndSlct")); //MMS-QH-CRF-0170-US-5  PALANINARAYANAN 1/7/2020

		//V201103 Starts
		String autoDistPkgVarServiceOPYN = checkForNull(req.getParameter("autoDistPkgVarServiceOPYN"));
		String autoDistPkgVarPharMedItemsOPYN = checkForNull(req.getParameter("autoDistPkgVarPharMedItemsOPYN"));
		String autoDistPkgVarServiceIPYN = checkForNull(req.getParameter("autoDistPkgVarServiceIPYN"));
		String autoDistPkgVarPharMedItemsIPYN = checkForNull(req.getParameter("autoDistPkgVarPharMedItemsIPYN"));
		//V201103 Starts
		//Added for NMC-JD-CRF-0084 Starts palani narayanan V210128
		String prevpkgDepositYN = checkForNull(req.getParameter("prevpkgDepositYN"));
		
		tabdata.put("FACILITY_ID",facilityId);
		tabdata.put("pkgStatus",pkgStatus);
		tabdata.put("pkgBkDateD",pkgBkDateD);
		tabdata.put("glSmryYN",glSmryYN);
		tabdata.put("valdDForOrd",valdDForOrd);
		tabdata.put("autoRefundYN",autoRefundYN);
		tabdata.put("valdRefundD",valdRefundD);
		tabdata.put("unAvaldSrvCode",unAvaldSrvCode);
		tabdata.put("pat_dep_for_pkg_code",pat_dep_for_pkg_code);
		tabdata.put("pkgServiceLimitBy", pkgServiceLimitBy);//Added V190617-Aravindh/MMS-DM-CRF-0129.1
		tabdata.put("dailyPkgLimitYN", dailyPkgLimitYN);//Added V190617-Aravindh/MMS-DM-CRF-0129.1
		tabdata.put("dailyPkgLimitBy", dailyPkgLimitBy);//Added V190617-Aravindh/MMS-DM-CRF-0129.1
		//Added against V200612-MuthuN/MMS-QH-CRF-0128.1-US001 & US004 Starts
		tabdata.put("pkgCustDiscNewPkgYN",pkgCustDiscNewPkgYN);
		tabdata.put("pkgCustDiscByPlcyYN",pkgCustDiscByPlcyYN);
		//Added against V200612-MuthuN/MMS-QH-CRF-0128.1-US001 & US004 Ends		
		tabdata.put("PkgLimitIndBy", PkgLimitIndBy); //MMS-QH-CRF-0170-US-5  PALANINARAYANAN 1/7/2020
		//V201103 Starts
		tabdata.put("autoDistPkgVarServiceOPYN",autoDistPkgVarServiceOPYN);
		tabdata.put("autoDistPkgVarPharMedItemsOPYN",autoDistPkgVarPharMedItemsOPYN);
		tabdata.put("autoDistPkgVarServiceIPYN",autoDistPkgVarServiceIPYN);
		tabdata.put("autoDistPkgVarPharMedItemsIPYN",autoDistPkgVarPharMedItemsIPYN);
		//Added for NMC-JD-CRF-0084 Starts palani narayanan V210128
		tabdata.put("prevpkgDepositYN",prevpkgDepositYN);
		//V201103 Starts
		return tabdata;
	}	

	private void modifyData(HttpServletRequest req,HttpServletResponse res)
	{
		try 
		{	
			tabdata=new HashMap();
			tabdata = populateTabData(req,res);
			boolean local_ejbs = false;
			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") != null) && (getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;
			Object home =ServiceLocator.getInstance().getHome("java:comp/env/PkgParameters",eBL.PkgParameters.PkgParametersHome.class, local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home, null);
			Object argArray[] = new Object[2];
			argArray[0] = p;
			argArray[1] = tabdata;
			Class[] paramArray = new Class[2];
			paramArray[0] = p.getClass();
			paramArray[1] = tabdata.getClass();		
			java.util.HashMap results = (java.util.HashMap) (busObj.getClass().getMethod("modify", paramArray)).invoke(busObj, argArray);	
			(busObj.getClass().getMethod("remove", null)).invoke(busObj, null);
			boolean inserted = (((Boolean) results.get("status")).booleanValue());
			String error = results.get("error").toString();
			String error_value="0";
			if(inserted)
			{
				error_value = "1" ;		
				Hashtable messageHashtable=new Hashtable();
				messageHashtable=MessageManager.getMessage(locale,"RECORD_INSERTED","SM");
				String success_msg=(String)messageHashtable.get("message");
				res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode( success_msg,"UTF-8" ) +"&err_value="+error_value);
			}
			else if(!error.equals(""))
			{		
					res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8" ) +"&err_value="+error_value);
			}	 
		} 
		catch (Exception e) 
		{
			//con.rollback();
			System.out.println("exception in main=" + e.toString());
			e.printStackTrace();
			out.println("<h3> Exception raise by Servlet ...So Record Not inserted </h3> Foll: Error Received : "+ e.toString());
			out.println("Values sent are : <br>");
		}
	}

	private String checkForNull(String str){
		return (str!=null && str.intern()!="null")?str:"";
	}

	private String checkForNull(String str,String defaultVal){
		return (!checkForNull(str).equals(""))?str:defaultVal;
	}

	private boolean isLocalEJB(){
		ServletContext servletcontext = getServletConfig().getServletContext();
		if ((servletcontext.getInitParameter("LOCAL_EJBS")!=null) &&(servletcontext.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) 
			return true;
			return false;
	}
}
