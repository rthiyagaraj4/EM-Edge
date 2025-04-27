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
import eBL.PkgAdhocDiscountBean.*;

public class PkgAdhocDiscountServlet extends javax.servlet.http.HttpServlet
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
		//System.out.println("inside adhoc  servlet");
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
		//System.out.println("tabdata servlet 1");
		String bean_id		= "bl_PkgAdhocDiscountBean" ;
		String bean_name	= "eBL.PkgAdhocDiscountBean";
		PkgAdhocDiscountBean bean	= (PkgAdhocDiscountBean)PersistenceHelper.getBeanObject( bean_id, bean_name, req ) ;
		String patientId = checkForNull(req.getParameter("patientId"));
		HashMap adhocDiscountDtls = bean.getAdhocDiscountDtls();
		ArrayList packageSeqNoList	= bean.getPackageSeqNoList();
		String called_from=req.getParameter("called_from");
		if ((called_from == null) ||(called_from.equals("")) ) called_from="";
		//System.out.println("called_from servlet: "+called_from);
		
		//Added V171219-Gayathri/65499
		String episode_type=req.getParameter("episode_type");
		if ((episode_type == null) ||(episode_type.equals("")) ) episode_type="";

		String episode_id=req.getParameter("episode_id");
		if ((episode_id == null) ||(episode_id.equals("")) ) episode_id="";

		String visit_id=req.getParameter("visit_id");
		if ((visit_id == null) ||(visit_id.equals("")) ) visit_id="";

		String blnggrp=req.getParameter("blnggrp");
		if ((blnggrp == null) ||(blnggrp.equals("")) ) blnggrp="";

		String billdoctype=req.getParameter("billdoctype");
		if ((billdoctype == null) ||(billdoctype.equals("")) ) billdoctype="";

		String billdocnum=req.getParameter("billdocnum");
		if ((billdocnum == null) ||(billdocnum.equals("")) ) billdocnum="";

		tabdata.put("FACILITY_ID",facilityId);
		tabdata.put("patientId",patientId);
		tabdata.put("packageSeqNoList",packageSeqNoList);
		tabdata.put("adhocDiscountDtls",adhocDiscountDtls);
		tabdata.put("client_ip_address",client_ip_address);
		tabdata.put("login_user",login_user);
		tabdata.put("called_from",called_from);
		//Added V171219-Gayathri/65499
		tabdata.put("episode_type",episode_type);
		tabdata.put("episode_id",episode_id);
		tabdata.put("visit_id",visit_id);
		tabdata.put("blnggrp",blnggrp);
		tabdata.put("billdoctype",billdoctype);
		tabdata.put("billdocnum",billdocnum);
		//System.out.println("tabdata servlet 2 "+tabdata);
		return tabdata;
	}

private void modifyData(HttpServletRequest req,HttpServletResponse res)
{
		try 
		{	
			//System.out.println("tabdata servlet 3");
			tabdata=new HashMap();
			
			tabdata = populateTabData(req,res);
			String called_from=req.getParameter("called_from");
			if ((called_from == null) ||(called_from.equals("")) ) called_from="";
			//System.out.println("called_from servlet1: "+called_from);
			boolean local_ejbs = false;
			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") != null) && (getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE")))
				local_ejbs = true;
			Object home =ServiceLocator.getInstance().getHome("java:comp/env/PkgAdhocDiscount",eBL.PkgAdhocDiscount.PkgAdhocDiscountHome.class, local_ejbs);
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
			//System.out.println("145 Error Value "+error);//muthu
			if(inserted)
			{
				System.out.println("Inserted successfully in PkgAdhocDiscountServlet.java");//muthu
				error_value = "1" ;		
				Hashtable messageHashtable=new Hashtable();
				messageHashtable=MessageManager.getMessage(locale,"RECORD_INSERTED","SM");
				String success_msg=(String)messageHashtable.get("message");
				if(called_from.equals("VISITREG")){
					System.out.println("153 in PkgAdhocDiscountServlet.java");//muthu
					//out.println("<script>alert('Tested by Muthu');parent.window.close();</script>");//muthu
					out.println("<script>alert('"+success_msg+"');parent.window.close();</script>");
				}else{
				System.out.println("156 PkgAdhocDiscountServlet.java ");//muthu
				res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode( success_msg,"UTF-8" ) +"&err_value="+error_value);				
				}				
			}			
			else if(!error.equals(""))
			{
				System.out.println("162 in PkgAdhocDiscountServlet.java");//muthu
				if(called_from.equals("VISITREG")){
					System.out.println("164 PkgAdhocDiscountServlet.java");//muthu
					out.println("<script>alert('"+error+"');parent.window.close();</script>");
				}else{
					System.out.println("167 in PkgAdhocDiscountServlet.java");//muthu
					res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8" ) +"&err_value="+error_value);
				}
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
