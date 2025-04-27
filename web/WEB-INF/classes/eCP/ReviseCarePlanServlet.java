/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
//This file is saved on 12/01/2006.

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
import eCP.ReviseCarePlan.*;

public class ReviseCarePlanServlet extends HttpServlet
{ 
	PrintWriter out;
	java.util.Properties prop;

	HttpSession session;
	//private ServletConfig config		 =		null;
	String care_plan_id					 =		"";
	String md_care_plan_id				 =		"";
	String patient_id					 =		"";
	long encounter_id		= 0;
	String care_mgr_id					 =		"";

	ArrayList Diagnosis					 =		null;
	HashMap Intvn						 =		null;
	HashMap HeaderValue    				 =		new HashMap();

	HashMap results						 =		new HashMap();
	HashMap TabData						 =		new HashMap();

	String added_by_id					 =		"";
	String added_at_ws_no				 =     "";
	String added_facility_id			 =		"";
	String client_ip_address			 =		"";
	String locale="";
	
	public void init(ServletConfig config)throws ServletException
	{
		super.init(config);
		
	}
	public  void doPost(HttpServletRequest request, HttpServletResponse response)throws javax.servlet.ServletException,IOException
	{
		this.out			=	response.getWriter();
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");

		session = request.getSession(false);

		this.prop					=		(java.util.Properties)session.getAttribute("jdbc");
		this.added_facility_id =		(String)session.getAttribute("facility_id");

		client_ip_address		=		this.prop.getProperty("client_ip_address");

		
		try
		{
			response.setContentType("text/html");
			this.out = response.getWriter();
			insert(request,response);
		}
		catch(Exception e){
			e.printStackTrace();
		}

	}//end of doPost()

	public  void doGet(HttpServletResponse response) throws javax.servlet.ServletException,IOException
	{
		try
		{
			this.out = response.getWriter();
			response.setContentType("text/html");
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}//end of doGet()


	private void insert(HttpServletRequest request,HttpServletResponse response)
	{
		try
		{
			locale			= (String)session.getAttribute("LOCALE");
			RecordSet	CPReviseCarePlan	=	null;
			CPReviseCarePlan	=	(webbeans.eCommon.RecordSet)session.getAttribute("ReviseCarePlan");
			Diagnosis=(ArrayList)CPReviseCarePlan.getObject(0);

			RecordSet	CPReviseCarePlanRecordchanges	=	null;
			CPReviseCarePlanRecordchanges	=	(webbeans.eCommon.RecordSet)session.getAttribute("ReviseCarePlanRecordchanges");
			Intvn=(HashMap)CPReviseCarePlanRecordchanges.getObject(0);
			

			md_care_plan_id		=	 request.getParameter("md_care_plan_id")==null?"":request.getParameter("md_care_plan_id"); 
			care_plan_id		=	 request.getParameter("care_plan_id")==null?"":request.getParameter("care_plan_id"); 
			patient_id			=	 request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
			encounter_id		=	 request.getParameter("encounter_id") == null ? 0 :  Long.parseLong(request.getParameter("encounter_id"));
			care_mgr_id			=	 request.getParameter("care_mgr_id")==null?"":request.getParameter("care_mgr_id");
			added_by_id			=	 (prop.getProperty("login_user")==null)?"":prop.getProperty("login_user");
			added_facility_id	=	 (this.added_facility_id == null)?"":this.added_facility_id; 
			added_at_ws_no		=	 (client_ip_address == null)?"":client_ip_address; 

			HeaderValue.put("MD_CARE_PLAN_ID",md_care_plan_id);
			HeaderValue.put("CARE_PLAN_ID",care_plan_id);
			HeaderValue.put("PATIENT_ID",patient_id);
			HeaderValue.put("ENCOUNTER_ID",new Long(encounter_id));
			HeaderValue.put("CARE_MGR_ID",care_mgr_id);
			HeaderValue.put("ADDED_BY_ID",added_by_id);
			HeaderValue.put("ADDED_FCY_ID",added_facility_id);
			HeaderValue.put("ADDED_AT_WS_NO",added_at_ws_no);
			HeaderValue.put("locale",locale);

			TabData.put("HV",HeaderValue);
			TabData.put("DIAGNOSIS",Diagnosis);
			TabData.put("INTVN",Intvn);
			
			
			/*InitialContext context			=		new InitialContext();
			Object homeObject				=		context.lookup("java:comp/env/ReviseCarePlan");
			ReviseCarePlanHome home			=		(ReviseCarePlanHome) PortableRemoteObject.narrow(homeObject ,ReviseCarePlanHome.class);
			ReviseCarePlanRemote remote		=		home.create();
			results							=		remote.AddModify(prop,TabData) ;*/

			boolean local_ejbs = false;
				ServletContext context = getServletConfig().getServletContext();
				if ((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) 
				local_ejbs = true;
				Object obj = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/ReviseCarePlan", eCP.ReviseCarePlan.ReviseCarePlanHome.class, local_ejbs);
				Object obj1 = obj.getClass().getMethod("create", null).invoke(obj, null);
				Object aobj[] = new Object[2];
				aobj[0] = prop;
				aobj[1] = TabData;
				Class aclass[] = new Class[2];
				aclass[0] = prop.getClass();
				aclass[1] = TabData.getClass();
				results = (HashMap)obj1.getClass().getMethod("AddModify", aclass).invoke(obj1, aobj);
				obj1.getClass().getMethod("remove", null).invoke(obj1, null);

			boolean inserted				=		(((Boolean) results.get( "status" )).booleanValue() ) ;
			String error					=		(String) results.get("error") ;
			int i=error.lastIndexOf(".");
            error=error.substring(0,i+1);
			String error_value				=		"0" ;
			
			if ( inserted ){ 
				error_value = "1" ;
				out.println("<script src='../eCommon/js/showModalDialog.js' language='JavaScript'></script>");
				out.println("<script>alert('"+error+"')</script>");
				out.println("<script>window.returnValue='SUCCESS'</script>");
				out.println("<script>window.close();</script>");
			}else{
				response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8" ) + "&err_value=" + error_value );
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}//end of catch
		finally
		{
			session.removeAttribute("ReviseCarePlan");
			session.removeAttribute("ReviseCarePlanRecordchanges");
		}
		
	}
	
}
