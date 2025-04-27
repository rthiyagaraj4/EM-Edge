/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
	Developed By       :  P.Sudhakaran
	Module Name 	   :  eCIS/dr
	Function Name	   : Exclude Possible Duplicate Servlet
	Function ID		   :

*/
package eDR;
import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import webbeans.eCommon.*;

public class ExcludePossibleDuplicateServlet extends javax.servlet.http.HttpServlet
{
	PrintWriter out;
	Properties p;
	HttpSession session;
	
	Connection con						= null;
	Statement stmt						= null;
	PreparedStatement pstmt				= null;
	ResultSet rs						= null;
	ResultSet messageResultset          = null;

	StringBuffer sb						= null;
	StringBuffer SqlBuffer				= null;
	StringBuffer InsertSqlBuffer		= null;
	StringBuffer DeleteSqlBuffer		= null;
	
	String client_ip_address			= "";
	String facilityId					= "";
	String addedById					= "";
	String modifiedById					= "";
	String addedFacilityId				= "";
	String modifiedFacilityId			= "";
	String addedAtWorkstation			= "";
	String modifiedAtWorkstation		= "";
	String patient_id1					= "";
	String patient_id2					= "";
	//String p_patient_id1				= "";
	//String p_patient_id2				= "";
	String sql							= "";
	String message						= "";
	String code							= "";
	String mode							= "";
	String fin_patient_id				= "";
	String del_patientid1				= "";
	String del_patientid2				= "";

	boolean commit_flag					=true;
	boolean valid_pat					=false;

	int count							=0;
	int rsinsertft						=0;
	int deleteft						=0;
	int pat_id1							=0;
	int pat_id2							=0;



	public void init(ServletConfig config) throws ServletException
	{
			super.init(config);
	}

	public synchronized void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
		session					= req.getSession(false);
		this.facilityId			= (String) session.getValue("facility_id");
		this.p					= (Properties) session.getValue("jdbc");
		this.client_ip_address  = p.getProperty("client_ip_address");
		
		try
		{
			con  = ConnectionManager.getConnection(req);
			stmt = con.createStatement();

			SqlBuffer = new StringBuffer();			

			String locale = p.getProperty("LOCALE");
			

			this.out	= res.getWriter();
			sb			= new StringBuffer("");
			mode		= req.getParameter("mode");
			
			if(mode != null && mode.equals("insert"))
			{
				patient_id1					= req.getParameter("patient_id1");
				patient_id2					= req.getParameter("patient_id2");
				addedById					= p.getProperty("login_user") ;

				modifiedById				= addedById ;
				addedFacilityId				= facilityId;
				modifiedFacilityId	        = addedFacilityId ;
				addedAtWorkstation	        = client_ip_address;
				modifiedAtWorkstation       = addedAtWorkstation ;
				
				sql		= "select count(*) from mp_patient where patient_id = ? ";
				pstmt	= con.prepareStatement(sql);
				pstmt.setString(1,patient_id1);
				rs		= pstmt.executeQuery();

				if (rs!=null && rs.next())
				{
					pat_id1 = rs.getInt(1);
				} if(rs != null) rs.close(); if(pstmt != null) pstmt.close();
				
				sql = "select count(*) from mp_patient where patient_id = ? ";

				pstmt	= con.prepareStatement(sql);
				pstmt.setString(1,patient_id2);
				rs		= pstmt.executeQuery();

				if(rs!=null && rs.next())
				{
					pat_id2 = rs.getInt(1);
				} 
				if(rs != null) rs.close(); 
				if(pstmt != null) pstmt.close();
				
				if(pat_id1 >= 1)
				{					
					if(pat_id2 >= 1) valid_pat = true;
					else valid_pat = false;
				}

				if(valid_pat == true)
				{
					SqlBuffer.append("select patient_id1,patient_id2 from dr_not_dup_patients where (patient_id1 = ? and  patient_id2 = ?) or (patient_id1 = ? and  patient_id2 = ?)");

					pstmt = con.prepareStatement(SqlBuffer.toString());

					pstmt.setString(1,patient_id1);
					pstmt.setString(2,patient_id2);
					pstmt.setString(3,patient_id1);
					pstmt.setString(4,patient_id2);

					rs	= pstmt.executeQuery();

					count = 0;
					while(rs != null && rs.next())
					{
						count++;
						//p_patient_id1=rs.getString("patient_id1");
						//p_patient_id2=rs.getString("patient_id2");
					} 
					if(rs != null) rs.close(); 
					if(pstmt != null) pstmt.close();
				}
				//else*/
				if(valid_pat == false)
				{
				/*	String mess="APP-DR0009 Patient Record does not exist";
					String cod="";  */

					java.util.Hashtable message = MessageManager.getMessage(locale, "NO_RECORD", "DR");
					String error = ((String) message.get("message"));

					res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode(error,"UTF-8") + "&err_value=0" );
				}

				if(valid_pat)
				{
					if(count == 0)
						insert_dr_not_dup_patients(res);
					else
					{
					//	message="APP-002005 Record Already Exists...";
						
						java.util.Hashtable message = MessageManager.getMessage(locale, "CODE_ALREADY_EXISTS", "Common");
						String error = ((String) message.get("message"));

						res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode(error,"UTF-8") + "&err_value=0" );
					}
				}
			}
			else if(mode != null && mode.equals("delete"))
			{
				fin_patient_id				= req.getParameter("fin_patient_id");

				modifiedById				= addedById ;
				addedFacilityId				= facilityId;
				modifiedFacilityId	        = addedFacilityId ;
				addedAtWorkstation	        = client_ip_address;
				modifiedAtWorkstation       = addedAtWorkstation;

				delete_dr_not_dup_patients(res);
			}
			
			if((SqlBuffer != null) && (SqlBuffer.length() > 0))
			{
				SqlBuffer.delete(0,SqlBuffer.length());
			}

			if(messageResultset!=null)	messageResultset.close();
			if(rs !=null )		rs.close();
			if(stmt != null)	stmt.close();
			if(pstmt != null)	pstmt.close();

		}catch(Exception e){out.println("In doPost :"+e.toString());}
		finally
		{
			ConnectionManager.returnConnection(con,req);
		}
	}//do post

	public synchronized void insert_dr_not_dup_patients(HttpServletResponse res)
	{
		try
		{
			String locale = p.getProperty("LOCALE");
			

			con.setAutoCommit(false);

			InsertSqlBuffer = new StringBuffer();
			
			InsertSqlBuffer.append("insert into dr_not_dup_patients ");
			InsertSqlBuffer.append("(patient_id1,");
			InsertSqlBuffer.append("patient_id2,");
			InsertSqlBuffer.append("added_by_id,");
			InsertSqlBuffer.append("added_date,");
			InsertSqlBuffer.append("added_at_ws_no,");
			InsertSqlBuffer.append("added_facility_id,");
			InsertSqlBuffer.append("modified_by_id,");
			InsertSqlBuffer.append("modified_date,");
			InsertSqlBuffer.append("modified_at_ws_no,");
			InsertSqlBuffer.append("modified_facility_id) ");
			InsertSqlBuffer.append("values (?,?,?,sysdate,?,?,?,sysdate,?,?)");

			pstmt = con.prepareStatement(InsertSqlBuffer.toString());
            
			pstmt.setString(1,patient_id1);
			pstmt.setString(2,patient_id2);
			pstmt.setString(3,addedById);
			pstmt.setString(4,addedAtWorkstation);				
			pstmt.setString(5,addedFacilityId);
			pstmt.setString(6,modifiedById);
			pstmt.setString(7,modifiedAtWorkstation);
			pstmt.setString(8,modifiedFacilityId);
            
			rsinsertft = 0;
			rsinsertft = pstmt.executeUpdate();
			
			sb.append("<br>");
			sb.append("rsinsertft :"+rsinsertft);

			if(rsinsertft>0)
			{
				con.commit();

		/*		String msg = "select message_id, message_text_sysdef from sm_message where message_ref = 'RECORD_INSERTED'";
				messageResultset = stmt.executeQuery(msg);
				if(messageResultset != null)
				{
					if(messageResultset.next())
					{
						code	= messageResultset.getString("message_id");
						message = messageResultset.getString("message_text_sysdef");
					}
				}
				if(messageResultset != null) messageResultset.close();  */

				java.util.Hashtable message = MessageManager.getMessage(locale, "RECORD_INSERTED", "SM");
				String error = ((String) message.get("message"));

				res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode(error,"UTF-8") + "&err_value=1 " );
			}
			else
			{
				con.rollback();
			//	res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode(""+code+" "+message+"" ) + "&err_value=0 " );
			}
			
			if((InsertSqlBuffer != null) && (InsertSqlBuffer.length() > 0))
			{
				InsertSqlBuffer.delete(0,InsertSqlBuffer.length());
			}

			if(messageResultset!=null)	messageResultset.close();
			if(stmt !=null ) stmt.close();
			if(pstmt != null) pstmt.close();

		}catch(Exception e)
		{
			try
			{
				con.rollback();
				out.println("<h3> Exception raise by Servlet ...So Record Not inserted </h3> Foll: Error Received : "+e.toString());
			}catch(Exception de){out.println("Exception while Rollback :"+de);}
		}
	}//method

	public synchronized void delete_dr_not_dup_patients(HttpServletResponse res)
	{
		try
		{
			String locale = p.getProperty("LOCALE");
			

			con.setAutoCommit(false);

			DeleteSqlBuffer			 = new StringBuffer();
			StringTokenizer indtoken = new StringTokenizer(fin_patient_id, "~");
			

			DeleteSqlBuffer.append("delete dr_not_dup_patients where patient_id1 = ? and patient_id2 = ?");
			
			pstmt = con.prepareStatement(DeleteSqlBuffer.toString());

		mainWhile :
			while(indtoken.hasMoreTokens())
			{
				String next_patient_token	= "";
				next_patient_token			= indtoken.nextToken();
				StringTokenizer stoken		= new StringTokenizer(next_patient_token,"|");
				
				int count =	0;
				
				while(stoken.hasMoreTokens())
				{
					count++;
					del_patientid1		= stoken.nextToken();
					del_patientid2		= stoken.nextToken();
					
		///////////////////////////////////////////////////////////////////////////////

					pstmt.setString(1,del_patientid1);
					pstmt.setString(2,del_patientid2);

					deleteft = 0;
					deleteft = pstmt.executeUpdate();

		///////////////////////////////////////////////////////////////////////////////

					if(deleteft == 0)
					{
						commit_flag = false;
						break mainWhile;
					}
				}
			}
			
			if(commit_flag == true && deleteft>0)
			{
				con.commit();

			/*	String msg = "select message_id, message_text_sysdef from sm_message where message_ref = 'RECORD_INSERTED'";
				messageResultset=stmt.executeQuery(msg);
				if(messageResultset != null)
				{
					if(messageResultset.next())
					{
						code	= messageResultset.getString("message_id");
						message	= messageResultset.getString("message_text_sysdef");
					}
				}
				if(messageResultset != null) messageResultset.close();  */

				java.util.Hashtable message = MessageManager.getMessage(locale, "RECORD_DELETED", "SM");
				String error = ((String) message.get("message"));

				res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode(error,"UTF-8") + "&err_value=1 " );
			}
			else
			{
				con.rollback();
			//	message = "<br>Transaction Failed"+sb.toString();
			//	res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode(""+code+" "+message+"" ) + "&err_value=0 " );
			}

			if((DeleteSqlBuffer != null) && (DeleteSqlBuffer.length() > 0))
			{
				DeleteSqlBuffer.delete(0,DeleteSqlBuffer.length());
			}

			if(messageResultset != null)	messageResultset.close();
			if(stmt != null)				stmt.close();
			if(pstmt != null)				pstmt.close();

		}catch(Exception e)
		{
			try
			{
				con.rollback();
				out.println("<h3> Exception raise by Servlet ...So Record Not inserted </h3> Foll: Error Received : "+e.toString());
			}catch(Exception de){out.println("Exception while Rollback :"+de);}
		}
	}//method
}//class
