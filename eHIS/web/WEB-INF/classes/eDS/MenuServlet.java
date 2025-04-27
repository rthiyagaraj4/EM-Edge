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
public class MenuServlet extends HttpServlet {
     // Checkstyle Violation commented by Munisekhar
	//private static final long serialVersionUID = 1L;

	String menuCode = "";
	String longDesc = "";
	String shortDesc = "";
    String dietType = "";
	String mealType = "";
	String mealClass = "";
	String effFrom = "";
    String effTo = "";
    String enable = "";
    int itemSrl = 0;
    String itemName = "";
    String itemType = "";
    int itemQty = 0;

	String facility_id="";
	String client_ip_address="";
	String login_user="";
	String mode = "";
	String patientClass = ""; // Added Against ML-MOh-CRF-1006(US5)
	java.util.Properties prop;
	HttpSession session;
    Connection con = null;
    PreparedStatement pstmt = null;
	// Checkstyle Violation commented by Munisekhar
   //  ResultSet rst = null;
    CommonCheckPk commonChk = null;
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MenuServlet() {
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
		// Checkstyle Violation commented by Munisekhar
		//String forNutrients = "";
		int result = 0;


		//int totalrow = Integer.parseInt(request.getParameter("totalRow"));	//Common-ICN-0044

		if("insert".equals(mode)){
			commonChk = new CommonCheckPk();
			if(!(commonChk.checkForPk(request, response, DlQuery.DL_MENU_CHECK_PK, request.getParameter("menu_Code")))){
				result = menuItemInsert(request,response);
			}
			else{
				result = 0;
			}
		}
		else{
			result = menuItemUpdate(request,response);
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




	private int menuItemInsert(HttpServletRequest request,
			HttpServletResponse response) {
		int result = 0;
		try{

			menuCode = request.getParameter("menu_Code");
			longDesc = request.getParameter("long_Desc");
			shortDesc = request.getParameter("short_Desc");
			dietType = request.getParameter("diet_Type");
			mealType = request.getParameter("meal_Type");
			mealClass = request.getParameter("meal_Class");
			effFrom = request.getParameter("eff_FromDate");
			effTo = request.getParameter("eff_ToDate");
			if(effTo==null) effTo="";
			Date effFromDate = new Date(sdf.parse(effFrom).getTime());
//			Date effToDate = new Date(sdf.parse(effTo).getTime());
			enable = request.getParameter("enable");
			patientClass = request.getParameter("Patient_Class"); //Added Against ML-MOH-CRF-1006-US5
			if("on".equals(enable)){
				enable = "E";
			}
			else{
				enable = "D";
			}

			session = request.getSession(false);
			this.prop = (java.util.Properties) session.getValue( "jdbc" ) ;
			this.facility_id = (String) session.getValue( "facility_id" ) ;
			login_user = this.prop.getProperty( "login_user" ) ;
			client_ip_address = this.prop.getProperty("client_ip_address") ;
			con = ConnectionManager.getConnection(request);
			pstmt = con.prepareStatement(DlQuery.DL_INSERT_MENU);
			pstmt.setString(1, menuCode);
			pstmt.setString(2, longDesc);
			pstmt.setString(3, shortDesc);
			pstmt.setString(4, dietType);
			pstmt.setString(5, mealType);
			pstmt.setString(6, mealClass);
			pstmt.setString(7, enable);
			pstmt.setDate(8, effFromDate);
			pstmt.setString(9, effTo);
			pstmt.setString(10, login_user);
			pstmt.setString(11, facility_id);
			pstmt.setString(12, client_ip_address);
			pstmt.setString(13, login_user);
			pstmt.setString(14, facility_id);
			pstmt.setString(15, client_ip_address);
			pstmt.setString(16, patientClass); //Added Against ML-MOH-CRF-1006-US5
			pstmt.execute();
          if(pstmt!=null)	pstmt.close();
			String nutrString = "";
			String contentvalue = "";
			String itemCodeStr = "";
			int totalrow = Integer.parseInt(request.getParameter("totalRow"));
			for(int i=0;i<totalrow;i++){
				nutrString = request.getParameter("nutMode"+i);
				itemCodeStr = request.getParameter("Hid_itemCode"+i);
				System.out.println("itemCodeStr--->"+itemCodeStr);
				contentvalue = request.getParameter("nutRow"+i);
				String[] kitArr = contentvalue.split(":::");

				pstmt = con.prepareStatement(DlQuery.DL_INSERT_MENU_ITEM);
				pstmt.setString(1, menuCode);
				pstmt.setInt(2, Integer.parseInt(kitArr[0]));
				pstmt.setString(3, kitArr[1]);
				//pstmt.setString(4, kitArr[2]);
				pstmt.setString(4, itemCodeStr);
				pstmt.setInt(5, Integer.parseInt(kitArr[3]));
				pstmt.setString(6, login_user);
				pstmt.setString(7, facility_id);
				pstmt.setString(8, client_ip_address);
				pstmt.setString(9, login_user);
				pstmt.setString(10, facility_id);
				pstmt.setString(11, client_ip_address);
				pstmt.execute();
			}
			con.commit();
			result = 1;
		}
		catch(Exception e){
			System.err.println("eDS Exception Diet Type->"+e);
			e.printStackTrace();
			result = 2;
		}
		finally{
			try{
				if(pstmt!=null) pstmt.close();
//				if(rst!=null) rst.close();
				ConnectionManager.returnConnection(con);
			}
			catch(Exception e){
				System.err.println("Exception in Diet Create:"+e);
				e.printStackTrace();
			}
		}
		return result;
	}

	private int menuItemUpdate(HttpServletRequest request,
			HttpServletResponse response) {
		int retRslt = 0;
		try{
			menuCode = request.getParameter("updMenuCode");
			longDesc = request.getParameter("long_Desc");
			shortDesc = request.getParameter("short_Desc");
			dietType = request.getParameter("diet_Type");
			mealType = request.getParameter("meal_Type");
			mealClass = request.getParameter("meal_Class");
			effFrom = request.getParameter("eff_FromDate");
			effTo = request.getParameter("eff_ToDate");
			if(effTo==null) effTo="";
			Date effFromDate = new Date(sdf.parse(effFrom).getTime());
//			Date effToDate = new Date(sdf.parse(effTo).getTime());
			enable = request.getParameter("enable");
			if("on".equals(enable)){
				enable = "E";
			}
			else{
				enable = "D";
			}
			patientClass = request.getParameter("Patient_Class"); //Added Against ML-MOH-CRF-1006-US5
			session = request.getSession(false);
			this.prop = (java.util.Properties) session.getValue( "jdbc" ) ;
			this.facility_id = (String) session.getValue( "facility_id" ) ;
			login_user = this.prop.getProperty( "login_user" ) ;
			client_ip_address = this.prop.getProperty("client_ip_address") ;
			con = ConnectionManager.getConnection(request);
			pstmt = con.prepareStatement(DlQuery.DL_UPDATE_MENU);

			pstmt.setString(1, longDesc);
			pstmt.setString(2, shortDesc);
			pstmt.setString(3, dietType);
			pstmt.setString(4, mealType);
			pstmt.setString(5, mealClass);
			pstmt.setString(6, enable);
			pstmt.setDate(7, effFromDate);
//			pstmt.setDate(8, effToDate);
			pstmt.setString(8, effTo);
			pstmt.setString(9, login_user);
			pstmt.setString(10, facility_id);
			pstmt.setString(11, client_ip_address);
			pstmt.setString(12, patientClass);
			pstmt.setString(13, menuCode);

			pstmt.execute();
           if(pstmt!=null)	pstmt.close();
			String nutrString = "";
			String contentvalue = "";
			String itemCodeStr = "";
			int totalrow = Integer.parseInt(request.getParameter("totalRow"));
			System.err.println("333333333333333333333333---->"+totalrow);
			for(int i=0;i<totalrow;i++){
				nutrString = request.getParameter("nutMode"+i);
				System.err.println("nutrString------------------------------>"+nutrString);
				itemCodeStr = request.getParameter("Hid_itemCode"+i);
				System.err.println("itemCodeStr------------------------------>"+itemCodeStr);
				contentvalue = request.getParameter("nutRow"+i);
				System.err.println("contentvalue------------------------------>"+contentvalue);
				String[] kitArr = contentvalue.split(":::");

				if("I".equals(nutrString)){
					pstmt = con.prepareStatement(DlQuery.DL_INSERT_MENU_ITEM);
					pstmt.setString(1, menuCode);
					pstmt.setInt(2, Integer.parseInt(kitArr[0]));
					pstmt.setString(3, kitArr[1]);
					//pstmt.setString(4, kitArr[2]);
					System.err.println("itemCodeStr in update"+itemCodeStr);
					pstmt.setString(4, itemCodeStr);
					pstmt.setInt(5, Integer.parseInt(kitArr[3]));
					pstmt.setString(6, login_user);
					pstmt.setString(7, facility_id);
					pstmt.setString(8, client_ip_address);
					pstmt.setString(9, login_user);
					pstmt.setString(10, facility_id);
					pstmt.setString(11, client_ip_address);
					pstmt.execute();
					if(pstmt!=null)	pstmt.close();
				}
				else if("U".equals(nutrString)){
					pstmt = con.prepareStatement(DlQuery.DL_UPDATE_MENU_ITEM);

					pstmt.setInt(1, Integer.parseInt(kitArr[3]));
					pstmt.setString(2, login_user);
					pstmt.setString(3, facility_id);
					pstmt.setString(4, client_ip_address);
					pstmt.setString(5, menuCode);
					pstmt.setString(6, kitArr[1]);
					//pstmt.setString(7, kitArr[2]);
					pstmt.setString(7, itemCodeStr);
					pstmt.execute();
				}
				else if("D".equals(nutrString)){
					pstmt = con.prepareStatement(DlQuery.DL_DELETE_MENU_ITEM);

					pstmt.setString(1, menuCode);
					pstmt.setString(2,  kitArr[1]);
					//pstmt.setString(3,  kitArr[2]);
					pstmt.setString(3, itemCodeStr);
					pstmt.setInt(4, Integer.parseInt(kitArr[0]));
					pstmt.execute();
				}
			}
			con.commit();
			retRslt=1;
		}
		catch(Exception e){
			System.err.println("eDS Exception Diet Type->"+e);
			e.printStackTrace();
			retRslt=2;
		}
		finally{
			try{
				if(pstmt!=null) pstmt.close();
//				if(rst!=null) rst.close();
				ConnectionManager.returnConnection(con);
			}
			catch(Exception e){
				System.err.println("Exception in Diet Create:"+e);
				e.printStackTrace();
			}
		}
		return retRslt;
	}

}
