/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
--------------------------------------------------------------------------------------------------------------------
Date       Edit History      		Name        	Description
--------------------------------------------------------------------------------------------------------------------
?             	100            		?           	created
23/05/2013		IN039387			vijayakumark	In manage Care Plan, Unable to record the Varience.When record button is clicked, Nothing is happens & again while trying to add a new varience system displays Java null Point Exception.
--------------------------------------------------------------------------------------------------------------------
*/

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
import eCP.CarePlanVariance.*;

public class CarePlanVarianceServlet extends HttpServlet
{ 
	PrintWriter out=null;
	java.util.Properties prop;

	HttpSession session;
	//private ServletConfig config		 =		null;
	String care_plan_id					 =		"";
	String md_care_plan_id				 =		"";
	String var_comp_type				 =		"";
	String term_code    				 =		"";
	String term_set_id    				 =		"";
	String goal_code    				 =		"";
	String outcome_code 				 =		"";

	ArrayList variance_data=new ArrayList();

	HashMap results						 =		new HashMap();
	HashMap TabData						 =		new HashMap();
	String added_by_id					 =		"";
	String added_at_ws_no				 =      "";
	String added_facility_id			 =		"";
	String client_ip_address			 =		"";
	String select_yn="";
	String remarks="";
	String action_plan="";
	String locale="";
	StringBuffer cons_remarks=null;
	StringBuffer cons_action_plan=null;
	String variance_rec_by = "";//IN039387

	int no_of_records=0;
	int n=0;

	
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
		
			RecordSet	CPVariance	=	null;
			CPVariance	=	(webbeans.eCommon.RecordSet)session.getAttribute("CarePlanVariance");
			locale=(String)session.getAttribute("LOCALE");
			n=CPVariance.getSize();
            cons_remarks=new StringBuffer();
            cons_action_plan=new StringBuffer();
			
			md_care_plan_id		=	 request.getParameter("p_md_care_plan_id")==null?"":request.getParameter("p_md_care_plan_id"); 
			care_plan_id		=	 request.getParameter("p_care_plan_id")==null?"":request.getParameter("p_care_plan_id"); 
			var_comp_type		=	 request.getParameter("p_var_comp_type")==null?"":request.getParameter("p_var_comp_type"); 
			term_code	       	=	 request.getParameter("p_term_code")==null?"":request.getParameter("p_term_code"); 
			term_set_id	       	=	 request.getParameter("p_term_set_id")==null?"":request.getParameter("p_term_set_id"); 
			goal_code	    	=	 request.getParameter("p_goal_code")==null?"":request.getParameter("p_goal_code"); 
//			outcome_code		=	 request.getParameter("p_outcome_code")==null?"":request.getParameter("p_outcome_code"); 

			for(int k=0;k<n;k++)
			{
			variance_data=(ArrayList)CPVariance.getObject(k);
			select_yn=(String)variance_data.get(5);
			remarks=(String)variance_data.get(3);
			action_plan=(String)variance_data.get(4);
			
			if(select_yn.equals("Y"))
			{
			cons_remarks=cons_remarks.append(remarks);
			cons_action_plan=cons_action_plan.append(action_plan);
			no_of_records++;
    		TabData.put("VARIANCE_DATA"+no_of_records,variance_data);
			}
			}

    		TabData.put("CONS_REMARKS",cons_remarks.toString());
    		TabData.put("CONS_ACTION_PLAN",cons_action_plan.toString());

        	added_by_id			=	 (prop.getProperty("login_user")==null)?"":prop.getProperty("login_user");
			variance_rec_by	=	(String) session.getAttribute("ca_practitioner_id");//IN039387 starts
			added_facility_id	=	 (this.added_facility_id == null)?"":this.added_facility_id; 
			added_at_ws_no		=	 (client_ip_address == null)?"":client_ip_address; 
         
			TabData.put("MD_CARE_PLAN_ID",md_care_plan_id);
			TabData.put("CARE_PLAN_ID",care_plan_id);
			TabData.put("VAR_COM_TYPE",var_comp_type);
			TabData.put("TERM_CODE",term_code);
			TabData.put("TERM_SET_ID",term_set_id);
			TabData.put("GOAL_CODE",goal_code);
			//TabData.put("OUTCOME_CODE",outcome_code);
			TabData.put("TOTAL_RECORDS", String.valueOf(no_of_records));
			TabData.put("ADDED_BY_ID",added_by_id);
			TabData.put("ADDED_FCY_ID",added_facility_id);
			TabData.put("ADDED_AT_WS_NO",added_at_ws_no);
			TabData.put("locale",locale);
			TabData.put("variance_rec_by",variance_rec_by);//IN039387

			/*InitialContext context		=		new InitialContext();
			Object homeObject				=		context.lookup("java:comp/env/ReviseCarePlan");
			ReviseCarePlanHome home			=		(ReviseCarePlanHome) PortableRemoteObject.narrow(homeObject ,ReviseCarePlanHome.class);
			ReviseCarePlanRemote remote		=		home.create();
			results							=		remote.AddModify(prop,TabData) ;*/
			boolean local_ejbs = false;
			ServletContext context = getServletConfig().getServletContext();
			if ((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) 
			local_ejbs = true;
			Object obj = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/CarePlanVariance", eCP.CarePlanVariance.CarePlanVarianceHome.class, local_ejbs);
	    	Object obj1 = obj.getClass().getMethod("create", null).invoke(obj, null);
			Object aobj[] = new Object[2];
			aobj[0] = prop;
			aobj[1] = TabData;
			Class aclass[] = new Class[2];
			aclass[0] = prop.getClass();
			aclass[1] = TabData.getClass();
			results = (HashMap)obj1.getClass().getMethod("insert", aclass).invoke(obj1, aobj);
			obj1.getClass().getMethod("remove", null).invoke(obj1, null);

			boolean inserted				=		(((Boolean) results.get( "result" )).booleanValue() ) ;
			String error                    =  "";
			error				         	=		(String) results.get("message") ;
			int i=error.lastIndexOf(".");
            error=error.substring(0,i+1);
			String error_value				=		"0" ;

			if(inserted)
			{ 
				error_value = "1" ;
				out.println("<script src='../eCommon/js/showModalDialog.js' language='JavaScript'></script>");
    			out.println("<script>window.alert('"+error+"');</script>");
				out.println("<script>window.close();</script>");
				out.println("<script>window.returnValue='SUCCESS'</script>");
			}
			else
			{
				response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8" ) + "&err_value=" + error_value );
			}
			CPVariance.clearAll();
			TabData.clear();
			no_of_records=0;

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}finally{
			session.removeAttribute("CarePlanVariance");
		}
	}
}
