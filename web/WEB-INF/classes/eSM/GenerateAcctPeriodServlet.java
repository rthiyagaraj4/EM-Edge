/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
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
import eCommon.SingleTabHandler.*;
import com.ehis.util.*;

public class GenerateAcctPeriodServlet extends javax.servlet.http.HttpServlet
{

	PrintWriter out;
	java.util.Properties p;
	String error_msg="";
	String error_val="";
	String msg="";
	String p_year="";
	String p_start_date="";
	String p_no_acc_per="";
	int p_year_no = 0;
	int p_year_th = 0;
	int p_no_acc_per_no = 0;

	Connection con ;
	CallableStatement cstmt	=	null;

	HttpSession session;

	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	}

	public synchronized void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		req.setCharacterEncoding("UTF-8");
    	res.setContentType("text/html;charset=UTF-8");
		session 		= req.getSession(false) ;

		out = res.getWriter() ;
		p = ( java.util.Properties ) session.getValue( "jdbc" ) ;

		try {
		this.out = res.getWriter();
		insertGenerateAcctPeriod(req, res);

		}catch (Exception e)	{
		out.println(e.toString());
		}
	}

	private void insertGenerateAcctPeriod(HttpServletRequest req, HttpServletResponse res)	{


		try
		{

		con = ConnectionManager.getConnection(req);
		boolean result=false;
		String locale = p.getProperty("LOCALE");
		String addedById = p.getProperty( "login_user" ) ;
		String client_ip_address = p.getProperty("client_ip_address");
		String facilityId = (String) session.getAttribute("facility_id") ;

		p_year=req.getParameter("acc_per_year1");
		p_start_date=req.getParameter("acc_per_start_date");
		p_start_date = DateUtils.convertDate(p_start_date,"DMY",locale,"en");
		p_no_acc_per=req.getParameter("acc_per");
		p_year_no = Integer.parseInt(p_year);
		p_no_acc_per_no = Integer.parseInt(p_no_acc_per);
		p_year_th=p_year_no-543;

			if(locale.equals("en"))
			{
				p_year_no=p_year_no;
			} else
			{
				p_year_no = p_year_th;
			}


		cstmt =	con.prepareCall("{call SY_GENERATE_ACC_PERIODS(?,to_date(?,'dd/mm/yyyy'), ?, ?, ?, ?, ?)}");
		cstmt.setInt(1,	p_year_no);
		cstmt.setString	(2,	p_start_date);
		cstmt.setInt(3,	p_no_acc_per_no);
		cstmt.setString	(4,	addedById);
		cstmt.setString	(5,	facilityId);
		cstmt.setString	(6,	client_ip_address);
		cstmt.registerOutParameter(7,	java.sql.Types.VARCHAR);
		cstmt.execute();

		error_msg	=	cstmt.getString(7);



		if(error_msg==null)
		{
			error_msg = "";
			result	= true;
		}


		if(cstmt!=null) cstmt.close();

		if(result)
		{
			con.commit();
			java.util.Hashtable message = MessageManager.getMessage( locale, "RECORD_INSERTED","SM" ) ;
			msg = (String) message.get("message");
			error_val="1";
		}
		else
		{
			con.rollback();
			java.util.Hashtable message = MessageManager.getMessage( locale, "ACC_PERIOD_DATE_OVERLAP","SM" ) ;
			msg = (String) message.get("message");
			error_val="0";
		}

		res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" +java.net.URLEncoder.encode(msg, "UTF-8") + "&err_value=" + error_val);



		}catch ( Exception e ) {
		out.println(e.getMessage());
		out.println(e.toString());
		}
		finally
		{

		ConnectionManager.returnConnection(con,req);

		}

}


}
