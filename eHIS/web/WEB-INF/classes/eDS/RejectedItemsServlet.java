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
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import eCommon.XSSRequestWrapper;
import webbeans.eCommon.ConnectionManager;

/**
 * Servlet implementation class RejectedItemsServlet
 */
public class RejectedItemsServlet extends HttpServlet {
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

	String tabName,facility_id,str_client_ip_address,login_user, str_user_id,encounterId,mealType,servingDate,servingDate_Freq,patientClass,kitchenCode,mealCategory,splFoodItemYn,sourceCode,rejectedYn,rejectedDate,mealClass,menuCode,status,complaintCode,complaintDesc,dietType,itemCode,itemQty,itemSL,itemType,eventDate,date_time,patientId,mealServedDate,othersComp; //Added Against MOH-CRF-1125
	Date serving_Date;
	java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "yyyy-MM-dd" ) ;
	int totalItems;
	String locale;
	String sStyle = "";
	Boolean isMealComplaints=false;//Added Against MOH-CRF-1125
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RejectedItemsServlet() {
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
	    
		//Added Against MMS Vulnerability Issue - Starts
        request= new XSSRequestWrapper(request);
        response.addHeader("X-XSS-Protection", "1; mode=block");
        response.addHeader("X-Content-Type-Options", "nosniff");
        //Added Against MMS Vulnerability Issue - Ends 

		// Checkstyle Violation commented by Munisekhar
		//String error_value = "0" ;
		//String error = "";
		//boolean successFlag=true;
		boolean rejectedSuccessFlag=true;
		session = request.getSession(false);
		this.prop = (java.util.Properties) session.getValue("jdbc");
		this.facility_id = (String) request.getParameter("operatingFacilityId");
		if(facility_id == null) facility_id="";
		str_user_id      = (String) session.getValue("login_user");
		if(str_user_id == null) str_user_id="";
		str_client_ip_address = prop.getProperty("client_ip_address");
		login_user = prop.getProperty( "login_user" ) ;
		if(str_client_ip_address == null) str_client_ip_address="";
		if(login_user == null) login_user="";
		this.totalItems=Integer.parseInt((String)request.getParameter("totalItems"));
		//Added Against Start MOH-CRF-1125
		this.isMealComplaints = Boolean.valueOf(request.getParameter("isMealComplaints"));
		System.err.println("89,isMealComplaints=="+isMealComplaints);
		//Added Against End MOH-CRF-1125
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
			System.out.println("Rejected Item Servlet:total Items --->>>"+totalItems);
			for(int i=1;i<=totalItems;i++) {
				getData(request,i);
				boolean rejectedFlag=isRejectedRecordAlreadyExists(request,response);
				if(rejectedFlag) {
					rejectedSuccessFlag=rejectedSuccessFlag && updateRejectedRecords(request,response);
				}
				else {
					if(rejectedYn.equals("Y")) rejectedSuccessFlag=rejectedSuccessFlag && insertRejectedRecords(request,response);
				}

			}

		}
		catch (Exception e)
		{
			System.err.println("Exception in doPost=" + e.toString());
			e.printStackTrace();
			out.println(e.toString());
		}
		System.out.println("TEST TEST TEST TEST IN SERVLETTTTTTTTTTT");
	}

	private boolean isRejectedRecordAlreadyExists(HttpServletRequest req,HttpServletResponse res) throws SQLException {
		session = req.getSession(false);

		try {
			con	=	ConnectionManager.getConnection(req);
			System.out.println("isRejectedRecordAlreadyExists:encounterId---->"+encounterId);
			String strQuery;
			strQuery="SELECT ITEM_CODE,REJECTED_YN FROM DS_EPSD_MEAL_ITEM_REJECTIONS WHERE OPERATING_FACILITY_ID =? AND ENCOUNTER_ID =? AND  SERVING_DATE =TO_DATE(?,'DD/MM/YYYY hh24:mi') AND SPL_FOOD_ITEM_YN =?	AND MEAL_TYPE =? AND  ITEM_CODE =?";
			pstmt = con.prepareStatement(strQuery,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			pstmt.setString(1,facility_id);
			pstmt.setString(2,encounterId);
			pstmt.setString(3,servingDate);
			pstmt.setString(4,"N");
			pstmt.setString(5,mealType);
			pstmt.setString(6,itemCode);
 
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
		   if(rs!=null)rs.close();
		   if(pstmt!=null)pstmt.close();
		   //if(con!=null)con.close();
		   if(con!=null)ConnectionManager.returnConnection(con,req); //Common-ICN-0052
		}
		return false;
	}

	private boolean updateRejectedRecords(HttpServletRequest request,
			HttpServletResponse response)   throws SQLException {
		boolean isUpdateSuccess=false;
		try {
			con	=	ConnectionManager.getConnection(request);
			String strQuery="UPDATE DS_EPSD_MEAL_ITEM_REJECTIONS SET KITCHEN_CODE=?, PATIENT_ID=?, PATIENT_CLASS=?," +
					" SOURCE_TYPE=?, SOURCE_CODE=?, DIET_TYPE=?, REJECTED_QTY=?, MEAL_SERVED_DATE=to_date(?,'DD/MM/YYYY hh24:mi')," +
					" REJECTED_DATE=to_date(?,'DD/MM/YYYY hh24:mi'), REJECTED_REASON=?, FREQ_YN=?, REJECTED_YN=?," +
					" ADDED_BY_ID=?, ADDED_DATE=?, ADDED_FACILITY_ID=?, ADDED_AT_WS_NO=?, MODIFIED_BY_ID=?, MODIFIED_DATE=?," +
					" MODIFIED_FACILITY_ID=?, MODIFIED_AT_WS_NO=?, OTH_COMPLAINT_DESC=? WHERE OPERATING_FACILITY_ID=? AND ENCOUNTER_ID=?" +
					" AND SERVING_DATE=to_date(?,'DD/MM/YYYY hh24:mi') AND MEAL_TYPE=? AND ITEM_CODE=? AND SPL_FOOD_ITEM_YN=?"; //Modified Against MOH-CRF-1125
			pstmt = con.prepareStatement(strQuery);
			pstmt.setString(1,kitchenCode);
			pstmt.setString(2,patientId);
			pstmt.setString(3,patientClass);
			pstmt.setString(4,"");
			//TODO:SourceCode
			pstmt.setString(5,"");
			pstmt.setString(6,dietType);
			pstmt.setString(7,itemQty);
			pstmt.setString(8,mealServedDate);
			pstmt.setString(9,rejectedDate);
			pstmt.setString(10,complaintCode);
			pstmt.setString(11,"N");
			pstmt.setString(12,rejectedYn);
			pstmt.setString(13,login_user);
			pstmt.setTimestamp(14,new  java.sql.Timestamp(System.currentTimeMillis()));
			pstmt.setString(15,facility_id);
			pstmt.setString(16,str_client_ip_address);
			pstmt.setString(17,login_user);
			pstmt.setTimestamp(18,new  java.sql.Timestamp(System.currentTimeMillis()));
			pstmt.setString(19,facility_id);
			pstmt.setString(20,str_client_ip_address);
			//Added Against Start MOH-CRF-1125
			System.err.println("197,isMealComplaints=="+isMealComplaints);
			if(isMealComplaints){
			pstmt.setString(21,othersComp); 
			System.err.println("200,othersComp=="+othersComp);
			}else{
			pstmt.setString(21,""); 
			}
			//Added Against End MOH-CRF-1125
			pstmt.setString(22,facility_id);
			pstmt.setInt(23,Integer.parseInt(encounterId));
			pstmt.setString(24,servingDate);
			pstmt.setString(25,mealType);
			pstmt.setString(26,itemCode);
			pstmt.setString(27,"N");

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

	private boolean insertRejectedRecords(HttpServletRequest request,
			HttpServletResponse response)  throws SQLException {
		boolean isInsertSuccess=false;
		try {
			con	=	ConnectionManager.getConnection(request);
			String strQuery="INSERT INTO DS_EPSD_MEAL_ITEM_REJECTIONS (KITCHEN_CODE, PATIENT_ID, PATIENT_CLASS, SOURCE_TYPE, SOURCE_CODE, DIET_TYPE, REJECTED_QTY, MEAL_SERVED_DATE, REJECTED_DATE, REJECTED_REASON, FREQ_YN, REJECTED_YN, ADDED_BY_ID, ADDED_DATE, ADDED_FACILITY_ID, ADDED_AT_WS_NO, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_FACILITY_ID, MODIFIED_AT_WS_NO, OPERATING_FACILITY_ID, ENCOUNTER_ID, SERVING_DATE, MEAL_TYPE, ITEM_CODE, SPL_FOOD_ITEM_YN,OTH_COMPLAINT_DESC) VALUES (?, ?, ?, ?, ?, ?, ?, to_date(?,'DD/MM/YYYY hh24:mi'), to_date(?,'DD/MM/YYYY hh24:mi'), ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, to_date(?,'DD/MM/YYYY hh24:mi'), ?, ?, ?, ?)"; //Modified Against MOH-CRF-1125
			pstmt = con.prepareStatement(strQuery);
			pstmt.setString(1,kitchenCode);
			pstmt.setString(2,patientId);
			pstmt.setString(3,patientClass);
			pstmt.setString(4,"");
			//TODO:SourceCode
			pstmt.setString(5,"");
			pstmt.setString(6,dietType);
			pstmt.setString(7,itemQty);
			pstmt.setString(8,mealServedDate);
			pstmt.setString(9,rejectedDate);
			pstmt.setString(10,complaintCode);
			pstmt.setString(11,"N");
			pstmt.setString(12,rejectedYn);
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
			pstmt.setString(23,servingDate);
			pstmt.setString(24,mealType);
			pstmt.setString(25,itemCode);
			pstmt.setString(26,"N");
			//Added Against Start MOH-CRF-1125
			System.err.println("268,isMealComplaints=="+isMealComplaints);
			if(isMealComplaints){			
			pstmt.setString(27,othersComp); 
			System.err.println("271,othersComp=="+othersComp);
			}else{
			pstmt.setString(27,""); 
			System.err.println("274else,==");
			}
			//Added Against End MOH-CRF-1125
			System.err.println("260, othersComp=" + othersComp+"==complaintCode==>"+complaintCode);

			int row=pstmt.executeUpdate();
			if (row >0)
			{
				isInsertSuccess = true;
			}
		}
		catch(SQLException sqle) {
			System.err.println("268, Exception in insertRecords method=" + sqle.toString());
			sqle.printStackTrace();
			con.close();
			isInsertSuccess = false;
		}
		catch(Exception e) {
			System.err.println("274, Exception in insertRecords method=" + e.toString());
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


	private void getData(HttpServletRequest req,int i) {
		this.encounterId=(String)req.getParameter("encounterId");
		this.servingDate=(String)req.getParameter("servingDate");
		this.mealServedDate=(String)req.getParameter("mealServedDate");
		this.mealType=(String)req.getParameter("mealType");
		this.patientClass=(String)req.getParameter("patientClass");
		this.kitchenCode=(String)req.getParameter("kitchenCode");
		this.patientId=(String)req.getParameter("patientId");
		this.dietType=(String)req.getParameter("dietType");
		this.complaintCode=(String)req.getParameter("complaintCode"+i);
		//if(complaintCode==null) complaintCode="";
		this.complaintDesc=(String)req.getParameter("complaintDesc"+i);
		this.menuCode=(String)req.getParameter("menuCode");
		this.mealClass=(String)req.getParameter("mealClass");
		this.mealCategory=(String)req.getParameter("mealCategory");
		this.splFoodItemYn=(String)req.getParameter("splFoodItemYn");
		this.sourceCode=(String)req.getParameter("sourceCode");

		this.rejectedYn=(String)req.getParameter("rejectedYn"+i);
		if(rejectedYn == null) rejectedYn="N";
		this.rejectedDate=(String)req.getParameter("rejdate"+i);
		this.itemQty=(String)req.getParameter("rejectedQty"+i);
		this.itemCode=(String)req.getParameter("itemCode"+i);
		//Added Against Start MOH-CRF-1125
		this.othersComp=(String)req.getParameter("othersComp"+i); 
		//Added Against ML-MMOH-CRF-1816 Starts
		if(this.othersComp.contains("& #39;"))
		this.othersComp = this.othersComp.replace("& #39;", "'");	
		//Added Against ML-MMOH-CRF-1816 Ends
		System.err.println("333,othersComp==>>"+othersComp+"==complaintCode==>>"+complaintCode);
		//if(othersComp==null) othersComp="";		
		//Added Against End MOH-CRF-1125
	}
}


