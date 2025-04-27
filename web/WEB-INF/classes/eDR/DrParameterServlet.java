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
	Function Name	   :  Change ID Series
	Function ID		   :

*/

package eDR;
import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import webbeans.eCommon.*;

public class DrParameterServlet extends javax.servlet.http.HttpServlet
{
	PrintWriter out;
	Properties p;
	
	Connection con						= null;
	PreparedStatement pstmt				= null;
	
	String start_time					= "";
	String end_time 					= "";
	String mode							= "Update";
	String sql							= ""; 
	String error_value					= "";
	String error						= "";
	
	int value1							= 0;



	public void init(ServletConfig config) throws ServletException
	{
			super.init(config);
	}

	public synchronized void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		try
		{
			con		= ConnectionManager.getConnection(req);
					
			req.setCharacterEncoding("UTF-8");
			res.setContentType("text/html;charset=UTF-8");
			this.out	= res.getWriter();

		
			
			if(mode != null && mode.equals("Update"))
			{
				updateDrParamTime(req, res);
			}
		}
		catch(Exception e)
		{
			out.println("Exception in doPost method :"+ e.toString());
			e.printStackTrace();
		}
		finally
		{
			ConnectionManager.returnConnection(con, req);
		}
	}//do post
	private  void updateDrParamTime(HttpServletRequest req, HttpServletResponse res)
	{
		try
		{
			
            HttpSession session = req.getSession(false);
			p = (java.util.Properties) session.getValue("jdbc");
			String locale = p.getProperty("LOCALE"); 	

			start_time  = req.getParameter("start_time");
			end_time	= req.getParameter("end_time");	
				
			sql	= "update DR_PARAM set EXEC_START_TIME = to_date(?,'hh24:mi'), EXEC_END_TIME = to_date(?,'hh24:mi') where MODULE_ID='DR'";
			
			pstmt	= con.prepareStatement(sql);
			pstmt.setString(1, start_time);
			pstmt.setString(2, end_time);

	
	

			value1	= pstmt.executeUpdate();

	

	
				
			if(value1 != 0)
  		    {
				con.commit();
				error_value	= "1" ;
			//	error		= "APP-SM0002 Operation Completed Successfully ....";
				
			java.util.Hashtable message = MessageManager.getMessage(locale, "RECORD_MODIFIED", "SM");
			String error = ((String) message.get("message"));

		        res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8" ) + "&err_value="+error_value);	
				
			}
			else 
			{
				con.rollback();

		/*		error		= "APP-SM0000 Transaction Failes ....<br>" ;
				error_value	= "0" ;
				res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error ) + "&err_value=" + error_value );
				*/
			}
			if(pstmt!=null) pstmt.close();
		}
		catch(Exception e)
		{	
			try
			{
				con.rollback();
			}catch(Exception ee){out.println("Exception while Rollback");}
			out.println("Transaction Failed :"+e);
			e.printStackTrace();
		} 
	}//method
}//class
