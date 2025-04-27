/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
//This file is saved on 18/10/2005.


/*
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eCP
*	Purpose 		:	
*	Created By		:	Venkatasubbu PR
*	Created On		:	21 Feb 2005
*/

package eCP;

import java.io.*;
import java.sql.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
//import javax.naming.*;
//import javax.rmi.*;
import java.net.*;
import webbeans.eCommon.*;
import eCP.AssignCareManager.*;

public class AssignCareManagerServlet extends javax.servlet.http.HttpServlet 
{
	PrintWriter out;
	java.util.Properties m_CurProperties;

	String m_strMDCPId		= "";
	String m_strCPId		= "";
	String m_strPatientId	= "";
	String m_strCPMgrId		= "";
	String m_strCPMgrFrom	= "";
	String m_strCPMgrUpto	= "";
	String m_strFacilityId	= "";
	String m_strAddedById	= "";
	String m_strAddedAtWsNo = "";
	String m_strClientIpAdd = "";
	String locale="";
	HttpSession session;
	
	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	}

	public  void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException	
	{
		session = req.getSession(false);
		this.m_CurProperties = (java.util.Properties) session.getAttribute( "jdbc" ) ;
		this.m_strFacilityId = (String) session.getAttribute( "facility_id" ) ;
		m_strClientIpAdd = m_CurProperties.getProperty("client_ip_address");
		
		try
		{
			res.setContentType("text/html;charset=UTF-8");
			req.setCharacterEncoding("UTF-8");
			this.out = res.getWriter();
			AddModify(req,res);
		}
		catch(Exception e)	
		{
			out.println(e.toString());
		}
	}

	public void doGet(HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
 		try
		{
			this.out = res.getWriter();
			res.setContentType("text/html");
		
		}
		catch(Exception e)	
		{	
			out.println(e.toString());
		}
	}


	private void AddModify(HttpServletRequest req, HttpServletResponse res)
	{
		try
		{
			m_strFacilityId		= (String)session.getAttribute("facility_id");
			locale=(String)session.getAttribute("LOCALE");
			m_strAddedById 		= m_CurProperties.getProperty( "login_user" ) ;
			m_strAddedAtWsNo	= m_strClientIpAdd;
            
			HashMap tabData	=	new HashMap();
			
			m_strMDCPId		=	req.getParameter("mdcp_id");
			m_strCPId		=	req.getParameter("cp_id");
			m_strPatientId	=	req.getParameter("patient_id");
			m_strCPMgrId	=	req.getParameter("assign_cpmgr_id");
			System.err.println(req.getParameter("cm_frdate"));
			m_strCPMgrFrom	=	com.ehis.util.DateUtils.convertDate(req.getParameter("cm_frdate"),"DMYHM",locale,"en");
			System.err.println(m_strCPMgrFrom);
			m_strCPMgrUpto	=	"";


			tabData.put("MD_CARE_PLAN_ID",m_strMDCPId);
			tabData.put("CARE_PLAN_ID",m_strCPId);
			tabData.put("CARE_MANAGER_ID",m_strCPMgrId);
			tabData.put("PATIENT_ID",m_strPatientId);
			tabData.put("EFF_DATE_FROM",m_strCPMgrFrom);
			tabData.put("EFF_DATE_TO",m_strCPMgrUpto);
			tabData.put("ADDED_BY_ID",m_strAddedById);
			tabData.put("ADDED_AT_WS_NO",m_strAddedAtWsNo);
			tabData.put("ADDED_FACILITY_ID",m_strFacilityId);
			tabData.put("locale",locale);
			tabData.put("properties",m_CurProperties);
			
			// Accessing EJB
			/*AssignCareManagerHome	acmHome = null;
			AssignCareManagerRemote acmRemote = null;

			InitialContext context = new InitialContext() ;

			Object object = context.lookup("java:comp/env/AssignCareManager");
			acmHome =  (AssignCareManagerHome) PortableRemoteObject.narrow(object ,AssignCareManagerHome.class);
			acmRemote = acmHome.create() ;

			HashMap mapResult = acmRemote.AddModify(tabData) ;*/

				boolean local_ejbs = false;
				ServletContext context = getServletConfig().getServletContext();
				if ((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) 
				local_ejbs = true;
				Object obj = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/AssignCareManager", eCP.AssignCareManager.AssignCareManagerHome.class, local_ejbs);
				Object obj1 = obj.getClass().getMethod("create", null).invoke(obj, null);
				Object aobj[] = new Object[1];
				aobj[0] = tabData;
				Class aclass[] = new Class[1];
				aclass[0] = tabData.getClass();
				HashMap mapResult = (HashMap)obj1.getClass().getMethod("AddModify", aclass).invoke(obj1, aobj);
				obj1.getClass().getMethod("remove", null).invoke(obj1, null);

			String strErrNum	= "";
			String strErrValue	= "";

			strErrValue="0";

			strErrNum=(String)mapResult.get("message");
			res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num="+strErrNum+"&err_value="+strErrValue);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}		
	}
}

