//New file MealAcknowledgementStatusServlet.java created against ML-MMOH-CRF-1061
/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eDS;	

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import webbeans.eCommon.ConnectionManager;

/**
 * Servlet implementation class MealAcknowledgementStatusServlet
 */
public class MealAcknowledgementStatusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PrintWriter out;
	java.util.Properties prop;
	HttpSession session;
	Connection con;
	PreparedStatement pstmt;
	HashMap support_data = new HashMap();
	String msg="";

	StringBuffer sb = new StringBuffer();
	String facility_id="",str_user_id="",str_client_ip_address="",login_user="",locale="",mode="";
	Boolean isUpdateSuccess=false;
	
	String served = "";
	String accept = "";
	String reject = "";   
	String MealPrepared = "";
	String MealReceived = "";
	String MealServed = "";
	String MealRejected = "";
	String patient_class_OP="";
	String status_code1=""; 
	String status_code2=""; 
	String status_code3="";
	String patient_class_IP="";
	String status_code_MP=""; 
	String status_code_MR=""; 
	String status_code_MS="";
	String status_code_MJ="";
	String noOfStatusRequired_OP="";
	String noOfStatusRequired_IP="";
	String OPstatus_Ser_YN="";
	String OPstatus_Acc_YN="";
	String OPstatus_Rej_YN="";
	String IPstatus_Pre_YN="";
	String IPstatus_Rec_YN="";
	String IPstatus_Ser_YN="";
	String IPstatus_Rej_YN="";
	
    public MealAcknowledgementStatusServlet() {
        super();
      
    }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		String error_value = "0" ;
		String error = "";
		//boolean flag=true; //Common-ICN-0044
		session = request.getSession(false);
		this.prop = (java.util.Properties) session.getValue("jdbc");
		this.facility_id = (String) request.getParameter("facilityId");
		if(facility_id == null) facility_id="";
		str_user_id      = (String) session.getValue("login_user");
		if(str_user_id == null) str_user_id="";
		str_client_ip_address = prop.getProperty("client_ip_address");
		login_user = prop.getProperty( "login_user" ) ;
		if(str_client_ip_address == null) str_client_ip_address="";
		if(login_user == null) login_user="";
		locale = prop.getProperty("LOCALE");
		//int count = 0;	//Common-ICN-0044
		try {
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/html;charset=UTF-8");
			this.out = response.getWriter();

			this.served = request.getParameter("served");
			this.accept = request.getParameter("accept");
			this.reject = request.getParameter("reject");
			this.status_code1 = request.getParameter("status_code1");
			this.status_code2 = request.getParameter("status_code2");
			this.status_code3 = request.getParameter("status_code3");
			this.patient_class_OP = request.getParameter("patient_class_OP");	
			this.MealPrepared = request.getParameter("MealPrepared");
			this.MealReceived = request.getParameter("MealReceived");
			this.MealServed = request.getParameter("MealServed");
			this.MealRejected = request.getParameter("MealRejected");
			this.patient_class_IP = request.getParameter("patient_class_IP");
			this.status_code_MP = request.getParameter("status_code_MP");
			this.status_code_MR = request.getParameter("status_code_MR");
			this.status_code_MS = request.getParameter("status_code_MS");
			this.status_code_MJ = request.getParameter("status_code_MJ");
			this.noOfStatusRequired_OP = request.getParameter("noOfStatusRequired_OP");
			this.noOfStatusRequired_IP = request.getParameter("noOfStatusRequired_IP");
			this.facility_id = request.getParameter("facility_id");
			this.OPstatus_Ser_YN = request.getParameter("OPstatus_Ser_YN");
			this.OPstatus_Acc_YN = request.getParameter("OPstatus_Acc_YN");
			this.OPstatus_Rej_YN = request.getParameter("OPstatus_Rej_YN");
			this.IPstatus_Pre_YN = request.getParameter("IPstatus_Pre_YN");
			this.IPstatus_Rec_YN = request.getParameter("IPstatus_Rec_YN");
			this.IPstatus_Ser_YN = request.getParameter("IPstatus_Ser_YN");
			this.IPstatus_Rej_YN = request.getParameter("IPstatus_Rej_YN");
			con	=	ConnectionManager.getConnection(request); 

			String strQuery="update ds_meal_acknowledgement_status set STATUS_DESC=? , STATUS_ACT_YN=? where PATIENT_CLASS=? and STATUS_CODE=? ";
			System.err.println("109 strQuery====>"+strQuery);
			pstmt = con.prepareStatement(strQuery);
			if(served.equals(served)){
			pstmt.setString(1,served);
			pstmt.setString(2,OPstatus_Ser_YN);
			pstmt.setString(3,patient_class_OP);
			pstmt.setString(4,status_code1);
			int row=pstmt.executeUpdate();
				if (row >0)
				{
					isUpdateSuccess = true;
				}
			}
			if(pstmt!=null) pstmt.close();	//Added Against Common-ICN-0031
			if(accept.equals(accept)){
			pstmt.setString(1,accept);
			pstmt.setString(2,OPstatus_Acc_YN);
			pstmt.setString(3,patient_class_OP);
			pstmt.setString(4,status_code2);
			int row=pstmt.executeUpdate();
				if (row >0)
				{
					isUpdateSuccess = true;
				}			
			}
			if(reject.equals(reject)){
			pstmt.setString(1,reject);
			pstmt.setString(2,OPstatus_Rej_YN);
			pstmt.setString(3,patient_class_OP);
			pstmt.setString(4,status_code3);
			int row=pstmt.executeUpdate();
				if (row >0)
				{
					isUpdateSuccess = true;
				}					
			} 

			if(MealPrepared.equals(MealPrepared)){
			pstmt.setString(1,MealPrepared);
			pstmt.setString(2,IPstatus_Pre_YN);
			pstmt.setString(3,patient_class_IP);
			pstmt.setString(4,status_code_MP);
			int row=pstmt.executeUpdate();
				if (row >0)
				{
					isUpdateSuccess = true;
				}		
			}
			if(MealReceived.equals(MealReceived)){
			pstmt.setString(1,MealReceived);
			pstmt.setString(2,IPstatus_Rec_YN);
			pstmt.setString(3,patient_class_IP);
			pstmt.setString(4,status_code_MR);
			int row=pstmt.executeUpdate();
				if (row >0)
				{
					isUpdateSuccess = true;
				}			
			}
			if(MealServed.equals(MealServed)){
			pstmt.setString(1,MealServed);
			pstmt.setString(2,IPstatus_Ser_YN);
			pstmt.setString(3,patient_class_IP);
			pstmt.setString(4,status_code_MS);
			int row=pstmt.executeUpdate();
				if (row >0)
				{
					isUpdateSuccess = true;
				}					
			}
			if(MealRejected.equals(MealRejected)){
			pstmt.setString(1,MealRejected);
			pstmt.setString(2,IPstatus_Rej_YN);
			pstmt.setString(3,patient_class_IP);
			pstmt.setString(4,status_code_MJ);
			int row=pstmt.executeUpdate();
				if (row >0)
				{
					isUpdateSuccess = true;
				}					
			}
			String Ack_status_Qry="update ds_param_for_facility set NO_OF_ACK_STATUS_IP=?, NO_OF_ACK_STATUS_OP=? where OPERATING_FACILITY_ID =? ";
			System.err.println("182 Ack_status_Qry====>"+Ack_status_Qry);
			pstmt = con.prepareStatement(Ack_status_Qry);
			pstmt.setString(1,noOfStatusRequired_OP);
			pstmt.setString(2,noOfStatusRequired_IP);
			pstmt.setString(3,facility_id);
			int row = pstmt.executeUpdate();
				if (row >0)
				{
					isUpdateSuccess = true;
				}	
		if (isUpdateSuccess) {
				error_value = "1" ;
				error = "APP-SM0070 Operation Completed Successfully ....";
		}
		else error = "Record has not been saved. Please try again";
			response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode(error,"UTF-8"  )+"&err_value="+error_value );
		}
		catch(SQLException sqle) {
			System.err.println("202 exception in MealAcknowledgementStatusServlet" + sqle.toString());
			sqle.printStackTrace();
			isUpdateSuccess = false;
		}
		catch(Exception e) {
			System.err.println("207 exception in MealAcknowledgementStatusServlet" + e.toString());
			e.printStackTrace();
			isUpdateSuccess = false;
		}
		finally{	
		try{		
			if(pstmt!=null) pstmt.close();
				if(isUpdateSuccess)
					con.commit();
				else 
				   con.rollback();
				if(con!=null) ConnectionManager.returnConnection(con);
		}catch(SQLException e){
			System.err.println("Final Exception in MealAcknowledgementStatusServlet.java========"+e);
			e.printStackTrace();
		}
		}
	}
}