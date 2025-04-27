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
//import eDS.Common.CommonCheckPk;

public class FoodItemForKitchenAreaServlet extends HttpServlet {
     // Checkstyle Violation commented by Munisekhar
	//private static final long serialVersionUID = 1L;
	
	String facility_id="";
	String client_ip_address="";
	String login_user="";
	String mode = "";
	java.util.Properties prop;
	HttpSession session;
    Connection con = null;
    PreparedStatement pstmt = null;
    ResultSet rst = null;
    //CommonCheckPk commonChk = null;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String error = "",error_value = "";
		mode = request.getParameter("mode");
		int result = 0;
		if(mode.equals("insert")){
			result = insert(request,response);
		}
		
		if(mode.equals("delete")){
			result = delete(request,response);
		}
		
		if(result == 1){
			error = "APP-SM0070 Operation Completed Successfully ....";
		}
		
		error_value = Integer.toString(result);
		response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8" ) +"&err_value="+error_value);
	}
	private int insert(HttpServletRequest request, HttpServletResponse response) {
		boolean rslt = false;
		int err_no = 0;
		try{
		String kitchen = request.getParameter("kitchen1");
		String kitchenArea = request.getParameter("kitchenArea1");
		String foodItemCode = request.getParameter("foodItemCode1");
		String[] foodItemArray=foodItemCode.split(",");
		
		session = request.getSession(false);
		this.prop = (java.util.Properties) session.getValue( "jdbc" ) ;
		this.facility_id = (String) session.getValue( "facility_id" ) ;
		login_user = this.prop.getProperty( "login_user" ) ;
		client_ip_address = this.prop.getProperty("client_ip_address") ;
		
		con = ConnectionManager.getConnection(request);
		
		String sql_delete = "delete from DS_KITCHEN_AREA_ITEMS where OPERATING_FACILITY_ID=? and KITCHEN_CODE=? and KITCHEN_AREA_CODE=?";
		pstmt = con.prepareStatement(sql_delete);
		pstmt.setString(1, facility_id);
		pstmt.setString(2, kitchen);
		pstmt.setString(3, kitchenArea);
		pstmt.execute();
		con.commit();
		
		try{
			if(pstmt!=null) pstmt.close();
		}
		catch(Exception e){
			System.err.println("Exception in FoodForKitchenArea delete:"+e);
		}
		
		String sql_food = "insert into DS_KITCHEN_AREA_ITEMS (ADDED_BY_ID, ADDED_DATE, ADDED_FACILITY_ID, ADDED_AT_WS_NO, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_FACILITY_ID, MODIFIED_AT_WS_NO, OPERATING_FACILITY_ID, KITCHEN_CODE, KITCHEN_AREA_CODE, FOOD_ITEM_CODE) values (?, SYSDATE, ?, ?, ?, SYSDATE, ?, ?, ?, ?, ?, ?)";
		for(int i=0;i<foodItemArray.length;i++) {
		pstmt = con.prepareStatement(sql_food);
		pstmt.setString(1, login_user);
		pstmt.setString(2, facility_id);
		pstmt.setString(3, client_ip_address);
		pstmt.setString(4, login_user);
		pstmt.setString(5, facility_id);
		pstmt.setString(6, client_ip_address);
		pstmt.setString(7, facility_id);
		pstmt.setString(8, kitchen);
		pstmt.setString(9, kitchenArea);
			pstmt.setString(10, foodItemArray[i]);
		rslt = pstmt.execute();
		err_no = 1;
		con.commit();
		if(pstmt!=null) pstmt.close();	//Added Against Common-ICN-0031
		}
		}catch(Exception e){
			System.err.println("eDS Exception in FoodForKitchenArea insert->"+e);
			err_no = 2;
		}
		finally{
			try{
				if(pstmt!=null) pstmt.close();
				if(rst!=null) rst.close();
				ConnectionManager.returnConnection(con);
			}
			catch(Exception e){
				System.err.println("Exception in FoodForKitchenArea:"+e);
			}

		}
		return err_no;
	}
	private int delete(HttpServletRequest request, HttpServletResponse response) {
		int result = 0;
		try{
			String kitchen_code = request.getParameter("kitchen1");
			String kitchen_Area = request.getParameter("kitchenArea1");
			String food_Item_Code = request.getParameter("foodItemCode");
			
			session = request.getSession(false);
			this.prop = (java.util.Properties) session.getValue( "jdbc" ) ;
			this.facility_id = (String) session.getValue( "facility_id" ) ;
			
			con = ConnectionManager.getConnection(request);
			String sql_delete = "delete from DS_KITCHEN_AREA_ITEMS where OPERATING_FACILITY_ID=? and KITCHEN_CODE=? and KITCHEN_AREA_CODE=? and FOOD_ITEM_CODE=?";
			pstmt = con.prepareStatement(sql_delete);
			pstmt.setString(1, facility_id);
			pstmt.setString(2, kitchen_code);
			pstmt.setString(3, kitchen_Area);
			pstmt.setString(4, food_Item_Code);
			pstmt.execute();
			con.commit();
			result = 1;
		}
		catch(Exception e){
			System.err.println("eDS Exception in FoodForKitchenArea delete->"+e);
			result = 2;
		}
		finally{
			try{
				if(pstmt!=null) pstmt.close();
				if(rst!=null) rst.close();
				ConnectionManager.returnConnection(con);
			}
			catch(Exception e){
				System.err.println("Exception in FoodForKitchenArea delete:"+e);
			}
		}
		return result;
	}
}
