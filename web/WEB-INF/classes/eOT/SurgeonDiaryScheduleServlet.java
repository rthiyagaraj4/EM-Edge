/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eOT;
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
import java.util.Date;





public class SurgeonDiaryScheduleServlet extends javax.servlet.http.HttpServlet {
	public void init(ServletConfig config) throws ServletException	{
		super.init(config);	    
	}
	 
	public void doPost(HttpServletRequest req, HttpServletResponse res)
	throws javax.servlet.ServletException,IOException{
		Connection connection = null;
		CallableStatement cstmt = null;
		int index=1;
		
		PrintWriter out;
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
		HttpSession session=req.getSession(false);
		out=res.getWriter();
		Properties prop = (java.util.Properties) session.getAttribute( "jdbc" ) ;
 		String login_at_ws_no = prop.getProperty( "client_ip_address" );
 		//String locale = prop.getProperty( "locale" );

		String facility_id = (String)session.getAttribute( "facility_id" );
		//String login_user = req.getParameter("login_user");
		String theatre_code = req.getParameter("theatre_code");
		String surgeon_code = req.getParameter("surgeon_code");
		String generate_by = req.getParameter("generate_by");	
		String from_date = req.getParameter("from_date");
		String to_date = req.getParameter("to_date");
		String error_text = "";
		String status = "";
		String lang_err_text = "";

 
	try{
			connection = ConnectionManager.getConnection(req);
			//cstmt=connection.prepareCall("{call OT_DIARY_SCHEDULE_GENERATION(?,?,?,?,to_date(?,'dd/mm/yyyy'),to_date(?,'dd/mm/yyyy'),?,?,?,?)}");
			cstmt=connection.prepareCall("{call OT_DIARY_SCHEDULE_GENERATION(?,?,?,?, ?,?, ?,  ?,?,?,?)}");
			index=1;		
	

			cstmt.setString( index++, facility_id);	
			cstmt.setString( index++, theatre_code);	
			cstmt.setString( index++, surgeon_code);	
			cstmt.setString( index++, "D");	
			cstmt.setString( index++, from_date);	
			cstmt.setString( index++, to_date);	
			cstmt.setString( index++, generate_by);	
			cstmt.setString( index++, login_at_ws_no);	
			cstmt.registerOutParameter( index++, Types.VARCHAR );  // status
			cstmt.registerOutParameter( index++, Types.VARCHAR );  // error msg
			cstmt.registerOutParameter( index++, Types.VARCHAR );  // lang_err_text
			cstmt.execute() ;

			status				=  cstmt.getString(9);
			error_text			=  cstmt.getString(10);
			lang_err_text		=  cstmt.getString(11);




			if("N".equals(status)){
				error_text = "RECORD_INSERTED";
			}else{
				error_text	=  cstmt.getString(10);
		
				error_text = error_text;
			}

			out.println(error_text);

		}catch(Exception e){
			System.err.println("caught Exception in SurgeonDiaryScheduleServlet, error_text===:"+e);
		}finally {
            try{
                cstmt.close() ;
                ConnectionManager.returnConnection( connection,req );
             }catch(Exception es){es.printStackTrace();}
        }
	}

}


