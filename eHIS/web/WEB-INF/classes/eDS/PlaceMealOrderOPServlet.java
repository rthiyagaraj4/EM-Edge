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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
// Added Againt Start ML-MOH-CRF-825
import java.sql.Timestamp;
import java.util.*;
import java.util.Arrays;
import java.text.ParseException;
import java.text.DateFormat;
// Added Againt End ML-MOH-CRF-825
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import eDS.Common.JSONArray;
import eDS.Common.JSONObject;
import org.apache.log4j.Logger;
import eDS.Common.DlQuery;
import webbeans.eCommon.ConnectionManager;
import eCommon.XSSRequestWrapper;
import webbeans.eCommon.MessageManager;
import eCommon.Common.CommonBean;

/**
File Name		: DocumentOPMealServlet.java
File Description: This servlet file is 
					1) To search all the Outpatient lists who 
							a) Books an appointment but yet to visit 
							b) Visit clinic with appointment
							c) Direct Visit without appointment
					2) To Place an order for the respective Outpatient based on the user inputs .
CRF#			: Bru-HIMS-CRF-230
Author			: Abirami
Date			: Aug-2013
**/

public class PlaceMealOrderOPServlet extends javax.servlet.http.HttpServlet {
	//Declaration:
	private static final long serialVersionUID = 1L;
	java.util.Properties prop;
	HttpSession session;
	String facility_id,str_client_ip_address,login_user,language_id;
	private final static Logger log = Logger.getLogger("eDS");
	String opMealOrderYn="",EmMealOrderYn="";//ML-MMOH-CRF-0825
	String irregular_flag_yn;
	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Added Against MMS Vulnerability Issue - Starts
        request= new XSSRequestWrapper(request);
        response.addHeader("X-XSS-Protection", "1; mode=block");
        response.addHeader("X-Content-Type-Options", "nosniff");
        //Added Against MMS Vulnerability Issue - Ends 

		//Declaration::
		PrintWriter out=response.getWriter();
		String operation = request.getParameter("mode");
		JSONObject specialityJSONList=new JSONObject();
		JSONObject mealOrderJSONList=new JSONObject();
		JSONObject treatMentAreaObj=new JSONObject();
		
		log.debug("operation"+operation);
		
		//Getting session values::
		session = request.getSession(false);
		//ML-MMOH-CRF-0825
		opMealOrderYn = request.getParameter("LATE_IRREGULAR_DIET_ORD_FOR_OP");
		EmMealOrderYn = request.getParameter("LATE_IRREGULAR_DIET_ORD_FOR_EM");
		//ML-MMOH-CRF-0825
		irregular_flag_yn = "N";
		this.prop = (java.util.Properties) session.getValue("jdbc");
		str_client_ip_address = prop.getProperty("client_ip_address");
		login_user = prop.getProperty( "login_user" ) ;
		if(str_client_ip_address == null) str_client_ip_address="";
		if(login_user == null) login_user="";
		this.facility_id = (String) session.getAttribute("facility_id");
		this.language_id = (String) session.getAttribute("LOCALE");
		/*******Initial Load - Loading Speciality, Location and MultiFacility Parameter  ********/
		if(operation.equals("loadKitchen_OPEnab")){
			//String sKitchen = loadKitchen(request,response);
			JSONObject objKit_OPMap = loadKitchen(request,response);
			response.setContentType("application/json");
			out.print(objKit_OPMap);
			out.flush();
		}
		/*******Initial Load - Loading Speciality, Location and MultiFacility Parameter  ********/
		if(operation.equals("initialLoad")){
			specialityJSONList = initialLoad(request,response);
			response.setContentType("application/json");
			out.print(specialityJSONList);
			out.flush();
		}
		/*******Searching Outpatient List********/
		if(operation.equals("searchMealOrder")){
			log.debug("search..mealorder2");
			mealOrderJSONList = searchMealOrder(request,response);
			response.setContentType("application/json");
			out.print(mealOrderJSONList);
			out.flush();
		}
		/*********Loading Selected Outpatient List in Place order Screen***********************/
		if(operation.equals("loadOPMealOrder")){
			log.debug("loadOPMealOrder");
			JSONObject mealOrderJSONList_Order = loadOPMealOrder(request,response);
			log.debug("mealOrderJSONList_Order---->>>"+mealOrderJSONList_Order+"<<<<<<<");
			response.setContentType("application/json");
			response.setContentType("text/html;charset=UTF-8");
			out.print(mealOrderJSONList_Order);
			out.flush();
		}
		/********* Check if the selected appointments are cancelled ***********************/
		if(operation.equals("chkCanceledAppt")){
			log.debug("chkCanceledAppt");
			JSONObject JSON_invalidOrderList = chkCanceledAppt(request,response);
			response.setContentType("application/json");
			out.print(JSON_invalidOrderList);
			out.flush();
		}
		/********* Insert/ Updating Meal Order for Outpatient based on the user inputs***********************/
		if(operation.equals("insertOPMealOrder")){
			log.debug("insertOPMealOrder");
			boolean bReturn = insertOPMealOrder(request,response);
		//	log.debug("mealOrderJSONList_Order---->>>"+mealOrderJSONList_Order+"<<<<<<<");
			response.setContentType("text/html;charset=UTF-8");
			MessageManager mm = new MessageManager();
			if(bReturn)
			{
				final java.util.Hashtable mesg = mm.getMessage(language_id,	"DS_OPER_COMPLETE", "DS");
				String msg1 = (String) mesg.get("message");
				out.println("<script>parent.warnOnClose = true;	 alert('" + msg1 + "');");
				out.println("parent.parent.document.querySelectorAll('#dialog-body')[parent.parent.document.querySelectorAll('#dialog-body').length-1].contentWindow.returnValue=true;");
				out.println("parent.parent.document.querySelectorAll('#dialog_tag')[parent.parent.document.querySelectorAll('#dialog_tag').length-1].close();</script>");
				/*out.println("parent.window.returnValue=true;");
				out.println("top.close();</script>");*/
				mesg.clear();	//Common-ICN-0044
			}else
			{
				final java.util.Hashtable mesg = mm.getMessage(language_id,	"DS_OPER_UNSUCCESS", "DS");
				String msg1 = (String) mesg.get("message");
				out.println("<script>parent.warnOnClose = true;	 alert('" + msg1 + "');");
				out.println("parent.parent.document.querySelectorAll('#dialog-body')[parent.parent.document.querySelectorAll('#dialog-body').length-1].contentWindow.returnValue=false;");
				out.println("parent.parent.document.querySelectorAll('#dialog_tag')[parent.parent.document.querySelectorAll('#dialog_tag').length-1].close();</script>");
				/*
				out.println("parent.window.returnValue=false;");
				out.println("top.close();</script>");*/
				mesg.clear();	//Common-ICN-0044
			}
			out.flush();
		}
		/********* Getting UOM Values***********************/
		if(operation.equals("KaloriForMeals")){
			log.debug("KaloriForMeals");
			ArrayList<String> kaloriList  = getKaloriForMeals(request);
		//	log.debug("mealOrderJSONList_Order---->>>"+mealOrderJSONList_Order+"<<<<<<<");
			out.println(kaloriList);
		}
		if(operation.equals("getTreatmentArea")){
			treatMentAreaObj  = getTreatmentArea(request);
		//	log.debug("mealOrderJSONList_Order---->>>"+mealOrderJSONList_Order+"<<<<<<<");
			out.println(treatMentAreaObj);
		}
		if(operation.equals("searchEMMealOrder")){
			mealOrderJSONList = searchEMMealOrder(request,response);
			response.setContentType("application/json");
			out.print(mealOrderJSONList);
			out.flush();			
		}
		if(operation.equals("loadKitchen_EM")){
			//String sKitchen = loadKitchen(request,response);
			JSONObject objKitchen = loadKitchen_EM(request,response);
			response.setContentType("application/json");
			out.print(objKitchen);
			out.flush();
		}		
		/*********Loading Selected A&E (EM) patient List in Place order Screen***********************/
		if(operation.equals("loadEMMealOrder")){
			JSONObject objMealOrder = loadEMMealOrder(request,response);
			log.debug("mealOrderJSONList_Order---->>>"+objMealOrder+"<<<<<<<");
			response.setContentType("application/json");
			response.setContentType("text/html;charset=UTF-8");
			out.print(objMealOrder);
			out.flush();
		}
		
		/*** To select Pending Meal Acknowledgements *********/
		//Added Against ML-MMOH-CRF-0600 starts here
		if(operation.equals("pendingMealOrderAckDetail")){
			JSONObject objMealAck = pendingMealOrder_AckDetail(request,response);			
			response.setContentType("application/json");
			response.setContentType("text/html;charset=UTF-8");
			out.print(objMealAck);
			out.flush();
		}
		//Added Against ML-MMOH-CRF-0600 Ends Here
		/********* Insert/ Updating Meal Order for Emergency patients based on the user inputs***********************/
		if(operation.equals("insertEMMealOrder")){
			System.out.println("insertOPMealOrder");
			
			boolean bReturn = insertEMMealOrder(request,response);
		//	log.debug("mealOrderJSONList_Order---->>>"+mealOrderJSONList_Order+"<<<<<<<");
			response.setContentType("text/html;charset=UTF-8");
			MessageManager mm = new MessageManager();
			if(bReturn)
			{
				final java.util.Hashtable mesg = mm.getMessage(language_id,	"DS_OPER_COMPLETE", "DS");
				String msg1 = (String) mesg.get("message");
				out.println("<script>parent.warnOnClose = true;	 alert('" + msg1 + "');");
				out.println("parent.parent.document.querySelectorAll('#dialog-body')[parent.parent.document.querySelectorAll('#dialog-body').length-1].contentWindow.returnValue=true;");
				out.println("parent.parent.document.querySelectorAll('#dialog_tag')[parent.parent.document.querySelectorAll('#dialog_tag').length-1].close();</script>");
				/*out.println("parent.window.returnValue=true;");
				out.println("top.close();</script>");*/
				mesg.clear();	//Common-ICN-0044
			}else
			{
				final java.util.Hashtable mesg = mm.getMessage(language_id,	"DS_OPER_UNSUCCESS", "DS");
				String msg1 = (String) mesg.get("message");
				out.println("<script>parent.warnOnClose = true;	 alert('" + msg1 + "');");
				out.println("parent.parent.document.querySelectorAll('#dialog-body')[parent.parent.document.querySelectorAll('#dialog-body').length-1].contentWindow.returnValue=false;");
				out.println("parent.parent.document.querySelectorAll('#dialog_tag')[parent.parent.document.querySelectorAll('#dialog_tag').length-1].close();</script>");
//				out.println("parent.window.returnValue=false;");
//				out.println("top.close();</script>");
				mesg.clear();	//Common-ICN-0044
			}
			out.flush();
		}		
	
	}
	
	/* Method Desc: Initial Load - Loading Speciality, Location and MultiFacility Parameter  */
	private JSONObject loadKitchen(HttpServletRequest request,  HttpServletResponse response) {
		Connection conn = ConnectionManager.getConnection(request);
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String kitchenCode = "";
		int OPCount = 0;
		JSONObject jsonList = new JSONObject(); 
		try{
		
			String SQL_kitchen= "select kitchen_code from ds_speciality_for_kitchen where OPERATING_FACILITY_ID = ? and speciality_code=? ";
			String SQL_OPEnabledYN = "SELECT count(*) OPCount FROM ds_meal_type WHERE OPMEALORDER_YN = 'Y' and eff_status = 'E'";
			
			String speciality = request.getParameter("speciality");
			String facilityid = request.getParameter("facilityid");
			
			//Getting kitchen Code ::
			pstmt = conn.prepareStatement(SQL_kitchen);
			pstmt.setString(1, facilityid);
			pstmt.setString(2, speciality);
			
			rs = pstmt.executeQuery();

			log.debug("initialLoad method::");
			while(rs != null && rs.next())
			{
				kitchenCode = rs.getString("kitchen_code");
			}
			jsonList.append("kitchenCode", kitchenCode);
			
			//Check if any mealtype is mapped with OP:
			if(pstmt!=null) pstmt.close();	//Added Against Common-ICN-0031
			if(rs!=null) rs.close();	//Added Against Common-ICN-0031
			pstmt = conn.prepareStatement(SQL_OPEnabledYN);
			
			rs = pstmt.executeQuery();

			while(rs != null && rs.next())
			{
				OPCount = rs.getInt("OPCount");
			}
			jsonList.append("OPCount", OPCount);
			
		}
		catch(Exception ee){
			System.err.println("PlaceMealOrderOPServlet.java-255-->"+ee.getMessage());
		}
		finally{
			try{
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null)ConnectionManager.returnConnection(conn,request);
			}catch(Exception e)
			{
				System.err.println("PlaceMealOrderOPServlet.java-264-->"+e.getMessage());
			}
		}
		return jsonList;
	}
	
	/* Method Desc: Initial Load - Loading Speciality, Location and MultiFacility Parameter  */
	private JSONObject loadKitchen_EM(HttpServletRequest request,  HttpServletResponse response) {
		Connection conn = ConnectionManager.getConnection(request);
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String kitchenCode = "";
		int EMCount = 0;
		JSONObject jsonList = new JSONObject(); 
		try{
		
			String SQL_kitchen= "select kitchen_code from ds_speciality_for_kitchen where OPERATING_FACILITY_ID = ? and speciality_code=? ";
			String SQL_EMEnabledYN = "SELECT count(*) EMCount FROM ds_meal_type WHERE em_meal_order_yn = 'Y' and eff_status = 'E'";
			
			String speciality = request.getParameter("speciality");
			String facilityid = request.getParameter("facilityid");
			
			//Getting kitchen Code ::
			pstmt = conn.prepareStatement(SQL_kitchen);
			pstmt.setString(1, facilityid);
			pstmt.setString(2, speciality);
			
			rs = pstmt.executeQuery();

			log.debug("initialLoad method::");
			while(rs != null && rs.next())
			{
				kitchenCode = rs.getString("kitchen_code");
			}
			jsonList.append("kitchenCode", kitchenCode);
			
			if(pstmt!=null) pstmt.close();	//Added Against Common-ICN-0031
			if(rs!=null) rs.close();	//Added Against Common-ICN-0031
			//Check if any mealtype is mapped with OP:
			
			pstmt = conn.prepareStatement(SQL_EMEnabledYN);
			
			rs = pstmt.executeQuery();

			while(rs != null && rs.next())
			{
				EMCount = rs.getInt("EMCount");
			}
			jsonList.append("EMCount", EMCount);
			
		}
		catch(Exception ee){
			System.err.println("PlaceMealOrderOPServlet.java--314->"+ee.getMessage());
		}
		finally{
			try{
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null)ConnectionManager.returnConnection(conn,request);
			}catch(Exception e)
			{
				System.err.println("PlaceMealOrderOPServlet.java--323->"+e.getMessage());
			}
		}
		return jsonList;
	}
	
	/* Method Desc: Initial Load - Loading Speciality, Location and MultiFacility Parameter  */
	private JSONObject initialLoad(HttpServletRequest request,  HttpServletResponse response) {
		
		Connection conn = ConnectionManager.getConnection(request);
		PreparedStatement pstmt=null;
		PreparedStatement pstmtLoc=null;
		PreparedStatement pstmtRes=null;
		ResultSet rs=null;
		
		JSONObject jsonList = new JSONObject();
		try{
		
			//String speciality_code = "select distinct speciality_code, am_get_desc.am_speciality(speciality_code,'"+language_id+"', 2) short_desc from Am_Speciality where  EFF_STATUS ='E' order by UPPER(short_desc)";//Commented against ML-MMOH-CRF-597
			
			String speciality_code = "select distinct speciality_code, am_get_desc.am_speciality(speciality_code,'"+language_id+"', 2) short_desc from ds_speciality_for_kitchen  order by UPPER(short_desc)";//Added against ML-MMOH-CRF-597
			String location_type = "select locn_type, am_get_desc.am_care_locn_type(LOCN_TYPE,'"+ language_id +"',2) short_desc, care_locn_type_ind from " +
					"am_care_locn_type where sys_user_def_ind = 'S' and locn_type in ('C','E','Y')  order by UPPER(short_desc)";
			String multifacility = "select multifacility_yn from DS_PARAM_FOR_FACILITY where operating_facility_id=?";
			String pIDLength = "select patient_id_length from mp_param";
			String priorityZone="select priority_zone,priority_zone_desc from ae_priority_zone where eff_status='E'";
				
			//Getting Speciality Code and Desc::
			pstmt = conn.prepareStatement(speciality_code);
			rs = pstmt.executeQuery();

			log.debug("initialLoad method::");
			while(rs != null && rs.next())
			{
				String specCode = rs.getString("speciality_code");
				String shortdesc = rs.getString("short_desc");
				JSONObject jsonSpecList = new JSONObject();
				
				jsonSpecList.put("specCode", specCode);
				jsonSpecList.put("specDesc", shortdesc);
				
				jsonList.append("specList",jsonSpecList);
			}
			if(pstmt!=null) pstmt.close();	//Added Against Common-ICN-0031
			if(rs!=null) rs.close();	//Added Against Common-ICN-0031
			//Getting Location type and Desc::
			pstmtLoc = conn.prepareStatement(location_type);
			rs = pstmtLoc.executeQuery();

			while(rs != null && rs.next())
			{
				String locCode = rs.getString("locn_type");
				String shortdesc = rs.getString("short_desc");
				JSONObject jsonLocList = new JSONObject();
				
				jsonLocList.put("LocCode", locCode);
				jsonLocList.put("LocDesc", shortdesc);
				jsonList.append("locList",jsonLocList);
			}
			if(rs!=null) rs.close();	//Common-ICN-0044
			//Getting multifacility:
			pstmtRes = conn.prepareStatement(multifacility);
			pstmtRes.setString(1, facility_id);
			rs = pstmtRes.executeQuery();

			while(rs != null && rs.next())
			{
				String cMultifacility = rs.getString("multifacility_yn");
				
				jsonList.append("multifacility",cMultifacility);
			}
			if(pstmtRes!=null) pstmtRes.close();	//Added Against Common-ICN-0031
			if(rs!=null) rs.close();	//Added Against Common-ICN-0031
			//Setting PatientID Length:
			pstmtRes = conn.prepareStatement(pIDLength);
			rs = pstmtRes.executeQuery();

			while(rs != null && rs.next())
			{
				String sPIDLength = rs.getString("patient_id_length");
				
				jsonList.append("patientIDLen",sPIDLength);
			}
			if(rs!=null) rs.close();	//Added Against Common-ICN-0031
			//Getting Priority Zone Code and Desc::
			pstmt = conn.prepareStatement(priorityZone);
			rs = pstmt.executeQuery();

			while(rs != null && rs.next())
			{
				String code = rs.getString("priority_zone");
				String desc = rs.getString("priority_zone_desc");
				JSONObject jsonPriorityZoneList = new JSONObject();
				
				jsonPriorityZoneList.put("pZoneCode", code);
				jsonPriorityZoneList.put("pZoneDesc", desc);
				
				jsonList.append("priorityZoneList",jsonPriorityZoneList);
			}			

		}
		catch(Exception ee){
			System.err.println("PlaceMealOrderOPServlet.java-423-->"+ee.getMessage());
		}
		finally{
			try{
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(pstmtLoc!=null) pstmtLoc.close();
				if(pstmtRes!=null) pstmtRes.close();
				if(conn!=null)ConnectionManager.returnConnection(conn,request);
			}catch(Exception e)
			{
				System.err.println("PlaceMealOrderOPServlet.java-434-->"+e.getMessage());
			}
		}
		return jsonList;
	}

	/* Method Desc: Searching Outpatient List*/
	private JSONObject searchMealOrder(HttpServletRequest request,  HttpServletResponse response) {
	 
		Connection conn = ConnectionManager.getConnection(request);
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		log.debug("declaration:");
		JSONObject jsonList = new JSONObject();
		try{
				//Getting Inputs::
				log.debug("getting request parameters1::");
				String jsonData = request.getParameter("jsonData");
				JSONObject json = new JSONObject(jsonData);		
				log.debug("getting request parameters::");
				String facilityid =  json.getString("facilityid");
				String speciality =  json.getString("speciality");
				String encounterid	=  json.getString("encounterId");
				String sEncounterQuery = "";
				if("".equalsIgnoreCase(encounterid.trim()))
					sEncounterQuery = "";
				else
					sEncounterQuery = " and appt.encounter_id = NVL(?, appt.encounter_id) " ;
				
				log.debug("sEncounterQuery:"+ sEncounterQuery);
				String patientid	=  json.getString("patientId");
				String locationType =  json.getString("locationType");
				String locationCode	=  json.getString("locationCode");
				String restype	=  json.getString("restype");
				String resource =  json.getString("resource");
				String sapptDateFrom	=  com.ehis.util.DateUtils.convertDate(json.getString("apptDateFrom"),"DMY", language_id, "en");
				String sapptDateTo		=  com.ehis.util.DateUtils.convertDate(json.getString("apptDateTo"),"DMY", language_id, "en");
				String apptNo	=  json.getString("apptNo");
				String sApptQuery = "";
				if("".equalsIgnoreCase(apptNo.trim()))
					sApptQuery = "";
				else
					sApptQuery = " and enct.appt_id = NVL(?, enct.appt_id) ";
				
				
				//Forming Query for filtering search with patient id ::
				patientid = patientid.toString().trim();
				String sWherePatientQuery = "";
				String sFromPatientQuery = "";
				if(!"".equalsIgnoreCase(patientid))
				{
					sFromPatientQuery = " ,mp_patient mp ";
					sWherePatientQuery = " and mp.patient_id(+) = appt.patient_id and appt.patient_id = NVL(?, appt.patient_id) ";
				}
				// Forming Query for Status::
				String status	=  json.getString("status");
				String sFromStatusQuery = "";
				
				String sSelectStatusQuery1 = "";
				String sSelectStatusQuery2 = "";
				String sSelectStatusQuery3 = "";
				
				String sWhereStatusQuery1 = "";
				String sWhereStatusQuery2 = "";
				String sWhereStatusQuery3 = "";
				
				if("".equalsIgnoreCase(status))
				{
					status = null; //All Status
					
					sSelectStatusQuery1 = " (select dietHdr.Modified_YN from DS_OP_DIET_ORDER_HDR dietHdr where appt.appt_ref_no = dietHdr.App_No and appt.FACILITY_ID = dietHdr.Facility_Id) as status, "; 
					sSelectStatusQuery2 = " (select dietHdr.Modified_YN from DS_OP_DIET_ORDER_HDR dietHdr where appt.appt_ref_no = dietHdr.App_No and appt.FACILITY_ID = dietHdr.Facility_Id) as status, ";
					sSelectStatusQuery3 = " (select dietHdr.Modified_YN from DS_OP_DIET_ORDER_HDR dietHdr where enct.Encounter_id = dietHdr.Encounter_Id and enct.FACILITY_ID = dietHdr.Facility_Id) as status, ";
					
					sFromStatusQuery = "";
					
					sWhereStatusQuery1 = "";
					sWhereStatusQuery2 = "";
					sWhereStatusQuery3 = "";
				}
				else if("A".equalsIgnoreCase(status))
				{
					status = "N"; //Order Placed
					
					sSelectStatusQuery1 = " dietHdr.Modified_YN as status, ";
					sSelectStatusQuery2 = sSelectStatusQuery1;
					sSelectStatusQuery3 = sSelectStatusQuery1;
					
					sFromStatusQuery = " , DS_OP_DIET_ORDER_HDR dietHdr ";
					
					sWhereStatusQuery1 = " and appt.FACILITY_ID = dietHdr.Facility_Id and appt.appt_ref_no = dietHdr.App_No ";
					sWhereStatusQuery2 = " and appt.FACILITY_ID = dietHdr.Facility_Id and appt.appt_ref_no = dietHdr.App_No "; // and dietHdr.Modified_YN = 'N' ";
					sWhereStatusQuery3 = " and enct.FACILITY_ID = dietHdr.Facility_Id and enct.Encounter_id = dietHdr.Encounter_Id ";
					
				}
				else if("C".equalsIgnoreCase(status))
				{
					status = "N"; //Order Pending
					
					sSelectStatusQuery1 = " null as status, ";
					sSelectStatusQuery2 = sSelectStatusQuery1;
					sSelectStatusQuery3 = sSelectStatusQuery1;
					
					sFromStatusQuery = "";
					
					sWhereStatusQuery1 = " and appt.appt_ref_no not in(select dietHdr.App_No from DS_OP_DIET_ORDER_HDR dietHdr where dietHdr.App_No =appt.appt_ref_no and appt.FACILITY_ID = dietHdr.Facility_Id) ";
					sWhereStatusQuery2 = " and appt.appt_ref_no not in(select dietHdr.App_No from DS_OP_DIET_ORDER_HDR dietHdr where dietHdr.App_No =appt.appt_ref_no and appt.FACILITY_ID = dietHdr.Facility_Id) ";
					sWhereStatusQuery3 = " and enct.Encounter_id not in(select dietHdr.Encounter_Id from DS_OP_DIET_ORDER_HDR dietHdr where dietHdr.Encounter_Id =enct.Encounter_Id and enct.FACILITY_ID = dietHdr.Facility_Id) ";
					
				}
				else if("F".equalsIgnoreCase(status))
				{
					status = "Y"; //Order Modified
					
					sSelectStatusQuery1 = " dietHdr.Modified_YN as status, ";
					sSelectStatusQuery2 = sSelectStatusQuery1;
					sSelectStatusQuery3 = sSelectStatusQuery1;
					
					sFromStatusQuery = " , DS_OP_DIET_ORDER_HDR dietHdr ";
					
					sWhereStatusQuery1 = " and appt.FACILITY_ID = dietHdr.Facility_Id and appt.appt_ref_no = dietHdr.App_No and dietHdr.Modified_YN = 'Y'  ";
					sWhereStatusQuery2 = " and appt.FACILITY_ID = dietHdr.Facility_Id and appt.appt_ref_no = dietHdr.App_No and dietHdr.Modified_YN = 'Y' ";
					sWhereStatusQuery3 = " and enct.FACILITY_ID = dietHdr.Facility_Id and enct.Encounter_id = dietHdr.Encounter_Id and dietHdr.Modified_YN = 'Y' ";
				}
				
				//Forming Query for filtering Resources::
				String sResourceQuery = "";
				if(!"".equalsIgnoreCase(restype))
				{
					sResourceQuery = "and decode(?,'R', ASSIGN_ROOM_NUM,  " +
									"        'P', ATTEND_PRACTITIONER_ID, " + 
									"        'E', decode(OTHER_RES_CLASS, 'E', OTHER_RESOURCE_ID, ''), " +
									"        'O', decode(OTHER_RES_CLASS, 'O', OTHER_RESOURCE_ID, ''))= NVL(?, decode(?,'R', ASSIGN_ROOM_NUM, " + 
									" 		                                                          'P', ATTEND_PRACTITIONER_ID, " + 
									"                                                  'E', decode(OTHER_RES_CLASS, 'E', OTHER_RESOURCE_ID, ''), " +
									"                                                  'O', decode(OTHER_RES_CLASS, 'O', OTHER_RESOURCE_ID, '')) ) ";
				}
				
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				log.debug("done");
				log.debug(facilityid);
				log.debug("speciality"+speciality);
				log.debug("encounterId"+encounterid);
				log.debug("patientId"+patientid);
				log.debug("locationType"+locationType);
				log.debug("locationCode"+locationCode);
			
				StringBuffer sbmealOrderResult = new StringBuffer();
				//Modified against ML-BRU-SCF-1336/49184
				sbmealOrderResult.append("select appt.patient_id as patient_id, appt.patient_name as patient_name, to_char(appt.appt_date, 'dd/mm/yyyy') as apptDate, nvl(to_char(appt_time,'hh24:mi'),' ') as appt_time, appt.appt_ref_no as apptNo, ");
				sbmealOrderResult.append("appt.encounter_id as encounterid , null as visitDate, " +	sSelectStatusQuery1 );
				sbmealOrderResult.append("to_char(appt.appt_date , 'mm/dd/yyyy') as chkPlaceOrderDate " );
				sbmealOrderResult.append("from oa_appt appt" + sFromPatientQuery + " " + sFromStatusQuery );
				//sbmealOrderResult.append("where  appt.FACILITY_ID = NVL(?, appt.FACILITY_ID) and appt_status='1' " + sWherePatientQuery + " " + sEncounterQuery ); //INC:49184
				sbmealOrderResult.append("where  appt.FACILITY_ID like NVL(?, '%%') and appt_status='1' " + sWherePatientQuery + " " + sEncounterQuery );
				sbmealOrderResult.append(" and appt.speciality_code = NVL(?, appt.speciality_code ) " );
				sbmealOrderResult.append(" and appt.care_locn_type_ind = NVL(?, appt.care_locn_type_ind) " );
				sbmealOrderResult.append(" and appt.clinic_code =NVL(?, appt.clinic_code) " );
				sbmealOrderResult.append(" and appt.resource_class = NVL(?, appt.resource_class) " );
				sbmealOrderResult.append(" and appt.practitioner_id = NVL(?, appt.practitioner_id) " );
				sbmealOrderResult.append(" and appt.appt_ref_no = NVL(?, appt.appt_ref_no)  " + sWhereStatusQuery1 );
				sbmealOrderResult.append(" and (trunc(appt.appt_date) between to_date(?, 'dd/mm/yyyy') and to_date(nvl(?, '31/12/2999'), 'dd/mm/yyyy')) ");
				sbmealOrderResult.append(" Union  " );
				sbmealOrderResult.append(" select enct.patient_id as patient_id, mp.patient_name as patient_name, to_char(appt.appt_date, 'dd/mm/yyyy') as apptDate, nvl(to_char(appt_time,'hh24:mi'),' ') as appt_time, appt.appt_ref_no as apptNo, " ); 
				sbmealOrderResult.append(" appt.encounter_id as encounterid, to_char(enct.visit_adm_date_time, 'dd/mm/yyyy HH24:MI') as visitDate,  " + sSelectStatusQuery2 );
				sbmealOrderResult.append(" to_char(enct.visit_adm_date_time , 'mm/dd/yyyy') as chkPlaceOrderDate " );
				sbmealOrderResult.append("from oa_appt appt, pr_encounter enct, mp_patient mp  " + sFromStatusQuery ); 
				//sbmealOrderResult.append("where appt.FACILITY_ID = NVL(?,  appt.FACILITY_ID) and appt.Encounter_id =  enct.Encounter_id " );//INC:49184
				sbmealOrderResult.append("where appt.FACILITY_ID like NVL(?,  '%%') and appt.Encounter_id =  enct.Encounter_id " );
				sbmealOrderResult.append("and enct.patient_id = mp.patient_id and appt.FACILITY_ID = enct.Facility_Id and enct.patient_class='OP' " );
				sbmealOrderResult.append("and enct.patient_id = NVL(?, enct.patient_id) " );
				sbmealOrderResult.append("and enct.Encounter_id = NVL(?, enct.Encounter_id) " );
				sbmealOrderResult.append("and enct.specialty_code = NVL(?, enct.specialty_code) " );
				sbmealOrderResult.append("and enct.PAT_CURR_LOCN_TYPE = NVL(?, enct.PAT_CURR_LOCN_TYPE) " );
				sbmealOrderResult.append("and enct.PAT_CURR_LOCN_CODE = NVL(?, enct.PAT_CURR_LOCN_CODE) " );
				sbmealOrderResult.append("and appt.appt_ref_no = NVL(?, appt.appt_ref_no) " + sResourceQuery + " " + sWhereStatusQuery2 ); 
				sbmealOrderResult.append(" and (trunc(enct.visit_adm_date_time) between to_date(?, 'dd/mm/yyyy') and to_date(nvl(?, '31/12/2999'), 'dd/mm/yyyy')) ");
				sbmealOrderResult.append("Union " );
				sbmealOrderResult.append("select mp.patient_id as patient_id, mp.patient_name as patient_name, null as apptDate, null as appt_time, '' as apptNo, " );  
				sbmealOrderResult.append("enct.encounter_id as encounterid, to_char(enct.visit_adm_date_time, 'dd/mm/yyyy HH24:MI') as visitDate,  " + sSelectStatusQuery3 ); 
				sbmealOrderResult.append("to_char(enct.visit_adm_date_time , 'mm/dd/yyyy') as chkPlaceOrderDate " );
				sbmealOrderResult.append("from pr_encounter enct, mp_patient mp  " + sFromStatusQuery );
				sbmealOrderResult.append("where  enct.FACILITY_ID like NVL(?,  '%%') and visit_status IN('01','02','03','04','07') " );//INC:49184
				sbmealOrderResult.append("and enct.appt_case_yn = 'W' " );
				sbmealOrderResult.append("and mp.patient_id = enct.patient_id and enct.patient_class='OP' " );
				sbmealOrderResult.append("and enct.patient_id = NVL(?, enct.patient_id) " );
				sbmealOrderResult.append("and enct.Encounter_id = NVL(?, enct.Encounter_id) " );
				sbmealOrderResult.append("and enct.specialty_code = NVL(?, enct.specialty_code) " );
				sbmealOrderResult.append("and enct.PAT_CURR_LOCN_TYPE = NVL(?, enct.PAT_CURR_LOCN_TYPE) " );
				sbmealOrderResult.append("and enct.PAT_CURR_LOCN_CODE = NVL(?, enct.PAT_CURR_LOCN_CODE) " + sApptQuery + " " + sResourceQuery + " " + sWhereStatusQuery3 ); 
				sbmealOrderResult.append(" and (trunc(enct.visit_adm_date_time) between to_date(?, 'dd/mm/yyyy') and to_date(nvl(?, '31/12/2999'), 'dd/mm/yyyy')) ");
				sbmealOrderResult.append(" order by visitDate desc, apptDate desc, appt_time desc, apptNo desc ");

				String mealOrderResult = sbmealOrderResult.toString(); 
						
				//Getting Outpatient Lists::
				log.debug("mealOrderResult::"+mealOrderResult);
				pstmt = conn.prepareStatement(mealOrderResult);
				int nindex = 1;
				pstmt.setString(nindex++, facilityid);
				
				if(!"".equalsIgnoreCase(patientid))
				{
					pstmt.setString(nindex++, patientid);
				}
				
				String dapptDateFrom="";
				String dapptDateTo="";
				if(!("".equalsIgnoreCase(sapptDateFrom) )) //|| sapptDateFrom.length()>0)
				{
					 java.util.Date dateStr = sdf.parse(sapptDateFrom);
			         dapptDateFrom = sdf.format(dateStr);
				}
				
				if(!("".equalsIgnoreCase(sapptDateTo) ))
				{
					java.util.Date dateStr = sdf.parse(sapptDateTo);
					dapptDateTo = sdf.format(dateStr);
				}
				
				log.debug("dapptDateFrom:"+dapptDateFrom);
				log.debug("dapptDateFrom:"+sdf.parse(sapptDateFrom).getDate());
				log.debug("dapptDateTo:"+dapptDateTo);
				
				if(!"".equalsIgnoreCase(encounterid.trim()))
					pstmt.setString(nindex++, encounterid);
			
				//Setting inputs for first main query::
				pstmt.setString(nindex++, speciality);
				pstmt.setString(nindex++, locationType);
				pstmt.setString(nindex++, locationCode);
				pstmt.setString(nindex++, restype);
				pstmt.setString(nindex++, resource);
				pstmt.setString(nindex++, apptNo);
				pstmt.setString(nindex++, dapptDateFrom);
				pstmt.setString(nindex++, dapptDateTo);
				
				//Setting inputs for second main query::
				pstmt.setString(nindex++, facilityid);
				pstmt.setString(nindex++, patientid);
				pstmt.setString(nindex++, encounterid);
				pstmt.setString(nindex++, speciality);
				pstmt.setString(nindex++, locationType);
				pstmt.setString(nindex++, locationCode);
				pstmt.setString(nindex++, apptNo);
				if(!"".equalsIgnoreCase(restype))
				{
					pstmt.setString(nindex++, restype);
					pstmt.setString(nindex++, resource);
					pstmt.setString(nindex++, restype);
				}
				pstmt.setString(nindex++, dapptDateFrom);
				pstmt.setString(nindex++, dapptDateTo);
				
				//Setting inputs for third main query::
				pstmt.setString(nindex++, facilityid);
				pstmt.setString(nindex++, patientid);
				pstmt.setString(nindex++, encounterid);
				pstmt.setString(nindex++, speciality);
				pstmt.setString(nindex++, locationType);
				pstmt.setString(nindex++, locationCode);
				
				if(!"".equalsIgnoreCase(apptNo.trim()))
				{
					pstmt.setString(nindex++, apptNo);
				}
				
				if(!"".equalsIgnoreCase(restype))
				{
					pstmt.setString(nindex++, restype);
					pstmt.setString(nindex++, resource);
					pstmt.setString(nindex++, restype);
				}	
				pstmt.setString(nindex++, dapptDateFrom);
				pstmt.setString(nindex++, dapptDateTo);
				
				rs = pstmt.executeQuery();
				

				log.debug("Getting Records:");
				while(rs != null && rs.next())
				{
					JSONObject jsonRecord= new JSONObject();
					jsonRecord.put("patient_id", 	isNULL(rs.getString("patient_id")));
					jsonRecord.put("patient_name", 	isNULL(rs.getString("patient_name")));
					//jsonRecord.put("ApptDate", 		isNULL(rs.getString("apptDate")));
					//jsonRecord.put("VisitDate", 	isNULL(rs.getString("visitDate")));
					jsonRecord.put("ApptDate", 		com.ehis.util.DateUtils.convertDate(rs.getString("apptDate"),"DMY","en",language_id));
					jsonRecord.put("ApptTime", 		rs.getString("appt_time"));
					jsonRecord.put("VisitDate", 	com.ehis.util.DateUtils.convertDate(rs.getString("visitDate"),"DMYHM","en",language_id));
					jsonRecord.put("chkPlaceOrderDate", isNULL(rs.getString("chkPlaceOrderDate")));
					jsonRecord.put("ApptNo", 		isNULL(rs.getString("apptNo")));
					jsonRecord.put("Encounterid", 	isNULL(rs.getString("encounterid")));
					jsonRecord.put("status", 		rs.getString("status"));
					//Added Against ML-MMOH-CRF-0600 Starts Here
					String patientid_temp=isNULL(rs.getString("patient_id"));
					String pending_Ack=pendingMealOrder_Ack(request,response,"OP",patientid_temp);					
					jsonRecord.put("pending_Ack", 	pending_Ack);
					//Added Against ML-MMOH-CRF-0600 Ends Here
					jsonList.append("jsonOrderList", jsonRecord);
				}
			}
			catch(Exception ee){
				System.err.println("PlaceMealOrderOPServlet.java--732->"+ee.getMessage());
			}
			finally{
				try{
					if(rs!=null) rs.close();
					if(pstmt!=null) pstmt.close();
					if(conn!=null)ConnectionManager.returnConnection(conn,request);
				}catch(Exception e){System.err.println("PlaceMealOrderOPServlet.java--739->"+e.getMessage());}
			}
			return jsonList;
	}

	/**Method Desc: Loading Selected Outpatient List in Place order Screen**/
	private JSONObject loadOPMealOrder(HttpServletRequest request,  HttpServletResponse response) {
		
		//CRF-0684
		boolean isMenuType =false;        
		Connection conn = ConnectionManager.getConnection(request);
		isMenuType = CommonBean.isSiteSpecific(conn,"DS","DS_MENU_TYPE");
		PreparedStatement pstmt=null;
		PreparedStatement pstmt_FoodItem=null;
		PreparedStatement pstmt_splFoodItem=null;
	
		ResultSet rs=null;
		ResultSet rs_FoodItem = null;
		ResultSet rs_splFoodItem = null;
		
		log.debug("declaration:");
		JSONObject jsonList = new JSONObject();
		//Added Against ML-MMOH-CRF-0674 Starts Here
		String diettype_auto=request.getParameter("diettype_auto");
		diettype_auto=diettype_auto+"%";
		System.err.println("OP Patient:===="+diettype_auto);
		System.out.println("OP Patient:===="+diettype_auto);
		//Added Against ML-MMOH-CRF-0674 Ends Here
		
		try{
			log.debug("getting request parameters1::");
			//Getting inputs:
				String jsonData = request.getParameter("jsonData");
				JSONObject json = new JSONObject(jsonData);		
				log.debug("getting request parameters::");
				String facilityid =  json.getString("facilityid");
				String speciality =  json.getString("speciality");
				log.debug("getting jsonarray::1");
				//JSONArray arrMealOrder=json.getJSONArray("mealorderObj");
				log.debug("getting jsonarray::2");
				StringBuffer sbAppt = new StringBuffer();
				StringBuffer sbEnct = new StringBuffer();
				log.debug("getting jsonarray::3");
				
				JSONArray arrEnctOrder=json.getJSONArray("enctObj");
				for (int i = 0; i < arrEnctOrder.length(); i++){
					String sEnct =	arrEnctOrder.getString(i);
					sbEnct.append("'" + sEnct+"',");
				}	
				
				JSONArray arrApptOrder=json.getJSONArray("apptObj");
				for (int i = 0; i < arrApptOrder.length(); i++){
					String sAppt =	arrApptOrder.getString(i);
					sbAppt.append("'" + sAppt+"',");
				}	
				
				String sApptList = sbAppt.toString();
				String sEnctList = sbEnct.toString();
				
				if(!"".equalsIgnoreCase(sApptList))
					sApptList = sApptList.substring(0, sApptList.length()-1);
				else
					sApptList = "''";
				
				if(!"".equalsIgnoreCase(sEnctList))
					sEnctList = sEnctList.substring(0, sEnctList.length()-1);
				else
					sEnctList ="''";
				
				log.debug("done");
				log.debug(facilityid);
				log.debug("speciality"+speciality);
				log.debug("sbEnct:"+sApptList);
				log.debug("sbAppt:"+sEnctList);
				
				StringBuffer sbLoadMealOrderResult = new StringBuffer();
				sbLoadMealOrderResult.append("select appt.patient_id as patient_id, appt.patient_name as patient_name, to_char(appt.appt_date, 'dd/mm/yyyy') as apptDate, nvl(to_char(appt.appt_time,'hh24:mi'),' ') as appt_time, appt.appt_ref_no as apptNo, ");
				sbLoadMealOrderResult.append("appt.encounter_id as encounterid , to_char(to_date('', 'DD/MM/YYYY'),'DD/MM/YYYY') as visitDate, to_char(appt.appt_date, 'dd/mm/yyyy') as servingDate, opdiethdr.DIETTYPE, opdietdtl.MEALTYPE, opdiethdr.REMARKS, opdiethdr.Modified_YN ");
				sbLoadMealOrderResult.append("	,opdiethdr.PREP_INSTR 	");//vikash for DS CRF-417
				sbLoadMealOrderResult.append(",opdiethdr.MENU_TYPE  ");//CRF-684
				sbLoadMealOrderResult.append("from oa_appt appt,  mp_patient mp, DS_OP_DIET_ORDER_DTL opdietdtl, DS_OP_DIET_ORDER_HDR opdiethdr ");
				sbLoadMealOrderResult.append("where  appt.FACILITY_ID like NVL(?,  '%%') ");//INC:49184
				sbLoadMealOrderResult.append("and appt.appt_status='1'  ");
				sbLoadMealOrderResult.append("and mp.patient_id(+) = appt.patient_id ");
				sbLoadMealOrderResult.append("and appt.appt_ref_no IN("+ sApptList +") ");
				sbLoadMealOrderResult.append("and appt.appt_ref_no = opdietdtl.App_No(+) ");  
				sbLoadMealOrderResult.append("and appt.FACILITY_ID = opdietdtl.FACILITY_ID(+) "); 
				sbLoadMealOrderResult.append("and appt.appt_ref_no = opdiethdr.App_No(+)  ");
				sbLoadMealOrderResult.append("and appt.FACILITY_ID = opdiethdr.FACILITY_ID(+) "); 
				sbLoadMealOrderResult.append("union ");
				sbLoadMealOrderResult.append("select enct.patient_id as patient_id, mp.patient_name as patient_name, to_char(appt.appt_date, 'dd/mm/yyyy') as apptDate, nvl(to_char(appt.appt_time,'hh24:mi'),' ') as appt_time, appt.appt_ref_no as apptNo, "); 
				sbLoadMealOrderResult.append("appt.encounter_id as encounterid, to_char(enct.visit_adm_date_time, 'dd/mm/yyyy HH24:MI') as visitDate, to_char(enct.visit_adm_date_time, 'dd/mm/yyyy') as servingDate, opdiethdr.DIETTYPE, opdietdtl.MEALTYPE, opdiethdr.REMARKS, opdiethdr.Modified_YN ");
				sbLoadMealOrderResult.append("	,opdiethdr.PREP_INSTR 	");//vikash for DS CRF-417
				sbLoadMealOrderResult.append("	,opdiethdr.MENU_TYPE 	");// CRF-684
				sbLoadMealOrderResult.append("from oa_appt appt, pr_encounter enct, mp_patient mp, DS_OP_DIET_ORDER_DTL opdietdtl, DS_OP_DIET_ORDER_HDR opdiethdr ");
				sbLoadMealOrderResult.append("where appt.FACILITY_ID like NVL(?, '%%') ");//INC:49184
				sbLoadMealOrderResult.append("and appt.Encounter_id =  enct.Encounter_id ");
				sbLoadMealOrderResult.append("and  appt.FACILITY_ID = enct.facility_id ");
				sbLoadMealOrderResult.append(" and enct.APPT_ID IN("+ sApptList +") ");
				sbLoadMealOrderResult.append("and enct.patient_id = mp.patient_id and enct.patient_class='OP' ");
				sbLoadMealOrderResult.append("and appt.appt_ref_no = enct.APPT_ID ");
				sbLoadMealOrderResult.append("and appt.appt_ref_no = opdietdtl.App_No(+) ");  
				sbLoadMealOrderResult.append("and appt.FACILITY_ID = opdietdtl.FACILITY_ID(+) "); 
				sbLoadMealOrderResult.append("and appt.appt_ref_no = opdiethdr.App_No(+)  ");
				sbLoadMealOrderResult.append("and appt.FACILITY_ID = opdiethdr.FACILITY_ID(+) "); 
				sbLoadMealOrderResult.append("and enct.appt_case_yn = 'A' ");
				sbLoadMealOrderResult.append("Union ");
				sbLoadMealOrderResult.append("select mp.patient_id as patient_id, mp.patient_name as patient_name, to_char(to_date('', 'DD/MM/YYYY'),'DD/MM/YYYY') as apptDate, '' as appt_time, '' as apptNo, ");  
				sbLoadMealOrderResult.append("enct.encounter_id as encounterid, to_char(enct.visit_adm_date_time, 'dd/mm/yyyy hh24:mi') as visitDate, to_char(enct.visit_adm_date_time, 'dd/mm/yyyy') as servingDate, opdiethdr.DIETTYPE, opdietdtl.MEALTYPE, opdiethdr.REMARKS, opdiethdr.Modified_YN ");
				sbLoadMealOrderResult.append("	,opdiethdr.PREP_INSTR 	");//vikash for DS CRF-417
				sbLoadMealOrderResult.append("	,opdiethdr.MENU_TYPE 	");//CRF-684
				sbLoadMealOrderResult.append("from pr_encounter enct, mp_patient mp, DS_OP_DIET_ORDER_DTL opdietdtl, DS_OP_DIET_ORDER_HDR opdiethdr ");
				sbLoadMealOrderResult.append("where enct.FACILITY_ID like NVL(?, '%%') ");//INC:49184
				sbLoadMealOrderResult.append("and visit_status IN('01','02','03','04','07') ");
				sbLoadMealOrderResult.append("and enct.appt_case_yn = 'W' ");
				sbLoadMealOrderResult.append("and mp.patient_id = enct.patient_id and enct.patient_class='OP' ");
				sbLoadMealOrderResult.append("and enct.Encounter_id IN("+ sEnctList +") ");
				sbLoadMealOrderResult.append("and enct.FACILITY_ID = opdietdtl.FACILITY_ID(+) "); 
				sbLoadMealOrderResult.append("and enct.encounter_ID= opdietdtl.encounter_ID(+) ");
				sbLoadMealOrderResult.append("and enct.FACILITY_ID = opdiethdr.FACILITY_ID(+) ");
				sbLoadMealOrderResult.append("and enct.encounter_ID= opdiethdr.encounter_ID(+) ");
				sbLoadMealOrderResult.append(" order by visitDate desc, apptDate desc, appt_time desc, apptNo desc ");
				
				String query_mealOrderResult = sbLoadMealOrderResult.toString(); 
				System.err.println("855,query_mealOrderResult--->"+query_mealOrderResult);
				//String query_loadDiettype = "select distinct diet_type, ds_get_desc.ds_diet_type(diet_type,?,'2') sdesc from DS_DIET_TYPE where eff_status = 'E'";// commented against ML-MMOH-SCF-0542
				//Commented against ML-MMOH-CRF-	
				//String query_loadDiettype = "select diet_type, ds_get_desc.ds_diet_type(diet_type,?,'2') sdesc from DS_DIET_TYPE where eff_status = 'E'";//added against ML-MMOH-SCF-0542
				//Modified against ML-MMOH-CRF-0418 and ML-MMOH-CRF-0674
				String query_loadDiettype = "select diet_type, ds_get_desc.ds_diet_type(diet_type,?,'2') sdesc from DS_DIET_TYPE where eff_status = 'E' AND OP_DIET_TYPE_YN ='Y'  AND SHORT_DESC LIKE '"+diettype_auto+"' ORDER BY LOWER (sdesc)";
				
				//Getting Menu TYpe CRF-684
				if(isMenuType){
				int defaultcount=0;
                String sql_Menu_Count="SELECT count(*)defaultcount FROM ds_menu_type where eff_status ='E' and appl_for_op_yn ='Y' AND DEFAULT_YN='Y'";
				pstmt = conn.prepareStatement(sql_Menu_Count);
				rs	= pstmt.executeQuery();
				if(rs.next()){
					defaultcount=rs.getInt("defaultcount");
				}		
				if(pstmt!=null) pstmt.close();	//Added Against Common-ICN-0031
				if(rs!=null) rs.close();	//Added Against Common-ICN-0031
				String query_loadMenu_type ="SELECT menu_type,short_desc,DEFAULT_YN FROM ds_menu_type where eff_status ='E' and appl_for_op_yn ='Y' ORDER BY short_desc asc";
				pstmt = conn.prepareStatement(query_loadMenu_type);
				rs = pstmt.executeQuery();
				while(rs != null && rs.next())
				{
					JSONObject jsonMenuList= new JSONObject();
					jsonMenuList.put("menuCode",rs.getString("menu_type"));
					jsonMenuList.put("shortDesc",rs.getString("short_desc"));
					jsonMenuList.put("DEFAULT_YN",rs.getString("DEFAULT_YN"));
					jsonMenuList.put("defaultcount",defaultcount);
					jsonList.append("jsonMenuList",jsonMenuList);					
				}
					if(pstmt!=null) pstmt.close();	//Added Against Common-ICN-0031
					if(rs!=null) rs.close();	//Added Against Common-ICN-0031
				}
				//String query_mealType = "select distinct meal_type, ds_get_desc.ds_meal_type(meal_type,?,'2') short_desc FROM ds_meal_type  where eff_status = 'E' and opmealorder_yn = 'Y'  order by meal_order asc  ";// commented against ML-MMOH-SCF-0542
				//String query_mealType = "select meal_type, ds_get_desc.ds_meal_type(meal_type,?,'2') short_desc ,SERVING_START_TIME_OP,SERVING_END_TIME_OP,IRREGULAR_START_TIME_OP,IRREGULAR_END_TIME_OP, meal_order FROM ds_meal_type  where eff_status = 'E' and opmealorder_yn = 'Y'  order by meal_order asc  ";//Commented Against ML-MMOH-CRF-0825
				String query_mealType = "SELECT c.meal_type, ds_get_desc.ds_meal_type (c.meal_type, ?,'2') short_desc, serving_start_time_op, serving_end_time_op, irregular_start_time_op, irregular_end_time_op, meal_order, NVL((SELECT serving_start_time_op FROM ds_meal_type_lang_vw a WHERE a.meal_order = (SELECT MIN (b.meal_order) FROM ds_meal_type_lang_vw b WHERE b.serving_start_time_op IS NOT NULL AND b.meal_order > c.meal_order) AND a.language_id = ?), '23:59') next_serving_start_time_OP FROM ds_meal_type c where eff_status = 'E' and  opmealorder_yn = 'Y' order by c.meal_order";//Modified Against ML-MMOH-CRF-0825
				
				//String query_kitchen = "select kitchen_code, short_desc from ds_speciality_kitchen_vw where OPERATING_FACILITY_ID = ? and speciality_code=? ";
				String query_kitchen = "SELECT KITCHEN_CODE AS KITCHEN_CODE, KITCHEN_DESC AS KITCHEN_DESC FROM ds_speciality_kitchen_vw WHERE OPERATING_FACILITY_ID = ? and speciality_code=?"; 
				
				//Getting Meal type::
				pstmt = conn.prepareStatement(query_mealType);
				pstmt.setString(1, language_id);
				pstmt.setString(2, language_id);//Added Against ML-MMOH-CRF-0825 
				rs = pstmt.executeQuery();
				
				//HashMap hMealList = new HashMap() ;
				HashMap hMealKeyList = new HashMap() ;
				int i=0;
			while(rs != null && rs.next())
			{
				JSONObject jsonMealList= new JSONObject();
				jsonMealList.put("mealType",rs.getString("meal_type"));
				jsonMealList.put("shortDesc",rs.getString("short_desc"));
				//Added Against ML-MMOH-CRF-0825 Starts Here
				jsonMealList.put("ServingStartTimeOP",rs.getString("SERVING_START_TIME_OP"));
				jsonMealList.put("ServingEndTimeOP",rs.getString("SERVING_END_TIME_OP"));
				jsonMealList.put("IrregularStartTimeOP",rs.getString("IRREGULAR_START_TIME_OP"));
				jsonMealList.put("IrregularEndTimeOP",rs.getString("IRREGULAR_END_TIME_OP"));
				jsonMealList.put("MealOrderOP",rs.getString("MEAL_ORDER"));
				jsonMealList.put("nextServingStartTimeOP",rs.getString("NEXT_SERVING_START_TIME_OP"));
				//Added Against ML-MMOH-CRF-0825 Ends Here
				jsonList.append("jsonMealList", jsonMealList);
				hMealKeyList.put(i, rs.getString("meal_type"));
				i++;
			}
				if(pstmt!=null) pstmt.close();	//Added Against Common-ICN-0031
				if(rs!=null) rs.close();	//Added Against Common-ICN-0031
				//Getting patient details for placing meal order::
				pstmt = conn.prepareStatement(query_mealOrderResult);
				pstmt.setString(1, facilityid);
				pstmt.setString(2, facilityid);
				pstmt.setString(3, facilityid);
				rs = pstmt.executeQuery();
				
				log.debug("Getting Records::");
				HashMap hAppt_Enct = new HashMap();
				JSONObject jsonMealTypeList = new JSONObject();
				while(rs != null && rs.next())
				{
					if( hAppt_Enct.get( rs.getString("encounterid") ) != null )
					{
						log.debug("encounter id ::");
						//if( jsonMealTypeList.get(rs.getString("encounterid")) != null )
						{
								//JSONArray tmpJsonMealValueList =  (JSONArray) jsonMealTypeList.get(rs.getString("encounterid"));
								//tmpJsonMealValueList.put(rs.getString("mealtype"));
								jsonMealTypeList.append("enct" + rs.getString("encounterid"), rs.getString("mealtype"));
						}
								
						//jsonMealTypeList.append(rs.getString("encounterid"), rs.getString("mealtype"));
					}
					else if( hAppt_Enct.get( rs.getString("apptNo") ) != null )
					{
						log.debug("appt no::");
						//jsonMealTypeList.append(rs.getString("apptNo"), rs.getString("mealtype"));
						//if( jsonMealTypeList.get(rs.getString("apptNo")) != null )
						{
								//JSONArray tmpJsonMealValueList =  (JSONArray) jsonMealTypeList.get(rs.getString("apptNo"));
								//tmpJsonMealValueList.put( rs.getString("mealtype"));
//								jsonMealTypeList.append(rs.getString("apptNo"), tmpJsonMealValueList);
								jsonMealTypeList.append("appt" + rs.getString("apptNo"), rs.getString("mealtype"));
						}
					}	
					else
					{
						JSONObject jsonRecord= new JSONObject();
						jsonRecord.put("patientId", 	isNULL(rs.getString("patient_id")));
						jsonRecord.put("patientName", 	isNULL(rs.getString("patient_name")));
						//jsonRecord.put("apptDate", 		isNULL(rs.getString("apptDate")));
						//jsonRecord.put("visitDate", 	isNULL(rs.getString("visitDate")));
						jsonRecord.put("apptDate", 		com.ehis.util.DateUtils.convertDate(rs.getString("apptDate"),"DMY","en",language_id));
						jsonRecord.put("visitDate", 	com.ehis.util.DateUtils.convertDate(rs.getString("visitDate"),"DMYHM","en",language_id));
						jsonRecord.put("apptTime", 		rs.getString("appt_time"));
						jsonRecord.put("apptno", 		isNULL(rs.getString("apptNo")));
						jsonRecord.put("servingDate", 	isNULL(rs.getString("servingDate")));
						jsonRecord.put("encounterid", 	isNULL(rs.getString("encounterid")));
						jsonRecord.put("diettype", 		isNULL(rs.getString("diettype")));
						
						//jsonMealTypeList.append(rs.getString("apptNo"), rs.getString("mealtype"));
						
						log.debug("apptno:"+ rs.getString("apptNo"));
						log.debug("encounterid:"+ rs.getString("encounterid"));
						
						if(rs.getString("apptNo") != null)
						{
							hAppt_Enct.put(rs.getString("apptNo"), "");
							jsonMealTypeList.append("appt"+rs.getString("apptNo"), rs.getString("mealtype"));
						}else if(rs.getString("encounterid") != null)
						{
							hAppt_Enct.put(rs.getString("encounterid"), "");
							jsonMealTypeList.append("enct"+rs.getString("encounterid"),  rs.getString("mealtype"));
						}
						
						//jsonRecord.put("remarks", 		isNULL(rs.getString("remarks")));
						jsonRecord.put("remarks", 		isNULL(rs.getString("remarks")));
						jsonRecord.put("prepartoryInstr", isNULL(rs.getString("PREP_INSTR")));	//vikash for DS CRF-417
						if(isMenuType){
							jsonRecord.put("menuType",      isNULL(rs.getString("menu_type")));	//CRF-684
						}
						else {
							jsonRecord.put("menuType",     "" );	//CRF-684	
						}
//						jsonRecord.put("remarks2", 		URLEncoder.encode(isNULL(rs.getString("remarks"))) );
						jsonRecord.put("modifiedFlag", 	isNULL(rs.getString("Modified_YN")));
						
						//Getting Food Dislike::
						String sFilterQuery_FITM = "";
						if(rs.getString("apptNo") != null)
							sFilterQuery_FITM = " and FDITM.app_No = NVL(?, FDITM.app_No) " ;
						else
							sFilterQuery_FITM = " and FDITM.encounter_id = NVL(?, FDITM.encounter_id) " ;
						
						String query_foodDislike = "select DSITM.FOOD_ITEM_CODE ITMCODE, DSITM.SHORT_DESC ITMDESC from DS_PATIENT_OP_FOOD_DISLIKES FDITM, DS_ITEMS DSITM " +
								" WHERE FDITM.facility_id = ? "+ sFilterQuery_FITM +" and FDITM.ITEM_CODE = DSITM.FOOD_ITEM_CODE AND DSITM.LANGUAGE_ID = '"+language_id+"'";
						
						pstmt_FoodItem = conn.prepareStatement(query_foodDislike);
						pstmt_FoodItem.setString(1, facilityid);
						if(rs.getString("apptNo") != null)
							pstmt_FoodItem.setString(2, rs.getString("apptNo"));
						else
							pstmt_FoodItem.setString(2, rs.getString("encounterid"));
						
						rs_FoodItem = pstmt_FoodItem.executeQuery();
						JSONObject jsonFoodList= new JSONObject();
						log.debug("gettig food dislike item::");
						while(rs_FoodItem != null && rs_FoodItem.next())
						{
							ArrayList arrFoodDislikeItem = new ArrayList();
							arrFoodDislikeItem.add(0, rs_FoodItem.getString("ITMCODE") );
							arrFoodDislikeItem.add(1, rs_FoodItem.getString("ITMDESC") );
							arrFoodDislikeItem.add(2, "0" );
							jsonFoodList.append("jsonFoodItem", 	arrFoodDislikeItem); 
						}
						jsonRecord.put("jsonFoodList",jsonFoodList);
						
						//Getting Special FoodItem::
						String sFilterQuery = "";
						if(rs.getString("apptNo") != null)
							sFilterQuery = " and ITM.app_No = NVL(?, ITM.app_No) " ;
						else
							sFilterQuery = " and ITM.encounter_id = NVL(?, ITM.encounter_id) " ;
						
						String query_splFooditem = "select ITM.ITEM_TYPE itemType, ITEMTYPE.SHORT_DESC itemDesc, DSITEMS.FOOD_ITEM_CODE itemCode, DSITEMS.SHORT_DESC foodDesc, ITM.QUANTITY itemQty, "+  
						" ITM.MEAL_TYPE mealType, MEALTYPE.SHORT_DESC mealDesc , TO_CHAR(DSITEMS.CALORIFIC_CONT_PER_UOM,'999999.99') cUOM, PARAM.ENERGY_UOM eUOM, AM_GET_DESC.AM_UOM(ENERGY_UOM,'"+language_id+"',2) ENERGY_UOM_DESC "+
						" from DS_OP_DIET_SPL_ITEMS ITM, DS_ITEMS DSITEMS, DS_PARAM PARAM, ds_meal_type_lang_vw MEALTYPE, ds_item_type_lang_vw ITEMTYPE where facility_id = ? " + 
						sFilterQuery + " and DSITEMS.FOOD_ITEM_CODE =ITM.ITEM_CODE and DSITEMS.LANGUAGE_ID = '"+language_id+"' and "+ 
						" MEALTYPE.MEAL_TYPE = ITM.MEAL_TYPE and ITM.ITEM_TYPE =ITEMTYPE.ITEM_TYPE and MEALTYPE.LANGUAGE_ID = '"+language_id+"' and ITEMTYPE.LANGUAGE_ID = '"+language_id+"' "; //Modified Against PMG2017-COMN-CRF-0012.1[IN:067191](Outpatients Patients )
						
						pstmt_splFoodItem = conn.prepareStatement(query_splFooditem);
						pstmt_splFoodItem.setString(1, facilityid);
						if(rs.getString("apptNo") != null)
							pstmt_splFoodItem.setString(2, rs.getString("apptNo"));
						else
							pstmt_splFoodItem.setString(2, rs.getString("encounterid"));
						
						
						rs_splFoodItem = pstmt_splFoodItem.executeQuery();
						JSONObject jsonSplFoodList= new JSONObject();
						while(rs_splFoodItem != null && rs_splFoodItem.next())
						{
							ArrayList arrSplFoodItem = new ArrayList();
							arrSplFoodItem.add(0, rs_splFoodItem.getString("itemType") );
							arrSplFoodItem.add(1, rs_splFoodItem.getString("itemCode") );
							arrSplFoodItem.add(2, rs_splFoodItem.getString("itemQty") );
							arrSplFoodItem.add(3, rs_splFoodItem.getString("foodDesc") );
							arrSplFoodItem.add(4, rs_splFoodItem.getString("itemDesc") );
							arrSplFoodItem.add(5, rs_splFoodItem.getString("mealType") );
							arrSplFoodItem.add(6, rs_splFoodItem.getString("mealDesc") );
							arrSplFoodItem.add(7, "0" );
							arrSplFoodItem.add(8, rs_splFoodItem.getString("cUOM"));
							arrSplFoodItem.add(9, rs_splFoodItem.getString("eUOM") );
							arrSplFoodItem.add(10, rs_splFoodItem.getString("ENERGY_UOM_DESC") ); //Added Against PMG2017-COMN-CRF-0012.1[IN:067191]
							jsonSplFoodList.append("jsonSplFoodItem", 	arrSplFoodItem);
						}
						jsonRecord.put("jsonSplFoodList",jsonSplFoodList);
						jsonList.append("jsonOrderList", jsonRecord);
					}
				}
				jsonList.append("jsonMealTypeList", jsonMealTypeList);
				log.debug("Getting Diet type::");
				//Common-ICN-0044
				if(pstmt!=null) pstmt.close();	
				if(rs!=null) rs.close();
				//Common-ICN-0044
				//Getting Diet type::
				pstmt = conn.prepareStatement(query_loadDiettype);
				pstmt.setString(1, language_id);
				rs = pstmt.executeQuery();
				//JSONObject jsonDietList= new JSONObject();
				while(rs != null && rs.next())
				{
					JSONObject jsonDietList= new JSONObject();
					jsonDietList.put("DietCode",rs.getString("diet_type"));
					jsonDietList.put("DietDesc",rs.getString("sdesc"));
					jsonList.append("jsonDietList", jsonDietList);
				}
			if(pstmt!=null) pstmt.close();	//Added Against Common-ICN-0031
			if(rs!=null) rs.close();	//Added Against Common-ICN-0031				
				//JSONObject jsonDietList= new JSONObject();			
				
				log.debug("Getting Kitchen::");
				
				//Getting Kitchen::
				pstmt = conn.prepareStatement(query_kitchen);
				pstmt.setString(1, facilityid);
				pstmt.setString(2, speciality);
				
				rs = pstmt.executeQuery();
				while(rs != null && rs.next())
				{
					jsonList.append("jsonKitchenCode", rs.getString("KITCHEN_CODE"));
					jsonList.append("jsonKitchenDesc", rs.getString("KITCHEN_DESC"));
				}
			}
			catch(Exception ee){
				System.err.println("PlaceMealOrderOPServlet.java-1090-->"+ee.getMessage());
			}
			finally{
				try{
					if(rs!=null) rs.close();
					if(pstmt!=null) pstmt.close();
					
					if(rs_FoodItem!=null) rs_FoodItem.close();
					if(pstmt_FoodItem!=null) pstmt_FoodItem.close();
					
					if(rs_splFoodItem!=null) rs_splFoodItem.close();
					if(pstmt_splFoodItem!=null) pstmt_splFoodItem.close();
					
					if(conn!=null)ConnectionManager.returnConnection(conn,request);
				}catch(Exception e){
				System.err.println("PlaceMealOrderOPServlet.java--1104->"+e.getMessage());
				}
			}
			return jsonList;
	}
	
	private String isNULL(String obj)
	{
		if(obj == null)
			return  "";
		else
			return obj;
	}
	
	/**Method Desc: Check if the selected appointments are cancelled:: **/
	private JSONObject chkCanceledAppt(HttpServletRequest request,  HttpServletResponse response)
	{
		
		Connection conn = ConnectionManager.getConnection(request);
		PreparedStatement pstmt=null;
		
		ResultSet rs=null;
		
		log.debug("declaration:");
		JSONObject jsoninvalidOrderList = new JSONObject();
		try{
			log.debug("getting request parameters1::");
			//Getting inputs:
				String jsonData = request.getParameter("jsonData");
				JSONObject json = new JSONObject(jsonData);		
				log.debug("getting request parameters::");
				//JSONArray arrMealOrder=json.getJSONArray("mealorderObj");
				log.debug("getting jsonarray::2");
				StringBuffer sbAppt = new StringBuffer();
				StringBuffer sbEnct = new StringBuffer();
				log.debug("getting jsonarray::3");
				
				JSONArray arrEnctOrder=json.getJSONArray("enctObj");
				for (int i = 0; i < arrEnctOrder.length(); i++){
					String sEnct =	arrEnctOrder.getString(i);
					sbEnct.append("'" + sEnct+"',");
				}	
				
				JSONArray arrApptOrder=json.getJSONArray("apptObj");
				for (int i = 0; i < arrApptOrder.length(); i++){
					String sAppt =	arrApptOrder.getString(i);
					sbAppt.append("'" + sAppt+"',");
				}	
				
				String sApptList = sbAppt.toString();
				String sEnctList = sbEnct.toString();
				
				if(!"".equalsIgnoreCase(sApptList))
					sApptList = sApptList.substring(0, sApptList.length()-1);
				else
					sApptList = "''";
				
				if(!"".equalsIgnoreCase(sEnctList))
					sEnctList = sEnctList.substring(0, sEnctList.length()-1);
				else
					sEnctList ="''";
				
				String query_EnctList = "select encounter_id, appt_id, patient_id from pr_encounter where facility_id = ? and visit_status IN('99','09') and encounter_id IN("+ sEnctList +") ";
				String query_ApptList = "select APPT_REF_NO from oa_appt_del_tr where facility_id = ? and APPT_REF_NO IN("+ sApptList +") and APPT_REF_NO NOT IN(select distinct APPT_REF_NO from oa_appt) ";
				
				//Get the appointment list which is cancelled:
				pstmt = conn.prepareStatement(query_ApptList);
				pstmt.setString(1, facility_id);
				
				rs = pstmt.executeQuery();
				
				while(rs != null && rs.next())
				{
					jsoninvalidOrderList.append("apptList", rs.getString("APPT_REF_NO"));
				}
				if(pstmt!=null) pstmt.close();	//Added Against Common-ICN-0031
				if(rs!=null) rs.close();	//Added Against Common-ICN-0031
				//Get the encounter list whose visit is cancelled:
				pstmt = conn.prepareStatement(query_EnctList);
				pstmt.setString(1, facility_id);
				
				rs = pstmt.executeQuery();
				
				while(rs != null && rs.next())
				{
					JSONObject jsonEnctList = new JSONObject();
				
					jsonEnctList.put("encounter_id", rs.getString("encounter_id"));
					jsonEnctList.put("patient_id", rs.getString("patient_id"));
					jsonEnctList.put("appt_id", isNULL(rs.getString("appt_id")) );
					jsoninvalidOrderList.append("enctList",jsonEnctList);
				}
				
		}catch(Exception ee){
			System.err.println("PlaceMealOrderOPServlet.java-1196-->"+ee.getMessage());
		}
		finally{
			try{
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null)ConnectionManager.returnConnection(conn,request);
			}catch(Exception e){System.err.println("PlaceMealOrderOPServlet.java-1203-->"+e.getMessage());}
		}
		return jsoninvalidOrderList;
		
	}
		
	/**Method Desc: Insert/ Updating Meal Order for Outpatient based on the user inputs **/
	private boolean insertOPMealOrder(HttpServletRequest request,  HttpServletResponse response)
	{
		//CRF-0684
		boolean isMenuType =false;
		Connection conn = ConnectionManager.getConnection(request);
        isMenuType = CommonBean.isSiteSpecific(conn,"DS","DS_MENU_TYPE");
		boolean bReturn = false;
		String patientId, patientName= "";
		String apptDate, visitDate, servingDate= "";
		String kitchen, apptNo,enctId= "";
		String dietTypes, remarks, modFlag = "";
		String PREP_INSTR="";//vikash added against for CRF-417
		String menu_type ="";//CRF-0684
		String exFoodDislike = "0";
		JSONArray mealtypes;
		JSONArray foodDislike;
		JSONArray splFoodItems;
		
	//	Connection conn = null;
		PreparedStatement pstmt=null;
		//ResultSet rs=null;	//Common-ICN-0044
		boolean rslt = false;
		try
		{	
			//Getting Inputs ::
			String jsonData = request.getParameter("jsonData");
			kitchen = request.getParameter("hdnkitchen");
			JSONObject jsonobj = new JSONObject(jsonData);		
			JSONArray mealOrderArray=jsonobj.getJSONArray("mealOrders");
			log.debug("insertOPMealOrder::");
			//conn = ConnectionManager.getConnection(request);
			
			//Queries::
			
			for(int i=0;i<mealOrderArray.length();i++) {
				JSONObject obj=mealOrderArray.getJSONObject(i);
				JSONObject rowMealOrderObj=obj.getJSONObject("rowmealOrder");
				patientId	=	rowMealOrderObj.getString("patientId").trim();
				patientName	=	rowMealOrderObj.getString("patientName").trim();
				apptDate	=	rowMealOrderObj.getString("apptDate").trim();
				visitDate	=	rowMealOrderObj.getString("visitDate").trim();
				servingDate = 	rowMealOrderObj.getString("servingDate").trim();
				apptNo		=	rowMealOrderObj.getString("apptNo").toString().trim();
				enctId		=	rowMealOrderObj.getString("enctId").trim();
				dietTypes	=	rowMealOrderObj.getString("dietTypes").trim();
				//remarks		=	rowMealOrderObj.getString("remarks").trim();
				remarks		=	URLDecoder.decode(rowMealOrderObj.getString("remarks").trim(), "UTF-8"); // Lang-support for Remarks
				PREP_INSTR	=	URLDecoder.decode(rowMealOrderObj.getString("prepartoryInstr").trim(), "UTF-8"); //CRF-417
				if(isMenuType){
				menu_type  =    rowMealOrderObj.getString("menuType").trim(); //CRF-684
				System.err.println("Inside, menu_type===>"+menu_type);
				}
				System.err.println("Outside, menu_type===>"+menu_type);
				modFlag		=	rowMealOrderObj.getString("modFlag").toString().trim();
				foodDislike		=	rowMealOrderObj.getJSONArray("foodDislike");
				splFoodItems	=	rowMealOrderObj.getJSONArray("splFoodItem");
				mealtypes		=	rowMealOrderObj.getJSONArray("mealTypes");
			
				log.debug("insertOPMealOrder::patientId"+patientId);
				log.debug("insertOPMealOrder::patientName"+patientName);
				log.debug("modFlag::s"+modFlag+"e");
				if(modFlag == null)
					log.debug("modFlag::null");
				else if(modFlag != "")
					log.debug("modFlag::not null");
				
				if("".equalsIgnoreCase(modFlag)) //Insertion of New Records::
				{
					// Insert Transaction start:
					//Table 1 - OPMealHdr::
					pstmt = conn.prepareStatement(DlQuery.DL_INSERT_OPMEALORDERHDR);
					//Facility_Id, Patient_Id, Encounter_Id, App_No, Seving_date, Kitchen, DietType, Remarks, Modified_YN,
					//ADDED_BY_ID, ADDED_DATE, ADDED_FACILITY_ID, ADDED_AT_WS_NO, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_FACILITY_ID, MODIFIED_AT_WS_NO) 
					pstmt.setString(1, facility_id);
					pstmt.setString(2, patientId);
					pstmt.setString(3, enctId);
					pstmt.setString(4, apptNo);
					pstmt.setString(5, servingDate);
					pstmt.setString(6, kitchen);
					pstmt.setString(7, dietTypes);
					pstmt.setString(8, remarks);
					pstmt.setString(9, "N");
					pstmt.setString(10, login_user);
					pstmt.setString(11, facility_id);
					pstmt.setString(12, str_client_ip_address);
					pstmt.setString(13, login_user);
					pstmt.setString(14, facility_id);
					pstmt.setString(15, str_client_ip_address);
					pstmt.setString(16, PREP_INSTR);//vikash added against for CRF-417
					if(isMenuType){
					pstmt.setString(17, menu_type);//CRF-684
					}
					else{
					pstmt.setString(17, " ");//CRF-684
					}
					rslt = pstmt.execute();
					
					//Table 2 - OPMealDtl:
					rslt = insertMealTypes(conn, mealtypes, patientId, enctId, apptNo, servingDate, dietTypes, "N", null);
					
					
					//Table 3 - DL_INSERT_OPFOODDISLIKES
					rslt = insertFoodDislike(conn, foodDislike, exFoodDislike, patientId, enctId, apptNo);
				
										
					//Table 4 - DL_INSERT_OPSPLITEMS
					rslt = insertSplFoodItems(conn, splFoodItems, patientId, enctId, apptNo);
					
					
				}else //Updation of existing records::
				{
						//Updation of OPMealorder Header table:
						//if(!apptNo.isEmpty())
						if(!("".equalsIgnoreCase(apptNo)))
							pstmt = conn.prepareStatement(DlQuery.DL_UPDATE_OPMEALORDERHDR_APPT);
						else
							pstmt = conn.prepareStatement(DlQuery.DL_UPDATE_OPMEALORDERHDR_ENCT);

						pstmt.setString(1, dietTypes);
						pstmt.setString(2, remarks);
						pstmt.setString(3, "Y");
						pstmt.setString(4, PREP_INSTR);//CRF-417
						if(isMenuType){
						pstmt.setString(5, menu_type);//CRF-0684
						}
						else{
						pstmt.setString(5, " ");//CRF-0684
						}
						pstmt.setString(6, facility_id);

						//pstmt.setString(5, enctId);
						//if(!apptNo.isEmpty())

						if(!("".equalsIgnoreCase(apptNo)))
							pstmt.setString(7, apptNo);
						else
							pstmt.setString(7, enctId);

						pstmt.setString(8, kitchen);
						pstmt.execute();
							
						//Deletion of OPMealorder Detail table:
						//if(!apptNo.isEmpty())
						if(!("".equalsIgnoreCase(apptNo)))
							pstmt = conn.prepareStatement(DlQuery.DL_DELETE_OPMEALORDERDTL_APPT);
						else
							pstmt = conn.prepareStatement(DlQuery.DL_DELETE_OPMEALORDERDTL_ENCT);
						
						pstmt.setString(1, facility_id);
						//if(!apptNo.isEmpty())
						if(!("".equalsIgnoreCase(apptNo)))
							pstmt.setString(2, apptNo);
						else
							pstmt.setString(2, enctId);
						
						rslt = pstmt.execute();
							
						//Insertion of OPMealDtl:
						rslt = insertMealTypes(conn, mealtypes, patientId, enctId, apptNo, servingDate, dietTypes, "Y", null);
						
						//Deletion of Food Dislike table:
						//if(!apptNo.isEmpty())
						if(!("".equalsIgnoreCase(apptNo)))
							pstmt = conn.prepareStatement(DlQuery.DL_DELETE_OPFOODDISLIKES_APPT);
						else
							pstmt = conn.prepareStatement(DlQuery.DL_DELETE_OPFOODDISLIKES_ENCT);
						
						pstmt.setString(1, facility_id);
						
						//if(!apptNo.isEmpty())
						if(!("".equalsIgnoreCase(apptNo)))
							pstmt.setString(2, apptNo);
						else
							pstmt.setString(2, enctId);
						pstmt.execute();
						
						//Insertion of - DL_INSERT_OPFOODDISLIKES
						insertFoodDislike(conn, foodDislike, exFoodDislike, patientId, enctId, apptNo);
						
						//Deletion of SpecialFood Item  table:
						
						//if(!apptNo.isEmpty())
						if(!("".equalsIgnoreCase(apptNo)))
							pstmt = conn.prepareStatement(DlQuery.DL_DELETE_OPSPLITEMS_APPT);
						else
							pstmt = conn.prepareStatement(DlQuery.DL_DELETE_OPSPLITEMS_ENCT);
						
						pstmt.setString(1, facility_id);
						//if(!apptNo.isEmpty())
						if(!("".equalsIgnoreCase(apptNo)))
							pstmt.setString(2, apptNo);
						else
							pstmt.setString(2, enctId);
						pstmt.execute();
							
						//Insertion of - DL_INSERT_OPSPLITEMS
						rslt = insertSplFoodItems(conn, splFoodItems, patientId, enctId, apptNo);
						
				}
				
			}
			conn.commit();
			bReturn = true;

		}catch(Exception ee){
			bReturn = false;
			ee.printStackTrace(); 
			try {
				if(conn!=null) conn.rollback();
				}catch(SQLException e){
				e.printStackTrace(); 
				}
			System.err.println("PlaceMealOrderOPServlet.java-1400-->"+ee.getMessage());
		}
		finally{
			try{
				if(pstmt!=null) pstmt.close();
				if(conn!=null)ConnectionManager.returnConnection(conn,request);
			}catch(Exception e){
			System.err.println("PlaceMealOrderOPServlet.java-1406+-->"+e.getMessage());
			} 
		}
		return bReturn;
	}
	
	/**Method Desc: Insert/ Updating Food Dsilike for the given appt/Encounter id based on the user inputs **/
	private boolean insertFoodDislike( Connection conn, JSONArray foodDislike, String exFoodDislike, String patientId, String enctId, String apptNo) throws Exception
	{
		boolean rslt = true;
		PreparedStatement pstmt=null;
		JSONArray arrFoodItem = new JSONArray();
		try
		{
			for(int index=0;index<foodDislike.length();index++) {
					if(foodDislike.isNull(index))
						continue;
					arrFoodItem = foodDislike.getJSONArray(index);
					log.debug("arrfoodDislike:"+ arrFoodItem.get(0));
					if((arrFoodItem.length() < 3) || !"-1".equalsIgnoreCase( (arrFoodItem.get(2)).toString() ))
					{
						pstmt = conn.prepareStatement(DlQuery.DL_INSERT_OPFOODDISLIKES);
						//Facility_Id, Patient_Id, Encounter_Id, App_No, Item_Code, 
						//ADDED_BY_ID, ADDED_DATE, ADDED_FACILITY_ID, ADDED_AT_WS_NO, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_FACILITY_ID, MODIFIED_AT_WS_NO) 
						pstmt.setString(1, facility_id);
						pstmt.setString(2, patientId);
						pstmt.setString(3, enctId);
						pstmt.setString(4, apptNo);
						pstmt.setString(5, (String)arrFoodItem.get(0));
						pstmt.setString(6, login_user);
						pstmt.setString(7, facility_id);
						pstmt.setString(8, str_client_ip_address);
						pstmt.setString(9, login_user);
						pstmt.setString(10, facility_id);
						pstmt.setString(11, str_client_ip_address);
						rslt = pstmt.execute();
					}
					//if(!rslt)
					//	break;
			}
		}
		finally{
			try{
				if(pstmt!=null) pstmt.close();
			}catch(Exception e){System.err.println("PlaceMealOrderOPServlet.java-1449-->"+e.getMessage());} 
		}
		return rslt;
	}
	
	/**Method Desc: Insert/ Updating Meal Types for the given appt/Encounter id based on the user inputs **/
	private boolean insertMealTypes( Connection conn, JSONArray mealtypes, String patientId, String enctId, String apptNo, String servingDate, String dietTypes, String modFlag, String AckDate) throws Exception
	{
		boolean rslt = true;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm"); //Added Against ML-MOH-CRF-825
		try
		{
			/* Added Against Start ML-MOH-CRF-825 */
			String currentDate="",currentTime="",sysDateQuery="",mealTypeQuery="",IrrStartTime="",IrrEndTime="";	
			sysDateQuery = "select TO_CHAR (SYSDATE, 'DD/MM/YYYY') currentDate , TO_CHAR (SYSDATE, 'HH24:MI') currentTime from dual";
			pstmt = conn.prepareStatement(sysDateQuery);
			rs = pstmt.executeQuery();
			if(rs!= null && rs.next()){
				currentDate = rs.getString("currentDate");
				currentTime = rs.getString("currentTime");
			}
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			mealTypeQuery = "SELECT IRREGULAR_START_TIME_OP,IRREGULAR_END_TIME_OP FROM DS_MEAL_TYPE_LANG_VW  WHERE LANGUAGE_ID=? AND EFF_STATUS='E' AND meal_type = ?  ORDER BY MEAL_ORDER";	 		
			/* Added Against End ML-MOH-CRF-825 */	
			
			for(int index=0;index<mealtypes.length();index++){			
			/* Added Against Start ML-MOH-CRF-825 */	
			pstmt = conn.prepareStatement(mealTypeQuery);
			pstmt.setString(1,language_id);
			pstmt.setString(2,(String)mealtypes.get(index));
			rs = pstmt.executeQuery();
			while(rs!= null && rs.next()){
				IrrStartTime = (String)CommonBean.checkForNull(rs.getString(1));
				IrrEndTime = (String)CommonBean.checkForNull(rs.getString(2));
			}
			if(pstmt!=null) pstmt.close();
				if(rs!=null) rs.close();	//Common-ICN-0044
			String startDate = servingDate+" "+IrrStartTime;
			String endDate = currentDate+" "+IrrEndTime;
			String sysDate = currentDate+" "+currentTime;	
			if(opMealOrderYn.equalsIgnoreCase("Y") && startDate.length()==16 && endDate.length()==16 && sysDate.length()==16){
			irregular_flag_yn  = compareDatesByDateMethods(sdf, sdf.parse(endDate), sdf.parse(startDate),  sdf.parse(sysDate));			
			} 			
			if(irregular_flag_yn.equals("") || irregular_flag_yn.equals(null))
				irregular_flag_yn = "N";
			pstmt = conn.prepareStatement(DlQuery.DL_INSERT_OPMEALORDERDTL);
			/* Added Against End ML-MOH-CRF-825 */		

			pstmt.setString(1, facility_id);
			pstmt.setString(2, patientId);
			pstmt.setString(3, enctId);
			pstmt.setString(4, apptNo);
			pstmt.setString(5, servingDate);
			pstmt.setString(6, (String)mealtypes.get(index));
			pstmt.setString(7, dietTypes);
			pstmt.setString(8, "");
			pstmt.setString(9, AckDate);
			pstmt.setString(10, login_user);
			pstmt.setString(11, facility_id);
			pstmt.setString(12, str_client_ip_address);
			pstmt.setString(13, login_user);
			pstmt.setString(14, facility_id);
			pstmt.setString(15, str_client_ip_address);
			pstmt.setString(16, irregular_flag_yn);//Added Against ML-ML-MMOH-CRF-0825
			rslt = pstmt.execute();
			}	
		} catch(ParseException sqle){ //Added Against ML-MOH-CRF-825
			System.err.println("exception in sql insertMealTypes="+sqle.toString());
			sqle.printStackTrace();			
		} catch(Exception e){
		e.printStackTrace();
		System.err.println("exception in e insertMealTypes="+e.toString());
		}
		finally{
			try{
				if(pstmt!=null) pstmt.close();
				if(rs!=null) rs.close();
			}catch(Exception e){
			System.err.println("insertMealTypes.java-1638-->"+e.getMessage());
			e.printStackTrace();
			} 
		}
		return rslt;
	}
	
		/* Added Against Start ML-MOH-CRF-825 */
		public String compareDatesByDateMethods(DateFormat sdf2,java.util.Date endDate, java.util.Date startDate, java.util.Date sysDate) {
		if (endDate.after(sysDate) && startDate.before(sysDate)){			
			irregular_flag_yn = "Y";
		}
		else{
			irregular_flag_yn = "N";
		}
		return irregular_flag_yn;
		}	
		/* Added Against End ML-MOH-CRF-825 */

	/**Method Desc: Insert/ Updating Special Food Items for the given appt/Encounter id based on the user inputs **/
	private boolean insertSplFoodItems( Connection conn, JSONArray splFoodItems, String patientId, String enctId, String apptNo) throws Exception
	{
		boolean rslt = true;
		PreparedStatement pstmt=null;
		try
		{
			for(int index=0;index<splFoodItems.length();index++) {
				//log.debug("splFoodItems:" +splFoodItems.get(i));
				JSONArray arrFoodItem = splFoodItems.getJSONArray(index);
				log.debug("arrfoodDislike:"+ arrFoodItem.get(0));
				if(!"-1".equalsIgnoreCase( (arrFoodItem.get(7)).toString() ) )
				{
					pstmt = conn.prepareStatement(DlQuery.DL_INSERT_OPSPLITEMS);
					//Facility_Id, Patient_Id, Encounter_Id, App_No, Item_Type, Item_Code, Quantity, Meal_Type, 
					//ADDED_BY_ID, ADDED_DATE, ADDED_FACILITY_ID, ADDED_AT_WS_NO, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_FACILITY_ID, MODIFIED_AT_WS_NO) 
					pstmt.setString(1, facility_id);
					pstmt.setString(2, patientId);
					pstmt.setString(3, enctId);
					pstmt.setString(4, apptNo);
					pstmt.setString(5, arrFoodItem.get(0).toString());
					pstmt.setString(6, arrFoodItem.get(1).toString());
					pstmt.setString(7, arrFoodItem.get(2).toString());
					pstmt.setString(8, arrFoodItem.get(5).toString());
					pstmt.setString(9, login_user);
					pstmt.setString(10, facility_id);
					pstmt.setString(11, str_client_ip_address);
					pstmt.setString(12, login_user);
					pstmt.setString(13, facility_id);
					pstmt.setString(14, str_client_ip_address);
					rslt = pstmt.execute();
				}	
			}
		}
		finally{
			try{
				if(pstmt!=null) pstmt.close();
			}catch(Exception e){System.err.println("PlaceMealOrderOPServlet.java--1528->"+e.getMessage());} 
		}
		return rslt;
	}

	/**Method Desc: For getting UOM values for the given food Item based on the user inputs **/
	private ArrayList<String> getKaloriForMeals(HttpServletRequest request) {
		ArrayList<String> kaloriList = new ArrayList<String>();

		String foodType = request.getParameter("foodType");
		String locale = request.getParameter("languageId");
		Connection conn = ConnectionManager.getConnection(request);
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try{
		String kalori_query = "SELECT A.FOOD_ITEM_CODE,TO_CHAR(A.CALORIFIC_CONT_PER_UOM,'999999.99'), B.ENERGY_UOM, AM_GET_DESC.AM_UOM(ENERGY_UOM,?,2) ENERGY_UOM_DESC FROM DS_ITEMS A,DS_PARAM B WHERE A.FOOD_ITEM_CODE = ? AND A.LANGUAGE_ID = ? "; //Modified Against PMG2017-COMN-CRF-0012.1[IN:067191]
		pstmt = conn.prepareStatement(kalori_query);
		/* Added Start Against PMG2017-COMN-CRF-0012.1[IN:067191] */		
		pstmt.setString(1,locale);
		pstmt.setString(2,foodType);
		pstmt.setString(3,locale);
		/* Added End Against PMG2017-COMN-CRF-0012.1[IN:067191] */
		rs = pstmt.executeQuery();
		while(rs != null && rs.next()){
			String FOOD_ITEM_CODE =rs.getString(1);
			String CALORIFIC_CONT_PER_UOM =rs.getString(2);
			String ENERGY_UOM =rs.getString(3);
			String ENERGY_UOM_DESC =rs.getString(4); //Added Against PMG2017-COMN-CRF-0012.1[IN:067191]

			kaloriList.add(FOOD_ITEM_CODE);
			kaloriList.add(CALORIFIC_CONT_PER_UOM);
			kaloriList.add(ENERGY_UOM);
			kaloriList.add(ENERGY_UOM_DESC); //Added Against PMG2017-COMN-CRF-0012.1[IN:067191]
		}
		}catch(Exception ee){
			System.err.println("PlaceMealOrderOPServlet.java-1558-->"+ee.getMessage());
		}finally{
			try{
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
			}catch(SQLException e){
				System.err.println("PlaceMealOrderOPServlet.java--1565->"+e.getMessage());
			}
			if(conn!=null)ConnectionManager.returnConnection(conn,request);
		}
		return kaloriList;
	}
	
	/**Method Desc: For getting the applicable Treatment Area for the given clinic **/
	private JSONObject getTreatmentArea(HttpServletRequest request) {
		JSONObject jsonResponse = new JSONObject();

		String langId = request.getParameter("language_Id");
		String facilityId = request.getParameter("facilityId");
		String clinicCode = request.getParameter("clinicCode");
		
		Connection conn = ConnectionManager.getConnection(request);
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try{
			
			String priorityZone = request.getParameter("priorityZone");
			String priorityZoneWhereClause="";
			
			if(!priorityZone.equals("")) {priorityZoneWhereClause=" and priority_zone='"+priorityZone+"' ";}			
			String trtmntArea_query = "SELECT TREATMENT_AREA_CODE, AE_GET_DESC.AE_TMT_AREA_FOR_CLINIC('"+facilityId+"','"+clinicCode+"',TREATMENT_AREA_CODE,'"+langId+"','2') SHORT_DESC FROM AE_TMT_AREA_FOR_CLINIC_VW WHERE CLINIC_CODE='"+clinicCode+"' AND FACILITY_ID='"+facilityId+"'"+priorityZoneWhereClause+" AND EFF_STATUS='E' order by 2";
			pstmt = conn.prepareStatement(trtmntArea_query);

			rs = pstmt.executeQuery();
			while(rs != null && rs.next()){
				String code =rs.getString(1);
				String desc =rs.getString(2);
			
				jsonResponse.append("treatmentAreaCode", code);
				jsonResponse.append("treatmentAreaDesc", desc);
		}

		}catch(Exception ee){
			System.err.println("PlaceMealOrderOPServlet.java--1604->"+ee.getMessage());
		}finally{
			try{
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
			}catch (SQLException e) {
			// TODO Auto-generated catch block
				System.err.println("PlaceMealOrderOPServlet.java--1611->"+e.getMessage());
			}
			if(conn!=null)ConnectionManager.returnConnection(conn,request);
		}
		return jsonResponse;
	}
	
	/* Method Desc: Searching A&E patient List*/
	private JSONObject searchEMMealOrder(HttpServletRequest request,  HttpServletResponse response) {
	
		Connection conn = ConnectionManager.getConnection(request);
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		log.debug("declaration:");
		JSONObject jsonList = new JSONObject();
		try{
				String jsonData = request.getParameter("jsonData");
				JSONObject json = new JSONObject(jsonData);		
				String facilityid =  json.getString("facilityid");
				String encounterid	=  json.getString("encounterId");
				String sEncounterQuery = "";
				if("".equalsIgnoreCase(encounterid.trim()))
					sEncounterQuery = "";
				else
					sEncounterQuery = " and appt.encounter_id = NVL(?, appt.encounter_id) " ;
				
				String patientid	=  json.getString("patientId");
				String locationType =  json.getString("locationType");
				String locationCode	=  json.getString("locationCode");
				String restype	=  json.getString("restype");
				String resource =  json.getString("resource");
				String priorityZone = json.getString("priorityZone");
				String treatmentArea = json.getString("treatmentArea");
				//ML-MMOH-SCF-1923 Starts
			String sysdateQuery = "select TO_CHAR (SYSDATE, 'DD/MM/YYYY') currentDate from dual";
			String currentDate="";
			pstmt = conn.prepareStatement(sysdateQuery);
			rs = pstmt.executeQuery();
			if(rs!= null && rs.next()){
				currentDate = rs.getString("currentDate");
			}
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			//ML-MMOH-SCF-1923 Ends
			
				String date	=  com.ehis.util.DateUtils.convertDate(json.getString("date"),"DMY", language_id, "en");
				String PreviousDate_display	=  com.ehis.util.DateUtils.convertDate(json.getString("PreviousDate_display"),"DMY", language_id, "en");	//ML-MMOH-CRF-1651 US001
				// Forming Query for Status::
				String status	=  json.getString("status");
				String sFromStatusQuery = "";
				
				String sSelectStatusQuery = "";
				
				String sWhereStatusQuery = "";
				
				String priorityZoneQuery="";
				
				String treatmentAreaQuery="";
				
				if("".equalsIgnoreCase(status))
				{
					status = null; //All Status
					
					//sSelectStatusQuery = " (select dietHdr.Modified_YN from DS_EM_DIET_ORDER_HDR dietHdr where enct.Encounter_id = dietHdr.Encounter_Id and enct.FACILITY_ID = dietHdr.Facility_Id) as status,  ";
					sSelectStatusQuery = " (select dietHdr.Modified_YN from DS_EM_DIET_ORDER_HDR dietHdr where enct.Encounter_id = dietHdr.Encounter_Id and enct.FACILITY_ID = dietHdr.Facility_Id and to_char(dietHdr.serving_date , 'dd/mm/yyyy')='"+currentDate+"') as status, (select to_char(dietHdr.serving_date , 'dd/mm/yyyy') from DS_EM_DIET_ORDER_HDR dietHdr where enct.Encounter_id = dietHdr.Encounter_Id and enct.FACILITY_ID = dietHdr.Facility_Id and to_char(dietHdr.serving_date , 'dd/mm/yyyy')='"+currentDate+"') as serving_date, ";//ML-MMOH-CRF-1651 US001 and Modified Against ML-MMOH-SCF-1923
					
					sFromStatusQuery = "";
					
					sWhereStatusQuery = "";
				}
				else if("A".equalsIgnoreCase(status))
				{
					status = "N"; //Order Placed
					
					//sSelectStatusQuery = " dietHdr.Modified_YN as status,  ";
					sSelectStatusQuery = " dietHdr.Modified_YN as status, to_char(dietHdr.serving_date , 'dd/mm/yyyy') as serving_date,  "; //ML-MMOH-CRF-1651 US001
					
					sFromStatusQuery = " , DS_EM_DIET_ORDER_HDR dietHdr ";
					
					sWhereStatusQuery = " and enct.FACILITY_ID = dietHdr.Facility_Id and enct.Encounter_id = dietHdr.Encounter_Id and to_char(dietHdr.serving_date , 'dd/mm/yyyy')='"+currentDate+"'"; //Modified Against ML-MMOH-SCF-1923
					
				}
				else if("C".equalsIgnoreCase(status))
				{
					status = "N"; //Order Pending
					
					//sSelectStatusQuery = " null as status,  ";
					sSelectStatusQuery = " null as status,(select to_char(dietHdr.serving_date , 'dd/mm/yyyy') from DS_EM_DIET_ORDER_HDR dietHdr where enct.Encounter_id = dietHdr.Encounter_Id and enct.FACILITY_ID = dietHdr.Facility_Id) as serving_date,  ";	//ML-MMOH-CRF-1651 US001
					
					sFromStatusQuery = "";
					
					//sWhereStatusQuery = " and enct.Encounter_id not in(select dietHdr.Encounter_Id from DS_EM_DIET_ORDER_HDR dietHdr where dietHdr.Encounter_Id =enct.Encounter_Id and enct.FACILITY_ID = dietHdr.Facility_Id ) ";
					sWhereStatusQuery = " and enct.Encounter_id not in(select dietHdr.Encounter_Id from DS_EM_DIET_ORDER_HDR dietHdr where to_char(dietHdr.serving_date , 'dd/mm/yyyy')='"+currentDate+"' ) "; //Modified Against ML-MMOH-SCF-1923
					
				}
				else if("F".equalsIgnoreCase(status))
				{
					status = "Y"; //Order Modified
					
					//sSelectStatusQuery = " dietHdr.Modified_YN as status,  ";
					sSelectStatusQuery = " dietHdr.Modified_YN as status, to_char(dietHdr.serving_date , 'dd/mm/yyyy')  as serving_date,  ";//ML-MMOH-CRF-1651 US001
					
					sFromStatusQuery = " , DS_EM_DIET_ORDER_HDR dietHdr ";
					
					sWhereStatusQuery = " and enct.FACILITY_ID = dietHdr.Facility_Id and enct.Encounter_id = dietHdr.Encounter_Id and dietHdr.Modified_YN = 'Y' and to_char(dietHdr.serving_date , 'dd/mm/yyyy')='"+currentDate+"'"; //Modified Against ML-MMOH-SCF-1923
				}
				
				//Forming Query for filtering Resources::
				String sResourceQuery = "";
				if(!"".equalsIgnoreCase(restype))
				{
					sResourceQuery = "and decode(?,'R', ASSIGN_ROOM_NUM,  " +
									"        'P', ATTEND_PRACTITIONER_ID, " + 
									"        'E', decode(OTHER_RES_CLASS, 'E', OTHER_RESOURCE_ID, ''), " +
									"        'O', decode(OTHER_RES_CLASS, 'O', OTHER_RESOURCE_ID, ''))= NVL(?, decode(?,'R', ASSIGN_ROOM_NUM, " + 
									" 		                                                          'P', ATTEND_PRACTITIONER_ID, " + 
									"                                                  'E', decode(OTHER_RES_CLASS, 'E', OTHER_RESOURCE_ID, ''), " +
									"                                                  'O', decode(OTHER_RES_CLASS, 'O', OTHER_RESOURCE_ID, '')) ) ";
				}
				
				if(!"".equalsIgnoreCase(priorityZone) && !"ALL".equalsIgnoreCase(priorityZone)) {
					priorityZoneQuery= " and enct.priority_zone = '"+priorityZone+"' ";
				}
				
				if(!"".equalsIgnoreCase(treatmentArea)) {
					treatmentAreaQuery= " and enct.treatment_area_code = '"+treatmentArea+"' ";
				}				
				
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				log.debug("done");
				log.debug(facilityid);
				log.debug("encounterId"+encounterid);
				log.debug("patientId"+patientid);
				log.debug("locationType"+locationType);
				log.debug("locationCode"+locationCode);
			
				StringBuffer sbmealOrderResult = new StringBuffer();
				
				sbmealOrderResult.append("select mp.patient_id as patient_id, mp.patient_name as patient_name," );  
				sbmealOrderResult.append("enct.encounter_id as encounterid, to_char(enct.visit_adm_date_time, 'dd/mm/yyyy HH24:MI') as visitDate,  " + sSelectStatusQuery ); 
				sbmealOrderResult.append("to_char(enct.visit_adm_date_time , 'dd/mm/yyyy') as chkPlaceOrderDate, enct.specialty_code " );
				sbmealOrderResult.append("from pr_encounter enct, mp_patient mp  " + sFromStatusQuery );
				//sbmealOrderResult.append("where enct.facility_id LIKE NVL (?, '%%') and visit_status IN('01','02','03','04','07') " );
				sbmealOrderResult.append("where enct.facility_id LIKE NVL (?, '%%') and visit_status IN('01','02','03','04') " );	//ML-MMOH-CRF-1651 US001
				
				if(!"".equalsIgnoreCase(priorityZone) && !"ALL".equalsIgnoreCase(priorityZone)) {sbmealOrderResult.append(priorityZoneQuery);}
				
				if(!"".equalsIgnoreCase(treatmentArea)) {sbmealOrderResult.append(treatmentAreaQuery);}
				
//				sbmealOrderResult.append("and enct.appt_case_yn = 'W' " );
				sbmealOrderResult.append("and mp.patient_id = enct.patient_id and enct.patient_class='EM' " );
				sbmealOrderResult.append("and enct.patient_id = NVL(?, enct.patient_id) " );
				sbmealOrderResult.append("and enct.Encounter_id = NVL(?, enct.Encounter_id) " );
//				sbmealOrderResult.append("and enct.specialty_code = NVL(?, enct.specialty_code) " );
				sbmealOrderResult.append("and enct.PAT_CURR_LOCN_TYPE = NVL(?, enct.PAT_CURR_LOCN_TYPE) " );
				sbmealOrderResult.append("and enct.PAT_CURR_LOCN_CODE = NVL(?, enct.PAT_CURR_LOCN_CODE) AND NVL(attend_practitioner_id,'X')=NVL(?,NVL(attend_practitioner_id,'X')) " + sWhereStatusQuery ); 
				sbmealOrderResult.append(" and (trunc(enct.visit_adm_date_time) between to_date(?, 'dd/mm/yyyy') and to_date(nvl(?, '31/12/2999'), 'dd/mm/yyyy')) ");
				sbmealOrderResult.append(" order by visitDate desc");

				String mealOrderResult = sbmealOrderResult.toString(); 
						
				//Getting Outpatient Lists::
				System.err.println("mealOrderResult:*********:"+mealOrderResult);
				log.debug("mealOrderResult::"+mealOrderResult);
				pstmt = conn.prepareStatement(mealOrderResult);
				int nindex = 1;
				
				String dapptDate="";
				String beforeDate="";
				if(!("".equalsIgnoreCase(date) )) //|| sapptDateFrom.length()>0)
				{
					 java.util.Date dateStr = sdf.parse(date);
			         dapptDate = sdf.format(dateStr);
					 //ML-MMOH-CRF-1651 US001 Starts
					 java.util.Date dateStr1 = sdf.parse(PreviousDate_display);	
			         beforeDate = sdf.format(dateStr1);
					 //ML-MMOH-CRF-1651 US001 Ends
				}
			
				pstmt.setString(nindex++, facilityid);
				pstmt.setString(nindex++, patientid);
				pstmt.setString(nindex++, encounterid);
				pstmt.setString(nindex++, locationType);
				pstmt.setString(nindex++, locationCode);
				pstmt.setString(nindex++, resource);
				System.err.println("dapptDate===>"+dapptDate);
				System.err.println("beforeDate===>"+beforeDate);
				System.err.println("beforeDate===>"+(dapptDate.compareTo(beforeDate) < 0));
				if(sdf.parse(dapptDate).after(sdf.parse(beforeDate))) //Added Against ML-MMOH-SCF-2135
				{
				System.err.println("Before , App");
				pstmt.setString(nindex++, beforeDate);	
				pstmt.setString(nindex++, dapptDate);
				}
				else
				{
					System.err.println("App , App");
				pstmt.setString(nindex++, dapptDate);
				pstmt.setString(nindex++, dapptDate);
				}
				
				rs = pstmt.executeQuery();
				

				log.debug("Getting Records:");
				while(rs != null && rs.next())
				{
					JSONObject jsonRecord= new JSONObject();
					jsonRecord.put("patient_id", 	isNULL(rs.getString("patient_id")));
					jsonRecord.put("patient_name", 	isNULL(rs.getString("patient_name")));
					jsonRecord.put("VisitDate", 	com.ehis.util.DateUtils.convertDate(rs.getString("visitDate"),"DMYHM","en",language_id));
					jsonRecord.put("chkPlaceOrderDate", isNULL(rs.getString("chkPlaceOrderDate")));
					jsonRecord.put("Encounterid", 	isNULL(rs.getString("encounterid")));
					jsonRecord.put("status", 		rs.getString("status"));
					jsonRecord.put("serving_date", 		rs.getString("serving_date"));	//ML-MMOH-CRF-1651 US001
					
					jsonRecord.put("specialityCode", 		rs.getString("specialty_code"));
					//Added Against ML-MMOH-CRF-0600 Ends Here
					String patientid_temp=isNULL(rs.getString("patient_id"));
					String pending_Ack=pendingMealOrder_Ack(request,response,"EM",patientid_temp);					
					jsonRecord.put("pending_Ack", 	pending_Ack);
					//Added Against ML-MMOH-CRF-0600 Ends Here
				
					jsonList.append("jsonOrderList", jsonRecord);
				}
			}
			catch(Exception ee){
				System.err.println("PlaceMealOrderOPServlet.java-1797-->"+ee.getMessage());
			}
			finally{
				try{
					if(rs!=null) rs.close();
					if(pstmt!=null) pstmt.close();
					if(conn!=null)ConnectionManager.returnConnection(conn,request);
				}catch(Exception e){System.err.println("PlaceMealOrderOPServlet.java--1804->"+e.getMessage());}
			}
			return jsonList;
	}
	
	/**Method Desc: Loading Selected Outpatient List in Place order Screen**/
	private JSONObject loadEMMealOrder(HttpServletRequest request,  HttpServletResponse response) {
		
		//CRF-0684
		boolean isMenuType =false;
		Connection conn = ConnectionManager.getConnection(request);
        isMenuType = CommonBean.isSiteSpecific(conn,"DS","DS_MENU_TYPE");
		PreparedStatement pstmt=null;
		PreparedStatement pstmt_FoodItem=null;
		PreparedStatement pstmt_splFoodItem=null;
	
		ResultSet rs=null;
		ResultSet rs_FoodItem = null;
		ResultSet rs_splFoodItem = null;
		
		JSONObject jsonList = new JSONObject();
		try{
			//Getting inputs:
				String jsonData = request.getParameter("jsonData");
				JSONObject json = new JSONObject(jsonData);		
				String facilityid =  json.getString("facilityid");
				String speciality =  json.getString("speciality");
				//JSONArray arrMealOrder=json.getJSONArray("mealorderObj");
				//StringBuffer sbAppt = new StringBuffer(); //Common-ICN-0055
				StringBuffer sbEnct = new StringBuffer();
				//Added Against ML-MMOH-CRF-0674 Starts Here
				String diettype_auto=request.getParameter("diettype_auto");
				diettype_auto=diettype_auto+"%";
				System.err.println("EM Patient:===="+diettype_auto);
				System.out.println("EM Patient:===="+diettype_auto);
				//Added Against ML-MMOH-CRF-0674 Ends Here
				JSONArray arrEnctOrder=json.getJSONArray("enctObj");
				for (int i = 0; i < arrEnctOrder.length(); i++){
					String sEnct =	arrEnctOrder.getString(i);
					sbEnct.append("'" + sEnct+"',");
				}	
				
				String sEnctList = sbEnct.toString();
				
				if(!"".equalsIgnoreCase(sEnctList))
					sEnctList = sEnctList.substring(0, sEnctList.length()-1);
				else
					sEnctList ="''";
				
				log.debug("done");
				log.debug(facilityid);
				log.debug("speciality"+speciality);
				log.debug("sbAppt:"+sEnctList);
				
				
			//ML-MMOH-SCF-1923 Starts
			String sysdateQuery = "select TO_CHAR (SYSDATE, 'DD/MM/YYYY') currentDate from dual";
			String currentDate="";
			pstmt = conn.prepareStatement(sysdateQuery);
			rs = pstmt.executeQuery();
			if(rs!= null && rs.next()){
				currentDate = rs.getString("currentDate");
			}
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			//ML-MMOH-SCF-1923 Ends
				
				StringBuffer sbLoadMealOrderResult = new StringBuffer();
				/* sbLoadMealOrderResult.append("select mp.patient_id as patient_id, mp.patient_name as patient_name,");  
				sbLoadMealOrderResult.append("enct.encounter_id as encounterid, to_char(enct.visit_adm_date_time, 'dd/mm/yyyy hh24:mi') as visitDate, TO_CHAR (emdiethdr.SERVING_DATE, 'dd/mm/yyyy') AS servingDate, emdiethdr.DIET_TYPE, emdietdtl.MEAL_TYPE, emdiethdr.REMARKS, emdiethdr.Modified_YN "); //Modified Against ML-MMOH-SCF-1923
				//sbLoadMealOrderResult.append("enct.encounter_id as encounterid, to_char(enct.visit_adm_date_time, 'dd/mm/yyyy hh24:mi') as visitDate, TO_CHAR (emdiethdr.SERVING_DATE, 'dd/mm/yyyy') AS servingDate, emdiethdr.DIET_TYPE,  emdiethdr.REMARKS, emdiethdr.Modified_YN "); //Modified Against ML-MMOH-SCF-1923
				sbLoadMealOrderResult.append("	,emdiethdr.PREP_INSTR as PREP_INSTR	");//vikash added against for CRF-417
				sbLoadMealOrderResult.append("	,emdiethdr.MENU_TYPE as MENU_TYPE	");//CRF-684
				sbLoadMealOrderResult.append("from pr_encounter enct, mp_patient mp, DS_EM_DIET_ORDER_DTL emdietdtl, DS_EM_DIET_ORDER_HDR emdiethdr ");
				sbLoadMealOrderResult.append("where enct.facility_id LIKE NVL (?, '%%') ");
				sbLoadMealOrderResult.append("and visit_status IN('01','02','03','04','07') ");
//				sbLoadMealOrderResult.append("and enct.appt_case_yn = 'W' ");
				sbLoadMealOrderResult.append("and mp.patient_id = enct.patient_id and enct.patient_class='EM' ");
				sbLoadMealOrderResult.append("and enct.Encounter_id IN("+ sEnctList +") ");
				sbLoadMealOrderResult.append("and enct.FACILITY_ID = emdietdtl.FACILITY_ID(+) "); 
				sbLoadMealOrderResult.append("and enct.encounter_ID= emdietdtl.encounter_ID ");
				sbLoadMealOrderResult.append("and enct.FACILITY_ID = emdiethdr.FACILITY_ID(+) ");
				sbLoadMealOrderResult.append("and enct.encounter_ID= emdiethdr.encounter_ID ");
				//sbLoadMealOrderResult.append(" order by visitDate desc");
				sbLoadMealOrderResult.append(" ORDER BY servingDate DESC"); //Modified Against ML-MMOH-SCF-1923 */
				
				//Modified Against Common-ICN-0081 Starts
				sbLoadMealOrderResult.append("select mp.patient_id as patient_id, mp.patient_name as patient_name,");  
				sbLoadMealOrderResult.append("enct.encounter_id as encounterid, to_char(enct.visit_adm_date_time, 'dd/mm/yyyy hh24:mi') as visitDate, emdiethdr.servingdate, emdiethdr.DIET_TYPE, emdiethdr.MEAL_TYPE, emdiethdr.REMARKS, emdiethdr.Modified_YN, emdiethdr.prep_instr, emdiethdr.menu_type "); //Modified Against ML-MMOH-SCF-1923
				sbLoadMealOrderResult.append("from pr_encounter enct, mp_patient mp,");
				sbLoadMealOrderResult.append("(select TO_CHAR (emdiethdr.serving_date, 'dd/mm/yyyy') AS servingdate,emdiethdr.diet_type, emdietdtl.meal_type ,emdiethdr.remarks, emdiethdr.modified_yn,emdiethdr.prep_instr AS prep_instr, emdiethdr.menu_type AS menu_type,emdiethdr.encounter_id,emdiethdr.facility_id from ds_em_diet_order_dtl emdietdtl,ds_em_diet_order_hdr emdiethdr where  emdiethdr.encounter_id = emdietdtl.encounter_id AND emdiethdr.serving_date = emdietdtl.serving_date and TO_CHAR (emdiethdr.serving_date, 'dd/mm/yyyy') = '"+currentDate+"') emdiethdr ");
				sbLoadMealOrderResult.append("where enct.facility_id LIKE NVL (?, '%%') ");
				sbLoadMealOrderResult.append("and visit_status IN('01','02','03','04','07') ");
				sbLoadMealOrderResult.append("and mp.patient_id = enct.patient_id and enct.patient_class='EM' ");
				sbLoadMealOrderResult.append("and enct.Encounter_id IN("+ sEnctList +") ");
				sbLoadMealOrderResult.append("and enct.FACILITY_ID = emdiethdr.FACILITY_ID(+) ");
				sbLoadMealOrderResult.append("and enct.encounter_ID= emdiethdr.encounter_ID(+) ");
				//Modified Against Common-ICN-0081 Ends
				
				String query_mealOrderResult = sbLoadMealOrderResult.toString(); 
				System.err.println("1830,query_mealOrderResult-->"+query_mealOrderResult);
				//String query_loadDiettype = "select distinct diet_type, ds_get_desc.ds_diet_type(diet_type,?,'2') sdesc from DS_DIET_TYPE where eff_status = 'E'";//commented against ML-MMOH-SCF-0542
				//Commented against ML-MMOH-CRF-0418
				//String query_loadDiettype = "select diet_type, ds_get_desc.ds_diet_type(diet_type,?,'2') sdesc from DS_DIET_TYPE where eff_status = 'E'";//Added against ML-MMOH-SCF-0542
				//Modified against ML-MMOH-CRF-0418,ML-MMOH-CRF-0674
				String query_loadDiettype = "select  diet_type, ds_get_desc.ds_diet_type(diet_type,?,'2') sdesc from DS_DIET_TYPE where eff_status = 'E' AND EM_DIET_TYPE_YN='Y' AND SHORT_DESC LIKE '"+diettype_auto+"' ORDER BY LOWER (sdesc)";//Added Against ML-MMOH-CRF-0674
				//Getting Menu TYPE CRF-684
				if(isMenuType){	
				int defaultcount=0;
                String sql_Menu_Count="SELECT count(*)defaultcount FROM ds_menu_type where eff_status ='E' and appl_for_em_yn ='Y' AND DEFAULT_YN='Y'";
				pstmt = conn.prepareStatement(sql_Menu_Count);
				rs	= pstmt.executeQuery();
				if(rs.next()){
					defaultcount=rs.getInt("defaultcount");
				}
				if(pstmt!=null) pstmt.close();	//Added Against Common-ICN-0031
				if(rs!=null) rs.close();	//Added Against Common-ICN-0031
				String query_loadMenu_type ="SELECT menu_type,short_desc,DEFAULT_YN FROM ds_menu_type where eff_status ='E' and appl_for_em_yn ='Y' ORDER BY short_desc asc";
				pstmt = conn.prepareStatement(query_loadMenu_type);
				rs = pstmt.executeQuery();
				while(rs != null && rs.next())
				{
					JSONObject jsonMenuList= new JSONObject();
					jsonMenuList.put("menuCode",rs.getString("menu_type"));
					jsonMenuList.put("shortDesc",rs.getString("short_desc"));
					jsonMenuList.put("DEFAULT_YN",rs.getString("DEFAULT_YN"));
					jsonMenuList.put("defaultcount",defaultcount);
					jsonList.append("jsonMenuList",jsonMenuList);					
				}				
				}
				if(pstmt!=null) pstmt.close();	//Added Against Common-ICN-0031
				if(rs!=null) rs.close();	//Added Against Common-ICN-0031
				
				//String query_mealType = "select distinct meal_type, ds_get_desc.ds_meal_type(meal_type,?,'2') short_desc FROM ds_meal_type  where eff_status = 'E' and em_meal_order_yn = 'Y'  order by meal_order asc  ";//Commented against ML-MMOH-SCF-0542
				//String query_mealType = "select  meal_type, ds_get_desc.ds_meal_type(meal_type,?,'2') short_desc FROM ds_meal_type  where eff_status = 'E' and em_meal_order_yn = 'Y'  order by meal_order asc  ";//Added against ML-MMOH-SCF-0542 and Commented Against ML-ML-MMOH-CRF-0825
				String query_mealType = "SELECT c.meal_type, ds_get_desc.ds_meal_type (c.meal_type, ?,'2') short_desc, serving_start_time_em, serving_end_time_em, irregular_start_time_em, irregular_end_time_em, meal_order,NVL((SELECT serving_start_time_em FROM ds_meal_type_lang_vw a WHERE a.meal_order = (SELECT MIN (b.meal_order) FROM ds_meal_type_lang_vw b WHERE b.serving_start_time_em IS NOT NULL AND b.meal_order > c.meal_order) AND a.language_id = ?), '23:59') next_serving_start_time_EM FROM ds_meal_type c where eff_status = 'E' and  EM_MEAL_ORDER_YN = 'Y' order by c.meal_order";//Modified Against ML-MMOH-CRF-0825
				
				String query_kitchen = "SELECT KITCHEN_CODE AS KITCHEN_CODE, KITCHEN_DESC AS KITCHEN_DESC FROM ds_speciality_kitchen_vw WHERE OPERATING_FACILITY_ID = ? and speciality_code=?";				
				
				//Getting Meal type::
				pstmt = conn.prepareStatement(query_mealType);
				pstmt.setString(1, language_id);
				pstmt.setString(2, language_id);//Added Against ML-ML-MMOH-CRF-0825
				rs = pstmt.executeQuery();
				
				int i=0;
				while(rs != null && rs.next())
				{
					JSONObject jsonMealList= new JSONObject();
					jsonMealList.put("mealType",rs.getString("meal_type"));
					jsonMealList.put("shortDesc",rs.getString("short_desc"));
					//Added Against ML-MMOH-CRF-0825 Starts Here
					jsonMealList.put("ServingStartTimeEM",rs.getString("SERVING_START_TIME_EM"));
					jsonMealList.put("ServingEndTimeEM",rs.getString("SERVING_END_TIME_EM"));
					jsonMealList.put("IrregularStartTimeEM",rs.getString("IRREGULAR_START_TIME_EM"));
					jsonMealList.put("IrregularEndTimeEM",rs.getString("IRREGULAR_END_TIME_EM"));
					jsonMealList.put("MealOrderEM",rs.getString("MEAL_ORDER"));
					jsonMealList.put("nextServingStartTimeEM",rs.getString("NEXT_SERVING_START_TIME_EM"));
					//Added Against ML-MMOH-CRF-0825 Ends Here
					jsonList.append("jsonMealList", jsonMealList);
					i++;
				}
				if(pstmt!=null) pstmt.close();	//Added Against Common-ICN-0031
				if(rs!=null) rs.close();	//Added Against Common-ICN-0031
				//Getting patient details for placing meal order::
				pstmt = conn.prepareStatement(query_mealOrderResult);
				pstmt.setString(1, facilityid);
				rs = pstmt.executeQuery();
				
				log.debug("Getting Records::");
				HashMap hAppt_Enct = new HashMap();
				JSONObject jsonMealTypeList = new JSONObject();
				while(rs != null && rs.next())
				{
					if( hAppt_Enct.get( rs.getString("encounterid") ) != null )
					{
						log.debug("encounter id ::");
						//if( jsonMealTypeList.get(rs.getString("encounterid")) != null )
						{
								//JSONArray tmpJsonMealValueList =  (JSONArray) jsonMealTypeList.get(rs.getString("encounterid"));
								//tmpJsonMealValueList.put(rs.getString("mealtype"));
								jsonMealTypeList.append("enct" + rs.getString("encounterid"), rs.getString("meal_type"));
						}
								
						//jsonMealTypeList.append(rs.getString("encounterid"), rs.getString("mealtype"));
					}
					else
					{
						JSONObject jsonRecord= new JSONObject();
						jsonRecord.put("patientId", 	isNULL(rs.getString("patient_id")));
						jsonRecord.put("patientName", 	isNULL(rs.getString("patient_name")));
						jsonRecord.put("visitDate", 	com.ehis.util.DateUtils.convertDate(rs.getString("visitDate"),"DMYHM","en",language_id));
						jsonRecord.put("servingDate", 	isNULL(rs.getString("servingDate")));
						jsonRecord.put("encounterid", 	isNULL(rs.getString("encounterid")));
						jsonRecord.put("diettype", 		isNULL(rs.getString("diet_type")));
						
						log.debug("encounterid:"+ rs.getString("encounterid"));
						
						if(rs.getString("encounterid") != null)
						{
							hAppt_Enct.put(rs.getString("encounterid"), "");
							jsonMealTypeList.append("enct"+rs.getString("encounterid"),  rs.getString("meal_type"));
						}
						
						jsonRecord.put("remarks", 		isNULL(rs.getString("remarks")));
						jsonRecord.put("prepartoryInstr", 	isNULL(rs.getString("PREP_INSTR")));//vikash added against for CRF-417
						if(isMenuType){
						jsonRecord.put("menuType",  	isNULL(rs.getString("menu_type")));// CRF-684
						}
						else{
						jsonRecord.put("menuType",  	"");// CRF-684
                         }
						jsonRecord.put("modifiedFlag", 	isNULL(rs.getString("Modified_YN")));
						
						//Getting Food Dislike::
						String sFilterQuery_FITM = "";
						sFilterQuery_FITM = " and DISLIKE.encounter_id = NVL(?, DISLIKE.encounter_id) " ;
						
						String query_foodDislike = "select DSITM.FOOD_ITEM_CODE ITMCODE, DSITM.SHORT_DESC ITMDESC from DS_PATIENT_EM_FOOD_DISLIKES DISLIKE, DS_ITEMS DSITM " +
								" WHERE DISLIKE.facility_id = ? "+ sFilterQuery_FITM +" and DISLIKE.ITEM_CODE = DSITM.FOOD_ITEM_CODE AND DSITM.LANGUAGE_ID = '"+language_id+"'";
						
						pstmt_FoodItem = conn.prepareStatement(query_foodDislike);
						pstmt_FoodItem.setString(1, facilityid);
						pstmt_FoodItem.setString(2, rs.getString("encounterid"));
						
						rs_FoodItem = pstmt_FoodItem.executeQuery();
						JSONObject jsonFoodList= new JSONObject();
						log.debug("gettig food dislike item::");
						while(rs_FoodItem != null && rs_FoodItem.next())
						{
							ArrayList arrFoodDislikeItem = new ArrayList();
							arrFoodDislikeItem.add(0, rs_FoodItem.getString("ITMCODE") );
							arrFoodDislikeItem.add(1, rs_FoodItem.getString("ITMDESC") );
							arrFoodDislikeItem.add(2, "0" );
							jsonFoodList.append("jsonFoodItem", 	arrFoodDislikeItem); 
						}
						jsonRecord.put("jsonFoodList",jsonFoodList);
						
						//Getting Special FoodItem::
						String sFilterQuery = "";
						sFilterQuery = " and ITM.encounter_id = NVL(?, ITM.encounter_id) " ;
						
						String query_splFooditem = "select ITM.ITEM_TYPE itemType, ITEMTYPE.SHORT_DESC itemDesc, DSITEMS.FOOD_ITEM_CODE itemCode, DSITEMS.SHORT_DESC foodDesc, ITM.QUANTITY itemQty, "+  
						" ITM.MEAL_TYPE mealType, MEALTYPE.SHORT_DESC mealDesc , TO_CHAR(DSITEMS.CALORIFIC_CONT_PER_UOM,'999999.99') cUOM, PARAM.ENERGY_UOM eUOM, AM_GET_DESC.AM_UOM (ENERGY_UOM, '"+language_id+"', 2) ENERGY_UOM_DESC "+
						" from DS_EM_DIET_SPL_ITEMS ITM, DS_ITEMS DSITEMS, DS_PARAM PARAM, ds_meal_type_lang_vw MEALTYPE, ds_item_type_lang_vw ITEMTYPE where facility_id = ? " + 
						sFilterQuery + " and DSITEMS.FOOD_ITEM_CODE =ITM.ITEM_CODE and DSITEMS.LANGUAGE_ID = '"+language_id+"' and "+ 
						" MEALTYPE.MEAL_TYPE = ITM.MEAL_TYPE and ITM.ITEM_TYPE =ITEMTYPE.ITEM_TYPE and MEALTYPE.LANGUAGE_ID = '"+language_id+"' and ITEMTYPE.LANGUAGE_ID = '"+language_id+"' "; //Modified Against PMG2017-COMN-CRF-0012.1[IN:067191](Emergency Patients Tab)
						
						pstmt_splFoodItem = conn.prepareStatement(query_splFooditem);
						pstmt_splFoodItem.setString(1, facilityid);
						pstmt_splFoodItem.setString(2, rs.getString("encounterid"));
						
						
						rs_splFoodItem = pstmt_splFoodItem.executeQuery();
						JSONObject jsonSplFoodList= new JSONObject();
						while(rs_splFoodItem != null && rs_splFoodItem.next())
						{
							ArrayList arrSplFoodItem = new ArrayList();
							arrSplFoodItem.add(0, rs_splFoodItem.getString("itemType") );
							arrSplFoodItem.add(1, rs_splFoodItem.getString("itemCode") );
							arrSplFoodItem.add(2, rs_splFoodItem.getString("itemQty") );
							arrSplFoodItem.add(3, rs_splFoodItem.getString("foodDesc") );
							arrSplFoodItem.add(4, rs_splFoodItem.getString("itemDesc") );
							arrSplFoodItem.add(5, rs_splFoodItem.getString("mealType") );
							arrSplFoodItem.add(6, rs_splFoodItem.getString("mealDesc") );
							arrSplFoodItem.add(7, "0" );
							arrSplFoodItem.add(8, rs_splFoodItem.getString("cUOM"));
							arrSplFoodItem.add(9, rs_splFoodItem.getString("eUOM") );
							arrSplFoodItem.add(10, rs_splFoodItem.getString("ENERGY_UOM_DESC") ); //Added Against PMG2017-COMN-CRF-0012.1[IN:067191]
							jsonSplFoodList.append("jsonSplFoodItem", 	arrSplFoodItem);
						}
						jsonRecord.put("jsonSplFoodList",jsonSplFoodList);
						jsonList.append("jsonOrderList", jsonRecord);
					}
				}
				jsonList.append("jsonMealTypeList", jsonMealTypeList);
				log.debug("Getting Diet type::");
				if(pstmt!=null) pstmt.close();	//Added Against Common-ICN-0031
				if(rs!=null) rs.close();	//Added Against Common-ICN-0031
				//Getting Diet type::
				pstmt = conn.prepareStatement(query_loadDiettype);
				pstmt.setString(1, language_id);
				rs = pstmt.executeQuery();
				//JSONObject jsonDietList= new JSONObject();
				while(rs != null && rs.next())
				{
					JSONObject jsonDietList= new JSONObject();
					jsonDietList.put("DietCode",rs.getString("diet_type"));
					jsonDietList.put("DietDesc",rs.getString("sdesc"));
					jsonList.append("jsonDietList", jsonDietList);
				}
				//jsonList.append("jsonDietList", jsonDietList);
				log.debug("Getting Kitchen::");
				if(pstmt!=null) pstmt.close();	//Added Against Common-ICN-0031
				if(rs!=null) rs.close();	//Added Against Common-ICN-0031
				//Getting Kitchen::
				pstmt = conn.prepareStatement(query_kitchen);
				pstmt.setString(1, facilityid);
				pstmt.setString(2, speciality);
				
				rs = pstmt.executeQuery();
				while(rs != null && rs.next())
				{
					jsonList.append("jsonKitchenCode", rs.getString("KITCHEN_CODE"));
					jsonList.append("jsonKitchenDesc", rs.getString("KITCHEN_DESC"));
				}
			}
			catch(Exception ee){
				System.err.println("PlaceMealOrderOPServlet.java-2029-->"+ee.getMessage());
			}
			finally{
				try{
					if(rs!=null) rs.close();
					if(pstmt!=null) pstmt.close();
					
					if(rs_FoodItem!=null) rs_FoodItem.close();
					if(pstmt_FoodItem!=null) pstmt_FoodItem.close();
					
					if(rs_splFoodItem!=null) rs_splFoodItem.close();
					if(pstmt_splFoodItem!=null) pstmt_splFoodItem.close();
					
					if(conn!=null)ConnectionManager.returnConnection(conn,request);
				}catch(Exception e){System.err.println("PlaceMealOrderOPServlet.java--2043->"+e.getMessage());}
			}
			return jsonList;
	}
	
	/**Method Desc: Insert/ Updating Meal Order for Emergency Patients based on the user inputs **/
	private boolean insertEMMealOrder(HttpServletRequest request,  HttpServletResponse response)
	{
		boolean isMenuType =false;
		Connection conn = ConnectionManager.getConnection(request);
        isMenuType = CommonBean.isSiteSpecific(conn,"DS","DS_MENU_TYPE");
        boolean bReturn = false;
		String patientId, patientName= "";
		String visitDate, servingDate= "";
		String kitchen, enctId= "";
		String dietTypes, remarks, modFlag = "";
		String PREP_INSTR="";//vikash added against for CRF-417
		String menu_type ="";//CRF-0684
		String exFoodDislike = "0";
		JSONArray mealtypes;
		JSONArray foodDislike;
		JSONArray splFoodItems;
		
		//Connection conn = null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		boolean rslt = false;
		try
		{	
			//Getting Inputs ::
			String jsonData = request.getParameter("jsonData");
			kitchen = request.getParameter("hdnkitchen");
			JSONObject jsonobj = new JSONObject(jsonData);		
			JSONArray mealOrderArray=jsonobj.getJSONArray("mealOrders");
			log.debug("insertOPMealOrder::");
			//conn = ConnectionManager.getConnection(request);
			
			//Queries::
			//ML-MMOH-CRF-1651 US001 Starts
			String sysdateQuery = "select TO_CHAR (SYSDATE, 'DD/MM/YYYY') currentDate from dual";
			String currentDate="";
			pstmt = conn.prepareStatement(sysdateQuery);
			rs = pstmt.executeQuery();
			if(rs!= null && rs.next()){
				currentDate = rs.getString("currentDate");
			}
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			//ML-MMOH-CRF-1651 US001 Ends
			for(int i=0;i<mealOrderArray.length();i++) {
				JSONObject obj=mealOrderArray.getJSONObject(i);
				JSONObject rowMealOrderObj=obj.getJSONObject("rowmealOrder");
				patientId	=	rowMealOrderObj.getString("patientId").trim();
				patientName	=	rowMealOrderObj.getString("patientName").trim();
				visitDate	=	rowMealOrderObj.getString("visitDate").trim();
				servingDate = 	rowMealOrderObj.getString("servingDate").trim();
				enctId		=	rowMealOrderObj.getString("enctId").trim();
				dietTypes	=	rowMealOrderObj.getString("dietTypes").trim();
				remarks		=	URLDecoder.decode(rowMealOrderObj.getString("remarks").trim(), "UTF-8"); // Lang-support for Remarks
				PREP_INSTR	=	URLDecoder.decode(rowMealOrderObj.getString("prepartoryInstr").trim(), "UTF-8"); //vikash added against for CRF-417
				if(isMenuType){
				menu_type  =    rowMealOrderObj.getString("menuType").trim(); //CRF-684
				}
				modFlag		=	rowMealOrderObj.getString("modFlag").toString().trim();
				foodDislike		=	rowMealOrderObj.getJSONArray("foodDislike");
				splFoodItems	=	rowMealOrderObj.getJSONArray("splFoodItem");
				mealtypes		=	rowMealOrderObj.getJSONArray("mealTypes");
				if(modFlag == null)
					log.debug("modFlag::null");
				else if(modFlag != "")
					log.debug("modFlag::not null");
				
				if("".equalsIgnoreCase(modFlag)) //Insertion of New Records::
				{
					// Insert Transaction start:
					//Table 1 - OPMealHdr::
					pstmt = conn.prepareStatement(DlQuery.DL_INSERT_EMMEALORDERHDR);
					//Facility_Id, Patient_Id, Encounter_Id, App_No, Seving_date, Kitchen, DietType, Remarks, Modified_YN,
					//ADDED_BY_ID, ADDED_DATE, ADDED_FACILITY_ID, ADDED_AT_WS_NO, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_FACILITY_ID, MODIFIED_AT_WS_NO) 
					pstmt.setString(1, facility_id);
					pstmt.setString(2, patientId);
					pstmt.setString(3, enctId);
					//pstmt.setString(4, servingDate);
					pstmt.setString(4, currentDate);	//ML-MMOH-CRF-1651 US001
					pstmt.setString(5, kitchen);
					pstmt.setString(6, dietTypes);
					pstmt.setString(7, remarks);
					pstmt.setString(8, "N");
					pstmt.setString(9, login_user);
					pstmt.setString(10, facility_id);
					pstmt.setString(11, str_client_ip_address);
					pstmt.setString(12, login_user);
					pstmt.setString(13, facility_id);
					pstmt.setString(14, str_client_ip_address);
					pstmt.setString(15, PREP_INSTR);//CRF-417
					if(isMenuType){						
					pstmt.setString(16, menu_type);//CRF-0684					
					}
					else {					
                     pstmt.setString(16, "");//CRF-0684						
					}
					rslt = pstmt.execute();
					
					//Table 2 - OPMealDtl:
					//rslt = insertOrderDtl_EM(conn, mealtypes, patientId, enctId, servingDate, dietTypes, "N", null);
					rslt = insertOrderDtl_EM(conn, mealtypes, patientId, enctId, currentDate, dietTypes, "N", null); //Common-ICN-0084
					
					//Added Against ML-MMOH-SCF-1923
					pstmt = conn.prepareStatement(DlQuery.DL_DELETE_EMFOODDISLIKES);
						
						pstmt.setString(1, facility_id);
						pstmt.setString(2, enctId);
						pstmt.execute();
					//Added Against ML-MMOH-SCF-1923
					
					//Table 3 - DL_INSERT_OPFOODDISLIKES
					rslt = insertFoodDislikes_EM(conn, foodDislike, exFoodDislike, patientId, enctId);
					//Added Against ML-MMOH-SCF-1923
					pstmt = conn.prepareStatement(DlQuery.DL_DELETE_EMSPLITEMS);
						
						pstmt.setString(1, facility_id);
						pstmt.setString(2, enctId);
						pstmt.execute();
					//Added Against ML-MMOH-SCF-1923				
					//Table 4 - DL_INSERT_OPSPLITEMS
					rslt = insertSplFoodItems_EM(conn, splFoodItems, patientId, enctId);
					
					
				}else //Updation of existing records::
				{
						//Updation of OPMealorder Header table:
						//if(!apptNo.isEmpty())
						pstmt = conn.prepareStatement(DlQuery.DL_UPDATE_EMMEALORDERHDR);
						pstmt.setString(1, dietTypes);
						pstmt.setString(2, remarks);
						pstmt.setString(3, "Y");
						pstmt.setString(4, PREP_INSTR);//vikash added against for CRF-417
						if(isMenuType){
						 pstmt.setString(5, menu_type);//CRF-0684
						}
						else{
						 pstmt.setString(5, "");//CRF-0684	
						}
                        pstmt.setString(6, facility_id);
						pstmt.setString(7, enctId);
						pstmt.setString(8, kitchen);
						pstmt.execute();
							
						//Deletion of OPMealorder Detail table:
						pstmt = conn.prepareStatement(DlQuery.DL_DELETE_EMMEALORDERDTL);
						
						pstmt.setString(1, facility_id);
						//if(!apptNo.isEmpty())
						/*if(!("".equalsIgnoreCase(apptNo)))
							pstmt.setString(2, apptNo);
						else*/
							pstmt.setString(2, enctId);
						
						rslt = pstmt.execute();
							
						//Insertion of OPMealDtl:
						rslt = insertOrderDtl_EM(conn, mealtypes, patientId, enctId, servingDate, dietTypes, "Y", null);
						
						//Deletion of Food Dislike table:
						//if(!apptNo.isEmpty())
						pstmt = conn.prepareStatement(DlQuery.DL_DELETE_EMFOODDISLIKES);
						
						pstmt.setString(1, facility_id);
						pstmt.setString(2, enctId);
						pstmt.execute();
						
						//Insertion of - DL_INSERT_OPFOODDISLIKES
						insertFoodDislikes_EM(conn, foodDislike, exFoodDislike, patientId, enctId);
						
						//Deletion of SpecialFood Item  table:
						
						pstmt = conn.prepareStatement(DlQuery.DL_DELETE_EMSPLITEMS);
						
						pstmt.setString(1, facility_id);
						pstmt.setString(2, enctId);
						pstmt.execute();
							
						//Insertion of - DL_INSERT_OPSPLITEMS
						rslt = insertSplFoodItems_EM(conn, splFoodItems, patientId, enctId);
						
				}
				
			}
			conn.commit();
			bReturn = true;

		}catch(Exception ee){
			bReturn = false;
			try {
				if(conn!=null) conn.rollback();
				} catch (SQLException e) {	e.printStackTrace(); }
			System.err.println("PlaceMealOrderOPServlet.java-2200-->"+ee.getMessage());
		}
		finally{
			try{
				if(pstmt!=null) pstmt.close();
				if(conn!=null)ConnectionManager.returnConnection(conn,request);
			}catch(Exception e){
				System.err.println("PlaceMealOrderOPServlet.java--2206->"+e.getMessage());} 
		}
		return bReturn;
	}
	
	/**Method Desc: Insert/ Updating Meal Types for the given encounter id based on the user inputs **/
	private boolean insertOrderDtl_EM( Connection conn, JSONArray mealtypes, String patientId, String enctId, String servingDate, String dietTypes, String modFlag, String AckDate) throws Exception
	{
		boolean rslt = true;
		PreparedStatement pstmt=null;
		//Added Against ML-MOH-CRF-825
		ResultSet rs=null;
		DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		try
		{
			/* Added Against Start ML-MOH-CRF-825 */
			String currentDate="",currentTime="",sysdateQuery="",mealTypeQuery="",IrrStartTime="",IrrEndTime="";	
			sysdateQuery = "select TO_CHAR (SYSDATE, 'DD/MM/YYYY') currentDate , TO_CHAR (SYSDATE, 'HH24:MI') currentTime from dual";
			pstmt = conn.prepareStatement(sysdateQuery);
			rs = pstmt.executeQuery();
			if(rs!= null && rs.next()){
				currentDate = rs.getString("currentDate");
				currentTime = rs.getString("currentTime");
			}
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			mealTypeQuery = "SELECT IRREGULAR_START_TIME_EM,IRREGULAR_END_TIME_EM FROM DS_MEAL_TYPE_LANG_VW  WHERE LANGUAGE_ID=? AND EFF_STATUS='E' AND meal_type = ?  ORDER BY MEAL_ORDER";	 		
			/* Added Against End ML-MOH-CRF-825 */				
			
			for(int index=0;index<mealtypes.length();index++) {			
			/* Added Against Start ML-MOH-CRF-825 */	
			pstmt = conn.prepareStatement(mealTypeQuery);
			pstmt.setString(1,language_id);
			pstmt.setString(2,(String)mealtypes.get(index));
			rs = pstmt.executeQuery();
			while(rs!= null && rs.next()){
				IrrStartTime = (String)CommonBean.checkForNull(rs.getString(1));
				IrrEndTime = (String)CommonBean.checkForNull(rs.getString(2));
			}
			if(pstmt!=null) pstmt.close(); 
			if(rs!=null) rs.close();	//Common-ICN-0044 
			String startDate = servingDate+" "+IrrStartTime;
			String endDate = currentDate+" "+IrrEndTime;
			String sysDate = currentDate+" "+currentTime;	
			if(EmMealOrderYn.equalsIgnoreCase("Y") && startDate.length()==16 && endDate.length()==16 && sysDate.length()==16){
			irregular_flag_yn  = compareDatesByDateMethods(sdf, sdf.parse(endDate), sdf.parse(startDate),  sdf.parse(sysDate));			
			} 			
			if(irregular_flag_yn.equals("") || irregular_flag_yn.equals(null))
				irregular_flag_yn = "N";
			/* Added Against End ML-MOH-CRF-825 */	
			pstmt = conn.prepareStatement(DlQuery.DL_INSERT_EMMEALORDERDTL);
			//System.err.println(DlQuery.DL_INSERT_EMMEALORDERDTL);
			pstmt.setString(1, facility_id);
			pstmt.setString(2, patientId);
			pstmt.setString(3, enctId);
			//pstmt.setString(4, servingDate);
			pstmt.setString(4, currentDate);	//ML-MMOH-CRF-1651 US001
			pstmt.setString(5, (String)mealtypes.get(index));
			pstmt.setString(6, dietTypes);
			pstmt.setString(7, "");
			pstmt.setString(8, AckDate);
			pstmt.setString(9, login_user);
			pstmt.setString(10, facility_id);
			pstmt.setString(11, str_client_ip_address);
			pstmt.setString(12, login_user);
			pstmt.setString(13, facility_id);
			pstmt.setString(14, str_client_ip_address);
			pstmt.setString(15, irregular_flag_yn);//Added Against ML-ML-MMOH-CRF-0825
			rslt = pstmt.execute();
			if(pstmt!=null) pstmt.close();	//Common-ICN-0044
			}
			}catch(ParseException sqle){ //Added Against ML-MOH-CRF-825
				System.err.println("exception in sql insertOrderDtl_EM="+sqle.toString());
				sqle.printStackTrace();			
			}catch(Exception e){ 
				System.err.println("exception in insertOrderDtl_EM="+e.toString());
				e.printStackTrace();
			}finally{
			try{
			if(pstmt!=null) pstmt.close();
			if(rs!=null) rs.close();
			}catch(Exception e){			
				System.err.println("PlaceMealOrderOPServlet.java-insertOrderDtl_EM-->"+e.getMessage());
				e.printStackTrace();
				e.printStackTrace();
			} 
		}
		return rslt;
	}
	
	/**Method Desc: Insert/ Updating Food Dsilike for the given appt/Encounter id based on the user inputs **/
	private boolean insertFoodDislikes_EM( Connection conn, JSONArray foodDislike, String exFoodDislike, String patientId, String enctId) throws Exception
	{
		boolean rslt = true;
		PreparedStatement pstmt=null;
		JSONArray arrFoodItem = new JSONArray();
		try
		{
			for(int index=0;index<foodDislike.length();index++) {
					if(foodDislike.isNull(index))
						continue;
					arrFoodItem = foodDislike.getJSONArray(index);
					log.debug("arrfoodDislike:"+ arrFoodItem.get(0));
					if((arrFoodItem.length() < 3) || !"-1".equalsIgnoreCase( (arrFoodItem.get(2)).toString() ))
					{
						pstmt = conn.prepareStatement(DlQuery.DL_INSERT_EMFOODDISLIKES);
						pstmt.setString(1, facility_id);
						pstmt.setString(2, patientId);
						pstmt.setString(3, enctId);
						pstmt.setString(4, (String)arrFoodItem.get(0));
						pstmt.setString(5, login_user);
						pstmt.setString(6, facility_id);
						pstmt.setString(7, str_client_ip_address);
						pstmt.setString(8, login_user);
						pstmt.setString(9, facility_id);
						pstmt.setString(10, str_client_ip_address);
						rslt = pstmt.execute();
						if(pstmt!=null) pstmt.close(); //Common-ICN-0044
					}
					//if(!rslt)
					//	break;
			}
		}
		finally{
			try{
				if(pstmt!=null) pstmt.close();
			}catch(Exception e){System.err.println("PlaceMealOrderOPServlet.java-2280-->"+e.getMessage());} 
		}
		return rslt;
	}
	/**Method Desc: Insert/ Updating Special Food Items for the given appt/Encounter id based on the user inputs **/
	private boolean insertSplFoodItems_EM( Connection conn, JSONArray splFoodItems, String patientId, String enctId) throws Exception
	{
		boolean rslt = true;
		PreparedStatement pstmt=null;
		try
		{
			for(int index=0;index<splFoodItems.length();index++) {
				//log.debug("splFoodItems:" +splFoodItems.get(i));
				JSONArray arrFoodItem = splFoodItems.getJSONArray(index);
				log.debug("arrfoodDislike:"+ arrFoodItem.get(0));
				if(!"-1".equalsIgnoreCase( (arrFoodItem.get(7)).toString() ) )
				{
					pstmt = conn.prepareStatement(DlQuery.DL_INSERT_EMSPLITEMS);
					pstmt.setString(1, facility_id);
					pstmt.setString(2, patientId);
					pstmt.setString(3, enctId);
					pstmt.setString(4, arrFoodItem.get(0).toString());
					pstmt.setString(5, arrFoodItem.get(1).toString());
					pstmt.setString(6, arrFoodItem.get(2).toString());
					pstmt.setString(7, arrFoodItem.get(5).toString());
					pstmt.setString(8, login_user);
					pstmt.setString(9, facility_id);
					pstmt.setString(10, str_client_ip_address);
					pstmt.setString(11, login_user);
					pstmt.setString(12, facility_id);
					pstmt.setString(13, str_client_ip_address);
					rslt = pstmt.execute();
					if(pstmt!=null) pstmt.close();	//Common-ICN-0044
				}	
			}
		}
		finally{
			try{
				if(pstmt!=null) pstmt.close();
			}catch(Exception e)
				{System.err.println("PlaceMealOrderOPServlet.java--2318->"+e.getMessage());} 
		}
		return rslt;
	}
	
	//Added Against ML-MMOH-CRF-0600 Starts Here	
	/* Method Desc: Searching Pending MealOrder Acknowledgement*/
	private String pendingMealOrder_Ack(HttpServletRequest request,  HttpServletResponse response,String patient_Type,String patientid) {	
		Connection conn = ConnectionManager.getConnection(request);
		PreparedStatement pstmt=null;
		ResultSet rs=null;	
		String pending_Ack="";
		try{
		String pendingMealOrder_query="";
		//Added Against INC#65290 Starts Here
		String pending_Ack_Allow="";
		String Allowplaceorder_Op_Em="select ALLOW_PLACE_ORD_OP_EM from DS_PARAM_FOR_FACILITY where OPERATING_FACILITY_ID=?";
			pstmt = conn.prepareStatement(Allowplaceorder_Op_Em);
			pstmt.setString(1,facility_id);
			rs = pstmt.executeQuery();		
				while(rs != null && rs.next())
				{
				//System.out.println("rs.getString(1)"+rs.getString(1));
				pending_Ack_Allow=rs.getString(1);	
				}
				if(pending_Ack_Allow.equalsIgnoreCase("Y"))
				{
		//Added Against INC#65290 Ends Here
		if(patient_Type.equalsIgnoreCase("OP"))
		//pendingMealOrder_query="SELECT 1 FROM (SELECT DISTINCT a.encounter_id, a.serving_date, b.status curr_stat,b.mealtype,CASE WHEN b.status = 'MS' THEN 1 WHEN b.status = 'MA' THEN 2 WHEN b.status = 'MR' AND 1 = (SELECT 1 from ds_param_for_facility WHERE op_em_reject_yn = 'Y') THEN 3 ELSE 0 END status FROM ds_op_diet_order_hdr a, ds_op_diet_order_dtl b WHERE a.facility_id  = ? AND a.patient_id   = ? AND a.facility_id  = b.facility_id AND a.serving_date = b.serving_date AND a.patient_id   = b.patient_id AND a.serving_date = (SELECT MAX (serving_date) FROM ds_op_diet_order_hdr WHERE facility_id = a.facility_id AND patient_id = a.patient_id) ORDER BY a.serving_date DESC) WHERE status < (SELECT CASE WHEN op_em_served_yn = 'Y' THEN 1 WHEN op_em_accept_yn = 'Y' THEN 2 WHEN op_em_reject_yn = 'Y' THEN 3 ELSE 0 END status FROM ds_param_for_facility)";
		//Modified Against INC#65290
		pendingMealOrder_query="SELECT 1 FROM (SELECT DISTINCT a.encounter_id, a.serving_date, b.status curr_stat,b.mealtype,CASE WHEN b.status = 'MS' THEN 1 WHEN b.status = 'MA' THEN 2 WHEN b.status = 'MR' AND 1 = (SELECT 1 from ds_param_for_facility WHERE op_em_reject_yn = 'Y') THEN 3 ELSE 0 END status FROM ds_op_diet_order_hdr a, ds_op_diet_order_dtl b WHERE a.facility_id  = ? AND a.patient_id   = ? AND a.facility_id  = b.facility_id AND a.serving_date = b.serving_date AND a.patient_id   = b.patient_id AND a.serving_date = (SELECT MAX (serving_date) FROM ds_op_diet_order_hdr WHERE facility_id = a.facility_id AND patient_id = a.patient_id) ORDER BY a.serving_date DESC) WHERE status < (SELECT MAX (op_param_val) FROM (SELECT CASE WHEN op_em_served_yn = 'Y' THEN 1 ELSE 0 END op_param_val  FROM ds_param_for_facility  WHERE operating_facility_id = ?  UNION ALL SELECT CASE WHEN op_em_accept_yn = 'Y' THEN 2 ELSE 0 END op_param_val FROM ds_param_for_facility WHERE operating_facility_id = ?)) ";
		else
		//pendingMealOrder_query="SELECT 1 FROM (SELECT DISTINCT a.encounter_id, a.serving_date, b.status curr_stat,b.meal_type,CASE WHEN b.status = 'MS' THEN 1 WHEN b.status = 'MA' THEN 2 WHEN b.status = 'MR' AND 1 = (SELECT 1 from ds_param_for_facility WHERE op_em_reject_yn = 'Y') THEN 3 ELSE 0 END status FROM ds_em_diet_order_hdr a, ds_em_diet_order_dtl b WHERE a.facility_id  = ? AND a.patient_id   = ? AND a.facility_id  = b.facility_id AND a.patient_id   = b.patient_id AND a.serving_date = b.serving_date AND a.serving_date = (SELECT MAX (serving_date) FROM ds_em_diet_order_hdr WHERE facility_id = a.facility_id AND patient_id = a.patient_id) ORDER BY a.serving_date DESC) WHERE status < (SELECT CASE WHEN op_em_served_yn = 'Y' THEN 1 WHEN op_em_accept_yn = 'Y' THEN 2 WHEN op_em_reject_yn = 'Y' THEN 3 ELSE 0 END status FROM ds_param_for_facility)";
		//Modified Against INC#65290
		pendingMealOrder_query="SELECT 1 FROM (SELECT DISTINCT a.encounter_id, a.serving_date, b.status curr_stat,b.meal_type,CASE WHEN b.status = 'MS' THEN 1 WHEN b.status = 'MA' THEN 2 WHEN b.status = 'MR' AND 1 = (SELECT 1 from ds_param_for_facility WHERE op_em_reject_yn = 'Y') THEN 3 ELSE 0 END status FROM ds_em_diet_order_hdr a, ds_em_diet_order_dtl b WHERE a.facility_id  = ? AND a.patient_id   = ? AND a.facility_id  = b.facility_id AND a.patient_id   = b.patient_id AND a.serving_date = b.serving_date AND a.serving_date = (SELECT MAX (serving_date) FROM ds_em_diet_order_hdr WHERE facility_id = a.facility_id AND patient_id = a.patient_id) ORDER BY a.serving_date DESC) WHERE status < (SELECT MAX (op_param_val) FROM (SELECT CASE WHEN op_em_served_yn = 'Y' THEN 1 ELSE 0 END op_param_val  FROM ds_param_for_facility  WHERE operating_facility_id = ?  UNION ALL SELECT CASE WHEN op_em_accept_yn = 'Y' THEN 2 ELSE 0 END op_param_val FROM ds_param_for_facility WHERE operating_facility_id = ?))";
		//System.out.println("pendingMealOrder_query========"+pendingMealOrder_query);
		if(pstmt!=null) pstmt.close();	//Added Against Common-ICN-0031
		if(rs!=null) rs.close();	//Added Against Common-ICN-0031
		pstmt = conn.prepareStatement(pendingMealOrder_query);
		pstmt.setString(1,facility_id);
		pstmt.setString(2,patientid);	
		//Added Against INC#65290 Starts Here
		pstmt.setString(3,facility_id);
		pstmt.setString(4,facility_id);
		//Added Against INC#65290 Ends Here
		rs = pstmt.executeQuery();		
				while(rs != null && rs.next())
				{
					pending_Ack=rs.getString(1);	
				}
		//Added Against INC#65290 Starts Here
				}
				else
				pending_Ack=" ";
		//Added Against INC#65290 Ends Here
			}
		catch(Exception ee){
				System.err.println("PlaceMealOrderOPServlet.java--->"+ee.getMessage());
				ee.printStackTrace();			
			}
			finally{
				try{
					if(rs!=null) rs.close();
					if(pstmt!=null) pstmt.close();
					if(conn!=null)ConnectionManager.returnConnection(conn,request);
				}catch(Exception e){
					e.printStackTrace();
					System.err.println("PlaceMealOrderOPServlet.java--->"+e.getMessage());
				}
			}
			return pending_Ack;
	}
	
	private  JSONObject pendingMealOrder_AckDetail(HttpServletRequest request,  HttpServletResponse response)
	{
		Connection conn = ConnectionManager.getConnection(request);
		PreparedStatement pstmt=null;
		/* PreparedStatement pstmt_FoodItem=null;
		PreparedStatement pstmt_splFoodItem=null; */	//Common-ICN-0044
	
		ResultSet rs=null;
		String patientid=request.getParameter("patientid");
		String patient_type=request.getParameter("patient_type");
		JSONObject jsonList = new JSONObject();
		try{
				String query_pendingAck="";
				if(patient_type.equalsIgnoreCase("OP"))
					//query_pendingAck="SELECT TRUNC(serving_date) serving_date,ds_get_desc.ds_meal_type(mealtype,'en','2') meal_type_desc,DECODE(curr_stat, 'MS','Served','MA','Accept','MR','Reject','NA') stauts FROM (SELECT DISTINCT a.encounter_id, a.serving_date, b.status curr_stat,b.mealtype FROM ds_op_diet_order_hdr a, ds_op_diet_order_dtl b  WHERE a.facility_id = ? AND a.patient_id = ? AND a.facility_id = b.facility_id AND a.serving_date = b.serving_date AND a.patient_id = b.patient_id AND a.serving_date = (SELECT MAX (serving_date) FROM ds_op_diet_order_hdr WHERE facility_id = a.facility_id AND patient_id = a.patient_id) ORDER BY a.serving_date DESC)";
					query_pendingAck="SELECT TRUNC(serving_date) serving_date,ds_get_desc.ds_meal_type(mealtype,'en','2') meal_type_desc,NVL ((SELECT status_desc FROM ds_meal_ack_status_mast WHERE status_code = curr_stat AND patient_class = 'OP'), 'NA') status FROM (SELECT DISTINCT a.encounter_id, a.serving_date, b.status curr_stat,b.mealtype FROM ds_op_diet_order_hdr a, ds_op_diet_order_dtl b  WHERE a.facility_id = ? AND a.patient_id = ? AND a.facility_id = b.facility_id AND a.serving_date = b.serving_date AND a.patient_id = b.patient_id AND a.serving_date = (SELECT MAX (serving_date) FROM ds_op_diet_order_hdr WHERE facility_id = a.facility_id AND patient_id = a.patient_id) ORDER BY a.serving_date DESC)";//CRF-1061
				else
					//query_pendingAck="SELECT TRUNC(serving_date) serving_date,ds_get_desc.ds_meal_type(meal_type,'en','2') meal_type_desc,DECODE(curr_stat, 'MS','Served','MA','Accept','MR','Reject','NA') stauts   FROM (SELECT DISTINCT a.encounter_id, a.serving_date, b.status curr_stat,b.meal_type FROM ds_em_diet_order_hdr a, ds_em_diet_order_dtl b WHERE a.facility_id = ? AND a.patient_id = ? AND a.facility_id = b.facility_id AND a.patient_id = b.patient_id AND a.serving_date = b.serving_date AND a.serving_date = (SELECT MAX (serving_date) FROM ds_em_diet_order_hdr WHERE facility_id = a.facility_id AND patient_id = a.patient_id) ORDER BY a.serving_date DESC)";
					query_pendingAck="SELECT TRUNC(serving_date) serving_date,ds_get_desc.ds_meal_type(meal_type,'en','2') meal_type_desc,NVL ((SELECT status_desc FROM ds_meal_ack_status_mast WHERE status_code = curr_stat AND patient_class = 'OP'), 'NA') status FROM (SELECT DISTINCT a.encounter_id, a.serving_date, b.status curr_stat,b.meal_type FROM ds_em_diet_order_hdr a, ds_em_diet_order_dtl b WHERE a.facility_id = ? AND a.patient_id = ? AND a.facility_id = b.facility_id AND a.patient_id = b.patient_id AND a.serving_date = b.serving_date AND a.serving_date = (SELECT MAX (serving_date) FROM ds_em_diet_order_hdr WHERE facility_id = a.facility_id AND patient_id = a.patient_id) ORDER BY a.serving_date DESC)";//CRF-1061
				pstmt = conn.prepareStatement(query_pendingAck);
				pstmt.setString(1, facility_id);
				pstmt.setString(2, patientid);
				rs = pstmt.executeQuery();
				
				int i=0;
				while(rs != null && rs.next())
				{
					JSONObject jsonMealPendingList= new JSONObject();
					jsonMealPendingList.put("serving_date",rs.getString(1));
					jsonMealPendingList.put("mealtypeDesc",rs.getString(2));
					jsonMealPendingList.put("status",rs.getString(3));
					jsonList.append("jsonMealPendingList", jsonMealPendingList);
					i++;
				}				
			}
			catch(Exception ee){
				System.err.println("PlaceMealOrderOPServlet.java--->"+ee.getMessage());
				ee.printStackTrace();
			}
			finally{
				try{
					if(rs!=null) rs.close();
					if(pstmt!=null) pstmt.close();					
					if(conn!=null)ConnectionManager.returnConnection(conn,request);
				}catch(Exception e){
					System.err.println("PlaceMealOrderOPServlet.java--->"+e.getMessage());
					e.printStackTrace();
				}
			}
			return jsonList;
			
	}
	//Added Against ML-MMOH-CRF-0600 Ends Here	
}