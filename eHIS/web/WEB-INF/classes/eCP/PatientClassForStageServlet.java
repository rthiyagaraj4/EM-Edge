/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
//This file is saved on 18/10/2005.

package eCP;

import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import eCommon.Common.CommonRepository;
import webbeans.eCommon.*;
import eCommon.SingleTableHandler.*;

public class PatientClassForStageServlet extends javax.servlet.http.HttpServlet 
{
	PrintWriter out;

	java.util.Properties p;

	String stage_code="";
	String patient_class="";
	String added_by_id = "";
	String added_at_ws_no = "";
	String added_facility_id = "";
	String locale;
	String facilityId1;
	String client_ip_address;
	
	HttpSession session;
	
	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	}

	public  void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{			
		session = req.getSession(false);
		this.p = (java.util.Properties) session.getAttribute( "jdbc" ) ;
		this.facilityId1 = (String) session.getAttribute( "facility_id" ) ;
		
		client_ip_address = p.getProperty("client_ip_address");

		try
		{
			res.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("UTF-8");
			this.out = res.getWriter();
			AddModify(req,res);
		}
		catch(Exception e)
		{
			out.println(e.toString());
		}
	}

	public void doGet(HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		try
		{
			this.out = res.getWriter();
			res.setContentType("text/html");
		}
		catch(Exception e)	
		{	
			out.println(e.toString());
		}
	}



	private void AddModify(HttpServletRequest req, HttpServletResponse res)
	{		
		try
		{
		    
			HashMap tabData = new HashMap();
			HashMap sqlMap = new HashMap();
			HashMap map=new HashMap();
			ArrayList insertData = new ArrayList() ;
       	    
			String err_num="";
			String error_value="";
			String sql_insert="Insert into cp_pat_class_for_stage (patient_class, stage_code, ADDED_BY_ID, added_date,ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, modified_date, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID) values ( ?, ?, ?,sysdate, ?, ?, ?,sysdate, ?, ? )";
			String sql_delete="delete from cp_pat_class_for_stage where stage_code=? and patient_class=?";
            int totalCount=0;
			stage_code = req.getParameter("stage_code");
			totalCount		=Integer.parseInt(req.getParameter("total_records")==null?"0":req.getParameter("total_records"));
			if(stage_code == null) stage_code="";
	        locale=(String)session.getAttribute("LOCALE");
			for(int i=0;i<totalCount;i++){
				patient_class=req.getParameter("patient_class"+i);
				String db_action=req.getParameter("db_action"+i)==null?"I":req.getParameter("db_action"+i);
				String select=req.getParameter("select_yn"+i)==null?"N":req.getParameter("select_yn"+i);
			added_by_id 	= p.getProperty( "login_user" ) ;
			added_at_ws_no	= client_ip_address;
			added_facility_id= facilityId1;

				if(db_action.equals("U")){
					if(select.equals("Y")){
						tabData.clear();
						insertData.clear();
						sqlMap.clear();
					}else{
							insertData.clear();
							tabData.clear();
							insertData.add(stage_code);
							insertData.add(patient_class);
							tabData.put( "InsertData", insertData);
							tabData.put( "properties",	p ) ;
							try{
								sqlMap.clear();
								sqlMap.put( "InsertSQL", sql_delete);
							}catch(Exception e)
							{
								out.println(e.toString());
							}
					}
				}else 
				if(db_action.equals("I")){
						if(select.equals("N")){
								tabData.clear();
								insertData.clear();
								sqlMap.clear();
						}else{
							insertData.clear();
							tabData.clear();
							insertData.add(patient_class);
							insertData.add(stage_code);
							insertData.add(added_by_id);
							insertData.add(client_ip_address);
							insertData.add(facilityId1);
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
						error_value ="1";
//                     err_num= "APP-SM0002 Operation Completed Successfully ....";
						Hashtable mestable=MessageManager.getMessage(locale,"RECORD_INSERTED", "CP");
						err_num=(String)mestable.get("message");
					}
					else{
						err_num = "Exception Occured... "+ (String)map.get("msgid");
						error_value="0";
					}
			}
			else
				{
					error_value ="1";
				    //err_num= "APP-SM0002 Operation Completed Successfully ....";
					Hashtable mestable=MessageManager.getMessage(locale,"RECORD_INSERTED", "CP");
					err_num=(String)mestable.get("message");
				}
		}
					res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num="+err_num+"&err_value="+error_value);

				

		} catch ( Exception e ) {
			out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
			out.println( "Values sent are : <br>" ) ;

			}
	}
}
