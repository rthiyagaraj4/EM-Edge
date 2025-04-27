/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eSM;
import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import java.net.URLEncoder;
import webbeans.eCommon.*;

public class ReportServlet extends javax.servlet.http.HttpServlet implements SingleThreadModel
{
	PrintWriter out;
	String Report_Id;
	String Facility_Based_Yn;
	String Report_Group;
	String facilityId ;
    String Select_Yn; 
	HttpSession session;
	Connection con;
	Properties p;
	String locale;
	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	}

	public synchronized void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{ 
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
		session = req.getSession(false);
	    this.p	= (java.util.Properties) session.getValue( "jdbc" ) ;
		this.facilityId = (String) session.getValue( "facility_id" ) ;
		if(facilityId==null) facilityId="";
		locale = p.getProperty("LOCALE");	
		try
		{
			this.out = res.getWriter();

			modifyReport(req, res);
		}
		catch(Exception e)
		{
			out.println(e.toString());
		}
	}

	private void modifyReport(HttpServletRequest req, HttpServletResponse res)
	{       
		try
		{ 
             con =  ConnectionManager.getConnection(req);
	        PreparedStatement pstmt = null;
	        con.setAutoCommit(false);
            String maxRecord=req.getParameter("maxrecord");
			int maxRec=Integer.parseInt(maxRecord);
			String query;
            int cnt=0;
			
           for(int k=1;k<maxRec;k++)
            {
                       
			Report_Id=req.getParameter("reportId"+k)==null ? "" : req.getParameter("reportId"+k);
			Facility_Based_Yn=req.getParameter("facBased"+k)==null ? "Y" : req.getParameter("facBased"+k);
			Report_Group=req.getParameter("repGrp"+k)==null ? "" : req.getParameter("repGrp"+k);
			
            Select_Yn=req.getParameter("Select_Yn"+k)==null ? "" : req.getParameter("Select_Yn"+k);
			
			if(Select_Yn.equals("Y"))
			{
				       
			 query="update sm_report set report_group_id ='"+Report_Group+"',facility_based_yn ='"+Facility_Based_Yn+"' where report_id ='"+Report_Id+"'";

			 pstmt=con.prepareStatement(query);
		     cnt=pstmt.executeUpdate();
				 
			}if(pstmt != null) pstmt.close();
		  }   
		  String error="";
           MessageManager mm=new MessageManager();
				 if(cnt >= 1)
					{
					 con.commit();
					java.util.Hashtable mesg=mm.getMessage(locale, "RECORD_MODIFIED", "SM") ;
                     error = (String)mesg.get("message");
					 mesg.clear();
					 res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + URLEncoder.encode(error, "UTF-8") + "&err_value=1");
                   	}
				else
					{
					
   					 con.rollback();
					java.util.Hashtable mesg=mm.getMessage(locale, "NO_CHANGE_TO_SAVE", "Common") ;
                    error = (String)mesg.get("message");
					 mesg.clear();
                     res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + URLEncoder.encode(error, "UTF-8") + "&err_value=1");	 
					}
		                 			
		}
catch ( Exception e )
	{
		out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
		out.println(e.toString());
	}
       finally
			{
				if( con != null ) ConnectionManager.returnConnection(con,req);
			}      
					   
	}

}
	
        		
			



	
			

			
