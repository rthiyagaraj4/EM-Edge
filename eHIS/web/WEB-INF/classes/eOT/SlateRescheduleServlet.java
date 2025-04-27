/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eOT;
import java.sql.Connection;
import webbeans.eCommon.ConnectionManager;
import java.sql.CallableStatement;
import java.sql.Types;


import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.StringTokenizer;
import eCommon.Common.CommonBean;

public class SlateRescheduleServlet extends javax.servlet.http.HttpServlet {

	public void init(ServletConfig config) throws ServletException	{
		super.init(config);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res)
	throws javax.servlet.ServletException,IOException{
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
		HttpSession session=req.getSession(false);
		PrintWriter out;
		out=res.getWriter();
		java.util.Properties prop = null;
		String facility_id = (String)session.getValue( "facility_id" ) ;
		prop = (java.util.Properties) session.getValue( "jdbc" ) ;
		String client_ip_address = prop.getProperty( "client_ip_address" );
		String login_user = prop.getProperty( "login_user" );

		String action_val = CommonBean.checkForNull(req.getParameter("action_val"));
		String reschedule_date =  CommonBean.checkForNull(req.getParameter("reschedule_date"));
		String total_records = CommonBean.checkForNull(req.getParameter("total_records"));
		StringTokenizer stk=null;
		StringTokenizer stk1=null;
		String rec="";
		String appt_ref_num="";
		String oper_room_code="";
		Connection connection = null ;
		CallableStatement cstmt= null ;
		String status="";
		String err_message="";
		boolean flag=true;
		try{
			connection	= ConnectionManager.getConnection(req);
			stk=new StringTokenizer(total_records,"::");	
			while(stk.hasMoreTokens()){	
				rec=stk.nextToken();
				stk1=new StringTokenizer(rec,"@@");
				while(stk1.hasMoreTokens()){
					appt_ref_num=stk1.nextToken();
					oper_room_code=stk1.nextToken();
					

					cstmt=connection.prepareCall("{call OT_SLATE_RESCHEDULE(?,?,?,?,?,?,?,?,?,null,null,null)}");
					cstmt.setString(1, action_val);		 
					cstmt.setString(2, facility_id);
					cstmt.setString(3, appt_ref_num);
					cstmt.setString(4, oper_room_code);		
					cstmt.setString(5, reschedule_date);
					cstmt.setString(6, login_user);
					cstmt.setString(7, client_ip_address);
					cstmt.registerOutParameter( 8, Types.VARCHAR );
					cstmt.registerOutParameter( 9, Types.VARCHAR );
					cstmt.execute() ;
					status = cstmt.getString(8);
					err_message = cstmt.getString(9);
					if(status.equals("E"))
						flag=false;
				}
					 if(cstmt!=null)cstmt.close();

			}
	if(flag==false){
		connection.rollback();
		out.println(err_message);
	}else{
		connection.commit();
		out.println(status);
	 }
	 if(cstmt!=null)cstmt.close();
	}catch(Exception e){
		   System.err.println("Err Msg in SlateRescheduleServlet "+e);
		}finally{
				if(connection!=null)ConnectionManager.returnConnection(connection,req);
		
		}
	}
}




