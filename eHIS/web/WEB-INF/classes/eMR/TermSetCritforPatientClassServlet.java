/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eMR;

import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import javax.naming.*;
import javax.rmi.*;
import eCommon.Common.*;
import webbeans.eCommon.*;
//import eCommon.SingleTableHandler.*;
import eCommon.SingleTabHandler.*;

public class TermSetCritforPatientClassServlet extends javax.servlet.http.HttpServlet implements SingleThreadModel
{
	PrintWriter out;
	java.util.Properties p;
	//Connection conn = null;
	//ResultSet rset=null;
	//Statement stmt=null;
	String accuracy_code="";
	String patient_class="";
	String added_by_id = "";
	String added_at_ws_no = "";
	String added_facility_id = "";
	String msg = "";
	String locale ="";
	String facilityId1 ;
	String client_ip_address;
	String db_action;
	String criteria = "";
	String list_value = "";
	String dflt_value_yn = "";
	HttpSession session;
	boolean flag1=false;

	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	}

	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		session = req.getSession(false);
		this.p = (java.util.Properties) session.getValue( "jdbc" ) ;
		this.facilityId1 = (String) session.getValue( "facility_id" ) ;
		client_ip_address = p.getProperty("client_ip_address");
		try
		{
			this.out = res.getWriter();
			req.setCharacterEncoding("UTF-8");
			res.setContentType("text/html;charset=UTF-8");
			this.out = res.getWriter();
			SpecialityAddModify(req,res);

		}
		catch(Exception e)	
		{
			//out.println(e.toString());
				e.printStackTrace();
		}
	}
	
	
	public synchronized void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{			
		
		session = req.getSession(false);
		this.p = (java.util.Properties) session.getValue( "jdbc" ) ;
		this.facilityId1 = (String) session.getValue( "facility_id" ) ;
		client_ip_address = p.getProperty("client_ip_address");
		try
		{			
			req.setCharacterEncoding("UTF-8");
			res.setContentType("text/html;charset=UTF-8");
			this.out = res.getWriter();
			SpecialityAddModify(req,res);
		}
		catch(Exception e)
		{
			//out.println(e.toString());
			e.printStackTrace();
		}
	}
	
	private void SpecialityAddModify(HttpServletRequest req, HttpServletResponse res)
	{		
		try
		{
			//conn = ConnectionManager.getConnection(req);
			//stmt = conn.createStatement();
			HashMap tabData = new HashMap();
			HashMap sqlMap = new HashMap();
			HashMap map=new HashMap();
			ArrayList insertData = new ArrayList() ;
			String error_value="0";
			String error="";
			
//			String sql_insert = " Insert into MR_ACCURACY_FOR_PAT_CLASS (patient_class, accuracy_code, added_by_id, added_date, added_at_ws_no, added_facility_id, modified_by_id, modified_date, modified_at_ws_no, modified_facility_id) values ( ?, ?, ?,sysdate, ?, ?, ?,sysdate, ?, ? ) ";

//			String sql_delete = " delete from MR_ACCURACY_FOR_PAT_CLASS where accuracy_code = ? and patient_class = ? ";

            int totalCount=0;
			accuracy_code = req.getParameter("accuracy_code");
			if(accuracy_code == null) accuracy_code="";
			criteria = req.getParameter("criteria");
			if(criteria == null) criteria="";
			list_value = req.getParameter("list_value");
			if(list_value == null) list_value="";


			totalCount		=Integer.parseInt(req.getParameter("total_records")==null?"0":req.getParameter("total_records"));
			if(accuracy_code == null) accuracy_code="";

			added_by_id 	= p.getProperty( "login_user" ) ;
			locale = p.getProperty("LOCALE");
			added_at_ws_no	= client_ip_address;
			added_facility_id= facilityId1;
			for(int i=0;i<totalCount;i++)
			{

				patient_class=req.getParameter("patient_class"+i);
				String select=req.getParameter("select_yn"+i)==null?"N":req.getParameter("select_yn"+i);
				db_action = req.getParameter("db_action"+i)==null?"I":req.getParameter("db_action"+i);
				dflt_value_yn  = req.getParameter("default_yn"+i)==null?"N":req.getParameter("default_yn"+i);

				
/*				
				if(db_action.equals("U"))
				{
					if(select.equals("Y"))
					{
						//clear all delete fileds
						tabData.clear();
						insertData.clear();
						sqlMap.clear();
					}
					else
					{
						//pass all delete fileds
						insertData.clear();
						tabData.clear();
						insertData.add(accuracy_code);
						insertData.add(patient_class);
						tabData.put( "InsertData", insertData);
						tabData.put( "properties",	p );

						sqlMap.clear();
						sqlMap.put( "InsertSQL", sql_delete);

					}
				}
				else if (db_action.equals("I"))
				{
					if(select.equals("N"))
					{
						// clear all fields
						tabData.clear();
						insertData.clear();
						sqlMap.clear();
					}
					else
					{
						// pass all ineert data
						insertData.clear();
						tabData.clear();
						insertData.add(patient_class);
						insertData.add(accuracy_code);
						insertData.add(added_by_id);
						insertData.add(client_ip_address);
						insertData.add(facilityId1);
						insertData.add(added_by_id);
						insertData.add(added_at_ws_no);
						insertData.add(added_facility_id);
						tabData.put( "InsertData", insertData);
						tabData.put( "properties",	p ) ;

						sqlMap.clear();
						sqlMap.put( "InsertSQL", sql_insert);

					}
				}
*/
					
/*
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
*/				
/*******************************************************************************/
				if( db_action.equals("I") && select.equals("Y")) 
				{
					HashMap InsertValues = new HashMap();

					InsertValues.put("PATIENT_CLASS",patient_class);
					InsertValues.put("CRITERIA",criteria);
					InsertValues.put("LIST_VALUE",list_value);
					InsertValues.put("ACCURACY_CODE",accuracy_code);
					InsertValues.put("DFLT_VALUE_YN",dflt_value_yn);
					InsertValues.put("ADDED_AT_WS_NO",client_ip_address);
					InsertValues.put("MODIFIED_DATE",new java.sql.Timestamp(System.currentTimeMillis()));
					InsertValues.put("ADDED_BY_ID",added_by_id);
					InsertValues.put("ADDED_DATE",new java.sql.Timestamp(System.currentTimeMillis()));
					InsertValues.put("ADDED_FACILITY_ID",added_facility_id);
					InsertValues.put("MODIFIED_AT_WS_NO",client_ip_address);
					InsertValues.put("MODIFIED_BY_ID",added_by_id);
					InsertValues.put("MODIFIED_FACILITY_ID",added_facility_id);

					String dupfields[] = {"PATIENT_CLASS","CRITERIA","LIST_VALUE","ACCURACY_CODE"};
					/*HashMap dupfields=new HashMap();
					dupfields.put("PATIENT_CLASS",patient_class);
					dupfields.put("CRITERIA",criteria);
					dupfields.put("LIST_VALUE",list_value);
					if (criteria.equals("Accuracy"))
					{
						dupfields.put("ACCURACY_CODE",accuracy_code);
					}*/

					String tabname = "MR_TERM_SET_CRIT_FOR_PC";

					
					try
					{
						boolean local_ejbs = false;
						if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;
						Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
						Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
						
						Object argArray[] = new Object[4];
						argArray[0] = p;
						argArray[1] = InsertValues;
						argArray[2] = dupfields;
						argArray[3] = tabname;
						
						Class [] paramArray = new Class[4];
						paramArray[0] = p.getClass();
						paramArray[1] = InsertValues.getClass();
						paramArray[2] = dupfields.getClass();
						paramArray[3] = tabname.getClass();

						java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
						boolean inserted = (((Boolean)results.get("status")).booleanValue());
						error = (String) results.get("error") ;

						 if ( inserted )
						 {
								error_value= "1";
						}
						else
						{
								error_value= "0";
						}
					 }
					 catch(Exception exp)
					 {
						 
						exp.printStackTrace();
						error = "Error ";
						error_value = "0" ;
						res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8" ) + "&err_value=" + error_value );
					}
				}//E.o. if( db_action.equals("I") )
				else if( db_action.equals("U") && select.equals("Y")) 
				{
						
					
					HashMap InsertValues = new HashMap();
					HashMap condflds=new HashMap();
					if (criteria.equals("ACCURACY"))
					{
					InsertValues.put("PATIENT_CLASS",patient_class);
					InsertValues.put("CRITERIA",criteria);
					InsertValues.put("LIST_VALUE",list_value);
					InsertValues.put("ACCURACY_CODE",accuracy_code);
					InsertValues.put("DFLT_VALUE_YN",dflt_value_yn);
					InsertValues.put("MODIFIED_DATE",new java.sql.Timestamp(System.currentTimeMillis()));
					InsertValues.put("MODIFIED_AT_WS_NO",client_ip_address);
					InsertValues.put("MODIFIED_BY_ID",added_by_id);
					InsertValues.put("MODIFIED_FACILITY_ID",added_facility_id);


					condflds.put("PATIENT_CLASS",patient_class);
					condflds.put("CRITERIA",criteria);
					condflds.put("LIST_VALUE",list_value);
					//if (criteria.equals("Accuracy"))
					//{
						condflds.put("ACCURACY_CODE",accuracy_code);
					//}

					}
					else
					{
						InsertValues.put("PATIENT_CLASS",patient_class);
						InsertValues.put("CRITERIA",criteria);
						InsertValues.put("LIST_VALUE",list_value);
						InsertValues.put("ACCURACY_CODE",accuracy_code);
						InsertValues.put("DFLT_VALUE_YN",dflt_value_yn);
						InsertValues.put("MODIFIED_DATE",new java.sql.Timestamp(System.currentTimeMillis()));
						InsertValues.put("MODIFIED_AT_WS_NO",client_ip_address);
						InsertValues.put("MODIFIED_BY_ID",added_by_id);
						InsertValues.put("MODIFIED_FACILITY_ID",added_facility_id);


						condflds.put("PATIENT_CLASS",patient_class);
						condflds.put("CRITERIA",criteria);
						condflds.put("LIST_VALUE",list_value);
						


					}

					String tabname = "MR_TERM_SET_CRIT_FOR_PC";

					
					try
					{
						boolean local_ejbs = false;
						if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;
						Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
						Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
						
						Object argArray[] = new Object[4];
						argArray[0] = p;
						argArray[1] = InsertValues;
						argArray[2] = condflds;
						argArray[3] = tabname;
						
						Class [] paramArray = new Class[4];
						paramArray[0] = p.getClass();
						paramArray[1] = InsertValues.getClass();
						paramArray[2] = condflds.getClass();
						paramArray[3] = String.class;

						java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("update",paramArray)).invoke(busObj,argArray);
						(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
						boolean inserted = (((Boolean)results.get("status")).booleanValue());
						error = (String) results.get("error") ;
						 if ( inserted )
						 {
								error_value= "1";
						}
						else
						{
								error_value= "0";
						}
					 }
					 catch(Exception exp)
					 {
						 exp.printStackTrace();
						error = "Error ";
						error_value = "0" ;
						res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8" ) + "&err_value=" + error_value );
					}
				}//E.o. if( db_action.equals("U") )
				else if( db_action.equals("U") && select.equals("N") )
				{
					String table_name = "MR_TERM_SET_CRIT_FOR_PC";
					HashMap delflds=new HashMap();
					if (criteria.equals("Accuracy"))
					{
						delflds.put("accuracy_code",accuracy_code);
					}
					delflds.put("patient_class",patient_class);
					delflds.put("CRITERIA",criteria);
					delflds.put("LIST_VALUE",list_value);
					try
					{
							

						boolean local_ejbs = false;
						if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;
						Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
						Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
//						Object argArray[] = new Object[4];
						
						Object argDelArray[] = new Object[3];
						argDelArray[0] = p;
						argDelArray[1] = delflds;
						argDelArray[2] = table_name;

						Class [] paramDelArray = new Class[3];
						paramDelArray[0] = p.getClass();
						paramDelArray[1] = delflds.getClass();
						paramDelArray[2] = table_name.getClass();

						java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("delete",paramDelArray)).invoke(busObj,argDelArray);

						error = (String) results.get("error") ;
						boolean updated = (((Boolean)results.get("status")).booleanValue());




						if ( updated )
						{
							error_value= "1";
							
						}
						else
						{
							error_value= "0";
						}
					}catch(Exception exp)
					{
						exp.printStackTrace();
						error = "Error ";
						error_value = "0" ;
						res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8" ) + "&err_value=" + error_value );
					}
				}
			}// E.io For

			res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8" ) + "&err_value=" + error_value );
			if (map != null) map.clear();
			if (sqlMap != null) sqlMap.clear();
			if (tabData != null) tabData.clear();
			if (insertData != null) insertData.clear();		
		} 
		catch ( Exception e ) 
		{
			/* out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
			out.println( "Values sent are : <br>" ) ; */
			e.printStackTrace();
		}
	}
}
