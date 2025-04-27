/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eDS;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import java.io.PrintWriter;
import java.util.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.io.IOException;
import eDS.Common.JSONObject;
import eDS.Common.DlQuery;
import eCommon.XSSRequestWrapper;
import webbeans.eCommon.ConnectionManager;
import webbeans.eCommon.MessageManager;

/**
File Name		: DocumentOPMealServlet.java
File Description: This servlet file is to document/ acknowledge the placed OP Meal order based on the user inputs .
CRF#			: Bru-HIMS-CRF-230
Author			: Abirami
Date			: Aug-2013
**/

public class DocumentOPMealServlet extends javax.servlet.http.HttpServlet {

	private static final long serialVersionUID = 1L;
	java.util.Properties prop;
	HttpSession session;
	String facility_id,str_client_ip_address,login_user,language_id;

	private final static Logger log = Logger.getLogger("eDS"); 
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
		boolean bsuccessFlag = true;
		String error_value = "", error= "";
		PrintWriter out=response.getWriter();
		String operation = request.getParameter("mode");
		JSONObject specialityJSONList=new JSONObject();
		JSONObject treatMentAreaObj=new JSONObject();
		JSONObject ordersJSONList=new JSONObject();
		
		//Getting session values::
		session = request.getSession(false);
		this.prop = (java.util.Properties) session.getValue("jdbc");
		str_client_ip_address = prop.getProperty("client_ip_address");
		login_user = prop.getProperty( "login_user" ) ;
		if(str_client_ip_address == null) str_client_ip_address="";
		if(login_user == null) login_user="";
		this.facility_id = (String) session.getAttribute("facility_id");	
		this.language_id = (String) session.getAttribute("LOCALE");
		log.debug("operation:"+operation);
		
		/*******Initial Load - Loading Speciality, Location and MealType********/
		if(operation.equals("initialLoad")){
			specialityJSONList = initialLoad(request,response);
			response.setContentType("application/json");
			out.print(specialityJSONList);
			out.flush();
		}else if(operation.equals("searchDocMealOrder")){ /*******Searching OP Meal Order for Documentation********/
			specialityJSONList = searchDocMealOrder(request,response);
			response.setContentType("application/json");
			out.print(specialityJSONList);
			out.flush();
		}else if(operation.equals("applyDocMealOrder"))	/*******Document/Acknowledge OP Meal Order********/
		{
			String OPFlag  		= (String)request.getParameter("OPFlag");
			
			if(OPFlag.equals("Y")) {
				bsuccessFlag = updateDocMealOrder_OP(request,response);
			}
			else if (OPFlag.equals("N")) {
				bsuccessFlag = updateDocMealOrder_EM(request,response);
			}
			if ( bsuccessFlag )
			{
				MessageManager mm = new MessageManager();
				error_value = "1" ;
				final java.util.Hashtable mesg = mm.getMessage(language_id,	"DS_OPER_COMPLETE", "DS");
				error = (String) mesg.get("message");  //"APP-SM0070 Operation Completed Successfully ....";
				mesg.clear(); //Common-ICN-0044
			}
			response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode(error,"UTF-8"  )+"&err_value="+error_value );
		}
		else if(operation.equals("getTreatmentArea")){
			treatMentAreaObj  = getTreatmentArea(request);
		//	log.debug("mealOrderJSONList_Order---->>>"+mealOrderJSONList_Order+"<<<<<<<");
			out.println(treatMentAreaObj);
		}
		else if(operation.equals("searchDocMealOrder_EM")) {
			ordersJSONList = searchDocMealOrder_EM(request,response);
			response.setContentType("application/json");
			out.print(ordersJSONList);
			out.flush();			
		}
		
	}
	
	/**Method Desc: Initial Load - Loading Speciality, Location and MealType**/
	private JSONObject initialLoad(HttpServletRequest request,  HttpServletResponse response) {
		
	
		Connection conn = ConnectionManager.getConnection(request);
		PreparedStatement pstmt=null;
		PreparedStatement pstmtLoc=null;
		PreparedStatement pstmtRes=null;
		ResultSet rs=null;
		
		JSONObject jsonList = new JSONObject();
		try{
		
			//String speciality_code = "select distinct speciality_code, short_desc from Am_Speciality_lang_vw where language_id='"+language_id+"' and EFF_STATUS ='E'  order by UPPER(short_desc) asc";
			
			//String speciality_code = "select distinct speciality_code, am_get_desc.am_speciality(speciality_code,'"+language_id+"', 2) short_desc from Am_Speciality where  EFF_STATUS ='E' order by UPPER(short_desc) asc";//Commented against ML-MMOH-CRF-597
			
			String speciality_code = "select distinct speciality_code, am_get_desc.am_speciality(speciality_code,'"+language_id+"', 2) short_desc from ds_speciality_for_kitchen  order by UPPER(short_desc) asc";//Added against ML-MMOH-CRF-597

			String location_type = "select locn_type, am_get_desc.am_care_locn_type(LOCN_TYPE,'"+language_id+"',2) short_desc, care_locn_type_ind from " +
					"am_care_locn_type where sys_user_def_ind = 'S' and locn_type in ('C','E','Y')  order by UPPER(short_desc)";
					
			//String sql_mealType = "select distinct meal_type, short_desc FROM ds_meal_type  where eff_status = 'E' and opmealorder_yn = 'Y' order by meal_order asc  ";
			String sql_mealType = "select meal_type, ds_get_desc.ds_meal_type(meal_type,'"+language_id+"','2') short_desc FROM ds_meal_type  where eff_status = 'E' and opmealorder_yn = 'Y'  order by meal_order asc  ";//ML-MMOH-SCF- 0556
			String sql_mealType_EM="select meal_type, ds_get_desc.ds_meal_type(meal_type,'"+language_id+"','2') short_desc FROM ds_meal_type  where eff_status = 'E' and em_meal_order_yn = 'Y'  order by meal_order asc  ";//ML-MMOH-SCF- 0556
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
			
			//Getting Location type and Desc::
			if(rs!=null) rs.close();	//Added Against Common-ICN-0031
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
			if(pstmt!=null) pstmt.close();	//Added Against Common-ICN-0031
			if(rs!=null) rs.close();	//Added Against Common-ICN-0031
			//Getting MealType Code and Desc::
			pstmt = conn.prepareStatement(sql_mealType);
			rs = pstmt.executeQuery();

			log.debug("initialLoad method::");
			while(rs != null && rs.next())
			{
				String meal_type = rs.getString("meal_type");
				String shortdesc = rs.getString("short_desc");
				JSONObject jsonMealList = new JSONObject();
				
				jsonMealList.put("mealType", meal_type);
				jsonMealList.put("mealDesc", shortdesc);
				
				jsonList.append("mealList",jsonMealList);
			}
			if(pstmt!=null) pstmt.close();	//Added Against Common-ICN-0031
				if(rs!=null) rs.close();	//Added Against Common-ICN-0031
			//Getting MealType Code and Desc::
			pstmt = conn.prepareStatement(sql_mealType_EM);
			rs = pstmt.executeQuery();

			while(rs != null && rs.next())
			{
				String meal_type = rs.getString("meal_type");
				String shortdesc = rs.getString("short_desc");
				JSONObject jsonMealList_EM = new JSONObject();
				
				jsonMealList_EM.put("mealType", meal_type);
				jsonMealList_EM.put("mealDesc", shortdesc);
				
				jsonList.append("mealList_EM",jsonMealList_EM);
			}
			if(pstmt!=null) pstmt.close();	//Added Against Common-ICN-0031
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
			System.err.println("DocumentOPMealServlet.java--->"+ee.getMessage());
			ee.printStackTrace();
		}
		finally{
			try{
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(pstmtLoc!=null) pstmtLoc.close();
				if(pstmtRes!=null) pstmtRes.close();
				if(conn!=null)ConnectionManager.returnConnection(conn,request);
			}catch(Exception e){System.err.println("DocumentOPMealServlet.java--->"+e.getMessage());
			e.printStackTrace();}
		}
		return jsonList;
	}
	
	 /**Method Desc: Searching OP Meal Order for Documentation**/
	private JSONObject searchDocMealOrder(HttpServletRequest request,  HttpServletResponse response)
	{
		Connection conn = ConnectionManager.getConnection(request);
		PreparedStatement pstmt=null;
	
		ResultSet rs=null;
		log.debug("declaration:");
		JSONObject jsonList = new JSONObject();
		try{
			log.debug("getting request parameters1::");
			String jsonData = request.getParameter("jsonData");
			JSONObject json = new JSONObject(jsonData);		
			log.debug("getting request parameters::");
			
			String speciality =  json.getString("speciality");
			String locationType =  json.getString("locationType");
			String locationCode	=  json.getString("locationCode");
			String restype		=  json.getString("restype");
			String resource 	=  json.getString("resource");
			
			String servingDate	=  com.ehis.util.DateUtils.convertDate(json.getString("servingdate"),"DMY", language_id, "en");
			String mealType		=  json.getString("mealType");
			
			//Forming Query for filtering Resources::
			String sResourceQuery = "";
			if(!"".equalsIgnoreCase(restype))
			{
				/*sResourceQuery = "  and decode(?,'R', ASSIGN_ROOM_NUM,  " +
								"        'P', ATTEND_PRACTITIONER_ID, " + 
								"        'E', decode(OTHER_RES_CLASS, 'E', OTHER_RESOURCE_ID, ''), " +
								"        'O', decode(OTHER_RES_CLASS, 'O', OTHER_RESOURCE_ID, ''))= NVL(?, decode(?,'R', ASSIGN_ROOM_NUM, " + 
								" 		                                                          'P', ATTEND_PRACTITIONER_ID, " + 
								"                                                  'E', decode(OTHER_RES_CLASS, 'E', OTHER_RESOURCE_ID, ''), " +
								"                                                  'O', decode(OTHER_RES_CLASS, 'O', OTHER_RESOURCE_ID, '')) )  ";*/
				sResourceQuery = "  and decode(?,'R', ASSIGN_ROOM_NUM,  " +
				"        'P', ATTEND_PRACTITIONER_ID, " + 
				"        'E', decode(OTHER_RES_CLASS, 'E', OTHER_RESOURCE_ID, ''), " +
				"        'O', decode(OTHER_RES_CLASS, 'O', OTHER_RESOURCE_ID, '')) = NVL(?, decode(?,'R', ASSIGN_ROOM_NUM, " + 
				" 		                                                          'P', ATTEND_PRACTITIONER_ID, " + 
				"                                                  'E', decode(OTHER_RES_CLASS, 'E', OTHER_RESOURCE_ID, ''), " +
				"                                                  'O', decode(OTHER_RES_CLASS, 'O', OTHER_RESOURCE_ID, '')) )  ";
			}
			
			StringBuffer sbDocOPMealOrder = new StringBuffer();
			
			sbDocOPMealOrder.append(" select appt.patient_id as patient_id, appt.patient_name as patient_name, TO_CHAR(appt.appt_date, 'DD/MM/YYYY')  as apptDate, nvl(to_char(appt.appt_time,'hh24:mi'),' ') as appt_time, appt.appt_ref_no as apptNo, ");
			sbDocOPMealOrder.append(" appt.encounter_id as encounterid , TO_CHAR('', 'DD/MM/YYYY HH24:MI') as visitDate, opdietdtl.Status as status, TO_CHAR(opdietdtl.Acknowledge_Date_Time, 'DD/MM/YYYY HH24:MI') as AckDate ");

			sbDocOPMealOrder.append(" ,TO_CHAR (SYSDATE, 'DD/MM/YYYY HH24:MI') AS sys_date ");//ML-MMOH-CRF-681	
			sbDocOPMealOrder.append(" ,opdietdtl.COMPLAINT_CODE as COMPLAINT_CODE ");//ML-MMOH-CRF-683			
			sbDocOPMealOrder.append(" ,ds_get_desc.ds_complaints(opdietdtl.COMPLAINT_CODE,? ,'1') COMPLAINT_DESC ");//ML-MMOH-CRF-683
			sbDocOPMealOrder.append(" ,opdietdtl.OTH_COMPLAINT_DESC as OTH_COMPLAINT_DESC ");//Added Against ML-MMOH-CRF-1125
			sbDocOPMealOrder.append(" ,opdietdtl.MEAL_REPLACE_YN as MEAL_REPLACE_YN ");//ML-MMOH-CRF-681
			sbDocOPMealOrder.append(" from oa_appt appt,  mp_patient mp, DS_OP_DIET_ORDER_DTL opdietdtl where  appt.FACILITY_ID = NVL(?, appt.FACILITY_ID) and appt.appt_status='1' ");
			sbDocOPMealOrder.append(" and appt.speciality_code = NVL(?, appt.speciality_code ) and appt.care_locn_type_ind = NVL(?, appt.care_locn_type_ind) ");
			sbDocOPMealOrder.append(" and appt.clinic_code =NVL(?, appt.clinic_code)  and appt.resource_class = NVL(?, appt.resource_class) ");
			sbDocOPMealOrder.append(" and appt.practitioner_id = NVL(?, appt.practitioner_id)  and trunc(opdietdtl.SERVING_DATE) = to_date(?, 'dd/mm/yyyy')   ");
			sbDocOPMealOrder.append(" and opdietdtl.MealType  = NVL(?, opdietdtl.MealType ) and mp.patient_id(+) = appt.patient_id ");
			sbDocOPMealOrder.append(" and appt.appt_ref_no = opdietdtl.App_No  and appt.FACILITY_ID = opdietdtl.FACILITY_ID   "); 
			sbDocOPMealOrder.append(" and mp.patient_id(+) = appt.patient_id ");
			sbDocOPMealOrder.append(" Union ");
			sbDocOPMealOrder.append(" select mp.patient_id as patient_id, mp.patient_name as patient_name, TO_CHAR(appt.appt_date, 'DD/MM/YYYY') as apptDate, nvl(to_char(appt.appt_time,'hh24:mi'),' ') as appt_time, appt.appt_ref_no as apptNo,   ");
			sbDocOPMealOrder.append(" appt.encounter_id as encounterid, TO_CHAR(enct.visit_adm_date_time, 'DD/MM/YYYY HH24:MI')  as visitDate, opdietdtl.Status as status, TO_CHAR(opdietdtl.Acknowledge_Date_Time, 'DD/MM/YYYY HH24:MI') as AckDate");

			sbDocOPMealOrder.append(" ,TO_CHAR (SYSDATE, 'DD/MM/YYYY HH24:MI') AS sys_date ");//ML-MMOH-CRF-681		
			sbDocOPMealOrder.append(" ,opdietdtl.COMPLAINT_CODE as COMPLAINT_CODE ");//ML-MMOH-CRF-683
			sbDocOPMealOrder.append(" ,ds_get_desc.ds_complaints(opdietdtl.COMPLAINT_CODE,?,'1') COMPLAINT_DESC ");//ML-MMOH-CRF-683
			sbDocOPMealOrder.append(" ,opdietdtl.OTH_COMPLAINT_DESC as OTH_COMPLAINT_DESC ");//Added Against ML-MMOH-CRF-1125
			sbDocOPMealOrder.append(" ,opdietdtl.MEAL_REPLACE_YN as MEAL_REPLACE_YN ");//ML-MMOH-CRF-681
			sbDocOPMealOrder.append(" from oa_appt appt, pr_encounter enct, mp_patient mp, DS_OP_DIET_ORDER_DTL opdietdtl ");
			sbDocOPMealOrder.append(" where enct.FACILITY_ID = NVL(?, enct.FACILITY_ID)  and appt.FACILITY_ID = enct.FACILITY_ID");
			sbDocOPMealOrder.append(" and enct.Encounter_id =  appt.Encounter_id and enct.visit_status IN('01','02','03','04','07')  ");
			sbDocOPMealOrder.append(" and enct.appt_case_yn = 'A' and mp.patient_id = enct.patient_id and enct.patient_class='OP' ");
			sbDocOPMealOrder.append(" and enct.specialty_code = NVL(?, enct.specialty_code)	and enct.PAT_CURR_LOCN_TYPE = NVL(?, enct.PAT_CURR_LOCN_TYPE) ");
			sbDocOPMealOrder.append(" and enct.PAT_CURR_LOCN_CODE = NVL(?, enct.PAT_CURR_LOCN_CODE) "+ sResourceQuery );
			sbDocOPMealOrder.append(" and trunc(opdietdtl.SERVING_DATE) = to_date(?, 'dd/mm/yyyy')  and opdietdtl.MealType  = NVL(?, opdietdtl.MealType ) ");
			sbDocOPMealOrder.append(" and appt.appt_ref_no = enct.appt_id and enct.APPT_ID = opdietdtl.APP_NO    ");
			sbDocOPMealOrder.append(" and enct.FACILITY_ID = opdietdtl.FACILITY_ID     ");                                                                  
			sbDocOPMealOrder.append(" Union ");
			sbDocOPMealOrder.append(" select mp.patient_id as patient_id, mp.patient_name as patient_name, TO_CHAR('', 'DD/MM/YYYY') as apptDate, '' as appt_time, '' as apptNo, ");  
			sbDocOPMealOrder.append(" enct.encounter_id as encounterid, TO_CHAR(enct.visit_adm_date_time, 'DD/MM/YYYY HH24:MI') as visitDate, opdietdtl.Status as status, TO_CHAR(opdietdtl.Acknowledge_Date_Time, 'DD/MM/YYYY HH24:MI') as AckDate");

			sbDocOPMealOrder.append(" ,TO_CHAR (SYSDATE, 'DD/MM/YYYY HH24:MI') AS sys_date ");//ML-MMOH-CRF-681	
			sbDocOPMealOrder.append(" ,opdietdtl.COMPLAINT_CODE as COMPLAINT_CODE ");//ML-MMOH-CRF-683			
			sbDocOPMealOrder.append(" ,ds_get_desc.ds_complaints(opdietdtl.COMPLAINT_CODE,?,'1')COMPLAINT_DESC ");//ML-MMOH-CRF-683
			sbDocOPMealOrder.append(" ,opdietdtl.OTH_COMPLAINT_DESC as OTH_COMPLAINT_DESC ");//Added Against ML-MMOH-CRF-1125
			sbDocOPMealOrder.append(" ,opdietdtl.MEAL_REPLACE_YN as MEAL_REPLACE_YN ");//ML-MMOH-CRF-681
			sbDocOPMealOrder.append(" from pr_encounter enct, mp_patient mp, DS_OP_DIET_ORDER_DTL opdietdtl ");
			sbDocOPMealOrder.append(" where enct.FACILITY_ID = NVL(?, enct.FACILITY_ID) and visit_status IN('01','02','03','04','07') ");
			sbDocOPMealOrder.append(" and enct.appt_case_yn = 'W'	and mp.patient_id = enct.patient_id and enct.patient_class='OP' ");
			sbDocOPMealOrder.append(" and enct.specialty_code = NVL(?, enct.specialty_code)	and enct.PAT_CURR_LOCN_TYPE = NVL(?, enct.PAT_CURR_LOCN_TYPE) ");
			sbDocOPMealOrder.append(" and enct.PAT_CURR_LOCN_CODE = NVL(?, enct.PAT_CURR_LOCN_CODE)	"+ sResourceQuery );
			sbDocOPMealOrder.append(" and trunc(opdietdtl.SERVING_DATE) = to_date(?, 'dd/mm/yyyy')  and opdietdtl.MealType  = NVL(?, opdietdtl.MealType ) ");
			sbDocOPMealOrder.append(" and enct.encounter_id = opdietdtl.encounter_id   and enct.FACILITY_ID = opdietdtl.FACILITY_ID " );
			sbDocOPMealOrder.append(" order by visitDate desc, apptDate desc, appt_time desc, apptNo desc ");

			String sql_docOPMealOrder = sbDocOPMealOrder.toString();
					
			System.err.println("323,sql_docOPMealOrder: "+sql_docOPMealOrder);
			int nindex = 1;
			pstmt = conn.prepareStatement(sql_docOPMealOrder);
			
			log.debug("done");
			log.debug("speciality"+speciality);
			log.debug("restype"+restype);
			log.debug("resource"+resource);
			log.debug("locationType"+locationType);
			log.debug("locationCode"+locationCode);
			if(pstmt!=null) pstmt.close();	//Added Against Common-ICN-0031
			//pstmt = conn.prepareStatement(DlQuery.DL_GET_DOCOPMEALORDER);
			pstmt = conn.prepareStatement(sql_docOPMealOrder);

			//Setting for First Main Query:
			pstmt.setString(nindex++, language_id);	
			pstmt.setString(nindex++, facility_id);
			pstmt.setString(nindex++, speciality);
			pstmt.setString(nindex++, locationType);
			pstmt.setString(nindex++, locationCode);
			pstmt.setString(nindex++, restype);
			pstmt.setString(nindex++, resource);
			pstmt.setString(nindex++, servingDate);
			pstmt.setString(nindex++, mealType);
			pstmt.setString(nindex++, language_id);	
			//Setting for First Main Query:
			pstmt.setString(nindex++, facility_id);
			pstmt.setString(nindex++, speciality);
			pstmt.setString(nindex++, locationType);
			pstmt.setString(nindex++, locationCode);
			if(!"".equalsIgnoreCase(restype))
			{
				pstmt.setString(nindex++, restype);
				pstmt.setString(nindex++, resource);
				pstmt.setString(nindex++, restype);
			}
			pstmt.setString(nindex++, servingDate);
			pstmt.setString(nindex++, mealType);
			pstmt.setString(nindex++, language_id);	
			pstmt.setString(nindex++, facility_id);
			pstmt.setString(nindex++, speciality);
			pstmt.setString(nindex++, locationType);
			pstmt.setString(nindex++, locationCode);
			if(!"".equalsIgnoreCase(restype))
			{
				pstmt.setString(nindex++, restype);
				pstmt.setString(nindex++, resource);
				pstmt.setString(nindex++, restype);
			}
			pstmt.setString(nindex++, servingDate);
			pstmt.setString(nindex++, mealType);
			
			rs = pstmt.executeQuery();
			
			while(rs != null && rs.next())
			{
				JSONObject jsonRecord= new JSONObject();
				jsonRecord.put("patient_id", 	isNULL(rs.getString("patient_id")));
				jsonRecord.put("patient_name", 	isNULL(rs.getString("patient_name")));
				jsonRecord.put("ApptDate", 		com.ehis.util.DateUtils.convertDate(rs.getString("apptDate"),"DMY","en",language_id) );
				jsonRecord.put("VisitDate", 	com.ehis.util.DateUtils.convertDate(rs.getString("visitDate"),"DMYHM","en",language_id) );
				jsonRecord.put("ApptTime", 		rs.getString("appt_time"));
				jsonRecord.put("ApptNo", 		rs.getString("apptNo"));
				jsonRecord.put("Encounterid", 	rs.getString("encounterid"));
				jsonRecord.put("status", 		rs.getString("status"));
				jsonRecord.put("AckDate", 		com.ehis.util.DateUtils.convertDate(rs.getString("AckDate"),"DMYHM","en",language_id) );
				jsonRecord.put("sys_date", 		com.ehis.util.DateUtils.convertDate(rs.getString("sys_date"),"DMYHM","en",language_id) );//ML-MMOH-CRF-681				
				jsonRecord.put("complaint_code", 	isEmpty(rs.getString("COMPLAINT_CODE"))); //ML-MMOH-CRF-683
				jsonRecord.put("complaint_desc", 	isEmpty(rs.getString("COMPLAINT_DESC"))); //ML-MMOH-CRF-683
				jsonRecord.put("othersComp_desc", 	isEmpty(rs.getString("OTH_COMPLAINT_DESC"))); //Added Against ML-MMOH-CRF-1125
				jsonRecord.put("MealReplaceYn", 	isNULL(rs.getString("MEAL_REPLACE_YN"))); //ML-MMOH-CRF-681
				jsonList.append("jsonDocOPOrderList", jsonRecord);
			}
		}
		catch(Exception ee){
			System.err.println("DocumentOPMealServlet.java--->"+ee.getMessage());
			ee.printStackTrace();
		}
		finally{
			try{
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null)ConnectionManager.returnConnection(conn,request);
			}catch(Exception e){System.err.println("DocumentOPMealServlet.java--->"+e.getMessage());
			e.printStackTrace();}
		}
		
		System.err.println("285,jsonList===="+jsonList);	
		
		return jsonList;
	}
	
	private JSONObject searchDocMealOrder_EM(HttpServletRequest request,  HttpServletResponse response)
	{
		Connection conn = ConnectionManager.getConnection(request);
		PreparedStatement pstmt=null;
	
		ResultSet rs=null;
		log.debug("declaration:");
		JSONObject jsonList = new JSONObject();
		try{
			log.debug("getting request parameters1::");
			String jsonData = request.getParameter("jsonData");
			JSONObject json = new JSONObject(jsonData);		
			log.debug("getting request parameters::");
			
//			String speciality =  json.getString("speciality");
			String locationType =  json.getString("locationType");
			String locationCode	=  json.getString("locationCode");
			String restype		=  json.getString("restype");
			String resource 	=  json.getString("resource");
			String priorityZone = json.getString("priorityZone");
			String treatmentArea = json.getString("treatmentArea");
			
			String servingDate	=  com.ehis.util.DateUtils.convertDate(json.getString("servingdate"),"DMY", language_id, "en");
			String mealType		=  json.getString("mealType");
			
			String priorityZoneQuery="";
			String treatmentAreaQuery="";
			
			if(!"".equalsIgnoreCase(priorityZone) && !"ALL".equalsIgnoreCase(priorityZone)) {
				priorityZoneQuery= " and enct.priority_zone = '"+priorityZone+"' ";
			}
			
			if(!"".equalsIgnoreCase(treatmentArea) && !"ALL".equalsIgnoreCase(treatmentArea)) {
				treatmentAreaQuery= " and enct.treatment_area_code = '"+treatmentArea+"' ";
			}			
			
			StringBuffer sbDocOPMealOrder = new StringBuffer();
			
			sbDocOPMealOrder.append(" select mp.patient_id as patient_id, mp.patient_name as patient_name,");  
			sbDocOPMealOrder.append(" enct.encounter_id as encounterid, TO_CHAR(enct.visit_adm_date_time, 'DD/MM/YYYY HH24:MI') as visitDate, opdietdtl.Status as status, TO_CHAR(opdietdtl.Acknowledge_Date_Time, 'DD/MM/YYYY HH24:MI') as AckDate");

			sbDocOPMealOrder.append(" ,TO_CHAR (SYSDATE, 'DD/MM/YYYY HH24:MI') AS sys_date ");//ML-MMOH-CRF-681	
			sbDocOPMealOrder.append(" ,opdietdtl.COMPLAINT_CODE as COMPLAINT_CODE ");//ML-MMOH-CRF-683			
			sbDocOPMealOrder.append(" ,ds_get_desc.ds_complaints(opdietdtl.complaint_code,? ,'1') COMPLAINT_DESC"); //ML-MMOH-CRF-683
			sbDocOPMealOrder.append(" ,opdietdtl.OTH_COMPLAINT_DESC as OTH_COMPLAINT_DESC ");//Added Against ML-MMOH-CRF-1125
			sbDocOPMealOrder.append(" ,opdietdtl.MEAL_REPLACE_YN as MEAL_REPLACE_YN ");//ML-MMOH-CRF-681
			sbDocOPMealOrder.append(" from pr_encounter enct, mp_patient mp, DS_EM_DIET_ORDER_DTL opdietdtl ");
			sbDocOPMealOrder.append(" where enct.FACILITY_ID = NVL(?, enct.FACILITY_ID) and visit_status IN('01','02','03','04','07') ");
			sbDocOPMealOrder.append(" and mp.patient_id = enct.patient_id and enct.patient_class='EM' ");
			
			if(!"".equalsIgnoreCase(priorityZone) && !"ALL".equalsIgnoreCase(priorityZone)) {sbDocOPMealOrder.append(priorityZoneQuery);}
			
			if(!"".equalsIgnoreCase(treatmentArea) && !"ALL".equalsIgnoreCase(treatmentArea)) {sbDocOPMealOrder.append(treatmentAreaQuery);}
			
			sbDocOPMealOrder.append(" and enct.PAT_CURR_LOCN_TYPE = NVL(?, enct.PAT_CURR_LOCN_TYPE) ");
			sbDocOPMealOrder.append(" and enct.PAT_CURR_LOCN_CODE = NVL(?, enct.PAT_CURR_LOCN_CODE)	AND NVL(attend_practitioner_id,'X')=NVL(?,NVL(attend_practitioner_id,'X'))" );
			sbDocOPMealOrder.append(" and trunc(opdietdtl.SERVING_DATE) = to_date(?, 'dd/mm/yyyy')  and opdietdtl.Meal_Type  = NVL(?, opdietdtl.Meal_Type ) ");
			sbDocOPMealOrder.append(" and enct.encounter_id = opdietdtl.encounter_id   and enct.FACILITY_ID = opdietdtl.FACILITY_ID " );
			sbDocOPMealOrder.append(" order by visitDate desc");

			String sql_docOPMealOrder = sbDocOPMealOrder.toString();
					
			System.err.println("488, sql_docOPMealOrder: "+sql_docOPMealOrder);
			int nindex = 1;
			pstmt = conn.prepareStatement(sql_docOPMealOrder);
			
			log.debug("done");
			log.debug("restype"+restype);
			log.debug("resource"+resource);
			log.debug("locationType"+locationType);
			log.debug("locationCode"+locationCode);
			if(pstmt!=null) pstmt.close();	//Added Against Common-ICN-0031
			//pstmt = conn.prepareStatement(DlQuery.DL_GET_DOCOPMEALORDER);
			pstmt = conn.prepareStatement(sql_docOPMealOrder);
			pstmt.setString(nindex++, language_id);
			pstmt.setString(nindex++, facility_id);
			pstmt.setString(nindex++, locationType);
			pstmt.setString(nindex++, locationCode);
			pstmt.setString(nindex++, resource);
			pstmt.setString(nindex++, servingDate);
			pstmt.setString(nindex++, mealType);
			
			rs = pstmt.executeQuery();
			
			while(rs != null && rs.next())
			{
				JSONObject jsonRecord= new JSONObject();
				jsonRecord.put("patient_id", 	isNULL(rs.getString("patient_id")));
				jsonRecord.put("patient_name", 	isNULL(rs.getString("patient_name")));
				jsonRecord.put("VisitDate", 	com.ehis.util.DateUtils.convertDate(rs.getString("visitDate"),"DMYHM","en",language_id) );
				jsonRecord.put("Encounterid", 	rs.getString("encounterid"));
				jsonRecord.put("status", 		rs.getString("status"));
				jsonRecord.put("AckDate", 		com.ehis.util.DateUtils.convertDate(rs.getString("AckDate"),"DMYHM","en",language_id) );
				jsonRecord.put("sys_date", 		com.ehis.util.DateUtils.convertDate(rs.getString("sys_date"),"DMYHM","en",language_id) );//ML-MMOH-CRF-681
				jsonRecord.put("MealReplaceYn", isNULL(rs.getString("MEAL_REPLACE_YN"))); //ML-MMOH-CRF-681				
				jsonRecord.put("complaint_code", 		isNULL(rs.getString("COMPLAINT_CODE"))); //ML-MMOH-CRF-683
				jsonRecord.put("complaint_desc", 		isEmpty(rs.getString("COMPLAINT_DESC"))); //ML-MMOH-CRF-683
				jsonRecord.put("othersComp_desc", 	isEmpty(rs.getString("OTH_COMPLAINT_DESC"))); //Added Against ML-MMOH-CRF-1125
				jsonList.append("jsonDocOPOrderList", jsonRecord);
			}
		}
		catch(Exception ee){
			System.err.println("DocumentOPMealServlet.java--->"+ee.getMessage());
			ee.printStackTrace();
		}
		finally{
			try{
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null)ConnectionManager.returnConnection(conn,request);
			}catch(Exception e){System.err.println("DocumentOPMealServlet.java--->"+e.getMessage());
			e.printStackTrace();}
		}
		return jsonList;
	}
	
	private String isNULL(String obj)
	{
		if(obj == null)
			return  "&nbsp";
		else
			return obj;
	}
	
	private String isEmpty(String obj)
	{
		if(obj == null)
			return  "";
		else
			return obj;
	}
	
	/**Method Desc: Document/Acknowledge OP Meal Order**/
	private boolean updateDocMealOrder_OP(HttpServletRequest request,  HttpServletResponse response) 
	{
		Connection conn = null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		boolean bReturn = true;
		try{
			conn = ConnectionManager.getConnection(request);
			
			/* String sPatId  		= (String)request.getParameter("patId0");	
			String sPatName  	= (String)request.getParameter("patName0");
			String speciality	= (String)request.getParameter("speciality"); */ //Common-ICN-0044
			String mealtype		= (String)request.getParameter("mealtype");
			String servingDate	= (String)request.getParameter("servingDate");
			servingDate = com.ehis.util.DateUtils.convertDate(servingDate,"DMY", language_id, "en");
			//String speciality	= (String)request.getParameter("speciality");
			int nRows 		= Integer.parseInt(request.getParameter("nRows"));
			System.err.println("mealtype:"+ mealtype +",servingDate:" +servingDate+",facility_id:"+facility_id);
			for(int index=0; index < nRows ;index++) { 
			//Updation of OPMealorder Header table:
				String status 		= (String)request.getParameter("status"+index);
				String AckDate		= (String)request.getParameter("ackDate"+index);
				AckDate = com.ehis.util.DateUtils.convertDate(AckDate,"DMYHM", language_id, "en");
				String apptNo		= (String)request.getParameter("apptNo"+index).trim();
				String enctId		= (String)request.getParameter("encounterid"+index);
				String MealReplaceYn = (String)request.getParameter("MealReplaceYn"+index);
				String complaintCode = (String)isEmpty(request.getParameter("complaintCode"+index)); //Added Against ML-MMOH-CRF-0683 [IN062278]
				String othersComplaintsDesc = (String)isEmpty(request.getParameter("othersComp"+index)); //Added Against ML-MMOH-CRF-1125
				//Added Against ML-MMOH-CRF-1816 Starts
				if(othersComplaintsDesc.contains("& #39;"))
				othersComplaintsDesc = othersComplaintsDesc.replace("& #39;", "'");	
				//Added Against ML-MMOH-CRF-1816 Ends
				complaintCode = isEmpty((complaintCode)); //Added Against ML-MMOH-CRF-0683 [IN062278]
				MealReplaceYn = isEmpty((MealReplaceYn));
				String reject_by = "";
				int count=0,count1 = 0;
				apptNo	= apptNo.trim();

				StringBuffer str_qry =new StringBuffer();
				str_qry.append("select REJECTED_BY from ds_op_diet_order_dtl where Facility_Id = ?");
				if(apptNo.length() > 1){
					str_qry.append(" and App_No = ?");
				}
				else{
					str_qry.append(" and Encounter_Id = ?");
				}
				str_qry.append(" and MealType= ? and trunc(SERVING_DATE) = to_date(?, 'dd/mm/yyyy')");
				pstmt = conn.prepareStatement(str_qry.toString());
					
				pstmt.setString(++count1, facility_id);
				if(apptNo.length() > 1){
					pstmt.setString(++count1, apptNo);					
				}	
				else{
					pstmt.setString(++count1, enctId);				
				}		
				pstmt.setString(++count1, mealtype);
				pstmt.setString(++count1, servingDate);
				rs = pstmt.executeQuery();
				while(rs != null && rs.next())
					{
						reject_by = isEmpty(rs.getString("REJECTED_BY"));						
					}
				StringBuffer str_appt = new StringBuffer();
				
				str_appt.append("update DS_OP_DIET_ORDER_DTL set status = ?, ACKNOWLEDGE_DATE_TIME = to_date(?,'DD/MM/YYYY hh24:mi'), MEAL_REPLACE_YN=? ");				
				
				if(status.equals("MS")){  //Served  status
					str_appt.append(", SERVED_DATE_TIME=to_date(?,'DD/MM/YYYY hh24:mi')");
				}
				if(status.equals("MR") && reject_by.equals("")){ //Rejected  status
					str_appt.append(", REJECTED_BY=?");
				}
				str_appt.append(", MODIFIED_BY_ID=?");
				str_appt.append(", MODIFIED_DATE=SYSDATE");
				str_appt.append(", COMPLAINT_CODE=?"); //Added Against ML-MMOH-CRF-0683 [IN062278]
				str_appt.append(", OTH_COMPLAINT_DESC=?"); //Added Against ML-MMOH-CRF-1125
				str_appt.append(" where Facility_Id = ?");
				if(apptNo.length() > 1){
					str_appt.append(" and App_No = ?");
				}
				else{
					str_appt.append(" and Encounter_Id = ?");
				}
					str_appt.append(" and MealType= ? and trunc(SERVING_DATE) = to_date(?, 'dd/mm/yyyy')");
				if(pstmt!=null) pstmt.close();	//Added Against Common-ICN-0031
				pstmt = conn.prepareStatement(str_appt.toString());
				pstmt.setString(++count, status);
				pstmt.setString(++count, AckDate);
				pstmt.setString(++count, MealReplaceYn);
				if(status.equals("MS")){  //Served  status
				pstmt.setString(++count, AckDate);
				}
				if(status.equals("MR") && reject_by.equals("")){ //Rejected  status
				pstmt.setString(++count, login_user);
				}
				pstmt.setString(++count, login_user);
				pstmt.setString(++count, complaintCode); //Added Against ML-MMOH-CRF-0683 [IN062278]
				pstmt.setString(++count,othersComplaintsDesc);	//Added Against MOH-CRF-1125
				pstmt.setString(++count, facility_id);
				if(apptNo.length() > 1){
					pstmt.setString(++count, apptNo);
				}	
				else{
					pstmt.setString(++count, enctId);
				}				
				pstmt.setString(++count, mealtype);
				pstmt.setString(++count, servingDate);				
				pstmt.execute();				
			}	
			conn.commit();
				
			bReturn = true;
		}
		catch(Exception ee){
			ee.printStackTrace();
			bReturn = false;
			try {
				if(conn!=null) conn.rollback();
				} 
			catch (SQLException e) {	
					System.err.println("updateDocMealOrder_OP===DocumentOPMealServlet.java--->"+e.getMessage());
					e.printStackTrace();
				}
					System.err.println("updateDocMealOrder_OP====DocumentOPMealServlet.java--->"+ee.getMessage());
		}
		finally{
			try{
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null)ConnectionManager.returnConnection(conn,request);
			}catch(Exception e){
				System.err.println("DocumentOPMealServlet.java--->"+e.getMessage());
				e.printStackTrace();
			}
		}
		return true;
	}
	/**Method Desc: Document/Acknowledge Meal Order for AE Patients**/
	private boolean updateDocMealOrder_EM(HttpServletRequest request,  HttpServletResponse response) 
	{
		Connection conn = null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		boolean bReturn = true;
		try{
			conn = ConnectionManager.getConnection(request);

			String mealtype		= (String)request.getParameter("mealtype");
			String servingDate	= (String)request.getParameter("servingDate");
			servingDate = com.ehis.util.DateUtils.convertDate(servingDate,"DMY", language_id, "en");
			int nRows 		= Integer.parseInt(request.getParameter("nRows"));
			String reject_by = "";			
			
			for(int index=0; index < nRows ;index++) { 
			//Updation of OPMealorder Header table:
				String status 		= (String)request.getParameter("status_EM"+index);
				String AckDate		= (String)request.getParameter("ackDate_EM"+index);
				AckDate = com.ehis.util.DateUtils.convertDate(AckDate,"DMYHM", language_id, "en");
				String enctId		= (String)request.getParameter("encounterid_EM"+index);
				String MealReplaceYn = (String)request.getParameter("MealReplaceYn"+index);
				MealReplaceYn = isEmpty((MealReplaceYn));
				String complaintCode = (String)isEmpty(request.getParameter("complaintCode"+index)); //Added Against ML-MMOH-CRF-0683 [IN062278]
				String othersComplaintsDesc = (String)isEmpty(request.getParameter("othersComp"+index)); //Added Against ML-MMOH-CRF-1125
				complaintCode = isEmpty((complaintCode)); //Added Against ML-MMOH-CRF-0683 [IN062278]
				int count1 = 0;				
				StringBuffer str_em_qry =new StringBuffer();
				str_em_qry.append("select REJECTED_BY from ds_em_diet_order_dtl where Facility_Id = ?");
				str_em_qry.append(" and Encounter_Id = ? and MEAL_TYPE= ? and trunc(SERVING_DATE) = to_date(?, 'dd/mm/yyyy')");
				pstmt = conn.prepareStatement(str_em_qry.toString());
				
				pstmt.setString(1,facility_id);
				pstmt.setString(2,enctId);
				pstmt.setString(3,mealtype);
				pstmt.setString(4,servingDate);
				rs = pstmt.executeQuery();
				while(rs != null && rs.next())
					{
						reject_by = isEmpty(rs.getString("REJECTED_BY"));
					}			
				if(rs!=null) rs.close(); //Common-ICN-0044
				StringBuffer str_em_updt_qry =new StringBuffer();	
				str_em_updt_qry.append("UPDATE ds_em_diet_order_dtl SET status = ?,	acknowledge_date_time = TO_DATE (?, 'DD/MM/YYYY hh24:mi'), MEAL_REPLACE_YN=? ");
				if(status.equals("MS")){  //Served  status
				str_em_updt_qry.append(", SERVED_DATE_TIME=to_date(?,'DD/MM/YYYY hh24:mi')");
				}
				if(status.equals("MR") && reject_by.equals("")){ //Rejected  status
				str_em_updt_qry.append(", REJECTED_BY=?");
				}
				str_em_updt_qry.append(", MODIFIED_BY_ID=?");
				str_em_updt_qry.append(", MODIFIED_DATE=SYSDATE");
				str_em_updt_qry.append(", COMPLAINT_CODE=?"); //Added Against ML-MMOH-CRF-0683 [IN062278]
				str_em_updt_qry.append(", OTH_COMPLAINT_DESC=?"); //Added Against ML-MMOH-CRF-1125
				str_em_updt_qry.append(" WHERE facility_id = ? AND encounter_id = ? AND meal_type = ? AND TRUNC (serving_date) = TO_DATE (?, 'dd/mm/yyyy')");
				if(pstmt!=null) pstmt.close();	//Added Against Common-ICN-0031
				pstmt = conn.prepareStatement(str_em_updt_qry.toString());				
				
				pstmt.setString(++count1, status);
				pstmt.setString(++count1, AckDate);
				pstmt.setString(++count1, MealReplaceYn);
				if(status.equals("MS")){  //Served  status
				pstmt.setString(++count1, AckDate);
				}
				if(status.equals("MR") && reject_by.equals("")){ //Rejected  status
				pstmt.setString(++count1, login_user);
				}
				pstmt.setString(++count1, login_user);
				pstmt.setString(++count1, complaintCode); //Added Against ML-MMOH-CRF-0683 [IN062278]
				pstmt.setString(++count1, othersComplaintsDesc);	//Added Against MOH-CRF-1125
				pstmt.setString(++count1, facility_id);
				pstmt.setString(++count1, enctId);
				pstmt.setString(++count1, mealtype);
				pstmt.setString(++count1, servingDate);				
				pstmt.execute();
				if(pstmt!=null) pstmt.close();	//Common-ICN-0044	
			}
			
			conn.commit();
				
			bReturn = true;
		}
		catch(Exception ee){
			ee.printStackTrace();
			bReturn = false;
			try {
				if(conn!=null) conn.rollback();
				} 
			catch (SQLException e) {
					e.printStackTrace();
					System.err.println("updateDocMealOrder_EM===DocumentOPMealServlet.java--->"+e.getMessage());
				}
			System.err.println("updateDocMealOrder_EM====DocumentOPMealServlet.java--->"+ee.getMessage());
		}
		finally{
			try{
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null)ConnectionManager.returnConnection(conn,request);
			}catch(Exception e){
				System.err.println("updateDocMealOrder_EM====DocumentOPMealServlet.java--->"+e.getMessage());
			}
		}
		return true;
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
			System.err.println("PlaceMealOrderOPServlet.java--->"+ee.getMessage());
			ee.printStackTrace();
		}finally{
			try{
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
			}catch (SQLException e) {
			// TODO Auto-generated catch block
				System.err.println("PlaceMealOrderOPServlet.java--->"+e.getMessage());
				e.printStackTrace();
			}
			if(conn!=null)ConnectionManager.returnConnection(conn,request);
		}
		return jsonResponse;
	}	
}	
