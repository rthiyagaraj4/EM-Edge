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
import eCommon.Common.CommonBean;
/**
 * Servlet implementation class DietTypeServlet
 */
public class MealTypeServlet extends HttpServlet {     
	//private static final long serialVersionUID = 1L;

	String mealType = "";
	String longDesc = "";
	String shortDesc = "";
    String enabledYn = "";
    String opmealorder_yn = "";
    String emmealorder_yn = "";
	String supldietorder_yn = "";//MMS-QH-CRF-0079
	String stmealorder_yn = "";//ML-MMOH-CRF-0820
    int order = 0;

	String facility_id="";
	String client_ip_address="";
	String login_user="";
	String mode = "";
	
	//ML_MMOH_CRF_0409 STARTS
	String Serving_Start_Time="";
	String Serving_End_Time="";
	String Irregular_Start_Time="";
	String Irregular_End_Time="";
	//ML_MMOH_CRF_0409 ENDS
	// Added Against Start ML-MOH-CRF-1006 
	String ipmealorder_yn = "";
	String DietCategoryCode=""; 
	String DocMealOrder_YN=""; 
	String OpsMealOrder_YN=""; 
	String OncMealOrder_YN=""; 
	String StfMealOrder_YN=""; 
	String StuMealOrder_YN=""; 
	// Added Against Start ML-MOH-CRF-1006 
	// Added Against Start ML-MOH-CRF-825
	String Op_Serving_Start_Time="",Op_Serving_End_Time="",Op_Irregular_Start_Time="",Op_Irregular_End_Time="";
	String Em_Serving_Start_Time="",Em_Serving_End_Time="",Em_Irregular_Start_Time="",Em_Irregular_End_Time="";
	String Supplement_Serving_Start_Time="",Supplement_Serving_End_Time="",Supplement_Irregular_Start_Time="",Supplement_Irregular_End_Time="";
	String Doc_Serving_Start_Time="",Doc_Serving_End_Time="",Doc_Irregular_Start_Time="",Doc_Irregular_End_Time="";
	String Ops_Serving_Start_Time="",Ops_Serving_End_Time="",Ops_Irregular_Start_Time="",Ops_Irregular_End_Time="";
	String Onc_Serving_Start_Time="",Onc_Serving_End_Time="",Onc_Irregular_Start_Time="",Onc_Irregular_End_Time="";
	String Staff_Serving_Start_Time="",Staff_Serving_End_Time="",Staff_Irregular_Start_Time="",Staff_Irregular_End_Time="";
	String Student_Serving_Start_Time="",Student_Serving_End_Time="",Student_Irregular_Start_Time="",Student_Irregular_End_Time="";	
	// Added Against End ML-MOH-CRF-825 
	
	java.util.Properties prop;
	HttpSession session;
    Connection con = null;
    PreparedStatement pstmt = null;
    ResultSet rst = null;
    CommonCheckPk commonChk = null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MealTypeServlet() {
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
			if(!(commonChk.checkForPk(request, response, DlQuery.DL_MEAL_TYPE_CHECK_PK, request.getParameter("meal_Type")))){
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

	//CRF-230 Changes: This method is modified for enabling meal type for placing OPmeal order
	private int update(HttpServletRequest request,HttpServletResponse response) {
		boolean rslt = false;
		int err_no = 0;
		try{
			mealType = request.getParameter("updMealType");
			longDesc = request.getParameter("long_Desc");
			shortDesc = request.getParameter("short_Desc");
			enabledYn = request.getParameter("enabled_Yn");
			opmealorder_yn = request.getParameter("opmealorder_yn");//CRF-230
			emmealorder_yn= request.getParameter("emmealorder_yn");//CRF-412
			supldietorder_yn= request.getParameter("supldietorder_yn");//MMS-QH-CRF-0079
			stmealorder_yn= request.getParameter("stmealorder_yn");//ML-MMOH-CRF-0820
			//ML_MMOH_CRF_0409 STARTS
			Serving_Start_Time=request.getParameter("ServingStartTime");
			Serving_End_Time=request.getParameter("ServingEndTime");
			Irregular_Start_Time=request.getParameter("IrregularStartTime");
			Irregular_End_Time=request.getParameter("IrregularEndTime");
			//ML_MMOH_CRF_0409
			//Added Against Start ML-MOH-CRF-1006
			ipmealorder_yn = request.getParameter("ipmealorder_yn");
			DocMealOrder_YN = request.getParameter("docMealOrderYn");
			OpsMealOrder_YN = request.getParameter("opsMealOrderYn");
			OncMealOrder_YN = request.getParameter("oncMealOrderYn");
			StfMealOrder_YN = request.getParameter("stcMealOrderYn");
			StuMealOrder_YN = request.getParameter("stuMealOrderYn");
			//Added Against End ML-MOH-CRF-1006
			order = Integer.parseInt(request.getParameter("updOrder"));
			//Added Againt ML-MMOH-CRF-0825 Starts
			Op_Serving_Start_Time=CommonBean.checkForNull(request.getParameter("OpServingStartTime"));
			Op_Serving_End_Time=CommonBean.checkForNull(request.getParameter("OpServingEndTime"));
			Op_Irregular_Start_Time=CommonBean.checkForNull(request.getParameter("OpIrregularStartTime"));
			Op_Irregular_End_Time=CommonBean.checkForNull(request.getParameter("OpIrregularEndTime"));			
		
			Em_Serving_Start_Time=CommonBean.checkForNull(request.getParameter("EmServingStartTime"));
			Em_Serving_End_Time=CommonBean.checkForNull(request.getParameter("EmServingEndTime"));
			Em_Irregular_Start_Time=CommonBean.checkForNull(request.getParameter("EmIrregularStartTime"));
			Em_Irregular_End_Time=CommonBean.checkForNull(request.getParameter("EmIrregularEndTime"));
		
			Supplement_Serving_Start_Time=CommonBean.checkForNull(request.getParameter("SupplementServingStartTime"));
			Supplement_Serving_End_Time=CommonBean.checkForNull(request.getParameter("SupplementServingEndTime"));
			Supplement_Irregular_Start_Time=CommonBean.checkForNull(request.getParameter("SupplementIrregularStartTime"));
			Supplement_Irregular_End_Time=CommonBean.checkForNull(request.getParameter("SupplementIrregularEndTime"));
		
			Doc_Serving_Start_Time=CommonBean.checkForNull(request.getParameter("DocServingStartTime"));
			Doc_Serving_End_Time=CommonBean.checkForNull(request.getParameter("DocServingEndTime"));
			Doc_Irregular_Start_Time=CommonBean.checkForNull(request.getParameter("DocIrregularStartTime"));
			Doc_Irregular_End_Time=CommonBean.checkForNull(request.getParameter("DocIrregularEndTime"));
			
			Ops_Serving_Start_Time=CommonBean.checkForNull(request.getParameter("OpsServingStartTime"));
			Ops_Serving_End_Time=CommonBean.checkForNull(request.getParameter("OpsServingEndTime"));
			Ops_Irregular_Start_Time=CommonBean.checkForNull(request.getParameter("OpsIrregularStartTime"));
			Ops_Irregular_End_Time=CommonBean.checkForNull(request.getParameter("OpsIrregularEndTime"));
			
			Onc_Serving_Start_Time=CommonBean.checkForNull(request.getParameter("OncServingStartTime"));
			Onc_Serving_End_Time=CommonBean.checkForNull(request.getParameter("OncServingEndTime"));
			Onc_Irregular_Start_Time=CommonBean.checkForNull(request.getParameter("OncIrregularStartTime"));
			Onc_Irregular_End_Time=CommonBean.checkForNull(request.getParameter("OncIrregularEndTime"));
			
			Staff_Serving_Start_Time=CommonBean.checkForNull(request.getParameter("StaffServingStartTime"));
			Staff_Serving_End_Time=CommonBean.checkForNull(request.getParameter("StaffServingEndTime"));
			Staff_Irregular_Start_Time=CommonBean.checkForNull(request.getParameter("StaffIrregularStartTime"));
			Staff_Irregular_End_Time=CommonBean.checkForNull(request.getParameter("StaffIrregularEndTime"));
			
			Student_Serving_Start_Time=CommonBean.checkForNull(request.getParameter("StudentServingStartTime"));
			Student_Serving_End_Time=CommonBean.checkForNull(request.getParameter("StudentServingEndTime"));
			Student_Irregular_Start_Time=CommonBean.checkForNull(request.getParameter("StudentIrregularStartTime"));
			Student_Irregular_End_Time=CommonBean.checkForNull(request.getParameter("StudentIrregularEndTime"));
			//Added Againt ML-MMOH-CRF-0825 Ends
			if("on".equals(enabledYn)){
				enabledYn = "E";
			}else{
				enabledYn = "D";
			}			
			//Added Against Start ML-MOH-CRF-1006
			if("on".equalsIgnoreCase(ipmealorder_yn)){
				ipmealorder_yn = "Y";
			}else{
				ipmealorder_yn = "N";
			}	
			//Added Against End ML-MOH-CRF-1006
			//CRF-230
			if("on".equalsIgnoreCase(opmealorder_yn)){
				opmealorder_yn = "Y";
			}else{
				opmealorder_yn = "N";
			}
			//CRF-412
			if("on".equalsIgnoreCase(emmealorder_yn)){
				emmealorder_yn = "Y";
			}else{
				emmealorder_yn = "N";
			}
			//MMS-QH-CRF-0079 Starts
			if("on".equalsIgnoreCase(supldietorder_yn)){
				supldietorder_yn = "Y";
			}else{
				supldietorder_yn = "N";
			}
			//MMS-QH-CRF-0079 Ends

			//ML-MMOH-CRF-0820 Starts
			if("on".equalsIgnoreCase(stmealorder_yn)){
				stmealorder_yn = "Y";
			}else{
				stmealorder_yn = "N";
			}
			//ML-MMOH-CRF-0820 Ends
			// Added Against Start ML-MOH-CRF-1006
			stmealorder_yn=""; 
			
			if("on".equalsIgnoreCase(DocMealOrder_YN)){
				DocMealOrder_YN = "Y";
			}else{
				DocMealOrder_YN = "N";
			}
			
			if("on".equalsIgnoreCase(OpsMealOrder_YN)){
				OpsMealOrder_YN = "Y";
			}else{
				OpsMealOrder_YN = "N";
			}
			
			if("on".equalsIgnoreCase(OncMealOrder_YN)){
				OncMealOrder_YN = "Y";
			}else{
				OncMealOrder_YN = "N";
			}
			
			if("on".equalsIgnoreCase(StfMealOrder_YN)){
				StfMealOrder_YN = "Y";
			}else{
				StfMealOrder_YN = "N";
			}
		
			if("on".equalsIgnoreCase(StuMealOrder_YN)){
				StuMealOrder_YN = "Y";
			}else{
				StuMealOrder_YN = "N";
			}
			// Added Against End ML-MOH-CRF-1006
			session = request.getSession(false);
			this.prop = (java.util.Properties) session.getValue( "jdbc" ) ;
			this.facility_id = (String) session.getValue( "facility_id" ) ;
			login_user = this.prop.getProperty( "login_user" ) ;
			client_ip_address = this.prop.getProperty("client_ip_address") ;
			con = ConnectionManager.getConnection(request);
			pstmt = con.prepareStatement(DlQuery.DL_UPDATE_MEAL_TYPE);
			pstmt.setString(1, longDesc);
			pstmt.setString(2, shortDesc);
			pstmt.setInt(3, order);
			pstmt.setString(4, enabledYn);
			pstmt.setString(5, opmealorder_yn);
			pstmt.setString(6, emmealorder_yn);
			pstmt.setString(7, supldietorder_yn);//MMS-QH-CRF-0079
			pstmt.setString(8, stmealorder_yn);//ML-MMOH-CRF-0820
			pstmt.setString(9, login_user);
			pstmt.setString(10, facility_id);
			pstmt.setString(11, client_ip_address);
			//ML-MMOH-CRF-0409 STARTS
			pstmt.setString(12,Serving_Start_Time);
			pstmt.setString(13,Serving_End_Time);
			pstmt.setString(14,Irregular_Start_Time);
			pstmt.setString(15,Irregular_End_Time);
			//ML-MMOH-CRF-0409 ENDS
			//Added Against Start ML-MOH-CRF-1006
			pstmt.setString(16,ipmealorder_yn);
			pstmt.setString(17,DocMealOrder_YN);
			pstmt.setString(18,OpsMealOrder_YN);
			pstmt.setString(19,OncMealOrder_YN);
			pstmt.setString(20,StfMealOrder_YN);
			pstmt.setString(21,StuMealOrder_YN);
			//Added Against End ML-MOH-CRF-1006
			//Added Against ML-MMOH-CRF-0825-US3 Starts
			pstmt.setString(22,Op_Serving_Start_Time);
			pstmt.setString(23,Op_Serving_End_Time);
			pstmt.setString(24,Op_Irregular_Start_Time);
			pstmt.setString(25,Op_Irregular_End_Time);
			pstmt.setString(26,Em_Serving_Start_Time);
			pstmt.setString(27,Em_Serving_End_Time);
			pstmt.setString(28,Em_Irregular_Start_Time);
			pstmt.setString(29,Em_Irregular_End_Time);
			pstmt.setString(30,Supplement_Serving_Start_Time);
			pstmt.setString(31,Supplement_Serving_End_Time);
			pstmt.setString(32,Supplement_Irregular_Start_Time);
			pstmt.setString(33,Supplement_Irregular_End_Time);
			pstmt.setString(34,Doc_Serving_Start_Time);
			pstmt.setString(35,Doc_Serving_End_Time);
			pstmt.setString(36,Doc_Irregular_Start_Time);
			pstmt.setString(37,Doc_Irregular_End_Time);
			pstmt.setString(38,Ops_Serving_Start_Time);
			pstmt.setString(39,Ops_Serving_End_Time);
			pstmt.setString(40,Ops_Irregular_Start_Time);
			pstmt.setString(41,Ops_Irregular_End_Time);
			pstmt.setString(42,Onc_Serving_Start_Time);
			pstmt.setString(43,Onc_Serving_End_Time);
			pstmt.setString(44,Onc_Irregular_Start_Time);
			pstmt.setString(45,Onc_Irregular_End_Time);
			pstmt.setString(46,Staff_Serving_Start_Time);
			pstmt.setString(47,Staff_Serving_End_Time);
			pstmt.setString(48,Staff_Irregular_Start_Time);
			pstmt.setString(49,Staff_Irregular_End_Time);
			pstmt.setString(50,Student_Serving_Start_Time);
			pstmt.setString(51,Student_Serving_End_Time);
			pstmt.setString(52,Student_Irregular_Start_Time);
			pstmt.setString(53,Student_Irregular_End_Time);
			//Added Against ML-MMOH-CRF-0825-US3 Ends
			pstmt.setString(54, mealType); 
			
			rslt = pstmt.execute();
			err_no = 1;
			con.commit();
			}
			catch(Exception e){
				System.err.println("301 eDS Exception Meal Type->"+e);
				err_no = 2;
			}
			finally{
				try{
					if(pstmt!=null) pstmt.close();
					if(rst!=null) rst.close();
					ConnectionManager.returnConnection(con);
				}
				catch(Exception e){
					System.err.println("311 Exception in Meal Type:"+e);
				}
			}
			return err_no;
	}

	//CRF-230 Changes: This method is modified for enabling meal type for placing OPmeal order
	private int insert(HttpServletRequest request, HttpServletResponse response) {
		boolean rslt = false;
		int err_no = 0;
		try{
			mealType = request.getParameter("meal_Type");
			longDesc = request.getParameter("long_Desc");
			shortDesc = request.getParameter("short_Desc");
			enabledYn = request.getParameter("enabled_Yn");
			order = Integer.parseInt(request.getParameter("order_no"));
			opmealorder_yn = request.getParameter("opmealorder_yn");
			emmealorder_yn = request.getParameter("emmealorder_yn");
			supldietorder_yn = request.getParameter("supldietorder_yn");//MMS-QH-CRF-0079
			stmealorder_yn= request.getParameter("stmealorder_yn");//ML-MMOH-CRF-0820
			//ML-MMOH-CRF-0409 STARTS
			Serving_Start_Time=request.getParameter("ServingStartTime");
			Serving_End_Time=request.getParameter("ServingEndTime");
			Irregular_Start_Time=request.getParameter("IrregularStartTime");
			Irregular_End_Time=request.getParameter("IrregularEndTime");
			//ML-MMOH-CRF-0409 ENDS
			// Added Against Start ML-MOH-CRF-1006 
			ipmealorder_yn = request.getParameter("ipmealorder_yn");
			/* Commented Against ML-MOH-CRF-825
			String[] selecttype=request.getParameterValues("check");	
			String chkedValues="";			
			 if (selecttype != null) 
			{
				for (int i = 0; i < selecttype.length; i++){
						if(chkedValues.length() == 0)
						chkedValues = chkedValues; 	
						chkedValues = chkedValues + selecttype[i] + ",";						
					}
				DietCategoryCode=chkedValues.substring(0,chkedValues.length()-1);			
			}
			String[] myStrArr = DietCategoryCode.split(",");
			DocMealOrder_YN="N"; 
			OpsMealOrder_YN="N"; 
			OncMealOrder_YN="N"; 
			StfMealOrder_YN="N"; 
			StuMealOrder_YN="N"; 
			Commented End ML-MOH-CRF-825 */
			// Added Against Start ML-MOH-CRF-825
			
			DocMealOrder_YN = request.getParameter("docMealOrderYn");
			OpsMealOrder_YN = request.getParameter("opsMealOrderYn");
			OncMealOrder_YN = request.getParameter("oncMealOrderYn");
			StfMealOrder_YN = request.getParameter("stcMealOrderYn");
			StuMealOrder_YN = request.getParameter("stuMealOrderYn");
			
			Op_Serving_Start_Time=CommonBean.checkForNull(request.getParameter("OpServingStartTime"));
			Op_Serving_End_Time=CommonBean.checkForNull(request.getParameter("OpServingEndTime"));
			Op_Irregular_Start_Time=CommonBean.checkForNull(request.getParameter("OpIrregularStartTime"));
			Op_Irregular_End_Time=CommonBean.checkForNull(request.getParameter("OpIrregularEndTime"));
			
			Em_Serving_Start_Time=CommonBean.checkForNull(request.getParameter("EmServingStartTime"));
			Em_Serving_End_Time=CommonBean.checkForNull(request.getParameter("EmServingEndTime"));
			Em_Irregular_Start_Time=CommonBean.checkForNull(request.getParameter("EmIrregularStartTime"));
			Em_Irregular_End_Time=CommonBean.checkForNull(request.getParameter("EmIrregularEndTime"));
			
			Supplement_Serving_Start_Time=CommonBean.checkForNull(request.getParameter("SupplementServingStartTime"));
			Supplement_Serving_End_Time=CommonBean.checkForNull(request.getParameter("SupplementServingEndTime"));
			Supplement_Irregular_Start_Time=CommonBean.checkForNull(request.getParameter("SupplementIrregularStartTime"));
			Supplement_Irregular_End_Time=CommonBean.checkForNull(request.getParameter("SupplementIrregularEndTime"));
			
			Doc_Serving_Start_Time=CommonBean.checkForNull(request.getParameter("DocServingStartTime"));
			Doc_Serving_End_Time=CommonBean.checkForNull(request.getParameter("DocServingEndTime"));
			Doc_Irregular_Start_Time=CommonBean.checkForNull(request.getParameter("DocIrregularStartTime"));
			Doc_Irregular_End_Time=CommonBean.checkForNull(request.getParameter("DocIrregularEndTime"));
			
			Ops_Serving_Start_Time=CommonBean.checkForNull(request.getParameter("OpsServingStartTime"));
			Ops_Serving_End_Time=CommonBean.checkForNull(request.getParameter("OpsServingEndTime"));
			Ops_Irregular_Start_Time=CommonBean.checkForNull(request.getParameter("OpsIrregularStartTime"));
			Ops_Irregular_End_Time=CommonBean.checkForNull(request.getParameter("OpsIrregularEndTime"));
			
			Onc_Serving_Start_Time=CommonBean.checkForNull(request.getParameter("OncServingStartTime"));
			Onc_Serving_End_Time=CommonBean.checkForNull(request.getParameter("OncServingEndTime"));
			Onc_Irregular_Start_Time=CommonBean.checkForNull(request.getParameter("OncIrregularStartTime"));
			Onc_Irregular_End_Time=CommonBean.checkForNull(request.getParameter("OncIrregularEndTime"));
			
			Staff_Serving_Start_Time=CommonBean.checkForNull(request.getParameter("StaffServingStartTime"));
			Staff_Serving_End_Time=CommonBean.checkForNull(request.getParameter("StaffServingEndTime"));
			Staff_Irregular_Start_Time=CommonBean.checkForNull(request.getParameter("StaffIrregularStartTime"));
			Staff_Irregular_End_Time=CommonBean.checkForNull(request.getParameter("StaffIrregularEndTime"));
			
			Student_Serving_Start_Time=CommonBean.checkForNull(request.getParameter("StudentServingStartTime"));
			Student_Serving_End_Time=CommonBean.checkForNull(request.getParameter("StudentServingEndTime"));
			Student_Irregular_Start_Time=CommonBean.checkForNull(request.getParameter("StudentIrregularStartTime"));
			Student_Irregular_End_Time=CommonBean.checkForNull(request.getParameter("StudentIrregularEndTime"));			
			// Added Against End ML-MOH-CRF-825
			if("on".equals(enabledYn)){
				enabledYn = "E";
			}else{
				enabledYn = "D";
			}
			//Added Against Start ML-MOH-CRF-1006
			if("on".equalsIgnoreCase(ipmealorder_yn)){
				ipmealorder_yn = "Y";
			}else{
				ipmealorder_yn = "N";
			}
			//Added Against End ML-MOH-CRF-1006
			if("on".equalsIgnoreCase(opmealorder_yn)){
				opmealorder_yn = "Y";
			}else{
				opmealorder_yn = "N";
			}			
			if("on".equalsIgnoreCase(emmealorder_yn)){
				emmealorder_yn = "Y";
			}else{
				emmealorder_yn = "N";
			}
			//MMS-QH-CRF-0079 Starts
			if("on".equalsIgnoreCase(supldietorder_yn)){
				supldietorder_yn = "Y";
			}else{
				supldietorder_yn = "N";
			}
			//MMS-QH-CRF-0079 Ends

			//ML-MMOH-CRF-0820 Starts
			if("on".equalsIgnoreCase(stmealorder_yn)){
				stmealorder_yn = "Y";
			}
			else{
				stmealorder_yn = "N";
			}
			//ML-MMOH-CRF-0820 Ends
			
			// Added Against Start ML-MMOH-CRF-0825
			if("on".equalsIgnoreCase(DocMealOrder_YN)){
				DocMealOrder_YN = "Y";
			}
			else{
				DocMealOrder_YN = "N";
			}
			
			if("on".equalsIgnoreCase(OpsMealOrder_YN)){
				OpsMealOrder_YN = "Y";
			}
			else{
				OpsMealOrder_YN = "N";
			}
			
			if("on".equalsIgnoreCase(OncMealOrder_YN)){
				OncMealOrder_YN = "Y";
			}
			else{
				OncMealOrder_YN = "N";
			}
			
			if("on".equalsIgnoreCase(StfMealOrder_YN)){
				StfMealOrder_YN = "Y";
			}
			else{
				StfMealOrder_YN = "N";
			}
			
			if("on".equalsIgnoreCase(StuMealOrder_YN)){
				StuMealOrder_YN = "Y";
			}
			else{
				StuMealOrder_YN = "N";
			}
			
			// Added Against End ML-MMOH-CRF-0825

			stmealorder_yn=""; //Added Agaist ML-MOH-CRF-1006			
			session = request.getSession(false);
			this.prop = (java.util.Properties) session.getValue( "jdbc" ) ;
			this.facility_id = (String) session.getValue( "facility_id" ) ;
			login_user = this.prop.getProperty( "login_user" ) ;
			client_ip_address = this.prop.getProperty("client_ip_address") ;
			con = ConnectionManager.getConnection(request);
			pstmt = con.prepareStatement(DlQuery.DL_INSERT_MEAL_TYPE);
			pstmt.setString(1, mealType);
			pstmt.setString(2, longDesc);
			pstmt.setString(3, shortDesc);
			pstmt.setInt(4, order);
			pstmt.setString(5, enabledYn);			
			pstmt.setString(6, opmealorder_yn);
			pstmt.setString(7, emmealorder_yn);
			pstmt.setString(8, supldietorder_yn);//MMS-QH-CRF-0079
			pstmt.setString(9, stmealorder_yn);//ML-MMOH-CRF-0820
			pstmt.setString(10, login_user);
			pstmt.setString(11, facility_id);
			pstmt.setString(12, client_ip_address);
			pstmt.setString(13, login_user);
			pstmt.setString(14, facility_id);
			pstmt.setString(15, client_ip_address);
			//ML-MMOH-CRF-0409 STARTS
			pstmt.setString(16, Serving_Start_Time);
			pstmt.setString(17, Serving_End_Time);
			pstmt.setString(18, Irregular_Start_Time);
			pstmt.setString(19, Irregular_End_Time);
			//ML-MMOH-CRF-0409 ENDS
			//Added Agaist Start ML-MOH-CRF-1006	
			pstmt.setString(20, ipmealorder_yn);
			/* Commented Against Start ML-MOH-CRF-825
			for(int k=0; k<myStrArr.length ; k++){
				if(myStrArr[k].equals("DOC"))
					DocMealOrder_YN = "Y";
				if(myStrArr[k].equals("OPS"))	
					OpsMealOrder_YN = "Y";	
				if(myStrArr[k].equals("ONC"))
					OncMealOrder_YN = "Y";
				if(myStrArr[k].equals("STF"))
					StfMealOrder_YN = "Y";	
				if(myStrArr[k].equals("STU")) 
					StuMealOrder_YN = "Y";
			} 
			Commented Against End ML-MOH-CRF-825 */		
			pstmt.setString(21, DocMealOrder_YN);
			pstmt.setString(22, OpsMealOrder_YN);
			pstmt.setString(23, OncMealOrder_YN);
			pstmt.setString(24, StfMealOrder_YN);
			pstmt.setString(25, StuMealOrder_YN);
			/* Added Against Start ML-MOH-CRF-825 */				
			pstmt.setString(26, Op_Serving_Start_Time);
			pstmt.setString(27, Op_Serving_End_Time);
			pstmt.setString(28, Op_Irregular_Start_Time);
			pstmt.setString(29, Op_Irregular_End_Time);
			pstmt.setString(30, Em_Serving_Start_Time);
			pstmt.setString(31, Em_Serving_End_Time);
			pstmt.setString(32, Em_Irregular_Start_Time);
			pstmt.setString(33, Em_Irregular_End_Time);
			pstmt.setString(34, Supplement_Serving_Start_Time);
			pstmt.setString(35, Supplement_Serving_End_Time);
			pstmt.setString(36, Supplement_Irregular_Start_Time);
			pstmt.setString(37, Supplement_Irregular_End_Time);
			pstmt.setString(38, Doc_Serving_Start_Time);
			pstmt.setString(39, Doc_Serving_End_Time);
			pstmt.setString(40, Doc_Irregular_Start_Time);
			pstmt.setString(41, Doc_Irregular_End_Time);
			pstmt.setString(42, Ops_Serving_Start_Time);
			pstmt.setString(43, Ops_Serving_End_Time);
			pstmt.setString(44, Ops_Irregular_Start_Time);
			pstmt.setString(45, Ops_Irregular_End_Time);						
			pstmt.setString(46, Onc_Serving_Start_Time);
			pstmt.setString(47, Onc_Serving_End_Time);
			pstmt.setString(48, Onc_Irregular_Start_Time);
			pstmt.setString(49, Onc_Irregular_End_Time);						
			pstmt.setString(50, Staff_Serving_Start_Time);
			pstmt.setString(51, Staff_Serving_End_Time);
			pstmt.setString(52, Staff_Irregular_Start_Time);
			pstmt.setString(53, Staff_Irregular_End_Time);						
			pstmt.setString(54, Student_Serving_Start_Time);
			pstmt.setString(55, Student_Serving_End_Time);
			pstmt.setString(56, Student_Irregular_Start_Time);
			pstmt.setString(57, Student_Irregular_End_Time);						
			/* Added Against End ML-MOH-CRF-825 */				
			//Added Agaist End ML-MOH-CRF-1006				
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
