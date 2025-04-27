/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eXH;

import java.io.*;
import java.util.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

import webbeans.eCommon.ConnectionManager;
import webbeans.eCommon.*;
import eXH.XHDBAdapter;

/**
 *  Class used for debug log operations
 */
public class XHDebugInfoServlet extends HttpServlet
{
    /**
	 * Do post method which implements the functionalities for debug log
	 * @param  HttpServletRequest request
	 * @param  HttpServletResponse response
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
        throws IOException, ServletException
    {    
		
        HttpSession session=request.getSession(false);
		
		Properties p = (Properties) session.getValue("jdbc");	
		String locale  = p.getProperty("LOCALE");

		request.setCharacterEncoding("UTF-8");
   	    response.setContentType("text/html;charset=UTF-8");

		try
		{
			String pgmList = XHDBAdapter.checkNull((String)request.getParameter("strPGM"));
			String clientList = XHDBAdapter.checkNull((String)request.getParameter("strClient"));
			String fromDate = XHDBAdapter.checkNull((String)request.getParameter("fromDate"));
			String toDate = XHDBAdapter.checkNull((String)request.getParameter("toDate"));
			String mode = XHDBAdapter.checkNull((String)request.getParameter("mode"));

		/*	System.out.println("(XHDebugInfoServlet:pgmList) "+pgmList);
			System.out.println("(XHDebugInfoServlet:clientList) "+clientList);
			System.out.println("(XHDebugInfoServlet:fromDate) "+fromDate);
			System.out.println("(XHDebugInfoServlet:toDate) "+toDate);
			System.out.println("(XHDebugInfoServlet:MODE) "+mode);
		*/
			HashMap detailsMap = new HashMap();

			detailsMap.put("strPGM",pgmList);
			detailsMap.put("strClient",clientList);
			detailsMap.put("fromDate",fromDate);
			detailsMap.put("toDate",toDate);

			HashMap result_hm = null;

			if(mode.equalsIgnoreCase("D"))
			{
				result_hm = deleteLog(detailsMap,locale);
			}

			RequestDispatcher reqDis=null;
			reqDis = session.getServletContext().getRequestDispatcher("/eXH/jsp/DisplayResult.jsp?message="+(String)result_hm.get("status"));		
			reqDis.forward(request,response);
		}
		catch(Exception exp)
		{
			exp.printStackTrace(System.err);
		}					

    }//end of do post
	
	/**
	 * Method used to delete selected records from XH_TRACE.
	 */
	public HashMap deleteLog(HashMap details,String locale)
	{
		Connection dbConn = null;
		Statement stmt = null;

		String status = "";
		String deleteLogQuery = "DELETE xh_trace ";

		HashMap result_hm = new HashMap();
		MessageManager mm=new MessageManager();

		try
		{
			String strPGM = (String)details.get("strPGM");
			String strClient = (String)details.get("strClient");
			String fromDate = (String)details.get("fromDate");
			String toDate = (String)details.get("toDate");
			String whereClause = "";

			boolean flag = false;

			if(!strPGM.equals(""))
			{
				flag = true;
				whereClause = whereClause+" WHERE pgm_id IN ("+strPGM+")";
			}
			
			if(!strClient.equals("") && !strClient.equals("'ALL'"))
			{
				if(flag) whereClause = whereClause+" AND machineid IN ("+strClient+")";
				else whereClause = whereClause+" WHERE machineid IN ("+strClient+")";
			}

			if(!fromDate.equals(""))
			{
				if(flag) 
				{
					if(!toDate.equals(""))
					{
						whereClause = whereClause+" AND TO_NUMBER(to_CHAR(RX_DATE,'RRRRMMDDHH24MISS')) BETWEEN TO_NUMBER(to_CHAR(TO_DATE('"+fromDate+"','DD/MM/RRRR HH24:MI:SS'),'RRRRMMDDHH24MISS')) AND TO_NUMBER(to_CHAR(TO_DATE('"+toDate+"'),'RRRRMMDDHH24MISS'))";
					}
					else
					{
						whereClause = whereClause+" AND TO_NUMBER(to_CHAR(RX_DATE,'RRRRMMDDHH24MISS')) >= TO_NUMBER(to_CHAR(TO_DATE('"+fromDate+"','DD/MM/RRRR HH24:MI:SS'),'RRRRMMDDHH24MISS'))";
					}
				}
				else 
				{
					if(!toDate.equals(""))
					{
						whereClause = whereClause+" WHERE TO_NUMBER(to_CHAR(RX_DATE,'RRRRMMDDHH24MISS')) BETWEEN TO_NUMBER(to_CHAR(TO_DATE('"+fromDate+")','DD/MM/RRRR HH24:MI:SS','RRRRMMDDHH24MISS')) AND TO_NUMBER(to_CHAR(TO_DATE('"+toDate+"'),'RRRRMMDDHH24MISS'))";
					}
					else
					{
						whereClause = whereClause+" WHERE TO_NUMBER(to_CHAR(RX_DATE,'RRRRMMDDHH24MISS')) >= TO_NUMBER(to_CHAR(TO_DATE('"+fromDate+")','DD/MM/RRRR HH24:MI:SS','RRRRMMDDHH24MISS'))";
					}
				}
			}
			else if(!toDate.equals(""))
			{
				if(flag) 
				{
					whereClause = whereClause+" AND TO_NUMBER(to_CHAR(RX_DATE,'RRRRMMDDHH24MISS')) <= TO_NUMBER(to_CHAR(TO_DATE('"+toDate+"','DD/MM/RRRR HH24:MI:SS'),'RRRRMMDDHH24MISS'))";
				}
				else 
				{
					whereClause = whereClause+" WHERE TO_NUMBER(to_CHAR(RX_DATE,'RRRRMMDDHH24MISS')) <= TO_NUMBER(to_CHAR(TO_DATE('"+toDate+")','DD/MM/RRRR HH24:MI:SS','RRRRMMDDHH24MISS'))";					
				}
			}

			deleteLogQuery = deleteLogQuery+whereClause;			

			dbConn = ConnectionManager.getConnection();
			stmt = dbConn.createStatement();
			int i =	stmt.executeUpdate(deleteLogQuery);

			if(i > 0)
			{
					dbConn.commit();
					final java.util.Hashtable mesg = mm.getMessage(locale, "XH1001", "XH") ;
					status = ((String) mesg.get("message"));
			}
			else
			{
					dbConn.rollback();
					final java.util.Hashtable mesg = mm.getMessage(locale, "XH1000", "XH") ;
					status = ((String) mesg.get("message"));		
			}
		}
		catch(Exception exp)
		{			
			exp.printStackTrace(System.err);
		}
		finally
		{
			try
			{
				if(stmt != null) stmt.close();
				if(dbConn != null) ConnectionManager.returnConnection(dbConn);
			}catch(Exception fexp)
			{
				fexp.printStackTrace(System.err);
			}
		}

		result_hm.put("status",status);

		return result_hm; 
	}



}//end of class
