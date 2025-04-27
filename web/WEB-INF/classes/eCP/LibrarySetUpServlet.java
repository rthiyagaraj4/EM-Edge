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
-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

?             100            ?               created
05/12/2012    IN034470      Karthi L		When creating new library setup, age groups not created completely and query back the same data not displaying respective checkboxs
-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
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
import eCP.LibrarySetup.*;

public class  LibrarySetUpServlet extends HttpServlet 
{
	PrintWriter out;
	java.util.Properties prop;

	HttpSession session;
	//private ServletConfig config	=	null;
		
	String library_id		=		"";
	String short_desc		=		"";
	String long_desc		=		"";
	String eff_status_yn	=		"";
	String version_remarks	=		"";
	String Status			=		"";
	String dependency_level	=		"";
	String libraryBasis		=		"";
	String version_no		=		"";
	String patientchk		=		"";
	String agegrp			=		"";
	String mode				=		"";
	String added_by_id		=		"";
	
	String added_at_ws_no	=       "";
	String added_facility_id=		"";
	String client_ip_address=		"";
	String total_age_grp_recs =		""; //added for IN034470
	String total_pat_cls_recs =		""; //added for IN034470

	HashMap TabData			 =		new HashMap();
	HashMap LibrarySetUpValues =		new HashMap();
	ArrayList PatientClass		 =		new ArrayList();
	ArrayList AgeGrpList		 =		new ArrayList();
	
	public void init(ServletConfig config)throws ServletException{

		super.init(config);
		
	}

//end of init()
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
		catch(Exception e)
		{
			e.printStackTrace();	
		}

		}//end of doPost()

		public  void doGet(HttpServletResponse response) throws javax.servlet.ServletException,IOException{
	try{
		this.out = response.getWriter();
		response.setContentType("text/html");

		}
	catch(Exception e)
	{
	e.printStackTrace();
	}
}//end of doGet()

private void insert(HttpServletRequest request,HttpServletResponse response){
	try{
		
			added_by_id			=	 (prop.getProperty("login_user")==null)?"":prop.getProperty("login_user");
			added_facility_id	=	 (this.added_facility_id == null)?"":this.added_facility_id; 
			added_at_ws_no		=	 (client_ip_address == null)?"":client_ip_address; 

			library_id			=	 request.getParameter("library_id")==null?"":request.getParameter("library_id"); 
			short_desc			=	 request.getParameter("short_desc")==null?"":request.getParameter("short_desc"); 
			long_desc			=	 request.getParameter("long_desc")==null?"":request.getParameter("long_desc"); 
			eff_status_yn		=	 request.getParameter("eff_status_yn")==null?"":request.getParameter("eff_status_yn"); 
			version_remarks		=	 request.getParameter("version_remarks")==null?"":request.getParameter("version_remarks"); 
			Status				=	 request.getParameter("Status")==null?"":request.getParameter("Status"); 
			dependency_level	=	 request.getParameter("dependency_level")==null?"":request.getParameter("dependency_level"); 
			libraryBasis		=	 request.getParameter("libraryBasis")==null?"":request.getParameter("libraryBasis"); 
			version_no			=	 request.getParameter("version_no")==null?"":request.getParameter("version_no"); 
			mode				=	 request.getParameter("mode")==null?"":request.getParameter("mode"); 
			total_pat_cls_recs	=	 request.getParameter("totPatClsRecords")==null?"":request.getParameter("totPatClsRecords");	// added by IN034470 -- START
			total_age_grp_recs	=	 request.getParameter("totAgeGrpRecords")==null?"":request.getParameter("totAgeGrpRecords");
 	
									 
			int agegrprecs		= 0;
			int patclsrecs		= 0;
			if(total_pat_cls_recs != null && total_pat_cls_recs != "") {
				patclsrecs		=	 Integer.parseInt(total_pat_cls_recs);
			}
			if(total_age_grp_recs != null && total_age_grp_recs != "") {
				agegrprecs		=	 Integer.parseInt(total_age_grp_recs);
			}
			for(int i=0;i<6;i++){
				patientchk=request.getParameter("patientchk_"+i)==null?"":request.getParameter("patientchk_"+i);
				if(!(patientchk.equals(""))){
					PatientClass.add(patientchk);
				}
			}

			for(int i=0;i<=agegrprecs;i++){ //agegrprecs added by IN034470
				agegrp=request.getParameter("AgeGrpChk"+i)==null?"":request.getParameter("AgeGrpChk"+i);
				if(!(agegrp.equals(""))){
					AgeGrpList.add(agegrp);
				}
			}
		String locale=(String)session.getAttribute("LOCALE");
		LibrarySetUpValues.put("LIBRARY_ID",library_id);
		LibrarySetUpValues.put("LONG_DESC",long_desc);
		LibrarySetUpValues.put("SHORT_DESC",short_desc);
        LibrarySetUpValues.put("EFF_STATUS",eff_status_yn);
        LibrarySetUpValues.put("VERSION_REMARKS",version_remarks);
        LibrarySetUpValues.put("STATUS",Status);
        LibrarySetUpValues.put("DEPENDENCY_LEVEL",dependency_level);
        LibrarySetUpValues.put("LIBRARY_BASIS",libraryBasis);
		LibrarySetUpValues.put("VERSION_NO",version_no);
		LibrarySetUpValues.put("MODE",mode);
		LibrarySetUpValues.put("ADDED_BY_ID",added_by_id);
        LibrarySetUpValues.put("ADDED_AT_WS_NO",added_at_ws_no);
        LibrarySetUpValues.put("ADDED_FACILITY_ID",added_facility_id);
        LibrarySetUpValues.put("locale",locale);
		
        
		TabData.clear();
		TabData.put("VD",LibrarySetUpValues);
		TabData.put("PC",PatientClass);
		TabData.put("AG",AgeGrpList);
				boolean local_ejbs = false;
				ServletContext context = getServletConfig().getServletContext();
				if ((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) 
				local_ejbs = true;
				Object obj = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/LibrarySetup", eCP.LibrarySetup.LibrarySetupHome.class, local_ejbs);
				Object obj1 = obj.getClass().getMethod("create", null).invoke(obj, null);
				Object aobj[] = new Object[2];
				aobj[0] = prop;
				aobj[1] = TabData;
				Class aclass[] = new Class[2];
				aclass[0] = prop.getClass();
				aclass[1] = TabData.getClass();
				HashMap results = (HashMap)obj1.getClass().getMethod("AddModify", aclass).invoke(obj1, aobj);
				obj1.getClass().getMethod("remove", null).invoke(obj1, null);
		boolean inserted			=		( ((Boolean) results.get( "status" )).booleanValue() ) ;
		String error				=		(String) results.get("error") ;
		String error_value			=		"0" ;

				if ( inserted ) error_value = "1" ;
				response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error ,"UTF-8") + "&err_value=" + error_value );

			PatientClass.clear();
			AgeGrpList.clear();
			LibrarySetUpValues.clear();
			TabData.clear();
			results.clear();
				

		}
		catch(Exception e){
		out.println("<h3> Exception raised by Servlet ...So Record Not inserted </h3> Foll: Error Received : "+e.toString());
		System.err.println(e.toString());
		e.printStackTrace();
	}//end of catch
}//end of insert
}
