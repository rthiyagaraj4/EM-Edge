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
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import webbeans.eCommon.ConnectionManager;

/**
 * Servlet implementation class DSparameterForTheFacilityServlet
 */
public class DSparameterForTheFacilityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PrintWriter out;
	java.util.Properties prop;
	HttpSession session;
	Connection con = null;
	PreparedStatement pstmt = null;
	//ResultSet rs = null;
	//HashMap support_data = new HashMap();
	String msg="";

	StringBuffer sb = new StringBuffer();
	String facility_id="",str_user_id="",str_client_ip_address="",login_user="",locale="",deptCode="",uomCode="",mode="";
	Boolean isUpdateSuccess=false;
	String generateDefaultDiet="", labelForDefaultDiet="",labelMessage="",blInterface="",inventoryInterface="",inventoryStoreCode="",multiKitchen="",kitchenCode="",chargeStdService="",dialyDietOrders="",maxMealPlanCreateDays="",trackMenuValidity="",mealPlanNextSeq="",acceptDietForMeal="",enableRDAAlert="",attendantOrderApplicable="",cutOffTimeForLiquidFood="",gracePeriod="",gracePeriodApplicable="",multiFacilityOP="";
	String enableDrugFood="";//MMS-KH-CRF-0029.1-US008
	//crf-427
	String RestrictDateRangeforInpatientsYN="",MaximumDaysAllowed="";
	String GenerateNilByMouth="";//crf-78.1
	String LATE_IRREGULAR_DIET_ORD_FOR_IP="",RestrictMealServingStartTime="",NotificationMessageforPlaceDietOrder="";
	String Attendent_Label_Name="";//ML-MMOH-CRF-406
	String attendantcount="";//ML-MMOH-CRF-0412
	//ML-MMOH-CRF-0600
	String op_em_served="",op_em_accept="",op_em_allow="";
	String ip_MealPrepared="",ip_MealReceived="",ip_MealServed="",ip_allow="";
	//ML-MMOH-CRF-0600
	String LATE_IRREGULAR_DIET_ORD_FOR_OP="",LATE_IRREGULAR_DIET_ORD_FOR_EM="",LATE_IRREGULAR_DIET_ORD_FOR_ST="",LATE_IRREGULAR_DIET_ORD_FOR_SP="";//ML-MMOH-CRF-0825
	//Added by santhosh for ML-MMOH-CRF-1961
	String InstructionInLabelFormula="";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DSparameterForTheFacilityServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String error_value = "0" ;
		String error = "";
		//boolean flag=true;	//Common-ICN-0044
		session = request.getSession(false);
		this.prop = (java.util.Properties) session.getValue("jdbc");
		this.facility_id = (String) request.getParameter("facilityId");
		if(facility_id == null) facility_id="";
		str_user_id      = (String) session.getValue("login_user");
		if(str_user_id == null) str_user_id="";
		str_client_ip_address = prop.getProperty("client_ip_address");
		login_user = prop.getProperty( "login_user" ) ;
		if(str_client_ip_address == null) str_client_ip_address="";
		if(login_user == null) login_user="";
		locale = prop.getProperty("LOCALE");
		int count = 0;//ML--MMOH-CRF-0600
		try {
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/html;charset=UTF-8");
			this.out = response.getWriter();
			this.generateDefaultDiet=(String)request.getParameter("generateDefaultDietYn");
			this.labelForDefaultDiet="N";
			this.labelMessage=(String)request.getParameter("labelMessage");
			this.blInterface=(String)request.getParameter("blInterfaceYn");
			this.inventoryInterface="N";
			this.inventoryStoreCode="N";
			this.multiKitchen=(String)request.getParameter("multiKitchenYn");
			if(multiKitchen == null) multiKitchen="N"; 
			this.kitchenCode=(String)request.getParameter("kitchenCode");
			this.chargeStdService="";
			this.dialyDietOrders="";
			this.maxMealPlanCreateDays=(String)request.getParameter("maxMealPlanCreatDays");
			this.trackMenuValidity="";
			this.mealPlanNextSeq=(String)request.getParameter("mealPlanNextSeq");
			this.acceptDietForMeal=(String)request.getParameter("acceptDietForIndMealYn");
			this.enableRDAAlert="";
			this.attendantOrderApplicable=(String)request.getParameter("attendantOrderApplicableYn");
			this.cutOffTimeForLiquidFood=(String)request.getParameter("cutoffTimeforFreqBased");
			this.gracePeriod = (String)request.getParameter("gracePeriod");
			this.gracePeriodApplicable = (String)request.getParameter("gracePeriodApplicableYn");
			//CRF-230 changes  - For Enabling multifacility/alternate facility option in Place OPMealOrder screen. 
			this.multiFacilityOP = (String)request.getParameter("multiFacilityOPyn");
			this.RestrictDateRangeforInpatientsYN=(String)request.getParameter("RestrictDateRangeforInpatientsYN");//ML-MMOH-CRF-0427
			this.MaximumDaysAllowed=(String)request.getParameter("MaximumDaysAllowed");//ML-MMOH-CRF-0427
			//crf-78.1
			this.GenerateNilByMouth=(String)request.getParameter("GenerateNilByMouth_YN");//MMs-CRF-78.1
			//ML-MMOH-CRF-409 starts
			this.LATE_IRREGULAR_DIET_ORD_FOR_IP=(String)request.getParameter("LATE_IRREGULAR_DIET_ORD_FOR_IP");
			if(LATE_IRREGULAR_DIET_ORD_FOR_IP == null) LATE_IRREGULAR_DIET_ORD_FOR_IP="N";

			//ML-MMOH-CRF-0825 STARTS
			this.LATE_IRREGULAR_DIET_ORD_FOR_OP=(String)request.getParameter("LATE_IRREGULAR_DIET_ORD_FOR_OP");
			if(LATE_IRREGULAR_DIET_ORD_FOR_OP == null) LATE_IRREGULAR_DIET_ORD_FOR_OP="N";

			this.LATE_IRREGULAR_DIET_ORD_FOR_EM=(String)request.getParameter("LATE_IRREGULAR_DIET_ORD_FOR_EM");
			if(LATE_IRREGULAR_DIET_ORD_FOR_EM == null) LATE_IRREGULAR_DIET_ORD_FOR_EM="N";

			this.LATE_IRREGULAR_DIET_ORD_FOR_ST=(String)request.getParameter("LATE_IRREGULAR_DIET_ORD_FOR_ST");
			if(LATE_IRREGULAR_DIET_ORD_FOR_ST == null) LATE_IRREGULAR_DIET_ORD_FOR_ST="N";

			this.LATE_IRREGULAR_DIET_ORD_FOR_SP=(String)request.getParameter("LATE_IRREGULAR_DIET_ORD_FOR_SP");
			if(LATE_IRREGULAR_DIET_ORD_FOR_SP == null) LATE_IRREGULAR_DIET_ORD_FOR_SP="N";
			//ML-MMOH-CRF-0825 ENDS
			
			this.enableDrugFood = (String)request.getParameter("enableDrugFoodYN");//MMS-KH-CRF-0029.1-US008
			this.NotificationMessageforPlaceDietOrder=(String)request.getParameter("NotificationMessageforPlaceDietOrder");
			//ML-MMOH-CRF-409 ends	
			this.Attendent_Label_Name=(String)request.getParameter("Attendent_Label_Name");//ML-MMOH-CRF-406
			this.attendantcount=(String)request.getParameter("attendantcount");//ML-MMOH-CRF-412
			this.mode=(String)request.getParameter("mode");
			//ML-MMOH-CRF-0600
			this.op_em_served=(String)request.getParameter("op_served_yn");
			if(op_em_served == null) op_em_served="N";
			this.op_em_accept=(String)request.getParameter("op_accept_yn");
			if(op_em_accept == null) op_em_accept="N";
			//this.op_em_reject=(String)request.getParameter("op_reject_yn");
			//if(op_em_reject == null) op_em_reject="N";
			//Newly added for CRF600
			this.op_em_allow=(String)request.getParameter("allow_op_em_yn");
			if(op_em_allow == null) op_em_allow="N";
			this.ip_MealPrepared=(String)request.getParameter("ip_MealPrepared_yn");
			if(ip_MealPrepared == null) ip_MealPrepared="N";
			this.ip_MealReceived=(String)request.getParameter("ip_MealReceived_yn");
			if(ip_MealReceived == null) ip_MealReceived="N";
			this.ip_MealServed=(String)request.getParameter("ip_MealServed_yn");
			if(ip_MealServed == null) ip_MealServed="N";
			//this.ip_MealReject=(String)request.getParameter("ip_MealReject_yn");
			//if(ip_MealReject == null) ip_MealReject="N";
			this.ip_allow=(String)request.getParameter("allow_ip_yn");
			if(ip_allow == null) ip_allow="N";
			//ML-MMOH-CRF-0600
			//Added by santhosh for ML-MMOH-CRF-1961
			this.InstructionInLabelFormula=(String)request.getParameter("InstructionInLabelFormula");
			con	=	ConnectionManager.getConnection(request);
			con.setAutoCommit(false);
			if(mode.equals("modify")) {
				//String strQuery="update DS_PARAM_FOR_FACILITY set GENERATE_DEFAULT_DIET_YN=?, LABEL_FOR_DEFAULT_DIET_YN=?, LABEL_MESSAGE=?, BL_INTERFACE_YN=?, INVENTORY_INTERFACE_YN=?, INVENTORY_STORE_CODE=?, MULTI_KITCHEN_YN=?, KITCHEN_CODE=?, CHARGE_STD_SERVICE_YN=?, DAILY_DIET_ORDERS_YN=?, MAX_MEAL_PLAN_CREAT_DAYS=?, TRACK_MENU_VALIDITY_YN=?, MEAL_PLAN_NEXT_SEQ=?, ACCEPT_DIET_FOR_IND_MEAL_YN=?, ENABLE_RDA_ALERT_YN=?, ATTENDANT_ORDER_APPLICABLE_YN=?, CUTOFF_TIME_FOR_ACK_LIQFOOD=?, ADDED_BY_ID=?, ADDED_DATE=?, ADDED_FACILITY_ID=?, ADDED_AT_WS_NO=?, MODIFIED_BY_ID=?, MODIFIED_DATE=?, MODIFIED_FACILITY_ID=?, MODIFIED_AT_WS_NO=? where OPERATING_FACILITY_ID=?";
				/* String strQuery="update DS_PARAM_FOR_FACILITY set GENERATE_DEFAULT_DIET_YN=nvl(?,'N'), LABEL_MESSAGE=?, BL_INTERFACE_YN=nvl(?,'N'), " +
				"MULTI_KITCHEN_YN=nvl(?,'N'), KITCHEN_CODE=?, MAX_MEAL_PLAN_CREAT_DAYS=?, MEAL_PLAN_NEXT_SEQ=?, " +
				"ACCEPT_DIET_FOR_IND_MEAL_YN=nvl(?,'N'), ATTENDANT_ORDER_APPLICABLE_YN=nvl(?,'N'), CUTOFF_TIME_FOR_ACK_LIQFOOD=?, " +
				"GRACE_PERIOD=?,GRACE_PERIOD_APPLICABLE_YN=nvl(?,'N'), MULTIFACILITY_YN=nvl(?,'N'), ADDED_BY_ID=?, ADDED_DATE=?, ADDED_FACILITY_ID=?, ADDED_AT_WS_NO=?, MODIFIED_BY_ID=?, MODIFIED_DATE=?," +
				"MODIFIED_FACILITY_ID=?, MODIFIED_AT_WS_NO=?,RESTRICT_DATE_INPATIENTS_YN=?,MAXIMUM_DAYS_ALLOWED=?,GEN_MEALPLAN_FOR_NBM_PAT_YN=?,LATE_IRREGULAR_DIET_ORD_FOR_IP=nvl(?,'N'),IRREGULAR_MEAL_ORD_MESSAGE=?,Attendent_Label_Name=?,NO_OF_ATTENDANT=nvl(?,0),op_em_served_yn=nvl(?,'N'),op_em_accept_yn=nvl(?,'N'),allow_place_ord_op_em=nvl(?,'N'),ip_MealPrepared_yn=nvl(?,'N'),ip_MealReceived_yn=nvl(?,'N'),ip_MealServed_yn=nvl(?,'N'),allow_place_ord_ip=nvl(?,'N') where OPERATING_FACILITY_ID=?"; *///MMS-CRF-78.1 and ML-MMOH-CRF-0427 and ML-MMOH-CRF-406 AND ML-MMOH-CRF-412 & CRF-600
				
				String strQuery=" update DS_PARAM_FOR_FACILITY set GENERATE_DEFAULT_DIET_YN=nvl(?,'N'), LABEL_MESSAGE=?, BL_INTERFACE_YN=nvl(?,'N'), MULTI_KITCHEN_YN=nvl(?,'N'), KITCHEN_CODE=?,  MAX_MEAL_PLAN_CREAT_DAYS=?, MEAL_PLAN_NEXT_SEQ=?, ACCEPT_DIET_FOR_IND_MEAL_YN=nvl(?,'N'),  ATTENDANT_ORDER_APPLICABLE_YN=nvl(?,'N'), CUTOFF_TIME_FOR_ACK_LIQFOOD=?,  GRACE_PERIOD=?, GRACE_PERIOD_APPLICABLE_YN=nvl(?,'N'), MULTIFACILITY_YN=nvl(?,'N'), ADDED_BY_ID=?, ADDED_DATE=?,  ADDED_FACILITY_ID=?, ADDED_AT_WS_NO=?, MODIFIED_BY_ID=?, MODIFIED_DATE=?, MODIFIED_FACILITY_ID=?, MODIFIED_AT_WS_NO=?, RESTRICT_DATE_INPATIENTS_YN=?, MAXIMUM_DAYS_ALLOWED=?, GEN_MEALPLAN_FOR_NBM_PAT_YN=?, LATE_IRREGULAR_DIET_ORD_FOR_IP=nvl(?,'N'), IRREGULAR_MEAL_ORD_MESSAGE=?, Attendent_Label_Name=?, NO_OF_ATTENDANT=nvl(?,0), op_em_served_yn=nvl(?,'N'), op_em_accept_yn=nvl(?,'N'), allow_place_ord_op_em=nvl(?,'N'), ip_MealPrepared_yn=nvl(?,'N'), ip_MealReceived_yn=nvl(?,'N'), ip_MealServed_yn=nvl(?,'N'), allow_place_ord_ip=nvl(?,'N'), LATE_IRREGULAR_DIET_ORD_FOR_OP=nvl(?,'N'), LATE_IRREGULAR_DIET_ORD_FOR_EM=nvl(?,'N'), LATE_IRREGULAR_DIET_ORD_FOR_ST=nvl(?,'N'), LATE_IRREGULAR_DIET_ORD_FOR_SP=nvl(?,'N'), ENABLE_DRUG_FOOD_YN=nvl(?,'N'), INSTRUCTION_IN_LABEL=? where OPERATING_FACILITY_ID=? ";//ML-MMOH-CRF-0825 & MMS-KH-CRF-0029.1-US008(ENABLE_DRUG_FOOD_YN)

				pstmt = con.prepareStatement(strQuery);
				System.err.println("164,modify,strQuery==="+strQuery);
				System.err.println("166,start,count===="+count);
				//ML--MMOH-CRF-0600 - Changed as ++count instead of numeric values
				pstmt.setString(1,generateDefaultDiet);
				pstmt.setString(2,labelMessage);
				pstmt.setString(3,blInterface);
				pstmt.setString(4,multiKitchen);
				pstmt.setString(5,kitchenCode);
				pstmt.setString(6,maxMealPlanCreateDays);
				pstmt.setString(7,mealPlanNextSeq);
				pstmt.setString(8,acceptDietForMeal);
				pstmt.setString(9,attendantOrderApplicable);
				pstmt.setString(10,cutOffTimeForLiquidFood);
				pstmt.setString(11,gracePeriod);				
				pstmt.setString(12,gracePeriodApplicable);				
				pstmt.setString(13,multiFacilityOP);
				pstmt.setString(14,login_user);
				pstmt.setTimestamp(15,new  java.sql.Timestamp(System.currentTimeMillis()));
				pstmt.setString(16,facility_id);
				pstmt.setString(17,str_client_ip_address);
				pstmt.setString(18,login_user);
				pstmt.setTimestamp(19,new java.sql.Timestamp(System.currentTimeMillis()));
				pstmt.setString(20,facility_id);
				pstmt.setString(21,str_client_ip_address);				
				pstmt.setString(22,RestrictDateRangeforInpatientsYN);//ML-MMOH-CRF-0427
				pstmt.setString(23,MaximumDaysAllowed);//ML-MMOH-CRF-0427
				pstmt.setString(24,GenerateNilByMouth);//MMS-CRF-78.1
				//ML-MMOH-CRF-0427 Starts
				pstmt.setString(25,LATE_IRREGULAR_DIET_ORD_FOR_IP);	
				pstmt.setString(26,NotificationMessageforPlaceDietOrder);
				//ML-MMOH-CRF-0427 ends
				pstmt.setString(27,Attendent_Label_Name);//ML-MMOH-CRF-406
				pstmt.setString(28,attendantcount);//ML-MMOH-CRF-412
				//ML-MMOH-CRF-0600
				pstmt.setString(29,op_em_served);
				pstmt.setString(30,op_em_accept);
				//pstmt.setString(++count,op_em_reject);
				pstmt.setString(31,op_em_allow);
				pstmt.setString(32,ip_MealPrepared);
				pstmt.setString(33,ip_MealReceived);
				pstmt.setString(34,ip_MealServed);
				//pstmt.setString(++count,ip_MealReject);
				pstmt.setString(35,ip_allow);
				//ML-MMOH-CRF-0825
				pstmt.setString(36,LATE_IRREGULAR_DIET_ORD_FOR_OP);
				pstmt.setString(37,LATE_IRREGULAR_DIET_ORD_FOR_EM);
				pstmt.setString(38,LATE_IRREGULAR_DIET_ORD_FOR_ST);
				pstmt.setString(39,LATE_IRREGULAR_DIET_ORD_FOR_SP);
				//ML-MMOH-CRF-0825
				pstmt.setString(40,enableDrugFood);
				pstmt.setString(41,InstructionInLabelFormula);//Added by santhosh for ML-MMOH-CRF-1961
				pstmt.setString(42,facility_id);
				System.err.println("209,end,count===="+count);
				//ML-MMOH-CRF-0600
				int row=pstmt.executeUpdate();
				//int row=pstmt.execute();
				System.err.println("248,row===="+row);
				if(row>0)
				{				
					isUpdateSuccess = true;
				}
				else{
					System.err.println("250,else,row===="+row);
					isUpdateSuccess = false;
					
				}
			}

			else if(mode.equals("insert")) {
				//String strQuery="update DS_PARAM_FOR_FACILITY set GENERATE_DEFAULT_DIET_YN=?, LABEL_FOR_DEFAULT_DIET_YN=?, LABEL_MESSAGE=?, BL_INTERFACE_YN=?, INVENTORY_INTERFACE_YN=?, INVENTORY_STORE_CODE=?, MULTI_KITCHEN_YN=?, KITCHEN_CODE=?, CHARGE_STD_SERVICE_YN=?, DAILY_DIET_ORDERS_YN=?, MAX_MEAL_PLAN_CREAT_DAYS=?, TRACK_MENU_VALIDITY_YN=?, MEAL_PLAN_NEXT_SEQ=?, ACCEPT_DIET_FOR_IND_MEAL_YN=?, ENABLE_RDA_ALERT_YN=?, ATTENDANT_ORDER_APPLICABLE_YN=?, CUTOFF_TIME_FOR_ACK_LIQFOOD=?, ADDED_BY_ID=?, ADDED_DATE=?, ADDED_FACILITY_ID=?, ADDED_AT_WS_NO=?, MODIFIED_BY_ID=?, MODIFIED_DATE=?, MODIFIED_FACILITY_ID=?, MODIFIED_AT_WS_NO=? where OPERATING_FACILITY_ID=?";
				String strQuery="INSERT INTO DS_PARAM_FOR_FACILITY (GENERATE_DEFAULT_DIET_YN, LABEL_MESSAGE, BL_INTERFACE_YN, " +
				"MULTI_KITCHEN_YN, KITCHEN_CODE, MAX_MEAL_PLAN_CREAT_DAYS, MEAL_PLAN_NEXT_SEQ, " +
				"ACCEPT_DIET_FOR_IND_MEAL_YN, ATTENDANT_ORDER_APPLICABLE_YN, CUTOFF_TIME_FOR_ACK_LIQFOOD, " +
				"GRACE_PERIOD,GRACE_PERIOD_APPLICABLE_YN, MULTIFACILITY_YN, ADDED_BY_ID, ADDED_DATE, ADDED_FACILITY_ID, ADDED_AT_WS_NO, MODIFIED_BY_ID, MODIFIED_DATE," +
				" MODIFIED_FACILITY_ID, MODIFIED_AT_WS_NO, OPERATING_FACILITY_ID,RESTRICT_DATE_INPATIENTS_YN,MAXIMUM_DAYS_ALLOWED,GEN_MEALPLAN_FOR_NBM_PAT_YN,LATE_IRREGULAR_DIET_ORD_FOR_IP,IRREGULAR_MEAL_ORD_MESSAGE,Attendent_Label_Name,NO_OF_ATTENDANT,OP_EM_SERVED_YN,OP_EM_ACCEPT_YN,ALLOW_PLACE_ORD_OP_EM,IP_MEALPREPARED_YN,IP_MEALRECEIVED_YN,IP_MEALSERVED_YN,ALLOW_PLACE_ORD_IP,LATE_IRREGULAR_DIET_ORD_FOR_OP,LATE_IRREGULAR_DIET_ORD_FOR_EM,LATE_IRREGULAR_DIET_ORD_FOR_ST,LATE_IRREGULAR_DIET_ORD_FOR_SP,ENABLE_DRUG_FOOD_YN,INSTRUCTION_IN_LABEL) VALUES (nvl(?,'N'),?,nvl(?,'N'),nvl(?,'N'),?,?,?,nvl(?,'N'),nvl(?,'N'),?,?,nvl(?,'N'),nvl(?,'N'),?,?,?,?,?,?,?,?,?,?,?,?,nvl(?,'N'),?,?,nvl(?,0),nvl(?,'N'),nvl(?,'N'),nvl(?,'N'),nvl(?,'N'),nvl(?,'N'),nvl(?,'N'),nvl(?,'N'),nvl(?,'N'),nvl(?,'N'),nvl(?,'N'),nvl(?,'N'),nvl(?,'N'),?)";//ML-MMOH-CRF-0427 and MMS-CRF-78.1 AND ML-MMOH-CRF-406 AND ML-MMOH-CRF-412 & CRF-600 & MMS-CRF-029.1-US008

				pstmt = con.prepareStatement(strQuery);
			
				//ML--MMOH-CRF-0600 - Changed as ++count instead of numeric values
				pstmt.setString(++count,generateDefaultDiet);
				pstmt.setString(++count,labelMessage);
				pstmt.setString(++count,blInterface);
				pstmt.setString(++count,multiKitchen);
				pstmt.setString(++count,kitchenCode);
				pstmt.setString(++count,maxMealPlanCreateDays);
				pstmt.setString(++count,mealPlanNextSeq);
				pstmt.setString(++count,acceptDietForMeal);
				pstmt.setString(++count,attendantOrderApplicable);
				pstmt.setString(++count,cutOffTimeForLiquidFood);				
				pstmt.setString(++count,gracePeriod);				
				pstmt.setString(++count,gracePeriodApplicable);
				
				pstmt.setString(++count,multiFacilityOP);
				pstmt.setString(++count,login_user);
				pstmt.setTimestamp(++count,new  java.sql.Timestamp(System.currentTimeMillis()));
				pstmt.setString(++count,facility_id);
				pstmt.setString(++count,str_client_ip_address);
				pstmt.setString(++count,login_user);
				pstmt.setTimestamp(++count,new  java.sql.Timestamp(System.currentTimeMillis()));
				pstmt.setString(++count,facility_id);
				pstmt.setString(++count,str_client_ip_address);
				pstmt.setString(++count,facility_id);				
				pstmt.setString(++count,RestrictDateRangeforInpatientsYN);//ML-MMOH-CRF-0427
				pstmt.setString(++count,MaximumDaysAllowed);//ML-MMOH-CRF-0427
				pstmt.setString(++count,GenerateNilByMouth);//MMS-CRF-78.1
				//ML-MMOH-CRF-0409 Starts
				pstmt.setString(++count,LATE_IRREGULAR_DIET_ORD_FOR_IP);				
				pstmt.setString(++count,NotificationMessageforPlaceDietOrder);
				//ML-MMOH-CRF-0409 Ends
				pstmt.setString(++count,Attendent_Label_Name);//ML-MMOH-CRF-406
				pstmt.setString(++count,attendantcount);//ML-MMOH-CRF-412
                //ML-MMOH-CRF-0600
				pstmt.setString(++count,op_em_served);
				pstmt.setString(++count,op_em_accept);
				//pstmt.setString(++count,op_em_reject);
				pstmt.setString(++count,op_em_allow);
				pstmt.setString(++count,ip_MealPrepared);
				pstmt.setString(++count,ip_MealReceived);
				pstmt.setString(++count,ip_MealServed);
				//pstmt.setString(++count,ip_MealReject);
				pstmt.setString(++count,ip_allow);
				//ML--MMOH-CRF-0600 - Changed as ++count instead of numeric values
				pstmt.setString(++count,LATE_IRREGULAR_DIET_ORD_FOR_OP);
				pstmt.setString(++count,LATE_IRREGULAR_DIET_ORD_FOR_EM);
				pstmt.setString(++count,LATE_IRREGULAR_DIET_ORD_FOR_ST);
				pstmt.setString(++count,LATE_IRREGULAR_DIET_ORD_FOR_SP);
				pstmt.setString(++count,enableDrugFood);//MMS-KH-CRF-0029.1-US008
				pstmt.setString(++count,InstructionInLabelFormula);//Added by santhosh for ML-MMOH-CRF-1961
			
				int row=pstmt.executeUpdate();
				if (row >0)
				{
					isUpdateSuccess = true;
					//con.commit();				
				}
				else{
					isUpdateSuccess = false;
				}
			}
			//update DS_MEAL_CATEGORY table--ML-MOH-CRF-406			
			updateTableForPatientCareTaker(request,response,con);	//for testing purpose
			if(isUpdateSuccess){
			//con.commit();				
			error_value = "1" ;
			error = "APP-SM0070 Operation Completed Successfully ....";
			}else{
			//con.rollback();				
			error_value = "0" ;
			error = "Record has not been saved. Please try again";			
			}
			response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode(error,"UTF-8"  )+"&err_value="+error_value );			
			
			if(pstmt!=null){
			pstmt.close();
			}			
			/* if(con!=null){
			//ConnectionManager.returnConnection(con);
			con.close();
			System.err.println("344,if,conn====");
			}else{
			con.close();
			System.err.println("348,else,con====");
			} */
		}catch(SQLException sqle){
			System.err.println("347,SQLException in DSparameterAcrossFacilityServlet" + sqle.toString());
			sqle.printStackTrace();
			isUpdateSuccess = false;
		}catch(Exception e){
			System.err.println("351,Exception in DSparameterAcrossFacilityServlet" + e.toString());
			e.printStackTrace();
			isUpdateSuccess = false;
			//con.rollback();	
		}finally{
			try{
				if(isUpdateSuccess){
				con.commit();
				}else{  
				con.rollback();
				}
				if(pstmt!=null){ pstmt.close();
				}
				if(con!=null){ 
				//ConnectionManager.returnConnection(con);
				con.close();
				}
				else{
					con.close();
				}
				
			}catch(Exception e){
			e.printStackTrace();	
			System.err.println("Finally catch exception in DSparameterAcrossFacilityServlet" + e.toString());				
			}
		}
	}
	
	//ML-MOH-CRF-406
	private boolean updateTableForPatientCareTaker(HttpServletRequest request, HttpServletResponse response,Connection con){
		boolean flag=false;
		try{			
			String update_meal_category="update DS_MEAL_CATEGORY set DESCRIPTION=? where MEAL_CATEGORY_CODE='ATT'";//for updating DS_MEAL_CATEGORY
			this.Attendent_Label_Name=(String)request.getParameter("Attendent_Label_Name");//ML-MMOH-CRF-406			
			pstmt = con.prepareStatement(update_meal_category);
			pstmt.setString(1,Attendent_Label_Name);

			int attendant=0;
			
			attendant=pstmt.executeUpdate();
			String update_sm_function="update sm_function set FUNCTION_NAME=? where function_id = 'DSR_ATTND_MEAL_LIST'";
			String update_sm_menu_dtl="update sm_menu_dtl set OPTION_DESCRIPTOR=? where module_id = 'DS' and menu_id = 'DS_LIST_REPORTS'  and function_id = 'DSR_ATTND_MEAL_LIST'";
						
			if(pstmt!=null) pstmt.close();			
			//updating sm_menu_function
			pstmt = con.prepareStatement(update_sm_function);
			pstmt.setString(1,Attendent_Label_Name.concat(" Meal List"));			
			
			attendant=pstmt.executeUpdate();
			if(pstmt!=null) pstmt.close();						
			//updating sm_menu_details
			pstmt = con.prepareStatement(update_sm_menu_dtl);
			pstmt.setString(1,Attendent_Label_Name.concat(" Meal List"));
			
			attendant=pstmt.executeUpdate();
			//update sm_report
			StringBuffer update_sm_report=new StringBuffer();
			
			update_sm_report.append("	update sm_report	");
			update_sm_report.append("	set report_desc= case	");
			update_sm_report.append("	when report_id='DSRATMLT' then '"+Attendent_Label_Name.concat(" Meals List")+"'	");
			update_sm_report.append("	when report_id='DSRATSDT' then '"+Attendent_Label_Name.concat(" Meals Summary")+"'	");
			update_sm_report.append("	when report_id='DSRSTADMT' then '"+("Meal Tickets For ".concat(Attendent_Label_Name))+"'	");
			update_sm_report.append("	end	");
			update_sm_report.append("	where report_id in('DSRATMLT','DSRATSDT','DSRSTADMT')	");
			
			if(pstmt!=null) pstmt.close();			
			pstmt=con.prepareStatement(update_sm_report.toString());
			attendant=pstmt.executeUpdate();
			if (attendant > 0){
				//con.commit();
				flag = true;
			}	
		}catch(Exception e){
			e.printStackTrace();
		}finally{
		try{
			if(pstmt!=null) pstmt.close();	
			//con.close();		
			//if(con!=null)ConnectionManager.returnConnection(con,request); //Common-ICN-0052
		}catch(Exception e){
			e.printStackTrace();
			System.err.println("435,exception===="+e.toString());
			}
		}
		return flag;
	}
	//ML-MOH-CRF-406
}
