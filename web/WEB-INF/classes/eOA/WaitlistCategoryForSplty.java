/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eOA;
import webbeans.eCommon.*;
import eCommon.SingleTabHandler.SingleTabHandlerManagerHome;
import eCommon.SingleTabHandler.SingleTabHandlerManagerRemote;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringTokenizer;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Properties;
import javax.naming.InitialContext;
import javax.rmi.PortableRemoteObject;
import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.*;

public class WaitlistCategoryForSplty extends HttpServlet {

	PrintWriter out;
    Properties p;
	Connection con;
	Hashtable message=null;
   	String facilityId;
    String client_ip_address;
	String watinglistcatcode="";
    int res=0;
	String speciality="";
    StringBuffer  sql=new StringBuffer();
	PreparedStatement pstmt=null;
	//java.text.SimpleDateFormat dateFormat;
	StringTokenizer strToken1=null;
   

    public void init(ServletConfig servletconfig) throws ServletException {
     super.init(servletconfig);
    }

    public synchronized void doPost(HttpServletRequest httpservletrequest, HttpServletResponse httpservletresponse) throws ServletException, IOException {
    
	try {
			 
			 
			HttpSession session;
			//SimpleDateFormat dateFormat;
			session = httpservletrequest.getSession(false);
			facilityId = (String)session.getValue("facility_id");
			p = (Properties)session.getValue("jdbc");
			con					                   = ConnectionManager.getConnection(p);
			client_ip_address = p.getProperty("client_ip_address");

			httpservletrequest.setCharacterEncoding("UTF-8");
				httpservletresponse.setContentType("text/html;charset=UTF-8");
			out = httpservletresponse.getWriter();
	        speciality=httpservletrequest.getParameter("splty")==null?"":httpservletrequest.getParameter("splty");
			watinglistcatcode=httpservletrequest.getParameter("waitlist_category_code")==null?"":httpservletrequest.getParameter("waitlist_category_code");
		
			WaitlistCategoryForSplty(httpservletresponse);
		}
        catch(Exception exception) {
        out.println(exception.toString());
		exception.printStackTrace();
        }finally
		{
		ConnectionManager.returnConnection(con,p);
		}
    
	
	}

    
 private void WaitlistCategoryForSplty(HttpServletResponse httpservletresponse) {
     try {
		String s = p.getProperty("login_user");
		String s6 = client_ip_address;
		String locale = p.getProperty("LOCALE");
		
		strToken1= new StringTokenizer(speciality,"~");
	   if(strToken1!=null)
	   {
	   sql.setLength(0);
	   sql.append("delete from OA_WL_CATEGORY_FOR_SPLTY where WAITLIST_CATEGORY_CODE='"+watinglistcatcode+"'");
	   pstmt = con.prepareStatement(sql.toString());
	   pstmt.executeUpdate();
	  
	   if(pstmt!=null)pstmt.close(); 
	   sql.setLength(0);
	   sql.append("insert into OA_WL_CATEGORY_FOR_SPLTY(SPECIALTY_CODE,WAITLIST_CATEGORY_CODE,ADDED_BY_ID,ADDED_DATE, ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID) values(?,?,?,sysdate,?,?,?,sysdate,?,?)");
	   pstmt = con.prepareStatement(sql.toString());
	   while(strToken1.hasMoreElements())
	   {
	   String spec=(String)strToken1.nextElement();
	   if(!spec.equals(""))
	   {
     	pstmt.setString(1,spec);
		pstmt.setString(2,watinglistcatcode);
		pstmt.setString(3,s);
		pstmt.setString(4,s6);
		pstmt.setString(5,facilityId);
		pstmt.setString(6,s);
		pstmt.setString(7,s6);
		pstmt.setString(8,facilityId);
	   res=pstmt.executeUpdate();

	}  	
	}
	}
    
	String error_value="";
	if(res>0)
	{
	con.commit();
	message= MessageManager.getMessage( locale,"RECORD_INSERTED","SM" ) ;
	String error=(String) message.get("message");
	error_value = "1" ;
    httpservletresponse.sendRedirect("../eCommon/jsp/error.jsp?err_num="+java.net.URLEncoder.encode( error,"UTF-8" )+"&err_value="+error_value );
	}else
	{
	error_value = "0" ;
    httpservletresponse.sendRedirect("../eCommon/jsp/error.jsp?err_num=&err_value="+error_value );
	}
	
	if(pstmt!=null)pstmt.close();
    if(pstmt!=null)pstmt.close();
}catch(Exception e)
{

e.printStackTrace();
}
}}
