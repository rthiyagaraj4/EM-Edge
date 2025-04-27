/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eBL;

import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import javax.naming.*;
import javax.rmi.*;
import java.net.*;
import webbeans.eCommon.*;
import eBL.*;
import com.ehis.persist.*;
import eCommon.Common.*;

public class BLAdhocDiscServlet extends javax.servlet.http.HttpServlet {

	PrintWriter out;

	java.util.Properties p;

	HttpSession session;

	Connection con;

	PreparedStatement pstmt;

	ResultSet rs;	

	
	HashMap hm = new HashMap();
	Hashtable messageHashtable=new Hashtable();
	String msg="";

	StringBuffer sb = new StringBuffer();
	String facility_id, client_ip_address, user_id ;
	String locale;
	String sStyle = "";
	String patient_id="",  visit_id="", episode_id="", episode_type="", encounter_id="";    

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}

	public synchronized void doPost(HttpServletRequest req,HttpServletResponse res) throws javax.servlet.ServletException,IOException 
	{
		session = req.getSession(false);
		this.p = (java.util.Properties) session.getValue("jdbc");


		this.facility_id = (String) session.getValue("facility_id");
		if(facility_id == null) facility_id="";

		user_id      = (String) session.getValue("login_user");
		if(user_id == null) user_id="";

		client_ip_address = p.getProperty("client_ip_address");
		if(client_ip_address == null) client_ip_address="";

		sStyle = (session.getAttribute("PREFERRED_STYLE") != null)
				|| (session.getAttribute("PREFERRED_STYLE") != "") ? (String) session
				.getAttribute("PREFERRED_STYLE")
				: "IeStyle.css";

		//String attributes[] = session.getValueNames();
		locale = p.getProperty("LOCALE");
		
		try 
		{
			req.setCharacterEncoding("UTF-8");
			res.setContentType("text/html;charset=UTF-8");
			this.out = res.getWriter();			
			insertAdhocdisc(req, res);

		} 
		catch (Exception e) 
		{
			System.out.println("Exception in doPost=" + e.toString());
			e.printStackTrace();
			out.println(e.toString());
		} 
		/*finally 
		{
			if (con != null)
				ConnectionManager.returnConnection(con, req);
		}*/
	}

	private void insertAdhocdisc(HttpServletRequest req,HttpServletResponse res) throws SQLException
	{
						
			getData(req);
//			System.out.println("from servlet");
			
	}
			
		public void getData(HttpServletRequest req)
		{	 
			hm.clear();
			String str_patient_id = req.getParameter("patient_id");	
			if(str_patient_id==null) str_patient_id="";	
				
			String str_episode_type = req.getParameter("episode_type");	
			if(str_episode_type==null) str_episode_type="";	

			String str_episode_id = req.getParameter("episode_id");	
			if(str_episode_id==null) str_episode_id="";	

			String str_visit_id = req.getParameter("visit_id");	
			if(str_visit_id==null) str_visit_id="";		
			
			String total_records = req.getParameter("total_records");
			if (total_records==null) total_records = "";
//			System.out.println("blng_stotal_records temp :"+total_records);

			int totalRecords = Integer.parseInt(total_records);
			
			String checked_services = req.getParameter("checked_services");
			if (checked_services==null) checked_services = "";

//			System.out.println("checked_services temp :"+checked_services);

			StringTokenizer st_checked_services = null;
			st_checked_services = new StringTokenizer(checked_services,",");
				//int count=0; unused
			while(st_checked_services.hasMoreTokens())
			{
				String blng_serv_code = st_checked_services.nextToken();
//				System.out.println("blng_serv_code temp :"+blng_serv_code);
				
				for(int i=0;i<totalRecords;i++)
				{

					String selected_row = req.getParameter("selected_row"+i);
					if(selected_row == null) selected_row="";
					

				if(blng_serv_code.equals(selected_row))
					{
//					System.out.println("selected_row temp :"+selected_row);					
						String trx_doc_ref = req.getParameter("trx_doc_ref"+i);
//						System.out.println("trx_doc_ref :"+trx_doc_ref);
						if(trx_doc_ref.equals(" ")) trx_doc_ref="";

						String trx_doc_ref_line_no = req.getParameter("trx_doc_ref_line_no"+i);
//						System.out.println("trx_doc_ref_line_no :"+trx_doc_ref_line_no);
						if(trx_doc_ref_line_no.equals(" ")) trx_doc_ref_line_no="";

						String trx_doc_ref_seq_no = req.getParameter("trx_doc_ref_seq_no"+i);
//						System.out.println("trx_doc_ref_seq_no :"+trx_doc_ref_seq_no);
						if(trx_doc_ref_seq_no.equals(" ")) trx_doc_ref_seq_no="";

						String disc_amt = req.getParameter("disc_amt"+i);
//						System.out.println("disc_amt :"+disc_amt);
						if(disc_amt.equals(" ")) disc_amt="";

						String disc_reason_code = req.getParameter("disc_reason_code"+i);
//						System.out.println("disc_reason_code :"+disc_reason_code);
						if(disc_reason_code.equals(" ")) disc_reason_code="";

						String adhoc_user_id = req.getParameter("adhoc_user_id"+i);
//						System.out.println("adhoc_user_id :"+adhoc_user_id);
						if(adhoc_user_id.equals(" ")) adhoc_user_id="";

						hm.put("trx_doc_ref",trx_doc_ref);
						hm.put("trx_doc_ref_line_no",trx_doc_ref_line_no);
						hm.put("trx_doc_ref_seq_no",trx_doc_ref_seq_no);
						hm.put("disc_amt",disc_amt);
						hm.put("disc_reason_code",disc_reason_code);
						hm.put("adhoc_user_id",adhoc_user_id);
						hm.put("patient_id",str_patient_id);
						hm.put("episode_type",str_episode_type);
						hm.put("episode_id",str_episode_id);
						hm.put("visit_id",str_visit_id);

				}//if
			}//for
		}//while
//		System.out.println("hm servlet 2"+hm);
	}//method
	
}
