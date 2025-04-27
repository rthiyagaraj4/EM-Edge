/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eOT;

/*import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import javax.naming.*;
import javax.rmi.*;
import webbeans.eCommon.*;
//import eOT.SwabCount.*; */

import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;
import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.Properties;
import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.Types;
import webbeans.eCommon.ConnectionManager;
import webbeans.eCommon.*;

public class SwabCountServlet extends javax.servlet.http.HttpServlet 
{
	public void init(ServletConfig config) throws ServletException	
	{
		super.init(config);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		Connection connection = null;
		CallableStatement cstmt = null;
		int index=1;
		String error_text = "";
		String status = "";

		PrintWriter out;
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
		HttpSession session=req.getSession(false);
		out=res.getWriter();
		Properties prop = (java.util.Properties) session.getAttribute( "jdbc" ) ;
		String login_at_ws_no = prop.getProperty( "client_ip_address" );
		String locale = prop.getProperty( "LOCALE" );
		String facility_id = (String)session.getAttribute( "facility_id" );
		String oper_num = req.getParameter("oper_num");
		String swab_serial_number = req.getParameter("swab_serial_number");		
		swab_serial_number=swab_serial_number==null?"1":swab_serial_number;
		swab_serial_number=swab_serial_number.equalsIgnoreCase("null")?"1":swab_serial_number;
		String login_user = req.getParameter("login_user");
		login_user = login_user.toUpperCase();
		String no_of_records_str = req.getParameter("no_of_records");
		no_of_records_str=no_of_records_str==null?"0":no_of_records_str;
		no_of_records_str=no_of_records_str.equalsIgnoreCase("null")?"0":no_of_records_str;
		no_of_records_str=no_of_records_str.equals("")?"0":no_of_records_str;
		int no_of_records = Integer.parseInt(no_of_records_str);
		String lang_error_text = "";
		String allwdSwabCntsVal = req.getParameter("allwdSwabCntsVal") == null ? "0" : req.getParameter("allwdSwabCntsVal");
		try
		{
			connection = ConnectionManager.getConnection(req);
			cstmt=connection.prepareCall("{call ot_add_swab_instr_items(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			System.err.println("=========facility_id======SwabCountServlet======"+facility_id);
			System.err.println("=========oper_num======SwabCountServlet======"+oper_num);
			System.err.println("=========swab_serial_number======SwabCountServlet======"+swab_serial_number);
			System.err.println("=========login_user======SwabCountServlet======"+login_user);
			System.err.println("=========first_count_yn======SwabCountServlet======"+(req.getParameter("first_count_yn")).trim());
			System.err.println("=========additions_during_op======SwabCountServlet======"+(req.getParameter("additions_during_op")).trim());
			System.err.println("=========second_count_yn======SwabCountServlet======"+(req.getParameter("second_count_yn")).trim());
			System.err.println("=========third_count_yn======SwabCountServlet======"+(req.getParameter("third_count_yn")).trim());
			System.err.println("=========fourth_count_yn======SwabCountServlet======"+(req.getParameter("fourth_count_yn")).trim());
			System.err.println("=========fifth_count_yn======SwabCountServlet======"+(req.getParameter("fifth_count_yn")).trim());
			System.err.println("=========final_count_yn======SwabCountServlet======"+(req.getParameter("final_count_yn")).trim());

			System.err.println("=========item_stage======SwabCountServlet======"+(req.getParameter("item_stage")).trim());

			System.err.println("=========first_cnt_cmpl_yn======SwabCountServlet======"+(req.getParameter("first_cnt_cmpl_yn")).trim());
			System.err.println("=========additions_during_op_cmpl_yn======SwabCountServlet======"+(req.getParameter("additions_during_op_cmpl_yn")).trim());
			System.err.println("=========second_cnt_cmpl_yn======SwabCountServlet======"+(req.getParameter("second_cnt_cmpl_yn")).trim());
			System.err.println("=========additions_aft_clcav_cmpl_yn======SwabCountServlet======"+(req.getParameter("additions_aft_clcav_cmpl_yn")).trim());

			System.err.println("=========third_cnt_cmpl_yn======SwabCountServlet======"+(req.getParameter("third_cnt_cmpl_yn")).trim());
			System.err.println("=========add_after_third_count======SwabCountServlet======"+(req.getParameter("add_after_third_count")).trim());
			System.err.println("=========fourth_cnt_cmpl_yn======SwabCountServlet======"+(req.getParameter("fourth_cnt_cmpl_yn")).trim());
			System.err.println("=========add_after_fourth_count======SwabCountServlet======"+(req.getParameter("add_after_fourth_count")).trim());
			System.err.println("=========fifth_cnt_cmpl_yn======SwabCountServlet======"+(req.getParameter("fifth_cnt_cmpl_yn")).trim());
			System.err.println("=========add_after_fifth_count======SwabCountServlet======"+(req.getParameter("add_after_fifth_count")).trim());

			System.err.println("=========final_cnt_cmpl_yn======SwabCountServlet======"+(req.getParameter("final_cnt_cmpl_yn")).trim());
			System.out.println("=========allwdSwabCntsVal======SwabCountServlet======"+(req.getParameter("allwdSwabCntsVal")).trim());
			System.err.println("=========reviewed_by======SwabCountServlet======"+(req.getParameter("reviewed_by")).trim());

			for(int rownum=1;rownum<=no_of_records;rownum++)
			{
				System.err.println("=========template_id_======SwabCountServlet======"+(req.getParameter("template_id_"+rownum)).trim());
				System.err.println("=========item_code_======SwabCountServlet======"+(req.getParameter("item_code_"+rownum)).trim());
				System.err.println("=========item_value_======SwabCountServlet======"+(req.getParameter("item_value_"+rownum)).trim());
				System.err.println("=========new_remarks_======SwabCountServlet======"+(req.getParameter("new_remarks_"+rownum)).trim());

				index=1;
				cstmt.setString( index++, facility_id);	//1
				cstmt.setString( index++, oper_num);			//2
				cstmt.setString( index++, allwdSwabCntsVal);	//3
				cstmt.setString( index++, req.getParameter("template_id_"+rownum).trim());			//4
				cstmt.setString( index++, req.getParameter("item_code_"+rownum).trim());			//5
				cstmt.setString( index++, req.getParameter("item_value_"+rownum).trim());			//6
				cstmt.setString( index++, req.getParameter("new_remarks_"+rownum).trim());			//7
				cstmt.setString( index++, req.getParameter("first_count_yn").trim());	//8
				cstmt.setString( index++, req.getParameter("additions_during_op").trim());	//9		
				cstmt.setString( index++, req.getParameter("second_count_yn").trim());		//10
				cstmt.setString( index++, req.getParameter("third_count_yn").trim());		//11
				cstmt.setString( index++, req.getParameter("fourth_count_yn").trim());		//12
				cstmt.setString( index++, req.getParameter("fifth_count_yn").trim());		//13
				cstmt.setString( index++, req.getParameter("final_count_yn").trim());			//14
				cstmt.setString( index++, req.getParameter("item_stage").trim());			//15
				cstmt.setString( index++, req.getParameter("first_cnt_cmpl_yn"));			//16
				cstmt.setString( index++, req.getParameter("additions_during_op_cmpl_yn").trim());	//17
				cstmt.setString( index++, req.getParameter("second_cnt_cmpl_yn").trim());			//18
				cstmt.setString( index++, req.getParameter("additions_aft_clcav_cmpl_yn").trim());	//19
				cstmt.setString( index++, req.getParameter("third_cnt_cmpl_yn").trim());			//20
				cstmt.setString( index++, req.getParameter("add_after_third_count").trim());		//21
				cstmt.setString( index++, req.getParameter("fourth_cnt_cmpl_yn").trim());			//22
				cstmt.setString( index++, req.getParameter("add_after_fourth_count").trim());		//23
				cstmt.setString( index++, req.getParameter("fifth_cnt_cmpl_yn").trim());			//24
				cstmt.setString( index++, req.getParameter("add_after_fifth_count").trim());		//25
				cstmt.setString( index++, req.getParameter("final_cnt_cmpl_yn").trim());			//26
				cstmt.setString( index++, login_user);			//27
				cstmt.setString( index++, login_at_ws_no);		//28	
				cstmt.setString( index++, swab_serial_number);	//29
				cstmt.setString( index++, "null");//  ADD_FIELD2 set as null //30
				cstmt.setString( index++, req.getParameter("reviewed_by").trim());		//31
//				cstmt.setString( index++, login_user);//30
//				cstmt.setString( index++, login_user);//31
//				cstmt.setString( index++, login_user);//32
//				cstmt.setString( index++, login_user);//33
//				cstmt.setString( index++, login_user);//34
				cstmt.registerOutParameter( index++, Types.VARCHAR );  // 32: STATUS-> 'E' for Error and 'S' for Success
				cstmt.registerOutParameter( index++, Types.VARCHAR );  // 33: ERROR_TEXT
		        cstmt.registerOutParameter( index++, Types.VARCHAR ); // 34 LANG_ERROR_TEXT
				cstmt.execute() ;
			}


			status = cstmt.getString(32);
			error_text = cstmt.getString(33);
			lang_error_text = cstmt.getString(34);
			System.err.println("=========status======SwabCountServlet======"+status);
			System.err.println("=========error_text======SwabCountServlet======"+error_text);
			System.err.println("=========lang_error_text======SwabCountServlet======"+lang_error_text);
			if(status.equals("E"))
			{
				error_text = cstmt.getString(27);
				connection.rollback();
			}
			else
			{
				error_text	= "RECORD_INSERTED";
				connection.commit();
			}
            MessageManager mm=new MessageManager();
			String msg = "";
			if(!error_text.equals("RECORD_INSERTED"))
			{
				final java.util.Hashtable mesg = mm.getMessage(locale, "APP-OT0082", "SM") ;
				msg = ((String) mesg.get("message"));
				out.println("<html><script>alert("+msg+");</script></html>");
			}
			else
			{
				String htmlStr = "<html><script>";
				final java.util.Hashtable mesg = mm.getMessage(locale, "RECORD_INSERTED", "SM") ;
				msg = ((String) mesg.get("message"));
				htmlStr = htmlStr+"alert('"+msg+"');";
				htmlStr = htmlStr+"var tabFormObj = parent.parent.parent.f_tab_frames.document.SwabCountTabForm;";
				htmlStr = htmlStr+"var params = tabFormObj.params.value;";
				htmlStr = htmlStr+"parent.parent.parent.frames(3).location.href=\"../eOT/jsp/SwabCountTabs.jsp?\"+params;";
				htmlStr = htmlStr+"</script></html>";
				out.println(htmlStr);
			}

		}
		catch(Exception e)
		{
			System.err.println("error_text at 129===:"+error_text);
			e.printStackTrace();
			try
			{
				connection.rollback();
			}
			catch(Exception e_1)
			{
				System.err.println("119: Caught Exception during rollback"+e_1);
			}
		}
		finally 
		{
            try
            {
                cstmt.close() ;
                ConnectionManager.returnConnection( connection,req );
            }
            catch(Exception es)
            {
            	es.printStackTrace();
            }
        }
	}
}
