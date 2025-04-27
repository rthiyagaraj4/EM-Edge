  
package eSM;

import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import javax.naming.*;
import javax.rmi.*;
import webbeans.eCommon.*;
import eDS.Common.*;

public class UserLogoutServlet extends javax.servlet.http.HttpServlet
{
	PrintWriter out;
	java.util.Properties p;
	String userId						= "";
	Connection con=null;

	HttpSession session;


	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	}

	public synchronized void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		session = req.getSession(false);
		this.p = (java.util.Properties) session.getValue( "jdbc" ) ;
		userId = p.getProperty( "login_user" );
		try
		{
			res.setContentType("application/json");
			String mode = req.getParameter("mode");
			if ( mode.equals("logout") ) autoLogout(req,res);

		}
		catch(Exception e)
		{
			out.println(e.toString());
			e.printStackTrace();
		}
	}


	private synchronized void  autoLogout(HttpServletRequest req,HttpServletResponse res) {
		JSONObject json						= new JSONObject();
		PreparedStatement stmtLoggedOut=null;
		boolean inserted=false;
		try
		{
			con = ConnectionManager.getConnection();
			String upd_sql="delete from SM_APPL_USER_AUDIT WHERE APPL_USER_ID = ? and LOGIN_TYPE = '3'";
			stmtLoggedOut = con.prepareStatement(upd_sql);	
			stmtLoggedOut.setString ( 1, userId) ;
			int resCnt = stmtLoggedOut.executeUpdate();					
			if(stmtLoggedOut!=null)
			stmtLoggedOut.close();
			con.commit();
			
			if((resCnt>=1)) {
				json.put("success","true");	
				json.put("error","success");	
			}else {
				json.put("success","fail");	
				json.put("error","fail");	
			}
			res.getWriter().write(json.toString());
		}
		catch ( Exception e )
		{
			json.put("error"," Exception raise by Servlet ... Error Received : "+e.toString());
			try{
				res.setContentType("application/json");
				e.printStackTrace();
				res.getWriter().write(json.toString());

			}catch( Exception e1 ) {

			}
		}finally {
			ConnectionManager.returnConnection(con,req);
		}
	}


} 