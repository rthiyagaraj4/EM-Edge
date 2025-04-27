/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eRS;

import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import eCommon.Common.*;
import  eCommon.SingleTableHandler.*;
import webbeans.eCommon.*;
import eRS.RSStaffProfileSetup.*;

public class StaffProfileSetupServlet extends HttpServlet{ 

	private ServletConfig config			= null;
	HttpSession session						= null;
	Properties p							= new Properties();
	String client_ip_address				= "";
	String error_value						="";
	String err_value						="";
	String facility_id						="";
	String funcValue				="";
	String role_type				="";
	String staff_type				="";
	String staff_id					="";
	String skill_code				="";
	String proficiency_level		="";
	String task						="";
	String added_by_id				= "";
	String added_at_ws_no			= "";
	String added_facility_id		= "";
	String modified_by_id			= "";
	String modified_at_ws_no		= "";
	String modified_facility_id		= "";
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
			String db_action = request.getParameter("db_action");
			if ( db_action.equalsIgnoreCase("I"))
				insert(request, response);
			if ( db_action.equalsIgnoreCase("U")) 
				modify(request, response);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public void insert(HttpServletRequest request,HttpServletResponse response)throws Exception{

	  funcValue = request.getParameter("funcVal");
	 	if(funcValue.equalsIgnoreCase("Skill")){
			insertSkill(request,response);
		}else if(funcValue.equalsIgnoreCase("training")){
			insertTraining(request,response);
		}else if(funcValue.equalsIgnoreCase("license")){
			insertLicensure(request,response);
		}else if(funcValue.equalsIgnoreCase("expr")){
			insertExperience(request,response);
		}
	}//end of insert

	public void insertSkill(HttpServletRequest request,HttpServletResponse response)throws Exception{
		try{
			HashMap tabData = new HashMap();
			HashMap sqlMap = new HashMap();
			HashMap insertData = new HashMap() ;

			String sql="INSERT INTO rs_staff_skillset (role_type,staff_id,skill_code,proficiency_level,added_by_id,added_date,added_at_ws_no,added_facility_id,modified_by_id,modified_date,modified_at_ws_no,modified_facility_id)VALUES(?,?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?)";
			String insert_staffProfile="INSERT INTO rs_staff_profile (role_type,staff_id,eff_status,staff_type, added_by_id,added_date,added_at_ws_no,added_facility_id,modified_by_id,modified_date,modified_at_ws_no,modified_facility_id)VALUES(?,?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?)";
			
			role_type= request.getParameter("role_type")==null ? "":request.getParameter("role_type");
			staff_type= request.getParameter("staff_type")==null ? "":request.getParameter("staff_type");
			staff_id= request.getParameter("staff_id")==null ? "":request.getParameter("staff_id");
			skill_code= request.getParameter("skillID")==null ? "":request.getParameter("skillID");
			proficiency_level= request.getParameter("prof_level")==null ? "":request.getParameter("prof_level");
			funcValue= request.getParameter("funcVal")==null ? "":request.getParameter("funcVal");
									
			added_by_id 			= p.getProperty( "login_user" ) ;
			modified_by_id			= added_by_id ;
			added_at_ws_no			= client_ip_address;
			added_facility_id		= facility_id;
			modified_at_ws_no		= added_at_ws_no ;
			modified_facility_id	= facility_id ;

			insertData.put("role_type",role_type);
			insertData.put("staff_type",staff_type);
			insertData.put("staff_id",staff_id);
			insertData.put("skill_code",skill_code);
			insertData.put("proficiency_level",proficiency_level);
			insertData.put("added_by_id",added_by_id);
			insertData.put("added_at_ws_no",added_at_ws_no);
			insertData.put("added_facility_id",added_facility_id);
			insertData.put("modified_by_id",modified_by_id);
			insertData.put("modified_at_ws_no",modified_at_ws_no);
			insertData.put("modified_facility_id",modified_facility_id);
			insertData.put("locale",locale);
			
			tabData.put("funcValue",funcValue);
			tabData.put("InsertData",insertData);
			tabData.put("properties", p);
			sqlMap.put("InsertSql",sql); 
			sqlMap.put("Insert_Staff_Profile",insert_staffProfile);

			boolean local_ejbs = false;
			ServletContext context = getServletConfig().getServletContext();
			if ((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) 
			local_ejbs = true;
			Object obj = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/RSStaffProfileSetup", eRS.RSStaffProfileSetup.RSStaffProfileSetupLocalHome.class, local_ejbs);
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
			if(result.equals("true")){
				err_value	="1";
		}else{
				err_value	="0";
		}
		error_value =(String)map.get("message");
		response.sendRedirect("../eRS/jsp/StaffProfileSetupError.jsp?err_num="+error_value+ "&err_value="+err_value);

		}catch(Exception e){
			e.printStackTrace();
		}
		
	}//end of insertSkill

public void insertTraining(HttpServletRequest request,HttpServletResponse response)throws Exception{
		try{
			HashMap tabData = new HashMap();
			HashMap sqlMap = new HashMap();
			HashMap insertData = new HashMap() ;
			
			String sql="INSERT INTO rs_staff_training (role_type,staff_id,training_code,facility_type,facility_id,facility_name,start_date,end_date,certified_yn,remarks,added_by_id,added_date,added_at_ws_no,added_facility_id,modified_by_id, modified_date,modified_at_ws_no,modified_facility_id)VALUES(?,?,?,?,?,?,TO_DATE(?,'dd/mm/yyyy'),TO_DATE(?,'dd/mm/yyyy'),?,?,?,SYSDATE,?,?,?,SYSDATE,?,?)";
			String insert_staffProfile="INSERT INTO rs_staff_profile (role_type,staff_id,eff_status,staff_type, added_by_id,added_date,added_at_ws_no,added_facility_id,modified_by_id,modified_date,modified_at_ws_no,modified_facility_id)VALUES(?,?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?)";

			role_type= request.getParameter("role_type")==null ? "":request.getParameter("role_type");
			staff_type= request.getParameter("staff_type")==null ? "":request.getParameter("staff_type");
			staff_id= request.getParameter("staff_id")==null ? "":request.getParameter("staff_id");
			funcValue= request.getParameter("funcVal")==null ? "":request.getParameter("funcVal");
			String frm_dt= request.getParameter("frm_dt")==null ? "":com.ehis.util.DateUtils.convertDate(request.getParameter("frm_dt"),"DMY",locale,"en");
			String to_dt= request.getParameter("to_dt")==null ? "":com.ehis.util.DateUtils.convertDate(request.getParameter("to_dt"),"DMY",locale,"en");
			String training_code= request.getParameter("training_id")==null ? "":request.getParameter("training_id");
			String fac_type= request.getParameter("training_type")==null ? "":request.getParameter("training_type");
			String fac_id= request.getParameter("org_type")==null ? "":request.getParameter("org_type"); 
			String fac_name = "";
			if(fac_id.equals(""))
				fac_name= request.getParameter("org_txt")==null ? "":request.getParameter("org_txt");
			else
				fac_name= request.getParameter("org_txt1")==null ? "":request.getParameter("org_txt1");
			String cert= request.getParameter("chk")==null ?"N":request.getParameter("chk");
			String remarks= request.getParameter("remarks")==null ? "":request.getParameter("remarks");

			added_by_id 			= p.getProperty( "login_user" ) ;
			modified_by_id			= added_by_id ;
			added_at_ws_no			= client_ip_address;
			added_facility_id		= facility_id;
			modified_at_ws_no		= added_at_ws_no ;
			modified_facility_id	= facility_id ;
	
			insertData.put("role_type",role_type);
			insertData.put("staff_type",staff_type);
			insertData.put("staff_id",staff_id);
			insertData.put("frm_dt",frm_dt);
			insertData.put("to_dt",to_dt);
			insertData.put("training_code",training_code);
			insertData.put("fac_type",fac_type);
			insertData.put("fac_id",fac_id);
			insertData.put("fac_name",fac_name);
			insertData.put("cert",cert);
			insertData.put("remarks",remarks);
			insertData.put("added_by_id",added_by_id);
			insertData.put("added_at_ws_no",added_at_ws_no);
			insertData.put("added_facility_id",added_facility_id);
			insertData.put("modified_by_id",modified_by_id);
			insertData.put("modified_at_ws_no",modified_at_ws_no);
			insertData.put("modified_facility_id",modified_facility_id);
			insertData.put("locale",locale);

			tabData.put("funcValue",funcValue);
			tabData.put("InsertData",insertData);
			tabData.put("properties", p);
			sqlMap.put("InsertSql",sql); 
			sqlMap.put("Insert_Staff_Profile",insert_staffProfile);

			boolean local_ejbs = false;
			ServletContext context = getServletConfig().getServletContext();
			if ((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) 
			local_ejbs = true;
			Object obj = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/RSStaffProfileSetup", eRS.RSStaffProfileSetup.RSStaffProfileSetupLocalHome.class, local_ejbs);
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
			if(result.equals("true")){
				err_value	="1";
			}else{
				err_value	="0";
			}
			error_value =(String)map.get("message");
			response.sendRedirect("../eRS/jsp/StaffProfileSetupError.jsp?err_num="+error_value+ "&err_value="+err_value);
			
		}catch(Exception e){
			e.printStackTrace();
		}		
	}//end of insertTraining

	public void insertLicensure(HttpServletRequest request,HttpServletResponse response)throws Exception{
		try{
			HashMap tabData = new HashMap();
			HashMap sqlMap = new HashMap();
			HashMap insertData = new HashMap() ;
			
			String sql="INSERT INTO rs_staff_licensure(role_type,staff_id,license_code,license_id,issue_date,valid_until,facility_type,facility_id,facility_name,remarks,added_by_id,added_date,added_at_ws_no,added_facility_id,modified_by_id,modified_date,modified_at_ws_no,modified_facility_id) VALUES(?,?,?,?,TO_DATE(?,'dd/mm/yyyy'),TO_DATE(?,'dd/mm/yyyy'),?,?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?)";
			String insert_staffProfile="INSERT INTO rs_staff_profile (role_type,staff_id,eff_status,staff_type, added_by_id,added_date,added_at_ws_no,added_facility_id,modified_by_id,modified_date,modified_at_ws_no,modified_facility_id)VALUES(?,?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?)";

			role_type= request.getParameter("role_type")==null ? "":request.getParameter("role_type");
			staff_type= request.getParameter("staff_type")==null ? "":request.getParameter("staff_type");
			staff_id= request.getParameter("staff_id")==null ? "":request.getParameter("staff_id");
			funcValue= request.getParameter("funcVal")==null ? "":request.getParameter("funcVal");

			String license_code=request.getParameter("license_id")==null ? "":request.getParameter("license_id");
			String license_id=request.getParameter("id_txt")==null ? "":request.getParameter("id_txt");
			String issue_dt=request.getParameter("issue_dt")==null ? "":com.ehis.util.DateUtils.convertDate(request.getParameter("issue_dt"),"DMY",locale,"en");
			String valid_dt=request.getParameter("valid_dt")==null ? "":com.ehis.util.DateUtils.convertDate(request.getParameter("valid_dt"),"DMY",locale,"en");
			String facility_type=request.getParameter("license_type")==null ? "":request.getParameter("license_type");
			String fac_id=request.getParameter("facility_id")==null ? "":request.getParameter("facility_id");
			String facility_name=request.getParameter("orng_name")==null ? "":request.getParameter("orng_name");
			String remarks=request.getParameter("remarks")==null ? "":request.getParameter("remarks");

			added_by_id 			= p.getProperty( "login_user" ) ;
			modified_by_id			= added_by_id ;
			added_at_ws_no			= client_ip_address;
			added_facility_id		= facility_id;
			modified_at_ws_no		= added_at_ws_no ;
			modified_facility_id	= facility_id ;

			insertData.put("role_type",role_type);
			insertData.put("staff_type",staff_type);
			insertData.put("staff_id",staff_id);
			insertData.put("license_code",license_code);
			insertData.put("license_id",license_id);
			insertData.put("issue_dt",issue_dt);
			insertData.put("valid_dt",valid_dt);
			insertData.put("facility_type",facility_type);
			insertData.put("fac_id",fac_id);
			insertData.put("facility_name",facility_name);
			insertData.put("remarks",remarks);
			insertData.put("added_by_id",added_by_id);
			insertData.put("added_at_ws_no",added_at_ws_no);
			insertData.put("added_facility_id",added_facility_id);
			insertData.put("modified_by_id",modified_by_id);
			insertData.put("modified_at_ws_no",modified_at_ws_no);
			insertData.put("modified_facility_id",modified_facility_id);
			insertData.put("locale",locale);

			tabData.put("funcValue",funcValue);
			tabData.put("InsertData",insertData);
			tabData.put("properties", p);
			sqlMap.put("InsertSql",sql); 
			sqlMap.put("Insert_Staff_Profile",insert_staffProfile);

			boolean local_ejbs = false;
			ServletContext context = getServletConfig().getServletContext();
			if ((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) 
			local_ejbs = true;
			Object obj = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/RSStaffProfileSetup", eRS.RSStaffProfileSetup.RSStaffProfileSetupLocalHome.class, local_ejbs);
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
			if(result.equals("true")){
				err_value	="1";
			}else{
				err_value	="0";
			}
			error_value =(String)map.get("message");
			response.sendRedirect("../eRS/jsp/StaffProfileSetupError.jsp?err_num="+error_value+ "&err_value="+err_value);

		}catch(Exception e){
			e.printStackTrace();
		}
		
	}//end of insertLicensure

public void insertExperience(HttpServletRequest request,HttpServletResponse response)throws Exception{
		try{
			HashMap tabData = new HashMap();
			HashMap sqlMap = new HashMap();
			HashMap insertData = new HashMap() ;
			
			String sql="INSERT INTO rs_staff_experience (role_type,staff_id,serial_no,position_code,facility_type,facility_id,facility_name,from_date,TO_DATE,locn_type,workplace_code,workplace_name,grade_code,fte,remarks,added_by_id,added_date,added_at_ws_no,added_facility_id,modified_by_id,modified_date,modified_at_ws_no,modified_facility_id)VALUES(?,?,?,?,?,?,?,TO_DATE(?,'dd/mm/yyyy'),TO_DATE(?,'dd/mm/yyyy'),?,?,?,?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?)";
			String insert_staffProfile="INSERT INTO rs_staff_profile (role_type,staff_id,eff_status,staff_type, added_by_id,added_date,added_at_ws_no,added_facility_id,modified_by_id,modified_date,modified_at_ws_no,modified_facility_id)VALUES(?,?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?)";
			String modify_staffProfile="update rs_staff_profile set grade_code=?, position_code=?,modified_by_id=?,modified_date=SYSDATE,modified_at_ws_no=?,modified_facility_id=? where role_type=? and staff_id=?";
			String select_serialNo="SELECT NVL(MAX(serial_no),0)+1 srlNo FROM rs_staff_experience  WHERE role_type=? AND STAFF_ID=?";
			String check_current_position="select nvl(count(*),0) count from rs_staff_experience where role_type=? and staff_id=? and ((to_date(?,'dd/mm/yyyy') between from_date and nvl(to_date, trunc(sysdate))) or nvl(to_date(?,'dd/mm/yyyy'),trunc(sysdate)) between  from_date and nvl(to_date, trunc(sysdate)))";
			role_type= request.getParameter("role_type")==null ? "":request.getParameter("role_type");
			staff_type= request.getParameter("staff_type")==null ? "":request.getParameter("staff_type");
			staff_id= request.getParameter("staff_id")==null ? "":request.getParameter("staff_id");
			funcValue= request.getParameter("funcVal")==null ? "":request.getParameter("funcVal");

			String position_code= request.getParameter("position_id")==null ? "":request.getParameter("position_id"); 
			String facility_type= request.getParameter("fac_type")==null ? "":request.getParameter("fac_type"); 
			String fac_id= request.getParameter("org_type")==null ? "":request.getParameter("org_type");
			String	facility_name= request.getParameter("facility")==null ? "":request.getParameter("facility");
			String from_date= request.getParameter("frm_dt")==null ? "":com.ehis.util.DateUtils.convertDate(request.getParameter("frm_dt"),"DMY",locale,"en");
			String to_date= request.getParameter("to_dt")==null ? "":com.ehis.util.DateUtils.convertDate(request.getParameter("to_dt"),"DMY",locale,"en");
			String locn_type= request.getParameter("locn_type")==null ? "":request.getParameter("locn_type");
			String workplace_code= request.getParameter("wrkplace_id")==null ? "":request.getParameter("wrkplace_id");
			String workplace_name=request.getParameter("wrkplace")==null ? "":request.getParameter("wrkplace");
			String grade_code=request.getParameter("grade_id")==null ? "":request.getParameter("grade_id");
			String fte=request.getParameter("fte")==null ? "":request.getParameter("fte");
			String remarks= request.getParameter("remarks")==null ? "":request.getParameter("remarks");

			added_by_id 			= p.getProperty( "login_user" ) ;
			modified_by_id			= added_by_id ;
			added_at_ws_no			= client_ip_address;
			added_facility_id		= facility_id;
			modified_at_ws_no		= added_at_ws_no ;
			modified_facility_id	= facility_id ;

			insertData.put("role_type",role_type);
			insertData.put("staff_type",staff_type);
			insertData.put("staff_id",staff_id);
			insertData.put("position_code",position_code);
			insertData.put("facility_type",facility_type);
			insertData.put("facility_id",fac_id);
			insertData.put("facility_name",facility_name);
			insertData.put("from_date",from_date);
			insertData.put("to_date",to_date);
			insertData.put("locn_type",locn_type);
			insertData.put("workplace_code",workplace_code);
			insertData.put("workplace_name",workplace_name);
			insertData.put("grade_code",grade_code);
			insertData.put("fte",fte);
			insertData.put("remarks",remarks);
			insertData.put("added_by_id",added_by_id);
			insertData.put("added_at_ws_no",added_at_ws_no);
			insertData.put("added_facility_id",added_facility_id);
			insertData.put("modified_by_id",modified_by_id);
			insertData.put("modified_at_ws_no",modified_at_ws_no);
			insertData.put("modified_facility_id",modified_facility_id);
			insertData.put("locale",locale);

			tabData.put("funcValue",funcValue);
			tabData.put("InsertData",insertData);
			tabData.put("properties", p);

			sqlMap.put("InsertSql",sql); 
			sqlMap.put("Insert_Staff_Profile",insert_staffProfile);
			sqlMap.put("select_serialNo",select_serialNo);
			sqlMap.put("modify_staffProfile",modify_staffProfile);
			sqlMap.put("check_current_position",check_current_position);

			boolean local_ejbs = false;
			ServletContext context = getServletConfig().getServletContext();
			if ((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) 
			local_ejbs = true;
			Object obj = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/RSStaffProfileSetup", eRS.RSStaffProfileSetup.RSStaffProfileSetupLocalHome.class, local_ejbs);
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
			
			

			if(result.equals("true")){
				err_value	="1";
			}else{
				err_value	="0";
			}
			error_value =(String)map.get("message");
			response.sendRedirect("../eRS/jsp/StaffProfileSetupError.jsp?err_num="+error_value+ "&err_value="+err_value);
		}catch(Exception e){
			e.printStackTrace();
		}		
	}//end of insertExperience

	public void modify(HttpServletRequest request,HttpServletResponse response)throws Exception{
		funcValue = request.getParameter("funcVal");
			if(funcValue.equalsIgnoreCase("Skill")){
				modifySkill(request,response);
			}else if(funcValue.equalsIgnoreCase("training")){
				modifyTraining(request,response);
			}else if(funcValue.equalsIgnoreCase("license")){
				modifyLicensure(request,response);
			}else if(funcValue.equalsIgnoreCase("expr")){
				modifyExperience(request,response);
			}
	}// end of modify 

public void modifySkill(HttpServletRequest request,HttpServletResponse response)throws Exception{
	try{
			HashMap tabData = new HashMap();
			HashMap sqlMap = new HashMap();
			HashMap modifyData = new HashMap() ;

			String ModifySql="UPDATE rs_staff_skillset SET role_type=?,staff_id=?,skill_code=?,proficiency_level=?,modified_by_id=?,modified_date=SYSDATE,modified_at_ws_no=?,modified_facility_id=? WHERE role_type=? AND staff_id=? AND skill_code=?";
			String DelSql="DELETE FROM rs_staff_skillset WHERE role_type=? AND staff_id=? AND skill_code=?";

			role_type= request.getParameter("role_type")==null ? "":request.getParameter("role_type");
			staff_type= request.getParameter("staff_type")==null ? "":request.getParameter("staff_type");
			staff_id= request.getParameter("staff_id")==null ? "":request.getParameter("staff_id");
			skill_code= request.getParameter("skillID")==null ? "":request.getParameter("skillID");
			proficiency_level= request.getParameter("prof_level")==null ? "":request.getParameter("prof_level");
			funcValue= request.getParameter("funcVal")==null ? "":request.getParameter("funcVal");
			task= request.getParameter("task")==null ? "":request.getParameter("task");
			modified_by_id 			= p.getProperty( "login_user" ) ;
			modified_at_ws_no		= client_ip_address;
			modified_facility_id	= facility_id ;

			modifyData.put("role_type",role_type);
			modifyData.put("staff_id",staff_id);
			modifyData.put("skill_code",skill_code);
			modifyData.put("proficiency_level",proficiency_level);
			modifyData.put("task",task);
			modifyData.put("modified_by_id",modified_by_id);
			modifyData.put("modified_at_ws_no",modified_at_ws_no);
			modifyData.put("modified_facility_id",modified_facility_id);
			modifyData.put("locale",locale);

			tabData.put("funcValue",funcValue);
			tabData.put("ModifyData",modifyData);
			tabData.put("properties", p);
			sqlMap.put("ModifySql",ModifySql); 
			sqlMap.put("DelSql",DelSql);
		
			boolean local_ejbs = false;
			ServletContext context = getServletConfig().getServletContext();
			if ((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) 
			local_ejbs = true;
			Object obj = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/RSStaffProfileSetup", eRS.RSStaffProfileSetup.RSStaffProfileSetupLocalHome.class, local_ejbs);
			Object obj1 = obj.getClass().getMethod("create", null).invoke(obj, null);
			Object aobj[] = new Object[2];
			aobj[0] = tabData;
			aobj[1] = sqlMap;
			Class aclass[] = new Class[2];
			aclass[0] = tabData.getClass();
			aclass[1] = sqlMap.getClass();
			HashMap map=(HashMap)obj1.getClass().getMethod("modify", aclass).invoke(obj1, aobj);
			obj1.getClass().getMethod("remove", null).invoke(obj1, null);

			String result = ((Boolean)map.get("result")).toString();
			if(result.equals("true")){
				err_value	="1";
			}else{
				err_value	="0";
			}
			error_value =(String)map.get("message");
			response.sendRedirect("../eRS/jsp/StaffProfileSetupError.jsp?err_num="+error_value+ "&err_value="+err_value);

		}catch(Exception e){
			e.printStackTrace();
		}
}//end of modifySkill
/*****************************************************************************************************/
public void modifyTraining(HttpServletRequest request,HttpServletResponse response)throws Exception{
	try{
			HashMap tabData = new HashMap();
			HashMap sqlMap = new HashMap();
			HashMap modifyData = new HashMap() ;

			String ModifySql="UPDATE rs_staff_training SET certified_yn=?,remarks=?,modified_by_id=?,modified_date=SYSDATE,modified_at_ws_no=?,modified_facility_id=? WHERE role_type=? AND staff_id=? AND training_code=?";
			String DelSql="DELETE FROM rs_staff_training WHERE role_type=? AND staff_id=? AND training_code=?";

			role_type= request.getParameter("role_type")==null ? "":request.getParameter("role_type");
			staff_id= request.getParameter("staff_id")==null ? "":request.getParameter("staff_id");
			funcValue= request.getParameter("funcVal")==null ? "":request.getParameter("funcVal");
			String training_code= request.getParameter("training_id")==null ? "":request.getParameter("training_id");
			String cert= request.getParameter("chk")==null ?"N":request.getParameter("chk");
			String remarks= request.getParameter("remarks")==null ? "":request.getParameter("remarks");
			task= request.getParameter("task")==null ? "":request.getParameter("task");

			modified_by_id 			= p.getProperty( "login_user" ) ;
			modified_at_ws_no		= client_ip_address;
			modified_facility_id	= facility_id ;
			
			modifyData.put("role_type",role_type);
			modifyData.put("staff_id",staff_id);
			modifyData.put("training_code",training_code);
			modifyData.put("task",task);
			modifyData.put("cert",cert);
			modifyData.put("remarks",remarks);
			modifyData.put("modified_by_id",modified_by_id);
			modifyData.put("modified_at_ws_no",modified_at_ws_no);
			modifyData.put("modified_facility_id",modified_facility_id);
			modifyData.put("locale",locale);

			tabData.put("funcValue",funcValue);
			tabData.put("ModifyData",modifyData);
			tabData.put("properties", p);
			sqlMap.put("ModifySql",ModifySql); 
			sqlMap.put("DelSql",DelSql);

			boolean local_ejbs = false;
			ServletContext context = getServletConfig().getServletContext();
			if ((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) 
			local_ejbs = true;
			Object obj = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/RSStaffProfileSetup", eRS.RSStaffProfileSetup.RSStaffProfileSetupLocalHome.class, local_ejbs);
			Object obj1 = obj.getClass().getMethod("create", null).invoke(obj, null);
			Object aobj[] = new Object[2];
			aobj[0] = tabData;
			aobj[1] = sqlMap;
			Class aclass[] = new Class[2];
			aclass[0] = tabData.getClass();
			aclass[1] = sqlMap.getClass();
			HashMap map=(HashMap)obj1.getClass().getMethod("modify", aclass).invoke(obj1, aobj);
			obj1.getClass().getMethod("remove", null).invoke(obj1, null);

			String result = ((Boolean)map.get("result")).toString();
			if(result.equals("true")){
				err_value	="1";
			}else{
				err_value	="0";
			}
			error_value =(String)map.get("message");
			response.sendRedirect("../eRS/jsp/StaffProfileSetupError.jsp?err_num="+error_value+ "&err_value="+err_value);

			}catch(Exception e){
			e.printStackTrace();
		}
}//end of modifySkill

public void modifyLicensure(HttpServletRequest request,HttpServletResponse response)throws Exception{
	try{
			HashMap tabData = new HashMap();
			HashMap sqlMap = new HashMap();
			HashMap modifyData = new HashMap() ;

			String ModifySql="UPDATE rs_staff_licensure SET remarks=?,modified_by_id=?,modified_date=SYSDATE,modified_at_ws_no=?,modified_facility_id=? WHERE role_type=? AND staff_id=? AND license_code=?";
			String DelSql="DELETE FROM rs_staff_licensure WHERE role_type=? AND staff_id=? AND license_code=?";

			role_type= request.getParameter("role_type")==null ? "":request.getParameter("role_type");
			staff_id= request.getParameter("staff_id")==null ? "":request.getParameter("staff_id");
			funcValue= request.getParameter("funcVal")==null ? "":request.getParameter("funcVal");
			String license_code= request.getParameter("license_id")==null ? "":request.getParameter("license_id");
			String remarks= request.getParameter("remarks")==null ? "":request.getParameter("remarks");
			task= request.getParameter("task")==null ? "":request.getParameter("task");

			modified_by_id 			= p.getProperty( "login_user" ) ;
			modified_at_ws_no		= client_ip_address;
			modified_facility_id	= facility_id ;
			
			modifyData.put("role_type",role_type);
			modifyData.put("staff_id",staff_id);
			modifyData.put("license_code",license_code);
			modifyData.put("task",task);
			modifyData.put("remarks",remarks);
			modifyData.put("modified_by_id",modified_by_id);
			modifyData.put("modified_at_ws_no",modified_at_ws_no);
			modifyData.put("modified_facility_id",modified_facility_id);
			modifyData.put("locale",locale);

			tabData.put("funcValue",funcValue);
			tabData.put("ModifyData",modifyData);
			tabData.put("properties", p);
			sqlMap.put("ModifySql",ModifySql); 
			sqlMap.put("DelSql",DelSql);
			
			boolean local_ejbs = false;
			ServletContext context = getServletConfig().getServletContext();
			if ((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) 
			local_ejbs = true;
			Object obj = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/RSStaffProfileSetup", eRS.RSStaffProfileSetup.RSStaffProfileSetupLocalHome.class, local_ejbs);
			Object obj1 = obj.getClass().getMethod("create", null).invoke(obj, null);
			Object aobj[] = new Object[2];
			aobj[0] = tabData;
			aobj[1] = sqlMap;
			Class aclass[] = new Class[2];
			aclass[0] = tabData.getClass();
			aclass[1] = sqlMap.getClass();
			HashMap map=(HashMap)obj1.getClass().getMethod("modify", aclass).invoke(obj1, aobj);
			obj1.getClass().getMethod("remove", null).invoke(obj1, null);

			String result = ((Boolean)map.get("result")).toString();
			if(result.equals("true")){
				err_value	="1";
			}else{
				err_value	="0";
			}
			error_value =(String)map.get("message");
			response.sendRedirect("../eRS/jsp/StaffProfileSetupError.jsp?err_num="+error_value+ "&err_value="+err_value);

			}catch(Exception e){
			e.printStackTrace();
		}
}//end of modifyLicense

public void modifyExperience(HttpServletRequest request,HttpServletResponse response)throws Exception{
	try{
			HashMap tabData = new HashMap();
			HashMap sqlMap = new HashMap();
			HashMap modifyData = new HashMap() ;

			String ModifySql="UPDATE rs_staff_experience SET to_date=to_date(?,'dd/mm/yyyy'), fte=?,remarks=?,modified_by_id=?,modified_date=SYSDATE,modified_at_ws_no=?,modified_facility_id=? WHERE role_type=? AND staff_id=? AND serial_no=?";
			String DelSql="DELETE FROM rs_staff_experience WHERE role_type=? AND staff_id=? AND serial_no=?";

			role_type= request.getParameter("role_type")==null ? "":request.getParameter("role_type");
			staff_id= request.getParameter("staff_id")==null ? "":request.getParameter("staff_id");
			funcValue= request.getParameter("funcVal")==null ? "":request.getParameter("funcVal");
			String to_date= request.getParameter("frm_dt")==null ? "":com.ehis.util.DateUtils.convertDate(request.getParameter("to_dt"),"DMY",locale,"en");
			String serial_no= request.getParameter("serial_no")==null ? "":request.getParameter("serial_no");
			String fte=request.getParameter("fte")==null ? "":request.getParameter("fte");
			String remarks= request.getParameter("remarks")==null ? "":request.getParameter("remarks");
			task= request.getParameter("task")==null ? "":request.getParameter("task");

			modified_by_id 			= p.getProperty( "login_user" ) ;
			modified_at_ws_no		= client_ip_address;
			modified_facility_id	= facility_id ;
			
			modifyData.put("to_date",to_date);
			modifyData.put("role_type",role_type);
			modifyData.put("staff_id",staff_id);
			modifyData.put("serial_no",serial_no);
			modifyData.put("fte",fte);
			modifyData.put("remarks",remarks);
			modifyData.put("task",task);
			
			modifyData.put("modified_by_id",modified_by_id);
			modifyData.put("modified_at_ws_no",modified_at_ws_no);
			modifyData.put("modified_facility_id",modified_facility_id);
			modifyData.put("locale",locale);

			tabData.put("funcValue",funcValue);
			tabData.put("ModifyData",modifyData);
			tabData.put("properties", p);
			sqlMap.put("ModifySql",ModifySql); 
			sqlMap.put("DelSql",DelSql);

			boolean local_ejbs = false;
			ServletContext context = getServletConfig().getServletContext();
			if ((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) 
			local_ejbs = true;
			Object obj = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/RSStaffProfileSetup", eRS.RSStaffProfileSetup.RSStaffProfileSetupLocalHome.class, local_ejbs);
			Object obj1 = obj.getClass().getMethod("create", null).invoke(obj, null);
			Object aobj[] = new Object[2];
			aobj[0] = tabData;
			aobj[1] = sqlMap;
			Class aclass[] = new Class[2];
			aclass[0] = tabData.getClass();
			aclass[1] = sqlMap.getClass();
			HashMap map=(HashMap)obj1.getClass().getMethod("modify", aclass).invoke(obj1, aobj);
			obj1.getClass().getMethod("remove", null).invoke(obj1, null);

			String result = ((Boolean)map.get("result")).toString();
			if(result.equals("true")){
				err_value	="1";
			}else{
				err_value	="0";
			}
			error_value =(String)map.get("message");
			response.sendRedirect("../eRS/jsp/StaffProfileSetupError.jsp?err_num="+error_value+ "&err_value="+err_value);

			}catch(Exception e){
			e.printStackTrace();
		}
	}//end of modifyExperience
}//end of class
