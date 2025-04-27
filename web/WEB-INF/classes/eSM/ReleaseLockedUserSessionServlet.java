/*Created by Thamizh selvi on Oct 26th 2016 against MO-CRF-20113*/
package eSM;
import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import javax.naming.*;
import javax.rmi.*;
import java.util.*;
import webbeans.eCommon.*;
import com.ehis.util.*;

public class ReleaseLockedUserSessionServlet extends javax.servlet.http.HttpServlet implements SingleThreadModel
{
	
	PrintWriter out;
	java.util.Properties p;
	String userId;
	String locale="";
	String s20 = "";
	String err_value="0";
	PreparedStatement pstmtUpd=null;
	PreparedStatement pstmtDel=null;
	String facilityId ;
	String login_user ;
	String client_ip_address ;
	Connection con ;
	HttpSession session;
	int updateCount=0;
	int delCount=0;
	
	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	}
	
	public synchronized void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		session = req.getSession(false);
		this.p = (java.util.Properties) session.getValue( "jdbc" ) ;
		locale = p.getProperty("LOCALE");
		this.facilityId = (String) session.getValue( "facility_id" ) ;
		this.login_user = (String) session.getValue( "login_user" ) ;
		if(facilityId==null) facilityId="";
		client_ip_address = p.getProperty("client_ip_address");
		try
		{
			req.setCharacterEncoding("UTF-8");
		    res.setContentType("text/html;charset=UTF-8");
			this.out = res.getWriter();
			updateUserSessionDetails(req, res);
		}
		catch(Exception e)
		{
			out.println(e.toString());
			e.printStackTrace();
		}

	}
	private void updateUserSessionDetails(HttpServletRequest req, HttpServletResponse res)
	{
	try{
		
		con = ConnectionManager.getConnection(req);
		String userIds	= "";
		String finalData = req.getParameter("finalData");
		StringTokenizer insToken = new StringTokenizer(finalData, ",");
		
		while(insToken.hasMoreTokens()){
			userIds	= userIds + "'"+insToken.nextToken()+"',";
		}
		
		if (!userIds.equals("")){
			 userIds = userIds.substring(0, userIds.length() - 1);
		}
		
		String updSql="UPDATE SM_APPL_USER_AUDIT SET RELEASE_YN = 'Y',MODIFIED_BY_ID=?,MODIFIED_DATE=sysdate,MODIFIED_AT_WS_NO=? WHERE APPL_USER_ID in ("+userIds+")";
		
		pstmtUpd = con.prepareStatement(updSql);
		pstmtUpd.setString(1,login_user);
		pstmtUpd.setString(2,client_ip_address);
		updateCount = pstmtUpd.executeUpdate();


		if (updateCount >= 1)
		{
			String delSql="DELETE FROM SM_APPL_USER_AUDIT WHERE APPL_USER_ID in("+userIds+")";

			pstmtDel = con.prepareStatement(delSql);
			delCount = pstmtDel.executeUpdate();
			
			if (delCount >= 1)
			{
				con.commit();
				err_value="1";
				java.util.Hashtable hashtable1 = MessageManager.getMessage(locale,"RECORD_INSERTED", "SM");
				s20 = (String)hashtable1.get("message");
				hashtable1.clear();
				
			}
		if(pstmtUpd != null) pstmtUpd.close();
		if(pstmtDel != null) pstmtDel.close();
		}else con.rollback();
		
		out.println("<script type='text/javascript'>alert('"+s20+"')</script>");
		out.println("<script type='text/javascript'>parent.onSuccess()</script>");
		//res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode(s20, "UTF-8") + "&err_value=" + err_value);
		
	}
	catch ( Exception e )
	{
		out.println("<h3> Exception raise by Servlet ...So Record Not Modified" +e.toString());
		e.printStackTrace();
	}
	finally
	{
		ConnectionManager.returnConnection(con, req);
		
	}
	}
}