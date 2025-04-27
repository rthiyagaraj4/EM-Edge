/*
------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name		Rev.Date		Rev.Name			Description
------------------------------------------------------------------------------------------------------------------------------
27/07/2017		IN061891	Raja S		27/07/2017		Ramesh G		ML-MMOH-CRF-0543
16/03/2021		15950		Nijitha S									Common-ICN-0030
02/03/2022 Common-ICN-0092  K.Pranay                                    connection closing statement
------------------------------------------------------------------------------------------------------------------------------
*/ 
package eCA;

import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import javax.naming.*;
import javax.rmi.*;
import eCommon.SingleTabHandler.*;
import webbeans.eCommon.*;

public class PersonalisePatListServlet extends javax.servlet.http.HttpServlet	
{

public void init(ServletConfig config) throws ServletException	
{
	super.init(config);
}

public void doPost(HttpServletRequest req, HttpServletResponse res)
        throws javax.servlet.ServletException,IOException
{

		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
		PrintWriter out = null;
		String mode = req.getParameter("mode") == null ? "" :  req.getParameter("mode");
		
		
		try
		{
			out = res.getWriter();
			if("delete".equals(mode))
				deletePersonalisePatient(req, res);
			else if("insert".equals(mode))
				insertPersonalisePatient(req, res);
		} 
		catch(Exception e) 
		{
			//out.println(e.toString());//common-icn-0181
			e.printStackTrace();
		}
}

private void insertPersonalisePatient(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException 
{
		PrintWriter out;
		
		java.util.Properties p;
		
		String errorMsg				= "";
		
		String facilityId			= "" ;
		String appl_user_id			= "" ;
		String patientId			= "" ;
		String respId			= "" ;
		String client_ip_address	= "";
		String locale				= "";
		String pract_id				= "";
		String system_id			= "";
		PreparedStatement ps;
		Connection con = null;
		
		boolean result = false;
		

		HttpSession session				= req.getSession(false);
		p								= (java.util.Properties) session.getValue( "jdbc" ) ;
		client_ip_address				= (String) p.getProperty("client_ip_address");
		locale							= (String) p.getProperty("LOCALE");
		facilityId						= req.getParameter("facility_id") == null?"":req.getParameter("facility_id");
		appl_user_id					= req.getParameter("login_id") == null?"":req.getParameter("login_id");
		patientId						= req.getParameter("patient_id") == null?"":req.getParameter("patient_id");
		respId							= req.getParameter("resp_id") == null?"":req.getParameter("resp_id");
		pract_id						= req.getParameter("pract_id") == null?"":req.getParameter("pract_id");
		system_id						= req.getParameter("system_id") == null?"":req.getParameter("system_id");
		String insertQuery	= "INSERT INTO ca_pat_personalise_list(FACILITY_ID,PRACTITIONER_ID,PATIENT_ID,APP_LOGIN_ID,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID) values (?,?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?)";
		Hashtable tabdata;
		String errVal="";


		out = res.getWriter();
		
		try 
		{
			con = ConnectionManager.getConnection(req);

			ps = con.prepareStatement(insertQuery);
			ps.setString(1,facilityId);
			ps.setString(2,pract_id);
			ps.setString(3,patientId);
			ps.setString(4,appl_user_id);
			ps.setString(5,pract_id);
			ps.setString(6,system_id);
			ps.setString(7,facilityId);
			ps.setString(8,pract_id);
			ps.setString(9,system_id);
			ps.setString(10,facilityId);
			int inserted = ps.executeUpdate();
			if(inserted > 0)
			{
				result = true;
			}
			if(ps != null)ps.close();

			if(result)
			{
				con.commit();
				tabdata = MessageManager.getMessage(locale,"ADD_PAT_SUCCESS","CA");
				errorMsg= (String) tabdata.get("message");
				errVal = "1";
			}
			else
			{ 
				con.rollback();
				tabdata = MessageManager.getMessage(locale, "DUP_ENT_NOT_ALLOWED","CA");
				errorMsg= (String) tabdata.get("message");
				errVal = "0";
			}
			tabdata.clear();
		
			res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( errorMsg,"UTF-8" ));
						
		} 
		catch ( Exception e ) 
		{
			//out.println("Exception in Insert Block :"+e.getMessage());
			//out.println("Exception in Insert Block :"+e.toString());//common-icn-0181
			e.printStackTrace();
		}
		finally//15950
		{
			ConnectionManager.returnConnection(con);
		}//15950 Ends
	
	}
private void deletePersonalisePatient(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException 
{
		PrintWriter out;
		
		java.util.Properties p;
		
		String errorMsg				= "";
		
		String facilityId			= "" ;
		String appl_user_id			= "" ;
		String patientId			= "" ;
		String client_ip_address	= "";
		String locale				= "";
		String del_patient_list	 	= "";
		String pract_id				= "";
		PreparedStatement ps = null;
		Connection con = null;
		
		

		HttpSession session				= req.getSession(false);
		p								= (java.util.Properties) session.getValue( "jdbc" ) ;
		client_ip_address				= (String) p.getProperty("client_ip_address");
		locale							= (String) p.getProperty("LOCALE");
		facilityId						= req.getParameter("facility_id") == null?"":req.getParameter("facility_id");
		appl_user_id					= req.getParameter("login_id") == null?"":req.getParameter("login_id");
		patientId						= req.getParameter("patient_id") == null?"":req.getParameter("patient_id");
		del_patient_list				= req.getParameter("delPatList") == null?"":req.getParameter("delPatList");
		pract_id						= req.getParameter("pract_id") == null?"":req.getParameter("pract_id");
		String deleteQuery	= "DELETE FROM ca_pat_personalise_list WHERE PATIENT_ID in ("+del_patient_list+") AND FACILITY_ID=? and PRACTITIONER_ID=?";
		Hashtable tabdata = null;
		String errVal="";


		out = res.getWriter();
		
		try 
		{
			con = ConnectionManager.getConnection(req);

			ps = con.prepareStatement(deleteQuery);

			ps.setString(1,facilityId);
			ps.setString(2,pract_id);

			int deleted = ps.executeUpdate();
			if(deleted != 0)
				tabdata = MessageManager.getMessage(locale,"RECORD_DELETED","CA");
				errorMsg= (String) tabdata.get("message");
				con.commit();
				errVal="1";
			if(ps != null)ps.close();//15950
			res.sendRedirect("../eCA/jsp/PersonaliseErrorMsg.jsp?err_num=" + java.net.URLEncoder.encode( errorMsg, "UTF-8" ) + "&err_value=" + errVal );
			
		} 
		catch ( Exception e ) 
		{
			//out.println("Exception in Insert Block :"+e.getMessage());
			//out.println("Exception in Insert Block :"+e.toString());//common-icn-0181
			e.printStackTrace();
		}
		//15950 Fix Starts
		finally {			
				try {
					if(ps != null) ps.close();//Common-ICN-0092  
					ConnectionManager.returnConnection(con);
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		//15950 Ends

	}
}

