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
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Types;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Calendar;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Iterator;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import webbeans.eCommon.ConnectionManager;
import eCommon.Common.CommonBean;
import eCommon.XSSRequestWrapper;
import eDS.Common.JSONObject;

/**
 * Servlet implementation class PlaceDietOrderServlet
 *
 */
public class PlaceDietOrderServlet extends javax.servlet.http.HttpServlet
{
//	private static final long serialVersionUID = 1L;
	java.util.Properties prop;
	HttpSession session;
	String facility_id,str_client_ip_address,login_user;
	private ArrayList editMenu_1 = new ArrayList();
	private ArrayList applyMenu_1 = new ArrayList();
	private ArrayList cancelMenu_1 = new ArrayList();
//Added against AMS-CRF-0112 Starts Here
		String additionalinstructions="";		
		UpdateMealMenuObject updateMealMenuObjectInstr = new UpdateMealMenuObject();//Added Against AMS-CRF-0112
//Added against AMS-CRF-0112 Ends Here
	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	}
	//ML-MMOH-SCF-0735
	private String checkForNull(String parameter) {
		// TODO Auto-generated method stub
		String ret = "";
		if(parameter == null){
			ret = "";
		}
		else{
			ret = parameter;
		}
		return ret;
	}
	//ML-MMOH-SCF-0735

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{   
		//Added Against MMS Vulnerability Issue - Starts
        request= new XSSRequestWrapper(request);
        response.addHeader("X-XSS-Protection", "1; mode=block");
        response.addHeader("X-Content-Type-Options", "nosniff");
        //Added Against MMS Vulnerability Issue - Ends 
		ArrayList<String> callAgeGroup = new ArrayList<String>();
		ArrayList<String> dietTypeList = new ArrayList<String>();
		ArrayList<String> mealTypeList = new ArrayList<String>();
		ArrayList<String> mealContent = new ArrayList<String>();
		ArrayList<String> drugInteraction = new ArrayList<String>();	//Added for the MMS-KH-CRF-0029.1
		ArrayList<String> editItems = new ArrayList<String>();	//Added for the MMS-KH-CRF-0029.1
		ArrayList<String> applyItems = new ArrayList<String>();	//Added for the MMS-KH-CRF-0029.1
		ArrayList<String> cancelItems = new ArrayList<String>();	//Added for the MMS-KH-CRF-0029.1
		ArrayList<String> mealContents = new ArrayList<String>();
		ArrayList<String> kalContent = new ArrayList<String>();
		ArrayList<String> NBMAtt = new ArrayList<String>();	//Added by ML-MMOH-CRF-1460
		ArrayList<String> SplFoodItems = new ArrayList<String>();
		ArrayList<String> srlNO = new ArrayList<String>();
		ArrayList<String> delItems = new ArrayList<String>();
		ArrayList<String> updItems = new ArrayList<String>();
		ArrayList<String> mtDisChange = new ArrayList<String>();
		ArrayList<String> delSrlNO = new ArrayList<String>();
		ArrayList<JSONObject> mealTypeListWithTime = new ArrayList<JSONObject>();
		
		JSONObject NBM_Overlap_profile = new  JSONObject();//CRF-410
		
		String irregularMealCode=new String();//409
		String DietTypeModified=new String();//006
		List nutriAndSplFood = new ArrayList();
		List updDietType = new ArrayList();
		List orderDetails = new ArrayList();
		session = request.getSession(false);
		this.prop = (java.util.Properties) session.getValue("jdbc");
		str_client_ip_address = prop.getProperty("client_ip_address");
		login_user = prop.getProperty( "login_user" ) ;
		if(str_client_ip_address == null) str_client_ip_address="";
		if(login_user == null) login_user="";
		this.facility_id = (String) session.getAttribute("facility_id");

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		String operation = request.getParameter("mode");
		if(operation.equals("fetchAgeGroupCode")){
			callAgeGroup = fetchAgeGroupCode(request,response);
			out.println(callAgeGroup);
		}
		else if(operation.equals("fecthDietTypes")){
				dietTypeList = fecthDietTypes(request);
				out.println(dietTypeList);
		}
		else if(operation.equals("fecthDietTypes_Attendant")){
			dietTypeList = fecthDietTypes_Attendant(request);
			out.println(dietTypeList);
	}
		else if(operation.equals("mealTypeList"))
		{
				mealTypeList = fecthMealTypes(request);
				out.println(mealTypeList);
		}
		else if(operation.equals("DayRefNo")){
			int dayRefNo = 0;
			dayRefNo = getDayRefNo(request);
			out.println(dayRefNo);
		}
		else if(operation.equals("MealContent")){
			mealContent = getMealContents(request);
			out.println(mealContent);
		}
		//Added against MMS-KH-CRF-0029.1 Starts Here
		else if(operation.equals("drug")){		
			drugInteraction = drugFood(request,response);
			out.println(drugInteraction);
		}
		
		 else if(operation.equals("updateEditMenu")){		
			editItems = getEditMenu();
			out.println(editItems);
		}
		
		else if(operation.equals("applyMenu")){		
			applyItems = getApplyMenu();
			System.err.println("applyItems value===>"+applyItems);
			out.println(applyItems);
		}
		
		else if(operation.equals("cancelMenu")){		
			cancelItems = getCancelMenu();
			System.err.println("cancelItems value===>"+cancelItems);
			out.println(cancelItems);
		}
		//Added against MMS-KH-CRF-0029.1 Ends Here
		
		else if(operation.equals("insertMealContents"))
		{
			try
			{
				mealContents = insertMealContents(request,response);
				if(mealContents != null && !mealContents.isEmpty())
				{
					out.println(mealContents);
				}

			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
			catch (ParseException e)
			{
				e.printStackTrace();
			}
		}
		else if(operation.equals("insertNBMAttList")){	//Added Against ML-MMOH-CRF-1460
			try {
				NBMAtt = insertNBMAttList(request,response);
				out.println(NBMAtt);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			catch (ParseException e)
			{
				e.printStackTrace();
			}
		}
		else if(operation.equals("KaloriForMeals")){
			try {
				kalContent = getKaloriForMeals(request);
				out.println(kalContent);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}else if(operation.equals("insertSplFoodItems")){
			try {
				SplFoodItems = insertSplFoodItems(request);
				out.println(SplFoodItems);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		else if(operation.equals("srlNO")){
			try {
				srlNO = getSlNo(request);
				out.println(srlNO);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		else if(operation.equals("delSplFoodItems")){
			try {
				delItems = deleteSplFoodItems(request);
				out.println(delItems);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		else if(operation.equals("updSplFoodItems")){
			try {
				updItems = updateSplFoodItems(request);
				out.println(updItems);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}else if(operation.equals("nutrientsAndSplFoodItems")){
			try {
				nutriAndSplFood = getNutrientsAndSplFoodItems(request,response);
				//out.println(nutriAndSplFood);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}else if(operation.equals("updatedDietTypes")){
			updDietType = getDietTypesForMeals(request);
			if(updDietType != null && !updDietType.isEmpty()){
				out.println(updDietType);
			}
		}
		else if(operation.equals("dietOrders"))
		{
			String encounterId = request.getParameter("encounterId");
			String facility = request.getParameter("facility");
			try
			{
				orderDetails = fecthMealContents(facility,encounterId,request);
				out.println(orderDetails);
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
		else if(operation.equals("updateMealMenuItems"))
		{
			try
			{
				updateMealMenuItems(request,response);
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
		else if(operation.equals("updateMealMenuItemsObject")) // AAKH-CRF-0065 start
		{
			try
			{
				updateMealMenuItemsObject(request,response);
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		} // AAKH-CRF-0065 end
		else if(operation.equals("mealTypeForDischange"))
		{
			String encounterId = request.getParameter("encounterId");
			String facility = request.getParameter("facility");
			String flag = request.getParameter("hdrFlag");
			try{
				mtDisChange = mealTypeForDischange(facility,encounterId,flag,request);
				out.println(mtDisChange);
			} catch(SQLException e){
				e.printStackTrace();
			}
		}
		else if(operation.equals("srlNOForDel")){
			try{
				delSrlNO = getsrlNOForDelSplFood(request);
				out.println(delSrlNO);
			} catch(SQLException e){
				e.printStackTrace();
			}
		}else if(operation.equals("getDieticianFlag")){
			try{
				String dietCian_YN = getDieticianFlag(request);
				if(dietCian_YN != null && !dietCian_YN.equals("")){
					out.println(dietCian_YN);
				}

			} catch(SQLException e){
				e.printStackTrace();
			}
		}
		else if(operation.equalsIgnoreCase("cancelMealContents"))
		{
			String cancelMealOrderChk = "";
			try
			{
				cancelMealOrderChk = cancelMealOrder(request);				
				if(cancelMealOrderChk != null && cancelMealOrderChk.trim().length() > 0)
					out.println(cancelMealOrderChk);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		else if(operation.equalsIgnoreCase("verifyOrdersForCancellation"))
		{
			String ordersForCancellation = "";
			try
			{
				ordersForCancellation = chkOrdersForCancellation(request);				
				if(ordersForCancellation != null && ordersForCancellation.trim().length() > 0)
					out.println(ordersForCancellation);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		else if(operation.equals("mealTypeListWithTime"))
		{
			mealTypeListWithTime = fetchMealTypesWithTime(request);
			out.println(mealTypeListWithTime);
		}else if(operation.equals("irregularMealCode")){
			irregularMealCode=loadIrregularMealCode(request);
			out.println(irregularMealCode);
			
		}else if(operation.equals("checkDietTypeModified")){
			DietTypeModified=loadDietTypeModified(request);
			out.println(DietTypeModified);
		}
		
		//Added by vikash against 60459
		else if(operation.equals("delSplFoodItemsNew")){
		try{
				delItems = deleteSplFoodItemsNew(request);
				out.println(delItems);
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		//Added By Vikash against CRF-410 starts 
		else if(operation.equals("getNBMProfileOverLap")){			
			NBM_Overlap_profile=getNBMProfileOverLap(request,response);
			response.setContentType("application/json");
			response.setContentType("text/html;charset=UTF-8");
			out.print(NBM_Overlap_profile);
			out.flush();
		}else if(operation.equals("cancelNBMProfile")){
			String cancelNBMProfileresult=cancelNBMProfile(request,response);
			out.print(cancelNBMProfileresult);
			out.flush();
		}
		else if(operation.equals("updateNBMProfile")){
			String result=updateNBMProfile(request,response);
			out.print(result);
			out.flush();
		}else if(operation.equals("insertFullNBMProfile")){
			String result=insertFullNBMprofile(request);
			out.print(result);
			out.flush();
		}else if(operation.equals("getDietProfileOverLap")){
			String result=getDietProfileOverLap(request,response);
			out.print(result);
			out.flush();
		}else if(operation.equals("insertAndUpdateNBMProfile")){
			String result=insertAndUpdateNBMProfile(request);
			out.print(result);
			out.flush();
		}
		//Added By Vikash against CRF-410 ends
		//Added Against ML-MMOH-CRF-0600 starts here
		else if(operation.equals("pendingMealOrderAckDetail_IP")){
			JSONObject objMealAck = pendingMealOrder_AckDetail_IP(request,response);			
			response.setContentType("application/json");
			response.setContentType("text/html;charset=UTF-8");
			out.print(objMealAck);
			out.flush();
		}
		//Added Against ML-MMOH-CRF-0600 Ends Here
	}
	private String getDietProfileOverLap(HttpServletRequest request,HttpServletResponse response) {
		//TODO Auto-generated method stub
		Connection con=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		String result="N";
		try{
			con=ConnectionManager.getConnection(request);
			StringBuffer diet_profile_overlap=new StringBuffer();
			diet_profile_overlap.append("    SELECT profile_sl,	");
			diet_profile_overlap.append("	 TO_CHAR (nil_by_mouth_frm, 'dd/mm/yyyy HH24:MI') nil_by_mouth_frm,	");
			diet_profile_overlap.append("	 TO_CHAR (nil_by_mouth_to, 'dd/mm/yyyy HH24:MI') nil_by_mouth_to	");
			diet_profile_overlap.append("	FROM ds_epsd_diet_profile_hdr	");
			diet_profile_overlap.append("	WHERE 	");
			diet_profile_overlap.append("	encounter_id=?	");
			diet_profile_overlap.append("	and OPERATING_FACILITY_ID=?	and status is null	");
			diet_profile_overlap.append("	and	");
			diet_profile_overlap.append("	(	");
			diet_profile_overlap.append("	(	");
			diet_profile_overlap.append("	trunc(PERIOD_FROM) >= trunc(to_date(?,'dd/mm/yyyy HH24:MI'))	");
			diet_profile_overlap.append("	AND trunc(PERIOD_TO) <= trunc(to_date(?,'dd/mm/yyyy HH24:MI'))	");
			diet_profile_overlap.append("	)	");
			diet_profile_overlap.append("	OR (	");
			diet_profile_overlap.append("	trunc(PERIOD_TO) >= trunc(to_date(?,'dd/mm/yyyy HH24:MI'))	");
			diet_profile_overlap.append("	AND trunc(PERIOD_FROM) <= trunc(to_date(?,'dd/mm/yyyy HH24:MI'))	");
			diet_profile_overlap.append("	)	");
			diet_profile_overlap.append("	)	");
			
			String fromDate=request.getParameter("from");
			String dateTo=request.getParameter("to");
			String addedFacilityId=request.getParameter("addedFacilityId");
			String encounterId=request.getParameter("encounterId");
			
			int index=0;
			psmt=con.prepareStatement(diet_profile_overlap.toString());
			psmt.setString(++index,encounterId);
			psmt.setString(++index,addedFacilityId);
			psmt.setString(++index,fromDate);
			psmt.setString(++index,dateTo);
			psmt.setString(++index,fromDate);
			psmt.setString(++index,dateTo);
			
			rs=psmt.executeQuery();
			while(rs.next()){
				result="Y";	
			}			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
			if(con!=null)ConnectionManager.returnConnection(con,request);
			if(psmt !=null) psmt.close(); //Common-ICN-0053
			}catch(Exception e){
					
				}
		}
		return result;
	}

	private String cancelNBMProfile(HttpServletRequest request,HttpServletResponse response) {	
		String result="N";
		Connection conn = null;
		PreparedStatement psmt=null;
		try{
			conn = ConnectionManager.getConnection(request);
			String profileSL=request.getParameter("profileSL");
			String cancelNBMProfile_query="update ds_epsd_nbm_profile set status='X' where profile_sl in ("+profileSL+") and encounter_id=?  and operating_facility_id=? ";
			psmt=conn.prepareStatement(cancelNBMProfile_query);
			int index=0;
			
			String encounterId=request.getParameter("encounterId");
			String facilityId=request.getParameter("addedFacilityId");
			
			psmt.setString(++index, encounterId);		
			psmt.setString(++index, facilityId);
			int recsUpdated = psmt.executeUpdate();
			if(recsUpdated != 0)
			{				
				result = "Y";
				conn.commit();
			}			
			else{
			conn.rollback();
			}			
		}catch(Exception e){
			e.printStackTrace();			
		}finally{
			try{
				if(conn!=null)ConnectionManager.returnConnection(conn,request);
				if(psmt !=null) psmt.close(); //Common-ICN-0053
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return result;
	}

	//CRF-410 Starts
	private JSONObject getNBMProfileOverLap(HttpServletRequest request,HttpServletResponse response) {	
		Connection conn = null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		
		JSONObject keyValueList = new  JSONObject();
		
		try{
			conn = ConnectionManager.getConnection(request);
			String fromDate=request.getParameter("fromDate");
			String dateTo=request.getParameter("dateTo");
			String addedFacilityId=request.getParameter("addedFacilityId");
			String encounterId=request.getParameter("encounterId");
			
			StringBuffer nbm_profile_overlap_query=new StringBuffer();
			
			nbm_profile_overlap_query.append("    SELECT profile_sl,	");
			nbm_profile_overlap_query.append("	       TO_CHAR (nil_by_mouth_frm, 'dd/mm/yyyy HH24:MI') nil_by_mouth_frm,	");
			nbm_profile_overlap_query.append("	       TO_CHAR (nil_by_mouth_to, 'dd/mm/yyyy HH24:MI') nil_by_mouth_to	");
			nbm_profile_overlap_query.append("	FROM ds_epsd_nbm_profile	");
			nbm_profile_overlap_query.append("	WHERE 	");
			nbm_profile_overlap_query.append("	encounter_id=?	");
			nbm_profile_overlap_query.append("	and OPERATING_FACILITY_ID=?  and status IS NULL	");
			nbm_profile_overlap_query.append("	and	");
			nbm_profile_overlap_query.append("	(	");
			nbm_profile_overlap_query.append("	(	");
			nbm_profile_overlap_query.append("	trunc(NIL_BY_MOUTH_FRM) >= trunc(to_date(?,'dd/mm/yyyy HH24:MI'))	");
			nbm_profile_overlap_query.append("	AND trunc(NIL_BY_MOUTH_TO) <= trunc(to_date(?,'dd/mm/yyyy HH24:MI'))	");
			nbm_profile_overlap_query.append("	)	");
			nbm_profile_overlap_query.append("	OR (	");
			nbm_profile_overlap_query.append("	trunc(NIL_BY_MOUTH_TO) >= trunc(to_date(?,'dd/mm/yyyy HH24:MI'))	");
			nbm_profile_overlap_query.append("	AND trunc(NIL_BY_MOUTH_FRM) <= trunc(to_date(?,'dd/mm/yyyy HH24:MI'))	");
			nbm_profile_overlap_query.append("	)	");
			nbm_profile_overlap_query.append("	)	");
			
			psmt=conn.prepareStatement(nbm_profile_overlap_query.toString());
			int index=0;
			
			psmt.setString(++index,encounterId);
			psmt.setString(++index,addedFacilityId);
			psmt.setString(++index,fromDate);
			psmt.setString(++index,dateTo);
			psmt.setString(++index,fromDate);
			psmt.setString(++index,dateTo);
			
			rs=psmt.executeQuery();
			while(rs.next()){
				JSONObject NBMProfileList= new JSONObject();
				NBMProfileList.put("profile_sl", rs.getString("profile_sl"));
				NBMProfileList.put("nil_by_mouth_frm", rs.getString("nil_by_mouth_frm"));
				NBMProfileList.put("nil_by_mouth_to", rs.getString("nil_by_mouth_to"));
				keyValueList.append("NBMOverLapProfileList",NBMProfileList);
			}
		}catch(Exception e){
				e.printStackTrace();		
		}finally{
			try{
				if(conn!=null)ConnectionManager.returnConnection(conn,request);
				if(psmt !=null) psmt.close(); //Common-ICN-0053
			}catch(Exception e){
					e.printStackTrace();							
			}
		}
		return keyValueList;		
	}
	//CRF-410 Ends
	private List getDietTypesForMeals(HttpServletRequest request) {
		List upDiet = new ArrayList();
		String profilesl = request.getParameter("profileSL");
		String encounterId = request.getParameter("encounterId");
		String facility = request.getParameter("facility");

		Connection conn = ConnectionManager.getConnection(request);
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String MEAL_TYPE = null;
		String DIET_TYPE = null;
		try{
			String upDiet_query = "SELECT PRFDTL.MEAL_TYPE, PRFDTL.DIET_TYPE FROM DS_EPSD_DIET_PROFILE_DTL PRFDTL,DS_MEAL_TYPE MTYPE WHERE PRFDTL.OPERATING_FACILITY_ID ='"+facility+"' AND PRFDTL.ENCOUNTER_ID = '"+encounterId+"' AND PRFDTL.PROFILE_SL='"+profilesl+"' AND PRFDTL.MEAL_TYPE = MTYPE.MEAL_TYPE ORDER BY MTYPE.MEAL_ORDER";
			pstmt = conn.prepareStatement(upDiet_query);
			rs = pstmt.executeQuery();

			while(rs != null && rs.next()){
				MEAL_TYPE = rs.getString(1);
				DIET_TYPE = rs.getString(2);
				upDiet.add(MEAL_TYPE);
				upDiet.add(DIET_TYPE);
			}
		if(pstmt!=null) pstmt.close();
	    if(conn!=null)ConnectionManager.returnConnection(conn,request);
		}catch(Exception ee){
			ee.printStackTrace();
			System.err.println("PlaceDietOrderServlet.java--->"+ee.getMessage());
		}
		return upDiet;
	}

	private List getNutrientsAndSplFoodItems(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException
	{
		List<String> list = new ArrayList<String>();
		List<String> list2 = new ArrayList<String>();
		List<String> list3 = new ArrayList<String>();
		List<String> list4 = new ArrayList<String>();
		List<String> list5 = new ArrayList<String>();
		List<String> list6 = new ArrayList<String>();

		PrintWriter out=response.getWriter();
		Connection conn = ConnectionManager.getConnection(request);

		PreparedStatement pstmt=null;
		PreparedStatement pstmt2=null;
		PreparedStatement pstmt3=null;
		PreparedStatement pstmt4=null;
		PreparedStatement pstmt5=null;
		PreparedStatement pstmt6=null;

		ResultSet rs=null;
		ResultSet rs2=null;
		ResultSet rs3=null;
		ResultSet rs4=null;
		ResultSet rs5=null;
		ResultSet rs6=null;

		String locale =  request.getParameter("locale");
		String date = com.ehis.util.DateUtils.convertDate(request.getParameter("dateForMeanu"),"DMY", locale, "en");
		String profileSL = request.getParameter("profileSL");
		String encounterID = request.getParameter("encounterId");
		String patientID = request.getParameter("patientID");
		String facility = request.getParameter("facility");

		String nutriSpl = "";
		String splfList = "";
		String attdfList = "";
		String dietTList = "";
		String disLikesList = "";
		String exclusionsList = "";

		StringBuffer nutri = new StringBuffer();
		StringBuffer splList = new StringBuffer();
		StringBuffer attList = new StringBuffer();
		StringBuffer dietList = new StringBuffer();
		StringBuffer disLikes = new StringBuffer();
		StringBuffer exclusions = new StringBuffer();
		try
		{
			session = request.getSession(false);
			session.removeAttribute("ALLMENUITEMSMAP");
	//	String nutriAndSplFood_query = "SELECT TO_CHAR (suppl.serving_start_time, 'DD/MM/YYYY'),TO_CHAR (suppl.serving_end_time, 'DD/MM/YYYY'), suppl.meal_type,suppl.meal_type, suppl.item_sl, dsitemtype.item_type,dsitemtype.short_desc as item_type_short_desc, suppl.item_code, items.short_desc as item_short_desc,suppl.item_qty, suppl.patient_class, items.serving_uom_code,TO_CHAR (items.calorific_cont_per_uom, '999999.99'), param.energy_uom FROM ds_epsd_diet_profile_suppl suppl,ds_items items,ds_param param,ds_item_type_lang_vw dsitemtype WHERE suppl.item_code = items.food_item_code AND suppl.item_type = dsitemtype.item_type AND dsitemtype.language_id = items.language_id AND suppl.operating_facility_id = '"+facility+"' AND suppl.encounter_id = '"+encounterID+"' AND suppl.profile_sl = '"+profileSL+"' AND items.language_id = '"+locale+"' AND TO_CHAR (NVL (suppl.serving_end_time, SYSDATE), 'DD/MM/YYYY') >='"+date+"'"; //Commented Against PMG2017-COMN-CRF-0012.1-US001
	
	/* 	String nutriAndSplFood_query = "SELECT TO_CHAR (suppl.serving_start_time, 'DD/MM/YYYY'),TO_CHAR (suppl.serving_end_time, 'DD/MM/YYYY'),dsitemtype.item_type, suppl.meal_type, suppl.item_sl, suppl.meal_type, dsitemtype.short_desc as item_type_short_desc, suppl.item_code, items.short_desc as item_short_desc,suppl.item_qty, suppl.patient_class, items.serving_uom_code,TO_CHAR (items.calorific_cont_per_uom, '999999.99'), param.energy_uom,am_get_desc.am_uom (param.energy_uom, '"+locale+"', '2')ENERGY_UOM_DESC FROM ds_epsd_diet_profile_suppl suppl,ds_items items,ds_param param,ds_item_type_lang_vw dsitemtype WHERE suppl.item_code = items.food_item_code AND suppl.item_type = dsitemtype.item_type AND dsitemtype.language_id = items.language_id AND suppl.operating_facility_id = '"+facility+"' AND suppl.encounter_id = '"+encounterID+"' AND suppl.profile_sl = '"+profileSL+"' AND items.language_id = '"+locale+"' AND TO_CHAR (NVL (suppl.serving_end_time, SYSDATE), 'DD/MM/YYYY') >='"+date+"'";*/
	//Added Against PMG2017-COMN-CRF-0012.1-US001 & Commented Against Nutrient Supplement & Special food item [IN:067653]
	
	String nutriAndSplFood_query = "SELECT TO_CHAR (suppl.serving_start_time, 'DD/MM/YYYY'),TO_CHAR (suppl.serving_end_time, 'DD/MM/YYYY'),dsitemtype.item_type, suppl.item_code,suppl.item_qty, suppl.meal_type, suppl.meal_type,items.short_desc as item_short_desc, dsitemtype.short_desc as item_type_short_desc,items.serving_uom_code,suppl.patient_class,suppl.item_sl,TO_CHAR (items.calorific_cont_per_uom, '999999.99'), param.energy_uom,am_get_desc.am_uom (param.energy_uom, '"+locale+"', '2')ENERGY_UOM_DESC,am_get_desc.am_uom (items.serving_uom_code, '"+locale+"', '2') serving_uom_desc FROM ds_epsd_diet_profile_suppl suppl,ds_items items,ds_param param,ds_item_type_lang_vw dsitemtype WHERE suppl.item_code = items.food_item_code AND suppl.item_type = dsitemtype.item_type AND dsitemtype.language_id = items.language_id AND suppl.operating_facility_id = '"+facility+"' AND suppl.encounter_id = '"+encounterID+"' AND suppl.profile_sl = '"+profileSL+"' AND items.language_id = '"+locale+"' AND TO_CHAR (NVL (suppl.serving_end_time, SYSDATE), 'DD/MM/YYYY') >='"+date+"'";//Added Against Nutrient Supplement & Special food item [IN:067653]
	
		//System.err.println("619 nutriAndSplFood_query===>"+nutriAndSplFood_query);
		//String splfooditem = "SELECT TO_CHAR(SPL.SERVING_TIME, 'DD/MM/YYYY HH24:MI') AS SERVING_TIME, SPL.SERVING_FREQ, TO_CHAR(SPL.PERIOD_BET_SERVINGS, 'HH:MI') AS PERIOD_BET_SERVINGS, SPL.ITEM_SL AS ITEM_SL, SPL.ITEM_TYPE AS ITEM_TYPE, DSITEMTYPE3_.SHORT_DESC AS SHORT_DESC, SPL.ITEM_CODE AS ITEM_CODE, DSITEMS2_.SHORT_DESC AS SHORT_DESC, SPL.ITEM_QTY AS ITEM_QTY, SPL.PATIENT_CLASS AS PATIENT_CLASS, DSITEMS2_.SERVING_UOM_CODE AS SERVING_UOM_CODE, TO_CHAR(DSITEMS2_.CALORIFIC_CONT_PER_UOM, '999999.99') AS CALORIFIC_CONT_PER_UOM, LOWER(DSPARAM4_.ENERGY_UOM) AS ENERGY_UOM, TO_CHAR(SPL.PERIOD_BET_SERVINGS, 'HH:MI') AS PERIOD_BET_SERVINGS, DSMEALTYPE1_.SHORT_DESC AS SHORT_DESC, DSMEALTYPE1_.MEAL_TYPE AS MEAL_TYPE, SPL.FREQ_YN AS FREQ_YN FROM DS_EPSD_DIET_PROFILE_SPL SPL LEFT OUTER JOIN DS_MEAL_TYPE DSMEALTYPE1_ ON SPL.MEAL_TYPE=DSMEALTYPE1_.MEAL_TYPE, DS_ITEMS DSITEMS2_, DS_ITEM_TYPE_LANG_VW DSITEMTYPE3_, DS_PARAM DSPARAM4_ WHERE (SPL.ITEM_CODE=DSITEMS2_.FOOD_ITEM_CODE )AND(SPL.ITEM_TYPE=DSITEMTYPE3_.ITEM_TYPE )AND(DSITEMTYPE3_.LANGUAGE_ID=DSITEMS2_.LANGUAGE_ID )AND(SPL.OPERATING_FACILITY_ID='"+facility+"')AND(SPL.ENCOUNTER_ID='"+encounterID+"')AND(NVL(SPL.PROFILE_SL , 0)=NVL('"+profileSL+"' , 0))AND(DSITEMS2_.LANGUAGE_ID='"+locale+"')";
		//String splfooditem = "SELECT TO_CHAR(SPL.SERVING_TIME, 'DD/MM/YYYY') AS SERVING_TIME, SPL.SERVING_FREQ, TO_CHAR(SPL.PERIOD_BET_SERVINGS, 'HH:MI') AS PERIOD_BET_SERVINGS, SPL.ITEM_SL AS ITEM_SL, SPL.ITEM_TYPE AS ITEM_TYPE, DSITEMTYPE3_.SHORT_DESC AS item_type_short_desc, SPL.ITEM_CODE AS ITEM_CODE, DSITEMS2_.SHORT_DESC AS item_short_desc, SPL.ITEM_QTY AS ITEM_QTY, SPL.PATIENT_CLASS AS PATIENT_CLASS, DSITEMS2_.SERVING_UOM_CODE AS SERVING_UOM_CODE, TO_CHAR(DSITEMS2_.CALORIFIC_CONT_PER_UOM, '999999.99') AS CALORIFIC_CONT_PER_UOM, LOWER(DSPARAM4_.ENERGY_UOM) AS ENERGY_UOM, TO_CHAR(SPL.PERIOD_BET_SERVINGS, 'HH:MI') AS PERIOD_BET_SERVINGS, DSMEALTYPE1_.SHORT_DESC AS meal_type_short_desc, DSMEALTYPE1_.MEAL_TYPE AS MEAL_TYPE, SPL.FREQ_YN AS FREQ_YN FROM DS_EPSD_DIET_PROFILE_SPL SPL LEFT OUTER JOIN DS_MEAL_TYPE DSMEALTYPE1_ ON SPL.MEAL_TYPE=DSMEALTYPE1_.MEAL_TYPE, DS_ITEMS DSITEMS2_, DS_ITEM_TYPE_LANG_VW DSITEMTYPE3_, DS_PARAM DSPARAM4_ WHERE (SPL.ITEM_CODE=DSITEMS2_.FOOD_ITEM_CODE )AND(SPL.ITEM_TYPE=DSITEMTYPE3_.ITEM_TYPE )AND(DSITEMTYPE3_.LANGUAGE_ID=DSITEMS2_.LANGUAGE_ID )AND(SPL.OPERATING_FACILITY_ID='"+facility+"')AND(SPL.ENCOUNTER_ID='"+encounterID+"')AND(NVL(SPL.PROFILE_SL , 0)=NVL('"+profileSL+"' , 0))AND(DSITEMS2_.LANGUAGE_ID='"+locale+"') order by SPL.ITEM_SL"; //Commented Against PMG2017-COMN-CRF-0012.1-US001
		String splfooditem = "SELECT TO_CHAR(SPL.SERVING_TIME, 'DD/MM/YYYY') AS SERVING_TIME, SPL.SERVING_FREQ, TO_CHAR(SPL.PERIOD_BET_SERVINGS, 'HH:MI') AS PERIOD_BET_SERVINGS, SPL.ITEM_SL AS ITEM_SL, SPL.ITEM_TYPE AS ITEM_TYPE, DSITEMTYPE3_.SHORT_DESC AS item_type_short_desc, SPL.ITEM_CODE AS ITEM_CODE, DSITEMS2_.SHORT_DESC AS item_short_desc, SPL.ITEM_QTY AS ITEM_QTY, SPL.PATIENT_CLASS AS PATIENT_CLASS, DSITEMS2_.SERVING_UOM_CODE AS SERVING_UOM_CODE, TO_CHAR(DSITEMS2_.CALORIFIC_CONT_PER_UOM, '999999.99') AS CALORIFIC_CONT_PER_UOM, LOWER(DSPARAM4_.ENERGY_UOM) AS ENERGY_UOM, TO_CHAR(SPL.PERIOD_BET_SERVINGS, 'HH:MI') AS PERIOD_BET_SERVINGS, DSMEALTYPE1_.SHORT_DESC AS meal_type_short_desc, DSMEALTYPE1_.MEAL_TYPE AS MEAL_TYPE, SPL.FREQ_YN AS FREQ_YN, AM_GET_DESC.AM_UOM (DSPARAM4_.ENERGY_UOM, '"+locale+"', 2) AS ENERGY_UOM_DESC,   am_get_desc.am_uom (dsitems2_.serving_uom_code, '"+locale+"', 2) AS SERVING_UOM_DESC FROM DS_EPSD_DIET_PROFILE_SPL SPL LEFT OUTER JOIN DS_MEAL_TYPE DSMEALTYPE1_ ON SPL.MEAL_TYPE=DSMEALTYPE1_.MEAL_TYPE, DS_ITEMS DSITEMS2_, DS_ITEM_TYPE_LANG_VW DSITEMTYPE3_, DS_PARAM DSPARAM4_ WHERE (SPL.ITEM_CODE=DSITEMS2_.FOOD_ITEM_CODE )AND(SPL.ITEM_TYPE=DSITEMTYPE3_.ITEM_TYPE )AND(DSITEMTYPE3_.LANGUAGE_ID=DSITEMS2_.LANGUAGE_ID )AND(SPL.OPERATING_FACILITY_ID='"+facility+"')AND(SPL.ENCOUNTER_ID='"+encounterID+"')AND(NVL(SPL.PROFILE_SL , 0)=NVL('"+profileSL+"' , 0))AND(DSITEMS2_.LANGUAGE_ID='"+locale+"') order by SPL.ITEM_SL"; //Modified Against Nutrient Supplement & Special food item [IN:067653] 
		//String attendentList = "SELECT ATT.ATTENDENT_SRL AS ATTENDENT_SRL, ATT.DIET_TYPE AS DIET_TYPE, DSDIETTYPE2_.SHORT_DESC AS DIET_TYPE_SHORT_DESC, ATT.MEAL_CLASS AS MEAL_CLASS, DSMEALCLAS1_.SHORT_DESC AS MEAL_CLASS_SHORT_DESC, TO_CHAR(ATT.PERIOD_FROM, 'DD/MM/YYYY') AS PERIOD_FROM, TO_CHAR(ATT.PERIOD_TO, 'DD/MM/YYYY') AS PERIOD_TO, ATT.ORDER_ID AS ORDER_ID, ATT.ORDER_LINE_NO AS ORDER_LINE_NO, ATT.PATIENT_CLASS AS PATIENT_CLASS,ATT.ATNDNT_INSTR AS ATNDNT_INSTR FROM DS_EPSD_DIET_PROFILE_ATT ATT, DS_MEAL_CLASS DSMEALCLAS1_, DS_DIET_TYPE DSDIETTYPE2_ WHERE ATT.DIET_TYPE=DSDIETTYPE2_.DIET_TYPE AND ((ATT.MEAL_CLASS=DSMEALCLAS1_.MEAL_CLASS )AND(ATT.OPERATING_FACILITY_ID='"+facility+"')AND(ATT.ENCOUNTER_ID='"+encounterID+"')AND(ATT.PROFILE_SL='"+profileSL+"')  AND TRUNC (SYSDATE) BETWEEN TRUNC (att.period_from) AND TRUNC (att.period_to))";//Added att.period_to condition against ML-MMOH-CRF-1460 
		String attendentList = "SELECT ATT.ATTENDENT_SRL AS ATTENDENT_SRL, ATT.DIET_TYPE AS DIET_TYPE, DSDIETTYPE2_.SHORT_DESC AS DIET_TYPE_SHORT_DESC, ATT.MEAL_CLASS AS MEAL_CLASS, DSMEALCLAS1_.SHORT_DESC AS MEAL_CLASS_SHORT_DESC, TO_CHAR(ATT.PERIOD_FROM, 'DD/MM/YYYY') AS PERIOD_FROM, TO_CHAR(ATT.PERIOD_TO, 'DD/MM/YYYY') AS PERIOD_TO, ATT.ORDER_ID AS ORDER_ID, ATT.ORDER_LINE_NO AS ORDER_LINE_NO, ATT.PATIENT_CLASS AS PATIENT_CLASS,ATT.ATNDNT_INSTR AS ATNDNT_INSTR FROM DS_EPSD_DIET_PROFILE_ATT ATT, DS_MEAL_CLASS DSMEALCLAS1_, DS_DIET_TYPE DSDIETTYPE2_ WHERE ATT.DIET_TYPE=DSDIETTYPE2_.DIET_TYPE AND ((ATT.MEAL_CLASS=DSMEALCLAS1_.MEAL_CLASS )AND(ATT.OPERATING_FACILITY_ID='"+facility+"')AND(ATT.ENCOUNTER_ID='"+encounterID+"')AND(ATT.PROFILE_SL='"+profileSL+"')  AND (TRUNC (SYSDATE) BETWEEN TRUNC (att.period_from) AND TRUNC (att.period_to) OR  (TO_DATE (att.period_to, 'DD/MM/YYYY') >= TO_DATE(TRUNC (SYSDATE),'DD/MM/YYYY'))))";//Added att.period_to condition against ML-MMOH-CRF-1460 
		//AND  (TO_DATE (att.period_to, 'DD/MM/YYYY') >= TO_DATE('"+currentdate+"','DD/MM/YYYY')))"; // Modified Against ML-MMOH-SCF-2000
		System.err.println(" attendentList in PlaceDietOrderServlet: "+attendentList.toString());
		String dietTypeList = "SELECT DTL.DIET_TYPE AS DIET_TYPE, DTL.MEAL_TYPE AS MEAL_TYPE FROM DS_EPSD_DIET_PROFILE_DTL DTL WHERE (DTL.OPERATING_FACILITY_ID='"+facility+"')AND(DTL.ENCOUNTER_ID='"+encounterID+"')AND(DTL.PROFILE_SL='"+profileSL+"') ORDER BY  2 , 1";
		String foodDislikesList = "SELECT DIS.ITEM_CODE AS ITEM_CODE, ITM.SHORT_DESC AS SHORT_DESC FROM DS_PATIENT_FOOD_DISLIKES DIS, DS_ITEMS ITM WHERE (DIS.ITEM_CODE=ITM.FOOD_ITEM_CODE )AND(DIS.PATIENT_ID='"+patientID+"')AND(ITM.LANGUAGE_ID='"+locale+"')";
		String mealTypeExclusionsList = "SELECT TO_CHAR(EXCLUDED_DATE,'DD/MM/YYYY') ,DS_GET_DESC.DS_MEAL_TYPE(MEAL_TYPE,'"+locale+"','2') MEALTYPEDESC, MEAL_TYPE FROM DS_MEAL_TYPE_EXCLUSIONS WHERE OPERATING_FACILITY_ID='"+facility+"' AND ENCOUNTER_ID ="+encounterID+" AND PROFILE_SL="+profileSL+"ORDER BY EXCLUDED_DATE";

		pstmt = conn.prepareStatement(nutriAndSplFood_query);
		pstmt2 = conn.prepareStatement(splfooditem);
		pstmt3 = conn.prepareStatement(attendentList);
		pstmt4 = conn.prepareStatement(dietTypeList);
		pstmt5 = conn.prepareStatement(foodDislikesList);
		pstmt6 = conn.prepareStatement(mealTypeExclusionsList);

		rs = pstmt.executeQuery();
		rs2 = pstmt2.executeQuery();
		rs3 = pstmt3.executeQuery();
		rs4 = pstmt4.executeQuery();
		rs5 = pstmt5.executeQuery();
		rs6 = pstmt6.executeQuery();

		while(rs != null && rs.next())
		{
			//Commented Against Nutrient Supplement & Special food item [IN:067653] Starts Here
			/* String serving_start_time = com.ehis.util.DateUtils.convertDate(rs.getString(1),"DMY", "en", locale);
			String serving_end_time = com.ehis.util.DateUtils.convertDate(rs.getString(2),"DMY", "en", locale);
			String meal_type = rs.getString(3);
			String meal_type1 = rs.getString(4);
			String item_sl = rs.getString(5);
			String item_type = rs.getString(6);
			String short_desc = rs.getString(7);
			String item_code = rs.getString(8);
			String short_desc1 = rs.getString(9);
			String item_qty = rs.getString(10);
			String patient_class = rs.getString(11);
			String serving_uom_code = rs.getString(12);
			String calorific_cont_per_uom = rs.getString(13);
			String energy_uom = rs.getString(14);
			System.err.println("660 energy_uom====>"+energy_uom);
			String energy_uom_desc = rs.getString(15);//Added Against PMG2017-COMN-CRF-0012.1-US001
			System.err.println("662 energy_uom_desc====>"+energy_uom_desc);
			list.add(serving_start_time);
			list.add(serving_end_time);
			list.add(meal_type);
			list.add(meal_type1);
			list.add(item_sl);
			list.add(item_type);
			list.add(short_desc);
			list.add(item_code);
			list.add(short_desc1);
			list.add(item_qty);
			list.add(patient_class);
			list.add(serving_uom_code);
			list.add(calorific_cont_per_uom);
			list.add(energy_uom);
			list.add(energy_uom_desc);//Added Against PMG2017-COMN-CRF-0012.1-US001 */
			//Commented Against Nutrient Supplement & Special food item [IN:067653] Ends Here
			
			//Added Against Nutrient Supplement & Special food item [IN:067653] Starts Here
			String serving_start_time = com.ehis.util.DateUtils.convertDate(rs.getString(1),"DMY", "en", locale);
			String serving_end_time = com.ehis.util.DateUtils.convertDate(rs.getString(2),"DMY", "en", locale);
			String item_type = rs.getString(3);
			String item_code = rs.getString(4);
			String item_qty = rs.getString(5);
			String meal_type = rs.getString(6);
			String meal_type1 = rs.getString(7);
			String short_desc1 = rs.getString(8);
			String short_desc = rs.getString(9);
			String serving_uom_code = rs.getString(10);
			String patient_class = rs.getString(11);
			String item_sl = rs.getString(12);
			String calorific_cont_per_uom = rs.getString(13);
			String energy_uom = rs.getString(14);
			String energy_uom_desc = rs.getString(15);
			String serving_uom_desc = rs.getString(16);
			list.add(serving_start_time);
			list.add(serving_end_time);
			list.add(item_type);
			list.add(item_code);
			list.add(item_qty);
			list.add(meal_type);
			list.add(meal_type1);
			list.add(short_desc1);
			list.add(short_desc);
			list.add(serving_uom_code);
			list.add(patient_class);
			list.add(item_sl);
			list.add(calorific_cont_per_uom);
			list.add(energy_uom);
			list.add(energy_uom_desc);
			list.add(serving_uom_desc);
			//Added Against Nutrient Supplement & Special food item [IN:067653] Ends Here
		}
		while(rs2 != null && rs2.next())
		{
		String SERVING_TIME = com.ehis.util.DateUtils.convertDate(rs2.getString(1),"DMY", "en", locale);
		String SERVING_FREQ = rs2.getString(2);
		String PERIOD_BET_SERVINGS = rs2.getString(3);
		String ITEM_SL = rs2.getString(4);
		String ITEM_TYPE = rs2.getString(5);
		String SHORT_DESC = rs2.getString(6);
		String ITEM_CODE = rs2.getString(7);
		String SHORT_DESC1 = rs2.getString(8);
		String ITEM_QTY = rs2.getString(9);
		String PATIENT_CLASS = rs2.getString(10);
		String SERVING_UOM_CODE = rs2.getString(11);
		String CALORIFIC_CONT_PER_UOM = rs2.getString(12);
		String ENERGY_UOM = rs2.getString(13);
		String PERIOD_BET_SERVINGS1 = rs2.getString(14);
		String SHORT_DESC3 = rs2.getString(15);
		String MEAL_TYPE = rs2.getString(16);
		String FREQ_YN = rs2.getString(17);
		String ENERGY_UOM_DESC = rs2.getString(18); //Added Against PMG2017-COMN-CRF-0012.1-US001
		String SERVING_UOM_DESC = rs2.getString(19); //Added Against Nutrient Supplement & Special food item [IN:067653]

		list2.add(SERVING_TIME);
		list2.add(SERVING_FREQ);
		list2.add(PERIOD_BET_SERVINGS);
		list2.add(ITEM_SL);
		list2.add(ITEM_TYPE);
		list2.add(SHORT_DESC);
		list2.add(ITEM_CODE);
		list2.add(SHORT_DESC1);
		list2.add(ITEM_QTY);
		list2.add(PATIENT_CLASS);
		list2.add(SERVING_UOM_CODE);
		list2.add(CALORIFIC_CONT_PER_UOM);
		list2.add(ENERGY_UOM);
		list2.add(PERIOD_BET_SERVINGS1);
		list2.add(SHORT_DESC3);
		list2.add(MEAL_TYPE);
		list2.add(FREQ_YN);
		list2.add(ENERGY_UOM_DESC); //Added Against PMG2017-COMN-CRF-0012.1-US001
		list2.add(SERVING_UOM_DESC);//Added Against Nutrient Supplement & Special food item [IN:067653]
		}
		while(rs3 != null && rs3.next())
		{
		String ATTENDENT_SRL = rs3.getString(1);
		String DIET_TYPE = rs3.getString(2);
		String SHORT_DESC = rs3.getString(3);
		String MEAL_CLASS = rs3.getString(4);
		String SHORT_DESC1 = rs3.getString(5);
		String PERIOD_FROM = com.ehis.util.DateUtils.convertDate(rs3.getString(6),"DMY", "en", locale);
		String PERIOD_TO = (rs3.getString(7) == null) ? "" : com.ehis.util.DateUtils.convertDate(rs3.getString(7),"DMY", "en", locale); //IN:: 39937
		String ORDER_ID = rs3.getString(8);
		String ORDER_LINE_NO = rs3.getString(9);
		String PATIENT_CLASS = rs3.getString(10);
		String ATNDNT_INSTR = rs3.getString(11);

		list3.add(ATTENDENT_SRL);
		list3.add(DIET_TYPE);
		list3.add(SHORT_DESC);
		list3.add(MEAL_CLASS);
		list3.add(SHORT_DESC1);
		list3.add(PERIOD_FROM);
		list3.add(PERIOD_TO);
		list3.add(ORDER_ID);
		list3.add(ORDER_LINE_NO);
		list3.add(PATIENT_CLASS);
		list3.add(ATNDNT_INSTR);
		}
		while(rs4 != null && rs4.next())
		{
		String DIET_TYPE = rs4.getString(1);
		String MEAL_TYPE = rs4.getString(2);

		list4.add(DIET_TYPE);
		list4.add(MEAL_TYPE);

		}
		while(rs5 != null && rs5.next())
		{
		String ITEM_CODE = rs5.getString(1);
		String SHORT_DESC = rs5.getString(2);

		list5.add(ITEM_CODE);
		list5.add(SHORT_DESC);
		}
		while(rs6 != null && rs6.next())
		{
		String excluded_date= rs6.getString(1);
		String meal_type_desc = rs6.getString(2);
		String meal_type_code = rs6.getString(3);
		list6.add(excluded_date);
		list6.add(meal_type_desc);
		list6.add(meal_type_code);
		}

		if(list != null && !list.isEmpty()){
			nutri.append(list);
			nutriSpl = nutri.toString();
			nutriSpl = nutriSpl.replace("'","\\'");
		}
		if(list2 != null && !list2.isEmpty()){
			splList.append(list2);
			splfList = splList.toString();
			splfList = splfList.replace("'","\\'");
		}
		if(list3 != null && !list3.isEmpty()){
			attList.append(list3);
			attdfList = attList.toString();
			attdfList = attdfList.replace("'","\\'");
		}
		if(list4 != null && !list4.isEmpty()){
			dietList.append(list4);
			dietTList = dietList.toString();
			dietTList = dietTList.replace("'","\\'");
		}
		if(list5 != null && !list5.isEmpty()){
			disLikes.append(list5);
			disLikesList = disLikes.toString();
			disLikesList = disLikesList.replace("'","\\'");
		}
		if(list6 != null && !list6.isEmpty()){
			exclusions.append(list6);
			exclusionsList = exclusions.toString();
			exclusionsList = exclusionsList.replace("'","\\'");
		}
		
		out.println("nutrinetSplFoodItems('"+nutriSpl.trim()+"','"+splfList.trim()+"','"+attdfList.trim()+"','"+dietTList.trim()+"','"+disLikesList.trim()+"','"+ getLastAttendantSerial(request, encounterID) +"','"+exclusionsList.trim()+"')"); //IN:39937 - Passing Last Attendant serial
		}
		catch(Exception ee)
		{
			ee.printStackTrace();
			System.err.println("PlaceDietOrderServlet.java--->"+ee.getMessage());
		}
		finally
		{
			if(conn!=null)ConnectionManager.returnConnection(conn,request);
		    if(rs2!=null) rs2.close();
		    if(rs3!=null) rs3.close();
	 		if(rs4!=null) rs4.close();
		    if(rs5!=null) rs5.close();
			if(rs!=null) rs.close();
			if(rs6!=null) rs6.close();

			if(pstmt!=null) pstmt.close();
			if(pstmt2!=null) pstmt2.close();
			if(pstmt3!=null) pstmt3.close();
			if(pstmt4!=null) pstmt4.close();
			if(pstmt5!=null) pstmt5.close();
			if(pstmt6!=null) pstmt6.close();

			
		}
		return null;
	}

	private ArrayList<String> updateSplFoodItems(HttpServletRequest request) throws SQLException {
		Connection conn = ConnectionManager.getConnection(request);
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		session = request.getSession(false);
		String language_id = (String)session.getAttribute("LOCALE");
		String encounterId = request.getParameter("encounterId");
		String facility = request.getParameter("facility");
		//String profileSL = request.getParameter("profileSL"); //Common-ICN-0055
		//Long pi = Long.parseLong(profileSL); //Common-ICN-0055
		String updJSList = request.getParameter("foodARR");
		String[] updList = updJSList.split(",");
		
		try{
			for(int i =0; i< updList.length;){
			String upd_query = "UPDATE DS_EPSD_DIET_PROFILE_SPL SET ITEM_TYPE = ?, SERVING_TIME =to_date(?,'DD/MM/YYYY HH24:MI'), SERVING_FREQ = ?, PERIOD_BET_SERVINGS =to_date(?,'DD/MM/YYYY HH24:MI'), ITEM_CODE = ?, ITEM_QTY = ?, FREQ_YN = ?, MEAL_TYPE = ? WHERE OPERATING_FACILITY_ID = ? AND ENCOUNTER_ID = ? AND PROFILE_SL = ? AND ITEM_SL = ?";
			pstmt = conn.prepareStatement(upd_query);
			pstmt.setString(1, updList[i+2]);
			updList[i] = com.ehis.util.DateUtils.convertDate(updList[i],"DMY", language_id, "en");
			pstmt.setString(2, updList[i]);
			pstmt.setString(3, updList[i+1]);
			String periodBtwSr = new String(updList[i]+" "+updList[i+17]);
			pstmt.setString(4, periodBtwSr);
			pstmt.setString(5, updList[i+3]);
			int qty = Integer.parseInt(updList[i+4].trim());
			pstmt.setInt(6, qty);
			pstmt.setString(7, updList[i+20].trim());
			if(updList[i+19].trim() != null && updList[i+19].trim() != "" && !updList[i+19].trim().equals("null")){
				pstmt.setString(8, updList[i+19].trim());
			}else{
				pstmt.setString(8, "");
			}
			pstmt.setString(9, facility.trim());
			pstmt.setString(10, encounterId.trim());
			pstmt.setString(11, updList[i+5].trim());
			int srlNO = Integer.parseInt(updList[i+6].trim());
			pstmt.setInt(12, srlNO);
			//i = i+21;//Commented Against PMG2017-COMN-CRF-0012.1-US001
			i = i+22;//Added Against PMG2017-COMN-CRF-0012.1-US001
			int flag = pstmt.executeUpdate();
			if(flag != 0){
				System.out.println("Flag not zero in updateSplFoodItems");
				conn.commit();
			}else{
				System.out.println("Flag zero in updateSplFoodItems");
				conn.rollback();
			}
			if(pstmt !=null) pstmt.close(); //Common-ICN-0053
		}
		}catch(Exception ee){
			ee.printStackTrace();
			System.err.println("PlaceDietOrderServlet.java------updateSplFoodItems->"+ee.getMessage());
		}finally{
			if(conn!=null)ConnectionManager.returnConnection(conn,request);
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			
		}
		return null;

	}

	private ArrayList<String> deleteSplFoodItems(HttpServletRequest request) throws SQLException{
		String encounterId = request.getParameter("encounterId");
		String facility = request.getParameter("facility");
		String itemSrlNo = request.getParameter("itemSrlNo");
		String profileSL = request.getParameter("profileSL");

		Connection conn = ConnectionManager.getConnection(request);
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try{				
				String del_query = "delete from DS_EPSD_DIET_PROFILE_SPL where OPERATING_FACILITY_ID='"+facility+"' and ENCOUNTER_ID='"+encounterId+"' and PROFILE_SL='"+profileSL.trim()+"' and ITEM_SL='"+itemSrlNo.trim()+"'";
				 pstmt = conn.prepareStatement(del_query);
				 int delete = pstmt.executeUpdate();
				 if(delete != 0){
					 System.out.println("Flag not zero in deleteSplFoodItems");
						conn.commit();
					}else{
						System.out.println("Flag zero in deleteSplFoodItems");
						conn.rollback();
					}

		}catch(Exception ee){
			ee.printStackTrace();
			System.err.println("PlaceDietOrderServlet.java--->"+ee.getMessage());
		}finally{
			if(conn!=null)ConnectionManager.returnConnection(conn,request);
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			
		}

		return null;
	}

	private ArrayList<String> getSlNo(HttpServletRequest request) throws SQLException {
		ArrayList<String> srlNOList = new ArrayList<String>();
		String encounterId = request.getParameter("encounterId");
		String facility = request.getParameter("facility");

		Connection conn = ConnectionManager.getConnection(request);
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String ITEM_SL = null;
		String PROFILE_SL = null;
		try{
			String query_str = "SELECT SPL.PROFILE_SL,SPL.ITEM_SL FROM DS_EPSD_DIET_PROFILE_SPL SPL WHERE SPL.OPERATING_FACILITY_ID ='"+facility+"' AND SPL.ENCOUNTER_ID ='"+encounterId+"'";
			pstmt = conn.prepareStatement(query_str);
			rs = pstmt.executeQuery();
			while(rs != null && rs.next()){
				PROFILE_SL = rs.getString(1);
				ITEM_SL = rs.getString(2);
				 srlNOList.add(PROFILE_SL);
				 srlNOList.add(ITEM_SL);
			}

		}catch(Exception ee){
			ee.printStackTrace();
			System.err.println("PlaceDietOrderServlet.java--->"+ee.getMessage());
		}finally{
			if(conn!=null)ConnectionManager.returnConnection(conn,request);
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			
		}
		return srlNOList;
	}

	public ArrayList<String> fetchAgeGroupCode(HttpServletRequest request, HttpServletResponse response)
	{
		String gender = "";
		String maxAge = "";
		int maxAgeInYears 	= 0;
		int maxAgeInDays 	= 0;
		int maxAgeInMonths 	= 0;
		int maxAgeInHours 	= 0;
		int maxAgeInMinutes = 0;
		String ageUnit = "";
		ArrayList<String> list = new ArrayList<String>();
		Connection conn = ConnectionManager.getConnection(request);
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try
		{
			session = request.getSession();// AAKH-CRF-0065
			session.removeAttribute("ALLMENUITEMSMAP");// AAKH-CRF-0065
			gender = request.getParameter("gender");
			maxAge = request.getParameter("maxAge");
			ageUnit = request.getParameter("ageUnit");
			//SCF-1148 Changes Start -
			if("Y".equalsIgnoreCase(ageUnit))
			{
				maxAgeInYears 	=  Integer.parseInt(maxAge);
				maxAgeInMonths 	=  Integer.parseInt(maxAge) * 12  ;
				maxAgeInDays 	=  Integer.parseInt(maxAge) * 365 ;
				maxAgeInHours    =  Integer.parseInt(maxAge) * 8760 ;
				maxAgeInMinutes =  Integer.parseInt(maxAge) * 525600;
			}
			else if("M".equalsIgnoreCase(ageUnit))
			{
				maxAgeInMonths 	=  Integer.parseInt(maxAge);
				maxAgeInDays 	=  Integer.parseInt(maxAge) * 30 ;
				maxAgeInHours    =  Integer.parseInt(maxAge) * 720;
				maxAgeInMinutes =  Integer.parseInt(maxAge) * 43200;
			}
			else if("D".equalsIgnoreCase(ageUnit))
			{
				maxAgeInDays		= Integer.parseInt(maxAge);
				maxAgeInHours   	= Integer.parseInt(maxAge) * 24;
				maxAgeInMinutes = Integer.parseInt(maxAge) * 1440;
			}
			else if("H".equalsIgnoreCase(ageUnit))
			{
				maxAgeInHours	= Integer.parseInt(maxAge);
				maxAgeInMinutes = Integer.parseInt(maxAge) * 60;
			}
			else if("N".equalsIgnoreCase(ageUnit))
			{
				maxAgeInMinutes = Integer.parseInt(maxAge);
			}
			String age_group_code = "select age_Group_Code from Am_Age_Group where NVL(gender,'"+gender+"') = '"+gender+"' and " +
											 "  ( ("+maxAgeInYears+" between min_Age and max_Age	and age_Unit = 'Y') or " +
										     "  ("+maxAgeInMonths+" between min_Age and max_Age	and age_Unit = 'M') or " +
										     "  ("+maxAgeInDays+" between min_Age and max_Age	and age_Unit = 'D') or " +
										     "  ("+maxAgeInHours+" between min_Age and max_Age	and age_Unit = 'H') or " +
										     "  ("+maxAgeInMinutes+" between min_Age and max_Age	and age_Unit = 'N')  )";
			//SCF-1148 Changes End			
			pstmt = conn.prepareStatement(age_group_code);
			rs = pstmt.executeQuery();

			while(rs != null && rs.next())
			{
				String ageGroupCode = rs.getString(1);
				list.add(ageGroupCode);
			}
		}
		catch(Exception ee)
		{
			ee.printStackTrace();
			System.err.println("PlaceDietOrderServlet.java--->"+ee.getMessage());
		}
		finally
		{
			try
			{
				if(conn!=null)ConnectionManager.returnConnection(conn,request);
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				
			}
			catch(Exception e){}
		}
		return list;
	}

	public ArrayList<String> fecthDietTypes(HttpServletRequest request)
	{
			ArrayList<String> list = new ArrayList<String>();
			Connection conn = ConnectionManager.getConnection(request);
			PreparedStatement pstmt=null;
			ResultSet rs=null;

			String language_Id = request.getParameter("language_Id");
			String dietCategoryCode = request.getParameter("diet_Category");
			String allList = request.getParameter("ageGroupArr");
			String patientClass = request.getParameter("patientClass"); // Added for ML-MMOH-CRF-0820
		
			//Added Against ML-MMOH-CRF-0674 Starts Here
			String diettypeauto=request.getParameter("diettype_auto");
			diettypeauto=diettypeauto+"%";
			//Added Against ML-MMOH-CRF-0674 Ends Here
			String[] ageGrplist = allList.split(",");
			StringBuffer sb_diet_Types = new StringBuffer(); // Added for ML-MMOH-CRF-0820			
			
			try
			{						
				 sb_diet_Types.append("select diet_Type,short_Desc from Ds_Diet_Type_Lang_Vw where language_Id= ? and eff_Status ='E' and diet_Category_Code like ? and age_Group_Code IN(");				
				
				for (int i = 0; i < ageGrplist.length; i++)
				{
					if(i>0)
					{
					  sb_diet_Types.append(",");
					}
					sb_diet_Types.append("'"+ageGrplist[i].trim()+"'");
				}
				sb_diet_Types.append(")");

				 /*Added Start Below for ML-MMOH-CRF-0820 */
				if(patientClass.equals("IP"))
				{
					sb_diet_Types.append(" AND NVL(IP_DIET_TYPE_YN,'N') = 'Y' ");
				}
				else if(patientClass.equals("DC"))
				{
					sb_diet_Types.append(" AND NVL(DC_DIET_TYPE_YN,'N') = 'Y' ");
				}
				
				/*Added End Below for ML-MMOH-CRF-0820 */
					sb_diet_Types.append("AND short_desc LIKE ? order by lower(short_Desc)");//	//Added Against ML-MMOH-CRF-0674 
				
				pstmt = conn.prepareStatement(sb_diet_Types.toString());
					pstmt.setString(1, language_Id);
					pstmt.setString(2, dietCategoryCode);
					pstmt.setString(3, diettypeauto);//Added Against ML-MMOH-CRF-0674					
					
					rs = pstmt.executeQuery();
					while(rs != null && rs.next())
					{
						String diet_Type = rs.getString(1);
						String short_Desc = rs.getString(2).replace(",","");
						list.add(diet_Type);
						list.add(short_Desc);
					}
					if(rs!=null) rs.close();
					//Added Against ML-MMOH-CRF-0674 Ends Here
			
			}
			catch(Exception ee)
			{
				ee.printStackTrace();
				System.err.println("PlaceDietOrderServlet.java--->"+ee.getMessage());
			}
			finally
			{
				try
				{
					if(conn!=null)ConnectionManager.returnConnection(conn,request);
					if(rs!=null) rs.close();
					if(pstmt!=null) pstmt.close();
					
				}catch(Exception e){}
			}
			return list;
		}

	public ArrayList<String> fecthDietTypes_Attendant(HttpServletRequest request){
		ArrayList<String> list = new ArrayList<String>();
		Connection conn = ConnectionManager.getConnection(request);
		PreparedStatement pstmt=null;
		ResultSet rs=null;

		String language_Id = request.getParameter("language_Id");
		String dietCategoryCode = request.getParameter("diet_Category");
           //Added Against ML-MMOH-CRF-0674 Starts Here
			String diettypeauto=request.getParameter("diettype_auto");
			diettypeauto=diettypeauto+"%";
			//Added Against ML-MMOH-CRF-0674 Ends Here

		try {						
			String diet_Types = "select diet_Type,short_Desc from Ds_Diet_Type_Lang_Vw where language_Id= ? and eff_Status ='E' and diet_Category_Code like ? AND short_desc LIKE ? AND NVL(APPL_ATT_YN,'N') = 'Y' order by lower(short_Desc) ";//Added Against ML-MMOH-CRF-0674 & ML-MMOH-CRF-0670
			
			pstmt = conn.prepareStatement(diet_Types);
		} catch (SQLException e1) {
			e1.printStackTrace();
			System.err.println("PlaceDietOrderServlet.java--->"+e1.getMessage());
		}
		try{
				pstmt.setString(1, language_Id);
				pstmt.setString(2, dietCategoryCode);
				pstmt.setString(3, diettypeauto);//Added Against ML-MMOH-CRF-0674
				rs = pstmt.executeQuery();

				while(rs != null && rs.next()){
					String diet_Type = rs.getString(1);
					String short_Desc = rs.getString(2).replace(",","");
					list.add(diet_Type);
					list.add(short_Desc);
				}
				if(rs!=null) rs.close();
		}catch(Exception ee){
			ee.printStackTrace();
			System.err.println("PlaceDietOrderServlet.java in fecthDietTypes_Attendant--->"+ee.getMessage());
		}
		finally{
			try{
				if(conn!=null)ConnectionManager.returnConnection(conn,request);
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				
			}catch(Exception e){}
		}
		return list;
	}
	public ArrayList<String> fecthMealTypes(HttpServletRequest request)
	{
		session = request.getSession();// AAKH-CRF-0065
		session.removeAttribute("ALLMENUITEMSMAP");// AAKH-CRF-0065
		ArrayList<String> returnList = new ArrayList<String>();
		Connection conn = ConnectionManager.getConnection(request);
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String language_Id = request.getParameter("language_Id");
		String dietCategoryCode = request.getParameter("diet_Category");
		String mClass = request.getParameter("mClass");
		String dType = request.getParameter("dType");
		String ageGroupArr = request.getParameter("ageGroupArr");
		String[] ageGrplist = ageGroupArr.split(",");
		String kCode = request.getParameter("kCode");
		try
		{
			String diet_Types = "select diet_Type,short_Desc from Ds_Diet_Type_Lang_Vw where language_Id= ? and eff_Status ='E' and diet_Category_Code like ? and age_Group_Code like ?";
			pstmt = conn.prepareStatement(diet_Types);
		}
		catch (SQLException ee)
		{
			ee.printStackTrace();
			System.err.println("PlaceDietOrderServlet.java--->"+ee.getMessage());
		}
		try
		{
				for (int i = 0; i < ageGrplist.length; i++)
				{
					pstmt.setString(1,language_Id);
					pstmt.setString(2,dietCategoryCode);
					pstmt.setString(3,ageGrplist[i].trim());

					rs = pstmt.executeQuery();
					while(rs != null && rs.next()){
						String diet_Type = rs.getString(1);
						String short_Desc = rs.getString(2);
						returnList.add(diet_Type);
						returnList.add(short_Desc);
					}
					if(rs!=null) rs.close();
				}
			}catch(Exception ee){
				ee.printStackTrace();
				System.err.println("PlaceDietOrderServlet.java--->"+ee.getMessage());
			}
			finally{
				try{
					if(conn!=null)ConnectionManager.returnConnection(conn,request);
					if(rs!=null) rs.close();
					if(pstmt!=null) pstmt.close();
					
				}catch(Exception e){}
			}
			returnList = getSortedMealTypes(dType,mClass,kCode,language_Id, request);
		return returnList;
	}
	public ArrayList<String> getSortedMealTypes(String dType,String mClass,String kCode,String language_Id,HttpServletRequest request){
		ArrayList<String> keyValueList = new ArrayList<String>();
		Connection conn = ConnectionManager.getConnection(request);
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String Serving_start_time = "", Serving_end_time="", Irregular_start_time="", Irregular_end_time=""; //Common-ICN-0055
		try{
			//ML-MMOH-CRF-409
			String meal_Types_query = "select menuTimeTable.meal_Type, mealType.short_Desc,mealType.Serving_start_time,mealType.serving_end_time,mealType.irregular_start_time,mealType.irregular_end_time from Ds_Diet_Menu_Time_Table menuTimeTable, Ds_Meal_Type_Lang_Vw mealType where menuTimeTable.meal_Type = mealType.meal_Type and menuTimeTable.diet_Type = '"+dType.trim()+"' and menuTimeTable.meal_Class like '"+mClass+"' and menuTimeTable.kitchen_Code like '"+kCode+"' and menuTimeTable.day_No = '1'  and mealType.LANGUAGE_ID = '"+language_Id+"' and menuTimeTable.EFF_STATUS='E' order by mealtype.meal_order";	//Added EFF_STATUS Against AMS-SCF-0835
			//ML-MMOH-CRF-409
			pstmt = conn.prepareStatement(meal_Types_query);
			rs = pstmt.executeQuery();
			while(rs != null && rs.next()){

				String meal_type = rs.getString(1);
				String short_Desc = rs.getString(2);
				//ML-MMOH-CRF-409
				 Serving_start_time=rs.getString(3);
				 Serving_end_time=rs.getString(4);
				 Irregular_start_time=rs.getString(5);
				 Irregular_end_time=rs.getString(6);
				//ML-MMOH-CRF-409

				keyValueList.add(meal_type);
				keyValueList.add(short_Desc);
				
			}
		}
		catch(Exception ee){
			ee.printStackTrace();
			System.err.println("PlaceDietOrderServlet.java--->"+ee.getMessage());
		}
		finally{
			try{
				if(conn!=null)ConnectionManager.returnConnection(conn,request);
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				
			}catch(Exception e){}
		}		
		return keyValueList;
	}
	public int getDayRefNo(HttpServletRequest request){
		session = request.getSession(false);
		String language_id = (String) session.getAttribute("LOCALE");
		int day = 0;
		Long cycleDays = 0L;
		java.util.Date menuDate = null;
		String dsDietType = request.getParameter("dietType");
		String dsMealClass = request.getParameter("mealClass");
		String facility = request.getParameter("facility");		
		String dateForMeanu = com.ehis.util.DateUtils.convertDate(request.getParameter("dateForMeanu"),"DMY", language_id, "en");
		Connection conn = ConnectionManager.getConnection(request);
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			if(dateForMeanu != null && !dateForMeanu.equals("")){
				menuDate = new SimpleDateFormat("dd/MM/yyyy").parse(dateForMeanu.trim());
			}
		}catch (ParseException e1) {
			e1.printStackTrace();
		}

		try{
			String day_ref_query = "select menu_Sched_Cycle_Days, to_char( meal_Plan_Ref_Date, 'DD/MM/YYYY' ),meal_Plan_Ref_Day_No from Ds_Diet_Menu_Sched_Cycle where diet_Type = ? and meal_Class =? and operating_Facility_Id =?";  // Modified Against KDAH-CRF-0349.1/US003[IN:067380]
			
			pstmt = conn.prepareStatement(day_ref_query);
			// Added Start Against KDAH-CRF-0349.1/US003[IN:067380]
			pstmt.setString(1,dsDietType.trim());
			pstmt.setString(2,dsMealClass.trim());
			pstmt.setString(3,facility);
			// Added End Against KDAH-CRF-0349.1/US003[IN:067380]
			rs = pstmt.executeQuery();
			while(rs != null && rs.next()){
				cycleDays = rs.getLong(1);
				String meal_Plan_Ref_Date = null;
				if(rs.getString(2) != null && rs.getString(2) != ""){
					meal_Plan_Ref_Date = rs.getString(2).substring(0,10);
				}
				DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
				java.util.Date toDate = formatter.parse(meal_Plan_Ref_Date);
				Long l_plan_ref_day_no = rs.getLong(3);
				java.sql.Timestamp dateCompare = new 	Timestamp(toDate.getTime());
				if(menuDate != null){
					long diff = Math.abs((menuDate.getTime() - dateCompare.getTime()));
					int dayDiff = (int) Math.floor(diff / 1000 / 60 / 60 / 24);
					dayDiff = dayDiff + l_plan_ref_day_no.intValue();
					day = (dayDiff % cycleDays.intValue());
				}
			}
			if(day == 0){
				day = cycleDays.intValue();
			}
		}
		catch(Exception ee){
			ee.printStackTrace();
			System.err.println("PlaceDietOrderServlet.java--->"+ee.getMessage());
		}
		finally{
			try{
				if(conn!=null)ConnectionManager.returnConnection(conn,request);
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				
			}catch(Exception e){}
		}		
		return day;
	}
/* Added Start Against KDAH-CRF-0349.1/US003[IN:067380]	*/
	public int getDayRefNo1(HttpServletRequest request,String dateforMenu,String dietType,String mealClass,String facility_id) {
		session = request.getSession(false);
		String language_id = (String) session.getAttribute("LOCALE");
		int day = 0;
		Long cycleDays = 0L;
		java.util.Date menuDate = null;
		String dsDietType = dietType;
		String dsMealClass = mealClass;
		String facility = facility_id;
		
		String dateForMeanu = com.ehis.util.DateUtils.convertDate(dateforMenu,"DMY", language_id, "en");
		Connection conn = ConnectionManager.getConnection(request);
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			if(dateForMeanu != null && !dateForMeanu.equals("")){
				menuDate = new SimpleDateFormat("dd/MM/yyyy").parse(dateForMeanu.trim());
			}
		}catch (ParseException e1) {
			e1.printStackTrace();
		}
		try{
			String day_ref_query = "select menu_Sched_Cycle_Days, to_char( meal_Plan_Ref_Date, 'DD/MM/YYYY' ),meal_Plan_Ref_Day_No from Ds_Diet_Menu_Sched_Cycle where diet_Type = ? and meal_Class = ? and operating_Facility_Id = ? ";
			
			pstmt = conn.prepareStatement(day_ref_query);
			pstmt.setString(1,dsDietType.trim());
			pstmt.setString(2,dsMealClass.trim());
			pstmt.setString(3,facility);
			rs = pstmt.executeQuery();
			while(rs != null && rs.next()){
				cycleDays = rs.getLong(1);
				String meal_Plan_Ref_Date = null;
				if(rs.getString(2) != null && rs.getString(2) != ""){
					meal_Plan_Ref_Date = rs.getString(2).substring(0,10);
				}
				DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
				java.util.Date toDate = formatter.parse(meal_Plan_Ref_Date);
				Long l_plan_ref_day_no = rs.getLong(3);
				java.sql.Timestamp dateCompare = new 	Timestamp(toDate.getTime());
				if(menuDate != null){
					long diff = Math.abs((menuDate.getTime() - dateCompare.getTime()));
					int dayDiff = (int) Math.floor(diff / 1000 / 60 / 60 / 24);
					dayDiff = dayDiff + l_plan_ref_day_no.intValue();
					day = (dayDiff % cycleDays.intValue());
				}
			}
			if(day == 0){
				day = cycleDays.intValue();
			}
		}
		catch(Exception ee){
			ee.printStackTrace();
			System.err.println("getDayRefNo1===>"+ee.getMessage());
		}
		finally{
			try{
				if(conn!=null)ConnectionManager.returnConnection(conn,request);
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				
			}catch(Exception e){}
		}		
		return day;
	}

	public String getMenu(HttpServletRequest request,String dietType,String mealClass,String facility_id,String mealType,int dayRefNo) {
		session = request.getSession(false);
		//String language_id = (String) session.getAttribute("LOCALE"); //Common-ICN-0055
		String menuName = "";
		String dsDietType = dietType;
		String dsMealClass = mealClass;
		String facility = facility_id;
		String dsmealType = mealType;
		int day_no  = dayRefNo;

		Connection conn = ConnectionManager.getConnection(request);
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try{
			String menu_query = "SELECT menu_code FROM ds_diet_menu_time_table WHERE operating_facility_id = ? AND diet_type = ? AND meal_class = ? AND meal_type = ? AND day_no = ? "; 
			
			pstmt = conn.prepareStatement(menu_query);
			pstmt.setString(1,facility);
			pstmt.setString(2,dsDietType.trim());
			pstmt.setString(3,dsMealClass.trim());
			pstmt.setString(4,dsmealType.trim());
			pstmt.setInt(5,day_no);
			
			rs = pstmt.executeQuery();
			while(rs != null && rs.next()){
				menuName = rs.getString(1);
			}
		}
		catch(Exception ee){
			ee.printStackTrace();
			System.err.println("getMenu===>"+ee.getMessage());
		}
		finally{
			try{
				if(conn!=null)ConnectionManager.returnConnection(conn,request);
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				
			}catch(Exception e){}
		}		
		return menuName;
	}
	
	public int getMenuAvail(HttpServletRequest request,String dietType,String mealClass,String facility_id,String mealType,int dayRefNo,String itemCode,String menuCode) {
		session = request.getSession(false);
		String language_id = (String) session.getAttribute("LOCALE");
		int menuCnt = 0;
		String dsDietType = dietType;
		String dsMealClass = mealClass;
		String facility = facility_id;
		String dsmealType = mealType;
		int day_no  = dayRefNo;
		String dsitemCode = itemCode;
		String dsmenuCode = menuCode;

		Connection conn = ConnectionManager.getConnection(request);
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try{
			String menuQueryCnt = " SELECT count(*) retcnt FROM ds_menu_item menuitem, ds_menu menu, ds_items items, ds_diet_menu_time_table menutimetable, ds_meal_type mealtype WHERE menutimetable.meal_type =  mealtype.meal_type AND (menuitem.menu_code = menu.menu_code) AND (menuitem.item_code = items.food_item_code) AND (items.language_id LIKE ?) AND (menutimetable.menu_code = menu.menu_code) AND (menutimetable.operating_facility_id = ?) AND (menutimetable.diet_type = ?) AND (menutimetable.meal_class = ?) AND (menutimetable.meal_type = ?) AND (menuitem.item_code = ?) AND (menutimetable.day_no = ?) AND  (menuitem.menu_code = ?) and menuTimeTable.EFF_STATUS='E'  "; //Added EFF_STATUS Against AMS-SCF-0835 
			
			pstmt = conn.prepareStatement(menuQueryCnt);
			pstmt.setString(1,language_id);
			pstmt.setString(2,facility);
			pstmt.setString(3,dsDietType.trim());
			pstmt.setString(4,dsMealClass.trim());
			pstmt.setString(5,dsmealType.trim());
			pstmt.setString(6,dsitemCode.trim());
			pstmt.setInt(7,day_no);
			pstmt.setString(8,dsmenuCode.trim());
			
			rs = pstmt.executeQuery();
			while(rs != null && rs.next()){
				menuCnt = rs.getInt(1);
			}
		}
		catch(Exception ee){
			ee.printStackTrace();
			System.err.println("getMenuAvail===>"+ee.getMessage());
		}
		finally{
			try{
				if(conn!=null)ConnectionManager.returnConnection(conn,request);
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				
			}catch(Exception e){}
		}		
		return menuCnt;
	}
	/* Added End Against KDAH-CRF-0349.1/US003[IN:067380] */		
	/* Added Against Start KDAH-CRF-0349.1[IN:067479] */
	public int getreviewSlNo(HttpServletRequest request,String facility_id,String encounterId,String profileSL,String mealType,String itemCode,String dateforMenu) {
		int reviewSlno = 0;
		String facility = facility_id;
		String dsencounterId = encounterId;
		String dsprofileSL = profileSL;
		String dsmealType = mealType;
		String dsitemCode = itemCode;
		String dsDateForMenu = dateforMenu;

		Connection conn = ConnectionManager.getConnection(request);
		PreparedStatement pstmt=null;
		ResultSet rs=null;		
		try{
			String review_slno_query = "SELECT REVIEW_SLNO FROM DS_EPSD_DIET_PROF_DTL_REVIEWED WHERE OPERATING_FACILITY_ID = ? AND ENCOUNTER_ID = ? AND PROFILE_SL = ? AND MEAL_TYPE = ? AND ITEM_CODE = ? AND TO_CHAR(SERVING_DATE, 'DD/MM/YYYY') = ? "; 
			
			pstmt = conn.prepareStatement(review_slno_query);
			pstmt.setString(1,facility);
			pstmt.setString(2,dsencounterId);
			pstmt.setString(3,dsprofileSL);
			pstmt.setString(4,dsmealType.trim());
			pstmt.setString(5,dsitemCode.trim());
			pstmt.setString(6,dsDateForMenu);
			rs = pstmt.executeQuery();
			while(rs != null && rs.next()){
				reviewSlno = rs.getInt(1);
			}
		}
		catch(Exception ee){
			ee.printStackTrace();
			System.err.println("getreviewSlNoMethod===>"+ee.getMessage());
		}
		finally{
			try{
				if(conn!=null)ConnectionManager.returnConnection(conn,request);
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				
			}catch(Exception e){}
		}		
		return reviewSlno;
	}	
/* Added Against Start KDAH-CRF-0349.1[IN:067479] */

	public ArrayList<String> getMealContents(HttpServletRequest request)
	{
		ArrayList<String> returnList = new ArrayList<String>();
		String language_Id =  request.getParameter("locale");
		String mealTypeStr =  request.getParameter("_mTypeArr");
		String[] mealType = mealTypeStr.split(",");
		String mealClass	=  request.getParameter("mClass");
		String dietTypeStr =  request.getParameter("_dTypeArr");
		String[] dietType = dietTypeStr.split(",");
		String profileID	=  request.getParameter("profileSL");
		String encounterID	=  request.getParameter("encounterId");
		String fromDate	=  com.ehis.util.DateUtils.convertDate(request.getParameter("dateForMeanu"),"DMY", language_Id, "en");
		//String dateTo = request.getParameter("dateTo");	//Common-ICN-0055	
		String dayRef	=  request.getParameter("dayRef");
		String kichenCode	=  request.getParameter("kitchenCode");
		String facility	=  request.getParameter("addedFacilityId");
		String dietTypes	=  request.getParameter("dietType");
		if ((profileID == null) || (profileID.equals("")))
			returnList = getMenuItems(language_Id,mealType,mealClass,dietType,profileID,encounterID,fromDate,dayRef,kichenCode,facility,dietTypes,request);
		else
	    	returnList = getMenuItems(language_Id,mealType,mealClass,dietType,profileID,encounterID,fromDate,dayRef,kichenCode,facility,dietTypes,request);
		return returnList;
	}
	//Added against  MMS-KH-CRF-0029.1 Starts Here
	public ArrayList<String> drugFood(HttpServletRequest request,HttpServletResponse response)		
	{
		Connection conn = ConnectionManager.getConnection(request);	
		/* CallableStatement cstmt = null;		 //Common-ICN-0055
		String food_Value=""; */
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		ArrayList<String> drugList = new ArrayList<String>();
		String foodValue[] = null;
		String item[] = null;
		String item_1[] = null;
		String Value="";
		String date1="";
		String ing1="";
		String specialCharacters = "#";
		try{
			//String language_Id =  request.getParameter("locale"); //Common-ICN-0055
			String mealClass	=  request.getParameter("mClass");
			String facility	=  request.getParameter("addedFacilityId");
			String dietTypes	=  request.getParameter("dietType");
			String encounterID	=  request.getParameter("encounterId");
			String fromDate	=  request.getParameter("fromDate");
			String dateTo = request.getParameter("dateTo");		
			String food = "SELECT ds_drug_interaction_food_items(?, ?, ?, ?, to_date(?,'dd/mm/yyyy'), to_date(?,'dd/mm/yyyy')) drug_in from dual";
				pstmt = conn.prepareStatement(food);
				pstmt.setString(1,facility);
				pstmt.setString(2,encounterID);
				pstmt.setString(3,dietTypes);
				pstmt.setString(4,mealClass);
				pstmt.setString(5,fromDate);				
				pstmt.setString(6,dateTo);
				rs = pstmt.executeQuery();
				if( rs!=null && rs.next())
				{					
					Value=checkForNull(rs.getString("drug_in"));
				}
					foodValue = Value.split("~");
					for (int j=0; j < foodValue.length; j++)
					{
						for (int i = 0; i < foodValue[j].length(); i++) {
						if (specialCharacters.contains(Character.toString(foodValue[j].charAt(i))))
					{
						item = foodValue[j].split("!");
						
						 date1 = item[0];
						 ing1 = item[1];	
						item_1=ing1.split("#");
						String item_co = item_1[0];
						String ing_co = item_1[1];
				try{
				/* String sql="select distinct f.drug_desc,e.long_desc,d.long_desc,intr_severity_level,intr_signif_level,intr_prob_level,intr_restrt_yn,b.eff_status FROM ph_patient_drug_profile a,ph_drug_interaction b,ds_food_item_ingredients c,ds_food_item d,ds_ingredient e,ph_drug f WHERE encounter_id='"+encounterID+"'AND a.drug_code = b.intr_code1 AND b.intr_code2 ='"+ing_co+"' AND b.intr_type2 ='F'  AND c.ingredient_code = b.intr_code2 AND c.food_item_code = d.food_item_code AND d.food_item_code ='"+item_co+"'AND c.ingredient_code = e.ingredient_code AND a.DRUG_CODE = f.DRUG_CODE AND (to_date('"+fromDate+"', 'dd/mm/yyyy') BETWEEN TRUNC(START_DATE) AND TRUNC(END_DATE) OR to_date ('"+fromDate+"', 'dd/mm/yyyy') BETWEEN TRUNC(START_DATE) AND TRUNC(END_DATE)) AND NVL(c.EFF_STATUS,'!') = 'E'";	//Added Against ICN:72440*/				
				String sql="select distinct f.drug_desc,e.long_desc,d.long_desc,intr_severity_level,intr_signif_level,intr_prob_level,intr_restrt_yn,b.eff_status FROM ph_patient_drug_profile a,ph_drug_interaction b,ds_food_item_ingredients c,ds_food_item d,ds_ingredient e,ph_drug f WHERE encounter_id='"+encounterID+"'AND a.drug_code = b.intr_code1 AND b.intr_code2 ='"+ing_co+"' AND b.intr_type2 ='F'  AND c.ingredient_code = b.intr_code2 AND c.food_item_code = d.food_item_code AND d.food_item_code ='"+item_co+"'AND c.ingredient_code = e.ingredient_code AND a.DRUG_CODE = f.DRUG_CODE AND (to_date('"+fromDate+"', 'dd/mm/yyyy') BETWEEN TRUNC(START_DATE) AND TRUNC(END_DATE) OR to_date ('"+fromDate+"', 'dd/mm/yyyy') BETWEEN TRUNC(START_DATE) AND TRUNC(END_DATE)) AND NVL(c.EFF_STATUS,'!') = 'E' union select distinct f.drug_desc,e.long_desc,d.long_desc,intr_severity_level,intr_signif_level,intr_prob_level,intr_restrt_yn,b.eff_status FROM ph_patient_drug_profile a,ph_drug_interaction b,ds_food_item_ingredients c,ds_food_item d,ds_ingredient e,ph_drug f WHERE encounter_id='"+encounterID+"'AND a.generic_id = b.intr_code1 AND b.intr_code2 ='"+ing_co+"'  AND b.intr_type1 = 'G' AND b.intr_type2 ='F'  AND c.ingredient_code = b.intr_code2 AND c.food_item_code = d.food_item_code AND d.food_item_code ='"+item_co+"' AND c.ingredient_code = e.ingredient_code AND a.DRUG_CODE = f.DRUG_CODE AND (to_date('"+fromDate+"', 'dd/mm/yyyy') BETWEEN TRUNC(START_DATE) AND TRUNC(END_DATE) OR to_date ('"+fromDate+"', 'dd/mm/yyyy') BETWEEN TRUNC(START_DATE) AND TRUNC(END_DATE)) AND NVL(c.EFF_STATUS,'!') = 'E'";	//Added Against ICN:72440 and Modified Against MMS-KH-SCF-0078
				
				PreparedStatement pstmt1 = conn.prepareStatement(sql);
				ResultSet rs1 = pstmt1.executeQuery();

				while(rs1 != null && rs1.next()){
				String one = rs1.getString(1);
				String two = rs1.getString(2);
				String thr = rs1.getString(3);
				String four = rs1.getString(4);
				String five = rs1.getString(5);
				String six = rs1.getString(6);
				String sev = rs1.getString(7);
				String eig = rs1.getString(8);		//Added Against ICN-72016
				
				drugList.add(date1);
				drugList.add(one);
				drugList.add(two);
				drugList.add(thr);
				drugList.add(four);
				drugList.add(five);
				drugList.add(six);
				drugList.add(sev);
				drugList.add(eig);					//Added Against ICN-72016
				}
					}
		catch(Exception ee){
		ee.printStackTrace();}
		}
					}
					}
		}		
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Excetion after the try block end- 1607------->"+e.getMessage());
		}
		finally {
			try {
				ConnectionManager.returnConnection(conn);
				} 
			catch(Exception es){
				es.printStackTrace() ;
				}
				}
		return drugList;
	}	
	//Added against MMS-KH-CRF-0029.1 Ends Here
	
	public ArrayList<String> getMenuItems(String language_Id, String[] mealType, String mealClass, String[] dietType, String profileID, String encounterID, String fromDate, String dayRef, String kichenCode, String facility, String dietTypes,HttpServletRequest request)
	{
		session = request.getSession();// AAKH-CRF-0065
		ArrayList<String> mealList = new ArrayList<String>();
		ArrayList<String> menuItemsList = new ArrayList<String>();
		Connection conn = ConnectionManager.getConnection(request);
		PreparedStatement pstmt=null,pstmt1=null,pstmt2=null;
		ResultSet rs=null;
		String menuCode = null;
		LinkedHashMap allMenuItemsMap = new LinkedHashMap();
		ArrayList allMenuItemsList = new ArrayList();
		ArrayList menuItemsListSession = new ArrayList();
		ArrayList reviewedMenuItemsListSession = new ArrayList();
		UpdateMealMenuObject updateMealMenuObject = null;

		try
		{
			allMenuItemsMap = (LinkedHashMap)session.getAttribute("ALLMENUITEMSMAP");
			
			String menucode_query = "select  dsmenu2_.menu_code AS menu_code from Ds_Diet_Menu_Time_Table dsdietmenu0_, ds_meal_type dsmealtype1_, ds_menu dsmenu2_ where dsdietmenu0_.meal_type = dsmealtype1_.meal_type and dsdietmenu0_.menu_code = dsmenu2_.menu_code and ((dsdietmenu0_.operating_Facility_Id = ?) and (dsdietmenu0_.kitchen_Code = ?) and (dsdietmenu0_.diet_Type = ?) and (dsdietmenu0_.meal_Type = ?) and (dsdietmenu0_.meal_Class = ?) and (dsdietmenu0_.day_No = ?)) and dsmenu2_.EFF_STATUS='E' ORDER BY dsmealtype1_.meal_order, 1"; //Added EFF_STATUS in ds_menu against ML-MMOH-SCF-1881
			pstmt = conn.prepareStatement(menucode_query);
			//Modified Against KDAH-CRF-0352
			String menu_items_query = "select menutimetable.MEAL_TYPE,dsmealtype.short_desc as mealTypeShortDesc,menuitem.item_Code,items.short_Desc as itemShortDesc,menuitem.item_Qty,menuitem.item_Type, items.serving_Uom_Code,to_char(items.calorific_Cont_Per_Uom,'999999.99'),lower(param.energy_Uom), am_get_desc.am_uom (items.serving_uom_code,?, '2') serving_uom_desc,am_get_desc.am_uom (param.energy_uom, ?, '2') energy_uom_desc from Ds_Menu_Item menuitem, Ds_Menu menu, Ds_Items items, Ds_Param param,Ds_Diet_Menu_Time_Table menutimetable,ds_meal_type_lang_Vw  dsmealtype where " +
			"menuitem.item_Code = items.food_Item_Code and " +
			"menuitem.menu_Code = menu.menu_Code and menutimetable.menu_Code = menu.menu_Code and " +
			"dsmealtype.meal_type = menutimetable.meal_type and menutimetable.operating_Facility_Id =? and " +
			"menuitem.menu_Code =? and menutimetable.kitchen_Code = ? " +
			"and menutimetable.diet_Type = ? " +
			"and menutimetable.meal_Type =? and menutimetable.meal_Class = ?" +
			"and menutimetable.day_No = ? and dsmealtype.language_id = ? " +
			"and items.language_Id  = ? " +
			"and(menuItem.ITEM_CODE not in(select dtlReviewed.ITEM_CODE from DS_EPSD_DIET_PROF_DTL_REVIEWED dtlReviewed " +
			"where (dtlReviewed.OPERATING_FACILITY_ID=?)and(dtlReviewed.ENCOUNTER_ID=? )and" +
			"(dtlReviewed.PROFILE_SL=?)and(dtlReviewed.MEAL_TYPE=? )" +
			"and(((dtlReviewed.SERVING_DATE is null )and(dtlReviewed.CYCLE_DAY_REF=?))or(to_char(dtlReviewed.SERVING_DATE , 'dd/mm/yyyy')=? ))))" +
			" and menuTimeTable.EFF_STATUS='E'  ORDER BY dsmealtype.meal_order";	//Added EFF_STATUS Against AMS-SCF-0835
			pstmt1 = conn.prepareStatement(menu_items_query);
			
		 	//Modified Against KDAH-CRF-0352
			String sql_itemsReviewed="select dtlReviewed.ITEM_SL, dtlReviewed.ITEM_TYPE , " +
					"dtlReviewed.ITEM_CODE,items.SHORT_DESC as itemShortDesc, " +
					"dtlReviewed.ITEM_QTY, dtlReviewed.REVIEW_TYPE, " +
					"dtlReviewed.MEAL_TYPE,mealType.SHORT_DESC as mealTypeShortDesc, " +
					"dtlReviewed.DIET_TYPE, items.SERVING_UOM_CODE,dtlReviewed.REVIEW_SLNO, " +
					"to_char(items.CALORIFIC_CONT_PER_UOM, '999999.99'), lower(param.ENERGY_UOM),"+
					"am_get_desc.am_uom (items.serving_uom_code, ?, '2') serving_uom_desc,"+
					"am_get_desc.am_uom (param.energy_uom, ?, '2') energy_uom_desc " +
					"from DS_EPSD_DIET_PROF_DTL_REVIEWED dtlReviewed, DS_MEAL_TYPE mealType, DS_ITEMS items, " +
					"DS_PARAM param where (dtlReviewed.OPERATING_FACILITY_ID=? )and(dtlReviewed.ENCOUNTER_ID=? )" +
					"and(dtlReviewed.PROFILE_SL=? )and(dtlReviewed.MEAL_TYPE=mealType.MEAL_TYPE )" +
					"and(dtlReviewed.ITEM_CODE=items.FOOD_ITEM_CODE )and(items.LANGUAGE_ID like ?)" +
					"and(((dtlReviewed.SERVING_DATE is not null )" +
					"and(to_char(dtlReviewed.SERVING_DATE , 'dd/mm/yyyy')=? ))" +
					"or(((dtlReviewed.SERVING_DATE is null )and(dtlReviewed.CYCLE_DAY_REF=? )))) " +
					"order by  mealType.MEAL_ORDER";
			pstmt2 = conn.prepareStatement(sql_itemsReviewed);

			for(int i=0; i < dietType.length; i++)
			{
				pstmt.setString(1,facility);
				pstmt.setString(2,kichenCode);
				pstmt.setString(3,dietType[i]);
				pstmt.setString(4,mealType[i].trim());
				pstmt.setString(5,mealClass);
				pstmt.setString(6,dayRef);
				rs = pstmt.executeQuery();
				while(rs != null && rs.next())
				{
					menuCode = rs.getString(1);
					mealList.add(menuCode);
				}
				if(rs!=null) rs.close();

				if(mealList != null)
				{
					for(int j=0; j< mealList.size(); j++)
					{
						if(allMenuItemsMap == null)
						{
						//Modified Against KDAH-CRF-0352 Starts Here
						pstmt1.setString(1,language_Id);
						pstmt1.setString(2,language_Id);
						pstmt1.setString(3,facility);
						pstmt1.setString(4,mealList.get(j).trim());
						pstmt1.setString(5,kichenCode);
						pstmt1.setString(6,dietType[i].trim());
						pstmt1.setString(7,mealType[i].trim());
						pstmt1.setString(8,mealClass);
						pstmt1.setString(9,dayRef);
						pstmt1.setString(10,language_Id);
						pstmt1.setString(11,language_Id);
						pstmt1.setString(12,facility);
						pstmt1.setString(13,encounterID);
						pstmt1.setString(14,profileID);
						pstmt1.setString(15,mealType[i].trim());
						pstmt1.setString(16,dayRef);
						pstmt1.setString(17,fromDate);
						//Modified Against KDAH-CRF-0352 Ends Here
												
						rs = pstmt1.executeQuery();
						while(rs != null && rs.next())
						{
							String meal_Type = rs.getString(1);
							String short_Desc = rs.getString(2);
							String item_Code = rs.getString(3);
							String short_Desc1 = rs.getString(4);
							String item_Qty = rs.getString(5);
							String item_Type = rs.getString(6);
							String serving_Uom_Code = rs.getString(7);
							String calorific_Cont_Per_Uom = rs.getString(8);
							String energy_Uom = rs.getString(9);
							//Added Against KDAH-CRF-0352 Starts Here
							String serving_Uom_Desc = rs.getString(10);
						    String energy_Uom_Desc = rs.getString(11);
							//Added Against KDAH-CRF-0352 Ends Here
							menuItemsList.add(meal_Type); 
							menuItemsList.add(short_Desc);
							menuItemsList.add(item_Code);
							menuItemsList.add(short_Desc1);
							menuItemsList.add(item_Qty);
							menuItemsList.add(item_Type);
							menuItemsList.add(serving_Uom_Code);
							menuItemsList.add(calorific_Cont_Per_Uom);
							menuItemsList.add(energy_Uom);
							menuItemsList.add(null);
							//Added Against KDAH-CRF-0352 Starts Here
							menuItemsList.add(serving_Uom_Desc);
							menuItemsList.add(energy_Uom_Desc);
							//Added Against KDAH-CRF-0352 Ends Here
						}
			            if(rs!=null)
			            	rs.close();
						//Modified Against KDAH-CRF-0352 Starts Here
						pstmt2.setString(1,language_Id);
						pstmt2.setString(2,language_Id);
			        	pstmt2.setString(3,facility);
			        	pstmt2.setString(4,encounterID);
			        	pstmt2.setString(5,profileID);
			        	pstmt2.setString(6,language_Id);
			        	pstmt2.setString(7,fromDate);
			        	pstmt2.setString(8,dayRef);
						//Modified Against KDAH-CRF-0352 Ends Here
						rs = pstmt2.executeQuery();
						while(rs != null && rs.next())
						{
							String item_Type = rs.getString(2);
							String item_Code = rs.getString(3);
							String short_Desc1 = rs.getString(4);
							String item_Qty = rs.getString(5);
							String review_Type = rs.getString(6);
							String meal_Type = rs.getString(7);
							String short_Desc = rs.getString(8);
							String serving_Uom_Code = rs.getString(10);
							String calorific_Cont_Per_Uom = rs.getString(12);
							String energy_Uom = rs.getString(13);
							//Added Against KDAH-CRF-0352 Starts Here
							String serving_Uom_Desc = rs.getString(14);
						    String energy_Uom_Desc = rs.getString(15);
							//Added Against KDAH-CRF-0352 Ends Here

							if((mealType[i].trim()).equals(meal_Type))
							{
								menuItemsList.add(meal_Type);
								menuItemsList.add(short_Desc);
								menuItemsList.add(item_Code);
								menuItemsList.add(short_Desc1);
								menuItemsList.add(item_Qty);
								menuItemsList.add(item_Type);
								menuItemsList.add(serving_Uom_Code);
								menuItemsList.add(calorific_Cont_Per_Uom);
								menuItemsList.add(energy_Uom);
								menuItemsList.add(review_Type);
								//Added Against KDAH-CRF-0352 Starts Here
								menuItemsList.add(serving_Uom_Desc);
								menuItemsList.add(energy_Uom_Desc);
								//Added Against KDAH-CRF-0352 Ends Here

							}
						}
			            if(rs!=null) rs.close();
						}
						else
						{
							allMenuItemsList = (ArrayList)(((LinkedHashMap)allMenuItemsMap.get("MEALTYPEMENUITEMSLISTMAP")).get(mealType[i].toString()));
							//System.err.println("1534======allMenuItemsList======");
							if(allMenuItemsList != null)
							{
								menuItemsListSession = (ArrayList)allMenuItemsList.get(0);
								reviewedMenuItemsListSession = (ArrayList)allMenuItemsList.get(1);
								if(menuItemsListSession != null)
								{
									//System.err.println("1540======menuItemsListSession.size()========"+menuItemsListSession.size());
									for(int z=0; z<menuItemsListSession.size(); z++)
									{
										updateMealMenuObject = (UpdateMealMenuObject)menuItemsListSession.get(z);
										String meal_Type = updateMealMenuObject.getMealType();
										String short_Desc = updateMealMenuObject.getMealTypeShortDesc();
										String item_Code = updateMealMenuObject.getItemCode();
										String short_Desc1 = updateMealMenuObject.getItemShortDesc();
										String item_Qty = updateMealMenuObject.getItemQty();
										String item_Type = updateMealMenuObject.getItemType();
										String serving_Uom_Code = updateMealMenuObject.getServingUomCode();
										String calorific_Cont_Per_Uom = updateMealMenuObject.getCalorificContPerUom();
										String energy_Uom = updateMealMenuObject.getEnergyUom();
										//Added Against KDAH-CRF-0352 starts Here
										String serving_Uom_Desc=updateMealMenuObject.getServingUomDesc();
										String energy_Uom_Desc=updateMealMenuObject.getEnergyUomDesc();
										//Added Against KDAH-CRF-0352 Ends Here
										menuItemsList.add(meal_Type);
										menuItemsList.add(short_Desc);
										menuItemsList.add(item_Code);
										menuItemsList.add(short_Desc1);
										menuItemsList.add(item_Qty);
										menuItemsList.add(item_Type);
										menuItemsList.add(serving_Uom_Code);
										menuItemsList.add(calorific_Cont_Per_Uom);
										menuItemsList.add(energy_Uom);
										menuItemsList.add(null);
										//Added Against KDAH-CRF-0352 starts Here										
										menuItemsList.add(serving_Uom_Desc);
										menuItemsList.add(energy_Uom_Desc);
										//Added Against KDAH-CRF-0352 Ends Here
									}
								}
								if(reviewedMenuItemsListSession != null)
								{									
									for(int z=0; z<reviewedMenuItemsListSession.size(); z++)
									{
										updateMealMenuObject = (UpdateMealMenuObject)reviewedMenuItemsListSession.get(z);
										String item_Type = updateMealMenuObject.getItemType();
										String item_Code = updateMealMenuObject.getItemCode();
										String short_Desc1 = updateMealMenuObject.getItemShortDesc();
										String item_Qty = updateMealMenuObject.getItemQty();
										String review_Type = updateMealMenuObject.getReviewType();
										String meal_Type = updateMealMenuObject.getMealType();
										String short_Desc = updateMealMenuObject.getMealTypeShortDesc();
										String serving_Uom_Code = updateMealMenuObject.getServingUomCode();
										String calorific_Cont_Per_Uom = updateMealMenuObject.getCalorificContPerUom();
										String energy_Uom = updateMealMenuObject.getEnergyUom();
										//Added Against KDAH-CRF-0352 starts Here
										String serving_Uom_Desc=updateMealMenuObject.getServingUomDesc();
										String energy_Uom_Desc=updateMealMenuObject.getEnergyUomDesc();
										//Added Against KDAH-CRF-0352 Ends Here
										if((mealType[i].trim()).equals(meal_Type))
										{
											menuItemsList.add(meal_Type);
											menuItemsList.add(short_Desc);
											menuItemsList.add(item_Code);
											menuItemsList.add(short_Desc1);
											menuItemsList.add(item_Qty);
											menuItemsList.add(item_Type);
											menuItemsList.add(serving_Uom_Code);
											menuItemsList.add(calorific_Cont_Per_Uom);
											menuItemsList.add(energy_Uom);
											menuItemsList.add(review_Type);
											//Added Against KDAH-CRF-0352 starts Here										
											menuItemsList.add(serving_Uom_Desc);
											menuItemsList.add(energy_Uom_Desc);
											//Added Against KDAH-CRF-0352 Ends Here
										}
									}
								}
							}
						}
					}
						mealList.clear();
					}
				}
			}
		catch(Exception ee)
		{
			ee.printStackTrace();
			System.err.println("PlaceDietOrderServlet.java--->"+ee.getMessage());
		}
		finally
		{
			try
			{
				if(conn!=null)ConnectionManager.returnConnection(conn,request);
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(pstmt1!=null) pstmt1.close();
				if(pstmt2!=null) pstmt2.close();
				
		}
			catch(Exception e){}
		}		
		return menuItemsList;
	}

	/**
	 * Placing the Place diet order
	 * @param request
	 * @param response
	 * @return
	 * @throws SQLException
	 * @throws IOException
	 * @throws ParseException
	 */
	private ArrayList<String> insertMealContents(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ParseException
	{
	
		ArrayList<String> ordersList = new ArrayList<String>();
		//CRF - 0684
		boolean isMenuType =false;        
		Connection conn = ConnectionManager.getConnection(request);
		isMenuType = CommonBean.isSiteSpecific(conn,"DS","DS_MENU_TYPE");
		//CRF - 0684
		/* ORDER CATALOG */
		String MEAL_CATEGORY_CODE = null;
		String feedType = null;
		String dsDeliveryInstr = null;
		String texture_of_diet = null;//ML-MMOH-CRF-412
		String menu_type = null;//ML-MMOh-CRF-0684
		String mealTypesForDietType[] = null;
		String dietTypesforMealType[] = null;
		String attDietList[] = null;
		String fudDisListArr[] = null;
		String delFoodDisArr[] = null;
		String foodCodeDelList[] = null;
		String nutrientSuppList[] = null;
		String nutrientDeleteFlag =null;
		String dieticianReferral = null;
		//Added newly Against PMG2013-CRF-0009.1-US004 Apply Issue 
		String Cancelled_PracID = null;
		String Cancelled_Date = null;
		String Cancelled_Reason = null;
		//Added Newly Against PMG2013-CRF-0009.1-US004 Apply Issue
		
		ArrayList updateMealsDetailsList = null; // AAKH-CRF-0065
		
		LinkedHashMap allMenuItemsMap = new LinkedHashMap();

		String encounterId = request.getParameter("encounterId");
        
		String pateintRadio=checkForNull(request.getParameter("pateintRadio"));//SCF-735     

		String Diet_Category = request.getParameter("diet_Category");
		String addedById = request.getParameter("addedById");
		String addedFacilityId = request.getParameter("addedFacilityId");
		String isNEW = request.getParameter("isNEW");
		String profileSL = request.getParameter("profileSL");
		Long pi = Long.parseLong(profileSL);
		String patientId = request.getParameter("patientId");
		String patientClass = request.getParameter("patientClass");
		String locationType = request.getParameter("locationType");
		String locationCode = request.getParameter("locationCode");
		String addedAtWsNo = request.getParameter("addedAtWsNo");
		String mealTypes = request.getParameter("objMeal");
		String irregular_meal_code=request.getParameter("irregular_meal_code");//409
		String irregular_flag="";
		String atndInstr = "";//Muthu 19-May-17
		//JSONObject jsonList = new JSONObject();
		String mealExclusions = request.getParameter("mealExclusions");
		JSONObject exclusionsObj = new JSONObject(mealExclusions);
		String DietTypeModified_YN=request.getParameter("dietTypeModified_YN");//MMS-DM-0006
		session = request.getSession(false);
		String language_id = (String)session.getAttribute("LOCALE");
		// AAKH-CRF-0065 start
		allMenuItemsMap = (LinkedHashMap)session.getAttribute("ALLMENUITEMSMAP");
		if(allMenuItemsMap != null)
			updateMealsDetailsList = (ArrayList)allMenuItemsMap.get("ALLMENUITEMS");

		// AAKH-CRF-0065 end

		if(mealTypes != null && !mealTypes.equals("")){
			mealTypesForDietType = mealTypes.split(",");
		}

		String dietTypes = request.getParameter("obDiet");
		if(dietTypes != null && !dietTypes.equals("")){
			dietTypesforMealType = dietTypes.split(",");
		}

		Long servingFreq = new Long(2L);
		String mClass = request.getParameter("mClass");
		String dType = request.getParameter("dType");
		String dietCycleType = "";

		//IN:39937
		attDietList = request.getParameterValues("attdietList");

		String foodDisLikeList = request.getParameter("foodDislikeListArr");
		if(foodDisLikeList != null && !foodDisLikeList.equals("")){
			fudDisListArr = foodDisLikeList.split(",");
		}
		String delFoodDis = request.getParameter("delFoodDis");
		
		if(delFoodDis != null && !delFoodDis.equals("")){
			delFoodDisArr = delFoodDis.split(",");
		}
		String foodCodeArr = request.getParameter("foodCodeArr");
		if(foodCodeArr != null && !foodCodeArr.equals("")){
			foodCodeDelList = foodCodeArr.split(",");
		}

		String fromDate = request.getParameter("fromDate");
		String from = null;
		if(request.getParameter("from") != null && !request.getParameter("from").equals("")){
			from = com.ehis.util.DateUtils.convertDate(request.getParameter("from"),"DMYHM", language_id, "en");
		}

		String to = null;
		if(request.getParameter("to") != null && !request.getParameter("to").equals("")){
			to = com.ehis.util.DateUtils.convertDate(request.getParameter("to"),"DMYHM", language_id, "en");
		}

		String DIETARY_REMARKS = null;
		if(request.getParameter("feedingInstructions") != null && !request.getParameter("feedingInstructions").equals("")){
			DIETARY_REMARKS = URLDecoder.decode(request.getParameter("feedingInstructions"),"UTF-8");
		}
		String prepInstr = null;
		if(request.getParameter("prepInstr") != null && !request.getParameter("prepInstr").equals("")){
			prepInstr = URLDecoder.decode(request.getParameter("prepInstr"),"UTF-8");
		}
		String toDate =null;
		if(request.getParameter("dateTo") != null && !request.getParameter("dateTo").equals("")){
			toDate = request.getParameter("dateTo");
		}
		if("IP".equals(patientClass) || "DC".equals(patientClass)){
            MEAL_CATEGORY_CODE = "INP";
		}else if("OP".equals(patientClass) || "EM".equals(patientClass)){
            MEAL_CATEGORY_CODE ="OUT";
		}
		if(request.getParameter("feedType") != null && !request.getParameter("feedType").equals("")){
			feedType = request.getParameter("feedType");
		}
		if(request.getParameter("dsDeliveryInstr") != null && !request.getParameter("dsDeliveryInstr").equals("")){
			dsDeliveryInstr = request.getParameter("dsDeliveryInstr");
		}
		//ML-MMOH-CRF-412
		if(request.getParameter("texture_of_diet") != null && !request.getParameter("texture_of_diet").equals("")){
			texture_of_diet = request.getParameter("texture_of_diet");
		}
		//CRF-684
		if(isMenuType){			
		if(request.getParameter("menu_type") != null && !request.getParameter("menu_type").equals("")){
			menu_type = request.getParameter("menu_type");			
		}
		}else{
			menu_type = "";
		}
		//CRF-684
		String defaultDietYn = getDefaultDietYN(MEAL_CATEGORY_CODE,request);
		if(defaultDietYn != null && !defaultDietYn.equals("") && defaultDietYn.equals(dType)){
			defaultDietYn = "Y";
		}else {
			defaultDietYn = "N";
		}		

		String status = "";
		if(request.getParameter("status") != null && !request.getParameter("status").equals("")){
			status = request.getParameter("status");
		}
		if(request.getParameter("dieticianReferral") != null){
			dieticianReferral = request.getParameter("dieticianReferral");
		}
		String disChargeflag = "";
		if(request.getParameter("flag") != null && !request.getParameter("flag").equals("")){
			disChargeflag = request.getParameter("flag");
		}
		String remarks = "";
		if(request.getParameter("returnRemarks") != null && !request.getParameter("returnRemarks").equals("")){
			remarks = URLDecoder.decode(request.getParameter("returnRemarks"), "UTF-8");
			if(remarks.equalsIgnoreCase("null")){  //Fixed By SelvinM
				remarks = "";
			}
		}

		if(request.getParameter("nutrientSuppListArr") != null && !request.getParameter("nutrientSuppListArr").equals("")){
			nutrientSuppList = request.getParameter("nutrientSuppListArr").split(",");
		}
		if(request.getParameter("nutrientDeleteFlag") != null && !request.getParameter("nutrientDeleteFlag").equals("")){
			nutrientDeleteFlag = request.getParameter("nutrientDeleteFlag");
		}
		
		if(request.getParameter("atndInstr") != null && !request.getParameter("atndInstr").equals("")){
			atndInstr = request.getParameter("atndInstr");
		}
		//410-CRF Starts
		String Full_Day_NBM_YN="N";
		if(request.getParameter("Full_Day_NBM_YN") != null && !request.getParameter("Full_Day_NBM_YN").equals("")){
			Full_Day_NBM_YN = request.getParameter("Full_Day_NBM_YN");			
		}
		//410-CRF Ends
		//Connection conn = ConnectionManager.getConnection(request);
		PreparedStatement pstmt=null;
		PreparedStatement pstmtForDel = null; //IN:39937
		PreparedStatement pstmt1=null;
		ResultSet rs=null;
		ResultSet rs1=null;
		ResultSet rs2=null;//Added Newly Against PMG2013-CRF-0009.1-US004 Apply Issue
		CallableStatement cstmt = null;
		CallableStatement cst = null;
		String P_Error_Text = null;
		String viewCode = null;
		String orderTypeString = null;
		/**
		 * Getting the orderTypeCode to process the other details
		 */
		try
		{
			if(dieticianReferral != null && (Diet_Category.equals("") || fromDate.equals("") || mClass.equals("") || dType.equals("")))
			{				
				updateDieticianRefferal(request,dieticianReferral,addedFacilityId,addedAtWsNo,addedById,encounterId,patientClass,patientId);				
				//insertFullNBMprofile(request,conn);//CRF-410
			}
			// 410 starts
			else if(Full_Day_NBM_YN.equals("Y")){
				//insertFullNBMprofile(request,conn);
			}
			//410 ends
			else
			{
			String orderTypeCode_query = "select dietcategory.order_Type_Code from Ds_Diet_Category dietcategory where dietcategory.diet_Category_Code='"+Diet_Category+"'";
			String dietTypeCycle_query = "select dietType.diet_Cycle_Type from Ds_Diet_Type dietType where dietType.diet_Type = '"+dType+"'";
			pstmt = conn.prepareStatement(orderTypeCode_query);
			pstmt1 = conn.prepareStatement(dietTypeCycle_query);
			rs = pstmt.executeQuery();
			rs1 = pstmt1.executeQuery();
			while(rs != null && rs.next())
				orderTypeString = rs.getString(1);
			if(rs1 != null && rs1.next())
				dietCycleType = rs1.getString(1);	
			rs.close();
			rs1.close();
			pstmt.close();
			pstmt1.close();
		/**
		 * If order is new calling the Insert_Order_Header procedure
		 */
		if ((isNEW != null && isNEW.equalsIgnoreCase("true")) || pi.equals(new Long(0)))
		{
			cstmt = conn.prepareCall("{call Insert_Order_Header(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			cstmt.setString(1, "DS");
			if (orderTypeString != null)
				cstmt.setString(2, orderTypeString);
			else
				cstmt.setString(2, Diet_Category);
			cstmt.setDate(3, new java.sql.Date(System.currentTimeMillis()));
			cstmt.setString(4, "DS");
			cstmt.setString(5, "R");
			cstmt.setString(6, addedFacilityId);
			cstmt.setString(7, addedFacilityId);
			cstmt.setString(8, patientId);
			cstmt.setString(9, patientClass);
			cstmt.setString(10, encounterId + "");
			cstmt.setString(11, encounterId + "");
			cstmt.setString(12, null);
			cstmt.setString(13, locationType);
			cstmt.setString(14, locationCode);
			cstmt.setString(15, addedById);
			cstmt.setString(16, null);
			cstmt.setString(17, null);
			cstmt.setString(18, null);
			cstmt.setString(19, null);
			cstmt.setString(20, null);
			cstmt.setString(21, null);
			cstmt.setString(22, addedById);
			cstmt.setString(23, addedById);
			cstmt.setString(24, addedAtWsNo);
			cstmt.registerOutParameter(25, Types.VARCHAR);
			cstmt.registerOutParameter(26, Types.VARCHAR);
			cstmt.execute();
			viewCode = cstmt.getString(25);
			P_Error_Text = cstmt.getString(26);
		}
		else
		{
			viewCode = "";
		}
		/**
		 * If Order is new then calling the Insert_Order_Line procedure
		 */
		if ((isNEW != null && isNEW.equalsIgnoreCase("true")) || pi.equals(new Long(0)))
		{			
			String order_Catalog_Code = null;
			String catlog1 = null;
			String short_Desc = null;
			String order_Catalog_Nature = null;
			String catalog_query = "select dietType.order_Catalog_Code	from Ds_Diet_Type dietType where dietType.diet_Type = '"+dType+"'";
			pstmt = conn.prepareStatement(catalog_query);
			rs = pstmt.executeQuery();
			while(rs != null && rs.next()){
				order_Catalog_Code = rs.getString(1);
			}
			rs.close();
			pstmt.close();
			String orderCatalogNature = "select catalog.order_Catalog_Code,catalog.short_Desc,catalog.order_Catalog_Nature from Or_Order_Catalog catalog where catalog.order_Catalog_Code = '"+order_Catalog_Code+"'";
			pstmt = conn.prepareStatement(orderCatalogNature);
			rs = pstmt.executeQuery();
			while(rs != null && rs.next()){
				catlog1 = rs.getString(1);
				short_Desc = rs.getString(2);
				order_Catalog_Nature = rs.getString(3);
			}			
			cst = conn.prepareCall("{call Insert_Order_Line(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			cst.setString(1, "NEW");
			cst.setString(2, "DS");
			if (orderTypeString != null)
				cst.setString(3, orderTypeString);
			else
				cst.setString(3, Diet_Category);

			cst.setString(4, viewCode);
			cst.setInt(5, 1);
			cst.setTimestamp(6, getCurrentTimeStamp());
			cst.setString(7, "DS");
			cst.setString(8, "R");
			cst.setString(9, catlog1);
			cst.setString(10, short_Desc);
			cst.setString(11, order_Catalog_Nature);
			cst.setString(12, addedFacilityId);
			cst.setString(13, null);
			cst.setString(14, null);
			cst.setString(15, null);
			cst.setString(16, null);
			cst.setString(17, addedById);
			cst.setString(18, null);
			cst.setString(19, addedById);
			cst.setString(20, addedAtWsNo);
			cst.registerOutParameter(21, Types.VARCHAR);
			cst.execute();
			P_Error_Text = cst.getString(21);
			cst.close();
		}		

		/**
		 * Inserting into the DS_EPSD_DIET_PROFILE_HDR table based on the Order Id and Order Type
		 */
		
		if(viewCode != null && !(viewCode.equals("")))
		{			
			int flag;
			/*String dietProfileHdr = "insert into DS_EPSD_DIET_PROFILE_HDR (MEAL_CLASS, ORDER_TYPE_CODE, FEED_TYPE, DIET_CATEGORY, PATIENT_ID, DIET_TYPE, DELIVERY_CODE, PATIENT_CLASS, PERIOD_FROM, PERIOD_TO, NIL_BY_MOUTH_FRM, NIL_BY_MOUTH_TO, MEAL_CATEGORY_CODE, DIET_CYCLE_TYPE, STD_SERVICE_YN, CONSISTENCY_DTL, ATTENDANT_MEAL_YN, NO_OF_ATTENDANT_MEALS, DIETARY_REMARKS, ORDER_ID, MEAL_PLAN_CREATED_YN, MEAL_PLAN_CREATED_DATE, MEAL_PLAN_REF_DATE, MEAL_PLAN_REF_DAY_NO, DEFAULT_DIET_YN, CANCELED_PRACT_ID, CANCELLED_DATE, CANCEL_REASON, STATUS, ADDED_BY_ID, ADDED_DATE, ADDED_FACILITY_ID, ADDED_AT_WS_NO, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_FACILITY_ID, MODIFIED_AT_WS_NO, PREP_INSTR, OPERATING_FACILITY_ID, ENCOUNTER_ID, PROFILE_SL,DIETICIAN_REFRL_YN,DISCHARGE_FLAG_YN,REMARKS,ATNDNT_INSTR,DIET_TYPE_MODIFIED,TEXTURE_OF_DIET) values (?, ?, ?, ?, ?, ?, ?, ?, to_date(?,'dd/mm/yyyy'),to_date(?,'dd/mm/yyyy'),to_date(?,'dd/mm/yyyy HH24:MI'),to_date(?,'dd/mm/yyyy HH24:MI'),?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?,?,?,?,?)";*/
			try{	//Added try-catch against ML-MMOH-SCF-1864
			StringBuffer dietProfileHdr=new StringBuffer();
             dietProfileHdr.append("insert into DS_EPSD_DIET_PROFILE_HDR (");
			 dietProfileHdr.append("MEAL_CLASS, ORDER_TYPE_CODE, FEED_TYPE, DIET_CATEGORY, PATIENT_ID, DIET_TYPE, DELIVERY_CODE, PATIENT_CLASS, PERIOD_FROM, PERIOD_TO, NIL_BY_MOUTH_FRM, NIL_BY_MOUTH_TO, MEAL_CATEGORY_CODE, DIET_CYCLE_TYPE, STD_SERVICE_YN, CONSISTENCY_DTL, ATTENDANT_MEAL_YN, NO_OF_ATTENDANT_MEALS, DIETARY_REMARKS, ORDER_ID, MEAL_PLAN_CREATED_YN, MEAL_PLAN_CREATED_DATE, MEAL_PLAN_REF_DATE, MEAL_PLAN_REF_DAY_NO, DEFAULT_DIET_YN, CANCELED_PRACT_ID, CANCELLED_DATE, CANCEL_REASON, STATUS, ADDED_BY_ID, ADDED_DATE, ADDED_FACILITY_ID, ADDED_AT_WS_NO, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_FACILITY_ID, MODIFIED_AT_WS_NO, PREP_INSTR, OPERATING_FACILITY_ID, ENCOUNTER_ID, PROFILE_SL,DIETICIAN_REFRL_YN,DISCHARGE_FLAG_YN,REMARKS,ATNDNT_INSTR,DIET_TYPE_MODIFIED,TEXTURE_OF_DIET,MENU_TYPE)");//CRF-684
			 dietProfileHdr.append(" values (?, ?, ?, ?, ?, ?, ?, ?, to_date(?,'dd/mm/yyyy'),to_date(?,'dd/mm/yyyy'),to_date(?,'dd/mm/yyyy HH24:MI'),to_date(?,'dd/mm/yyyy HH24:MI'),?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?,?");
            if(pateintRadio.equals("Yes")){
				dietProfileHdr.append(",?,?,?)");//CRF-684
			}else{			
				dietProfileHdr.append(",?,?,?,?)");//CRF-684
			}

			pstmt = conn.prepareStatement(dietProfileHdr.toString());
			pstmt.setString(1, mClass);
			pstmt.setString(2, orderTypeString);
			pstmt.setString(3, feedType);
			pstmt.setString(4, Diet_Category);
			pstmt.setString(5, patientId);
			pstmt.setString(6, dType.trim());
			pstmt.setString(7, dsDeliveryInstr);
			pstmt.setString(8, patientClass);
			pstmt.setString(9, fromDate);
			pstmt.setString(10, toDate);
			pstmt.setString(11, from);
			pstmt.setString(12, to);
			pstmt.setString(13, MEAL_CATEGORY_CODE);
			pstmt.setString(14, dietCycleType);
			pstmt.setString(15, "Y");
			pstmt.setString(16, null);
			pstmt.setString(17, "N");
			pstmt.setString(18, null);
			pstmt.setString(19, DIETARY_REMARKS);
			pstmt.setString(20, viewCode);
			pstmt.setString(21, "Y");
			pstmt.setString(22, null);
			pstmt.setString(23, null);
			pstmt.setLong(24, new Long(1L));
			pstmt.setString(25, defaultDietYn);
			pstmt.setString(26, null);
			pstmt.setString(27, null);
			pstmt.setString(28, null);
			pstmt.setString(29, "");
			pstmt.setString(30, addedById);
			pstmt.setTimestamp(31, getCurrentTimeStamp());
			pstmt.setString(32, addedFacilityId);
			pstmt.setString(33, addedAtWsNo);
			pstmt.setString(34, addedById);
			pstmt.setTimestamp(35, getCurrentTimeStamp());
			pstmt.setString(36, addedFacilityId);
			pstmt.setString(37, addedAtWsNo);
			pstmt.setString(38, prepInstr);
			pstmt.setString(39, addedFacilityId);
			pstmt.setString(40, encounterId);
			pstmt.setLong(41, ++pi);
			pstmt.setString(42, dieticianReferral);
			pstmt.setString(43, disChargeflag);
			pstmt.setString(44, remarks);
			//SCF-735
			if(pateintRadio.equals("Yes")){
				pstmt.setString(45,DietTypeModified_YN);
				pstmt.setString(46,texture_of_diet);//ML-MMOH-CRF-412				
				pstmt.setString(47,menu_type);//CRF-684
			}else{
				pstmt.setString(45,atndInstr);
				pstmt.setString(46,DietTypeModified_YN);
				pstmt.setString(47,texture_of_diet);//ML-MMOH-CRF-412
				pstmt.setString(48,menu_type);//CRF-684
			}
			//SCF-735
			flag = pstmt.executeUpdate();
			if(flag != 0)
			{
				System.out.println("flag is not zero");
				conn.commit();
			}
			else
			{
				System.out.println("flag is zero");
				conn.rollback();
			}
			pstmt.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
				System.out.println("2470, Place Diet Order Servlet ==> "+e);
			}
			
			/*
			 * Updating the dietician flag in DS_EPSD_DIETICIAN_REFERRAL
			 */
			updateDieticianRefferal(request,dieticianReferral,addedFacilityId,addedAtWsNo,addedById,encounterId,patientClass,patientId);
			updateOldOrders(request,pi);
		}
		else
		{
			//Added Newly Against PMG2013-CRF-0009.1-US004 Apply Issue
			String cancelData = "select CANCELED_PRACT_ID,to_char(CANCELLED_DATE,'dd/mm/yyyy HH24:MI') CANCELLED_DATE,CANCEL_REASON from ds_epsd_diet_profile_hdr where OPERATING_FACILITY_ID='"+addedFacilityId+"' and ENCOUNTER_ID='"+encounterId+"'  and PROFILE_SL='"+pi+"'";
			pstmt = conn.prepareStatement(cancelData);
			rs2 = pstmt.executeQuery();
			while(rs2 != null && rs2.next()){
				Cancelled_PracID = rs2.getString(1);
				Cancelled_Date = rs2.getString(2);
				Cancelled_Reason = rs2.getString(3);
			}
			//Added Newly Against PMG2013-CRF-0009.1-US004 Apply Issue
		
			// Update the HDR table
			int flag;
			try{ //Added try-catch against ML-MMOH-SCF-1864
			StringBuffer dietProfileHdrUpd=new StringBuffer();
			/*String dietProfileHdrUpd = "update DS_EPSD_DIET_PROFILE_HDR set MEAL_CLASS=?, ORDER_TYPE_CODE=?, FEED_TYPE=?, DIET_CATEGORY=?, PATIENT_ID=?, DIET_TYPE=?, DELIVERY_CODE=?, PATIENT_CLASS=?, PERIOD_FROM=to_date(?,'dd/mm/yyyy'), PERIOD_TO=to_date(?,'dd/mm/yyyy'), NIL_BY_MOUTH_FRM=to_date(?,'dd/mm/yyyy HH24:MI'), NIL_BY_MOUTH_TO=to_date(?,'dd/mm/yyyy HH24:MI'), MEAL_CATEGORY_CODE=?, DIET_CYCLE_TYPE=?, STD_SERVICE_YN=?, CONSISTENCY_DTL=?, ATTENDANT_MEAL_YN=?, NO_OF_ATTENDANT_MEALS=?, DIETARY_REMARKS=?, MEAL_PLAN_CREATED_YN=?, MEAL_PLAN_CREATED_DATE=?, MEAL_PLAN_REF_DATE=?, MEAL_PLAN_REF_DAY_NO=?, DEFAULT_DIET_YN=?, CANCELED_PRACT_ID=?, CANCELLED_DATE=?, CANCEL_REASON=?, ADDED_BY_ID=?, ADDED_DATE=?, ADDED_FACILITY_ID=?, ADDED_AT_WS_NO=?, MODIFIED_BY_ID=?, MODIFIED_DATE=?, MODIFIED_FACILITY_ID=?, MODIFIED_AT_WS_NO=?, PREP_INSTR=?, DIETICIAN_REFRL_YN=?,DISCHARGE_FLAG_YN=?,REMARKS=?,ATNDNT_INSTR=?,DIET_TYPE_MODIFIED=?  ,TEXTURE_OF_DIET=? where OPERATING_FACILITY_ID=? and ENCOUNTER_ID=? and PROFILE_SL=?";*/
			
			//Added aginst CRF-0679  Starts here
			String Modifieddiettypecode="";
			String diettypeold="";
			String dietProfileHdrUpdSelect="select MODIFIED_DIET_TYPE_CODE,DIET_TYPE from DS_EPSD_DIET_PROFILE_HDR  where OPERATING_FACILITY_ID='"+addedFacilityId+"' and ENCOUNTER_ID='"+encounterId+"'  and PROFILE_SL='"+pi+"'";
			pstmt = conn.prepareStatement(dietProfileHdrUpdSelect);
			ResultSet rsentry=pstmt.executeQuery();
			while(rsentry != null && rsentry.next())
			{
				Modifieddiettypecode=rsentry.getString(1);
				diettypeold=rsentry.getString(2);
			}
			//Added aginst CRF-0679 By  Ends here
			try{ //Added try-catch against ML-MMOH-SCF-1864
			dietProfileHdrUpd.append("update DS_EPSD_DIET_PROFILE_HDR set MEAL_CLASS=?, ORDER_TYPE_CODE=?, FEED_TYPE=?, DIET_CATEGORY=?, PATIENT_ID=?, DIET_TYPE=?, DELIVERY_CODE=?, PATIENT_CLASS=?, PERIOD_FROM=to_date(?,'dd/mm/yyyy'), PERIOD_TO=to_date(?,'dd/mm/yyyy'), NIL_BY_MOUTH_FRM=to_date(?,'dd/mm/yyyy HH24:MI'), NIL_BY_MOUTH_TO=to_date(?,'dd/mm/yyyy HH24:MI'), MEAL_CATEGORY_CODE=?, DIET_CYCLE_TYPE=?, STD_SERVICE_YN=?, CONSISTENCY_DTL=?, ATTENDANT_MEAL_YN=?, NO_OF_ATTENDANT_MEALS=?, DIETARY_REMARKS=?, MEAL_PLAN_CREATED_YN=?, MEAL_PLAN_CREATED_DATE=?, MEAL_PLAN_REF_DATE=?, MEAL_PLAN_REF_DAY_NO=?, DEFAULT_DIET_YN=?, CANCELED_PRACT_ID=?, CANCELLED_DATE=to_date(?,'dd/mm/yyyy HH24:MI'), CANCEL_REASON=?, ADDED_BY_ID=?, ADDED_DATE=?, ADDED_FACILITY_ID=?, ADDED_AT_WS_NO=?, MODIFIED_BY_ID=?, MODIFIED_DATE=?, MODIFIED_FACILITY_ID=?, MODIFIED_AT_WS_NO=?, PREP_INSTR=?, DIETICIAN_REFRL_YN=?,DISCHARGE_FLAG_YN=?,REMARKS=?");//Modified Against PMG2013-CRF-0009.1-US004 Apply Issue
            if(pateintRadio.equals("Yes")){
				dietProfileHdrUpd.append(",DIET_TYPE_MODIFIED=?, TEXTURE_OF_DIET=?, MODIFIED_DIET_TYPE_CODE=? ,MENU_TYPE = ?  where OPERATING_FACILITY_ID=? and ENCOUNTER_ID=? and PROFILE_SL=?");//CRF-684
			}else{
				dietProfileHdrUpd.append(",ATNDNT_INSTR=?, DIET_TYPE_MODIFIED=?, TEXTURE_OF_DIET=?, MODIFIED_DIET_TYPE_CODE=? ,MENU_TYPE = ? where OPERATING_FACILITY_ID=? and ENCOUNTER_ID=? and PROFILE_SL=?");//CRF-684
			}

			pstmt = conn.prepareStatement(dietProfileHdrUpd.toString());
			pstmt.setString(1, mClass);
			pstmt.setString(2, orderTypeString);
			pstmt.setString(3, feedType);
			pstmt.setString(4, Diet_Category);
			pstmt.setString(5, patientId);
			pstmt.setString(6, dType.trim());
			pstmt.setString(7, dsDeliveryInstr);
			pstmt.setString(8, patientClass);
			pstmt.setString(9, fromDate);
			pstmt.setString(10, toDate);
			pstmt.setString(11, from);
			pstmt.setString(12, to);
			pstmt.setString(13, MEAL_CATEGORY_CODE);
			pstmt.setString(14, dietCycleType);
			pstmt.setString(15, "Y");
			pstmt.setString(16, null);
			pstmt.setString(17, "N");
			pstmt.setString(18, null);
			pstmt.setString(19, DIETARY_REMARKS);
			pstmt.setString(20, "Y");
			pstmt.setString(21, null);
			pstmt.setString(22, null);
			pstmt.setLong(23, new Long(1L));
			pstmt.setString(24, defaultDietYn);
			
			//Added Newly Against PMG2013-CRF-0009.1-US004 Apply Issue
			if(Cancelled_PracID != null && Cancelled_Date != null && Cancelled_Reason != null){
				pstmt.setString(25, Cancelled_PracID);//cancelled_PracID
				pstmt.setString(26, Cancelled_Date);//cancelled_date
				pstmt.setString(27, Cancelled_Reason);//cancelled_reason
			}else{
				pstmt.setString(25, null);//cancelled_PracID
				pstmt.setString(26, null);//cancelled_date
				pstmt.setString(27, null);//cancelled_reason
			}
			//Added Newly Against PMG2013-CRF-0009.1-US004 Apply Issue
			
			pstmt.setString(28, addedById);
			pstmt.setTimestamp(29, getCurrentTimeStamp());
			pstmt.setString(30, addedFacilityId);
			pstmt.setString(31, addedAtWsNo);
			pstmt.setString(32, addedById);
			pstmt.setTimestamp(33, getCurrentTimeStamp());
			pstmt.setString(34, addedFacilityId);
			pstmt.setString(35, addedAtWsNo);
			pstmt.setString(36, prepInstr);
			pstmt.setString(37, dieticianReferral);
			pstmt.setString(38, disChargeflag);
			pstmt.setString(39, remarks);
			//SCF-735
			if(pateintRadio.equals("Yes")){			
			pstmt.setString(40,DietTypeModified_YN);//MMS-DM-0006
			pstmt.setString(41,texture_of_diet);//ML-MMOH-CRF-412
			
			//Added aginst ML-MMOH-CRF-0679 Starts here
			if (diettypeold.equals(dType.trim())){
				pstmt.setString(42,"");
			}else{
				pstmt.setString(42,diettypeold);
			}
			//Added aginst ML-MMOH-CRF-0679 Ends here
            pstmt.setString(43,menu_type);//CRF-684         
			pstmt.setString(44, addedFacilityId);
			pstmt.setString(45, encounterId);
			pstmt.setLong(46, pi);          			
			}else{
			pstmt.setString(40, atndInstr);
			pstmt.setString(41,DietTypeModified_YN);//MMS-DM-0006
			pstmt.setString(42,texture_of_diet);//ML-MMOH-CRF-412

			//Added aginst ML-MMOH-CRF-0679 Starts here
			if (diettypeold.equals(dType.trim())){
				pstmt.setString(43,"");
			}else{
				pstmt.setString(43,diettypeold);
			}
			//Added aginst ML-MMOH-CRF-0679 Ends here
            pstmt.setString(44,menu_type);//CRF-684	
			pstmt.setString(45, addedFacilityId);
			pstmt.setString(46, encounterId);
			pstmt.setLong(47, pi);
			}
			//SCF-735
			flag = pstmt.executeUpdate();
			if(flag != 0){
				System.out.println("flag is not zero in update HDR table");
				conn.commit();
			}else{
				System.out.println("flag is zero in update HDR table");
				conn.rollback();
			}
			pstmt.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
				System.out.println("2641, Place Diet Order Servlet ==> "+e);
			}
			if(rsentry!=null) rsentry.close(); //Common-ICN-0054
			}
			catch(Exception e)
			{
				e.printStackTrace();
				System.out.println("2616, Place Diet Order Servlet ==> "+e);
			}
			/*
			 * Updating the dietician flag in DS_EPSD_DIETICIAN_REFERRAL
			 */
			updateDieticianRefferal(request,dieticianReferral,addedFacilityId,addedAtWsNo,addedById,encounterId,patientClass,patientId);
			updateOldOrders(request,pi);
		}
		/**
		 * Inserting into the DS_EPSD_DIET_PROFILE_DTL table based on the mealTypeForDietType
		 */
		if(mealTypesForDietType != null && !mealTypesForDietType.equals("") && viewCode != null && !(viewCode.equals(""))){			
			int flag;
           //Commented Against Ams-CRf-0112
		   try{ //Added try-catch against ML-MMOH-SCF-1864
			String dietProfileDtl = "insert into DS_EPSD_DIET_PROFILE_DTL (PATIENT_CLASS, DIET_TYPE, MEAL_CLASS, FEED_TYPE, DELIVERY_CODE, SERVING_TIME, SERVING_FREQ, PERIOD_BET_SERVINGS, MEAL_PLAN_CREATED_YN, MEAL_PLAN_CREATED_DATE, MEAL_PLAN_REF_DATE, MEAL_PLAN_REF_DAY_NO, ADDED_BY_ID, ADDED_DATE, ADDED_FACILITY_ID, ADDED_AT_WS_NO, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_FACILITY_ID, MODIFIED_AT_WS_NO, ORDER_ID, ORDER_LINE_NUM, OPERATING_FACILITY_ID, ENCOUNTER_ID, PROFILE_SL, MEAL_TYPE,DISCHARGE_FLAG_YN,IRREGULAR_FLAG_YN) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?)";//409
			//Modified Against Ams-CRf-0112
			/*String dietProfileDtl = "insert into DS_EPSD_DIET_PROFILE_DTL (PATIENT_CLASS, DIET_TYPE, MEAL_CLASS, FEED_TYPE, DELIVERY_CODE, SERVING_TIME, SERVING_FREQ, PERIOD_BET_SERVINGS, MEAL_PLAN_CREATED_YN, MEAL_PLAN_CREATED_DATE, MEAL_PLAN_REF_DATE, MEAL_PLAN_REF_DAY_NO, ADDED_BY_ID, ADDED_DATE, ADDED_FACILITY_ID, ADDED_AT_WS_NO, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_FACILITY_ID, MODIFIED_AT_WS_NO, ORDER_ID, ORDER_LINE_NUM, OPERATING_FACILITY_ID, ENCOUNTER_ID, PROFILE_SL, MEAL_TYPE,DISCHARGE_FLAG_YN,IRREGULAR_FLAG_YN,MEAL_ADDITIONAL_INSTRUCTION) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?,?)";*/
			pstmt = conn.prepareStatement(dietProfileDtl);

			for(int i=0; i<mealTypesForDietType.length; i++){				
				if(irregular_meal_code.contains(mealTypesForDietType[i].trim())){
					irregular_flag="Y";					
				}else{
					irregular_flag="N";					
				}
				
				pstmt.setString(1, patientClass);
				pstmt.setString(2, dietTypesforMealType[i].trim());
				pstmt.setString(3, mClass);
				pstmt.setString(4, feedType);
				pstmt.setString(5, dsDeliveryInstr);
				pstmt.setString(6, null);
				pstmt.setLong(7, servingFreq);
				pstmt.setString(8, null);
				pstmt.setString(9, null);
				pstmt.setString(10, null);
				pstmt.setString(11, null);
				pstmt.setString(12, null);
				pstmt.setString(13, addedById);
				pstmt.setTimestamp(14, getCurrentTimeStamp());
				pstmt.setString(15, addedFacilityId);
				pstmt.setString(16, addedAtWsNo);
				pstmt.setString(17, addedById);
				pstmt.setTimestamp(18, getCurrentTimeStamp());
				pstmt.setString(19, addedFacilityId);
				pstmt.setString(20, addedAtWsNo);
				pstmt.setString(21, viewCode);
				pstmt.setLong(22, new Long(1L));
				pstmt.setString(23, addedFacilityId);
				pstmt.setString(24, encounterId);
				pstmt.setLong(25, pi);
				pstmt.setString(26, mealTypesForDietType[i].trim());
				pstmt.setString(27, disChargeflag);
				pstmt.setString(28,irregular_flag);//409
				flag = pstmt.executeUpdate();
				if(flag != 0){
					System.out.println("flag1 is not zero");
					conn.commit();
				}else{
					System.out.println("flag1 is zero");
					conn.rollback();
				}
			}
			pstmt.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
				System.out.println("2685, Place Diet Order Servlet ==> "+e);
			}
		}
		else if(mealTypesForDietType != null && !mealTypesForDietType.equals("") && disChargeflag == ""){
			int flag;
			//String mealTypesList=""; //Common-ICN-0055
			
			//Added aginst ML-MMOH-CRF-0679 Starts here
			LinkedHashMap<String,String> Modifieddiettypecode1=new LinkedHashMap<String,String>();  	
			LinkedHashMap<String,String> diettypeold1=new LinkedHashMap<String,String>();  	
			String dietProfileHdrUpdSelect="select MODIFIED_DIET_TYPE_CODE,DIET_TYPE,MEAL_TYPE from DS_EPSD_DIET_PROFILE_DTL  where OPERATING_FACILITY_ID='"+addedFacilityId+"' and ENCOUNTER_ID='"+encounterId+"'  and PROFILE_SL='"+pi+"'";
		
			PreparedStatement pstmtNew=null;
			pstmtNew = conn.prepareStatement(dietProfileHdrUpdSelect);
			ResultSet rsentry=pstmtNew.executeQuery();
			while(rsentry != null && rsentry.next())
			{			
				Modifieddiettypecode1.put(rsentry.getString(3),rsentry.getString(1));
				diettypeold1.put(rsentry.getString(3),rsentry.getString(2));			
			}			
			//Added aginst ML-MMOH-CRF-0679 Ends here

			//IN:40900 - start
			String dietProfileDtlDel = "Delete from DS_EPSD_DIET_PROFILE_DTL where OPERATING_FACILITY_ID=? and ENCOUNTER_ID=? and PROFILE_SL=?";
			pstmt = conn.prepareStatement(dietProfileDtlDel);
			pstmt.setString(1, addedFacilityId);
			pstmt.setString(2, encounterId);
			pstmt.setLong(3, pi);

			int delflag = pstmt.executeUpdate();
			if(delflag  != 0){
				System.out.println("flag1 is not zero in delete DTL table ===== 2263");
				conn.commit();
			}else{
				System.out.println("flag1 is zero in delete DTL table ===== 2266");
				conn.rollback();
			}

			String orderidQuery = "SELECT order_id from DS_EPSD_DIET_PROFILE_HDR where OPERATING_FACILITY_ID=? and ENCOUNTER_ID=? and PROFILE_SL=?";
			String orderid = "";
			pstmt = conn.prepareStatement(orderidQuery);
			pstmt.setString(1, addedFacilityId);
			pstmt.setString(2, encounterId);
			pstmt.setLong(3, pi);
			rs = pstmt.executeQuery();
			while(rs != null && rs.next()){
				 orderid = rs.getString(1);
			}
			try{ //Added try-catch against ML-MMOH-SCF-1864
            //Commented Against AMS-CRF-0112
			String dietProfileDtlUpd = "insert into DS_EPSD_DIET_PROFILE_DTL(PATIENT_CLASS, DIET_TYPE, MEAL_CLASS, FEED_TYPE, DELIVERY_CODE, SERVING_TIME, SERVING_FREQ, PERIOD_BET_SERVINGS, MEAL_PLAN_CREATED_YN, MEAL_PLAN_CREATED_DATE, MEAL_PLAN_REF_DATE, MEAL_PLAN_REF_DAY_NO, ADDED_BY_ID, ADDED_DATE, ADDED_FACILITY_ID, ADDED_AT_WS_NO, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_FACILITY_ID, MODIFIED_AT_WS_NO, ORDER_ID, ORDER_LINE_NUM, OPERATING_FACILITY_ID, ENCOUNTER_ID, PROFILE_SL, MEAL_TYPE,DISCHARGE_FLAG_YN,IRREGULAR_FLAG_YN,MODIFIED_DIET_TYPE_CODE) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?,?)";//409
			/*String dietProfileDtlUpd = "insert into DS_EPSD_DIET_PROFILE_DTL(PATIENT_CLASS, DIET_TYPE, MEAL_CLASS, FEED_TYPE, DELIVERY_CODE, SERVING_TIME, SERVING_FREQ, PERIOD_BET_SERVINGS, MEAL_PLAN_CREATED_YN, MEAL_PLAN_CREATED_DATE, MEAL_PLAN_REF_DATE, MEAL_PLAN_REF_DAY_NO, ADDED_BY_ID, ADDED_DATE, ADDED_FACILITY_ID, ADDED_AT_WS_NO, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_FACILITY_ID, MODIFIED_AT_WS_NO, ORDER_ID, ORDER_LINE_NUM, OPERATING_FACILITY_ID, ENCOUNTER_ID, PROFILE_SL, MEAL_TYPE,DISCHARGE_FLAG_YN,IRREGULAR_FLAG_YN,MEAL_ADDITIONAL_INSTRUCTION) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?,?)";*///Added Against AMS-CRF-0112
			
			pstmt = conn.prepareStatement(dietProfileDtlUpd);

			for(int i=0; i<mealTypesForDietType.length; i++){
				//409
				if(irregular_meal_code.contains(mealTypesForDietType[i].trim())){
					irregular_flag="Y";					
				}else{
					irregular_flag="N";					
				}
				//409
				
				pstmt.setString(1, patientClass);
				pstmt.setString(2, dietTypesforMealType[i].trim());
				pstmt.setString(3, mClass);
				pstmt.setString(4, feedType);
				pstmt.setString(5, dsDeliveryInstr);
				pstmt.setString(6, null);
				pstmt.setLong(7, servingFreq);
				pstmt.setString(8, null);
				pstmt.setString(9, null);
				pstmt.setString(10, null);
				pstmt.setString(11, null);
				pstmt.setString(12, null);
				pstmt.setString(13, addedById);
				pstmt.setTimestamp(14, getCurrentTimeStamp());
				pstmt.setString(15, addedFacilityId);
				pstmt.setString(16, addedAtWsNo);
				pstmt.setString(17, addedById);
				pstmt.setTimestamp(18, getCurrentTimeStamp());
				pstmt.setString(19, addedFacilityId);
				pstmt.setString(20, addedAtWsNo);
				pstmt.setString(21, orderid); //orderid
				pstmt.setLong(22, new Long(1L)); //orderlinenumber
				pstmt.setString(23, addedFacilityId);
				pstmt.setString(24, encounterId);
				pstmt.setLong(25, pi);
				pstmt.setString(26, mealTypesForDietType[i].trim());
				pstmt.setString(27, disChargeflag);
				pstmt.setString(28,irregular_flag);//409
					
			//Added aginst ML-MMOH-CRF-0679 Starts here
			String tempModifieddiet="";
			String tempdiettype="";
			tempdiettype=CommonBean.checkForNull(diettypeold1.get(mealTypesForDietType[i].trim()));
			tempModifieddiet=CommonBean.checkForNull(Modifieddiettypecode1.get(mealTypesForDietType[i].trim()));

			if (dietTypesforMealType[i].trim().equals(tempdiettype)){			
			if(tempModifieddiet.equals("") || tempModifieddiet.equals(null) ||			tempModifieddiet.equals("null"))
				pstmt.setString(29,"");
			else
				pstmt.setString(29,tempModifieddiet);
			}else{			
				pstmt.setString(29,tempdiettype);
			}			
			//Added aginst ML-MMOH-CRF-0679 Ends here
				
			flag = pstmt.executeUpdate();
			if(flag != 0){
				System.out.println("flag1 is not zero in update DTL table");
				conn.commit();
			}else{
				System.out.println("flag1 is zero in update DTL table");
				conn.rollback();
			}
			}//IN:40900 - end
			if(pstmt !=null)pstmt.close();
			if(rsentry !=null)rsentry.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
				System.out.println("2470, Place Diet Order Servlet ==> "+e);
			}
		}else if(mealTypesForDietType != null && !mealTypesForDietType.equals("") && disChargeflag != null && disChargeflag != ""){
			int flag;
			try{
				String delMealType = "delete from DS_EPSD_DIET_PROFILE_DTL where encounter_id = '"+encounterId+"' and profile_sl = '"+pi+"' and OPERATING_FACILITY_ID = '"+addedFacilityId+"'";
				pstmt = conn.prepareStatement(delMealType);
				flag = pstmt.executeUpdate();
				if(flag != 0){
					System.out.println("flag1 is not zero in delete DTL table =====  2360");
					conn.commit();
				}else{
					System.out.println("flag1 is zero in delete DTL table ========== 2363");
					conn.rollback();
				}
				if(pstmt !=null)pstmt.close();
				try{ //Added try-catch against ML-MMOH-SCF-1864
				String mealTypeIns = "insert into DS_EPSD_DIET_PROFILE_DTL (PATIENT_CLASS, DIET_TYPE, MEAL_CLASS, FEED_TYPE, DELIVERY_CODE, SERVING_TIME, SERVING_FREQ, PERIOD_BET_SERVINGS, MEAL_PLAN_CREATED_YN, MEAL_PLAN_CREATED_DATE, MEAL_PLAN_REF_DATE, MEAL_PLAN_REF_DAY_NO, ADDED_BY_ID, ADDED_DATE, ADDED_FACILITY_ID, ADDED_AT_WS_NO, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_FACILITY_ID, MODIFIED_AT_WS_NO, ORDER_ID, ORDER_LINE_NUM, OPERATING_FACILITY_ID, ENCOUNTER_ID, PROFILE_SL, MEAL_TYPE,DISCHARGE_FLAG_YN,IRREGULAR_FLAG_YN) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?)";//409
				pstmt = conn.prepareStatement(mealTypeIns);
				for(int c = 0; c < mealTypesForDietType.length; c++){
					
					//409
					if(irregular_meal_code.contains(mealTypesForDietType[c].trim())){
						irregular_flag="Y";						
					}else{
						irregular_flag="N";						
					}
					//409
					
					pstmt.setString(1, patientClass);
					pstmt.setString(2, dietTypesforMealType[c].trim());
					pstmt.setString(3, mClass);
					pstmt.setString(4, feedType);
					pstmt.setString(5, dsDeliveryInstr);
					pstmt.setString(6, null);
					pstmt.setLong(7, servingFreq);
					pstmt.setString(8, null);
					pstmt.setString(9, null);
					pstmt.setString(10, null);
					pstmt.setString(11, null);
					pstmt.setString(12, null);
					pstmt.setString(13, addedById);
					pstmt.setTimestamp(14, getCurrentTimeStamp());
					pstmt.setString(15, addedFacilityId);
					pstmt.setString(16, addedAtWsNo);
					pstmt.setString(17, addedById);
					pstmt.setTimestamp(18, getCurrentTimeStamp());
					pstmt.setString(19, addedFacilityId);
					pstmt.setString(20, addedAtWsNo);
					pstmt.setString(21, viewCode);
					pstmt.setLong(22, new Long(1L));
					pstmt.setString(23, addedFacilityId);
					pstmt.setString(24, encounterId);
					pstmt.setLong(25, pi);
					pstmt.setString(26, mealTypesForDietType[c].trim());
					pstmt.setString(27, disChargeflag);
					pstmt.setString(28,irregular_flag);//409
					flag = pstmt.executeUpdate();
					if(flag != 0){
						System.out.println("flag1 is not zero in disChargeflag Insertiion");
						conn.commit();
					}else{
						System.out.println("flag1 is zero in disChargeflag Insertiion");
						conn.rollback();
					}
				}
				if(pstmt!=null) pstmt.close();
				}
			catch(Exception e)
			{
				e.printStackTrace();
				System.out.println("2880, Place Diet Order Servlet ==> "+e);
			}
			}
			catch(Exception e){
				e.printStackTrace();
			}
			finally{
				pstmt.close();
			}
		}
		ordersList = fecthMealContents(addedFacilityId,encounterId,request);
		//IN::39937 - Start
		if(attDietList.length > 0 && attDietList[0].trim()!= "")
		{
			int flag = 1;
			
		//Added Against MMS-DM-SCF-0413 Starts Here			
		  String currentdate_attn= new SimpleDateFormat("dd/MM/yyyy").format(new java.util.Date());        
		  String attendant_query_update="UPDATE ds_epsd_diet_profile_att SET status = 'C' WHERE encounter_id = '"+encounterId+"' AND period_from <= TO_DATE ('"+currentdate_attn+"', 'DD/MM/YYYY')";		  
        //Added Against MMS-DM-SCF-0413 Ends Here				
				
			long attendentID = 0;
			int StartPos = 0;
			String attendant_query = "INSERT INTO DS_EPSD_DIET_PROFILE_ATT(OPERATING_FACILITY_ID,PATIENT_CLASS,ENCOUNTER_ID,PROFILE_SL,ORDER_ID,ORDER_LINE_NO,ATTENDENT_SRL,PERIOD_FROM,PERIOD_TO,DIET_TYPE,MEAL_CLASS,ADDED_BY_ID,ADDED_DATE,ADDED_FACILITY_ID,ADDED_AT_WS_NO,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_FACILITY_ID,MODIFIED_AT_WS_NO,MENU_TYPE) VALUES(?, ?, ?, ?, ?, ?, ?, to_date(?,'dd/mm/yyyy'), to_date(?,'dd/mm/yyyy'), ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?)";//CRF-684
			String attDietsubList[] = null;
			attDietsubList = attDietList[StartPos].split(",");
			int nRowCount = 0;
			//pstmt = conn.prepareStatement(attendant_query);//Commented  against SCF-0413
			//Getting the Starting position to traverse the 2 dimensional array
			while(StartPos < attDietsubList.length)
			{
				if(!("".equals(attDietsubList[StartPos].trim())) )
				{
					break;
				}
				else
					StartPos++;
			}

			nRowCount = StartPos;
			//Traversing the attDietsubList array to get the attendant details:

			String Delattd_query = "Delete from DS_EPSD_DIET_PROFILE_ATT where OPERATING_FACILITY_ID =? AND ENCOUNTER_ID=? AND PROFILE_SL = ? AND ATTENDENT_SRL =?";
			pstmtForDel = conn.prepareStatement(Delattd_query);
			//Added Against SCF-0413 starts Here			
			if(viewCode != null && !(viewCode.equals("")))
			{
			pstmt = conn.prepareStatement(attendant_query_update);
		    pstmt.executeUpdate();
			}
			pstmt = conn.prepareStatement(attendant_query);
			//Added Against SCF-0413 Ends Here
			while(nRowCount < attDietsubList.length && !("".equals(attDietsubList[nRowCount])) )
			{
				int nRowCount_FrmDate = nRowCount;
				int nRowCount_ToDate = nRowCount + 1;
				int nRowCount_Diet = nRowCount + 2;
				int nRowCount_MealClass = nRowCount + 3;
				int nRowCount_pfsl = nRowCount + 4;
				int nRowCount_dsl = nRowCount + 5;
				int nRowCount_attdsl = nRowCount + 6;

				if("-1".equalsIgnoreCase(attDietsubList[nRowCount_dsl]))
				{
					if(attDietsubList[nRowCount_attdsl] != "")
					{
						pstmtForDel.setString(1,addedFacilityId.trim());
						pstmtForDel.setString(2,encounterId);
						pstmtForDel.setLong(3,pi);
						pstmtForDel.setString(4,attDietsubList[nRowCount_attdsl]); //052895
						pstmtForDel.executeUpdate();
					}
					nRowCount = nRowCount + 7;
					continue;
				}
				else if((isNEW != null && !(isNEW.equalsIgnoreCase("true"))) && ("99".equalsIgnoreCase(attDietsubList[nRowCount_dsl]))) {
					nRowCount = nRowCount + 7;
					continue;
				}
				pstmt.setString(1, addedFacilityId.trim());
				pstmt.setString(2, patientClass);
				pstmt.setLong(3, Long.parseLong(encounterId));
				pstmt.setLong(4, pi);

				if(pi == null || attDietsubList[nRowCount_pfsl].equals(new Long(0L))){
					attendentID++;
					if(attendentID < 10L){
                        pstmt.setString(5, "ATT00" +attendentID);
					}else if(attendentID < 100L){
						pstmt.setString(5, "ATT0" +attendentID);
					}else{
                        pstmt.setString(5, "ATT" +attendentID);
					}
				}
				else {
					attendentID++;
					if(pi < 10L){
						pstmt.setString(5,"ATT00" +attendentID);
					}else if(pi < 100L){
                    	pstmt.setString(5, "ATT0" +attendentID);
					}else{
                    	pstmt.setString(5, "ATT" +attendentID);
					}
				}
				pstmt.setLong(6, new Long(1L));
				pstmt.setLong(7, Long.parseLong(attDietsubList[nRowCount_attdsl].trim())); //IN::39937
				attDietsubList[nRowCount_FrmDate] = com.ehis.util.DateUtils.convertDate(attDietsubList[nRowCount_FrmDate].trim(),"DMY", language_id,"en");
				pstmt.setString(8, attDietsubList[nRowCount_FrmDate].trim());
				attDietsubList[nRowCount_ToDate] = com.ehis.util.DateUtils.convertDate(attDietsubList[nRowCount_ToDate].trim(),"DMY", language_id,"en");
				if(attDietsubList[nRowCount_ToDate] != null && !attDietsubList[nRowCount_ToDate].equals("")){
					pstmt.setString(9, attDietsubList[nRowCount_ToDate].trim());
				}else{
					pstmt.setString(9, ""); //IN:39937
				}
				pstmt.setString(10, attDietsubList[nRowCount_Diet].trim());
				pstmt.setString(11, attDietsubList[nRowCount_MealClass].trim());
				pstmt.setString(12, addedById);
				pstmt.setTimestamp(13, getCurrentTimeStamp());
				pstmt.setString(14, addedFacilityId);
				pstmt.setString(15, addedAtWsNo);
				pstmt.setString(16, addedById);
				pstmt.setTimestamp(17, getCurrentTimeStamp());
				pstmt.setString(18, addedFacilityId);
				pstmt.setString(19, addedAtWsNo);
				pstmt.setString(20, menu_type);//CRF-684

				flag = pstmt.executeUpdate();
				if(flag == 0){
					break;
				}
				nRowCount = nRowCount + 7;
			}
				if(flag != 0){
					conn.commit();
				}else{
					conn.rollback();
				}
				pstmt.close();
				if(pstmtForDel!=null) pstmtForDel.close();
				//conn1.close();

		}//IN::39937 - End
		/*
		 * Food DisLike
		 */
		if(fudDisListArr != null && !fudDisListArr.equals("")){
			//int cnt = 0; //Common-ICN-0055
			int flag;
			String query_all = "DELETE FROM DS_PATIENT_FOOD_DISLIKES WHERE PATIENT_ID = '"+patientId+"'";
			pstmt = conn.prepareStatement(query_all);
			flag = pstmt.executeUpdate();
			if(flag != 0){
				System.out.println("flag1 is not zero in delete DS_PATIENT_FOOD_DISLIKES table");
				conn.commit();
			}else{
				System.out.println("flag1 is zero in delete DS_PATIENT_FOOD_DISLIKES table");
				conn.rollback();
			}
			String fudDisLike_insQuery = "insert into DS_PATIENT_FOOD_DISLIKES (ADDED_BY_ID, ADDED_DATE, ADDED_FACILITY_ID, ADDED_AT_WS_NO, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_FACILITY_ID, MODIFIED_AT_WS_NO, PATIENT_ID, ITEM_CODE) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(fudDisLike_insQuery);

			for(int i = 0; i < fudDisListArr.length;){
				pstmt.setString(1, addedById);
				pstmt.setTimestamp(2, getCurrentTimeStamp());
				pstmt.setString(3, addedFacilityId);
				pstmt.setString(4, addedAtWsNo);
				pstmt.setString(5, addedById);
				pstmt.setTimestamp(6, getCurrentTimeStamp());
				pstmt.setString(7, addedFacilityId);
				pstmt.setString(8, addedAtWsNo);
				pstmt.setString(9, patientId);
				pstmt.setString(10, fudDisListArr[i].trim());
				flag = pstmt.executeUpdate();
				if(flag != 0){
					System.out.println("Flag is not zero in insert");
					conn.commit();
				}else{
					System.out.println("Flag is zero in insert");
					conn.rollback();
				}
				i = i+3;
				}
				if(pstmt!=null) pstmt.close();
				pstmt.close();

		}
		String fudDisLike_delQuery = "delete from DS_PATIENT_FOOD_DISLIKES where PATIENT_ID=? and ITEM_CODE=?";
		pstmt = conn.prepareStatement(fudDisLike_delQuery);
		if(delFoodDisArr != null && !delFoodDisArr.equals("")){
			for(int i = 0; i < delFoodDisArr.length;i++){//57407
				pstmt.setString(1,patientId);
				pstmt.setString(2,delFoodDisArr[i].trim());

				int flag = pstmt.executeUpdate();
				if(flag != 0){
					System.out.println("flag1 is not zero in delete1 DS_PATIENT_FOOD_DISLIKES table");
					conn.commit();
				}else{
					System.out.println("flag1 is zero in delete1 DS_PATIENT_FOOD_DISLIKES table");
					conn.rollback();
				}
			}
		}
		if(pstmt!=null) pstmt.close();

		//NutrientSupplement list INC 41450
		if(nutrientDeleteFlag.equals("Y") || (nutrientSuppList != null && !nutrientSuppList.equals(""))) {
			int flag;
			//String item_SL = null; //Common-ICN-0055
			String del_query = "delete from ds_epsd_diet_profile_suppl where encounter_id='"+encounterId+"' and profile_sl='"+pi+"'";
			pstmt = conn.prepareStatement(del_query);
			flag = pstmt.executeUpdate();
			if(flag != 0){
				System.out.println("flag1 is not zero in delete ds_epsd_diet_profile_suppl table");
				conn.commit();
			}else{
				System.out.println("flag1 is zero in delete ds_epsd_diet_profile_suppl table");
				conn.rollback();
			}
		}

		if(nutrientSuppList != null && !nutrientSuppList.equals("")){
			int flag;
			String item_SL = null;
			for(int k = 0; k < nutrientSuppList.length;){
				if(!nutrientSuppList[k].equals("")){
					nutrientSuppList[k] = com.ehis.util.DateUtils.convertDate(nutrientSuppList[k].trim(),"DMY", language_id,"en");
					nutrientSuppList[k+1] = com.ehis.util.DateUtils.convertDate(nutrientSuppList[k+1].trim(),"DMY", language_id,"en");
					String nutrient_query = "insert into DS_EPSD_DIET_PROFILE_SUPPL (PATIENT_CLASS, SERVING_START_TIME, SERVING_END_TIME, MEAL_TYPE, ITEM_TYPE, ITEM_CODE, ITEM_QTY, ITEM_CHARGE, CHARGE_ITEM, MEAL_PLAN_CREATED_YN, MEAL_PLAN_CREATED_DATE, MEAL_PLAN_REF_DATE, MEAL_PLAN_REF_DAY_NO, ADDED_BY_ID, ADDED_DATE, ADDED_FACILITY_ID, ADDED_AT_WS_NO, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_FACILITY_ID, MODIFIED_AT_WS_NO, OPERATING_FACILITY_ID, ENCOUNTER_ID, PROFILE_SL, ITEM_SL) values (?, to_date('"+nutrientSuppList[k].trim()+"','dd/mm/yyyy'), to_date('"+nutrientSuppList[k+1].trim()+"','dd/mm/yyyy'), ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
					String nutQuery = "select MAX(item_sl) from ds_epsd_diet_profile_suppl where encounter_id = '"+encounterId+"'";
					pstmt = conn.prepareStatement(nutQuery);
					rs = pstmt.executeQuery();
					if(rs != null && rs.next()){
						item_SL = rs.getString(1);
					}
					pstmt = conn.prepareStatement(nutrient_query);
					pstmt.setString(1, patientClass);
					pstmt.setString(2, nutrientSuppList[k+5].trim());
					pstmt.setString(3, nutrientSuppList[k+2].trim());
					pstmt.setString(4, nutrientSuppList[k+3].trim());
					pstmt.setString(5, nutrientSuppList[k+4].trim());
					pstmt.setString(6, "");
					pstmt.setString(7, "");
					pstmt.setString(8, "");
					pstmt.setString(9, "");
					pstmt.setString(10, "");
					pstmt.setString(11, "");
					pstmt.setString(12, addedById);
					pstmt.setTimestamp(13, getCurrentTimeStamp());
					pstmt.setString(14, addedFacilityId);
					pstmt.setString(15, addedAtWsNo);
					pstmt.setString(16, addedById);
					pstmt.setTimestamp(17, getCurrentTimeStamp());
					pstmt.setString(18, addedFacilityId);
					pstmt.setString(19, addedAtWsNo);
					pstmt.setString(20, addedFacilityId);
					pstmt.setString(21, encounterId);
					pstmt.setLong(22, pi);
					if(item_SL == null || item_SL.equals("")){
						if(nutrientSuppList[k+6] == null || nutrientSuppList[k+6].equals("0")){
							item_SL = nutrientSuppList[k+6];
							Long itemSL = Long.parseLong(item_SL);
							pstmt.setLong(23, ++itemSL);
						}else{
							item_SL = nutrientSuppList[k+6].trim();
							Long itemSL = Long.parseLong(item_SL);
							pstmt.setLong(23, itemSL);
						}
					}else{
						Long itemSL = Long.parseLong(item_SL);
						pstmt.setLong(23, ++itemSL);
					}
					flag = pstmt.executeUpdate();
					if(flag != 0){
						System.out.println("Flag is not zero in  nutrientSuppList insert");
						conn.commit();
					}else{
						System.out.println("Flag is zero in nutrientSuppList insert");
						conn.rollback();
					}
					k = k+7;
					if(pstmt!=null) pstmt.close(); //Common-ICN-0053
					if(rs!=null) rs.close(); //Common-ICN-0054
				}else{
					k = k+1;
				}
			}
		}
		excludeMeals(addedFacilityId,encounterId,pi,exclusionsObj,request);
		}
			// AAKH-CRF-0065 start
			/*
			if((isNEW != null && isNEW.equalsIgnoreCase("true")))
			{
				updateMealMenuItems(request, response);
			}
			*/
			if(updateMealsDetailsList != null)
			{
				updateMealMenuItems(request, response, updateMealsDetailsList, pi);
			}
			session.removeAttribute("ALLMENUITEMSMAP");
			// AAKH-CRF-0065 end
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Excetion after the try block end-------->"+e.getMessage());
			if (P_Error_Text != null)
			{
				//("Caught Exception in DairyScheduleForSuregonQueryResult.jsp "+e);
			}
		}
		finally
		{
			if(conn!=null)ConnectionManager.returnConnection(conn,request);
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			if(cstmt!=null) cstmt.close();
			if(pstmtForDel!=null) pstmtForDel.close();
			
		}
		return ordersList;
	}

	//CRF-410-Starts
	//private void insertFullNBMprofile(HttpServletRequest request,Connection conn) {
		private String insertFullNBMprofile(HttpServletRequest request) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement psmt=null;
		String result="N";
		try{
			conn=ConnectionManager.getConnection(request);
			
			String encounterId = request.getParameter("encounterId");
			String addedById = request.getParameter("addedById");
			/* String addedFacilityId = request.getParameter("addedFacilityId"); 
			String profileSL = request.getParameter("profileSL");
			String patientId = request.getParameter("patientId");
			String patientClass = request.getParameter("patientClass");	 */ //Common-ICN-0055
			String maxprofileSL = request.getParameter("maxprofileSL");
			Long pi = Long.parseLong(maxprofileSL);		
			String addedAtWsNo = request.getParameter("addedAtWsNo");
			String full_day_nbm_yn=request.getParameter("Full_Day_NBM_YN");
			String nbm_from_date=request.getParameter("from");
			String nbm_to_date=request.getParameter("to");
			String nbmstatus=request.getParameter("nbmstatus");
			String language_id = (String)session.getAttribute("LOCALE");
			
			nbm_from_date = com.ehis.util.DateUtils.convertDate(request.getParameter("from"),"DMYHM", language_id, "en");
			nbm_to_date = com.ehis.util.DateUtils.convertDate(request.getParameter("to"),"DMYHM", language_id, "en");			
			
			StringBuffer nbm_query=new StringBuffer();
			nbm_query.append("	insert into DS_EPSD_NBM_PROFILE	(	");
			nbm_query.append("	OPERATING_FACILITY_ID,ENCOUNTER_ID,PROFILE_SL,FULL_DAY_NBM_YN,NIL_BY_MOUTH_FRM,NIL_BY_MOUTH_TO,STATUS,	");
			nbm_query.append("	ADDED_BY_ID,ADDED_DATE,ADDED_FACILITY_ID,ADDED_AT_WS_NO,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_FACILITY_ID,MODIFIED_AT_WS_NO	)	");
			nbm_query.append("	values	");
			nbm_query.append("	(	");
			//nbm_query.append("	?,?,?,?,to_date(?,'dd/mm/yyyy HH24:MI'),to_date(?,'dd/mm/yyyy HH24:MI'),?,?,sysdate,?,?,?,sysdate,?,?	");
			nbm_query.append("	?,?,?,?,to_date(?,'dd/mm/yyyy HH24:MI'),to_date(?,'dd/mm/yyyy HH24:MI'),?,?,?,?,?,?,?,?,?	");
			nbm_query.append("	)	");
			
			psmt=conn.prepareStatement(nbm_query.toString());
			int index=0;
			
			psmt.setString(++index,facility_id);			
			psmt.setString(++index,encounterId);
			psmt.setLong(++index,++pi);
			psmt.setString(++index,full_day_nbm_yn);
			psmt.setString(++index,nbm_from_date);
			psmt.setString(++index,nbm_to_date);
			psmt.setString(++index,nbmstatus);
			psmt.setString(++index,addedById);
			psmt.setTimestamp(++index,getCurrentTimeStamp());//15-Dec
			psmt.setString(++index,facility_id);
			psmt.setString(++index,addedAtWsNo);
			psmt.setString(++index,addedById);
			psmt.setTimestamp(++index,getCurrentTimeStamp());//15-Dec
			psmt.setString(++index,facility_id);
			psmt.setString(++index,addedAtWsNo);
			
			int a=psmt.executeUpdate();
			if(a>0){
			conn.commit();
			result="Y";
			}else{
				conn.rollback();
				result="N";
			}	
			if(psmt!=null) psmt.close(); //Common-ICN-0053			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(conn!=null)ConnectionManager.returnConnection(conn,request);
		}
		return result;
	}
	
	public String updateNBMProfile(HttpServletRequest request,HttpServletResponse response){
		String result="";
		Connection con=null;
		PreparedStatement psmt=null;
		try{
			con=ConnectionManager.getConnection(request);
			
			//This function is used to update the fromdate,todate of existing nbm profile
			String encounterId = request.getParameter("encounterId");
			String addedById = request.getParameter("addedById");
			String addedFacilityId = request.getParameter("addedFacilityId");
			String profileSL = request.getParameter("profileSL");
			Long pi = Long.parseLong(profileSL);			
						
			String addedAtWsNo = request.getParameter("addedAtWsNo");
/* 			String full_day_nbm_yn=request.getParameter("Full_Day_NBM_YN");
			String nbmstatus=request.getParameter("nbmstatus");
			String language_id = (String)session.getAttribute("LOCALE"); */ //Common-ICN-0055
			String nbm_from_date=request.getParameter("from");
			String nbm_to_date=request.getParameter("to");
			
			StringBuffer update_NBM_Profile=new StringBuffer();
			update_NBM_Profile.append("	update ds_epsd_nbm_profile set ");
			update_NBM_Profile.append("	NIL_BY_MOUTH_FRM=to_date(?,'dd/mm/yyyy HH24:MI'),NIL_BY_MOUTH_TO=to_date(?,'dd/mm/yyyy HH24:MI'),	");
			update_NBM_Profile.append("	MODIFIED_BY_ID=?,MODIFIED_DATE=sysdate,MODIFIED_FACILITY_ID=?,MODIFIED_AT_WS_NO=?	");
			update_NBM_Profile.append("	where	");
			update_NBM_Profile.append("	ENCOUNTER_ID=? and PROFILE_SL=? and ADDED_FACILITY_ID=?	");
			
			psmt=con.prepareStatement(update_NBM_Profile.toString());
			int index=0;
			
			psmt.setString(++index, nbm_from_date);
			psmt.setString(++index, nbm_to_date);
			psmt.setString(++index, addedById);
			psmt.setString(++index, addedFacilityId);
			psmt.setString(++index, addedAtWsNo);
			psmt.setString(++index, encounterId);
			psmt.setLong(++index, pi);
			psmt.setString(++index, addedFacilityId);
			
			int count=psmt.executeUpdate();
			if(count>0){
				con.commit();
				result="Y";
			}else{
				con.rollback();
				result="N";
			}	
		if(psmt!=null) psmt.close(); //Common-ICN-0053			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(con!=null)ConnectionManager.returnConnection(con,request);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return result;
	}
	
	private String insertAndUpdateNBMProfile(HttpServletRequest request) {
		// TODO Auto-generated method stub
		String result="";
		Connection con=null;
		PreparedStatement psmt=null,update_pmst=null;
		try{
			con=ConnectionManager.getConnection(request);
			String encounterId = request.getParameter("encounterId");
			String addedById = request.getParameter("addedById");
			String addedFacilityId = request.getParameter("addedFacilityId");
			String profileSL = request.getParameter("profileSL");
			String maxprofileSL=request.getParameter("maxprofileSL");
			Long pi = Long.parseLong(maxprofileSL);
			/* String patientId = request.getParameter("patientId");
			String patientClass = request.getParameter("patientClass");	 */		//Common-ICN-0055
			String addedAtWsNo = request.getParameter("addedAtWsNo");
			String full_day_nbm_yn=request.getParameter("Full_Day_NBM_YN");
			String nbm_from_date=request.getParameter("from");
			String nbm_to_date=request.getParameter("to");
			String nbmstatus=request.getParameter("nbmstatus");
			String language_id = (String)session.getAttribute("LOCALE");
			
			nbm_from_date = com.ehis.util.DateUtils.convertDate(request.getParameter("from"),"DMYHM", language_id, "en");
			nbm_to_date = com.ehis.util.DateUtils.convertDate(request.getParameter("to"),"DMYHM", language_id, "en");
			StringBuffer nbm_query=new StringBuffer();
			nbm_query.append("	insert into DS_EPSD_NBM_PROFILE	(	");
			nbm_query.append("	OPERATING_FACILITY_ID,ENCOUNTER_ID,PROFILE_SL,FULL_DAY_NBM_YN,NIL_BY_MOUTH_FRM,NIL_BY_MOUTH_TO,STATUS,	");
			nbm_query.append("	ADDED_BY_ID,ADDED_DATE,ADDED_FACILITY_ID,ADDED_AT_WS_NO,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_FACILITY_ID,MODIFIED_AT_WS_NO	)	");
			nbm_query.append("	values	");
			nbm_query.append("	(	");
			//nbm_query.append("	?,?,?,?,to_date(?,'dd/mm/yyyy HH24:MI'),to_date(?,'dd/mm/yyyy HH24:MI'),?,?,sysdate,?,?,?,sysdate,?,?	");
			nbm_query.append("	?,?,?,?,to_date(?,'dd/mm/yyyy HH24:MI'),to_date(?,'dd/mm/yyyy HH24:MI'),?,?,?,?,?,?,?,?,?	");
			nbm_query.append("	)	");
			
			psmt=con.prepareStatement(nbm_query.toString());
			int index=0;
			
			psmt.setString(++index,facility_id);
			psmt.setString(++index,encounterId);
			psmt.setLong(++index,++pi);
			psmt.setString(++index,full_day_nbm_yn);
			psmt.setString(++index,nbm_from_date);
			psmt.setString(++index,nbm_to_date);
			psmt.setString(++index,nbmstatus);
			psmt.setString(++index,addedById);
			psmt.setTimestamp(++index,getCurrentTimeStamp());//15-Dec
			psmt.setString(++index,facility_id);
			psmt.setString(++index,addedAtWsNo);
			psmt.setString(++index,addedById);
			psmt.setTimestamp(++index,getCurrentTimeStamp());//15-Dec
			psmt.setString(++index,facility_id);
			psmt.setString(++index,addedAtWsNo);
			
			int a=psmt.executeUpdate();
			if(a>0){
				String updateFullNBMToDate="";
				//updateFullNBMToDate = "UPDATE DS_EPSD_NBM_PROFILE set NIL_BY_MOUTH_TO=to_date(?,'dd/mm/yyyy HH24:MI')-1 WHERE (operating_facility_id = '"+addedFacilityId+"') AND (encounter_id = '"+encounterId+"') and (profile_sl="+profileSL+") ";
				updateFullNBMToDate = "UPDATE DS_EPSD_NBM_PROFILE set NIL_BY_MOUTH_TO=TRUNC((to_date(?,'dd/mm/yyyy HH24:MI')-1) + 1) - 1/(24*60*60) WHERE (operating_facility_id = '"+addedFacilityId+"') AND (encounter_id = '"+encounterId+"') and (profile_sl="+profileSL+") ";
				
				update_pmst=con.prepareStatement(updateFullNBMToDate);				
				update_pmst.setString(1,nbm_from_date);
				a=update_pmst.executeUpdate();
				if(a>0){
					result="S";
					con.commit();
				}else{
					result="F";
					con.rollback();
				}				
			}else{
				con.rollback();
				result="N";
			}
			if(psmt!=null) psmt.close(); //Common-ICN-0053
			if(update_pmst!=null) update_pmst.close(); //Common-ICN-0053
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(con!=null){ConnectionManager.returnConnection(con,request);}
		}
		return result;
	}
	//CRF-410-ends
	
	private static java.sql.Timestamp getCurrentTimeStamp() {
	    java.util.Date today = new java.util.Date();
	    return new java.sql.Timestamp(today.getTime());
	}
	private String getDefaultDietYN(String MealCatCode,HttpServletRequest request) throws SQLException{
		Connection conn = ConnectionManager.getConnection(request);
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String defaultDietYn = null;
		try{
			String default_Diet_Type_Query = "select mealcate.default_Diet_Type, mealcate.default_Meal_Class from Ds_Meal_Category mealcate where mealcate.meal_Category_Code ='"+MealCatCode+"'";
			pstmt = conn.prepareStatement(default_Diet_Type_Query);
			rs = pstmt.executeQuery();
			while(rs != null && rs.next()){
				defaultDietYn = rs.getString(1);
			}
		}catch(Exception ee){
			ee.printStackTrace();
			System.err.println("PlaceDietOrderServlet.java--->"+ee.getMessage());
		}finally{
			if(conn!=null)ConnectionManager.returnConnection(conn,request);
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			
		}

		return defaultDietYn;
	}

	private ArrayList<String> fecthMealContents(String facility,String encounterId,HttpServletRequest request) throws SQLException
	{
		ArrayList<String> dietOrderList = new ArrayList<String>();
		Connection conn = ConnectionManager.getConnection(request);
		session = request.getSession(false);
		String language_id = (String)session.getAttribute("LOCALE");
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try
		{
			//String dietOrderQuery = "SELECT dsepsddiet.diet_category,dsepsddiet.meal_class,dsepsddiet.feed_type,dsepsddiet.diet_type,dsepsddiet.dietary_remarks,dsepsddiet.delivery_code,dsepsddiet.patient_class,dsepsddiet.encounter_id,dsepsddiet.profile_sl,TO_CHAR(dsepsddiet.period_from, 'DD/MM/YYYY'),TO_CHAR(dsepsddiet.period_to, 'DD/MM/YYYY'),to_char(dsepsddiet.added_date,'DD/MM/YYYY HH24:MI'),dsepsddiet.status,dsepsddiet.order_id,to_char(dsepsddiet.nil_by_mouth_frm,'DD/MM/YYYY HH24:MI'),to_char(dsepsddiet.nil_by_mouth_to,'DD/MM/YYYY HH24:MI'),dsepsddiet.order_type_code,dsepsddiet.order_id,dsepsddiet.prep_instr,dsepsddiet.ADDED_BY_ID,dsepsddiet.dietician_refrl_yn,dsepsddiet.DISCHARGE_FLAG_YN,dsepsddiet.REMARKS,dsepsddiet.atndnt_instr,dsepsddiet.texture_of_diet texture_of_diet  FROM ds_epsd_diet_profile_hdr dsepsddiet WHERE (dsepsddiet.operating_facility_id = ?) AND (dsepsddiet.encounter_id = ?) order by profile_sl";//ML-MMOH-CRF-412 and Modified Against PMG2013-CRF-0009.1-US001 & [This Query commented Against PMG2013-CRF-0009.1-US001-ALPHA-DS IN:68968]
			
			//CRF-410-starts			
			StringBuffer dietOrderBuffer=new StringBuffer();
			dietOrderBuffer.append("	SELECT   dsepsddiet.diet_category, dsepsddiet.meal_class,	");
			dietOrderBuffer.append("	dsepsddiet.feed_type, dsepsddiet.diet_type,	");
			dietOrderBuffer.append("	dsepsddiet.dietary_remarks, dsepsddiet.delivery_code,	");
			dietOrderBuffer.append("	dsepsddiet.patient_class, dsepsddiet.encounter_id,	");
			dietOrderBuffer.append("	dsepsddiet.profile_sl,	");
			dietOrderBuffer.append("	TO_CHAR (dsepsddiet.period_from, 'DD/MM/YYYY'),	");
			dietOrderBuffer.append("	TO_CHAR (dsepsddiet.period_to, 'DD/MM/YYYY'),	");
			dietOrderBuffer.append("	TO_CHAR (dsepsddiet.added_date, 'DD/MM/YYYY HH24:MI'),	");
			dietOrderBuffer.append("	dsepsddiet.status, dsepsddiet.order_id,	");
			dietOrderBuffer.append("	TO_CHAR (dsepsddiet.nil_by_mouth_frm, 'DD/MM/YYYY HH24:MI'),	");
			dietOrderBuffer.append("	TO_CHAR (dsepsddiet.nil_by_mouth_to, 'DD/MM/YYYY HH24:MI'),	");
			dietOrderBuffer.append("	dsepsddiet.order_type_code, dsepsddiet.order_id,	");
			dietOrderBuffer.append("	dsepsddiet.prep_instr, dsepsddiet.added_by_id,	");
			dietOrderBuffer.append("	dsepsddiet.dietician_refrl_yn, dsepsddiet.discharge_flag_yn,	");
			dietOrderBuffer.append("	dsepsddiet.remarks, dsepsddiet.atndnt_instr,	");
			dietOrderBuffer.append("	dsepsddiet.texture_of_diet texture_of_diet, ");//Added against ML-MMOH-CRF-0684
		    dietOrderBuffer.append("	dsepsddiet.MENU_TYPE menu_type	");//Added against ML-MMOH-CRF-0684
			dietOrderBuffer.append("	FROM ds_epsd_diet_profile_hdr dsepsddiet	");
			dietOrderBuffer.append("	WHERE (dsepsddiet.operating_facility_id = ?)	");
			dietOrderBuffer.append("	AND (dsepsddiet.encounter_id = ?)	");
			//Added Against PMG2013-CRF-0009.1-US001 Starts Here
			dietOrderBuffer.append("	union all	");
			dietOrderBuffer.append("	SELECT   dsepsddiet.diet_category, dsepsddiet.meal_class, ");
			dietOrderBuffer.append("	dsepsddiet.feed_type, dsepsddiet.diet_type,	");
			dietOrderBuffer.append("	dsepsddiet.dietary_remarks, dsepsddiet.delivery_code,	");
			dietOrderBuffer.append("	dsepsddiet.patient_class, dsepsddiet.encounter_id,	");
			dietOrderBuffer.append("	dsepsddiet.profile_sl,	");
			dietOrderBuffer.append("	TO_CHAR (dsepsddiet.period_to + 1, 'DD/MM/YYYY'),	");
			dietOrderBuffer.append("	TO_CHAR (dsepsddiet.actual_todate, 'DD/MM/YYYY'),	");
			dietOrderBuffer.append("	TO_CHAR (dsepsddiet.added_date, 'DD/MM/YYYY HH24:MI'),	");
			dietOrderBuffer.append("	'X' status, dsepsddiet.order_id,	");
			dietOrderBuffer.append("	TO_CHAR (dsepsddiet.nil_by_mouth_frm, 'DD/MM/YYYY HH24:MI'),	");
			dietOrderBuffer.append("	TO_CHAR (dsepsddiet.nil_by_mouth_to, 'DD/MM/YYYY HH24:MI'),	");
			dietOrderBuffer.append("	dsepsddiet.order_type_code, dsepsddiet.order_id,	");
			dietOrderBuffer.append("	dsepsddiet.prep_instr, dsepsddiet.added_by_id,	");
			dietOrderBuffer.append("	dsepsddiet.dietician_refrl_yn, dsepsddiet.discharge_flag_yn,	");
			dietOrderBuffer.append("	dsepsddiet.remarks, dsepsddiet.atndnt_instr,	");
			dietOrderBuffer.append("	dsepsddiet.texture_of_diet texture_of_diet, "); 
		    dietOrderBuffer.append("	dsepsddiet.menu_type menu_type	"); 
			dietOrderBuffer.append("	FROM ds_epsd_diet_profile_hdr dsepsddiet	");
			dietOrderBuffer.append("	WHERE (dsepsddiet.operating_facility_id = ?)	");
			dietOrderBuffer.append("	AND (dsepsddiet.encounter_id = ?)	");     
			dietOrderBuffer.append("	AND (dsepsddiet.actual_todate IS NOT NULL) 	");	
			//Added Against PMG2013-CRF-0009.1-US001 Ends Here
			dietOrderBuffer.append("	union all	");
			dietOrderBuffer.append("	SELECT   'NBM' diet_category, 'NBM' meal_class,	");
			dietOrderBuffer.append("	'NBM' feed_type, 'N/A' diet_type,	");
			dietOrderBuffer.append("	NULL dietary_remarks, NULL delivery_code,	");
			//dietOrderBuffer.append("	patient_class, encounter_id,	");
			dietOrderBuffer.append("	'IP', encounter_id,	");
			dietOrderBuffer.append("	profile_sl profile_sl,	");
			dietOrderBuffer.append("	TO_CHAR (nil_by_mouth_frm, 'DD/MM/YYYY'),	");
			dietOrderBuffer.append("	TO_CHAR (nil_by_mouth_TO, 'DD/MM/YYYY'),	");
			dietOrderBuffer.append("	TO_CHAR (MODIFIED_DATE, 'DD/MM/YYYY HH24:MI'),	");
			dietOrderBuffer.append("	status status, NULL order_id,	");
			dietOrderBuffer.append("	TO_CHAR (nil_by_mouth_frm, 'DD/MM/YYYY HH24:MI'),	");
			dietOrderBuffer.append("	TO_CHAR (nil_by_mouth_TO, 'DD/MM/YYYY HH24:MI'),	");
			dietOrderBuffer.append("	'NBM' order_type_code, NULL order_id,	");
			dietOrderBuffer.append("	NULL prep_instr, MODIFIED_BY_ID,	");
			dietOrderBuffer.append("	NULL dietician_refrl_yn, NULL discharge_flag_yn,	");
			dietOrderBuffer.append("	NULL remarks, NULL atndnt_instr,	");
			dietOrderBuffer.append("	NULL texture_of_diet, ");  //CRF -0684 by Aravindh Anbumani
		    dietOrderBuffer.append("	NULL menu_type	"); //CRF -0684 by Aravindh Anbumani
			dietOrderBuffer.append("	FROM DS_EPSD_NBM_PROFILE dsdietrefer	");
			dietOrderBuffer.append("	WHERE (operating_facility_id = ?)	");
			dietOrderBuffer.append("	AND (encounter_id = ?)	");     
			dietOrderBuffer.append("	ORDER BY profile_sl	");
			
			pstmt = conn.prepareStatement(dietOrderBuffer.toString());
			//Added Against PMG2013-CRF-0009.1-US001 Starts Here
			int index = 0;
			pstmt.setString(++index,facility);
			pstmt.setString(++index,encounterId);
			pstmt.setString(++index,facility);
			pstmt.setString(++index,encounterId);
			pstmt.setString(++index,facility);
			pstmt.setString(++index,encounterId);
			//Added Against PMG2013-CRF-0009.1-US001 Ends Here
			rs = pstmt.executeQuery();
			while(rs != null && rs.next())
			{
				String diet_category = rs.getString(1);
				String meal_class = rs.getString(2);
				String feed_type = rs.getString(3);
				String diet_type = rs.getString(4);
				String dietary_remarks = rs.getString(5); //55310
				if(dietary_remarks != null && dietary_remarks.trim().length() > 0)
					dietary_remarks = dietary_remarks.replaceAll(",", " ");
				String delivery_code = rs.getString(6);
				String patient_class = rs.getString(7);
				String encounter_id = rs.getString(8);
				String profile_sl = rs.getString(9);
				String period_from = rs.getString(10);
				String newFromDate = null;
				if(period_from != null)
					newFromDate = period_from;

				String period_to = rs.getString(11);
				String newToDate = null;

				if(period_to != null)
					newToDate = period_to;
				else
					period_to = "";

				String added_date = rs.getString(12);
				String new_added_date = null;

				if(added_date != null)
					new_added_date =  com.ehis.util.DateUtils.convertDate(added_date,"DMYHM", "en", language_id);

				String status = "";

				if(rs.getString(13) != null && !rs.getString(13).equals(""))
					status = rs.getString(13);
				String todayAsString = new SimpleDateFormat("dd/MM/yyyy").format(new java.util.Date());
				SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
				java.util.Date testFromDate = fmt.parse(newFromDate);
				java.util.Date currentDate = fmt.parse(todayAsString);
				java.util.Date testToDate = null;
				if(newToDate != null)
					testToDate = fmt.parse(newToDate);

				if(status != null && !status.equals("X"))
				{
					if(testToDate != null && testToDate.before(currentDate))
					{
						status = "C";
					}
					else if(testFromDate.after(currentDate))
						status = "F";
					else
						status = "";
				}
				String order_id = rs.getString(14);
				String nil_by_mouth_frm = rs.getString(15);
				if(nil_by_mouth_frm != null && nil_by_mouth_frm != "")
					nil_by_mouth_frm = com.ehis.util.DateUtils.convertDate(nil_by_mouth_frm.substring(0, 16),"DMYHM", "en", language_id);
				else
					nil_by_mouth_frm = rs.getString(15);

				String nil_by_mouth_to = rs.getString(16);

				if(nil_by_mouth_to != null && nil_by_mouth_to != "")
					nil_by_mouth_to = com.ehis.util.DateUtils.convertDate(nil_by_mouth_to.substring(0, 16),"DMYHM", "en", language_id);
				else
					nil_by_mouth_to = rs.getString(16);

				String order_type_code = rs.getString(17);
				String order_id1 = rs.getString(18);
				String prep_instr = rs.getString(19); //55310
				if(prep_instr != null && prep_instr.trim().length() > 0)
					prep_instr = prep_instr.replaceAll(",", " ");
				String added_by_id = rs.getString(20);
				String dieticianReferral = rs.getString(21);
				dietOrderList.add(diet_category);
				dietOrderList.add(meal_class);
				dietOrderList.add(feed_type);
				dietOrderList.add(diet_type);
				dietOrderList.add(dietary_remarks);
				dietOrderList.add(delivery_code);
				dietOrderList.add(patient_class);
				dietOrderList.add(encounter_id);
				dietOrderList.add(profile_sl);

				if(newFromDate != null)
				{
					//SimpleDateFormat format1 = new SimpleDateFormat("yyyy-mm-dd"); //Common-ICN-0055
				    SimpleDateFormat format2 = new SimpleDateFormat("dd/mm/yyyy");
				    java.util.Date date1 = format2.parse(newFromDate);
				    dietOrderList.add(com.ehis.util.DateUtils.convertDate(format2.format(date1).toString(),"DMY", "en", language_id));
				}

				if(newToDate != null)
				{
					//SimpleDateFormat format1 = new SimpleDateFormat("yyyy-mm-dd"); //Common-ICN-0055
				    SimpleDateFormat format2 = new SimpleDateFormat("dd/mm/yyyy");
				    java.util.Date date2 = format2.parse(newToDate);
				    dietOrderList.add(com.ehis.util.DateUtils.convertDate(format2.format(date2).toString(),"DMY", "en", language_id));
				}
				else
					dietOrderList.add(period_to);

				if(new_added_date != null)
				{
					//SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd hh:mm"); //Common-ICN-0055
				    /* SimpleDateFormat format2 = new SimpleDateFormat("dd/MM/yyyy hh:mm");
				    java.util.Date date3 = format2.parse(new_added_date); */ //Common-ICN-0055
				    //dietOrderList.add(format2.format(date3).toString());
				    dietOrderList.add(new_added_date); 	//Modified Against ML-MMOH-SCF-1918
				}
				if(dieticianReferral==null)
					dieticianReferral="N";
				dietOrderList.add(status);
				dietOrderList.add(order_id);
				dietOrderList.add(nil_by_mouth_frm);
				dietOrderList.add(nil_by_mouth_to);
				dietOrderList.add(order_type_code);
				dietOrderList.add(order_id1);
				dietOrderList.add(prep_instr);
				dietOrderList.add(added_by_id);
				dietOrderList.add(dieticianReferral);
				String disCharge_flag = "";

				if(rs.getString(22) != null && rs.getString(22) != "")
					disCharge_flag = rs.getString(22);
				dietOrderList.add(disCharge_flag);

				String remarksHdr = "";
				if(rs.getString(23) != null && rs.getString(23) != "")
					remarksHdr = URLEncoder.encode(rs.getString(23), "UTF-8").replace("+", "%20");
				dietOrderList.add(remarksHdr);
				String atndInstr = "";
				if(rs.getString(24) != null && rs.getString(24) != "")
					atndInstr = rs.getString(24);
				dietOrderList.add(atndInstr);
				//ML-MMOH-CRF-412
				/*if(rs.getString("texture_of_diet")!=null && rs.getString("texture_of_diet")!=""){
					String texture_of_diet=rs.getString("texture_of_diet");
					dietOrderList.add(texture_of_diet);
				}*/
				//Added Newly for testing
				String texture_of_diet=rs.getString("texture_of_diet");
				if(texture_of_diet==null ){
					texture_of_diet="";
				}
				dietOrderList.add(texture_of_diet);
				
				//Added Against ML-MMOH-CRF-0684 By Aravindh Anbumani Starts here
				String menu_type=rs.getString("menu_type");
				if(menu_type==null ){
					menu_type="";
				}
				dietOrderList.add(menu_type);
				//Added Against ML-MMOH-CRF-0684 By Aravindh Anbumani Ends here
				}
				//Added Newly for testing
		}
		catch(Exception ee)
		{
			ee.printStackTrace();
			System.err.println("PlaceDietOrderServlet.java-111-->"+ee.getMessage());
		}
		finally
		{
			if(conn!=null)ConnectionManager.returnConnection(conn,request);
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			
		}
		return dietOrderList;
	}

	private ArrayList<String> getKaloriForMeals(HttpServletRequest request) throws SQLException{
		ArrayList<String> kaloriList = new ArrayList<String>();

		String foodType = request.getParameter("foodType");
		String locale = request.getParameter("languageId");
		
		Connection conn = ConnectionManager.getConnection(request);
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try{
		//String kalori_query = "SELECT A.FOOD_ITEM_CODE,TO_CHAR(A.CALORIFIC_CONT_PER_UOM,'999999.99'), B.ENERGY_UOM,  AM_GET_DESC.AM_UOM (ENERGY_UOM, '"+locale+"', 2) ENERGY_UOM_DESC FROM DS_ITEMS A,DS_PARAM B	WHERE A.FOOD_ITEM_CODE ='"+foodType+"' and A.LANGUAGE_ID='"+locale+"'"; //Modified Against PMG2017-COMN-CRF-0012.1[IN:067191] 
		String kalori_query = "SELECT a.food_item_code, TO_CHAR (a.calorific_cont_per_uom, '999999.99'), b.energy_uom, am_get_desc.am_uom (energy_uom, '"+locale+"', 2) energy_uom_desc,a.serving_uom_code,am_get_desc.am_uom (a.serving_uom_code, '"+locale+"',2) serving_uom_desc FROM ds_items a, ds_param b WHERE a.food_item_code = '"+foodType+"' AND a.language_id = '"+locale+"'";
		//Added Against Nutrient Supplement & Special food item [IN:067653]
		pstmt = conn.prepareStatement(kalori_query);
		rs = pstmt.executeQuery();
		while(rs != null && rs.next()){
			String FOOD_ITEM_CODE =rs.getString(1);
			String CALORIFIC_CONT_PER_UOM =rs.getString(2);
			String ENERGY_UOM =rs.getString(3);
			String ENERGY_UOM_DESC =rs.getString(4); //Added Against PMG2017-COMN-CRF-0012.1[IN:067191]
			String SERVING_UOM_CODE =rs.getString(5);//Added Nutrient Supplement & Special food item [IN:067653]
			String SERVING_UOM_DESC =rs.getString(6); //Added Nutrient Supplement & Special food item [IN:067653]
			kaloriList.add(FOOD_ITEM_CODE);
			kaloriList.add(CALORIFIC_CONT_PER_UOM);
			kaloriList.add(ENERGY_UOM);
			kaloriList.add(ENERGY_UOM_DESC); //Added Against PMG2017-COMN-CRF-0012.1[IN:067191]
			kaloriList.add(SERVING_UOM_CODE); //Added Nutrient Supplement & Special food item [IN:067653]
			kaloriList.add(SERVING_UOM_DESC); //Added Nutrient Supplement & Special food item [IN:067653]
		}

		}catch(Exception ee){
			ee.printStackTrace();
			System.err.println("PlaceDietOrderServlet.java--->"+ee.getMessage());
		}finally{
			if(conn!=null)ConnectionManager.returnConnection(conn,request);
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			
		}
		return kaloriList;

	}
	private ArrayList<String> insertSplFoodItems(HttpServletRequest request) throws SQLException{
		int flag = 0;
		String encounterId = request.getParameter("encounterId");
		String patientClass = request.getParameter("patientClass");
		String facility = request.getParameter("facility");
		String addedById = request.getParameter("addedById");
		String workStationNo = request.getParameter("workStationNo");
		String profile_SL = request.getParameter("profileSL");
		Long pi = Long.parseLong(profile_SL);
		String disChargeflag = request.getParameter("flag");
		String allList = request.getParameter("foodARR");
		String[] allFoodList = allList.split(",");
		session = request.getSession(false);
		String language_id = (String)session.getAttribute("LOCALE");
		
		Connection conn = ConnectionManager.getConnection(request);
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		Long item_SL = null;
		try{
		String itemSL = "SELECT NVL(MAX(ITEM_SL),0) FROM DS_EPSD_DIET_PROFILE_SPL WHERE ENCOUNTER_ID ='"+encounterId+"'";
		pstmt = conn.prepareStatement(itemSL);
		rs = pstmt.executeQuery();
		while(rs != null && rs.next()){
			 item_SL = rs.getLong(1);
		}
		if(pstmt!=null) pstmt.close();
		}catch(Exception ee){
			ee.printStackTrace();
		}
		try{
			String insSplFItem_query = "insert into DS_EPSD_DIET_PROFILE_SPL (ITEM_TYPE, PATIENT_CLASS, SERVING_TIME, SERVING_FREQ, PERIOD_BET_SERVINGS, ITEM_CODE, ITEM_QTY, ITEM_CHARGE, CHARGE_ITEM, MEAL_PLAN_CREATED_YN, MEAL_PLAN_CREATED_DATE, MEAL_PLAN_REF_DATE, MEAL_PLAN_REF_DAY_NO, FREQ_YN, MEAL_TYPE, ADDED_BY_ID, ADDED_DATE, ADDED_FACILITY_ID, ADDED_AT_WS_NO, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_FACILITY_ID, MODIFIED_AT_WS_NO, OPERATING_FACILITY_ID, ENCOUNTER_ID, PROFILE_SL, ITEM_SL,DISCHARGE_FLAG_YN) values (?, ?, to_date(?,'dd/mm/yyyy'), ?, to_date(?,'dd/MM/yyyy HH:MI'), ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?)";
			pstmt = conn.prepareStatement(insSplFItem_query);

			for(int i =0; i< allFoodList.length;){
				/*String insSplFItem_query = "insert into DS_EPSD_DIET_PROFILE_SPL (ITEM_TYPE, PATIENT_CLASS, SERVING_TIME, SERVING_FREQ, PERIOD_BET_SERVINGS, ITEM_CODE, ITEM_QTY, ITEM_CHARGE, CHARGE_ITEM, MEAL_PLAN_CREATED_YN, MEAL_PLAN_CREATED_DATE, MEAL_PLAN_REF_DATE, MEAL_PLAN_REF_DAY_NO, FREQ_YN, MEAL_TYPE, ADDED_BY_ID, ADDED_DATE, ADDED_FACILITY_ID, ADDED_AT_WS_NO, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_FACILITY_ID, MODIFIED_AT_WS_NO, OPERATING_FACILITY_ID, ENCOUNTER_ID, PROFILE_SL, ITEM_SL,DISCHARGE_FLAG_YN) values (?, ?, to_date(?,'dd/mm/yyyy'), ?, to_date(?,'dd/MM/yyyy HH:MI'), ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?)";
				pstmt = conn.prepareStatement(insSplFItem_query);*/
				pstmt.setString(1, allFoodList[i+2]);
				pstmt.setString(2, patientClass);
				allFoodList[i] = com.ehis.util.DateUtils.convertDate(allFoodList[i],"DMY", language_id, "en");
				pstmt.setString(3, allFoodList[i] );
				pstmt.setString(4, allFoodList[i+16]);
				String st = new String(allFoodList[i]+" "+allFoodList[i+17]);
				pstmt.setString(5, st);
				pstmt.setString(6, allFoodList[i+3]);
				pstmt.setString(7, allFoodList[i+4]);
				pstmt.setString(8, null);
				pstmt.setString(9, null);
				pstmt.setString(10, null);
				pstmt.setString(11, null);
				pstmt.setString(12, null);
				pstmt.setString(13, null);
				pstmt.setString(14, allFoodList[i+20].trim());
				pstmt.setString(15, allFoodList[i+18].trim());
				pstmt.setString(16, addedById);
				pstmt.setTimestamp(17, getCurrentTimeStamp());
				pstmt.setString(18, facility);
				pstmt.setString(19, workStationNo);
				pstmt.setString(20, addedById);
				pstmt.setTimestamp(21, getCurrentTimeStamp());
				pstmt.setString(22, facility);
				pstmt.setString(23, workStationNo);
				pstmt.setString(24, facility);
				pstmt.setString(25, encounterId);
				if(pi == 0){
					pstmt.setLong(26, ++pi);
				}else{
					pstmt.setLong(26, pi);
				}
				//pstmt.setLong(26, ++pi);
				if(item_SL != null){
					pstmt.setLong(27, ++item_SL);
				}
				pstmt.setString(28, disChargeflag);
				//i = i+21;
				i = i+22;//Modified Against Nutrient Supplement & Special food item [IN:067653]
				flag = pstmt.executeUpdate();
//				if(pstmt!=null) pstmt.close();
				if(flag != 0){
					System.out.println("Flag not zero in insertSplFoodItems");
					conn.commit();
				}else{
					System.out.println("Flag zero in insertSplFoodItems");
					conn.rollback();
				}
				//--pi;
			}
			if(pstmt!=null) pstmt.close();
		}catch(Exception ee){
			ee.printStackTrace();
			System.err.println("PlaceDietOrderServlet.java--->"+ee.getMessage());
		}finally{
			if(conn!=null)ConnectionManager.returnConnection(conn,request);
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			
		}
		return null;
	}

	private void updateMealMenuItems(HttpServletRequest request,HttpServletResponse response) throws SQLException
	{
		session = request.getSession(false);
		int totalItems = 0;//054259
		String language_id = (String)session.getAttribute("LOCALE");
		if(request.getParameter("totalItems") != null)//054259
			totalItems = Integer.parseInt(request.getParameter("totalItems"));
		String patientId = request.getParameter("patientId");
		String patientClass = request.getParameter("patientClass");
		String encounterId = request.getParameter("encounterId");
		String mealClass = request.getParameter("mealClass");
		String dateforMenu=com.ehis.util.DateUtils.convertDate(request.getParameter("dateForMenu"),"DMY", language_id, "en");
		String profileSL = request.getParameter("profileSL");
		String dateFrom = com.ehis.util.DateUtils.convertDate(request.getParameter("dateFrom"),"DMY", language_id, "en");
		String dateTo = com.ehis.util.DateUtils.convertDate(request.getParameter("dateTo"),"DMY", language_id, "en");
		//String params=request.getParameter("paramValues"); //Common-ICN-0055
		String error_value = "0" ;
		String error = "";

		Boolean isInsertSuccess=false;
		Connection conn = ConnectionManager.getConnection(request);
		PreparedStatement pstmt=null,pstmt1=null;//Modified Against AMS-CRF-0112
		ResultSet rs=null;
		try
		{
			String sql="INSERT INTO DS_EPSD_DIET_PROF_DTL_REVIEWED (PATIENT_ID, PATIENT_CLASS, ENCOUNTER_ID, " +
					"PROFILE_SL, MEAL_TYPE, ITEM_CODE, SERVING_DATE, CYCLE_DAY_REF, REVIEW_TYPE, NIL_BY_MOUTH_YN," +
					" PERIOD_FROM, PERIOD_TO, DIET_TYPE, MEAL_CLASS, ITEM_SL, ITEM_TYPE, ITEM_QTY, PREF_OPTION," +
					" MENU_CODE, STATUS, ADDED_BY_ID, ADDED_DATE, ADDED_FACILITY_ID, ADDED_AT_WS_NO, " +
					"MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_FACILITY_ID, MODIFIED_AT_WS_NO, " +
					"OPERATING_FACILITY_ID, REVIEW_SLNO) VALUES (?, ?, ?, ?, ?, ?, to_date(?,'DD/MM/YYYY'), ?, ?, ?,to_date(?,'DD/MM/YYYY'), to_date(?,'DD/MM/YYYY'), ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);

			String sql_update="UPDATE DS_EPSD_DIET_PROF_DTL_REVIEWED SET PATIENT_ID=?, PATIENT_CLASS=?, ENCOUNTER_ID=?, PROFILE_SL=?, MEAL_TYPE=?, ITEM_CODE=?, SERVING_DATE=to_date(?,'DD/MM/YYYY'), CYCLE_DAY_REF=?, REVIEW_TYPE=?, NIL_BY_MOUTH_YN=?, PERIOD_FROM=to_date(?,'DD/MM/YYYY'), PERIOD_TO=to_date(?,'DD/MM/YYYY'), DIET_TYPE=?, MEAL_CLASS=?, ITEM_SL=?, ITEM_TYPE=?, ITEM_QTY=?, PREF_OPTION=?, MENU_CODE=?, STATUS=?, MODIFIED_BY_ID=?, MODIFIED_DATE=?, MODIFIED_FACILITY_ID=?, MODIFIED_AT_WS_NO=? WHERE OPERATING_FACILITY_ID=? and REVIEW_SLNO=?";
			pstmt1 = conn.prepareStatement(sql_update);
            
			//Added Against AMS-CRF-0112 Starts Here
			/*String sql_AdditionalInstruction_update="UPDATE DS_EPSD_DIET_PROFILE_DTL SET MEAL_ADDITIONAL_INSTRUCTION=? WHERE ENCOUNTER_ID=? AND PROFILE_SL=? AND MEAL_TYPE=?";*/
			/*String sql_AdditionalInstruction_update="UPDATE DS_EPSD_DIET_PROFILE_DTL SET MEAL_ADDITIONAL_INSTRUCTION=?, MODIFIED_DATE=?,MODIFIED_BY_ID=?,MODIFIED_FACILITY_ID=?,MODIFIED_AT_WS_NO=? WHERE ENCOUNTER_ID=? AND PROFILE_SL=? AND MEAL_TYPE=?";
			pstmt2=conn.prepareStatement(sql_AdditionalInstruction_update);*/
			//Added Against AMS-CRF-0112 Ends Here
			for(int i=0;i<totalItems;i++)
			{
				String mealType = request.getParameter("mealType"+i);
				String itemCode = request.getParameter("itemCode"+i);
				String menuCode = request.getParameter("menuCode"+i);
				String dietType = request.getParameter("dietType"+i);
				String menuSL = request.getParameter("menuSL"+i);
				String mealmenuSL = request.getParameter("mealmenuSL"+i);
				String reviewType = request.getParameter("reviewType"+i);
				//String methodFlag = request.getParameter("methodFlag"+i); //Common-ICN-0055
				String itemQty = request.getParameter("itemQty"+i);
				String itemType=request.getParameter("itemType"+i);
				String status=request.getParameter("methodFlag"+i);
				
				if(mealmenuSL.equals("0"))
				{
					if(!(reviewType.equals("N")))
					{
						int reviewSl=getReviewSLNum(request);
						pstmt.setString(1,patientId);
						pstmt.setString(2,patientClass);
						pstmt.setString(3,encounterId);
						pstmt.setString(4,profileSL);
						pstmt.setString(5,mealType);
						pstmt.setString(6,itemCode);
						pstmt.setString(7,dateforMenu);
						pstmt.setString(8,"1");
						pstmt.setString(9,reviewType);
						pstmt.setString(10,"");
						pstmt.setString(11,dateFrom);
						pstmt.setString(12,dateTo);
						pstmt.setString(13,dietType);
						pstmt.setString(14, mealClass);
						pstmt.setInt(15,i+1);
						pstmt.setString(16,itemType);
						pstmt.setString(17,itemQty);
						pstmt.setString(18,"" );
						pstmt.setString(19,menuCode);
						pstmt.setString(20,status);
						pstmt.setString(21,login_user);
						pstmt.setTimestamp(22, new  java.sql.Timestamp(System.currentTimeMillis()));
						pstmt.setString(23,facility_id);
						pstmt.setString(24,str_client_ip_address);
						pstmt.setString(25,login_user);
						pstmt.setTimestamp(26, new  java.sql.Timestamp(System.currentTimeMillis()));
						pstmt.setString(27,facility_id);
						pstmt.setString(28,str_client_ip_address);
						pstmt.setString(29,facility_id);
						pstmt.setInt(30,reviewSl+1);

						int row=pstmt.executeUpdate();

						if (row >0)
						{
							isInsertSuccess = true;
							conn.commit();
						}
						else conn.rollback();
					}
				}
				else if(mealmenuSL.equals("2"))
				{
					pstmt1.setString(1,patientId);
					pstmt1.setString(2,patientClass);
					pstmt1.setString(3,encounterId);
					pstmt1.setString(4,profileSL);
					pstmt1.setString(5,mealType);
					pstmt1.setString(6,itemCode);
					pstmt1.setString(7,dateforMenu);
					pstmt1.setString(8,"1");
					pstmt1.setString(9,reviewType);
					pstmt1.setString(10,"");
					pstmt1.setString(11,dateFrom);
					pstmt1.setString(12,dateTo);
					pstmt1.setString(13,dietType);
					pstmt1.setString(14, mealClass);
					pstmt1.setInt(15,i+1);
					pstmt1.setString(16,itemType);
					pstmt1.setString(17,itemQty);
					pstmt1.setString(18,"" );
					pstmt1.setString(19,menuCode);
					pstmt1.setString(20,status);
					pstmt1.setString(21,login_user);
					pstmt1.setTimestamp(22, new  java.sql.Timestamp(System.currentTimeMillis()));
					pstmt1.setString(23,facility_id);
					pstmt1.setString(24,str_client_ip_address);
					pstmt1.setString(25,facility_id);
					pstmt1.setInt(26,Integer.parseInt(menuSL));

					int row=pstmt1.executeUpdate();

					if (row >0)
					{
						isInsertSuccess = true;
						conn.commit();
					}
					else
						conn.rollback();
				}
			}
			if(pstmt!=null) pstmt.close();
			if(pstmt1!=null) pstmt1.close();
			if ( isInsertSuccess )
			{
				error_value = "1" ;
			}
			else
			{
				 error = "Records have not been saved. Please try again";
			}
			response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode(error,"UTF-8"  )+"&err_value="+error_value );

		}catch(Exception ee){
			ee.printStackTrace();
		}finally{
			if(conn!=null)ConnectionManager.returnConnection(conn,request);
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			
		}
	}

	private int getReviewSLNum(HttpServletRequest req) throws SQLException {
		int id=0;
		Connection conn = ConnectionManager.getConnection(req);
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			String strQuery="select max(to_number(REVIEW_SLNO)) from DS_EPSD_DIET_PROF_DTL_REVIEWED";
			pstmt = conn.prepareStatement(strQuery);

			rs=pstmt.executeQuery();
			if(rs!=null)
				{
				   while(rs.next())
				        {
					   		id=rs.getInt(1);
				        }
				}
			}
		catch(Exception e) {
			System.err.println("exception in getOrderId method=" + e.toString());
			e.printStackTrace();
			if(conn!=null) ConnectionManager.returnConnection(conn);
		}
		finally {
			if(conn!=null)ConnectionManager.returnConnection(conn);
			if(rs!=null) rs.close();
			pstmt.close();
			
		}
		return id;
	}


	private ArrayList<String> mealTypeForDischange(String facility,
			String encounterId, String flag,HttpServletRequest request) throws SQLException {
		ArrayList<String> mealTyList = new ArrayList<String>();
		Connection conn = ConnectionManager.getConnection(request);
		String profilesl = request.getParameter("profileSL");
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String meal_type = "";
		String diet_type = "";
		try{
			String mealType_query = "select meal_type,diet_type from ds_epsd_diet_profile_dtl where encounter_id = '"+encounterId+"' and OPERATING_FACILITY_ID = '"+facility+"' and DISCHARGE_FLAG_YN='"+flag+"' and profile_SL='"+profilesl+"'";
			pstmt = conn.prepareStatement(mealType_query);
			rs=pstmt.executeQuery();
			if(rs!=null)
			{
			   while(rs.next())
			   {
				   meal_type = rs.getString(1);
				   diet_type = rs.getString(2);
				   mealTyList.add(meal_type);
				   mealTyList.add(diet_type);
			   }
			}
		}catch(Exception e){
			if(rs!=null) rs.close();
			pstmt.close();
			if(conn!=null)ConnectionManager.returnConnection(conn);
		}
		return mealTyList;
	}

	//getLastAttendantSerial - IN:39937 - This method is for getting last attendant serial:
	private int getLastAttendantSerial(HttpServletRequest request, String nEncounterid) throws SQLException {
		int id=0;
		Connection conn = ConnectionManager.getConnection(request);
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			String strQuery="select max(to_number(ATTENDENT_SRL)) from DS_EPSD_DIET_PROFILE_ATT where ENCOUNTER_ID = '"+nEncounterid+"'";
			pstmt = conn.prepareStatement(strQuery);

			rs=pstmt.executeQuery();
			if(rs!=null)
				{
				   while(rs.next())
				        {
					   		id=rs.getInt(1);
				        }
				}
			}
		catch(Exception e) {
			System.err.println("exception in getLastAttendantSerial method=" + e.toString());
			e.printStackTrace();
		}
		finally {
			if(conn!=null)ConnectionManager.returnConnection(conn);
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			
		}
		return id;
	}

	private ArrayList<String> getsrlNOForDelSplFood(HttpServletRequest request) throws SQLException {
		ArrayList list = new ArrayList();
		String encounterId = request.getParameter("encounterId");
		String facility = request.getParameter("facility");
		String itemCode = request.getParameter("itemCode");
		String profileSL = request.getParameter("profileSL");
		String rowNum = request.getParameter("rowNum");
		Connection conn = ConnectionManager.getConnection(request);
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String ITEM_SL = null;
		String PROFILE_SL = null;
		try{
			String query_str = "SELECT SPL.PROFILE_SL,SPL.ITEM_SL FROM DS_EPSD_DIET_PROFILE_SPL SPL WHERE SPL.OPERATING_FACILITY_ID ='"+facility+"' AND spl.item_sl = '"+rowNum+"' AND SPL.ENCOUNTER_ID ='"+encounterId+"' and item_code='"+itemCode+"' and profile_sl='"+profileSL+"'";
			pstmt = conn.prepareStatement(query_str);
			rs = pstmt.executeQuery();
			while(rs != null && rs.next()){
				PROFILE_SL = rs.getString(1);
				ITEM_SL = rs.getString(2);
				list.add(PROFILE_SL);
				list.add(ITEM_SL);
			}

		}catch(Exception ee){
			ee.printStackTrace();
			System.err.println("PlaceDietOrderServlet.java--->"+ee.getMessage());
		}finally{
			if(conn!=null)ConnectionManager.returnConnection(conn,request);
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			
		}
		return list;
	}

	private void updateOldOrders(HttpServletRequest request, Long profileSL_NEW) throws SQLException
	{
		session = request.getSession(false);
		String encounterId = request.getParameter("encounterId");
		String facility = request.getParameter("addedFacilityId");
		String fromDate = request.getParameter("fromDate");
		String toDate = request.getParameter("dateTo");
		//String selectedProfile = request.getParameter("selectedProfile"); //Common-ICN-0055
		String profileSL = "";
		String period_from = "";
		String orderFromDate = "";
		String orderToDate = "";
		String period_to = "";
		String updateQuery = "";
		StringBuffer updateQueryBuffer = new StringBuffer();
		int setIndex = 0;

		Date newFromDate = null;
		Date newToDate = null;

		Connection conn = ConnectionManager.getConnection(request);
		PreparedStatement pstmt=null;
		ResultSet rs=null;

		try
		{
			String dietOrderQuery = "SELECT profile_sl,TO_CHAR (period_from, 'DD/MM/YYYY'),TO_CHAR (period_to, 'DD/MM/YYYY'),to_char(nil_by_mouth_frm,'DD/MM/YYYY HH24:MI') FROM ds_epsd_diet_profile_hdr WHERE (operating_facility_id = '"+facility+"') AND (encounter_id = '"+encounterId+"') and nvl(status,'ZZ') not in('X') and profile_sl<>"+profileSL_NEW;
			pstmt = conn.prepareStatement(dietOrderQuery);
			rs = pstmt.executeQuery();
			SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
			while(rs != null && rs.next())
			{
				profileSL = rs.getString(1);
				period_from = rs.getString(2);
				if(period_from != null)
					orderFromDate = period_from;
				period_to = rs.getString(3);
				if(period_to != null)
					orderToDate = period_to;
				else
					orderToDate = "31/12/2999";


				Date dbFromDate = null;
				Date dbToDate = null;
				if(orderFromDate != null)
					dbFromDate = fmt.parse(orderFromDate);
				if(orderToDate != null)
					dbToDate = fmt.parse(orderToDate);
				if(fromDate != null && fromDate.trim().length() > 0)
					newFromDate = fmt.parse(fromDate);
				if(toDate != null && toDate.trim().length() > 0)
					newToDate = fmt.parse(toDate);				

				if(newFromDate != null && (newFromDate.after(dbFromDate) && (dbToDate == null || (dbToDate != null && (newFromDate.before(dbToDate) || newFromDate.equals(dbToDate))))))
				{
					updateQuery = "UPDATE ds_epsd_diet_profile_hdr set period_to=to_date(?,'DD/MM/YYYY')-1 WHERE (operating_facility_id = '"+facility+"') AND (encounter_id = '"+encounterId+"') and (profile_sl="+profileSL+") ";
					pstmt = conn.prepareStatement(updateQuery);
					pstmt.setString(1, fromDate);
					int row = pstmt.executeUpdate();
					if(pstmt!=null)
						pstmt.close();
					if (row > 0)
					{
						System.out.println("update to_date for profileSL"+profileSL);
						conn.commit();
					}
					else
						conn.rollback();
				}

				//For Cancellation of existing profile
				if(((newFromDate != null && newToDate != null) && ((newFromDate.before(dbFromDate) || newFromDate.equals(dbFromDate)) && (newToDate.after(dbToDate) || newToDate.equals(dbToDate))))
						|| (newFromDate != null && newToDate == null && (newFromDate.before(dbFromDate) || newFromDate.equals(dbFromDate))))
				{
					updateQueryBuffer.append("	UPDATE ds_epsd_diet_profile_hdr dsepsddiet	");
					updateQueryBuffer.append("	SET status = 'X'							");
					updateQueryBuffer.append("	WHERE dsepsddiet.operating_facility_id = ?	");
					updateQueryBuffer.append("	AND dsepsddiet.encounter_id = ?				");
					updateQueryBuffer.append("	AND profile_sl = ?							");

					pstmt = null;
					setIndex = 0;
					pstmt = conn.prepareStatement(updateQueryBuffer.toString());
					pstmt.setString(++setIndex, facility);
					pstmt.setString(++setIndex, encounterId);
					pstmt.setString(++setIndex, profileSL);
					int row = pstmt.executeUpdate();
					if(pstmt!=null)
						pstmt.close();
					if (row > 0)
					{
						System.out.println("===cancellation condition==="+profileSL);
						conn.commit();
					}
					else
						conn.rollback();
					updateQueryBuffer.delete(0, updateQueryBuffer.length());
				}

				//For Updation of existing profile
				if((newFromDate != null && newToDate != null) && (dbFromDate.after(newFromDate) || dbFromDate.equals(newFromDate)) && (dbFromDate.before(newToDate)
						|| dbFromDate.equals(newToDate)) && (newToDate.before(dbToDate)))
				{
					updateQueryBuffer.append("	UPDATE ds_epsd_diet_profile_hdr dsepsddiet		");
					updateQueryBuffer.append("	SET period_from = to_date(?,'DD/MM/YYYY')+1		");
					updateQueryBuffer.append("	WHERE dsepsddiet.operating_facility_id = ?		");
					updateQueryBuffer.append("	AND dsepsddiet.encounter_id = ?					");
					updateQueryBuffer.append("	AND profile_sl = ?								");

					pstmt = null;
					setIndex = 0;
					pstmt = conn.prepareStatement(updateQueryBuffer.toString());
					pstmt.setString(++setIndex, toDate);
					pstmt.setString(++setIndex, facility);
					pstmt.setString(++setIndex, encounterId);
					pstmt.setString(++setIndex, profileSL);
					int row = pstmt.executeUpdate();
					if(pstmt!=null)
						pstmt.close();
					if (row > 0)
					{
						System.out.println("===cancellation condition==="+profileSL);
						conn.commit();
					}
					else
						conn.rollback();
					updateQueryBuffer.delete(0, updateQueryBuffer.length());
				}
			}
		}
		catch(Exception ee)
		{
			ee.printStackTrace();
			System.err.println("PlaceDietOrderServlet.java--->"+ee.getMessage());
		}
		finally
		{
			if(conn!=null)ConnectionManager.returnConnection(conn,request);
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			
		}
		return;
	}

	//geting the DIETICIAN REFERRAL value
	private String getDieticianFlag(HttpServletRequest request) throws SQLException {
		String encounterId = request.getParameter("encounterId");
		String facility = request.getParameter("facility");

		Connection conn = ConnectionManager.getConnection(request);
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String DIETICIAN_REFRL_YN = "";
		try{
			String dietcian_query = "SELECT DIETICIAN_REFRL_YN FROM DS_EPSD_DIETICIAN_REFERRAL WHERE ENCOUNTER_ID = '"+encounterId+"' AND OPERATING_FACILITY_ID='"+facility+"'";
			pstmt = conn.prepareStatement(dietcian_query);
			rs = pstmt.executeQuery();
			if(rs != null && rs.next()){
				DIETICIAN_REFRL_YN = rs.getString(1);
			}

		}catch(Exception ee){
			ee.printStackTrace();
			System.err.println("PlaceDietOrderServlet.java--->"+ee.getMessage());
		}finally{
			if(conn!=null)ConnectionManager.returnConnection(conn,request);
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
		}
		return DIETICIAN_REFRL_YN;
	}

	/*
	 * Updating the Dietitian Referral in DS_EPSD_DIETICIAN_REFERRAL table
	 */
	private void updateDieticianRefferal(HttpServletRequest request,String dieticianReferral,String addedFacilityId,String addedAtWsNo, String addedById,
			String encounterId,String patientClass,String patientId) throws SQLException{
		PreparedStatement pstmtForDietician = null;
		PreparedStatement pstmt=null;
		Connection conn = ConnectionManager.getConnection(request);
		try{
			//Delete from DS_EPSD_DIETICIAN_REFERRAL
			if(dieticianReferral != null){
				int dieticianFlag;
				int delFlg;
				String delete_query = "delete from DS_EPSD_DIETICIAN_REFERRAL where encounter_id='"+encounterId+"'";
				pstmtForDietician = conn.prepareStatement(delete_query);
				delFlg = pstmtForDietician.executeUpdate();
				if(delFlg != 0){
					System.out.println("DS_EPSD_DIETICIAN_REFERRAL deleted");
					conn.commit();
				}else{
					System.out.println("DS_EPSD_DIETICIAN_REFERRAL not deleted");
					conn.rollback();
				}

				//Insert into DS_EPSD_DIETICIAN_REFERRAL with updated DIETICIAN_REFRL_YN value
				String dietcian_query = "INSERT INTO DS_EPSD_DIETICIAN_REFERRAL(OPERATING_FACILITY_ID,ENCOUNTER_ID,PATIENT_ID,PATIENT_CLASS,DIETICIAN_REFRL_YN,ADDED_BY_ID,ADDED_DATE,ADDED_FACILITY_ID,ADDED_AT_WS_NO,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_FACILITY_ID,MODIFIED_AT_WS_NO) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
				pstmt = conn.prepareStatement(dietcian_query);
				pstmt.setString(1, addedFacilityId);
				pstmt.setString(2, encounterId);
				pstmt.setString(3, patientId);
				pstmt.setString(4, patientClass);
				pstmt.setString(5, dieticianReferral);
				pstmt.setString(6, addedById);
				pstmt.setTimestamp(7, getCurrentTimeStamp());
				pstmt.setString(8, addedFacilityId);
				pstmt.setString(9, addedAtWsNo);
				pstmt.setString(10, addedById);
				pstmt.setTimestamp(11, getCurrentTimeStamp());
				pstmt.setString(12, addedFacilityId);
				pstmt.setString(13, addedAtWsNo);

				dieticianFlag = pstmt.executeUpdate();
				if(dieticianFlag != 0){
					System.out.println("Flag is not zero in  updateDieticianRefferal");
					conn.commit();
				}else{
					System.out.println("Flag is zero in updateDieticianRefferal");
					conn.rollback();
				}
			}
		}catch(Exception ee){
			ee.printStackTrace();
			System.err.println("Exception in updateDieticianRefferal method--->"+ee.getMessage());
		}finally{
			if(conn!=null)ConnectionManager.returnConnection(conn,request);
			if(pstmt!=null) pstmt.close();
			if(pstmtForDietician != null) pstmtForDietician.close();
		}
	}

	private String cancelMealOrder(HttpServletRequest request)
	{
		String cnacelOrderChk = "N";
		String facilityId = "";
		String patientClass = "";
		String encounterId = "";
		String profileSL = "";
		String dateFrom = "";
		String dateTo = "";
		String activeOrderFlag = "";
		String Actual_todate = "",  Cancelled_PracID = "", Cancelled_Reason= "" ; //Added Against PMG2013-CRF-0009.1-US001 
		int recsUpdated = 0;
		StringBuffer cancelMealOrderBuffer = new StringBuffer();
		StringBuffer cancelNBMMealOrderBuffer = new StringBuffer();//CRF-410
		int index = 0;

		Connection conn = ConnectionManager.getConnection(request);
		PreparedStatement pstmt = null;

		try
		{
			/*if(toDate != null && toDate.before(currentDate))
			{
			}*/
			facilityId = request.getParameter("facilityId");
			patientClass = request.getParameter("patientClass");
			encounterId = request.getParameter("encounterId");
			profileSL = request.getParameter("profileSL");
			dateFrom = request.getParameter("dateFrom");
			dateTo = request.getParameter("dateTo");
			//Addded Against PMG2013-CRF-0009.1-US001 Starts Here
			Actual_todate = request.getParameter("Actual_todate");
			Cancelled_Reason = request.getParameter("Cancelled_Reason");
			Cancelled_PracID = prop.getProperty( "login_user" );
			//Addded Against PMG2013-CRF-0009.1-US001 Ends Here
			activeOrderFlag = request.getParameter("activeOrderFlag");			

			cancelMealOrderBuffer.append("	UPDATE ds_epsd_diet_profile_hdr dsepsddiet	SET	");
			if(activeOrderFlag != null && activeOrderFlag.equalsIgnoreCase("N"))
				cancelMealOrderBuffer.append("	 status = 'X',							");
			cancelMealOrderBuffer.append("	period_to = TO_DATE (?, 'dd/mm/yyyy'),		");
			//Addded Against PMG2013-CRF-0009.1-US001 Starts Here
			cancelMealOrderBuffer.append("	ACTUAL_TODATE = TO_DATE (?, 'DD/MM/YYYY'),	");
			cancelMealOrderBuffer.append("	CANCELLED_DATE = sysdate, ");
			cancelMealOrderBuffer.append("	CANCEL_REASON = ?,					    	");
			cancelMealOrderBuffer.append("	CANCELED_PRACT_ID = ?						");
			//Addded Against PMG2013-CRF-0009.1-US001 Ends Here
			cancelMealOrderBuffer.append("	WHERE dsepsddiet.operating_facility_id = ?	");
			cancelMealOrderBuffer.append("	AND dsepsddiet.encounter_id = ?				");
			cancelMealOrderBuffer.append("	and dsepsddiet.patient_class = ?			");
			cancelMealOrderBuffer.append("	AND profile_sl = ?							");

			pstmt = conn.prepareStatement(cancelMealOrderBuffer.toString());
			pstmt.setString(++index, dateTo);
			//Addded Against PMG2013-CRF-0009.1-US001 Starts Here
			if(activeOrderFlag != null && activeOrderFlag.equalsIgnoreCase("N")){
				pstmt.setString(++index, null);
			}else{
				pstmt.setString(++index, Actual_todate);
			}
			//pstmt.setString(++index, Cancelled_Date);
			pstmt.setString(++index, Cancelled_Reason);
			pstmt.setString(++index, Cancelled_PracID);
			//Addded Against PMG2013-CRF-0009.1-US001 Ends Here
			pstmt.setString(++index, facilityId);
			pstmt.setString(++index, encounterId);
			pstmt.setString(++index, patientClass);
			pstmt.setString(++index, profileSL);
			recsUpdated = pstmt.executeUpdate();

			//recsUpdated = pstmt.executeUpdate();
			if(recsUpdated != 0)
			{
				cnacelOrderChk = "Y";
				conn.commit();
			}
			else
			{
				//Check upating the ds_epsd_nbm_profile table
				//CRF-410 starts
				//String nilFromDate=request.getParameter("nilFromDate"); //Common-ICN-0055
				String nilToDate=request.getParameter("nilToDate");				
				
				cancelNBMMealOrderBuffer.append("	update ds_epsd_nbm_profile set	NIL_BY_MOUTH_TO=TO_DATE (?, 'dd/mm/yyyy HH24:MI')	");
				if(activeOrderFlag != null && activeOrderFlag.equalsIgnoreCase("N")){
					cancelNBMMealOrderBuffer.append("	,status='X'	");
				}
				cancelNBMMealOrderBuffer.append("	where profile_sl=? and encounter_id=?  and operating_facility_id=?	");
				
				index=0;
				pstmt = conn.prepareStatement(cancelNBMMealOrderBuffer.toString());				
				
				pstmt.setString(++index,nilToDate);
				pstmt.setString(++index, profileSL);
				pstmt.setString(++index, encounterId);				
				pstmt.setString(++index, facilityId);
				recsUpdated = pstmt.executeUpdate();
				if(recsUpdated != 0)
				{					
					cnacelOrderChk = "Y";
					conn.commit();
				}				
				else{
				conn.rollback();
				}
				//CRF-410 ends
			}
		}
		catch(Exception mainEx)
		{
			mainEx.printStackTrace();
		}
		finally
		{
			try
			{
				if(conn!=null)
					ConnectionManager.returnConnection(conn,request); //Common-ICN-0052
				if(pstmt!=null)
					pstmt.close();
			    //conn.close();
			}
			catch(Exception finalBlockEx)
			{
				finalBlockEx.printStackTrace();
			}
		}
		return cnacelOrderChk;
	}

	public String chkOrdersForCancellation(HttpServletRequest request) throws SQLException
	{
		String encounterId = "";
		String facility = "";
		String fromDate = "";
		String toDate = "";
		String selectedProfile = "";
		String period_from = "";
		String orderFromDate = "";
		String orderToDate = "";
		String period_to = "";
		StringBuffer ordersForCancellationBuffer = new StringBuffer();
		StringBuffer dietOrderQueryBuffer = new StringBuffer();
		int setIndex = 0;

		Date newFromDate = null;
		Date newToDate = null;
		Date dbFromDate = null;
		Date dbToDate = null;

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try
		{
			conn = ConnectionManager.getConnection(request);
			if(conn == null)
				return ordersForCancellationBuffer.toString();

			encounterId = request.getParameter("encounterId");
			facility = request.getParameter("addedFacilityId");
			fromDate = request.getParameter("fromDate");
			toDate = request.getParameter("dateTo");
			selectedProfile = request.getParameter("selectedProfile");

			dietOrderQueryBuffer.append("	SELECT profile_sl, TO_CHAR (period_from, 'DD/MM/YYYY'),	");
			dietOrderQueryBuffer.append("	TO_CHAR (period_to, 'DD/MM/YYYY'),						");
			dietOrderQueryBuffer.append("	TO_CHAR (nil_by_mouth_frm, 'DD/MM/YYYY HH24:MI')		");
			dietOrderQueryBuffer.append("	FROM ds_epsd_diet_profile_hdr							");
			dietOrderQueryBuffer.append("	WHERE operating_facility_id = ?							");
			dietOrderQueryBuffer.append("	AND encounter_id = ?									");
			dietOrderQueryBuffer.append("	AND NVL (status, 'ZZ') not in ('X')				");
			dietOrderQueryBuffer.append("	AND profile_sl <> ?										");
			pstmt = conn.prepareStatement(dietOrderQueryBuffer.toString());
			pstmt.setString(++setIndex, facility);
			pstmt.setString(++setIndex, encounterId);
			pstmt.setString(++setIndex, selectedProfile);
			rs = pstmt.executeQuery();
			SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
			while(rs != null && rs.next())
			{
				period_from = rs.getString(2);
				if(period_from != null)
					orderFromDate = period_from;
				period_to = rs.getString(3);
				if(period_to != null)
					orderToDate = period_to;
				else
					orderToDate = "31/12/2999";

				dbFromDate = null;
				dbToDate = null;
				if(orderFromDate != null)
					dbFromDate = fmt.parse(orderFromDate);
				if(orderToDate != null)
					dbToDate = fmt.parse(orderToDate);
				if(fromDate != null && fromDate.trim().length() > 0)
					newFromDate = fmt.parse(fromDate);
				if(toDate != null && toDate.trim().length() > 0)
					newToDate = fmt.parse(toDate);

				//List For Canceling of existing profile
				if(((newFromDate != null && newToDate != null) && ((newFromDate.before(dbFromDate) || newFromDate.equals(dbFromDate)) && (newToDate.after(dbToDate) || newToDate.equals(dbToDate))))
						|| (newFromDate != null && newToDate == null && (newFromDate.before(dbFromDate) || newFromDate.equals(dbFromDate))))
				{
					if(period_from != null && period_from.trim().length() > 0)
						ordersForCancellationBuffer.append(period_from);
					if(period_to != null && period_to.trim().length() > 0)
					{
						ordersForCancellationBuffer.append(" - ");
						ordersForCancellationBuffer.append(period_to);
					}
					ordersForCancellationBuffer.append("\n");
				}
			}
		}catch(Exception ee){
			ee.printStackTrace();
			System.err.println("PlaceDietOrderServlet.java--chkOrdersForCancellation->"+ee.getMessage());
		}finally{
			if(conn!=null)ConnectionManager.returnConnection(conn,request);
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			}
		return ordersForCancellationBuffer.toString();
	}
		//Added against MMS-KH-CRF-0029.1 Starts Here	
	public void setEditMenu(ArrayList edit_menu){
		System.err.println("setEditMenu");
		this.editMenu_1 = edit_menu;
		
	}
	public ArrayList getEditMenu(){
		System.err.println("getEditMenu");
		return editMenu_1;		
	}
	
	public void setApplyMenu(ArrayList apply_menu){
		System.err.println("setApplyMenu");
		this.applyMenu_1 = apply_menu;
		
	}
	public ArrayList getApplyMenu(){
		System.err.println("getApplyMenu");
		return applyMenu_1;		
	}
	public void setCancelMenu(ArrayList cancel_menu){
		System.err.println("setCancelMenu");
		this.cancelMenu_1 = cancel_menu;
		
	}
	public ArrayList getCancelMenu(){
		System.err.println("getCancelMenu");
		return cancelMenu_1;		
	}
		//Added against MMS-KH-CRF-0029.1 Ends Here	
	// AAKH-CRF-0065 start
	private void updateMealMenuItemsObject(HttpServletRequest request,HttpServletResponse response) throws SQLException
	{
		String language_id = "";
		int totalItems = 0;
		String patientId = "";
		String patientClass = "";
		String encounterId = "";
		String mealClass = "";
		String dateforMenu = "";
		String profileSL = "";
		String dateFrom = "";
		String dateTo = "";
		String mealType = "";
		String itemCode = "";
		String menuCode = "";
		String dietType = "";
		String enableDrugYN = "";
		String menuSL = "";
		String mealmenuSL = "";
		String reviewType = "";
		String methodFlag = "";
		String itemQty = "";
		String itemType = "";
		String status = "";
		String calorificContPerUom = "";
		String foodItemDesc = "";
		String servingUomCode = "";
		String energy = "";
		editMenu_1 = new ArrayList();
		applyMenu_1 = new ArrayList();
		cancelMenu_1 = new ArrayList();
		//Added Against KDAH-CRF-0352 starts Here
		String servingUomDesc = "";
		String energyUomDesc = "";
		//Added Against KDAH-CRF-0352 Ends Here		
		//Added Against KDAH-CRF-0352 starts Here ICN-#65555
		String NutrientDesc = "";
		String NutrientUomQty = "";
		//Added Against KDAH-CRF-0352 Ends Here ICN-#65555				
		String mealTypeDesc = "";
		String tempMealType = null;
		UpdateMealMenuObject updateMealMenuObject = null;
		LinkedHashMap allMenuItemsMap = null;
		LinkedHashMap mealTypeMenuItemsListMap = null;
		ArrayList menuItemsList = null;
		ArrayList<String> edit_menu = new ArrayList<String>();	//gomu
		ArrayList<String> apply_menu = new ArrayList<String>();	//gomu
		ArrayList<String> cancel_menu = new ArrayList<String>();	//gomu
		String num="";//gomu
		String ing_1 = "";//gomu
		ArrayList reviewedMenuItemsList = null;
		ArrayList allMenuItemsList = null;
		ArrayList mealTypeMenuItemsList = null;
		String allValue = checkForNull(request.getParameter("allValue")); //Added Against KDAH-CRF-0349.1 [IN062717]US2
		Connection conn = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		PreparedStatement pstmt1 = null;
		ResultSet rs = null;		
		ResultSet rs2 = null;		
		ResultSet rs1 = null;		
		//gomu
		try{
		//Added against AMS-CRF-0112 starts Here
		boolean isAdditionalInstructions = false;//Added Against AMS-CRF-112		
		conn = ConnectionManager.getConnection(request);
		isAdditionalInstructions = CommonBean.isSiteSpecific(conn,"DS","PLACE_DIET_ORDER_INSTR");//Added against Ams-CRf-0112
		//Added against AMS-CRF-0112 Ends Here
			session = request.getSession();
			session.removeAttribute("ALLMENUITEMSMAP");
			allMenuItemsMap = new LinkedHashMap();
			menuItemsList = new ArrayList();
			reviewedMenuItemsList = new ArrayList();
			allMenuItemsList = new ArrayList();
			mealTypeMenuItemsList = new ArrayList();
			mealTypeMenuItemsListMap = new LinkedHashMap();
			String facility = facility_id;	//gomu
			language_id = (String)session.getAttribute("LOCALE");
			totalItems = Integer.parseInt(request.getParameter("totalItems"));
			patientId = request.getParameter("patientId");
			patientClass = request.getParameter("patientClass");
			encounterId = request.getParameter("encounterId");
			mealClass = request.getParameter("mealClass");
			dateforMenu=com.ehis.util.DateUtils.convertDate(request.getParameter("dateForMenu"),"DMY", language_id, "en");
			profileSL = request.getParameter("profileSL");
			dietType = request.getParameter("dietType");//gomu
			enableDrugYN = request.getParameter("enableDrugYN"); // Added Against AMRI-SCF-0701
			System.err.println("enableDrugYN ~~~~~~~~~~~~~~~"+enableDrugYN);
			dateFrom = com.ehis.util.DateUtils.convertDate(request.getParameter("dateFrom"),"DMY", language_id, "en");
			dateTo = com.ehis.util.DateUtils.convertDate(request.getParameter("dateTo"),"DMY", language_id, "en");
	
				System.err.println("encounterId=22=>"+encounterId);
				System.err.println("mealClass=33=>"+mealClass);
				System.err.println("dietType=44=>"+dietType);
				System.err.println("dateFrom=55=>"+dateFrom);
				System.err.println("dateTo=66=>"+dateTo);
			//System.err.println("totalItems===>"+totalItems);
			for(int i=0;i<totalItems;i++)
			{
				updateMealMenuObject = new UpdateMealMenuObject();				
				mealType = request.getParameter("mealType"+i);
				if(tempMealType != null && !tempMealType.equals(mealType))
				{
					if(!mealTypeMenuItemsListMap.containsKey(tempMealType))
					{
					mealTypeMenuItemsList.add(menuItemsList);
					mealTypeMenuItemsList.add(reviewedMenuItemsList);
					mealTypeMenuItemsListMap.put(tempMealType, mealTypeMenuItemsList);
					//System.err.println("If,mealTypeMenuItemsListMap===>"+mealTypeMenuItemsListMap);
					}
					else
					{
						mealTypeMenuItemsList = (ArrayList)mealTypeMenuItemsListMap.get(tempMealType);
						menuItemsList = (ArrayList) mealTypeMenuItemsList.get(0);
						reviewedMenuItemsList = (ArrayList) mealTypeMenuItemsList.get(1);
						menuItemsList.add(updateMealMenuObject);
						reviewedMenuItemsList.add(updateMealMenuObject);
						mealTypeMenuItemsList.clear();
						mealTypeMenuItemsList.add(menuItemsList);
						mealTypeMenuItemsList.add(reviewedMenuItemsList);
						mealTypeMenuItemsListMap.put(tempMealType, mealTypeMenuItemsList);
						//System.err.println("Else,mealTypeMenuItemsListMap===>"+mealTypeMenuItemsListMap);
					}
					menuItemsList = new ArrayList();
					reviewedMenuItemsList = new ArrayList();
					mealTypeMenuItemsList = new ArrayList();
					//System.err.println("menuItemsList===>"+menuItemsList);
					//System.err.println("reviewedMenuItemsList===>"+reviewedMenuItemsList);
					//System.err.println("mealTypeMenuItemsList===>"+mealTypeMenuItemsList);
				}
				tempMealType = mealType;
				itemCode = request.getParameter("itemCode"+i);
				menuCode = request.getParameter("menuCode"+i);
				dietType = request.getParameter("dietType"+i);
				menuSL = request.getParameter("menuSL"+i);
				mealmenuSL = request.getParameter("mealmenuSL"+i);
				reviewType = request.getParameter("reviewType"+i);
				methodFlag = request.getParameter("methodFlag"+i);
				itemQty = request.getParameter("itemQty"+i);
				itemType = request.getParameter("itemType"+i);
				status = request.getParameter("methodFlag"+i);
				System.err.println("status==>"+status);
				//Added against MMS-KH-CRF-0029.1 Starts Here	
				if(enableDrugYN.equals("Y")) // Added Against AMRI-SCF-0701
				{
					if(methodFlag.equals("5") && reviewType.equals("F"))		
				{
					System.err.println("methodFlag");
				String editMenu = "Select ds_drug_interaction(?, ?, to_date(?,'dd/mm/yyyy'),to_date(?,'dd/mm/yyyy')) ing from dual";
				pstmt = conn.prepareStatement(editMenu);
				pstmt.setString(1,facility);
				pstmt.setString(2,encounterId);
				pstmt.setString(3,dateFrom);				
				pstmt.setString(4,dateTo);				
				rs = pstmt.executeQuery();
				System.err.println("After Execution");
				if( rs!=null && rs.next())
				{
					ing_1=checkForNull(rs.getString("ing"));
					System.err.println("ing_1===>"+ing_1);
				}
					String strArray[] = ing_1.split(",");
					System.err.println("itemCode===11122222333333");
					System.err.println("itemCode===>"+itemCode);
					if(pstmt!=null) pstmt.close();	//Added Against Common-ICN-0053
					if(rs!=null) rs.close();	//Added Against Common-ICN-0054

				try{
					 for (int j=0; j < strArray.length; j++)
					{
				String sql="SELECT 1 FROM ds_food_item_ingredients b WHERE b.food_item_code = '"+itemCode+"' AND(b.ingredient_code IN (SELECT     REGEXP_SUBSTR ('"+strArray[j]+"', '[^,]+', 1, LEVEL ) AS ingr_code FROM DUAL CONNECT BY REGEXP_SUBSTR ('"+strArray[j]+"', '[^,]+', 1, LEVEL) IS NOT NULL)) AND NVL(b.EFF_STATUS,'!') = 'E'";	//Added Against ICN:72440		
				 pstmt1 = conn.prepareStatement(sql);
				 rs1 = pstmt1.executeQuery();

				while(rs1 != null && rs1.next()){
				num = rs1.getString(1);
				System.err.println("num===>"+num);
				}
				if(pstmt1!=null) pstmt1.close();	//Added Against Common-ICN-0053
				if(rs1!=null) rs1.close();	//Added Against Common-ICN-0054
				if(num.equals("1"))
				{
					System.err.println("strArray[j]===>"+strArray[j]);
				/* String sql1="select distinct f.drug_desc,e.long_desc,d.long_desc,intr_severity_level,intr_signif_level,intr_prob_level,intr_restrt_yn,b.eff_status FROM ph_patient_drug_profile a,ph_drug_interaction b,ds_food_item_ingredients c,ds_food_item d,ds_ingredient e,ph_drug f WHERE encounter_id='"+encounterId+"'AND a.drug_code = b.intr_code1 AND b.intr_code2 ='"+strArray[j]+"' AND b.intr_type2 ='F'  AND c.ingredient_code = b.intr_code2 AND c.food_item_code = d.food_item_code AND d.food_item_code ='"+itemCode+"'AND c.ingredient_code = e.ingredient_code And a.DRUG_CODE = f.DRUG_CODE AND (to_date('"+dateFrom+"', 'dd/mm/yyyy') BETWEEN TRUNC(START_DATE) AND TRUNC(END_DATE) OR to_date ('"+dateFrom+"', 'dd/mm/yyyy') BETWEEN TRUNC(START_DATE) AND TRUNC(END_DATE)) AND NVL(c.EFF_STATUS,'!') = 'E'";	//Added Against ICN:72440	*/				
				String sql1="select distinct f.drug_desc,e.long_desc,d.long_desc,intr_severity_level,intr_signif_level,intr_prob_level,intr_restrt_yn,b.eff_status FROM ph_patient_drug_profile a,ph_drug_interaction b,ds_food_item_ingredients c,ds_food_item d,ds_ingredient e,ph_drug f WHERE encounter_id='"+encounterId+"'AND a.drug_code = b.intr_code1 AND b.intr_code2 ='"+strArray[j]+"' AND b.intr_type2 ='F'  AND c.ingredient_code = b.intr_code2 AND c.food_item_code = d.food_item_code AND d.food_item_code ='"+itemCode+"'AND c.ingredient_code = e.ingredient_code AND a.DRUG_CODE = f.DRUG_CODE AND (to_date('"+dateFrom+"', 'dd/mm/yyyy') BETWEEN TRUNC(START_DATE) AND TRUNC(END_DATE) OR to_date ('"+dateFrom+"', 'dd/mm/yyyy') BETWEEN TRUNC(START_DATE) AND TRUNC(END_DATE)) AND NVL(c.EFF_STATUS,'!') = 'E' union select distinct f.drug_desc,e.long_desc,d.long_desc,intr_severity_level,intr_signif_level,intr_prob_level,intr_restrt_yn,b.eff_status FROM ph_patient_drug_profile a,ph_drug_interaction b,ds_food_item_ingredients c,ds_food_item d,ds_ingredient e,ph_drug f WHERE encounter_id='"+encounterId+"'AND a.generic_id = b.intr_code1 AND b.intr_code2 ='"+strArray[j]+"'  AND b.intr_type1 = 'G' AND b.intr_type2 ='F'  AND c.ingredient_code = b.intr_code2 AND c.food_item_code = d.food_item_code AND d.food_item_code ='"+itemCode+"' AND c.ingredient_code = e.ingredient_code AND a.DRUG_CODE = f.DRUG_CODE AND (to_date('"+dateFrom+"', 'dd/mm/yyyy') BETWEEN TRUNC(START_DATE) AND TRUNC(END_DATE) OR to_date ('"+dateFrom+"', 'dd/mm/yyyy') BETWEEN TRUNC(START_DATE) AND TRUNC(END_DATE)) AND NVL(c.EFF_STATUS,'!') = 'E'"; //Modified Against MMS-KH-SCF-0078
				System.err.println("1");
				 pstmt2 = conn.prepareStatement(sql1);
				System.err.println("2");
				 rs2 = pstmt2.executeQuery();
				while(rs2 != null && rs2.next()){
				System.err.println("4");
				String one = rs2.getString(1);
				String two = rs2.getString(2);
				String thr = rs2.getString(3);
				String four = rs2.getString(4);
				String five = rs2.getString(5);
				String six = rs2.getString(6);
				String sev = rs2.getString(7);
				String eig = rs2.getString(8);		
			
				edit_menu.add(dateFrom);
				edit_menu.add(one);
				edit_menu.add(two);
				edit_menu.add(thr);
				edit_menu.add(four);
				edit_menu.add(five);
				edit_menu.add(six);
				edit_menu.add(sev);
				edit_menu.add(eig);
				setEditMenu(edit_menu);
				System.err.println("edit_menu===>"+edit_menu);
					}
					if(pstmt2!=null) pstmt2.close();	//Added Against Common-ICN-0053
					if(rs2!=null) rs2.close();	//Added Against Common-ICN-0054

					}
				}
			}
		catch(Exception ee){
		ee.printStackTrace();}	
				}
				
				if(reviewType.equals("N") || reviewType.equals("F"))		
				{
				String editMenu = "Select ds_drug_interaction(?, ?, to_date(?,'dd/mm/yyyy'),to_date(?,'dd/mm/yyyy')) ing from dual";
				pstmt = conn.prepareStatement(editMenu);
				pstmt.setString(1,facility);
				pstmt.setString(2,encounterId);
				pstmt.setString(3,dateFrom);				
				pstmt.setString(4,dateTo);				
				rs = pstmt.executeQuery();
				System.err.println("After Execution");
				if( rs!=null && rs.next())
				{
					ing_1=checkForNull(rs.getString("ing"));
					System.err.println("ing_1===>"+ing_1);
				}
					String strArray[] = ing_1.split("~");
					System.err.println("itemCode===11122222333333");
					System.err.println("itemCode===>"+itemCode);
					
				try{
					 for (int j=0; j < strArray.length; j++)
					{
						String splitVal[] = strArray[j].split("!");
						System.err.println("Drug Date==>"+splitVal[0]);
						String date=splitVal[0];
						System.err.println("date==>"+date);
						System.err.println("Drug Ing==>"+splitVal[1]);
						String ing_code[]= splitVal[1].split(",");
					for(int k=0; k<ing_code.length; k++)
					{
						
						System.err.println("ing_code==>"+ing_code[k]);
				String sql="SELECT 1 FROM ds_food_item_ingredients b WHERE b.food_item_code = '"+itemCode+"' AND(b.ingredient_code IN (SELECT     REGEXP_SUBSTR ('"+ing_code[k]+"', '[^,]+', 1, LEVEL ) AS ingr_code FROM DUAL CONNECT BY REGEXP_SUBSTR ('"+ing_code[k]+"', '[^,]+', 1, LEVEL) IS NOT NULL)) AND NVL(b.EFF_STATUS,'!') = 'E'";	//Added Against ICN:72440		
				 pstmt1 = conn.prepareStatement(sql);
				 rs1 = pstmt1.executeQuery();

				while(rs1 != null && rs1.next()){
				num = rs1.getString(1);
				System.err.println("num===>"+num);
				}
				if(num.equals("1"))
				{
					//System.err.println("strArray[j]===>"+strArray[j]);
				/* String sql1="select distinct f.drug_desc,e.long_desc,d.long_desc,intr_severity_level,intr_signif_level,intr_prob_level,intr_restrt_yn,b.eff_status FROM ph_patient_drug_profile a,ph_drug_interaction b,ds_food_item_ingredients c,ds_food_item d,ds_ingredient e,ph_drug f WHERE encounter_id='"+encounterId+"'AND a.drug_code = b.intr_code1 AND b.intr_code2 ='"+ing_code[k]+"' AND b.intr_type2 ='F'  AND c.ingredient_code = b.intr_code2 AND c.food_item_code = d.food_item_code AND d.food_item_code ='"+itemCode+"'AND c.ingredient_code = e.ingredient_code And a.DRUG_CODE = f.DRUG_CODE AND (to_date('"+date+"', 'dd/mm/yyyy') BETWEEN TRUNC(START_DATE) AND TRUNC(END_DATE) OR to_date ('"+date+"', 'dd/mm/yyyy') BETWEEN TRUNC(START_DATE) AND TRUNC(END_DATE)) AND NVL(c.EFF_STATUS,'!') = 'E'";	//Added Against ICN:72440
 				*/			
				String sql1="select distinct f.drug_desc,e.long_desc,d.long_desc,intr_severity_level,intr_signif_level,intr_prob_level,intr_restrt_yn,b.eff_status FROM ph_patient_drug_profile a,ph_drug_interaction b,ds_food_item_ingredients c,ds_food_item d,ds_ingredient e,ph_drug f WHERE encounter_id='"+encounterId+"'AND a.drug_code = b.intr_code1 AND b.intr_code2 ='"+ing_code[k]+"' AND b.intr_type2 ='F'  AND c.ingredient_code = b.intr_code2 AND c.food_item_code = d.food_item_code AND d.food_item_code ='"+itemCode+"'AND c.ingredient_code = e.ingredient_code AND a.DRUG_CODE = f.DRUG_CODE AND (to_date('"+date+"', 'dd/mm/yyyy') BETWEEN TRUNC(START_DATE) AND TRUNC(END_DATE) OR to_date ('"+date+"', 'dd/mm/yyyy') BETWEEN TRUNC(START_DATE) AND TRUNC(END_DATE)) AND NVL(c.EFF_STATUS,'!') = 'E' union select distinct f.drug_desc,e.long_desc,d.long_desc,intr_severity_level,intr_signif_level,intr_prob_level,intr_restrt_yn,b.eff_status FROM ph_patient_drug_profile a,ph_drug_interaction b,ds_food_item_ingredients c,ds_food_item d,ds_ingredient e,ph_drug f WHERE encounter_id='"+encounterId+"'AND a.generic_id = b.intr_code1 AND b.intr_code2 ='"+ing_code[k]+"'  AND b.intr_type1 = 'G' AND b.intr_type2 ='F'  AND c.ingredient_code = b.intr_code2 AND c.food_item_code = d.food_item_code AND d.food_item_code ='"+itemCode+"' AND c.ingredient_code = e.ingredient_code AND a.DRUG_CODE = f.DRUG_CODE AND (to_date('"+date+"', 'dd/mm/yyyy') BETWEEN TRUNC(START_DATE) AND TRUNC(END_DATE) OR to_date ('"+date+"', 'dd/mm/yyyy') BETWEEN TRUNC(START_DATE) AND TRUNC(END_DATE)) AND NVL(c.EFF_STATUS,'!') = 'E'";  //Modified Against MMS-KH-SCF-0078

				System.err.println("1");
				 pstmt2 = conn.prepareStatement(sql1);
				System.err.println("2");
				 rs2 = pstmt2.executeQuery();
				while(rs2 != null && rs2.next()){
				System.err.println("4");
				String one = rs2.getString(1);
				String two = rs2.getString(2);
				String thr = rs2.getString(3);
				String four = rs2.getString(4);
				String five = rs2.getString(5);
				String six = rs2.getString(6);
				String sev = rs2.getString(7);
				String eig = rs2.getString(8);		
				
				apply_menu.add(date);
				apply_menu.add(one);
				apply_menu.add(two);
				apply_menu.add(thr);
				apply_menu.add(four);
				apply_menu.add(five);
				apply_menu.add(six);
				apply_menu.add(sev);
				apply_menu.add(eig);
				setApplyMenu(apply_menu);
				System.err.println("apply_menu===>"+apply_menu);
				}}
				}
				}
				}
		catch(Exception ee){
		ee.printStackTrace();}	
				}
				
				if(reviewType.equals("M"))		
				{
				String editMenu = "Select ds_drug_interaction(?, ?, to_date(?,'dd/mm/yyyy'),to_date(?,'dd/mm/yyyy')) ing from dual";
				pstmt = conn.prepareStatement(editMenu);
				pstmt.setString(1,facility);
				pstmt.setString(2,encounterId);
				pstmt.setString(3,dateFrom);				
				pstmt.setString(4,dateTo);				
				rs = pstmt.executeQuery();
				System.err.println("After Execution");
				if( rs!=null && rs.next())
				{
					ing_1=checkForNull(rs.getString("ing"));
					System.err.println("ing_1===>"+ing_1);
				}
					String strArray[] = ing_1.split("~");
					System.err.println("itemCode===11122222333333");
					System.err.println("itemCode===>"+itemCode);
					if(pstmt!=null) pstmt.close();	//Added Against Common-ICN-0053
					if(rs!=null) rs.close();	//Added Against Common-ICN-0054
				try{ArrayList<String> list= new ArrayList<String>();
					 for (int j=0; j < strArray.length; j++)
					{
						String splitVal[] = strArray[j].split("!");
						System.err.println("Drug Date==>"+splitVal[0]);
						System.err.println("Drug Ing==>"+splitVal[1]);
						list.add(splitVal[1]);
						System.err.println("list===>"+list);
						
					}
					String date = dateFrom; 
					ArrayList<String> nonDupList = new ArrayList<String>();
						Iterator<String> dupIter = list.iterator();
						while(dupIter.hasNext())
						{
						String dupWord = dupIter.next();
						if(nonDupList.contains(dupWord))
						{
							dupIter.remove();
						}else
						{
							nonDupList.add(dupWord);
						}
						}
					  System.err.println("duplicates==>"+nonDupList);
					System.err.println("newList===>");
					String frnames[]=nonDupList.toArray(new String[nonDupList.size()]);
		for(String m: frnames)
		{
			System.err.println("mmmmmm=====>"+m);
			String[] ing_code = m.split(",");
					 for(int k=0; k<ing_code.length; k++)
					{
						System.err.println("ing_code==>"+ing_code[k]);
				String sql="SELECT 1 FROM ds_food_item_ingredients b WHERE b.food_item_code = '"+itemCode+"' AND(b.ingredient_code IN (SELECT     REGEXP_SUBSTR ('"+ing_code[k]+"', '[^,]+', 1, LEVEL ) AS ingr_code FROM DUAL CONNECT BY REGEXP_SUBSTR ('"+ing_code[k]+"', '[^,]+', 1, LEVEL) IS NOT NULL)) AND NVL(b.EFF_STATUS,'!') = 'E'";		//Added Against ICN:72440	
				 pstmt1 = conn.prepareStatement(sql);
				 rs1 = pstmt1.executeQuery();

				while(rs1 != null && rs1.next()){
				num = rs1.getString(1);
				System.err.println("num===>"+num);
				}
				if(pstmt1!=null) pstmt1.close();	//Added Against Common-ICN-0053
				if(rs1!=null) rs1.close();	//Added Against Common-ICN-0054

				if(num.equals("1"))
				{
					//System.err.println("strArray[j]===>"+strArray[j]);
				/* String sql1="select distinct f.drug_desc,e.long_desc,d.long_desc,intr_severity_level,intr_signif_level,intr_prob_level,intr_restrt_yn,b.eff_status FROM ph_patient_drug_profile a,ph_drug_interaction b,ds_food_item_ingredients c,ds_food_item d,ds_ingredient e,ph_drug f WHERE encounter_id='"+encounterId+"'AND a.drug_code = b.intr_code1 AND b.intr_code2 ='"+ing_code[k]+"' AND b.intr_type2 ='F'  AND c.ingredient_code = b.intr_code2 AND c.food_item_code = d.food_item_code AND d.food_item_code ='"+itemCode+"'AND c.ingredient_code = e.ingredient_code And a.DRUG_CODE = f.DRUG_CODE AND (to_date('"+date+"', 'dd/mm/yyyy') BETWEEN TRUNC(START_DATE) AND TRUNC(END_DATE) OR to_date ('"+date+"', 'dd/mm/yyyy') BETWEEN TRUNC(START_DATE) AND TRUNC(END_DATE)) AND NVL(c.EFF_STATUS,'!') = 'E'"; */				
				String sql1="select distinct f.drug_desc,e.long_desc,d.long_desc,intr_severity_level,intr_signif_level,intr_prob_level,intr_restrt_yn,b.eff_status FROM ph_patient_drug_profile a,ph_drug_interaction b,ds_food_item_ingredients c,ds_food_item d,ds_ingredient e,ph_drug f WHERE encounter_id='"+encounterId+"'AND a.drug_code = b.intr_code1 AND b.intr_code2 ='"+ing_code[k]+"' AND b.intr_type2 ='F'  AND c.ingredient_code = b.intr_code2 AND c.food_item_code = d.food_item_code AND d.food_item_code ='"+itemCode+"'AND c.ingredient_code = e.ingredient_code AND a.DRUG_CODE = f.DRUG_CODE AND (to_date('"+date+"', 'dd/mm/yyyy') BETWEEN TRUNC(START_DATE) AND TRUNC(END_DATE) OR to_date ('"+date+"', 'dd/mm/yyyy') BETWEEN TRUNC(START_DATE) AND TRUNC(END_DATE)) AND NVL(c.EFF_STATUS,'!') = 'E' union select distinct f.drug_desc,e.long_desc,d.long_desc,intr_severity_level,intr_signif_level,intr_prob_level,intr_restrt_yn,b.eff_status FROM ph_patient_drug_profile a,ph_drug_interaction b,ds_food_item_ingredients c,ds_food_item d,ds_ingredient e,ph_drug f WHERE encounter_id='"+encounterId+"'AND a.generic_id = b.intr_code1 AND b.intr_code2 ='"+ing_code[k]+"'  AND b.intr_type1 = 'G' AND b.intr_type2 ='F'  AND c.ingredient_code = b.intr_code2 AND c.food_item_code = d.food_item_code AND d.food_item_code ='"+itemCode+"' AND c.ingredient_code = e.ingredient_code AND a.DRUG_CODE = f.DRUG_CODE AND (to_date('"+date+"', 'dd/mm/yyyy') BETWEEN TRUNC(START_DATE) AND TRUNC(END_DATE) OR to_date ('"+date+"', 'dd/mm/yyyy') BETWEEN TRUNC(START_DATE) AND TRUNC(END_DATE)) AND NVL(c.EFF_STATUS,'!') = 'E'"; //Modified Against MMS-KH-SCF-0078
				
				System.err.println("1");
				 pstmt2 = conn.prepareStatement(sql1);
				System.err.println("2");
				 rs2 = pstmt2.executeQuery();
				while(rs2 != null && rs2.next()){
				System.err.println("4");
				String one = rs2.getString(1);
				String two = rs2.getString(2);
				String thr = rs2.getString(3);
				String four = rs2.getString(4);
				String five = rs2.getString(5);
				String six = rs2.getString(6);
				String sev = rs2.getString(7);
				String eig = rs2.getString(8);		
				System.err.println("one===>"+one);
				System.err.println("two===>"+two);
				System.err.println("thr===>"+thr);
				System.err.println("four===>"+four);
				System.err.println("five===>"+five);
				System.err.println("six===>"+six);
				System.err.println("sev===>"+sev);
				System.err.println("eig===>"+eig);
				cancel_menu.add(date);
				cancel_menu.add(one);
				cancel_menu.add(two);
				cancel_menu.add(thr);
				cancel_menu.add(four);
				cancel_menu.add(five);
				cancel_menu.add(six);
				cancel_menu.add(sev);
				cancel_menu.add(eig);
				setCancelMenu(cancel_menu);
				System.err.println("cancel_menu===>"+cancel_menu);
					}
					if(pstmt2!=null) pstmt2.close();	//Added Against Common-ICN-0053
					if(rs2!=null) rs2.close();	//Added Against Common-ICN-0054

				}
				}  
				}}
		catch(Exception ee){
		ee.printStackTrace();}	
				}
				}
					//Added against MMS-KH-CRF-0029.1 Ends Here	
				//AMS-CRF-0112
				if(isAdditionalInstructions)									
					additionalinstructions=request.getParameter("AdditionalInstruction"+mealType);//AMS-CRF-0112
				//AMS-CRF-0112
				calorificContPerUom = request.getParameter("calorificContPerUom"+i);
				foodItemDesc = request.getParameter("foodItemDesc"+i);
				servingUomCode = request.getParameter("servingCodeUom"+i);
				energy = request.getParameter("energy");
				//Added Against KDAH-CRF-0352 starts Here
				servingUomDesc = request.getParameter("servingCodeUomDesc"+i);
				energyUomDesc =request.getParameter("energyUomDesc");
				//Added Against KDAH-CRF-0352 Ends Here
				
				//Added Against KDAH-CRF-0352 starts Here ICN-#65555
				NutrientDesc = request.getParameter("NutrientDesc"+i);
				NutrientUomQty =request.getParameter("NutrientUomQty"+i);
				//Added Against KDAH-CRF-0352 Ends Here ICN-#65555
				
				mealTypeDesc = request.getParameter("mealTypeDesc"+i);				

				//common values
				updateMealMenuObject.setLanguageId(language_id);
				updateMealMenuObject.setTotalItems(totalItems);
				updateMealMenuObject.setPatientId(patientId);
				updateMealMenuObject.setPatientClass(patientClass);
				updateMealMenuObject.setEncounterId(encounterId);
				updateMealMenuObject.setMealClass(mealClass);
				updateMealMenuObject.setDateforMenu(dateforMenu);
				updateMealMenuObject.setProfileSL(profileSL);
				updateMealMenuObject.setDateFrom(dateFrom);
				updateMealMenuObject.setDateTo(dateTo);
				//request values
				updateMealMenuObject.setMealType(mealType);
				updateMealMenuObject.setItemCode(itemCode);
				updateMealMenuObject.setMenuCode(menuCode);
				updateMealMenuObject.setDietType(dietType);
				updateMealMenuObject.setMenuSL(menuSL);
				updateMealMenuObject.setReviewSLNo(menuSL);
				updateMealMenuObject.setMealmenuSL(mealmenuSL);
				updateMealMenuObject.setReviewType(reviewType);
				updateMealMenuObject.setMethodFlag(methodFlag);
				updateMealMenuObject.setItemQty(itemQty);
				//Added against AMS-CRF-0112 starts here
				if(isAdditionalInstructions)
				{
				//Added against CRF-112 ICN-64406 starts Here 
				if(!additionalinstructions.equalsIgnoreCase("") || additionalinstructions != "" || !additionalinstructions.equalsIgnoreCase("null") || additionalinstructions != "null" )
					{
							updateMealMenuObject.setAdditionalInstructions2(mealType,additionalinstructions);
							updateMealMenuObjectInstr.setAdditionalInstructions2(mealType,additionalinstructions);

							updateMealMenuObject.setAdditionalInstrDate(dateforMenu);
							updateMealMenuObjectInstr.setAdditionalInstrDate(dateforMenu);	
					}
				}				
				//Added against CRF-112 ICN-64406 Ends Here 
				//Added against AMS-CRF-0112 Ends here
				updateMealMenuObject.setItemType(itemType);
				updateMealMenuObject.setStatus(status);
				updateMealMenuObject.setCalorificContPerUom(calorificContPerUom);

				updateMealMenuObject.setItemShortDesc(foodItemDesc);
				updateMealMenuObject.setServingUomCode(servingUomCode);
				updateMealMenuObject.setEnergyUom(energy);
				//Added Against KDAH-CRF-0352 starts Here
				updateMealMenuObject.setServingUomDesc(servingUomDesc);
				updateMealMenuObject.setEnergyUomDesc(energyUomDesc);
				//Added Against KDAH-CRF-0352 Ends Here
				
				//Added Against KDAH-CRF-0352 starts Here ICN-#65555
				updateMealMenuObject.setNutrientDesc(NutrientDesc);
				updateMealMenuObject.setServingUomQty(NutrientUomQty);
				//Added Against KDAH-CRF-0352 Ends Here ICN-#65555
				updateMealMenuObject.setMealTypeShortDesc(mealTypeDesc);
				updateMealMenuObject.setAllValue(allValue); //Added Against KDAH-CRF-0349.1 [IN062717]US2
				if(reviewType.equals("N"))
					menuItemsList.add(updateMealMenuObject);
				else
					reviewedMenuItemsList.add(updateMealMenuObject);
				allMenuItemsList.add(updateMealMenuObject);
			}
			if(!mealTypeMenuItemsListMap.containsKey(tempMealType))
			{
			mealTypeMenuItemsList.add(menuItemsList);
			mealTypeMenuItemsList.add(reviewedMenuItemsList);
			mealTypeMenuItemsListMap.put(tempMealType, mealTypeMenuItemsList);
			}
			else
			{
				mealTypeMenuItemsList = (ArrayList)mealTypeMenuItemsListMap.get(tempMealType);

				menuItemsList = (ArrayList) mealTypeMenuItemsList.get(0);
				reviewedMenuItemsList = (ArrayList) mealTypeMenuItemsList.get(1);	

				if(reviewType.equals("N"))
					menuItemsList.add(updateMealMenuObject);
				else
					reviewedMenuItemsList.add(updateMealMenuObject);

				mealTypeMenuItemsList.clear();
				mealTypeMenuItemsList.add(menuItemsList);
				mealTypeMenuItemsList.add(reviewedMenuItemsList);
				mealTypeMenuItemsListMap.put(tempMealType, mealTypeMenuItemsList);
			}			

			allMenuItemsMap.put("MEALTYPEMENUITEMSLISTMAP", mealTypeMenuItemsListMap);
			allMenuItemsMap.put("ALLMENUITEMS", allMenuItemsList);			
			if(allMenuItemsMap != null && allMenuItemsMap.size() > 0)
				session.setAttribute("ALLMENUITEMSMAP", allMenuItemsMap);
				
		}catch(Exception ee){
			ee.printStackTrace();
		}
		finally{
			if(conn!=null)ConnectionManager.returnConnection(conn,request);	//Added Against Common-ICN-0031
			if(pstmt!=null) pstmt.close();
			if(rs!=null) rs.close();			
			if(pstmt2!=null) pstmt2.close();	
			if(pstmt1!=null) pstmt1.close();
			if(rs2!=null) rs2.close();		
			if(rs1!=null) rs1.close();		
		}
	}

	private void updateMealMenuItems(HttpServletRequest request,HttpServletResponse response, ArrayList updateMealsDetailsList, long profileSl) throws SQLException
	{
		boolean isInsertSuccess = false;
		Connection conn = ConnectionManager.getConnection(request);
		PreparedStatement insertPstmt = null, updatePstmt = null,addedinstrPstmt2=null,selectinstrPstmt=null,pstmt=null;//Modified Against AMS-CRF-0112 and KDAH-CRF-0349.1 [IN062717]US2
		ResultSet rst = null, rsnew = null; // Added Against KDAH-CRF-0349.1/US003[IN:067380] & AMS-SCF-0778
		StringBuffer insertSql = new StringBuffer();
		StringBuffer updateSql = new StringBuffer();
		UpdateMealMenuObject updateMealMenuObject = null;
         //Added against AMS-CRF-0112 starts Here 
		boolean isAdditionalInstructions = false;
		isAdditionalInstructions = CommonBean.isSiteSpecific(conn,"DS","PLACE_DIET_ORDER_INSTR");//Added against Ams-CRf-0112						
		String selectinstrsql="";
		String AdditionalInstr_Insert_sql="";
		String AdditionalInstr_update_sql="";
		int selectInstrcount=0;
		//Added against AMS-CRF-0112 Ends Here 
		/* String languageId = "";
		int totalItems = 0; */ //Common-ICN-0055
		String patientId = "";
		String patientClass = "";
		String encounterId = "";
		String mealClass = "";
		String dateforMenu = "";
		String profileSL1 = ""; //Added Against KDAH-CRF-0349.1[IN:067479]
		String dateFrom = "";
		String dateTo = "";
		String mealType = "";
		String itemCode = "";
		String menuCode = "";
		String dietType = "";
		String menuSL = "";
		String mealmenuSL = "";
		String reviewType = "";
		String methodFlag = "";
		String itemQty = "";
		String itemType = "";
		String status = "";
		String error_value = "0" ;
		String error = "";
		/* Added Against Start KDAH-CRF-0349.1 [IN062717]US2 */
		List<Date> dates = new ArrayList<Date>();
		DateFormat formatter ; 
		formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date startDate = null, endDate = null;
		int count = 1;
		String allDate = "", assigningDate = "";
		/* Added Against Start KDAH-CRF-0349.1 [IN062717]US2 */
		try
		{
			insertSql.append("	INSERT INTO ds_epsd_diet_prof_dtl_reviewed	");
			insertSql.append("	(patient_id, patient_class, encounter_id, profile_sl, meal_type,	");
			insertSql.append("	item_code, serving_date, cycle_day_ref, review_type,	");
			insertSql.append("	nil_by_mouth_yn, period_from, period_to, diet_type, meal_class,	");
			insertSql.append("	item_sl, item_type, item_qty, pref_option, menu_code, status,	");
			insertSql.append("	added_by_id, added_date, added_facility_id, added_at_ws_no,	");
			insertSql.append("	modified_by_id, modified_date, modified_facility_id,	");
			insertSql.append("	modified_at_ws_no, operating_facility_id, review_slno 	");
			insertSql.append("  								 )	"); 
			insertSql.append("	VALUES (?, ?, ?, ?, ?,	");
			insertSql.append("	?, TO_DATE (?, 'DD/MM/YYYY'), ?, ?,	");
			insertSql.append("	?, TO_DATE (?, 'DD/MM/YYYY'), TO_DATE (?, 'DD/MM/YYYY'), ?, ?,	");
			insertSql.append("	?, ?, ?, ?, ?, ?,	");
			insertSql.append("	?, ?, ?, ?,	");
			insertSql.append("	?, ?, ?,	");
			insertSql.append("	?, ?, ?	");
			insertSql.append("	)			"); 						
			insertPstmt = conn.prepareStatement(insertSql.toString());			
			
			//--------------------------- Start of For loop -----------------------------
			for(int i=0;i<updateMealsDetailsList.size();i++)
			{
				updateSql.delete(0, updateSql.length());//AMS-CRF-0122					
				updateMealMenuObject = (UpdateMealMenuObject)updateMealsDetailsList.get(i);
				patientId = updateMealMenuObject.getPatientId();
				patientClass = updateMealMenuObject.getPatientClass();
				encounterId = updateMealMenuObject.getEncounterId(); 
				mealClass = updateMealMenuObject.getMealClass();
				dateforMenu = updateMealMenuObject.getDateforMenu();
				profileSL1 = updateMealMenuObject.getProfileSL(); //Added Against KDAH-CRF-0349.1[IN:067479]
				dateFrom = updateMealMenuObject.getDateFrom();
				dateTo = updateMealMenuObject.getDateTo();
				
				mealType = updateMealMenuObject.getMealType(); 
				itemCode = updateMealMenuObject.getItemCode(); 
				menuCode = updateMealMenuObject.getMenuCode();
				dietType = updateMealMenuObject.getDietType();
				menuSL = updateMealMenuObject.getMenuSL();
				if(menuSL == null)
				menuSL = "";
				mealmenuSL = updateMealMenuObject.getMealmenuSL();
				reviewType = updateMealMenuObject.getReviewType();
				methodFlag = updateMealMenuObject.getMethodFlag();
				itemQty = updateMealMenuObject.getItemQty();
				itemType = updateMealMenuObject.getItemType();
				status = updateMealMenuObject.getStatus();
				
				/* Added Start Against KDAH-CRF-0349.1 [IN062717]US2 */
				allDate = updateMealMenuObject.getAllValue(); 				
				startDate = (Date)formatter.parse(dateforMenu);
				endDate = (Date)formatter.parse(dateTo);
				long interval = 24*1000 * 60 * 60; 
				long endTime =endDate.getTime() ; 
				long curTime = startDate.getTime();
				while (curTime <= endTime) {
				dates.add(new Date(curTime));
				curTime += interval; 
				}				
				if(allDate == null)
				allDate = ""; 
				
				if(allDate.equals("ALL")){						
				String DiffCount="SELECT  TO_DATE(?,'DD/MM/YYYY') - TO_DATE(?,'DD/MM/YYYY') datediff FROM DUAL";
				pstmt = conn.prepareStatement(DiffCount);
				pstmt.setString(1,dateTo);
				pstmt.setString(2,dateforMenu);
				rst = pstmt.executeQuery();
				//System.err.println("4450,before,count==="+count);
				while(rst!= null && rst.next()){
					count = rst.getInt("datediff");	
					count++;
				}
				if(pstmt!=null) pstmt.close();	//Added Against Common-ICN-0053
				if(rst!=null) rst.close();	//Added Against Common-ICN-0054
				}
			for(int j=0;j<count;j++){	
				Date lDate =(Date)dates.get(j);
				assigningDate = formatter.format(lDate);  
				dateforMenu = assigningDate;
				updateSql.delete(0, updateSql.length());
				/* Added End Against KDAH-CRF-0349.1 [IN062717]US2 */
				
				updateSql.append("	UPDATE ds_epsd_diet_prof_dtl_reviewed	");
				updateSql.append("	SET patient_id = ?,	");
				updateSql.append("	patient_class = ?,	");
				updateSql.append("	encounter_id = ?,	");
				updateSql.append("	profile_sl = ?,	");
				updateSql.append("	meal_type = ?,	");
				updateSql.append("	item_code = ?,	");
				updateSql.append("	serving_date = TO_DATE (?, 'DD/MM/YYYY'),	");
				updateSql.append("	cycle_day_ref = ?,	");
				updateSql.append("	review_type = ?,	");
				updateSql.append("	nil_by_mouth_yn = ?,	");
				updateSql.append("	period_from = TO_DATE (?, 'DD/MM/YYYY'),	");
				updateSql.append("	period_to = TO_DATE (?, 'DD/MM/YYYY'),	");
				updateSql.append("	diet_type = ?,	");
				updateSql.append("	meal_class = ?,	");
				updateSql.append("	item_sl = ?,	");
				updateSql.append("	item_type = ?,	");
				updateSql.append("	item_qty = ?,	");
				updateSql.append("	pref_option = ?,	");
				updateSql.append("	menu_code = ?,	");
				updateSql.append("	status = ?,	");
				updateSql.append("	modified_by_id = ?,	");
				//Added Against CRF-0122 Starts here
				if(status.equalsIgnoreCase("6"))
				{
					updateSql.append("	modified_date = ?,	");
				}
				//Added Against CRF-0122 Ends Here
				updateSql.append("	modified_facility_id = ?,	");
				updateSql.append("	modified_at_ws_no = ?	");
				updateSql.append("	WHERE operating_facility_id = ? AND review_slno = ?	");
				updatePstmt = conn.prepareStatement(updateSql.toString());			
				
           //Added against AMS-CRF-0112 starts Here  
			if(isAdditionalInstructions)
			{
				selectinstrsql="select count(*) from DS_ADDT_INST_FOR_MEAL where ENCOUNTER_ID='"+encounterId+"' AND PROFILE_SL='"+profileSl+"'  AND (to_char(MENU_DATE , 'dd/mm/yyyy')='"+dateforMenu+"' AND MEAL_TYPE='"+mealType+"' )";
				selectinstrPstmt=conn.prepareStatement(selectinstrsql);
				rsnew=selectinstrPstmt.executeQuery();//AMS-SCF-0778
				rsnew.next();
				selectInstrcount = rsnew.getInt(1);
				if(selectinstrPstmt!=null) selectinstrPstmt.close();	//Added Against Common-ICN-0053
				if(rsnew!=null) rsnew.close();	//Added Against Common-ICN-0054
			if(selectInstrcount > 0)
			  {
				AdditionalInstr_update_sql="UPDATE DS_ADDT_INST_FOR_MEAL SET MEAL_ADDT_INST=?,MODIFIED_BY_ID=?,MODIFIED_AT_WS_NO=?,MODIFIED_FACILITY_ID=?,MODIFIED_DATE=? WHERE ENCOUNTER_ID=? AND PROFILE_SL=? AND MEAL_TYPE=? AND (to_char(MENU_DATE , 'dd/mm/yyyy')=? )";
				addedinstrPstmt2=conn.prepareStatement(AdditionalInstr_update_sql);
			  }			
			 else
				{
					AdditionalInstr_Insert_sql="insert into DS_ADDT_INST_FOR_MEAL  (MEAL_ADDT_INST,MENU_DATE,ENCOUNTER_ID,PROFILE_SL,MEAL_TYPE,OPERATING_FACILITY_ID,ADDED_BY_ID,ADDED_AT_WS_NO,ADDED_FACILITY_ID,ADDED_DATE,MODIFIED_BY_ID,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID,MODIFIED_DATE) Values (?,TO_DATE (?, 'DD/MM/YYYY'),?,?,?,?,?,?,?,?,?,?,?,?)";
					addedinstrPstmt2=conn.prepareStatement(AdditionalInstr_Insert_sql);
				}
			}
			//Added against AMS-CRF-0112 Ends Here  
			/* Added Start Against KDAH-CRF-0349.1/US003[IN:067380] */
			int dayRefNo,isMenuAvail,reviewSlNoVal; //Added Against KDAH-CRF-0349.1[IN:067479](reviewSlNoVal)
			String menuCodeVal = "";
			dayRefNo = getDayRefNo1(request,dateforMenu,dietType,mealClass,facility_id);
			menuCodeVal = getMenu(request,dietType,mealClass,facility_id,mealType,dayRefNo);
			isMenuAvail = getMenuAvail(request,dietType,mealClass,facility_id,mealType,dayRefNo,itemCode,menuCodeVal);
			/* Added End Against KDAH-CRF-0349.1/US003[IN:067380] */
			
				if(mealmenuSL.equals("0"))
				{				
					if(!(reviewType.equals("N")))
					{
						// Below Condition Added Against KDAH-CRF-0349.1/US003[IN:067380] 
						if(isMenuAvail>0 || methodFlag.equals("5")) 
						{
						int reviewSl=getReviewSLNum(request);
						insertPstmt.setString(1,patientId);
						insertPstmt.setString(2,patientClass);
						insertPstmt.setString(3,encounterId);
						insertPstmt.setLong(4,profileSl);
						insertPstmt.setString(5,mealType);
						insertPstmt.setString(6,itemCode);
						insertPstmt.setString(7,dateforMenu); //serving_date(7)- dateforMenu 
						insertPstmt.setString(8,"1");
						insertPstmt.setString(9,reviewType);
						insertPstmt.setString(10,"");
						insertPstmt.setString(11,dateFrom); //period_from(11)-dateFrom
						insertPstmt.setString(12,dateTo);	//period_to(12)-dateTo   
						insertPstmt.setString(13,dietType);
						insertPstmt.setString(14, mealClass);
						insertPstmt.setInt(15,i+1);
						insertPstmt.setString(16,itemType);
						insertPstmt.setString(17,itemQty);
						insertPstmt.setString(18,"" );
						insertPstmt.setString(19,menuCode);
						insertPstmt.setString(20,status);
						insertPstmt.setString(21,login_user);
						insertPstmt.setTimestamp(22, new  java.sql.Timestamp(System.currentTimeMillis()));
						insertPstmt.setString(23,facility_id);
						insertPstmt.setString(24,str_client_ip_address);
						insertPstmt.setString(25,login_user);
						insertPstmt.setTimestamp(26, new  java.sql.Timestamp(System.currentTimeMillis()));
						insertPstmt.setString(27,facility_id);
						insertPstmt.setString(28,str_client_ip_address);
						insertPstmt.setString(29,facility_id);
						insertPstmt.setInt(30,reviewSl+1);						
						int row=insertPstmt.executeUpdate();

		   if(isAdditionalInstructions)
			{	
		//System.err.println("selectInstrcount=4879==>"+selectInstrcount);		
			if(selectInstrcount > 0)
			  {				
				addedinstrPstmt2.setString(1,updateMealMenuObjectInstr.getAdditionalInstructions2(mealType));
				addedinstrPstmt2.setString(2,login_user);
				addedinstrPstmt2.setString(3,str_client_ip_address);
				addedinstrPstmt2.setString(4,facility_id);
				addedinstrPstmt2.setTimestamp(5, new  java.sql.Timestamp(System.currentTimeMillis()));
				addedinstrPstmt2.setString(6,encounterId);
				addedinstrPstmt2.setLong(7,profileSl);
				addedinstrPstmt2.setString(8,mealType);
				addedinstrPstmt2.setString(9,dateforMenu);

				addedinstrPstmt2.executeUpdate();
			  }else{
					addedinstrPstmt2.setString(1,updateMealMenuObjectInstr.getAdditionalInstructions2(mealType));
					addedinstrPstmt2.setString(2,dateforMenu);
					addedinstrPstmt2.setString(3,encounterId);
					addedinstrPstmt2.setLong(4,profileSl);
					addedinstrPstmt2.setString(5,mealType);	
					addedinstrPstmt2.setString(6,facility_id);
					addedinstrPstmt2.setString(7,login_user);
					addedinstrPstmt2.setString(8,str_client_ip_address);
					addedinstrPstmt2.setString(9,facility_id);
					addedinstrPstmt2.setTimestamp(10, new  java.sql.Timestamp(System.currentTimeMillis()));
					addedinstrPstmt2.setString(11,login_user);
					addedinstrPstmt2.setString(12,str_client_ip_address);
					addedinstrPstmt2.setString(13,facility_id);
					addedinstrPstmt2.setTimestamp(14, new  java.sql.Timestamp(System.currentTimeMillis()));
					addedinstrPstmt2.executeUpdate();
				}
			}
			//Added Against AMS-CRF-0112 Ends Here
						if (row >0)
						{
							isInsertSuccess = true;
							conn.commit();
						}
						else{ 							
							conn.rollback();
						}
						
						} //Added Against KDAH-CRF-0349.1/US003[IN:067380] (isMenuAvail if cond end)
					}		// (reviewType if cond End)			
					
			//Added against CRF-0112 starts Here
			else if(isAdditionalInstructions)
			{	
				//System.err.println("selectInstrcount=4927==>"+selectInstrcount);		
				if(selectInstrcount > 0)
				{						
					addedinstrPstmt2.setString(1,updateMealMenuObjectInstr.getAdditionalInstructions2(mealType));
					addedinstrPstmt2.setString(2,login_user);
					addedinstrPstmt2.setString(3,str_client_ip_address);
					addedinstrPstmt2.setString(4,facility_id);
					addedinstrPstmt2.setTimestamp(5, new  java.sql.Timestamp(System.currentTimeMillis()));
					addedinstrPstmt2.setString(6,encounterId);
					addedinstrPstmt2.setLong(7,profileSl);
					addedinstrPstmt2.setString(8,mealType);
					addedinstrPstmt2.setString(9,dateforMenu);
					int row1=addedinstrPstmt2.executeUpdate();
						if (row1 >0)
						{
							isInsertSuccess = true;
							conn.commit();						
						}
						else
						{					
						conn.rollback();				
						}
				}else{					
					addedinstrPstmt2.setString(1,updateMealMenuObjectInstr.getAdditionalInstructions2(mealType));
					addedinstrPstmt2.setString(2,dateforMenu);
					addedinstrPstmt2.setString(3,encounterId);
					addedinstrPstmt2.setLong(4,profileSl);
					addedinstrPstmt2.setString(5,mealType);	
					addedinstrPstmt2.setString(6,facility_id);
					addedinstrPstmt2.setString(7,login_user);
					addedinstrPstmt2.setString(8,str_client_ip_address);
					addedinstrPstmt2.setString(9,facility_id);
					addedinstrPstmt2.setTimestamp(10, new  java.sql.Timestamp(System.currentTimeMillis()));
					addedinstrPstmt2.setString(11,login_user);
					addedinstrPstmt2.setString(12,str_client_ip_address);
					addedinstrPstmt2.setString(13,facility_id);
					addedinstrPstmt2.setTimestamp(14, new  java.sql.Timestamp(System.currentTimeMillis()));
					
					int row1=addedinstrPstmt2.executeUpdate();
					if(row1 >0)
					{
						isInsertSuccess = true;
						conn.commit();							
					}else{					
						conn.rollback();
					}
					if(addedinstrPstmt2!=null) addedinstrPstmt2.close();	//Added Against Common-ICN-0053
				}					
			}
				//Added against CRF-0112 Ends Here				
			}else if(mealmenuSL.equals("2")){
			reviewSlNoVal = getreviewSlNo(request,facility_id,encounterId,profileSL1,mealType,itemCode,dateforMenu); //Added Against KDAH-CRF-0349.1[IN:067479]
					if(reviewSlNoVal>0){ //Added Against KDAH-CRF-0349.1[IN:067479]
					updatePstmt.setString(1,patientId);
					updatePstmt.setString(2,patientClass);
					updatePstmt.setString(3,encounterId);
					updatePstmt.setLong(4,profileSl);
					updatePstmt.setString(5,mealType);
					updatePstmt.setString(6,itemCode);
					updatePstmt.setString(7,dateforMenu); //serving_date(7)- dateforMenu 
					updatePstmt.setString(8,"1");
					updatePstmt.setString(9,reviewType);
					updatePstmt.setString(10,"");
					updatePstmt.setString(11,dateFrom);
					updatePstmt.setString(12,dateTo);
					updatePstmt.setString(13,dietType);
					updatePstmt.setString(14, mealClass);
					updatePstmt.setInt(15,i+1);
					updatePstmt.setString(16,itemType);
					updatePstmt.setString(17,itemQty);
					updatePstmt.setString(18,"" );
					updatePstmt.setString(19,menuCode);
					updatePstmt.setString(20,status);
					updatePstmt.setString(21,login_user);
					//AMS-CRF-122 Starts here
					if(status.equalsIgnoreCase("6")){					
					updatePstmt.setTimestamp(22, new  java.sql.Timestamp(System.currentTimeMillis()));			
					updatePstmt.setString(23,facility_id);
					updatePstmt.setString(24,str_client_ip_address);
					updatePstmt.setString(25,facility_id);				
					/* Commented Against Start KDAH-CRF-0349.1[IN:067479] 
					if(allDate.equalsIgnoreCase("ALL")){	//IN-67325
					updatePstmt.setInt(26,(Integer.parseInt(menuSL)+j));	
					}else{
					updatePstmt.setInt(26,Integer.parseInt(menuSL));
					} //67325 
					//updatePstmt.setInt(26,Integer.parseInt(menuSL));
					Commented Against End KDAH-CRF-0349.1[IN:067479] */	
					updatePstmt.setInt(26,reviewSlNoVal); //Added Against KDAH-CRF-0349.1[IN:067479]
					}else{
					updatePstmt.setString(22,facility_id);
					updatePstmt.setString(23,str_client_ip_address);
					updatePstmt.setString(24,facility_id);
					/* Commented Against Start KDAH-CRF-0349.1[IN:067479] 
					if(allDate.equalsIgnoreCase("ALL")){	//67325
					updatePstmt.setInt(25,(Integer.parseInt(menuSL)+j));
					}else{
					updatePstmt.setInt(25,Integer.parseInt(menuSL));
					} 
					Commented Against End KDAH-CRF-0349.1[IN:067479] */
					updatePstmt.setInt(25,reviewSlNoVal); //Added Against KDAH-CRF-0349.1[IN:067479]
					}	//67325
					//AMS-CRF-122 Ends Here					

					int row=updatePstmt.executeUpdate();
					//Added Against AMS-CRF-0112 Starts Here
					if(updatePstmt!=null) updatePstmt.close();	//Added Against Common-ICN-0053
		if(isAdditionalInstructions)
		{
			if(selectInstrcount > 0)
			{
				addedinstrPstmt2.setString(1,updateMealMenuObjectInstr.getAdditionalInstructions2(mealType));
				addedinstrPstmt2.setString(2,login_user);
				addedinstrPstmt2.setString(3,str_client_ip_address);
				addedinstrPstmt2.setString(4,facility_id);
				addedinstrPstmt2.setTimestamp(5, new  java.sql.Timestamp(System.currentTimeMillis()));
				addedinstrPstmt2.setString(6,encounterId);
				addedinstrPstmt2.setLong(7,profileSl);
				addedinstrPstmt2.setString(8,mealType);
				addedinstrPstmt2.setString(9,dateforMenu);							
							
				addedinstrPstmt2.executeUpdate();
			}else{
				addedinstrPstmt2.setString(1,updateMealMenuObjectInstr.getAdditionalInstructions2(mealType));
				addedinstrPstmt2.setString(2,dateforMenu);
				addedinstrPstmt2.setString(3,encounterId);
				addedinstrPstmt2.setLong(4,profileSl);
				addedinstrPstmt2.setString(5,mealType);	
				addedinstrPstmt2.setString(6,facility_id);
				addedinstrPstmt2.setString(7,login_user);
				addedinstrPstmt2.setString(8,str_client_ip_address);
				addedinstrPstmt2.setString(9,facility_id);
				addedinstrPstmt2.setTimestamp(10, new  java.sql.Timestamp(System.currentTimeMillis()));
				addedinstrPstmt2.setString(11,login_user);
				addedinstrPstmt2.setString(12,str_client_ip_address);
				addedinstrPstmt2.setString(13,facility_id);
				addedinstrPstmt2.setTimestamp(14, new  java.sql.Timestamp(System.currentTimeMillis()));			
				addedinstrPstmt2.executeUpdate();
				}
			}
			//Added Against AMS-CRF-0112 Ends Here
					if (row >0)
					{
						isInsertSuccess = true;
						conn.commit();
					}
					else{
						conn.rollback();						
						}
					if(addedinstrPstmt2!=null) addedinstrPstmt2.close();	//Added Against Common-ICN-0053
					}  //(reviewSlNoVal cond end)
				} // update if cond end
			  } // Added Against KDAH-CRF-0349.1 [IN062717]US2 (End For-loop)
			}
			if(isInsertSuccess)
				error_value = "1" ;
			else
				error = "Records have not been saved. Please try again";
								
		}catch(ParseException ee){ /* Added Against KDAH-CRF-0349.1 [IN062717]US2 */
			ee.printStackTrace();
		}catch(Exception ee){
			ee.printStackTrace();
		}finally{
			if(conn!=null) ConnectionManager.returnConnection(conn,request);
			//Added Against Start KDAH-CRF-0349.1/US003[IN:067380]
			if(rst!=null) rst.close(); 
			if(rsnew!=null) rsnew.close(); //AMS-SCF-0778
			if(pstmt!=null) pstmt.close();
			//Added Against End KDAH-CRF-0349.1/US003[IN:067380]
			if(insertPstmt!=null) insertPstmt.close();
			if(addedinstrPstmt2!=null) addedinstrPstmt2.close(); //AMS-SCF-0778
			if(updatePstmt!=null) updatePstmt.close();
			if(selectinstrPstmt!=null) selectinstrPstmt.close(); //AMS-SCF-0778			
			
		}
	}

	// AAKH-CRF-0065 end
	private ArrayList<JSONObject> fetchMealTypesWithTime(HttpServletRequest request) {
		//JSONObject jsonList = new JSONObject(); //Common-ICN-0055
		ArrayList<JSONObject> keyValueList = new ArrayList<JSONObject>();
		Connection conn = ConnectionManager.getConnection(request);
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String language_Id = request.getParameter("language_Id");
		String mClass = request.getParameter("mClass");
		String dType = request.getParameter("dType");
		String kCode = request.getParameter("kCode");
		String meal_type="", short_Desc="", Serving_start_time="", Serving_end_time="", Irregular_start_time="", Irregular_end_time="";
		try{
			String meal_Types_query = "select menuTimeTable.meal_Type, mealType.short_Desc,mealType.Serving_start_time,mealType.serving_end_time,mealType.irregular_start_time,mealType.irregular_end_time,NVL((SELECT serving_start_time FROM ds_meal_type_lang_vw a WHERE a.meal_order =(SELECT MIN (b.meal_order) FROM ds_meal_type_lang_vw b WHERE b.serving_start_time IS NOT NULL AND b.meal_order > mealtype.meal_order) AND a.language_id = mealtype.language_id), '23:59' ) next_meal_start_time from Ds_Diet_Menu_Time_Table menuTimeTable, Ds_Meal_Type_Lang_Vw mealType where menuTimeTable.meal_Type = mealType.meal_Type and menuTimeTable.diet_Type = '"+dType.trim()+"' and menuTimeTable.meal_Class like '"+mClass+"' and menuTimeTable.kitchen_Code like '"+kCode+"' and menuTimeTable.day_No = '1'  and mealType.LANGUAGE_ID = '"+language_Id+"' order by mealtype.meal_order";
			pstmt = conn.prepareStatement(meal_Types_query);
			rs = pstmt.executeQuery();
			while(rs != null && rs.next()){
				  meal_type = rs.getString(1);
				 short_Desc = rs.getString(2);
				 Serving_start_time=rs.getString(3);
				 Serving_end_time=rs.getString(4);
				 Irregular_start_time=rs.getString(5);
				 Irregular_end_time=rs.getString(6);
				JSONObject MealTypesList= new JSONObject();
				MealTypesList.put("Meal_Code", CommonBean.checkForNull(rs.getString(1)));
				MealTypesList.put("Short_Desc", CommonBean.checkForNull(rs.getString(2)));
				MealTypesList.put("Serving_Start_Time", CommonBean.checkForNull(rs.getString(3)));
				MealTypesList.put("Serving_End_Time", CommonBean.checkForNull(rs.getString(4)));
				MealTypesList.put("Irregular_Start_Time", CommonBean.checkForNull(rs.getString(5)));
				MealTypesList.put("Irregular_End_Time", CommonBean.checkForNull(rs.getString(6)));
				MealTypesList.put("Next_Meal_Start_Time", CommonBean.checkForNull(rs.getString(7)));
				keyValueList.add(MealTypesList);
			}
		}
		catch(Exception ee){
			ee.printStackTrace();
			System.err.println("PlaceDietOrderServlet.java--->"+ee.getMessage());
		}
		finally{
			try{
				if(conn!=null)ConnectionManager.returnConnection(conn,request);
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				
			}catch(Exception e){}
		}
		return keyValueList;
	}
	//CRF-412
	private ArrayList<JSONObject> fetchTextureOfDiet(HttpServletRequest request) {
		//JSONObject jsonList = new JSONObject(); //Common-ICN-0055
		ArrayList<JSONObject> keyValueList = new ArrayList<JSONObject>();
		Connection conn = ConnectionManager.getConnection(request);
		PreparedStatement pstmt=null;
		ResultSet rs=null;		
		String texture_code = "",texture_description="";
		try{
			String TextureOfDiet_Query = "select texture_of_diet,short_desc from ds_texture_of_diet where eff_status='E' and added_facility_id='"+facility_id+"'";
			pstmt = conn.prepareStatement(TextureOfDiet_Query);
			rs = pstmt.executeQuery();
			while(rs != null && rs.next()){
				texture_code=rs.getString(1);
				texture_description=rs.getString(2);					
				
				JSONObject TextureOfDietList= new JSONObject();
				TextureOfDietList.put("Texture_Code", CommonBean.checkForNull(rs.getString(1)));
				TextureOfDietList.put("Texture_Desc", CommonBean.checkForNull(rs.getString(2)));				
				keyValueList.add(TextureOfDietList);
			}
		}
		catch(Exception ee){
			ee.printStackTrace();
			System.err.println("PlaceDietOrderServlet.java--->"+ee.getMessage());
		}
		finally{
			try{
				if(conn!=null)ConnectionManager.returnConnection(conn,request);
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				}catch(Exception e){}
		}
		return keyValueList;
	}
	//CRF-412
//428	
	private void excludeMeals(String facilityId, String encounterId, Long pi, JSONObject exclusionsObj, HttpServletRequest req) {
		Connection conn = ConnectionManager.getConnection(req);
		PreparedStatement pstmt=null;
			
		try{
			String addedById = req.getParameter("addedById");
			String addedAtWsNo = req.getParameter("addedAtWsNo");
			
			String exclusions_delete_query = "delete from ds_meal_type_exclusions where operating_facility_id='"+facilityId+"' and encounter_id="+encounterId+" and profile_sl="+pi;
			pstmt = conn.prepareStatement(exclusions_delete_query);	

			int delete = pstmt.executeUpdate();
			
			Iterator<String> keys = exclusionsObj.keys();
			
			if(delete != 0){
				System.out.println("exclusions deleted successfully");
				conn.commit();
			}else{
				System.out.println("error in delete exclusions");
				conn.rollback();
			}
			
			String exclusions_insert_query = "insert into ds_meal_type_exclusions (operating_facility_id,encounter_id,profile_sl,excluded_date,meal_type,added_by_id, added_date, added_facility_id, added_at_ws_no, modified_by_id, modified_date, modified_facility_id, modified_at_ws_no) values (?,?,?,to_date(?,'dd/mm/yyyy'),?,?,sysdate,?,?,?,sysdate,?,?)";
			pstmt = conn.prepareStatement(exclusions_insert_query);
			String date="";
			String mealType="";
			String flag="";
			int successFlag=0;
			
			while( keys.hasNext() ) {
				date = (String)keys.next();
				//String mealTypesJson=(String) exclusionsObj.get(date);
				JSONObject mealTypeObj=(JSONObject) exclusionsObj.get(date);
				Iterator<String> keysMealType = mealTypeObj.keys();
				while(keysMealType.hasNext() ) {
					mealType = (String)keysMealType.next();
					flag= (String)mealTypeObj.get(mealType);
					
					if(flag.equals("Y")) {
						pstmt.setString(1, facilityId);
						pstmt.setString(2, encounterId);
						pstmt.setLong(3, pi);
						pstmt.setString(4,date );
						pstmt.setString(5,mealType);
						pstmt.setString(6, addedById);
						//pstmt.setTimestamp(7, new  java.sql.Timestamp(System.currentTimeMillis()));
						pstmt.setString(7, facilityId);
						pstmt.setString(8, addedAtWsNo);
						pstmt.setString(9, addedById);
						//pstmt.setTimestamp(11, new  java.sql.Timestamp(System.currentTimeMillis()));
						pstmt.setString(10, facilityId);
						pstmt.setString(11, addedAtWsNo);
						
						successFlag = pstmt.executeUpdate();
					}
				}
			}
			if(successFlag != 0)
			{
				System.out.println("flag is not zero");
				conn.commit();
			}
			else
			{
				System.out.println("flag is zero");
				conn.rollback();
			}
			pstmt.close();			
			
		}
		catch(Exception ee){
			ee.printStackTrace();
			System.err.println("PlaceDietOrderServlet.java--->"+ee.getMessage());
		}
		finally{
			try{
				if(conn!=null)ConnectionManager.returnConnection(conn,req);
				if(pstmt!=null) pstmt.close();
			}catch(Exception e){}
		}
	}	
	//ML-MMOH-CRF-409
	public String loadIrregularMealCode(HttpServletRequest request){
		Connection conn = ConnectionManager.getConnection(request);
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String irregular_meal_code="";
		try{
			String encounter_id=request.getParameter("encounterId");
			String profile_sl=request.getParameter("profileSL");
			String facility_id=request.getParameter("facility");			
			
			String irregular_meal_code_query = "SELECT MEAL_TYPE,IRREGULAR_FLAG_YN FROM DS_EPSD_DIET_PROFILE_DTL WHERE ENCOUNTER_ID=? AND  PROFILE_SL=? AND  OPERATING_FACILITY_ID=? AND IRREGULAR_FLAG_YN='Y'";
			pstmt = conn.prepareStatement(irregular_meal_code_query);	

			pstmt.setString(1,encounter_id);
			pstmt.setString(2,profile_sl);
			pstmt.setString(3,facility_id);
			
			rs=pstmt.executeQuery();
			
			while(rs.next()){
				irregular_meal_code+=rs.getString("MEAL_TYPE");
				irregular_meal_code+=",";
			}
			if(irregular_meal_code!=null && irregular_meal_code.length()>0) //Fix for StringOutofBoundException
			irregular_meal_code=irregular_meal_code.substring(0,irregular_meal_code.length()-1);
			pstmt.close();				
		}
		catch(Exception ee){
			ee.printStackTrace();
			System.err.println("PlaceDietOrderServlet.java--->"+ee.getMessage());
		}
		finally{
			try{
				if(conn!=null)ConnectionManager.returnConnection(conn,request);
				if(pstmt!=null) pstmt.close();
			}catch(Exception e){}
		}
		return irregular_meal_code;
		
	}
	//ML-MMOH-CRF-409
	//006 STARTS
	public String loadDietTypeModified(HttpServletRequest request){
		Connection conn = ConnectionManager.getConnection(request);
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String DietTypeModified="";
		try{
			String encounter_id=request.getParameter("encounterId");
			String profile_sl=request.getParameter("profileSL");
			String facility_id=request.getParameter("facility");			
			
			String irregular_meal_code_query = "SELECT nvl(DIET_TYPE_MODIFIED,'N') DIET_TYPE_MODIFIED FROM DS_EPSD_DIET_PROFILE_HDR WHERE ENCOUNTER_ID=? AND  PROFILE_SL=? AND  OPERATING_FACILITY_ID=?";
			pstmt = conn.prepareStatement(irregular_meal_code_query);	

			pstmt.setString(1,encounter_id);
			pstmt.setString(2,profile_sl);
			pstmt.setString(3,facility_id);
			
			rs=pstmt.executeQuery();
			
			if(rs.next()){
				DietTypeModified=rs.getString("DIET_TYPE_MODIFIED");				
			}else{
				DietTypeModified="N";				
			}
			
			//irregular_meal_code=irregular_meal_code.substring(0,irregular_meal_code.length()-1);	
				
			pstmt.close();			
		}
		catch(Exception ee){
			ee.printStackTrace();
			System.err.println("PlaceDietOrderServlet.java--->"+ee.getMessage());
		}
		finally{
			try{
				if(conn!=null)ConnectionManager.returnConnection(conn,request);
				if(pstmt!=null) pstmt.close();
			}catch(Exception e){}
		}
		return DietTypeModified;
		
	}
	//006 ENDS
	//Added by vikash against 60459 Starts
	private ArrayList<String> deleteSplFoodItemsNew(HttpServletRequest request) throws SQLException{
		String encounterId = request.getParameter("encounterId");
		String facility = request.getParameter("facility");
		//String itemSrlNo = request.getParameter("itemSrlNo"); //Common-ICN-0055
		String profileSL = request.getParameter("profileSL");
		String Item_Type= request.getParameter("Item_Type");
		String Item_Code= request.getParameter("Item_Code");
		String Meal_Type= request.getParameter("Meal_Type");
		String Freq_Based= request.getParameter("Freq_Based");
		Connection conn = ConnectionManager.getConnection(request);
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try{
				//String del_query = "delete from DS_EPSD_DIET_PROFILE_SPL where OPERATING_FACILITY_ID='"+facility+"' and ENCOUNTER_ID='"+encounterId+"' and PROFILE_SL='"+profileSL.trim()+"' and Item_Type='"+Item_Type.trim()+"' and Item_Code='"+Item_Code+"' and Meal_Type='"+Meal_Type+"'";
				String del_query = "";
				if(Freq_Based.equals("Y")){
					//Freq Food Item no need to check meal type
					del_query = "delete from DS_EPSD_DIET_PROFILE_SPL where OPERATING_FACILITY_ID='"+facility+"' and ENCOUNTER_ID='"+encounterId+"' and PROFILE_SL='"+profileSL.trim()+"' and Item_Type='"+Item_Type.trim()+"' and Item_Code='"+Item_Code+"' and FREQ_YN='Y'";					
				}else{
					//Non Freq Food item need to check meal type
					del_query = "delete from DS_EPSD_DIET_PROFILE_SPL where OPERATING_FACILITY_ID='"+facility+"' and ENCOUNTER_ID='"+encounterId+"' and PROFILE_SL='"+profileSL.trim()+"' and Item_Type='"+Item_Type.trim()+"' and Item_Code='"+Item_Code+"' and Meal_Type='"+Meal_Type+"' and FREQ_YN='N'";				
				}
				
				pstmt = conn.prepareStatement(del_query);
				 int delete = pstmt.executeUpdate();
				 if(delete != 0){
					 System.out.println("Flag not zero in deleteSplFoodItemsNew");
						conn.commit();
					}else{
						System.out.println("Flag zero in deleteSplFoodItemsNew");
						conn.rollback();
					}
		}catch(Exception ee){
			ee.printStackTrace();
			System.err.println("PlaceDietOrderServlet.java--->"+ee.getMessage());
		}finally{
			if(conn!=null)ConnectionManager.returnConnection(conn,request);
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
		}
		return null;
	}
	//Added by vikash against 60459 Ends
	//Added Against ML-MMOH-CRF-0600 Starts Here
	private  JSONObject pendingMealOrder_AckDetail_IP(HttpServletRequest request,  HttpServletResponse response)
	{
		Connection conn = ConnectionManager.getConnection(request);
		PreparedStatement pstmt=null;
		/* PreparedStatement pstmt_FoodItem=null;
		PreparedStatement pstmt_splFoodItem=null; */ //Common-ICN-0055
	
		ResultSet rs=null;
		String encounter_Id=request.getParameter("encounter_Id");
		String facility_Id=request.getParameter("facility_Id");
		JSONObject jsonList = new JSONObject();
		try{			
				//String query_pendingAckIP="SELECT serving_date,meal_type,DECODE (meal_type,'NA','NA',ds_get_desc.ds_meal_type(meal_type,'en','2')) meal_type_desc, DECODE (curr_stat,'MP','Meal Prepared','MR','Meal Received','MS','Meal Served','MJ','Meal Rejected','NA') Status FROM (SELECT DISTINCT a.encounter_id, a.serving_date, b.status curr_stat, a.meal_type FROM ds_epsd_meal_plan_dtl a, ds_epsd_meal_plan_hdr_audit b, ds_epsd_diet_profile_hdr c WHERE a.operating_facility_id = ? AND a.encounter_id = ? AND a.operating_facility_id = b.operating_facility_id(+) AND a.encounter_id = b.encounter_id(+) AND a.serving_date = b.serving_date(+) AND a.meal_type = b.meal_type(+) AND a.spl_food_item_yn = 'N' AND a.operating_facility_id = c.operating_facility_id AND a.encounter_id = c.encounter_id AND c.profile_sl = (SELECT MAX(PROFILE_SL) from ds_epsd_diet_profile_hdr where operating_facility_id = a.operating_facility_id  AND encounter_id = a.encounter_id) AND a.serving_date BETWEEN c.period_from AND c.period_to UNION SELECT DISTINCT a.encounter_id, a.serving_date, b.status curr_stat, NVL(a.meal_type,'NA') meal_type FROM ds_epsd_meal_plan_dtl a, ds_epsd_meal_plan_spl_audit b,ds_epsd_diet_profile_hdr c WHERE a.operating_facility_id = ? AND a.encounter_id = ? AND a.operating_facility_id = b.operating_facility_id(+) AND a.encounter_id = b.encounter_id(+) AND a.serving_date = b.serving_date(+) AND a.spl_food_item_yn = 'Y' AND a.operating_facility_id = c.operating_facility_id AND a.encounter_id = c.encounter_id AND c.profile_sl = (SELECT MAX(PROFILE_SL) from ds_epsd_diet_profile_hdr where operating_facility_id = a.operating_facility_id AND encounter_id = a.encounter_id) AND a.serving_date BETWEEN c.period_from AND c.period_to)";//Tooltip
				String query_pendingAckIP="SELECT serving_date,meal_type,DECODE (meal_type,'NA','NA',ds_get_desc.ds_meal_type(meal_type,'en','2')) meal_type_desc, nvl((select STATUS_DESC from ds_meal_ack_status_mast where STATUS_CODE= curr_stat and patient_class = 'IP'),'NA') Status FROM (SELECT DISTINCT a.encounter_id, a.serving_date, b.status curr_stat, a.meal_type FROM ds_epsd_meal_plan_dtl a, ds_epsd_meal_plan_hdr_audit b, ds_epsd_diet_profile_hdr c WHERE a.operating_facility_id = ? AND a.encounter_id = ? AND a.operating_facility_id = b.operating_facility_id(+) AND a.encounter_id = b.encounter_id(+) AND a.serving_date = b.serving_date(+) AND a.meal_type = b.meal_type(+) AND a.spl_food_item_yn = 'N' AND a.operating_facility_id = c.operating_facility_id AND a.encounter_id = c.encounter_id AND c.profile_sl = (SELECT MAX(PROFILE_SL) from ds_epsd_diet_profile_hdr where operating_facility_id = a.operating_facility_id  AND encounter_id = a.encounter_id) AND a.serving_date BETWEEN c.period_from AND c.period_to UNION SELECT DISTINCT a.encounter_id, a.serving_date, b.status curr_stat, NVL(a.meal_type,'NA') meal_type FROM ds_epsd_meal_plan_dtl a, ds_epsd_meal_plan_spl_audit b,ds_epsd_diet_profile_hdr c WHERE a.operating_facility_id = ? AND a.encounter_id = ? AND a.operating_facility_id = b.operating_facility_id(+) AND a.encounter_id = b.encounter_id(+) AND a.serving_date = b.serving_date(+) AND a.spl_food_item_yn = 'Y' AND a.operating_facility_id = c.operating_facility_id AND a.encounter_id = c.encounter_id AND c.profile_sl = (SELECT MAX(PROFILE_SL) from ds_epsd_diet_profile_hdr where operating_facility_id = a.operating_facility_id AND encounter_id = a.encounter_id) AND a.serving_date BETWEEN c.period_from AND c.period_to)";//Tooltip & CRF-1061
				pstmt = conn.prepareStatement(query_pendingAckIP);
				pstmt.setString(1, facility_Id);
				pstmt.setString(2, encounter_Id);
				pstmt.setString(3, facility_Id);
				pstmt.setString(4, encounter_Id);
				rs = pstmt.executeQuery();
				
				int i=0;
				while(rs != null && rs.next())
				{
					JSONObject jsonMealPendingListIP= new JSONObject();
					jsonMealPendingListIP.put("serving_date",rs.getString(1));
					jsonMealPendingListIP.put("meal_type",rs.getString(2));
					jsonMealPendingListIP.put("mealtypeDesc",rs.getString(3));
					jsonMealPendingListIP.put("status",rs.getString(4));
					jsonList.append("jsonMealPendingListIP", jsonMealPendingListIP);
					i++;
				}				
			}
			catch(Exception ee){
				ee.printStackTrace();
			}
			finally{
				try{
					if(conn!=null)ConnectionManager.returnConnection(conn,request);
					if(rs!=null) rs.close();
					if(pstmt!=null) pstmt.close();					
				}catch(Exception e){
					System.err.println("PlaceDietOrderServlet.java 5139--->"+e.getMessage());
					e.printStackTrace();
				}
			}
			return jsonList;			
	}
		//Added Against ML-MMOH-CRF-0600 Ends Here
		
		//Added Against ML-MMOH-CRF-1460 Starts
		private ArrayList<String> insertNBMAttList(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ParseException
	{
		System.err.println("~~~~~~~~~~~~~insertNBMAttList~~~~~~~~~");
		Connection conn = ConnectionManager.getConnection(request);
		PreparedStatement pstmt=null;
		PreparedStatement pstmtForDel = null; 
		ResultSet rs=null;
		CallableStatement cstmt = null;
		String P_Error_Text = null;
		String attDietList[] = null;
		String viewCode = null;
		
		String language_id = request.getParameter("language_Id");
		String dietCategoryCode = request.getParameter("diet_Category");
		String encounterId = request.getParameter("encounterId");
		String addedFacilityId=request.getParameter("addedFacilityId");
		String profileSL = request.getParameter("profileSL");
		Long pi = Long.parseLong(profileSL);
		String patientClass = request.getParameter("patientClass");
		String patientId = request.getParameter("patientId");
		String addedById = request.getParameter("addedById");
		String locationType = request.getParameter("locationType");
		String locationCode = request.getParameter("locationCode");
		String addedAtWsNo = request.getParameter("addedAtWsNo");
		String result = request.getParameter("result");
		String attIns = request.getParameter("attIns");	//ML-MMOH-SCF-1828
		String menu_type = "";
		String orderTypeString = null;
		String isNEW = request.getParameter("isNEW");
		
		try
		{
			if(request.getParameter("menu_type") != null && !request.getParameter("menu_type").equals("")){
			menu_type = request.getParameter("menu_type");			
			}
			else{
				menu_type = "";
			}
				
			if(result.equals("insert")) ++pi;
			attDietList = request.getParameterValues("attdietList");
			String orderTypeCode_query = "select dietcategory.order_Type_Code from Ds_Diet_Category dietcategory where dietcategory.diet_Category_Code='"+dietCategoryCode+"'";

			pstmt = conn.prepareStatement(orderTypeCode_query);
			rs = pstmt.executeQuery();
			while(rs != null && rs.next())
				orderTypeString = rs.getString(1);
			rs.close();
			pstmt.close();
			if ((isNEW != null && isNEW.equalsIgnoreCase("true")) || pi.equals(new Long(0)))
		{
			cstmt = conn.prepareCall("{call Insert_Order_Header(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			cstmt.setString(1, "DS");
			if (orderTypeString != null)
				cstmt.setString(2, orderTypeString);
			else
				cstmt.setString(2, dietCategoryCode);
			cstmt.setDate(3, new java.sql.Date(System.currentTimeMillis()));
			cstmt.setString(4, "DS");
			cstmt.setString(5, "R");
			cstmt.setString(6, addedFacilityId);
			cstmt.setString(7, addedFacilityId);
			cstmt.setString(8, patientId);
			cstmt.setString(9, patientClass);
			cstmt.setString(10, encounterId + "");
			cstmt.setString(11, encounterId + "");
			cstmt.setString(12, null);
			cstmt.setString(13, locationType);
			cstmt.setString(14, locationCode);
			cstmt.setString(15, addedById);
			cstmt.setString(16, null);
			cstmt.setString(17, null);
			cstmt.setString(18, null);
			cstmt.setString(19, null);
			cstmt.setString(20, null);
			cstmt.setString(21, null);
			cstmt.setString(22, addedById);
			cstmt.setString(23, addedById);
			cstmt.setString(24, addedAtWsNo);
			cstmt.registerOutParameter(25, Types.VARCHAR);
			cstmt.registerOutParameter(26, Types.VARCHAR);
			cstmt.execute();
			viewCode = cstmt.getString(25);
			P_Error_Text = cstmt.getString(26);
		}
		else
		{
			viewCode = "";
		}
		if(attDietList.length > 0 && attDietList[0].trim()!= "")
		{
			int flag = 1;
			
		  String currentdate_attn= new SimpleDateFormat("dd/MM/yyyy").format(new java.util.Date());        
		  String attendant_query_update="UPDATE ds_epsd_diet_profile_att SET status = 'C' WHERE encounter_id = '"+encounterId+"' AND period_from <= TO_DATE ('"+currentdate_attn+"', 'DD/MM/YYYY')";		  
			long attendentID = 0;
			int StartPos = 0;
			String attendant_query = "INSERT INTO DS_EPSD_DIET_PROFILE_ATT(OPERATING_FACILITY_ID,PATIENT_CLASS,ENCOUNTER_ID,PROFILE_SL,ORDER_ID,ORDER_LINE_NO,ATTENDENT_SRL,PERIOD_FROM,PERIOD_TO,DIET_TYPE,MEAL_CLASS,ADDED_BY_ID,ADDED_DATE,ADDED_FACILITY_ID,ADDED_AT_WS_NO,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_FACILITY_ID,MODIFIED_AT_WS_NO,MENU_TYPE,ATNDNT_INSTR) VALUES(?, ?, ?, ?, ?, ?, ?, to_date(?,'dd/mm/yyyy'), to_date(?,'dd/mm/yyyy'), ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?)";
			String attDietsubList[] = null;
			attDietsubList = attDietList[StartPos].split(",");
			int nRowCount = 0;
			while(StartPos < attDietsubList.length)
			{
				if(!("".equals(attDietsubList[StartPos].trim())) )
				{
					break;
				}
				else
					StartPos++;
			}

			nRowCount = StartPos;
			String Delattd_query = "Delete from DS_EPSD_DIET_PROFILE_ATT where OPERATING_FACILITY_ID =? AND ENCOUNTER_ID=? AND PROFILE_SL = ? AND ATTENDENT_SRL =?";
			pstmtForDel = conn.prepareStatement(Delattd_query);
			if(viewCode != null && !(viewCode.equals("")))
			{
			pstmt = conn.prepareStatement(attendant_query_update);
		    pstmt.executeUpdate();
			}
			pstmt = conn.prepareStatement(attendant_query);
			while(nRowCount < attDietsubList.length && !("".equals(attDietsubList[nRowCount])) )
			{
				int nRowCount_FrmDate = nRowCount;
				int nRowCount_ToDate = nRowCount + 1;
				int nRowCount_Diet = nRowCount + 2;
				int nRowCount_MealClass = nRowCount + 3;
				int nRowCount_pfsl = nRowCount + 4;
				int nRowCount_dsl = nRowCount + 5;
				int nRowCount_attdsl = nRowCount + 6;

				if("-1".equalsIgnoreCase(attDietsubList[nRowCount_dsl]))
				{
					if(attDietsubList[nRowCount_attdsl] != "")
					{
						pstmtForDel.setString(1,addedFacilityId.trim());
						pstmtForDel.setString(2,encounterId);
						pstmtForDel.setLong(3,pi);
						pstmtForDel.setString(4,attDietsubList[nRowCount_attdsl]); 
						pstmtForDel.executeUpdate();
					}
					nRowCount = nRowCount + 7;
					continue;
				}
				else if((isNEW != null && !(isNEW.equalsIgnoreCase("true"))) && ("99".equalsIgnoreCase(attDietsubList[nRowCount_dsl]))) {
					nRowCount = nRowCount + 7;
					continue;
				}
				pstmt.setString(1, addedFacilityId.trim());
				pstmt.setString(2, patientClass);
				pstmt.setLong(3, Long.parseLong(encounterId));
				pstmt.setLong(4, pi);
				if(pi == null || attDietsubList[nRowCount_pfsl].equals(new Long(0L))){
					attendentID++;
					if(attendentID < 10L){
                        pstmt.setString(5, "ATT00" +attendentID);
					}else if(attendentID < 100L){
						pstmt.setString(5, "ATT0" +attendentID);
					}else{
                        pstmt.setString(5, "ATT" +attendentID);
					}
				}
				else {
					attendentID++;
					if(pi < 10L){
						pstmt.setString(5,"ATT00" +attendentID);
					}else if(pi < 100L){
                    	pstmt.setString(5, "ATT0" +attendentID);
					}else{
                    	pstmt.setString(5, "ATT" +attendentID);
					}
				}
				pstmt.setLong(6, new Long(1L));
				pstmt.setLong(7, Long.parseLong(attDietsubList[nRowCount_attdsl].trim())); 
				attDietsubList[nRowCount_FrmDate] = com.ehis.util.DateUtils.convertDate(attDietsubList[nRowCount_FrmDate].trim(),"DMY", language_id,"en");
				pstmt.setString(8, attDietsubList[nRowCount_FrmDate].trim());
				attDietsubList[nRowCount_ToDate] = com.ehis.util.DateUtils.convertDate(attDietsubList[nRowCount_ToDate].trim(),"DMY", language_id,"en");
				if(attDietsubList[nRowCount_ToDate] != null && !attDietsubList[nRowCount_ToDate].equals("")){
					pstmt.setString(9, attDietsubList[nRowCount_ToDate].trim());
				}else{
					pstmt.setString(9, ""); 
				}
				pstmt.setString(10, attDietsubList[nRowCount_Diet].trim());
				pstmt.setString(11, attDietsubList[nRowCount_MealClass].trim());
				pstmt.setString(12, addedById);
				pstmt.setTimestamp(13, getCurrentTimeStamp());
				pstmt.setString(14, addedFacilityId);
				pstmt.setString(15, addedAtWsNo);
				pstmt.setString(16, addedById);
				pstmt.setTimestamp(17, getCurrentTimeStamp());
				pstmt.setString(18, addedFacilityId);
				pstmt.setString(19, addedAtWsNo);
				pstmt.setString(20, menu_type);
				pstmt.setString(21, attIns);	//Added Against ML-MMOH-SCF-1828
				flag = pstmt.executeUpdate();
				if(flag == 0){
					break;
				}
				nRowCount = nRowCount + 7;
			}
				if(flag != 0){
					conn.commit();
				}else{
					conn.rollback();
				}
				pstmt.close();
				if(pstmtForDel!=null) pstmtForDel.close();
		}
	}
	catch(Exception e)
		{
			e.printStackTrace();
			System.err.println("Excetion in insertNBMAttList==>"+e.getMessage());
		}
		finally
		{
			if(conn!=null)ConnectionManager.returnConnection(conn,request);
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			if(cstmt!=null) cstmt.close();
			if(pstmtForDel!=null) pstmtForDel.close();
		}
		return null;
	}
	//Added Against ML-MMOH-CRF-1460 Ends
}