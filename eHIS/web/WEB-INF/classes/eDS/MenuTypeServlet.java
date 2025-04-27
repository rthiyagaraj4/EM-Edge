/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/* This File Created against ML-MMOH-CRF-0684 */
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
 * Servlet implementation class MenuTypeServlet
 */
public class MenuTypeServlet extends HttpServlet {

	String menuType = "";
	String longDesc = "";
	String shortDesc = "";
    String enabledYn = "";
	String facility_id="";
	String client_ip_address="";
	String login_user="";
	String mode = "";
	String ipmenutype_yn = "";
	String opmenutype_yn = "";
	String emmenutype_yn = "";
	String applstafforder_yn = "";
	String default_menu = "";
	java.util.Properties prop;
	HttpSession session;
    Connection con = null;
    PreparedStatement pstmt = null;
    ResultSet rst = null;
    CommonCheckPk commonChk = null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MenuTypeServlet() {
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
			if(!(commonChk.checkForPk(request, response, DlQuery.DL_MENU_TYPE_CHECK_PK, request.getParameter("menuType")))){
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
		int count =0;
		try{
			menuType = request.getParameter("updMenuType");
			longDesc = request.getParameter("longDesc");
			shortDesc = request.getParameter("shortDesc");
			enabledYn = request.getParameter("enabledYn");
			default_menu = request.getParameter("default_menu");
			ipmenutype_yn = request.getParameter("ipmenutype_yn");
			opmenutype_yn = request.getParameter("opmenutype_yn");
			emmenutype_yn = request.getParameter("emmenutype_yn");
			applstafforder_yn = request.getParameter("applstafforder_yn");
						
			if("on".equals(default_menu)){
                default_menu = "Y";	
			}
			else{
				default_menu = "N";			
			}
			if("on".equals(ipmenutype_yn)){
                ipmenutype_yn = "Y";	
			}
			else{
				ipmenutype_yn = "N";			
			}
			if("on".equals(opmenutype_yn)){
                opmenutype_yn = "Y";	
			}
			else{
				opmenutype_yn = "N";			
			}
			if("on".equals(emmenutype_yn)){
                emmenutype_yn = "Y";	
			}
			else{
				emmenutype_yn = "N";			
			}
			if("on".equals(applstafforder_yn)){
				applstafforder_yn = "Y";	
			}
			else{
				applstafforder_yn = "N";			
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
			pstmt = con.prepareStatement(DlQuery.DL_UPDATE_MENU_TYPE);
			
			pstmt.setString(++count, longDesc);
			pstmt.setString(++count, shortDesc);
			pstmt.setString(++count, default_menu);
			pstmt.setString(++count, ipmenutype_yn);
			pstmt.setString(++count, opmenutype_yn);
			pstmt.setString(++count, emmenutype_yn);
			pstmt.setString(++count, applstafforder_yn);
			pstmt.setString(++count, enabledYn);
			pstmt.setString(++count, login_user);
			pstmt.setString(++count, facility_id);
			pstmt.setString(++count, client_ip_address);
			pstmt.setString(++count, menuType);
			
			rslt = pstmt.execute();
			err_no = 1;
			con.commit();
			}
			catch(Exception e){
				System.err.println("eDS Exception MenuTypeServlet Update->"+e);
				e.printStackTrace();
				err_no = 2;
			}
			finally{
				try{
					if(pstmt!=null) pstmt.close();
					if(rst!=null) rst.close();
					ConnectionManager.returnConnection(con);
				}
				catch(Exception e){
					System.err.println("Exception in MenuTypeServlet Update :"+e);
					e.printStackTrace();
				}
			}
			return err_no;
	}

	private int insert(HttpServletRequest request, HttpServletResponse response) {
		boolean rslt = false;
		int err_no = 0;
		int count =0;
		try{
			menuType = request.getParameter("menuType");
			longDesc = request.getParameter("longDesc");
			shortDesc = request.getParameter("shortDesc");
			enabledYn = request.getParameter("enabledYn");
			default_menu = request.getParameter("default_menu");
			ipmenutype_yn = request.getParameter("ipmenutype_yn");
			opmenutype_yn = request.getParameter("opmenutype_yn");
			emmenutype_yn = request.getParameter("emmenutype_yn");
			applstafforder_yn = request.getParameter("applstafforder_yn");			
			
			if("on".equals(default_menu)){
                default_menu = "Y";	
			}
			else{
				default_menu = "N";			
			}
			if("on".equals(ipmenutype_yn)){
                ipmenutype_yn = "Y";	
			}
			else{
				ipmenutype_yn = "N";			
			}
			if("on".equals(opmenutype_yn)){
                opmenutype_yn = "Y";	
			}
			else{
				opmenutype_yn = "N";			
			}
			if("on".equals(emmenutype_yn)){
                emmenutype_yn = "Y";	
			}
			else{
				emmenutype_yn = "N";			
			}
			if("on".equals(applstafforder_yn)){
				applstafforder_yn = "Y";	
			}
			else{
				applstafforder_yn = "N";			
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
			pstmt = con.prepareStatement(DlQuery.DL_INSERT_MENU_TYPE);

			pstmt.setString(++count, menuType);
			pstmt.setString(++count, longDesc);
			pstmt.setString(++count, shortDesc);
			pstmt.setString(++count, default_menu);
			pstmt.setString(++count, ipmenutype_yn);
			pstmt.setString(++count, opmenutype_yn);
			pstmt.setString(++count, emmenutype_yn);
			pstmt.setString(++count, applstafforder_yn);
			pstmt.setString(++count, enabledYn);
			pstmt.setString(++count, login_user);
			pstmt.setString(++count, facility_id);
			pstmt.setString(++count, client_ip_address );
			pstmt.setString(++count, login_user );
			pstmt.setString(++count, facility_id );
			pstmt.setString(++count, client_ip_address );
			rslt = pstmt.execute();
			err_no = 1;
			con.commit();
		}
		catch(Exception e){
			System.err.println("eDS Exception in MenuTypeServlet Insert->"+e);
			e.printStackTrace();
		}
		finally{
			try{
				if(pstmt!=null) pstmt.close();
				if(rst!=null) rst.close();
				ConnectionManager.returnConnection(con);
			}
			catch(Exception e){
				System.err.println("Exception in MenuTypeServlet Insert:"+e);
				e.printStackTrace();
				err_no = 2;
			}
		}
		return err_no;
	}
}
