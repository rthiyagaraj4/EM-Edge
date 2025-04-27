/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       	Edit History     Name      			Rev.Date		Rev.Name		Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
11/05/2018	IN063838		Ramesh G											ML-MMOH-CRF-0813
---------------------------------------------------------------------------------------------------------------------------------------------------------
*/ 
package eCA;

import java.io.*;
import java.sql.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.naming.*;
import javax.rmi.*;
import java.net.*;
import webbeans.eCommon.*;

public class TannerStagingServlet extends HttpServlet
{
	public void doPost(HttpServletRequest request, HttpServletResponse response)throws javax.servlet.ServletException,IOException
	{
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = null;
		java.util.Properties p;
		HttpSession session;
		session = request.getSession(false);
		p = (java.util.Properties) session.getValue("jdbc") ;
		try{
			out = response.getWriter();
			insert(request, response,out,p,session); 
		}
		catch(Exception e){
			//out.println("Exception in try of doPost() of ChartSetupServlet.java"+e);//common-icn-0181
			e.printStackTrace();
		}
	}

public void doGet(HttpServletRequest req, HttpServletResponse response) throws javax.servlet.ServletException,IOException
	{
		PrintWriter out = null;
		try
		{
			out = response.getWriter();
			doPost(req,response);		
		}
		catch(Exception e)	
		{	
			out.println("Exception in invoking doPost Method");
			e.printStackTrace();
		}
	}
public void insert(HttpServletRequest request, HttpServletResponse response, PrintWriter out, java.util.Properties p, HttpSession session) throws SQLException, IOException
{	
	Connection con 		= null;
	String error 		= "" ;
	String locale		="";
	PreparedStatement pstmt 	= null;
	PreparedStatement pstmt1 	= null;	
//	boolean update_spl_chart_group_flag=false;   //Common-ICN-0092  
	locale		= (String) p.getProperty("LOCALE");
	String practitionerId 	= (String)	session.getValue("ca_practitioner_id")==null ? "" :(String)	session.getValue("ca_practitioner_id");
	String facilityId 		= (String)	session.getValue("facility_id")==null ? "" :(String)	session.getValue("facility_id") ;
	String patientId 		= request.getParameter("patientId")==null?"":(String)request.getParameter("patientId");
	String encounterId 		= request.getParameter("encounterId")==null?"":(String)request.getParameter("encounterId");
	String stageOfPuberty 	= request.getParameter("stageOfPuberty")==null?"":(String)request.getParameter("stageOfPuberty");
	String pubicHair 		= request.getParameter("pubicHair")==null?"":(String)request.getParameter("pubicHair");
	String addedById   		= p.getProperty( "login_user" )==null ? "" :p.getProperty( "login_user" ) ;			
	String addedAtWSNo 		= p.getProperty("client_ip_address") ==null ? "" : p.getProperty("client_ip_address");
	
	try
	{
		con = ConnectionManager.getConnection(request);		
		
		pstmt1 = con.prepareStatement("INSERT INTO CA_TANNER_STAGING_DTL (PATIENT_ID,EVENT_DATE_TIME, ENCOUNTER_ID, PUBERTY_STAGE,PUBIC_HAIR_STAGE, FACILITY_ID,PRACTITIONER_ID,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID) VALUES (?,SYSDATE,?,?,?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?)");
		
		pstmt1.setString(1,patientId);
		pstmt1.setString(2,encounterId);
		pstmt1.setString(3,stageOfPuberty);
		pstmt1.setString(4,pubicHair);
		pstmt1.setString(5,facilityId);
		pstmt1.setString(6,practitionerId);		
		pstmt1.setString(7,addedById);
		pstmt1.setString(8,addedAtWSNo);						
		pstmt1.setString(9,facilityId);
		pstmt1.setString(10,addedById);
		pstmt1.setString(11,addedAtWSNo);
		pstmt1.setString(12,facilityId);
		
		int k2 = pstmt1.executeUpdate();
		
		if (pstmt1 != null)pstmt1.close();
		
		if(k2>0){			
			con.commit() ;
			error = getMessage (locale, "RECORD_INSERTED","CA");
			response.sendRedirect("../eCA/jsp/CAError.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8" ) + "&err_value=1");						
		}
	}catch(Exception m){
		m.printStackTrace();		
	}
	finally
		{

		if(pstmt != null)pstmt.close();
		if(con != null)	con.close();		
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
