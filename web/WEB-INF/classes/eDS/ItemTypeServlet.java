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
public class ItemTypeServlet extends HttpServlet {
     // Checkstyle Violation commented by Munisekhar
	//private static final long serialVersionUID = 1L;

	String itemType = "";
	String longDesc = "";
	String shortDesc = "";
	String dietCategory = "";
	String comFormula = "";
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
    public ItemTypeServlet() {
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
			commonChk = new CommonCheckPk();
			if(!(commonChk.checkForPk(request, response, DlQuery.DL_ITEM_TYPE_CHECK_PK, request.getParameter("item_Type")))){
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
			itemType = request.getParameter("updItemType");
			longDesc = request.getParameter("long_Desc");
			shortDesc = request.getParameter("short_Desc");
			enabledYn = request.getParameter("enabled_Yn");
			dietCategory = request.getParameter("diet_Category");
			comFormula = request.getParameter("com_Formula");

			if("on".equals(comFormula)){
				comFormula = "Y";
			}
			else{
				comFormula = "N";
			}

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
			pstmt = con.prepareStatement(DlQuery.DL_UPDATE_ITEM_TYPE);
			pstmt.setString(1, longDesc);
			pstmt.setString(2, shortDesc);
			pstmt.setString(3, comFormula);
			pstmt.setString(4, dietCategory);
			pstmt.setString(5, enabledYn);
			pstmt.setString(6, login_user);
			pstmt.setString(7, facility_id);
			pstmt.setString(8, client_ip_address);
			pstmt.setString(9, itemType);
			rslt = pstmt.execute();
			err_no = 1;
			con.commit();
			}
			catch(Exception e){
				System.err.println("eDS Exception Item Type->"+e);
				err_no = 2;
			}
			finally{
				try{
					if(pstmt!=null) pstmt.close();
					if(rst!=null) rst.close();
					ConnectionManager.returnConnection(con);
				}
				catch(Exception e){
					System.err.println("Exception in Item Create:"+e);
				}
			}
			return err_no;
	}


	private int insert(HttpServletRequest request, HttpServletResponse response) {

		boolean rslt = false;
		int err_no = 0;
		try{
			itemType = request.getParameter("item_Type");
			longDesc = request.getParameter("long_Desc");
			shortDesc = request.getParameter("short_Desc");
			enabledYn = request.getParameter("enabled_Yn");
			dietCategory = request.getParameter("diet_Category");
			comFormula = request.getParameter("com_Formula");

			if("on".equals(comFormula)){
				comFormula = "Y";
			}
			else{
				comFormula = "N";
			}

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
			pstmt = con.prepareStatement(DlQuery.DL_INSERT_ITEM_TYPE);
			pstmt.setString(1, itemType);
			pstmt.setString(2, longDesc);
			pstmt.setString(3, shortDesc);
			pstmt.setString(4, comFormula);
			pstmt.setString(5, dietCategory);
			pstmt.setString(6, enabledYn);
			pstmt.setString(7, login_user);
			pstmt.setString(8, facility_id);
			pstmt.setString(9, client_ip_address);
			pstmt.setString(10, login_user);
			pstmt.setString(11, facility_id);
			pstmt.setString(12, client_ip_address);
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
