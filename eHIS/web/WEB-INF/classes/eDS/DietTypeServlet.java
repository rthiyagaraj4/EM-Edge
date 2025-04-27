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
public class DietTypeServlet extends HttpServlet {
    // Checkstyle Violation commented by Munisekhar
	//private static final long serialVersionUID = 1L;

	String dietType = "";
	String dietDescription = "";
	String shortDescription = "";
	String ageGroup = "";
    String defaultDietType = "";
    String defaultFeedType = "";
    String dietCycleType = "";
    String orderCatlogcode = "";
    String dietCategory = "";
	String applstafforder_yn= "";//Added against CRF-0419
    String enabled = "";
	String ipdiettype_yn = "";   //ML-MMOH-CRF-0820
	String dcdiettype_yn = "";   //ML-MMOH-CRF-0820
	
	String opdiettype_yn = "";   //ML-MMOH-CRF-0418
    String emdiettype_yn = "";   //ML-MMOH-CRF-0418
	String attdntorderappl_yn =""; //ML-MMOH-CRF-0670-US001
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
    public DietTypeServlet() {
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
			if(!(commonChk.checkForPk(request, response, DlQuery.DL_DIET_CHECK_PK, request.getParameter("dietType")))){
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
		dietType = request.getParameter("dietType");
		dietDescription = request.getParameter("longDesc");
		shortDescription = request.getParameter("shortDesc");
		ageGroup = request.getParameter("ageGroup");
		defaultDietType = request.getParameter("defaultDiet");
		if("on".equals(defaultDietType)){
			defaultDietType = "Y";
		}
		else{
			defaultDietType = "N";
		}
		defaultFeedType = request.getParameter("defaultFeed");
		dietCycleType = request.getParameter("dietCycle");
		orderCatlogcode = request.getParameter("orderCatalogDescription");
		dietCategory = request.getParameter("dietCategory");
		
		//Added against CRF-0419 Starts Here
		applstafforder_yn= request.getParameter("applstafforder_yn");
		if("on".equals(applstafforder_yn)){
			applstafforder_yn = "Y";
		}
		else{
			applstafforder_yn = "N";
		}
		//Added against CRF-0419 Ends Here

		//Added against ML-MMOH-CRF-0670-US001 Starts Here
		attdntorderappl_yn= request.getParameter("attdntorderappl_yn");
		if("on".equals(attdntorderappl_yn)){
			attdntorderappl_yn = "Y";
		}
		else{
			attdntorderappl_yn = "N";
		}
		//Added against ML-MMOH-CRF-0670-US001 Ends Here

		
		enabled = request.getParameter("enable");
		if("on".equals(enabled)){
			enabled = "E";
		}
		else{
			enabled = "D";
		}

		//ML-MMOH-CRF-0820 Starts
		ipdiettype_yn=request.getParameter("ipdiettype_yn");
		if("on".equals(ipdiettype_yn)){
			ipdiettype_yn = "Y";
		}
		else{
			ipdiettype_yn = "N";
		}

		dcdiettype_yn=request.getParameter("dcdiettype_yn");
		if("on".equals(dcdiettype_yn)){
			dcdiettype_yn = "Y";
		}
		else{
			dcdiettype_yn = "N";
		}
		//ML-MMOH-CRF-0820 Ends

		//ML-MMOH-CRF-0418
		opdiettype_yn=request.getParameter("opdiettype_yn");
		if("on".equals(opdiettype_yn)){
			opdiettype_yn = "Y";
		}
		else{
			opdiettype_yn = "N";
		}
		emdiettype_yn=request.getParameter("emdiettype_yn");
		if("on".equals(emdiettype_yn)){
			emdiettype_yn = "Y";
		}
		else{
			emdiettype_yn = "N";
		}
		//ML-MMOH-CRF-0418
				
		session = request.getSession(false);
		this.prop = (java.util.Properties) session.getValue( "jdbc" ) ;
		this.facility_id = (String) session.getValue( "facility_id" ) ;
		login_user = this.prop.getProperty( "login_user" ) ;
		client_ip_address = this.prop.getProperty("client_ip_address") ;

		con = ConnectionManager.getConnection(request);
		pstmt = con.prepareStatement(DlQuery.DL_DIET_UPDATE);
		pstmt.setString(1, dietDescription);
		pstmt.setString(2, shortDescription);
		pstmt.setString(3, ageGroup);
		pstmt.setString(4, defaultFeedType);
		pstmt.setString(5, defaultDietType);
		pstmt.setString(6, dietCycleType);
		pstmt.setString(7, ipdiettype_yn);   //ML-MMOH-CRF-0820
		pstmt.setString(8, dcdiettype_yn);   //ML-MMOH-CRF-0820
		pstmt.setString(9, opdiettype_yn);   //ML-MMOH-CRF-0418
		pstmt.setString(10, emdiettype_yn);   //ML-MMOH-CRF-0418
		pstmt.setString(11, applstafforder_yn);  //ML-MMOH-CRF-0419
		pstmt.setString(12, attdntorderappl_yn);//Added Against ML-MMOH-CRF-0670-US001
		pstmt.setString(13, enabled);
		pstmt.setString(14, login_user);
		pstmt.setString(15, facility_id);
		pstmt.setString(16, client_ip_address);
		pstmt.setString(17, dietType);
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

	private int insert(HttpServletRequest request, HttpServletResponse response) {
		boolean rslt = false;
		int err_no = 0;
		try{
		dietType = request.getParameter("dietType");
		dietDescription = request.getParameter("longDesc");
		shortDescription = request.getParameter("shortDesc");
		ageGroup = request.getParameter("ageGroup");
		defaultDietType = request.getParameter("defaultDiet");
		if("on".equals(defaultDietType)){
			defaultDietType = "Y";
		}
		else{
			defaultDietType = "N";
		}
		defaultFeedType = request.getParameter("defaultFeed");
		dietCycleType = request.getParameter("dietCycle");
		orderCatlogcode = request.getParameter("orderCatalogDescription");
		dietCategory = request.getParameter("dietCategory");
		//Added against CRF-0419 Starts Here
		applstafforder_yn= request.getParameter("applstafforder_yn");
		if("on".equals(applstafforder_yn)){
			applstafforder_yn = "Y";
		}
		else{
			applstafforder_yn = "N";
		}
		//Added against CRF-0419 Ends Here
		enabled = request.getParameter("enable");
		if("on".equals(enabled)){
			enabled = "E";
		}
		else{
			enabled = "D";
		}

		//ML-MMOH-CRF-0820 Starts
		ipdiettype_yn = request.getParameter("ipdiettype_yn");
		if("on".equals(ipdiettype_yn)){
			ipdiettype_yn = "Y";
		}
		else{
			ipdiettype_yn = "N";
		}

		dcdiettype_yn = request.getParameter("dcdiettype_yn");
		if("on".equals(dcdiettype_yn)){
			dcdiettype_yn = "Y";
		}
		else{
			dcdiettype_yn = "N";
		}
		//ML-MMOH-CRF-0820 Ends

		//ML-MMOH-CRF-0418
		opdiettype_yn = request.getParameter("opdiettype_yn");
		if("on".equals(opdiettype_yn)){
			opdiettype_yn = "Y";
		}
		else{
			opdiettype_yn = "N";
		}
       emdiettype_yn=request.getParameter("emdiettype_yn");
	   if("on".equals(emdiettype_yn)){
	            emdiettype_yn ="Y";
				}
				else{
				    emdiettype_yn="N";
		}
		//ML-MMOH-CRF-0418	
		//ML-MMOH-CRF-0670-US001
		attdntorderappl_yn=request.getParameter("attdntorderappl_yn");
	   if("on".equals(attdntorderappl_yn)){
	            attdntorderappl_yn ="Y";
				}
				else{
				    attdntorderappl_yn="N";
		}
		//ML-MMOH-CRF-0670-US001
		session = request.getSession(false);
		this.prop = (java.util.Properties) session.getValue( "jdbc" ) ;
		this.facility_id = (String) session.getValue( "facility_id" ) ;
		login_user = this.prop.getProperty( "login_user" ) ;
		client_ip_address = this.prop.getProperty("client_ip_address") ;

		con = ConnectionManager.getConnection(request);
		pstmt = con.prepareStatement(DlQuery.DL_DIET_TYPE);
		pstmt.setString(1, dietType);
		pstmt.setString(2, dietDescription);
		pstmt.setString(3, shortDescription);
		pstmt.setString(4, ageGroup);
		pstmt.setString(5, dietCategory);
		pstmt.setString(6, defaultFeedType);
		pstmt.setString(7, defaultDietType);
		pstmt.setString(8, dietCycleType);
		pstmt.setString(9, orderCatlogcode);
		pstmt.setString(10, ipdiettype_yn);   //ML-MMOH-CRF-0820
		pstmt.setString(11, dcdiettype_yn);   //ML-MMOH-CRF-0820
		pstmt.setString(12, opdiettype_yn);   //ML-MMOH-CRF-0418
		pstmt.setString(13, emdiettype_yn);   //ML-MMOH-CRF-0418
		pstmt.setString(14, applstafforder_yn);   //ML-MMOH-CRF-0419
		pstmt.setString(15, attdntorderappl_yn );//Added Against ML-MMOH-CRF-0670-US001
		pstmt.setString(16, enabled);
		pstmt.setString(17, login_user);
		pstmt.setString(18, facility_id);
		pstmt.setString(19, client_ip_address);
		pstmt.setString(20, login_user);
		pstmt.setString(21, facility_id);
		pstmt.setString(22, client_ip_address);
		rslt = pstmt.execute();
		
		pstmt = con.prepareStatement("update or_order_catalog set contr_mod_id='DS',contr_msr_panel_id = ? where order_catalog_code = ? and order_category='DS'");
		pstmt.setString(1, dietType);
		pstmt.setString(2, orderCatlogcode);
		rslt = pstmt.execute();
		if(pstmt!=null) pstmt.close();	//Common-ICN-0044
		
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