/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eSM;
import com.ehis.util.*;
import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import javax.naming.*;
import javax.rmi.*;
import java.util.*;
import java.text.ParseException;
import webbeans.eCommon.*;
import eCommon.SingleTabHandler.*;
import javax.servlet.http.HttpServletResponse;

public class MaintainAcctPeriodServlet extends javax.servlet.http.HttpServlet implements SingleThreadModel
{

	PrintWriter out;
	java.util.Properties p;
	StringBuffer sb1=  null;
	StringBuffer sb =new StringBuffer( "" ) ;
	String error_msg="";
	String error_val="";
	String msg="";
    String acc_per_year;
    String acc_per_month;
	String acc_per_start_date;
	String acc_per_end_date1;
	String acc_per_desc1;
	String acc_cal_year1;
	String acc_cal_month1;
	String mon;
	String date;
	String desc;
	String date1;

    String error="";
    String acc_per_closed_yn;
	Connection con ;
    PreparedStatement pstmt ;
	ResultSet rs ;


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
		//String operation = req.getParameter("function");

		insertMaintainAcctPeriod(req, res);

		}catch (Exception e)	{
		out.println(e.toString());
		e.printStackTrace();
		}
	}

	private void insertMaintainAcctPeriod(HttpServletRequest req, HttpServletResponse res)	{


		try
		{


		String locale = p.getProperty("LOCALE");
		String addedById = p.getProperty( "login_user" ) ;
		//Timestamp  tsTime = new Timestamp(System.currentTimeMillis() );
		String client_ip_address = p.getProperty("client_ip_address");
		String facilityId = (String) session.getAttribute("facility_id") ;
		String modifiedById    =   addedById;
		String modifiedBy_ws_no    =   client_ip_address;
		String modifiedBy_faci_Id    =   facilityId;
        con = ConnectionManager.getConnection(req);

        acc_per_year	= req.getParameter( "acc_per_year" ) ;
		acc_per_year = DateUtils.convertDate(acc_per_year,"YY",locale,"en");

	    acc_per_month	= req.getParameter( "acc_per_mon" ) ;
	    acc_per_start_date	= req.getParameter( "acc_per_start_date" ) ;

		acc_per_start_date = DateUtils.convertDate(acc_per_start_date,"DMY",locale,"en");


		acc_per_end_date1	= req.getParameter( "acc_per_end_date1" ) ;
		acc_per_end_date1 = DateUtils.convertDate(acc_per_end_date1,"DMY",locale,"en");


		acc_per_desc1	= req.getParameter( "acc_per_desc1" ) ;

        StringTokenizer str=new StringTokenizer(acc_per_desc1);
		 while (str.hasMoreTokens()) {
	      mon=str.nextToken();
		  date=(String)str.nextToken();
          date1 = DateUtils.convertDate(date,"YY",locale,"en");
          desc=mon+" "+date1;
	}

		acc_cal_year1	= req.getParameter( "acc_cal_year1" ) ;
		acc_cal_year1 = DateUtils.convertDate(acc_cal_year1,"YY",locale,"en");

		acc_cal_month1	= req.getParameter( "acc_cal_month1" ) ;


       pstmt = con.prepareStatement("insert into SY_ACC_PERIOD_DEFN( ACC_PER_YEAR, ACC_PER_MONTH, ACC_PER_START_DATE, ACC_PER_END_DATE, CAL_PER_YEAR, CAL_PER_MONTH, ACC_PER_DESC,ACC_PER_CLOSED_YN,ADDED_BY_ID,  ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,  MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID) values(?,?,to_date(?,'dd/mm/yyyy'),to_date(?,'dd/mm/yyyy'),?,?,?,'N',?,sysdate,?,?,?,sysdate,?,?) ");

	   pstmt.setString(1,acc_per_year);
	   pstmt.setString(2,acc_per_month);
	   pstmt.setString(3,acc_per_start_date);
	   pstmt.setString(4,acc_per_end_date1);
	   pstmt.setString(5,acc_cal_year1);
	   pstmt.setString(6,acc_cal_month1);
	   pstmt.setString(7,desc);
	   pstmt.setString(8,addedById);
	   pstmt.setString(9,client_ip_address);
	   pstmt.setString(10,facilityId);
	   pstmt.setString(11,modifiedById);
	   pstmt.setString(12,modifiedBy_ws_no);
	   pstmt.setString(13,modifiedBy_faci_Id);

	   int n = pstmt.executeUpdate();
	 if( n > 0){

			con.commit();
			java.util.Hashtable message = MessageManager.getMessage(locale,"RECORD_INSERTED","SM") ;
			msg = (String) message.get("message");
		    error_val="1";
	 }

		if (pstmt != null) pstmt.close();
		res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" +java.net.URLEncoder.encode(msg, "UTF-8") + "&err_value=" + error_val);

		}catch ( Exception e ) {
		out.println(e.getMessage());
		out.println(e.toString());
		e.printStackTrace();
		}

		finally
		{

		ConnectionManager.returnConnection(con,req);

		}

}


}
