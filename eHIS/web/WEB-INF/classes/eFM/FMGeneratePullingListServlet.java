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
import java.lang.reflect.Method;
import java.lang.*;
import java.util.StringTokenizer;
import javax.rmi.*;
import javax.naming.*;
import javax.ejb.*;
import webbeans.eCommon.*;
import com.ehis.util.*;





public class FMGeneratePullingListServlet extends javax.servlet.http.HttpServlet implements SingleThreadModel
{
	String fm_appt_date="", to_appt_date="", fm_clinic_code="", to_clinic_code="", fm_pract_id="";
	String to_pract_id="",	pull_list_yn="", p_gender="";
	
	String facility_id="",gen_tracer="";
	String p_order_term = "";
	boolean inserted=false;
	String error="", user_id="", fs_locn_code="",appl_user_id="", err_out="";
	String p_gen_report="",print_pull_list_type="",order_by_pull_list="",print_tel_no="",print_bar_code="",operation_type="" ,fm_appt_datee="" ,to_appt_datee="" ;
	String locale			= "" ;
	String fm_appt_date1 ="";
    String p_print_req_slip="";
	int p_generated_cnt = 0;
	String error_value = "";
	/*Added for MMS-QH-CRF-0146 [IN:043836] by Dharma on Feb 19th 2014 Start*/
	String start_time	= "";
	String end_time	= "";
	/*Added for MMS-QH-CRF-0146 [IN:043836] by Dharma on Feb 19th 2014 End*/
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
		client_ip_address = p.getProperty("client_ip_address");
		locale = p.getProperty("LOCALE");
		try
		{
			con				=	ConnectionManager.getConnection(request);
			facility_id		=	(String)session.getValue("facility_id");
			user_id			=	(String)session.getValue("login_user");	
			stmt			=	con.createStatement();
			fm_appt_date	= request.getParameter("fm_appt_date");
			to_appt_date	= request.getParameter("to_appt_date");
			fm_clinic_code	= request.getParameter("fm_clinic_code");
			to_clinic_code	= request.getParameter("to_clinic_code");
			fm_pract_id		= request.getParameter("fm_pract_id");
			to_pract_id		= request.getParameter("to_pract_id");
			p_gender		= request.getParameter("p_gender");
			pull_list_yn	= request.getParameter("pull_list_yn");
			fs_locn_code	= request.getParameter("fs_locn_code");	
			appl_user_id	= request.getParameter("appl_user_id");	
			p_gen_report	= request.getParameter("gen_report");
			print_tel_no	= request.getParameter("print_tel_no");
			print_bar_code	= request.getParameter("print_bar_code");
			gen_tracer	= request.getParameter("gen_tracer");
			operation_type	= request.getParameter("operation_type");
			order_by_pull_list	= request.getParameter("order_by_pull_list");
			print_pull_list_type = request.getParameter("print_pull_list_type");			
			p_order_term = request.getParameter("p_order_term");	
			p_print_req_slip = request.getParameter("print_req_slip1");
			/*Added for MMS-QH-CRF-0146 [IN:043836] by Dharma on Feb 19th 2014 Start*/
			start_time		 = (request.getParameter("start_time")==null || request.getParameter("start_time")=="")?"":request.getParameter("start_time");
			end_time		 = (request.getParameter("end_time")==null || request.getParameter("end_time")=="")?"":request.getParameter("end_time");
			/*Added for MMS-QH-CRF-0146 [IN:043836] by Dharma on Feb 19th 2014 End*/
			
			if(fm_appt_date !=null )
			{
				fm_appt_datee=fm_appt_date;
				fm_appt_date=DateUtils.convertDate(fm_appt_date,"DMY",locale,"en");
			
			}
			else
			{
			fm_appt_date="";
			fm_appt_datee="";
			}
			if(to_appt_date!=null )
			{
				to_appt_datee=to_appt_date;
				to_appt_date=DateUtils.convertDate(to_appt_date,"DMY",locale,"en");
			}
			else
			{	
			to_appt_date="";
           to_appt_datee="";
			}
			if(fm_clinic_code==null || fm_clinic_code.equals("null"))fm_clinic_code="";
			if(to_clinic_code==null || to_clinic_code.equals("null"))to_clinic_code="";
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
						
			if (operation_type.equals("print"))
			{
				//doOnlineReportPrinting(request,response,"FMBMRPLA",locale);
			}
            else
			{
			if (print_pull_list_type==null)
			{
				print_pull_list_type="N";
			}
			if (p_gen_report==null)
			{
				p_gen_report="N";
			}
			try
			{
						
					statement=con.prepareCall("{call generate_fm_pulling_list (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
					statement.setString( 1,  facility_id);
					statement.setString( 2,  client_ip_address);
					statement.setString( 3,  user_id);
					statement.setString( 4,  fs_locn_code);					
					statement.setString( 5,  appl_user_id);
					statement.setString( 6,  fm_appt_date);
					statement.setString( 7,  fm_appt_date);
					statement.setString( 8,  fm_clinic_code);
					statement.setString( 9,  to_clinic_code);
					statement.setString( 10, fm_pract_id);
					statement.setString( 11, to_pract_id);
					statement.setString( 12, p_gender);
					statement.setString( 13, start_time);
					statement.setString( 14, end_time);
					statement.registerOutParameter( 15,java.sql.Types.VARCHAR);
					statement.registerOutParameter( 16,java.sql.Types.INTEGER);
					statement.registerOutParameter( 17,java.sql.Types.INTEGER);
					statement.execute() ;
					err_out = statement.getString(15);
					p_generated_cnt = statement.getInt(16);
				   p_pull_list_seq  = statement.getInt(17);
				
				if(err_out.equals("1"))
				{
					inserted=true;
					error="";
					
					
					if (p_generated_cnt > 0)
					{ 
						
						Hashtable message = MessageManager.getMessage(locale, "GEN_PULL_FILES_INCLUDED","FM" ) ;
						error	= (String) message.get("message") ;	
						String p_generated_cnt_s=Integer.toString(p_generated_cnt);
						error = error.replace("$",p_generated_cnt_s);
				     //	out.println("<script>alert('"+error+"');</script>");
						
						out.println("<script>parent.frames[1].frames[1].doOnlineReportPrinting('"+error+"','"+fm_appt_datee+"','"+to_appt_datee+"','"+fm_clinic_code+"','"+to_clinic_code+"','"+fm_pract_id+"','"+to_pract_id+"','"+p_gender+"','"+pull_list_yn+"','"+fs_locn_code+"','"+appl_user_id+"','"+p_gen_report+"','"+print_tel_no+"','"+print_bar_code+"','"+gen_tracer+"','"+operation_type+"','"+order_by_pull_list+"','"+print_pull_list_type+"','"+p_order_term+"','"+p_pull_list_seq+"','"+p_print_req_slip+"');</script>");
                       message.clear();	
						//out.println("<script>location.href =\"../eCommon/jsp/error.jsp?err_num=" +java.net.URLEncoder.encode( error,"UTF-8" )+"&err_value=0"+"\"</script>");
					
					}
					else
					{	
					   	Hashtable message1 = MessageManager.getMessage(locale, "GEN_PULL_NO_FILE_INCLUDED","FM" ) ;
						  error	= (String) message1.get("message") ;
					      out.println("<script>alert('"+error+"');parent.frames[1].frames[1].document.forms[0].print_pull_list_type.value='M'; parent.frames[1].frames[1].document.forms[0].print_pull_list_type.focus();	parent.frames[1].frames[1].document.forms[0].generate.disabled=false;parent.frames[1].frames[1].document.all.calend.style.display='inline';parent.frames[1].frames[1].document.forms[0].fm_appt_date.readOnly=true;	parent.frames[1].frames[1].document.forms[0].fm_appt_date.value=parent.frames[1].frames[1].document.forms[0].to_appt_date_disp.value;</script>");
                    		 error="";
						 out.println("<script>location.href =\"../eCommon/jsp/error.jsp?err_num=" +java.net.URLEncoder.encode( error,"UTF-8" )+"&err_value=0"+"\"</script>");
					     message1.clear();	
					}					
					con.commit();
					
				}
				else if(err_out.equals("0"))
				{
					error=err_out;
					error = "Transaction Failed here";
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
			}
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
}



		
