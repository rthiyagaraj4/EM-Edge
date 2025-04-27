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

public class SkillForPositionServlet extends HttpServlet{

	private ServletConfig config = null;
	HttpSession session = null;
	PrintWriter out;
	Properties p = new Properties();
	String client_ip_address = "";

	String facility_id = "";
	String added_by_id = "";
	String added_at_ws_no = "";
	String added_facility_id = ""; 
	String err_num="";
	String error_value="";
	
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

			this.out = response.getWriter();
			insert(request, response);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	/**************************************************/
	public void insert(HttpServletRequest request,HttpServletResponse response)throws Exception{
		
		try{

			HashMap map			= new HashMap() ;
			map.put( "result", new Boolean( false ) ) ;
			ArrayList insertData = new ArrayList() ;
			HashMap tabData = new HashMap() ;
			HashMap sqlMap = new HashMap() ;

			String formName=request.getParameter("formName")==null?"":request.getParameter("formName");
			String position_code		="";
			String skill_code	="";
			String mandatory_yn	="";
			String db_action="";
			String select_yn="";
			added_by_id 	= p.getProperty( "login_user" ) ;
			added_at_ws_no	= client_ip_address;
			added_facility_id= facility_id;
			String totalRecords=request.getParameter("totalRecords")==null?"":request.getParameter("totalRecords");
			int int_totalRecords = Integer.parseInt(totalRecords);
			
			for(int i=0; i<int_totalRecords; i++){
				if(formName.equals("form_skillList")){

					added_by_id 	= p.getProperty( "login_user" ) ;
					added_at_ws_no	= client_ip_address;
					added_facility_id= facility_id;
					position_code=request.getParameter("position_code")==null?"":request.getParameter("position_code");
					skill_code=request.getParameter("skill_code"+i)==null?"":request.getParameter("skill_code"+i);
				}
				else if(formName.equals("form_positionList")){
					position_code		= request.getParameter("position_code"+i)==null?"":request.getParameter("position_code"+i);
					skill_code		= request.getParameter("skill_code")==null?"":request.getParameter("skill_code");
				}
				mandatory_yn= request.getParameter("mandatory_yn"+i)==null?"":request.getParameter("mandatory_yn"+i);
				select_yn		= request.getParameter("select"+i)==null?"":request.getParameter("select"+i);
				db_action		= request.getParameter("db_action"+i)==null?"":request.getParameter("db_action"+i);
				
				if(mandatory_yn.equals(""))
					mandatory_yn="N";
				if(select_yn.equals(""))
					select_yn="N";
				if (select_yn.equals("") ){
					select_yn="N";
				}

				if(db_action.equalsIgnoreCase("U")){
					//System.err.println("db_action--->"+db_action);
					if(select_yn.equalsIgnoreCase("Y")){
						//System.err.println("select_yn------>"+select_yn);
						insertData.clear();
						tabData.clear();
						
						insertData.add(mandatory_yn);
						insertData.add("E");
						insertData.add(added_by_id);
						insertData.add(added_at_ws_no);
						insertData.add(added_facility_id);
						insertData.add(position_code);
						insertData.add(skill_code);
						
						tabData.put( "InsertData", insertData);
						tabData.put( "properties",	p ) ;
						


						try{
							sqlMap.clear();
							sqlMap.put( "InsertSQL","UPDATE RS_SKILL_FOR_POSITION SET MANDATORY_YN=?,EFF_STATUS=?,MODIFIED_BY_ID=?, MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=? WHERE POSITION_CODE=? AND SKILL_CODE=?");
						}
						catch(Exception e){
							e.printStackTrace();
						}
					}
					else if(select_yn.equalsIgnoreCase("N")){
						insertData.clear();
						tabData.clear();
								
						insertData.add(mandatory_yn);
						insertData.add("D");
						insertData.add(added_by_id);
						insertData.add(added_at_ws_no);
						insertData.add(added_facility_id);
						insertData.add(position_code);
						insertData.add(skill_code);
						
						tabData.put( "InsertData", insertData);
						tabData.put( "properties",p) ;
						

						try{
							sqlMap.clear();
							sqlMap.put( "InsertSQL","UPDATE RS_SKILL_FOR_POSITION SET MANDATORY_YN=?,EFF_STATUS=?,MODIFIED_BY_ID=?, MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=? WHERE POSITION_CODE=? AND SKILL_CODE=?");
							
						}
						catch(Exception e){
							e.printStackTrace();
						}
					}
				}
				else if(db_action.equalsIgnoreCase("I")){
					
					if(select_yn.equalsIgnoreCase("Y")){
					
						insertData.clear();
						tabData.clear();
						insertData.add(position_code);
						insertData.add(skill_code);
						insertData.add(mandatory_yn);
						insertData.add("E");
						insertData.add(added_by_id);
						insertData.add(client_ip_address);
						insertData.add(facility_id);
						insertData.add(added_by_id);
						insertData.add(added_at_ws_no);
						insertData.add(added_facility_id);
						tabData.put( "InsertData", insertData);
						tabData.put( "properties",p) ;
						
					try{
							sqlMap.clear();
							sqlMap.put( "InsertSQL", "INSERT INTO RS_SKILL_FOR_POSITION(POSITION_CODE, SKILL_CODE,MANDATORY_YN,EFF_STATUS,ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID) VALUES (?,?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?)");
							
						}
						catch(Exception e){
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
					//System.err.println("result------------>"+result);
					if(result.equals("true")){
						error_value ="1";
						err_num= "APP-SM0002 Operation Completed Successfully ....";
					}
					else{
						err_num = "Exception Occured... "+ (String)map.get("msgid");
						error_value="0";
					}
				}	
			}//end of for loop		

			response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num="+err_num+"&err_value="+error_value+"&formName="+formName);
		}
		catch ( Exception e ) {
			out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
			out.println( "Values sent are : <br>" ) ;
		}
	} // end of insert
}
