/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eMR;

import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import javax.naming.*;
import javax.rmi.*;
import webbeans.eCommon.*;

public class TerminologyGroupServlet extends javax.servlet.http.HttpServlet
{
	PrintWriter out;
	java.util.Properties p;
	
	String term_group_id;
	String term_set_id;
	String term_group_desc ;
	String term_group_applicablity;
	String eff_status ;

	String termcodes;
	String sr_nos;
	String added_by_id ;
	String added_at_ws_no;
	String added_facility_id;
	String modified_by_id;
	String modified_at_ws_no;
	String modified_facility_id;
	String client_ip_address ;
	String locale;


	HttpSession session;
	Connection conn = null;
	String function;
	String msg,error_val;
	String indextype_yn;

	
	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	}

	public synchronized void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		session = req.getSession(false);
		out=res.getWriter();
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
		p = (java.util.Properties) session.getAttribute("jdbc");
		client_ip_address = p.getProperty("client_ip_address");
		added_facility_id=(String) session.getAttribute("facility_id");
		locale = p.getProperty("LOCALE");
		term_group_id		= req.getParameter("term_group_id")==null?"":req.getParameter("term_group_id");

		term_group_desc		= req.getParameter("term_group_desc")==null?"":req.getParameter("term_group_desc");
		

		term_set_id			= req.getParameter("term_set_id")==null?"":req.getParameter("term_set_id");

		eff_status			= req.getParameter("term_status_yn")==null?"":req.getParameter("term_status_yn");
		if(eff_status==null || eff_status.equals(""))
			eff_status="E";
			


		termcodes			= req.getParameter("termcodes")==null?"":req.getParameter("termcodes");
		function			= req.getParameter("function")==null?"":req.getParameter("function");
		
		sr_nos				= req.getParameter("sr_nos")==null?"":req.getParameter("sr_nos");
		indextype_yn		= req.getParameter("indextype_yn")==null?"N":req.getParameter("indextype_yn");

	
	msg="";
		error_val="";
		term_group_applicablity="P";

		if(function.equalsIgnoreCase("insert"))
		{
			insert(req,res);
		}

		else if(function.equalsIgnoreCase("modify"))
		{
			modify(req,res);
		}
	}

	 private void insert(HttpServletRequest req,HttpServletResponse response)		
	 {
		modified_facility_id=added_facility_id;
		added_by_id	= (p.getProperty("login_user")==null)?"":p.getProperty("login_user");
		modified_by_id=added_by_id;

		added_at_ws_no=client_ip_address;
		modified_at_ws_no=client_ip_address;
		int count=0,count_dtl=0;
		PreparedStatement pstmt_hdr=null,pstmt_dtl=null,pstmt_dupchk=null;
		ResultSet rs=null;
		try
		{	
			conn = ConnectionManager.getConnection(req);

			pstmt_hdr = conn.prepareStatement("INSERT INTO mr_term_group_hdr(term_group_id, term_set_id,term_group_desc, term_group_applicablity,eff_status, added_by_id,added_date, added_at_ws_no,added_facility_id, modified_by_id,modified_date, modified_at_ws_no,modified_facility_id,INDEX_TYPE_YN) VALUES (?,?,?,?,?,?,sysdate,?,?,?,sysdate,?,?,?)");

			pstmt_dtl = conn.prepareStatement("INSERT INTO mr_term_group_dtl(term_group_id, term_set_id, term_code,added_by_id, added_date, added_at_ws_no,added_facility_id, modified_by_id, modified_date,modified_at_ws_no, modified_facility_id,ORDER_SRL_NO) VALUES(?,?,?,?,sysdate,?,?,?,sysdate,?,?,?)");
			
			pstmt_dupchk = conn.prepareStatement("select count(*) from mr_term_group_hdr where term_group_id = ?");
			pstmt_dupchk.setString(1,term_group_id);
			rs = pstmt_dupchk.executeQuery();
			
			if(rs.next())
			{
				count = rs.getInt(1);
			}

			if(count == 0 && count_dtl==0)
			{
				pstmt_hdr.setString(1,term_group_id);
				pstmt_hdr.setString(2,term_set_id);
				pstmt_hdr.setString(3,term_group_desc);
				pstmt_hdr.setString(4,term_group_applicablity);
				pstmt_hdr.setString(5,eff_status);
				pstmt_hdr.setString(6,added_by_id);
				pstmt_hdr.setString(7,added_at_ws_no);
				pstmt_hdr.setString(8,added_facility_id);
				pstmt_hdr.setString(9,modified_by_id);
				pstmt_hdr.setString(10,modified_at_ws_no);
				pstmt_hdr.setString(11,modified_facility_id);
				pstmt_hdr.setString(12,indextype_yn);


				int result_update = pstmt_hdr.executeUpdate();

				StringTokenizer stk_termcodes=new StringTokenizer(termcodes,"~");
				StringTokenizer stk_srnos=new StringTokenizer(sr_nos,"~");

			/* Commented for checkStyle
				int count_termcodes=stk_termcodes.countTokens();
			*/
				while(stk_termcodes.hasMoreTokens() && stk_srnos.hasMoreTokens())
				{
					pstmt_dtl.setString(1,term_group_id);
					pstmt_dtl.setString(2,term_set_id);

					pstmt_dtl.setString(3,stk_termcodes.nextToken());

					pstmt_dtl.setString(4,added_by_id);
					pstmt_dtl.setString(5,added_at_ws_no);
					pstmt_dtl.setString(6,added_facility_id);
					pstmt_dtl.setString(7,modified_by_id);
					pstmt_dtl.setString(8,modified_at_ws_no);
					pstmt_dtl.setString(9,modified_facility_id);
					pstmt_dtl.setString(10,stk_srnos.nextToken());

					pstmt_dtl.addBatch();
				}

				int result_update1[] = pstmt_dtl.executeBatch();
				
				if(result_update >0 && result_update1.length>0)
				{
					conn.commit();	
					java.util.Hashtable message = MessageManager.getMessage( locale, "RECORD_MODIFIED","SM" ) ;
					msg = (String) message.get("message");error_val="1";
                    message.clear();
				}
				else
				{
					conn.rollback();
					msg = "Operation Failed";error_val="0";
				}
			}
			else
			{
				error_val = "0";
				java.util.Hashtable message = MessageManager.getMessage( locale, "RECORD_EXISTS","SM" ) ;
				msg = (String) message.get("message");
				out.println("Error!... Record Already Exists... ");
			}

			response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" +java.net.URLEncoder.encode(msg, "UTF-8") + "&err_value=" + error_val);

		}
		catch(Exception e)
		{
			try
			{
				//out.println("Error while inserting the values=="+e.toString());
				e.printStackTrace();
				conn.rollback();
				response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=1&err_value=Error while inserting the values");
			}
			catch(Exception ee)
			{
			}
		}
		finally
		{
			try
			{
				if(conn != null) ConnectionManager.returnConnection(conn,req);
				if(pstmt_hdr != null)pstmt_hdr.close();
				if(pstmt_dtl != null)pstmt_dtl.close();
				if(pstmt_dupchk != null)pstmt_dupchk.close();
				if(rs != null)rs.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}
/*************************************** End of Insert Function ***************************************/

	private void modify(HttpServletRequest req,HttpServletResponse response)		
	 {
		modified_facility_id=added_facility_id;
		added_by_id	= (p.getProperty("login_user")==null)?"":p.getProperty("login_user");
		modified_by_id=added_by_id;

		added_at_ws_no=client_ip_address;
		modified_at_ws_no=client_ip_address;

		PreparedStatement pstmt_update_hdr=null,pstmt_delete_dtl=null,pstmt_insert_dtl=null;

		try
		{	
			conn = ConnectionManager.getConnection(req);

			pstmt_update_hdr = conn.prepareStatement("update mr_term_group_hdr set term_group_desc = ?, term_group_applicablity =?,eff_status = ?, modified_by_id = ?,  modified_date = sysdate, modified_at_ws_no = ?, modified_facility_id = ?,  INDEX_TYPE_YN = ?   where term_group_id = ? and  term_set_id = ?");
			pstmt_delete_dtl = conn.prepareStatement("delete from mr_term_group_dtl where term_group_id = ? and term_set_id = ? ");
			
			pstmt_insert_dtl = conn.prepareStatement("INSERT INTO mr_term_group_dtl(term_group_id, term_set_id, term_code,added_by_id, added_date, added_at_ws_no,added_facility_id, modified_by_id, modified_date,modified_at_ws_no, modified_facility_id,ORDER_SRL_NO) VALUES(?,?,?,?,sysdate,?,?,?,sysdate,?,?,?)");
				
			pstmt_delete_dtl.setString(1,term_group_id);
			pstmt_delete_dtl.setString(2,term_set_id);

			pstmt_delete_dtl.executeUpdate();

			pstmt_update_hdr.setString(1,term_group_desc);
			pstmt_update_hdr.setString(2,term_group_applicablity);
			pstmt_update_hdr.setString(3,eff_status);
			pstmt_update_hdr.setString(4,modified_by_id);
			pstmt_update_hdr.setString(5,modified_at_ws_no);
			pstmt_update_hdr.setString(6,modified_facility_id);
			pstmt_update_hdr.setString(7,indextype_yn);
			pstmt_update_hdr.setString(8,term_group_id);
			pstmt_update_hdr.setString(9,term_set_id);


			int result_update = pstmt_update_hdr.executeUpdate();

			StringTokenizer stk_termcodes=new StringTokenizer(termcodes,"~");
			StringTokenizer stk_srnos=new StringTokenizer(sr_nos,"~");


		/* Commented for checkStyle
			int count_termcodes=stk_termcodes.countTokens();
			int count_srnos=stk_srnos.countTokens();
		*/
			while(stk_termcodes.hasMoreTokens())
			{
				pstmt_insert_dtl.setString(1,term_group_id);
				pstmt_insert_dtl.setString(2,term_set_id);

				pstmt_insert_dtl.setString(3,stk_termcodes.nextToken());

				pstmt_insert_dtl.setString(4,added_by_id);
				pstmt_insert_dtl.setString(5,added_at_ws_no);
				pstmt_insert_dtl.setString(6,added_facility_id);
				pstmt_insert_dtl.setString(7,modified_by_id);
				pstmt_insert_dtl.setString(8,modified_at_ws_no);
				pstmt_insert_dtl.setString(9,modified_facility_id);
				pstmt_insert_dtl.setString(10,stk_srnos.nextToken());
			
				pstmt_insert_dtl.addBatch();
			}

			int result_update1[] = pstmt_insert_dtl.executeBatch();
			
			if(result_update >0 && result_update1.length>0)
			{
				conn.commit();
				java.util.Hashtable message = MessageManager.getMessage( locale, "RECORD_MODIFIED","SM" ) ;
				msg = (String) message.get("message");error_val="1";
				message.clear();
			}
			else
			{
				conn.rollback();
				msg = "Operation Failed";
				error_val="0";
			}	
			response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" +java.net.URLEncoder.encode(msg,"UTF-8") + "&err_value=" + error_val);

		}
		catch(Exception e)
		{
			try
			{
				conn.rollback();
			}
			catch(Exception ee)
			{
			}
			//out.println("Error while inserting the values=="+e.toString());
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if(conn != null) ConnectionManager.returnConnection(conn,req);
				if(pstmt_update_hdr != null)pstmt_update_hdr.close();
				if(pstmt_delete_dtl != null)pstmt_delete_dtl.close();
				if(pstmt_insert_dtl != null)pstmt_insert_dtl.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}
}
