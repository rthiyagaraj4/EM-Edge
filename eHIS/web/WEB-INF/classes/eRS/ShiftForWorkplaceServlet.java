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

public class ShiftForWorkplaceServlet extends HttpServlet{

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
		
		HashMap map			= new HashMap() ;
	    map.put( "result", new Boolean( false ) ) ;
		ArrayList insertData = new ArrayList() ;
		HashMap tabData = new HashMap() ;
		HashMap sqlMap = new HashMap() ;

		String formName=request.getParameter("formName");
		String 	facility_id1	=request.getParameter("facility_id");
		String workplace_code	="";
		String shift_code	="";
		String shift_mnemonic="";
		String db_action="";
		String select_yn="";

		String insert_query = "insert into rs_shift_for_workplace(facility_id,workplace_code,shift_code,shift_mnemonic,eff_status,added_by_id,added_date,added_at_ws_no,added_facility_id,modified_by_id,modified_date,modified_at_ws_no,modified_facility_id) values(?,?,?,?,?,?,sysdate,?,?,?,sysdate,?,?)";
		String update_query = "update rs_shift_for_workplace set eff_status=? where facility_id = ? and workplace_code = ? and shift_code = ?";

		
		added_by_id 	= p.getProperty( "login_user" ) ;
		added_at_ws_no	= client_ip_address;
		added_facility_id= facility_id;
		String totalRecords=request.getParameter("totalRecords");
		int int_totalRecords = Integer.parseInt(totalRecords);
		
		if(formName.equals("frm_shift_list")){

		try{
			workplace_code		= request.getParameter("workplace_code");

			for(int i=0; i<int_totalRecords; i++){
				select_yn		= request.getParameter("select_yn"+i)==null?"N":request.getParameter("select_yn"+i);
				db_action		= request.getParameter("db_action"+i)==null?"":request.getParameter("db_action"+i);
				shift_mnemonic=request.getParameter("shift_mnemonic"+i);
				shift_code		= request.getParameter("shift_code"+i);

				if (select_yn.equals("")){
					select_yn="N";
				}
				if(db_action.equalsIgnoreCase("U")){
					if(select_yn.equalsIgnoreCase("N")){
							insertData.clear();
							tabData.clear();
							insertData.add("D");
							insertData.add(facility_id1);
							insertData.add(workplace_code);
							insertData.add(shift_code);
							tabData.put( "InsertData", insertData);
							tabData.put( "properties",p) ;
							try{
								sqlMap.clear();
								sqlMap.put( "InsertSQL", update_query);
							}
							catch(Exception e){
								e.printStackTrace();
							}
					}else if (select_yn.equalsIgnoreCase("Y")){
							insertData.clear();
							tabData.clear();
							insertData.add("E");
							insertData.add(facility_id1);
							insertData.add(workplace_code);
							insertData.add(shift_code);
							tabData.put( "InsertData", insertData);
							tabData.put( "properties",p) ;
							try{
								sqlMap.clear();
								sqlMap.put( "InsertSQL", update_query);
							}
							catch(Exception e){
								e.printStackTrace();
							}
					}
					}else if(db_action.equalsIgnoreCase("I")){
						if(select_yn.equalsIgnoreCase("Y")){
							insertData.clear();
							tabData.clear();
							insertData.add(facility_id1);
							insertData.add(workplace_code);
							insertData.add(shift_code);
							insertData.add(shift_mnemonic);
							insertData.add("E");
							insertData.add(added_by_id);
							insertData.add(client_ip_address);
							insertData.add(facility_id);
							insertData.add(added_by_id);
							insertData.add(added_at_ws_no);
							insertData.add(added_facility_id);
							tabData.put( "InsertData", insertData);
							tabData.put( "properties",	p ) ;
							try{
								sqlMap.clear();
								sqlMap.put( "InsertSQL", insert_query);
							}
							catch(Exception e){
								e.printStackTrace();
							}
						}
						else if (select_yn.equalsIgnoreCase("N")){
							insertData.clear();
							tabData.clear();
							sqlMap.clear();
						}
					}
					if(!(tabData.isEmpty()) && !(sqlMap.isEmpty())){
					/*	SingleTableHandlerHome home		= null;
						SingleTableHandlerRemote remote	= null;
					
						InitialContext context = new InitialContext() ;
						Object object = context.lookup(CommonRepository.getCommonKeyValue("JNDI_SINGLE_TABLE_HANDLER"));
						home		  = (SingleTableHandlerHome) PortableRemoteObject.narrow( object, SingleTableHandlerHome.class ) ;
						remote = home.create() ;
						map = remote.insert(tabData, sqlMap) ;
					*/
						boolean local_ejbs = false;
						ServletContext context = getServletConfig().getServletContext();
						if ((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) 
						local_ejbs = true;
						//Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/ejb/eCommon/SingleTableHandler",SingleTableHandlerLocalHome.class,local_ejbs);
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
							err_num= "APP-SM0002 Operation Completed Successfully ....";
						}
						else{
							err_num = "Exception Occured... "+ (String)map.get("msgid");
							error_value="0";
						}
					}	
				}//end of for loop		
	
				response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num="+err_num+"&err_value="+error_value);
			}
			catch(Exception e ){
					out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
					out.println( "Values sent are : <br>" ) ;
			}
	   }//end of if

		else{
			if(formName.equals("frm_workplace_list")){

				try{
					shift_code		= request.getParameter("shift_code");
					shift_mnemonic=request.getParameter("shift_mnemonic");

					for(int i=0; i<int_totalRecords; i++){

						select_yn		= request.getParameter("select_yn"+i)==null?"":request.getParameter("select_yn"+i);
						db_action		= request.getParameter("db_action"+i)==null?"":request.getParameter("db_action"+i);
						workplace_code		= request.getParameter("workplace_code"+i);
						if (select_yn.equals("")){
							select_yn="N";
						}
						if(db_action.equalsIgnoreCase("U")){
							if(select_yn.equalsIgnoreCase("N")){
								insertData.clear();
								tabData.clear();
								insertData.add("D");
								insertData.add(facility_id1);
								insertData.add(workplace_code);
								insertData.add(shift_code);
								tabData.put( "InsertData", insertData);
								tabData.put( "properties",p) ;
								try{
									sqlMap.clear();
									sqlMap.put( "InsertSQL", update_query);
								}
								catch(Exception e){
									e.printStackTrace();
								}
							}else if (select_yn.equalsIgnoreCase("Y")){
								insertData.clear();
								tabData.clear();
								insertData.add("E");
								insertData.add(facility_id1);
								insertData.add(workplace_code);
								insertData.add(shift_code);
								tabData.put( "InsertData", insertData);
								tabData.put( "properties",p) ;
								try{
									sqlMap.clear();
									sqlMap.put( "InsertSQL", update_query);
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
								insertData.add(facility_id1);
								insertData.add(workplace_code);
								insertData.add(shift_code);
								insertData.add(shift_mnemonic);
								insertData.add("E");
								insertData.add(added_by_id);
								insertData.add(client_ip_address);
								insertData.add(facility_id);
								insertData.add(added_by_id);
								insertData.add(added_at_ws_no);
								insertData.add(added_facility_id);
								tabData.put( "InsertData", insertData);
								tabData.put( "properties",	p ) ;
								try{
									sqlMap.clear();
									sqlMap.put( "InsertSQL", insert_query);
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
						/*	SingleTableHandlerHome home		= null;
							SingleTableHandlerRemote remote	= null;
						
							InitialContext context = new InitialContext() ;
							Object object = context.lookup(CommonRepository.getCommonKeyValue("JNDI_SINGLE_TABLE_HANDLER"));
							home		  = (SingleTableHandlerHome) PortableRemoteObject.narrow( object, SingleTableHandlerHome.class ) ;
							remote = home.create() ;
							map = remote.insert(tabData, sqlMap) ;
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
				response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num="+err_num+"&err_value="+error_value);
			}
			catch( Exception e ){
				out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
				out.println( "Values sent are : <br>" ) ;
			}
		}
	  }//end of else
	} // end of insert
}
