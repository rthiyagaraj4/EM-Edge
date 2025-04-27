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

public class OHTrmtSendOutAckServlet extends javax.servlet.http.HttpServlet {
	public void init(ServletConfig config) throws ServletException	{
		super.init(config);
	}

	private String checkForNull(String str){
		return (str!=null && str.intern()!="null")?str:"";
	}

	private String checkForNull(String inputString,String defaultValue){
        return ( inputString == null || inputString.equals("") )    ?   defaultValue    :   inputString;
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res)	throws javax.servlet.ServletException,IOException{
		PrintWriter out;
		//HashMap hashElement=null,map=null;
		eOH.MasterXMLParse masterXMLParse;
		HashMap CommonData=new HashMap();
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
		HttpSession session=req.getSession(false);
		out=res.getWriter();
					
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
	
		CommonData.put("login_user", login_user); 
		CommonData.put("login_at_ws_no",client_ip_address);
		CommonData.put("facility_id",facility_id);
		CommonData.put("locale",locale);
		
		Connection con = null;
		PreparedStatement pstmt = null;
		String sqlUpdate ="";
		int flag=0;
		String msg="";
		int index = 1;
		String commit_flag = "N";
		ArrayList flag_arr= new ArrayList();
		try{
				con = ConnectionManager.getConnection(req);

				String chart_level=checkForNull(req.getParameter("chart_level"));
				String patient_id=checkForNull(req.getParameter("patient_id"));
				String chart_num=checkForNull(req.getParameter("chart_num"));
				String chart_line_num=checkForNull(req.getParameter("chart_line_num"));
				String trmt_code=checkForNull(req.getParameter("trmt_code"));
				String task_code=checkForNull(req.getParameter("task_code"));
				String task_seq_no=checkForNull(req.getParameter("task_seq_no"));
				String called_from=checkForNull(req.getParameter("called_from"));
				//String ca_practitioner_id=checkForNull(req.getParameter("ca_practitioner_id"));	//Commented Against Common-ICN-0031

				//PARAMETERS FOR SEND OUT FUNCTION
				String facility_id_param=checkForNull(req.getParameter("facility_id"));
				String location_code=checkForNull(req.getParameter("location_code"));
				String sendout_parct=checkForNull(req.getParameter("sendout_parct"));
				String sendout_perm_loc=checkForNull(req.getParameter("sendout_perm_loc"));
				String sendout_completed=checkForNull(req.getParameter("sendout_completed"),"N");
				String sendout_personnel=checkForNull(req.getParameter("sendout_personnel"));
				String sendout_date=checkForNull(req.getParameter("sendout_date"));
				sendout_date=com.ehis.util.DateUtils.convertDate(sendout_date,"DMYHM",locale,"en");

		
				//PARAMETERS FOR ACKNOWLEDGE FUNCTION
				String ack_recvd_date=checkForNull(req.getParameter("ack_recvd_date"));
				ack_recvd_date=com.ehis.util.DateUtils.convertDate(ack_recvd_date,"DMYHM",locale,"en");
				String ack_recpt_no=checkForNull(req.getParameter("ack_recpt_no"));
				String ack_personnel=checkForNull(req.getParameter("ack_personnel"));
				String ack_expected_date=checkForNull(req.getParameter("ack_expected_date"));
				String ack_completed=checkForNull(req.getParameter("ack_completed"),"N");

				//PARAMETERS FOR RECIEVE DETAILS FUNCTION
				String recv_recvd_date=checkForNull(req.getParameter("recv_recvd_date"));
				recv_recvd_date=com.ehis.util.DateUtils.convertDate(recv_recvd_date,"DMYHM",locale,"en");
				String recv_personnel=checkForNull(req.getParameter("recv_personnel"));
				String recv_completed=checkForNull(req.getParameter("recv_completed"),"N");
				String recv_remarks=checkForNull(req.getParameter("recv_remarks"));
				String recv_lab_price=checkForNull(req.getParameter("recv_lab_price"));
				String recv_recpt_no=checkForNull(req.getParameter("recv_recpt_no"));

				if(pstmt != null) pstmt.close();
				if(chart_level.equals("E")){
					if(called_from.equals("sendOut")){
						//sqlUpdate="UPDATE OH_RESTORATIVE_CHART_TASKS SET (SEND_FROM_FACILITY_ID,SEND_FROM_LOCATION,SEND_PRACTITIONER_ID,PERFORMING_LOCATION,SENT_OUT_DATE,SENT_TO,SENDOUT_YN,MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID) VALUES (?,?,?,?,?,?,?,?,SYSDATE,?,?) WHERE PATIENT_ID = ? AND CHART_NUM = ? AND CHART_LINE_NUM = ? AND TRMT_CODE = ? AND TASK_CODE = ? AND TASK_SEQ = ?";
						sqlUpdate="UPDATE OH_RESTORATIVE_CHART_TASKS SET SEND_FROM_FACILITY_ID = ?, SEND_FROM_LOCATION =?, SEND_PRACTITIONER_ID = ?, PERFORMING_LOCATION = ?, SENT_OUT_DATE = TO_DATE(?,'DD/MM/YYYY HH24:MI'), SENT_TO = ?, SENDOUT_YN = ?, MODIFIED_BY_ID = ?, MODIFIED_DATE = SYSDATE, MODIFIED_AT_WS_NO = ?, MODIFIED_FACILITY_ID = ? WHERE PATIENT_ID = ? AND CHART_NUM = ? AND CHART_LINE_NUM = ? AND TRMT_CODE = ? AND TASK_CODE = ? AND TASK_SEQ = ?";
						pstmt=con.prepareStatement(sqlUpdate);
						index = 1;
						pstmt.setString(index++,facility_id_param);				  
						pstmt.setString(index++,location_code);				  
						pstmt.setString(index++,sendout_parct);				  
						pstmt.setString(index++,sendout_perm_loc);	
						pstmt.setString(index++,sendout_date);
						pstmt.setString(index++,sendout_personnel);	
						pstmt.setString(index++,sendout_completed);			
										
						pstmt.setString(index++,login_user);				
						pstmt.setString(index++,client_ip_address); 		
						pstmt.setString(index++,facility_id);				
						pstmt.setString(index++,patient_id);				
						pstmt.setString(index++,chart_num);				
						pstmt.setString(index++,chart_line_num);				
						pstmt.setString(index++,trmt_code);				
						pstmt.setString(index++,task_code);				
						pstmt.setString(index++,task_seq_no);				
						flag = pstmt.executeUpdate();
					}
					else if(called_from.equals("acknowledge")){
						sqlUpdate="UPDATE OH_RESTORATIVE_CHART_TASKS SET ACKNOWLEDGE_DATE = TO_DATE(?,'DD/MM/YYYY HH24:MI'), ACK_RECEIPT_NO =?, ACKNOWLEDGED_BY = ?, EXPECTED_DELIVERY_DATE = TO_DATE(?,'DD/MM/YYYY HH24:MI'), ACKNOWLEDGED_YN = ?, MODIFIED_BY_ID = ?, MODIFIED_DATE = SYSDATE, MODIFIED_AT_WS_NO = ?, MODIFIED_FACILITY_ID = ? WHERE PATIENT_ID = ? AND CHART_NUM = ? AND CHART_LINE_NUM = ? AND TRMT_CODE = ? AND TASK_CODE = ? AND TASK_SEQ = ?";
						pstmt=con.prepareStatement(sqlUpdate);
						index = 1;
						pstmt.setString(index++,ack_recvd_date);				  
						pstmt.setString(index++,ack_recpt_no);				
						pstmt.setString(index++,ack_personnel);					
						pstmt.setString(index++,ack_expected_date);				
						pstmt.setString(index++,ack_completed);		
						pstmt.setString(index++,login_user);				
						pstmt.setString(index++,client_ip_address); 		
						pstmt.setString(index++,facility_id);	
						pstmt.setString(index++,patient_id);				
						pstmt.setString(index++,chart_num);				
						pstmt.setString(index++,chart_line_num);				
						pstmt.setString(index++,trmt_code);				
						pstmt.setString(index++,task_code);				
						pstmt.setString(index++,task_seq_no);
						flag = pstmt.executeUpdate();
					}
					else if(called_from.equals("recvDetails")){
						sqlUpdate="UPDATE OH_RESTORATIVE_CHART_TASKS SET RECEIVED_DATE = TO_DATE(?,'DD/MM/YYYY HH24:MI'), RECEIVED_BY =?, RECEIVED_YN = ?, REMARKS = ?, LAB_PRICE = ?, RCV_RECEIPT_NO = ?, MODIFIED_BY_ID = ?, MODIFIED_DATE = SYSDATE, MODIFIED_AT_WS_NO = ?, MODIFIED_FACILITY_ID = ? WHERE PATIENT_ID = ? AND CHART_NUM = ? AND CHART_LINE_NUM = ? AND TRMT_CODE = ? AND TASK_CODE = ? AND TASK_SEQ = ?";
						pstmt=con.prepareStatement(sqlUpdate);
						index = 1;
						pstmt.setString(index++,recv_recvd_date);				  
						pstmt.setString(index++,recv_personnel);				
						pstmt.setString(index++,recv_completed);					
						pstmt.setString(index++,recv_remarks);				
						pstmt.setString(index++,recv_lab_price);				
						pstmt.setString(index++,recv_recpt_no);				
						pstmt.setString(index++,login_user);				
						pstmt.setString(index++,client_ip_address); 		
						pstmt.setString(index++,facility_id);	
						pstmt.setString(index++,patient_id);				
						pstmt.setString(index++,chart_num);				
						pstmt.setString(index++,chart_line_num);				
						pstmt.setString(index++,trmt_code);				
						pstmt.setString(index++,task_code);				
						pstmt.setString(index++,task_seq_no);
						flag = pstmt.executeUpdate();
					}
				}
				else{
					if(called_from.equals("sendOut")){
						sqlUpdate="UPDATE OH_RESTORATIVE_CHART_TASKS SET SEND_FROM_FACILITY_ID = ?, SEND_FROM_LOCATION =?, SEND_PRACTITIONER_ID = ?, PERFORMING_LOCATION = ?, SENT_OUT_DATE = TO_DATE(?,'DD/MM/YYYY HH24:MI'), SENT_TO = ?, SENDOUT_YN = ?, MODIFIED_BY_ID = ?, MODIFIED_DATE = SYSDATE, MODIFIED_AT_WS_NO = ?, MODIFIED_FACILITY_ID = ? WHERE OPERATING_FACILITY_ID = ? AND PATIENT_ID = ? AND CHART_NUM = ? AND CHART_LINE_NUM = ? AND TRMT_CODE = ? AND TASK_CODE = ? AND TASK_SEQ = ?";
						pstmt=con.prepareStatement(sqlUpdate);
						index = 1;
						pstmt.setString(index++,facility_id_param);				  
						pstmt.setString(index++,location_code);				  
						pstmt.setString(index++,sendout_parct);				  
						pstmt.setString(index++,sendout_perm_loc);	
						pstmt.setString(index++,sendout_date);
						pstmt.setString(index++,sendout_personnel);	
						pstmt.setString(index++,sendout_completed);	
						
						pstmt.setString(index++,login_user);				
						pstmt.setString(index++,client_ip_address); 		
						pstmt.setString(index++,facility_id);				
						pstmt.setString(index++,facility_id);				
						pstmt.setString(index++,patient_id);				
						pstmt.setString(index++,chart_num);				
						pstmt.setString(index++,chart_line_num);				
						pstmt.setString(index++,trmt_code);				
						pstmt.setString(index++,task_code);				
						pstmt.setString(index++,task_seq_no);
						flag = pstmt.executeUpdate();
					}
					else if(called_from.equals("acknowledge")){
						sqlUpdate="UPDATE OH_RESTORATIVE_CHART_TASKS SET ACKNOWLEDGE_DATE = TO_DATE(?,'DD/MM/YYYY HH24:MI'), ACK_RECEIPT_NO =?, ACKNOWLEDGED_BY = ?, EXPECTED_DELIVERY_DATE = TO_DATE(?,'DD/MM/YYYY HH24:MI'), ACKNOWLEDGED_YN = ?, MODIFIED_BY_ID = ?, MODIFIED_DATE = SYSDATE, MODIFIED_AT_WS_NO = ?, MODIFIED_FACILITY_ID = ? WHERE OPERATING_FACILITY_ID = ? AND PATIENT_ID = ? AND CHART_NUM = ? AND CHART_LINE_NUM = ? AND TRMT_CODE = ? AND TASK_CODE = ? AND TASK_SEQ = ?";
						pstmt=con.prepareStatement(sqlUpdate);
						index = 1;
						pstmt.setString(index++,ack_recvd_date);				  
						pstmt.setString(index++,ack_recpt_no);				
						pstmt.setString(index++,ack_personnel);					
						pstmt.setString(index++,ack_expected_date);				
						pstmt.setString(index++,ack_completed);		
						pstmt.setString(index++,login_user);				
						pstmt.setString(index++,client_ip_address); 		
						pstmt.setString(index++,facility_id);				
						pstmt.setString(index++,facility_id);				
						pstmt.setString(index++,patient_id);				
						pstmt.setString(index++,chart_num);				
						pstmt.setString(index++,chart_line_num);				
						pstmt.setString(index++,trmt_code);				
						pstmt.setString(index++,task_code);				
						pstmt.setString(index++,task_seq_no);
						flag = pstmt.executeUpdate();
					}
					else if(called_from.equals("recvDetails")){
						sqlUpdate="UPDATE OH_RESTORATIVE_CHART_TASKS SET RECEIVED_DATE = TO_DATE(?,'DD/MM/YYYY HH24:MI'), RECEIVED_BY =?, RECEIVED_YN = ?, REMARKS = ?, LAB_PRICE = ?, RCV_RECEIPT_NO =?, MODIFIED_BY_ID = ?, MODIFIED_DATE = SYSDATE, MODIFIED_AT_WS_NO = ?, MODIFIED_FACILITY_ID = ? WHERE OPERATING_FACILITY_ID = ? AND PATIENT_ID = ? AND CHART_NUM = ? AND CHART_LINE_NUM = ? AND TRMT_CODE = ? AND TASK_CODE = ? AND TASK_SEQ = ?";
						pstmt=con.prepareStatement(sqlUpdate);
						index = 1;
						pstmt.setString(index++,recv_recvd_date);				  
						pstmt.setString(index++,recv_personnel);				
						pstmt.setString(index++,recv_completed);					
						pstmt.setString(index++,recv_remarks);				
						pstmt.setString(index++,recv_lab_price);				
						pstmt.setString(index++,recv_recpt_no);				
						pstmt.setString(index++,login_user);				
						pstmt.setString(index++,client_ip_address); 		
						pstmt.setString(index++,facility_id);				
						pstmt.setString(index++,facility_id);				
						pstmt.setString(index++,patient_id);				
						pstmt.setString(index++,chart_num);				
						pstmt.setString(index++,chart_line_num);				
						pstmt.setString(index++,trmt_code);				
						pstmt.setString(index++,task_code);				
						pstmt.setString(index++,task_seq_no);
						flag = pstmt.executeUpdate();
					}
				}
				
				flag_arr.add(""+flag);
				
				if(!flag_arr.contains("0")){
					commit_flag="Y";
				 }else{
					commit_flag="N";
				 }
				
				MessageManager mm=new MessageManager();
				if(commit_flag.equals("Y") && flag!=0){
					con.commit();
					final java.util.Hashtable mesg = mm.getMessage(locale, "RECORD_INSERTED", "SM") ;
					msg = ((String) mesg.get("message"));
					mesg.clear();	//Common-ICN-0044
				 }else{
					con.rollback();
					final java.util.Hashtable mesg = mm.getMessage(locale, "APP-OH00018", "OH") ;
					msg = ((String) mesg.get("message"));
					mesg.clear();	//Common-ICN-0044
				 }

				 res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode( msg,"UTF-8" ));
	}catch(Exception e){
				try{
					System.err.println("Rollback performed, Err Msg in OHTrmtSendOutAckServlet"+e.getMessage());
					con.rollback();
				}catch(Exception e_1){
					System.err.println("OHTrmtSendOutAckServlet :Caught Exception during rollback"+e_1);
				}

			    System.err.println("Err Msg in OHTrmtSendOutAckServlet"+e.getMessage());
				msg = e.toString();
				res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode( msg,"UTF-8" ));
	}finally{
		try{
				CommonData.clear();	//Common-ICN-0044
				flag_arr.clear();	//Common-ICN-0044
				if(pstmt!=null) pstmt.close();
				if(con!=null) ConnectionManager.returnConnection(con,req);
		}catch(Exception e){}
	  }
    }
 }



