/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eRS;

import java.io.* ;
import java.rmi.*;
import java.util.* ;
import java.sql.*;
import eCommon.Common.*;
import webbeans.eCommon.*;
import javax.servlet.*;
import javax.servlet.http.*;
import  eCommon.SingleTableHandler.*;

public class ShiftPatternForWorkplaceServlet extends HttpServlet{

	private ServletConfig config = null;
	HttpSession session = null;

	String facility_id = "";
	Properties p = new Properties();
	String client_ip_address = "";
	String error_value ="";
	String err_num="";

	String shift_pattern_id = "";
	String workplace_code = "";
	String added_by_id = "";
	String added_at_ws_no = "";
	String added_facility_id = "";
	
	public void init(ServletConfig config)throws ServletException{
		super.init(config);
		this.config = config;
	}

	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException	{
		doPost(request,response);
	}
	/**************************************************/
	public synchronized void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException	{

		session = request.getSession(false);
		facility_id = (String)session.getAttribute("facility_id");
		this.p = (java.util.Properties) session.getAttribute( "jdbc" ) ;
		this.client_ip_address = p.getProperty("client_ip_address");		

		try{
			
			request.setCharacterEncoding("UTF-8");
		    response.setContentType("text/html;charset=UTF-8"); 

			String mode = request.getParameter("mode");
			if ( mode.equals("1")) insert(request, response);

		}catch(Exception e){
			e.printStackTrace();
		}
	}

	/**************************************************/
	public void insert(HttpServletRequest request,HttpServletResponse response)throws Exception{		
		try{

			HashMap map=new HashMap();
			String sql_insert = "insert into rs_shift_pattern_for_workplace (facility_id,workplace_code,shift_pattern_id, eff_status, added_by_id,added_date,added_at_ws_no,added_facility_id,modified_by_id,modified_date,modified_at_ws_no,modified_facility_id) values (?,?,?,?,?,sysdate,?,?,?,sysdate,?,?)";
			String sql_update = "update rs_shift_pattern_for_workplace set efF_status=? where facility_id=? and workplace_code=? and shift_pattern_id=?";
			String select_yn;
			String db_action;
			String totalRecords;
			HashMap tabData = new HashMap();
			HashMap sqlMap = new HashMap();
			ArrayList insertData = new ArrayList() ;
					
			added_by_id 	= p.getProperty( "login_user" ) ;
			added_at_ws_no	= client_ip_address;
			added_facility_id= facility_id;
			String form_name=request.getParameter("form_name");
			totalRecords=request.getParameter("totalRecords");
			int int_totalRecords = Integer.parseInt(totalRecords);
			
			/*****************************insert by Workplace*********************/

			if(form_name.equalsIgnoreCase("form_listShiftPattern")){
				for(int i=0; i<int_totalRecords; i++){
				workplace_code = request.getParameter("workplace_code")==null ? "":request.getParameter("workplace_code");
					shift_pattern_id = request.getParameter("shift_pattern_id"+i)==null ? "":request.getParameter("shift_pattern_id"+i);
					select_yn		= request.getParameter("select_yn"+i)==null ? "":request.getParameter("select_yn"+i);
					db_action		= request.getParameter("db_action"+i)==null ? "":request.getParameter("db_action"+i);
					if(select_yn==null ||select_yn.equals(""))
						select_yn="N";
					if (db_action.equals("")|| (db_action==null))
						db_action="N";

					if(db_action.equalsIgnoreCase("U")){
						if(select_yn.equalsIgnoreCase("N")){
							insertData.clear();
							tabData.clear();
							insertData.add("D");
							insertData.add(facility_id);
							insertData.add(workplace_code);
							insertData.add(shift_pattern_id);
							tabData.put( "InsertData", insertData);
							tabData.put( "properties",	p) ;
							try{
								sqlMap.clear();
								sqlMap.put( "InsertSQL", sql_update);
							}catch(Exception e){
									e.printStackTrace();
							}
						 }else if (select_yn.equalsIgnoreCase("Y")){
								insertData.clear();
								tabData.clear();
								insertData.add("E");
								insertData.add(facility_id);
								insertData.add(workplace_code);
								insertData.add(shift_pattern_id);
								tabData.put( "InsertData", insertData);
								tabData.put( "properties",	p) ;
								try{
									sqlMap.clear();
									sqlMap.put( "InsertSQL", sql_update);
								}catch(Exception e){
										e.printStackTrace();
								}
						}
					}else if(db_action.equalsIgnoreCase("I")){
						if(select_yn.equalsIgnoreCase("Y")){
							insertData.clear();
							tabData.clear();
							insertData.add(facility_id);
							insertData.add(workplace_code);
							insertData.add(shift_pattern_id);
							insertData.add("E");
							insertData.add(added_by_id);
							insertData.add(added_at_ws_no);
							insertData.add(added_facility_id);
							insertData.add(added_by_id);
							insertData.add(added_at_ws_no);
							insertData.add(added_facility_id);
							tabData.put( "InsertData", insertData);
							tabData.put( "properties",	p ) ;
							try{
								sqlMap.clear();
								sqlMap.put( "InsertSQL", sql_insert);
							}catch(Exception e){
									e.printStackTrace();
							}
						}else if (select_yn.equalsIgnoreCase("N")){
							insertData.clear();
							tabData.clear();
							sqlMap.clear();
						}
					}
				if(!(tabData.isEmpty()) && !(sqlMap.isEmpty())){
					boolean local_ejbs = false;
					ServletContext context = getServletConfig().getServletContext();
					if ((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) 
					local_ejbs = true;
					Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTableHandler",SingleTableHandlerLocalHome.class,local_ejbs);
					Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
					Object argArray[] = new Object[2];
					argArray[0] =tabData;
					argArray[1] =sqlMap;

					Class [] paramArray = new Class[2];
					paramArray[0] =tabData.getClass();
					paramArray[1] =sqlMap.getClass();
					
					map = (HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
					(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

					String result = ((Boolean)map.get("result")).toString();
					if(result.equals("true")){
						error_value ="1";
						err_num= "APP-SM0001 Operation Completed Successfully...";
					}
					else{
						err_num = "Exception Occured... "+ (String)map.get("msgid");
						error_value="0";
					}
				}
			}
			response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num="+err_num+"&err_value="+error_value);
		}
		/*********************Insert by ShiftPattern*******************************/
		else
		if(form_name.equalsIgnoreCase("form_listWorkplace")){
			shift_pattern_id = request.getParameter("shift_pattern_id")==null ? "":request.getParameter("shift_pattern_id");
			for(int i=0; i<int_totalRecords; i++){
				workplace_code = request.getParameter("workplace_code"+i)==null ? "":request.getParameter("workplace_code"+i);
				select_yn		= request.getParameter("select_yn"+i)==null ? "":request.getParameter("select_yn"+i);
				db_action		= request.getParameter("db_action"+i)==null ? "":request.getParameter("db_action"+i);
				if(select_yn==null ||select_yn.equals(""))
					select_yn="N";
				if (db_action.equals("")|| (db_action==null))
					db_action="N";
				if(db_action.equalsIgnoreCase("U")){
					if(select_yn.equalsIgnoreCase("N")){
							insertData.clear();
							tabData.clear();
							insertData.add("D");
							insertData.add(facility_id);
							insertData.add(workplace_code);
							insertData.add(shift_pattern_id);
							tabData.put( "InsertData", insertData);
							tabData.put( "properties",	p) ;
							try{
								sqlMap.clear();
								sqlMap.put( "InsertSQL", sql_update);
							}catch(Exception e){
									e.printStackTrace();
							}
					 }else if (select_yn.equalsIgnoreCase("Y")){
							insertData.clear();
							tabData.clear();
							insertData.add("E");
							insertData.add(facility_id);
							insertData.add(workplace_code);
							insertData.add(shift_pattern_id);
							tabData.put( "InsertData", insertData);
							tabData.put( "properties",	p) ;
							try{
								sqlMap.clear();
								sqlMap.put( "InsertSQL", sql_update);
							}catch(Exception e){
									e.printStackTrace();
							}
					}
				}else if(db_action.equalsIgnoreCase("I")){
					if(select_yn.equalsIgnoreCase("Y")){
						insertData.clear();
						tabData.clear();
						insertData.add(facility_id);
						insertData.add(workplace_code);
						insertData.add(shift_pattern_id);
						insertData.add("E");
						insertData.add(added_by_id);
						insertData.add(added_at_ws_no);
						insertData.add(added_facility_id);
						insertData.add(added_by_id);
						insertData.add(added_at_ws_no);
						insertData.add(added_facility_id);
						tabData.put( "InsertData", insertData);
						tabData.put( "properties",	p ) ;
						try{
							sqlMap.clear();
							sqlMap.put( "InsertSQL", sql_insert);
						}catch(Exception e){	 
								e.printStackTrace();
						}
					}else if (select_yn.equalsIgnoreCase("N")){
						insertData.clear();
						tabData.clear();
						sqlMap.clear();
					}
				}	
				if(!(tabData.isEmpty()) && !(sqlMap.isEmpty())){
					boolean local_ejbs = false;
					ServletContext context = getServletConfig().getServletContext();
					if ((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) 
					local_ejbs = true;
					Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTableHandler",SingleTableHandlerLocalHome.class,local_ejbs);
					Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
					Object argArray[] = new Object[2];
					argArray[0] =tabData;
					argArray[1] =sqlMap;

					Class [] paramArray = new Class[2];
					paramArray[0] =tabData.getClass();
					paramArray[1] =sqlMap.getClass();
					
					map = (HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
					(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

					String result = ((Boolean)map.get("result")).toString();
					if(result.equals("true")){
						error_value ="1";
						err_num= "APP-SM0001 Operation Completed Successfully...";
					}
					else{
						err_num = "Exception Occured... "+ (String)map.get("msgid");
						error_value="0";
					}
				}
			}
			response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num="+err_num+"&err_value="+error_value);
		}
	}catch(Exception e){
		e.printStackTrace();
		}
	}
}
