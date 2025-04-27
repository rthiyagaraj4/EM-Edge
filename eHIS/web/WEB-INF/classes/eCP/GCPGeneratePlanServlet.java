/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
//This file is saved on 18/10/2005.


/*************************************************************************
*	ClassName					: GCPGeneratePlanServlet.java
*	Description				    : This function is used to takes all the request parameters and which
								  will be further used to insert/update the database 
*	Methods						:
*	Exception					:
*	Author						: Jerome
*	Version						: 1.0
*	Date						: 27 Jan 2004
*	Revision History			:
***************************************************************************
*   Version			Date		Name		Remarks
***************************************************************************/
package eCP;

import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
//import javax.naming.*;
//import javax.rmi.*;
import java.util.*;
import java.text.*;
import eCP.GCPGeneratePlan.*;
import webbeans.eCommon.*; 

 public class GCPGeneratePlanServlet extends HttpServlet
 {
	PrintWriter out;
	String client_ip_addr="";
	String facilityId = "" ;
	String addedId ="";
	String mode ="";
	HttpSession session; 
	Properties p;
		
		
/**
*	init	-	will initialise the servlet
*	@param	config - this is ServletConfig
*/
	public  void init(ServletConfig config) throws ServletException
	{
			 super.init(config);
	}
/**
*	doPost	-	will be called when the method is of post
*	@param	request - this is HttpServletRequest
*	@param	response - this is HttpServletResponse
*	throws javax.servlet.ServletException,IOException
*/
	public  void doPost(HttpServletRequest request,HttpServletResponse response)throws javax.servlet.ServletException,IOException
	 {
	
		session = request.getSession(false);
		this.p = (java.util.Properties) session.getAttribute( "jdbc" ) ;
		this.facilityId = (String) session.getAttribute( "facility_id" ) ;
		client_ip_addr = this.p.getProperty("client_ip_address");
		try{


			response.setContentType("text/html;charset=UTF-8");
			request.setCharacterEncoding("UTF-8");
			this.out = response.getWriter();
			mode =request.getParameter("mode") == null ? "" :  request.getParameter("mode");
	
			mode = "insert";
			if(mode.equals("insert")){
				insert(request,response);
			}
				

		} catch(Exception e) {
			out.println("Exception in Main Block : "+e.toString());
			e.printStackTrace();
		}


		/********************/
	 }


 /**
*	insert	-	will be called when the mode value is insert
*	@param	request - this is HttpServletRequest
*	@param	response - this is HttpServletResponse
*	throws javax.servlet.ServletException,IOException
*/
	void insert(HttpServletRequest request,HttpServletResponse response)		
	 {
		try{
			HashMap tabdata=new HashMap();
				
			String patient_id		= "";
			String errorMsg			= "";
			long encounter_id		= 0;
			int count = 0,tcode_cnt=0,version_no=0,out_cnt=0,intvn_cnt=0;
			String locale=(String)session.getAttribute("LOCALE");
			this.p			= (java.util.Properties) session.getAttribute( "jdbc" ) ;
			this.facilityId = (String) session.getAttribute( "facility_id" ) ;
			client_ip_addr	= this.p.getProperty("client_ip_address");
			addedId			= (p.getProperty("login_user")==null)?"":p.getProperty("login_user")  ;    
			String cm_pract_id		= (String) session.getAttribute("ca_practitioner_id") == null?"" :(String) session.getAttribute("ca_practitioner_id");
			String curr_care_manager ="";
			String outcome_code = "",intervent_code="",target_date="";
			String library_id = "";
			String term_set_id = "",term_code="",goal_code="";
			String care_plan_start_date="",care_plan_end_date="",start_date="",end_date="";
			String intervention_code = "",intervention_type = "",freq_code = "",duration = "",durn_type = "",cnt="",priority="",position_code="",role_type="",stage_code="";
			String out_group_id="",int_group_id="";
			String error_value = "0" ;
			String goal_stmt="";
			try{
			curr_care_manager = request.getParameter("curr_care_manager") == null ? cm_pract_id :  request.getParameter("curr_care_manager");
			tcode_cnt = request.getParameter("tcode_cnt")==null? 0 :Integer.parseInt(request.getParameter("tcode_cnt"));
			cnt = request.getParameter("count") == null ? "0" :  request.getParameter("count");
			count = request.getParameter("count")==null? 0 :Integer.parseInt(request.getParameter("count"));
			count = Integer.parseInt(cnt);
			}
			catch(Exception e){
				e.printStackTrace();
			
			}
			boolean inserted;
			java.util.HashMap results = new HashMap();String intvn_cnt1="";
			for(int tmp=0;tmp<tcode_cnt;tmp++){

				term_set_id		 = request.getParameter("term_set_id"+tmp) == null ? "" :  request.getParameter("term_set_id"+tmp);
				term_code		 = request.getParameter("term_code"+tmp) == null ? "" :  request.getParameter("term_code"+tmp);
				library_id		 = request.getParameter("library_id"+tmp) == null ? "" :  request.getParameter("library_id"+tmp);
				version_no		 = request.getParameter("version_no"+tmp) == null ? 0 :  Integer.parseInt(request.getParameter("version_no"+tmp)); 
				target_date		 = request.getParameter("target_date"+tmp) == null ? "" : com.ehis.util.DateUtils.convertDate(request.getParameter("target_date"+tmp),"DMYHM",locale,"en"); 
				goal_code		 = request.getParameter("goal_code"+tmp) == null ? "" :  request.getParameter("goal_code"+tmp); 
				out_cnt			 = request.getParameter("out_cnt"+tmp) == null ? 0 :  Integer.parseInt(request.getParameter("out_cnt"+tmp)); 	
				intvn_cnt		 = request.getParameter("intv_cnt"+tmp) == null ? 0 :  Integer.parseInt(request.getParameter("intv_cnt"+tmp)); 	
				intvn_cnt1		 = request.getParameter("intv_cnt"+tmp) == null ? "0" :  request.getParameter("intv_cnt"+tmp); 

				for(int out_tmp=0;out_tmp<out_cnt;out_tmp++){					
					outcome_code		 = request.getParameter("outcome_code"+out_tmp+tmp) == null ? "" :  request.getParameter("outcome_code"+out_tmp+tmp); 
					out_group_id		 = request.getParameter("out_group_id"+out_tmp+tmp) == null ? "" :  request.getParameter("out_group_id"+out_tmp+tmp); 
					tabdata.put("outcome_code"+out_tmp+tmp, outcome_code);
					tabdata.put("out_group_id"+out_tmp+tmp, out_group_id);
				}
				for(int inv_tmp=0;inv_tmp<intvn_cnt;inv_tmp++){
					intervent_code		 = request.getParameter("intervent_code"+inv_tmp+tmp) == null ? "" :  request.getParameter("intervent_code"+inv_tmp+tmp); 
					int_group_id		 = request.getParameter("int_group_id"+inv_tmp+tmp) == null ? "0" :  request.getParameter("int_group_id"+inv_tmp+tmp); 
	
					tabdata.put("intervent_code"+inv_tmp+tmp, intervent_code);
					tabdata.put("int_group_id"+inv_tmp+tmp, int_group_id);
				}
				
				
				tabdata.put("library_id"+tmp, library_id);
				tabdata.put("version_no"+tmp, new Integer(version_no));
				tabdata.put("term_set_id"+tmp, term_set_id);
				tabdata.put("term_code"+tmp, term_code);
				tabdata.put("goal_code"+tmp, goal_code);
				tabdata.put("target_date"+tmp, target_date);
				tabdata.put("out_cnt"+tmp, new Integer(out_cnt));
				tabdata.put("intvn_cnt"+tmp, new Integer(intvn_cnt));
				tabdata.put("intvn_cnt1"+tmp, intvn_cnt1);
				
			}
			for(int icnt=0;icnt<count;icnt++){
				intervention_code	 = request.getParameter("inter_code"+icnt) == null ? "" :  request.getParameter("inter_code"+icnt);	
				intervention_type	 = request.getParameter("intervention_type"+icnt) == null ? "" :  request.getParameter("intervention_type"+icnt);	
				freq_code	 = request.getParameter("freq_code"+icnt) == null ? "" :  request.getParameter("freq_code"+icnt);	
				duration	 = request.getParameter("durn_value"+icnt) == null ? "" :  request.getParameter("durn_value"+icnt);	
				durn_type	 = request.getParameter("dur_type"+icnt) == null ? "" :  request.getParameter("dur_type"+icnt);	
				start_date	 = request.getParameter("st_date"+icnt) == null ? "" :  com.ehis.util.DateUtils.convertDate(request.getParameter("st_date"+icnt),"DMYHM",locale,"en");	
				end_date	 = request.getParameter("end_date"+icnt) == null ? "" :  com.ehis.util.DateUtils.convertDate(request.getParameter("end_date"+icnt),"DMYHM",locale,"en");	
				position_code= request.getParameter("postn"+icnt) == null ? "" :  request.getParameter("postn"+icnt);	
				role_type	 =request.getParameter("role_type"+icnt) == null ? "" :  request.getParameter("role_type"+icnt);	
				priority	 = request.getParameter("prior"+icnt) == null ? "" :  request.getParameter("prior"+icnt);	
				stage_code	 = request.getParameter("intvn_stage"+icnt) == null ? "" :  request.getParameter("intvn_stage"+icnt);
				
				tabdata.put("intervention_code"+icnt, intervention_code);
				tabdata.put("intervention_type"+icnt, intervention_type);
				tabdata.put("freq_code"+icnt, freq_code);
				tabdata.put("duration"+icnt, duration);
				tabdata.put("durn_type"+icnt, durn_type);
				tabdata.put("start_date"+icnt, start_date);
				tabdata.put("end_date"+icnt, end_date);
				tabdata.put("position_code"+icnt, position_code);
				tabdata.put("role_type"+icnt, role_type);
				tabdata.put("priority"+icnt, priority);
				tabdata.put("stage_code"+icnt, stage_code);
				
			}
			try{
				
				patient_id			 = request.getParameter("patient_id") == null ? "" :  request.getParameter("patient_id");
				encounter_id		 = request.getParameter("encounter_id") == null ? 0 :  Long.parseLong(request.getParameter("encounter_id"));
				goal_stmt			 = request.getParameter("goal_stmt") == null ? "" :  request.getParameter("goal_stmt");
				care_plan_start_date = request.getParameter("care_plan_start_date") == null ? "" :  request.getParameter("care_plan_start_date");
				care_plan_end_date	 = request.getParameter("care_plan_end_date") == null ? "" :  request.getParameter("care_plan_end_date");
				
				
			}
			catch(Exception e){	
				e.printStackTrace();
			}
			tabdata.put("mode",mode);
			tabdata.put("tcode_cnt",new Integer(tcode_cnt));
			tabdata.put("count",cnt);
			tabdata.put("patient_id",patient_id);
			tabdata.put("encounter_id",new Long(encounter_id));
			tabdata.put("goal_stmt",goal_stmt);
			tabdata.put("care_plan_start_date",care_plan_start_date);
			tabdata.put("care_plan_end_date",care_plan_end_date);
			tabdata.put("module_id","CP");
			tabdata.put("cm_pract_id",cm_pract_id);
			tabdata.put("curr_care_manager",curr_care_manager);
			tabdata.put("added_by_id",addedId);
			tabdata.put("added_date",new  java.sql.Timestamp(System.currentTimeMillis()));
			tabdata.put("added_facility_id", facilityId);
			tabdata.put("added_at_ws_no",client_ip_addr);
			tabdata.put("modified_by_id",addedId);
			tabdata.put("modified_date",new  java.sql.Timestamp(System.currentTimeMillis()));
			tabdata.put("modified_facility_id",facilityId);
			tabdata.put("modified_at_ws_no",client_ip_addr );
			tabdata.put("locale",locale );
			//System.err.println("tabdate ===>"+tabdata);
			
		/*InitialContext context = new InitialContext();
		Object homeObject = context.lookup("java:comp/env/GCPGeneratePlan");
		GCPGeneratePlanHome gcpGeneratePlanHome  = (GCPGeneratePlanHome) PortableRemoteObject.narrow(homeObject ,GCPGeneratePlanHome.class);
		GCPGeneratePlanRemote gcpGeneratePlanRemote = gcpGeneratePlanHome.create();
		results = gcpGeneratePlanRemote.generateCarePlan(p,tabdata);*/

		boolean local_ejbs = false;
				ServletContext context = getServletConfig().getServletContext();
				//System.err.println("one");
				if ((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) 
				local_ejbs = true;
				//System.err.println("two");
				Object obj = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/GCPGeneratePlan", eCP.GCPGeneratePlan.GCPGeneratePlanHome.class, local_ejbs);
				//System.err.println("three");
				Object obj1 = obj.getClass().getMethod("create", null).invoke(obj, null);
				//System.err.println("four");
				Object aobj[] = new Object[2];
				aobj[0] = p;
				aobj[1] = tabdata;
				Class aclass[] = new Class[2];
				aclass[0] = p.getClass();
				aclass[1] = tabdata.getClass();
					//System.err.println("five");
				results = (HashMap)obj1.getClass().getMethod("generateCarePlan", aclass).invoke(obj1, aobj);
				//System.err.println("results:="+results);
				obj1.getClass().getMethod("remove", null).invoke(obj1, null);
				//System.err.println("six");
				inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
				//System.err.println("inserted:="+inserted);
				errorMsg = (String) results.get("error");
				//System.err.println("errorMsg:="+errorMsg);


		if ( inserted )
			error_value = "1" ;

			//System.err.println("seven");
		response.sendRedirect("../eCP/jsp/GCPGenerateCarePlanIntermediate.jsp?err_num=" + java.net.URLEncoder.encode(errorMsg,"UTF-8")+ "&err_value=" + error_value );
			//System.err.println("end");
		}
		catch ( Exception e ) {
			out.println("Exception in Insert Block :"+e.getMessage());
			out.println("Exception in Insert Block :"+e.toString());
			out.println("Exception in insert GCPGeneratePlan Servlet ...So Record Not inserted  : "+e.toString());
			e.printStackTrace();
		}
	}
 }
