/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eAT;

import java.lang.reflect.Method;
import java.net.URLEncoder;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.HashMap;
import javax.naming.InitialContext;
import javax.rmi.PortableRemoteObject;
import eCommon.SingleTabHandler.*;
import java.sql.*;
import javax.sql.*;
import webbeans.eCommon.ConnectionManager  ;

public class ATParamServlet extends javax.servlet.http.HttpServlet{
	PrintWriter out;
	HttpSession session;
	java.util.Properties p;
	HashMap results;
	String login_user="";
	
	

	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	}

	public synchronized void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		
		PrintWriter out = res.getWriter();
		req.setCharacterEncoding("UTF-8");
		session = req.getSession(true);
		
		
		Connection connection   = null ;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt1 =null ;
		try
					
					{
								
		connection	= ConnectionManager.getConnection(req);
										
		System.out.println("datbase");		
										
		String preanaesthesia_noteType = req.getParameter("preanaesthesia_noteType");
		String intraanaesthesia_noteType=req.getParameter("intraanaesthesia_noteType");
		String postanaesthesia_noteType	=req.getParameter("postanaesthesia_noteType");
		String discrete_measureCode=req.getParameter("discrete_measureCode");
		
										
		String sql = "INSERT INTO  AT_PARAM(PRE_ANES_NOTE_TYPE,INTRA_ANES_NOTE_TYPE,POST_ANES_NOTE_TYPE,DISCR_MSR_ID) VALUES(?,?,?,?)";
									
		pstmt  =connection.prepareStatement(sql);
		pstmt.setString(1,preanaesthesia_noteType);
		pstmt.setString(2,intraanaesthesia_noteType);
		pstmt.setString(3,postanaesthesia_noteType);
		pstmt.setString(4,discrete_measureCode);
		pstmt.executeUpdate();
		connection.commit();

		out.println("your data is inserted");
		
		}
							catch(Exception e)
							{
		out.println("sorry unable to process request");
		System.err.println("Caught Exception error : "+e);
								
		e.printStackTrace() ;
								
							}
							finally 
								{
									
								}

					
	}//void post 

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		doPost(req,res);
	}

	
}

