/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/* 
--------------------------------------------------------------------------------------------------------------------
Date       		Edit History    	 Name      			Rev.Date		Rev.Name		Description
--------------------------------------------------------------------------------------------------------------------			 	
29/04/2024     58928	     Krishna pranay	         30/04/204         Ramesh Goli       	ML-MMOH-CRF-1759.2
--------------------------------------------------------------------------------------------------------------------
*/
package eCA;
import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import javax.naming.*;
import javax.rmi.*;
import java.util.*;
import webbeans.eCommon.MessageManager;
import webbeans.eCommon.*;

public class CAMenstrualHistDtlServlet extends javax.servlet.http.HttpServlet	
{	
/**
*	init	-	will initialise the servlet
*	@param	config - this is ServletConfig
*/
public void init(ServletConfig config) throws ServletException	{
		super.init(config);
	}

public  void doGet(HttpServletRequest req, HttpServletResponse response)throws javax.servlet.ServletException,IOException
{
	doPost(req,response);
}
/**
*	doPost	-	will be called when the method is of post
*	@param	req - this is HttpServletRequest
*	@param	response - this is HttpServletResponse
*	throws javax.servlet.ServletException,IOException
*/
public  void doPost(HttpServletRequest req, HttpServletResponse response)throws javax.servlet.ServletException,IOException
{
		req.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		HttpSession session = req.getSession(false);
		PrintWriter out = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String Min_Age = "";
		String Max_Age = "";
		String Cut_Off_Backdate_Delivery=""; 
		String Cut_Off_Date_Delivery=""; 
		String Cut_Off_Delivery_Lmp="";
		String Cut_Off_Miscarriage_Lmp="";
		String Enable_Mark_As_Error_YN="";
		String errorMsg = "";
		String user_id = "";
		String client_ip_addr = "";
		String facility_id = "";
		String menstrual_History_dtl = "";
		String operationalFacility="";
		String locale = "";
		int result = 0;
		Hashtable tabdata = new Hashtable();
		Properties p;

		try
		{

			con = ConnectionManager.getConnection();
			out = response.getWriter();		
			operationalFacility	= req.getParameter("facility")==null?"":req.getParameter("facility");
			Min_Age = req.getParameter("Min_Age")==null?"":req.getParameter("Min_Age");
			Max_Age = req.getParameter("Max_Age")==null?"":req.getParameter("Max_Age");
			Cut_Off_Backdate_Delivery = req.getParameter("Cut_Off_Backdate_Delivery")==null?"":req.getParameter("Cut_Off_Backdate_Delivery"); // 41650
			Cut_Off_Date_Delivery = req.getParameter("Cut_Off_Date_Delivery")==null?"":req.getParameter("Cut_Off_Date_Delivery"); // 41653
			Cut_Off_Delivery_Lmp = req.getParameter("Cut_Off_Delivery_Lmp")==null?"":req.getParameter("Cut_Off_Delivery_Lmp"); // 41653
			Cut_Off_Miscarriage_Lmp = req.getParameter("Cut_Off_Miscarriage_Lmp")==null?"":req.getParameter("Cut_Off_Miscarriage_Lmp"); // 41653
			Enable_Mark_As_Error_YN = req.getParameter("Enable_Mark_As_Error_YN")==null?"":req.getParameter("Enable_Mark_As_Error_YN"); // 41653

			p = (java.util.Properties) session.getValue( "jdbc" ) ;
			locale = (String) p.getProperty("LOCALE");
			facility_id = (String) session.getValue( "facility_id" ) ;
			client_ip_addr=	p.getProperty("client_ip_address");
			user_id =  (p.getProperty("login_user")==null)?"":p.getProperty("login_user")  ;
			
			String addedById			= p.getProperty( "login_user" ) ;
			String modifiedById			= addedById ;
			String addedFacilityId		= facility_id;
			String modifiedFacilityId	= facility_id ;
			String addedAtWorkstation	= client_ip_addr;
			String modifiedAtWorkstation = addedAtWorkstation ;

	
			if(!Min_Age.equals("") && !Max_Age.equals("") && !Cut_Off_Backdate_Delivery.equals("") && !Cut_Off_Date_Delivery.equals("") && !Cut_Off_Delivery_Lmp.equals("") && !Cut_Off_Miscarriage_Lmp.equals("") )
			{			
				String insertQry = "SELECT 1 FROM CA_MENSTRUAL_HIST_DTL";
				pstmt = con.prepareStatement(insertQry);
				rs = pstmt.executeQuery();
				if (rs != null  && rs.next())
				{
					menstrual_History_dtl = rs.getString(1)==null?"":rs.getString(1);
				}
				if (rs != null)rs.close();
				if (pstmt != null)pstmt.close();
				if (menstrual_History_dtl.equals(""))
				{
				   insertQry = "INSERT INTO CA_MENSTRUAL_HIST_DTL (FACILITY_ID,MIN_AGE,MAX_AGE,CUT_OFF_BACK_DATE,CUT_OFF_DATE_DELIVERY,CUT_OFF_DELIVERY_LMP,CUT_OFF_MISCARRIAGE_LMP,ENABLE_MARK_AS_ERROR_YN,ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID) VALUES (?,?,?,?,?,?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?)"; // 41653
	
					pstmt = con.prepareStatement(insertQry);
					pstmt.setString(1,operationalFacility);
					pstmt.setString(2,Min_Age);
					pstmt.setString(3,Max_Age);
					pstmt.setString(4,Cut_Off_Backdate_Delivery);
					pstmt.setString(5,Cut_Off_Date_Delivery);
					pstmt.setString(6,Cut_Off_Delivery_Lmp);
					pstmt.setString(7,Cut_Off_Miscarriage_Lmp);
					pstmt.setString(8,Enable_Mark_As_Error_YN);
					pstmt.setString(9,addedById);
					pstmt.setString(10,addedAtWorkstation);
					pstmt.setString(11,addedFacilityId);
					pstmt.setString(12,modifiedById);
					pstmt.setString(13,modifiedAtWorkstation);
					pstmt.setString(14,modifiedFacilityId);
					result = pstmt.executeUpdate();
					if (pstmt != null)pstmt.close();				
					if (result != 0)
					{
						con.commit();
						tabdata = MessageManager.getMessage(locale, "RECORD_INSERTED","CA");
						errorMsg= (String) tabdata.get("message");					response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num="+java.net.URLEncoder.encode(errorMsg,"UTF-8")+"&err_value=1");
					}
				}else{
					insertQry = "UPDATE CA_MENSTRUAL_HIST_DTL SET FACILITY_ID =?,MIN_AGE=?,MAX_AGE=?,CUT_OFF_BACK_DATE=?,CUT_OFF_DATE_DELIVERY=?,CUT_OFF_DELIVERY_LMP=?,CUT_OFF_MISCARRIAGE_LMP=?,ENABLE_MARK_AS_ERROR_YN=?, MODIFIED_BY_ID=?, MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=?"; // 41653

					pstmt = con.prepareStatement(insertQry);
					pstmt.setString(1,operationalFacility);
					pstmt.setString(2,Min_Age);
					pstmt.setString(3,Max_Age);
					pstmt.setString(4,Cut_Off_Backdate_Delivery);
					pstmt.setString(5,Cut_Off_Date_Delivery);
					pstmt.setString(6,Cut_Off_Delivery_Lmp);
					pstmt.setString(7,Cut_Off_Miscarriage_Lmp);
					pstmt.setString(8,Enable_Mark_As_Error_YN);
					pstmt.setString(9,modifiedById);
					pstmt.setString(10,modifiedAtWorkstation);
					pstmt.setString(11,modifiedFacilityId);
					result = pstmt.executeUpdate();
					if (pstmt != null)pstmt.close();				
					if (result != 0)
					{
						con.commit();
						tabdata = MessageManager.getMessage(locale, "RECORD_INSERTED","CA");
						errorMsg= (String) tabdata.get("message");	
						response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num="+java.net.URLEncoder.encode(errorMsg,"UTF-8")+"&err_value=1");
					}
				}
				
			}
			else
			{  				
				errorMsg= "";
				response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num="+errorMsg+"&err_value=1");
			}			
		}
		catch(Exception ee)
		{
				try
				{
					con.rollback();	
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
				
				tabdata = MessageManager.getMessage(locale, "FAILED_OPERATION","CA");
				errorMsg= (String) tabdata.get("message");					response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num="+java.net.URLEncoder.encode(errorMsg,"UTF-8")+"&err_value=1");
				ee.printStackTrace();
		}
		finally
		{
			if(con != null) ConnectionManager.returnConnection(con);
		}

	}
}
