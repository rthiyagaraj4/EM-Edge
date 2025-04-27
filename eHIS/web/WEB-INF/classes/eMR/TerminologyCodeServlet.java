/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eMR;
import java.io.*;
import java.sql.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.naming.*;
import javax.rmi.*;
import java.net.*;
import webbeans.eCommon.*;
import eCommon.SingleTabHandler.*;

public class TerminologyCodeServlet extends HttpServlet
{
	PrintWriter out;
	java.util.Properties p;
	HttpSession session;
	private ServletConfig config=null;
	String mode = "";
	String term_set_id = "";
	String term_code = "";
	String part_term_code = "";
	String code_level = "";
	String long_desc = "";
	String short_desc = "";
	String proc_diag = "";
	String proc = "";
	String diag = "";
	String eff_status = "";
	String selectable = "";
	String added_by_id = "";
	
	String added_at_ws_no = "";
	String added_facility_id = "";
	String modified_by_id = "";
	
	String modified_at_ws_no = "";
	String modified_facility_id = "";
	String client_ip_address = "";
	String error_value = "0";
	String sensitive = "";
	String notifiable = "";
	String code_indicator = "";


	String actual_yn="";
	String potential_yn="";
	String wellness_yn="";
	String multi_desc = ""; // added by mujafar for ML-MMOH-CRF-1281
	String isMultiDescAppl=""; // added by mujafar for ML-MMOH-CRF-1281
	String dagger_independent_yn="";
	String High_risk_cndn_code=""; // Added for this CRF [BRU-HIMS-19.1]
	//java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "yyyy-MM-dd" );
    HashMap Termcodeval = new HashMap();
	public void init(ServletConfig config)throws ServletException
	{
		super.init(config);
		this.config = config;
	}
	//end of init()
	public synchronized void doPost(HttpServletRequest request, HttpServletResponse response)throws javax.servlet.ServletException,IOException
	{
		this.out = response.getWriter();		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		session = request.getSession(false);
		this.p = (java.util.Properties)session.getValue("jdbc");
		this.added_facility_id = (String)session.getValue("facility_id");
		client_ip_address = this.p.getProperty("client_ip_address");
		modified_by_id = (p.getProperty("login_user")==null)?"":p.getProperty("login_user");
		modified_facility_id		= (this.added_facility_id==null)?"":this.added_facility_id;
		modified_at_ws_no   = (client_ip_address==null)?"":client_ip_address;

		try
		{
			 mode = (request.getParameter("mode")==null)?"":request.getParameter("mode");
			 if(mode.equals("")) insert(request,response);
			 if(mode.equals("Modify")) modify(request,response);
		}
		catch(Exception e)
		{
			//out.println("Exception in try of doPost() of TerminologyCodeServlet.java"+e);
			e.printStackTrace();
		}
	}//end of doPost()
	public synchronized void doGet(HttpServletRequest request,HttpServletResponse response) throws javax.servlet.ServletException,IOException
	{
		try
		{
			this.out = response.getWriter();
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/html;charset=UTF-8");
			doPost(request,response);
		}
		catch(Exception e)
		{
			/*out.println("Exception in doGet() of TerminologyCodeServlet.java"+e); */
			e.printStackTrace();
		}
	}//end of doGet()
//***********Start of Insert************************
	private void insert(HttpServletRequest request,HttpServletResponse response)
	{
		try
		{
			added_by_id = (p.getProperty("login_user")==null)?"":p.getProperty("login_user");
			added_facility_id = (this.added_facility_id == null)?"":this.added_facility_id; 
			added_at_ws_no = (client_ip_address == null)?"":client_ip_address; 
			term_set_id = request.getParameter("termsetid")==null?"":request.getParameter("termsetid");
			part_term_code = request.getParameter("part_term_code")==null?"":request.getParameter("part_term_code");  
			term_code = request.getParameter("term_code")==null?"":request.getParameter("term_code");  
			code_level = request.getParameter("codelevel")==null?"":request.getParameter("codelevel"); 
			long_desc = request.getParameter("long_desc")==null?"try":request.getParameter("long_desc");
			short_desc = request.getParameter("short_desc")==null?"":request.getParameter("short_desc");
			proc_diag = request.getParameter("proc_diag")==null?"":request.getParameter("proc_diag");
			
			sensitive = request.getParameter("sensitive")==null?"N":request.getParameter("sensitive");
			notifiable = request.getParameter("notifiable")==null?"N":request.getParameter("notifiable");
			code_indicator = request.getParameter("code_indicator")==null?"":request.getParameter("code_indicator");

			actual_yn = request.getParameter("active")==null?"N":request.getParameter("active");
			potential_yn = request.getParameter("potential")==null?"N":request.getParameter("potential");
			wellness_yn = request.getParameter("wellness")==null?"N":request.getParameter("wellness");
			multi_desc = request.getParameter("multi_desc")==null?"N":request.getParameter("multi_desc");  //added by mujafar for ML-MMOH-CRF-1281
			isMultiDescAppl = request.getParameter("isMultiDescAppl")==null?"N":request.getParameter("isMultiDescAppl");  
			dagger_independent_yn = request.getParameter("dagger_independent_yn")==null?"N":request.getParameter("dagger_independent_yn");
			High_risk_cndn_code = request.getParameter("High_risk_cndn_code")==null?"":request.getParameter("High_risk_cndn_code"); // Added for this CRF [BRU-HIMS-19.1]
 
			if(proc_diag.equals(""))
			{
				proc = "N";
				diag = "N";
			}
			else if(proc_diag.equals("P"))
			{
				proc = "Y";
				diag = "N";
			}
			else if(proc_diag.equals("D"))
			{
				proc = "N";
				diag = "Y";
			}
			eff_status = request.getParameter("eff_status")==null?"D":request.getParameter("eff_status");
			selectable = request.getParameter("selectable")==null?"N":request.getParameter("selectable");
			Termcodeval.put("TERM_SET_ID",term_set_id);
			Termcodeval.put("TERM_CODE",term_code);
			Termcodeval.put("PART_TERM_CODE",part_term_code);
			Termcodeval.put("CODE_LEVEL",code_level);
			Termcodeval.put("LONG_DESC",long_desc);
			Termcodeval.put("SHORT_DESC",short_desc);
			Termcodeval.put("PROCEDURE_YN",proc);
			Termcodeval.put("DIAGNOSIS_YN",diag);
			Termcodeval.put("EFF_STATUS",eff_status);
			Termcodeval.put("SELECT_YN",selectable);
			Termcodeval.put("SENSITIVE_YN",sensitive);
			Termcodeval.put("NOTIFIABLE_YN",notifiable);
			Termcodeval.put("CROSS_REF_TYPE",code_indicator);
			Termcodeval.put("ADDED_BY_ID",added_by_id);
			Termcodeval.put("ADDED_DATE",new  java.sql.Timestamp(System.currentTimeMillis()));
			Termcodeval.put("ADDED_AT_WS_NO",added_at_ws_no);
			Termcodeval.put("ADDED_FACILITY_ID",added_facility_id);
			Termcodeval.put("MODIFIED_BY_ID",modified_by_id);
			Termcodeval.put("MODIFIED_DATE",new  java.sql.Timestamp(System.currentTimeMillis()));
			Termcodeval.put("MODIFIED_AT_WS_NO",modified_at_ws_no);
			Termcodeval.put("MODIFIED_FACILITY_ID",modified_facility_id);

			Termcodeval.put("ACTUAL_YN",actual_yn);
			Termcodeval.put("POTENTIAL_YN",potential_yn);
			Termcodeval.put("WELLNESS_YN",wellness_yn); 
			if(isMultiDescAppl.equals("true")) //added by mujafar for ML-MMOH-CRF-1281
			Termcodeval.put("MULTI_DESC_YN",multi_desc);
			Termcodeval.put("DAGGER_INDEPENDENT_YN",dagger_independent_yn);
			Termcodeval.put("HIGH_RISK_CODE",High_risk_cndn_code); // Added for this CRF [BRU-HIMS-19.1]
			String dupfields[] = {"TERM_SET_ID","TERM_CODE"};
			String tabname="MR_TERM_CODE";
			try
			{
				boolean local_ejbs = false;
				if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;
				Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
				Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
				Object argArray[] = new Object[4];
				argArray[0] = p;
				argArray[1] = Termcodeval;
				argArray[2] = dupfields;
				argArray[3] = tabname;
				Class [] paramArray = new Class[4];
				paramArray[0] = p.getClass();
				paramArray[1] = Termcodeval.getClass();
				paramArray[2] = dupfields.getClass();
				paramArray[3] = tabname.getClass();
				java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);

				boolean inserted = (((Boolean)results.get("status")).booleanValue());
				String error = (String) results.get("error") ;
			    if ( inserted )
					   {   
				          	error_value= "1";
							response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8" ) + "&err_value=" + error_value );
					   }
					   else
					   {
						   String error_value = "0" ;
						   response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8" ) + "&err_value=" + error_value );
					   }
				if ( results != null) results.clear();
			}
			catch(Exception exp)
			{
					  exp.printStackTrace();
					  String error = "Error ";
					  String error_value = "0" ;
					  response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8" ) + "&err_value=" + error_value );
			}
		}
		catch(Exception e)
		{
			/*out.println("<h3> Exception raised by Servlet ...So Record Not inserted </h3> Foll: Error Received : "+e.toString()); */
			e.printStackTrace();
		}//end of catch
	}//end of insert
	// Modify part
	private void modify(HttpServletRequest request,HttpServletResponse response)
	{
		try
		{
			HashMap Termcodemodifyvalues=new HashMap();
			added_by_id 	= p.getProperty( "login_user" ) ;
			added_facility_id=(String)session.getValue("facility_id");
			modified_by_id	= added_by_id ;
			added_at_ws_no	= client_ip_address;
		    modified_at_ws_no= added_at_ws_no ;
			modified_facility_id = added_facility_id ;
			term_set_id = request.getParameter("termsetid")==null?"":request.getParameter("termsetid");
			part_term_code = request.getParameter("part_term_code")==null?"":request.getParameter("part_term_code");  
			term_code = request.getParameter("term_code")==null?"":request.getParameter("term_code");  
			code_level = request.getParameter("codelevel")==null?"":request.getParameter("codelevel"); 
			long_desc = request.getParameter("long_desc")==null?"try":request.getParameter("long_desc");
			short_desc = request.getParameter("short_desc")==null?"":request.getParameter("short_desc");
			proc_diag = request.getParameter("proc_diag")==null?"":request.getParameter("proc_diag");
			sensitive = request.getParameter("sensitive")==null?"N":request.getParameter("sensitive");
			notifiable = request.getParameter("notifiable")==null?"N":request.getParameter("notifiable");
			code_indicator = request.getParameter("code_indicator")==null?"":request.getParameter("code_indicator");

			actual_yn = request.getParameter("active")==null?"N":request.getParameter("active");
			potential_yn = request.getParameter("potential")==null?"N":request.getParameter("potential");
			wellness_yn = request.getParameter("wellness")==null?"N":request.getParameter("wellness");
			multi_desc = request.getParameter("multi_desc")==null?"N":request.getParameter("multi_desc"); //added by mujafar for ML-MMOH-CRF-1281
			isMultiDescAppl = request.getParameter("isMultiDescAppl")==null?"N":request.getParameter("isMultiDescAppl");  
			dagger_independent_yn = request.getParameter("dagger_independent_yn")==null?"N":request.getParameter("dagger_independent_yn");
			High_risk_cndn_code = request.getParameter("High_risk_cndn_code")==null?"":request.getParameter("High_risk_cndn_code"); // Added for this CRF [BRU-HIMS-19.1]
			if(proc_diag.equals(""))
			{
				proc = "N";
				diag = "N";
			}
			else if(proc_diag.equals("P"))
			{
				proc = "Y";
				diag = "N";
			}
			else if(proc_diag.equals("D"))
			{
				proc = "N";
				diag = "Y";
			}
			eff_status = request.getParameter("eff_status")==null?"D":request.getParameter("eff_status");
			selectable = request.getParameter("selectable")==null?"N":request.getParameter("selectable");
			Termcodemodifyvalues.put("TERM_SET_ID",term_set_id);
			Termcodemodifyvalues.put("TERM_CODE",term_code);
			Termcodemodifyvalues.put("PART_TERM_CODE",part_term_code);
			Termcodemodifyvalues.put("CODE_LEVEL",code_level);
			Termcodemodifyvalues.put("LONG_DESC",long_desc);
			Termcodemodifyvalues.put("SHORT_DESC",short_desc);
			Termcodemodifyvalues.put("PROCEDURE_YN",proc);
			Termcodemodifyvalues.put("DIAGNOSIS_YN",diag);
			Termcodemodifyvalues.put("EFF_STATUS",eff_status);
			Termcodemodifyvalues.put("SELECT_YN",selectable);
			Termcodemodifyvalues.put("SENSITIVE_YN",sensitive);
			Termcodemodifyvalues.put("NOTIFIABLE_YN",notifiable);
			Termcodemodifyvalues.put("CROSS_REF_TYPE",code_indicator);
			Termcodemodifyvalues.put("ADDED_BY_ID",added_by_id);
			Termcodemodifyvalues.put("ADDED_DATE",new  java.sql.Timestamp(System.currentTimeMillis()));
			Termcodemodifyvalues.put("ADDED_AT_WS_NO",added_at_ws_no);
			Termcodemodifyvalues.put("ADDED_FACILITY_ID",added_facility_id);
			Termcodemodifyvalues.put("MODIFIED_BY_ID",modified_by_id);
			Termcodemodifyvalues.put("MODIFIED_DATE",new  java.sql.Timestamp(System.currentTimeMillis()));
			Termcodemodifyvalues.put("MODIFIED_AT_WS_NO",modified_at_ws_no);
			Termcodemodifyvalues.put("MODIFIED_FACILITY_ID",modified_facility_id);

			Termcodemodifyvalues.put("ACTUAL_YN",actual_yn);
			Termcodemodifyvalues.put("POTENTIAL_YN",potential_yn);
			Termcodemodifyvalues.put("WELLNESS_YN",wellness_yn);
			if(isMultiDescAppl.equals("true")) //added by mujafar for ML-MMOH-CRF-1281
			Termcodemodifyvalues.put("MULTI_DESC_YN",multi_desc);
			Termcodemodifyvalues.put("DAGGER_INDEPENDENT_YN",dagger_independent_yn);
			Termcodemodifyvalues.put("HIGH_RISK_CODE",High_risk_cndn_code); // Added for this CRF [BRU-HIMS-19.1]

			HashMap condflds=new HashMap();
			condflds.put("TERM_CODE",term_code);
			condflds.put("TERM_SET_ID",term_set_id);
		
			try
			{
				String tabname="MR_TERM_CODE";
				boolean local_ejbs = false;
				if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;
				Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
				Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
				Object argArray[] = new Object[4];
				argArray[0] = p;
				argArray[1] = Termcodemodifyvalues;
				argArray[2] = condflds;
				argArray[3] = tabname;
				Class [] paramArray = new Class[4];
				paramArray[0] = p.getClass();
				paramArray[1] = Termcodemodifyvalues.getClass();
				paramArray[2] = condflds.getClass();
				paramArray[3] = tabname.getClass();
				java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("update",paramArray)).invoke(busObj,argArray);
				boolean inserted = (((Boolean)results.get("status")).booleanValue());
				String error = (String) results.get("error") ;
				 if ( inserted )
				   {
					  	error_value= "1";
						response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8" ) + "&err_value=" + error_value );
				   }
				   else
				   {
					    response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8" ) + "&err_value=" + error_value );
				   }
				if ( results != null) results.clear();
			}
			catch(Exception exp)
			{
					  exp.printStackTrace();
					  String error=exp.getMessage();
					  String error_value = "0" ;
					  response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8" ) + "&err_value=" + error_value );
			}
			if (Termcodemodifyvalues != null )  Termcodemodifyvalues.clear();
			if (condflds != null )  condflds.clear();
		}
		catch(Exception e)
		{
		
			out.println("<h3> Exception raised by Servlet ...So Record Not inserted </h3> Foll: Error Received : "+e.toString());
			e.printStackTrace();
		}//end of catch
	}
}
