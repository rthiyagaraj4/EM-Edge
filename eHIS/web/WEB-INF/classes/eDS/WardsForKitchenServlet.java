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
 * Servlet implementation class WardsForKitchenServlet
 */
public class WardsForKitchenServlet extends HttpServlet {
     // Checkstyle Violation commented by Munisekhar
	//private static final long serialVersionUID = 1L;

	String kitchenCode = "";
	String selectWards = "";
	String reomveWards = "";
	String nursingCode = "";
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
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WardsForKitchenServlet() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String error = "",error_value = "";
		int result = 0;
		String[] selWards = null;
		String[] remWards = null;
		kitchenCode = request.getParameter("kitchen_Code");
		selectWards = request.getParameter("selectedWards");
		reomveWards = request.getParameter("removedWards");

		if(selectWards != null && !selectWards.equals("")){
			selWards = selectWards.split(",");
			for(int i=0;i<selWards.length;i++){
				result = update(request, kitchenCode, selWards[i]);
			}
		}
		if(reomveWards != null && !reomveWards.equals("")){
			remWards = reomveWards.split(",");
			for(int i=0;i<remWards.length;i++){
				result = delete(request, kitchenCode, remWards[i]);
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


	private int update(HttpServletRequest request,String kitchenCode, String selWards) {
		System.out.println("In Update");
		boolean rslt = false;
		int err_no = 0;
		try{
			
			session = request.getSession(false);
			this.prop = (java.util.Properties) session.getValue( "jdbc" ) ;
			this.facility_id = (String) session.getValue( "facility_id" ) ;
			login_user = this.prop.getProperty( "login_user" ) ;
			client_ip_address = this.prop.getProperty("client_ip_address") ;

			System.out.println("login_user->"+login_user);
			System.out.println("facility_id->"+facility_id);
			System.out.println("client_ip_address->"+client_ip_address);

			con = ConnectionManager.getConnection(request);
			pstmt = con.prepareStatement(DlQuery.DL_INSERT_WARDS_FOR_KITCHEN);
			pstmt.setString(1, login_user);
			pstmt.setString(2, facility_id);
			pstmt.setString(3, client_ip_address);
			pstmt.setString(4, login_user);
			pstmt.setString(5, facility_id);
			pstmt.setString(6, client_ip_address);
			pstmt.setString(7, facility_id);
			pstmt.setString(8, kitchenCode);
			pstmt.setString(9, selWards);
			rslt = pstmt.execute();
			System.out.println("rslt->"+rslt);
			err_no = 1;
			con.commit();
			}
			catch(Exception e){
				System.err.println("eDS Exception wardsforkitchen->"+e);
				err_no = 2;
			}
			finally{
				try{
					if(pstmt!=null) pstmt.close();
					if(rst!=null) rst.close();
					ConnectionManager.returnConnection(con);
				}
				catch(Exception e){
					System.err.println("Exception in wardsforkitchen:"+e);
				}
			}
			System.out.println("err_no-->"+err_no);
			return err_no;
	}


	private int delete(HttpServletRequest request,String kitchenCode, String remWards) {

		boolean rslt = false;
		int err_no = 0;
		try{
			session = request.getSession(false);
			this.prop = (java.util.Properties) session.getValue( "jdbc" ) ;
			this.facility_id = (String) session.getValue( "facility_id" ) ;
			login_user = this.prop.getProperty( "login_user" ) ;
			client_ip_address = this.prop.getProperty("client_ip_address") ;

			System.out.println("login_user->"+login_user);
			System.out.println("facility_id->"+facility_id);
			System.out.println("client_ip_address->"+client_ip_address);


			con = ConnectionManager.getConnection(request);
			pstmt = con.prepareStatement(DlQuery.DL_DELETE_WARDS_FOR_KITCHEN);
			pstmt.setString(1, facility_id);
			pstmt.setString(2, kitchenCode);
			pstmt.setString(3, remWards);
			
			rslt = pstmt.execute();
			System.out.println("rslt->"+rslt);
			err_no = 1;
			con.commit();
		}
		catch(Exception e){
			System.err.println("eDS Exception wardsforkitchen->"+e);
			err_no = 2;
		}
		finally{
			try{
				if(pstmt!=null) pstmt.close();
				if(rst!=null) rst.close();
				ConnectionManager.returnConnection(con);
			}
			catch(Exception e){
				System.err.println("Exception in wardsforkitchen:"+e);
			}

		}

		return err_no;

	}

}
