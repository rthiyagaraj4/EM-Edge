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
public class CommercialFoodItemServlet extends HttpServlet {
	//private static final long serialVersionUID = 1L;

	String foodItem = "";
	String longDesc = "";
	String shortDesc = "";
	String itemType = "";
    String servingUom = "";
    String preparationUom = "";
    String baseQty = "";
    String preparationFactor = "";
    String calorieContent = "";
    String itemCode = "";
    String enabled = "";
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
    public CommercialFoodItemServlet() {
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
			result = nutrientsInsertUpdate(request,response);
		}
		else{
			if("insert".equals(mode)){
				commonChk = new CommonCheckPk();
				if(!(commonChk.checkForPk(request, response, DlQuery.DL_COM_FOOD_ITEM_CHECK_PK, request.getParameter("food_Item")))){
					result = insert(request,response);
				}
				else{
					result = 0;
				}
			}
			else if("modify".equals(mode)){
				result = update(request,response);
			}
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
		else if(result == -1){ //IN:39942 - Modification
			error = "APP-000008 Atleast One record should be entered";
		}
		error_value = Integer.toString(result);
		response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8" ) +"&err_value="+error_value);
	}


	private int update(HttpServletRequest request,HttpServletResponse response) {
		boolean rslt = false;
		int err_no = 0;
		try{
		foodItem = request.getParameter("updFoodItem");
		longDesc = request.getParameter("long_Desc");
		shortDesc = request.getParameter("short_Desc");
		itemType = request.getParameter("item_Type");
		servingUom = request.getParameter("serving_Uom");
		preparationUom = request.getParameter("preparation_Uom");
		baseQty = request.getParameter("base_Qty");
		preparationFactor = request.getParameter("preparation_Factor");
		calorieContent = request.getParameter("calorie_Content");
		itemCode = request.getParameter("item_Code");
		enabled = request.getParameter("enable");
		if("on".equals(enabled)){
			enabled = "E";
		}
		else{
			enabled = "D";
		}
		session = request.getSession(false);
		this.prop = (java.util.Properties) session.getValue( "jdbc" ) ;
		this.facility_id = (String) session.getValue( "facility_id" ) ;
		login_user = this.prop.getProperty( "login_user" ) ;
		client_ip_address = this.prop.getProperty("client_ip_address") ;

		con = ConnectionManager.getConnection(request);
		pstmt = con.prepareStatement(DlQuery.DL_UPDATE_COM_FOOD_ITEM);
		pstmt.setString(1, longDesc);
		pstmt.setString(2, shortDesc);
		pstmt.setString(3, servingUom);
		pstmt.setString(4, calorieContent);
		pstmt.setString(5, preparationUom);
		pstmt.setString(6, preparationFactor);
		pstmt.setString(7, baseQty);
		pstmt.setString(8, itemCode);
		pstmt.setString(9, enabled);
		pstmt.setString(10, login_user);
		pstmt.setString(11, facility_id);
		pstmt.setString(12, client_ip_address);
		pstmt.setString(13, foodItem);
		rslt = pstmt.execute();
		err_no = 1;
		con.commit();
		}
		catch(Exception e){
			System.err.println("eDS Exception Com Food Item->"+e);
			err_no = 2;
		}
		finally{
			try{
				if(pstmt!=null) pstmt.close();
				if(rst!=null) rst.close();
				ConnectionManager.returnConnection(con);
			}
			catch(Exception e){
				System.err.println("Exception in Com Food Item:"+e);
			}
		}
		return err_no;
	}


	private int insert(HttpServletRequest request, HttpServletResponse response) {

		boolean rslt = false;
		int err_no = 0;
		try{
		foodItem = request.getParameter("food_Item");
		longDesc = request.getParameter("long_Desc");
		shortDesc = request.getParameter("short_Desc");
		itemType = request.getParameter("item_Type");
		servingUom = request.getParameter("serving_Uom");
		baseQty = request.getParameter("base_Qty");
		preparationFactor = request.getParameter("preparation_Factor");
		calorieContent = request.getParameter("calorie_Content");
		preparationUom = request.getParameter("preparation_Uom");
		itemCode = request.getParameter("item_Code");
		enabled = request.getParameter("enable");
		if("on".equals(enabled)){
			enabled = "E";
		}
		else{
			enabled = "D";
		}
		session = request.getSession(false);
		this.prop = (java.util.Properties) session.getValue( "jdbc" ) ;
		this.facility_id = (String) session.getValue( "facility_id" ) ;
		login_user = this.prop.getProperty( "login_user" ) ;
		client_ip_address = this.prop.getProperty("client_ip_address") ;

		con = ConnectionManager.getConnection(request);
		pstmt = con.prepareStatement(DlQuery.DL_INSERT_COM_FOOD_ITEM);
		pstmt.setString(1, foodItem);
		pstmt.setString(2, longDesc);
		pstmt.setString(3, shortDesc);
		pstmt.setString(4, itemType);
		pstmt.setString(5, servingUom);
		pstmt.setString(6, calorieContent);
		pstmt.setString(7, preparationUom);
		pstmt.setString(8, preparationFactor);
		pstmt.setString(9, baseQty);
		pstmt.setString(10, itemCode);
		pstmt.setString(11, enabled);
		pstmt.setString(12, login_user);
		pstmt.setString(13, facility_id);
		pstmt.setString(14, client_ip_address);
		pstmt.setString(15, login_user);
		pstmt.setString(16, facility_id);
		pstmt.setString(17, client_ip_address);
		rslt = pstmt.execute();
		err_no = 1;
		con.commit();
		}
		catch(Exception e){
			System.err.println("eDS Exception Com Food Item->"+e);
			err_no = 2;
		}
		finally{
			try{
				if(pstmt!=null) pstmt.close();
				if(rst!=null) rst.close();
				ConnectionManager.returnConnection(con);
			}
			catch(Exception e){
				System.err.println("Exception in Com Food Item:"+e);
			}

		}

		return err_no;

	}

	private int nutrientsInsertUpdate(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub

		String nutrString = "";
		String foodItemCode = request.getParameter("foodItmCode");
		String contentvalue = "";
		//String strnutCode = "";
		int totalrow = Integer.parseInt(request.getParameter("totalRow"));
		//IN:39942 - Modification: If there are no records, return result as -1
		if(totalrow == 0)
			return -1;

		int[] result = new int[totalrow];
		for(int i=0;i<totalrow;i++){
			nutrString = request.getParameter("nutMode"+i);
			String[] nutArr = nutrString.split("::");
			contentvalue = request.getParameter("nutRow"+i);
			String[] kitArr = contentvalue.split(":::");
			if("U".equals(nutArr[1])){
				result[i] = nutrientsUpdate(request,response,foodItemCode,kitArr,nutArr);
			}
			else if("I".equals(nutArr[1])){
				result[i] = nutrientsInsert(request,response,foodItemCode,kitArr,nutArr);
			}
			else if("D".equals(nutArr[1])){
				result[i] = nutrientsDelete(request,response,foodItemCode,kitArr,nutArr);
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

	private int nutrientsDelete(HttpServletRequest request,
			HttpServletResponse response, String foodItemCode, String[] kitArr,
			String[] nutArr) {
		int result = 0;
		try{
			session = request.getSession(false);
			this.prop = (java.util.Properties) session.getValue( "jdbc" ) ;
			this.facility_id = (String) session.getValue( "facility_id" ) ;
			login_user = this.prop.getProperty( "login_user" ) ;
			client_ip_address = this.prop.getProperty("client_ip_address") ;
			con = ConnectionManager.getConnection(request);
			pstmt = con.prepareStatement(DlQuery.DL_DEL_COM_NUTRIENTS);
			pstmt.setString(1, foodItemCode);
			pstmt.setString(2, nutArr[0]);
			pstmt.execute();
			con.commit();
			result = 1;
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


	private int nutrientsUpdate(HttpServletRequest request,
			HttpServletResponse response, String foodItemCode, String[] kitArr, String[] nutArr) {
		int result = 0;
		try{
			session = request.getSession(false);
			this.prop = (java.util.Properties) session.getValue( "jdbc" ) ;
			this.facility_id = (String) session.getValue( "facility_id" ) ;
			login_user = this.prop.getProperty( "login_user" ) ;
			client_ip_address = this.prop.getProperty("client_ip_address") ;
			con = ConnectionManager.getConnection(request);
			pstmt = con.prepareStatement(DlQuery.DL_UPDATE_COM_NUTRIENTS);
			pstmt.setString(1, kitArr[1]);
			pstmt.setString(2, login_user);
			pstmt.setString(3, facility_id);
			pstmt.setString(4, client_ip_address);
			pstmt.setString(5, foodItemCode);
			pstmt.setString(6, nutArr[0]);
			pstmt.execute();
			con.commit();
			result = 1;
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


	private int nutrientsInsert(HttpServletRequest request,
			HttpServletResponse response, String foodItemCode, String[] kitArr, String[] nutArr) {
		int result = 0;
		try{
			session = request.getSession(false);
			this.prop = (java.util.Properties) session.getValue( "jdbc" ) ;
			this.facility_id = (String) session.getValue( "facility_id" ) ;
			login_user = this.prop.getProperty( "login_user" ) ;
			client_ip_address = this.prop.getProperty("client_ip_address") ;
			con = ConnectionManager.getConnection(request);
			pstmt = con.prepareStatement(DlQuery.DL_INSERT_COM_NUTRIENTS);
			pstmt.setString(1, foodItemCode);
			pstmt.setString(2, nutArr[0]);
			pstmt.setString(3, kitArr[1]);
			pstmt.setString(4, login_user);
			pstmt.setString(5, facility_id);
			pstmt.setString(6, client_ip_address);
			pstmt.setString(7, login_user);
			pstmt.setString(8, facility_id);
			pstmt.setString(9, client_ip_address);
			pstmt.execute();
			con.commit();
			result = 1;
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



}
