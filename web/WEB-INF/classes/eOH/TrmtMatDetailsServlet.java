/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
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

public class TrmtMatDetailsServlet extends javax.servlet.http.HttpServlet {
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
		facility_id = (String)session.getValue( "facility_id" ) ;
		prop = (java.util.Properties) session.getValue( "jdbc" ) ;
		client_ip_address = prop.getProperty( "client_ip_address" );
		login_user = prop.getProperty( "login_user" );
		locale = prop.getProperty("LOCALE");
		
		Connection          con = null;
		PreparedStatement pstmt = null;
		ResultSet         rs    = null;
		
		
		
		String msg="";
		String trace="0";
		String composition_remarks="";
		try{
			con = ConnectionManager.getConnection(request);
				        
			String patient_id = checkForNull(request.getParameter( "patient_id" )) ;
		    String chart_num = checkForNull(request.getParameter( "chart_num" )) ;
			String chart_line_num = checkForNull(request.getParameter( "chart_line_num" )) ;
			String trmt_code = checkForNull(request.getParameter( "trmt_code" )) ;
			String task_code = checkForNull(request.getParameter( "task_code" )) ;
			String composition_class_code= checkForNull(request.getParameter( "composition_class" ));
		    String composition_code= checkForNull(request.getParameter( "composition_code" ));
			String seq_no = checkForNull(request.getParameter( "seq_no" )) ;
			String tooth_range_count = checkForNull(request.getParameter( "tooth_range_count_for_order" )) ;
			tooth_range_count=tooth_range_count==null?"0":tooth_range_count;
			tooth_range_count=tooth_range_count.equals("null")?"0":tooth_range_count;
			tooth_range_count=tooth_range_count.equals("")?"0":tooth_range_count;
			
            int mat_count = Integer.parseInt(tooth_range_count);
			int mat_chart_line_num_int = Integer.parseInt(chart_line_num);
			int mat_flag = 0;
			//int max_count = 0;	//Commented Against Common-ICN-0031

		    if(pstmt != null) pstmt.close();
			if(rs != null) rs.close();
			int composition_seq_no = 1;

			if(composition_class_code.equals("OTH")){
				composition_remarks = composition_code;
				composition_code = "OTH";
				pstmt=con.prepareStatement("SELECT MAX(COMPOSITION_SEQ_NO) MAX_COUNT FROM OH_RESTORATIVE_CHART_MATRL WHERE PATIENT_ID = ? AND CHART_NUM = ? AND CHART_LINE_NUM = ? AND TRMT_CODE = ? AND COMPOSITION_CLASS_CODE = ? AND COMPOSITION_CODE = ? AND TASK_CODE = ?");
				pstmt.setString(1,patient_id);
				pstmt.setString(2,chart_num);
				pstmt.setString(3,chart_line_num);
				pstmt.setString(4,trmt_code);
				pstmt.setString(5,composition_class_code);
				pstmt.setString(6,composition_code);
				pstmt.setString(7,task_code);
				rs = pstmt.executeQuery();
				while(rs.next()){
					composition_seq_no = Integer.parseInt(checkForNull(rs.getString("MAX_COUNT"),"1"));
				}
				composition_seq_no++;
			}

			if(pstmt != null) pstmt.close();	//Added Against Common-ICN-0031
			String str_composition_seq_no = composition_seq_no+"";
			pstmt=con.prepareStatement("INSERT INTO OH_RESTORATIVE_CHART_MATRL (OPERATING_FACILITY_ID,PATIENT_ID,CHART_NUM,CHART_LINE_NUM,TRMT_CODE,COMPOSITION_CLASS_CODE,COMPOSITION_CODE,COMPOSITION_REMARKS,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID,TASK_CODE,COMPOSITION_SEQ_NO,TASK_SEQ) VALUES (?,?,?,?,?,?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?,?,?,?)");
            
			if(mat_count == 0){
				pstmt.setString(1,facility_id);
				pstmt.setString(2,patient_id);
				pstmt.setString(3,chart_num);
				pstmt.setString(4,chart_line_num);
				pstmt.setString(5,trmt_code);
				pstmt.setString(6,composition_class_code);
				pstmt.setString(7,composition_code);
				pstmt.setString(8,composition_remarks);
				pstmt.setString(9,login_user);
				pstmt.setString(10,client_ip_address);
				pstmt.setString(11,facility_id);
				pstmt.setString(12,login_user);
				pstmt.setString(13,client_ip_address);
				pstmt.setString(14,facility_id);
				pstmt.setString(15,task_code);
				pstmt.setString(16,str_composition_seq_no);
				pstmt.setString(17,seq_no);
				mat_flag = pstmt.executeUpdate();
			}
			else{
				for(int j=1;j<=mat_count;j++){
					chart_line_num = mat_chart_line_num_int+"";
					pstmt.setString(1,facility_id);
					pstmt.setString(2,patient_id);
					pstmt.setString(3,chart_num);
					pstmt.setString(4,chart_line_num);
					pstmt.setString(5,trmt_code);
					pstmt.setString(6,composition_class_code);
					pstmt.setString(7,composition_code);
					pstmt.setString(8,composition_remarks);
					pstmt.setString(9,login_user);
					pstmt.setString(10,client_ip_address);
					pstmt.setString(11,facility_id);
					pstmt.setString(12,login_user);
					pstmt.setString(13,client_ip_address);
					pstmt.setString(14,facility_id);
					pstmt.setString(15,task_code);
					pstmt.setString(16,str_composition_seq_no);
					pstmt.setString(17,seq_no);
					mat_flag = pstmt.executeUpdate();
					mat_chart_line_num_int++;
				}
			}
            if(mat_flag != 0){
				con.commit();
			}
			else{
				con.rollback();
			}

			response.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode( msg,"UTF-8" ));
	
		}catch(Exception e){
				try{
					System.err.println("Rollback performed, Err Msg in TrmtMatDetailsServlet"+e.getMessage());
					con.rollback();
				}catch(Exception e_1){
					System.err.println("TrmtMatDetailsServlet :Caught Exception during rollback"+e_1);
				}
			    System.err.println("Err Msg in TrmtMatDetailsServlet"+e.getMessage());
			    System.err.println("Err Msg in TrmtMatDetailsServlet:trace="+trace);
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
