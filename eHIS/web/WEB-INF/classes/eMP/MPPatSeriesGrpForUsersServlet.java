/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/****** Last Modified Date Time 9/22/2005 11:21 AM *****/
package eMP;

import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import javax.naming.*;
import javax.rmi.*;
import java.util.*;
import webbeans.eCommon.*;
import eMP.AccessRights.*;

public class MPPatSeriesGrpForUsersServlet extends javax.servlet.http.HttpServlet
{
    


    public void init(ServletConfig config) throws ServletException
    {
        super.init(config);
    }

    public synchronized void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
    {
		doGet(req,res);
        
    }

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
    {
		addModifyPatSerGrpUser(req,res);
    }
	private void addModifyPatSerGrpUser(HttpServletRequest req, HttpServletResponse res){
		Connection con =null;
		PreparedStatement pstmt= null;
		PreparedStatement delPstmt= null;
		java.util.Properties p;
		String client_ip_address ;
		HttpSession session= req.getSession(false);
		p = (java.util.Properties) session.getValue( "jdbc" );
		client_ip_address = p.getProperty("client_ip_address");
		String addedById = p.getProperty( "login_user" ) ;
		int recStart=Integer.parseInt(req.getParameter("recStart"));
		int recCount=Integer.parseInt(req.getParameter("recCount"));
		//String deleteUsers=""; //Commented for checkstyle
		String insSQL="insert into mp_pat_ser_grp_for_user(PAT_SER_GRP_CODE,APPL_USER_ID,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO)values(?,?,?,sysdate,?,?,sysdate,?)";
		
		String delSQL="delete from mp_pat_ser_grp_for_user where PAT_SER_GRP_CODE=? and APPL_USER_ID =?";
		
		String patSerGrpCode=req.getParameter("patSerGrpCode"); 
		int insertCount=0;
		int deleteCount=0;
		int[] insertRec;
		int[] deleteRec;
		PrintWriter out;
		String locale = p.getProperty("LOCALE");
		try{
			out = res.getWriter();
			req.setCharacterEncoding("UTF-8");
			res.setContentType("text/html;charset=UTF-8");
			con = ConnectionManager.getConnection(req);
			pstmt  = con.prepareStatement(insSQL);
			delPstmt  = con.prepareStatement(delSQL);
			for(;recStart<recCount;recStart++){
				if(req.getParameter("user_pat_link"+recStart)==null){
					if(req.getParameter("linkedYN"+recStart).equals("Y")){
						delPstmt.setString(1,patSerGrpCode);
						delPstmt.setString(2,req.getParameter("User"+recStart));
						delPstmt.addBatch();
						deleteCount++;
					}					
				}else{
					if(req.getParameter("linkedYN"+recStart).equals("N")){
						pstmt.setString(1,patSerGrpCode);
						pstmt.setString(2,req.getParameter("User"+recStart));
						pstmt.setString(3,addedById);
						pstmt.setString(4,client_ip_address);
						pstmt.setString(5,addedById);
						pstmt.setString(6,client_ip_address);
						pstmt.addBatch();
						insertCount++;
					}
				}
			}
			insertRec=new int[insertCount];
			deleteRec=new int[deleteCount];
			if(insertCount >0){
				insertRec=pstmt.executeBatch();
			}
			if(deleteCount >0){
				deleteRec=delPstmt.executeBatch();
			}
			con.commit();
			if(insertRec.length > 0 || deleteRec.length>0){
				Hashtable hashtable1 = MessageManager.getMessage(locale, "RECORD_INSERTED","SM");
				String error = (String)hashtable1.get("message");
				res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8" ) + "&err_value=1");
			}
			if(pstmt!=null)pstmt.close(); //Added for checkstyle
			if(delPstmt!=null)delPstmt.close(); //Added for checkstyle
		}catch(Exception ex){
			ex.printStackTrace();
			try{
				Hashtable hashtable1 = MessageManager.getMessage(locale, "ERROR_IN_UPDATING","SM");
				String error = (String)hashtable1.get("message");
				res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8" ) + "&err_value=0");
			}catch(Exception ex1){
				ex.printStackTrace();
			}
		}finally{
			ConnectionManager.returnConnection(con,req);
		}
	}    
}
