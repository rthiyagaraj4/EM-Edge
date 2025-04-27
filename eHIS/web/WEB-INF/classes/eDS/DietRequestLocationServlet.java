// Created for ML-MMOH-CRF-0419
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
 * Servlet implementation class DietRequestLocationServlet
 */
public class DietRequestLocationServlet extends HttpServlet {

	String dietLocationCode = "";
	String longDesc = "";
	String shortDesc = "";
	String defaultYn= "";
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
    public DietRequestLocationServlet() {
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
			if(!(commonChk.checkForPk(request, response, DlQuery.DL_DIET_REQUEST_LOCATION_CODE_CHECK_PK, request.getParameter("dietlocationcode")))){
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
        else if(result == 3){
			error = "Default diet location is already available";
		}
		error_value = Integer.toString(result);
		response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8" ) +"&err_value="+error_value);
	}


	private int update(HttpServletRequest request,HttpServletResponse response) {
		boolean rslt = false;
		int err_no = 0;
		try{
			dietLocationCode = request.getParameter("updDietLocationCode");
			longDesc = request.getParameter("longDesc");
			shortDesc = request.getParameter("shortDesc");
			defaultYn = request.getParameter("defaultlocation");
			enabledYn = request.getParameter("enabledYn");
            String temp_location=request.getParameter("temp_location");
			String default_Count_temp=request.getParameter("default_Count");
			int default_Count=Integer.parseInt(default_Count_temp);
			
			if("on".equals(defaultYn)){
				defaultYn = "Y";
				if(default_Count > 0 && !temp_location.equalsIgnoreCase(dietLocationCode))
			{
			err_no=3;
			return err_no;
			}
			}
			else{
				defaultYn = "N";
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
			pstmt = con.prepareStatement(DlQuery.DL_UPDATE_DIET_REQUEST_LOCATION_CODE);
			pstmt.setString(1, longDesc);
			pstmt.setString(2, shortDesc);
			pstmt.setString(3, defaultYn);
			pstmt.setString(4, enabledYn);
			pstmt.setString(5, login_user);
			pstmt.setString(6, facility_id);
			pstmt.setString(7, client_ip_address);
			pstmt.setString(8, dietLocationCode);
			rslt = pstmt.execute();
			err_no = 1;
			con.commit();
			}
			catch(Exception e){
				System.err.println("eDS Exception Diet Request Location->"+e);
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
					System.err.println("Exception in Diet Request Location:"+e);
					e.printStackTrace();
				}
			}
			return err_no;
	}

	private int insert(HttpServletRequest request, HttpServletResponse response) {

		boolean rslt = false;
		int err_no = 0;
		try{
			dietLocationCode = request.getParameter("dietLocationCode");
			longDesc = request.getParameter("longDesc");
			shortDesc = request.getParameter("shortDesc");
			defaultYn = request.getParameter("defaultlocation");
			enabledYn = request.getParameter("enabledYn");

			if("on".equals(defaultYn)){
				defaultYn = "Y";
			}
			else{
				defaultYn = "N";
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
			pstmt = con.prepareStatement(DlQuery.DL_INSERT_DIET_REQUEST_LOCATION_CODE);
			pstmt.setString(1, dietLocationCode);
			pstmt.setString(2, longDesc);
			pstmt.setString(3, shortDesc);
			pstmt.setString(4, defaultYn);
			pstmt.setString(5, enabledYn);
			pstmt.setString(6, login_user);
			pstmt.setString(7, facility_id);
			pstmt.setString(8, client_ip_address);
			pstmt.setString(9, login_user);
			pstmt.setString(10, facility_id);
			pstmt.setString(11, client_ip_address);
			rslt = pstmt.execute();
			err_no = 1;
			con.commit();
		}
		catch(Exception e){
			System.err.println("eDS Exception Diet Request Location->"+e);
			e.printStackTrace();
		}
		finally{
			try{
				if(pstmt!=null) pstmt.close();
				if(rst!=null) rst.close();
				ConnectionManager.returnConnection(con);
			}
			catch(Exception e){
				System.err.println("Exception in Diet Request Location:"+e);
				e.printStackTrace();
				err_no = 2;
			}
		}
		return err_no;
	}
}