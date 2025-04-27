/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eSM ;
import java.io.*;
import java.sql.* ;
import javax.servlet.*;
import javax.servlet.http.*;
import webbeans.eCommon.*;
import java.util.*;
public class ChangePasswordServletLogin extends HttpServlet {
Connection con1 ;
PreparedStatement pstmt ;
ResultSet rs_ora=null;
Properties p;
String locale="";
HttpSession session;
public synchronized void  doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException {
PrintWriter out 			= res.getWriter() ;
session = req.getSession(false);
String current_user			= req.getParameter("current_user");
String current_password		= req.getParameter("new_password1");
String startup_db_driver	= req.getParameter("startup_db_driver");
String startup_connect_string = req.getParameter("startup_connect_string");
String startup_user			= req.getParameter("startup_user");
String startup_password		= req.getParameter("startup_password");

int result=0;
String output				= "<html><link rel='stylesheet' type='text/css' href='../eCommon/html/IeStyle.css'><script src='../eCommon/js/message.js' language='javascript'></script>" ;
		output				= output + "<body onLoad=\"window.document.title='eHIS'\">" ;
String backToLogin			="<hr><center><input type='submit' class='BUTTON' value='Back' onClick='history.go(-1);'></center>" ;
		backToLogin			= backToLogin + "</body></html>" ;
String ora_role_password	="";
req.setCharacterEncoding("UTF-8");
res.setContentType("text/html;charset=UTF-8");
this.p			= (java.util.Properties) session.getValue( "jdbc" ) ;
MessageManager mm=new MessageManager();
if ( current_password == null ) current_password = "" ;
try {
	Class.forName( startup_db_driver ) ;
	con1 = DriverManager.getConnection( startup_connect_string, startup_user, startup_password ) ;
	con1.setAutoCommit(false);
	
	String sql_ora=" Select APP_PASSWORD.DECRYPT(ORA_ROLE_PASSWORD) from sm_ora_role where ora_role_id='MEDADMIN' ";
	pstmt=con1.prepareStatement(sql_ora);
	rs_ora=pstmt.executeQuery();
	if(rs_ora!=null)
	{
	while(rs_ora.next())
		{
		ora_role_password=rs_ora.getString(1);
		}
	}
	else
	{
         java.util.Hashtable mesg=mm.getMessage(locale, "NOT_FND_FOR_MEDADMIN", "SM") ;
                        String msg=(String)mesg.get("message");
						out.println("<script>alert('"+msg+"');</script>");
						mesg.clear();
	//out.println("<script>alert('Record not Found For the Role MEDADMIN');</script>");
	}
	if(ora_role_password !=null && !ora_role_password.equals("")){
		sql_ora="Set Role MEDADMIN identified by "+ora_role_password;
		if(pstmt!=null) pstmt.close();
		pstmt=con1.prepareStatement(sql_ora);
		pstmt.execute();
		if(pstmt!=null) pstmt.close();
	}else{
		sql_ora="Set Role MEDADMIN";
		if(pstmt!=null) pstmt.close();
		pstmt=con1.prepareStatement(sql_ora);
		pstmt.execute();
		if(pstmt!=null) pstmt.close();
	}
	String dbsql = "alter user "+current_user+" identified by "+current_password;
	
	pstmt = con1.prepareStatement( dbsql );
	boolean res1=pstmt.execute();
	if(pstmt!=null) pstmt.close();
	if(res1==false)
	{
	pstmt = con1.prepareCall( "update sm_appl_user set appl_user_password = app_password.encrypt(?) where appl_user_id = ? " ) ;
	pstmt.setString( 1, current_password ) ;
	pstmt.setString( 2, current_user ) ;
	result = pstmt.executeUpdate() ;
	
	if(pstmt!=null) pstmt.close();
	if ( result > 0 ) {
		con1.commit();
		String alertVal="";
		java.util.Hashtable mesg=mm.getMessage(locale, "PASSWORD_CHANGED", "SM") ;
                        alertVal=(String)mesg.get("message");
						mesg.clear();
//		out.println("<script>alert('Password has been Changed');</script>");
		out.println("<script>alert('"+alertVal+"');</script>");
		out.println("<script>parent.window.returnValue='T';parent.window.close();</script>");
		}else
		{
			con1.rollback();
			String alertVal="";
		java.util.Hashtable mesg=mm.getMessage(locale, "PASSWORD_CHANGED", "SM") ;
                        alertVal=(String)mesg.get("message");
						mesg.clear();
		out.println("<script>alert('"+alertVal+"');</script>");
			//out.println("<script>alert('Password is not changed');</script>");
			out.println("<script>parent.window.returnValue='F';parent.window.close();</script>");
		}
		}
		else{
	    	con1.rollback();
			out.println("<script>alert('Password is not changed');</script>");	out.println("<script>parent.window.returnValue='F';parent.window.close();</script>");
		}

			if(rs_ora !=null ) rs_ora.close();
			if(pstmt !=null) pstmt.close();
					
		}
		catch ( Exception e ) {
				try{
				con1.rollback();
				
				String errnum=e.getMessage().substring(0,9);
				
				if(errnum.equals("ORA-28007"))
				{
				out.println("<script>alert('The password cannot be reused');</script>");
			    out.println("<script>parent.window.returnValue='T';parent.window.close();</script>");
				}
				
				
				}catch(Exception ec){}
					out.println(output);
					out.println(e.getMessage() ) ;
					out.println(backToLogin);
				} 
			  finally	{
			  try {
					con1.close();
					ConnectionManager.returnConnection(con1,req);
					
					} 
					catch (Exception ee) {
					}
		     }//finally


	}//method
}//class
