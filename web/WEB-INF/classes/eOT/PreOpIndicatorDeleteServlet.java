/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eOT;

import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import webbeans.eCommon.ConnectionManager;
import eCommon.Common.CommonBean;
import org.xml.sax.InputSource;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;

public class PreOpIndicatorDeleteServlet extends javax.servlet.http.HttpServlet {
	public void init(ServletConfig config) throws ServletException	{
		super.init(config);
	}
	

	public void doPost(HttpServletRequest req, HttpServletResponse res)
	throws javax.servlet.ServletException,IOException{
		HashMap CommonData=new HashMap();
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
		req= new XSSRequestWrapper(req);
		res.addHeader("X-XSS-Protection", "1; mode=block");
		res.addHeader("X-Content-Type-Options", "nosniff");
		HttpSession session=req.getSession(false);
		PrintWriter out=res.getWriter();
					
		String client_ip_address="";
		String facility_id = "";	
		String login_user=""; 
		/* String added_date="";
		String modified_date=""; */ //Common-ICN-0055
		String locale="";
		
		java.util.Properties prop = null;
		facility_id = (String)session.getValue( "facility_id" ) ;
		prop = (java.util.Properties) session.getValue( "jdbc" ) ;
		client_ip_address = prop.getProperty( "client_ip_address" );
		login_user = prop.getProperty( "login_user" );
		locale = prop.getProperty( "LOCALE" );
	
		CommonData.put("login_user", login_user); 
		CommonData.put("login_at_ws_no",client_ip_address);
		CommonData.put("facility_id",facility_id);
		CommonData.put("locale",locale);
		
		Connection con = null;
		PreparedStatement pstmt = null;
		String msg="";
		String sqlDelete="DELETE FROM OT_DISCR_MSR WHERE DISCR_MSR_ID=?";
		MessageManager mm=new MessageManager();
		try{
			   String DISCR_MSR_ID = req.getParameter("DISCR_MSR_ID");
		       con = ConnectionManager.getConnection(req);
				pstmt=con.prepareStatement(sqlDelete);
			    pstmt.setString(1,DISCR_MSR_ID);
				pstmt.executeUpdate();
				con.commit();
				final java.util.Hashtable mesg = mm.getMessage(locale, "RECORD_INSERTED", "SM") ;
				msg = ((String) mesg.get("message"));
		}catch(Exception e){
			e.printStackTrace();
		    //System.err.println("Err Msg in FunctionStatusServlet"+e.getMessage());
			//out.println(""+e);
			try{
				con.rollback();
				final java.util.Hashtable mesg = mm.getMessage(locale, "APP-OT0082", "OT") ;
				msg = ((String) mesg.get("message"));
			}catch(Exception e1){e1.printStackTrace();}
		}finally{
		try{
				if(pstmt!=null) pstmt.close();
				if(con!=null) ConnectionManager.returnConnection(con,req);
				out.println(msg);
		}catch(Exception e){e.printStackTrace();}
	  }//end of finally 
    }//end of doPost method
 }//end of class



