/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eXH;

import javax.servlet.http.*;
import javax.servlet.*;
import java.sql.*;
import java.io.*;
import java.util.*;
import webbeans.eCommon.ConnectionManager;
import webbeans.eCommon.*;
import eXH.*;

/**
 * Servlet to deal with Element Segment Configuaration data. 
 *
 */
public class ElementSegmConfValidateServlet extends HttpServlet
{

HttpServletRequest req=null;

/**
	 * doPost -- inserts a new record in xh_event_segment_config table (Element Segment Config)
	 * @param  HttpServletRequest request
	 * @param  HttpServletResponse response
	 * @throws IOException
	 * @throws ServletException
	 */
	
public void doPost (HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException 
{	
		PrintWriter out = response.getWriter();
		req=request;

		String exceptions="";
			
		HttpSession session=request.getSession(false);
		Properties p;		
		p = (Properties) session.getValue("jdbc");	
	//	String locale  = p.getProperty("LOCALE");

		request.setCharacterEncoding("UTF-8");
   	    response.setContentType("text/html;charset=UTF-8");

		String QueryResult = request.getParameter("QueryResult");
		//String qryText = request.getParameter("qryText");
		//String sysDefStructure = request.getParameter("SystDefStructure");


	  Connection connection = null;	  
	  Statement statement = null;
      ResultSet resultSet = null;

	  int errFlag = 0;

      try
	  {
		if(connection==null) connection = ConnectionManager.getConnection();      
      }
      catch(Exception exp){
		System.out.println("Error in calling getconnection method of ElementSegmConfValidateServlet  :"+exp.toString());
		exp.printStackTrace(System.err);
	//	exceptions=exceptions+"1"+"*"+exp.toString();        
      }
		try{
		    statement = connection.createStatement();
			resultSet = statement.executeQuery(QueryResult); 
		}
		catch(Exception exp){
			errFlag = 1;
			System.out.println("Error in executing QueryResult of ElementSegmConfValidateServlet  :"+exp.toString());
			exp.printStackTrace(System.err);
//			exceptions=exceptions+"1"+"*"+exp.toString();  
			exceptions=exp.toString();        
		}
		finally
		{

		try{
			ConnectionManager.returnConnection(connection);
			if(statement != null) statement.close();
			if(resultSet != null) resultSet.close();			
		}
		catch(Exception ex){
		   System.out.println("Error in closing dbrealted statements in callejb method of CommProtocolIdAddModifyServlet :"+ex.toString());
		   ex.printStackTrace(System.err); 
		}

		}

//		  if(errFlag==1){
// 				System.out.println("errFlag : "+errFlag);
//				RequestDispatcher reqDis = 	session.getServletContext().getRequestDispatcher("/eXH/jsp/ShowElementSegmentQueryInfo.jsp?message='"+exceptions+"'&QueryResult="+QueryResult);
				RequestDispatcher reqDis = 	session.getServletContext().getRequestDispatcher("/eXH/jsp/ElementSegmentQueryInfo.jsp?message='"+exceptions+"'&QueryResult='"+QueryResult+"'&errFlag="+errFlag);
				reqDis.forward(request,response);		

	}// end of do post

}//end of class 
