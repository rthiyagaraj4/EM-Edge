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
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.sql.*;
import java.sql.Date;
import java.io.*;
import java.util.*;

import javax.naming.*;
import javax.rmi.*;
import java.net.*;
import webbeans.eCommon.*;
import eDS.*;
import com.ehis.persist.*;
import com.ehis.util.DateUtils;
import eCommon.XSSRequestWrapper;
import eCommon.Common.*;

/**
 * Servlet implementation class MealPreparedServedComplaintsServlet
 */
public class MealPreparedServedComplaintsServlet extends HttpServlet {
     // Checkstyle Violation commented by Munisekhar
	//private static final long serialVersionUID = 1L;
	PrintWriter out;
	java.util.Properties prop;
	HttpSession session;
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	HashMap support_data = new HashMap();
	String msg="";

	StringBuffer sb = new StringBuffer();

	String tabName,facility_id,str_client_ip_address,login_user, str_user_id,encounterId,mealType,servingDate,servingDate_Freq,patientClass,kitchenCode,mealCategory,mealClass,menuCode,status,complaintCode,complaintDesc,dietType,itemCode,itemQty,itemSL,itemType,eventDate,eventDate_Freq,eventDate_NonFreq,date_time,patientId,MealReplaceYn,rejected_by,othersComplaintsDesc; //CRF-681 & MOH-CRF-1125
	Date serving_Date;
	java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "yyyy-MM-dd" ) ;
	int totalRecords,startIndex;
	String locale;

	String sStyle = "";


    /**
     * @see HttpServlet#HttpServlet()
     */
    public MealPreparedServedComplaintsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
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
		
		//Added Against MMS Vulnerability Issue - Starts
        request= new XSSRequestWrapper(request);
        response.addHeader("X-XSS-Protection", "1; mode=block");
        response.addHeader("X-Content-Type-Options", "nosniff");
        //Added Against MMS Vulnerability Issue - Ends 

		// TODO Auto-generated method stub
		String error_value = "0" ;
		String error = "";
		boolean successFlag=true;
		boolean rejectedSuccessFlag=true;
		session = request.getSession(false);
		this.prop = (java.util.Properties) session.getValue("jdbc");
		this.facility_id = (String) request.getParameter("facility_id");
		if(facility_id == null) facility_id="";
		str_user_id      = (String) session.getValue("login_user");
		if(str_user_id == null) str_user_id="";
		this.totalRecords=Integer.parseInt((String)request.getParameter("totalRecords"));
		this.startIndex=Integer.parseInt((String)request.getParameter("startIndex"));
		this.tabName = (String) request.getParameter("tabName");
		str_client_ip_address = prop.getProperty("client_ip_address");
		login_user = prop.getProperty( "login_user" ) ;
		if(str_client_ip_address == null) str_client_ip_address="";
		if(login_user == null) login_user="";

		sStyle = (session.getAttribute("PREFERRED_STYLE") != null)
				|| (session.getAttribute("PREFERRED_STYLE") != "") ? (String) session
				.getAttribute("PREFERRED_STYLE")
				: "IeStyle.css";
		locale = prop.getProperty("LOCALE");
		try
		{
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/html;charset=UTF-8");
			this.out = response.getWriter();
			System.err.println("totalRecords --->>>"+totalRecords);
			for(int i=startIndex;i<=totalRecords;i++) {
				this.encounterId=(String)request.getParameter("encounterId"+i);
				if(encounterId!=null) {
					getData(request,i);
					boolean flag=isRecordAlreadyExists(request,response);
					System.err.println("flag--->>>"+flag+"for i="+i);
					//IN:39965
					if(flag) {
						if(tabName.equals("mealTypeTab") && status.length()>0){ 
							updateRecords(request,response);							
						} 
						else if((tabName.equals("spFoodItemsTab")|| tabName.equals("freqBasedTab")) && status.length()>0) successFlag= successFlag && updateFreqBasedRecords(request,response);
						else if(tabName.equals("nonFreqBasedTab") && status.length()>0) successFlag=successFlag && updateNonFreqBasedRecords(request,response);
					}
					else {
						if(tabName.equals("mealTypeTab")) insertRecords(request,response);
						else if(tabName.equals("spFoodItemsTab")|| tabName.equals("freqBasedTab")) successFlag= successFlag && insertFreqBasedRecords(request,response);
						else if(tabName.equals("nonFreqBasedTab")) successFlag=successFlag && insertNonFreqBasedRecords(request,response);
					}
					System.err.println("status--->>>"+status+"for i="+i);
					if(status.equals("MJ")) {
						boolean rejectedFlag=isRejectedRecordAlreadyExists(request,response);
						System.err.println("rejectedFlag--->>>"+rejectedFlag+"for i="+i);
						if(rejectedFlag) {
							if(tabName.equals("mealTypeTab"));// updateRejectedRecords(request,response);
							else if(tabName.equals("spFoodItemsTab")|| tabName.equals("freqBasedTab")) rejectedSuccessFlag= rejectedSuccessFlag && updateFreqBasedRejectedRecords(request,response);
							else if(tabName.equals("nonFreqBasedTab")) rejectedSuccessFlag=rejectedSuccessFlag && updateNonFreqBasedRejectedRecords(request,response);
						}
						else {
							if(tabName.equals("mealTypeTab"));// insertRejectedRecords(request,response);
							else if(tabName.equals("spFoodItemsTab")|| tabName.equals("freqBasedTab")) rejectedSuccessFlag= rejectedSuccessFlag && insertFreqBasedRejectedRecords(request,response);
							else if(tabName.equals("nonFreqBasedTab")) rejectedSuccessFlag=rejectedSuccessFlag && insertNonFreqBasedRejectedRecords(request,response);
						}
					}
				}
			}
			MessageManager mm = new MessageManager();
			if ( successFlag && rejectedSuccessFlag )
			{
				error_value = "1" ;
				final java.util.Hashtable mesg = mm.getMessage(locale,	"DS_OPER_COMPLETE", "DS");
				error = (String) mesg.get("message");// "APP-SM0070 Operation Completed Successfully ....";
				mesg.clear();	//Common-ICN-0044
			}
			else
			{
				if (!successFlag) {
					final java.util.Hashtable mesg = mm.getMessage(locale,	"DS_AUDREC_NOTSAV_TRYAGN", "DS");
					error = (String) mesg.get("message"); //"One or more Audit records have not been saved. Please try again";
					mesg.clear();	//Common-ICN-0044
				}
				if (!rejectedSuccessFlag) {
					final java.util.Hashtable mesg = mm.getMessage(locale,	"DS_REJREC_NOTSAV_TRYAGN", "DS");
					error = (String) mesg.get("message"); //"One or more Rejected records have not been saved. Please try again";
					mesg.clear();	//Common-ICN-0044
					}
			}
			response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode(error,"UTF-8"  )+"&err_value="+error_value );
		}
		catch (Exception e)
		{
			System.err.println("Exception in doPost=" + e.toString());
			e.printStackTrace();
			out.println(e.toString());
			response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode(error,"UTF-8"  )+"&err_value="+error_value );
		}
		System.err.println("TEST TEST TEST TEST IN SERVLETTTTTTTTTTT");
	}
	//CRF-681
	private String isEmpty(String obj)
	{
		if(obj == null)
			return  "";
		else
			return obj;
	}
	//CRF-681
	private boolean isRecordAlreadyExists(HttpServletRequest req,HttpServletResponse res) throws SQLException {
		session = req.getSession(false);

		try {
			con	=	ConnectionManager.getConnection(req);
			System.out.println("facility_id---->"+facility_id);
			System.out.println("encounterId---->"+encounterId);
			System.out.println("servingDate---->"+servingDate);
			System.out.println("servingDate_Freq---->"+servingDate_Freq);
			System.out.println("mealType---->"+mealType);
			System.out.println("itemCode---->"+itemCode);
			String strQuery;
			if(tabName.equals("mealTypeTab")) {
				strQuery="SELECT * FROM DS_EPSD_MEAL_PLAN_HDR_AUDIT WHERE OPERATING_FACILITY_ID=? AND ENCOUNTER_ID=? AND SERVING_DATE=to_date(?,'DD/MM/YYYY') AND MEAL_TYPE=?";
				pstmt = con.prepareStatement(strQuery,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
				pstmt.setString(1,facility_id);
				pstmt.setString(2,encounterId);
				pstmt.setString(3,servingDate);
				pstmt.setString(4,mealType);
			}
			else {
				//Added against 060395 Starts
				//strQuery="SELECT * FROM DS_EPSD_MEAL_PLAN_SPL_AUDIT WHERE OPERATING_FACILITY_ID=? AND ENCOUNTER_ID=? AND SERVING_DATE=to_date(?,'DD/MM/YYYY hh24:mi') and meal_type=? AND ITEM_CODE=?";
				// Removed meal type AND MEAL_TYPE=?
				if(tabName.equals("nonFreqBasedTab")){
					strQuery="SELECT * FROM DS_EPSD_MEAL_PLAN_SPL_AUDIT WHERE OPERATING_FACILITY_ID=? AND ENCOUNTER_ID=? AND SERVING_DATE=to_date(?,'DD/MM/YYYY hh24:mi') AND MEAL_TYPE=? AND ITEM_CODE=?";					
				}else{
					strQuery="SELECT * FROM DS_EPSD_MEAL_PLAN_SPL_AUDIT WHERE OPERATING_FACILITY_ID=? AND ENCOUNTER_ID=? AND SERVING_DATE=to_date(?,'DD/MM/YYYY hh24:mi') AND ITEM_CODE=?";
					
				}
				pstmt = con.prepareStatement(strQuery,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
				pstmt.setString(1,facility_id);
				pstmt.setString(2,encounterId);
				pstmt.setString(3,date_time);
				if(tabName.equals("nonFreqBasedTab")){
					pstmt.setString(4,mealType);
					pstmt.setString(5,itemCode);
					
				}else{
					pstmt.setString(4,itemCode);
					
				}
				//Added against 060395 Ends
			}

			rs=pstmt.executeQuery();
			rs.last();	int maxRecord = rs.getRow();
		    if(maxRecord > 0){
				out.println("Record Already exists. Update should be done");
				return true;
			}
		    else {
		    	out.println("Record doesn't exists. Insert should be done");
		    	return false;
		    }
		}
		catch(Exception e) {
			System.err.println("exception in main=" + e.toString());
			e.printStackTrace();
/*			out.println("<h3> Exception raise by Servlet ...So Record Not inserted </h3> Foll: Error Received : "
							+ e.toString() + sb.toString());
			out.println("Values sent are : <br>");*/
		}
		finally {
		//Checkstyle Correction added by Munisekhar
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
		//if(con!=null) con.close();
		if(con!=null)ConnectionManager.returnConnection(con,req); //Common-ICN-0052	
		}
		return false;
	}

	private boolean isRejectedRecordAlreadyExists(HttpServletRequest req,HttpServletResponse res) throws SQLException {
		session = req.getSession(false);

		try {
			con	=	ConnectionManager.getConnection(req);
			System.out.println("isRejectedRecordAlreadyExists:encounterId---->"+encounterId);
			System.out.println("isRejectedRecordAlreadyExists:tabName---->"+tabName);
			String strQuery;
			if(tabName.equals("mealTypeTab")) {
				strQuery="SELECT * FROM DS_EPSD_MEAL_PLAN_HDR_AUDIT WHERE OPERATING_FACILITY_ID=? AND ENCOUNTER_ID=? AND SERVING_DATE=to_date(?,'DD/MM/YYYY') AND MEAL_TYPE=?";
				pstmt = con.prepareStatement(strQuery,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
				pstmt.setString(1,facility_id);
				pstmt.setString(2,encounterId);
				pstmt.setString(3,servingDate);
				pstmt.setString(4,mealType);
			}
			else if(tabName.equals("spFoodItemsTab")|| tabName.equals("freqBasedTab")) {
				strQuery="SELECT * FROM DS_EPSD_MEAL_ITEM_REJECTIONS REJECTIONS WHERE REJECTIONS.OPERATING_FACILITY_ID=? AND REJECTIONS.ENCOUNTER_ID=? AND REJECTIONS.SERVING_DATE=to_date(?,'DD/MM/YYYY hh24:mi') AND REJECTIONS.MEAL_TYPE=? AND REJECTIONS.ITEM_CODE=? AND REJECTIONS.SPL_FOOD_ITEM_YN=?";
				pstmt = con.prepareStatement(strQuery,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
				pstmt.setString(1,facility_id);
				pstmt.setString(2,encounterId);
				pstmt.setString(3,date_time);
				pstmt.setString(4,"##");
				pstmt.setString(5,itemCode);
				pstmt.setString(6,"Y");
			}
			else if(tabName.equals("nonFreqBasedTab")) {
				strQuery="SELECT * FROM DS_EPSD_MEAL_ITEM_REJECTIONS REJECTIONS WHERE REJECTIONS.OPERATING_FACILITY_ID=? AND REJECTIONS.ENCOUNTER_ID=? AND REJECTIONS.SERVING_DATE=to_date(?,'DD/MM/YYYY hh24:mi') AND REJECTIONS.MEAL_TYPE=? AND REJECTIONS.ITEM_CODE=? AND REJECTIONS.SPL_FOOD_ITEM_YN=?";
				pstmt = con.prepareStatement(strQuery,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
				pstmt.setString(1,facility_id);
				pstmt.setString(2,encounterId);
				pstmt.setString(3,date_time);
				pstmt.setString(4,mealType);
				pstmt.setString(5,itemCode);
				pstmt.setString(6,"Y");
			}

			rs=pstmt.executeQuery();
			rs.last();	int maxRecord = rs.getRow();
		    if(maxRecord > 0){
				out.println("Rejected Record Already exists. Update should be done");
				return true;
			}
		    else {
		    	out.println("Rejected Record doesn't exists. Insert should be done");
		    	return false;
		    }
		}
		catch(Exception e) {
			System.err.println("exception in main=" + e.toString());
			e.printStackTrace();
		}
		finally {
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
		//if(con!=null) con.close();
		if(con!=null)ConnectionManager.returnConnection(con,req); //Common-ICN-0052
		}
		return false;
	}

	private boolean insertRecords(HttpServletRequest request,
			HttpServletResponse response)  throws SQLException {
		boolean isInsertSuccess=false;
		try {
			con	=	ConnectionManager.getConnection(request);
			StringBuffer strQuery = new StringBuffer();
			
			if(!status.equals("")){
			strQuery.append("INSERT INTO DS_EPSD_MEAL_PLAN_HDR_AUDIT");	
			strQuery.append("(MEAL_CLASS, DIET_TYPE, MENU_CODE, KITCHEN_CODE, PATIENT_CLASS, EVENT_DATE_TIME, MEAL_CATEGORY, STATUS, COMPLAINT_CODE, COMPLAINT_DESC, COMPLAINT_SOURCE_TYPE, COMPLAINT_SOURCE_CODE, ADDED_BY_ID, ADDED_DATE, ADDED_FACILITY_ID, ADDED_AT_WS_NO, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_FACILITY_ID, MODIFIED_AT_WS_NO, OPERATING_FACILITY_ID, ENCOUNTER_ID, SERVING_DATE, MEAL_TYPE");
			/*Added Against Start ML-MMOH-CRF-681*/
			int count=24;		
			if(status.equals("MS"))
				strQuery.append(" ,SERVED_DATE_TIME");
			if((status=="MJ" || status.equals("MJ")) && (rejected_by=="" || rejected_by.equals(""))) //Rejected  status
			strQuery.append(" ,REJECTED_BY");
			
			strQuery.append(" ,MEAL_REPLACE_YN");  
			strQuery.append(" ,OTH_COMPLAINT_DESC");  //Added Against ML-MOH-CRF-1125
			strQuery.append(" )");  
			/*Added Against End ML-MMOH-CRF-681*/
			strQuery.append(" VALUES (?, ?, ?, ?, ?, TO_DATE(?, 'DD/MM/YYYY HH24:MI'), ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, to_date(?,'DD/MM/YYYY'), ?");
			if(status.equals("MS"))
			strQuery.append(" , to_date(?,'DD/MM/YYYY hh24:mi')");
			if((status=="MJ" || status.equals("MJ")) && (rejected_by=="" || rejected_by.equals(""))) //Rejected  status
			strQuery.append(" , ?");
			
			strQuery.append(" , ?, ?)"); //Added Against ML-MOH-CRF-1125
			pstmt = con.prepareStatement(strQuery.toString());
			pstmt.setString(1,mealClass);
			pstmt.setString(2,dietType);
			pstmt.setString(3,menuCode);
			pstmt.setString(4,kitchenCode);
			pstmt.setString(5,patientClass);
			pstmt.setString(6,eventDate);
			pstmt.setString(7,mealCategory);
			pstmt.setString(8,status);
			pstmt.setString(9,complaintCode);
			pstmt.setString(10,complaintDesc);
//			TODO: check if complaint source type should be 'N' always
			pstmt.setString(11,"N");
			pstmt.setString(12,"");
			pstmt.setString(13,login_user);
			pstmt.setTimestamp(14, new  java.sql.Timestamp(System.currentTimeMillis()));
			pstmt.setString(15,facility_id);
			pstmt.setString(16,str_client_ip_address);
			pstmt.setString(17,login_user);
			pstmt.setTimestamp(18, new  java.sql.Timestamp(System.currentTimeMillis()));
			pstmt.setString(19,facility_id);
			pstmt.setString(20,str_client_ip_address);
			pstmt.setString(21,facility_id);
			pstmt.setInt(22,Integer.parseInt(encounterId));
			pstmt.setString(23,servingDate);
			pstmt.setString(24,mealType);
			/*Added Against Start ML-MMOH-CRF-681*/
			if(status.equals("MS") || status.equals("MS"))
			pstmt.setString(++count,eventDate);
			if((status=="MJ" || status.equals("MJ")) && (rejected_by=="" || rejected_by.equals("")))
			pstmt.setString(++count,login_user);		
			pstmt.setString(++count,isEmpty(MealReplaceYn));
			pstmt.setString(++count,othersComplaintsDesc);	//Added Against MOH-CRF-1125
			/*Added Against End ML-MMOH-CRF-681*/

			int row=pstmt.executeUpdate();
			if (row >0)
			{
				isInsertSuccess = true;
			}
			}
		}
		catch(Exception e) {
			System.err.println("exception in insertRecords method=" + e.toString());
			e.printStackTrace();
			con.close();
			isInsertSuccess = false;
		}
		finally {
			pstmt.close();
			if(isInsertSuccess)con.commit();
			else con.rollback();
			//con.close();
			if(con!=null)ConnectionManager.returnConnection(con,request); //Common-ICN-0052
		}
		return isInsertSuccess;
	}

	private boolean insertFreqBasedRecords(HttpServletRequest request,
			HttpServletResponse response)  throws SQLException {
		boolean isInsertSuccess=false;
		try {
			con	=	ConnectionManager.getConnection(request);
			String strQuery="INSERT INTO DS_EPSD_MEAL_PLAN_SPL_AUDIT (ITEM_SL, ITEM_TYPE, ITEM_QTY, FREQ_YN, ADDED_BY_ID, ADDED_DATE, ADDED_FACILITY_ID, ADDED_AT_WS_NO, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_FACILITY_ID, MODIFIED_AT_WS_NO, EVENT_DATE_TIME, STATUS, COMPLAINT_CODE, COMPLAINT_DESC, COMPLAINT_SOURCE_TYPE, COMPLAINT_SOURCE_CODE, OPERATING_FACILITY_ID, ENCOUNTER_ID, SERVING_DATE, MEAL_TYPE, ITEM_CODE, MEAL_REPLACE_YN, OTH_COMPLAINT_DESC) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, to_date(?,'DD/MM/YYYY hh24:mi'), ?, ?, ?, ?, ?, ?, ?, to_date(?,'DD/MM/YYYY hh24:mi'), ?, ?, ?, ?)"; 
			// Modified Against ML-MMOH-CRF-681 and CRF-1125
			pstmt = con.prepareStatement(strQuery);
			pstmt.setString(1,itemSL);
			pstmt.setString(2,itemType);
			pstmt.setString(3,itemQty);
			pstmt.setString(4,"Y");
			pstmt.setString(5,login_user);
			pstmt.setTimestamp(6,new  java.sql.Timestamp(System.currentTimeMillis()));
			pstmt.setString(7,facility_id);
			pstmt.setString(8,str_client_ip_address);
			pstmt.setString(9,login_user);
			pstmt.setTimestamp(10,new  java.sql.Timestamp(System.currentTimeMillis()));
			pstmt.setString(11,facility_id);
			pstmt.setString(12,str_client_ip_address);
			pstmt.setString(13,eventDate_Freq);
			pstmt.setString(14,status);
			pstmt.setString(15,complaintCode);
			pstmt.setString(16,complaintDesc);
//			TODO: check if complaint source type should be 'N' always
			pstmt.setString(17,"N");
			pstmt.setString(18, "");
			pstmt.setString(19,facility_id);
			pstmt.setInt(20,Integer.parseInt(encounterId));
			pstmt.setString(21,date_time);
			pstmt.setString(22,"##");
			pstmt.setString(23,itemCode);
			pstmt.setString(24,isEmpty(MealReplaceYn)); // Added Against ML-MMOH-CRF-681
			pstmt.setString(25,othersComplaintsDesc); // Added Against ML-MMOH-CRF-1125
			int row=pstmt.executeUpdate();
			if (row >0)
			{
				isInsertSuccess = true;
			}
		}
		catch(Exception e) {
			System.err.println("exception in insertRecords method=" + e.toString());
			e.printStackTrace();
			con.close();
			isInsertSuccess = false;
		}
		finally {
			pstmt.close();
			if(isInsertSuccess)con.commit();
			else con.rollback();
			//con.close();
			if(con!=null)ConnectionManager.returnConnection(con,request); //Common-ICN-0052
		}
		return isInsertSuccess;
	}

	private boolean insertNonFreqBasedRecords(HttpServletRequest request,
			HttpServletResponse response)  throws SQLException {
		boolean isInsertSuccess=false;
		try {
			con	=	ConnectionManager.getConnection(request);
			String strQuery="INSERT INTO DS_EPSD_MEAL_PLAN_SPL_AUDIT (ITEM_SL, ITEM_TYPE, ITEM_QTY, FREQ_YN, ADDED_BY_ID, ADDED_DATE, ADDED_FACILITY_ID, ADDED_AT_WS_NO, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_FACILITY_ID, MODIFIED_AT_WS_NO, EVENT_DATE_TIME, STATUS, COMPLAINT_CODE, COMPLAINT_DESC, COMPLAINT_SOURCE_TYPE, COMPLAINT_SOURCE_CODE, OPERATING_FACILITY_ID, ENCOUNTER_ID, SERVING_DATE, MEAL_TYPE, ITEM_CODE, MEAL_REPLACE_YN, OTH_COMPLAINT_DESC) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, to_date(?,'DD/MM/YYYY hh24:mi'), ?, ?, ?, ?, ?, ?, ?, to_date(?,'DD/MM/YYYY hh24:mi'), ?, ?, ?, ?)"; // Modified Against ML-MMOH-CRF-681 and ML-MMOH-CRF-1125
			pstmt = con.prepareStatement(strQuery);
			pstmt.setString(1,itemSL);
			pstmt.setString(2,itemType);
			pstmt.setString(3,itemQty);
			pstmt.setString(4,"N");
			pstmt.setString(5,login_user);
			pstmt.setTimestamp(6,new  java.sql.Timestamp(System.currentTimeMillis()));
			pstmt.setString(7,facility_id);
			pstmt.setString(8,str_client_ip_address);
			pstmt.setString(9,login_user);
			pstmt.setTimestamp(10,new  java.sql.Timestamp(System.currentTimeMillis()));
			pstmt.setString(11,facility_id);
			pstmt.setString(12,str_client_ip_address);
			pstmt.setString(13,eventDate_NonFreq);
			pstmt.setString(14,status);
			pstmt.setString(15,complaintCode);
			pstmt.setString(16,complaintDesc);
//			TODO: check if complaint source type should be 'N' always
			pstmt.setString(17,"N");
			pstmt.setString(18, "");
			pstmt.setString(19,facility_id);
			pstmt.setInt(20,Integer.parseInt(encounterId));
			pstmt.setString(21,date_time);
			pstmt.setString(22,mealType);
			pstmt.setString(23,itemCode);
			pstmt.setString(24,isEmpty(MealReplaceYn)); // Added Against ML-MMOH-CRF-681
			pstmt.setString(25,othersComplaintsDesc); // Added Against ML-MMOH-CRF-1125

			int row=pstmt.executeUpdate();
			if (row >0)
			{
				isInsertSuccess = true;
			}
		}
		catch(Exception e) {
			System.err.println("exception in insertRecords method=" + e.toString());
			e.printStackTrace();
			con.close();
			isInsertSuccess = false;
		}
		finally {
			pstmt.close();
			if(isInsertSuccess)con.commit();
			else con.rollback();
			//con.close();
			if(con!=null)ConnectionManager.returnConnection(con,request); //Common-ICN-0052
		}
		return isInsertSuccess;
	}

	private boolean insertFreqBasedRejectedRecords(HttpServletRequest request,
			HttpServletResponse response)  throws SQLException {
		boolean isInsertSuccess=false;
		try {
			con	=	ConnectionManager.getConnection(request);
			String strQuery="INSERT INTO DS_EPSD_MEAL_ITEM_REJECTIONS (KITCHEN_CODE, PATIENT_ID, PATIENT_CLASS, SOURCE_TYPE, SOURCE_CODE, DIET_TYPE, REJECTED_QTY, MEAL_SERVED_DATE, REJECTED_DATE, REJECTED_REASON, FREQ_YN, REJECTED_YN, ADDED_BY_ID, ADDED_DATE, ADDED_FACILITY_ID, ADDED_AT_WS_NO, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_FACILITY_ID, MODIFIED_AT_WS_NO, OPERATING_FACILITY_ID, ENCOUNTER_ID, SERVING_DATE, MEAL_TYPE, ITEM_CODE, SPL_FOOD_ITEM_YN, OTH_COMPLAINT_DESC) VALUES (?, ?, ?, ?, ?, ?, ?, to_date(?,'DD/MM/YYYY hh24:mi'), to_date(?,'DD/MM/YYYY hh24:mi'), ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, to_date(?,'DD/MM/YYYY hh24:mi'), ?, ?, ?, ?)"; //Added Against ML-MOH-CRF-1125
			pstmt = con.prepareStatement(strQuery);
			pstmt.setString(1,kitchenCode);
			pstmt.setString(2,patientId);
			pstmt.setString(3,patientClass);
			pstmt.setString(4,"N");
			//TODO:SourceCode
			pstmt.setString(5,"");
			pstmt.setString(6,dietType);
			pstmt.setString(7,itemQty);
			pstmt.setString(8,eventDate_Freq);
			pstmt.setString(9,eventDate_Freq);
			pstmt.setString(10,complaintCode);
			pstmt.setString(11,"Y");
			pstmt.setString(12,"Y");
			pstmt.setString(13,login_user);
			pstmt.setTimestamp(14,new  java.sql.Timestamp(System.currentTimeMillis()));
			pstmt.setString(15,facility_id);
			pstmt.setString(16,str_client_ip_address);
			pstmt.setString(17,login_user);
			pstmt.setTimestamp(18,new  java.sql.Timestamp(System.currentTimeMillis()));
			pstmt.setString(19,facility_id);
			pstmt.setString(20,str_client_ip_address);
			pstmt.setString(21,facility_id);
			pstmt.setInt(22,Integer.parseInt(encounterId));
			pstmt.setString(23,date_time);
			pstmt.setString(24,"##");
			pstmt.setString(25,itemCode);
			pstmt.setString(26,"Y");
			pstmt.setString(27,othersComplaintsDesc);  //Added Against ML-MOH-CRF-1125

			int row=pstmt.executeUpdate();
			if (row >0)
			{
				isInsertSuccess = true;
			}
		}
		catch(SQLException sqle) {
			System.err.println("exception in insertRecords method=" + sqle.toString());
			sqle.printStackTrace();
			con.close();
			isInsertSuccess = false;
		}
		catch(Exception e) {
			System.err.println("exception in insertRecords method=" + e.toString());
			e.printStackTrace();
			con.close();
			isInsertSuccess = false;
		}
		finally {
			pstmt.close();
			if(isInsertSuccess)con.commit();
			else con.rollback();
			//con.close();
			if(con!=null)ConnectionManager.returnConnection(con,request); //Common-ICN-0052
		}
		return isInsertSuccess;
	}

	private boolean insertNonFreqBasedRejectedRecords(HttpServletRequest request,
			HttpServletResponse response)  throws SQLException {
		boolean isInsertSuccess=false;
		try {
			con	=	ConnectionManager.getConnection(request);
			String strQuery="INSERT INTO DS_EPSD_MEAL_ITEM_REJECTIONS (KITCHEN_CODE, PATIENT_ID, PATIENT_CLASS, SOURCE_TYPE, SOURCE_CODE, DIET_TYPE, REJECTED_QTY, MEAL_SERVED_DATE, REJECTED_DATE, REJECTED_REASON, FREQ_YN, REJECTED_YN, ADDED_BY_ID, ADDED_DATE, ADDED_FACILITY_ID, ADDED_AT_WS_NO, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_FACILITY_ID, MODIFIED_AT_WS_NO, OPERATING_FACILITY_ID, ENCOUNTER_ID, SERVING_DATE, MEAL_TYPE, ITEM_CODE, SPL_FOOD_ITEM_YN, OTH_COMPLAINT_DESC) VALUES (?, ?, ?, ?, ?, ?, ?, to_date(?,'DD/MM/YYYY hh24:mi'), to_date(?,'DD/MM/YYYY hh24:mi'), ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, to_date(?,'DD/MM/YYYY hh24:mi'), ?, ?, ?, ?)"; //Added Against ML-MOH-CRF-1125
			pstmt = con.prepareStatement(strQuery);
			pstmt.setString(1,kitchenCode);
			pstmt.setString(2,patientId);
			pstmt.setString(3,patientClass);
			pstmt.setString(4,"N");
			//TODO:SourceCode
			pstmt.setString(5,"");
			pstmt.setString(6,dietType);
			pstmt.setString(7,itemQty);
			pstmt.setString(8,eventDate_NonFreq);
			pstmt.setString(9,eventDate_NonFreq);
			pstmt.setString(10,complaintCode);
			pstmt.setString(11,"N");
			pstmt.setString(12,"Y");
			pstmt.setString(13,login_user);
			pstmt.setTimestamp(14,new  java.sql.Timestamp(System.currentTimeMillis()));
			pstmt.setString(15,facility_id);
			pstmt.setString(16,str_client_ip_address);
			pstmt.setString(17,login_user);
			pstmt.setTimestamp(18,new  java.sql.Timestamp(System.currentTimeMillis()));
			pstmt.setString(19,facility_id);
			pstmt.setString(20,str_client_ip_address);
			pstmt.setString(21,facility_id);
			pstmt.setInt(22,Integer.parseInt(encounterId));
			pstmt.setString(23,date_time);
			pstmt.setString(24,mealType);
			pstmt.setString(25,itemCode);
			pstmt.setString(26,"Y");
			pstmt.setString(27,othersComplaintsDesc);  //Added Against ML-MOH-CRF-1125
			int row=pstmt.executeUpdate();
			if (row >0)
			{
				isInsertSuccess = true;
			}
		}
		catch(SQLException sqle) {
			System.err.println("exception in insertRecords method=" + sqle.toString());
			sqle.printStackTrace();
			con.close();
			isInsertSuccess = false;
		}
		catch(Exception e) {
			System.err.println("exception in insertRecords method=" + e.toString());
			e.printStackTrace();
			con.close();
			isInsertSuccess = false;
		}
		finally {
			pstmt.close();
			if(isInsertSuccess)con.commit();
			else con.rollback();
			//con.close();
			if(con!=null)ConnectionManager.returnConnection(con,request); //Common-ICN-0052
		}
		return isInsertSuccess;
	}


	private boolean updateFreqBasedRecords(HttpServletRequest request,
			HttpServletResponse response)   throws SQLException {
		boolean isUpdateSuccess=false;
		try {
			con	=	ConnectionManager.getConnection(request);
			String strQuery="update DS_EPSD_MEAL_PLAN_SPL_AUDIT set ITEM_SL=?, ITEM_TYPE=?, ITEM_QTY=?, FREQ_YN=?, ADDED_BY_ID=?, ADDED_DATE=?," +
					" ADDED_FACILITY_ID=?, ADDED_AT_WS_NO=?, MODIFIED_BY_ID=?, MODIFIED_DATE=?, MODIFIED_FACILITY_ID=?, MODIFIED_AT_WS_NO=?," +
					" EVENT_DATE_TIME=to_date(?,'DD/MM/YYYY hh24:mi'), STATUS=?, COMPLAINT_CODE=?, COMPLAINT_DESC=?, COMPLAINT_SOURCE_TYPE=?," +
					" COMPLAINT_SOURCE_CODE=?, MEAL_REPLACE_YN=?, OTH_COMPLAINT_DESC=?  where OPERATING_FACILITY_ID=? and ENCOUNTER_ID=? and SERVING_DATE=to_date(?,'DD/MM/YYYY hh24:mi') and MEAL_TYPE=? and ITEM_CODE=?"; // MEAL_REPLACE_YN Added Against ML-MMOH-CRF-681 and CRF-1125
			pstmt = con.prepareStatement(strQuery);
			pstmt.setString(1,itemSL);
			pstmt.setString(2,itemType);
			pstmt.setString(3,itemQty);
			pstmt.setString(4,"Y");
			pstmt.setString(5,login_user);
			pstmt.setTimestamp(6,new  java.sql.Timestamp(System.currentTimeMillis()));
			pstmt.setString(7,facility_id);
			pstmt.setString(8,str_client_ip_address);
			pstmt.setString(9,login_user);
			pstmt.setTimestamp(10,new  java.sql.Timestamp(System.currentTimeMillis()));
			pstmt.setString(11,facility_id);
			pstmt.setString(12,str_client_ip_address);
			pstmt.setString(13,eventDate_Freq);
			pstmt.setString(14,status);
			pstmt.setString(15,complaintCode);
			pstmt.setString(16,complaintDesc);
//			TODO: check if complaint source type should be 'N' always
			pstmt.setString(17,"N");
			pstmt.setString(18, "");
			// Added Against ML-MMOH-CRF-681
			pstmt.setString(19,isEmpty(MealReplaceYn)); 
			pstmt.setString(20,othersComplaintsDesc); // Added Against ML-MMOH-CRF-1125
			pstmt.setString(21,facility_id);
			pstmt.setInt(22,Integer.parseInt(encounterId));
			pstmt.setString(23,date_time);
			pstmt.setString(24,"##");
			pstmt.setString(25,itemCode);
			//Added Against ML-MMOH-CRF-681
			int row=pstmt.executeUpdate();
			if (row >0)
			{
				isUpdateSuccess = true;
			}
		}
		catch(Exception e) {
			System.err.println("exception in updateRecords method=" + e.toString());
			e.printStackTrace();
			con.close();
			isUpdateSuccess = false;
		}
		finally {
			pstmt.close();
			if(isUpdateSuccess)con.commit();
			else con.rollback();
			//con.close();
			if(con!=null)ConnectionManager.returnConnection(con,request); //Common-ICN-0052
		}
		return isUpdateSuccess;
	}

	private boolean updateRecords(HttpServletRequest request,
			HttpServletResponse response)   throws SQLException {
		boolean isUpdateSuccess=false;
		try {
			int count=0;
			con	=	ConnectionManager.getConnection(request);
			//String strQuery="update DS_EPSD_MEAL_PLAN_HDR_AUDIT set MEAL_CLASS=?, DIET_TYPE=?, MENU_CODE=?, KITCHEN_CODE=?, PATIENT_CLASS=?, EVENT_DATE_TIME=TO_DATE(?, 'DD/MM/YYYY HH24:MI'), MEAL_CATEGORY=?, STATUS=?, COMPLAINT_CODE=?, COMPLAINT_DESC=?, COMPLAINT_SOURCE_TYPE=?, COMPLAINT_SOURCE_CODE=?, ADDED_BY_ID=?, ADDED_DATE=?, ADDED_FACILITY_ID=?, ADDED_AT_WS_NO=?, MODIFIED_BY_ID=?, MODIFIED_DATE=?, MODIFIED_FACILITY_ID=?, MODIFIED_AT_WS_NO=? where OPERATING_FACILITY_ID=? and ENCOUNTER_ID=? and SERVING_DATE=to_date(?,'DD/MM/YYYY') and MEAL_TYPE=?";

			// Added Against Start ML-MMOH-CRF-681 & Modified Against MOH-CRF-1125
			StringBuffer strQuery= new StringBuffer();
			strQuery.append("update DS_EPSD_MEAL_PLAN_HDR_AUDIT set MEAL_CLASS=?, DIET_TYPE=?, MENU_CODE=?, KITCHEN_CODE=?, PATIENT_CLASS=?, EVENT_DATE_TIME=TO_DATE(?, 'DD/MM/YYYY HH24:MI'), MEAL_CATEGORY=?, STATUS=?, COMPLAINT_CODE=?, COMPLAINT_DESC=?, OTH_COMPLAINT_DESC=?, COMPLAINT_SOURCE_TYPE=?, COMPLAINT_SOURCE_CODE=?, ADDED_BY_ID=?, ADDED_DATE=?, ADDED_FACILITY_ID=?, ADDED_AT_WS_NO=?, MODIFIED_BY_ID=?, MODIFIED_DATE=?, MODIFIED_FACILITY_ID=?, MODIFIED_AT_WS_NO=? ");
			
			if(status.equals("MJ") && rejected_by.equals("")){ //Rejected  status
				strQuery.append(" ,REJECTED_BY=? ");
			}
			if(status.equals("MS")){
				strQuery.append(" ,SERVED_DATE_TIME=to_date(?,'DD/MM/YYYY hh24:mi') ");
			}
			strQuery.append(" ,MEAL_REPLACE_YN=? ");  
			strQuery.append(" where OPERATING_FACILITY_ID=? and ENCOUNTER_ID=? and SERVING_DATE=to_date(?,'DD/MM/YYYY') and MEAL_TYPE=?");
			// Added Against Start ML-MMOH-CRF-681	
			pstmt = con.prepareStatement(strQuery.toString());			
			pstmt.setString(++count,mealClass);
			pstmt.setString(++count,dietType);			
			pstmt.setString(++count,menuCode);			
			pstmt.setString(++count,kitchenCode);			
			pstmt.setString(++count,patientClass);			
			pstmt.setString(++count,eventDate);			
			pstmt.setString(++count,mealCategory);			
			pstmt.setString(++count,status);
			//if(complaintCode == null)
			//complaintCode="";
			pstmt.setString(++count,complaintCode);			
			pstmt.setString(++count,complaintDesc);		
			pstmt.setString(++count,othersComplaintsDesc);	//Added Against MOH-CRF-1125
//			TODO: check if complaint source type should be 'N' always
			pstmt.setString(++count,"N");			
			pstmt.setString(++count,"");			
			pstmt.setString(++count,login_user);			
			pstmt.setTimestamp(++count, new  java.sql.Timestamp(System.currentTimeMillis()));			
			pstmt.setString(++count,facility_id);	
			pstmt.setString(++count,str_client_ip_address);	
			pstmt.setString(++count,login_user);	
			pstmt.setTimestamp(++count, new  java.sql.Timestamp(System.currentTimeMillis()));
			pstmt.setString(++count,facility_id);			
			pstmt.setString(++count,str_client_ip_address);	
			// Added Against Start ML-MMOH-CRF-681	
			if(status.equals("MJ") && rejected_by.equals("")){ //Rejected  status
				pstmt.setString(++count,login_user);				
			}
			if(status.equals("MS")){
			pstmt.setString(++count,eventDate);			
			}	
			pstmt.setString(++count,isEmpty(MealReplaceYn)); 
			// Added Against End ML-MMOH-CRF-681			
			pstmt.setString(++count,facility_id);		
			pstmt.setInt(++count,Integer.parseInt(encounterId));		
			pstmt.setString(++count,servingDate);		
			pstmt.setString(++count,mealType);
			
		
			int row=pstmt.executeUpdate();
			if (row >0)
			{
				isUpdateSuccess = true;
			}
		}
		catch(Exception e) {
			System.err.println("exception in updateRecords method=" + e.toString());
			e.printStackTrace();
			con.close();
			isUpdateSuccess = false;
		}
		finally {
			pstmt.close();
			if(isUpdateSuccess)con.commit();
			else con.rollback();
			//con.close();
			if(con!=null)ConnectionManager.returnConnection(con,request); //Common-ICN-0052
		}
		return isUpdateSuccess;
	}

	private boolean updateNonFreqBasedRecords(HttpServletRequest request,
			HttpServletResponse response)   throws SQLException {
		boolean isUpdateSuccess=false;
		try {
			con	=	ConnectionManager.getConnection(request);
			String strQuery="update DS_EPSD_MEAL_PLAN_SPL_AUDIT set ITEM_SL=?, ITEM_TYPE=?, ITEM_QTY=?, FREQ_YN=?, ADDED_BY_ID=?, ADDED_DATE=?," +
					" ADDED_FACILITY_ID=?, ADDED_AT_WS_NO=?, MODIFIED_BY_ID=?, MODIFIED_DATE=?, MODIFIED_FACILITY_ID=?, MODIFIED_AT_WS_NO=?," +
					" EVENT_DATE_TIME=to_date(?,'DD/MM/YYYY hh24:mi'), STATUS=?, COMPLAINT_CODE=?, COMPLAINT_DESC=?, COMPLAINT_SOURCE_TYPE=?," +
					" COMPLAINT_SOURCE_CODE=?, MEAL_REPLACE_YN=?, OTH_COMPLAINT_DESC=? where OPERATING_FACILITY_ID=? and ENCOUNTER_ID=? and SERVING_DATE=to_date(?,'DD/MM/YYYY hh24:mi') and MEAL_TYPE=? and ITEM_CODE=?"; //MEAL_REPLACE_YN Added Against ML-MMOH-CRF-681	& ML-MMOH-CRF-1125
			pstmt = con.prepareStatement(strQuery);
			pstmt.setString(1,itemSL);
			pstmt.setString(2,itemType);
			pstmt.setString(3,itemQty);
			pstmt.setString(4,"N");
			pstmt.setString(5,login_user);
			pstmt.setTimestamp(6,new  java.sql.Timestamp(System.currentTimeMillis()));
			pstmt.setString(7,facility_id);
			pstmt.setString(8,str_client_ip_address);
			pstmt.setString(9,login_user);
			pstmt.setTimestamp(10,new  java.sql.Timestamp(System.currentTimeMillis()));
			pstmt.setString(11,facility_id);
			pstmt.setString(12,str_client_ip_address);
			pstmt.setString(13,eventDate_NonFreq);
			pstmt.setString(14,status);
			pstmt.setString(15,complaintCode);
			pstmt.setString(16,complaintDesc);
			//TODO: check if complaint source type should be 'N' always
			pstmt.setString(17,"N");
			pstmt.setString(18, "");
			// Added Against ML-MMOH-CRF-681
			pstmt.setString(19,isEmpty(MealReplaceYn));
			pstmt.setString(20,othersComplaintsDesc); // Added Against ML-MMOH-CRF-1125
			pstmt.setString(21,facility_id);
			pstmt.setInt(22,Integer.parseInt(encounterId));
			pstmt.setString(23,date_time);
			pstmt.setString(24,mealType);
			pstmt.setString(25,itemCode);
			// Added Against ML-MMOH-CRF-681

			int row=pstmt.executeUpdate();
			if (row >0)
			{
				isUpdateSuccess = true;
			}
		}
		catch(Exception e) {
			System.err.println("exception in updateRecords method=" + e.toString());
			e.printStackTrace();
			con.close();
			isUpdateSuccess = false;
		}
		finally {
			pstmt.close();
			if(isUpdateSuccess)con.commit();
			else con.rollback();
			//con.close();
			if(con!=null)ConnectionManager.returnConnection(con,request); //Common-ICN-0052
		}
		return isUpdateSuccess;
	}

	private boolean updateFreqBasedRejectedRecords (HttpServletRequest request,
			HttpServletResponse response)   throws SQLException {
		boolean isUpdateSuccess=false;
		try {
			con	=	ConnectionManager.getConnection(request);
			String strQuery="UPDATE DS_EPSD_MEAL_ITEM_REJECTIONS SET KITCHEN_CODE=?, PATIENT_ID=?, PATIENT_CLASS=?," +
					" SOURCE_TYPE=?, SOURCE_CODE=?, DIET_TYPE=?, REJECTED_QTY=?, MEAL_SERVED_DATE=to_date(?,'DD/MM/YYYY hh24:mi')," +
					" REJECTED_DATE=to_date(?,'DD/MM/YYYY hh24:mi'), REJECTED_REASON=?, FREQ_YN=?, REJECTED_YN=?," +
					" ADDED_BY_ID=?, ADDED_DATE=?, ADDED_FACILITY_ID=?, ADDED_AT_WS_NO=?, MODIFIED_BY_ID=?, MODIFIED_DATE=?," +
					" MODIFIED_FACILITY_ID=?, MODIFIED_AT_WS_NO=?, OTH_COMPLAINT_DESC=? WHERE OPERATING_FACILITY_ID=? AND ENCOUNTER_ID=?" +
					" AND SERVING_DATE=to_date(?,'DD/MM/YYYY hh24:mi') AND MEAL_TYPE=? AND ITEM_CODE=? AND SPL_FOOD_ITEM_YN=?"; //Modified Against ML-MOH-CRF-1125
			pstmt = con.prepareStatement(strQuery);
			pstmt.setString(1,kitchenCode);
			pstmt.setString(2,patientId);
			pstmt.setString(3,patientClass);
			pstmt.setString(4,"N");
			//TODO:SourceCode
			pstmt.setString(5,"");
			pstmt.setString(6,dietType);
			pstmt.setString(7,itemQty);
			pstmt.setString(8,eventDate_Freq);
			pstmt.setString(9,eventDate_Freq);
			pstmt.setString(10,complaintCode);
			pstmt.setString(11,"Y");
			pstmt.setString(12,"Y");
			pstmt.setString(13,login_user);
			pstmt.setTimestamp(14,new  java.sql.Timestamp(System.currentTimeMillis()));
			pstmt.setString(15,facility_id);
			pstmt.setString(16,str_client_ip_address);
			pstmt.setString(17,login_user);
			pstmt.setTimestamp(18,new  java.sql.Timestamp(System.currentTimeMillis()));
			pstmt.setString(19,facility_id);
			pstmt.setString(20,str_client_ip_address);
			pstmt.setString(21,othersComplaintsDesc);  //Added Against ML-MOH-CRF-1125
			pstmt.setString(22,facility_id);
			pstmt.setInt(23,Integer.parseInt(encounterId));
			pstmt.setString(24,date_time);
			pstmt.setString(25,"##");
			pstmt.setString(26,itemCode);
			pstmt.setString(27,"Y");

			int row=pstmt.executeUpdate();
			if (row >0)
			{
				isUpdateSuccess = true;
			}
		}
		catch(Exception e) {
			System.err.println("exception in updateRecords method=" + e.toString());
			e.printStackTrace();
			con.close();
			isUpdateSuccess = false;
		}
		finally {
			pstmt.close();
			if(isUpdateSuccess)con.commit();
			else con.rollback();
			//con.close();
			if(con!=null)ConnectionManager.returnConnection(con,request); //Common-ICN-0052
		}
		return isUpdateSuccess;
	}

	private boolean updateNonFreqBasedRejectedRecords(HttpServletRequest request,
			HttpServletResponse response)   throws SQLException {
		boolean isUpdateSuccess=false;
		try {
			con	=	ConnectionManager.getConnection(request);
			String strQuery="UPDATE DS_EPSD_MEAL_ITEM_REJECTIONS SET KITCHEN_CODE=?, PATIENT_ID=?, PATIENT_CLASS=?," +
					" SOURCE_TYPE=?, SOURCE_CODE=?, DIET_TYPE=?, REJECTED_QTY=?, MEAL_SERVED_DATE=to_date(?,'DD/MM/YYYY hh24:mi')," +
					" REJECTED_DATE=to_date(?,'DD/MM/YYYY hh24:mi'), REJECTED_REASON=?, FREQ_YN=?, REJECTED_YN=?," +
					" ADDED_BY_ID=?, ADDED_DATE=?, ADDED_FACILITY_ID=?, ADDED_AT_WS_NO=?, MODIFIED_BY_ID=?, MODIFIED_DATE=?," +
					" MODIFIED_FACILITY_ID=?, MODIFIED_AT_WS_NO=?, OTH_COMPLAINT_DESC=? WHERE OPERATING_FACILITY_ID=? AND ENCOUNTER_ID=?" +
					" AND SERVING_DATE=to_date(?,'DD/MM/YYYY hh24:mi') AND MEAL_TYPE=? AND ITEM_CODE=? AND SPL_FOOD_ITEM_YN=?"; //Modified Against ML-MOH-CRF-1125
			pstmt = con.prepareStatement(strQuery);
			pstmt.setString(1,kitchenCode);
			pstmt.setString(2,patientId);
			pstmt.setString(3,patientClass);
			pstmt.setString(4,"N");
			//TODO:SourceCode
			pstmt.setString(5,"");
			pstmt.setString(6,dietType);
			pstmt.setString(7,itemQty);
			pstmt.setString(8,eventDate_NonFreq);
			pstmt.setString(9,eventDate_NonFreq);
			pstmt.setString(10,complaintCode);
			pstmt.setString(11,"N");
			pstmt.setString(12,"Y");
			pstmt.setString(13,login_user);
			pstmt.setTimestamp(14,new  java.sql.Timestamp(System.currentTimeMillis()));
			pstmt.setString(15,facility_id);
			pstmt.setString(16,str_client_ip_address);
			pstmt.setString(17,login_user);
			pstmt.setTimestamp(18,new  java.sql.Timestamp(System.currentTimeMillis()));
			pstmt.setString(19,facility_id);
			pstmt.setString(20,str_client_ip_address);
			pstmt.setString(21,othersComplaintsDesc); //Added Against ML-MOH-CRF-1125
			pstmt.setString(22,facility_id);
			pstmt.setInt(23,Integer.parseInt(encounterId));
			pstmt.setString(24,date_time);
			pstmt.setString(25,mealType);
			pstmt.setString(26,itemCode);
			pstmt.setString(27,"Y");

			int row=pstmt.executeUpdate();
			if (row >0)
			{
				isUpdateSuccess = true;
			}
		}
		catch(Exception e) {
			System.err.println("exception in updateRecords method=" + e.toString());
			e.printStackTrace();
			con.close();
			isUpdateSuccess = false;
		}
		finally {
			pstmt.close();
			if(isUpdateSuccess)con.commit();
			else con.rollback();
			//con.close();
			if(con!=null)ConnectionManager.returnConnection(con,request); //Common-ICN-0052
		}
		return isUpdateSuccess;
	}

	private void getData(HttpServletRequest req,int i) {
		this.encounterId=(String)req.getParameter("encounterId"+i);
		this.servingDate=(String)req.getParameter("date_mealtype");
		this.servingDate = com.ehis.util.DateUtils.convertDate(this.servingDate,"DMY", locale, "en"); // Date Localization 
		
		this.servingDate_Freq=(String)req.getParameter("date_freqBased");
		this.servingDate_Freq = com.ehis.util.DateUtils.convertDate(this.servingDate_Freq,"DMY", locale, "en"); // Date Localization
		
		this.mealType=(String)req.getParameter("mealType"+i);
		this.patientClass=(String)req.getParameter("patientClass"+i);
		this.kitchenCode=(String)req.getParameter("kitchenCode"+i);
		this.mealCategory=(String)req.getParameter("mealCategory"+i);
		this.mealClass=(String)req.getParameter("mealClass"+i);
		this.menuCode=(String)req.getParameter("menuCode"+i);
		this.status=(String)req.getParameter("effStatus"+i);
		// Added Against ML-MMOH-CRF-681
		this.MealReplaceYn=(String)req.getParameter("MealReplaceYn"+i);
		this.rejected_by=(String)req.getParameter("rejected_by"+i);
		// Added Against ML-MMOH-CRF-681
		this.complaintCode=(String)isEmpty(req.getParameter("complaintCode"+i));
		if(this.complaintCode.equals("null"))	complaintCode="";
		this.complaintDesc=(String)isEmpty(req.getParameter("complaintDesc"+i));
		if(this.complaintDesc.equals("null"))	complaintDesc="";
		this.othersComplaintsDesc=(String)isEmpty(req.getParameter("othersComp"+i)); //Added Against CRF-1125
		//Added Against ML-MMOH-CRF-1816 Starts
		if(this.othersComplaintsDesc.contains("& #39;"))
		this.othersComplaintsDesc = this.othersComplaintsDesc.replace("& #39;", "'");	
		//Added Against ML-MMOH-CRF-1816 Ends
		if(this.othersComplaintsDesc.equals("null"))	othersComplaintsDesc="";
		this.dietType=(String)req.getParameter("dietType"+i);
		this.itemCode=(String)req.getParameter("itemCode"+i);
		this.itemQty=(String)req.getParameter("itemQty"+i);
		this.itemSL=(String)req.getParameter("itemSL"+i);
		this.itemType=(String)req.getParameter("itemType"+i);
		this.eventDate=(String)req.getParameter("eventDate"+i);
		this.eventDate = DateUtils.convertDate(this.eventDate,"DMYHM", locale, "en"); // Date Localization
		
		this.eventDate_Freq=(String)req.getParameter("eventDate_Freq"+i);
		this.eventDate_Freq = DateUtils.convertDate(this.eventDate_Freq,"DMYHM", locale, "en"); // Date Localization
		
		this.eventDate_NonFreq=(String)req.getParameter("eventDate_NonFreq"+i);
		this.eventDate_NonFreq = DateUtils.convertDate(this.eventDate_NonFreq,"DMYHM", locale, "en"); // Date Localization
		
		this.date_time=(String)req.getParameter("date_time"+i);
		this.patientId=(String)req.getParameter("patientId"+i);		

	}

}
