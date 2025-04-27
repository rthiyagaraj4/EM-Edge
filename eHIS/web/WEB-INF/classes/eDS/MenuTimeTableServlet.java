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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import webbeans.eCommon.ConnectionManager;

import eDS.Common.CommonCheckPk;
import eDS.Common.DlQuery;


/**
 * Servlet implementation class DietTypeServlet
 */
public class MenuTimeTableServlet extends HttpServlet {
     // Checkstyle Violation commented by Munisekhar
	//private static final long serialVersionUID = 1L;

	String kitchenCode = "";
	String dietType = "";
	String mealClass = "";
	String mealType = "";
	String dayNo = "";
	String menu = "";
	String enabled_yn = "";

	String facility_id="";
	String client_ip_address="";
	String login_user="";
	String mode = "";
	String patientClass = ""; // Added Against ML-MOH-CRF-1006(US6)
	java.util.Properties prop;
	HttpSession session;
    Connection con = null;
    PreparedStatement pstmt = null;
    ResultSet rst = null;
    CommonCheckPk commonChk = null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MenuTimeTableServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String error = "",error_value = "";
		mode = request.getParameter("mode");
		int result = 0;
		if("insert".equals(mode)){
			//result = insert(request,response);
			commonChk = new CommonCheckPk();
			String[] args = new String[6];
			session = request.getSession(false);
			args[0] = (String) session.getValue( "facility_id" ) ;
			args[1] = request.getParameter("kitchen_Code");
			args[2] = request.getParameter("diet_Type");
			args[3] = request.getParameter("meal_Class");
			args[4] = request.getParameter("meal_Type");
			args[5] = request.getParameter("day_No");
			if(!(commonChk.checkForPk(request, response, DlQuery.DL_MENU_TIME_CHECK_PK, args, args.length))){
				result = insert(request,response);
			}
			else{
				result = 0;
			}
		}
		else if("modify".equals(mode)){
			result = update(request,response);
		}
		if(result == 1){
			error = "APP-SM0070 Operation Completed Successfully ....";
		}
		else if(result == 0){
			error = "APP-000064 Record Already Exists...";
		}
		else if(result == 2){
			error = "Record has not saved. Please try again";
		}
		error_value = Integer.toString(result);
		response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8" ) +"&err_value="+error_value);
	}


	private int update(HttpServletRequest request,HttpServletResponse response) {
		boolean rslt = false;
		int err_no = 0;
		try{
			mealType = request.getParameter("updMealType");
			dietType = request.getParameter("updDietType");
			mealClass = request.getParameter("updMealClass");
			kitchenCode = request.getParameter("updKitchen");
			dayNo = request.getParameter("updDayNo");
			enabled_yn = request.getParameter("enable");
			menu = request.getParameter("menu_Item");

			if("on".equals(enabled_yn)){
				enabled_yn = "E";
			}
			else{
				enabled_yn = "D";
			}
			session = request.getSession(false);
			this.prop = (java.util.Properties) session.getValue( "jdbc" ) ;
			this.facility_id = (String) session.getValue( "facility_id" ) ;
			login_user = this.prop.getProperty( "login_user" ) ;
			client_ip_address = this.prop.getProperty("client_ip_address") ;

			con = ConnectionManager.getConnection(request);
			pstmt = con.prepareStatement(DlQuery.DL_UPDATE_MENU_TIME_TAB);
			pstmt.setString(1, menu);
			pstmt.setString(2, enabled_yn);
			pstmt.setString(3, login_user);
			pstmt.setString(4, facility_id);
			pstmt.setString(5, client_ip_address);
			pstmt.setString(6, kitchenCode);
			pstmt.setString(7, dietType);
			pstmt.setString(8, mealClass);
			pstmt.setString(9, mealType);
			pstmt.setString(10, dayNo);
			rslt = pstmt.execute();
			err_no = 1;
			con.commit();
			}
			catch(Exception e){
				System.err.println("eDS Exception Diet Type->"+e);
				err_no = 2;
			}
			finally{
				try{
					if(pstmt!=null) pstmt.close();
					if(rst!=null) rst.close();
					ConnectionManager.returnConnection(con);
				}
				catch(Exception e){
					System.err.println("Exception in Diet Create:"+e);
				}
			}
			return err_no;
	}


	private int insert(HttpServletRequest request, HttpServletResponse response) {

		boolean rslt = false;
		int err_no = 0;
		try{
			mealType = request.getParameter("meal_Type");
			dietType = request.getParameter("diet_Type");
			mealClass = request.getParameter("meal_Class");
			kitchenCode = request.getParameter("kitchen_Code");
			dayNo = request.getParameter("day_No");
			enabled_yn = request.getParameter("enable");
			patientClass = request.getParameter("Patient_Class"); //Added Against ML-MOH-CRF-1006-US6
			menu = request.getParameter("menu_Item");
			if("on".equals(enabled_yn)){
				enabled_yn = "E";
			}
			else{
				enabled_yn = "D";
			}
			session = request.getSession(false);
			this.prop = (java.util.Properties) session.getValue( "jdbc" ) ;
			this.facility_id = (String) session.getValue( "facility_id" ) ;
			login_user = this.prop.getProperty( "login_user" ) ;
			client_ip_address = this.prop.getProperty("client_ip_address") ;

			con = ConnectionManager.getConnection(request);
			pstmt = con.prepareStatement(DlQuery.DL_INSERT_MENU_TIME_TAB);
			pstmt.setString(1, facility_id);
			pstmt.setString(2, kitchenCode);
			pstmt.setString(3, dietType);
			pstmt.setString(4, mealClass);
			pstmt.setString(5, mealType);
			pstmt.setString(6, menu);
			pstmt.setString(7, dayNo);
			pstmt.setString(8, enabled_yn);
			pstmt.setString(9, login_user);
			pstmt.setString(10, facility_id);
			pstmt.setString(11, client_ip_address);
			pstmt.setString(12, login_user);
			pstmt.setString(13, facility_id);
			pstmt.setString(14, client_ip_address);
			pstmt.setString(15, patientClass); //Added Against ML-MOH-CRF-1006-US6
			rslt = pstmt.execute();
			err_no = 1;
			con.commit();
		}
		catch(Exception e){
			System.err.println("eDS Exception Diet Type->"+e);
			err_no = 2;
			e.printStackTrace();
		}
		finally{
			try{
				if(pstmt!=null) pstmt.close();
				if(rst!=null) rst.close();
				ConnectionManager.returnConnection(con);
			}
			catch(Exception e){
				System.err.println("Exception in Diet Create:"+e);
				e.printStackTrace();
			}

		}

		return err_no;

	}

}
