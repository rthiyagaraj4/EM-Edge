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
import webbeans.eCommon.*;
import  eCommon.SingleTableHandler.*;

public class MasterScheduleServlet extends HttpServlet{

	private ServletConfig config = null;
	HttpSession session = null;

	Properties p = new Properties();
	String client_ip_address = "";
	String error_value ="";

	String facility_id = "";
	String workplace_code = "";
	String requirement_id= "";
	String position_code="";
	String role_type="";
	String staff_type="";
	String staff_id="";
	String week_no="";
	String day_no = "";
	String shift_code = "";
	String shift_mnemonic= "";
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

			insert(request, response);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	/**************************************************/
	public void insert(HttpServletRequest request,HttpServletResponse response)throws Exception{
		
		try{

			String sql_insert = "insert into rs_master_schedule (facility_id,workplace_code, requirement_id, role_type, staff_type, position_code, staff_id,week_no,day_no, shift_code, shift_mnemonic, added_by_id, added_date, added_at_ws_no, added_facility_id, modified_by_id, modified_date, modified_at_ws_no, modified_facility_id) values (?,?,?,?,?,?,?,?,?,?,?,?,sysdate,?,?,?,sysdate,?,?)";
			String sql_update = "update rs_master_schedule set shift_code=?, shift_mnemonic=? where facility_id=? and workplace_code=? and requirement_id=? and role_type=? and staff_type=? and position_code=? and staff_id=? and week_no=? and day_no=?";
			String sql_delete = "delete from rs_master_schedule where facility_id=? and workplace_code=? and requirement_id=? and role_type=? and staff_type=? and position_code=? and staff_id=? and week_no=? and day_no=?";

			HashMap map=new HashMap();
			HashMap tabData = new HashMap();
			HashMap sqlMap = new HashMap();
			ArrayList insertData = new ArrayList() ;
			added_by_id 	= p.getProperty( "login_user" ) ;
			added_at_ws_no	= client_ip_address;
			added_facility_id= facility_id;

			String totalRecords=request.getParameter("total_records")==null?"0":request.getParameter("total_records");
			int total_records=Integer.parseInt(totalRecords);
			facility_id = request.getParameter("facility_id")==null ? "":request.getParameter("facility_id");
			workplace_code = request.getParameter("workplace_code")==null ? "":request.getParameter("workplace_code");
			requirement_id = request.getParameter("requirement_id")==null ? "":request.getParameter("requirement_id");
			week_no=request.getParameter("week_no")==null ? "":request.getParameter("week_no");

			for(int i=0;i<total_records;i++){

				staff_id= request.getParameter("staff"+i)==null ? "":request.getParameter("staff"+i);
				role_type= request.getParameter("role_type"+i)==null ? "":request.getParameter("role_type"+i);
				staff_type= request.getParameter("staff_type"+i)==null ? "":request.getParameter("staff_type"+i);
				position_code= request.getParameter("position_code"+i)==null ? "":request.getParameter("position_code"+i);

				for(int day=0;day<7;day++){
					insertData.clear();
					tabData.clear();
					sqlMap.clear();

					day_no=String.valueOf(day+1);
					shift_code= request.getParameter("shift_code"+role_type+staff_id+day)==null ? "":request.getParameter("shift_code"+role_type+staff_id+day);
					shift_mnemonic= request.getParameter("shift"+role_type+staff_id+day)==null ? "":request.getParameter("shift"+role_type+staff_id+day);
					String db_action= request.getParameter("db_action"+role_type+staff_id+day)==null ? "":request.getParameter("db_action"+role_type+staff_id+day);

					if(((shift_mnemonic.equals(""))||(shift_mnemonic==null))&&(db_action.equals("I")))
						continue;

					if(db_action.equalsIgnoreCase("I")){

						insertData.clear();
						tabData.clear();

						insertData.add(facility_id);
						insertData.add(workplace_code);
						insertData.add(requirement_id);
						insertData.add(role_type);
						insertData.add(staff_type);
						insertData.add(position_code);
						insertData.add(staff_id);
						insertData.add(week_no);
						insertData.add(day_no);
						insertData.add(shift_code);
						insertData.add(shift_mnemonic);
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
				}
				else if(((shift_mnemonic.equals(""))||(shift_mnemonic==null))&&(db_action.equals("U"))){

						insertData.clear();
						tabData.clear();
						insertData.add(facility_id);
						insertData.add(workplace_code);
						insertData.add(requirement_id);
						insertData.add(role_type);
						insertData.add(staff_type);
						insertData.add(position_code);
						insertData.add(staff_id);
						insertData.add(week_no);
						insertData.add(day_no);
						tabData.put( "InsertData", insertData);
						tabData.put( "properties",	p ) ;
						try{
							sqlMap.clear();
							sqlMap.put( "InsertSQL", sql_delete);
						}catch(Exception e){
							e.printStackTrace();
						}
				}
				else 	if(db_action.equalsIgnoreCase("U")){

						insertData.clear();
						tabData.clear();
						insertData.add(shift_code);
						insertData.add(shift_mnemonic);
						insertData.add(facility_id);
						insertData.add(workplace_code);
						insertData.add(requirement_id);
						insertData.add(role_type);
						insertData.add(staff_type);
						insertData.add(position_code);
						insertData.add(staff_id);
						insertData.add(week_no);
						insertData.add(day_no);
						tabData.put( "InsertData", insertData);
						tabData.put( "properties",	p ) ;
						try{
							sqlMap.clear();
							sqlMap.put( "InsertSQL", sql_update);
						}catch(Exception e){
							e.printStackTrace();
						}
					}
					else{
						insertData.clear();
						tabData.clear();
						sqlMap.clear();
					}
				if(!(tabData.isEmpty()) && !(sqlMap.isEmpty())){

					/*SingleTableHandlerHome home		= null;
					SingleTableHandlerRemote remote	= null;
					InitialContext context = new InitialContext() ;
					Object object = context.lookup( CommonRepository.getCommonKeyValue("JNDI_SINGLE_TABLE_HANDLER") ) ;
					home		  = (SingleTableHandlerHome) PortableRemoteObject.narrow( object, SingleTableHandlerHome.class ) ;
					remote = home.create() ;
					map = remote.insert( tabData, sqlMap) ;*/
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
					if(result.equals("true"))
						error_value = "APP-SM0001 Operation Completed Successfully...";
					else
						error_value = "Exception Occured... "+ (String)map.get("msgid");
			
				}

				}
			}
			response.sendRedirect("../eCommon/jsp/error.jsp?err_num="+error_value+"&err_value=1" );

		}catch(Exception e){
			e.printStackTrace();
		}

	}
	/*****************************************************************/
}
