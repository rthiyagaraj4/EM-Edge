/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
//This file is saved on 19/11/2005.

package eCP ;

import java.sql.* ;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

//import javax.naming.*;
//import javax.rmi.*;
import webbeans.eCommon.*;
import eCP.PatientAssessment.*;

public class PatientAssessmentServlet extends HttpServlet 
{
	HttpSession	 session	=	null;
    java.io.PrintWriter	 out =	null;
    java.util.Properties p = null;
	String locale="";
	public void init(ServletConfig cfg) throws ServletException
	{
		super.init(cfg);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, java.io.IOException
    {
        session = request.getSession(true) ;
        out = response.getWriter() ;
		locale			= (String)session.getAttribute("LOCALE");
		String mode = request.getParameter("mode") == null ? "" : request.getParameter("mode");
        try
        {
			p = (java.util.Properties)session.getAttribute("jdbc") ;

			if(!mode.equals("modify"))
			{
				insertPatientAssessment(request,response);
			}
			else if(mode.equals("modify"))
			{
				updatePatientAssessment(request,response);
			}
			
		}
		catch(Exception e)
		{
			out.println("Exception at doPost of Servlet:1 : "+e.toString());
		}
    }


	private void insertPatientAssessment(HttpServletRequest request, HttpServletResponse response) throws ServletException, java.io.IOException
	{
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		try
        {
			session	=	request.getSession(false);
			
			eCP.PatientAssessmentDiag diagBean = (eCP.PatientAssessmentDiag) session.getAttribute("diagBean");

			HashMap assessMap = new HashMap();
			HashMap results = new HashMap();			
			
			String login_user_id		=	(String) session.getAttribute("login_user");
			String facility_id			=	(String) session.getAttribute("facility_id");
			String patient_id			=	request.getParameter("pat_id");
			String encounter_id			=	request.getParameter("enc_id");
			String assess_pract_id		=	(String) session.getAttribute("ca_practitioner_id");
			String accession_no			=	request.getParameter("accession_num");
			String assess_ref_no			=	request.getParameter("assess_ref_no");
			String added_at_ws_no = request.getRemoteAddr();

			String status = request.getParameter("status") == null? "" : request.getParameter("status");
			String status_flag = request.getParameter("status_flag") == null? "" : request.getParameter("status_flag");
			String abnormal_categ = request.getParameter("abnormal_categ") == null? "" : request.getParameter("abnormal_categ");
			String chk_val_hid = request.getParameter("chk_val_hid") == null? "" : request.getParameter("chk_val_hid");
			String ua_dep_code = request.getParameter("assessDependency") == null? "" : request.getParameter("assessDependency");
			String ss_dep_code = request.getParameter("dependency_ss") == null? "" : request.getParameter("dependency_ss");

			boolean inserted = true;
			String error_value = "";
			String message = "";
			
				try
				{
					ArrayList diagList = diagBean.getKeySet();

					assessMap.put("patient_id",patient_id);
					assessMap.put("login_user_id",login_user_id);
					assessMap.put("status",status);
					assessMap.put("status_flag",status_flag);
					assessMap.put("abnormal_categ",abnormal_categ);
					assessMap.put("ua_dep_code",ua_dep_code);
					assessMap.put("ss_dep_code",ss_dep_code);
					assessMap.put("chk_val_hid",chk_val_hid);
					assessMap.put("facility_id",facility_id);
					assessMap.put("encounter_id",encounter_id);
					assessMap.put("accession_no",accession_no);
					assessMap.put("assess_ref_no",assess_ref_no);
					assessMap.put("assess_pract_id",assess_pract_id);					
					assessMap.put("added_by_id",login_user_id);
					assessMap.put("added_at_ws_no",added_at_ws_no);
					assessMap.put("added_by_facility_id",facility_id);
					assessMap.put("modified_by_id",login_user_id);
					assessMap.put("modified_at_ws_no",added_at_ws_no);
					assessMap.put("modified_by_facility_id",facility_id);
					assessMap.put("locale",locale);
					/*InitialContext context = new InitialContext();
					Object homeObject = context.lookup("java:comp/env/PatientAssessment");
					PatientAssessmentHome patAssessmentHome  = (PatientAssessmentHome) PortableRemoteObject.narrow(homeObject ,PatientAssessmentHome.class);
					PatientAssessmentRemote patAssessmentRemote = patAssessmentHome.create();
					results = patAssessmentRemote.insertPatientAssessment(p,assessMap,diagList);*/

				boolean local_ejbs = false;
				ServletContext context = getServletConfig().getServletContext();
				if ((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) 
				local_ejbs = true;
				Object obj = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/PatientAssessment", eCP.PatientAssessment.PatientAssessmentHome.class, local_ejbs);
				Object obj1 = obj.getClass().getMethod("create", null).invoke(obj, null);
				Object aobj[] = new Object[3];
				aobj[0] = p;
				aobj[1] = assessMap;
				aobj[2] = diagList;
				Class aclass[] = new Class[3];
				aclass[0] = p.getClass();
				aclass[1] = assessMap.getClass();
				aclass[2] = diagList.getClass();
				results = (HashMap)obj1.getClass().getMethod("insertPatientAssessment", aclass).invoke(obj1, aobj);
				obj1.getClass().getMethod("remove", null).invoke(obj1, null);

					inserted = ( ((Boolean) results.get( "status_ins" )).booleanValue() ) ;
					message = (String) results.get("message") ;

					if(message == null || message.equals("") )
					{
						message = (String) results.get("error") ;
					}
					error_value = "0" ;

					if ( inserted ) error_value = "1" ;
					response.sendRedirect("../eCP/jsp/PatientAssessmentError.jsp?err_num=" + java.net.URLEncoder.encode(message,"UTF-8") + "&err_value=" + error_value );
				}//end of try
				catch(Exception e)
				{
					e.printStackTrace(System.err);
				}
			}//end of try-insertPatientAssessment
			catch(Exception e)
			{
				e.printStackTrace();
			}
		
	}//end of insertPatientAssessment

	/***************************************************************************************************/

	private void updatePatientAssessment(HttpServletRequest request,HttpServletResponse response) throws ServletException, java.io.IOException
	{
		response.setContentType("text/html");		
		try
		{			
			session	=	request.getSession(false);
		
			HashMap assessMap = new HashMap();
			HashMap results = new HashMap();
			boolean updated = true;

			PatientAssessmentDiag diagBean = (eCP.PatientAssessmentDiag)session.getAttribute("diagBean");

			ArrayList diagList = diagBean.getKeySet();
			
			String login_user_id		=	(String) session.getAttribute("login_user");
			String facility_id			=	(String) session.getAttribute("facility_id");
			String patient_id			=	request.getParameter("pat_id");
			String encounter_id			=	request.getParameter("enc_id");
			String assess_pract_id		=	(String) session.getAttribute("ca_practitioner_id");
			String accession_no			=	request.getParameter("accession_num");
			String ss_dependency_code	=	request.getParameter("dependency_ss") == null ? "" :request.getParameter("dependency_ss");

			String ua_dependency_code	= request.getParameter("assessDependency") == null ? "" : request.getParameter("assessDependency"); 
			String added_at_ws_no = request.getRemoteAddr();

			
		
			String message = "";
			String error_value = "";

			String chk_val_hid = request.getParameter("chk_val_hid") == null? "" : request.getParameter("chk_val_hid");
			String assess_ref_no = request.getParameter("assess_ref_no") == null? "" : request.getParameter("assess_ref_no");
			String status = request.getParameter("status_at_mod") == null? "" : request.getParameter("status_at_mod");
			String status_flag = request.getParameter("status_flag_at_mod") == null? "" : request.getParameter("status_flag_at_mod");
			String abnormal_categ = request.getParameter("abnormal_categ") == null? "" : request.getParameter("abnormal_categ");

			assessMap.put("patient_id",patient_id);
			assessMap.put("assess_ref_no",assess_ref_no);
			assessMap.put("login_user_id",login_user_id);
			assessMap.put("status",status);
			assessMap.put("status_flag",status_flag);
			assessMap.put("abnormal_categ",abnormal_categ);
			assessMap.put("chk_val_hid",chk_val_hid);
			assessMap.put("facility_id",facility_id);
			assessMap.put("encounter_id",encounter_id);
			assessMap.put("accession_no",accession_no);
			assessMap.put("assess_pract_id",assess_pract_id);
			assessMap.put("ua_dep_code",ua_dependency_code);
			assessMap.put("ss_dep_code",ss_dependency_code);
			assessMap.put("added_by_id",login_user_id);
			assessMap.put("added_at_ws_no",added_at_ws_no);
			assessMap.put("added_by_facility_id",facility_id);
			assessMap.put("modified_by_id",login_user_id);
			assessMap.put("modified_at_ws_no",added_at_ws_no);
			assessMap.put("modified_by_facility_id",facility_id);
			assessMap.put("locale",locale);
			/*InitialContext context = new InitialContext();
			Object homeObject = context.lookup("java:comp/env/PatientAssessment");
			PatientAssessmentHome patAssessmentHome  = (PatientAssessmentHome) PortableRemoteObject.narrow(homeObject ,PatientAssessmentHome.class);
			PatientAssessmentRemote patAssessmentRemote = patAssessmentHome.create();
			results = patAssessmentRemote.updatePatientAssessment(p,assessMap,diagList);*/

			boolean local_ejbs = false;
				ServletContext context = getServletConfig().getServletContext();
				if ((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) 
				local_ejbs = true;
				Object obj = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/PatientAssessment", eCP.PatientAssessment.PatientAssessmentHome.class, local_ejbs);
				Object obj1 = obj.getClass().getMethod("create", null).invoke(obj, null);
				Object aobj[] = new Object[3];
				aobj[0] = p;
				aobj[1] = assessMap;
				aobj[2] = diagList;
				Class aclass[] = new Class[3];
				aclass[0] = p.getClass();
				aclass[1] = assessMap.getClass();
				aclass[2] = diagList.getClass();
				results = (HashMap)obj1.getClass().getMethod("updatePatientAssessment", aclass).invoke(obj1, aobj);
				obj1.getClass().getMethod("remove", null).invoke(obj1, null);

			
			updated = ( ((Boolean) results.get( "status_ins" )).booleanValue()) ;
			message = (String) results.get("message") ;

			if(message == null || message.equals("") )
			{
				message = (String) results.get("error") ;
			}
			error_value = "0" ;

			if ( updated ) error_value = "1" ;
			response.sendRedirect("../eCP/jsp/PatientAssessmentError.jsp?err_num=" + java.net.URLEncoder.encode( message,"UTF-8" ) + "&err_value=" + error_value );
	
		}//end of try-update
		catch(Exception e)
		{
			e.printStackTrace(System.err);
		}
	}//end of updatePatientAssessment
}//end of class
