/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/* 11/5/2005
	Modified by vinod - To change the database transactions from SingleTabHandler to local Servlet
*/
package eMR;

import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import javax.naming.*;
import javax.rmi.*;
import com.ehis.util.*;
import eCommon.SingleTabHandler.*;
import webbeans.eCommon.*;

public class OtherMedicalInfoServlet extends javax.servlet.http.HttpServlet
{
	PrintWriter out;
	Properties p;
	String patient_id;
	String ref_no;
	String ref_date ;
	String category ;
	String remarks ;
	String facilityId ;
	String client_ip_address ;
	String called_from	=	"";
	String error_value = "0" ;
	String error = "";
	Connection conn = null;
	PreparedStatement pstmt = null;
	//Statement stmt = null;
	PreparedStatement stmt = null;
	ResultSet rs = null;

	HttpSession session;
	java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "yyyy-MM-dd" ) ;
	String locale ="";
	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	}

	public synchronized void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		req.setCharacterEncoding("UTF-8");
		session = req.getSession(false);
		this.facilityId = (String) session.getValue( "facility_id" ) ;
		this.p = (Properties) session.getValue( "jdbc" ) ;
		locale = p.getProperty("LOCALE");
		this.client_ip_address = p.getProperty("client_ip_address");

		try
		{
			res.setContentType("text/html;charset=UTF-8");
			this.out = res.getWriter();

			String operation = req.getParameter("mode");
			if(operation.equals("insert"))   insert(req, res);
			if(operation.equals("modify"))    modify(req, res);
		}
		catch(Exception e)
		{
			//out.println(e.toString());
			e.printStackTrace();
		}
	}

	private void modify(HttpServletRequest req, HttpServletResponse res)
	{
		
		try
		{
			conn = ConnectionManager.getConnection(req);
            conn.setAutoCommit(false);

			patient_id =req.getParameter("patient_id");
			ref_no =req.getParameter("ref_no1");
			ref_date = req.getParameter("ref_date");
			if(ref_date==null) 
				ref_date="";
			ref_date = DateUtils.convertDate(ref_date,"DMY",locale,"en");
			
			category = req.getParameter("category");
			if(category==null) category="";
			remarks = req.getParameter("remarks");
			if ( remarks == null ) remarks="";
			called_from	=	(req.getParameter("called_from")==null)	?	""	:	req.getParameter("called_from");

			String addedById = p.getProperty( "login_user" ) ;
			String modifiedById = addedById ;
			String addedFacilityId=facilityId;
			String modifiedFacilityId = addedFacilityId ;
			String addedAtWorkstation=client_ip_address;
			String modifiedAtWorkstation = addedAtWorkstation ;

			pstmt = conn.prepareStatement(" update MR_PAT_OTHER_MED_INFO  set  ref_date=to_date(?,'dd/mm/yyyy'), category=?, remarks=?, modified_by_id=?, modified_date=sysdate, modified_at_ws_no=?, modified_facility_id=? where patient_id=? and ref_no=?");

			pstmt.setString(1,ref_date);
			pstmt.setString(2,category);
			pstmt.setString(3,remarks);
			pstmt.setString(4,modifiedById);
			pstmt.setString(5,modifiedAtWorkstation );
			pstmt.setString(6,modifiedFacilityId);
			pstmt.setString(7,patient_id);
			pstmt.setString(8,ref_no);

			int reslt = pstmt.executeUpdate();
            String  recInsert = (reslt > 0 ?  "Record_Updated" : "Not_Updated");

			if ( recInsert.equals("Record_Updated") )
			{
				conn.commit();
				error_value = "1" ;
				
				java.util.Hashtable message = MessageManager.getMessage( locale, "RECORD_MODIFIED","SM" ) ;
				String msg = (String) message.get("message");
				error=msg;

			}
			else
				conn.rollback();
			if(called_from.equals("CA"))
			{
				res.sendRedirect("../eCA/jsp/CAError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8" ) + "&err_value="+error_value);
			}
			else
			{
				res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8" ) + "&err_value="+error_value);
			}

		}
		catch ( Exception e )
		{
			//out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
			//out.println( "Values sent are : <br>" ) ;
			e.printStackTrace();
		}
		finally 
		{
			if(conn != null) ConnectionManager.returnConnection(conn,req);
			try
			{
				if(pstmt != null) pstmt.close();
			}
			catch( Exception e )
			{
				//out.println("<h3> Exception raise by Servlet ...</h3> Foll: Error Received : "+e.toString());
			e.printStackTrace();
			}
		}
	}

	private void insert(HttpServletRequest req, HttpServletResponse res)
	{
		
		try
		{
			conn = ConnectionManager.getConnection(req);
            conn.setAutoCommit(false);
			patient_id =req.getParameter("patient_id");
			ref_no =req.getParameter("ref_no");
			ref_date = req.getParameter("ref_date");
			if(ref_date==null) 
				ref_date="";
			ref_date = DateUtils.convertDate(ref_date,"DMY",locale,"en");
			
			category = req.getParameter("category");
			if(category==null) category="";
			remarks = req.getParameter("remarks");
			if ( remarks == null ) remarks="";
			called_from	=	(req.getParameter("called_from")==null)	?	""	:	req.getParameter("called_from");

			String addedById = p.getProperty( "login_user" ) ;
			String modifiedById = addedById ;
			String addedFacilityId=facilityId;
			String modifiedFacilityId = addedFacilityId ;
			String addedAtWorkstation=client_ip_address;
			String modifiedAtWorkstation = addedAtWorkstation ;


			int Record  = 0;
			//stmt = conn.createStatement() ;
			String countSql = " select count(*) from MR_PAT_OTHER_MED_INFO where patient_id = ? and ref_no = ? ";
			stmt = conn.prepareStatement(countSql);
			stmt.setString(1,patient_id);
			stmt.setString(2,ref_no);
			rs	= stmt.executeQuery();
			
			
			if(rs!=null  && rs.next())
			{
				Record = rs.getInt(1);
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
			}
			
			if(Record == 0)
			{

				pstmt = conn.prepareStatement(" insert into MR_PAT_OTHER_MED_INFO  (patient_id, ref_no, ref_date, category, remarks, added_by_id, added_date, added_at_ws_no, added_facility_id, modified_by_id, modified_date, modified_at_ws_no, modified_facility_id) values(?,?,to_date(?,'dd/mm/yyyy'),?,?,?,sysdate,?,?,?,sysdate,?,?)");

				pstmt.setString(1,patient_id);
				pstmt.setString(2,ref_no);
				pstmt.setString(3,ref_date);
				pstmt.setString(4,category);
				pstmt.setString(5,remarks);
				pstmt.setString(6,addedById);
				pstmt.setString(7,addedAtWorkstation);
				pstmt.setString(8, facilityId);
				pstmt.setString(9,modifiedById);
				pstmt.setString(10,modifiedAtWorkstation );
				pstmt.setString(11,modifiedFacilityId);


				int reslt = pstmt.executeUpdate();

				String  recInsert = (reslt > 0 ?  "Record_Inserted" : "Not_Inserted");
							
				if ( recInsert.equals("Record_Inserted") )
				{
					conn.commit();
					error_value = "1" ;
					
					java.util.Hashtable message = MessageManager.getMessage( locale, "RECORD_MODIFIED","SM" ) ;
					String msg = (String) message.get("message");
					error=msg;
				}
				else
					conn.rollback();

				if(called_from.equals("CA"))
				{
					//Changed the below lines for edge conversion by Vedesh A D
					out.println("<Script>parent.window[2].location.href='../eCA/jsp/CAError.jsp?err_num="+java.net.URLEncoder.encode(error, "UTF-8")+"'; </Script>"); 					
					//res.sendRedirect("../eCA/jsp/CAError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8" ) + "&err_value="+error_value);
				}
				else
				{ 
					//Changed the below lines for edge conversion by Vedesh A D
					String errmsg = java.net.URLEncoder.encode(error, "UTF-8");
					out.println("<Script> parent.window[2].location.href='../eCommon/jsp/error.jsp?err_num="+errmsg+"';  </Script>"); 					
					//res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8" ) + "&err_value="+error_value);
				}
			}
			else
			{
				java.util.Hashtable message = MessageManager.getMessage( locale, "RECORD_EXISTS","SM" ) ;
				String ErrMsg = (String) message.get("message");
				
				//Changed the below lines for edge conversion by Vedesh A D
				out.println("<Script>parent.window[2].location.href='../eCommon/jsp/error.jsp?err_num="+java.net.URLEncoder.encode(ErrMsg, "UTF-8")+"'; </Script>"); 					
				//res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode( ErrMsg, "UTF-8" ) + "&err_value=1");
			}
		}
		catch ( Exception e )
		{
			//out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
			/*out.println( "Values sent are : <br>" ) ;
			out.println( 	patient_id+" "+ref_no+" "+ref_date+" "+category+" "+remarks  );
			*/
			e.printStackTrace();
		}
		finally 
		{
			if(conn != null) ConnectionManager.returnConnection(conn,req);
  			try
			{
				if(pstmt != null) pstmt.close();
			}
			catch( Exception e )
			{
				//out.println("<h3> Exception raise by Servlet ...</h3> Foll: Error Received : "+e.toString());
				
				e.printStackTrace();
			}
		}
	}
}
