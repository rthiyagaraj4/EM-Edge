/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
--------------------------------------------------------------------------------------------------------------
Date			Edit History      Name			Description
--------------------------------------------------------------------------------------------------------------
?				100					?           created
06/12/2012   IN030466     Karthi L		CRF-025 Based on the access rights, practitioner can Record and update the Clinical Studies content in CA Patient Chart Menu	
---------------------------------------------------------------------------------------------------------------
*/ 
package eCA;

import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import java.util.Date.*;
import javax.naming.*;
import javax.rmi.*;
import webbeans.eCommon.*;

public class ResearchPatientRecordServlet extends javax.servlet.http.HttpServlet
{
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
		String mode = "";
		HttpSession session;
		PrintWriter out;
		out = res.getWriter();
		session = req.getSession(false);
		Connection 	con = ConnectionManager.getConnection(req);
		
		try
		{
			mode =(req.getParameter("mode")==null)?"":req.getParameter("mode");
			if (mode.trim().equalsIgnoreCase("insert"))   insert(req, res, session, out, con);
			if (mode.trim().equalsIgnoreCase("modify"))   modify(req, res, session, out, con);
		}//try1
		catch(Exception e)
		{
			out.println("Exception in try1 of ResearchPatientRecordServlet.java"+e.toString());
			e.printStackTrace();
		}
	}

	private void insert(HttpServletRequest req, HttpServletResponse res, HttpSession session, PrintWriter out, Connection con)
	{
		PreparedStatement stmt=null;
		ResultSet rs1=null;

		String error = "";
		String patient_id = "";
		String research_categ_id = "";
		String remarks = "";
		String start_date = "";
		String close_date = "";
		String facilityId = "";
		String client_ip_address = "";
		String addedById = "";
		String addedAtWorkstation = "";
		String addedFacilityId = "";
		String modifiedById = "";
		String modifiedAtWorkstation = "";
		String addedDate = "";
		String res_categ_risk_factor = ""; // added for CRF-025

		int insert_chk = 0;
		int count = 0;

		java.util.Properties p = (Properties)session.getValue("jdbc") ;
		String locale = (String) p.getProperty("LOCALE");
		facilityId = (String)session.getValue( "facility_id" ) ;
		client_ip_address = p.getProperty("client_ip_address");
		modifiedById = (p.getProperty("login_user")==null)?"":p.getProperty("login_user")  ;           
		modifiedAtWorkstation   = (client_ip_address==null)?"":client_ip_address;
		java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "yyyy-MM-dd" ) ;

		addedById = (p.getProperty("login_user")==null)?"":p.getProperty("login_user")  ;
		addedDate = dateFormat.format( new java.util.Date() ) ;
		addedFacilityId		= (facilityId == null)?"":facilityId;  
		addedAtWorkstation	= (client_ip_address == null)?"":client_ip_address; 		                                 
		try
		{

			patient_id = req.getParameter("patient_id");
			
			if(patient_id == null) patient_id = "";
			research_categ_id = req.getParameter("research_id");
			if(research_categ_id == null) research_categ_id = "";
			remarks = req.getParameter("remarks");
			if(remarks == null) remarks = "";
			start_date = req.getParameter("start_date");
			if(start_date == null) start_date = "";
			close_date = req.getParameter("close_date");
			if(close_date == null) close_date = "";
			if(addedById == null) addedById="";
			if(addedDate == null) addedDate="";
			if(facilityId == null ) facilityId="";
			if(addedFacilityId == null )	addedFacilityId="";
			if(addedAtWorkstation == null) addedAtWorkstation="";
			if(modifiedById == null) modifiedById="";
			if(modifiedAtWorkstation == null ) modifiedAtWorkstation="";

			res_categ_risk_factor = req.getParameter("res_categ_risk_factor"); //added for CRF-025
			if(res_categ_risk_factor == null) res_categ_risk_factor = ""; //added for CRF-025
			start_date		= com.ehis.util.DateUtils.convertDate(start_date,"DMY",locale,"en");
			close_date		= com.ehis.util.DateUtils.convertDate(close_date,"DMY",locale,"en");
			

			//String insert_bfore_chk = "SELECT COUNT(*) total FROM ca_research_patient_detail WHERE RESEARCH_CATEG_ID=? AND START_DATE > = TO_DATE(?,'DD/MM/YYYY') and (TO_DATE(CLOSE_DATE,'DD/MM/YYYY') > = TO_DATE(?,'DD/MM/YYYY') OR CLOSE_DATE IS NULL) AND PATIENT_ID=?";
			
			String insert_bfore_chk = "SELECT COUNT(*) total FROM ca_research_patient_detail WHERE RESEARCH_CATEG_ID=? AND START_DATE = TO_DATE(?,'DD/MM/YYYY') AND PATIENT_ID=? AND RESEARCH_CATEG_FACT_ID=?"; // modified for CRF-025

			
			//	String insert_bfore_chk = "SELECT COUNT(*) total FROM ca_research_patient_detail WHERE RESEARCH_CATEG_ID=? AND START_DATE = TO_DATE(?,'DD/MM/YYYY') AND PATIENT_ID=?"; // commented for CRF-025

			stmt = con.prepareStatement(insert_bfore_chk);
			stmt.setString(1,research_categ_id);
			stmt.setString(2,start_date);
			//stmt.setString(3,close_date);
			stmt.setString(3,patient_id);
			stmt.setString(4,res_categ_risk_factor); //added for CRF-025
		
			rs1=stmt.executeQuery();

			while(rs1.next())
			{
				count = rs1.getInt("total");
			}	
			if(rs1!=null)rs1.close();
			if(stmt!=null)stmt.close();

			if(count == 0)
			{
				try{
				//	String insert_sql = "insert into ca_research_patient_detail ( patient_id, research_categ_id, remarks, start_date,close_date, added_by_id, added_date, added_at_ws_no, added_facility_id, modified_by_id,modified_date, modified_at_ws_no, modified_facility_id ) values (?,?,?,TO_DATE(?,'DD/MM/YYYY'),TO_DATE(?,'DD/MM/YYYY'),?,sysdate,?,?,?,sysdate,?,?)"; // commented for CRF-025
					
					String insert_sql = "insert into ca_research_patient_detail ( patient_id, research_categ_id, remarks, start_date,close_date, added_by_id, added_date, added_at_ws_no, added_facility_id, modified_by_id,modified_date, modified_at_ws_no, modified_facility_id, research_categ_fact_id) values (?,?,?,TO_DATE(?,'DD/MM/YYYY'),TO_DATE(?,'DD/MM/YYYY'),?,sysdate,?,?,?,sysdate,?,?,?)"; // modified for CRF-025

					stmt = con.prepareStatement(insert_sql);
					stmt.setString(1,patient_id);
					stmt.setString(2,research_categ_id);
					stmt.setString(3,remarks);
					stmt.setString(4,start_date);
					stmt.setString(5,close_date);
					stmt.setString(6,addedById);
					stmt.setString(7,addedAtWorkstation);
					stmt.setString(8,addedFacilityId);
					stmt.setString(9,modifiedById);
					stmt.setString(10,modifiedAtWorkstation);
					stmt.setString(11,addedFacilityId);
					stmt.setString(12,res_categ_risk_factor); // added for CRF-025
					insert_chk= stmt.executeUpdate();
					//hashtablequery.put("query",insert_sql);

					String error_value	= "0" ;
					error = getMessage(locale,"FAILED_TRANSACTION","CA");
							
					if ( insert_chk!=0 )
						{
							error_value			= "1" ;
							error = getMessage(locale,"RECORD_INSERTED","CA");
							con.commit();

						}
					res.sendRedirect("../eCA/jsp/CAError.jsp?err_num=" + java.net.URLEncoder.encode( error ,"UTF-8") + "&err_value="+error_value);
				}//try3
				catch(Exception euptd)
				{
					try{
						con.rollback();
					}//try4
					catch(Exception e){
						//out.println("Exception in try4 of ResearchPatientRecordServlet.java:"+e);
						e.printStackTrace();
					}	
					//out.println("Exception in try3 of ResearchPatientRecordServlet.java:"+euptd);//common-icn-0181
				}
			}
			else
			{
				String error_value	= "0" ;
				error = getMessage(locale, "CODE_ALREADY_EXISTS","Common");

				res.sendRedirect("../eCA/jsp/CAError.jsp?err_num=" + java.net.URLEncoder.encode( error ,"UTF-8") + "&err_value="+error_value);
			}
		}//try2
		catch(Exception e)
		{
			out.println("Exception in try2 of ResearchPatientRecordServlet.java:"+e);
			e.printStackTrace();
		}
		finally
		{
			try{
				if(stmt!=null) stmt.close();
				
				if(con!=null) ConnectionManager.returnConnection(con,req);
			}//try5	
			catch(Exception e){ 
				//out.println("Exception in try5 of ResearchPatientRecordServlet.java:"+e.toString()); //common-icn-0181
				e.printStackTrace();
			}
		}
	}

	private void modify(HttpServletRequest req, HttpServletResponse res, HttpSession session, PrintWriter out, Connection con)
	{
		PreparedStatement stmt = null;
		String error = "";
		String patient_id = "";	
		String research_categ_id = "";
		String remarks = "";
		String start_date = "";
		String close_date = "";
		String facilityId = "";
		String client_ip_address = "";
		String addedById = "";
		String addedAtWorkstation = "";
		String addedFacilityId = "";
		String modifiedById = "";
		String modifiedAtWorkstation = "";
		String addedDate	= "";
		String res_categ_risk_factor = ""; // added for CRF-025

		int row_updt = 0;

		java.util.Properties p = (Properties)session.getValue("jdbc") ;
		String locale = (String) p.getProperty("LOCALE");
		facilityId = (String)session.getValue( "facility_id" ) ;
		client_ip_address = p.getProperty("client_ip_address");
		modifiedById = (p.getProperty("login_user")==null)?"":p.getProperty("login_user")  ;           
		modifiedAtWorkstation   = (client_ip_address==null)?"":client_ip_address;      
		java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "yyyy-MM-dd" ) ;

		addedById = (p.getProperty("login_user")==null)?"":p.getProperty("login_user")  ;
		addedDate = dateFormat.format( new java.util.Date() ) ;
		addedFacilityId		= (facilityId == null)?"":facilityId;  
		addedAtWorkstation	= (client_ip_address == null)?"":client_ip_address;   
		try
		{
			patient_id = req.getParameter("patient_id");
			if(patient_id == null) patient_id = "";
			remarks = req.getParameter("remarks");
			if(remarks == null) remarks = "";
			research_categ_id = req.getParameter("research_id");
			if(research_categ_id == null) research_categ_id = "";
			start_date = req.getParameter("start_date");
			if(start_date == null) start_date = "";
			close_date = req.getParameter("close_date");
			if(close_date == null) close_date = "";
			if(addedById == null) addedById="";
			if(addedDate == null) addedDate="";
			if(facilityId == null ) facilityId="";
			if(addedFacilityId == null ) addedFacilityId="";
			if(addedAtWorkstation == null) addedAtWorkstation="";
			if(modifiedById == null) modifiedById="";
			if(modifiedAtWorkstation == null ) modifiedAtWorkstation="";

			res_categ_risk_factor = req.getParameter("research_categ_fact_id");
			if(res_categ_risk_factor == null) res_categ_risk_factor = "";
			
			start_date		= com.ehis.util.DateUtils.convertDate(start_date,"DMY",locale,"en");
			close_date		= com.ehis.util.DateUtils.convertDate(close_date,"DMY",locale,"en");

			//String update_sql = "update ca_research_patient_detail set close_date = TO_DATE(?,'DD/MM/YYYY'),remarks = ?, ADDED_BY_ID = ?,ADDED_DATE = sysdate,ADDED_AT_WS_NO = ?, ADDED_FACILITY_ID = ?,MODIFIED_BY_ID = ?,MODIFIED_DATE = sysdate,MODIFIED_AT_WS_NO = ?,MODIFIED_FACILITY_ID = ? where patient_id = ? and research_categ_id = ? and start_date = TO_DATE(?,'DD/MM/YYYY')"; commented for CRF - 025
			
			// Modified for CRF-025
			String update_sql = "update ca_research_patient_detail set close_date = TO_DATE(?,'DD/MM/YYYY'),remarks = ?, ADDED_BY_ID = ?,ADDED_DATE = sysdate,ADDED_AT_WS_NO = ?, ADDED_FACILITY_ID = ?,MODIFIED_BY_ID = ?,MODIFIED_DATE = sysdate,MODIFIED_AT_WS_NO = ?,MODIFIED_FACILITY_ID = ? where patient_id = ? and research_categ_id = ? and start_date = TO_DATE(?,'DD/MM/YYYY') and research_categ_fact_id = ?";
			stmt = con.prepareStatement(update_sql);
			stmt.setString(1,close_date);
			stmt.setString(2,remarks);
			stmt.setString(3,addedById);
			stmt.setString(4,addedAtWorkstation);
			stmt.setString(5,addedFacilityId);
			stmt.setString(6,addedById);
			stmt.setString(7,addedAtWorkstation);
			stmt.setString(8,addedFacilityId);
			stmt.setString(9,patient_id);
			stmt.setString(10,research_categ_id);
			stmt.setString(11,start_date);
			stmt.setString(12,res_categ_risk_factor); // added for CRF-025
			row_updt = stmt.executeUpdate();
			
			String error_value	= "0" ;
			error = getMessage(locale,"FAILED_TRANSACTION","CA");
			
			if ( row_updt!=0 )
			{
				error_value			= "1" ;
				error = getMessage(locale,"RECORD_INSERTED","CA");
				con.commit();
				
			}
			res.sendRedirect("../eCA/jsp/CAError.jsp?err_num=" + java.net.URLEncoder.encode( error ,"UTF-8") + "&err_value="+error_value);
		}//try6
		catch(Exception euptd)
		{
			try{
				con.rollback();
			}//try7
			catch(Exception e){
				//out.println("Exception in try7 of ResearchPatientRecordServlet.java:"+e);//common-icn-0181
				e.printStackTrace();
			}
			//out.println("Exception in try6 of ResearchPatientRecordServlet.java:"+euptd);//common-icn-0181
			euptd.printStackTrace();
		}
		finally
		{
			try{
				if(stmt!=null) stmt.close();
				if(con!=null) ConnectionManager.returnConnection(con, req);
			}//try8
			catch(Exception e){ 
				e.printStackTrace();
			}
		}
	}
	private String getMessage(String locale, String messageId, String moduleId)
	{
		java.util.Hashtable message = MessageManager.getMessage(locale,messageId,moduleId);
		String mesg = (String) message.get("message");
		message.clear();
		return(mesg) ;
	}
	
}	
	


			
			
			
