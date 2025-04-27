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
import java.util.HashMap;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import webbeans.eCommon.ConnectionManager;
import eCommon.Common.CommonBean;
import eDS.Common.CommonCheckPk;
import eDS.Common.DlQuery;
import eDS.Common.*;


/**
 * Servlet implementation class DietTypeServlet
 */
public class MealClassServlet extends HttpServlet {
     // Checkstyle Violation commented by Munisekhar
	//private static final long serialVersionUID = 1L;

	String mealClass = "";
	String longDesc = "";
	String shortDesc = "";
    String enabledYn = "";
	String applstafforder_yn= ""; //Added against CRF-0419
	String editmenuappl_yn =""; //ML-MMOH-CRF-0669
	String attdntorderappl_yn =""; //ML-MMOH-CRF-1005
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
	//CRF-673
	String locale= "";
	String bedClassValues="";
	//CRF-673
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MealClassServlet() {
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
			if(!(commonChk.checkForPk(request, response, DlQuery.DL_MEAL_CLASS_CHECK_PK, request.getParameter("mealClass")))){
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
			mealClass = request.getParameter("updMealClass");
			longDesc = request.getParameter("longDesc");
			shortDesc = request.getParameter("shortDesc");
			enabledYn = request.getParameter("enabledYn");
   			//Added against CRF-0419 Starts Here
			applstafforder_yn= request.getParameter("applstafforder_yn");
			//bedClassValues= request.getParameter("bedClassCode"); //CRF-673	
			editmenuappl_yn = request.getParameter("editmenuappl_yn");
			attdntorderappl_yn= request.getParameter("attdntorderappl_yn");
			//Added Against ML-MMOH-CRF-1005

			String[] selecttype=request.getParameterValues("check");		
			String chkedValues="";
			// Added Against Start CRF-673	
			if (selecttype != null) 
			{
				for (int i = 0; i < selecttype.length; i++){
						if(chkedValues.length() == 0)
						chkedValues = chkedValues; 	
						chkedValues = chkedValues + selecttype[i] + ",";						
					}
				bedClassValues=chkedValues.substring(0,chkedValues.length()-1);			
			}else{
					bedClassValues="";
			}		
			// Added Against End CRF-673	
			if("on".equals(applstafforder_yn)){				
				applstafforder_yn = "Y";
			}
			else{
				applstafforder_yn = "N";				
			}
			//Added against CRF-0419 Ends Here

			if("on".equals(enabledYn)){
				enabledYn = "E";
			}
			else{
				enabledYn = "D";
			}
            //ML-MMOH-CRF-0669		
			if("on".equals(editmenuappl_yn)){
				editmenuappl_yn = "Y";
			}else{
				editmenuappl_yn = "N";
			}
			//ML-MMOH-CRF-1005 Stars Here	
			if("on".equals(attdntorderappl_yn)){
				attdntorderappl_yn = "Y";
			}else{
				attdntorderappl_yn = "N";
			}
			//ML-MMOH-CRF-1005 Ends Here
			session = request.getSession(false);
			this.prop = (java.util.Properties) session.getValue( "jdbc" ) ;
			this.facility_id = (String) session.getValue( "facility_id" ) ;
			login_user = this.prop.getProperty( "login_user" ) ;
			client_ip_address = this.prop.getProperty("client_ip_address") ;
			
			con = ConnectionManager.getConnection(request);	
		
			pstmt = con.prepareStatement(DlQuery.DL_UPDATE_MEAL_CLASS);			
			
			pstmt.setString(1, longDesc);
			pstmt.setString(2, shortDesc);
			pstmt.setString(3, applstafforder_yn);//Added against CRF-0419 Ends Here
			pstmt.setString(4, editmenuappl_yn);//ML-MMOH-CRF-0669
			pstmt.setString(5, attdntorderappl_yn);//Added Against ML-MMOH-CRF-1005
			pstmt.setString(6, enabledYn);
			pstmt.setString(7, login_user);
			pstmt.setString(8, facility_id);
			pstmt.setString(9, client_ip_address);
			pstmt.setString(10, bedClassValues); //Added Against 673 CRF 
			//pstmt.setString(10, attdntorderappl_yn);//Added Against ML-MMOH-CRF-1005
			pstmt.setString(11, mealClass);			
		
			rslt = pstmt.execute();
			err_no = 1;
			con.commit();
			}
			catch(Exception e){
				System.err.println("eDS Exception Mealclass Update Type->"+e);
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
					System.err.println("Exception in Mealclass Update=="+e);
				}
			}
			return err_no;
	}


	private int insert(HttpServletRequest request, HttpServletResponse response) {
		boolean rslt = false;
		int err_no = 0;
		try{
			mealClass = request.getParameter("mealClass");
			longDesc = request.getParameter("longDesc");
			shortDesc = request.getParameter("shortDesc");
			enabledYn = request.getParameter("enabledYn");
			applstafforder_yn= request.getParameter("applstafforder_yn");
           	editmenuappl_yn = request.getParameter("editmenuappl_yn");//ML-MMOH-CRF-0669	
			attdntorderappl_yn = request.getParameter("attdntorderappl_yn");//ML-MMOH-CRF-1005	
			bedClassValues= request.getParameter("bedClassCode"); //CRF-673	
			
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
			//ML-MMOH-CRF-0669
		    if("on".equals(editmenuappl_yn)){
                editmenuappl_yn = "Y";	
			}
			else{
				editmenuappl_yn = "N";			
			}			 
			//ML-MMOH-CRF-0669		
			
			//ML-MMOH-CRF-1005 Starts Here
		    if("on".equals(attdntorderappl_yn)){
                attdntorderappl_yn = "Y";	
			}
			else{
				attdntorderappl_yn = "N";			
			}			 
			//ML-MMOH-CRF-1005 Ends Here
			session = request.getSession(false);
			this.prop = (java.util.Properties) session.getValue( "jdbc" ) ;
			this.facility_id = (String) session.getValue( "facility_id" ) ;
			login_user = this.prop.getProperty( "login_user" ) ;
			client_ip_address = this.prop.getProperty("client_ip_address") ;
			
			con = ConnectionManager.getConnection(request);
			pstmt = con.prepareStatement(DlQuery.DL_INSERT_MEAL_CLASS);
			pstmt.setString(1, mealClass);
			pstmt.setString(2, longDesc);
			pstmt.setString(3, shortDesc);
			pstmt.setString(4, enabledYn);
			pstmt.setString(5, login_user);
			pstmt.setString(6, facility_id);
			pstmt.setString(7, client_ip_address);
			pstmt.setString(8, login_user);
			pstmt.setString(9, facility_id);
			pstmt.setString(10, client_ip_address);
			pstmt.setString(11, applstafforder_yn);  //ML-MMOH-CRF-0419
			pstmt.setString(12, editmenuappl_yn );//ML-MMOH-CRF-0669
			pstmt.setString(13, attdntorderappl_yn );//Added Against ML-MMOH-CRF-1005
			pstmt.setString(14, bedClassValues );//ML-MMOH-CRF-0673
			
			
			rslt = pstmt.execute();
			err_no = 1;
			con.commit();
		}
		catch(Exception e){
			System.err.println("eDS Exception in MealClass insert->"+e);
			e.printStackTrace();
		}
		finally{
			try{
				if(pstmt!=null) pstmt.close();
				if(rst!=null) rst.close();
				ConnectionManager.returnConnection(con);
			}
			catch(Exception e){
				System.err.println("Exception in MEAL Create:"+e);
				err_no = 2;
			}

		}

		return err_no;

	}

}
