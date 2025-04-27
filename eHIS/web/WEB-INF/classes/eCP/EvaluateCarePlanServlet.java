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
import java.net.*;
import webbeans.eCommon.*;
import eCP.EvaluateCarePlan.*;

public class EvaluateCarePlanServlet extends HttpServlet
{ 
	Connection con = null;
	PrintWriter out;
	java.util.Properties prop;
	HttpSession session;
	private ServletConfig config=null;
	String added_by_id = "";
	String added_at_ws_no = "";
	String added_facility_id = "";
	String modified_by_id = "";
	String modified_at_ws_no = "";
	String modified_facility_id = "";
	String client_ip_address = "";
	String mode = "";
	String locale="";

	public void init(ServletConfig config)throws ServletException
	{
		super.init(config);
		this.config = config;
	}
	//end of init()
	public  void doPost(HttpServletRequest request, HttpServletResponse response)throws javax.servlet.ServletException,IOException
	{
		this.out = response.getWriter();
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		session = request.getSession(false);
		this.prop = (java.util.Properties)session.getAttribute("jdbc");
		this.added_facility_id = (String)session.getAttribute("facility_id");
		client_ip_address = this.prop.getProperty("client_ip_address");
		modified_by_id = (prop.getProperty("login_user")==null)?"":prop.getProperty("login_user");
		modified_facility_id = (this.added_facility_id==null)?"":this.added_facility_id;
		modified_at_ws_no = (client_ip_address==null)?"":client_ip_address;
		try
		{
			 mode = (request.getParameter("mode")==null)?"":request.getParameter("mode");
			 if(mode.equals("")) insert(request,response);
		}
		catch(Exception e)
		{
			out.println("Exception in try of doPost()"+e);
		}
	}
	//end of doPost()
	public  void doGet(HttpServletRequest request,HttpServletResponse response) throws javax.servlet.ServletException,IOException
	{
		try
		{
			this.out = response.getWriter();
			response.setContentType("text/html");
			doPost(request,response);
		}
		catch(Exception e)
		{
			out.println("Exception in doGet()"+e);
		}
	}//end of doGet()
//***********Start of Insert************************
	private void insert(HttpServletRequest request,HttpServletResponse response)
	{
		try
		{
			added_by_id = (prop.getProperty("login_user")==null)?"":prop.getProperty("login_user");
			added_facility_id = (this.added_facility_id == null)?"":this.added_facility_id; 
			added_at_ws_no = (client_ip_address == null)?"":client_ip_address;
			ArrayList diag_arr = new ArrayList();
			ArrayList goal_arr = new ArrayList();
			ArrayList outcome_arr = new ArrayList();
			HashMap hashmap_main = new HashMap();
			// Diagnosis var declaration.
			String term_set_id_diag = "";
			String term_code_diag = "";
			String term_code_srl_no_diag = "";
			String dx_prog_pct = "";
			String diag_status = "";
			String evaluation_allowed_diag_yn = "";
			String evaluated_diag_yn = "";
			String DiagmsrID="";
			// End ofDiagnosis.
			// Goal var declaration.
			String term_set_id_goal = "";
			String term_code_goal = "";
			String term_code_srl_no_goal = "";
			String goal_srl_no = "";
			String goal_code = "";
			String goal_prog_pct = "";
			String goal_status = "";
			String diag_status_for_goal = "";
			String evaluation_allowed_goal_yn = "";
			String evaluation_goal_yn = "";
			String GoalmsrID="";
			// End of Goal.
			// Outcome var declaration.
			String term_set_id_outcome = "";
			String term_code_outcome = "";
			String term_code_srl_no_outcome = "";
			String goal_code_outcome = "";
			String goal_srl_no_outcome = "";
			String group_id = "";
			String outcome_code = "";
			String outcome_prog_pct = "";
			String term_code_status = "";
			String goal_status_outcome = "";
			String outcome_status = "";
			String outcome_srl_no = "";
			String evaluation_allowed_outcome_yn = "";
			String evaluation_outcome_yn = "";
			String OutcomemsrID="";
			// End of Outcome.
			String patient_id = request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
			String pract_id = request.getParameter("pract_id")==null?"":request.getParameter("pract_id");
			String encounter_id = request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
			String care_plan_id = request.getParameter("care_plan_id")==null?"":request.getParameter("care_plan_id");
			String md_plan_id = request.getParameter("md_plan_id")==null?"":request.getParameter("md_plan_id");
			String diag_cnt = request.getParameter("diag_count")==null?"0":request.getParameter("diag_count");
			String goal_cnt = request.getParameter("goal_count")==null?"0":request.getParameter("goal_count");
			String outcome_cnt = request.getParameter("outcome_count")==null?"0":request.getParameter("outcome_count");
			String eval_status = request.getParameter("eval_status")==null?"A":request.getParameter("eval_status");
			String eval_remarks = request.getParameter("eval_remarks")==null?"":request.getParameter("eval_remarks");
			int diag_count = Integer.parseInt(diag_cnt);
			int goal_count = Integer.parseInt(goal_cnt);
			int outcome_count = Integer.parseInt(outcome_cnt);
			if(diag_count!=0)
			diag_count = diag_count - 1;
			if(goal_count!=0)
			goal_count = goal_count - 1;
			if(outcome_count!=0)
			outcome_count = outcome_count - 1;
			// Values of Diagnosis.
			for(int i=1;i<=diag_count;i++)
			{
				term_set_id_diag = request.getParameter("term_set_id_diag"+i);
				term_code_diag = request.getParameter("term_code_diag"+i);
				term_code_srl_no_diag = request.getParameter("term_code_srl_no_diag"+i);
				dx_prog_pct = request.getParameter("dx_prog_pct"+i);
				diag_status = request.getParameter("diag_status"+i);
				evaluation_allowed_diag_yn = request.getParameter("evaluation_allowed_diag_yn"+i);
				evaluated_diag_yn = request.getParameter("evaluated_diag_yn"+i)==null?"N":request.getParameter("evaluated_diag_yn"+i);
				DiagmsrID=request.getParameter("DiagmsrID"+i);
				if(evaluation_allowed_diag_yn.equals("Y"))
				{
					if(evaluated_diag_yn.equals("Y"))
					{
						HashMap diag_map = new HashMap();
						diag_map.put("TERM_SET_ID_DIAG",term_set_id_diag);	
						diag_map.put("TERM_CODE_DIAG",term_code_diag);	
						diag_map.put("TERM_CODE_SRL_NO_DIAG",term_code_srl_no_diag);	
						diag_map.put("DX_PROG_PCT",dx_prog_pct);	
						diag_map.put("DIAG_STATUS",diag_status);
						diag_map.put("DIAGMSRID",DiagmsrID);
						diag_arr.add(diag_map);
					}
				}
			}
			// End of Diagnosis.
			// Values of Goal.
			for(int j=1;j<=goal_count;j++)
			{
				term_set_id_goal = request.getParameter("term_set_id_goal"+j);
				term_code_goal = request.getParameter("term_code_goal"+j);
				term_code_srl_no_goal = request.getParameter("term_code_srl_no_goal"+j);
				goal_code = request.getParameter("goal_code"+j);
				goal_srl_no = request.getParameter("goal_srl_no"+j);
				goal_prog_pct = request.getParameter("goal_prog_pct"+j);
				diag_status_for_goal = request.getParameter("diag_status_for_goal"+j);
				goal_status = request.getParameter("goal_status"+j);
				evaluation_allowed_goal_yn = request.getParameter("evaluation_allowed_goal_yn"+j);
				GoalmsrID=request.getParameter("GoalmsrID"+j);
				//System.err.println("GoalmsrID in servlet "+GoalmsrID);
				evaluation_goal_yn = request.getParameter("evaluation_goal_yn"+j)==null?"N":request.getParameter("evaluation_goal_yn"+j);
				if(evaluation_allowed_goal_yn.equals("Y"))
				{
					if(evaluation_goal_yn.equals("Y"))
					{
						HashMap goal_map = new HashMap();
						goal_map.put("TERM_SET_ID_GOAL",term_set_id_goal);	
						goal_map.put("TERM_CODE_GOAL",term_code_goal);	
						goal_map.put("TERM_CODE_SRL_NO_GOAL",term_code_srl_no_goal);	
						goal_map.put("GOAL_CODE",goal_code);	
						goal_map.put("GOAL_SRL_NO",goal_srl_no);	
						goal_map.put("GOAL_PROG_PCT",goal_prog_pct);	
						goal_map.put("GOAL_STATUS",goal_status);
						goal_map.put("DIAG_STATUS_FOR_GOAL",diag_status_for_goal);
						goal_map.put("GOALMSRID",GoalmsrID);
						goal_arr.add(goal_map);
					}
				}
			}
			// End of Goal.
			//Values of Outcome.
			for(int k=1;k<=outcome_count;k++)
			{
				if(!(request.getParameter("term_set_id_outcome"+k)== null))
				{
					term_set_id_outcome = request.getParameter("term_set_id_outcome"+k);
					term_code_outcome = request.getParameter("term_code_outcome"+k);
					term_code_srl_no_outcome = request.getParameter("term_code_srl_no_outcome"+k);
					goal_code_outcome = request.getParameter("goal_code_outcome"+k);
					goal_srl_no_outcome = request.getParameter("goal_srl_no_outcome"+k);
					group_id = request.getParameter("group_id"+k);
					outcome_code = request.getParameter("outcome_code"+k);
					outcome_prog_pct = request.getParameter("outcome_prog_pct"+k);
					term_code_status = request.getParameter("term_code_status"+k);
					goal_status_outcome = request.getParameter("goal_status"+k);
					outcome_status = request.getParameter("outcome_status"+k);
					outcome_srl_no = request.getParameter("outcome_srl_no"+k);
					evaluation_allowed_outcome_yn = request.getParameter("evaluation_allowed_outcome_yn"+k);
					evaluation_outcome_yn = request.getParameter("evaluation_outcome_yn"+k);
					OutcomemsrID=request.getParameter("OutcomemsrID"+k);
				//	System.err.println("OutcomemsrID in servlet"+OutcomemsrID);
					if(evaluation_allowed_outcome_yn.equals("Y"))
					{
						if(evaluation_outcome_yn.equals("Y"))
						{
							HashMap outcome_map = new HashMap();
							outcome_map.put("TERM_SET_ID_OUTCOME",term_set_id_outcome);	
							outcome_map.put("TERM_CODE_OUTCOME",term_code_outcome);	
							outcome_map.put("TERM_CODE_SRL_NO_OUTCOME",term_code_srl_no_outcome);	
							outcome_map.put("GOAL_CODE_OUTCOME",goal_code_outcome);	
							outcome_map.put("GOAL_SRL_NO_OUTCOME",goal_srl_no_outcome);	
							outcome_map.put("GROUP_ID",group_id);	
							outcome_map.put("OUTCOME_CODE",outcome_code);
							outcome_map.put("OUTCOME_PROG_PCT",outcome_prog_pct);
							outcome_map.put("TERM_CODE_STATUS",term_code_status);
							outcome_map.put("GOAL_STATUS_OUTCOME",goal_status_outcome);
							outcome_map.put("OUTCOME_STATUS",outcome_status);
							outcome_map.put("OUTCOME_SRL_NO",outcome_srl_no);
							outcome_map.put("OUTCOMEMSRID",OutcomemsrID);
							outcome_arr.add(outcome_map);
						}
					}
				}
			}
			//End of Outcome.
			hashmap_main.put("PATIENT_ID",patient_id);	
			hashmap_main.put("PRACT_ID",pract_id);	
			hashmap_main.put("ENCOUNTER_ID",encounter_id);	
			hashmap_main.put("CARE_PLAN_ID",care_plan_id);	
			hashmap_main.put("MD_PLAN_ID",md_plan_id);	
			hashmap_main.put("STATUS",eval_status);	
//	System.out.println("@@Status>>>>>>>>>>>>>>>"+eval_status);
			hashmap_main.put("REMARKS",eval_remarks);	
			hashmap_main.put("DIAGNOSIS",diag_arr);
			hashmap_main.put("GOAL",goal_arr);
			hashmap_main.put("OUTCOME",outcome_arr);
			hashmap_main.put("ADDED_BY_ID",added_by_id);
			hashmap_main.put("ADDED_DATE",new  java.sql.Timestamp(System.currentTimeMillis()));
			hashmap_main.put("ADDED_AT_WS_NO",added_at_ws_no);
			hashmap_main.put("ADDED_FACILITY_ID",added_facility_id);
			hashmap_main.put("MODIFIED_BY_ID",modified_by_id);
			hashmap_main.put("MODIFIED_DATE",new  java.sql.Timestamp(System.currentTimeMillis()));
			hashmap_main.put("MODIFIED_AT_WS_NO",modified_at_ws_no);
			hashmap_main.put("MODIFIED_FACILITY_ID",modified_facility_id);
//	System.out.println("@@CP HashMap>>>>>>>>>>>"+hashmap_main);
			try
			{
				con = ConnectionManager.getConnection(request);
				locale=(String)session.getAttribute("LOCALE");
				boolean local_ejbs = false;
				ServletContext context = getServletConfig().getServletContext();
				if ((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) 
				local_ejbs = true;
				Object obj = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/EvaluateCarePlan", eCP.EvaluateCarePlan.EvaluateCarePlanHome.class, local_ejbs);
				Object obj1 = obj.getClass().getMethod("create", null).invoke(obj, null);
				Object aobj[] = new Object[2];
				aobj[0] = prop;
				aobj[1] = hashmap_main;
				Class aclass[] = new Class[2];
				aclass[0] = prop.getClass();
				aclass[1] = hashmap_main.getClass();
				HashMap results = (HashMap)obj1.getClass().getMethod("AddModify", aclass).invoke(obj1, aobj);
				obj1.getClass().getMethod("remove", null).invoke(obj1, null);
				boolean inserted = (((Boolean)results.get("status")).booleanValue());
				String error = (String) results.get("error");
				Hashtable final_result = MessageManager.getMessage(locale,"RECORD_INSERTED","CP");
				String msgid= (String)final_result.get("message");
				int i=msgid.lastIndexOf(".");
                msgid=msgid.substring(0,i+1);
				String error_value = "";
				if (inserted)
				{
					error_value= "1";
					out.println("<script src='../eCommon/js/showModalDialog.js' language='JavaScript'></script>");
					out.println("<script>alert('"+msgid+"')</script>");
					out.println("<script>window.returnValue = 'SUCCESS'</script>");
					out.println("<script>window.close();</script>");
				}
				else
				{
					response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8" ) + "&err_value=" + error_value );
				}
			}
			catch(Exception exp)
			{
				exp.printStackTrace();
				String error = "Error ";
				String error_value = "0" ;
				response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error ,"UTF-8") + "&err_value=" + error_value );
			}
			finally
			{
				ConnectionManager.returnConnection(con,request);
			}
		}
		catch(Exception e)
		{

			out.println("<h3> Exception raised by Servlet ...So Record Not inserted </h3> Foll: Error Received : "+e.toString());
		}//end of catch
	}//end of insert
}
