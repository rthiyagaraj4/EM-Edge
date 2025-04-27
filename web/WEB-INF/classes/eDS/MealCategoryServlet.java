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
public class MealCategoryServlet extends HttpServlet {
    // Checkstyle Violation commented by Munisekhar
	//private static final long serialVersionUID = 1L;

	String mealCategory = "";
	String dietType = "";
	String mealClass = "";


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
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MealCategoryServlet() {
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
		String forNutrients = "";

		int result = 0;
		forNutrients = request.getParameter("Nutrients");

		if("yes".equals(forNutrients)){
			result = mealAttendents(request,response);
		}
		else{
			if("modify".equals(mode)){
				result = update(request,response);
			}
		}
		if(result == 1){
			error = "APP-SM0070 Operation Completed Successfully ....";
		}
		else if(result == 2){
			error = "Record has not saved. Please try again";
		}
		error_value = Integer.toString(result);
		response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8" ) +"&err_value="+error_value);
	}


	private int mealAttendents(HttpServletRequest request,
			HttpServletResponse response) {
		String nutrString = "";
		String contentvalue = "";
		// Checkstyle Violation commented by Munisekhar
		//String strnutCode = "";
		int totalrow = Integer.parseInt(request.getParameter("totalRow"));
		int[] result = new int[totalrow];
		for(int i=0;i<totalrow;i++){
			nutrString = request.getParameter("nutMode"+i);
			contentvalue = request.getParameter("nutRow"+i);
			String[] kitArr = contentvalue.split(":::");

			if("U".equals(nutrString)){
				result[i] = mealAttendentsUpdate(request,response,kitArr);
			}
			else if("I".equals(nutrString)){
				result[i] = mealAttendentsInsert(request,response,kitArr);
			}
			else if("D".equals(nutrString)){
				result[i] = mealAttendentsDelete(request,response,kitArr);
			}

		}
		int retRslt = result[0];
		for(int i=1;i<totalrow;i++){
			if(result[i]>retRslt){
				retRslt = result[i];
			}
		}
		return retRslt;
	}


	private int mealAttendentsDelete(HttpServletRequest request,
			HttpServletResponse response, String[] kitArr) {
		int result = 0;
		try{
			session = request.getSession(false);
			this.prop = (java.util.Properties) session.getValue( "jdbc" ) ;
			this.facility_id = (String) session.getValue( "facility_id" ) ;
			login_user = this.prop.getProperty( "login_user" ) ;
			client_ip_address = this.prop.getProperty("client_ip_address") ;
			con = ConnectionManager.getConnection(request);
			pstmt = con.prepareStatement(DlQuery.DL_DELETE_MEAL_ATTENDENTS);
			pstmt.setString(1, facility_id);
			pstmt.setString(2, "ATT");
			pstmt.setString(3, kitArr[0]);
			pstmt.execute();
			result = 1;
			con.commit();
		}
		catch(Exception e){
			System.err.println("eDS Exception Diet Type->"+e);
			result = 2;
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
		return result;
	}


	private int mealAttendentsInsert(HttpServletRequest request,
			HttpServletResponse response, String[] kitArr) {
		int result = 0;
		try{
			session = request.getSession(false);
			this.prop = (java.util.Properties) session.getValue( "jdbc" ) ;
			this.facility_id = (String) session.getValue( "facility_id" ) ;
			login_user = this.prop.getProperty( "login_user" ) ;
			client_ip_address = this.prop.getProperty("client_ip_address") ;
			con = ConnectionManager.getConnection(request);
			pstmt = con.prepareStatement(DlQuery.DL_INSERT_MEAL_ATTENDENTS);
			pstmt.setString(1, facility_id);
			pstmt.setString(2, "ATT");
			pstmt.setString(3, kitArr[0]);
			pstmt.setString(4, kitArr[1]);
			pstmt.setString(5, kitArr[2]);
			pstmt.setString(6, login_user);
			pstmt.setString(7, facility_id);
			pstmt.setString(8, client_ip_address);
			pstmt.setString(9, login_user);
			pstmt.setString(10, facility_id);
			pstmt.setString(11, client_ip_address);
			pstmt.execute();
			result = 1;
			con.commit();
		}
		catch(Exception e){
			System.err.println("eDS Exception Diet Type->"+e);
			result = 2;
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
		return result;
	}


	private int mealAttendentsUpdate(HttpServletRequest request,
			HttpServletResponse response, String[] kitArr) {
		int result = 0;
		try{
			session = request.getSession(false);
			this.prop = (java.util.Properties) session.getValue( "jdbc" ) ;
			this.facility_id = (String) session.getValue( "facility_id" ) ;
			login_user = this.prop.getProperty( "login_user" ) ;
			client_ip_address = this.prop.getProperty("client_ip_address") ;
			con = ConnectionManager.getConnection(request);
			pstmt = con.prepareStatement(DlQuery.DL_UPDATE_MEAL_ATTENDENTS);
			pstmt.setString(1, kitArr[1]);
			pstmt.setString(2, kitArr[2]);
			pstmt.setString(3, login_user);
			pstmt.setString(4, facility_id);
			pstmt.setString(5, client_ip_address);
			pstmt.setString(6, kitArr[0]);
			pstmt.execute();
			result = 1;
			con.commit();
		}
		catch(Exception e){
			System.err.println("eDS Exception Diet Type->"+e);
			result = 2;
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
		return result;
	}


	private int update(HttpServletRequest request,HttpServletResponse response) {
		boolean rslt = false;
		int err_no = 0;
		try{
			mealCategory = request.getParameter("updMealCategory");
			dietType = request.getParameter("diet_Type");
			mealClass = request.getParameter("meal_Class");

			session = request.getSession(false);
			this.prop = (java.util.Properties) session.getValue( "jdbc" ) ;
			this.facility_id = (String) session.getValue( "facility_id" ) ;
			login_user = this.prop.getProperty( "login_user" ) ;
			client_ip_address = this.prop.getProperty("client_ip_address") ;

			con = ConnectionManager.getConnection(request);
			pstmt = con.prepareStatement(DlQuery.DL_UPDATE_MEAL_CATEGORY);
			pstmt.setString(1, dietType);
			pstmt.setString(2, mealClass);
			pstmt.setString(3, login_user);
			pstmt.setString(4, facility_id);
			pstmt.setString(5, client_ip_address);
			pstmt.setString(6, mealCategory);
			rslt = pstmt.execute();
			err_no = 1;
			con.commit();
			}
			catch(Exception e){
				System.err.println("eDS Exception Meal Category->"+e);
				err_no = 2;
			}
			finally{
				try{
					if(pstmt!=null) pstmt.close();
					if(rst!=null) rst.close();
					ConnectionManager.returnConnection(con);
				}
				catch(Exception e){
					System.err.println("Exception in Meal Category:"+e);
				}
			}
			return err_no;
	}

}
