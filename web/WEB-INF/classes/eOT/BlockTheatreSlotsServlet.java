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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import webbeans.eCommon.ConnectionManager;
   

public class BlockTheatreSlotsServlet extends javax.servlet.http.HttpServlet {
	public void init(ServletConfig config) throws ServletException	{
		super.init(config);	    
	}
	 
	public void doPost(HttpServletRequest req, HttpServletResponse res)
	throws javax.servlet.ServletException,IOException{
		Connection connection = null;
		CallableStatement cstmt = null;
		PreparedStatement pstmt=null;
		ResultSet rst=null;
		int index=1;
		
		PrintWriter out;
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
		HttpSession session=req.getSession(false);
		out=res.getWriter();
		Properties prop = (java.util.Properties) session.getAttribute( "jdbc" ) ;
 		String login_at_ws_no = prop.getProperty( "client_ip_address" );
// 		String locale = prop.getProperty( "locale" );
		String facility_id = (String)session.getAttribute( "facility_id" );
		String theatre_code = req.getParameter("theatre_code");
		String block_reason= req.getParameter("block_reason");
		String block_by_day = req.getParameter("block_by_day");
		String from_date = req.getParameter("from_date");
		String to_date = req.getParameter("to_date");
		String from_time = req.getParameter("from_time");
		String to_time = req.getParameter("to_time");
		String week1 = req.getParameter("week1");
		String week2 = req.getParameter("week2");
		String week3 = req.getParameter("week3");
		String week4 = req.getParameter("week4");
		String week5 = req.getParameter("week5");
		String day_code = req.getParameter("day_code");
		String from_date_time=""; 
		String to_date_time=""; 
		day_code=day_code.toUpperCase();
		String error_text = "";
		String status = "";
		String lang_error_text = "";
		String include_blocked_slot_yn = ""; // Added for CRF 337
		int Blocked_Count = 0;   
		int unit = 0;   
		System.err.println("BlockTheatreSlotsServlet.java,from_date===="+from_date);
		System.err.println("59,to_date===="+to_date);
		System.err.println("60,from_time===="+from_time);
		System.err.println("61,to_time===="+to_time);
		//Modified by AnithaJ against incident IN027150	
		block_reason=java.net.URLDecoder.decode(block_reason,"UTF-8");
		System.err.println("block_reason  "+block_reason);
	
	

	try{

			connection = ConnectionManager.getConnection(req);
			//Added start for 337 CRF
			connection.setAutoCommit(false); 
			if(rst!=null) rst.close();
			if(pstmt!=null)pstmt.close();
			String include_blocked_sql ="SELECT INCLUDE_BLOCKED_SLOT INCLUDE_BLOCKED_SLOT FROM OT_PARAM_FOR_FACILITY WHERE  OPERATING_FACILITY_ID = ? ";
			String unit_time_sql ="SELECT TO_NUMBER(TO_CHAR(UNIT_OT_TIME,'SSSSS')) / 60 A FROM OT_PARAM_FOR_FACILITY WHERE OPERATING_FACILITY_ID = ? ";
			//String date_time_sql ="SELECT (to_date(?,'dd/mm/yyyy hh24:mi') - to_date(?,'dd/mm/yyyy hh24:mi')) * 24 * 60 / (to_number(to_char(unit_ot_time,'SSSSS')) / 60)  ac FROM ot_param_for_facility WHERE operating_facility_id = ? ";
			
			String date_time_sql ="SELECT ROUND((to_date(?,'hh24:mi') - to_date(?,'hh24:mi')) * 24 * 60 / (to_number(to_char(unit_ot_time,'SSSSS')) / 60))  ac FROM ot_param_for_facility WHERE operating_facility_id = ? ";
			
			pstmt = connection.prepareStatement(include_blocked_sql);
			pstmt.setString(1,facility_id);
			rst = pstmt.executeQuery();
			if(rst.next()){
				include_blocked_slot_yn=rst.getString(1);		
			}
			if(rst!=null) rst.close();
			if(pstmt!=null)pstmt.close();
			System.err.println("75,include_blocked_slot_yn==="+include_blocked_slot_yn);
			/*if(include_blocked_slot_yn.equals("Y")) // existing functionality
			{
				Blocked_Count = 0;	
			}*/
			//else{ // new functionality 
			pstmt = connection.prepareStatement(unit_time_sql);
			pstmt.setString(1,facility_id);
			rst = pstmt.executeQuery();
			if(rst.next()){
				unit=rst.getInt(1);		
				System.err.println("unit==="+unit);
			}
			if(rst!=null) rst.close();
			if(pstmt!=null)pstmt.close();
			from_date_time = from_date + " " + from_time;
			to_date_time =   to_date  + " " +  to_time	;
			System.err.println("from_date_time==="+from_date_time);
			System.err.println("to_date_time==="+to_date_time);
			pstmt = connection.prepareStatement(date_time_sql);
			System.err.println("date_time_sql==="+date_time_sql);
			/*
			pstmt.setString(1,to_date_time);
			pstmt.setString(2,from_date_time);
			*/
			pstmt.setString(1,to_time);
			pstmt.setString(2,from_time);
			
			pstmt.setString(3,facility_id);
			rst = pstmt.executeQuery();
			if(rst.next()){
				Blocked_Count=rst.getInt(1);		
				System.err.println("Blocked_Count==="+Blocked_Count);
			}
			if(rst!=null) rst.close();
			if(pstmt!=null)pstmt.close();
			//}
			//End for 337 CRF
			if(block_by_day.equals("Y"))
			{
			System.err.println("if OT_PROC_BLOCK_THEATRE.PROC_BLOCK_ROOM_BY_DAY======");	
			//cstmt=connection.prepareCall("{call OT_PROC_BLOCK_THEATRE.PROC_BLOCK_ROOM_BY_DAY(?,?,to_date(?,'DD/MM/YYYY'),to_date(?,'DD/MM/YYYY'),to_date(?,'HH24:MI'),to_date(?,'HH24:MI'),?,?,?,?,?,?,?,?,?,?,?,?)}");
			cstmt=connection.prepareCall("{call OT_PROC_BLOCK_THEATRE.PROC_BLOCK_ROOM_BY_DAY(?,?,to_date(?,'DD/MM/YYYY'),to_date(?,'DD/MM/YYYY'),to_date(?,'HH24:MI'),to_date(?,'HH24:MI'),?,?,?,?,?,?,?,?,?,?,?,?,?)}"); // New param added against 337 CRF


				index=1;		



			cstmt.setString( 1, facility_id);		//1							P_FACILITY_ID				
			cstmt.setString( 2, theatre_code);		//1							OPER_ROOM_CODE				
			cstmt.setString( 3, from_date);		//2							P_FM_BLOCK_DATE		
			cstmt.setString( 4, to_date);			//3							P_TO_BLOCK_DATE		
			cstmt.setString( 5, from_time);		//4							P_FM_BLOCK_TIME		
			cstmt.setString( 6, to_time);			//5							P_TO_BLOCK_TIME		
			cstmt.setString( 7, block_reason);	//14						P_BLOCK_REASON	
			cstmt.setString( 8, day_code);		//7							P_DAY_CODE	
			cstmt.setString( 9, week1);			//8							P_WEEK_1		
			cstmt.setString( 10, week2);			//9						P_WEEK_2		
			cstmt.setString( 11, week3);			//10						P_WEEK_3		
			cstmt.setString( 12, week4);			//11						P_WEEK_4		
			cstmt.setString( 13, week5);			//12						P_WEEK_5
			cstmt.setString( 14, login_at_ws_no);	//15						P_WS_ID	
			cstmt.setInt( 15, Blocked_Count);	// added for 337 CRF
			cstmt.registerOutParameter( 16, 12);  //16 status					P_STATUS
			cstmt.registerOutParameter( 17, 12);  //16 status					P_STATUS	    
			cstmt.registerOutParameter( 18, 12 );  //17 error_text				P_ERR_MSG	    
			cstmt.registerOutParameter( 19, 12 );  //18 lang_error_text		V_LANG_ERR_MSG_ID   
			System.err.println("155,Blocked_Count========="+Blocked_Count);	
			cstmt.execute() ;
			status				=  cstmt.getString(17);
			error_text			=  cstmt.getString(18);
			System.err.println("92,status========="+status);	
			System.err.println("93,error_text======"+error_text);	
		}else
		{
			System.err.println("else OT_PROC_BLOCK_THEATRE.PROC_BLOCK_THEATRE======");	
			//cstmt=connection.prepareCall("{call OT_PROC_BLOCK_THEATRE.PROC_BLOCK_THEATRE(?,to_date(?,'DD/MM/YYYY'),to_date(?,'DD/MM/YYYY'),to_date(?,'HH24:MI'),to_date(?,'HH24:MI'),?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			cstmt=connection.prepareCall("{call OT_PROC_BLOCK_THEATRE.PROC_BLOCK_THEATRE(?,to_date(?,'DD/MM/YYYY'),to_date(?,'DD/MM/YYYY'),to_date(?,'HH24:MI'),to_date(?,'HH24:MI'),?,?,?,?,?,?,?,?,?,?,?,?,?,?)}"); // New Param added against 337 CRF

			index=1;		

			cstmt.setString( 1, facility_id);		//1							P_FACILITY_ID				
			cstmt.setString( 2, from_date);		//2							P_FM_BLOCK_DATE		
			cstmt.setString( 3, to_date);			//3							P_TO_BLOCK_DATE		
			cstmt.setString( 4, from_time);		//4							P_FM_BLOCK_TIME		
			cstmt.setString( 5, to_time);			//5							P_TO_BLOCK_TIME							
			cstmt.setString( 6, block_by_day);	//6							P_BLOCK_BY_DAY		
			cstmt.setString( 7, day_code);		//7							P_DAY_CODE		
			cstmt.setString( 8, week1);			//8							P_WEEK_1		
			cstmt.setString( 9, week2);			//9						P_WEEK_2		
			cstmt.setString( 10, week3);			//10						P_WEEK_3		
			cstmt.setString( 11, week4);			//11						P_WEEK_4		
			cstmt.setString( 12, week5);			//12						P_WEEK_5		
			cstmt.setString( 13, theatre_code);	//13						P_OPER_ROOM_CODE	
			cstmt.setString( 14, block_reason);	//14						P_BLOCK_REASON		
			cstmt.setString( 15, login_at_ws_no);	//15						P_WS_ID			
			cstmt.setInt( 16, Blocked_Count);
			cstmt.registerOutParameter( 17, 12);  //16 status					P_STATUS	    
			cstmt.registerOutParameter( 18, 12 );  //17 error_text				P_ERR_MSG	    
			cstmt.registerOutParameter( 19, 12 );  //18 lang_error_text		V_LANG_ERR_MSG_ID   
			System.err.println("186,Blocked_Count========="+Blocked_Count);	
			cstmt.execute() ;
			status				=  cstmt.getString(17);
			error_text			=  cstmt.getString(18);
			System.err.println("123,status========="+status);	
			System.err.println("124,error_text======"+error_text);	 
	}
			if("E".equals(status)){
				connection.rollback(); // Added for CRF 337
				error_text = cstmt.getString(18);
				lang_error_text = cstmt.getString(19);
				error_text = lang_error_text;
			}else{
				error_text = "RECORD_INSERTED";
				connection.commit(); // Added for CRF 337
			}
			out.println(error_text);
		}catch(Exception e){
			System.err.println("Err Msg From BlockTheatreSlotsServlet :: "+e);

		}finally {
            try{
                cstmt.close() ;
				if(rst!=null) rst.close(); // Added for CRF 337
				if(pstmt!=null)pstmt.close(); // Added for CRF 337
                ConnectionManager.returnConnection( connection,req );
             }catch(Exception es){es.printStackTrace();}
        }
	}

}


