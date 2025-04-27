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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.sql.Date;
import java.net.URLDecoder;
import java.util.*; //MMS-KH-CRF-029.1

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import webbeans.eCommon.ConnectionManager;
import eCommon.XSSRequestWrapper;
import eCommon.Common.CommonBean;//CRF-412

import eDS.Common.JSONObject;
import eDS.Common.JSONArray;
/**
 * Servlet implementation class PlaceBulkDietOrderServlet
 */
public class PlaceBulkDietOrderServlet extends javax.servlet.http.HttpServlet{
	java.util.Properties prop;
	HttpSession session;
	String facility_id,str_client_ip_address,login_user;
	
//	String viewCode=null;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public PlaceBulkDietOrderServlet() {
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
        
		//Added Against MMS Vulnerability Issue - Starts
        request= new XSSRequestWrapper(request);
        response.addHeader("X-XSS-Protection", "1; mode=block");
        response.addHeader("X-Content-Type-Options", "nosniff");
        //Added Against MMS Vulnerability Issue - Ends 

//		ArrayList<String> callAgeGroup = new ArrayList<String>();
//		String callAgeGroup="";
		JSONObject callAgeGroup=new JSONObject();
		JSONObject dietTypeList=new JSONObject();
		JSONObject mealTypeList = new JSONObject();
		JSONObject dayRefNo = new JSONObject();
		JSONObject mealContent = new JSONObject();
		JSONObject mealContents = new JSONObject();
		//JSONObject orderDetails = new JSONObject(); //Common-ICN-0055
		JSONObject splFoodItems= new JSONObject();
		JSONObject foodDislikes= new JSONObject();
		boolean dietProfileDtlFlag=false;//006
//		ArrayList<String> mealContents = new ArrayList<String>();
//		ArrayList<String> SplFoodItems = new ArrayList<String>();
		/* ArrayList<String> kalContent = new ArrayList<String>(); 
		ArrayList<String> srlNO = new ArrayList<String>();
		ArrayList<String> delItems = new ArrayList<String>();
		ArrayList<String> updItems = new ArrayList<String>(); 
		List nutriAndSplFood = new ArrayList();
		List updDietType = new ArrayList(); */  //Common-ICN-0055
		ArrayList<String> drugInteraction = new ArrayList<String>();//Added against MMS-KH-CRF-0029.1
//		List orderDetails = new ArrayList();
		JSONObject NBM_Overlap_profile = new  JSONObject();//CRF-410
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
		// Checkstyle Violation commented by Munisekhar
		//String delOper = request.getParameter("del");
		System.out.println("operation--in servlet-->"+operation);
		if(operation.equals("fetchAgeGroupCode")){
			callAgeGroup = fetchAgeGroupCode(request,response);
			response.setContentType("application/json");
			out.print(callAgeGroup);
			out.flush();
		}
		else if(operation.equals("fetchDietTypes")){
				dietTypeList = fetchDietTypes(request);
				response.setContentType("application/json");
				out.println(dietTypeList);
				out.flush();
		}
		else if(operation.equals("mealTypeList")){
				mealTypeList = fetchMealTypes(request);
				response.setContentType("application/json");
				out.println(mealTypeList);
				out.flush();
		}else if(operation.equals("DayRefNo")){
			dayRefNo = getDayRefNo(request);
			response.setContentType("application/json");
			out.println(dayRefNo);
			out.flush();
		}
		else if(operation.equals("MealContent")){
			mealContent = getMealContents(request);
			response.setContentType("application/json");
			out.println(mealContent);
			out.flush();
		}
		else if(operation.equals("insertMealContents")){
			try {
				mealContents = processPatientList(request,response,dietProfileDtlFlag);//006
				out.println(mealContents);
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}else if(operation.equals("insertSpecialFoodItems")){
			try {
				splFoodItems = processPatientList_SplFoodItems(request,response);
				out.println(splFoodItems);
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}else if(operation.equals("insertFoodDislikes")){
			try {
				foodDislikes = processPatientList_FoodDislikes(request,response);
				out.println(foodDislikes);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		//Added By Vikash against CRF-410 starts 
				else if(operation.equals("getNBMProfileOverLap")){
					NBM_Overlap_profile=getNBMProfileOverLap(request,response);
					System.out.println("NBM_Overlap_profile->"+NBM_Overlap_profile);
					response.setContentType("application/json");
					response.setContentType("text/html;charset=UTF-8");
					out.print(NBM_Overlap_profile);
					out.flush();
					//out.println(NBM_Overlap_profile);
				}
		//Added by Vikash against CRF-410 Ends
				
		//Added against MMS-KH-CRF-0029.1 Starts Here
			else if(operation.equals("drugGroup")){		
			drugInteraction = drugFood(request,response);
			out.println(drugInteraction);
				}
		//Added against MMS-KH-CRF-0029.1 Ends Here
		
	}

	public JSONObject fetchAgeGroupCode(HttpServletRequest request, HttpServletResponse response){
		String gender = "";
		String maxAge = "";
		String ageUnit = "";
		//ArrayList<String> list = new ArrayList<String>(); //Common-ICN-0055
		Connection conn = ConnectionManager.getConnection(request);
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int count=0;
		int maxAgeInYears 	= 0;
		int maxAgeInDays 	= 0;
		int maxAgeInMonths 	= 0;
		int maxAgeInHours 	= 0;
		int maxAgeInMinutes = 0;

		String age_group_code="";

		JSONObject json = new JSONObject();

		String patientObj = request.getParameter("jsonPatientObject");
		JSONObject jsonPatientObj = new JSONObject(patientObj);
		JSONArray patArray=jsonPatientObj.getJSONArray("patients");

		for(int i=0;i<patArray.length();i++) {
			JSONObject obj=patArray.getJSONObject(i);
			JSONObject patObj=obj.getJSONObject("patient");
			gender=patObj.getString("gender").trim();
			maxAge=patObj.getString("age").trim();
			ageUnit=patObj.getString("ageUnit").trim();

			//SCF-1148 Changes Start -
			if("Y".equalsIgnoreCase(ageUnit))
			{
				maxAgeInYears 	=  Integer.parseInt(maxAge);
				maxAgeInMonths 	=  Integer.parseInt(maxAge) * 12  ;
				maxAgeInDays 	=  Integer.parseInt(maxAge) * 365 ;
				maxAgeInHours    =  Integer.parseInt(maxAge) * 8760 ;
				maxAgeInMinutes =  Integer.parseInt(maxAge) * 525600;
			}else if("M".equalsIgnoreCase(ageUnit))
			{
				maxAgeInMonths 	=  Integer.parseInt(maxAge);
				maxAgeInDays 	=  Integer.parseInt(maxAge) * 30 ;
				maxAgeInHours    =  Integer.parseInt(maxAge) * 720;
				maxAgeInMinutes =  Integer.parseInt(maxAge) * 43200;
			}else if("D".equalsIgnoreCase(ageUnit))
			{
				maxAgeInDays		= Integer.parseInt(maxAge);
				maxAgeInHours   	= Integer.parseInt(maxAge) * 24;
				maxAgeInMinutes = Integer.parseInt(maxAge) * 1440;
			}else if("H".equalsIgnoreCase(ageUnit))
			{
				maxAgeInHours	= Integer.parseInt(maxAge);
				maxAgeInMinutes = Integer.parseInt(maxAge) * 60;
			}else if("N".equalsIgnoreCase(ageUnit))
			{
				maxAgeInMinutes = Integer.parseInt(maxAge);
			}
			age_group_code = age_group_code+ "select age_Group_Code from Am_Age_Group where NVL(gender,'"+gender+"') = '"+gender+"' and " +
											 "  ( ("+maxAgeInYears+" between min_Age and max_Age	and age_Unit = 'Y') or " +
										     "  ("+maxAgeInMonths+" between min_Age and max_Age	and age_Unit = 'M') or " +
										     "  ("+maxAgeInDays+" between min_Age and max_Age	and age_Unit = 'D') or " +
										     "  ("+maxAgeInHours+" between min_Age and max_Age	and age_Unit = 'H') or " +
										     "  ("+maxAgeInMinutes+" between min_Age and max_Age	and age_Unit = 'N')  )";

			//SCF-1148 Changes End

			if(i != (patArray.length()-1)) {
				age_group_code = age_group_code+" INTERSECT ";
			}
		}
		try{
			pstmt = conn.prepareStatement(age_group_code);
			rs = pstmt.executeQuery();

			while(rs != null && rs.next())
			{
				String ageGroupCode = rs.getString(1);
				json.append("ageGroup", ageGroupCode);
				count++;

			}
		}
		catch(Exception ee){
			System.err.println("PlaceBulkDietOrderServlet.java fetchAgeGroupCode--->"+ee.getMessage());
		}
		finally{
			try{
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null)ConnectionManager.returnConnection(conn,request);
			}catch(Exception e){}
		}
		return json;
	}

	public JSONObject fetchDietTypes(HttpServletRequest request){
		//ArrayList<String> list = new ArrayList<String>();//Common-ICN-0055
		Connection conn = ConnectionManager.getConnection(request);
		PreparedStatement pstmt=null;
		ResultSet rs=null;

		JSONObject jsonResponse = new JSONObject();

		String jsonData = request.getParameter("jsonData");
		JSONObject json = new JSONObject(jsonData);

		String language_Id=json.getString("languageId");
		String dietCategoryCode=json.getString("dietCategory");
		String patientClass = request.getParameter("patientClass");// Added for ML-MMOH-CRF-0820
		JSONArray ageGrplist=json.getJSONArray("ageGroupArr");
		StringBuffer sb_diet_Types = new StringBuffer(); // Added for ML-MMOH-CRF-0820
//Added Against ML-MMOH-CRF-0674 Starts Here
		String diettypeauto=json.getString("diettype_auto");
		diettypeauto=diettypeauto+"%";				
		//Added Against ML-MMOH-CRF-0674 Ends Here
		try{
						
			//sb_diet_Types.append("select diet_Type, ds_get_desc.ds_diet_type(diet_Type,'"+language_Id+"', 2) short_Desc from Ds_Diet_Type where eff_Status ='E' and diet_Category_Code like '"+dietCategoryCode+"' and age_Group_Code like '"+ageGrplist.getString(i).trim()+"' ");

			//Added Start Below for ML-MMOH-CRF-0820
			//for (int i = 0; i < ageGrplist.length(); i++){//Commented against ML-MMOH-CRF-0820
			sb_diet_Types.append("select diet_Type, ds_get_desc.ds_diet_type(diet_Type,'"+language_Id+"', 2) short_Desc from Ds_Diet_Type where eff_Status ='E' and diet_Category_Code like '"+dietCategoryCode+"' and age_Group_Code IN (");
			for (int i = 0; i < ageGrplist.length(); i++){
				if(i>0){
					sb_diet_Types.append(",");
				}
				sb_diet_Types.append("'"+ageGrplist.getString(i).trim()+"'");
			}
			sb_diet_Types.append(")");
			
				if(patientClass.equals("IP"))
				{
					sb_diet_Types.append(" AND NVL(IP_DIET_TYPE_YN,'N') = 'Y' ");
				}
				else if(patientClass.equals("DC"))
				{
					sb_diet_Types.append(" AND NVL(DC_DIET_TYPE_YN,'N') = 'Y' ");
				}
			
			 	/*Added End Below for ML-MMOH-CRF-0820 */
				sb_diet_Types.append("AND short_desc LIKE '"+diettypeauto+"' order by lower(short_Desc)");//Added against ML_MMOH_CRF_0674
				pstmt = conn.prepareStatement(sb_diet_Types.toString());
				
				rs = pstmt.executeQuery();
				while(rs != null && rs.next()){
					String diet_Type = rs.getString(1);
					String short_Desc = rs.getString(2).replace(",","");

					jsonResponse.append("dietTypeCode", diet_Type);
					jsonResponse.append("dietTypeDesc", short_Desc);
				}

		//	}//Commented against ML-MMOH-CRF-0820
		}catch(Exception ee){
			System.err.println("PlaceBulkDietOrderServlet.java fetchDietTypes --->"+ee.getMessage());
		}
		finally{
			try{
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null)ConnectionManager.returnConnection(conn,request);
			}catch(Exception e){}
		}
		return jsonResponse;
	}

	public JSONObject fetchMealTypes(HttpServletRequest request){
		Connection conn = ConnectionManager.getConnection(request);
		PreparedStatement pstmt=null;
		ResultSet rs=null;

		JSONObject jsonResponse = new JSONObject();

		String jsonData = request.getParameter("jsonData");
		JSONObject json = new JSONObject(jsonData);

		String language_Id=json.getString("languageId");
		String mealClass = json.getString("mealClass");
		String dietType = json.getString("dietType");
		String kitchenCode = json.getString("kitchenCode");

			try{
				String meal_Types_query = "select menuTimeTable.meal_Type, mealType.short_Desc from Ds_Diet_Menu_Time_Table menuTimeTable, Ds_Meal_Type_Lang_Vw mealType where menuTimeTable.meal_Type = mealType.meal_Type and menuTimeTable.diet_Type = '"+dietType.trim()+"' and menuTimeTable.meal_Class like '"+mealClass+"' and menuTimeTable.kitchen_Code like '"+kitchenCode+"' and menuTimeTable.day_No = '1'  and mealType.LANGUAGE_ID = '"+language_Id+"' order by mealType.meal_order";
				pstmt = conn.prepareStatement(meal_Types_query);
				rs = pstmt.executeQuery();

				while(rs != null && rs.next()){
					String meal_type = rs.getString(1);
					String short_Desc = rs.getString(2);

					jsonResponse.append("mealTypeCode",meal_type);
					jsonResponse.append("mealTypeDesc",short_Desc);
				}

			}catch(Exception ee){
				System.err.println("PlaceBulkDietOrderServlet.java--->"+ee.getMessage());
			}
			finally{
				try{
					if(rs!=null) rs.close();
					if(pstmt!=null) pstmt.close();
					if(conn!=null)ConnectionManager.returnConnection(conn,request);
				}catch(Exception e){}
			}
		return jsonResponse;
	}

	public JSONObject getDayRefNo(HttpServletRequest request) {

		Connection conn = ConnectionManager.getConnection(request);
		PreparedStatement pstmt=null;
		ResultSet rs=null;

		int day = 0;
		Long cycleDays = 0L;
		java.util.Date menuDate = null;

		JSONObject jsonResponse = new JSONObject();
		String jsonData = request.getParameter("jsonData");
		JSONObject json = new JSONObject(jsonData);

		//String language_Id=json.getString("languageId"); //Common-ICN-0055
		String mealClass = json.getString("mealClass");
		String dietType = json.getString("dietType");
		String facility = json.getString("facility");
		String dateForMeanu = json.getString("dateForMenu");

		try {
			if(dateForMeanu != null && dateForMeanu != ""){
				menuDate = new SimpleDateFormat("dd/MM/yyyy").parse(dateForMeanu);
				System.out.println("menuDate-->"+menuDate);
			}
		}catch (ParseException e1) {
			e1.printStackTrace();
		}

		try{
			String day_ref_query = "select menu_Sched_Cycle_Days, to_char( meal_Plan_Ref_Date, 'DD/MM/YYYY' ), meal_Plan_Ref_Day_No from Ds_Diet_Menu_Sched_Cycle where diet_Type = '"+dietType.trim()+"' and meal_Class ='"+mealClass.trim()+"' and operating_Facility_Id ='"+facility+"'";
			pstmt = conn.prepareStatement(day_ref_query);
			rs = pstmt.executeQuery();
			while(rs != null && rs.next()){
				cycleDays = rs.getLong(1);
				String meal_Plan_Ref_Date = null;
				if(rs.getString(2) != null && rs.getString(2) != ""){
					meal_Plan_Ref_Date = rs.getString(2).substring(0,10);
				}
				DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
				System.out.println("meal_Plan_Ref_Date-->"+meal_Plan_Ref_Date);
				java.util.Date toDate = formatter.parse(meal_Plan_Ref_Date);
				System.out.println("toDate-->"+toDate);
				Long l_plan_ref_day_no = rs.getLong(3);
				System.out.println("l_plan_ref_day_no-->"+l_plan_ref_day_no);
				java.sql.Timestamp dateCompare = new 	Timestamp(toDate.getTime());
				System.out.println("dateCompare-->"+dateCompare);
				if(menuDate != null){
					long diff = Math.abs((menuDate.getTime() - dateCompare.getTime()));
					System.out.println("diff-->"+diff);
					int dayDiff = (int) Math.floor(diff / 1000 / 60 / 60 / 24);
					dayDiff = dayDiff + l_plan_ref_day_no.intValue();
					System.out.println("dayDiff-->"+dayDiff);
					day = (dayDiff % cycleDays.intValue());
					jsonResponse.put("dayRefNum", day);
				}
				System.out.println("day-->"+day);

			}
			if(day == 0){
				day = cycleDays.intValue();
				System.out.println("day 111-->"+day);
				jsonResponse.put("dayRefNum", day);

			}
		}
		catch(Exception ee){
			System.err.println("PlaceBulkDietOrderServlet.java getDayRefNo --->"+ee.getMessage());
		}
		finally{
			try{
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null)ConnectionManager.returnConnection(conn,request);
			}catch(Exception e){}
		}
		return jsonResponse;
	}

	public JSONObject getMealContents(HttpServletRequest request) {
		//ArrayList<String> returnList = new ArrayList<String>(); //Common-ICN-0055
		JSONObject jsonResponse = new JSONObject();
		String jsonData = request.getParameter("jsonData");
		JSONObject json = new JSONObject(jsonData);

		String language_Id =  json.getString("locale");
		JSONArray mealType = json.getJSONArray("_mTypeArr");
		String mealClass	=  json.getString("mClass");
		JSONArray dietType = json.getJSONArray("_dTypeArr");
		String profileID	=  json.getString("profileSL");
		String encounterID	=  json.getString("encounterId");
		String fromDate	=  json.getString("dateForMeanu");
		String dayRef	=  json.getString("dayRef");
		String kichenCode	=  json.getString("kitchenCode");
		String facility	=  json.getString("addedFacilityId");
		String dietTypes	=  json.getString("dietType");

		if ((profileID == null) || (profileID.equals(""))) {
			jsonResponse = getMenuItems(language_Id,mealType,mealClass,dietType,profileID,encounterID,fromDate,dayRef,kichenCode,facility,dietTypes,request);
	     } else{
	    	 jsonResponse = getMenuItems(language_Id,mealType,mealClass,dietType,profileID,encounterID,fromDate,dayRef,kichenCode,facility,dietTypes,request);
	     }
		return jsonResponse;
	}

	public JSONObject getMenuItems(String language_Id, JSONArray mealType, String mealClass, JSONArray dietType, String profileID, String encounterID, String fromDate, String dayRef, String kichenCode, String facility, String dietTypes,HttpServletRequest request){
		ArrayList<String> mealList = new ArrayList<String>();
		//ArrayList<String> menuItemsList = new ArrayList<String>();	//Common-ICN-0044

		JSONObject jsonResponse = new JSONObject();
//		JSONObject obj=new JSONObject();

		Connection conn = ConnectionManager.getConnection(request);
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String menuCode = null;
		try{
			for(int i=0; i < dietType.length(); i++){
				String menucode_query = "select  dsmenu2_.menu_code AS menu_code from Ds_Diet_Menu_Time_Table dsdietmenu0_, ds_meal_type dsmealtype1_, ds_menu dsmenu2_ where dsdietmenu0_.meal_type = dsmealtype1_.meal_type and dsdietmenu0_.menu_code = dsmenu2_.menu_code and ((dsdietmenu0_.operating_Facility_Id = '"+facility+"') and (dsdietmenu0_.kitchen_Code = '"+kichenCode+"') and (dsdietmenu0_.diet_Type = '"+dietType.getString(i).trim()+"') and (dsdietmenu0_.meal_Type = '"+mealType.getString(i).trim()+"') and (dsdietmenu0_.meal_Class = '"+mealClass+"') and (dsdietmenu0_.day_No = '"+dayRef+"')) ORDER BY dsmealtype1_.meal_order, 1";
				pstmt = conn.prepareStatement(menucode_query);
				rs = pstmt.executeQuery();
				while(rs != null && rs.next()){
					menuCode = rs.getString(1);
					mealList.add(menuCode);
				}
				if(mealList != null){
					for(int j=0; j< mealList.size(); j++){
						String menu_items_query = "select menutimetable.MEAL_TYPE,dsmealtype.short_desc as mealTypeShortDesc,menuitem.item_Code,items.short_Desc as itemShortDesc,menuitem.item_Qty,menuitem.item_Type, items.serving_Uom_Code,to_char(items.calorific_Cont_Per_Uom,'999999.99'),lower(param.energy_Uom), am_get_desc.am_uom (items.serving_uom_code,'"+language_Id+"', '2') serving_uom_desc,am_get_desc.am_uom (param.energy_uom, '"+language_Id+"', '2') energy_uom_desc from Ds_Menu_Item menuitem, Ds_Menu menu, Ds_Items items, Ds_Param param,Ds_Diet_Menu_Time_Table menutimetable,ds_meal_type_lang_Vw  dsmealtype where " +
								"menuitem.item_Code = items.food_Item_Code and " +
								"menuitem.menu_Code = menu.menu_Code and menutimetable.menu_Code = menu.menu_Code and " +
								"dsmealtype.meal_type = menutimetable.meal_type and menutimetable.operating_Facility_Id ='"+facility+"' and " +
								"menuitem.menu_Code ='"+mealList.get(j).trim()+"' and menutimetable.kitchen_Code = '"+kichenCode+"' " +
								"and menutimetable.diet_Type = '"+dietType.getString(i).trim()+"' " +
								"and menutimetable.meal_Type ='"+mealType.getString(i).trim()+"' and menutimetable.meal_Class = '"+mealClass+"'" +
								"and menutimetable.day_No = '"+dayRef+"' and dsmealtype.language_id = '"+language_Id+"' " +
								"and items.language_Id  = '"+language_Id+"' " +
								" ORDER BY dsmealtype.meal_order";

//						String menu_items_query = "select menutimetable.MEAL_TYPE,dsmealtype.short_desc,menuitem.item_Code,items.short_Desc,menuitem.item_Qty,menuitem.item_Type, items.serving_Uom_Code,to_char(items.calorific_Cont_Per_Uom,'999999.99'),lower(param.energy_Uom) from Ds_Menu_Item menuitem, Ds_Menu menu, Ds_Items items, Ds_Param param,Ds_Diet_Menu_Time_Table menutimetable,ds_meal_type_lang_Vw  dsmealtype where menuitem.item_Code = items.food_Item_Code and menuitem.menu_Code = menu.menu_Code and menutimetable.menu_Code = menu.menu_Code and dsmealtype.meal_type = menutimetable.meal_type and menutimetable.operating_Facility_Id ='"+facility+"' and menuitem.menu_Code ='"+mealList.get(j).trim()+"' and menutimetable.kitchen_Code = '"+kichenCode+"' and menutimetable.diet_Type = '"+dietType[i].trim()+"' and menutimetable.meal_Type ='"+mealType[i].trim()+"' and menutimetable.meal_Class = '"+mealClass+"' and menutimetable.day_No = '"+dayRef+"' and dsmealtype.language_id = '"+language_Id+"' and items.language_Id  = '"+language_Id+"' ORDER BY dsmealtype.meal_order";
						pstmt = conn.prepareStatement(menu_items_query);
						rs = pstmt.executeQuery();
						while(rs != null && rs.next()){
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
							JSONObject obj=new JSONObject();

							obj.put("mealType",meal_Type);
							obj.put("shortDesc",short_Desc);
							obj.put("itemCode",item_Code);
							obj.put("shortDesc1",short_Desc1);
							obj.put("itemQty",item_Qty);
							obj.put("itemType",item_Type);
							obj.put("servUOMCode",serving_Uom_Code);
							obj.put("calorificCont",calorific_Cont_Per_Uom);
							obj.put("energyUom",energy_Uom);
							//Added Against KDAH-CRF-0352 Starts Here
							obj.put("servingUom_Desc",serving_Uom_Desc);
							obj.put("energyUom_Desc",energy_Uom_Desc);
							//Added Against KDAH-CRF-0352 Ends Here

							jsonResponse.append("menuItem", obj);
						}
			            if(rs!=null) rs.close();
			        	if(pstmt!=null) pstmt.close();
						mealList.clear();
					}
				}
			}
		}catch(Exception ee){
			System.err.println("PlaceBulkDietOrderServlet.java--->"+ee.getMessage());
		}
		finally{
			try{
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null)ConnectionManager.returnConnection(conn,request);
			}catch(Exception e){}
		}

		return jsonResponse;
	}

	private JSONObject processPatientList(HttpServletRequest request, HttpServletResponse response,boolean dietProfileDtlFlag) throws SQLException, IOException, ParseException {//006
		JSONObject resp=new JSONObject();

		String encounterId=null, patientClass=null,patientId=null,profileSL=null,isNewFlag=null;

		String patientObj = request.getParameter("jsonPatientObject");
		JSONObject jsonPatientObj = new JSONObject(patientObj);
		JSONArray patArray=jsonPatientObj.getJSONArray("patients");

		for(int i=0;i<patArray.length();i++) {
			JSONObject obj=patArray.getJSONObject(i);
			JSONObject patObj=obj.getJSONObject("patient");
			encounterId=patObj.getString("encounterId").trim();
			patientId=patObj.getString("patientId").trim();
			patientClass=patObj.getString("patientClass").trim();
			profileSL=patObj.getString("profileSL").trim();
			isNewFlag=patObj.getString("newFlag").trim();
			dietProfileDtlFlag=true;//006
			resp=insertMealContents(request,response,encounterId,patientId,patientClass,profileSL,isNewFlag,dietProfileDtlFlag);//006
		}
		return resp;
	}

	private JSONObject processPatientList_SplFoodItems(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ParseException {
		JSONObject resp=new JSONObject();

		String encounterId=null, patientClass=null,patientId=null,profileSL=null,isNewFlag=null;

		String patientObj = request.getParameter("jsonPatientObject");
		JSONObject jsonPatientObj = new JSONObject(patientObj);
		JSONArray patArray=jsonPatientObj.getJSONArray("patients");

		for(int i=0;i<patArray.length();i++) {
			JSONObject obj=patArray.getJSONObject(i);
			JSONObject patObj=obj.getJSONObject("patient");
			encounterId=patObj.getString("encounterId").trim();
			patientId=patObj.getString("patientId").trim();
			patientClass=patObj.getString("patientClass").trim();
			profileSL=patObj.getString("profileSL").trim();
			isNewFlag=patObj.getString("newFlag").trim();
			resp=insertSplFoodItems(request,response,encounterId,patientId,patientClass,profileSL,isNewFlag);
		}
		return resp;
	}

	private JSONObject processPatientList_FoodDislikes(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ParseException {
		JSONObject resp=new JSONObject();

		String encounterId=null, patientClass=null,patientId=null,profileSL=null;

		String patientObj = request.getParameter("jsonPatientObject");
		JSONObject jsonPatientObj = new JSONObject(patientObj);
		JSONArray patArray=jsonPatientObj.getJSONArray("patients");

		for(int i=0;i<patArray.length();i++) {
			JSONObject obj=patArray.getJSONObject(i);
			JSONObject patObj=obj.getJSONObject("patient");
			encounterId=patObj.getString("encounterId").trim();
			patientId=patObj.getString("patientId").trim();
			patientClass=patObj.getString("patientClass").trim();
			profileSL=patObj.getString("profileSL").trim();
			resp=insertFoodDislikes(request,response,encounterId,patientId,patientClass,profileSL);
		}
		return resp;
	}
	//MMS-DM-0006
	private String dietTypeModifiedCheck(HttpServletRequest request, HttpServletResponse response,String OPERATING_FACILITY_ID,String ENCOUNTER_ID,String PROFILE_SL,String Diet_Type,String Meal_Type){
		String result="";
		//OPERATING_FACILITY_ID=? and ENCOUNTER_ID=? and PROFILE_SL=? and MEAL_TYPE=?
		String query="select count(*) from DS_EPSD_DIET_PROFILE_DTL where OPERATING_FACILITY_ID=? and ENCOUNTER_ID=? and PROFILE_SL=? and DIET_TYPE=? and MEAL_TYPE=?";
		Connection conn = ConnectionManager.getConnection(request);
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try{
			pstmt=conn.prepareStatement(query);
			pstmt.setString(1,OPERATING_FACILITY_ID);
			pstmt.setString(2,ENCOUNTER_ID);
			pstmt.setString(3,PROFILE_SL);
			pstmt.setString(4,Diet_Type);
			pstmt.setString(5,Meal_Type);
			/*System.err.println("ENCOUNTER_ID:"+ENCOUNTER_ID);
			System.err.println("PROFILE_SL:"+PROFILE_SL);
			System.err.println("MEAL_TYPE:"+Meal_Type);
			System.err.println("Diet_TYPE:"+Diet_Type);
			System.err.println("OPERATING_FACILITY_ID :sa"+OPERATING_FACILITY_ID);*/
			rs=pstmt.executeQuery();
			if(rs.next()){
			result=rs.getString(1);
			}
			
			if(pstmt!=null) pstmt.close();	//Added Against Common-ICN-0031
			if(rs!=null) rs.close();	//Added Against Common-ICN-0031
			
		}catch(Exception e){
			e.printStackTrace();
			
		}finally{
			if(conn!=null)ConnectionManager.returnConnection(conn,request);
		}
		System.err.println("Result :627:"+result);
		return result;
		
	}
	//MMS-DM-0006
	private JSONObject insertMealContents(HttpServletRequest request, HttpServletResponse response, String encounterId,String patientId,String patientClass,String profileSL,String isNewFlag,boolean dietProfileDtlFlag) throws SQLException, IOException, ParseException{//006
		JSONObject ordersList=new  JSONObject();

		session = request.getSession(false);
		String language_id = (String)session.getAttribute("LOCALE");
		//CRF-0684
        boolean isMenuType =false;        
		Connection conn = ConnectionManager.getConnection(request);
		isMenuType = CommonBean.isSiteSpecific(conn,"DS","DS_MENU_TYPE");
		//CRF-0684	
		/* ORDER CATALOG */
		String MEAL_CATEGORY_CODE = null;
		String feedType = null;
		String dsDeliveryInstr = null;
		String texture_of_diet = null;//ML-MMOH-CRF-412
		String dieticianReferral = null;
		String viewCode=null;
        String menu_type = null;//CRF-0684
		//JSONObject jsonResponse = new JSONObject();	//Common-ICN-0044
		String jsonData = request.getParameter("jsonData");
		JSONObject json = new JSONObject(jsonData);
		
		String irregular_meal_code=request.getParameter("irregular_meal_code");//409
		String irregular_flag="";//409
		
		String dietCategory = json.getString("dietCategory");
		String addedById = json.getString("addedById");
		String addedFacilityId = json.getString("addedFacilityId");
//		String isNEW = json.getString("isNEW");
		String isNEW=isNewFlag;
		Long pi = Long.parseLong(profileSL);
		//String locationType = json.getString("locationType");	//Common-ICN-0044
		String locationCode = json.getString("locationCode");
		String addedAtWsNo = json.getString("addedAtWsNo");

		JSONArray mealTypesForDietType = json.getJSONArray("objMeal");
		JSONArray dietTypesforMealType = json.getJSONArray("obDiet");
		 //MMS-KH-CRF-029.1 Starts
		JSONArray remarksJsonArr = json.getJSONArray("returnRemarks");
		String fRemarks	= "";
		String remarksEncIdVal	= "";
		String fRemarksVal	= "";
		String fRemarksTokArr	= "";
		for(int i=0;i<remarksJsonArr.length();i++){
			fRemarksTokArr	= remarksJsonArr.getJSONObject(i).getString("remarks").trim();
			StringTokenizer st = new StringTokenizer(fRemarksTokArr,"|~|");			
			while(st.hasMoreTokens()) {
				fRemarksVal = st.nextToken();
				remarksEncIdVal = st.nextToken();
				if(remarksEncIdVal.equals(encounterId) && !fRemarksVal.equals("undefined")){
					fRemarks	= fRemarksVal;
				}
			}//While
		}//For
		 //MMS-KH-CRF-029.1 Ends	
		
		Long servingFreq = new Long(2L);
		String mClass = json.getString("mClass");
		String dType = json.getString("dType");
		String dietCycleType = "";

		String fromDate = json.getString("fromDate");
		String from = null;
		if(json.getString("NBMfrom") != null && !json.getString("NBMfrom").equals("")){
			from = com.ehis.util.DateUtils.convertDate(json.getString("NBMfrom"),"DMYHM", language_id, "en");
		}

		String to = null;
		if(json.getString("NBMto") != null && !json.getString("NBMto").equals("")){
			to = com.ehis.util.DateUtils.convertDate(json.getString("NBMto"),"DMYHM", language_id, "en");
		}

		String DIETARY_REMARKS = null;
		if(json.getString("feedingInstructions") != null && !json.getString("feedingInstructions").equals("")){
			DIETARY_REMARKS = URLDecoder.decode(json.getString("feedingInstructions"),"UTF-8");
		}
		String prepInstr = null;
		if(json.getString("prepInstr") != null && !json.getString("prepInstr").equals("")){
			prepInstr = URLDecoder.decode(json.getString("prepInstr"),"UTF-8");
		}
		String toDate =null;
		if(json.getString("dateTo") != null && !json.getString("dateTo").equals("")){
			toDate = json.getString("dateTo");
		}
		if("IP".equals(patientClass) || "DC".equals(patientClass)){
            MEAL_CATEGORY_CODE = "INP";
		}else if("OP".equals(patientClass) || "EM".equals(patientClass)){
            MEAL_CATEGORY_CODE ="OUT";
		}
		if(json.getString("feedType") != null && !json.getString("feedType").equals("")){
			feedType = json.getString("feedType");
		}
		if(json.getString("dsDeliveryInstr") != null && !json.getString("dsDeliveryInstr").equals("")){
			dsDeliveryInstr = json.getString("dsDeliveryInstr");
		}
		
		//ML-MMOH-CRF-412
		if(request.getParameter("texture_of_diet") != null && !request.getParameter("texture_of_diet").equals("")){
			texture_of_diet = request.getParameter("texture_of_diet");
		}
		//ML-MMOH-CRF-412
		//CRF-684
		if(isMenuType){
		if(request.getParameter("menu_type") != null && !request.getParameter("menu_type").equals("")){
			menu_type = request.getParameter("menu_type");			
		}
		}
		else {
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
		if(json.getString("status") != null && !json.getString("status").equals("")){
			status = json.getString("status");
		}
		if(json.getString("dieticianReferral") != null && !json.getString("dieticianReferral").equals("")){
			dieticianReferral = json.getString("dieticianReferral");
		}
		/*String remarks = "";
		if(json.getString("returnRemarks") != null && !json.getString("returnRemarks").equals("")){
			remarks = json.getString("returnRemarks");
		}*/
		//CRF-428
		String mealExclusions = request.getParameter("mealExclusions");
		String manualexcludedMeals=request.getParameter("manualexcludedMeals");//428
		
		JSONObject exclusionsObj = new JSONObject(mealExclusions);		
		JSONObject manualexcludedMealsObj = new JSONObject(manualexcludedMeals);//428
		//CRF-428
		//Initialization and getting the connections
		PreparedStatement pstmt=null;
		PreparedStatement pstmt1=null;
		ResultSet rs=null;
		ResultSet rs1=null;
		CallableStatement cstmt = null;
		CallableStatement cst = null;
		String P_Error_Text = null;
		String orderTypeString = null;
		//MMS-DM-0006
		//Checking for diet type is modified or not starts 
		String DietTypeModified_YN="N";
		//if(mealTypesForDietType != null && !mealTypesForDietType.equals("") && viewCode != null && !(viewCode.equals(""))){
		
		//check if diet type is already modified getOldDietModifiedStatus
		DietTypeModified_YN=getOldDietModifiedStatus(request,encounterId,profileSL,facility_id);
		if(DietTypeModified_YN.equals("N")){
		for(int i=0; i<mealTypesForDietType.length(); i++){
		
		String ret=dietTypeModifiedCheck(request,response,facility_id,encounterId,profileSL,dietTypesforMealType.getJSONObject(i).getString("diet").trim(),mealTypesForDietType.getJSONObject(i).getString("meal").trim());
		System.err.println("ret :"+ret);
		if(ret.equals("0")){
			System.err.println("diet Modified");
			DietTypeModified_YN="Y";
			
		}
		}
		}
		//}
		System.err.println("DietTypeModified_YN :"+DietTypeModified_YN);
		//MMS-DM-0006
		//ends
		//Check for old irregular code is avaiable or not
		//HttpServletRequest request,String encounterId,String profileSL,String facilityid
		irregular_meal_code+=getOldIrregularMealCode(request,encounterId,profileSL,facility_id);
		/**
		 * Getting the orderTypeCode to process the other details
		 */
		try{
			String orderTypeCode_query = "select dietcategory.order_Type_Code from Ds_Diet_Category dietcategory where dietcategory.diet_Category_Code='"+dietCategory+"'";
			String dietTypeCycle_query = "select dietType.diet_Cycle_Type from Ds_Diet_Type dietType where dietType.diet_Type = '"+dType+"'";
			pstmt = conn.prepareStatement(orderTypeCode_query);
			pstmt1 = conn.prepareStatement(dietTypeCycle_query);
			rs = pstmt.executeQuery();
			rs1 = pstmt1.executeQuery();
			while(rs != null && rs.next()){
				orderTypeString = rs.getString(1);
			}
			if(rs1 != null && rs1.next()){
				dietCycleType = rs1.getString(1);
			}
			

			rs.close();
			rs1.close();
			pstmt.close();
			pstmt1.close();
		/**
		 * If order is new calling the Insert_Order_Header procedure
		 */
		if ((isNEW != null && isNEW.equalsIgnoreCase("true")) || pi.equals(new Long(0))) {
			System.out.println("Inside the Insert_Order_Header procedure");
			cstmt = conn.prepareCall("{call Insert_Order_Header(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			cstmt.setString(1, "DS");
			if (orderTypeString != null){
				cstmt.setString(2, orderTypeString);
			}else{
				cstmt.setString(2, dietCategory);
			}
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
			cstmt.setString(13, "N");
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
		}else {
			// defaulting the order ID
			viewCode = "";
		}
		System.out.println("viewCode---------"+viewCode+"<<<<<");
		System.out.println("P_Error_Text in Order Header---------"+P_Error_Text+"<<<<<");
		/**
		 * If Order is new then calling the Insert_Order_Line procedure
		 */
		if ((isNEW != null && isNEW.equalsIgnoreCase("true")) || pi.equals(new Long(0))) {
			System.out.println("Inside the Insert_Order_Line procedure");
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
				cst.setString(3, dietCategory);

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
		System.out.println("P_Error_Text---------"+P_Error_Text+"<<<<<");

		/**
		 * Inserting into the DS_EPSD_DIET_PROFILE_HDR table based on the Order Id and Order Type
		 */
		
		if(viewCode != null && !(viewCode.equals(""))){
			System.out.println("insert the DS_EPSD_DIET_PROFILE_HDR table");
			int flag;
			String dietProfileHdr = "insert into DS_EPSD_DIET_PROFILE_HDR (MEAL_CLASS, ORDER_TYPE_CODE, FEED_TYPE, DIET_CATEGORY, PATIENT_ID, DIET_TYPE, DELIVERY_CODE, PATIENT_CLASS, PERIOD_FROM, PERIOD_TO, NIL_BY_MOUTH_FRM, NIL_BY_MOUTH_TO, MEAL_CATEGORY_CODE, DIET_CYCLE_TYPE, STD_SERVICE_YN, CONSISTENCY_DTL, ATTENDANT_MEAL_YN, NO_OF_ATTENDANT_MEALS, DIETARY_REMARKS, ORDER_ID, MEAL_PLAN_CREATED_YN, MEAL_PLAN_CREATED_DATE, MEAL_PLAN_REF_DATE, MEAL_PLAN_REF_DAY_NO, DEFAULT_DIET_YN, CANCELED_PRACT_ID, CANCELLED_DATE, CANCEL_REASON, STATUS, ADDED_BY_ID, ADDED_DATE, ADDED_FACILITY_ID, ADDED_AT_WS_NO, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_FACILITY_ID, MODIFIED_AT_WS_NO, PREP_INSTR, OPERATING_FACILITY_ID, ENCOUNTER_ID, PROFILE_SL,DIETICIAN_REFRL_YN,DISCHARGE_FLAG_YN,REMARKS,DIET_TYPE_MODIFIED,TEXTURE_OF_DIET,MENU_TYPE) values (?, ?, ?, ?, ?, ?, ?, ?, to_date(?,'dd/mm/yyyy'),to_date(?,'dd/mm/yyyy'),to_date(?,'dd/mm/yyyy HH24:MI'),to_date(?,'dd/mm/yyyy HH24:MI'),?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?,?,?,?,?,?)";//CRF-412
			pstmt = conn.prepareStatement(dietProfileHdr);
			pstmt.setString(1, mClass);
			pstmt.setString(2, orderTypeString);
			pstmt.setString(3, feedType);
			pstmt.setString(4, dietCategory);
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
			pstmt.setString(29, status);
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
			// FOR Discharge Flag
			pstmt.setString(43, "");
			pstmt.setString(44, fRemarks); //MMS-KH-CRF-029.1
			pstmt.setString(45,"N");//MMS-DM-0006
			pstmt.setString(46,texture_of_diet);//ML-MMOH-CRF-412
			pstmt.setString(47,menu_type);//CRF -0684
			System.out.println("pi---insert------"+pi+"<<<<<");
			flag = pstmt.executeUpdate();
			if(flag != 0){
				System.out.println("flag is not zero");
				conn.commit();
			}else{
				System.out.println("flag is zero");
				conn.rollback();
			}
			pstmt.close();
			updateOldOrders(request,pi,encounterId,addedFacilityId,fromDate);
			excludeMeals(addedFacilityId,encounterId,pi,exclusionsObj,request);		//CRF-428			
			deleteOverLapNBMProfile(encounterId,addedFacilityId,fromDate,toDate,conn);//CRF-410 18th Dec
		}
		else{
			// Update the HDR table
			System.err.println("update the DS_EPSD_DIET_PROFILE_HDR table");
			int flag;
			String dietProfileHdrUpd = "update DS_EPSD_DIET_PROFILE_HDR set MEAL_CLASS=?, ORDER_TYPE_CODE=?, FEED_TYPE=?, DIET_CATEGORY=?, PATIENT_ID=?, DIET_TYPE=?, DELIVERY_CODE=?, PATIENT_CLASS=?, PERIOD_FROM=to_date(?,'dd/mm/yyyy'), PERIOD_TO=to_date(?,'dd/mm/yyyy'), NIL_BY_MOUTH_FRM=to_date(?,'dd/mm/yyyy HH24:MI'), NIL_BY_MOUTH_TO=to_date(?,'dd/mm/yyyy HH24:MI'), MEAL_CATEGORY_CODE=?, DIET_CYCLE_TYPE=?, STD_SERVICE_YN=?, CONSISTENCY_DTL=?, ATTENDANT_MEAL_YN=?, NO_OF_ATTENDANT_MEALS=?, DIETARY_REMARKS=?, MEAL_PLAN_CREATED_YN=?, MEAL_PLAN_CREATED_DATE=?, MEAL_PLAN_REF_DATE=?, MEAL_PLAN_REF_DAY_NO=?, DEFAULT_DIET_YN=?, CANCELED_PRACT_ID=?, CANCELLED_DATE=?, CANCEL_REASON=?, STATUS=?, ADDED_BY_ID=?, ADDED_DATE=?, ADDED_FACILITY_ID=?, ADDED_AT_WS_NO=?, MODIFIED_BY_ID=?, MODIFIED_DATE=?, MODIFIED_FACILITY_ID=?, MODIFIED_AT_WS_NO=?, PREP_INSTR=?, DIETICIAN_REFRL_YN=?, DISCHARGE_FLAG_YN=?,REMARKS=?,DIET_TYPE_MODIFIED=?,TEXTURE_OF_DIET=?,MENU_TYPE =? where OPERATING_FACILITY_ID=? and ENCOUNTER_ID=? and PROFILE_SL=?";//MMS-DM-0006
			pstmt = conn.prepareStatement(dietProfileHdrUpd);
			pstmt.setString(1, mClass);
			pstmt.setString(2, orderTypeString);
			pstmt.setString(3, feedType);
			pstmt.setString(4, dietCategory);
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
			pstmt.setString(25, null);
			pstmt.setString(26, null);
			pstmt.setString(27, null);
			pstmt.setString(28, status);
			pstmt.setString(29, addedById);
			pstmt.setTimestamp(30, getCurrentTimeStamp());
			pstmt.setString(31, addedFacilityId);
			pstmt.setString(32, addedAtWsNo);
			pstmt.setString(33, addedById);
			pstmt.setTimestamp(34, getCurrentTimeStamp());
			pstmt.setString(35, addedFacilityId);
			pstmt.setString(36, addedAtWsNo);
			pstmt.setString(37, prepInstr);
			pstmt.setString(38, dieticianReferral);
			// For discharge flag
			pstmt.setString(39, "");
			pstmt.setString(40, fRemarks); //MMS-KH-CRF-029.1
			pstmt.setString(41,DietTypeModified_YN);//MMS-DM-0006
			pstmt.setString(42,texture_of_diet);//ML-MMOH-CRF-412
			pstmt.setString(43,menu_type);//CRF-0684
			pstmt.setString(44, addedFacilityId);
			pstmt.setString(45, encounterId);
			pstmt.setLong(46, pi);
			System.out.println("pi---update------"+pi+"<<<<<");
			flag = pstmt.executeUpdate();
			if(flag != 0){
				System.out.println("flag is not zero in update HDR table");
				conn.commit();
			}else{
				System.out.println("flag is zero in update HDR table");
				conn.rollback();
			}
			pstmt.close();
			excludeMeals(addedFacilityId,encounterId,pi,manualexcludedMealsObj,request);		//CRF-428			
			deleteOverLapNBMProfile(encounterId,addedFacilityId,fromDate,toDate,conn);//CRF-410 18th Dec
		}
		/**
		 * Inserting into the DS_EPSD_DIET_PROFILE_DTL table based on the mealTypeForDietType
		 */
		if(mealTypesForDietType != null && !mealTypesForDietType.equals("") && viewCode != null && !(viewCode.equals(""))){
			System.out.println("insert the DS_EPSD_DIET_PROFILE_DTL table");
			int flag;
			for(int i=0; i<mealTypesForDietType.length(); i++){
				System.out.println("dietTypesforMealType[i].trim()---------"+dietTypesforMealType.getJSONObject(i).getString("diet").trim()+"<<<<<");
				System.out.println("mealTypesForDietType[i].trim()---------"+mealTypesForDietType.getJSONObject(i).getString("meal").trim()+"<<<<<");
				System.out.println("servingFreq---------"+servingFreq+"<<<<<");
				System.out.println("pi---------"+pi+"<<<<<");
				
				//ML-MMOH-CRF-409 Starts
				if(irregular_meal_code.contains(mealTypesForDietType.getJSONObject(i).getString("meal").trim())){
					irregular_flag="Y";					
				}else{
					irregular_flag="N";					
				}
				//ML-MMOH-CRF-409 Ends
				
				String dietProfileDtl = "insert into DS_EPSD_DIET_PROFILE_DTL (PATIENT_CLASS, DIET_TYPE, MEAL_CLASS, FEED_TYPE, DELIVERY_CODE, SERVING_TIME, SERVING_FREQ, PERIOD_BET_SERVINGS, MEAL_PLAN_CREATED_YN, MEAL_PLAN_CREATED_DATE, MEAL_PLAN_REF_DATE, MEAL_PLAN_REF_DAY_NO, ADDED_BY_ID, ADDED_DATE, ADDED_FACILITY_ID, ADDED_AT_WS_NO, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_FACILITY_ID, MODIFIED_AT_WS_NO, ORDER_ID, ORDER_LINE_NUM, OPERATING_FACILITY_ID, ENCOUNTER_ID, PROFILE_SL, MEAL_TYPE,DISCHARGE_FLAG_YN,IRREGULAR_FLAG_YN) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?)";//ML-MMOH-CRF-409
				pstmt = conn.prepareStatement(dietProfileDtl);
				pstmt.setString(1, patientClass);
				pstmt.setString(2, dietTypesforMealType.getJSONObject(i).getString("diet").trim());
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
				pstmt.setString(26, mealTypesForDietType.getJSONObject(i).getString("meal").trim());
				// discharge flag
				pstmt.setString(27, "");
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
			//conn1.close();
		}
		else if(mealTypesForDietType != null && !mealTypesForDietType.equals("")){
			System.out.println("update the DS_EPSD_DIET_PROFILE_DTL table");
			System.out.println("pi---------"+pi+"<<<<<");
			int flag;
			for(int i=0; i<mealTypesForDietType.length(); i++){
			
			//ML-MMOH-CRF-409
				System.out.println("1068 :"+irregular_meal_code.contains(mealTypesForDietType.getJSONObject(i).getString("meal").trim()));
				if(irregular_meal_code.contains(mealTypesForDietType.getJSONObject(i).getString("meal").trim())){
					irregular_flag="Y";					
				}else{
					irregular_flag="N";					
				}
				//ML-MMOH-CRF-409
				
				//delete the DS_EPSD_DIET_PROFILE_DTL and then insert the data 006 CRF
				
				if(dietProfileDtlFlag){				
				String dietProfileDtlDel = "Delete from DS_EPSD_DIET_PROFILE_DTL where OPERATING_FACILITY_ID=? and ENCOUNTER_ID=? and PROFILE_SL=?";
				pstmt = conn.prepareStatement(dietProfileDtlDel);
				pstmt.setString(1, addedFacilityId);
				pstmt.setString(2, encounterId);
				pstmt.setLong(3, pi);
				int delflag = pstmt.executeUpdate();
				if(delflag  != 0){
					conn.commit();
					dietProfileDtlFlag=false;
				}else{
					conn.rollback();					
				}
				}
				String dietProfileDtl = "insert into DS_EPSD_DIET_PROFILE_DTL (PATIENT_CLASS, DIET_TYPE, MEAL_CLASS, FEED_TYPE, DELIVERY_CODE, SERVING_TIME, SERVING_FREQ, PERIOD_BET_SERVINGS, MEAL_PLAN_CREATED_YN, MEAL_PLAN_CREATED_DATE, MEAL_PLAN_REF_DATE, MEAL_PLAN_REF_DAY_NO, ADDED_BY_ID, ADDED_DATE, ADDED_FACILITY_ID, ADDED_AT_WS_NO, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_FACILITY_ID, MODIFIED_AT_WS_NO, ORDER_ID, ORDER_LINE_NUM, OPERATING_FACILITY_ID, ENCOUNTER_ID, PROFILE_SL, MEAL_TYPE,DISCHARGE_FLAG_YN,IRREGULAR_FLAG_YN) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?)";//ML-MMOH-CRF-409
				pstmt = conn.prepareStatement(dietProfileDtl);
				pstmt.setString(1, patientClass);
				pstmt.setString(2, dietTypesforMealType.getJSONObject(i).getString("diet").trim());System.err.println("diet:"+dietTypesforMealType.getJSONObject(i).getString("diet").trim());
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
				pstmt.setString(24, encounterId);System.err.println("encounterId:"+encounterId);
				pstmt.setLong(25, pi);System.err.println("pi:"+pi);
				pstmt.setString(26, mealTypesForDietType.getJSONObject(i).getString("meal").trim());System.err.println("meal:"+mealTypesForDietType.getJSONObject(i).getString("meal").trim());
				// discharge flag
				pstmt.setString(27, "");
				pstmt.setString(28,irregular_flag);//409
				flag = pstmt.executeUpdate();
				if(flag != 0){
					System.out.println("1187 flag1 is not zero flag:"+flag);
					conn.commit();
				}else{
					System.out.println("1190 flag1 is zero flag:"+flag);
					conn.rollback();
				}
				pstmt.close();
				//006
				/*String dietProfileDtlUpd = "update DS_EPSD_DIET_PROFILE_DTL set PATIENT_CLASS=?, DIET_TYPE=?, MEAL_CLASS=?, FEED_TYPE=?, DELIVERY_CODE=?, SERVING_TIME=?, SERVING_FREQ=?, PERIOD_BET_SERVINGS=?, MEAL_PLAN_CREATED_YN=?, MEAL_PLAN_CREATED_DATE=?, MEAL_PLAN_REF_DATE=?, MEAL_PLAN_REF_DAY_NO=?, ADDED_BY_ID=?, ADDED_DATE=?, ADDED_FACILITY_ID=?, ADDED_AT_WS_NO=?, MODIFIED_BY_ID=?, MODIFIED_DATE=?, MODIFIED_FACILITY_ID=?, MODIFIED_AT_WS_NO=?, ORDER_LINE_NUM=?,DISCHARGE_FLAG_YN=?,IRREGULAR_FLAG_YN=? where OPERATING_FACILITY_ID=? and ENCOUNTER_ID=? and PROFILE_SL=? and MEAL_TYPE=?";//ML-MMOH-CRF-409
				pstmt = conn.prepareStatement(dietProfileDtlUpd);
				pstmt.setString(1, patientClass);
				pstmt.setString(2, dietTypesforMealType.getJSONObject(i).getString("diet").trim());
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
				pstmt.setLong(21, new Long(1L));
				// discharge flag
				pstmt.setString(22, "");
				pstmt.setString(23,irregular_flag);//409
				pstmt.setString(24, addedFacilityId);
				pstmt.setString(25, encounterId);
				pstmt.setLong(26, pi);
				pstmt.setString(27, mealTypesForDietType.getJSONObject(i).getString("meal").trim());
				flag = pstmt.executeUpdate();
				if(flag != 0){
					System.out.println("flag1 is not zero in update DTL table");
					conn.commit();
				}else{
					System.out.println("flag1 is zero in update DTL table");
					conn.rollback();
				}*/
			}
		}
		
		//excludeMeals(addedFacilityId,encounterId,pi,exclusionsObj,request);		//CRF-428--Vikash Commented

		/**
		 * This Following Code To Fetch The List of Diet orders In HEADER Tables
		 */
		ordersList = fecthMealContents(addedFacilityId,encounterId,request);
		System.out.println("ordersList"+ordersList+"<<<<<");
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Excetion after the try block end-------->"+e.getMessage());
			if (P_Error_Text != null) {
			}
		}
		finally
		{
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			if(cstmt!=null) cstmt.close();
			if(conn!=null)ConnectionManager.returnConnection(conn,request);
		}
		return ordersList;
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
			System.err.println("PlaceBulkDietOrderServlet.java--->"+ee.getMessage());
		}finally{
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			if(conn!=null)ConnectionManager.returnConnection(conn,request);
		}

		return defaultDietYn;
	}

	private static java.sql.Timestamp getCurrentTimeStamp() {
	    java.util.Date today = new java.util.Date();
	    return new java.sql.Timestamp(today.getTime());
	}

	private JSONObject fecthMealContents(String facility,String encounterId,HttpServletRequest request) throws SQLException{
		JSONObject obj = new JSONObject();
		Connection conn = ConnectionManager.getConnection(request);
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try{
			String dietOrderQuery = "SELECT dsepsddiet.diet_category,dsepsddiet.meal_class,dsepsddiet.feed_type,dsepsddiet.diet_type,dsepsddiet.dietary_remarks,dsepsddiet.delivery_code,dsepsddiet.patient_class,dsepsddiet.encounter_id,dsepsddiet.profile_sl,dsepsddiet.period_from,dsepsddiet.period_to,dsepsddiet.added_date,dsepsddiet.status,dsepsddiet.order_id,dsepsddiet.nil_by_mouth_frm,dsepsddiet.nil_by_mouth_to,dsepsddiet.order_type_code,dsepsddiet.order_id,dsepsddiet.prep_instr,dsepsddiet.ADDED_BY_ID,dsepsddiet.dietician_refrl_yn,dsepsddiet.DISCHARGE_FLAG_YN,dsepsddiet.REMARKS,dsepsddiet.texture_of_diet texture_of_diet  FROM ds_epsd_diet_profile_hdr dsepsddiet WHERE (dsepsddiet.operating_facility_id = '"+facility+"') AND (dsepsddiet.encounter_id = '"+encounterId+"') order by profile_sl";
			pstmt = conn.prepareStatement(dietOrderQuery);
			rs = pstmt.executeQuery();
			while(rs != null && rs.next()){
				String diet_category = rs.getString(1);
				String meal_class = rs.getString(2);
				String feed_type = rs.getString(3);
				String diet_type = rs.getString(4);
				String dietary_remarks = rs.getString(5);
				String delivery_code = rs.getString(6);
				String patient_class = rs.getString(7);
				String encounter_id = rs.getString(8);
				String profile_sl = rs.getString(9);
				String period_from = rs.getString(10);
				String newFromDate = null;
				if(period_from != null){
					newFromDate = period_from.substring(0,10);
				}
				String period_to = rs.getString(11);
				String newToDate = null;
				if(period_to != null){
					newToDate = period_to.substring(0,10);
				}else{
					period_to = rs.getString(11);
				}
				String added_date = rs.getString(12);
				String new_added_date = null;
				if(added_date != null){
					new_added_date =  added_date.substring(0, 15);
				}
				String status = "";
				if(rs.getString(13) != null && !rs.getString(13).equals("")){
					status = rs.getString(13);
				}

				String todayAsString = new SimpleDateFormat("dd/MM/yyyy").format(new java.util.Date());
				DateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
				SimpleDateFormat fmt = new SimpleDateFormat("dd/mm/yyyy");
				java.util.Date testFromDate = formatter.parse(newFromDate);
				java.util.Date currentDate = fmt.parse(todayAsString);
				java.util.Date testToDate = null;
				System.out.println("testFromDate"+testFromDate);
				System.out.println("newToDate"+newToDate);
				if(newToDate != null){
					testToDate = formatter.parse(newToDate);
				}
				System.out.println("testToDate"+testToDate);
				System.out.println("currentDate"+currentDate);
				if(testToDate != null && testToDate.before(currentDate)){
					System.out.println("testToDate.before(currentDate)"+testToDate.before(currentDate));
					status = "C";
				}
				else if(testFromDate.after(currentDate)) {
					status = "F";
				}
				else status = "";
				System.out.println("status"+status);
				String order_id = rs.getString(14);
				String nil_by_mouth_frm = rs.getString(15);
				if(nil_by_mouth_frm != null && nil_by_mouth_frm != ""){
					nil_by_mouth_frm = nil_by_mouth_frm.substring(0, 16);
				}else{
					nil_by_mouth_frm = rs.getString(15);
				}
				String nil_by_mouth_to = rs.getString(16);
				if(nil_by_mouth_to != null && nil_by_mouth_to != ""){
					nil_by_mouth_to = nil_by_mouth_to.substring(0, 16);
				}else{
					nil_by_mouth_to = rs.getString(16);
				}
				String order_type_code = rs.getString(17);
				//String order_id1 = rs.getString(18); //Common-ICN-0055
				String prep_instr = rs.getString(19);
				String added_by_id = rs.getString(20);
				String dieticianReferral = rs.getString(21);

				obj.put("diet_category",diet_category);
				obj.put("meal_class",meal_class);
				obj.put("feed_type",feed_type);
				obj.put("diet_type",diet_type);
				obj.put("dietary_remarks",dietary_remarks);
				obj.put("delivery_code",delivery_code);
				obj.put("patient_class",patient_class);
				obj.put("encounter_id",encounter_id);
				obj.put("profile_sl",profile_sl);
				if(newFromDate != null){
					SimpleDateFormat format1 = new SimpleDateFormat("yyyy-mm-dd");
				    SimpleDateFormat format2 = new SimpleDateFormat("dd/mm/yyyy");
				    java.util.Date date1 = format1.parse(newFromDate);
				    obj.put("fromDate",format2.format(date1).toString());
				}
				if(newToDate != null){
					SimpleDateFormat format1 = new SimpleDateFormat("yyyy-mm-dd");
				    SimpleDateFormat format2 = new SimpleDateFormat("dd/mm/yyyy");
				    java.util.Date date2 = format1.parse(newToDate);
				    obj.put("toDate",format2.format(date2).toString());
				}else{
					obj.put("toDate",period_to);
				}
				if(new_added_date != null){
					SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd hh:mm");
				    SimpleDateFormat format2 = new SimpleDateFormat("dd/MM/yyyy hh:mm");
				    java.util.Date date3 = format1.parse(new_added_date);
				    obj.put("addedDate",format2.format(date3).toString());
				}
				if(dieticianReferral==null) dieticianReferral="N";
				obj.put("status",status);
				obj.put("orderId",order_id);
				if(nil_by_mouth_frm != null && nil_by_mouth_frm != ""){
					SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd hh:mm");
				    SimpleDateFormat format2 = new SimpleDateFormat("dd/MM/yyyy hh:mm");
				    java.util.Date date4 = format1.parse(nil_by_mouth_frm);
				    obj.put("NBMFromDate", format2.format(date4).toString());
				}else{
					obj.put("NBMFromDate", nil_by_mouth_frm);
				}
				if(nil_by_mouth_to != null && nil_by_mouth_to != ""){
					SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd hh:mm");
				    SimpleDateFormat format2 = new SimpleDateFormat("dd/MM/yyyy hh:mm");
				    java.util.Date date5 = format1.parse(nil_by_mouth_to);
				    obj.put("NBMToDate", format2.format(date5).toString());
				}else{
					obj.put("NBMToDate", nil_by_mouth_to);
				}
				obj.put("order_type_code", order_type_code);
				obj.put("prep_instr", prep_instr);
				obj.put("added_by_id", added_by_id);
				obj.put("dieticianReferral", dieticianReferral);

				String disCharge_flag = "";
				if(rs.getString(22) != null && rs.getString(22) != ""){
					disCharge_flag = rs.getString(22);

				}
				obj.put("disChargeFlag",disCharge_flag);
				String remarksHdr = "";
				if(rs.getString(23) != null && rs.getString(23) != ""){
					remarksHdr = rs.getString(23);
				}
				obj.put("remarksHdr",remarksHdr);
				
				//CRF-412
				String texture_of_diet=rs.getString("texture_of_diet");
				if(texture_of_diet==null ){
					texture_of_diet="";
				}
				//dietOrderList.add(texture_of_diet);
				//CRF-412
			}
		}catch(Exception ee){
			System.err.println("PlaceBulkDietOrderServlet.java--->"+ee.getMessage());
		}finally
		{
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			if(conn!=null)ConnectionManager.returnConnection(conn,request);
		}
				System.out.println("dietOrderList123------->>>>>"+obj);
		return obj;
	}

	private JSONObject insertSplFoodItems(HttpServletRequest request,HttpServletResponse response, String encounterId,String patientId,String patientClass,String profileSL,String isNewFlag) throws SQLException{

		int flag = 0;
		String jsonData = request.getParameter("jsonData");
		String facilityId = request.getParameter("facilityId");
		String addedId = request.getParameter("addedId");
		String workStNo = request.getParameter("workStNo");
		String isNEW=isNewFlag;

		JSONObject jsonObj = new JSONObject(jsonData);
		//JSONArray nonFreqArr=jsonObj.getJSONArray("items");	//Common-ICN-0044
		JSONArray freqArr=jsonObj.getJSONArray("items");
		Long pi = Long.parseLong(profileSL);
		String disChargeflag = request.getParameter("flag");
//		if(viewCode != null && !(viewCode.equals(""))){
		if ((isNEW != null && isNEW.equalsIgnoreCase("true")) || pi.equals(new Long(0))) {
			pi++;
		}

		session = request.getSession(false);
		String language_id = (String)session.getAttribute("LOCALE");

		System.out.println("encounterId----------->"+encounterId);
		System.out.println("patientClass----------->"+patientClass);
		System.out.println("facility----------->"+facilityId);
		System.out.println("addedById----------->"+addedId);
		System.out.println("workStationNo----------->"+workStNo);
		System.out.println("profile_SL----------->"+profileSL);
		System.out.println("pi----------->"+pi);
		System.out.println("disChargeflag----------->"+disChargeflag);
		Connection conn = ConnectionManager.getConnection(request);
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		Long item_SL = null;
		try{
		String deleteItems = "DELETE FROM DS_EPSD_DIET_PROFILE_SPL WHERE ENCOUNTER_ID ='"+encounterId+"' AND PROFILE_SL='"+pi+"' AND OPERATING_FACILITY_ID='"+facilityId+"'";
		pstmt = conn.prepareStatement(deleteItems);
		int delete = pstmt.executeUpdate();
		if(delete != 0){
			System.out.println("Flag not zero in deleteSplFoodItems");
			conn.commit();
		}else{
			System.out.println("Flag zero in deleteSplFoodItems");
			conn.rollback();
		}
		if(pstmt!=null) pstmt.close();
		}catch(Exception ee){
			ee.printStackTrace();
		}
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
			for(int i =0; i< freqArr.length();i++){
				JSONObject tempObj = freqArr.getJSONObject(i).getJSONObject("item");
				String insSplFItem_query = "insert into DS_EPSD_DIET_PROFILE_SPL (ITEM_TYPE, PATIENT_CLASS, SERVING_TIME, SERVING_FREQ, PERIOD_BET_SERVINGS, ITEM_CODE, ITEM_QTY, ITEM_CHARGE, CHARGE_ITEM, MEAL_PLAN_CREATED_YN, MEAL_PLAN_CREATED_DATE, MEAL_PLAN_REF_DATE, MEAL_PLAN_REF_DAY_NO, FREQ_YN, MEAL_TYPE, ADDED_BY_ID, ADDED_DATE, ADDED_FACILITY_ID, ADDED_AT_WS_NO, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_FACILITY_ID, MODIFIED_AT_WS_NO, OPERATING_FACILITY_ID, ENCOUNTER_ID, PROFILE_SL, ITEM_SL,DISCHARGE_FLAG_YN) values (?, ?, to_date(?,'dd/mm/yyyy'), ?, to_date(?,'dd/MM/yyyy HH:MI'), ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?)";
				pstmt = conn.prepareStatement(insSplFItem_query);
				pstmt.setString(1, tempObj.getString("itemType"));
				pstmt.setString(2, patientClass);
				pstmt.setString(3, com.ehis.util.DateUtils.convertDate(tempObj.getString("from"),"DMY", language_id, "en"));
				pstmt.setString(4, tempObj.getString("frequency"));
				String st = new String(com.ehis.util.DateUtils.convertDate(tempObj.getString("from"),"DMY", language_id, "en")+" "+tempObj.getString("periodBetween"));
				pstmt.setString(5, st);
				pstmt.setString(6, tempObj.getString("itemCode"));
				pstmt.setString(7, tempObj.getString("qty"));
				pstmt.setString(8, null);
				pstmt.setString(9, null);
				pstmt.setString(10, null);
				pstmt.setString(11, null);
				pstmt.setString(12, null);
				pstmt.setString(13, null);
				pstmt.setString(14, tempObj.getString("freqFlag"));
				pstmt.setString(15, tempObj.getString("mealTypeCode"));
				pstmt.setString(16, addedId);
				pstmt.setTimestamp(17, getCurrentTimeStamp());
				pstmt.setString(18, facilityId);
				pstmt.setString(19, workStNo);
				pstmt.setString(20, addedId);
				pstmt.setTimestamp(21, getCurrentTimeStamp());
				pstmt.setString(22, facilityId);
				pstmt.setString(23, workStNo);
				pstmt.setString(24, facilityId);
				pstmt.setString(25, encounterId);
				if(pi == 0){
					pstmt.setLong(26, ++pi);
				}else{
					pstmt.setLong(26, pi);
				}
				if(item_SL != null){
					pstmt.setLong(27, ++item_SL);
				}
				pstmt.setString(28, disChargeflag);
				flag = pstmt.executeUpdate();
				if(pstmt!=null) pstmt.close();
				if(flag != 0){
					System.out.println("Flag not zero in insertSplFoodItems");
					conn.commit();
				}else{
					System.out.println("Flag zero in insertSplFoodItems");
					conn.rollback();
				}
			}


		}catch(Exception ee){
			System.err.println("PlaceBulkDietOrderServlet.java--->"+ee.getMessage());

		}finally{
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			if(conn!=null)ConnectionManager.returnConnection(conn,request);
		}
		return null;
	}

	private JSONObject insertFoodDislikes(HttpServletRequest request,HttpServletResponse response, String encounterId,String patientId,String patientClass,String profileSL) throws SQLException {
		System.out.println("Inside the Food dislikes method--------->>>>>>");
		//int cnt = 0;	//Common-ICN-0044
		int flag;
		String query_all = "DELETE FROM DS_PATIENT_FOOD_DISLIKES WHERE PATIENT_ID = '"+patientId+"'";
		System.out.println("query_all------->>>>>>"+query_all);
		Connection conn = ConnectionManager.getConnection(request);
		PreparedStatement pstmt=null;
		//ResultSet rs=null;	//Common-ICN-0044

		String jsonData = request.getParameter("jsonData");
		String facilityId = request.getParameter("facilityId");
		String addedId = request.getParameter("addedId");
		String workStNo = request.getParameter("workStNo");

		JSONObject jsonObj = new JSONObject(jsonData);
		JSONArray foodDislikeArr=jsonObj.getJSONArray("items");
		JSONObject tempObj =null;
		
		pstmt = conn.prepareStatement(query_all);
		flag = pstmt.executeUpdate();
		if(pstmt!=null) pstmt.close();	//Common-ICN-0044
		if(flag != 0){
			System.out.println("flag1 is not zero in delete DS_PATIENT_FOOD_DISLIKES table");
			conn.commit();
		}else{
			System.out.println("flag1 is zero in delete DS_PATIENT_FOOD_DISLIKES table");
			conn.rollback();
		}
		for(int i = 0; i < foodDislikeArr.length();i++){
			tempObj = foodDislikeArr.getJSONObject(i).getJSONObject("item");
			String fudDisLike_insQuery = "insert into DS_PATIENT_FOOD_DISLIKES (ADDED_BY_ID, ADDED_DATE, ADDED_FACILITY_ID, ADDED_AT_WS_NO, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_FACILITY_ID, MODIFIED_AT_WS_NO, PATIENT_ID, ITEM_CODE) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(fudDisLike_insQuery);
			pstmt.setString(1, addedId);
			pstmt.setTimestamp(2, getCurrentTimeStamp());
			pstmt.setString(3, facilityId);
			pstmt.setString(4, workStNo);
			pstmt.setString(5, addedId);
			pstmt.setTimestamp(6, getCurrentTimeStamp());
			pstmt.setString(7, facilityId);
			pstmt.setString(8, workStNo);
			pstmt.setString(9, patientId);
			pstmt.setString(10, tempObj.getString("itemCode"));
			flag = pstmt.executeUpdate();
			if(flag != 0){
				System.out.println("Flag is not zero in insert");
				conn.commit();
			}else{
				System.out.println("Flag is zero in insert");
				conn.rollback();
			}
				if(pstmt !=null) pstmt.close(); //Common-ICN-0053
			}
			if(pstmt!=null) pstmt.close();
			pstmt.close();
			if(conn!=null)ConnectionManager.returnConnection(conn,request); //Added Against Common-ICN-0031
			return null;
	}

	private void updateOldOrders(HttpServletRequest request, Long profileSL_NEW, String encounterId,String facility,String fromDate) throws SQLException {
		session = request.getSession(false);
		/*String language_id = (String)session.getAttribute("LOCALE");
		String encounterId = request.getParameter("encounterId");
		String facility = request.getParameter("addedFacilityId");
		String fromDate = request.getParameter("fromDate");*/
/*		String toDate =null;
		if(request.getParameter("dateTo") != null && !request.getParameter("dateTo").equals("")){
			toDate = request.getParameter("dateTo");
		}*/

		Connection conn = ConnectionManager.getConnection(request);
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		Boolean isInsertSuccess=false;

		try{
//			String query_str = "SELECT SPL.PROFILE_SL,SPL.ITEM_SL FROM DS_EPSD_DIET_PROFILE_SPL SPL WHERE SPL.OPERATING_FACILITY_ID ='"+facility+"' AND SPL.ENCOUNTER_ID ='"+encounterId+"' and item_type='"+itemCode+"' and profile_sl='"+profileSL+"'";
			String dietOrderQuery = "SELECT profile_sl,TO_CHAR (period_from, 'DD/MM/YYYY'),TO_CHAR (period_to, 'DD/MM/YYYY'),to_char(nil_by_mouth_frm,'DD/MM/YYYY HH24:MI') FROM ds_epsd_diet_profile_hdr WHERE (operating_facility_id = '"+facility+"') AND (encounter_id = '"+encounterId+"') and nvl(status,'ZZ')<>'C' and profile_sl<>"+profileSL_NEW;
			pstmt = conn.prepareStatement(dietOrderQuery);
			rs = pstmt.executeQuery();
			while(rs != null && rs.next()){

				String profileSL = rs.getString(1);
				String period_from = rs.getString(2);
				String orderFromDate = null;
				if(period_from != null){
					orderFromDate = period_from;
				}

				String period_to = rs.getString(3);
				String orderToDate = null;
				if(period_to != null){
					orderToDate = period_to;
				}
				// If period to is null, hardcoding it to the maximum date
				else orderToDate = "31/12/2999";

				String todayAsString = new SimpleDateFormat("dd/MM/yyyy").format(new java.util.Date());
				//DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd"); //Common-ICN-0055
				SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");

				java.util.Date testFromDate = fmt.parse(orderFromDate);
				java.util.Date testToDate=null;

				if(orderToDate != null){testToDate = fmt.parse(orderToDate);}
				java.util.Date newFromDate=fmt.parse(fromDate);

				java.util.Date currentDate = fmt.parse(todayAsString);
				System.out.println("encounterId ---->>>"+encounterId);
				System.out.println("testFromDate ---->>>"+testFromDate);
				System.out.println("testToDate ---->>>"+testToDate);
				System.out.println("newFromDate ---->>>"+newFromDate);
			
				if(newFromDate.after(testFromDate) && (testToDate == null || (testToDate != null && newFromDate.before(testToDate)))) {
					String updateQuery = "UPDATE ds_epsd_diet_profile_hdr set period_to=to_date(?,'DD/MM/YYYY')-1 WHERE (operating_facility_id = '"+facility+"') AND (encounter_id = '"+encounterId+"') and (profile_sl="+profileSL+") ";
					pstmt = conn.prepareStatement(updateQuery);
					pstmt.setString(1,fromDate);
					int row=pstmt.executeUpdate();
					if(pstmt!=null) pstmt.close();
					if (row >0)
					{
						isInsertSuccess = true;
						System.out.println("update to_date for profileSL"+profileSL);
						conn.commit();
					}
					else conn.rollback();
				}
				if(newFromDate.equals(currentDate)) {
					String updateQuery = "UPDATE ds_epsd_diet_profile_hdr set status='C' WHERE (operating_facility_id = '"+facility+"') AND (encounter_id = '"+encounterId+"') and (profile_sl="+profileSL+") and trunc(period_from) < trunc(sysdate) ";
					pstmt = conn.prepareStatement(updateQuery);
					int row=pstmt.executeUpdate();
					if(pstmt!=null) pstmt.close();
					if (row >0)
					{
						isInsertSuccess = true;
						System.out.println("update status for profileSL"+profileSL);
						conn.commit();
					}
					else conn.rollback();
				}
			}
				if(pstmt!=null) pstmt.close();	//Added Against Common-ICN-0031
				if(rs!=null) rs.close();	//Added Against Common-ICN-0031

		}catch(Exception ee){
			ee.printStackTrace();
			System.err.println("PlaceBulkDietOrderServlet.java updateOldOrders --->"+ee.getMessage());
		}finally{
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			if(conn!=null)ConnectionManager.returnConnection(conn,request);
		}
		return;
	}
	
	//412
	private ArrayList<JSONObject> fetchTextureOfDiet(HttpServletRequest request) {
		JSONObject jsonList = new JSONObject();
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
			System.err.println("PlaceBulkDietOrderServlet.java--->"+ee.getMessage());
		}
		finally{
			try{
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null)ConnectionManager.returnConnection(conn,request);
			}catch(Exception e){}
		}
		System.out.println("keyValueList-->"+keyValueList);
		System.out.println("jsonList Line 423:"+jsonList);
		return keyValueList;
	
	}
	//CRF-412
//CRF-428
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
							pstmt.setString(7, facilityId);
							pstmt.setString(8, addedAtWsNo);
							pstmt.setString(9, addedById);
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
				System.err.println("PlaceBulkDietOrderServlet.java--->"+ee.getMessage());
			}
			finally{
				try{
					if(pstmt!=null) pstmt.close();
					if(conn!=null)ConnectionManager.returnConnection(conn,req);
				}catch(Exception e){}
			}
		}
//CRF-428
		//ML-MMOH-CRF-409
		public String getOldIrregularMealCode(HttpServletRequest request,String encounterId,String profileSL,String facilityid){
			Connection conn = ConnectionManager.getConnection(request);
			PreparedStatement pstmt=null;
			ResultSet rs=null;
			String irregular_meal_code="";
			try{
				String encounter_id=encounterId;
				String profile_sl=profileSL;
				facility_id=facilityid;
				
				
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
				irregular_meal_code=irregular_meal_code.substring(0,irregular_meal_code.length()-1);
				
				System.err.println("return irregular_meal_code:"+irregular_meal_code);			
					
				pstmt.close();
				rs.close();	//Added Against Common-ICN-0031
				
			}
			catch(Exception ee){
				ee.printStackTrace();
				System.err.println("PlaceBulkDietOrderServlet.java--->"+ee.getMessage());
			}
			finally{
				try{
					if(pstmt!=null) pstmt.close();
					if(conn!=null)ConnectionManager.returnConnection(conn,request);
				}catch(Exception e){}
			}
			return irregular_meal_code;
			
		}
		//ML-MMOH-CRF-409
		public String getOldDietModifiedStatus(HttpServletRequest request,String encounterId,String profileSL,String facilityid){
			Connection conn = ConnectionManager.getConnection(request);
			PreparedStatement pstmt=null;
			ResultSet rs=null;
			String Diet_Type_Modified="";
			try{
				String encounter_id=encounterId;
				String profile_sl=profileSL;
				 facility_id=facilityid;
				
				
				String Diet_Type_Modified_Query = "SELECT NVL(DIET_TYPE_MODIFIED,'N') DIET_TYPE_MODIFIED FROM DS_EPSD_DIET_PROFILE_HDR WHERE ENCOUNTER_ID=? AND  PROFILE_SL=? AND  OPERATING_FACILITY_ID=? ";
				pstmt = conn.prepareStatement(Diet_Type_Modified_Query);	

				pstmt.setString(1,encounter_id);
				pstmt.setString(2,profile_sl);
				pstmt.setString(3,facility_id);
				
				rs=pstmt.executeQuery();
				
				if(rs.next()){
					Diet_Type_Modified=rs.getString("DIET_TYPE_MODIFIED");
					
				}
					
				pstmt.close();		
				rs.close();	//Added Against Common-ICN-0031
				
			}
			catch(Exception ee){
				ee.printStackTrace();
				System.err.println("PlaceBulkDietOrderServlet.java--->"+ee.getMessage());
			}
			finally{
				try{
					if(pstmt!=null) pstmt.close();
					if(conn!=null)ConnectionManager.returnConnection(conn,request);
				}catch(Exception e){}
			}
			return Diet_Type_Modified;
			
		}
	//CRF-410 Starts
	private JSONObject getNBMProfileOverLap(HttpServletRequest request,HttpServletResponse response) {
			// TODO Auto-generated method stub
			Connection conn = null;
			PreparedStatement psmt=null;
			PreparedStatement psmt_delete_nbm_profile=null;
			ResultSet rs=null;
			
			JSONObject keyValueList = new  JSONObject();
			
			try{
				conn = ConnectionManager.getConnection(request);
				String fromDate=request.getParameter("fromDate");
				String dateTo=request.getParameter("dateTo");
				String addedFacilityId=request.getParameter("addedFacilityId");
				String encounterId=request.getParameter("encounterId");
				
				StringBuffer nbm_profile_overlap_query=new StringBuffer();
								
				nbm_profile_overlap_query.append("    SELECT encounter_id,profile_sl	");
				//nbm_profile_overlap_query.append("	       TO_CHAR (nil_by_mouth_frm, 'dd/mm/yyyy HH24:MI') nil_by_mouth_frm,	");
				//nbm_profile_overlap_query.append("	       TO_CHAR (nil_by_mouth_to, 'dd/mm/yyyy HH24:MI') nil_by_mouth_to	");
				nbm_profile_overlap_query.append("	FROM ds_epsd_nbm_profile	");
				nbm_profile_overlap_query.append("	WHERE 	");
				nbm_profile_overlap_query.append("	encounter_id in("+encounterId+")	");
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
				
				//psmt.setString(++index,encounterId);
				psmt.setString(++index,addedFacilityId);
				psmt.setString(++index,fromDate);
				psmt.setString(++index,dateTo);
				psmt.setString(++index,fromDate);
				psmt.setString(++index,dateTo);
				
				rs=psmt.executeQuery();
				while(rs.next()){
					JSONObject NBMProfileList= new JSONObject();
					NBMProfileList.put("encounter_id", rs.getString("encounter_id"));
					/*NBMProfileList.put("nil_by_mouth_frm", rs.getString("nil_by_mouth_frm"));
					NBMProfileList.put("nil_by_mouth_to", rs.getString("nil_by_mouth_to"));*/
					keyValueList.append("NBMOverLapProfileList",NBMProfileList);
					
					String delete_nbm_profile="delete from ds_epsd_nbm_profile where encounter_id='"+rs.getString("encounter_id")+"' and profile_sl='"+rs.getString("profile_sl")+"' and added_facility_id='"+addedFacilityId+"'";					
					psmt_delete_nbm_profile=conn.prepareStatement(delete_nbm_profile);					
					int delete_nbm=psmt_delete_nbm_profile.executeUpdate();					
					if(delete_nbm>0){
						conn.commit();						
					}else{
						conn.rollback();
					}	
						if(psmt_delete_nbm_profile !=null) psmt_delete_nbm_profile.close(); //Common-ICN-0053
				}
			}catch(Exception e){
				
			}finally{
				try{
					if(psmt!=null) psmt.close();	//Added Against Common-ICN-0031
					if(psmt_delete_nbm_profile!=null) psmt_delete_nbm_profile.close();	//Added Against Common-ICN-0031
					if(rs!=null) rs.close();	//Added Against Common-ICN-0031
					if(conn!=null)ConnectionManager.returnConnection(conn,request);
				}catch(Exception e){
					
				}
			}
			return keyValueList;			
		}
		
	private void deleteOverLapNBMProfile(String encounterId,String addedFacilityId,String fromDate,String toDate,Connection conn){//CRF-410 18th Dec
		PreparedStatement psmt=null;
		try{
			StringBuffer deleteOverLappingNBMOrder=new StringBuffer();
			deleteOverLappingNBMOrder.append("delete from ds_epsd_nbm_profile where encounter_id=? and added_facility_id=? and ");
			deleteOverLappingNBMOrder.append("	(	");
			deleteOverLappingNBMOrder.append("	(	");
			deleteOverLappingNBMOrder.append("	trunc(NIL_BY_MOUTH_FRM) >= trunc(to_date(?,'dd/mm/yyyy HH24:MI'))	");
			deleteOverLappingNBMOrder.append("	AND trunc(NIL_BY_MOUTH_TO) <= trunc(to_date(?,'dd/mm/yyyy HH24:MI'))	");
			deleteOverLappingNBMOrder.append("	)	");
			deleteOverLappingNBMOrder.append("	OR (	");
			deleteOverLappingNBMOrder.append("	trunc(NIL_BY_MOUTH_TO) >= trunc(to_date(?,'dd/mm/yyyy HH24:MI'))	");
			deleteOverLappingNBMOrder.append("	AND trunc(NIL_BY_MOUTH_FRM) <= trunc(to_date(?,'dd/mm/yyyy HH24:MI'))	");
			deleteOverLappingNBMOrder.append("	)	");
			deleteOverLappingNBMOrder.append("	)	");
			
			psmt=conn.prepareStatement(deleteOverLappingNBMOrder.toString());
			psmt.setString(1,encounterId);
			psmt.setString(2,addedFacilityId);
			psmt.setString(3,fromDate);
			psmt.setString(4,toDate);
			psmt.setString(5,fromDate);
			psmt.setString(6,toDate);
			
			int a=psmt.executeUpdate();
			if(a>0){
				conn.commit();
			}
				if(psmt!=null) psmt.close();	//Added Against Common-ICN-0031
		}catch(Exception e){
			e.printStackTrace();
		}		
	}
		//CRF-410 Ends
		//Added against MMS-KH-CRF-0029.1 Starts Here
	public ArrayList<String> drugFood(HttpServletRequest request,HttpServletResponse response)		
	{
		Connection conn = ConnectionManager.getConnection(request);
			//Common-ICN-0044
		//CallableStatement cstmt = null;
		//String food_Value="";		
		PreparedStatement pstmt=null;
		PreparedStatement pstmt1=null;
		ResultSet rs=null;
		ResultSet rs1=null;
		ArrayList<String> drugList = new ArrayList<String>();
		String foodValue[] = null;
		String item[] = null;
		String item_1[] = null;
		String Value="";
		String date1="";
		String ing1="";
		String specialCharacters = "#";
		try{
			//String language_Id =  request.getParameter("locale");	//Common-ICN-0044
			String mealClass	=  request.getParameter("mClass");
			String facility	=  request.getParameter("addedFacilityId");
			String dietTypes	=  request.getParameter("dietType");
			String fromDate	=  request.getParameter("fromDate");
			String dateTo = request.getParameter("dateTo");	
			String encounter	=  request.getParameter("encounterId");	
			String[] encounterID = encounter.split(",");
			for (int k=0; k < encounterID.length; k++)
			{			
				String food = "SELECT ds_drug_interaction_food_items(?, ?, ?, ?, to_date(?,'dd/mm/yyyy'), to_date(?,'dd/mm/yyyy')) drug_in from dual";
				pstmt = conn.prepareStatement(food);
				pstmt.setString(1,facility);
				pstmt.setString(2,encounterID[k]);
				pstmt.setString(3,dietTypes);
				pstmt.setString(4,mealClass);
				pstmt.setString(5,fromDate);				
				pstmt.setString(6,dateTo);
				rs = pstmt.executeQuery();
				if( rs!=null && rs.next())
				{					
					Value=CommonBean.checkForNull(rs.getString("drug_in"));
				}
				if(pstmt!=null) pstmt.close();	//Added Against Common-ICN-0031
					if(rs!=null) rs.close();	//Added Against Common-ICN-0031
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
	
				/* String sql="select distinct f.drug_desc,e.long_desc,d.long_desc,intr_severity_level,intr_signif_level,intr_prob_level,intr_restrt_yn,b.eff_status,a.PATIENT_ID FROM ph_patient_drug_profile a,ph_drug_interaction b,ds_food_item_ingredients c,ds_food_item d,ds_ingredient e,ph_drug f WHERE encounter_id='"+encounterID[k]+"'AND a.drug_code = b.intr_code1 AND b.intr_code2 ='"+ing_co+"' AND b.intr_type2 ='F'  AND c.ingredient_code = b.intr_code2 AND c.food_item_code = d.food_item_code AND d.food_item_code ='"+item_co+"'AND c.ingredient_code = e.ingredient_code AND a.DRUG_CODE = f.DRUG_CODE AND (to_date('"+fromDate+"', 'dd/mm/yyyy') BETWEEN TRUNC(START_DATE) AND TRUNC(END_DATE) OR to_date ('"+fromDate+"', 'dd/mm/yyyy') BETWEEN TRUNC(START_DATE) AND TRUNC(END_DATE)) AND NVL(c.EFF_STATUS,'!') = 'E'";*/
				String sql="select distinct f.drug_desc,e.long_desc,d.long_desc,intr_severity_level,intr_signif_level,intr_prob_level,intr_restrt_yn,b.eff_status FROM ph_patient_drug_profile a,ph_drug_interaction b,ds_food_item_ingredients c,ds_food_item d,ds_ingredient e,ph_drug f WHERE encounter_id='"+encounterID[k]+"'AND a.drug_code = b.intr_code1 AND b.intr_code2 ='"+ing_co+"' AND b.intr_type2 ='F'  AND c.ingredient_code = b.intr_code2 AND c.food_item_code = d.food_item_code AND d.food_item_code ='"+item_co+"'AND c.ingredient_code = e.ingredient_code AND a.DRUG_CODE = f.DRUG_CODE AND (to_date('"+fromDate+"', 'dd/mm/yyyy') BETWEEN TRUNC(START_DATE) AND TRUNC(END_DATE) OR to_date ('"+fromDate+"', 'dd/mm/yyyy') BETWEEN TRUNC(START_DATE) AND TRUNC(END_DATE)) AND NVL(c.EFF_STATUS,'!') = 'E' union select distinct f.drug_desc,e.long_desc,d.long_desc,intr_severity_level,intr_signif_level,intr_prob_level,intr_restrt_yn,b.eff_status FROM ph_patient_drug_profile a,ph_drug_interaction b,ds_food_item_ingredients c,ds_food_item d,ds_ingredient e,ph_drug f WHERE encounter_id='"+encounterID[k]+"'AND a.generic_id = b.intr_code1 AND b.intr_code2 ='"+ing_co+"'  AND b.intr_type1 = 'G' AND b.intr_type2 ='F'  AND c.ingredient_code = b.intr_code2 AND c.food_item_code = d.food_item_code AND d.food_item_code ='"+item_co+"' AND c.ingredient_code = e.ingredient_code AND a.DRUG_CODE = f.DRUG_CODE AND (to_date('"+fromDate+"', 'dd/mm/yyyy') BETWEEN TRUNC(START_DATE) AND TRUNC(END_DATE) OR to_date ('"+fromDate+"', 'dd/mm/yyyy') BETWEEN TRUNC(START_DATE) AND TRUNC(END_DATE)) AND NVL(c.EFF_STATUS,'!') = 'E'"; //Modified Against MMS-KH-SCF-0078
				
				 pstmt1 = conn.prepareStatement(sql);
				 rs1 = pstmt1.executeQuery();

				while(rs1 != null && rs1.next()){
					String one = rs1.getString(1);
					String two = rs1.getString(2);
					String thr = rs1.getString(3);
					String four = rs1.getString(4);
					String five = rs1.getString(5);
					String six = rs1.getString(6);
					String sev = rs1.getString(7);
					String eig = rs1.getString(8);		
					String nine = rs1.getString(9);		
				
					drugList.add(date1);
					drugList.add(one);
					drugList.add(two);
					drugList.add(thr);
					drugList.add(four);
					drugList.add(five);
					drugList.add(six);
					drugList.add(sev);
					drugList.add(eig);	
					drugList.add(nine);	
				}
				if(pstmt1!=null) pstmt1.close();	//Added Against Common-ICN-0031
					if(rs1!=null) rs1.close();	//Added Against Common-ICN-0031
				}}
				}}
				
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
}
