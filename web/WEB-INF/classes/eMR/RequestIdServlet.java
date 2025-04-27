/*Created by Ashwini on 07-Jul-2017 for ML-MMOH-CRF-0702*/
package eMR;

import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import javax.naming.*;
import javax.rmi.*;
import webbeans.eCommon.*;
import java.sql.*;

import eCommon.SingleTabHandler.*;

import eCommon.XSSRequestWrapper;


public class RequestIdServlet extends javax.servlet.http.HttpServlet
{
	PrintWriter out;
	Properties p;
	String req_year ="";
	String start_no ="";
	String max_no ="";
	String next_serl_no ="";
	String facilityId ="";
	String client_ip_address ="";
	HttpSession session;
	
	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	}

	public synchronized void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		req.setCharacterEncoding("UTF-8");
		
			req= new XSSRequestWrapper(req);
			res.addHeader("X-XSS-Protection", "1; mode=block");
			res.addHeader("X-Content-Type-Options", "nosniff");
		
		session = req.getSession(false);
		this.facilityId = (String) session.getValue( "facility_id" ) ;
		this.p = (Properties) session.getValue( "jdbc" );
		client_ip_address = p.getProperty("client_ip_address");

		try
		{			
			res.setContentType("text/html;charset=UTF-8");
			this.out = res.getWriter();
			insertRequestId(req, res);
		}
		catch(Exception e)
		{
			/* out.println(e.toString()); */
			 e.printStackTrace();
		}
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		try
		{
			req.setCharacterEncoding("UTF-8");
			res.setContentType("text/html;charset=UTF-8");
			
			req= new XSSRequestWrapper(req);
			res.addHeader("X-XSS-Protection", "1; mode=block");
			res.addHeader("X-Content-Type-Options", "nosniff");
			
			this.out = res.getWriter();
			insertRequestId(req, res);
		}
		catch(Exception e)	{/* out.println(e.toString()); */  e.printStackTrace();	}
	}

	private void insertRequestId(HttpServletRequest req, HttpServletResponse res)
	{
		
		Connection con =null;
		String sql = "";
		String error_value = "0" ;
		String error = "";
		int count=0;
		PreparedStatement pstmt=null;
		ResultSet rset=null;

		try
		{
			con = ConnectionManager.getConnection(req);
			con.setAutoCommit(false);
			String locale= p.getProperty("LOCALE");
			String addedFacilityId		= facilityId;
			String modifiedFacilityId	= addedFacilityId ;
			String addedAtWorkstation	= client_ip_address;
			String modifiedAtWorkstation = addedAtWorkstation ;
			
				req_year = req.getParameter("req_year");
				start_no = req.getParameter("start_no");
				max_no   = req.getParameter("max_no");
				next_serl_no = req.getParameter("next_serl_no");

			sql="select count(*) from mr_request_id_for_fcy where year_num= ? and facility_id= ?";
			pstmt = con.prepareStatement( sql );
			pstmt.setString(1, req_year);
			pstmt.setString(2, facilityId);
			rset = pstmt.executeQuery();
			if(rset!=null && rset.next()){
				count=rset.getInt(1);
			}
			
			if(rset!=null) rset.close();

			if(count != 0){
					 Hashtable message = MessageManager.getMessage(locale, "CODE_ALREADY_EXISTS","Common");
					 error = (String)message.get("message");					
					 res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num="+java.net.URLEncoder.encode( error , "UTF-8")+"&err_value="+error_value);
					 message.clear();			
			}else{			
				if(pstmt !=null) pstmt.close();
				sql="insert into mr_request_id_for_fcy(year_num,start_srl_no,max_srl_no,next_srl_no,facility_id,added_facility_id,modified_facility_id,added_at_ws_no,modified_at_ws_no) values(?,?,?,?,?,?,?,?,?)";
				pstmt = con.prepareStatement( sql );
				pstmt.setString(1, req_year);
				pstmt.setString(2, start_no);
				pstmt.setString(3, max_no);
				pstmt.setString(4, next_serl_no);
				pstmt.setString(5, facilityId);
				pstmt.setString(6, addedFacilityId);
				pstmt.setString(7, modifiedFacilityId);
				pstmt.setString(8, addedAtWorkstation);
				pstmt.setString(9, modifiedAtWorkstation);
				int result= pstmt.executeUpdate();							
				
				if ( result>0 )
				{
                     error_value = "1" ;
					 con.commit();
					 Hashtable message = MessageManager.getMessage(locale, "RECORD_INSERTED","SM");
					 error = (String)message.get("message");
				}
				}

				res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num="+java.net.URLEncoder.encode( error , "UTF-8")+"&err_value="+error_value);
		}
		catch ( Exception e )
		{
		    e.printStackTrace();
			/* out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
			out.println( "Values sent are : <br>" ) ;
			out.println( req_year+ " "+start_no + " "+max_no  + " "+next_serl_no + " "+facilityId); */
			
		}
		finally
		{
			 ConnectionManager.returnConnection(con,req);
		}
	}

}