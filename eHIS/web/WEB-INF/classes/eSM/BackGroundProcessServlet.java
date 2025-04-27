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
import java.text.*;
import webbeans.eCommon.*;
import com.ehis.util.*;

public class BackGroundProcessServlet extends javax.servlet.http.HttpServlet{
		PrintWriter out;
		String job;
		String proc_id;
		String proc_name;
		String next_execution_date;
		String interval;
		String job_type;
		String proc_srt_cmd;
		String error="";
		HttpSession session;
		String locale;
		Properties p;
		Connection con=null;
		CallableStatement cs1 = null;
		CallableStatement cs = null;

		public void init(ServletConfig config) throws ServletException
		{
			super.init(config);
		}
		public synchronized void doPost(HttpServletRequest req, HttpServletResponse res)
				throws javax.servlet.ServletException,IOException
		{
			req.setCharacterEncoding("UTF-8");
		    res.setContentType("text/html;charset=UTF-8");
			session = req.getSession(false);
			this.p = (Properties) session.getValue( "jdbc" ) ;
			locale = p.getProperty("LOCALE");
			try
			{
				
		

				String proc_srt_cmd_con=req.getParameter("proc_srt_cmd");
				String isConOGGApplicable=req.getParameter("isConOGGApplicable");
				


					if(proc_srt_cmd_con==null) proc_srt_cmd_con="";

				if(proc_srt_cmd_con.equals("dr_process;") && isConOGGApplicable.equals("true")){
					con = ConnectionManager.getConnectionOGG(req);					
				}else{
					con = ConnectionManager.getConnection(req);
				}
				if ( con.getAutoCommit() == true )
				con.setAutoCommit(false);
				this.out = res.getWriter();
				modify(req);
			}catch (Exception e)
			{
				e.printStackTrace();
				
				System.err.println("BackGroundProcessServlet line 72"+e.toString());
				out.println(e.toString());
				
			}
		}
		private void modify(HttpServletRequest req)	{
			try {
					job=req.getParameter("job");
					if(job==null) job="0";
					proc_id=req.getParameter("procid");
					if(proc_id==null) proc_id="";
					proc_name=req.getParameter("proc_name");
					if(proc_name==null) proc_name="";
					next_execution_date=req.getParameter("next_execution_date");
					next_execution_date=DateUtils.convertDate(next_execution_date,"DMYHM",locale,"en");
					if(next_execution_date==null) next_execution_date="";
                   	//next_execution_date = DateUtils.convertDate(next_execution_date,"DMYHM",locale,"en");
					proc_srt_cmd=req.getParameter("proc_srt_cmd");
					if(proc_srt_cmd==null) proc_srt_cmd="";
                    if(proc_srt_cmd.indexOf(";") == -1)
						proc_srt_cmd=proc_srt_cmd+";" ;
					interval=req.getParameter("interval");
					job_type=req.getParameter("job_type");
					int job1=0;
					if(job!=null &&   !job.equals("")  ) {
						 job1=Integer.parseInt(job);
					}

					if(interval!=null && !interval.equals("") )	{

					interval="sysdate+"+interval+"/1440";
					}
					else{
					interval="null";
					}

				try{
					int job_status=0;
					if (job_type.equals("S")) {
					cs1 = con.prepareCall( "{ call CHK_JOB_QUEUE(?, ?)}");
					cs1.setString ( 1,proc_srt_cmd   ) ;
					cs1.registerOutParameter( 2,  Types.INTEGER ) ;
					cs1.execute();
					job_status=cs1.getInt(2);
					cs1.close();
					if(job_status>0)
					{
						MessageManager mm = new MessageManager();
		                final java.util.Hashtable mesg = mm.getMessage(locale, "JOB_ALREADY_IN_QUEUE","SM");
		                error=(String)mesg.get("message");
			            out.println("<script>alert('"+error+"')</script>");
						mesg.clear();
					}
					else
					{
						cs = con.prepareCall( "{ call DBMS_JOB.SUBMIT(?,?,to_date('"+next_execution_date+"','dd/mm/yyyy hh24:mi'),?,false) }" ) ;
						cs.registerOutParameter( 1,  Types.INTEGER ) ;
						cs.setString ( 2,proc_srt_cmd   ) ;
						cs.setString ( 3,interval) ;
						cs.execute();
						con.commit();
						MessageManager mm = new MessageManager();
		                final java.util.Hashtable mesg = mm.getMessage(locale, "RECORD_INSERTED","SM");
		                error=(String)mesg.get("message");
						mesg.clear();
					}
				}
				else if (job_type.equals("C"))
				{
					boolean proces_chck			= true;
					PreparedStatement prc_chk = null;
					ResultSet rs				=null;
					String sql="select count(*) cnt  from sm_jobs_vw where   proc_id='"+proc_id+"'";
					prc_chk=con.prepareStatement(sql);
					rs=prc_chk.executeQuery();
					rs.next();
					if(rs.getInt("cnt")==0)
					proces_chck=false;
					if(rs!=null)
					rs.close();
					if(prc_chk!=null)
					prc_chk.close();
					if(proces_chck){
					if(cs!=null) cs.close();
					cs = con.prepareCall( "{ call DBMS_JOB.CHANGE(?,?,to_date('"+next_execution_date+"','dd/mm/yyyy hh24:mi'),?) }" ) ;
					cs.setInt	( 1,job1  ) ;
					cs.setString ( 2,proc_srt_cmd   ) ;
					cs.setString ( 3,interval) ;
					cs.execute() ;
					cs.close();
					con.commit();
					MessageManager mm = new MessageManager();
		            final java.util.Hashtable mesg = mm.getMessage(locale, "RECORD_INSERTED","SM");
		            error=(String)mesg.get("message");
					mesg.clear();
					}else{
					MessageManager mm = new MessageManager();
		            final java.util.Hashtable mesg = mm.getMessage(locale, "JOB_DOESNOT_EXIST","SM");
		            error=(String)mesg.get("message");
					mesg.clear();
					}
				}
				else if (job_type.equals("R"))
				{
					cs = con.prepareCall( "{ call DBMS_JOB.REMOVE(?) }" ) ;
					cs.setInt	( 1,job1  ) ;
					cs.execute();

					if (proc_id.equals("Drbmerge"))
					{
						String sql4 = "update dr_dup_group_hdr set marked_for_merge_yn='N' where marked_for_merge_yn='Y'";
						PreparedStatement pstmt4=con.prepareStatement(sql4);
						con.commit();
						if (pstmt4 != null)
						{
							pstmt4.close();
						}
					}
					else
					{
						String sql=" update dr_process_ctl set proc_status='AB' ";
						String sql1="insert into dr_process_log (proc_id,search_submit_date,search_submit_by_id,search_schedule_date,search_start_date,search_end_date,search_status,merge_submit_date,merge_submit_by_id,merge_schedule_date,merge_start_date,merge_end_date,merge_status,proc_status,initiating_function_id,added_by_id,added_date,added_at_ws_no,added_facility_id,modified_by_id,modified_date,modified_at_ws_no,modified_facility_id,search_facility_id,search_type,search_ws_no,merge_facility_id,merge_ws_no) (select proc_id,search_submit_date,search_submit_by_id,search_schedule_date,search_start_date,search_end_date,search_status,merge_submit_date,merge_submit_by_id,merge_schedule_date,merge_start_date,merge_end_date,merge_status,proc_status,initiating_function_id,added_by_id,added_date,added_at_ws_no,added_facility_id,modified_by_id,modified_date,modified_at_ws_no,modified_facility_id,search_facility_id,search_type,search_ws_no,merge_facility_id,merge_ws_no from dr_process_ctl)";
						String sql2= "delete from dr_dup_group_dtls ";
						String sql3= "delete from dr_dup_group_hdr ";
						PreparedStatement pstmt=con.prepareStatement(sql);
						PreparedStatement pstmt1=con.prepareStatement(sql1);
						PreparedStatement pstmt2=con.prepareStatement(sql2);
						PreparedStatement pstmt3=con.prepareStatement(sql3);
					try
						{
						con.commit();
						if (pstmt != null)
						{
							pstmt.close();
						}
						if (pstmt1 != null)
						{
							pstmt1.close();
						}

						if (pstmt2 != null)
						{
							pstmt2.close();
						}
						if (pstmt3 != null)
						{
							pstmt3.close();
						}
						}
						catch(Exception e)
						{
							e.printStackTrace();
							System.err.println("BackGroundProcessServlet line 228"+e.toString());
						}
					}

					MessageManager mm = new MessageManager();
		            final java.util.Hashtable mesg = mm.getMessage(locale, "RECORD_INSERTED","SM");
		            error=(String)mesg.get("message");
					mesg.clear();
				}
				else if (job_type.equals("E"))
				{
					MessageManager mm = new MessageManager();
		            final java.util.Hashtable mesg = mm.getMessage(locale, "JOB_IS_RUNNING","SM");
		            error =(String)mesg.get("message");
			        out.println("<script>alert('"+error+"')</script>");
					out.println("job_type"+job_type);
					out.println("<html><script>location.href =\"../eCommon/jsp/error.jsp?err_num=" +java.net.URLEncoder.encode( error, "UTF-8"  )+"&err_value=1"+"\"</script><body class='message'></html>");
					cs = con.prepareCall( "{ call DBMS_JOB.RUN(?) }" ) ;
					cs.setInt	( 1,job1  ) ;
					cs.execute() ;
					con.commit();
					mesg.clear();
					MessageManager mm1 = new MessageManager();
		            final java.util.Hashtable mesg1 = mm1.getMessage(locale, "RECORD_INSERTED","SM");
		            error=(String)mesg1.get("message");
					mesg1.clear();
				}

		}
		catch(Exception e)
		{	
			e.printStackTrace();
			System.err.println("BackGroundProcessServlet line 260"+e.toString());
			out.println(e.toString());
			con.rollback();
			con.setAutoCommit(true);
			
			error="APP-SP1000 Transaction Failed...."+e.toString();
			System.err.println("<html><script>location.href =\"../eCommon/jsp/error.jsp?err_num=" +java.net.URLEncoder.encode( error, "UTF-8"  )+"&err_value=0"+"\"</script><body class='message'></html>");
			out.println("<html><script>location.href =\"../eCommon/jsp/error.jsp?err_num=" +java.net.URLEncoder.encode( error, "UTF-8"  )+"&err_value=0"+"\"</script><body class='message'></html>");
		}
			out.println("<html><script>location.href =\"../eCommon/jsp/error.jsp?err_num=" +java.net.URLEncoder.encode( error, "UTF-8"  )+"&err_value=1"+"\"</script><body class='message'></html>");


		}catch( Exception e)
		{
				e.printStackTrace();
				System.err.println("<h3> BackGroundProcessServlet Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
				out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
				out.println( "Values sent are : <br>" ) ;


		}
			finally
				{
					try{
					if(cs1 != null)cs1.close();
					if(cs != null)cs.close();
					ConnectionManager.returnConnection(con,req);
					}catch(Exception e)
					{
						e.printStackTrace();
						System.err.println("Exception in Finally--> : "+e.toString());
						out.println("<script>alert('Exception in Finally')</script>");
						
					}
				}
			}//E.O.Method
		}
