/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eOH;

import java.lang.reflect.Method;
import java.net.URLEncoder;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.HashMap;
import javax.naming.InitialContext;
import javax.rmi.PortableRemoteObject;
import eCommon.SingleTabHandler.*;
import webbeans.eCommon.*;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import webbeans.eCommon.ConnectionManager;



public class OHParameters extends javax.servlet.http.HttpServlet{
	PrintWriter out;
	HttpSession session;
	java.util.Properties p;
	HashMap results;
	String facility_id="";
	String client_ip_address="";
	String login_user="";
	String locale="";
	String table_name="OH_PARAM";
	int flag=0;
	String msg="";
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String commit_flag = "N";

	java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "yyyy-MM-dd" ) ;

	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	}

	public synchronized void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
		session = req.getSession(false);
		this.p = (java.util.Properties) session.getValue( "jdbc" ) ;
		this.facility_id = (String) session.getValue( "facility_id" ) ;
		login_user = this.p.getProperty( "login_user" ) ;
		locale = this.p.getProperty( "LOCALE" ) ;
		client_ip_address = this.p.getProperty("client_ip_address") ;
		try
		{
			this.out = res.getWriter();
			String operation = req.getParameter("mode");
			if ( operation.equals("insert") )   insert(req, res);
			if ( operation.equals("modify"))    modify(req, res);
		}
		catch(Exception e)
		{
			out.println(e.toString());
		}
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		doPost(req,res);
	}

	private HashMap populateTabData(HttpServletRequest req, HttpServletResponse res){
		String chart_level = "";
		/* String res_rep1 = "";
		String res_rep = "";
		String gingival_recording_by = "";*/	//Commented Against Common-ICN-0031
		String res_rep2 = "";
		String mode = checkForNull(req.getParameter("mode"));
		String gigival_recorded = checkForNull(req.getParameter("gigival_recorded"));
		
        if (gigival_recorded.equals("") || gigival_recorded.equals(null) || gigival_recorded.equals("null")) {
			 gigival_recorded=checkForNull(req.getParameter("gingival_recording_by"));
        }	  
		HashMap tabdata=new HashMap();
		
		   if("insert".equals(mode)){
			chart_level = checkForNull(req.getParameter("chart_level1"));

			String tooth_numbering_system=checkForNull(req.getParameter("tooth_numbering_system"));
			String mixed_dentition_from_age_yrs=checkForNull(req.getParameter("mixed_dentition_from_age_yrs"));
			String mixed_dentition_to_age_yrs = checkForNull(req.getParameter("mixed_dentition_to_age_yrs"));
			String mixed_dentition_from_age_days = checkForNull(req.getParameter("mixed_dentition_from_age_days"));
			String mixed_dentition_to_age_days = checkForNull(req.getParameter("mixed_dentition_to_age_days"));
			String deciduous_grace_period_days = checkForNull(req.getParameter("deciduous_grace_period_days"));
			String dflt_mixed_dentition_chart = checkForNull(req.getParameter("dflt_mixed_dentition_chart"));
			String rest_chrt_validity_days = checkForNull(req.getParameter("rest_chrt_validity_days"));
			String peri_chrt_validity_days = checkForNull(req.getParameter("peri_chrt_validity_days"));
			String record_gingival_status_yn = checkForNull(req.getParameter("record_gingival_status_yn"));
			//String diag_scheme = checkForNull(req.getParameter("diag_scheme"));//Commented Against Common-ICN-0031
			res_rep2 = checkForNull(req.getParameter("res_rep2"));
									
			tabdata.put("chart_level",chart_level);
			tabdata.put("tooth_numbering_system",tooth_numbering_system);
			tabdata.put("mixed_dentition_from_age_yrs",mixed_dentition_from_age_yrs);
			tabdata.put("mixed_dentition_to_age_yrs",mixed_dentition_to_age_yrs);
			tabdata.put("mixed_dentition_from_age_days",mixed_dentition_from_age_days);
			tabdata.put("mixed_dentition_to_age_days",mixed_dentition_to_age_days);
			tabdata.put("deciduous_grace_period_days",deciduous_grace_period_days);
			tabdata.put("dflt_mixed_dentition_chart",dflt_mixed_dentition_chart);
			tabdata.put("rest_chrt_validity_days",rest_chrt_validity_days);
			tabdata.put("peri_chrt_validity_days",peri_chrt_validity_days);
			tabdata.put("record_gingival_status_yn",record_gingival_status_yn);
			tabdata.put("ext_perform_dtls_reqd_yn",res_rep2);
		
			if(record_gingival_status_yn.equals("Y")){
				tabdata.put("gingival_recording_by",gigival_recorded );
			}
			else{
				tabdata.put("gingival_recording_by","" );
			}

			if (gigival_recorded.equals("Q")){
				String gs_no_of_tooth_for_Q1 = checkForNull(req.getParameter("gs_no_of_tooth_for_Q1"));
				String gs_no_of_tooth_for_Q2 = checkForNull(req.getParameter("gs_no_of_tooth_for_Q2"));
				String gs_no_of_tooth_for_Q3 = checkForNull(req.getParameter("gs_no_of_tooth_for_Q3"));
				String gs_no_of_tooth_for_Q4 = checkForNull(req.getParameter("gs_no_of_tooth_for_Q4"));
				String gs_dflt_tooth_no_Q1 = checkForNull(req.getParameter("gs_dflt_tooth_no_Q1"));
				String gs_dflt_tooth_no_Q2 = checkForNull(req.getParameter("gs_dflt_tooth_no_Q2"));
				String gs_dflt_tooth_no_Q3 = checkForNull(req.getParameter("gs_dflt_tooth_no_Q3"));
				String gs_dflt_tooth_no_Q4 = checkForNull(req.getParameter("gs_dflt_tooth_no_Q4"));

				String dec_gs_no_of_tooth_for_Q1 = checkForNull(req.getParameter("dec_gs_no_of_tooth_for_Q1"));
				String dec_gs_no_of_tooth_for_Q2 = checkForNull(req.getParameter("dec_gs_no_of_tooth_for_Q2"));
				String dec_gs_no_of_tooth_for_Q3 = checkForNull(req.getParameter("dec_gs_no_of_tooth_for_Q3"));
				String dec_gs_no_of_tooth_for_Q4 = checkForNull(req.getParameter("dec_gs_no_of_tooth_for_Q4"));
				String dec_gs_dflt_tooth_no_Q1 = checkForNull(req.getParameter("dec_gs_dflt_tooth_no_Q1"));
				String dec_gs_dflt_tooth_no_Q2 = checkForNull(req.getParameter("dec_gs_dflt_tooth_no_Q2"));
				String dec_gs_dflt_tooth_no_Q3 = checkForNull(req.getParameter("dec_gs_dflt_tooth_no_Q3"));
				String dec_gs_dflt_tooth_no_Q4 = checkForNull(req.getParameter("dec_gs_dflt_tooth_no_Q4"));

				String md_gs_no_of_tooth_for_Q1 = checkForNull(req.getParameter("md_gs_no_of_tooth_for_Q1"));
				String md_gs_no_of_tooth_for_Q2 = checkForNull(req.getParameter("md_gs_no_of_tooth_for_Q2"));
				String md_gs_no_of_tooth_for_Q3 = checkForNull(req.getParameter("md_gs_no_of_tooth_for_Q3"));
				String md_gs_no_of_tooth_for_Q4 = checkForNull(req.getParameter("md_gs_no_of_tooth_for_Q4"));
				String md_gs_dflt_tooth_no_Q1 = checkForNull(req.getParameter("md_gs_dflt_tooth_no_Q1"));
				String md_gs_dflt_tooth_no_Q2 = checkForNull(req.getParameter("md_gs_dflt_tooth_no_Q2"));
				String md_gs_dflt_tooth_no_Q3 = checkForNull(req.getParameter("md_gs_dflt_tooth_no_Q3"));
				String md_gs_dflt_tooth_no_Q4 = checkForNull(req.getParameter("md_gs_dflt_tooth_no_Q4"));
			   
				tabdata.put("gs_no_of_tooth_for_Q1",gs_no_of_tooth_for_Q1);
				tabdata.put("gs_no_of_tooth_for_Q2",gs_no_of_tooth_for_Q2);
				tabdata.put("gs_no_of_tooth_for_Q3",gs_no_of_tooth_for_Q3);
				tabdata.put("gs_no_of_tooth_for_Q4",gs_no_of_tooth_for_Q4);
				tabdata.put("gs_dflt_tooth_no_Q1",gs_dflt_tooth_no_Q1);
				tabdata.put("gs_dflt_tooth_no_Q2",gs_dflt_tooth_no_Q2);
				tabdata.put("gs_dflt_tooth_no_Q3",gs_dflt_tooth_no_Q3);
				tabdata.put("gs_dflt_tooth_no_Q4",gs_dflt_tooth_no_Q4);

				tabdata.put("dec_gs_no_of_tooth_for_Q1",dec_gs_no_of_tooth_for_Q1);
				tabdata.put("dec_gs_no_of_tooth_for_Q2",dec_gs_no_of_tooth_for_Q2);
				tabdata.put("dec_gs_no_of_tooth_for_Q3",dec_gs_no_of_tooth_for_Q3);
				tabdata.put("dec_gs_no_of_tooth_for_Q4",dec_gs_no_of_tooth_for_Q4);
				tabdata.put("dec_gs_dflt_tooth_no_Q1",dec_gs_dflt_tooth_no_Q1);
				tabdata.put("dec_gs_dflt_tooth_no_Q2",dec_gs_dflt_tooth_no_Q2);
				tabdata.put("dec_gs_dflt_tooth_no_Q3",dec_gs_dflt_tooth_no_Q3);
				tabdata.put("dec_gs_dflt_tooth_no_Q4",dec_gs_dflt_tooth_no_Q4);

				tabdata.put("md_gs_no_of_tooth_for_Q1",md_gs_no_of_tooth_for_Q1);
				tabdata.put("md_gs_no_of_tooth_for_Q2",md_gs_no_of_tooth_for_Q2);
				tabdata.put("md_gs_no_of_tooth_for_Q3",md_gs_no_of_tooth_for_Q3);
				tabdata.put("md_gs_no_of_tooth_for_Q4",md_gs_no_of_tooth_for_Q4);
				tabdata.put("md_gs_dflt_tooth_no_Q1",md_gs_dflt_tooth_no_Q1);
				tabdata.put("md_gs_dflt_tooth_no_Q2",md_gs_dflt_tooth_no_Q2);
				tabdata.put("md_gs_dflt_tooth_no_Q3",md_gs_dflt_tooth_no_Q3);
				tabdata.put("md_gs_dflt_tooth_no_Q4",md_gs_dflt_tooth_no_Q4);

				tabdata.put("gs_no_of_tooth_for_S1","");
				tabdata.put("gs_no_of_tooth_for_S2","");
				tabdata.put("gs_no_of_tooth_for_S3","");
				tabdata.put("gs_no_of_tooth_for_S4","");
				tabdata.put("gs_no_of_tooth_for_S5","");
				tabdata.put("gs_no_of_tooth_for_S6","");
				tabdata.put("gs_dflt_tooth_no_S1","");
				tabdata.put("gs_dflt_tooth_no_S2","");
				tabdata.put("gs_dflt_tooth_no_S3","");
				tabdata.put("gs_dflt_tooth_no_S4","");
				tabdata.put("gs_dflt_tooth_no_S5","");
				tabdata.put("gs_dflt_tooth_no_S6","");

				tabdata.put("dec_gs_no_of_tooth_for_S1","");
				tabdata.put("dec_gs_no_of_tooth_for_S2","");
				tabdata.put("dec_gs_no_of_tooth_for_S3","");
				tabdata.put("dec_gs_no_of_tooth_for_S4","");
				tabdata.put("dec_gs_no_of_tooth_for_S5","");
				tabdata.put("dec_gs_no_of_tooth_for_S6","");
				tabdata.put("dec_gs_dflt_tooth_no_S1","");
				tabdata.put("dec_gs_dflt_tooth_no_S2","");
				tabdata.put("dec_gs_dflt_tooth_no_S3","");
				tabdata.put("dec_gs_dflt_tooth_no_S4","");
				tabdata.put("dec_gs_dflt_tooth_no_S5","");
				tabdata.put("dec_gs_dflt_tooth_no_S6","");

				tabdata.put("md_gs_no_of_tooth_for_S1","");
				tabdata.put("md_gs_no_of_tooth_for_S2","");
				tabdata.put("md_gs_no_of_tooth_for_S3","");
				tabdata.put("md_gs_no_of_tooth_for_S4","");
				tabdata.put("md_gs_no_of_tooth_for_S5","");
				tabdata.put("md_gs_no_of_tooth_for_S6","");
				tabdata.put("md_gs_dflt_tooth_no_S1","");
				tabdata.put("md_gs_dflt_tooth_no_S2","");
				tabdata.put("md_gs_dflt_tooth_no_S3","");
				tabdata.put("md_gs_dflt_tooth_no_S4","");
				tabdata.put("md_gs_dflt_tooth_no_S5","");
				tabdata.put("md_gs_dflt_tooth_no_S6","");


			}
			else{
				String gs_no_of_tooth_for_S1 = checkForNull(req.getParameter("gs_no_of_tooth_for_S1"));
				String gs_no_of_tooth_for_S2 = checkForNull(req.getParameter("gs_no_of_tooth_for_S2"));
				String gs_no_of_tooth_for_S3 = checkForNull(req.getParameter("gs_no_of_tooth_for_S3"));
				String gs_no_of_tooth_for_S4 = checkForNull(req.getParameter("gs_no_of_tooth_for_S4"));
				String gs_no_of_tooth_for_S5 = checkForNull(req.getParameter("gs_no_of_tooth_for_S5"));
				String gs_no_of_tooth_for_S6 = checkForNull(req.getParameter("gs_no_of_tooth_for_S6"));
				String gs_dflt_tooth_no_S1 = checkForNull(req.getParameter("gs_dflt_tooth_no_S1"));
				String gs_dflt_tooth_no_S2 = checkForNull(req.getParameter("gs_dflt_tooth_no_S2"));
				String gs_dflt_tooth_no_S3 = checkForNull(req.getParameter("gs_dflt_tooth_no_S3"));
				String gs_dflt_tooth_no_S4 = checkForNull(req.getParameter("gs_dflt_tooth_no_S4"));
				String gs_dflt_tooth_no_S5 = checkForNull(req.getParameter("gs_dflt_tooth_no_S5"));
				String gs_dflt_tooth_no_S6 = checkForNull(req.getParameter("gs_dflt_tooth_no_S6"));

				String dec_gs_no_of_tooth_for_S1 = checkForNull(req.getParameter("dec_gs_no_of_tooth_for_S1"));
				String dec_gs_no_of_tooth_for_S2 = checkForNull(req.getParameter("dec_gs_no_of_tooth_for_S2"));
				String dec_gs_no_of_tooth_for_S3 = checkForNull(req.getParameter("dec_gs_no_of_tooth_for_S3"));
				String dec_gs_no_of_tooth_for_S4 = checkForNull(req.getParameter("dec_gs_no_of_tooth_for_S4"));
				String dec_gs_no_of_tooth_for_S5 = checkForNull(req.getParameter("dec_gs_no_of_tooth_for_S5"));
				String dec_gs_no_of_tooth_for_S6 = checkForNull(req.getParameter("dec_gs_no_of_tooth_for_S6"));
				String dec_gs_dflt_tooth_no_S1 = checkForNull(req.getParameter("dec_gs_dflt_tooth_no_S1"));
				String dec_gs_dflt_tooth_no_S2 = checkForNull(req.getParameter("dec_gs_dflt_tooth_no_S2"));
				String dec_gs_dflt_tooth_no_S3 = checkForNull(req.getParameter("dec_gs_dflt_tooth_no_S3"));
				String dec_gs_dflt_tooth_no_S4 = checkForNull(req.getParameter("dec_gs_dflt_tooth_no_S4"));
				String dec_gs_dflt_tooth_no_S5 = checkForNull(req.getParameter("dec_gs_dflt_tooth_no_S5"));
				String dec_gs_dflt_tooth_no_S6 = checkForNull(req.getParameter("dec_gs_dflt_tooth_no_S6"));

				String md_gs_no_of_tooth_for_S1 = checkForNull(req.getParameter("md_gs_no_of_tooth_for_S1"));
				String md_gs_no_of_tooth_for_S2 = checkForNull(req.getParameter("md_gs_no_of_tooth_for_S2"));
				String md_gs_no_of_tooth_for_S3 = checkForNull(req.getParameter("md_gs_no_of_tooth_for_S3"));
				String md_gs_no_of_tooth_for_S4 = checkForNull(req.getParameter("md_gs_no_of_tooth_for_S4"));
				String md_gs_no_of_tooth_for_S5 = checkForNull(req.getParameter("md_gs_no_of_tooth_for_S5"));
				String md_gs_no_of_tooth_for_S6 = checkForNull(req.getParameter("md_gs_no_of_tooth_for_S6"));
				String md_gs_dflt_tooth_no_S1 = checkForNull(req.getParameter("md_gs_dflt_tooth_no_S1"));
				String md_gs_dflt_tooth_no_S2 = checkForNull(req.getParameter("md_gs_dflt_tooth_no_S2"));
				String md_gs_dflt_tooth_no_S3 = checkForNull(req.getParameter("md_gs_dflt_tooth_no_S3"));
				String md_gs_dflt_tooth_no_S4 = checkForNull(req.getParameter("md_gs_dflt_tooth_no_S4"));
				String md_gs_dflt_tooth_no_S5 = checkForNull(req.getParameter("md_gs_dflt_tooth_no_S5"));
				String md_gs_dflt_tooth_no_S6 = checkForNull(req.getParameter("md_gs_dflt_tooth_no_S6"));

				tabdata.put("gs_no_of_tooth_for_S1",gs_no_of_tooth_for_S1);
				tabdata.put("gs_no_of_tooth_for_S2",gs_no_of_tooth_for_S2);
				tabdata.put("gs_no_of_tooth_for_S3",gs_no_of_tooth_for_S3);
				tabdata.put("gs_no_of_tooth_for_S4",gs_no_of_tooth_for_S4);
				tabdata.put("gs_no_of_tooth_for_S5",gs_no_of_tooth_for_S5);
				tabdata.put("gs_no_of_tooth_for_S6",gs_no_of_tooth_for_S6);
				tabdata.put("gs_dflt_tooth_no_S1",gs_dflt_tooth_no_S1);
				tabdata.put("gs_dflt_tooth_no_S2",gs_dflt_tooth_no_S2);
				tabdata.put("gs_dflt_tooth_no_S3",gs_dflt_tooth_no_S3);
				tabdata.put("gs_dflt_tooth_no_S4",gs_dflt_tooth_no_S4);
				tabdata.put("gs_dflt_tooth_no_S5",gs_dflt_tooth_no_S5);
				tabdata.put("gs_dflt_tooth_no_S6",gs_dflt_tooth_no_S6);

				tabdata.put("dec_gs_no_of_tooth_for_S1",dec_gs_no_of_tooth_for_S1);
				tabdata.put("dec_gs_no_of_tooth_for_S2",dec_gs_no_of_tooth_for_S2);
				tabdata.put("dec_gs_no_of_tooth_for_S3",dec_gs_no_of_tooth_for_S3);
				tabdata.put("dec_gs_no_of_tooth_for_S4",dec_gs_no_of_tooth_for_S4);
				tabdata.put("dec_gs_no_of_tooth_for_S5",dec_gs_no_of_tooth_for_S5);
				tabdata.put("dec_gs_no_of_tooth_for_S6",dec_gs_no_of_tooth_for_S6);
				tabdata.put("dec_gs_dflt_tooth_no_S1",dec_gs_dflt_tooth_no_S1);
				tabdata.put("dec_gs_dflt_tooth_no_S2",dec_gs_dflt_tooth_no_S2);
				tabdata.put("dec_gs_dflt_tooth_no_S3",dec_gs_dflt_tooth_no_S3);
				tabdata.put("dec_gs_dflt_tooth_no_S4",dec_gs_dflt_tooth_no_S4);
				tabdata.put("dec_gs_dflt_tooth_no_S5",dec_gs_dflt_tooth_no_S5);
				tabdata.put("dec_gs_dflt_tooth_no_S6",dec_gs_dflt_tooth_no_S6);

				tabdata.put("md_gs_no_of_tooth_for_S1",md_gs_no_of_tooth_for_S1);
				tabdata.put("md_gs_no_of_tooth_for_S2",md_gs_no_of_tooth_for_S2);
				tabdata.put("md_gs_no_of_tooth_for_S3",md_gs_no_of_tooth_for_S3);
				tabdata.put("md_gs_no_of_tooth_for_S4",md_gs_no_of_tooth_for_S4);
				tabdata.put("md_gs_no_of_tooth_for_S5",md_gs_no_of_tooth_for_S5);
				tabdata.put("md_gs_no_of_tooth_for_S6",md_gs_no_of_tooth_for_S6);
			    tabdata.put("md_gs_dflt_tooth_no_S1",md_gs_dflt_tooth_no_S1);
			    tabdata.put("md_gs_dflt_tooth_no_S2",md_gs_dflt_tooth_no_S2);
			    tabdata.put("md_gs_dflt_tooth_no_S3",md_gs_dflt_tooth_no_S3);
			    tabdata.put("md_gs_dflt_tooth_no_S4",md_gs_dflt_tooth_no_S4);
			    tabdata.put("md_gs_dflt_tooth_no_S5",md_gs_dflt_tooth_no_S5);
			    tabdata.put("md_gs_dflt_tooth_no_S6",md_gs_dflt_tooth_no_S6);

				tabdata.put("gs_no_of_tooth_for_Q1","");
				tabdata.put("gs_no_of_tooth_for_Q2","");
				tabdata.put("gs_no_of_tooth_for_Q3","");
				tabdata.put("gs_no_of_tooth_for_Q4","");
				tabdata.put("gs_dflt_tooth_no_Q1","");
				tabdata.put("gs_dflt_tooth_no_Q2","");
				tabdata.put("gs_dflt_tooth_no_Q3","");
				tabdata.put("gs_dflt_tooth_no_Q4","");

				tabdata.put("dec_gs_no_of_tooth_for_Q1","");
				tabdata.put("dec_gs_no_of_tooth_for_Q2","");
				tabdata.put("dec_gs_no_of_tooth_for_Q3","");
				tabdata.put("dec_gs_no_of_tooth_for_Q4","");
				tabdata.put("dec_gs_dflt_tooth_no_Q1","");
				tabdata.put("dec_gs_dflt_tooth_no_Q2","");
				tabdata.put("dec_gs_dflt_tooth_no_Q3","");
				tabdata.put("dec_gs_dflt_tooth_no_Q4","");

				tabdata.put("md_gs_no_of_tooth_for_Q1","");
				tabdata.put("md_gs_no_of_tooth_for_Q2","");
				tabdata.put("md_gs_no_of_tooth_for_Q3","");
				tabdata.put("md_gs_no_of_tooth_for_Q4","");
				tabdata.put("md_gs_dflt_tooth_no_Q1","");
				tabdata.put("md_gs_dflt_tooth_no_Q2","");
				tabdata.put("md_gs_dflt_tooth_no_Q3","");
				tabdata.put("md_gs_dflt_tooth_no_Q4","");


			}
				  
			tabdata.put("added_by_id",login_user);
			tabdata.put("added_date",new  java.sql.Timestamp(System.currentTimeMillis()));
			tabdata.put("added_facility_id", facility_id);
			tabdata.put("added_at_ws_no",client_ip_address);
			tabdata.put("modified_by_id",login_user);
			tabdata.put("modified_date",new  java.sql.Timestamp(System.currentTimeMillis()));
			tabdata.put("modified_facility_id",facility_id);
			tabdata.put("modified_at_ws_no",client_ip_address );
			
		}else if ("modify".equals(mode)){
	  		chart_level = checkForNull(req.getParameter("chart_level1"));
	  		res_rep2 = checkForNull(req.getParameter("res_rep2"));

			if (chart_level.equals("")){
              chart_level=checkForNull(req.getParameter("chrt_level"));
			}			
	
			String tooth_numbering_system=checkForNull(req.getParameter("tooth_numbering_system"));
			String mixed_dentition_from_age_yrs=checkForNull(req.getParameter("mixed_dentition_from_age_yrs"));
			String mixed_dentition_to_age_yrs = checkForNull(req.getParameter("mixed_dentition_to_age_yrs"));
			String mixed_dentition_from_age_days = checkForNull(req.getParameter("mixed_dentition_from_age_days"));
			String mixed_dentition_to_age_days = checkForNull(req.getParameter("mixed_dentition_to_age_days"));
			String deciduous_grace_period_days = checkForNull(req.getParameter("deciduous_grace_period_days"));
			String dflt_mixed_dentition_chart = checkForNull(req.getParameter("dflt_chart"));
			
			if(dflt_mixed_dentition_chart.equals("")){
				dflt_mixed_dentition_chart = checkForNull(req.getParameter("dflt_mixed_dentition_chart"));
			}

			String rest_chrt_validity_days = checkForNull(req.getParameter("rest_chrt_validity_days"));
			String peri_chrt_validity_days = checkForNull(req.getParameter("peri_chrt_validity_days"));

			String record_gingival_status_yn = checkForNull(req.getParameter("record_gingival_status_yn_hid"));
			
			if(record_gingival_status_yn.equals("")){
				record_gingival_status_yn = checkForNull(req.getParameter("record_gingival_status_yn"));
			}
			
   		 	tabdata.put("chart_level",chart_level);//CHART_LEVEL	
   		 	tabdata.put("ext_perform_dtls_reqd_yn",res_rep2);
			tabdata.put("tooth_numbering_system",tooth_numbering_system);
			tabdata.put("mixed_dentition_from_age_yrs",mixed_dentition_from_age_yrs);
			tabdata.put("mixed_dentition_to_age_yrs",mixed_dentition_to_age_yrs);
			tabdata.put("mixed_dentition_from_age_days",mixed_dentition_from_age_days);
			tabdata.put("mixed_dentition_to_age_days",mixed_dentition_to_age_days);
			tabdata.put("deciduous_grace_period_days",deciduous_grace_period_days);
			tabdata.put("dflt_mixed_dentition_chart",dflt_mixed_dentition_chart);
			tabdata.put("rest_chrt_validity_days",rest_chrt_validity_days);
			tabdata.put("peri_chrt_validity_days",peri_chrt_validity_days);
			tabdata.put("record_gingival_status_yn",record_gingival_status_yn);
	 
			if(record_gingival_status_yn.equals("Y")){
				tabdata.put("gingival_recording_by",gigival_recorded);
			}
/*
			if (gigival_recorded.equals("Q")){
				String gs_no_of_tooth_for_Q1 = checkForNull(req.getParameter("gs_no_of_tooth_for_Q1"));
				String gs_no_of_tooth_for_Q2 = checkForNull(req.getParameter("gs_no_of_tooth_for_Q2"));
				String gs_no_of_tooth_for_Q3 = checkForNull(req.getParameter("gs_no_of_tooth_for_Q3"));
				String gs_no_of_tooth_for_Q4 = checkForNull(req.getParameter("gs_no_of_tooth_for_Q4"));
				String gs_dflt_tooth_no_Q1 = checkForNull(req.getParameter("gs_dflt_tooth_no_Q1"));
				String gs_dflt_tooth_no_Q2 = checkForNull(req.getParameter("gs_dflt_tooth_no_Q2"));
				String gs_dflt_tooth_no_Q3 = checkForNull(req.getParameter("gs_dflt_tooth_no_Q3"));
				String gs_dflt_tooth_no_Q4 = checkForNull(req.getParameter("gs_dflt_tooth_no_Q4"));

				String dec_gs_no_of_tooth_for_Q1 = checkForNull(req.getParameter("dec_gs_no_of_tooth_for_Q1"));
				String dec_gs_no_of_tooth_for_Q2 = checkForNull(req.getParameter("dec_gs_no_of_tooth_for_Q2"));
				String dec_gs_no_of_tooth_for_Q3 = checkForNull(req.getParameter("dec_gs_no_of_tooth_for_Q3"));
				String dec_gs_no_of_tooth_for_Q4 = checkForNull(req.getParameter("dec_gs_no_of_tooth_for_Q4"));
				String dec_gs_dflt_tooth_no_Q1 = checkForNull(req.getParameter("dec_gs_dflt_tooth_no_Q1"));
				String dec_gs_dflt_tooth_no_Q2 = checkForNull(req.getParameter("dec_gs_dflt_tooth_no_Q2"));
				String dec_gs_dflt_tooth_no_Q3 = checkForNull(req.getParameter("dec_gs_dflt_tooth_no_Q3"));
				String dec_gs_dflt_tooth_no_Q4 = checkForNull(req.getParameter("dec_gs_dflt_tooth_no_Q4"));

				String md_gs_no_of_tooth_for_Q1 = checkForNull(req.getParameter("md_gs_no_of_tooth_for_Q1"));
				String md_gs_no_of_tooth_for_Q2 = checkForNull(req.getParameter("md_gs_no_of_tooth_for_Q2"));
				String md_gs_no_of_tooth_for_Q3 = checkForNull(req.getParameter("md_gs_no_of_tooth_for_Q3"));
				String md_gs_no_of_tooth_for_Q4 = checkForNull(req.getParameter("md_gs_no_of_tooth_for_Q4"));
				String md_gs_dflt_tooth_no_Q1 = checkForNull(req.getParameter("md_gs_dflt_tooth_no_Q1"));
				String md_gs_dflt_tooth_no_Q2 = checkForNull(req.getParameter("md_gs_dflt_tooth_no_Q2"));
				String md_gs_dflt_tooth_no_Q3 = checkForNull(req.getParameter("md_gs_dflt_tooth_no_Q3"));
				String md_gs_dflt_tooth_no_Q4 = checkForNull(req.getParameter("md_gs_dflt_tooth_no_Q4"));
	   
				tabdata.put("gs_no_of_tooth_for_Q1",gs_no_of_tooth_for_Q1);
				tabdata.put("gs_no_of_tooth_for_Q2",gs_no_of_tooth_for_Q2);
				tabdata.put("gs_no_of_tooth_for_Q3",gs_no_of_tooth_for_Q3);
				tabdata.put("gs_no_of_tooth_for_Q4",gs_no_of_tooth_for_Q4);
				tabdata.put("gs_dflt_tooth_no_Q1",gs_dflt_tooth_no_Q1);
				tabdata.put("gs_dflt_tooth_no_Q2",gs_dflt_tooth_no_Q2);
				tabdata.put("gs_dflt_tooth_no_Q3",gs_dflt_tooth_no_Q3);
				tabdata.put("gs_dflt_tooth_no_Q4",gs_dflt_tooth_no_Q4);

				tabdata.put("dec_gs_no_of_tooth_for_Q1",dec_gs_no_of_tooth_for_Q1);
				tabdata.put("dec_gs_no_of_tooth_for_Q2",dec_gs_no_of_tooth_for_Q2);
				tabdata.put("dec_gs_no_of_tooth_for_Q3",dec_gs_no_of_tooth_for_Q3);
				tabdata.put("dec_gs_no_of_tooth_for_Q4",dec_gs_no_of_tooth_for_Q4);
				tabdata.put("dec_gs_dflt_tooth_no_Q1",dec_gs_dflt_tooth_no_Q1);
				tabdata.put("dec_gs_dflt_tooth_no_Q2",dec_gs_dflt_tooth_no_Q2);
				tabdata.put("dec_gs_dflt_tooth_no_Q3",dec_gs_dflt_tooth_no_Q3);
				tabdata.put("dec_gs_dflt_tooth_no_Q4",dec_gs_dflt_tooth_no_Q4);

				tabdata.put("md_gs_no_of_tooth_for_Q1",md_gs_no_of_tooth_for_Q1);
				tabdata.put("md_gs_no_of_tooth_for_Q2",md_gs_no_of_tooth_for_Q2);
				tabdata.put("md_gs_no_of_tooth_for_Q3",md_gs_no_of_tooth_for_Q3);
				tabdata.put("md_gs_no_of_tooth_for_Q4",md_gs_no_of_tooth_for_Q4);
				tabdata.put("md_gs_dflt_tooth_no_Q1",md_gs_dflt_tooth_no_Q1);
				tabdata.put("md_gs_dflt_tooth_no_Q2",md_gs_dflt_tooth_no_Q2);
				tabdata.put("md_gs_dflt_tooth_no_Q3",md_gs_dflt_tooth_no_Q3);
				tabdata.put("md_gs_dflt_tooth_no_Q4",md_gs_dflt_tooth_no_Q4);


				tabdata.put("gs_no_of_tooth_for_S1","");
				tabdata.put("gs_no_of_tooth_for_S2","");
				tabdata.put("gs_no_of_tooth_for_S3","");
				tabdata.put("gs_no_of_tooth_for_S4","");
				tabdata.put("gs_no_of_tooth_for_S5","");
				tabdata.put("gs_no_of_tooth_for_S6","");
				tabdata.put("gs_dflt_tooth_no_S1","");
				tabdata.put("gs_dflt_tooth_no_S2","");
				tabdata.put("gs_dflt_tooth_no_S3","");
				tabdata.put("gs_dflt_tooth_no_S4","");
				tabdata.put("gs_dflt_tooth_no_S5","");
				tabdata.put("gs_dflt_tooth_no_S6","");

				
				tabdata.put("dec_gs_no_of_tooth_for_S1","");
				tabdata.put("dec_gs_no_of_tooth_for_S2","");
				tabdata.put("dec_gs_no_of_tooth_for_S3","");
				tabdata.put("dec_gs_no_of_tooth_for_S4","");
				tabdata.put("dec_gs_no_of_tooth_for_S5","");
				tabdata.put("dec_gs_no_of_tooth_for_S6","");
				tabdata.put("dec_gs_dflt_tooth_no_S1","");
				tabdata.put("dec_gs_dflt_tooth_no_S2","");
				tabdata.put("dec_gs_dflt_tooth_no_S3","");
				tabdata.put("dec_gs_dflt_tooth_no_S4","");
				tabdata.put("dec_gs_dflt_tooth_no_S5","");
				tabdata.put("dec_gs_dflt_tooth_no_S6","");

				tabdata.put("md_gs_no_of_tooth_for_S1","");
				tabdata.put("md_gs_no_of_tooth_for_S2","");
				tabdata.put("md_gs_no_of_tooth_for_S3","");
				tabdata.put("md_gs_no_of_tooth_for_S4","");
				tabdata.put("md_gs_no_of_tooth_for_S5","");
				tabdata.put("md_gs_no_of_tooth_for_S6","");
				tabdata.put("md_gs_dflt_tooth_no_S1","");
				tabdata.put("md_gs_dflt_tooth_no_S2","");
				tabdata.put("md_gs_dflt_tooth_no_S3","");
				tabdata.put("md_gs_dflt_tooth_no_S4","");
				tabdata.put("md_gs_dflt_tooth_no_S5","");
				tabdata.put("md_gs_dflt_tooth_no_S6","");
			}
			else{
				String gs_no_of_tooth_for_S1 = checkForNull(req.getParameter("gs_no_of_tooth_for_S1"));
				String gs_no_of_tooth_for_S2 = checkForNull(req.getParameter("gs_no_of_tooth_for_S2"));
				String gs_no_of_tooth_for_S3 = checkForNull(req.getParameter("gs_no_of_tooth_for_S3"));
				String gs_no_of_tooth_for_S4 = checkForNull(req.getParameter("gs_no_of_tooth_for_S4"));
				String gs_no_of_tooth_for_S5 = checkForNull(req.getParameter("gs_no_of_tooth_for_S5"));
				String gs_no_of_tooth_for_S6 = checkForNull(req.getParameter("gs_no_of_tooth_for_S6"));
				String gs_dflt_tooth_no_S1 = checkForNull(req.getParameter("gs_dflt_tooth_no_S1"));
				String gs_dflt_tooth_no_S2 = checkForNull(req.getParameter("gs_dflt_tooth_no_S2"));
				String gs_dflt_tooth_no_S3 = checkForNull(req.getParameter("gs_dflt_tooth_no_S3"));
				String gs_dflt_tooth_no_S4 = checkForNull(req.getParameter("gs_dflt_tooth_no_S4"));
				String gs_dflt_tooth_no_S5 = checkForNull(req.getParameter("gs_dflt_tooth_no_S5"));
				String gs_dflt_tooth_no_S6 = checkForNull(req.getParameter("gs_dflt_tooth_no_S6"));

				String dec_gs_no_of_tooth_for_S1 = checkForNull(req.getParameter("dec_gs_no_of_tooth_for_S1"));
				String dec_gs_no_of_tooth_for_S2 = checkForNull(req.getParameter("dec_gs_no_of_tooth_for_S2"));
				String dec_gs_no_of_tooth_for_S3 = checkForNull(req.getParameter("dec_gs_no_of_tooth_for_S3"));
				String dec_gs_no_of_tooth_for_S4 = checkForNull(req.getParameter("dec_gs_no_of_tooth_for_S4"));
				String dec_gs_no_of_tooth_for_S5 = checkForNull(req.getParameter("dec_gs_no_of_tooth_for_S5"));
				String dec_gs_no_of_tooth_for_S6 = checkForNull(req.getParameter("dec_gs_no_of_tooth_for_S6"));
				String dec_gs_dflt_tooth_no_S1 = checkForNull(req.getParameter("dec_gs_dflt_tooth_no_S1"));
				String dec_gs_dflt_tooth_no_S2 = checkForNull(req.getParameter("dec_gs_dflt_tooth_no_S2"));
				String dec_gs_dflt_tooth_no_S3 = checkForNull(req.getParameter("dec_gs_dflt_tooth_no_S3"));
				String dec_gs_dflt_tooth_no_S4 = checkForNull(req.getParameter("dec_gs_dflt_tooth_no_S4"));
				String dec_gs_dflt_tooth_no_S5 = checkForNull(req.getParameter("dec_gs_dflt_tooth_no_S5"));
				String dec_gs_dflt_tooth_no_S6 = checkForNull(req.getParameter("dec_gs_dflt_tooth_no_S6"));

				String md_gs_no_of_tooth_for_S1 = checkForNull(req.getParameter("md_gs_no_of_tooth_for_S1"));
				String md_gs_no_of_tooth_for_S2 = checkForNull(req.getParameter("md_gs_no_of_tooth_for_S2"));
				String md_gs_no_of_tooth_for_S3 = checkForNull(req.getParameter("md_gs_no_of_tooth_for_S3"));
				String md_gs_no_of_tooth_for_S4 = checkForNull(req.getParameter("md_gs_no_of_tooth_for_S4"));
				String md_gs_no_of_tooth_for_S5 = checkForNull(req.getParameter("md_gs_no_of_tooth_for_S5"));
				String md_gs_no_of_tooth_for_S6 = checkForNull(req.getParameter("md_gs_no_of_tooth_for_S6"));
				String md_gs_dflt_tooth_no_S1 = checkForNull(req.getParameter("md_gs_dflt_tooth_no_S1"));
				String md_gs_dflt_tooth_no_S2 = checkForNull(req.getParameter("md_gs_dflt_tooth_no_S2"));
				String md_gs_dflt_tooth_no_S3 = checkForNull(req.getParameter("md_gs_dflt_tooth_no_S3"));
				String md_gs_dflt_tooth_no_S4 = checkForNull(req.getParameter("md_gs_dflt_tooth_no_S4"));
				String md_gs_dflt_tooth_no_S5 = checkForNull(req.getParameter("md_gs_dflt_tooth_no_S5"));
				String md_gs_dflt_tooth_no_S6 = checkForNull(req.getParameter("md_gs_dflt_tooth_no_S6"));

				tabdata.put("gs_no_of_tooth_for_S1",gs_no_of_tooth_for_S1);
				tabdata.put("gs_no_of_tooth_for_S2",gs_no_of_tooth_for_S2);
				tabdata.put("gs_no_of_tooth_for_S3",gs_no_of_tooth_for_S3);
				tabdata.put("gs_no_of_tooth_for_S4",gs_no_of_tooth_for_S4);
				tabdata.put("gs_no_of_tooth_for_S5",gs_no_of_tooth_for_S5);
				tabdata.put("gs_no_of_tooth_for_S6",gs_no_of_tooth_for_S6);
				tabdata.put("gs_dflt_tooth_no_S1",gs_dflt_tooth_no_S1);
				tabdata.put("gs_dflt_tooth_no_S2",gs_dflt_tooth_no_S2);
				tabdata.put("gs_dflt_tooth_no_S3",gs_dflt_tooth_no_S3);
				tabdata.put("gs_dflt_tooth_no_S4",gs_dflt_tooth_no_S4);
				tabdata.put("gs_dflt_tooth_no_S5",gs_dflt_tooth_no_S5);
				tabdata.put("gs_dflt_tooth_no_S6",gs_dflt_tooth_no_S6);

				tabdata.put("dec_gs_no_of_tooth_for_S1",dec_gs_no_of_tooth_for_S1);
				tabdata.put("dec_gs_no_of_tooth_for_S2",dec_gs_no_of_tooth_for_S2);
				tabdata.put("dec_gs_no_of_tooth_for_S3",dec_gs_no_of_tooth_for_S3);
				tabdata.put("dec_gs_no_of_tooth_for_S4",dec_gs_no_of_tooth_for_S4);
				tabdata.put("dec_gs_no_of_tooth_for_S5",dec_gs_no_of_tooth_for_S5);
				tabdata.put("dec_gs_no_of_tooth_for_S6",dec_gs_no_of_tooth_for_S6);
				tabdata.put("dec_gs_dflt_tooth_no_S1",dec_gs_dflt_tooth_no_S1);
				tabdata.put("dec_gs_dflt_tooth_no_S2",dec_gs_dflt_tooth_no_S2);
				tabdata.put("dec_gs_dflt_tooth_no_S3",dec_gs_dflt_tooth_no_S3);
				tabdata.put("dec_gs_dflt_tooth_no_S4",dec_gs_dflt_tooth_no_S4);
				tabdata.put("dec_gs_dflt_tooth_no_S5",dec_gs_dflt_tooth_no_S5);
				tabdata.put("dec_gs_dflt_tooth_no_S6",dec_gs_dflt_tooth_no_S6);

				tabdata.put("md_gs_no_of_tooth_for_S1",md_gs_no_of_tooth_for_S1);
				tabdata.put("md_gs_no_of_tooth_for_S2",md_gs_no_of_tooth_for_S2);
				tabdata.put("md_gs_no_of_tooth_for_S3",md_gs_no_of_tooth_for_S3);
				tabdata.put("md_gs_no_of_tooth_for_S4",md_gs_no_of_tooth_for_S4);
				tabdata.put("md_gs_no_of_tooth_for_S5",md_gs_no_of_tooth_for_S5);
				tabdata.put("md_gs_no_of_tooth_for_S6",md_gs_no_of_tooth_for_S6);
			    tabdata.put("md_gs_dflt_tooth_no_S1",md_gs_dflt_tooth_no_S1);
			    tabdata.put("md_gs_dflt_tooth_no_S2",md_gs_dflt_tooth_no_S2);
			    tabdata.put("md_gs_dflt_tooth_no_S3",md_gs_dflt_tooth_no_S3);
			    tabdata.put("md_gs_dflt_tooth_no_S4",md_gs_dflt_tooth_no_S4);
			    tabdata.put("md_gs_dflt_tooth_no_S5",md_gs_dflt_tooth_no_S5);
			    tabdata.put("md_gs_dflt_tooth_no_S6",md_gs_dflt_tooth_no_S6);

				tabdata.put("gs_no_of_tooth_for_Q1","");
				tabdata.put("gs_no_of_tooth_for_Q2","");
				tabdata.put("gs_no_of_tooth_for_Q3","");
				tabdata.put("gs_no_of_tooth_for_Q4","");
				tabdata.put("gs_dflt_tooth_no_Q1","");
				tabdata.put("gs_dflt_tooth_no_Q2","");
				tabdata.put("gs_dflt_tooth_no_Q3","");
				tabdata.put("gs_dflt_tooth_no_Q4","");

				tabdata.put("dec_gs_no_of_tooth_for_Q1","");
				tabdata.put("dec_gs_no_of_tooth_for_Q2","");
				tabdata.put("dec_gs_no_of_tooth_for_Q3","");
				tabdata.put("dec_gs_no_of_tooth_for_Q4","");
				tabdata.put("dec_gs_dflt_tooth_no_Q1","");
				tabdata.put("dec_gs_dflt_tooth_no_Q2","");
				tabdata.put("dec_gs_dflt_tooth_no_Q3","");
				tabdata.put("dec_gs_dflt_tooth_no_Q4","");

				tabdata.put("md_gs_no_of_tooth_for_Q1","");
				tabdata.put("md_gs_no_of_tooth_for_Q2","");
				tabdata.put("md_gs_no_of_tooth_for_Q3","");
				tabdata.put("md_gs_no_of_tooth_for_Q4","");
				tabdata.put("md_gs_dflt_tooth_no_Q1","");
				tabdata.put("md_gs_dflt_tooth_no_Q2","");
				tabdata.put("md_gs_dflt_tooth_no_Q3","");
				tabdata.put("md_gs_dflt_tooth_no_Q4","");
			}
				*/  
			tabdata.put("modified_by_id",login_user);
			tabdata.put("modified_date",new  java.sql.Timestamp(System.currentTimeMillis()));
			tabdata.put("modified_facility_id",facility_id);
			tabdata.put("modified_at_ws_no",client_ip_address );
			
		}
	
   return tabdata;
}

	private Object getRemoteObject(){
		boolean local_ejbs = isLocalEJB();
		Object busObj=null;
		try{
			Object home =com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
			
			//Get the remote object by invoking create method on the home object using reflection
			busObj =	(home.getClass().getMethod("create",null)).invoke(home,null);
		}catch(Exception e){
				out.println(e.toString());
		}
		return busObj;
	}

	
	private void insert(HttpServletRequest req, HttpServletResponse res){
		//String chart_level = checkForNull(req.getParameter("chart_level1"));
		
		HashMap tabData = populateTabData(req,res);
		String dupflds[]={"chart_level"};
		Object argArray[]  = new Object[4];
		argArray[0] = p;
		argArray[1] = tabData;				   
		argArray[2] = dupflds;
		argArray[3] = table_name;

		//Create a class array, containing the class types of the arguments passed
		Class [] paramArray	   = new Class[4];
		paramArray[0] = p.getClass();
		paramArray[1] = tabData.getClass();
		paramArray[2] = dupflds.getClass();
		paramArray[3] = table_name.getClass();
		
		try{
			Object busObj =	getRemoteObject();
			results =(HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
			boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
			String error = (String) results.get("error") ;
			String error_value = "0" ;
			if ( inserted ){
				 error_value = "1" ;
			}else{
				 error = (String) results.get("error") ;
			}
			error = (String) results.get("error") ;
			res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8" ) +"&err_value="+error_value );
		}
		catch ( Exception e ){
			out.println(" Exception raised ...So Record Not insertedFoll: Error Received : "+e.toString());
		}
		finally
		{
			try{
		tabData.clear();	//Common-ICN-0044
		}catch(Exception e){}
		}
	}
// modify mode is commented by parul on 10/08/2009 for crf  0456(IN009737) and written seprate query....
	/*private void modify(HttpServletRequest req, HttpServletResponse res){
		String chart_level = checkForNull(req.getParameter("chart_level1"));
		HashMap tabData = populateTabData(req,res);
		HashMap condflds=new HashMap();
		condflds.put("chart_level",chart_level);
		Object argArray[]  = new Object[4];
		argArray[0] = p;
		argArray[1] = tabData;				   
		argArray[2] = condflds;
		argArray[3] = table_name;
		Class [] paramArray	   = new Class[4];
		paramArray[0] = p.getClass();
		paramArray[1] = tabData.getClass();
		paramArray[2] = condflds.getClass();
		paramArray[3] = table_name.getClass();

		try{   
			Object busObj = getRemoteObject();
			results =(HashMap)(busObj.getClass().getMethod("update",paramArray)).invoke(busObj,argArray);

			boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
			String error = (String) results.get("error") ;
			String error_value = "0" ;
			if ( inserted ){
				error_value = "1" ;
			}else{
				error = (String) results.get("error") ;
			}
       		error = (String) results.get("error") ;
    		res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8" ) +"&err_value="+error_value);
		}
		catch ( Exception e ){
			out.println("<h3> Exception raised by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
		}
	}*/

	private void modify(HttpServletRequest req, HttpServletResponse res){
			//HashMap tabData = populateTabData(req,res);	//Commented Against Common-ICN-0031
			try{ 
				//String chart_level = checkForNull(req.getParameter("chrt_level"));
				String chart_level = checkForNull(req.getParameter("chart_level1"));
				//String chart_level_1 = checkForNull(req.getParameter("chrt_level"));	//Commented Against Common-ICN-0031
				String res_rep2 = checkForNull(req.getParameter("res_rep2"));

				String gigival_recorded = checkForNull(req.getParameter("gigival_recorded"));
				String chk_recorded = checkForNull(req.getParameter("chk_recorded"));

				//String gingival_recording_by = "";	//Commented Against Common-ICN-0031
				if (gigival_recorded.equals("") || gigival_recorded.equals(null) || gigival_recorded.equals("null")) {
					 gigival_recorded=checkForNull(req.getParameter("gingival_recording_by"));
				}		  
                if (chart_level.equals("")){
				 chart_level=checkForNull(req.getParameter("chrt_level"));
				}
				String tooth_numbering_system=checkForNull(req.getParameter("tooth_numbering_system"));
				String mixed_dentition_from_age_yrs=checkForNull(req.getParameter("mixed_dentition_from_age_yrs"));
				String mixed_dentition_to_age_yrs = checkForNull(req.getParameter("mixed_dentition_to_age_yrs"));
				String mixed_dentition_from_age_days = checkForNull(req.getParameter("mixed_dentition_from_age_days"));
				String mixed_dentition_to_age_days = checkForNull(req.getParameter("mixed_dentition_to_age_days"));
				String deciduous_grace_period_days = checkForNull(req.getParameter("deciduous_grace_period_days"));
				String dflt_mixed_dentition_chart = checkForNull(req.getParameter("dflt_chart"));
				
				if(dflt_mixed_dentition_chart.equals("")){
					dflt_mixed_dentition_chart = checkForNull(req.getParameter("dflt_mixed_dentition_chart"));
				}
				
				String rest_chrt_validity_days = checkForNull(req.getParameter("rest_chrt_validity_days"));
				String peri_chrt_validity_days = checkForNull(req.getParameter("peri_chrt_validity_days"));
				String record_gingival_status_yn = checkForNull(req.getParameter("record_gingival_status_yn_hid"));
				
				if(record_gingival_status_yn.equals("")){
					record_gingival_status_yn = checkForNull(req.getParameter("record_gingival_status_yn"));
				}
				
				String gs_no_of_tooth_for_Q1 = checkForNull(req.getParameter("gs_no_of_tooth_for_Q1"));
				String gs_no_of_tooth_for_Q2 = checkForNull(req.getParameter("gs_no_of_tooth_for_Q2"));
				String gs_no_of_tooth_for_Q3 = checkForNull(req.getParameter("gs_no_of_tooth_for_Q3"));
				String gs_no_of_tooth_for_Q4 = checkForNull(req.getParameter("gs_no_of_tooth_for_Q4"));
				String gs_dflt_tooth_no_Q1 = checkForNull(req.getParameter("gs_dflt_tooth_no_Q1"));
				String gs_dflt_tooth_no_Q2 = checkForNull(req.getParameter("gs_dflt_tooth_no_Q2"));
				String gs_dflt_tooth_no_Q3 = checkForNull(req.getParameter("gs_dflt_tooth_no_Q3"));
				String gs_dflt_tooth_no_Q4 = checkForNull(req.getParameter("gs_dflt_tooth_no_Q4"));

				String dec_gs_no_of_tooth_for_Q1 = checkForNull(req.getParameter("dec_gs_no_of_tooth_for_Q1"));
				String dec_gs_no_of_tooth_for_Q2 = checkForNull(req.getParameter("dec_gs_no_of_tooth_for_Q2"));
				String dec_gs_no_of_tooth_for_Q3 = checkForNull(req.getParameter("dec_gs_no_of_tooth_for_Q3"));
				String dec_gs_no_of_tooth_for_Q4 = checkForNull(req.getParameter("dec_gs_no_of_tooth_for_Q4"));
				String dec_gs_dflt_tooth_no_Q1 = checkForNull(req.getParameter("dec_gs_dflt_tooth_no_Q1"));
				String dec_gs_dflt_tooth_no_Q2 = checkForNull(req.getParameter("dec_gs_dflt_tooth_no_Q2"));
				String dec_gs_dflt_tooth_no_Q3 = checkForNull(req.getParameter("dec_gs_dflt_tooth_no_Q3"));
				String dec_gs_dflt_tooth_no_Q4 = checkForNull(req.getParameter("dec_gs_dflt_tooth_no_Q4"));

				String md_gs_no_of_tooth_for_Q1 = checkForNull(req.getParameter("md_gs_no_of_tooth_for_Q1"));
				String md_gs_no_of_tooth_for_Q2 = checkForNull(req.getParameter("md_gs_no_of_tooth_for_Q2"));
				String md_gs_no_of_tooth_for_Q3 = checkForNull(req.getParameter("md_gs_no_of_tooth_for_Q3"));
				String md_gs_no_of_tooth_for_Q4 = checkForNull(req.getParameter("md_gs_no_of_tooth_for_Q4"));
				String md_gs_dflt_tooth_no_Q1 = checkForNull(req.getParameter("md_gs_dflt_tooth_no_Q1"));
				String md_gs_dflt_tooth_no_Q2 = checkForNull(req.getParameter("md_gs_dflt_tooth_no_Q2"));
				String md_gs_dflt_tooth_no_Q3 = checkForNull(req.getParameter("md_gs_dflt_tooth_no_Q3"));
				String md_gs_dflt_tooth_no_Q4 = checkForNull(req.getParameter("md_gs_dflt_tooth_no_Q4"));

				String gs_no_of_tooth_for_S1 = checkForNull(req.getParameter("gs_no_of_tooth_for_S1"));
				String gs_no_of_tooth_for_S2 = checkForNull(req.getParameter("gs_no_of_tooth_for_S2"));
				String gs_no_of_tooth_for_S3 = checkForNull(req.getParameter("gs_no_of_tooth_for_S3"));
				String gs_no_of_tooth_for_S4 = checkForNull(req.getParameter("gs_no_of_tooth_for_S4"));
				String gs_no_of_tooth_for_S5 = checkForNull(req.getParameter("gs_no_of_tooth_for_S5"));
				String gs_no_of_tooth_for_S6 = checkForNull(req.getParameter("gs_no_of_tooth_for_S6"));
				String gs_dflt_tooth_no_S1 = checkForNull(req.getParameter("gs_dflt_tooth_no_S1"));
				String gs_dflt_tooth_no_S2 = checkForNull(req.getParameter("gs_dflt_tooth_no_S2"));
				String gs_dflt_tooth_no_S3 = checkForNull(req.getParameter("gs_dflt_tooth_no_S3"));
				String gs_dflt_tooth_no_S4 = checkForNull(req.getParameter("gs_dflt_tooth_no_S4"));
				String gs_dflt_tooth_no_S5 = checkForNull(req.getParameter("gs_dflt_tooth_no_S5"));
				String gs_dflt_tooth_no_S6 = checkForNull(req.getParameter("gs_dflt_tooth_no_S6"));

				
				String dec_gs_no_of_tooth_for_S1 = checkForNull(req.getParameter("dec_gs_no_of_tooth_for_S1"));
				String dec_gs_no_of_tooth_for_S2 = checkForNull(req.getParameter("dec_gs_no_of_tooth_for_S2"));
				String dec_gs_no_of_tooth_for_S3 = checkForNull(req.getParameter("dec_gs_no_of_tooth_for_S3"));
				String dec_gs_no_of_tooth_for_S4 = checkForNull(req.getParameter("dec_gs_no_of_tooth_for_S4"));
				String dec_gs_no_of_tooth_for_S5 = checkForNull(req.getParameter("dec_gs_no_of_tooth_for_S5"));
				String dec_gs_no_of_tooth_for_S6 = checkForNull(req.getParameter("dec_gs_no_of_tooth_for_S6"));
				String dec_gs_dflt_tooth_no_S1 = checkForNull(req.getParameter("dec_gs_dflt_tooth_no_S1"));
				String dec_gs_dflt_tooth_no_S2 = checkForNull(req.getParameter("dec_gs_dflt_tooth_no_S2"));
				String dec_gs_dflt_tooth_no_S3 = checkForNull(req.getParameter("dec_gs_dflt_tooth_no_S3"));
				String dec_gs_dflt_tooth_no_S4 = checkForNull(req.getParameter("dec_gs_dflt_tooth_no_S4"));
				String dec_gs_dflt_tooth_no_S5 = checkForNull(req.getParameter("dec_gs_dflt_tooth_no_S5"));
				String dec_gs_dflt_tooth_no_S6 = checkForNull(req.getParameter("dec_gs_dflt_tooth_no_S6"));

				String md_gs_no_of_tooth_for_S1 = checkForNull(req.getParameter("md_gs_no_of_tooth_for_S1"));
				String md_gs_no_of_tooth_for_S2 = checkForNull(req.getParameter("md_gs_no_of_tooth_for_S2"));
				String md_gs_no_of_tooth_for_S3 = checkForNull(req.getParameter("md_gs_no_of_tooth_for_S3"));
				String md_gs_no_of_tooth_for_S4 = checkForNull(req.getParameter("md_gs_no_of_tooth_for_S4"));
				String md_gs_no_of_tooth_for_S5 = checkForNull(req.getParameter("md_gs_no_of_tooth_for_S5"));
				String md_gs_no_of_tooth_for_S6 = checkForNull(req.getParameter("md_gs_no_of_tooth_for_S6"));
				String md_gs_dflt_tooth_no_S1 = checkForNull(req.getParameter("md_gs_dflt_tooth_no_S1"));
				String md_gs_dflt_tooth_no_S2 = checkForNull(req.getParameter("md_gs_dflt_tooth_no_S2"));
				String md_gs_dflt_tooth_no_S3 = checkForNull(req.getParameter("md_gs_dflt_tooth_no_S3"));
				String md_gs_dflt_tooth_no_S4 = checkForNull(req.getParameter("md_gs_dflt_tooth_no_S4"));
				String md_gs_dflt_tooth_no_S5 = checkForNull(req.getParameter("md_gs_dflt_tooth_no_S5"));
				String md_gs_dflt_tooth_no_S6 = checkForNull(req.getParameter("md_gs_dflt_tooth_no_S6"));

				con = ConnectionManager.getConnection(req);
				//pstmt=con.prepareStatement("UPDATE OH_PARAM SET  MODIFIED_BY_ID=?,MODIFIED_DATE=SYSDATE,MODIFIED_AT_WS_NO=?,MODIFIED_FACILITY_ID=?,CHART_LEVEL=?");
             // if (!chart_level.equals("")) {
				if (gigival_recorded.equals("Q")){
						pstmt=con.prepareStatement("UPDATE OH_PARAM SET  MODIFIED_BY_ID=?,MODIFIED_DATE=SYSDATE,MODIFIED_AT_WS_NO=?,MODIFIED_FACILITY_ID=?,CHART_LEVEL=?,TOOTH_NUMBERING_SYSTEM=?,MIXED_DENTITION_FROM_AGE_YRS=?,MIXED_DENTITION_TO_AGE_YRS=?,MIXED_DENTITION_FROM_AGE_DAYS=?,MIXED_DENTITION_TO_AGE_DAYS=?,DECIDUOUS_GRACE_PERIOD_DAYS=?,DFLT_MIXED_DENTITION_CHART=?,REST_CHRT_VALIDITY_DAYS=?,PERI_CHRT_VALIDITY_DAYS=?,RECORD_GINGIVAL_STATUS_YN=?,GINGIVAL_RECORDING_BY=?,GS_NO_OF_TOOTH_FOR_Q1=?,GS_NO_OF_TOOTH_FOR_Q2=?,GS_NO_OF_TOOTH_FOR_Q3=?,GS_NO_OF_TOOTH_FOR_Q4=?,GS_DFLT_TOOTH_NO_Q1=?,GS_DFLT_TOOTH_NO_Q2=?,GS_DFLT_TOOTH_NO_Q3=?,GS_DFLT_TOOTH_NO_Q4=?,DEC_GS_NO_OF_TOOTH_FOR_Q1=?,DEC_GS_NO_OF_TOOTH_FOR_Q2=?,DEC_GS_NO_OF_TOOTH_FOR_Q3=?,DEC_GS_NO_OF_TOOTH_FOR_Q4=?,DEC_GS_DFLT_TOOTH_NO_Q1=?,DEC_GS_DFLT_TOOTH_NO_Q2=?,DEC_GS_DFLT_TOOTH_NO_Q3=?,DEC_GS_DFLT_TOOTH_NO_Q4=?,MD_GS_NO_OF_TOOTH_FOR_Q1=?,MD_GS_NO_OF_TOOTH_FOR_Q2=?,MD_GS_NO_OF_TOOTH_FOR_Q3=?,MD_GS_NO_OF_TOOTH_FOR_Q4=?,MD_GS_DFLT_TOOTH_NO_Q1=?,MD_GS_DFLT_TOOTH_NO_Q2=?,MD_GS_DFLT_TOOTH_NO_Q3=?,MD_GS_DFLT_TOOTH_NO_Q4=?,EXT_PERFORM_DTLS_REQD_YN=?");											
						pstmt.setString(1,login_user);//MODIFIED_BY_ID
						pstmt.setString(2,client_ip_address);//MODIFIED_AT_WS_NO
						pstmt.setString(3,facility_id);//MODIFIED_FACILITY_ID
						pstmt.setString(4,chart_level);//CHART_LEVEL
						pstmt.setString(5,tooth_numbering_system);
						pstmt.setString(6,mixed_dentition_from_age_yrs);
						pstmt.setString(7,mixed_dentition_to_age_yrs);
						pstmt.setString(8,mixed_dentition_from_age_days);						
						pstmt.setString(9,mixed_dentition_to_age_days);
						pstmt.setString(10,deciduous_grace_period_days);
						pstmt.setString(11,dflt_mixed_dentition_chart);
						pstmt.setString(12,rest_chrt_validity_days);
						pstmt.setString(13,peri_chrt_validity_days);
						pstmt.setString(14,record_gingival_status_yn);
						pstmt.setString(15,gigival_recorded);
						pstmt.setString(16,gs_no_of_tooth_for_Q1);
						pstmt.setString(17,gs_no_of_tooth_for_Q2);
						pstmt.setString(18,gs_no_of_tooth_for_Q3);
						pstmt.setString(19,gs_no_of_tooth_for_Q4);
						pstmt.setString(20,gs_dflt_tooth_no_Q1);
						pstmt.setString(21,gs_dflt_tooth_no_Q2);
						pstmt.setString(22,gs_dflt_tooth_no_Q3);
						pstmt.setString(23,gs_dflt_tooth_no_Q4);
						pstmt.setString(24,dec_gs_no_of_tooth_for_Q1);
						pstmt.setString(25,dec_gs_no_of_tooth_for_Q2);
						pstmt.setString(26,dec_gs_no_of_tooth_for_Q3);
						pstmt.setString(27,dec_gs_no_of_tooth_for_Q4);
						pstmt.setString(28,dec_gs_dflt_tooth_no_Q1);
						pstmt.setString(29,dec_gs_dflt_tooth_no_Q2);						
						pstmt.setString(30,dec_gs_dflt_tooth_no_Q3);
						pstmt.setString(31,dec_gs_dflt_tooth_no_Q4);
						pstmt.setString(32,md_gs_no_of_tooth_for_Q1);
						pstmt.setString(33,md_gs_no_of_tooth_for_Q2);
						pstmt.setString(34,md_gs_no_of_tooth_for_Q3);
						pstmt.setString(35,md_gs_no_of_tooth_for_Q4);
						pstmt.setString(36,md_gs_dflt_tooth_no_Q1);
						pstmt.setString(37,md_gs_dflt_tooth_no_Q2);
						pstmt.setString(38,md_gs_dflt_tooth_no_Q3);
						pstmt.setString(39,md_gs_dflt_tooth_no_Q4);
						pstmt.setString(40,res_rep2);
						
						flag = pstmt.executeUpdate();
				}else if (gigival_recorded.equals("S")){
						pstmt=con.prepareStatement("UPDATE OH_PARAM SET  MODIFIED_BY_ID=?,MODIFIED_DATE=SYSDATE,MODIFIED_AT_WS_NO=?,MODIFIED_FACILITY_ID=?,CHART_LEVEL=?,TOOTH_NUMBERING_SYSTEM=?,MIXED_DENTITION_FROM_AGE_YRS=?,MIXED_DENTITION_TO_AGE_YRS=?,MIXED_DENTITION_FROM_AGE_DAYS=?,MIXED_DENTITION_TO_AGE_DAYS=?,DECIDUOUS_GRACE_PERIOD_DAYS=?,DFLT_MIXED_DENTITION_CHART=?,REST_CHRT_VALIDITY_DAYS=?,PERI_CHRT_VALIDITY_DAYS=?,RECORD_GINGIVAL_STATUS_YN=?,GINGIVAL_RECORDING_BY=?,GS_NO_OF_TOOTH_FOR_S1=?,GS_NO_OF_TOOTH_FOR_S2=?,GS_NO_OF_TOOTH_FOR_S3=?,GS_NO_OF_TOOTH_FOR_S4=?,GS_NO_OF_TOOTH_FOR_S5=?,GS_NO_OF_TOOTH_FOR_S6=?,GS_DFLT_TOOTH_NO_S1=?,GS_DFLT_TOOTH_NO_S2=?,GS_DFLT_TOOTH_NO_S3=?,GS_DFLT_TOOTH_NO_S4=?,GS_DFLT_TOOTH_NO_S5=?,GS_DFLT_TOOTH_NO_S6=?,DEC_GS_NO_OF_TOOTH_FOR_S1=?,DEC_GS_NO_OF_TOOTH_FOR_S2=?,DEC_GS_NO_OF_TOOTH_FOR_S3=?,DEC_GS_NO_OF_TOOTH_FOR_S4=?,DEC_GS_NO_OF_TOOTH_FOR_S5=?,DEC_GS_NO_OF_TOOTH_FOR_S6=?,DEC_GS_DFLT_TOOTH_NO_S1=?,DEC_GS_DFLT_TOOTH_NO_S2=?,DEC_GS_DFLT_TOOTH_NO_S3=?,DEC_GS_DFLT_TOOTH_NO_S4=?,DEC_GS_DFLT_TOOTH_NO_S5=?,DEC_GS_DFLT_TOOTH_NO_S6=?,MD_GS_NO_OF_TOOTH_FOR_S1=?,MD_GS_NO_OF_TOOTH_FOR_S2=?,MD_GS_NO_OF_TOOTH_FOR_S3=?,MD_GS_NO_OF_TOOTH_FOR_S4=?,MD_GS_NO_OF_TOOTH_FOR_S5=?,MD_GS_NO_OF_TOOTH_FOR_S6=?,MD_GS_DFLT_TOOTH_NO_S1=?,MD_GS_DFLT_TOOTH_NO_S2=?,MD_GS_DFLT_TOOTH_NO_S3=?,MD_GS_DFLT_TOOTH_NO_S4=?,MD_GS_DFLT_TOOTH_NO_S5=?,MD_GS_DFLT_TOOTH_NO_S6=?,EXT_PERFORM_DTLS_REQD_YN=?");

						pstmt.setString(1,login_user);//MODIFIED_BY_ID
						pstmt.setString(2,client_ip_address);//MODIFIED_AT_WS_NO
						pstmt.setString(3,facility_id);//MODIFIED_FACILITY_ID
						pstmt.setString(4,chart_level);//CHART_LEVEL
						pstmt.setString(5,tooth_numbering_system);//CHART_LEVEL
						pstmt.setString(6,mixed_dentition_from_age_yrs);
						pstmt.setString(7,mixed_dentition_to_age_yrs);
						pstmt.setString(8,mixed_dentition_from_age_days);
						pstmt.setString(9,mixed_dentition_to_age_days);
						pstmt.setString(10,deciduous_grace_period_days);
						pstmt.setString(11,dflt_mixed_dentition_chart);
						pstmt.setString(12,rest_chrt_validity_days);
						pstmt.setString(13,peri_chrt_validity_days);
						pstmt.setString(14,record_gingival_status_yn);
						pstmt.setString(15,gigival_recorded);
						pstmt.setString(16,gs_no_of_tooth_for_S1);
						pstmt.setString(17,gs_no_of_tooth_for_S2);
						pstmt.setString(18,gs_no_of_tooth_for_S3);
						pstmt.setString(19,gs_no_of_tooth_for_S4);
						pstmt.setString(20,gs_no_of_tooth_for_S5);
						pstmt.setString(21,gs_no_of_tooth_for_S6);
						pstmt.setString(22,gs_dflt_tooth_no_S1);
						pstmt.setString(23,gs_dflt_tooth_no_S2);
						pstmt.setString(24,gs_dflt_tooth_no_S3);
						pstmt.setString(25,gs_dflt_tooth_no_S4);
						pstmt.setString(26,gs_dflt_tooth_no_S5);
						pstmt.setString(27,gs_dflt_tooth_no_S6);
						pstmt.setString(28,dec_gs_no_of_tooth_for_S1);
						pstmt.setString(29,dec_gs_no_of_tooth_for_S2);
						pstmt.setString(30,dec_gs_no_of_tooth_for_S3);
						pstmt.setString(31,dec_gs_no_of_tooth_for_S4);
						pstmt.setString(32,dec_gs_no_of_tooth_for_S5);
						pstmt.setString(33,dec_gs_no_of_tooth_for_S6);
						pstmt.setString(34,dec_gs_dflt_tooth_no_S1);
						pstmt.setString(35,dec_gs_dflt_tooth_no_S2);
						pstmt.setString(36,dec_gs_dflt_tooth_no_S3);
						pstmt.setString(37,dec_gs_dflt_tooth_no_S4);
						pstmt.setString(38,dec_gs_dflt_tooth_no_S5);
						pstmt.setString(39,dec_gs_dflt_tooth_no_S6);
						pstmt.setString(40,md_gs_no_of_tooth_for_S1);
						pstmt.setString(41,md_gs_no_of_tooth_for_S2);
						pstmt.setString(42,md_gs_no_of_tooth_for_S3);
						pstmt.setString(43,md_gs_no_of_tooth_for_S4);
						pstmt.setString(44,md_gs_no_of_tooth_for_S5);
						pstmt.setString(45,md_gs_no_of_tooth_for_S6);
						pstmt.setString(46,md_gs_dflt_tooth_no_S1);
						pstmt.setString(47,md_gs_dflt_tooth_no_S2);
						pstmt.setString(48,md_gs_dflt_tooth_no_S3);
						pstmt.setString(49,md_gs_dflt_tooth_no_S4);
						pstmt.setString(50,md_gs_dflt_tooth_no_S5);
						pstmt.setString(51,md_gs_dflt_tooth_no_S6);
						pstmt.setString(52,res_rep2);
						flag = pstmt.executeUpdate();
					}else if(chart_level.equals("F") && chk_recorded.equals("Y")){
						
						pstmt=con.prepareStatement("UPDATE OH_PARAM SET  MODIFIED_BY_ID=?,MODIFIED_DATE=SYSDATE,MODIFIED_AT_WS_NO=?,MODIFIED_FACILITY_ID=?,CHART_LEVEL=?,EXT_PERFORM_DTLS_REQD_YN=?");
					
						pstmt.setString(1,login_user);//MODIFIED_BY_ID
						pstmt.setString(2,client_ip_address);//MODIFIED_AT_WS_NO
						pstmt.setString(3,facility_id);//MODIFIED_FACILITY_ID
						pstmt.setString(4,chart_level);//CHART_LEVEL
						pstmt.setString(5,res_rep2);
						flag = pstmt.executeUpdate();
					}
			
		
				MessageManager mm=new MessageManager();

				if(flag != 0 && chk_recorded.equals("Y")){
					con.commit();
					final java.util.Hashtable mesg = mm.getMessage(locale, "RECORD_INSERTED", "SM") ;
					msg = ((String) mesg.get("message"));
					mesg.clear();	//Common-ICN-0044

				}else if(chk_recorded.equals("N")){
					con.rollback();
					final java.util.Hashtable mesg = mm.getMessage(locale, "NO_CHANGE_TO_SAVE", "COMMON") ;
					msg = ((String) mesg.get("message"));
					mesg.clear();	//Common-ICN-0044
				}else if(chart_level.equals("F") && chk_recorded.equals("Y")){

					con.commit();
					final java.util.Hashtable mesg = mm.getMessage(locale, "RECORD_INSERTED", "SM") ;
					msg = ((String) mesg.get("message"));
					mesg.clear();	//Common-ICN-0044

				}
			
			 res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( msg,"UTF-8" ));
		 }
		catch ( Exception e ){
			out.println("<h3> Exception raised by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
		}finally{
			try{
				if(pstmt!=null) pstmt.close();
				if(con!=null) ConnectionManager.returnConnection(con,req);
			}catch(Exception e){}
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
