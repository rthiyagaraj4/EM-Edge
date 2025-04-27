/* This file created against MMS-QH-CRF-0079 [IN:038156] for September 2016 Release */
package eDS;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import webbeans.eCommon.ConnectionManager;
import eCommon.XSSRequestWrapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import eDS.SupplementaryOrder.bc.SupplementaryPlaceOrderBC;
import eDS.SupplementaryOrder.model.PlaceSupplementaryMealOrderRequest;
import eDS.SupplementaryOrder.model.PlaceSupplementaryMealOrderResponse;
import eDS.SupplementaryOrder.model.SupplementaryPlaceOrderRequest;
import eDS.SupplementaryOrder.model.SupplementaryPlaceOrderResponse;
import eDS.SupplementaryOrder.model.SupplementaryProcessRequest;
/**
 * Servlet implementation class SupplementaryOrderServlet
 */
public class SupplementaryOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	java.util.Properties prop;
	HttpSession session;
	private final static Logger log = Logger.getLogger("eDS");
	String facility_id,str_client_ip_address,login_user,language_id;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SupplementaryOrderServlet() {
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
		System.out.println("operation--->"+operation);
		if(operation.equals("Place_Supplementary_Result_New4")){
			String result=getSupplementaryPlaceSearch(request,response);
			response.setContentType("text/html;charset=UTF-8");
			response.setContentType("text/html;charset=UTF-8");
			System.err.println("return --->result--->"+result);
			System.err.println("before return");
			out.print(result);
			out.flush();
		}else if(operation.equals("INSERT_SUPPLEMENTARY_MEAL_ORDER")){
			String result=insertSupplementaryMealOrder(request,response);
			response.setContentType("text/html;charset=UTF-8");
			response.setContentType("text/html;charset=UTF-8");
			out.print(result);
			out.flush();
		}else if(operation.equals("Get_SUPPLEMENTARY_MEAL_ORDER")){
			String result=get_Supplementary_Meal_Order(request, response);
			response.setContentType("text/html;charset=UTF-8");
			response.setContentType("text/html;charset=UTF-8");
			System.err.println("return --->result--->"+result);
			System.err.println("before return");
			out.print(result);
			out.flush();
		}else if(operation.equals("Get_OLD_SUPPLEMENTARY_MEAL_ORDER")){
			String result=get_Old_Supplementary_Meal_Order(request,response);
			response.setContentType("text/html;charset=UTF-8");
			response.setContentType("text/html;charset=UTF-8");
			//System.err.println("return --->result--->"+result);
			out.print(result);
			out.flush();
		}else if(operation.equals("WardsForKitchenSetUp")){
			String result=wardsForKitchenSetUp(request,response);
			response.setContentType("text/html;charset=UTF-8");
			response.setContentType("text/html;charset=UTF-8");
			out.print(result);
			out.flush();
		}else if(operation.equals("UPDATE_SUPPLEMENTARY_MEAL_ORDER")){
			String result=updateSupplementaryMealOrder(request,response);
			response.setContentType("text/html;charset=UTF-8");
			response.setContentType("text/html;charset=UTF-8");
			System.err.println("return --->result--->"+result);
			out.print(result);
			out.flush();
		}
	}
	
	public String getSupplementaryPlaceSearch(HttpServletRequest request,HttpServletResponse response){
		String responseString="";
		Connection con=null;
		try{
			con=ConnectionManager.getConnection(request);
			SupplementaryPlaceOrderBC supplementaryBCObj=new SupplementaryPlaceOrderBC();
			SupplementaryPlaceOrderRequest requestObj=new SupplementaryPlaceOrderRequest();
			String Nursing_Unit_Code=request.getParameter("nursing_unit_code");
			String Facility_Id=request.getParameter("facility_id");
			String Locale=request.getParameter("locale");
			String Admission_From_Date=request.getParameter("Admission_From_Date");			
			String Admission_To_Date=request.getParameter("Admission_To_Date");
			String PatientId=request.getParameter("PatientId");
			String EncounterId=request.getParameter("EncounterId");
			String PractionerId=request.getParameter("PractionerId");
			String Gender=request.getParameter("Gender");
			String Start_Num=request.getParameter("Start_Num");
			String End_Num=request.getParameter("End_Num");
			String Grace_Period=request.getParameter("Grace_Period");
			String Status=request.getParameter("status");
			
			requestObj.setNursing_Unit_Code(Nursing_Unit_Code);
			requestObj.setFacility_Id(Facility_Id);
			requestObj.setLocale(Locale);
			requestObj.setAdmission_From_Date(Admission_From_Date);
			requestObj.setAdmission_To_Date(Admission_To_Date);
			requestObj.setPatientId(PatientId);
			requestObj.setEncounterId(EncounterId);
			requestObj.setPractionerId(PractionerId);
			requestObj.setGender(Gender);
			requestObj.setStart_Num(Start_Num);
			requestObj.setEnd_Num(End_Num);
			requestObj.setGrace_Period(Grace_Period);
			requestObj.setStatus(Status);
			
			System.out.println("servlet supplementaryPlaceResult");
			
			SupplementaryPlaceOrderResponse supplementaryDtls=supplementaryBCObj.getSupplementayPlaceSearch(requestObj, con);
			
			Gson gson = new GsonBuilder().serializeNulls().create();
			responseString = gson.toJson(supplementaryDtls);
			System.out.println("New responseString---->"+responseString);
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(con!=null)ConnectionManager.returnConnection(con,request);
		}
		return responseString;
	}
	private String insertSupplementaryMealOrder(HttpServletRequest request,HttpServletResponse response){
		String responseString="";
		Connection con=null;
		try{
			con=ConnectionManager.getConnection(request);
			PlaceSupplementaryMealOrderRequest requestObj=new PlaceSupplementaryMealOrderRequest();
			String encounter_Id=request.getParameter("encounterId");
			String patient_Id=request.getParameter("patientId");
			String locale=request.getParameter("locale");
			String facility_Id=request.getParameter("facility_id");
			String date=request.getParameter("date");
			String supplementaryMeal=request.getParameter("SupplementaryMealsarr");
			
			requestObj.setEncounterId(encounter_Id);
			requestObj.setPatient_Id(patient_Id);
			requestObj.setLocale(locale);
			requestObj.setFacility_Id(facility_Id);
			requestObj.setDate(date);
			requestObj.setSupplementaryMeal(supplementaryMeal);
			requestObj.setStr_client_ip_address(str_client_ip_address);
			requestObj.setLogin_user(login_user);
			
			SupplementaryPlaceOrderBC supplementaryBCObj=new SupplementaryPlaceOrderBC();
			supplementaryBCObj.insertSupplementaryMealOrder(requestObj,con);
			
			
		}catch(Exception e){	
			e.printStackTrace();
		}finally{
			if(con!=null)ConnectionManager.returnConnection(con,request);
		}
		return responseString;
	}
	
	private String get_Supplementary_Meal_Order(HttpServletRequest request,HttpServletResponse response){
		String result="";
		Connection con=null;
		try{
			con=ConnectionManager.getConnection(request);
			PlaceSupplementaryMealOrderRequest requestObj=new PlaceSupplementaryMealOrderRequest();
			String encounter_Id=request.getParameter("encounterId");
			String patient_Id=request.getParameter("patientId");
			String locale=request.getParameter("locale");
			String facility_Id=request.getParameter("facility_id");
			
			requestObj.setEncounterId(encounter_Id);
			requestObj.setPatient_Id(patient_Id);
			requestObj.setLocale(locale);
			requestObj.setFacility_Id(facility_Id);			
			
			List<PlaceSupplementaryMealOrderResponse> supplementaryOrderResponseList=null;			
			supplementaryOrderResponseList=new ArrayList<PlaceSupplementaryMealOrderResponse>();			
			SupplementaryPlaceOrderBC supplementaryBCObj=new SupplementaryPlaceOrderBC();
			supplementaryOrderResponseList=supplementaryBCObj.getSupplementaryMealOrder(requestObj, con);
			
 			Gson gson = new GsonBuilder().serializeNulls().create();
			result = gson.toJson(supplementaryOrderResponseList);
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(con!=null)ConnectionManager.returnConnection(con,request);
		}		
		return result;
	}
	
	private String get_Old_Supplementary_Meal_Order(HttpServletRequest request,HttpServletResponse response){
		String result="";
		Connection con=null;
		try{
			con=ConnectionManager.getConnection(request);
			PlaceSupplementaryMealOrderRequest requestObj=new PlaceSupplementaryMealOrderRequest();
			String encounter_Id=request.getParameter("encounter_id");			
			String locale=request.getParameter("locale");
			String facility_Id=request.getParameter("facility_id");
			
			requestObj.setEncounterId(encounter_Id);
			requestObj.setLocale(locale);
			requestObj.setFacility_Id(facility_Id);			
			
			List<PlaceSupplementaryMealOrderResponse> supplementaryOrderResponseList=null;
			
			supplementaryOrderResponseList=new ArrayList<PlaceSupplementaryMealOrderResponse>();			
			
			SupplementaryPlaceOrderBC supplementaryBCObj=new SupplementaryPlaceOrderBC();
			supplementaryOrderResponseList=supplementaryBCObj.getOldSupplementaryMealOrder(requestObj, con);
			
 			Gson gson = new GsonBuilder().serializeNulls().create();
			result = gson.toJson(supplementaryOrderResponseList);
			System.out.println("result get_old_Supplementary_Meal_Order---->"+result);
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(con!=null)ConnectionManager.returnConnection(con,request);
		}		
		return result;
	}
	private String wardsForKitchenSetUp(HttpServletRequest request,HttpServletResponse response){
		String result="";
		Connection con=null;
		try{
			con=ConnectionManager.getConnection(request);

			String bean_id 				= "DSCommonBean";
			String bean_name 			= "eDS.DSCommonBean";
			DSCommonBean commonbeanObj	= (DSCommonBean)com.ehis.persist.PersistenceHelper.getBeanObject( bean_id, bean_name, request ) ;
			
			String Nursing_unit=request.getParameter("nursing_unit_code");
			 facility_id=request.getParameter("facility_id");

			result=commonbeanObj.wardsForKitchenSetUp(con, Nursing_unit, facility_id);
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
	private String updateSupplementaryMealOrder(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		Connection con=null;
		String result="";
		try{
			con=ConnectionManager.getConnection(request);
			String processMealsarr=request.getParameter("processMealsarr");
			SupplementaryProcessRequest req=new SupplementaryProcessRequest();
			req.setProcessSupplementaryMealArray(processMealsarr);
			req.setFacilityId(facility_id);
			req.setLocale(language_id);
			req.setStr_client_ip_address(str_client_ip_address);
			req.setLogin_user(login_user);
			
			SupplementaryPlaceOrderBC bcobj=new SupplementaryPlaceOrderBC();
			result=bcobj.updateSupplementaryMealOrder(req, con);
			
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				ConnectionManager.returnConnection(con,request);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return result;
	}

}
