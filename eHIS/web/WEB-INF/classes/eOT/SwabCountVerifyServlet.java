/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eOT;

/*import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import javax.naming.*;
import javax.rmi.*;
import webbeans.eCommon.*;
import eOT.Common.*;*/

import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;
import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.Properties;
import java.sql.Connection;
import java.sql.PreparedStatement;
import webbeans.eCommon.ConnectionManager;
import eOT.Common.OTRepository;
import webbeans.eCommon.*;


public class SwabCountVerifyServlet extends javax.servlet.http.HttpServlet {
	public void init(ServletConfig config) throws ServletException	{
		super.init(config);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res)
	throws javax.servlet.ServletException,IOException{
		Connection connection = null;
		PreparedStatement pstmt = null;
		//int index=1; commented for V3
		//String error_text = "";
		//String status = "";

		PrintWriter out;
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
		HttpSession session=req.getSession(false);
		out=res.getWriter();
		Properties prop = (java.util.Properties) session.getAttribute( "jdbc" ) ;
		String login_at_ws_no = prop.getProperty( "client_ip_address" );
		String locale = prop.getProperty( "LOCALE" );
		String facility_id = (String)session.getAttribute( "facility_id" );
		String oper_num = req.getParameter("oper_num");
		String swab_serial_number = req.getParameter("swab_serial_number");		
		swab_serial_number=swab_serial_number==null?"1":swab_serial_number;
		swab_serial_number=swab_serial_number.equalsIgnoreCase("null")?"1":swab_serial_number;
		String login_user = req.getParameter("login_user");			
				
		//String mode =req.getParameter("mode");  commented for V3 on 18/06/2005 By Subramanian
		String disc_in_first_count = req.getParameter("disc_in_first_count");
		String xray_performed = req.getParameter("xray_performed");
		String missing_item_found = req.getParameter("missing_item_found");
		String new_remarks = req.getParameter("new_remarks");
		new_remarks=new_remarks==null?"":new_remarks;
		new_remarks=new_remarks.equalsIgnoreCase("null")?"":new_remarks;
		
		//String sql ="";
		String data_count = req.getParameter("data_count");
		String basic_set = req.getParameter("basic_set");
		String supplementary_set = req.getParameter("supplementary_set");
		basic_set=basic_set==null?"":basic_set;
		basic_set=basic_set.equalsIgnoreCase("null")?"":basic_set;
		supplementary_set=supplementary_set==null?"":supplementary_set;
		supplementary_set=supplementary_set.equalsIgnoreCase("null")?"":supplementary_set;
		boolean flag = false;
	try{
		connection = ConnectionManager.getConnection(req);
		if(data_count.equals("0")){
			pstmt = connection.prepareStatement(OTRepository.getOTKeyValue("SQL_OT_SWAB_COUNT_VERIFY_INSERT")) ;
			pstmt.setString(1,facility_id);
			pstmt.setString(2,oper_num);
			pstmt.setString(3,swab_serial_number);
			pstmt.setString(4,basic_set);
			pstmt.setString(5,supplementary_set);
			pstmt.setString(6,disc_in_first_count);
			pstmt.setString(7,xray_performed);
			pstmt.setString(8,missing_item_found);
			pstmt.setString(9,new_remarks);
			// audit fields
			pstmt.setString(10,login_user);
			pstmt.setString(11,login_at_ws_no);
			pstmt.setString(12,facility_id);
			pstmt.setString(13,login_user);
			pstmt.setString(14,login_at_ws_no);
			pstmt.setString(15,facility_id);
			//int count = pstmt.executeUpdate();
			pstmt.executeUpdate();
			connection.commit();
			flag=true;
		}else{
			pstmt = connection.prepareStatement(OTRepository.getOTKeyValue("SQL_OT_SWAB_COUNT_VERIFY_UPDATE")) ;
			pstmt.setString(1,basic_set);
			pstmt.setString(2,supplementary_set);
			pstmt.setString(3,disc_in_first_count);
			pstmt.setString(4,xray_performed);
			pstmt.setString(5,missing_item_found);
			pstmt.setString(6,new_remarks);
			pstmt.setString(7,login_user);
			pstmt.setString(8,login_at_ws_no);
			pstmt.setString(9,facility_id);
			pstmt.setString(10,facility_id);
			pstmt.setString(11,oper_num);
			pstmt.setString(12,swab_serial_number);			
			// audit fields
			//int count = pstmt.executeUpdate();
			pstmt.executeUpdate();
			connection.commit();
			flag=true;
		}
		MessageManager mm=new MessageManager();
		String msg = "";
		if(flag==false){
			final java.util.Hashtable mesg = mm.getMessage(locale, "APP-OT0082", "OT") ;
			msg = ((String) mesg.get("message"));
			//out.println("<html><script>alert('Operation Failed ....');</script></html>");
			out.println("<html><script>alert("+msg+");</script></html>");
		}else{		
			final java.util.Hashtable mesg = mm.getMessage(locale, "RECORD_INSERTED", "SM") ;
			msg = ((String) mesg.get("message"));

			String htmlStr = "<html><script>";
			//htmlStr = htmlStr+"alert('APP-SM0002 Operation Completed Successfully ....');";
			htmlStr = htmlStr+"alert('"+msg+"');";
			htmlStr = htmlStr+"var tabFormObj = parent.parent.parent.f_tab_frames.document.SwabCountTabForm;";	
			htmlStr = htmlStr+"var params = tabFormObj.params.value;";
			htmlStr = 	htmlStr+"self.location.href=\"../eOT/jsp/SwabCountVerify.jsp?\"+params;";
			htmlStr = htmlStr+"</script></html>"; 
			out.println(htmlStr);				
		}

		/* Commented by bshankar on 19/02/2006
		if(flag==false){
			out.println("<html><script>alert('Operation Failed ....');</script></html>");
		}else{		
			String htmlStr = "";
			htmlStr = "var tabFormObj = parent.parent.parent.f_tab_frames.document.SwabCountTabForm;";	
			htmlStr = htmlStr+"var params = tabFormObj.params.value;";
			htmlStr = htmlStr+"parent.parent.parent.f_tab_frames.location.href=\"../../eOT/jsp/SwabCountTabs.jsp?\"+params+\"&swab_tab_name=VERIFY\";";

//			String str = "<html><script>alert('APP-SM0002 Operation Completed Successfully ....'); "+htmlStr+"</script></html>"; 
//			out.println(str);				
		}
		*/
	}catch(Exception e){
		try{
			System.err.println("Rollback performed, Err Msg in SwabCountVerifyServlet "+e.getMessage());
			connection.rollback();
		}catch(Exception e_1){
			System.err.println("96: Caught Exception during rollback"+e_1);
		}
	}finally {
        try{
             if(pstmt!=null) pstmt.close() ;
             ConnectionManager.returnConnection( connection,req );
         }catch(Exception es){es.printStackTrace();}
    }
	}
}



