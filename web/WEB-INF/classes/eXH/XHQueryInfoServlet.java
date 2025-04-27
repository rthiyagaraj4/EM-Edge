/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eXH;

import java.sql.*;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import webbeans.eCommon.ConnectionManager;
import webbeans.eCommon.*;
import eXH.XHDBAdapter;

/**
 *  The XHViewEventsOutboundServlet class used to implement the functionalities of  
 *  Administered events and view events(0utbound).
 *
 */

public class XHQueryInfoServlet extends HttpServlet
{
	
	HttpServletRequest req=null;

    /**
	 * Do post method which implements the functionalities for Replay and Rebuild 
	 * @param  HttpServletRequest request
	 * @param  HttpServletResponse response
	 * @throws IOException
	 * @throws ServletException
	 */
	
	public void doPost (HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException 
	{
		Connection con = null;
		List columnNames = null;
		  try{
			   con = ConnectionManager.getConnection();
			   DatabaseMetaData dbmd = con.getMetaData();
			   ResultSet columns = dbmd.getColumns(null, "%", request.getParameter("table_name"), "%");
			   columnNames = new ArrayList();
			   while(columns.next())
			  {
					columnNames.add(columns.getString("COLUMN_NAME"));
			  }
				request.setAttribute("columns",columnNames);
				request.setAttribute("table",request.getParameter("table_name"));
		//		System.out.println("CONTEXT "+request.getSession(false).getServletContext());
			  	RequestDispatcher reqDis = 	request.getRequestDispatcher("/eXH/jsp/ShowElementSegmentQueryInfo.jsp");
				reqDis.forward(request,response);	

	    }catch(Exception ex)
	     { 
		       System.out.println("Error in dopost method of xhvieweventsoutboundservlet "+ex.toString());
		       ex.printStackTrace(System.err);
	     }
	     finally{
		         try{
	                  if(con!=null) ConnectionManager.returnConnection(con);
		            }catch(Exception ex){}
	     }
	
	}// end of do post


}// end of class
