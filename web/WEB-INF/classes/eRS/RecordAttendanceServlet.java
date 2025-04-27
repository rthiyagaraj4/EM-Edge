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

public class RecordAttendanceServlet extends HttpServlet{

	private ServletConfig config = null;
	HttpSession session = null;

	String facility_id = "";
	Properties p = new Properties();
	String client_ip_address = "";
	String error_value ="";
	String workplace_code = "";
	String role_type = "";
	String staff_id = "";
	String schedule_date = "";
	String shift_code = "";
	String stepin_time = "";
	String stepout_time = "";
	String modified_by_id= "";
	String modified_at_ws_no = "";
	String modified_facility_id= "";
	
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

			modify(request,response);

		}catch(Exception e){
			e.printStackTrace();
		}
	}

	/**************************************************/
	public void modify(HttpServletRequest request,HttpServletResponse response)throws Exception{		
		try{
			HashMap map=new HashMap();
			String sql_update = "update rs_work_schedule set user_step_in_time=to_date(?,'hh24:mi'), user_step_out_time=to_date(?,'hh24:mi'), modified_by_id=?, modified_date=sysdate, modified_at_ws_no=?, modified_facility_id=?where facility_id=? and workplace_code=? and role_type=? and staff_id=? and to_char(schedule_date,'dd/mm/yyyy')=? and shift_code=?";
			String totalRecords;
			HashMap tabData = new HashMap();
			HashMap sqlMap = new HashMap();
			ArrayList insertData = new ArrayList() ;
			modified_by_id	= p.getProperty( "login_user" ) ;
			modified_at_ws_no= client_ip_address;
			modified_facility_id = facility_id ;
			totalRecords=request.getParameter("totalRecords");
			int int_totalRecords = Integer.parseInt(totalRecords);
			workplace_code = request.getParameter("workplace_code")==null ? "":request.getParameter("workplace_code");
			
			for(int i=0; i<int_totalRecords; i++){

				role_type = request.getParameter("role_type"+i)==null ? "":request.getParameter("role_type"+i);
				staff_id		= request.getParameter("staff_id"+i)==null ? "":request.getParameter("staff_id"+i);
				schedule_date		= request.getParameter("schedule_date"+i)==null ? "":request.getParameter("schedule_date"+i);
				shift_code		= request.getParameter("shift_code"+i)==null ? "":request.getParameter("shift_code"+i);
				String stepin_hh		= request.getParameter("stepin_hh"+i)==null ? "":request.getParameter("stepin_hh"+i);
				String stepin_mm		= request.getParameter("stepin_mm"+i)==null ? "":request.getParameter("stepin_mm"+i);
				String stepout_hh		= request.getParameter("stepout_hh"+i)==null ? "":request.getParameter("stepout_hh"+i);
				String stepout_mm		= request.getParameter("stepout_mm"+i)==null ? "":request.getParameter("stepout_mm"+i);
				String select_yn=request.getParameter("select_yn"+i)==null ? "":request.getParameter("select_yn"+i);
				insertData.clear();
				tabData.clear();
				sqlMap.clear();

				if(select_yn.equals("Y")){
				if(!(stepin_hh.equals(""))){
							stepin_time=stepin_hh+":"+stepin_mm;
							if(!(stepout_hh.equals("")))
								stepout_time=stepout_hh+":"+stepout_mm;
							else
								stepout_time="";
							insertData.add(stepin_time);
							insertData.add(stepout_time);
							insertData.add(modified_by_id);
							insertData.add(modified_at_ws_no);
							insertData.add(modified_facility_id);
							insertData.add(facility_id);
							insertData.add(workplace_code);
							insertData.add(role_type);
							insertData.add(staff_id);
							insertData.add(schedule_date);
							insertData.add(shift_code);
							System.err.println("insertData-------->"+insertData);
							tabData.put( "InsertData", insertData);
							tabData.put( "properties",	p ) ;
							sqlMap.put( "InsertSQL", sql_update);
				}
				if(!(tabData.isEmpty()) && !(sqlMap.isEmpty())){

			/*		SingleTableHandlerHome home		= null;
					SingleTableHandlerRemote remote	= null;
					InitialContext context = new InitialContext() ;
					Object object = context.lookup( CommonRepository.getCommonKeyValue("JNDI_SINGLE_TABLE_HANDLER") ) ;
					home		  = (SingleTableHandlerHome) PortableRemoteObject.narrow( object, SingleTableHandlerHome.class ) ;
					remote = home.create() ;
					map = remote.insert( tabData, sqlMap) ;
				*/
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
					String err_num="0";
					if(result.equals("true")){
						err_num = "APP-SM0001 Operation Completed Successfully ....";
						error_value="1";
					}
					else{
						err_num = "APP-OP0060 Error in Inserting into "+ (String)map.get("msgid");		
						error_value="0";
					}
					response.sendRedirect("../eCommon/jsp/error.jsp?err_num="+err_num+"&err_value="+error_value);
					
				}
			}
		}
	}catch(Exception e){
		e.printStackTrace();
		}
	}
}
