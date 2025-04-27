/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
//Created by sathish on 21-01-2010
package eOH;

import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import webbeans.eCommon.ConnectionManager;
import org.xml.sax.InputSource;
import webbeans.eCommon.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TrmtComplicationDetailsServlet extends javax.servlet.http.HttpServlet {
	public void init(ServletConfig config) throws ServletException	{
		super.init(config);
	}

	private String checkForNull(String str){
		return (str!=null && str.intern()!="null")?str:"";
	}

	private String checkForNull(String str,String defaultVal){
		return (!checkForNull(str).equals(""))?str:defaultVal;
	}


public void doPost(HttpServletRequest request, HttpServletResponse response)	throws javax.servlet.ServletException,IOException{
		PrintWriter out;
		//HashMap hashElement=null,map=null;
		eOH.MasterXMLParse masterXMLParse;
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		HttpSession session=request.getSession(false);
		out=response.getWriter();
					
		masterXMLParse=new eOH.MasterXMLParse();
		String client_ip_address="";
		String facility_id = "";	
		String login_user=""; 
		String locale="";
		
		java.util.Properties prop = null;
		facility_id        = (String)session.getValue( "facility_id" ) ;
		prop               = (java.util.Properties) session.getValue( "jdbc" ) ;
		client_ip_address  = prop.getProperty( "client_ip_address" );
		login_user         = prop.getProperty( "login_user" );
		locale             = prop.getProperty("LOCALE");
		
		Connection          con = null;
		PreparedStatement pstmt = null;
		ResultSet            rs = null;
		
		
		
		String msg  ="";
		String trace="0";
		try{
			con = ConnectionManager.getConnection(request);
				        
			String patient_id          = checkForNull(request.getParameter( "patient_id" )) ;
		    String chart_num           = checkForNull(request.getParameter( "chart_num" )) ;
			String chart_line_num      = checkForNull(request.getParameter( "chart_line_num" )) ;
			String trmt_code           = checkForNull(request.getParameter( "trmt_code" )) ;
			String task_code           = checkForNull(request.getParameter( "task_code" )) ;
			String complication_code   = checkForNull(request.getParameter( "complication_code" ));
		    String complication_remarks= checkForNull(request.getParameter( "complication_remarks" ));
			String seq_no              = checkForNull(request.getParameter( "seq_no" )) ;
			String tooth_range_count   = checkForNull(request.getParameter( "tooth_range_count_for_order" )) ;
			tooth_range_count          =tooth_range_count==null?"0":tooth_range_count;
			tooth_range_count          =tooth_range_count.equals("null")?"0":tooth_range_count;
			tooth_range_count          =tooth_range_count.equals("")?"0":tooth_range_count;
			
            int tooth_range_cnt    = Integer.parseInt(tooth_range_count);
			int chart_line_num_int = Integer.parseInt(chart_line_num);
			int complication_flag  = 0;
			//int max_count          = 0;	//Commented Against Common-ICN-0031

		    if(rs    != null) rs.close();
			if(pstmt != null) pstmt.close();

			int complication_seq_no = 1;

			if(complication_code.equals("$OTH")){
				pstmt=con.prepareStatement("SELECT MAX(COMPLICATION_SEQ_NO) MAX_COUNT FROM OH_RESTO_CHRT_COMPLICATION WHERE PATIENT_ID = ? AND CHART_NUM = ? AND CHART_LINE_NUM = ? AND TRMT_CODE = ? AND COMPLICATION_CODE = ? AND TASK_CODE = ?");
				pstmt.setString(1,patient_id);
				pstmt.setString(2,chart_num);
				pstmt.setString(3,chart_line_num);
				pstmt.setString(4,trmt_code);
				pstmt.setString(5,complication_code);
				pstmt.setString(6,task_code);
				rs = pstmt.executeQuery();
				while(rs.next()){
					complication_seq_no = Integer.parseInt(checkForNull(rs.getString("MAX_COUNT"),"1"));
				}
				complication_seq_no++;
			}

						
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();

			String str_complication_seq_no = complication_seq_no+"";
			pstmt=con.prepareStatement("INSERT INTO OH_RESTO_CHRT_COMPLICATION (OPERATING_FACILITY_ID, PATIENT_ID, CHART_NUM, CHART_LINE_NUM, TRMT_CODE, TASK_CODE, TASK_SEQ, COMPLICATION_CODE, COMPLICATION_SEQ_NO, COMPLICATION_REMARKS, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID) VALUES(?,?,?,?,?,?,?,?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?)");
            
			if(tooth_range_cnt == 0){
				pstmt.setString(1,facility_id);
				pstmt.setString(2,patient_id);
				pstmt.setString(3,chart_num);
				pstmt.setString(4,chart_line_num);
				pstmt.setString(5,trmt_code);
				pstmt.setString(6,task_code);
				pstmt.setString(7,seq_no);
				pstmt.setString(8,complication_code);
				pstmt.setString(9,str_complication_seq_no);
				pstmt.setString(10,complication_remarks);
				pstmt.setString(11,login_user);
				pstmt.setString(12,client_ip_address);
				pstmt.setString(13,facility_id);
				pstmt.setString(14,login_user);
				pstmt.setString(15,client_ip_address);
				pstmt.setString(16,facility_id);
				
				complication_flag = pstmt.executeUpdate();
			}
			else{
				for(int j=1;j<=tooth_range_cnt;j++){
					chart_line_num = chart_line_num_int+"";
					pstmt.setString(1,facility_id);
					pstmt.setString(2,patient_id);
					pstmt.setString(3,chart_num);
					pstmt.setString(4,chart_line_num);
					pstmt.setString(5,trmt_code);
					pstmt.setString(6,task_code);
					pstmt.setString(7,seq_no);
					pstmt.setString(8,complication_code);
					pstmt.setString(9,str_complication_seq_no);
					pstmt.setString(10,complication_remarks);
					pstmt.setString(11,login_user);
					pstmt.setString(12,client_ip_address);
					pstmt.setString(13,facility_id);
					pstmt.setString(14,login_user);
					pstmt.setString(15,client_ip_address);
					pstmt.setString(16,facility_id);
					
					complication_flag = pstmt.executeUpdate();
					chart_line_num_int++;
				}
			}
            if(complication_flag != 0){
				con.commit();
			}
			else{
				con.rollback();
			}

			response.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode( msg,"UTF-8" ));
	
		}catch(Exception e){
				try{
					System.err.println("Rollback performed, Err Msg in TrmtComplicationDetailsServlet"+e.getMessage());
					con.rollback();
				}catch(Exception e_1){
					System.err.println("TrmtComplicationDetailsServlet :Caught Exception during rollback"+e_1);
				}
			    System.err.println("Err Msg in TrmtComplicationDetailsServlet"+e.getMessage());
			    System.err.println("Err Msg in TrmtComplicationDetailsServlet:trace="+trace);
				msg = e.toString();
				response.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode( msg,"UTF-8" ));
		}finally{
			try{
					if(rs!=null) rs.close();
					if(pstmt!=null) pstmt.close();
					if(con!=null) ConnectionManager.returnConnection(con,request);
			}catch(Exception e){}
		}
    }
}
