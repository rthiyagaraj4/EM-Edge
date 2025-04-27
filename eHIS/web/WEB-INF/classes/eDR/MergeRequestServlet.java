/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/**
 *	Developed By       : Sridhar R
 *	Module Name 	   : eHIS/DR
 *	Function Name	   : Manage Scheduled Reqeust 
**/
package eDR;
import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import webbeans.eCommon.*;

public class MergeRequestServlet extends javax.servlet.http.HttpServlet
{
	PrintWriter out;
	//java.util.Properties p;
	HttpSession session;
	String client_ip_address = "";
	java.util.Properties prop;
	Connection con						=null;
	Statement stmt						=null;
	ResultSet rs						=null;
	//String added_at_ws_no = "";
	String added_facility_id = "";
	String modified_by_id = "";
	String modified_at_ws_no = "";
	String modified_facility_id = "";
	String error_value					="0";
	String error						="";
	String currntJobSql = "";
String locale="";
	String next_execute_date="";
	String next_execute_date1=""; //created  by Y.Srinivas for incident 32694
	//String status="";
	String function_name="";
	//String scheduled_date="";
	String job_control_no="";
	//String added_by_id="";
	int job_ctrl_no=0;
	boolean proceed = false;
	 int Running_jobs = 0;
	 int Current_running_jobs = 0;

	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	}

	public synchronized void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
		this.out = res.getWriter();		
		try
		{ 
			con = ConnectionManager.getConnection(req);
			con.setAutoCommit(false);
		
		
		

		session					= req.getSession(false);
		this.prop				= (java.util.Properties)session.getValue("jdbc");
		locale = prop.getProperty("LOCALE");
		this.added_facility_id  = (String)session.getValue("facility_id");
		client_ip_address		= this.prop.getProperty("client_ip_address");
		modified_by_id			= (prop.getProperty("login_user")==null)?"":prop.getProperty("login_user");
		modified_facility_id	= (this.added_facility_id==null)?"":this.added_facility_id;
		modified_at_ws_no		= (client_ip_address==null)?"":client_ip_address;
		function_name			=  checkForNull(req.getParameter("function_name"));
		//scheduled_date          =  checkForNull(req.getParameter("scheduled_date"));
		job_control_no          =  checkForNull(req.getParameter("job_control_no"));
		next_execute_date1      =  checkForNull(req.getParameter("next_execute_date"));  //modified by Y.Srinivas for incident 32694
		next_execute_date       = com.ehis.util.DateUtils.convertDate(next_execute_date1,"DMYHM",locale,"en"); //created  by Y.Srinivas for incident 32694
		//added_by_id				= checkForNull((prop.getProperty("login_user")));
		//added_at_ws_no			= (client_ip_address == null)?"":client_ip_address; 
		job_ctrl_no				=  Integer.parseInt(job_control_no);


		String parameter_check = "N";
		String parameter_check_Sql  = "";
		
			if(!next_execute_date.equals(""))
				
			parameter_check_Sql = " SELECT (CASE WHEN TO_DATE(TO_CHAR(TO_DATE('"+next_execute_date+"', 'DD/MM/YYYY HH24:MI'),'HH24:MI'),'HH24:MI')  BETWEEN TO_DATE (TO_CHAR (exec_start_time, 'HH24:MI'), 'HH24:MI') AND TO_DATE (TO_CHAR (exec_end_time,'HH24:MI'),'HH24:MI') THEN 'Y' ELSE 'N' END ) parameter_check FROM dr_param ";
			else
			parameter_check_Sql="SELECT (CASE WHEN TO_CHAR(sysdate ,'HH24:MI') BETWEEN  TO_CHAR (exec_start_time, 'HH24:MI') AND  TO_CHAR (exec_end_time,'HH24:MI') THEN 'Y' ELSE 'N' END ) parameter_check FROM dr_param";	
					
			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();
			stmt=con.createStatement();
			rs=stmt.executeQuery(parameter_check_Sql);
			if(rs!=null && rs.next())
			{
				parameter_check =	rs.getString("parameter_check");
			}

            
			if(parameter_check.equals("Y"))
			{
				proceed = true;
			}
			else
			{
				java.util.Hashtable message = MessageManager.getMessage(locale, "DR_INVALID_MERGE_TIME" , "DR");
				error	=	(String) message.get("message");
				error_value= "1";


				res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8" ) + "&err_value=" + error_value );			
				proceed = false;
				message.clear();
			}

		

		if(proceed)
		{
			if(function_name.equals("submit")) 
				submit(req, res);
			if(function_name.equals("change"))
				change(req,res);
			if(function_name.equals("remove"))
				remove(req, res);
		}
		  if(rs!=null) rs.close();
		}catch(Exception e1)
		{
			out.println("Exception in parameter_check : "+e1.toString());
		}
		finally
		{				
			ConnectionManager.returnConnection(con, req);			
		}


	}

	private void submit(HttpServletRequest request,HttpServletResponse response)
	{
		 Running_jobs = 0;
		Current_running_jobs = 0;
		try
		{
			 
			

			String jobSql = " select count(1) Running_jobs from DR_JOB_CONTROL where status ='R' ";   
			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();
			
			stmt=con.createStatement();
			rs=stmt.executeQuery(jobSql);
			if(rs!=null && rs.next())
			{
				Running_jobs =	rs.getInt("Running_jobs");
			}

			if(Running_jobs > 0)
			{
				java.util.Hashtable message = MessageManager.getMessage(locale, "SEARCH_MERGE_JOB_EXISTS","DR");
				error	=	(String) message.get("message");

				//error=" Job is already Running....";
				error_value= "1";
				response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8" ) + "&err_value=" + error_value );			
				proceed = false;
				message.clear();
			}
			else
			{
				proceed = true;
			}

			currntJobSql = "";
			if(proceed)
			{
				//currntJobSql = " select count(1) Current_running_jobs from DR_JOB_CONTROL where scheduled_date = sysdate ";
				currntJobSql="select count(*) from dr_job_control where to_date(to_char(scheduled_date,'dd/mm/yy hh24:mi'),'dd/mm/yy hh24:mi') = to_date(to_char(sysdate,'dd/mm/yy hh24:mi'),'dd/mm/yy hh24:mi')";
				
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();
				stmt=con.createStatement();
				rs=stmt.executeQuery(currntJobSql);
				if(rs!=null && rs.next())
				{
					Current_running_jobs =	rs.getInt(1);
				}

				if(Current_running_jobs > 0)
				{
					java.util.Hashtable message = MessageManager.getMessage(locale, "SEARCH_MERGE_JOB_EXISTS", "DR");
					error	=	(String) message.get("message");
  			         error_value= "1";
					response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8" ) + "&err_value=" + error_value );			
					proceed = false;
					message.clear();
				}
				else
				{
					proceed = true;
				}
			}

			if(proceed)
			{
				 String sqlsubmit="";
				 
				 sqlsubmit=" update DR_JOB_CONTROL set scheduled_date = sysdate, modified_date = sysdate, modified_by_id = '"+modified_by_id+"', modified_at_ws_no = '"+modified_at_ws_no+"', modified_facility_id = '"+modified_facility_id+"' where job_ctrl_no = "+job_ctrl_no;
				int j=stmt.executeUpdate(sqlsubmit);
				if(j>0)
				{
					con.commit();
					//java.util.Hashtable message = MessageManager.getMessage(locale, "RECORD_INSERTED","DR");
					java.util.Hashtable message = MessageManager.getMessage(locale, "RECORD_INSERTED", "SM");
					error	=	(String) message.get("message");
					error_value= "1";
					response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode(error,"UTF-8" )+"&err_value="+error_value);
					message.clear();
				}
				else
				{
					con.rollback();
				}
			}
		}catch(Exception e)
		{
			try
			{
				con.rollback();
			}catch(Exception e1)
			{
				out.println("Exception in Roll back"+e1.toString());
			}
		}
		finally
		{
			
			ConnectionManager.returnConnection(con,request);
		}
	}


	private void remove(HttpServletRequest request,HttpServletResponse response)
	{
		try
		{
			//String locale = prop.getProperty("LOCALE");
			

			String sqlDelete=" Delete from DR_JOB_CONTROL where job_ctrl_no = "+job_ctrl_no;
			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();
			stmt=con.createStatement();
			int i=stmt.executeUpdate(sqlDelete);

			if( i > 0 )
			{
				String sqlUpdate = " update DR_DUP_GROUP_HDR set job_ctrl_no = null,MARKED_FOR_MERGE_YN='N', modified_by_id = '"+modified_by_id+"', modified_at_ws_no = '"+modified_at_ws_no+"', modified_facility_id = '"+modified_facility_id+"' where job_ctrl_no = "+job_ctrl_no;
				

				int j=stmt.executeUpdate(sqlUpdate);

				if( j > 0 )
				{
					con.commit();
					java.util.Hashtable message = MessageManager.getMessage(locale, "RECORD_INSERTED","SM");
					error	=	(String) message.get("message");
					error_value= "1";
					response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8" ) + "&err_value=" + error_value );
					message.clear();
				}
				else
					con.rollback();
			}
			else
				con.rollback();
		}catch(Exception e)
		{
			try
			{
				con.rollback();
			}
			catch(Exception e1)
			{
				out.println("Exception in Roll back"+e1.toString());
			}
		}
		finally
		{
			
			ConnectionManager.returnConnection(con,request);
		}
	}

	public static String checkForNull(String inputString)
	{
		return(((inputString == null) || (inputString.equals("null")) ) ? "" : inputString);
	}

	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString == null) || (inputString.equals("null")) ) ? defaultValue : inputString);
	}

private void change(HttpServletRequest request,HttpServletResponse response)
{
		 Running_jobs = 0;
		 Current_running_jobs = 0;
		try
		{
			//String locale = prop.getProperty("LOCALE");
			

            String sys_compare="SELECT (CASE WHEN to_date(to_char(SYSDATE,'dd/mm/rrrr hh24:mi'),'dd/mm/rrrr hh24:mi') >(to_date('"+next_execute_date+"','dd/mm/rrrr hh24:mi')) THEN 'Y' ELSE 'N' END),to_char(sysdate,'dd/mm/yyyy hh24:mi') FROM DUAL ";
			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();
			stmt=con.createStatement();
			rs=stmt.executeQuery(sys_compare);
			String comp_sys="";
			String sysdate1="";
		
			if(rs.next())
			{
			    comp_sys=rs.getString(1);
                sysdate1=rs.getString(2);
			}if (rs != null) rs.close();
			if(comp_sys.equals("Y"))
            {
				//String errors="APP-DR0019 Next Execution Date should be greater Than Sysdate:"+sysdate1;
				java.util.Hashtable message = MessageManager.getMessage(locale, "NEXT_EXE_DATE_GRT_CUR_DATE" , "DR");
				String error	=	(String) message.get("message");
				response.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode(error,"UTF-8") + "&err_value=0 " );
			}
			else
			
			{
			
			String sqlcount="select count(*) from dr_job_control where scheduled_date= to_date('"+next_execute_date+"','dd/mm/yy hh24:mi')";
			if(rs!=null) rs.close();
			rs=stmt.executeQuery(sqlcount);
			int maxrecord=0;
			while(rs.next())
			{
				maxrecord=rs.getInt(1);
			}

			
			if(maxrecord >0)
			 {
			/*	String msg1="select GET_ERROR_MESSAGE('SEARCH_MERGE_JOB_EXISTS') from dual";
				String mess="";
				rs=stmt.executeQuery(msg1);
				if(rs!=null)
				{
					if(rs.next())
					{
						mess=rs.getString(1);
					}
				}
				if (rs != null) rs.close();  */

				java.util.Hashtable message = MessageManager.getMessage(locale, "SEARCH_MERGE_JOB_EXISTS","DR");
				error	=	(String) message.get("message");
					   
				response.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode(error,"UTF-8" ) + "&err_value=0 " );
			
			}
		   else
		    {

				currntJobSql = "";
				String sqlsubmit=" update DR_JOB_CONTROL set scheduled_date = to_date('"+next_execute_date+"', 'DD/MM/YYYY HH24:MI'), modified_date = sysdate, modified_by_id = '"+modified_by_id+"', modified_at_ws_no = '"+modified_at_ws_no+"', modified_facility_id = '"+modified_facility_id+"' where job_ctrl_no = "+job_ctrl_no;
				
				int j=stmt.executeUpdate(sqlsubmit);
				if(j>0)
				{
					con.commit();
					java.util.Hashtable message = MessageManager.getMessage(locale, "RECORD_INSERTED" ,"SM");
					error	=	(String) message.get("message");
					error_value= "1";
					response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8" )+"&err_value="+error_value);
					message.clear();
				}
				else
				{
					con.rollback();
					out.println("Exception occured during Updation");
				}
			}
		}
		if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();}catch(Exception e)
		 {
			out.println("Exception occured"+e.toString());
			try
			{
				con.rollback();
			}catch(Exception e1)
			{
				out.println("Exception in Roll back"+e1.toString());
			}
		}
		finally
		{
			
			ConnectionManager.returnConnection(con,request);
		}
	}
}




		
