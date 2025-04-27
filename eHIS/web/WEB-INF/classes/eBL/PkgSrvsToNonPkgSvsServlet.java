/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
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
import java.util.StringTokenizer;
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
import eBL.PkgSrvsToNonPkgSvsBean.*;

public class PkgSrvsToNonPkgSvsServlet extends javax.servlet.http.HttpServlet
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
			out.println(e.toString());
		}
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException{
		doPost(req,res);
	}

	private HashMap populateTabData(HttpServletRequest req, HttpServletResponse res)
	{
		String bean_id		= "bl_PkgSrvsToNonPkgSvsBean" ;
		String bean_name	= "eBL.PkgSrvsToNonPkgSvsBean";
		PkgSrvsToNonPkgSvsBean bean	= (PkgSrvsToNonPkgSvsBean)PersistenceHelper.getBeanObject( bean_id, bean_name, req ) ;
		String patientId = checkForNull(req.getParameter("patientId"));
		HashMap srvsToNonPkgSvsDtls = bean.getSrvsToNonPkgSvsDtls();
		ArrayList packageSeqNoList	= bean.getPackageSeqNoList();
		tabdata.put("FACILITY_ID",facilityId);
		tabdata.put("patientId",patientId);
		tabdata.put("packageSeqNoList",packageSeqNoList);
		tabdata.put("srvsToNonPkgSvsDtls",srvsToNonPkgSvsDtls);
		tabdata.put("client_ip_address",client_ip_address);
		tabdata.put("login_user",login_user);
		return tabdata;
	}

private void modifyData(HttpServletRequest req,HttpServletResponse res)
{
		try 
		{	
			tabdata=new HashMap();
			//java.util.Locale loc = new java.util.Locale(locale);//unused variable
			tabdata = populateTabData(req,res);
			boolean local_ejbs = false;
			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") != null) && (getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE")))
				local_ejbs = true;
			Object home =ServiceLocator.getInstance().getHome("java:comp/env/PkgSrvsToNonPkgSvs",eBL.PkgSrvsToNonPkgSvs.PkgSrvsToNonPkgSvsHome.class, local_ejbs);
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
			out.println("<h3> Exception raise by Servlet ...So Record Not inserted </h3> Foll: Error Received : "
							+ e.toString() );
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
