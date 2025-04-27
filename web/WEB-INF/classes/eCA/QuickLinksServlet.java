/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
--------------------------------------------------------------------------------------------------------------
Date		Edit History	Name		Rev.Date		Rev.Name		Description
--------------------------------------------------------------------------------------------------------------
07/02/2019	IN069654	sivabagyam M 	07/02/2019		Ramesh G		MO-CRF-20101.4
21/06/2020  	IN071596	sivabagyam M 	21/06/2020		Ramesh G		MO-CRF-20101.7
04/11/2020		IN073728	Nijithas		04/11/2020		Ramesh G		MO-CRF-20101.16
03/02/2022      IN27709     Suji Keerthi.G  03/02/2022      Ramesh G        GHL-CRF-0658
---------------------------------------------------------------------------------------------------------------
*/ 
package eCA ;

import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import javax.naming.*;
import javax.rmi.*;
import java.text.*;
import webbeans.eCommon.*;
import webbeans.eCommon.MessageManager;


public class QuickLinksServlet extends javax.servlet.http.HttpServlet
{		
	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.
	ServletException,IOException
	{
		PrintWriter out = res.getWriter();
		HttpSession session;
		req.setCharacterEncoding("UTF-8");
		
		try
		{		
			session = req.getSession(false);
			res.setContentType("text/html;charset=UTF-8");
			out = res.getWriter();
			String mode = req.getParameter("mode") == null ? "insert" : req.getParameter("mode");
			String ql_type = req.getParameter("ql_type") == null ? "" : req.getParameter("ql_type");

			if(ql_type.equals("AM"))
				insertAdaptiveMenuQuickLinks(req, res,session,out);		

			if(mode.equals("insert")&&!(ql_type.equals("AM")))
				insertQuickLinks(req, res,session,out);
			else if(mode.equals("update"))
				updateQuickLinks(req, res,session,out);
		}
		catch(Exception e)
		{
			//out.print(e);//common-icn-0181
			e.printStackTrace();
		}
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		PrintWriter out = res.getWriter();
		try
		{
			doPost(req,res);		
		}
		catch(Exception e)	
		{	
			e.printStackTrace();
		}
	}

	
	private void insertAdaptiveMenuQuickLinks(HttpServletRequest req, HttpServletResponse res, HttpSession session, PrintWriter out)
	{
		Connection con				= null;
		PreparedStatement pstmt		= null;
		PreparedStatement pstmt1	= null;

		Hashtable tabdata;
		String client_ip_address= "";
		String facilityId= "";
		String errorMsg			= "";
		String errVal			= "0";
		boolean insert = false;		
		try
		{
			con = ConnectionManager.getConnection(req);
			java.util.Properties p;
			p						= (java.util.Properties) session.getValue( "jdbc" ) ;
			String locale			= (String) p.getProperty("LOCALE");
			client_ip_address		= (String) p.getProperty("client_ip_address");
			facilityId				= (String)session.getValue("facility_id");
			String addedById			= p.getProperty( "login_user" ) ;
			String modifiedById			= addedById ;
			String addedAtWorkstation	= client_ip_address;
			String modifiedAtWorkstation= addedAtWorkstation;
			String addedFacilityId		= facilityId;
			String modifiedFacilityId	= facilityId;
			//String addedDate			= new java.text.SimpleDateFormat( "yyyy-MM-dd" ).format( new java.util.Date() ) ;//Checkstyle
			
			String sql_adpt				= "";
			String sql_del				= "";
			String adpt_function_name	= "";
			String id		= "";
			String count		= "0";
			String display_order		= "";							
			String eff_status		= "";							
			int count_adpt = 0;
			
			count	= req.getParameter("count")	== null ? "0" : req.getParameter("count");			
			adpt_function_name	= req.getParameter("adpt_function_name")	== null ? "" : req.getParameter("adpt_function_name");	
			eff_status	= req.getParameter("eff_status")	== null ? "D" : req.getParameter("eff_status");	

			sql_del="delete from SM_QUICK_LINK_ADPT_MNU_DTL where S_ADPT_FUNCTION_REF =?";
			pstmt = con.prepareStatement(sql_del);
		
			
		//	if(Integer.parseInt(count)>0){
					pstmt.setString(1,adpt_function_name);
					pstmt.executeUpdate();
					if(pstmt != null) pstmt.close();
			//}
			

			sql_adpt = "insert into SM_QUICK_LINK_ADPT_MNU_DTL  (S_ADPT_FUNCTION_REF, L_ADPT_FUNCTION_REF, display_order, added_by_id, added_date, added_at_ws_no, added_facility_id, modified_by_id, modified_date, modified_at_ws_no, modified_facility_id,EFF_STATUS) values(?,?,?,?,sysdate,?,?,?,sysdate,?,?,?)";											
				pstmt1 = con.prepareStatement(sql_adpt);			
		
			if(Integer.parseInt(count)>0){
				for(int i=1;i<=Integer.parseInt(count);i++)
				{						
					id	= req.getParameter("id_"+i)	== null ? "" : req.getParameter("id_"+i);
					display_order= req.getParameter("dispOrder_"+i)	== null ? "" : req.getParameter("dispOrder_"+i);	

						pstmt1.setString(1,adpt_function_name);
						pstmt1.setString(2,id);
						pstmt1.setString(3,display_order);								
						pstmt1.setString(4,addedById);								
						pstmt1.setString(5,addedAtWorkstation);
						pstmt1.setString(6,addedFacilityId);
						pstmt1.setString(7,modifiedById);								
						pstmt1.setString(8,modifiedAtWorkstation);
						pstmt1.setString(9,modifiedFacilityId);
						pstmt1.setString(10,eff_status);
						count_adpt = pstmt1.executeUpdate();						
								
						if (count_adpt > 0 )
								{
									insert = true;
								}
							}
						
					
					if(pstmt1 != null) pstmt1.close();
						if(insert)
							{								
								con.commit();
								tabdata = MessageManager.getMessage(locale,"RECORD_INSERTED","CA");
								errorMsg= (String) tabdata.get("message");
								errVal = "1";
							}
							else
							{								
								con.rollback();
								tabdata = MessageManager.getMessage(locale, "FAILED_TRANSACTION","CA");
								errorMsg= (String) tabdata.get("message");
								errVal = "0";
							}
						}
					else{
								con.commit();
								tabdata = MessageManager.getMessage(locale,"NO_RECORD_FOUND","COMMON");
								errorMsg= (String) tabdata.get("message");
								errVal = "1";
						
						}
				res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( errorMsg,"UTF-8" ) +"&err_value="+errVal);
				if(pstmt != null) pstmt.close();

			}
			
			catch (Exception ee)
			{				

				ee.printStackTrace();
			}
			finally
	 		{
				if(con != null)
					ConnectionManager.returnConnection(con,req);
			}
		
		
	
	}	

	private void insertQuickLinks(HttpServletRequest req, HttpServletResponse res, HttpSession session, PrintWriter out)
	{
		Connection con				= null;
		PreparedStatement pstmt		= null;
		PreparedStatement pstmt1	= null;		
		ResultSet rs				= null;
		Hashtable tabdata;
		try
		{
			java.util.Properties p;

			String ql_type			= "";
			String function_id		= "";
			String function_name	= "";
			String url				= "";
			String desc				= "";
			String function_spec	= "";
			String function_spec1	= "";
			String global			= "";
			String global1			= "";
			String eff_status		= "";
			String client_ip_address= "";
			String facilityId		= "";
			String quick_link_ref	= "";
			String errorMsg			= "";
			String errVal			= "0";
			String sql1				= "";			
			String count			= "";
			String param_list_str   = "";
			String histType="";//IN069654
			String browser_check=""; //IN27709

			ql_type					= req.getParameter("ql_type")		== null ? "" : req.getParameter("ql_type");
			function_id				= req.getParameter("function_id")	== null ? "" : req.getParameter("function_id");
			function_name			= req.getParameter("function_name")	== null ? "" : req.getParameter("function_name");
			url						= req.getParameter("url")			== null ? "" : req.getParameter("url");
			desc					= req.getParameter("desc")			== null ? "" : req.getParameter("desc");
			function_spec			= req.getParameter("function_spec")	== null ? "" : req.getParameter("function_spec");
			function_spec1			= req.getParameter("function_spec1")== null ? "" : req.getParameter("function_spec1");
			global					= req.getParameter("global")		== null ? "" : req.getParameter("global");
			global1					= req.getParameter("global1")		== null ? "" : req.getParameter("global1");
			eff_status				= req.getParameter("eff_status")	== null ? "D" : req.getParameter("eff_status");
			param_list_str			= req.getParameter("externalParamResult")	== null ? "" : req.getParameter("externalParamResult");
			histType				= req.getParameter("grphistory_type")	== null ? "" : req.getParameter("grphistory_type");//IN069654//IN071596
			//IN073728 Starts
			String totalHistTypes  = req.getParameter("totalHistTypes")	== null ? "" : req.getParameter("totalHistTypes");//IN071596
			browser_check  = req.getParameter("brows_chk")	== null ? "" : req.getParameter("brows_chk"); //IN27709
			String histTypeCEH = "";
			String histtypeSelected = "N";
			//IN073728 Ends
			if(desc.equals("")) desc =  function_name;
			if(function_spec.equals("")) function_spec =  function_spec1;
			if(global.equals("")) global =  global1;


			
			p						= (java.util.Properties) session.getValue( "jdbc" ) ;
			String locale			= (String) p.getProperty("LOCALE");
			client_ip_address		= (String) p.getProperty("client_ip_address");
			facilityId				= (String)session.getValue("facility_id");

			String addedById			= p.getProperty( "login_user" ) ;
			String modifiedById			= addedById ;
			String addedAtWorkstation	= client_ip_address;
			String modifiedAtWorkstation= addedAtWorkstation;
			String addedFacilityId		= facilityId;
			String modifiedFacilityId	= facilityId;
			String addedDate			= new java.text.SimpleDateFormat( "yyyy-MM-dd" ).format( new java.util.Date() ) ;
			String modifiedDate			= addedDate ;

			java.sql.Date added_date	= java.sql.Date.valueOf( addedDate ) ;
			java.sql.Date modified_date = java.sql.Date.valueOf( modifiedDate ) ;

			try
			{
				con = ConnectionManager.getConnection(req);

				String sqlCheck = "select 1 from SM_QUICK_LINK_LIST where QUICK_LINK_TYPE = ? and OPTION_ID = ? and QUICK_LINK_DESCRIPTION = ?";
				pstmt = con.prepareStatement(sqlCheck);
				pstmt.setString(1,ql_type);
				pstmt.setString(2,function_id);
				pstmt.setString(3,desc);
				
				rs = pstmt.executeQuery();
				if(rs != null && rs.next())
				{
					tabdata = MessageManager.getMessage(locale,"CODE_ALREADY_EXISTS","COMMON");
					errorMsg= (String) tabdata.get("message");
					errVal = "0";
				}
				else
				{
					String sql = "select SM_QUICK_LINK_SEQ.nextval from dual"; 
				
					if(pstmt != null) pstmt.close();
					if(rs != null) rs.close();

					pstmt = con.prepareStatement(sql);
					rs = pstmt.executeQuery();
					if(rs != null)
					{
						while(rs.next()) 
							quick_link_ref = rs.getString(1);
					}
					if(rs != null) rs.close();
					if(pstmt != null) pstmt.close();

					StringBuffer insert_sql = new StringBuffer();

					insert_sql.append(" Insert into SM_QUICK_LINK_LIST ( QUICK_LINK_REF,");
					insert_sql.append(" QUICK_LINK_TYPE,");
					insert_sql.append(" QUICK_LINK_DESCRIPTION,");
					insert_sql.append(" OPTION_ID,");
					insert_sql.append(" FUNCTION_SPEC_YN,");
					insert_sql.append(" GLOBAL_YN,");
					insert_sql.append(" EXTERNAL_URL_APPL,");
					insert_sql.append(" EFF_STATUS,");
					insert_sql.append(" added_by_id,");
					insert_sql.append(" added_date,");
					insert_sql.append(" added_at_ws_no,");
					insert_sql.append(" added_facility_id,");
					insert_sql.append(" modified_by_id,");
					insert_sql.append(" modified_date,");
					insert_sql.append(" modified_at_ws_no,");
					insert_sql.append(" modified_facility_id,");
					insert_sql.append(" QUERY_STRING,");
					insert_sql.append(" HIST_TYPE, ");//IN069654
					insert_sql.append(" BROWSER_CHECK ) "); //IN27709
					//insert_sql.append(" values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");//IN069654
					insert_sql.append("  values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");//IN069654 //IN27709
					pstmt = con.prepareStatement(insert_sql.toString());
					pstmt.setString(1,quick_link_ref);
					pstmt.setString(2,ql_type);
					pstmt.setString(3,desc);
					pstmt.setString(4,function_id);
					pstmt.setString(5,function_spec);
					pstmt.setString(6,global);
					pstmt.setString(7,url);
					pstmt.setString(8,eff_status);
					pstmt.setString(9,addedById);
					pstmt.setDate(10,added_date);
					pstmt.setString(11,addedAtWorkstation);
					pstmt.setString(12,addedFacilityId);
					pstmt.setString(13,modifiedById);
					pstmt.setDate(14,modified_date);
					pstmt.setString(15,modifiedAtWorkstation);
					pstmt.setString(16,modifiedFacilityId);
					pstmt.setString(17,param_list_str);
					//IN073728 Starts
					//pstmt.setString(18,histType);//IN069654
					if(ql_type.equals("QF") && function_id.equals("FLOW_SHEET_NEW"))
						pstmt.setString(18,"*ALL");
					else
						pstmt.setString(18,histType);
					//IN073728 ENDS
					
					pstmt.setString(19,browser_check); //IN27709
					int count1 = pstmt.executeUpdate();

					if (count1 > 0 ) 
					{
						count = req.getParameter("count")	== null ? "0" : req.getParameter("count");
						int noOfCount = Integer.parseInt(count);
						boolean insert = false;
						//IN073728 Starts	
						if(ql_type.equals("QF") && function_id.equals("FLOW_SHEET_NEW"))
						{
							
							for(int m=0;m<Integer.valueOf(totalHistTypes);m++)
							{
								histTypeCEH  = req.getParameter("eventHistStr"+m)	== null ? "" : req.getParameter("eventHistStr"+m);//IN071596
								histtypeSelected = req.getParameter("histtypeSelected"+histTypeCEH)	== null ? "" : req.getParameter("histtypeSelected"+histTypeCEH);//IN071596
								
								String column_id	= "";
								String date_ind		= "";
								String noOfDays		= "";
								String value_ind	= "";
								String value_type	= "";
								String actual_val	= "";
								String relative_val = "";
								String column_type	= "";
								int count2 = 0;

								sql1 = "insert into SM_QUICK_LINK_DEFN (QUICK_LINK_REF, COLUMN_ID, VALUE_TYPE, ACTUAL_VALUE, DATETIME_RELATIVE_IND, DATETIME_RELATIVE_VAL, DATETIME_RELATIVE_UNIT, RELATIVE_FIELD_REF, added_by_id, added_date, added_at_ws_no, added_facility_id, modified_by_id, modified_date, modified_at_ws_no, modified_facility_id,HIST_TYPE) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

								pstmt1 = con.prepareStatement(sql1);
								if("Y".equals(histtypeSelected))
								{
									for(int i=0;i<noOfCount;i++)
									{
										column_id	= req.getParameter("column_id"+i+histTypeCEH)	== null ? "" : req.getParameter("column_id"+i+histTypeCEH);
										date_ind	= req.getParameter("date_ind"+i+histTypeCEH)	== null ? "" : req.getParameter("date_ind"+i+histTypeCEH);
										noOfDays	= req.getParameter("noOfDays"+i+histTypeCEH)	== null ? "" : req.getParameter("noOfDays"+i+histTypeCEH);
										value_ind	= req.getParameter("value_ind"+i+histTypeCEH)	== null ? "" : req.getParameter("value_ind"+i+histTypeCEH);
										actual_val	= req.getParameter("actual_val"+i+histTypeCEH)	== null ? "" : req.getParameter("actual_val"+i+histTypeCEH);
										relative_val= req.getParameter("relative_val"+i+histTypeCEH)== null ? "" : req.getParameter("relative_val"+i+histTypeCEH);
										value_type	= req.getParameter("value_type"+i+histTypeCEH)	== null ? "" : req.getParameter("value_type"+i+histTypeCEH);
										column_type	= req.getParameter("column_type"+i+histTypeCEH)	== null ? "" : req.getParameter("column_type"+i+histTypeCEH);
										
										if(column_type.equals("CHECKBOX") && actual_val.equals(""))
										{
											actual_val = "N";
										}

										pstmt1.setString(1,quick_link_ref);
										pstmt1.setString(2,column_id);
										pstmt1.setString(3,value_type);
										pstmt1.setString(4,actual_val);
										pstmt1.setString(5,date_ind);
										pstmt1.setString(6,noOfDays);
										pstmt1.setString(7,value_ind);
										pstmt1.setString(8,relative_val);
										pstmt1.setString(9,addedById);
										pstmt1.setDate(10,added_date);
										pstmt1.setString(11,addedAtWorkstation);
										pstmt1.setString(12,addedFacilityId);
										pstmt1.setString(13,modifiedById);
										pstmt1.setDate(14,modified_date);
										pstmt1.setString(15,modifiedAtWorkstation);
										pstmt1.setString(16,modifiedFacilityId);
										pstmt1.setString(17,histTypeCEH);
											
										System.out.println("ref id==>"+quick_link_ref+"columnid==>"+column_id+"histTypeCEH==>"+histTypeCEH);
										count2 = pstmt1.executeUpdate();
										
										if (count2 > 0 )
										{
											insert = true;
										}
									}
								}
							}
							if(pstmt1 != null) pstmt1.close();
							if(insert)
							{
								con.commit();
								tabdata = MessageManager.getMessage(locale,"RECORD_INSERTED","CA");
								errorMsg= (String) tabdata.get("message");
								errVal = "1";
							}
							else
							{
								con.rollback();
								tabdata = MessageManager.getMessage(locale, "FAILED_TRANSACTION","CA");
								errorMsg= (String) tabdata.get("message");
								errVal = "0";
							}
						
						}
						//if(ql_type.equals("QF") && noOfCount > 0)
						else if (ql_type.equals("QF") && noOfCount > 0)
						{//IN073728 Ends
							String column_id	= "";
							String date_ind		= "";
							String noOfDays		= "";
							String value_ind	= "";
							String value_type	= "";
							String actual_val	= "";
							String relative_val = "";
							String column_type	= "";
							int count2 = 0;

							sql1 = "insert into SM_QUICK_LINK_DEFN (QUICK_LINK_REF, COLUMN_ID, VALUE_TYPE, ACTUAL_VALUE, DATETIME_RELATIVE_IND, DATETIME_RELATIVE_VAL, DATETIME_RELATIVE_UNIT, RELATIVE_FIELD_REF, added_by_id, added_date, added_at_ws_no, added_facility_id, modified_by_id, modified_date, modified_at_ws_no, modified_facility_id) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

							pstmt1 = con.prepareStatement(sql1);

							for(int i=0;i<noOfCount;i++)
							{
								column_id	= req.getParameter("column_id"+i)	== null ? "" : req.getParameter("column_id"+i);
								date_ind	= req.getParameter("date_ind"+i)	== null ? "" : req.getParameter("date_ind"+i);
								noOfDays	= req.getParameter("noOfDays"+i)	== null ? "" : req.getParameter("noOfDays"+i);
								value_ind	= req.getParameter("value_ind"+i)	== null ? "" : req.getParameter("value_ind"+i);
								actual_val	= req.getParameter("actual_val"+i)	== null ? "" : req.getParameter("actual_val"+i);
								relative_val= req.getParameter("relative_val"+i)== null ? "" : req.getParameter("relative_val"+i);
								value_type	= req.getParameter("value_type"+i)	== null ? "" : req.getParameter("value_type"+i);
								column_type	= req.getParameter("column_type"+i)	== null ? "" : req.getParameter("column_type"+i);
								
								if(column_type.equals("CHECKBOX") && actual_val.equals(""))
								{
									actual_val = "N";
								}

								pstmt1.setString(1,quick_link_ref);
								pstmt1.setString(2,column_id);
								pstmt1.setString(3,value_type);
								pstmt1.setString(4,actual_val);
								pstmt1.setString(5,date_ind);
								pstmt1.setString(6,noOfDays);
								pstmt1.setString(7,value_ind);
								pstmt1.setString(8,relative_val);
								pstmt1.setString(9,addedById);
								pstmt1.setDate(10,added_date);
								pstmt1.setString(11,addedAtWorkstation);
								pstmt1.setString(12,addedFacilityId);
								pstmt1.setString(13,modifiedById);
								pstmt1.setDate(14,modified_date);
								pstmt1.setString(15,modifiedAtWorkstation);
								pstmt1.setString(16,modifiedFacilityId);

								count2 = pstmt1.executeUpdate();
								
								if (count2 > 0 )
								{
									insert = true;
								}
							}
							if(pstmt1 != null) pstmt1.close();
							if(insert)
							{
								con.commit();
								tabdata = MessageManager.getMessage(locale,"RECORD_INSERTED","CA");
								errorMsg= (String) tabdata.get("message");
								errVal = "1";
							}
							else
							{
								con.rollback();
								tabdata = MessageManager.getMessage(locale, "FAILED_TRANSACTION","CA");
								errorMsg= (String) tabdata.get("message");
								errVal = "0";
							}
						}
						else
						{
							con.commit();
							tabdata = MessageManager.getMessage(locale,"RECORD_INSERTED","CA");
							errorMsg= (String) tabdata.get("message");
							errVal = "1";
						}
					}
					else
					{
						con.rollback();
						tabdata = MessageManager.getMessage(locale, "FAILED_TRANSACTION","CA");
						errorMsg= (String) tabdata.get("message");
						errVal = "0";
					}
				}
				res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( errorMsg,"UTF-8" ) +"&err_value="+errVal);
				if(pstmt != null) pstmt.close();
			}
			catch (Exception ee)
			{
				con.rollback();

				ee.printStackTrace();
			}
			finally
	 		{
				if(con != null)
					ConnectionManager.returnConnection(con,req);
			}
		}
		catch (Exception e)
		{

			e.printStackTrace();
		}
	}


	private void updateQuickLinks(HttpServletRequest req, HttpServletResponse res, HttpSession session, PrintWriter out)
	{
		Connection con				= null;
		PreparedStatement pstmt		= null;
		PreparedStatement pstmt1	= null,pstmt2=null;		
		ResultSet rs =null;
		Hashtable tabdata;
		try
		{
			java.util.Properties p;

			String ql_type			= "";
			String function_id		= "";
			String url				= "";
			String desc				= "";
			String function_spec	= "";
			String function_spec1	= "";
			String global			= "";
			String global1			= "";
			String eff_status		= "";
			String client_ip_address= "";
			String facilityId		= "";
			String quick_link_ref	= "";
			String errorMsg			= "";
			String errVal			= "0";
			String sql1				= "",sql2="";			
			String count			= "";
			String param_list_str   = "";
			String histType="";//IN069654
			String browser_check=""; //IN27709
			ql_type					= req.getParameter("ql_type1")		== null ? "" : req.getParameter("ql_type1");
			function_id				= req.getParameter("function_id")	== null ? "" : req.getParameter("function_id");
			url						= req.getParameter("url")			== null ? "" : req.getParameter("url");
			desc					= req.getParameter("desc")			== null ? "" : req.getParameter("desc");
			function_spec			= req.getParameter("function_spec")	== null ? "" : req.getParameter("function_spec");
			function_spec1			= req.getParameter("function_spec1")== null ? "" : req.getParameter("function_spec1");
			global					= req.getParameter("global")		== null ? "" : req.getParameter("global");
			global1					= req.getParameter("global1")		== null ? "" : req.getParameter("global1");
			eff_status				= req.getParameter("eff_status")	== null ? "D" : req.getParameter("eff_status");
			quick_link_ref			= req.getParameter("ql_ref")		== null ? "" : req.getParameter("ql_ref");
			param_list_str				= req.getParameter("externalParamResult")	== null ? "" : req.getParameter("externalParamResult");
			histType				= req.getParameter("grphistory_type")	== null ? "" : req.getParameter("grphistory_type");//IN069654//IN071596
			String totalHistTypes  = req.getParameter("totalHistTypes")	== null ? "" : req.getParameter("totalHistTypes");//IN071596//IN073728
			browser_check  = req.getParameter("brows_chk")	== null ? "" : req.getParameter("brows_chk"); //IN27709
			
			if(url.equals(""))
				url = req.getParameter("url1") == null ? "" : req.getParameter("url1");
			if(desc.equals(""))
				desc = req.getParameter("desc1") == null ? "" : req.getParameter("desc1");
			if(function_spec.equals("")) function_spec =  function_spec1;
			if(global.equals("")) global =  global1;
			
			p						= (java.util.Properties) session.getValue( "jdbc" ) ;
			String locale			= (String) p.getProperty("LOCALE");
			client_ip_address		= (String) p.getProperty("client_ip_address");
			facilityId				= (String)session.getValue("facility_id");

			String modifiedById			= p.getProperty( "login_user" ) ;
			String modifiedAtWorkstation= client_ip_address; 
			String modifiedFacilityId	= facilityId;
			String modifiedDate			= new java.text.SimpleDateFormat( "yyyy-MM-dd" ).format( new java.util.Date() ) ;
			String histTypeCEH = "";//IN073728
			String histtypeSelected = "N";//IN073728
			java.sql.Date modified_date = java.sql.Date.valueOf( modifiedDate ) ;

			try
			{
				con = ConnectionManager.getConnection(req);

				StringBuffer update_sql = new StringBuffer();

				//update_sql.append(" update SM_QUICK_LINK_LIST set QUICK_LINK_DESCRIPTION = ?, FUNCTION_SPEC_YN = ?, GLOBAL_YN = ?, EXTERNAL_URL_APPL = ?, EFF_STATUS = ?, modified_by_id = ?, modified_date = ?, modified_at_ws_no = ?, modified_facility_id = ?, QUERY_STRING = ? where QUICK_LINK_REF = ? and QUICK_LINK_TYPE = ?  ");//modified for 20101.3
				update_sql.append(" update SM_QUICK_LINK_LIST set QUICK_LINK_DESCRIPTION = ?, FUNCTION_SPEC_YN = ?, GLOBAL_YN = ?, EXTERNAL_URL_APPL = ?, EFF_STATUS = ?, modified_by_id = ?, modified_date = ?, modified_at_ws_no = ?, modified_facility_id = ?, QUERY_STRING = ? , HIST_TYPE=? , BROWSER_CHECK=? where QUICK_LINK_REF = ? and QUICK_LINK_TYPE = ?  ");//20101.3 //IN27709
				pstmt = con.prepareStatement(update_sql.toString());
				pstmt.setString(1,desc);
				pstmt.setString(2,function_spec);
				pstmt.setString(3,global);
				pstmt.setString(4,url);
				pstmt.setString(5,eff_status);
				pstmt.setString(6,modifiedById);
				pstmt.setDate(7,modified_date);
				pstmt.setString(8,modifiedAtWorkstation);
				pstmt.setString(9,modifiedFacilityId);
				pstmt.setString(10,param_list_str);
				//IN073728 Starts
				//pstmt.setString(11,histType);//IN069654	
				if(ql_type.equals("QF") && "FLOW_SHEET_NEW".equals(function_id))
					pstmt.setString(11,"*ALL");
				else
					pstmt.setString(11,histType);
				//IN073728 Ends
				pstmt.setString(12,browser_check); //IN27709
				pstmt.setString(13,quick_link_ref);
				pstmt.setString(14,ql_type);
				
				int count1 = pstmt.executeUpdate();

				if (count1 > 0 )
				{
					count = req.getParameter("count")	== null ? "0" : req.getParameter("count");
					int noOfCount = Integer.parseInt(count);
					boolean update = false;	
					//IN073728 Starts				
					if(ql_type.equals("QF") && noOfCount > 0 && "FLOW_SHEET_NEW".equals(function_id))
					{

						String column_id	= "";
						String date_ind		= "";
						String noOfDays		= "";
						String value_ind	= "";
						String value_type	= "";
						String actual_val	= "";
						String relative_val = "";
						String column_type	= "";
						int count2 = 0;
						int column_exist = 0;
						for(int m=0;m<Integer.valueOf(totalHistTypes);m++)
						{
							histTypeCEH  = req.getParameter("eventHistStr"+m)	== null ? "" : req.getParameter("eventHistStr"+m);//IN071596
							histtypeSelected = req.getParameter("histtypeSelected"+histTypeCEH)	== null ? "" : req.getParameter("histtypeSelected"+histTypeCEH);//IN071596
						
							sql1 = "SELECT 1 FROM SM_QUICK_LINK_DEFN  WHERE QUICK_LINK_REF = ? and COLUMN_ID = ? AND HIST_TYPE= ?";										

							pstmt2 = con.prepareStatement(sql1);
							if("Y".equals(histtypeSelected))
							{		
								for(int i=0;i<noOfCount;i++)
								{
									column_exist = 0;
									column_id	= req.getParameter("column_id"+i+histTypeCEH)	== null ? "" : req.getParameter("column_id"+i+histTypeCEH);
									date_ind	= req.getParameter("date_ind"+i+histTypeCEH)	== null ? "" : req.getParameter("date_ind"+i+histTypeCEH);
									noOfDays	= req.getParameter("noOfDays"+i+histTypeCEH)	== null ? "" : req.getParameter("noOfDays"+i+histTypeCEH);
									value_ind	= req.getParameter("value_ind"+i+histTypeCEH)	== null ? "" : req.getParameter("value_ind"+i+histTypeCEH);
									actual_val	= req.getParameter("actual_val"+i+histTypeCEH)	== null ? "" : req.getParameter("actual_val"+i+histTypeCEH);
									relative_val= req.getParameter("relative_val"+i+histTypeCEH)== null ? "" : req.getParameter("relative_val"+i+histTypeCEH);
									value_type	= req.getParameter("value_type"+i+histTypeCEH)	== null ? "" : req.getParameter("value_type"+i+histTypeCEH);
									column_type	= req.getParameter("column_type"+i+histTypeCEH)	== null ? "" : req.getParameter("column_type"+i+histTypeCEH);
									
									if(column_type.equals("CHECKBOX") && actual_val.equals(""))
									{
										actual_val = "N";
									}
									pstmt2.setString(1,quick_link_ref);
									pstmt2.setString(2,column_id);
									pstmt2.setString(3,histTypeCEH);
									rs = pstmt2.executeQuery();
									if (rs != null && rs.next())
									{
										column_exist = rs.getInt(1);
									}
									if (rs != null)rs.close();						
									
									if (column_exist == 1)
									{
										sql2 = "update SM_QUICK_LINK_DEFN set VALUE_TYPE = ?, ACTUAL_VALUE = ?, DATETIME_RELATIVE_IND = ?, DATETIME_RELATIVE_VAL = ?, DATETIME_RELATIVE_UNIT = ?, RELATIVE_FIELD_REF = ?,  modified_by_id = ?, modified_date = ?, modified_at_ws_no = ?, modified_facility_id = ? where QUICK_LINK_REF = ? and COLUMN_ID = ? AND HIST_TYPE=?";
										pstmt1 = con.prepareStatement(sql2);
										pstmt1.setString(1,value_type);
										pstmt1.setString(2,actual_val);
										pstmt1.setString(3,date_ind);
										pstmt1.setString(4,noOfDays);
										pstmt1.setString(5,value_ind);
										pstmt1.setString(6,relative_val);
										pstmt1.setString(7,modifiedById);
										pstmt1.setDate(8,modified_date);
										pstmt1.setString(9,modifiedAtWorkstation);
										pstmt1.setString(10,modifiedFacilityId);
										pstmt1.setString(11,quick_link_ref);
										pstmt1.setString(12,column_id);
										pstmt1.setString(13,histTypeCEH);
									}else{
										sql2 = "insert into SM_QUICK_LINK_DEFN (QUICK_LINK_REF, COLUMN_ID, VALUE_TYPE, ACTUAL_VALUE, DATETIME_RELATIVE_IND, DATETIME_RELATIVE_VAL, DATETIME_RELATIVE_UNIT, RELATIVE_FIELD_REF, added_by_id, added_date, added_at_ws_no, added_facility_id, modified_by_id, modified_date, modified_at_ws_no, modified_facility_id,HIST_TYPE) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
										pstmt1 = con.prepareStatement(sql2);
										pstmt1.setString(1,quick_link_ref);
										pstmt1.setString(2,column_id);
										pstmt1.setString(3,value_type);
										pstmt1.setString(4,actual_val);
										pstmt1.setString(5,date_ind);
										pstmt1.setString(6,noOfDays);
										pstmt1.setString(7,value_ind);
										pstmt1.setString(8,relative_val);
										pstmt1.setString(9,modifiedById);
										pstmt1.setDate(10,modified_date);
										pstmt1.setString(11,modifiedAtWorkstation);
										pstmt1.setString(12,modifiedFacilityId);
										pstmt1.setString(13,modifiedById);
										pstmt1.setDate(14,modified_date);
										pstmt1.setString(15,modifiedAtWorkstation);
										pstmt1.setString(16,modifiedFacilityId);
										pstmt1.setString(17,histTypeCEH);
										
									}
									
		
									count2 = pstmt1.executeUpdate();
									
									if (count2 > 0 )
									{
										update = true;
									}
									if(pstmt1 != null) pstmt1.close();
								} 
							}
							if(pstmt2 != null) pstmt2.close();
						}
						
						if(update)
						{
							con.commit(); 
							tabdata = MessageManager.getMessage(locale,"RECORD_INSERTED","CA");
							errorMsg= (String) tabdata.get("message");
							errVal = "1";
						}
						else
						{
							con.rollback();
							tabdata = MessageManager.getMessage(locale, "FAILED_TRANSACTION","CA");
							errorMsg= (String) tabdata.get("message");
							errVal = "0";
						}
					
					}
					else if(ql_type.equals("QF") && noOfCount > 0)//IN073728 Ends
					{
						String column_id	= "";
						String date_ind		= "";
						String noOfDays		= "";
						String value_ind	= "";
						String value_type	= "";
						String actual_val	= "";
						String relative_val = "";
						String column_type	= "";
						int count2 = 0;
						int column_exist = 0;
						//Added by Sridhar Reddy For CRF GHL-CRF-0043.
						/*
							This changes will reflect to insert the newly added components/columns to  existing quick link definition in update mode. 
						*/
						sql1 = "SELECT 1 FROM SM_QUICK_LINK_DEFN  WHERE QUICK_LINK_REF = ? and COLUMN_ID = ?";										

						pstmt2 = con.prepareStatement(sql1);

						for(int i=0;i<noOfCount;i++)
						{
							column_exist = 0;
							column_id	= req.getParameter("column_id"+i)	== null ? "" : req.getParameter("column_id"+i);
							date_ind	= req.getParameter("date_ind"+i)	== null ? "" : req.getParameter("date_ind"+i);
							noOfDays	= req.getParameter("noOfDays"+i)	== null ? "" : req.getParameter("noOfDays"+i);
							value_ind	= req.getParameter("value_ind"+i)	== null ? "" : req.getParameter("value_ind"+i);
							actual_val	= req.getParameter("actual_val"+i)	== null ? "" : req.getParameter("actual_val"+i);
							relative_val= req.getParameter("relative_val"+i)== null ? "" : req.getParameter("relative_val"+i);
							value_type	= req.getParameter("value_type"+i)	== null ? "" : req.getParameter("value_type"+i);
							column_type	= req.getParameter("column_type"+i)	== null ? "" : req.getParameter("column_type"+i);
							
							if(column_type.equals("CHECKBOX") && actual_val.equals(""))
							{
								actual_val = "N";
							}
							pstmt2.setString(1,quick_link_ref);
							pstmt2.setString(2,column_id);
							rs = pstmt2.executeQuery();
							if (rs != null && rs.next())
							{
								column_exist = rs.getInt(1);
							}
							if (rs != null)rs.close();						
							
							if (column_exist == 1)
							{
								sql2 = "update SM_QUICK_LINK_DEFN set VALUE_TYPE = ?, ACTUAL_VALUE = ?, DATETIME_RELATIVE_IND = ?, DATETIME_RELATIVE_VAL = ?, DATETIME_RELATIVE_UNIT = ?, RELATIVE_FIELD_REF = ?,  modified_by_id = ?, modified_date = ?, modified_at_ws_no = ?, modified_facility_id = ? where QUICK_LINK_REF = ? and COLUMN_ID = ?";
								pstmt1 = con.prepareStatement(sql2);
								pstmt1.setString(1,value_type);
								pstmt1.setString(2,actual_val);
								pstmt1.setString(3,date_ind);
								pstmt1.setString(4,noOfDays);
								pstmt1.setString(5,value_ind);
								pstmt1.setString(6,relative_val);
								pstmt1.setString(7,modifiedById);
								pstmt1.setDate(8,modified_date);
								pstmt1.setString(9,modifiedAtWorkstation);
								pstmt1.setString(10,modifiedFacilityId);
								pstmt1.setString(11,quick_link_ref);
								pstmt1.setString(12,column_id);
							}else{
								sql2 = "insert into SM_QUICK_LINK_DEFN (QUICK_LINK_REF, COLUMN_ID, VALUE_TYPE, ACTUAL_VALUE, DATETIME_RELATIVE_IND, DATETIME_RELATIVE_VAL, DATETIME_RELATIVE_UNIT, RELATIVE_FIELD_REF, added_by_id, added_date, added_at_ws_no, added_facility_id, modified_by_id, modified_date, modified_at_ws_no, modified_facility_id) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
								pstmt1 = con.prepareStatement(sql2);
								pstmt1.setString(1,quick_link_ref);
								pstmt1.setString(2,column_id);
								pstmt1.setString(3,value_type);
								pstmt1.setString(4,actual_val);
								pstmt1.setString(5,date_ind);
								pstmt1.setString(6,noOfDays);
								pstmt1.setString(7,value_ind);
								pstmt1.setString(8,relative_val);
								pstmt1.setString(9,modifiedById);
								pstmt1.setDate(10,modified_date);
								pstmt1.setString(11,modifiedAtWorkstation);
								pstmt1.setString(12,modifiedFacilityId);
								pstmt1.setString(13,modifiedById);
								pstmt1.setDate(14,modified_date);
								pstmt1.setString(15,modifiedAtWorkstation);
								pstmt1.setString(16,modifiedFacilityId);
								
							}
							

							count2 = pstmt1.executeUpdate();
							
							if (count2 > 0 )
							{
								update = true;
							}
							if(pstmt1 != null) pstmt1.close();
						}
						if(pstmt2 != null) pstmt2.close();
						if(update)
						{
							con.commit();
							tabdata = MessageManager.getMessage(locale,"RECORD_INSERTED","CA");
							errorMsg= (String) tabdata.get("message");
							errVal = "1";
						}
						else
						{
							con.rollback();
							tabdata = MessageManager.getMessage(locale, "FAILED_TRANSACTION","CA");
							errorMsg= (String) tabdata.get("message");
							errVal = "0";
						}
					}
					else
					{
						con.commit();
						tabdata = MessageManager.getMessage(locale,"RECORD_INSERTED","CA");
						errorMsg= (String) tabdata.get("message");
						errVal = "1";
					}
				}
				else
				{
					con.rollback();
					tabdata = MessageManager.getMessage(locale, "FAILED_TRANSACTION","CA");
					errorMsg= (String) tabdata.get("message");
					errVal = "0";
				}
				res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( errorMsg,"UTF-8" ) +"&err_value="+errVal);
				if(pstmt != null) pstmt.close();
			}
			catch (Exception ee)
			{
				con.rollback();

				ee.printStackTrace();
			}
			finally
	 		{
				if(con != null)
					ConnectionManager.returnConnection(con,req);
			}
		}
		catch(Exception e)
		{

			e.printStackTrace();
		}
	}
}
