/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eCA;

import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import javax.naming.*;
import javax.rmi.*;
import webbeans.eCommon.*;

public class ConstructCAMenuServlet extends javax.servlet.http.HttpServlet
{
	private String getMessage(String locale, String messageId, String moduleId)
	{
		java.util.Hashtable message = MessageManager.getMessage(locale,messageId,moduleId);
		String mesg = (String) message.get("message");
		message.clear();
		return(mesg) ;
	}


	public void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
		
		PrintWriter out;
		out = res.getWriter();
		
		Connection          con		= null;
		PreparedStatement	pstmt	= null,		pstmtDelete=null;

		boolean		bUpdated		= true;

		String menu_id						= "";
		String option_id					= "";
		String option_occurance				= "";
		String header_option_id				= "";
		String header_option_occurance		= "";
		String order_seq_no					= "";
		String mode							= "INSERT";
		String desktop_chart				= "";
		String row_cnt						= "";
		String error_value					= "";
		String error						= "";

		int cont			= 0;

		StringBuffer insert_ca_menu_detail = new StringBuffer();
		
		HttpSession session;

		session = req.getSession(false);
		
		Properties p				= (Properties)session.getValue("jdbc") ;
		String locale	= (String) p.getProperty("LOCALE");
	
		try
		{
			row_cnt			= req.getParameter("row_count");
			desktop_chart	= req.getParameter("desktop_chart");
			mode			= req.getParameter("mode")==null?"INSERT":req.getParameter("mode");
			menu_id			= req.getParameter("menu_id");

			if(desktop_chart == null)
				desktop_chart ="";

			if(row_cnt!= null)
				cont = Integer.parseInt(row_cnt);

			con = ConnectionManager.getConnection(req);

			if(mode.equals("UPDATE"))
			{
				pstmtDelete = con.prepareStatement("delete from ca_menu_detail where menu_id=? and desktop_chart=?");
				pstmtDelete.setString(1,menu_id);
				pstmtDelete.setString(2,desktop_chart);

				pstmtDelete.executeUpdate();
			}
			
			if(pstmtDelete !=null) pstmtDelete.close();

			if(insert_ca_menu_detail.length() > 0) 
				insert_ca_menu_detail.delete(0,insert_ca_menu_detail.length());

			insert_ca_menu_detail.append("insert into ca_menu_detail ");
			insert_ca_menu_detail.append("(menu_id,option_id,");
			insert_ca_menu_detail.append("option_occurance,");
			insert_ca_menu_detail.append("header_option_id,");
			insert_ca_menu_detail.append("header_option_occurance,");
			insert_ca_menu_detail.append("order_seq_no,desktop_chart) ");
			insert_ca_menu_detail.append("values (?,?,?,?,?,?,?)");
			
			pstmt	=	con.prepareStatement(insert_ca_menu_detail.toString());	

			for(int i=0;i < cont;i++)
			{
				option_id = req.getParameter("option_id"+i);
				
				if(option_id == null)
					option_id ="";
		
				option_occurance = req.getParameter("option_occurance"+i);
				
				if(option_occurance == null)
					option_occurance ="";

				header_option_id = req.getParameter("header_option_id"+i);

				if(header_option_id == null)
					header_option_id ="";

				header_option_occurance =req.getParameter("header_option_occurance"+i);
				
				if(header_option_occurance == null)
					header_option_occurance ="";

				order_seq_no = req.getParameter("order_seq_no"+i);
				
				if(order_seq_no == null)
					order_seq_no ="";

				pstmt.setString	(1,menu_id.trim());
				pstmt.setString	(2,option_id.trim());
				pstmt.setString	(3,option_occurance.trim());
				pstmt.setString	(4,header_option_id.trim());
				pstmt.setInt	(5,Integer.parseInt(header_option_occurance.trim()));
				pstmt.setInt	(6,Integer.parseInt(order_seq_no.trim()));
				pstmt.setString	(7,desktop_chart.trim());

				pstmt.addBatch();
			}

			int [] nInsStatus = pstmt.executeBatch();
			
			if(nInsStatus.length == -3 || nInsStatus.length <  cont)
				bUpdated = false;

			if(bUpdated)
			{
				con.commit();
				error_value			= "1" ;
				error				= getMessage(locale, "RECORD_INSERTED","CA");
			}
			else
			{
				con.rollback();
				error_value			= "0" ;
				error				= getMessage(locale, "FAILED_TRANSACTION","CA");
			}
			
			res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8" ) + "&err_value=" + error_value );
		}
		catch(Exception euptd)
		{
			out.println("Exception in CA Construct Menu:"+euptd);
			euptd.printStackTrace();
			out.println("Exception:"+euptd);
		}
		finally
		{
			try
			{
				if(pstmt!=null) 	pstmt.close();
			}
			catch(Exception e)
			{
				out.println(e.toString());
				e.printStackTrace();
			}
			
			if(con != null) ConnectionManager.returnConnection(con, req);
		}
	}
}
