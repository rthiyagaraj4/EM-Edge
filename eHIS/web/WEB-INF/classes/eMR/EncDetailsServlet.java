/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
   File:	EncDetailsServlet.java
   Date      Author			Changes
   June 09	Sudhakar	Created 
*/
package eMR;
import java.sql.*;
import java.io.*;
import java.util.Properties;
import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.*;
import java.net.URLEncoder;
import javax.servlet.*;
import javax.servlet.http.*;
import webbeans.eCommon.*;
import javax.naming.*;
import javax.rmi.*;


public class EncDetailsServlet extends javax.servlet.http.HttpServlet implements SingleThreadModel{

	public void init(ServletConfig config) throws ServletException{
		super.init(config);
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException,IOException{
		try{
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/html;charset=UTF-8");
			doPost(request,response);
		}catch(Exception e){	
			e.printStackTrace();
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException,IOException{
		PrintWriter out=response.getWriter();;
		Connection con =null;
		PreparedStatement pstmt = null;
		HttpSession session = request.getSession(false);
		String facility_id=checkForNull(request.getParameter("facility_id"));
		//String encounterID=checkForNull(request.getParameter("encounterID")); //Commented for checkstyle
		String injury_date=checkForNull(request.getParameter("injury_date"));
		String trmt_strt_date=checkForNull(request.getParameter("trmt_strt_date"));
		String trmt_end_date=checkForNull(request.getParameter("trmt_end_date"));
		String checkedEncIds=checkForNull(request.getParameter("checkedEncIds"));
		String checkedEncIdsUpdate	=  checkedEncIds.replaceAll(",","','");
		java.util.Properties p=(java.util.Properties) session.getValue( "jdbc" ) ;
		String client_ip_address = p.getProperty("client_ip_address");
		String modifiedById = p.getProperty("login_user");
		String locale=p.getProperty("LOCALE");
		int count=0;
		boolean flag=false;
		try{
			con = ConnectionManager.getConnection(request);
			con.setAutoCommit(false);
			/* Added by Dharma on July 27th 2015 against MMS-QH-CRF-0219 [IN:055276] Start*/
			//pstmt = con.prepareStatement("update pr_encounter set INJURY_DATE=to_date(?,'dd/mm/yyyy'),TRMT_START_DATE=to_date(?,'dd/mm/yyyy'),TRMT_END_DATE=to_date(?,'dd/mm/yyyy'),MODIFIED_BY_ID =?,MODIFIED_DATE=sysdate,MODIFIED_AT_WS_NO=? where facility_id=? and encounter_id=?") ;
			pstmt = con.prepareStatement("update pr_encounter set INJURY_DATE=to_date(?,'dd/mm/yyyy'),TRMT_START_DATE=to_date(?,'dd/mm/yyyy'),TRMT_END_DATE=to_date(?,'dd/mm/yyyy'),MODIFIED_BY_ID =?,MODIFIED_DATE=sysdate,MODIFIED_AT_WS_NO=? where facility_id=? and encounter_id in('"+checkedEncIdsUpdate+"')") ;
			/* Added by Dharma on July 27th 2015 against MMS-QH-CRF-0219 [IN:055276] End*/
			pstmt.setString (1,injury_date);
			pstmt.setString (2,trmt_strt_date);
			pstmt.setString (3,trmt_end_date);
			pstmt.setString (4,modifiedById);
			pstmt.setString (5,client_ip_address);
			pstmt.setString (6,facility_id);
			//pstmt.setString (7,encounterID);//Commented by Dharma on July 27th 2015 against MMS-QH-CRF-0219 [IN:055276] 
			count	= pstmt.executeUpdate();
			if(count>0){
				con.commit();
			}
			flag=true;
			 if(pstmt!=null)	pstmt.close();  //Added for checkstyle
		}catch(Exception ex){
			ex.printStackTrace();
			try{
				con.rollback();
			}catch(Exception e){
				e.printStackTrace();
			}
		}finally{
			ConnectionManager.returnConnection(con,request);
		}
		if(flag){
			java.util.Hashtable message=MessageManager.getMessage(locale,"RECORD_MODIFIED","SM");
			String msg=(String) message.get("message");
			out.println("<script>alert(\""+msg+"\");window.close();</script>") ;
		}
	}
	private String checkForNull(String inputString)
	{
		return (inputString==null) ? "" : inputString;
	}
}
