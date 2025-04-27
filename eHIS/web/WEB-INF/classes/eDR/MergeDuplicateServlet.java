/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*////////////////////////////////////////////////////////////////////////
	Developed By       : Shyam Prasad.P
	Module Name 	   : eHIS/dr
	Function Name	   : MergeDuplicateServlet

*//////////////////////////////////////////////////////////////////////////
package eDR;
import java.sql.*;
import java.io.*;
import java.text.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import webbeans.eCommon.*;

public class MergeDuplicateServlet extends javax.servlet.http.HttpServlet
{
	PrintWriter out;
	java.util.Properties p;
	HttpSession session;

	Connection con						= null;
	Statement stmt						= null;
	ResultSet messageResultset          = null;
	PreparedStatement pstmt				= null;
	
	ResultSet rs						= null;

	String client_ip_address			= "";
	String facilityId					= "";
	
	String dup_group_id					= "";
	String p_line						= "";
	
	String addedById					= "";
	String modifiedById					= "";
	String addedFacilityId				= "";
	String modifiedFacilityId			= "";
	String addedAtWorkstation			= "";
	String modifiedAtWorkstation		= "";
	String error_value					= "";
	String final_chk_values				= "";
	String sqlinsert					= "";
	String code							= "";
	String message						= "";
	String sqlupdate					= "";
	String process_start				= "";
	String process_start_time			= "";
	String modal						= "";
	String pat_group_id					= "";
	
	String status						= "";
	String  scdate						= "";
	String  group_dup_status			= "";
	String job_ctrl_no					= "";
	String sStyle                       = "";
	String pendingJobCtrlNo				= "";//Added By Dharma 
	int pendingHrs						= 0;//Added By Dharma
	int resetIncompJobHrs				= 0;//Added By Dharma
	CallableStatement cstmt				= null;//Added By Dharma


	int total							= 0;
	int updateres						= 0;

	boolean commit_flag		 		    = true;
	boolean proceed		 		        = false;



	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	}
	public synchronized void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{

		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
		session					= req.getSession(false);
		this.facilityId			= (String) session.getValue("facility_id" ) ;
		this.p					= (java.util.Properties) session.getValue( "jdbc" ) ;
		sStyle	=
        	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		this.client_ip_address  = p.getProperty("client_ip_address");
		try
		{
			con	= ConnectionManager.getConnection(req);

			con.setAutoCommit(false);

			String locale = p.getProperty("LOCALE");
			
			stmt=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
			this.out					= res.getWriter();
			modal						= req.getParameter("modal");
			final_chk_values			= req.getParameter("p_final_dup_group_id");
			addedById					= p.getProperty("login_user") ;
			modifiedById				= addedById ;
			addedFacilityId				= facilityId;
			modifiedFacilityId	        = addedFacilityId ;
			addedAtWorkstation	        = client_ip_address;
			modifiedAtWorkstation       = addedAtWorkstation ;
			process_start			    = req.getParameter("process_start");

			process_start_time			= req.getParameter("start_later_time")==null?"":req.getParameter("start_later_time");
            if(!process_start_time.equals(""))
				process_start_time=com.ehis.util.DateUtils.convertDate(process_start_time,"DMYHM",locale,"en");

			p_line						= req.getParameter("p_line1");

			if(final_chk_values==null)
				final_chk_values="";

			if(p_line==null)
				p_line="";
			if(process_start_time==null || process_start_time.equals("null"))
			process_start_time		="";

			String parameter_check_Sql="";
			String parameter_check="";
			if(!process_start_time.equals(""))

			parameter_check_Sql = " SELECT (CASE WHEN TO_DATE(TO_CHAR(TO_DATE('"+process_start_time+"', 'DD/MM/YYYY HH24:MI'),'HH24:MI'),'HH24:MI')  BETWEEN TO_DATE (TO_CHAR (exec_start_time, 'HH24:MI'), 'HH24:MI') AND TO_DATE (TO_CHAR (exec_end_time,'HH24:MI'),'HH24:MI') THEN 'Y' ELSE 'N' END ) parameter_check FROM dr_param ";
			else
			parameter_check_Sql="SELECT (CASE WHEN TO_CHAR(sysdate ,'HH24:MI') BETWEEN  TO_CHAR (exec_start_time, 'HH24:MI') AND  TO_CHAR (exec_end_time,'HH24:MI') THEN 'Y' ELSE 'N' END ) parameter_check FROM dr_param";


			//stmt=con.createStatement();
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
				String error	=	(String) message.get("message");
				error_value= "0";


				res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8" ) + "&err_value=" + error_value );
				proceed = false;
				message.clear();

			}

			if(proceed)
			{
				if(!(process_start.equals("process_later")))
				   insert_dr_merge_start_now(req,res);
				else
				   insert_dr_merge_start_later(req,res);
			}

		if(stmt!=null) stmt.close();
		if(rs!=null) rs.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			out.println("Exception occured in post"+e.toString());
		}
		finally
		{
			ConnectionManager.returnConnection(con, req);
		}

}
 public synchronized void insert_dr_merge_start_now(HttpServletRequest req, HttpServletResponse res)
 {
	  try
		{
			String locale = p.getProperty("LOCALE");


			//String sqlchkjob="select count(*) total from dr_job_control where status='R'";
			String sqlchkjob="select job_ctrl_no,exec_start_date, ROUND((24*(sysdate-EXEC_START_DATE))) hours, (SELECT NVL (reset_incomp_job_hrs, 0) FROM dr_param) reset_incomp_job_hrs from dr_job_control where status='R'";

			stmt=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);

			if(rs!=null) rs.close();
			rs=stmt.executeQuery(sqlchkjob);
			if(rs !=null)
			{
					while(rs.next())
					{
					   //total=rs.getInt(1);
					   
					    total					 = 1;
						pendingJobCtrlNo		 = rs.getString("job_ctrl_no");  // Added By Dharma
						pendingHrs				 = rs.getInt("hours");  // Added By Dharma
						resetIncompJobHrs		 = rs.getInt("reset_incomp_job_hrs");  // Added By Dharma
						
					}

			}if (rs != null) rs.close();

			/*Added By Dharma Start*/
			String jobStatus		= "IDLE";
			String sqlChkStatus		= "SELECT nvl(upper(status),'IDLE') status FROM sm_jobs_vw where proc_id='DRBMERGE'";
			rs=stmt.executeQuery(sqlChkStatus);
			if(rs !=null) {
				while(rs.next()) {
					jobStatus=rs.getString("status");
				}
			}
			if (rs != null) rs.close();

			if(jobStatus.equals("IDLE") && !pendingJobCtrlNo.equals("") && pendingHrs >= resetIncompJobHrs) {
				cstmt=con.prepareCall("{call dr_reset_incomp_job(?,?)}");
				cstmt.setString(1,pendingJobCtrlNo);
				cstmt.registerOutParameter(2,java.sql.Types.VARCHAR);
				cstmt.execute();	
				String returnValue	= cstmt.getString(2);
				
				if(returnValue.equals("U") || returnValue.equals("D"))
					total	= 0;
			}
			/*Added By Dharma End*/



			if(total >0)
			{
					java.util.Hashtable message = MessageManager.getMessage(locale, "SEARCH_MERGE_JOB_EXISTS", "DR");
				    String error = ((String) message.get("message"));
				    res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode(error,"UTF-8") + "&err_value=0 " );
			}
			else
		    {
					String sqlcount="select count(*) from dr_job_control where to_date(to_char(scheduled_date,'dd/mm/yyyy hh24:mi'),'dd/mm/yyyy hh24:mi') = to_date(to_char(sysdate,'dd/mm/yyyy hh24:mi'),'dd/mm/yyyy hh24:mi')";

					rs=stmt.executeQuery(sqlcount);
					int maxrecord=0;
					while(rs.next())
					{
						maxrecord=rs.getInt(1);
					}



					if(maxrecord >0)
					{
						java.util.Hashtable message = MessageManager.getMessage(locale, "SEARCH_MERGE_JOB_EXISTS", "DR");
						String error = ((String) message.get("message"));
						res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode(error,"UTF-8") + "&err_value=0 " );
					}
					else
					{
						String sysdate1="select to_char(sysdate,'dd/mm/yyyy hh24:mi') from dual";

						if(rs!=null) rs.close();
						rs=stmt.executeQuery(sysdate1);
						if(rs !=null)
						{
							while(rs.next())
							{
								scdate=rs.getString(1);
							}
							if (rs != null) rs.close();
						}

						 commit_flag=Updateval();
						 displayResult(commit_flag);
	   			 }
			}

		if(stmt!=null) stmt.close();
		if(cstmt!=null) cstmt.close(); //Added for checkstyle
		
		}

	catch(Exception e)
	 {
		e.printStackTrace();
		try
		{
			con.rollback();
		}
		catch(Exception ee){
			e.printStackTrace();
			out.println("Exception occured in MergeDuplicateServlet"+e.toString());
		}


	}
	finally
	{
		ConnectionManager.returnConnection(con,req);
	}
}

public synchronized void insert_dr_merge_start_later(HttpServletRequest req, HttpServletResponse res)
{
  try
	{
		String locale = p.getProperty("LOCALE");


		
		java.text.SimpleDateFormat df = new java.text.SimpleDateFormat("dd/MM/yyyy HH:mm");
		java.util.Date scdatetxt=df.parse(process_start_time);
		
		String sqlcount="select max(to_char(scheduled_date,'dd/mm/yyyy hh24:mi'))maxscdate,to_char(sysdate,'dd/mm/yyyy hh24:mi')sysdate1 from dr_job_control";
		if(stmt!=null) stmt.close();
		stmt=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
		if(rs!=null) rs.close();
		rs=stmt.executeQuery(sqlcount);
		String maxscddate = "";
		String sysdate1   = "";
		rs.last();
		
		rs.beforeFirst();
		if(rs.next())
		{
			maxscddate =rs.getString(1);
		    sysdate1=rs.getString(2);


		}


		 if(maxscddate==null) maxscddate=sysdate1;
         java.util.Date consch=df.parse(maxscddate);
		 java.util.Date consys=df.parse(sysdate1);
         if(scdatetxt.before(consys) || consch.after(scdatetxt) || scdatetxt.equals(consch))
			{

					if(scdatetxt.before(consys))
					{
						java.util.Hashtable message = MessageManager.getMessage(locale, "START_LATER_TIME", "DR");
						String error = ((String) message.get("message"));

						res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode(""+error+" "+sysdate1+"", "UTF-8" ) + "&err_value=0 " );
					}

					else
					{
					  String sheduleDate = MessageManager.getLabel(locale,"Common.Schedule.label","Common")+" 							"+MessageManager.getLabel(locale,"Common.datetime.label","Common");

					  String dateTime = MessageManager.getLabel(locale, "Common.datetime.label", "Common");

					  java.util.Hashtable message = MessageManager.getMessage(locale, "CANNOT_GREATER", "MP");
					  String error = ((String) message.get("message"));
					  error = error.replace("#",sheduleDate);
					  error = error.replace("$",dateTime);

					  res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode(error,"UTF-8") + "&err_value=0 " );
					}
			  }


		else
		{

				commit_flag=Updateval();
				displayResult(commit_flag);
		 }

	 if(stmt!=null) stmt.close();
	 if(rs!=null) rs.close();
	}
	catch(Exception e)
	{
		e.printStackTrace();
		try
		{
			con.rollback();
		}
		catch(Exception ee){
			
			out.println("Exception occured in MergeDuplicateServlet"+e.toString());
			ee.printStackTrace();
		}
	}
	finally
	{
		ConnectionManager.returnConnection(con,req);
	}


 }
 public boolean Updateval()
 {
	 try
     {
		 String pat_dup_group_id = "";
		 String sqljobinc="select DR_JOB_CONTROL_SEQ.nextval from dual";

		 if(rs!=null) rs.close();
		 rs=stmt.executeQuery(sqljobinc);
		 if(rs !=null)
		 {
			while(rs.next())
			{
				job_ctrl_no=rs.getString(1);
			}
			if (rs != null) rs.close();
		 }

		if(!(process_start.equals("process_later")))
	    {
		 sqlinsert="insert into dr_job_control values("+job_ctrl_no+",sysdate,to_date('"+scdate+"','dd/mm/rrrr hh24:mi'),null,null,'"+status+"','"+addedById+"',sysdate,'"+addedAtWorkstation+"','"+addedFacilityId+"','"+modifiedById+"',sysdate,'"+modifiedAtWorkstation+"','"+modifiedFacilityId+"')";


		}
		else
		{
           sqlinsert="insert into dr_job_control values("+job_ctrl_no+",sysdate,to_date('"+process_start_time+"','dd/mm/rrrr hh24:mi'),null,null,'"+status+"','"+addedById+"',sysdate,'"+addedAtWorkstation+"','"+addedFacilityId+"','"+modifiedById+"',sysdate,'"+modifiedAtWorkstation+"','"+modifiedFacilityId+"')";

		}

		int cnt=stmt.executeUpdate(sqlinsert);

		if(cnt >0)
		{

		if(modal.equals("Y"))
		 {
			StringTokenizer getgroupid = new StringTokenizer(p_line, "|");

			while(getgroupid.hasMoreTokens())
			{
				pat_group_id= getgroupid.nextToken();

				sqlinsert="select a.dup_group_id from dr_dup_group_hdr a ,dr_dup_group_dtls b where a.dup_group_id=b.dup_group_id and b.patient_id='"+pat_group_id+"'";

				stmt=con.createStatement();
				if(rs!=null) rs.close();
				rs=stmt.executeQuery(sqlinsert);
				if(rs !=null)
				{
					if (rs.next())
					{
						 pat_dup_group_id=rs.getString("dup_group_id")==null?"":rs.getString("dup_group_id");
					}

				}if (stmt != null) stmt.close();
				if (rs != null) rs.close();

				if(!pat_dup_group_id.equals(""))
					break;
			}
		

			String sqldupgrp1="select group_status from dr_dup_group_hdr where dup_group_id='"+pat_dup_group_id+"'";

			stmt=con.createStatement(); // added this line  for IN016965
           	rs=stmt.executeQuery(sqldupgrp1);
			if(rs.next())
			{
				group_dup_status=rs.getString(1);


			}
			if (rs != null) rs.close();
			if(group_dup_status.equals("I"))
			{
			sqlinsert="";
			sqlinsert="update dr_dup_group_hdr set marked_for_merge_yn='Y', job_ctrl_no="+job_ctrl_no+" ,modified_by_id = '"+modifiedById+"',modified_date = sysdate, modified_at_ws_no = '"+modifiedAtWorkstation+"', modified_facility_id = '"+modifiedFacilityId+"' where dup_group_id='"+pat_dup_group_id+"'";


			pstmt = con.prepareStatement(sqlinsert);
			pstmt.executeUpdate();
			commit_flag = true;
            if(pstmt!=null) pstmt.close();
			}
			else
			{
			  commit_flag = false;
			}


	  }
	  else
	  {

			StringTokenizer indtoken = new StringTokenizer(final_chk_values, "|");
			int count=0;
			while(indtoken.hasMoreTokens() )
			{
				count++;
				dup_group_id		= indtoken.nextToken();
				pstmt=null;
				updateres=0;				
				sqlupdate="";
				sqlupdate="update dr_dup_group_hdr set job_ctrl_no="+job_ctrl_no+", marked_for_merge_yn='Y' ,modified_by_id = '"+modifiedById+"',modified_date = sysdate, modified_at_ws_no = '"+modifiedAtWorkstation+"', modified_facility_id = '"+modifiedFacilityId+"' where dup_group_id='"+dup_group_id+"'";

				pstmt = con.prepareStatement(sqlupdate);
				updateres =pstmt.executeUpdate();
				if(pstmt!=null) pstmt.close();

				if(updateres==0) 	{
					commit_flag = false;
					break;
				} else {
					commit_flag	 = true;
				}
		   }
	 }
	}
	else
	{
		con.rollback();
	}
  if(stmt!=null) stmt.close();
   if(pstmt!=null) pstmt.close();
    if(pstmt!=null) pstmt.close();}
  catch(Exception e)
  {

	  commit_flag=false;
	  e.printStackTrace();
	  try
		{
			con.rollback();
		}
		catch(Exception ee){}
	  out.println("Exception occured in Funtion"+e.toString());
   }
	 return commit_flag;
 }

 public void displayResult(boolean commit_flag)
 {
  try
   {
	  String locale = p.getProperty("LOCALE");

	 if(commit_flag)
	  {

				con.commit();			

				String error= "";
				java.util.Hashtable message = MessageManager.getMessage(locale, "MERGE_PROCESS_JOB", "DR");
				error = ((String) message.get("message"));

				if(modal.equals("Y"))
				{
					out.println("<html><head><link rel='stylesheet' type ='text/css' href='../eCommon/html/"+sStyle+"'></link></head><body class='message'>") ;
					out.println("<script>alert('"+error+"');</script>");
					out.println("<script> parent.location.href='../eCommon/jsp/dmenu.jsp';</script>");
					out.println("<script> location.href='../eCommon/jsp/error.jsp?err_num=&err_value=1';</script>");
					out.println("</body></html>");
				}
				else
				{
					out.println("<html><head><link rel='stylesheet' type ='text/css' href='../eCommon/html/"+sStyle+"'></link></head><body class='message'>") ;
					out.println("<script>alert('"+error+"');</script>");
					out.println("<script> parent.location.reload();</script>");
					out.println("<script> location.href='../eCommon/jsp/error.jsp?err_num=&err_value=1';</script>");
					out.println("</body></html>");
				}

	  }
	  else if(commit_flag==false && modal.equals("Y"))
	  {

					con.rollback();

					out.println("<html><head><link rel='stylesheet' type ='text/css' href='../eCommon/html/"+sStyle+"'></link></head><body class='message'>") ;
					out.println("<script>alert(parent.getMessage('PAT_SHD_BE_IDENTIFIED','DR'));</script>");
					out.println("</body></html>");

	  }
	 else
	 {
				   con.rollback();
				   out.println("Exception occured while updating");

	 }
   if(stmt!=null) stmt.close(); }
   catch(Exception e)
   {
	   e.printStackTrace();
	   try
		{
			con.rollback();
		}
		catch(Exception ee){}
	   out.println("Exception occured in displaying"+e.toString());
   }
}
}

