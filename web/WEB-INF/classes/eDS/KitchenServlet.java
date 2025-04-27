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
public class KitchenServlet extends HttpServlet {
     // Checkstyle Violation commented by Munisekhar
	//private static final long serialVersionUID = 1L;

	String kitchen = "";
	String longDesc = "";
	String shortDesc = "";
    String enabledYn = "";


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
    public KitchenServlet() {
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
			result = kitchenInsertUpdate(request,response);
		}
		else{
			if("insert".equals(mode)){
				commonChk = new CommonCheckPk();
				if(!(commonChk.checkForPk(request, response, DlQuery.DL_KITCHEN_CHECK_PK, request.getParameter("kitchen_Code")))){
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
		error_value = Integer.toString(result);
		response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8" ) +"&err_value="+error_value);
	}


	private int update(HttpServletRequest request,HttpServletResponse response) {
		boolean rslt = false;
		int err_no = 0;
		try{
			kitchen = request.getParameter("updKitchenCode");
			longDesc = request.getParameter("long_Desc");
			shortDesc = request.getParameter("short_Desc");
			enabledYn = request.getParameter("enabled_Yn");

			if("on".equals(enabledYn)){
				enabledYn = "E";
			}
			else{
				enabledYn = "D";
			}

			session = request.getSession(false);
			this.prop = (java.util.Properties) session.getValue( "jdbc" ) ;
			this.facility_id = (String) session.getValue( "facility_id" ) ;
			login_user = this.prop.getProperty( "login_user" ) ;
			client_ip_address = this.prop.getProperty("client_ip_address") ;

			con = ConnectionManager.getConnection(request);
			pstmt = con.prepareStatement(DlQuery.DL_UPDATE_KITCHEN);
			pstmt.setString(1, longDesc);
			pstmt.setString(2, shortDesc);
			pstmt.setString(3, enabledYn);
			pstmt.setString(4, login_user);
			pstmt.setString(5, facility_id);
			pstmt.setString(6, client_ip_address);
			pstmt.setString(7, kitchen);
			rslt = pstmt.execute();
			err_no = 1;
			con.commit();
			}
			catch(Exception e){
				System.err.println("eDS Exception Kitchen->"+e);
				err_no = 2;
			}
			finally{
				try{
					if(pstmt!=null) pstmt.close();
					if(rst!=null) rst.close();
					ConnectionManager.returnConnection(con);
				}
				catch(Exception e){
					System.err.println("Exception in Kitchen:"+e);
				}
			}
			return err_no;
	}


	private int insert(HttpServletRequest request, HttpServletResponse response) {

		boolean rslt = false;
		int err_no = 0;
		try{
			kitchen = request.getParameter("kitchen_Code");
			longDesc = request.getParameter("long_Desc");
			shortDesc = request.getParameter("short_Desc");
			enabledYn = request.getParameter("enabled_Yn");

			if("on".equals(enabledYn)){
				enabledYn = "E";
			}
			else{
				enabledYn = "D";
			}

			session = request.getSession(false);
			this.prop = (java.util.Properties) session.getValue( "jdbc" ) ;
			this.facility_id = (String) session.getValue( "facility_id" ) ;
			login_user = this.prop.getProperty( "login_user" ) ;
			client_ip_address = this.prop.getProperty("client_ip_address") ;

			con = ConnectionManager.getConnection(request);
			pstmt = con.prepareStatement(DlQuery.DL_INSERT_KITCHEN);
			pstmt.setString(1, kitchen);
			pstmt.setString(2, longDesc);
			pstmt.setString(3, shortDesc);
			pstmt.setString(4, enabledYn);
			pstmt.setString(5, login_user);
			pstmt.setString(6, facility_id);
			pstmt.setString(7, client_ip_address);
			pstmt.setString(8, login_user);
			pstmt.setString(9, facility_id);
			pstmt.setString(10, client_ip_address);
			pstmt.setString(11, facility_id);
			rslt = pstmt.execute();
			err_no = 1;
			con.commit();
		}
		catch(Exception e){
			System.err.println("eDS Exception Kitchen->"+e);
			err_no = 2;
		}
		finally{
			try{
				if(pstmt!=null) pstmt.close();
				if(rst!=null) rst.close();
				ConnectionManager.returnConnection(con);
			}
			catch(Exception e){
				System.err.println("Exception in Kitchen:"+e);
			}

		}

		return err_no;

	}

	private int kitchenInsertUpdate(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		String nutrString = "";
		String foodItemCode = request.getParameter("foodItmCode");
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
				result[i] = kitchenUpdate(request,response,foodItemCode,kitArr);
			}
			else if("I".equals(nutrString)){
				result[i] = kitchenInsert(request,response,foodItemCode,kitArr);
			}
			else if("D".equals(nutrString)){
				result[i] = kitchenDelete(request,response,foodItemCode,kitArr);
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

	private int kitchenDelete(HttpServletRequest request,
			HttpServletResponse response, String foodItemCode, String[] kitArr) {
		int result = 0;
		PreparedStatement pstmtForAreaItems = null;
		try{
			session = request.getSession(false);
			this.prop = (java.util.Properties) session.getValue( "jdbc" ) ;
			this.facility_id = (String) session.getValue( "facility_id" ) ;
			con = ConnectionManager.getConnection(request);
			
			//IN:39878 - Modified by Abirami - start 
			pstmtForAreaItems = con.prepareStatement(DlQuery.DL_DEL_KITCHEN_AREA_ITEMS);
			pstmtForAreaItems.setString(1, facility_id);
			pstmtForAreaItems.setString(2, foodItemCode);
			pstmtForAreaItems.setString(3, kitArr[0]);
			pstmtForAreaItems.execute();
			//IN:39878 - Modified by Abirami - end
			
			pstmt = con.prepareStatement(DlQuery.DL_DEL_KITCHEN_AREA);
			pstmt.setString(1, facility_id);
			pstmt.setString(2, foodItemCode);
			pstmt.setString(3, kitArr[0]);
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
				if(pstmtForAreaItems!=null) pstmtForAreaItems.close();
				if(rst!=null) rst.close();
				ConnectionManager.returnConnection(con);
			}
			catch(Exception e){
				System.err.println("Exception in Diet Create:"+e);
			}
		}
		return result;
	}


	private int kitchenUpdate(HttpServletRequest request,
			HttpServletResponse response, String foodItemCode, String[] kitArr) {
		int result = 0;
		try{
			session = request.getSession(false);
			this.prop = (java.util.Properties) session.getValue( "jdbc" ) ;
			this.facility_id = (String) session.getValue( "facility_id" ) ;
			login_user = this.prop.getProperty( "login_user" ) ;
			client_ip_address = this.prop.getProperty("client_ip_address") ;
			con = ConnectionManager.getConnection(request);
			pstmt = con.prepareStatement(DlQuery.DL_UPD_KITCHEN_AREA);
			pstmt.setString(1, kitArr[1]);
			pstmt.setString(2, kitArr[2]);
			if(kitArr[3].contains("enabled.gif")){
				kitArr[3] = "E";
			}
			else if(kitArr[3].contains("RRnwd.gif")){
				kitArr[3] = "D";
			}
			pstmt.setString(3, kitArr[3]);
			pstmt.setString(4, login_user);
			pstmt.setString(5, facility_id);
			pstmt.setString(6, client_ip_address);
			pstmt.setString(7, foodItemCode);
			pstmt.setString(8, kitArr[0]);
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


	private int kitchenInsert(HttpServletRequest request,
			HttpServletResponse response, String foodItemCode, String[] kitArr) {
		int result = 0;
		try{
			session = request.getSession(false);
			this.prop = (java.util.Properties) session.getValue( "jdbc" ) ;
			this.facility_id = (String) session.getValue( "facility_id" ) ;
			login_user = this.prop.getProperty( "login_user" ) ;
			client_ip_address = this.prop.getProperty("client_ip_address") ;
			con = ConnectionManager.getConnection(request);
			pstmt = con.prepareStatement(DlQuery.DL_INS_KITCHEN_AREA);
			pstmt.setString(1, facility_id);
			pstmt.setString(2, foodItemCode);
			pstmt.setString(3, kitArr[0]);
			pstmt.setString(4, kitArr[1]);
			pstmt.setString(5, kitArr[2]);
			if(kitArr[3].contains("enabled.gif")){
				kitArr[3] = "E";
			}
			else if(kitArr[3].contains("RRnwd.gif")){
				kitArr[3] = "D";
			}
			pstmt.setString(6, kitArr[3]);
			pstmt.setString(7, login_user);
			pstmt.setString(8, facility_id);
			pstmt.setString(9, client_ip_address);
			pstmt.setString(10, login_user);
			pstmt.setString(11, facility_id);
			pstmt.setString(12, client_ip_address);
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
