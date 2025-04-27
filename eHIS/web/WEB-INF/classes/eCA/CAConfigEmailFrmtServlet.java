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
import javax.naming.*;
import javax.rmi.*;
import java.util.*;
import webbeans.eCommon.*;
import webbeans.eCommon.MessageManager; 

public class CAConfigEmailFrmtServlet extends javax.servlet.http.HttpServlet
{
    
    public void init(ServletConfig config) throws ServletException
    {
        super.init(config);
    }

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		PrintWriter out = null;
		try
		{
			out = res.getWriter();
			doPost(req,res);		
		}
		catch(Exception e)	
		{	
			out.println("Exception in invoking doPost Method");
			e.printStackTrace();
		}
	}
	  public  void doPost(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException,IOException
    {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");	
		PrintWriter out = null;
		HttpSession session;
		session = request.getSession(false);

		String locale				= "";
		String eventName			= "";
		//String eventDesc			= "";
		String eventStatus			= "";
		String eventHdr			    = "";
		String reportTypeId			= "";
		String error_value="";
		String error="";

		String total_count="";
		int total_rows=0;
		int[] resCnt = null;
		int i=0;
		//int count1=0;
		//boolean update_flag = false ;

		String strSql1 = "";
		
		Properties p;
		p				= (java.util.Properties) session.getValue( "jdbc" ) ;
		Connection con				= null;		
		PreparedStatement pstmt1	= null;
		//ResultSet rs = null;
		
		

		try
		{
			out = response.getWriter();
			con = ConnectionManager.getConnection(request);

			reportTypeId = request.getParameter("configureEmailReport") == null ? "" : request.getParameter("configureEmailReport");
			total_count = request.getParameter("total_count") == null ? "0" : request.getParameter("total_count");
		    //total_count					 =(request.getParameter("total_count")==null)?"0":request.getParameter("total_count");

			total_rows=Integer.parseInt(total_count);
			strSql1 = "Update CA_CONFIG_EMAIL_FORMAT set EVENT_STATUS = ? where REPORT_ID = ? and EVENT_NAME = ?";
			
			pstmt1 = con.prepareStatement(strSql1);
			for(i=1;i<=total_rows;i++)
			{
				eventName		=(request.getParameter("eventName"+i)==null)?"":request.getParameter("eventName"+i);			
				eventHdr		=(request.getParameter("eventHdr"+i)==null)?"":request.getParameter("eventHdr"+i);			
				eventStatus =request.getParameter("eventStatus"+i+"~"+eventHdr)==null?"N":request.getParameter("eventStatus"+i+"~"+eventHdr);			
							
				if (reportTypeId.equals("EMPATINS") && ((eventName.equals("ORD_CAT_DTL")) || (eventName.equals("PAT_INSTRUCTIONS"))))
				{				 
				   eventStatus = "Y";
				}
				
				pstmt1.setString(1,eventStatus);
				pstmt1.setString(2,reportTypeId);
				pstmt1.setString(3,eventName);

				pstmt1.addBatch();
			}
			resCnt = pstmt1.executeBatch();
			 if(resCnt != null)
			{
				con.commit();				
				error = getMessage(locale, "RECORD_INSERTED","CA");
			    error_value = "1" ;			response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num="+java.net.URLEncoder.encode(error,"UTF-8"));
			}
			else
		{			
			error_value	= "0" ;
			error = getMessage(locale, "FAILED_TRANSACTION","CA");
		} 	     		
      

			
			if(pstmt1!=null) pstmt1.close();		
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			
		}
		finally
		{
			try
			{
				
				if(con!=null) ConnectionManager.returnConnection(con, request);
				//	response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error ) + "&err_value=" + error_value );			    
			}
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
