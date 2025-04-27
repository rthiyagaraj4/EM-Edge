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
import webbeans.eCommon.*;
import webbeans.eCommon.MessageManager;

public class ClinicEventMasterServlet extends javax.servlet.http.HttpServlet
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
		Hashtable htResMesg = new Hashtable();
		java.util.Properties p;
		
		String facilityId				=	"",					login_user			=	"";
		String errorMsg					=	"",					error_value			=	"";
		String hist_rec_type			=	"",					event_code			=	"";						
		String create_review_ord_phys_yn =	"",					create_review_atn_phys_yn = "";

		HttpSession session				=	req.getSession(false);

		p					= (java.util.Properties) session.getValue( "jdbc" ) ;
		String locale		= (String) p.getProperty("LOCALE");
		facilityId			= (String) session.getValue( "facility_id" ) ;
		login_user			= (String) session.getValue( "login_user" ) ;

		Connection			con		= null ;
		PreparedStatement	pstmt	= null ;
		ResultSet			rs		= null;

		boolean updated				= true;

		String slTotal =(req.getParameter("count")==null)?"0":req.getParameter("count");
		int ilTotal = Integer.parseInt(slTotal);
		StringBuffer sql  = new StringBuffer();

		if(sql.length() > 0) 
			sql.delete(0,sql.length());

		sql.append("Update cr_clin_event_mast set CREATE_REVIEW_ORD_PHYS_YN=?,  ");
		sql.append("CREATE_REVIEW_ATN_PHYS_YN=?, ");
		sql.append("MODIFIED_BY_ID=?,  " );
		sql.append("MODIFIED_DATE= SYSDATE,  ");
	    sql.append("MODIFIED_FACILITY_ID=?");
	    sql.append(" Where HIST_REC_TYPE=? and EVENT_CODE=? " );	
		
		try 
		{
			out = res.getWriter();
            con = ConnectionManager.getConnection(req);
			pstmt = con.prepareStatement(sql.toString()) ;
			
			for(int ilCount=0; ilCount<ilTotal; ilCount++)
			{		 	
				 hist_rec_type				 =(req.getParameter("hist_rec_type"+ilCount)==null)?"":req.getParameter("hist_rec_type"+ilCount)	 ;
				 event_code					 =(req.getParameter("event_code"+ilCount)==null)?"":req.getParameter("event_code"+ilCount);
				 create_review_ord_phys_yn	 =(req.getParameter("Ord_phys_yn"+ilCount)==null)?"N":req.getParameter("Ord_phys_yn"+ilCount);
				 create_review_atn_phys_yn   =(req.getParameter("Atn_phys_yn"+ilCount)==null)?"N":req.getParameter("Atn_phys_yn"+ilCount);  

				 pstmt.setString(1, create_review_ord_phys_yn);
				 pstmt.setString(2, create_review_atn_phys_yn);
				 pstmt.setString(3, login_user);
				 pstmt.setString(4, facilityId);
				 pstmt.setString(5, hist_rec_type);
				 pstmt.setString(6, event_code);
				 pstmt.addBatch();
			}

			int [] updatedCounts = pstmt.executeBatch();
			if(pstmt!=null) pstmt.close();

			if(updatedCounts.length  == -3 || updatedCounts.length < ilTotal)
				updated= false;

			if(updated)
			{	
				con.commit();
				htResMesg = MessageManager.getMessage(locale, "RECORD_INSERTED","CA");
				error_value = "1" ;
			}
			else
			{
				con.rollback();
				htResMesg = MessageManager.getMessage(locale, "FAILED_TRANSACTION","CA");
				error_value = "0";
			}
			
			errorMsg = (String)htResMesg.get("message");
			res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( errorMsg,"UTF-8") + "&err_value=" + error_value );
		}
		catch ( Exception e ) 
		{
			//out.println("Exception"+e.toString());//common-icn-0181
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if(rs != null) rs.close();
				if(pstmt!=null) pstmt.close();
				
			}
			catch(Exception e){	}
			if(con!=null) ConnectionManager.returnConnection(con,req);
		}
}

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException 
	{
			doPost(req,res);
	}
}
