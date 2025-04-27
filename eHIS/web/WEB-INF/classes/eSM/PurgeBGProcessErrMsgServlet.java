/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eSM;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Hashtable;
import java.util.Properties;
import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.SingleThreadModel;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import webbeans.eCommon.ConnectionManager;
import webbeans.eCommon.MessageManager;
import com.ehis.util.*;

public class PurgeBGProcessErrMsgServlet extends javax.servlet.http.HttpServlet
{

	PrintWriter out;
	Properties p;
	
	String facilityId ;
	String client_ip_address ;
	HttpSession session;
	Statement stmt=null;
	Connection con;
	boolean status=false;
	String error;
	String from;
    String to;
	String pid;
    String locale; 
	
	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	}
	public synchronized void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
		session = req.getSession(false);
		facilityId = (String)session.getValue("facility_id");
        if(facilityId == null)
            facilityId = "";
		this.p = (Properties) session.getValue( "jdbc" ) ;
		locale = p.getProperty("LOCALE");	
        try
		{
			this.out = res.getWriter();
			deleteErrMsg(req, res);
			}
		catch(Exception e)
		{
			out.println(e.toString());
		}
	}
 private void deleteErrMsg(HttpServletRequest req, HttpServletResponse res)
    {
        try
        {
            con = ConnectionManager.getConnection(req);
			stmt = con.createStatement();
            con.setAutoCommit(false);
			pid = req.getParameter("process_id") != null ? req.getParameter("process_id") : "";
			from = req.getParameter("from_date") != null ? req.getParameter("from_date") : "";
            from = DateUtils.convertDate(from,"DMY",locale,"en");
			to = req.getParameter("to_date") != null ? req.getParameter("to_date") : "";
            to = DateUtils.convertDate(to,"DMY",locale,"en");

			String s1 = "delete from sm_proc_msg where operating_facility_id ='"+ facilityId+"' and proc_id='"+pid+"' and trunc(msg_date_time) between to_date('"+from+"', 'dd/mm/yyyy') AND to_date('"+to+"', 'dd/mm/yyyy')";
			 int j=stmt.executeUpdate(s1) ;
			 if(j > 0)
                            status = true;
                        else
                            status = false;
			
                    if(stmt != null)
                    stmt.close();
					String err_value="0";
			if(status)
            {
                err_value = "1";
                con.commit();
				MessageManager mm = new MessageManager();
		        final java.util.Hashtable mesg = mm.getMessage(locale, "RECORD_DELETED","SM");
		        error=(String)mesg.get("message");
                res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + URLEncoder.encode(error, "UTF-8") + "&err_value=" + err_value);
				mesg.clear();
            } else
            {
                err_value = "1";
                con.rollback();
				MessageManager mm = new MessageManager();
		        final java.util.Hashtable mesg = mm.getMessage(locale, "NO_CHANGE_TO_SAVE","Common");
		        error=(String)mesg.get("message");
                res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + URLEncoder.encode(error, "UTF-8") + "&err_value=" + err_value);
				mesg.clear();
            }
		}
		catch(Exception exception)
        {
            out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : " + exception.toString());
            out.println(exception.toString());
        }
        finally
        {
            if(con != null)
                ConnectionManager.returnConnection(con, req);
        }
    }
} 
