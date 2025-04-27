/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
//This file is saved on 18/10/2005.


package eCP;

import java.io.*;
import java.sql.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.naming.*;
//import javax.rmi.*;
//import java.net.*;
import webbeans.eCommon.*;
import eCP.BuildLibrary.*;

public class  BuildLibraryServlet extends HttpServlet 
{
	PrintWriter out;
	java.util.Properties prop;

	HttpSession session;
	//private ServletConfig config	=		null;

	String libraryid				=		"";
	String versionno				=		"";
	ArrayList TermCodeList			=		null;

	HashMap TabData				=		new HashMap();
	HashMap HeaderValue    			=		new HashMap();

	String added_by_id				=		"";
	String added_at_ws_no			=       "";
	String added_facility_id		=		"";
	String client_ip_address		=		"";
	
	public void init(ServletConfig config)throws ServletException{

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
				
		try{
				response.setContentType("text/html");
				this.out = response.getWriter();
				 insert(request,response);
			}
		catch(Exception e){
			e.printStackTrace();
			
		}

		}//end of doPost()

		public  void doGet(HttpServletResponse response) throws javax.servlet.ServletException,IOException{
	try{
		this.out = response.getWriter();
		response.setContentType("text/html");

		}
	catch(Exception e){
		e.printStackTrace();	
	}
}//end of doGet()
private void insert(HttpServletRequest request,HttpServletResponse response){
	try{
			RecordSet	CPBuildLibrary	=	null;
			CPBuildLibrary	=	(webbeans.eCommon.RecordSet)	session.getAttribute("BuildLibrary");
			TermCodeList=(ArrayList)CPBuildLibrary.getObject(0);
			String locale=(String)session.getAttribute("LOCALE");
			libraryid	=	 request.getParameter("libraryid")==null?"":request.getParameter("libraryid"); 
			versionno				=	 request.getParameter("versionno")==null?"":request.getParameter("versionno"); 
			added_by_id				=	 (prop.getProperty("login_user")==null)?"":prop.getProperty("login_user");
			added_facility_id		=	 (this.added_facility_id == null)?"":this.added_facility_id; 
			added_at_ws_no		=	 (client_ip_address == null)?"":client_ip_address; 

			HeaderValue.put("LIBRARYID",libraryid);
			HeaderValue.put("VERSIONNO",versionno);
			HeaderValue.put("ADDED_BY_ID",added_by_id);
			HeaderValue.put("ADDED_FCY_ID",added_facility_id);
			HeaderValue.put("ADDED_AT_WS_NO",added_at_ws_no);
			HeaderValue.put("locale",locale);
			
			TabData.put("HV",HeaderValue);
			TabData.put("TC",TermCodeList);

			/*InitialContext context			=		new InitialContext();
			Object homeObject				=		context.lookup("java:comp/env/BuildLibrary");
			BuildLibraryHome home			=		(BuildLibraryHome) PortableRemoteObject.narrow(homeObject ,BuildLibraryHome.class);
			BuildLibraryRemote remote		=		home.create();
			results									=		remote.AddModify(prop,TabData) ;*/
			
				boolean local_ejbs = false;
				ServletContext context = getServletConfig().getServletContext();
				if ((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) 
				local_ejbs = true;
				Object obj = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/BuildLibrary", eCP.BuildLibrary.BuildLibraryHome.class, local_ejbs);
				Object obj1 = obj.getClass().getMethod("create", null).invoke(obj, null);
				Object aobj[] = new Object[2];
				aobj[0] = prop;
				aobj[1] = TabData;
				Class aclass[] = new Class[2];
				aclass[0] = prop.getClass();
				aclass[1] = TabData.getClass();
				HashMap results = (HashMap)obj1.getClass().getMethod("AddModify", aclass).invoke(obj1, aobj);
				obj1.getClass().getMethod("remove", null).invoke(obj1, null);
			boolean inserted						=		( ((Boolean) results.get( "status" )).booleanValue() ) ;
			String error							=		(String) results.get("error") ;
			String error_value					=		"0" ;

				if ( inserted ) error_value = "1" ;
				response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error ,"UTF-8") + "&err_value=" + error_value );

		}
		catch(Exception e){
			out.println("<h3> Exception raised by Servlet ...So Record Not inserted </h3> Foll: Error Received : "+e.toString());
			System.err.println(e.toString());
			e.printStackTrace();
		}finally{
			session.removeAttribute("BuildLibrary");
		}
	}
}
