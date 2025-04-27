/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eAM;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import eCommon.Common.*;
import eCommon.SingleTableHandler.*;
import webbeans.eCommon.*;

public class ShiftForLocationTypeServlet extends HttpServlet
{
	private ServletConfig config = null;
	PrintWriter out = null;
	HttpSession session = null;
	String facility_id = "";
	String facility = "";
	Properties p = new Properties();
	String client_ip_address = "";

	String locn_type = "";
	String shift_code = "";
	String added_by_id = "";
	String added_at_ws_no = "";
	String added_facility_id = "";
	String db_action="";
	//String error_value = "0" ;
	String err_num = "" ;
	String select="";
	String eff_status="";
	String locale="";

	public void init(ServletConfig config)
		throws ServletException
	{
		super.init(config);
		this.config = config;
	}
	public void doGet(HttpServletRequest request,HttpServletResponse response)
		throws ServletException,IOException
	{
		doPost(request,response);
	}
	public synchronized void doPost(HttpServletRequest request,HttpServletResponse response)
		throws ServletException,IOException
	{
		session = request.getSession(false);
		this.facility_id = (String) session.getAttribute( "facility_id" ) ;
		this.p = (java.util.Properties) session.getAttribute( "jdbc" ) ;
		this.client_ip_address = p.getProperty("client_ip_address");
		 locale= p.getProperty("LOCALE");

		try{
			response.setContentType("text/html");
			out = response.getWriter();
			String operation = request.getParameter("operation");
			
			if ( operation.equals("showshifts"))   insertShifts(request, response);
			if ( operation.equals("showfacilities"))   insertFacilities(request, response);

		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public void insertShifts(HttpServletRequest request,HttpServletResponse response)
	{
		try{

		p = (java.util.Properties) session.getAttribute( "jdbc" ) ;
		client_ip_address = p.getProperty("client_ip_address");

		String sql_insert = "insert into am_shift_for_locn_type(locn_type,shift_code,facility_id,added_by_id,added_date,added_at_ws_no,added_facility_id,modified_by_id,modified_date,modified_at_ws_no,modified_facility_id) values (?,?,?,?,sysdate,?,?,?,sysdate,?,?)";
		String sql_update = "update am_shift_for_locn_type set eff_status=? where locn_type = ? and shift_code = ? and facility_id = ?";

		added_by_id 	= p.getProperty( "login_user" ) ;
		added_at_ws_no	= client_ip_address;
		added_facility_id		= facility_id;
		
		HashMap tabData = new HashMap();
		HashMap sqlMap = new HashMap();

		ArrayList insertData = new ArrayList() ;
		HashMap map = new HashMap();

		locn_type = request.getParameter("locn_type")==null ? "":request.getParameter("locn_type");
		facility = request.getParameter("facility")==null ? "":request.getParameter("facility");
		int count = Integer.parseInt(request.getParameter("noOfRecords"));

		for(int i=0;i<=count;i++)
		{
			shift_code = request.getParameter("shift_code"+i)==null ? "":request.getParameter("shift_code"+i);
			
			db_action = request.getParameter("db_action"+(i));
			select=request.getParameter("select"+(i))==null?"D":request.getParameter("select"+(i));


			map = new HashMap();
		    insertData = new ArrayList();

				if(db_action.equals("U")){
					if(select.equals("E")){

					        insertData.clear();
							tabData.clear();
							eff_status="E";
							insertData.add(eff_status);
							insertData.add(locn_type);
							insertData.add(shift_code);
							insertData.add(facility);
							tabData.put( "InsertData", insertData);
							tabData.put( "properties",	p ) ;
								try{
								sqlMap.clear();
								sqlMap.put( "InsertSQL", sql_update);
							}catch(Exception e)
							{
							out.println(e.toString());
							}
					}else{

							insertData.clear();
							tabData.clear();
							eff_status="D";
							insertData.add(eff_status);
							insertData.add(locn_type);
							insertData.add(shift_code);
							insertData.add(facility);
							tabData.put( "InsertData", insertData);
							tabData.put( "properties",	p ) ;
							try{
								sqlMap.clear();
								sqlMap.put( "InsertSQL", sql_update);
							}catch(Exception e)
							{
							out.println(e.toString());
							}
					}
				}else 
				if(db_action.equals("I")){
						if(select.equals("D")){
								tabData.clear();
								insertData.clear();
								sqlMap.clear();
						}else{
							insertData.clear();
							tabData.clear();
							insertData.add(locn_type);
							insertData.add(shift_code);
							insertData.add(facility);
							insertData.add(added_by_id);
							insertData.add(client_ip_address);
							insertData.add(added_facility_id);
							insertData.add(added_by_id);
							insertData.add(added_at_ws_no);
							insertData.add(added_facility_id);
							tabData.put( "InsertData", insertData);
							tabData.put( "properties",	p ) ;
		
		try{
								sqlMap.clear();
								sqlMap.put( "InsertSQL", sql_insert);
							}catch(Exception e)
							{
							out.println(e.toString());
							}
						}
					}

		if(!(tabData.isEmpty()) && !(sqlMap.isEmpty())){

			boolean local_ejbs = false;
			ServletContext context = getServletConfig().getServletContext();
			if ((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) 
			local_ejbs = true;
				Object home=com.ehis.eslp.ServiceLocator.getInstance().getHome(CommonRepository.getCommonKeyValue("JNDI_SINGLE_TABLE_HANDLER"),SingleTableHandlerHome.class,local_ejbs);
				Object busObj=(home.getClass().getMethod("create",null)).invoke(home,null);

				Object argArray[]=new Object[2];
				argArray[0]=tabData;
				argArray[1]=sqlMap;

				Class[] paramArray=new Class[2];
				paramArray[0]=tabData.getClass();
				paramArray[1]=sqlMap.getClass();

				map=(HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
				(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
					String result = ((Boolean)map.get("result")).toString();

					

					if(result.equals("true")){
						//error_value ="1";
						Hashtable hashtable1 = MessageManager.getMessage(locale, "RECORD_INSERTED","SM");
					 err_num = (String)hashtable1.get("message");
					hashtable1.clear();
					}
					else{
						err_num = "Exception Occured... "+ (String)map.get("msgid");
						//error_value="0";
					}
			}else
				{
					//error_value ="1";
				  Hashtable hashtable1 = MessageManager.getMessage(locale, "RECORD_INSERTED","SM");
					 err_num = (String)hashtable1.get("message");
					hashtable1.clear();
				}
		}
		            tabData.clear();
					sqlMap.clear();
					insertData.clear();
					map.clear();

			response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num="+java.net.URLEncoder.encode(err_num,"UTF-8")+"&err_value=1");
			} catch ( Exception e ) {
			out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
			out.println( "Values sent are : <br>" ) ;

			}
			
	}
	//End of Shifts

	public void insertFacilities(HttpServletRequest request,HttpServletResponse response)
	{
		try{
			

		p = (java.util.Properties) session.getAttribute( "jdbc" ) ;
		client_ip_address = p.getProperty("client_ip_address");

		String sql_insert = "insert into am_shift_for_locn_type(locn_type,shift_code,facility_id,added_by_id,added_date,added_at_ws_no,added_facility_id,modified_by_id,modified_date,modified_at_ws_no,modified_facility_id) values (?,?,?,?,sysdate,?,?,?,sysdate,?,?)";
		
		String sql_update = "update am_shift_for_locn_type set eff_status=? where locn_type = ? and shift_code = ? and facility_id = ?";

		added_by_id 	= p.getProperty( "login_user" ) ;
		added_at_ws_no	= client_ip_address;
		added_facility_id		= facility_id;
		
		HashMap tabData = new HashMap();
		HashMap sqlMap = new HashMap();

		ArrayList insertData = new ArrayList() ;
		HashMap map = new HashMap();

		locn_type = request.getParameter("locn_type")==null ? "":request.getParameter("locn_type");
		shift_code = request.getParameter("shift_code")==null ? "":request.getParameter("shift_code");
		int count = Integer.parseInt(request.getParameter("noOfRecords"));
		
		for(int i=0;i<count;i++)
		{
			facility_id = request.getParameter("facility_id"+i)==null ? "":request.getParameter("facility_id"+i);
			
			db_action = request.getParameter("db_action"+(i));
			select=request.getParameter("select"+(i))==null?"D":request.getParameter("select"+(i));
		

			map = new HashMap();
		    insertData = new ArrayList();

				if(db_action.equals("U")){
					if(select.equals("E")){
						    insertData.clear();
							tabData.clear();
							eff_status="E";
							insertData.add(eff_status);
							insertData.add(locn_type);
							insertData.add(shift_code);
							insertData.add(facility_id);
							tabData.put( "InsertData", insertData);
							tabData.put( "properties",	p ) ;
							try{
								sqlMap.clear();
								sqlMap.put( "InsertSQL", sql_update);
							}catch(Exception e)
							{
							out.println(e.toString());
							}
					}else{
							insertData.clear();
							tabData.clear();
							eff_status="D";
							insertData.add(eff_status);
							insertData.add(locn_type);
							insertData.add(shift_code);
							insertData.add(facility_id);
							tabData.put( "InsertData", insertData);
							tabData.put( "properties",	p ) ;
							try{
								sqlMap.clear();
								sqlMap.put( "InsertSQL", sql_update);
							}catch(Exception e)
							{
							out.println(e.toString());
							}
					}
				}else 
				if(db_action.equals("I")){
						if(select.equals("D")){
								tabData.clear();
								insertData.clear();
								sqlMap.clear();
						}else{
							insertData.clear();
							tabData.clear();
							insertData.add(locn_type);
							insertData.add(shift_code);
							insertData.add(facility_id);
							insertData.add(added_by_id);
							insertData.add(client_ip_address);
							insertData.add(added_facility_id);
							insertData.add(added_by_id);
							insertData.add(added_at_ws_no);
							insertData.add(added_facility_id);
							tabData.put("InsertData", insertData);
							tabData.put("properties",	p ) ;
		
		try{
								sqlMap.clear();
								sqlMap.put( "InsertSQL", sql_insert);
							}catch(Exception e)
							{
							out.println(e.toString());
							}
						}
					}

		if(!(tabData.isEmpty()) && !(sqlMap.isEmpty())){

			boolean local_ejbs = false;
			ServletContext context = getServletConfig().getServletContext();
			if ((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) 
			local_ejbs = true;
				Object home=com.ehis.eslp.ServiceLocator.getInstance().getHome(CommonRepository.getCommonKeyValue("JNDI_SINGLE_TABLE_HANDLER"),SingleTableHandlerHome.class,local_ejbs);
				Object busObj=(home.getClass().getMethod("create",null)).invoke(home,null);

				Object argArray[]=new Object[2];
				argArray[0]=tabData;
				argArray[1]=sqlMap;

				Class[] paramArray=new Class[2];
				paramArray[0]=tabData.getClass();
				paramArray[1]=sqlMap.getClass();
				map=(HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
				(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

				   

					String result = ((Boolean)map.get("result")).toString();
					if(result.equals("true")){
						//error_value ="1";
						Hashtable hashtable1 = MessageManager.getMessage(locale, "RECORD_INSERTED","SM");
					 err_num = (String)hashtable1.get("message");
					hashtable1.clear();
					}
					else{
						err_num = "Exception Occured... "+ (String)map.get("msgid");
						//error_value="0";
					}
			}else
				{
					//error_value ="1";
				   Hashtable hashtable1 = MessageManager.getMessage(locale, "RECORD_INSERTED","SM");
					 err_num = (String)hashtable1.get("message");
					hashtable1.clear();
				}
		}
                    tabData.clear();
					sqlMap.clear();
					insertData.clear();
					map.clear();
			response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num="+java.net.URLEncoder.encode(err_num,"UTF-8")+"&err_value=1");
			} catch ( Exception e ) {
			out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
			out.println( "Values sent are : <br>" ) ;

			}
			
	}
	//End of Facilities
}
