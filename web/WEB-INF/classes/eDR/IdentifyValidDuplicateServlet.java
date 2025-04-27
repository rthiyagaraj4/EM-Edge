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
	Module Name 	   :  eHIS/dr
	Function Name	   : Identify Valid Duplicate Servlet
	Function ID		   :

*/
package eDR;
import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import webbeans.eCommon.*;

public class IdentifyValidDuplicateServlet extends javax.servlet.http.HttpServlet
{
	PrintWriter out;
	
	
	Connection con						= null;
	Statement stmt						= null;
	PreparedStatement pstmt				= null;
	PreparedStatement pstmt1			= null;
	PreparedStatement pstmt2			= null;
	PreparedStatement pstmt3			= null;
	PreparedStatement pstmt4			= null;
	PreparedStatement pstmt5			= null;
	ResultSet messageResultset          = null;
	ResultSet rs						= null;
	StringBuffer sb						= null;

	String dup_group_id					= "";
	//String count						= "";
	String final_chk_values				= "";
	String sqlinsert					= "";
	String sqlinsert1					= "";
	String sqlinsert2					= "";
	String sqlinsert3					= "";
	String sqlinsert4					= "";
	String sqlinsert5					= "";
	String patientid					= "";
	String dupindicator					= "";
	String code							= "";
	String message						= "";
	String sqlupdate					= "";
	String modal						= "";
	String del_header					= "";
	String function_name				= "";
	String exclude_mode					= "N";
	Properties p;
	StringBuffer SelectSQL				= null;	
	String locale                       = "";
	String error                        = "";

	int updatehdr						= 0;
	int updateres						= 0;
	HttpSession session;
	boolean commit_flag					= true;

	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	}
	public synchronized void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		try
		{
			req.setCharacterEncoding("UTF-8");
			res.setContentType("text/html;charset=UTF-8");
			con		= ConnectionManager.getConnection(req);
			stmt	= con.createStatement();
			session = req.getSession(false);
			con.setAutoCommit(false);

			p = (Properties)session.getValue("jdbc");			
			this.out		 = res.getWriter();
			locale = p.getProperty("LOCALE");

			sb				 = new StringBuffer("");
			final_chk_values = req.getParameter("final_chk_values");
			dup_group_id	 = req.getParameter("p_dup_group_id");
			del_header		 = req.getParameter("del_header");
			function_name	 = req.getParameter("function_name");
			modal			 = req.getParameter("modal");
			exclude_mode	 = req.getParameter("exclude_mode"); 

			sb.append("<br>final_chk_values"+final_chk_values);
		
	
			if(exclude_mode.equals("Y"))
			{
				insert_dr_not_dup_patients(res, req);
			}
			else
			{
				insert_dr_dup_group_dtls(res);
			}

			if(stmt != null) stmt.close();
		}catch(Exception e){out.println(e.toString());e.printStackTrace();}
		finally
		{
			ConnectionManager.returnConnection(con,req);
		}
	}//do post

	public synchronized void insert_dr_not_dup_patients(HttpServletResponse res, HttpServletRequest req)
	{
		Connection con				= null;
		PreparedStatement ins_pstmt	= null;
		PreparedStatement del_pstmt	= null;
		PreparedStatement update_pstmt	= null;
		StringBuffer InsertSql	= new StringBuffer();

		int insert = 0;
		try 
		{					
			con	= ConnectionManager.getConnection(req);
			con.setAutoCommit(false);
			InsertSql.append("insert into DR_NOT_DUP_PATIENTS ");
            InsertSql.append("(PATIENT_ID1, ");
            InsertSql.append("PATIENT_ID2, ");
            InsertSql.append("added_by_id, ");
            InsertSql.append("added_facility_id, ");
            InsertSql.append("added_at_ws_no, ");
            InsertSql.append("added_date, ");
            InsertSql.append("MODIFIED_BY_ID, ");
            InsertSql.append("MODIFIED_DATE, ");
            InsertSql.append("MODIFIED_AT_WS_NO, ");
            InsertSql.append("MODIFIED_FACILITY_ID) ");
            InsertSql.append(" values (?,?,?,?,?,sysdate,?,sysdate,?,?) ");
			ins_pstmt = con.prepareStatement(InsertSql.toString());
			StringTokenizer indtoken = new StringTokenizer(final_chk_values, "|");
			mainWhile :
				while(indtoken.hasMoreTokens())
				{
					String next_patient_token	= "";
					next_patient_token			= indtoken.nextToken();
					StringTokenizer stoken		= new StringTokenizer(next_patient_token,"~");
					while(stoken.hasMoreTokens())
					{
						patientid	= stoken.nextToken();
						dupindicator= stoken.nextToken();
						sqlinsert	= "";
						sqlinsert5	= " select count(1) from DR_NOT_DUP_PATIENTS where PATIENT_ID1= ? ";
                       pstmt5=con.prepareStatement(sqlinsert5);
						pstmt5.setString(1,patientid);
				      rs=	pstmt5.executeQuery();
					  rs.next();
					  int count = rs.getInt(1);
					  if(rs !=null) rs.close();
						if(count<=0)
						{
							if(dupindicator.equals("E"))
							{ 
								ins_pstmt.setString(1, patientid);
								ins_pstmt.setString(2, patientid);
								ins_pstmt.setString(3, p.getProperty("login_user"));
								ins_pstmt.setString(4, (String)session.getValue("facility_id"));
								ins_pstmt.setString(5, p.getProperty("client_ip_address"));
								ins_pstmt.setString(6, p.getProperty("login_user"));
								ins_pstmt.setString(7, p.getProperty("client_ip_address"));
								ins_pstmt.setString(8, (String)session.getValue("facility_id"));
								insert = 0;
								insert = ins_pstmt.executeUpdate();
								del_pstmt = con.prepareStatement(" delete from DR_DUP_GROUP_DTLS where patient_id = '"+patientid+"' ");
								del_pstmt.executeUpdate();
								update_pstmt = con.prepareStatement(" update DR_DUP_GROUP_HDR set PAT_COUNT = PAT_COUNT-1 ,modified_by_id = '"+p.getProperty("login_user")+"',modified_date = sysdate, modified_at_ws_no = '"+p.getProperty("client_ip_address")+"', modified_facility_id = '"+(String)session.getValue("facility_id")+"' where dup_group_id = '"+dup_group_id+"' ");
								 update_pstmt.executeUpdate();
							}
						}  else {
							java.util.Hashtable message = MessageManager.getMessage(locale, "EXCLUDE_DUPLICATE_RECORD", "DR");
							error = ((String) message.get("message"));							 res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode(""+error+"" ) + "&err_value=0 ");
						}
					}
				}
				if(ins_pstmt != null )ins_pstmt.close();
				if(del_pstmt != null )del_pstmt.close();
				if(insert== 0)
				{		
					con.rollback();
					message="<br>Transaction Failed"+sb.toString();
					if(modal != null && modal.equals("Y"))
					{
						res.sendRedirect("../eDR/jsp/DRerror.jsp?err_num=" + java.net.URLEncoder.encode(""+code+" "+message+"" ) + "&err_value=0 " );
					}
				}
				else 
				{
					con.commit();
/*				    Hashtable hashtable = MessageManager.getMessage(con, "RECORD_INSERTED");
					String msg = (String)hashtable.get("message");

					//res.sendRedirect("../eDR/jsp/DRerror.jsp?err_num=" + java.net.URLEncoder.encode(""+code+" "+msg+"" ) + "&err_value=1" );*/
					java.util.Hashtable message = MessageManager.getMessage(locale, "RECORD_INSERTED", "SM");
					error = ((String) message.get("message"));
					res.sendRedirect("../eCommon/jsp/error.jsp?err_num="+java.net.URLEncoder.encode(error,"UTF-8")+"&err_value=1");
				}

			}catch(Exception e)
			{
				e.printStackTrace();
				try 
				{
					con.rollback();
					out.println("Exception raise by Servlet in INSERT_DR_NOT_DUP_PATIENTS method : "+e.toString());
				}catch(Exception de)
				{
					e.printStackTrace();
					out.println("Exception while Rollback :"+de);
				}
			}
			finally
			{
				ConnectionManager.returnConnection(con,req);
			}
	}//E.o method


	public synchronized void insert_dr_dup_group_dtls(HttpServletResponse res)
	{


		StringBuffer InsertSqlBuffer = new StringBuffer();
		try 
		{

			

			con.setAutoCommit(false);
			SelectSQL = new StringBuffer();
			sqlinsert	= "delete DR_DUP_GROUP_DTLS where dup_group_id = ? and patient_id = ?";
			pstmt		= con.prepareStatement(sqlinsert);
			sqlinsert1	= "update DR_DUP_GROUP_HDR set  pat_count = pat_count - 1 ,modified_by_id = '"+p.getProperty("login_user")+"',modified_date = sysdate, modified_at_ws_no = '"+p.getProperty("client_ip_address")+"', modified_facility_id = '"+(String)session.getValue("facility_id")+"' where dup_group_id = ?";
			pstmt1		= con.prepareStatement(sqlinsert1);
			sqlinsert2	= "delete DR_DUP_GROUP_DTLS where dup_group_id = ? and patient_id = ?";
			pstmt2		= con.prepareStatement(sqlinsert2);
			sqlinsert3	= "update DR_DUP_GROUP_DTLS set dup_indicator = ? ,modified_by_id = ? ,modified_date = sysdate, modified_at_ws_no = ? , modified_facility_id = ? where dup_group_id = ? and patient_id = ?";
			pstmt3		= con.prepareStatement(sqlinsert3);

			InsertSqlBuffer.append("insert into DR_NOT_DUP_PATIENTS ");
            InsertSqlBuffer.append("(PATIENT_ID1, ");
            InsertSqlBuffer.append("PATIENT_ID2, ");
            InsertSqlBuffer.append("added_by_id, ");
            InsertSqlBuffer.append("added_facility_id, ");
            InsertSqlBuffer.append("added_at_ws_no, ");
            InsertSqlBuffer.append("added_date, ");
            InsertSqlBuffer.append("MODIFIED_BY_ID, ");
            InsertSqlBuffer.append("MODIFIED_DATE, ");
            InsertSqlBuffer.append("MODIFIED_AT_WS_NO, ");
            InsertSqlBuffer.append("MODIFIED_FACILITY_ID) ");
            InsertSqlBuffer.append(" values (?,?,?,?,?,sysdate,?,sysdate,?,?) ");
			pstmt4		= con.prepareStatement(InsertSqlBuffer.toString());

			StringTokenizer indtoken = new StringTokenizer(final_chk_values, "|");
			mainWhile :
				while(indtoken.hasMoreTokens())
				{
					String next_patient_token	= "";
					next_patient_token			= indtoken.nextToken();
                   
					StringTokenizer stoken		= new StringTokenizer(next_patient_token,"~");
					while(stoken.hasMoreTokens())
					{
						patientid	= stoken.nextToken();
						dupindicator= stoken.nextToken();
						sqlinsert	= "";
                       	sqlinsert5	= " select count(1) from DR_NOT_DUP_PATIENTS where PATIENT_ID1= ? ";
                       pstmt5=con.prepareStatement(sqlinsert5);
						pstmt5.setString(1,patientid);
				    rs=	pstmt5.executeQuery();
					rs.next();
					int count = rs.getInt(1);
					if(rs !=null) rs.close();
						
						if(count<=0)
						{
							if(dupindicator.equals("E"))
							{
								
								pstmt4.setString(1,patientid);
								pstmt4.setString(2, patientid);
								pstmt4.setString(3, p.getProperty("login_user"));
								pstmt4.setString(4, (String)session.getValue("facility_id"));
								pstmt4.setString(5, p.getProperty("client_ip_address"));
								pstmt4.setString(6, p.getProperty("login_user"));
								pstmt4.setString(7, p.getProperty("client_ip_address"));
								pstmt4.setString(8, (String)session.getValue("facility_id"));
								
								int insert = 0;
								insert = pstmt4.executeUpdate();
							}
						}
						if(function_name.equals("D"))
						{
							if(dupindicator.equals("L"))
							{
								pstmt.setString(1,dup_group_id);
								pstmt.setString(2,patientid);
								updateres = pstmt.executeUpdate();
								pstmt1.setString(1,dup_group_id);
								updateres = pstmt1.executeUpdate();
						   }
						}
						else
						{
							if(dupindicator.equals("L")){
								pstmt2.setString(1,dup_group_id);
								pstmt2.setString(2,patientid);
								updateres = pstmt2.executeUpdate();
							}else {
								pstmt3.setString(1,dupindicator);
								pstmt3.setString(2,p.getProperty("login_user"));
								pstmt3.setString(3,p.getProperty("client_ip_address"));
								pstmt3.setString(4,(String)session.getValue("facility_id"));
								pstmt3.setString(5,dup_group_id);
								pstmt3.setString(6,patientid);
								updateres = pstmt3.executeUpdate();
							}	
						}
						if(dupindicator.equals("E"))
						{
							 sqlupdate = "delete dr_dup_group_dtls where dup_group_id='"+dup_group_id +"' and PATIENT_ID ='"+patientid+"'";
							updatehdr = stmt.executeUpdate(sqlupdate);
							sqlupdate = "update DR_DUP_GROUP_HDR set PAT_COUNT = PAT_COUNT-1 ,modified_by_id = '"+p.getProperty("login_user")+"',modified_date = sysdate, modified_at_ws_no = '"+p.getProperty("client_ip_address")+"', modified_facility_id = '"+(String)session.getValue("facility_id")+"' where dup_group_id = '"+dup_group_id+"'";
							updatehdr = stmt.executeUpdate(sqlupdate);
						}
					
					}
				}
				if(pstmt4 != null )pstmt4.close();
				sb.append("<br> The final value of commit_flag"+commit_flag+"");
				if(commit_flag)
				{
					updatehdr = 0;
					sqlupdate = "";

			
					if(dupindicator.equals("L"))
					{
			
						if(del_header.equals("Y"))
						{
							sqlupdate = "delete dr_dup_group_dtls where dup_group_id="+dup_group_id;
							updatehdr = stmt.executeUpdate(sqlupdate);
							sqlupdate = "delete dr_dup_group_hdr where dup_group_id="+dup_group_id;
							updatehdr = stmt.executeUpdate(sqlupdate);
						}
					}
					else
					{
						sqlupdate = "update dr_dup_group_hdr set group_status='I',status_upd_date=sysdate , modified_by_id = '"+p.getProperty("login_user")+"',modified_date = sysdate, modified_at_ws_no = '"+p.getProperty("client_ip_address")+"', modified_facility_id = '"+(String)session.getValue("facility_id")+"' where dup_group_id="+dup_group_id;
						updatehdr = stmt.executeUpdate(sqlupdate);
					}
				}
				sb.append("<br> The value of updatehdr"+updatehdr+"");
				
				

				if(updateres == 1)
				{
					SelectSQL.append("select count(1) from DR_NOT_DUP_PATIENTS where (patient_id1 =(select patient_id from dr_dup_group_dtls where dup_indicator  = 'V' and dup_group_id = ?) and patient_id2 in (select patient_id from dr_dup_group_dtls where dup_indicator  = 'D' and dup_group_id = ?)) or (patient_id2 =(select patient_id from dr_dup_group_dtls where dup_indicator  = 'V' and dup_group_id = ? )and patient_id1 in (select patient_id from dr_dup_group_dtls where dup_indicator  = 'D' and dup_group_id = ?))");
					pstmt4 = con.prepareStatement(SelectSQL.toString());
					pstmt4.setString(1,dup_group_id);
					pstmt4.setString(2,dup_group_id);
					pstmt4.setString(3,dup_group_id);
					pstmt4.setString(4,dup_group_id);
					messageResultset = pstmt4.executeQuery();
					int error_value = 0;
					if(messageResultset != null && messageResultset.next())
					{
						if(messageResultset.getInt(1) == 0)
                        {
							con.commit();
							error_value = 1;
							if(messageResultset != null) messageResultset.close();

							/*String msg = "select message_id, message_text_sysdef from sm_message where message_ref='RECORD_INSERTED'";
							messageResultset = stmt.executeQuery(msg);
							if(messageResultset != null)
							{
								if(messageResultset.next())
								{
									code	= messageResultset.getString("message_id");
									message = messageResultset.getString("message_text_sysdef");
								}
							} if(messageResultset != null) messageResultset.close();*/

							java.util.Hashtable message = MessageManager.getMessage(locale, "RECORD_INSERTED", "SM");
							error = ((String) message.get("message"));
					   }
					   else
					   {
							con.rollback();
							error_value = 0;
							if(messageResultset != null) messageResultset.close();

							/*String msg = "select message_id, message_text_sysdef from sm_message where message_ref = 'EXCLUDE_DUPLICATE_RECORD'";
							messageResultset = stmt.executeQuery(msg);
							if(messageResultset != null)
							{
								if(messageResultset.next())
								{
									code	= messageResultset.getString("message_id");
									message = messageResultset.getString("message_text_sysdef");
								}
							} if(messageResultset != null) messageResultset.close();*/

							java.util.Hashtable message = MessageManager.getMessage(locale, "EXCLUDE_DUPLICATE_RECORD", "DR");
							error = ((String) message.get("message"));


					   }
					} if(messageResultset != null) messageResultset.close();
					  if(pstmt4 != null) pstmt4.close();

					if(modal != null && modal.equals("Y"))
					{
						

						res.sendRedirect("../eDR/jsp/DRerror.jsp?err_num=" + java.net.URLEncoder.encode(error,"UTF-8") + "&err_value="+error_value );
					}
					else
					{
						

						res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode(error,"UTF-8") + "&err_value="+error_value );
					}
				}
				else 
				{
					con.rollback();
					message="<br>Transaction Failed"+sb.toString();
				
					if(modal != null && modal.equals("Y"))
					{
						

						res.sendRedirect("../eDR/jsp/DRerror.jsp?err_num=" + java.net.URLEncoder.encode(""+code+" "+message+"" ) + "&err_value=0 " );
					}
					else
					{
						

						res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode(""+code+" "+message+"" ) + "&err_value=0 " );
				   }
			    }
			SelectSQL.delete(0,SelectSQL.length());
			if(rs !=null) rs.close();
			if(messageResultset!=null)	messageResultset.close();
			if(stmt != null) stmt.close();
			if(pstmt != null) pstmt.close();
			if(pstmt1 != null) pstmt1.close();
			if(pstmt2 != null) pstmt2.close();
			if(pstmt3 != null) pstmt3.close();
			if(pstmt4 != null) pstmt4.close();
		}catch(Exception e)
		{
			e.printStackTrace();
			try 
			{
				con.rollback();
				out.println("Exception raise by Servlet .in insert_dr_dup_group_dtls method : "+e.toString());
			}catch(Exception de){out.println("Exception while Rollback :"+de);}
		}
	}//E.o method

}//E.o class
