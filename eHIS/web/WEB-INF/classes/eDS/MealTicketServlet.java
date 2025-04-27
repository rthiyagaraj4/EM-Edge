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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import eCommon.XSSRequestWrapper;
import webbeans.eCommon.ConnectionManager;
import eCommon.Common.CommonBean;
import eDS.Common.JSONObject;

/**
 * Servlet implementation class MealTicketServlet
 */
public class MealTicketServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	java.util.Properties prop;
	HttpSession session;
	String facility_id,str_client_ip_address,login_user,language_id;
	String kitchen_code="";
	private final static Logger log = Logger.getLogger("eDS");
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MealTicketServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
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

		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		String operation = request.getParameter("mode");
				
		session = request.getSession(false);
		this.prop = (java.util.Properties) session.getValue("jdbc");
		str_client_ip_address = prop.getProperty("client_ip_address");
		login_user = prop.getProperty( "login_user" ) ;
		if(str_client_ip_address == null) str_client_ip_address="";
		if(login_user == null) login_user="";
		this.facility_id = (String) session.getAttribute("facility_id");
		this.language_id = (String) session.getAttribute("LOCALE");
		
		if(operation.equals("loadKitchen_MealTicket")){
			System.out.println("loadKitchen_MealTicket");
			JSONObject objKitchenList = loadKitchen_MealTicket(request,response);
			log.debug("objKitchenListJSONList_Order---->>>"+objKitchenList+"<<<<<<<");
			response.setContentType("application/json");
			response.setContentType("text/html;charset=UTF-8");
			out.print(objKitchenList);
			out.flush();
		
	}else if(operation.equals("loadSpecialty")){
		System.out.println("loadSpecialty line 82");
		JSONObject objSpecialtyList = loadSpecilatity(request,response);
		log.debug("objSpecialtyListJSONList_Order---->>>"+objSpecialtyList+"<<<<<<<");
		response.setContentType("application/json");
		response.setContentType("text/html;charset=UTF-8");
		out.print(objSpecialtyList);
		out.flush();
		
	}else if(operation.equals("loadLocation")){
		System.out.println("loadLocation line 91");
		JSONObject objLocationList = loadLocation(request,response);
		log.debug("objSpecialtyListJSONList_Order---->>>"+objLocationList+"<<<<<<<");
		response.setContentType("application/json");
		response.setContentType("text/html;charset=UTF-8");
		out.print(objLocationList);
		out.flush();
		
	}else if(operation.equals("loadMealType")){
		System.out.println("loadMealType line 91");
		JSONObject objMealTypeList = loadMealType(request,response);
		log.debug("objMealTypeListJSONList_Order---->>>"+objMealTypeList+"<<<<<<<");
		response.setContentType("application/json");
		response.setContentType("text/html;charset=UTF-8");
		out.print(objMealTypeList);
		out.flush();
		
	}else if(operation.equals("loadDietType")){
		System.out.println("loadMealType line 91");
		JSONObject objDietTypeList = loadDietType(request,response);
		log.debug("objMealTypeListJSONList_Order---->>>"+objDietTypeList+"<<<<<<<");
		response.setContentType("application/json");
		response.setContentType("text/html;charset=UTF-8");
		out.print(objDietTypeList);
		out.flush();
		
	}else if(operation.equals("loadPriorityZone")){
		System.out.println("loadPriorityZone line 91");
		JSONObject objPriorityZone = loadPriorityZone(request,response);
		log.debug("objPriorityZone JSONList_Order---->>>"+objPriorityZone+"<<<<<<<");
		response.setContentType("application/json");
		response.setContentType("text/html;charset=UTF-8");
		out.print(objPriorityZone);
		out.flush();
		
	}else if(operation.equals("loadTreatmentArea")){
		System.out.println("loadTreatmentArea line 91");
		JSONObject objTreatmentAreaZone = loadTreatmentArea(request,response);
		log.debug("objPriorityZone JSONList_Order---->>>"+objTreatmentAreaZone+"<<<<<<<");
		response.setContentType("application/json");
		response.setContentType("text/html;charset=UTF-8");
		out.print(objTreatmentAreaZone);
		out.flush();
		
	}else if(operation.equals("getCurrentServerDate")){
		System.out.println("getCurrentServerDate line 91");
		JSONObject objServerDate = getCurrentServerDate(request,response);
		log.debug("getCurrentServerDate JSONList_Order---->>>"+objServerDate+"<<<<<<<");
		response.setContentType("application/json");
		response.setContentType("text/html;charset=UTF-8");
		out.print(objServerDate);
		out.flush();
		
	}
	//ML-MMOH-CRF-0413 starts
	else if(operation.equals("loadWards")){
		System.out.println("loadWards line 91");
		JSONObject objloadWards = loadWards(request,response);
		log.debug("loadWards JSONList_Order---->>>"+objloadWards+"<<<<<<<");
		response.setContentType("application/json");
		response.setContentType("text/html;charset=UTF-8");
		out.print(objloadWards);
		out.flush();
		
	}else if(operation.equals("loadMealClass")){
		System.out.println("loadMealClass line 91");
		JSONObject objloadMealClass = loadMealClass(request,response);
		log.debug("loadMealClass JSONList_Order---->>>"+objloadMealClass+"<<<<<<<");
		response.setContentType("application/json");
		response.setContentType("text/html;charset=UTF-8");
		out.print(objloadMealClass);
		out.flush();
		
	}
	//ML-MMOH-CRF-0413 ends
	//MMS-QH-CRF-0079 Starts	
	else if(operation.equals("loadIPNursingUnit")){		
		JSONObject objloadIPNursingUnit = loadIPNursingUnit(request,response);		
		response.setContentType("application/json");
		response.setContentType("text/html;charset=UTF-8");
		out.print(objloadIPNursingUnit);
		out.flush();		
	}
	
	else if(operation.equals("getPatientIdLength")){		
		JSONObject objPatientIdLength = getPatientIdLength(request,response);
		response.setContentType("application/json");
		response.setContentType("text/html;charset=UTF-8");
		out.print(objPatientIdLength);
		out.flush();		
	}
	//MMS-QH-CRF-0079 Ends
}
	
	
	private JSONObject loadKitchen_MealTicket(HttpServletRequest request,HttpServletResponse response){
				
		Connection conn = ConnectionManager.getConnection(request);
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		JSONObject jsonList = new JSONObject(); 
		try{
				
			String SQL_kitchen= "select  KITCHEN_CODE,SHORT_DESC  from DS_KITCHENS_LANG_VW  where language_id=? and operating_facility_id =?  order by KITCHEN_CODE";//ML-MMOH-CRF-0413			
			String facilityid = request.getParameter("facilityid");			
						
			pstmt = conn.prepareStatement(SQL_kitchen);
			pstmt.setString(1, language_id);
			pstmt.setString(2, facilityid);
			
			rs = pstmt.executeQuery();

			log.debug("initialLoad method::");
			while(rs != null && rs.next())
			{
				JSONObject jsonKitchenList= new JSONObject();
				jsonKitchenList.put("KitchenCode",rs.getString("kitchen_code"));
				jsonKitchenList.put("KitchenDesc",rs.getString("SHORT_DESC"));
				jsonList.append("jsonKitchenList", jsonKitchenList);				
			}			
		}
		catch(Exception ee){
			System.err.println("PlaceMealOrderOPServlet.java--->"+ee.getMessage());
		}
		finally{
			try{
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null)ConnectionManager.returnConnection(conn,request);
			}catch(Exception e)
			{
				System.err.println("PlaceMealOrderOPServlet.java--->"+e.getMessage());
			}
		}
		return jsonList;
	}

	private JSONObject loadSpecilatity(HttpServletRequest request,HttpServletResponse response){
		
		Connection conn = ConnectionManager.getConnection(request);
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String kitchenCode = "",mealOrderFor="",kitchenCodeTo="";
		int Count = 0;
		JSONObject jsonList = new JSONObject(); 
		
		try{
			kitchenCode=CommonBean.checkForNull(request.getParameter("kitchenCode"));
			kitchenCodeTo=CommonBean.checkForNull(request.getParameter("kitchenCodeTo"));
			mealOrderFor=CommonBean.checkForNull(request.getParameter("mealOrderFor"));
			
			StringBuffer Speciality_sql=new StringBuffer();
			
			Speciality_sql.append("	SELECT distinct  a.speciality_code, a.speciality_desc	");
			Speciality_sql.append("	FROM ds_speciality_kitchen_vw a		");			
			Speciality_sql.append("	,op_clinic b	");//Added for Specaility issue on meal order click			
			Speciality_sql.append("	WHERE a.operating_facility_id = ?	");
			
			if(kitchenCode!=null && !kitchenCode.equals("") && kitchenCodeTo!=null && !kitchenCodeTo.equals("")){
				Speciality_sql.append("	AND a.kitchen_code between ? and ?	");
			}			
			Speciality_sql.append("	AND a.linked_yn = 'Y'	");
			
			//Added for Specaility issue on meal order click starts			
			Speciality_sql.append("	and a.SPECIALITY_CODE=b.SPECIALITY_CODE	");
			Speciality_sql.append("	and   a.operating_Facility_Id =b.FACILITY_ID	");
			Speciality_sql.append("	and b.FACILITY_ID=?		");//ML-MMOH-CRF-0413
			
			if(mealOrderFor.equals("ALL"))
			{
				Speciality_sql.append(" and b.clinic_type IN ('C','E') and b.LEVEL_OF_CARE_IND in('A','E') ");
			}
			if(mealOrderFor.equals("OP"))
			{
			Speciality_sql.append(" and b.clinic_type IN ('C','E') and b.LEVEL_OF_CARE_IND = 'A' ");
			}
			if(mealOrderFor.equals("EM"))
			{
			Speciality_sql.append(" and b.clinic_type IN ('C') and b.LEVEL_OF_CARE_IND = 'E' ");
			}
			//Added for Specaility issue on meal order click ends
			
			Speciality_sql.append("	ORDER BY speciality_code	");			
						
			//String speciality = request.getParameter("speciality");	//Common-ICN-0044
			String facilityid = request.getParameter("facilityid");			
			
			pstmt = conn.prepareStatement(Speciality_sql.toString());	
			
			pstmt.setString(++Count, facilityid);
			if(kitchenCode!=null && !kitchenCode.equals("") && kitchenCodeTo!=null && !kitchenCodeTo.equals("")){
				pstmt.setString(++Count, kitchenCode);	
				pstmt.setString(++Count, kitchenCodeTo);
				
			}
			pstmt.setString(++Count, facilityid);			
			rs = pstmt.executeQuery();

			log.debug("initialLoad method::");
			while(rs != null && rs.next())
			{
				JSONObject jsonSpecialityList= new JSONObject();
				jsonSpecialityList.put("SpecialityCode",rs.getString("speciality_code"));
				jsonSpecialityList.put("SpecialityDesc",rs.getString("speciality_desc"));
				jsonList.append("jsonSpecialityList", jsonSpecialityList);				
			}			
		}
		catch(Exception ee){
			System.err.println("PlaceMealOrderOPServlet.java--->"+ee.getMessage());
		}
		finally{
			try{
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null)ConnectionManager.returnConnection(conn,request);
			}catch(Exception e)
			{
				System.err.println("PlaceMealOrderOPServlet.java--->"+e.getMessage());
			}
		}
		return jsonList;
	}
	
private JSONObject loadLocation(HttpServletRequest request,HttpServletResponse response){
		
		Connection conn = ConnectionManager.getConnection(request);
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		/* String kitchenCode = "",mealOrderFor="";
		StringBuffer locCodeStr = new StringBuffer();
		String locations = "";
		int Count = 0; */	//Common-ICN-0044
		JSONObject jsonList = new JSONObject(); 
				
		try{
			
			String facilityId = CommonBean.checkForNull(request.getParameter("facilityid"));
			String mealOrderFor= request.getParameter("mealOrderFor");
			String specialityCodes=request.getParameter("specialityCodes");
			String specialityCodesTo=request.getParameter("specialityCodesTo");
			String kithcenCodeFrom=request.getParameter("kithcenCodeFrom");
			String kithcenCodeTo=request.getParameter("kithcenCodeTo");
			String levelOfCareWhereClause="";
			String clinicTypeWhereClause="";
			String specialityCodesWhereClause="";
						
			if(mealOrderFor.equalsIgnoreCase("OP")) {levelOfCareWhereClause=" AND a.level_of_care_ind = 'A' ";}
			
			else if(mealOrderFor.equalsIgnoreCase("EM")) {levelOfCareWhereClause=" AND a.level_of_care_ind = 'E' ";}
			
			
			if(mealOrderFor.equalsIgnoreCase("OP")) {clinicTypeWhereClause=" AND a.clinic_type in ('C','E','Y') ";}
			
			else if(mealOrderFor.equalsIgnoreCase("EM")) {clinicTypeWhereClause=" AND a.clinic_type='C' ";}
			
			if(!specialityCodes.equals("") && !specialityCodesTo.equals("")) {
				specialityCodesWhereClause=" AND a.speciality_code IN (select distinct speciality_code from ds_speciality_kitchen_vw where speciality_code between '"+specialityCodes+"' and '"+specialityCodesTo+"' and operating_facility_id = '"+facilityId+"' AND linked_yn = 'Y' )";
				}else{
				specialityCodesWhereClause="	AND a.speciality_code IN(select distinct speciality_code from ds_speciality_kitchen_vw where KITCHEN_CODE between '"+kithcenCodeFrom+"' and '"+kithcenCodeTo+"' and operating_facility_id = '"+facilityId+"' AND linked_yn = 'Y' )";
				}
			
			String location_sql = "SELECT a.clinic_code code, a.long_desc description FROM op_clinic_lang_vw a, am_os_user_locn_access_vw b WHERE a.facility_id = '"+facilityId+"' AND a.language_id='"+language_id+"'"+levelOfCareWhereClause+"AND a.eff_status='E'"+clinicTypeWhereClause+" and a.facility_id = b.facility_id  AND a.clinic_code = b.locn_code and b.appl_user_id = '"+login_user+"' and  b.oper_stn_id = (SELECT OPER_STN_ID  FROM AM_USER_FOR_OPER_STN A  WHERE FACILITY_ID = b.facility_id AND APPL_USER_ID = b.appl_user_id AND TRUNC (SYSDATE) BETWEEN EFF_DATE_FROM AND NVL (EFF_DATE_TO, TRUNC (SYSDATE))) and b.manage_queue_yn = 'Y' and a.CLINIC_TYPE=b.LOCN_TYPE and a.rd_appl_yn = 'N'"+specialityCodesWhereClause+"AND a.eff_status='E' ";//ML-MMOH-CRF-0413 , EFF_STATUS added against INC:37526
			//String location_sql = "SELECT a.clinic_code code, a.long_desc description FROM op_clinic_lang_vw a, am_os_user_locn_access_vw b WHERE a.facility_id = '"+facilityId+"' AND a.language_id='"+language_id+"'"+levelOfCareWhereClause+" "+clinicTypeWhereClause+" and a.facility_id = b.facility_id  AND a.clinic_code = b.locn_code  and  b.oper_stn_id = (SELECT OPER_STN_ID  FROM AM_USER_FOR_OPER_STN A  WHERE FACILITY_ID = b.facility_id AND APPL_USER_ID = b.appl_user_id AND TRUNC (SYSDATE) BETWEEN EFF_DATE_FROM AND NVL (EFF_DATE_TO, TRUNC (SYSDATE))) and b.manage_queue_yn = 'Y' and a.CLINIC_TYPE=b.LOCN_TYPE and a.rd_appl_yn = 'N'"+specialityCodesWhereClause+"  ";//ML-MMOH-CRF-0413

			pstmt = conn.prepareStatement(location_sql);			
			rs = pstmt.executeQuery();
			
			while(rs != null && rs.next())
			{
				JSONObject jsonLocationList= new JSONObject();
				jsonLocationList.put("LocationCode",rs.getString("code"));
				jsonLocationList.put("LocationDesc",rs.getString("description"));
				jsonList.append("jsonLocationList", jsonLocationList);				
			}			
		}
		catch(Exception ee){
			System.err.println("PlaceMealOrderOPServlet.java--->"+ee.getMessage());
		}
		finally{
			try{
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null)ConnectionManager.returnConnection(conn,request);
			}catch(Exception e)
			{
				System.err.println("PlaceMealOrderOPServlet.java--->"+e.getMessage());
			}
		}
		return jsonList;
	}
	
private JSONObject loadPriorityZone(HttpServletRequest request,HttpServletResponse response){
	
	Connection conn = ConnectionManager.getConnection(request);
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	/* String kitchenCode = "",mealOrderFor="";
	int Count = 0; */	//Common-ICN-0044
	JSONObject jsonList = new JSONObject(); 	
	
	try{
		/* StringBuffer locCodeStr = new StringBuffer();
		String locations = "";
		String specialityCodes=request.getParameter("specialityCodes");
		String facilityId = CommonBean.checkForNull(request.getParameter("facilityid")); 
		mealOrderFor= request.getParameter("mealOrderFor");*/	//Common-ICN-0044
		
		String LocationList=request.getParameter("locationList");		
		
		StringBuffer priorityZone=new StringBuffer();
		
		priorityZone.append("	select distinct a.priority_zone code,b.priority_zone_desc description from ae_tmt_area_for_clinic a,ae_priority_zone b where a.priority_zone=b.priority_zone 	");

		if(!LocationList.equals("")){		
			priorityZone.append("	and a.clinic_code in ('"+LocationList+"') 		");			
		}
		priorityZone.append("	order by a.priority_zone	");	//ML-MMOH-CRF-0413
		
		//String location_sql = "";			//Common-ICN-0044
		
		pstmt = conn.prepareStatement(priorityZone.toString());		
		rs = pstmt.executeQuery();

		while(rs != null && rs.next())
		{
			JSONObject jsonPriorityZone= new JSONObject();
			jsonPriorityZone.put("PriorityZoneCode",rs.getString("code"));
			jsonPriorityZone.put("PriorityZoneDesc",rs.getString("description"));
			jsonList.append("jsonPriorityZone", jsonPriorityZone);			
		}		
	}
	catch(Exception ee){
		System.err.println("PlaceMealOrderOPServlet.java--->"+ee.getMessage());
	}
	finally{
		try{
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			if(conn!=null)ConnectionManager.returnConnection(conn,request);
		}catch(Exception e)
		{
			System.err.println("PlaceMealOrderOPServlet.java--->"+e.getMessage());
		}
	}
	return jsonList;
}

private JSONObject loadMealType(HttpServletRequest request,HttpServletResponse response){
	
	Connection conn = ConnectionManager.getConnection(request);
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	/* String kitchenCode = "",mealOrderFor="";
	int Count = 0; */	//Common-ICN-0044
	JSONObject jsonList = new JSONObject();	
	
	try{
		/* StringBuffer locCodeStr = new StringBuffer();
		String locations = "";		
		String facilityId = CommonBean.checkForNull(request.getParameter("facilityid"));
		String specialityCodes=request.getParameter("specialityCodes");		
		String levelOfCareWhereClause="";
		String clinicTypeWhereClause="";
		String specialityCodesWhereClause=""; */		//Common-ICN-0044
		String mealOrderFor= request.getParameter("mealOrderFor");
		StringBuffer MealTypeQuery=new StringBuffer();

		MealTypeQuery.append("	select meal_order,meal_type,short_Desc from ds_meal_type where ");//ML-MMOH-CRF-0413
		
		if(mealOrderFor.equalsIgnoreCase("OP")) {
			MealTypeQuery.append(" opmealorder_yn='Y' ");			
		}
		
		else if(mealOrderFor.equalsIgnoreCase("EM")) {
			MealTypeQuery.append("	em_meal_order_yn='Y' ");
			}
			
		//Added Below condtition Against KDAH-CRF-0505
		else if(mealOrderFor.equalsIgnoreCase("IP")){
			MealTypeQuery.append("	IP_MEAL_ORDER_YN='Y' ");			
		}
					
		else if(mealOrderFor.equalsIgnoreCase("All")){
			MealTypeQuery.append(" (opmealorder_yn='Y' or em_meal_order_yn='Y')	");			
		}
		
		MealTypeQuery.append("	order by meal_order	");
				
		pstmt = conn.prepareStatement(MealTypeQuery.toString());		
		rs = pstmt.executeQuery();

		while(rs != null && rs.next())
		{
			JSONObject jsonMealTypeList= new JSONObject();
			jsonMealTypeList.put("MealCode",rs.getString("meal_order"));
			jsonMealTypeList.put("MealDesc",rs.getString("short_Desc"));
			jsonList.append("jsonMealTypeList", jsonMealTypeList);			
		}		
	}
	catch(Exception ee){
		System.err.println("PlaceMealOrderOPServlet.java--->"+ee.getMessage());
	}
	finally{
		try{
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			if(conn!=null)ConnectionManager.returnConnection(conn,request);
		}catch(Exception e)
		{
			System.err.println("PlaceMealOrderOPServlet.java--->"+e.getMessage());
		}
	}
	return jsonList;
}

private JSONObject loadDietType(HttpServletRequest request,HttpServletResponse response){
	
	Connection conn = ConnectionManager.getConnection(request);
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	JSONObject jsonList = new JSONObject(); 
	
	try{		
		StringBuffer DietTypeQuery=new StringBuffer();

		DietTypeQuery.append("	select diet_type,short_Desc from ds_diet_type_lang_vw where language_Id='"+language_id+"'  order by diet_type ASC		");//ML-MMOH-CRF-0413 
	
		pstmt = conn.prepareStatement(DietTypeQuery.toString());		
		rs = pstmt.executeQuery();

		while(rs != null && rs.next())
		{
			JSONObject jsonDietTypeList= new JSONObject();
			jsonDietTypeList.put("DietCode",rs.getString("diet_type"));
			jsonDietTypeList.put("DietDesc",rs.getString("short_Desc"));
			jsonList.append("jsonDietTypeList", jsonDietTypeList);
		}		
	}
	catch(Exception ee){
		System.err.println("PlaceMealOrderOPServlet.java--->"+ee.getMessage());
	}
	finally{
		try{
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			if(conn!=null)ConnectionManager.returnConnection(conn,request);
		}catch(Exception e)
		{
			System.err.println("PlaceMealOrderOPServlet.java--->"+e.getMessage());
		}
	}
	return jsonList;
}

private JSONObject loadTreatmentArea(HttpServletRequest request,HttpServletResponse response){
	
	Connection conn = ConnectionManager.getConnection(request);
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	JSONObject jsonList = new JSONObject(); 
		
	try{
		
		String facility = CommonBean.checkForNull(request.getParameter("facility"));
		String locationList = CommonBean.checkForNull(request.getParameter("locationList"));
		String priorityZone = CommonBean.checkForNull(request.getParameter("priorityZone"));
		String priorityZoneTo = CommonBean.checkForNull(request.getParameter("priorityZoneTo"));
		String priorityZoneWhereClause="";
		
		if(!priorityZone.equals("") && !priorityZoneTo.equals("")) {
			//priorityZoneWhereClause=" and priority_zone='"+priorityZone+"' ";
			priorityZoneWhereClause=" and priority_zone between '"+priorityZone+"' AND '"+priorityZoneTo+"'";	
		}
		StringBuffer treatmentArea=new StringBuffer();
		treatmentArea.append("	select treatment_area_code,short_desc from ae_tmt_area_for_clinic	");
		treatmentArea.append("	where	");
		if(!locationList.equals("")){
			
			treatmentArea.append("	clinic_code in ('"+locationList+"') and	");
		}
		//treatmentArea.append("	facility_id = '"+facility+"'"+priorityZoneWhereClause+" and eff_status='E' order by treatment_area_code	");
		treatmentArea.append("	facility_id = '"+facility+"'"+priorityZoneWhereClause+"  order by treatment_area_code	");		
		
		//String treatmentArea_sql = "select treatment_area_code,short_desc from ae_tmt_area_for_clinic where clinic_code in ("+locationList+") and facility_id = '"+facility+"'"+priorityZoneWhereClause+"  order by short_desc"; //Common-ICN-0055
		
		pstmt = conn.prepareStatement(treatmentArea.toString());	
		rs = pstmt.executeQuery();

		while(rs != null && rs.next())
		{
			JSONObject jsonTreatmentAreaList= new JSONObject();
			jsonTreatmentAreaList.put("treatment_area_code",rs.getString("treatment_area_code"));
			jsonTreatmentAreaList.put("short_desc",rs.getString("short_desc"));
			jsonList.append("jsonTreatmentAreaList", jsonTreatmentAreaList);
		}		
	}
	catch(Exception ee){
		System.err.println("PlaceMealOrderOPServlet.java--->"+ee.getMessage());
	}
	finally{
		try{
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			if(conn!=null)ConnectionManager.returnConnection(conn,request);
		}catch(Exception e)
		{
			System.err.println("PlaceMealOrderOPServlet.java--->"+e.getMessage());
		}
	}
	return jsonList;
}

private JSONObject getCurrentServerDate(HttpServletRequest request,HttpServletResponse response){
	
	Connection conn = ConnectionManager.getConnection(request);
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	JSONObject jsonList = new JSONObject(); 
	String servingDate="";
	
	try{		
		pstmt = conn.prepareStatement("SELECT to_char(SYSDATE,'dd/mm/yyyy') CURRENT_DATE FROM DUAL");
		rs = pstmt.executeQuery();
		while(rs.next()){
			servingDate = com.ehis.util.DateUtils.convertDate(rs.getString("CURRENT_DATE"),"DMY","en",language_id);
			JSONObject jsonCurrentDate= new JSONObject();
			jsonCurrentDate.put("Server_Date",rs.getString("CURRENT_DATE"));			
			jsonList.append("CurrentDate", jsonCurrentDate);
		}
	}
	catch(Exception ee){
		System.err.println("PlaceMealOrderOPServlet.java--->"+ee.getMessage());
	}
	finally{
		try{
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			if(conn!=null)ConnectionManager.returnConnection(conn,request);
		}catch(Exception e)
		{
			System.err.println("PlaceMealOrderOPServlet.java--->"+e.getMessage());
		}
	}
	return jsonList;
}

//ML-MMOH-CRF-0413 starts
private JSONObject loadWards(HttpServletRequest request,HttpServletResponse response){

	Connection conn = ConnectionManager.getConnection(request);
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	JSONObject jsonList = new JSONObject(); 
	//String servingDate="";	//Common-ICN-0044
	
	try{
		String facility = CommonBean.checkForNull(request.getParameter("facility"));
		String kitchenCode = CommonBean.checkForNull(request.getParameter("kitchenCode"));
		//String ward_sql = "select nursing_Unit_Code,short_Desc from Ds_Wards_Kitchen_Vw where operating_Facility_Id = ? and  nvl(kitchen_Code,'!!') in(?,'!!') and linked_Yn = 'Y' order by short_Desc ASC";
		StringBuffer ward_sql=new StringBuffer();
		ward_sql.append("	select nursing_Unit_Code,short_Desc from Ds_Wards_Kitchen_Vw where operating_Facility_Id = ?	");
		if(!kitchenCode.equals("All")){
			ward_sql.append("	and  nvl(kitchen_Code,'!!') in(?,'!!') and linked_Yn = 'Y' order by short_Desc ASC	");
		}
		pstmt = conn.prepareStatement(ward_sql.toString());
		pstmt.setString(1,facility);
		if(!kitchenCode.equals("All")){
		pstmt.setString(2,kitchenCode);
		}

		rs = pstmt.executeQuery();
		while(rs.next()){			
			JSONObject jsonWard= new JSONObject();
			jsonWard.put("Ward_Code",rs.getString("nursing_Unit_Code"));
			jsonWard.put("Ward_Desc",rs.getString("short_Desc"));			
			jsonList.append("Ward", jsonWard);
		}
	}
	catch(Exception ee){
		System.err.println("PlaceMealOrderOPServlet.java--->"+ee.getMessage());
	}
	finally{
		try{
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			if(conn!=null)ConnectionManager.returnConnection(conn,request);
		}catch(Exception e)
		{
			System.err.println("PlaceMealOrderOPServlet.java--->"+e.getMessage());
		}
	}
	return jsonList;
}

private JSONObject loadMealClass(HttpServletRequest request,HttpServletResponse response){
	
	Connection conn = ConnectionManager.getConnection(request);
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	JSONObject jsonList = new JSONObject(); 
	//String servingDate="";	//Common-ICN-0044
	
	try{
		
		String meal_class_sql = "select meal_Class,short_Desc from Ds_Meal_Class_Lang_Vw where language_Id = ? order by short_Desc ASC";
			
		pstmt = conn.prepareStatement(meal_class_sql);
		pstmt.setString(1,language_id);
				
		rs = pstmt.executeQuery();
		while(rs.next()){		
			JSONObject jsonMealClass= new JSONObject();
			jsonMealClass.put("Meal_Code",rs.getString("meal_Class"));
			jsonMealClass.put("Meal_Desc",rs.getString("short_Desc"));			
			jsonList.append("MealClass", jsonMealClass);
		}
	}
	catch(Exception ee){
		System.err.println("PlaceMealOrderOPServlet.java--->"+ee.getMessage());
	}
	finally{
		try{
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			if(conn!=null)ConnectionManager.returnConnection(conn,request);
		}catch(Exception e)
		{
			System.err.println("PlaceMealOrderOPServlet.java--->"+e.getMessage());
		}
	}
	return jsonList;
}
//ML-MMOH-CRF-0413 ends
//MMS-QH-CRF-0079 Starts
private JSONObject loadIPNursingUnit(HttpServletRequest request,HttpServletResponse response){	
	Connection conn = ConnectionManager.getConnection(request);
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	JSONObject jsonList = new JSONObject();	
	
	try{
		
		String Load_IP_Nursing_Unit = "select nursing_Unit_Code, short_Desc from Ip_Nursing_Unit_Lang_Vw where language_Id =? and eff_Status ='E'and facility_Id=? order by 2";
			
		pstmt = conn.prepareStatement(Load_IP_Nursing_Unit);
		pstmt.setString(1,language_id);
		pstmt.setString(2,facility_id);	
				
		rs = pstmt.executeQuery();
		while(rs.next()){		
			JSONObject jsonIPNursingUnit= new JSONObject();
			jsonIPNursingUnit.put("Nursing_Code",rs.getString("nursing_Unit_Code"));
			jsonIPNursingUnit.put("Nursing_Desc",rs.getString("short_Desc"));			
			jsonList.append("IPNursingUnit", jsonIPNursingUnit);
		}
	}
	catch(Exception ee){
		System.err.println("PlaceMealOrderOPServlet.java--->"+ee.getMessage());
	}
	finally{
		try{
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			if(conn!=null)ConnectionManager.returnConnection(conn,request);
		}catch(Exception e)
		{
			System.err.println("PlaceMealOrderOPServlet.java--->"+e.getMessage());
		}
	}
	return jsonList;
}
private JSONObject getPatientIdLength(HttpServletRequest request,HttpServletResponse response){	
	Connection conn = ConnectionManager.getConnection(request);
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	JSONObject jsonList = new JSONObject(); 	
	
	try{
		
		String patient_id_length = "select patient_id_length from mp_param where MODULE_ID='MP'";
			
		pstmt = conn.prepareStatement(patient_id_length);		
				
		rs = pstmt.executeQuery();
		while(rs.next()){		
			JSONObject jsonPatientIdLength= new JSONObject();
			jsonPatientIdLength.put("Patient_Id_Length",rs.getString("patient_id_length"));						
			jsonList.append("PatientIdLength", jsonPatientIdLength);
		}
	}
	catch(Exception ee){
		System.err.println("PlaceMealOrderOPServlet.java--->"+ee.getMessage());
	}
	finally{
		try{
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			if(conn!=null)ConnectionManager.returnConnection(conn,request);
		}catch(Exception e)
		{
			System.err.println("PlaceMealOrderOPServlet.java--->"+e.getMessage());
		}
	}
	return jsonList;
}
}
//MMS-QH-CRF-0079 Ends