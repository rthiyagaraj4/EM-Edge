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
import webbeans.eCommon.*;
import webbeans.eCommon.MessageManager;

public class AllowedDocTypesServlet extends javax.servlet.http.HttpServlet
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

		PrintWriter out			= null;
		String facilityId		= "";
		String login_user		= "";
		String errorMsg			= "";
		String error_value		= "";
		String applicable_yn	= "";						
		String obj_type			= "";
		String slTotal			= "";
		String locale			= "";

		boolean bUpdated			= true;

		HttpSession session = req.getSession(false);
		
		Hashtable htResMesg = new Hashtable();
		Properties p;

		p				= (java.util.Properties) session.getValue( "jdbc" ) ;
		locale			= (String) p.getProperty("LOCALE");
		facilityId		= (String) session.getValue( "facility_id" ) ;
		login_user		= (String) session.getValue( "login_user" ) ;

		PreparedStatement pstmt = null ;
		Connection con = null ;
		ResultSet rs = null;

		slTotal					 =(req.getParameter("count")==null)?"0":req.getParameter("count");
		
		int ilTotal = Integer.parseInt(slTotal);
		
		StringBuffer sql  = new StringBuffer();
		
		if(sql.length() > 0) 
			sql.delete(0,sql.length());

		sql.append("update ca_appl_linked_obj_type set APPLICABLE_YN=? where OBJ_TYPE=? ");

		try 
		{
				out = res.getWriter();
				con = ConnectionManager.getConnection(req);
				pstmt = con.prepareStatement(sql.toString()) ;

				for(int ilCount=0; ilCount<=ilTotal; ilCount++)
				{		 	
					 applicable_yn	=(req.getParameter("applicable_yn"+ilCount)==null)?"N":req.getParameter("applicable_yn"+ilCount);
					 obj_type		=(req.getParameter("obj_type"+ilCount)==null)?"":req.getParameter("obj_type"+ilCount);
					 
					 pstmt.setString(1, applicable_yn);
					 pstmt.setString(2, obj_type);
					 pstmt.addBatch();
				}
	
				int [] updatedCounts = pstmt.executeBatch();

				if(updatedCounts.length == -3 || updatedCounts.length < ilTotal)
					bUpdated = false;

				if(pstmt!=null) pstmt.close();

				if(bUpdated)
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
				res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( errorMsg,"UTF-8" ) + "&err_value=" + error_value );
		}
		catch ( Exception e ) 
		{
			//out.println("Exception"+e.toString());//common-icn-0181
			e.printStackTrace();//COMMON-ICN-0181
		}
		finally
		{
 			try
			{
				if(rs != null) rs.close();
				if(pstmt!=null) pstmt.close();
			}
			catch(Exception e)
			{	}
			
			if(con!=null) ConnectionManager.returnConnection(con,req);
		}
}

public void doGet(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException 
	{
		doPost(req,res);
	}
}
