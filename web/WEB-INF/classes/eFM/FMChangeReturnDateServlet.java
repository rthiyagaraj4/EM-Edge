/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eFM;
import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import javax.naming.*;
import javax.rmi.*;
import webbeans.eCommon.*;
import com.ehis.util.*;

public class FMChangeReturnDateServlet extends javax.servlet.http.HttpServlet implements SingleThreadModel
{
	PrintWriter out;
	Properties p;

	String facilityId			= "";
	String client_ip_address	= "" ;
	String file_no				= "", return_date_time = "", remarks = "",volume_no = "";
	String locale			= "" ;
	String return_date_time_defaulted=""; //Added for this CRF HSA-CRF-0306.1
	String isCurrentFsLocation=""; //Added for this CRF HSA-CRF-0306.1
	String returndate_manual_yn="N"; //Added for this CRF HSA-CRF-0306.1
	boolean isSiteSpecific=false; //Added for this CRF HSA-CRF-0306.1

	HttpSession session;

	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	}
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
		session				= req.getSession(false);
		this.p				= (Properties) session.getValue( "jdbc" ) ;
		locale = p.getProperty("LOCALE");
		this.facilityId		= (String) session.getValue( "facility_id" ) ;
		client_ip_address	= p.getProperty("client_ip_address");

		Connection con			=	null;
		PreparedStatement psmt	=	null;	

		String error = "", exp_error = "";
		String error_value = "0", user_id = "";

		boolean	inserted =	false;
		int	insert_count =	0;
		int isSiteSpec=0;

		try
		{
			con	= ConnectionManager.getConnection(req);
			res.setContentType("text/html");
			this.out = res.getWriter();

			file_no				=	req.getParameter("file_no");
			volume_no			=	req.getParameter("volume_no");
			remarks				=	req.getParameter("remarks");
			return_date_time	=	req.getParameter("return_date_time");
			user_id				=	req.getParameter("user_id");
			//Added for this CRF HSA-CRF-0306.1
			isCurrentFsLocation= req.getParameter("isCurrentFsLocation");			
			isSiteSpecific = Boolean.parseBoolean(isCurrentFsLocation);			
			return_date_time_defaulted = req.getParameter("return_date_time_defaulted"); 
			
			if(return_date_time_defaulted != null)
			{
				if (!locale.equals("en"))
				{
					return_date_time_defaulted=DateUtils.convertDate(return_date_time_defaulted,"DMYHM",locale,"en");
				}
			}
			
			//End HSA-CRF-0306.1

			if(file_no == null || file_no.equals("null")) file_no = "";
			if(volume_no == null || volume_no.equals("null")) volume_no = "";
			if(remarks == null || remarks.equals("null")) remarks = "";
			if(user_id == null || user_id.equals("null"))user_id = "";
			if(return_date_time != null)
			{
				if (!locale.equals("en"))
				{
					return_date_time=DateUtils.convertDate(return_date_time,"DMYHM",locale,"en");
				}
			}
			
			//Added for this CRF HSA-CRF-0306.1
			if(isSiteSpecific && !return_date_time_defaulted.equals(return_date_time)) returndate_manual_yn="Y";
			
			//End HSA-CRF-0306.1
			
			String addedById			= p.getProperty( "login_user" ) ;		
			String modifiedById			= addedById ;		
			String modifiedFacilityId	= facilityId ;
			String addedAtWorkstation	= client_ip_address;	
			//Added for this CRF HSA-CRF-0306.1
			
			String update_fm_curr_locn	= "Update fm_curr_locn set return_date_time = to_date(?, 'dd/mm/yyyy hh24:mi'), remarks = ?, MODIFIED_BY_ID = ?, MODIFIED_DATE  = sysdate, MODIFIED_AT_WS_NO = ?, MODIFIED_FACILITY_ID =?, return_date_manual_yn=? where file_no = ? and volume_no = ? and facility_id = ? ";
			
			psmt	=	con.prepareStatement(update_fm_curr_locn);
			psmt.setString(1, return_date_time);
			psmt.setString(2, remarks);
			psmt.setString(3, modifiedById);
			psmt.setString(4, addedAtWorkstation);
			psmt.setString(5, modifiedFacilityId);				
            psmt.setString(6, returndate_manual_yn);   //Added for this CRF HSA-CRF-0306.1				
			psmt.setString(7, file_no);
			psmt.setString(8, volume_no);
			psmt.setString(9, facilityId);

			insert_count	= psmt.executeUpdate();
			
			if(insert_count > 0)
			{
				inserted =	true;
				con.commit();
				//error	=	"APP-SM0002 Operation Completed Successfully ....";
				java.util.Hashtable message = MessageManager.getMessage(locale,"RECORD_MODIFIED","SM");
 				error = ((String) message.get("message"));
			}
			else
			{
				inserted	=	false;
				con.rollback();
				error		=	exp_error;
			}
			if ( inserted )
			{
				 error_value = "1" ;
				res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8" ) + "&err_value=" + error_value );
			}
			else
			{
				 res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" +java.net.URLEncoder.encode( error,"UTF-8" ) );
			}
			if(psmt != null) psmt.close();
		}
		catch(Exception e)
		{			
			out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
			out.println(e.toString());
		}
		finally
		{							
			ConnectionManager.returnConnection(con,req);			
		}
	}//end of doPost
}//end of main function

