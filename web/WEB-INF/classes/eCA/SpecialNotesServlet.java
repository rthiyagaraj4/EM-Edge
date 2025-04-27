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
import java.util.*;
import javax.naming.*;
import javax.rmi.*;
import webbeans.eCommon.*;
//import eCommon.SingleTabHandler.*;
public class SpecialNotesServlet extends javax.servlet.http.HttpServlet
{
    Properties p=null;
   
    public synchronized void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException
    {
        PreparedStatement pstmt = null;
		 PreparedStatement pstmt_new = null;

        ResultSet rs1 = null;
	    ResultSet rs = null;
        Connection con = null;
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        HttpSession httpsession = request.getSession();
        p = (Properties)httpsession.getValue("jdbc");
        String login_by_id = p.getProperty("login_user");
        String login_at_ws_no = p.getProperty("client_ip_address");
        String login_facility_id = (String)httpsession.getValue("facility_id");
		StringBuffer errorMsg = new StringBuffer();
		int inserted = 0;
		int  flag = 0;
        String querySelect = "select categ_id from ca_note_param_detail";
        String queryInsert = "update ca_note_param_detail set note_type = ?, MODIFIED_BY_ID = ? , MODIFIED_AT_WS_NO = ?, "+
        "MODIFIED_FACILITY_ID  = ? ,modified_date = sysdate where categ_id = ? ";
        try
        {
            con = ConnectionManager.getConnection();
            pstmt = con.prepareStatement(querySelect);
			pstmt_new= con.prepareStatement(queryInsert);
            rs1 = pstmt.executeQuery();
			
            while(rs1.next())
            {	
                //the select box has been named as categ_id and it has the value of note_type
				 flag++;
				String categ_id = (String)rs1.getString("categ_id");
                String note_type = (String)request.getParameter(categ_id);
                pstmt_new.setString(1, note_type);
                pstmt_new.setString(2, login_by_id);
                pstmt_new.setString(3, login_at_ws_no);
                pstmt_new.setString(4, login_facility_id);
                pstmt_new.setString(5, categ_id);
				inserted = inserted + pstmt_new.executeUpdate();
				out.println("<script>alert('"+flag+"')</script>");
				 
            }
			 
			 if(rs1!=null) rs1.close();
			if(pstmt!=null) pstmt.close();	
			if(pstmt_new !=null) pstmt_new.close();
			 if(inserted == flag)
			{	
				errorMsg.append("Select MESSAGE_ID,MESSAGE_TEXT_SYSDEF ");
				errorMsg.append("from sm_message where MESSAGE_REF = ? ");
				pstmt = con.prepareStatement(errorMsg.toString());
				pstmt.setString(1,"RECORD_MODIFIED");
				rs = pstmt.executeQuery();
				rs.next();
				errorMsg = new StringBuffer();
				errorMsg.append("APP -  ");
				errorMsg.append( rs.getString("MESSAGE_ID"));
				errorMsg.append( " " );
				errorMsg.append( rs.getString("MESSAGE_TEXT_SYSDEF"));
				response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" +
				java.net.URLEncoder.encode(errorMsg.toString(),"UTF-8") + "&err_value=1");
				if(rs !=null) rs.close();
                if(pstmt!=null) pstmt.close();
				con.commit();
			}
			else
			{
				con.rollback();
			}
			
				
        }
        catch(Exception e)
        {
            out.println("Error In Updating:"+e);
            e.printStackTrace();
			try
			{
			con.rollback();
			} 
			catch(Exception ee){}
            flag = 0;
        }
        finally
        {
           
			if(con!=null) ConnectionManager.returnConnection(con);
        }
       
    }
}
