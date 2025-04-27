/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED */
/*	Filename		:	WorkplaceRequirementServlet.java
*	Purpose 		:	This servlet is used to take all the request parameters and
*						put in a Hashtable which will be further given as an argument to the
*						EJB - 
*	Created By		:	Suresh.S
*	Created On		:	08 Dec 2004
*/
/************************************************************************************************/
package eRS;

import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import webbeans.eCommon.*;
import eRS.RSWorkplaceRequirement.*;

public class WorkplaceRequirementServlet extends HttpServlet{ 

	private ServletConfig config			= null;
	HttpSession session						= null;
	Properties p							= new Properties();
	String client_ip_address				= "";
	String error_value						="";
	String facility_id						="";
	String added_by_id				= "";
	String added_at_ws_no			= "";
	String added_facility_id		= "";
	String locale					="";

	public void init(ServletConfig config)throws ServletException{
		super.init(config);
		this.config = config;
	}

	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException	{
		doPost(request,response);
	}

	public synchronized void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException	{

		session = request.getSession(false);
		this.facility_id = (String)session.getAttribute("facility_id");
		this.p = (java.util.Properties) session.getAttribute( "jdbc" ) ;
		this.client_ip_address = p.getProperty("client_ip_address");
		locale=(String)session.getAttribute("LOCALE");

		try{
			request.setCharacterEncoding("UTF-8");
		    response.setContentType("text/html;charset=UTF-8");
			String mode = request.getParameter("mode");
			if ( mode.equalsIgnoreCase("1")) 
				insert(request, response);
			if ( mode.equalsIgnoreCase("2")) 
				modify(request, response);			
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public void insert(HttpServletRequest request,HttpServletResponse response)throws Exception{

		HashMap tabData = new HashMap();
		HashMap sqlMap = new HashMap();
					
		try{
			added_by_id 			= p.getProperty( "login_user" ) ;
			added_at_ws_no			= client_ip_address;
			added_facility_id		= facility_id;
				
			String INSERT_RS_WRKPLACE_REQD_DTL = "insert into rs_workplace_requirement_dtl(facility_id,workplace_code,requirement_id,shift_code,position_code,fr_wday_min,fr_wday_opt,fr_wday_max,fr_nwday_min,fr_nwday_opt,fr_nwday_max,fr_hday_min,fr_hday_opt,fr_hday_max,fr_sbr_staff_wday,fr_sbr_bed_wday,fr_sbr_staff_nwday,fr_sbr_bed_nwday,fr_sbr_staff_hday,fr_sbr_bed_hday,vr_spr_staff_wday,vr_spr_patient_wday,vr_spr_staff_nwday,vr_spr_patient_nwday,vr_spr_staff_hday,vr_spr_patient_hwday,vr_fte_wday,vr_fte_hours_wday,vr_fte_nwday,vr_fte_hours_nwday,vr_fte_hday,vr_fte_hours_hday,added_by_id,added_date,added_at_ws_no, added_facility_id,modified_by_id,modified_date,modified_at_ws_no,modified_facility_id)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?)";
			String SELECT_WRK_CYCLE_BASIS ="SELECT work_cycle_basis FROM rs_parameter WHERE facility_id IN  (SELECT facility_id FROM rs_parameter WHERE facility_id = ? UNION SELECT facility_id FROM rs_parameter WHERE facility_id = '*A' AND NOT EXISTS (SELECT facility_id FROM rs_parameter WHERE facility_id = ?))";
			String INSERT_RS_WRKPLACE_REQD = "insert into rs_workplace_requirement (facility_id,workplace_code,requirement_id,requirement_date_fm,requirement_date_to,requirement_desc,work_cycle_basis,eff_status,added_by_id,added_date,added_at_ws_no,added_facility_id,modified_by_id,modified_date,modified_at_ws_no,modified_facility_id,requirement_type)values(?,?,?,TO_DATE(?,'dd/mm/yyyy'),TO_DATE(?,'dd/mm/yyyy'),?,?,'E',?,sysdate,?,?,?,sysdate,?,?,?)";

			String fac_id=request.getParameter("fac_id")==null ? "":request.getParameter("fac_id");
			String workplace_code=request.getParameter("workplace_code")==null ? "":request.getParameter("workplace_code");
			String requirement_id=request.getParameter("req_id")==null ? "":request.getParameter("req_id");
			String frm_dt		  = request.getParameter("frm_dt")==null ? "":request.getParameter("frm_dt");
			String to_dt		  = request.getParameter("to_dt")==null ? "":request.getParameter("to_dt");
			String reqd_desc	  = request.getParameter("reqd_desc")==null ? "":request.getParameter("reqd_desc");	

			String total_recs	  = request.getParameter("totalRecords");
			int int_total_records = Integer.parseInt(total_recs);
			int count=0;

			for(int i=0; i<int_total_records; i++){

				String select_yn = request.getParameter("select"+i)==null ? "N":request.getParameter("select"+i);
				if(select_yn.equalsIgnoreCase("Y")){

					String dbAction =request.getParameter("dbAction"+i)==null ? "":request.getParameter("dbAction"+i);
	
					String shift_code=request.getParameter("shift_code"+i)==null ? "":request.getParameter("shift_code"+i);
					String position_code=request.getParameter("posiCode"+i)==null ? "":request.getParameter("posiCode"+i);
					String fr_wday_min=request.getParameter("wday_min"+i)==null ? "":request.getParameter("wday_min"+i); 
					String fr_wday_opt=request.getParameter("wday_opt"+i)==null ? "":request.getParameter("wday_opt"+i); 
					String fr_wday_max=request.getParameter("wday_max"+i)==null ? "":request.getParameter("wday_max"+i);
					String fr_nwday_min=request.getParameter("nwday_min"+i)==null ? 
					"":request.getParameter("nwday_min"+i);
					String fr_nwday_opt=request.getParameter("nwday_opt"+i)==null ? "":request.getParameter("nwday_opt"+i);
					String fr_nwday_max=request.getParameter("nwday_max"+i)==null ? "":request.getParameter("nwday_max"+i);
	
					String fr_hday_min=request.getParameter("hday_min"+i)==null ? "":request.getParameter("hday_min"+i);
					String fr_hday_opt=request.getParameter("hday_opt"+i)==null ? "":request.getParameter("hday_min"+i);
					String fr_hday_max=request.getParameter("hday_max"+i)==null ? "":request.getParameter("hday_min"+i);
	
					String fr_sbr_staff_wday=request.getParameter("wday_sb1"+i)==null ? "":request.getParameter("wday_sb1"+i);
					String fr_sbr_bed_wday=request.getParameter("wday_sb2"+i)==null ? "":request.getParameter("wday_sb2"+i);
					String fr_sbr_staff_nwday=request.getParameter("nwday_sb1"+i)==null ? "":request.getParameter("nwday_sb1"+i);
					String fr_sbr_bed_nwday=request.getParameter("nwday_sb2"+i)==null ? "":request.getParameter("nwday_sb2"+i);
					String fr_sbr_staff_hday=request.getParameter("hday_sb1"+i)==null ? "":request.getParameter("hday_sb1"+i);
					String fr_sbr_bed_hday=request.getParameter("hday_sb2"+i)==null ? "":request.getParameter("hday_sb2"+i);

					String vr_spr_staff_wday=request.getParameter("wday_sp1"+i)==null ? "":request.getParameter("wday_sp1"+i);
					String vr_spr_patient_wday=request.getParameter("wday_sp2"+i)==null ? "":request.getParameter("wday_sp2"+i);
					String vr_spr_staff_nwday=request.getParameter("nwday_sp1"+i)==null ? "":request.getParameter("nwday_sp1"+i);
					String vr_spr_patient_nwday=request.getParameter("nwday_sp2"+i)==null ? "":request.getParameter("nwday_sp2"+i);
					String vr_spr_staff_hday=request.getParameter("hday_sp1"+i)==null ? "":request.getParameter("hday_sp1"+i);
					String vr_spr_patient_hwday=request.getParameter("hday_sp2"+i)==null ? "":request.getParameter("hday_sp2"+i);

					String vr_fte_wday=request.getParameter("wday_fte"+i)==null ? "":request.getParameter("wday_fte"+i);
					String vr_fte_hours_wday=request.getParameter("wday_hrs"+i)==null ? "":request.getParameter("wday_hrs"+i);
	
					String vr_fte_nwday=request.getParameter("nwday_fte"+i)==null ? "":request.getParameter("nwday_fte"+i);
					String vr_fte_hours_nwday=request.getParameter("nwday_hrs"+i)==null ? "":request.getParameter("nwday_hrs"+i);
	
					String vr_fte_hday=request.getParameter("hday_fte"+i)==null ? "":request.getParameter("hday_fte"+i);
					String vr_fte_hours_hday=request.getParameter("hday_hrs"+i)==null ? "":request.getParameter("hday_hrs"+i);

					HashMap	insertData	 = new HashMap();		

					insertData.put("db_action",dbAction);
					insertData.put("shift_code",shift_code); 
					insertData.put("position_code",position_code); 
					insertData.put("fr_wday_min",fr_wday_min); 
					insertData.put("fr_wday_opt",fr_wday_opt);
					insertData.put("fr_wday_max",fr_wday_max); 
					insertData.put("fr_nwday_min",fr_nwday_min); 
					insertData.put("fr_nwday_opt",fr_nwday_opt); 
					insertData.put("fr_nwday_max",fr_nwday_max); 
					insertData.put("fr_hday_min",fr_hday_min); 
					insertData.put("fr_hday_opt",fr_hday_opt); 
					insertData.put("fr_hday_max",fr_hday_max); 
					insertData.put("fr_sbr_staff_wday",fr_sbr_staff_wday); 
					insertData.put("fr_sbr_bed_wday",fr_sbr_bed_wday);
					insertData.put("fr_sbr_staff_nwday",fr_sbr_staff_nwday);
					insertData.put("fr_sbr_bed_nwday",fr_sbr_bed_nwday); 
					insertData.put("fr_sbr_staff_hday",fr_sbr_staff_hday );
					insertData.put("fr_sbr_bed_hday",fr_sbr_bed_hday);
					insertData.put("vr_spr_staff_wday",vr_spr_staff_wday); 
					insertData.put("vr_spr_patient_wday",vr_spr_patient_wday); 
					insertData.put("vr_spr_staff_nwday",vr_spr_staff_nwday); 
					insertData.put("vr_spr_patient_nwday",vr_spr_patient_nwday); 
					insertData.put("vr_spr_staff_hday",vr_spr_staff_hday);
					insertData.put("vr_spr_patient_hwday",vr_spr_patient_hwday);
					insertData.put("vr_fte_wday",vr_fte_wday); 
					insertData.put("vr_fte_hours_wday",vr_fte_hours_wday);
					insertData.put("vr_fte_nwday",vr_fte_nwday); 
					insertData.put("vr_fte_hours_nwday",vr_fte_hours_nwday); 
					insertData.put("vr_fte_hday",vr_fte_hday); 
					insertData.put("vr_fte_hours_hday",vr_fte_hours_hday);
					insertData.put("locale",locale);

					tabData.put( ("InsertData"+count++), insertData);
				}
			}
			tabData.put("facility_id",fac_id);
			tabData.put("workplace_code",workplace_code); 
			tabData.put("requirement_id",requirement_id); 
			tabData.put("reqd_desc",reqd_desc);
			tabData.put("frm_dt",frm_dt);
			tabData.put("to_dt",to_dt);
			tabData.put("added_by_id",added_by_id); 
			tabData.put("added_at_ws_no",added_at_ws_no); 
			tabData.put("added_facility_id",added_facility_id);
			tabData.put("totalRecords", String.valueOf(count));
			tabData.put("properties", p);

			sqlMap.put("INSERT_RS_WRKPLACE_REQD_DTL",INSERT_RS_WRKPLACE_REQD_DTL); 
			sqlMap.put("INSERT_RS_WRKPLACE_REQD",INSERT_RS_WRKPLACE_REQD); 
			sqlMap.put("SELECT_WRK_CYCLE_BASIS",SELECT_WRK_CYCLE_BASIS); 						

			boolean local_ejbs = false;
			ServletContext context = getServletConfig().getServletContext();
			if ((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) 
			local_ejbs = true;
			//Object obj = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/ejb/eRS/RSWorkplaceRequirement", eRS.RSWorkplaceRequirement.RSWorkplaceRequirementLocalHome.class, local_ejbs);
			Object obj = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/RSWorkplaceRequirement", eRS.RSWorkplaceRequirement.RSWorkplaceRequirementLocalHome.class, local_ejbs);
			Object obj1 = obj.getClass().getMethod("create", null).invoke(obj, null);
			Object aobj[] = new Object[2];
			aobj[0] = tabData;
			aobj[1] = sqlMap;
			Class aclass[] = new Class[2];
			aclass[0] = tabData.getClass();
			aclass[1] = sqlMap.getClass();
			HashMap map=(HashMap)obj1.getClass().getMethod("insert", aclass).invoke(obj1, aobj);
			obj1.getClass().getMethod("remove", null).invoke(obj1, null);

			String result = ((Boolean)map.get("result")).toString();
			if(result.equals("true"))
				error_value = "Operation Completed Successfully...";
			else
				error_value = "Exception Occured... "+ (String)map.get("msgid");
			response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num="+error_value);

		}catch(Exception e){
			e.printStackTrace();
		}
	}//end of insert

	public void modify(HttpServletRequest request,HttpServletResponse response)throws Exception{

		try{
			HashMap tabData		 = new HashMap();
			HashMap sqlMap		 = new HashMap();

			added_by_id 			= p.getProperty( "login_user" ) ;
			added_at_ws_no			= client_ip_address;
			added_facility_id		= facility_id;

			String MODIFY_RS_WRKPLACE_REQD_DTL ="UPDATE rs_workplace_requirement_dtl SET FR_WDAY_MIN=?,FR_WDAY_OPT=?,FR_WDAY_MAX=?,FR_NWDAY_MIN=?,FR_NWDAY_OPT=?,FR_NWDAY_MAX=?,FR_HDAY_MIN=?, FR_HDAY_OPT=?, FR_HDAY_MAX=?,FR_SBR_STAFF_WDAY=?,FR_SBR_BED_WDAY=?,FR_SBR_STAFF_NWDAY=?, FR_SBR_BED_NWDAY=?,FR_SBR_STAFF_HDAY=?,FR_SBR_BED_HDAY=?,VR_SPR_STAFF_WDAY=?,VR_SPR_PATIENT_WDAY=?,VR_SPR_STAFF_NWDAY=?,VR_SPR_PATIENT_NWDAY=?,VR_SPR_STAFF_HDAY=?,VR_SPR_PATIENT_HWDAY=?,VR_FTE_WDAY=?,VR_FTE_HOURS_WDAY=?,VR_FTE_NWDAY=?,VR_FTE_HOURS_NWDAY=?,VR_FTE_HDAY=?,VR_FTE_HOURS_HDAY=?,MODIFIED_BY_ID=?,MODIFIED_DATE=SYSDATE,MODIFIED_AT_WS_NO=?,MODIFIED_FACILITY_ID=? WHERE 	facility_id = ? AND workplace_code = ? AND requirement_id = ? AND position_code = ? AND shift_code = ?";
			String INSERT_RS_WRKPLACE_REQD_DTL = "insert into rs_workplace_requirement_dtl(facility_id,workplace_code,requirement_id,shift_code,position_code,fr_wday_min,fr_wday_opt,fr_wday_max,fr_nwday_min,fr_nwday_opt,fr_nwday_max,fr_hday_min,fr_hday_opt,fr_hday_max,fr_sbr_staff_wday,fr_sbr_bed_wday,fr_sbr_staff_nwday,fr_sbr_bed_nwday,fr_sbr_staff_hday,fr_sbr_bed_hday,vr_spr_staff_wday,vr_spr_patient_wday,vr_spr_staff_nwday,vr_spr_patient_nwday,vr_spr_staff_hday,vr_spr_patient_hwday,vr_fte_wday,vr_fte_hours_wday,vr_fte_nwday,vr_fte_hours_nwday,vr_fte_hday,vr_fte_hours_hday,added_by_id,added_date,added_at_ws_no, added_facility_id,modified_by_id,modified_date,modified_at_ws_no,modified_facility_id)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?)";
			String SELECT_WRK_CYCLE_BASIS ="SELECT work_cycle_basis FROM rs_parameter WHERE facility_id IN  (SELECT facility_id FROM rs_parameter WHERE facility_id = ? UNION SELECT facility_id FROM rs_parameter WHERE facility_id = '*A' AND NOT EXISTS (SELECT facility_id FROM rs_parameter WHERE facility_id = ?))";
			String INSERT_RS_WRKPLACE_REQD = "insert into rs_workplace_requirement (facility_id,workplace_code,requirement_id,requirement_date_fm,requirement_date_to,requirement_desc,work_cycle_basis,eff_status,added_by_id,added_date,added_at_ws_no,added_facility_id,modified_by_id,modified_date,modified_at_ws_no,modified_facility_id,requirement_type)values(?,?,?,TO_DATE(?,'dd/mm/yyyy'),TO_DATE(?,'dd/mm/yyyy'),?,?,'E',?,sysdate,?,?,?,sysdate,?,?,?)";
			String MODIFY_RS_WRKPLACE_REQD = "update rs_workplace_requirement set requirement_type='V', requirement_date_fm=trunc(added_date), requirement_date_to=trunc(sysdate), modified_by_id=?,modified_date=sysdate, modified_at_ws_no=?,modified_facility_id=? where facility_id=? and workplace_code=? and requirement_id=?";

			String fac_id=request.getParameter("fac_id")==null ? "":request.getParameter("fac_id");
			String workplace_code=request.getParameter("workplace_code")==null ? "":request.getParameter("workplace_code");
			String requirement_id=request.getParameter("req_id")==null ? "":request.getParameter("req_id");
			String frm_dt		  = request.getParameter("frm_dt")==null ? "":request.getParameter("frm_dt");
			String to_dt		  = request.getParameter("to_dt")==null ? "":request.getParameter("to_dt");
			String reqd_desc	  = request.getParameter("reqd_desc")==null ? "":request.getParameter("reqd_desc");	

			String total_recs	  = request.getParameter("totalRecords");
			int int_total_records = Integer.parseInt(total_recs);
			int count=0;

			for(int i=0; i<int_total_records; i++){

				String select_yn = request.getParameter("select"+i)==null ? "N":request.getParameter("select"+i);
				if(select_yn.equalsIgnoreCase("Y")){

					String dbAction =request.getParameter("dbAction"+i)==null ? "":request.getParameter("dbAction"+i);
	
					String shift_code=request.getParameter("shift_code"+i)==null ? "":request.getParameter("shift_code"+i);
					String position_code=request.getParameter("posiCode"+i)==null ? "":request.getParameter("posiCode"+i);
					String fr_wday_min=request.getParameter("wday_min"+i)==null ? "":request.getParameter("wday_min"+i); 
					String fr_wday_opt=request.getParameter("wday_opt"+i)==null ? "":request.getParameter("wday_opt"+i); 
					String fr_wday_max=request.getParameter("wday_max"+i)==null ? "":request.getParameter("wday_max"+i);
					String fr_nwday_min=request.getParameter("nwday_min"+i)==null ? 
					"":request.getParameter("nwday_min"+i);
					String fr_nwday_opt=request.getParameter("nwday_opt"+i)==null ? "":request.getParameter("nwday_opt"+i);
					String fr_nwday_max=request.getParameter("nwday_max"+i)==null ? "":request.getParameter("nwday_max"+i);
	
					String fr_hday_min=request.getParameter("hday_min"+i)==null ? "":request.getParameter("hday_min"+i);
					String fr_hday_opt=request.getParameter("hday_opt"+i)==null ? "":request.getParameter("hday_min"+i);
					String fr_hday_max=request.getParameter("hday_max"+i)==null ? "":request.getParameter("hday_min"+i);
	
					String fr_sbr_staff_wday=request.getParameter("wday_sb1"+i)==null ? "":request.getParameter("wday_sb1"+i);
					String fr_sbr_bed_wday=request.getParameter("wday_sb2"+i)==null ? "":request.getParameter("wday_sb2"+i);
					String fr_sbr_staff_nwday=request.getParameter("nwday_sb1"+i)==null ? "":request.getParameter("nwday_sb1"+i);
					String fr_sbr_bed_nwday=request.getParameter("nwday_sb2"+i)==null ? "":request.getParameter("nwday_sb2"+i);
					String fr_sbr_staff_hday=request.getParameter("hday_sb1"+i)==null ? "":request.getParameter("hday_sb1"+i);
					String fr_sbr_bed_hday=request.getParameter("hday_sb2"+i)==null ? "":request.getParameter("hday_sb2"+i);

					String vr_spr_staff_wday=request.getParameter("wday_sp1"+i)==null ? "":request.getParameter("wday_sp1"+i);
					String vr_spr_patient_wday=request.getParameter("wday_sp2"+i)==null ? "":request.getParameter("wday_sp2"+i);
					String vr_spr_staff_nwday=request.getParameter("nwday_sp1"+i)==null ? "":request.getParameter("nwday_sp1"+i);
					String vr_spr_patient_nwday=request.getParameter("nwday_sp2"+i)==null ? "":request.getParameter("nwday_sp2"+i);
					String vr_spr_staff_hday=request.getParameter("hday_sp1"+i)==null ? "":request.getParameter("hday_sp1"+i);
					String vr_spr_patient_hwday=request.getParameter("hday_sp2"+i)==null ? "":request.getParameter("hday_sp2"+i);

					String vr_fte_wday=request.getParameter("wday_fte"+i)==null ? "":request.getParameter("wday_fte"+i);
					String vr_fte_hours_wday=request.getParameter("wday_hrs"+i)==null ? "":request.getParameter("wday_hrs"+i);
	
					String vr_fte_nwday=request.getParameter("nwday_fte"+i)==null ? "":request.getParameter("nwday_fte"+i);
					String vr_fte_hours_nwday=request.getParameter("nwday_hrs"+i)==null ? "":request.getParameter("nwday_hrs"+i);
	
					String vr_fte_hday=request.getParameter("hday_fte"+i)==null ? "":request.getParameter("hday_fte"+i);
					String vr_fte_hours_hday=request.getParameter("hday_hrs"+i)==null ? "":request.getParameter("hday_hrs"+i);

					HashMap	insertData	 = new HashMap();		

					insertData.put("db_action",dbAction);
					insertData.put("shift_code",shift_code); 
					insertData.put("position_code",position_code); 
					insertData.put("fr_wday_min",fr_wday_min); 
					insertData.put("fr_wday_opt",fr_wday_opt);
					insertData.put("fr_wday_max",fr_wday_max); 
					insertData.put("fr_nwday_min",fr_nwday_min); 
					insertData.put("fr_nwday_opt",fr_nwday_opt); 
					insertData.put("fr_nwday_max",fr_nwday_max); 
					insertData.put("fr_hday_min",fr_hday_min); 
					insertData.put("fr_hday_opt",fr_hday_opt); 
					insertData.put("fr_hday_max",fr_hday_max); 
					insertData.put("fr_sbr_staff_wday",fr_sbr_staff_wday); 
					insertData.put("fr_sbr_bed_wday",fr_sbr_bed_wday);
					insertData.put("fr_sbr_staff_nwday",fr_sbr_staff_nwday);
					insertData.put("fr_sbr_bed_nwday",fr_sbr_bed_nwday); 
					insertData.put("fr_sbr_staff_hday",fr_sbr_staff_hday );
					insertData.put("fr_sbr_bed_hday",fr_sbr_bed_hday);
					insertData.put("vr_spr_staff_wday",vr_spr_staff_wday); 
					insertData.put("vr_spr_patient_wday",vr_spr_patient_wday); 
					insertData.put("vr_spr_staff_nwday",vr_spr_staff_nwday); 
					insertData.put("vr_spr_patient_nwday",vr_spr_patient_nwday); 
					insertData.put("vr_spr_staff_hday",vr_spr_staff_hday);
					insertData.put("vr_spr_patient_hwday",vr_spr_patient_hwday);
					insertData.put("vr_fte_wday",vr_fte_wday); 
					insertData.put("vr_fte_hours_wday",vr_fte_hours_wday);
					insertData.put("vr_fte_nwday",vr_fte_nwday); 
					insertData.put("vr_fte_hours_nwday",vr_fte_hours_nwday); 
					insertData.put("vr_fte_hday",vr_fte_hday); 
					insertData.put("vr_fte_hours_hday",vr_fte_hours_hday);
					insertData.put("locale",locale);

					tabData.put( ("InsertData"+count++), insertData);
				}
			}
			tabData.put("facility_id",fac_id);
			tabData.put("workplace_code",workplace_code); 
			tabData.put("requirement_id",requirement_id); 
			tabData.put("reqd_desc",reqd_desc);
			tabData.put("frm_dt",frm_dt);
			tabData.put("to_dt",to_dt);
			tabData.put("added_by_id",added_by_id); 
			tabData.put("added_at_ws_no",added_at_ws_no); 
			tabData.put("added_facility_id",added_facility_id);
			tabData.put("totalRecords", String.valueOf(count));
			tabData.put("properties", p);

			sqlMap.put("INSERT_RS_WRKPLACE_REQD_DTL",INSERT_RS_WRKPLACE_REQD_DTL); 
			sqlMap.put("INSERT_RS_WRKPLACE_REQD",INSERT_RS_WRKPLACE_REQD); 
			sqlMap.put("MODIFY_RS_WRKPLACE_REQD",MODIFY_RS_WRKPLACE_REQD); 
			sqlMap.put("MODIFY_RS_WRKPLACE_REQD_DTL",MODIFY_RS_WRKPLACE_REQD_DTL); 
			sqlMap.put("SELECT_WRK_CYCLE_BASIS",SELECT_WRK_CYCLE_BASIS); 

			/*	RSWorkplaceRequirementHome home = null;
				RSWorkplaceRequirementRemote remote = null;
				
				InitialContext context = new InitialContext() ;
				Object object = context.lookup("java:comp/env/ejb/eRS/RSWorkplaceRequirement");
				home = (RSWorkplaceRequirementHome) PortableRemoteObject.narrow( object, RSWorkplaceRequirementHome.class ) ;
				remote = home.create() ;
				HashMap map = remote.modify(tabData, sqlMap ) ;
				*/
			boolean local_ejbs = false;
			ServletContext context = getServletConfig().getServletContext();
			if ((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) 
			local_ejbs = true;
			Object obj = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/RSWorkplaceRequirement", eRS.RSWorkplaceRequirement.RSWorkplaceRequirementLocalHome.class, local_ejbs);
			Object obj1 = obj.getClass().getMethod("create", null).invoke(obj, null);
			Object aobj[] = new Object[2];
			aobj[0] = tabData;
			aobj[1] = sqlMap;
			Class aclass[] = new Class[2];
			aclass[0] = tabData.getClass();
			aclass[1] = sqlMap.getClass();
			HashMap map=(HashMap)obj1.getClass().getMethod("modify", aclass).invoke(obj1, aobj);
			obj1.getClass().getMethod("remove", null).invoke(obj1, null);

			error_value =  (String)map.get("message");
			response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num="+error_value);
		}catch(Exception e){
			e.printStackTrace();
		}
	}//end of modify
}//end of class
