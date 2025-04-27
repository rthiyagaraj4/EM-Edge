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
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;

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
public class MenuCycleServlet extends HttpServlet {
     // Checkstyle Violation commented by Munisekhar
	//private static final long serialVersionUID = 1L;

	String dietType = "";
	String mealClass = "";
	String dayNo = "";
	String menuSchdCycle = "";
	String enabled_yn = "";
	String mealPlanDate = "";

	String facility_id="";
	String client_ip_address="";
	String login_user="";
	String mode = "";
	java.util.Properties prop;
	HttpSession session;
    Connection con = null;
    PreparedStatement pstmt = null;
    ResultSet rst = null;
    CommonCheckPk commonChk = null;
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MenuCycleServlet() {
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
		     //commented by N Munisekhar on 27-May-2013 against [IN39960]
			//result = insert(request,response);
			commonChk = new CommonCheckPk();
			String[] args = new String[3];
			args[0] = request.getParameter("diet_Type");
			args[1] = request.getParameter("meal_Class");
			session = request.getSession(false);
			args[2] = (String) session.getValue( "facility_id" ) ;
			if(!(commonChk.checkForPk(request, response, DlQuery.DL_MENU_CYCLE_PK_CHK, args, args.length))){
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
			dietType = request.getParameter("updDietType");
			mealClass = request.getParameter("updMealClass");
			dayNo = request.getParameter("reference_Day_No");
			enabled_yn = request.getParameter("enable");
			menuSchdCycle = request.getParameter("menu_Schd_Cycle");
			mealPlanDate = request.getParameter("meal_PlanDate");
			Date mealPlan = new Date(sdf.parse(mealPlanDate).getTime());
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
			pstmt = con.prepareStatement(DlQuery.DL_UPDATE_MENU_CYCLE);
			pstmt.setString(1, menuSchdCycle);
			pstmt.setString(2, dayNo);
			pstmt.setDate(3, mealPlan);
			pstmt.setString(4, enabled_yn);
			pstmt.setString(5, login_user);
			pstmt.setString(6, facility_id);
			pstmt.setString(7, client_ip_address);
			pstmt.setString(8, dietType);
			pstmt.setString(9, mealClass);
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
			dietType = request.getParameter("diet_Type");
			mealClass = request.getParameter("meal_Class");
			dayNo = request.getParameter("reference_Day_No");
			enabled_yn = request.getParameter("enable");
			menuSchdCycle = request.getParameter("menu_Schd_Cycle");
			mealPlanDate = request.getParameter("meal_PlanDate");
			Date mealPlan = new Date(sdf.parse(mealPlanDate).getTime());
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
			pstmt = con.prepareStatement(DlQuery.DL_INSERT_MENU_CYCLE);
			pstmt.setString(1, facility_id);
			pstmt.setString(2, dietType);
			pstmt.setString(3, mealClass);
			pstmt.setString(4, menuSchdCycle);
			pstmt.setDate(5, mealPlan);
			pstmt.setString(6, dayNo);
			pstmt.setString(7, enabled_yn);
			pstmt.setString(8, login_user);
			pstmt.setString(9, facility_id);
			pstmt.setString(10, client_ip_address);
			pstmt.setString(11, login_user);
			pstmt.setString(12, facility_id);
			pstmt.setString(13, client_ip_address);
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

}
