/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*--------------------------------------------------------------------------------------------------------------
Date			Edit History		Name        	Rev.Date 		Rev.by 					Description
--------------------------------------------------------------------------------------------------------------
23/02/2023       41650               Twinkle Shah    	                                        MMS-JU-CRF-0015.1
-------------------------------------------------------------------------------------------------------------- 
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

public class ImmunizationParameter extends javax.servlet.http.HttpServlet	
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
		//int arrayLength=0;
		String vacc_categ_id = "";
		String vacc_link_days = "";
		String auto_sch_immun_yn=""; // 41650
		String disp_vacc_sort_yn=""; // 41653
		String errorMsg = "";
		String user_id = "";
		String client_ip_addr = "";
		String facility_id = "";
		String im_param = "";
		String locale = "";
		int result = 0;
		Hashtable tabdata = new Hashtable();
		Properties p;

		try
		{

			con = ConnectionManager.getConnection();
			out = response.getWriter();		
			vacc_categ_id = req.getParameter("vacc_categ_id")==null?"":req.getParameter("vacc_categ_id");
			vacc_link_days = req.getParameter("vacc_link_days")==null?"":req.getParameter("vacc_link_days");
			auto_sch_immun_yn = req.getParameter("auto_sch_immun_yn")==null?"":req.getParameter("auto_sch_immun_yn"); // 41650
			disp_vacc_sort_yn = req.getParameter("disp_vacc_sort_yn")==null?"":req.getParameter("disp_vacc_sort_yn"); // 41653
			p = (java.util.Properties) session.getValue( "jdbc" ) ;
			locale = (String) p.getProperty("LOCALE");
			facility_id = (String) session.getValue( "facility_id" ) ;
			client_ip_addr=	p.getProperty("client_ip_address");
			user_id =  (p.getProperty("login_user")==null)?"":p.getProperty("login_user")  ;

	
			if(!vacc_categ_id.equals("") && !vacc_link_days.equals(""))
			{			
				String insertQry = "SELECT 1 FROM CA_IM_PARAM";
				pstmt = con.prepareStatement(insertQry);
				rs = pstmt.executeQuery();
				if (rs != null  && rs.next())
				{
					im_param = rs.getString(1)==null?"":rs.getString(1);
				}
				if (rs != null)rs.close();
				if (pstmt != null)pstmt.close();
				if (im_param.equals(""))
				{
//					insertQry = "INSERT INTO CA_IM_PARAM (VACC_CATEG_ID,VACC_LINK_DAYS,ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID,) VALUES (?,?,?,SYSDATE,?,?,?,SYSDATE,?,?,)";   //41650
				  // insertQry = "INSERT INTO CA_IM_PARAM (VACC_CATEG_ID,VACC_LINK_DAYS,ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID,AUTO_SCH_IMMUN_YN) VALUES (?,?,?,SYSDATE,?,?,?,SYSDATE,?,?,?)"; //41653
				   insertQry = "INSERT INTO CA_IM_PARAM (VACC_CATEG_ID,VACC_LINK_DAYS,ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID,AUTO_SCH_IMMUN_YN,DISP_VACC_SORT_YN) VALUES (?,?,?,SYSDATE,?,?,?,SYSDATE,?,?,?,?)"; // 41653
	
					pstmt = con.prepareStatement(insertQry);
					pstmt.setString(1,vacc_categ_id);
					pstmt.setString(2,vacc_link_days);
					pstmt.setString(3,user_id);
					pstmt.setString(4,client_ip_addr);
					pstmt.setString(5,facility_id);
					pstmt.setString(6,user_id);
					pstmt.setString(7,client_ip_addr);
					pstmt.setString(8,facility_id);
					pstmt.setString(9,auto_sch_immun_yn); // 41650
					pstmt.setString(10,disp_vacc_sort_yn); // 41653
					result = pstmt.executeUpdate();
					if (pstmt != null)pstmt.close();				
					if (result != 0)
					{
						con.commit();
						tabdata = MessageManager.getMessage(locale, "RECORD_INSERTED","CA");
						errorMsg= (String) tabdata.get("message");					response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num="+java.net.URLEncoder.encode(errorMsg,"UTF-8")+"&err_value=1");
					}
				}else{
					//insertQry = "UPDATE CA_IM_PARAM SET VACC_CATEG_ID =?,VACC_LINK_DAYS=?, MODIFIED_BY_ID=?, MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=?"; // 41650
					//insertQry = "UPDATE CA_IM_PARAM SET VACC_CATEG_ID =?,VACC_LINK_DAYS=?, MODIFIED_BY_ID=?, MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=?,AUTO_SCH_IMMUN_YN=?"; // 41653
					insertQry = "UPDATE CA_IM_PARAM SET VACC_CATEG_ID =?,VACC_LINK_DAYS=?, MODIFIED_BY_ID=?, MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=?,AUTO_SCH_IMMUN_YN=?,DISP_VACC_SORT_YN=?"; // 41653

					pstmt = con.prepareStatement(insertQry);
					pstmt.setString(1,vacc_categ_id);
					pstmt.setString(2,vacc_link_days);
					pstmt.setString(3,user_id);
					pstmt.setString(4,client_ip_addr);
					pstmt.setString(5,facility_id);	
					pstmt.setString(6,auto_sch_immun_yn);	// 41650
					pstmt.setString(7,disp_vacc_sort_yn);	// 41653
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
