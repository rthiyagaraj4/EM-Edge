/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eFM;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.util.*;
import java.io.*;
import javax.rmi.*;
import javax.naming.*;
import javax.ejb.*;
import webbeans.eCommon.*;
import com.ehis.util.*;



public class FMIPGeneratePullingListServlet extends javax.servlet.http.HttpServlet implements SingleThreadModel
{
	String fm_preferred_date="", to_preferred_date="", fm_nursing_unit_code="", to_nursing_unit_code="", fm_pract_id="";
	String to_pract_id="",	pull_list_yn="", p_gender="";

	String facility_id="",gen_tracer="";
	String p_order_term = "";
	boolean inserted=false;
	String error="",  user_id="", fs_locn_code="",appl_user_id="", err_out="";
	String p_gen_report="",print_pull_list_type="",order_by_pull_list="",print_tel_no="",print_bar_code="",operation_type="" ,p_error_code="";
	String locale			= "" ;
    String p_print_req_slip="";
	String fm_preferred_date1="" ,fm_preferred_datee;
	int p_generated_cnt = 0;
     int p_pull_list_seq=0;
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,java.io.IOException
	{
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		java.io.PrintWriter out = response.getWriter();
		java.util.Properties p=null;
		String client_ip_address="";		
		HttpSession session=request.getSession(false);

		Connection con	=	null;
		Statement stmt	=	null;
		ResultSet rs	=	null;
		CallableStatement statement = null;		
		p = (Properties) session.getValue("jdbc");
		locale = p.getProperty("LOCALE");
		client_ip_address = p.getProperty("client_ip_address");
		try
		{
			con				=	ConnectionManager.getConnection(request);
			facility_id		=	(String)session.getValue("facility_id");
			user_id			=	(String)session.getValue("login_user");	
			stmt			=	con.createStatement();
			fm_preferred_date	= request.getParameter("fm_preferred_date");
			to_preferred_date	= request.getParameter("to_preferred_date");
			fm_nursing_unit_code	= request.getParameter("fm_nursing_unit_code");
			to_nursing_unit_code	= request.getParameter("to_nursing_unit_code");
			fm_pract_id		= request.getParameter("fm_pract_id");
			to_pract_id		= request.getParameter("to_pract_id");
			p_gender		= request.getParameter("p_gender");
			pull_list_yn	= request.getParameter("pull_list_yn");
			fs_locn_code	= request.getParameter("fs_locn_code");	
			appl_user_id	= request.getParameter("appl_user_id");	
			p_gen_report	= request.getParameter("gen_report");
			print_tel_no	= request.getParameter("print_tel_no");
			print_bar_code	= request.getParameter("print_bar_code");
			gen_tracer	         = request.getParameter("gen_tracer");
			operation_type	     = request.getParameter("operation_type");
			order_by_pull_list	 = request.getParameter("order_by_pull_list");
			print_pull_list_type = request.getParameter("print_pull_list_type");			
			p_order_term = request.getParameter("p_order_term");	
			p_print_req_slip = request.getParameter("print_req_slip1");
			


			if(to_preferred_date==null || to_preferred_date.equals("null"))to_preferred_date="";
			if(fm_nursing_unit_code==null || fm_nursing_unit_code.equals("null"))fm_nursing_unit_code="";
			if(to_nursing_unit_code==null || to_nursing_unit_code.equals("null"))to_nursing_unit_code="";
			if(fm_pract_id==null || fm_pract_id.equals("null"))fm_pract_id="";
			if(to_pract_id==null || to_pract_id.equals("null"))to_pract_id="";
			if(p_gender==null || p_gender.equals("null"))p_gender="";
			if(pull_list_yn==null || pull_list_yn.equals("null"))pull_list_yn="N";
			if(fs_locn_code==null || fs_locn_code.equals("null"))fs_locn_code="";
			if(appl_user_id==null || appl_user_id.equals("null"))appl_user_id="";			
			if(gen_tracer==null || gen_tracer.equals("null"))gen_tracer="";		
			if(order_by_pull_list==null || order_by_pull_list.equals("null"))order_by_pull_list="";		
			if(print_tel_no==null || print_tel_no.equals("null"))print_tel_no="N";		
			if(print_bar_code==null || print_bar_code.equals("null"))print_bar_code="N";		
			if(operation_type==null || operation_type.equals("null"))operation_type="N";		
			if(p_print_req_slip==null || p_print_req_slip.equals("null")) p_print_req_slip="N";
			if(p_order_term==null || p_order_term.equals("null"))p_order_term="";	
			
			
			if(fm_preferred_date !=null )
		{
				 fm_preferred_datee=fm_preferred_date;
				fm_preferred_date=DateUtils.convertDate(fm_preferred_date,"DMY",locale,"en");
			 
			}
			else
			{
				fm_preferred_date="";
			fm_preferred_datee="";
			}
				try
			{					
					statement=con.prepareCall("{call generate_fm_ip_pulling_list(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
				
															
					statement.setString( 1,  facility_id);
					statement.setString( 2,  client_ip_address);
					statement.setString( 3,  user_id);
					statement.setString( 4,  fs_locn_code);
					statement.setString( 5,  appl_user_id);
					statement.setString( 6,  fm_preferred_date);
					statement.setString( 7,  fm_preferred_date);
					statement.setString( 8,  fm_nursing_unit_code);
					statement.setString( 9,  to_nursing_unit_code);
					statement.setString( 10, fm_pract_id);
					statement.setString( 11, to_pract_id);
					statement.setString( 12, p_gender);
					statement.registerOutParameter( 13,java.sql.Types.VARCHAR);
					statement.registerOutParameter( 14,java.sql.Types.INTEGER);
					statement.registerOutParameter( 15,java.sql.Types.VARCHAR);
						statement.registerOutParameter( 16,java.sql.Types.INTEGER);
					statement.execute() ;
					err_out = statement.getString(13);
					p_generated_cnt = statement.getInt(14);
					p_error_code = statement.getString(15);	       
				    p_pull_list_seq  = statement.getInt(16);	
							
				if(err_out.equals("1"))
				{
					inserted=true;
					error="";
					if (p_generated_cnt > 0)
					{
						/*String sql2 = "select message_id, MESSAGE_TEXT_SYSDEF FROM SM_MESSAGE WHERE MESSAGE_REF='GEN_PULL_FILES_INCLUDED'";
						rs=stmt.executeQuery(sql2);			
						while(rs!=null&&rs.next())
						{										
							error = "APP-"+rs.getString(1)+" "+p_generated_cnt+" "+rs.getString(2);
						}
							if (rs != null) rs.close();*/
					/*		Hashtable message = MessageManager.getMessage(locale, "GEN_PULL_FILES_INCLUDED","FM" ) ;
							error	= (String) message.get("message") ;	
							String p_generated_cnt_s=Integer.toString(p_generated_cnt);
							error = error.replace("$",p_generated_cnt_s); */

					     Hashtable message = MessageManager.getMessage(locale, "GEN_PULL_FILES_INCLUDED","FM" ) ;
							error	= (String) message.get("message") ;	
							String p_generated_cnt_s=Integer.toString(p_generated_cnt);
							error = error.replace("$",p_generated_cnt_s);
				     //	out.println("<script>alert('"+error+"');</script>");
						
						out.println("<script>parent.frames[1].frames[1].doOnlineReportPrinting('"+error+"','"+fm_preferred_datee+"','"+to_preferred_date+"','"+fm_nursing_unit_code+"','"+to_nursing_unit_code+"','"+fm_pract_id+"','"+to_pract_id+"','"+p_gender+"','"+pull_list_yn+"','"+fs_locn_code+"','"+appl_user_id+"','"+p_gen_report+"','"+print_tel_no+"','"+print_bar_code+"','"+gen_tracer+"','"+operation_type+"','"+order_by_pull_list+"','"+print_pull_list_type+"','"+p_order_term+"','"+p_pull_list_seq+"','"+p_print_req_slip+"');</script>");
					    message.clear();	
					
					
					}
					else
					{
						/*String sql1 = "select message_id, MESSAGE_TEXT_SYSDEF FROM SM_MESSAGE WHERE MESSAGE_REF='GEN_PULL_NO_FILE_INCLUDED'";
						rs=stmt.executeQuery(sql1);			
						while(rs!=null&&rs.next())											
							error= 	"APP-"+rs.getString(1)+" "+rs.getString(2);*/
						Hashtable message1 = MessageManager.getMessage(locale, "GEN_PULL_NO_FILE_INCLUDED","FM" ) ;
						error	= (String) message1.get("message") ;
                       out.println("<script>alert('"+error+"');parent.frames[1].frames[1].document.forms[0].print_pull_list_type.value='M';parent.frames[1].frames[1].document.forms[0].print_pull_list_type.focus();parent.frames[1].frames[1].document.forms[0].generate.disabled=false;parent.frames[1].frames[1].document.all.calend.style.display='inline';	parent.frames[1].frames[1].document.forms[0].fm_preferred_date.readOnly=true;parent.frames[1].frames[1].document.forms[0].fm_preferred_date.value=parent.frames[1].frames[1].document.forms[0].to_appt_date_disp.value;</script>");
                          error="";
						 out.println("<html><script>location.href =\"../eCommon/jsp/error.jsp?err_num=" +java.net.URLEncoder.encode( error,"UTF-8" )+"&err_value=0"+"\"</script><body class='message'></html>");
					     message1.clear();	
					}					
					con.commit();
				/*	if (p_generated_cnt > 0)
					{
						if (p_gen_report.equals("Y") )
							doOnlineReportPrinting(request,response,"FMBMRPLI",locale);
						if (gen_tracer.equals("Y"))
							doOnlineReportPrinting(request,response,"FMBATRCI",locale);
						 if (p_print_req_slip.equals("Y"))
						{
							 doOnlineReq_file_ReportPrinting(request,response,"FMFLRQSL",locale);
						   	}	
							
					}	 */					
				//	if (p_generated_cnt > 0)
				//	    {
				/*	out.println("<html><script>location.href =\"../eCommon/jsp/error.jsp?err_num=" +java.net.URLEncoder.encode( error,"UTF-8" )+"&err_value=1"+"\"</script><body class='message'></html>");
						}
				         else{
                           out.println("<script>alert('"+error+"');parent.frames(1).frames(1).document.forms(0).print_pull_list_type.value='M';parent.frames(1).frames(1).document.forms(0).print_pull_list_type.focus();parent.frames(1).frames(1).document.forms(0).generate.disabled=false;parent.frames(1).frames(1).document.all.calend.style.display='inline';	parent.frames(1).frames(1).document.forms(0).fm_preferred_date.readOnly=true;parent.frames(1).frames(1).document.forms(0).fm_preferred_date.value=parent.frames(1).frames(1).document.forms(0).to_appt_date_disp.value;</script>");
                          error="";
						 out.println("<html><script>location.href =\"../eCommon/jsp/error.jsp?err_num=" +java.net.URLEncoder.encode( error,"UTF-8" )+"&err_value=0"+"\"</script><body class='message'></html>");
						} */
				
		  
				  }
				else if(err_out.equals("0"))
				{
					error=err_out;
					error = error+" "+p_error_code;				
					inserted=false;					
					con.rollback();					
					out.println("<html><script>location.href =\"../eCommon/jsp/error.jsp?err_num=" +java.net.URLEncoder.encode( error,"UTF-8" )+"&err_value=0"+"\"</script><body class='message'></html>");
				}			
			}
			catch(Exception e)
			{
				out.println("Exception in calling procedure "+e.toString());
				e.printStackTrace();
			}
			//}
			if(stmt != null)stmt.close();
			if(rs != null)rs.close();
			if(statement != null)statement.close();
	}
	catch(Exception e)
		{
			out.println("Exception in main try"+e);
			e.printStackTrace();
		}
		finally
		{				
			ConnectionManager.returnConnection(con, request);			
		}
	}//end of doPost
/*public synchronized void doOnlineReportPrinting( HttpServletRequest req, HttpServletResponse res,String p_report_id, String locale )
{
	java.io.PrintWriter out = null;
	try
	{
		out = res.getWriter();
		String 	rs_report_id = p_report_id;		
		String ReportOutput="";

		if(fm_preferred_date!=null){
			fm_preferred_date1= DateUtils.convertDate(fm_preferred_date,"DMY","en",locale);
		}else{
			fm_preferred_date1="";
		}

		ecis.utils.OnlineReport report1=null;
			ecis.utils.OnlineReports onlineReports 	= new ecis.utils.OnlineReports() ;
				
                report1= new ecis.utils.OnlineReport( facility_id, "FM",rs_report_id) ;			
				report1.addParameter( "p_facility_id",facility_id ) ;
				report1.addParameter("p_user_name",user_id);
				report1.addParameter("p_report_id",rs_report_id);
				report1.addParameter("p_fm_nursing_unit_code",fm_nursing_unit_code);
				report1.addParameter("p_to_nursing_unit_code",to_nursing_unit_code);
				report1.addParameter("p_fm_pract_id",fm_pract_id);
				report1.addParameter("p_to_pract_id",to_pract_id);
				report1.addParameter("p_gender",p_gender);
				report1.addParameter("p_preferred_date",fm_preferred_date1);
				report1.addParameter("p_module_id","FM");
				report1.addParameter("p_src_fs_locn_code",fs_locn_code);
				report1.addParameter("p_status",print_pull_list_type);
				report1.addParameter("p_appl_user_id",appl_user_id);				
                report1.addParameter("p_call_from","GENERATE_PULLING_LIST");	
		       	report1.addParameter("ORDER_BY",order_by_pull_list);				
				report1.addParameter("P_T_NAME","FM_IP_PULLING_LIST");				
				report1.addParameter("p_print_tel_no",print_tel_no);				
				report1.addParameter("print_bar_code",print_bar_code);				
				report1.addParameter("p_order_term",p_order_term);
				report1.addParameter("P_LANGUAGE_ID",locale);
			
				onlineReports.add(report1);
		 ReportOutput = onlineReports.execute( req, res );
	   	}
	catch ( Exception e )
	{
		out.println("Encountered error while Processing Online Reports "+e);
		e.printStackTrace();
	}
}
	
 // END OF THE METHOD........

public synchronized void doOnlineReq_file_ReportPrinting( HttpServletRequest req, HttpServletResponse res,String p_report_id, String locale )
{
	java.io.PrintWriter out = null;
	try
	{
		out = res.getWriter();
		String 	rs_report_id = p_report_id;	
		String ReportOutput = "";
       				
				if(fm_preferred_date!=null){
					fm_preferred_date1= DateUtils.convertDate(fm_preferred_date,"DMY","en",locale);
				}else{
					fm_preferred_date1="";
				}

		       ecis.utils.OnlineReports onlineReports 	= new ecis.utils.OnlineReports() ;
				ecis.utils.OnlineReport report1= new ecis.utils.OnlineReport(facility_id,"FM",rs_report_id,"F",fs_locn_code) ;
	        					
				report1.addParameter( "p_facility_id",facility_id ) ;
				report1.addParameter("p_user_name",user_id);
				report1.addParameter("p_report_id",rs_report_id);
				report1.addParameter("p_fm_nursing_unit_code",fm_nursing_unit_code);
				report1.addParameter("p_to_nursing_unit_code",to_nursing_unit_code);
				report1.addParameter("p_fm_pract_id",fm_pract_id);
				report1.addParameter("p_to_pract_id",to_pract_id);
				report1.addParameter("p_gender",p_gender);
				report1.addParameter("p_preferred_date",fm_preferred_date1);
				report1.addParameter("p_module_id","FM");
				report1.addParameter("p_src_fs_locn_code",fs_locn_code);
				report1.addParameter("p_status",print_pull_list_type);
				report1.addParameter("P_PULL_LIST_TYPE",print_pull_list_type);
				report1.addParameter("p_appl_user_id",appl_user_id);
		        report1.addParameter("p_call_from","GENERATE_IP_PULLING_LIST");	
		        report1.addParameter("ORDER_BY",order_by_pull_list);				
				report1.addParameter("P_T_NAME","FM_PULLING_LIST");				
				report1.addParameter("p_print_tel_no",print_tel_no);				
				report1.addParameter("print_bar_code",print_bar_code);				
				report1.addParameter("p_order_term",p_order_term);
				report1.addParameter("P_LANGUAGE_ID",locale);
				onlineReports.add( report1) ;
				ReportOutput = onlineReports.execute( req, res ); 			
				
				
				}
	catch ( Exception e )
	{
		out.println("Encountered error while Processing Online Reports "+e);
		e.printStackTrace();
	} 
	
} */

















}//end of Main class



		
