/*******************************************************************************
/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
 //Created Against ML-MMOH-CRF-0687
package eDS;

import java.io.IOException;
import java.io.PrintWriter;
/*import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Types;*/
import java.sql.Timestamp;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
/*import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;*/
import java.util.*;
import java.net.URLDecoder;
import java.util.LinkedHashMap;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;  
import java.sql.*;
import webbeans.eCommon.ConnectionManager;
import eCommon.Common.CommonBean;
import webbeans.eCommon.MessageManager;

import eDS.Common.JSONObject;
import eDS.Common.JSONArray;
/**
 * Servlet implementation class MealComplaintServlet
 */
public class MealComplaintServlet extends javax.servlet.http.HttpServlet {
	java.util.Properties prop;
	PrintWriter out;
	HttpSession session;
	String locale;
	String error_value = "0" ;
	String error = "";
	String facility_id,str_client_ip_address,login_user="";	
	Boolean insertStatus_SuccessFlag=false;
/**
 * @see HttpServlet#HttpServlet()
 */
public MealComplaintServlet() {
	super();
	// TODO Auto-generated constructor stub
}

/**
 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
 */
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// TODO Auto-generated method stub
}

/**
 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
 */
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String operation="";
	response.setContentType("text/html;charset=UTF-8");	
	operation=request.getParameter("mode");
	//String mealComplaint="";	//Common-ICN-0044
	session = request.getSession(false);
	this.prop = (java.util.Properties) session.getValue("jdbc");
	locale = prop.getProperty("LOCALE");
	System.err.println("84,locale==="+locale);
	if(operation.equals("insertMealComplaint")){
		try {
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/html;charset=UTF-8");
			this.out = response.getWriter();
			MessageManager mm = new MessageManager();
			insertStatus_SuccessFlag=insertMealComplaint(request,response);		
			if(insertStatus_SuccessFlag){			
					final java.util.Hashtable mesg = mm.getMessage(locale,	"DS_OPER_COMPLETE", "DS");
					error = (String) mesg.get("message"); // "APP-SM0070 Operation Completed Successfully ....";
					error_value = "1" ;	
					mesg.clear(); //Common-ICN-0044					
			}else{
					final java.util.Hashtable mesg = mm.getMessage(locale,	"DS_REC_NOTSAV_TRYAGN", "DS");
					error = (String) mesg.get("message"); //"Record has not been saved. Please try again";	
					mesg.clear(); //Common-ICN-0044
			}		
					out.println(error);
			} catch (SQLException e) {
				e.printStackTrace();
				System.err.println("SQLException in MealComplaintServlet.java::::" + e.toString());
			} catch (ParseException e) {
				e.printStackTrace();
				System.err.println("ParseException in MealComplaintServlet.java::::" + e.toString());
			}
		}
	}

	
	private boolean insertMealComplaint(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ParseException
	{
		int flag=0;
		boolean isUpdateSuccess=false;
		PreparedStatement pstmt=null;	
		Connection conn=null; 		
	try
	{	
		conn = ConnectionManager.getConnection(request);
		conn.setAutoCommit(false);
		/* ResultSet rs=null;			
		String P_Error_Text = null; */	//Common-ICN-0044
		String acknowledge1="";
		String MealComplaint_insert ="";
		
		//int count=Integer.parseInt(request.getParameter("ComplaintListcount"));	//Common-ICN-0044	
		
		String jsonData = request.getParameter("jsonData");
		JSONObject json = new JSONObject(jsonData);	
		
		facility_id=json.getString("facility_id");
		String strloggeduser=json.getString("strloggeduser");
		String strclientip=json.getString("strclientip");		
		
		//String status = json.getString("status");		
		/* String acknowledged_by=json.getString("acknowledged_by");
		String acknowledged_date_time=json.getString("acknowledged_date_time"); */	//Common-ICN-0044
		
		JSONArray acknowledgeJSON = json.getJSONArray("acknowledgeArray");
		JSONArray servingdateForJSON = json.getJSONArray("serving_dateArray");
		JSONArray app_noForJSON = json.getJSONArray("app_noArray");
		JSONArray encounter_idForJSON = json.getJSONArray("encounter_idArray");		
		JSONArray statusForJSON = json.getJSONArray("statusArray");//07-Dec-17
		JSONArray mealtype_codeForJSON = json.getJSONArray("mealtype_codeArray");
		

	for(int i=0;i<encounter_idForJSON.length();i++) {
		String acknowledge = acknowledgeJSON.getJSONObject(i).getString("acknowledge").trim();
		String serving_date =servingdateForJSON.getJSONObject(i).getString("serving_date").trim();
		String app_no=app_noForJSON.getJSONObject(i).getString("app_no").trim();
		String encounter_id =encounter_idForJSON.getJSONObject(i).getString("encounter_id").trim();
		String mealtype_code=mealtype_codeForJSON.getJSONObject(i).getString("mealtype_code").trim();		
		String status = statusForJSON.getJSONObject(i).getString("status").trim();//07-Dec-17
		if(acknowledge.equalsIgnoreCase("Yes")){
			MealComplaint_insert="insert into ds_meal_complaint_acknowledge Values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";			

			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			Date servDate = new Date(sdf.parse(serving_date).getTime());
			
			pstmt = conn.prepareStatement(MealComplaint_insert);
			pstmt.setString(1, facility_id);
			
			pstmt.setString(2, encounter_id);
			
			pstmt.setString(3, app_no);
			
			pstmt.setDate(4, servDate);
			
			pstmt.setString(5, mealtype_code);
			
			pstmt.setString(6, status);
			
			pstmt.setString(7, strloggeduser);
			
			pstmt.setTimestamp(8, getCurrentTimeStamp());
			
		if(acknowledge.equalsIgnoreCase("No")){
			acknowledge1="N";
			pstmt.setString(9, acknowledge1);
		}else{
			acknowledge1="Y";
		pstmt.setString(9, acknowledge1);
		}
				pstmt.setString(10,strloggeduser);
				pstmt.setTimestamp(11, getCurrentTimeStamp());
				//pstmt.setDate(11, current_date);
				pstmt.setString(12,strclientip);
				pstmt.setString(13,facility_id );
				pstmt.setString(14, strloggeduser);
				pstmt.setTimestamp(15, getCurrentTimeStamp());
				//pstmt.setDate(15, current_date);
				pstmt.setString(16, strclientip);
				pstmt.setString(17,facility_id);
				pstmt.setString(18,"Y"); //Added Against ML-MMOH-SCF-1926
				flag=pstmt.executeUpdate();
				if(pstmt!=null) pstmt.close(); //Common-ICN-0044
	  }
	}//FOR LOOP	
			if (flag > 0)
			{
				isUpdateSuccess = true;			
			}
}catch(Exception e){
			System.err.println("Exception in MealComplaintServlet.java::::" + e.toString());
			e.printStackTrace();
			isUpdateSuccess = false;
	}finally{	
	try{		
		if(pstmt!=null) pstmt.close();
		if(isUpdateSuccess)
			conn.commit();
		else 
		   conn.rollback();
		if(conn!=null) ConnectionManager.returnConnection(conn);
		}catch(Exception e){
			System.err.println("Final Exception in MealComplaintServlet.java========"+e);
			e.printStackTrace();
		}
	}
	return isUpdateSuccess;
}

	private static java.sql.Timestamp getCurrentTimeStamp() {
	    java.util.Date today = new java.util.Date();
	    return new java.sql.Timestamp(today.getTime());
	}
}
