/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
	Developed By       :  NANDA KUMAR R.
	Module Name 	   :  eCIS/dr
	Function Name	   :  DR User Rights
	Function ID		   :

*/

package eDR;
import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import webbeans.eCommon.*;

public class DRUserRightsServlet extends javax.servlet.http.HttpServlet
{
	PrintWriter out;
	Properties p;
	HttpSession session;
	
	
	Connection con						= null;
	Statement stmt						= null;
	PreparedStatement pstmt				= null;
	ResultSet messageResultset          = null;
	ResultSet rs						= null;

	String client_ip_address			= "";
	String facilityId					= "";
    String mode							= "";
	String addedById					= "";
	String modifiedById					= "";
	String addedFacilityId				= "";
	String modifiedFacilityId			= "";
	String addedAtWorkstation			= "";
	String modifiedAtWorkstation		= "";
	String p_user_name					= "";
	String p_enabled					= "";
	String p_search						= "";
	String p_identify_valid_dup			= "";
	String p_merge						= "";
	String p_unmerge					= "";
	String p_admin						= "";
	String p_message_code				= "";

	StringBuffer InsertSql				= null;
	StringBuffer InsertSql1				= null;
	StringBuffer UpdateSql				= null;
	StringBuffer MessageSql				= null;

	int p_count							= 0;
	int rsinsertdr						= 0;
	int rsupdatedr						= 0;
	
	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	}
	
	public synchronized void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
		session					= req.getSession(false);
		this.facilityId			= (String) session.getValue("facility_id" ) ;
		this.p					= (Properties) session.getValue( "jdbc" ) ;
		this.client_ip_address	= p.getProperty("client_ip_address");
		
		try
		{
			con  = ConnectionManager.getConnection(req);
			stmt = con.createStatement();			

			this.out	= res.getWriter();

			mode					= req.getParameter("mode");
			p_user_name				= req.getParameter("p_user_name");
			p_enabled				= req.getParameter("p_enabled");
			p_search				= req.getParameter("p_search");
			p_identify_valid_dup	= req.getParameter("p_identify_valid_dup");
			p_merge					= req.getParameter("p_merge");
			p_unmerge				= req.getParameter("p_unmerge");
			p_admin					= req.getParameter("p_admin");

			addedById				= p.getProperty( "login_user" ) ;
			modifiedById			= addedById ;
			addedFacilityId			= facilityId;
			modifiedFacilityId	    = addedFacilityId ;
			addedAtWorkstation	    = client_ip_address;
			modifiedAtWorkstation   = addedAtWorkstation ;

			if(p_enabled == null)
			{
				p_enabled = "D";
			}

			//assigning N to check box variables
	
			if(mode != null && mode.equals("insert"))
			{
				insertDRUserRightsServlet(res);
			}
			if(mode != null && mode.equals("modify"))
			{
				modifyDRUserRightsServlet(res);
			}

			if(rs   != null) rs.close();
			if(messageResultset!=null)  messageResultset.close();
			if(stmt != null) stmt.close();
			if(pstmt != null) pstmt.close();

		}catch(Exception e){out.println(e.toString());}
		finally
		{
			ConnectionManager.returnConnection(con,req);
		}
	}//do post
	private synchronized void insertDRUserRightsServlet(HttpServletResponse res)
	{
		try
		{
			String locale = p.getProperty("LOCALE");
			

			con.setAutoCommit(false);
			
			InsertSql	= new StringBuffer();
			InsertSql1	= new StringBuffer();
			MessageSql	= new StringBuffer();
				
			InsertSql.append("select count(*) total from dr_user_rights where appl_user_id = ?");
			
			pstmt	= con.prepareStatement(InsertSql.toString());
			pstmt.setString(1,p_user_name);
			rs		= pstmt.executeQuery();

			while(rs.next())
			{
				p_count = rs.getInt("total");
			} 

			if(rs != null) rs.close(); 	
			if(pstmt != null) pstmt.close(); 	
			
			if(p_count > 0)
			{
				
				java.util.Hashtable message = MessageManager.getMessage(locale, "CODE_ALREADY_EXISTS", "Common");
				String error = ((String) message.get("message"));

				res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode(error,"UTF-8") + "&err_value=1 " );
			}
			else
			{
				InsertSql1.append("insert into  dr_user_rights(APPL_USER_ID,SEARCH_PRIVILEGE_LEVEL,IDENTIFY_PRIVILEGE_LEVEL, MERGE_PRIVILEGE_LEVEL,UNMERGE_PRIVILEGE_LEVEL,ADMINISTER_PRIVILEGE_LEVEL,EFF_STATUS, ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE, MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID) values(?,?,?,?,?,?,?,?,sysdate,?,?,?,sysdate,?,?)");

				pstmt = con.prepareStatement(InsertSql1.toString());	

				pstmt.setString(1,p_user_name);
				pstmt.setString(2,p_search);
				pstmt.setString(3,p_identify_valid_dup);
				pstmt.setString(4,p_merge);
				pstmt.setString(5,p_unmerge);
				pstmt.setString(6,p_admin);
				pstmt.setString(7,p_enabled);
				pstmt.setString(8,addedById);
				pstmt.setString(9,addedAtWorkstation);
				pstmt.setString(10,addedFacilityId);
				pstmt.setString(11,modifiedById);
				pstmt.setString(12,modifiedAtWorkstation);
				pstmt.setString(13,modifiedFacilityId);
				
				rsinsertdr = pstmt.executeUpdate();

				
			}
			if(pstmt != null) pstmt.close();
				
			if(rsinsertdr > 0)
			{
				con.commit();
			
				java.util.Hashtable message = MessageManager.getMessage(locale, "RECORD_INSERTED", "SM");
				String error = ((String) message.get("message"));

				res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode(error,"UTF-8") + "&err_value=1 " );
			}
			else
			{
				con.rollback();
				
			}

		
			if(pstmt != null) pstmt.close();	
		}catch(Exception e)
		{
			out.println("<h3> Exception raise by Servlet ...So Record Not modified </h3> Foll: Error Received : "+e.toString());
		}
	}//method
	private synchronized void modifyDRUserRightsServlet(HttpServletResponse res)
	{ 
		try
		{
			String locale = p.getProperty("LOCALE");
			

			con.setAutoCommit(false);

			UpdateSql   = new StringBuffer();
			MessageSql  = new StringBuffer();

			UpdateSql.append("update dr_user_rights set search_privilege_level = ?,identify_privilege_level = ? ,merge_privilege_level = ?,unmerge_privilege_level = ?,administer_privilege_level = ? ,eff_status = ?,modified_by_id = ?,modified_date=sysdate,modified_at_ws_no = ?,modified_facility_id = ? where appl_user_id = ? ");
			
			pstmt = con.prepareStatement(UpdateSql.toString());

			pstmt.setString(1,p_search);
			pstmt.setString(2,p_identify_valid_dup);
			pstmt.setString(3,p_merge);
			pstmt.setString(4,p_unmerge);
			pstmt.setString(5,p_admin);
			pstmt.setString(6,p_enabled);
			pstmt.setString(7,modifiedById);
			pstmt.setString(8,modifiedAtWorkstation);
			pstmt.setString(9,modifiedFacilityId);
			pstmt.setString(10,p_user_name);
			
			rsupdatedr = pstmt.executeUpdate();

			if(pstmt != null) pstmt.close();
			
			if(rsupdatedr > 0)
			{
				con.commit();

			/*	String code		= "";
				String message	= "";
				
				MessageSql.append("select message_id, message_text_sysdef from sm_message where message_ref='RECORD_MODIFIED'");
				
				messageResultset = stmt.executeQuery(MessageSql.toString());
				
				if(messageResultset!=null && messageResultset.next())
				{
					code	= messageResultset.getString("message_id");
					message = messageResultset.getString("message_text_sysdef");
				} if(messageResultset != null) messageResultset.close();
				*/

				java.util.Hashtable message = MessageManager.getMessage(locale, "RECORD_MODIFIED", "SM");
				String error = ((String) message.get("message"));
				
				res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode(error,"UTF-8" ) + "&err_value=1 " );
			}
			else
			{
				con.rollback();

		/*		String code		= "";
				String message	= "";

				res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode("APP-"+code+" "+message+"" ) + "&err_value=0 " );*/
			
			}
			
			if((UpdateSql != null) && (UpdateSql.length() > 0))	
			{
				UpdateSql.delete(0,UpdateSql.length());
			}
			if((MessageSql != null) && (MessageSql.length() > 0))	
			{
				MessageSql.delete(0,MessageSql.length());
			}

			if(stmt != null) stmt.close();
		}catch(Exception e)
		{
			out.println("Exception raise by Servlet in modifyDRUserRightsServlet method :"+e.toString());
		}
	}//method
}//class
