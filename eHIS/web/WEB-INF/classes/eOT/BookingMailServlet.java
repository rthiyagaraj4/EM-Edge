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
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.Properties;
import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.Types;
import webbeans.eCommon.ConnectionManager;
import webbeans.eCommon.*;
/*import com.ehis.util.BundleMessage;
import javax.servlet.jsp.*;*/


public class BookingMailServlet extends javax.servlet.http.HttpServlet {
	public void init(ServletConfig config) throws ServletException	{
		super.init(config);	    
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res)
	throws javax.servlet.ServletException,IOException{
		Connection connection = null;
		CallableStatement cstmt = null;
		int index=1;
		PrintWriter out;
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
		HttpSession session=req.getSession(false);
		//PageContext pageContext = JspFactory.getDefaultFactory().getPageContext(this, req, res, null, false, -1, true);
		//JspWriter out = pageContext.getOut();
		out=res.getWriter();
		Properties prop = (java.util.Properties) session.getAttribute( "jdbc" ) ;
		//String login_at_ws_no = prop.getProperty( "client_ip_address" ); //Common-ICN-0055
		String locale = prop.getProperty("LOCALE") ;
		String facility_id = (String)session.getAttribute( "facility_id" );
		//String login_user = req.getParameter("login_user"); //Common-ICN-0055
		String booking_num = req.getParameter("booking_num");
		String error_text = "";
		String status = "";
	
	try{
			connection = ConnectionManager.getConnection(req);
			cstmt=connection.prepareCall("{call OT_MAIL_FORMAT.INVOKE_MAIL_PROC('OTRBAPTS',?,?,?,?)}");
			index=1;		
			cstmt.setString( index++, facility_id);	//1
			cstmt.setString( index++, booking_num);	//2

			cstmt.registerOutParameter( index++, Types.VARCHAR );  //7 status
			cstmt.registerOutParameter( index++, Types.VARCHAR );  //8 error_text
			cstmt.execute() ;

			status				= cstmt.getString(3);
			error_text			= cstmt.getString(4);
			status=status==null?"":status;
			status=status.equalsIgnoreCase("null")?"":status;
			String msg="";
			String htmlStr = "<html><script>";
            MessageManager mm=new MessageManager();
			if(status.equals("E")){
				final java.util.Hashtable mesg = mm.getMessage(locale, "APP-OT0082", "OT") ;
				msg = ((String) mesg.get("message"));
				out.println("<html><script>alert('"+msg+"');</script></html>");
				htmlStr = htmlStr+"window.returnValue="+error_text+";";
				System.err.println("Error ext while sending mail : "+error_text);
			}else{		
				final java.util.Hashtable mesg = mm.getMessage(locale, "RECORD_INSERTED", "SM") ;
				msg = ((String) mesg.get("message"));
				htmlStr = htmlStr+"alert('"+msg+"');";
//				htmlStr = htmlStr+"var tabFormObj = parent.frames(0).forms(0).search.click();";	
//				htmlStr = 				htmlStr+"parent.parent.parent.frames(1).location.href=\"../eOT/jsp/SwabCountTabs.jsp?\"+params;";
				htmlStr = htmlStr+"window.returnValue='';";
			}	htmlStr = htmlStr+"window.close();";
				htmlStr = htmlStr+"</script></html>"; 
				out.println(htmlStr);				
		}catch(Exception e){
			System.err.println("caught Exception in BookingMailServlet, error_text===:"+error_text);
		}finally {
            try{
                cstmt.close() ;
                ConnectionManager.returnConnection( connection,req );
             }catch(Exception es){es.printStackTrace();}
        }
	}
}



