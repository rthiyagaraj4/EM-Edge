/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eOH;

import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import webbeans.eCommon.ConnectionManager;
import org.xml.sax.InputSource;
import webbeans.eCommon.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PerioChartServlet extends javax.servlet.http.HttpServlet {
	public void init(ServletConfig config) throws ServletException	{
		super.init(config);
	}

	private String checkForNull(String str){
		return (str!=null && str.intern()!="null")?str:"";
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res)	throws javax.servlet.ServletException,IOException{
		PrintWriter out;
		//HashMap hashElement=null,map=null;
		eOH.MasterXMLParse masterXMLParse;
		HashMap CommonData=new HashMap();
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
		HttpSession session=req.getSession(false);
		out=res.getWriter();
					
		masterXMLParse=new eOH.MasterXMLParse();
		String client_ip_address="";
		String facility_id = "";	
		String login_user=""; 
		String locale="";
		
		java.util.Properties prop = null;
		facility_id = (String)session.getValue( "facility_id" ) ;
		prop = (java.util.Properties) session.getValue( "jdbc" ) ;
		client_ip_address = prop.getProperty( "client_ip_address" );
		login_user = prop.getProperty( "login_user" );
		locale = prop.getProperty("LOCALE");
	
		CommonData.put("login_user", login_user); 
		CommonData.put("login_at_ws_no",client_ip_address);
		CommonData.put("facility_id",facility_id);
		CommonData.put("locale",locale);
		
		Connection con = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt_PDCEJ = null;
		ResultSet rs = null;

		String sqlInsert = "";
		//String sqlUpdate ="";	//Commented Against Common-ICN-0031
		String msg="";
		String commit_flag = "N";

		int flag=0;
		int flag1=0;
		int flag_delete=0;
		int flag_PDCEJ=0;
		int index = 1;
		
		try{
				con = ConnectionManager.getConnection(req);
				String chart_type = "";
				//String line_num = "";	//Commented Against Common-ICN-0031
				
				String DB_perio_comp = "";
				String data_exists_yn = "N";
				String CAL_bs1 = "";
				String CAL_bs2 = "";
				String CAL_bs3 = "";
				String CAL_ls1 = "";
				String CAL_ls2 = "";
				String CAL_ls3 = "";

				String s1 = "";
				String s2 = "";
				String s3 = "";
				String s4 = "";
				String s5 = "";
				String s6 = "";

				String patient_id=checkForNull(req.getParameter("patient_id"));
				String encounter_id=checkForNull(req.getParameter("encounter_id"));
				String patient_class=checkForNull(req.getParameter("patient_class"));
				String episode_type=checkForNull(req.getParameter("episode_type"));
				String episode_id=checkForNull(req.getParameter("episode_id"));
				String visit_id=checkForNull(req.getParameter("visit_id"));
				
				String chart_num = checkForNull(req.getParameter("cur_chart_num"));
				String chart_line_num = checkForNull(req.getParameter("chart_line_num"));
				String show_new_active_yn = checkForNull(req.getParameter( "show_new_active_yn" )) ;
				String chart_hdr_insert_yn = checkForNull(req.getParameter("chart_hdr_insert_yn"));
				String insert_new_EC_yn = checkForNull(req.getParameter("insert_new_EC_yn"));
				String header_tab=checkForNull(req.getParameter("header_tab"));
				String DB_insert_yn=checkForNull(req.getParameter("DB_insert_yn"));
		
				if(header_tab.equals("B")){
					chart_type = "BC";
				}
				else if(header_tab.equals("E")){
					chart_type = "EC";
				}
		
				String perio_chart=checkForNull(req.getParameter("perio_chart"));
				String perio_comp = checkForNull(req.getParameter("perio_comp"));
				String perio_tooth = checkForNull(req.getParameter("perio_tooth"));

				String bs1 = checkForNull(req.getParameter("bs1"));
				String bs2 = checkForNull(req.getParameter("bs2"));
				String bs3 = checkForNull(req.getParameter("bs3"));
				String ls1 = checkForNull(req.getParameter("ls1"));
				String ls2 = checkForNull(req.getParameter("ls2"));
				String ls3 = checkForNull(req.getParameter("ls3"));

				String non_surface_value = checkForNull(req.getParameter("non_surface_value"));
			
				if(show_new_active_yn.equals("Y") && chart_hdr_insert_yn.equals("Y") && header_tab.equals("B")){
					String chart_status = "PE";
					// for a New Chart.
					/*
					Case 1. New chart getting inserted for the 1st time
					Case 2. New chart getting inserted. Update the old with chart_status as 'C' and insert a new chart.
					*/

					chart_num = checkForNull(req.getParameter("chart_num"));

					if(rs != null) rs.close();
					if(pstmt != null) pstmt.close();

					sqlInsert="INSERT INTO OH_PERIODONTAL_CHART_HDR (OPERATING_FACILITY_ID,PATIENT_ID,CHART_NUM,CHART_CODE,CHART_DATE,CHART_TYPE,CHART_STATUS,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID) VALUES (?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?)";
					pstmt=con.prepareStatement(sqlInsert);
					pstmt.setString(1,facility_id);
					pstmt.setString(2,patient_id);
					pstmt.setString(3,chart_num);
					pstmt.setString(4,perio_chart); //CHART_CODE
					pstmt.setString(5,chart_type);
					pstmt.setString(6,chart_status);

					pstmt.setString(7,login_user);
					pstmt.setString(8,client_ip_address);
					pstmt.setString(9,facility_id);
					pstmt.setString(10,login_user);
					pstmt.setString(11,client_ip_address); 
					pstmt.setString(12,facility_id);
					flag1 = pstmt.executeUpdate();

					if(rs != null) rs.close();
					if(pstmt != null) pstmt.close();

					sqlInsert="INSERT INTO OH_PERIODONTAL_CHART_HDR_LINE (OPERATING_FACILITY_ID,PATIENT_ID,CHART_NUM,CHART_LINE_NUM,CHART_CODE,CHART_LINE_DATE,CHART_TYPE,CHART_LINE_STATUS,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID) VALUES (?,?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?)";
					pstmt=con.prepareStatement(sqlInsert);
					pstmt.setString(1,facility_id);
					pstmt.setString(2,patient_id);
					pstmt.setString(3,chart_num);
					pstmt.setString(4,chart_line_num);
					pstmt.setString(5,perio_chart); //CHART_CODE
					pstmt.setString(6,chart_type);
					pstmt.setString(7,chart_status);

					pstmt.setString(8,login_user);
					pstmt.setString(9,client_ip_address);
					pstmt.setString(10,facility_id);
					pstmt.setString(11,login_user);
					pstmt.setString(12,client_ip_address); 
					pstmt.setString(13,facility_id);
					flag1 = pstmt.executeUpdate();
				}

				if(header_tab.equals("E") && insert_new_EC_yn.equals("Y")){
					String chart_status = "PE";
					
					if(rs != null) rs.close();
					if(pstmt != null) pstmt.close();
					sqlInsert="INSERT INTO OH_PERIODONTAL_CHART_HDR_LINE (OPERATING_FACILITY_ID,PATIENT_ID,CHART_NUM,CHART_LINE_NUM,CHART_CODE,CHART_LINE_DATE,CHART_TYPE,CHART_LINE_STATUS,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID) VALUES (?,?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?)";
					pstmt=con.prepareStatement(sqlInsert);
					pstmt.setString(1,facility_id);
					pstmt.setString(2,patient_id);
					pstmt.setString(3,chart_num);
					pstmt.setString(4,chart_line_num);
					pstmt.setString(5,perio_chart); //CHART_CODE
					pstmt.setString(6,chart_type);
					pstmt.setString(7,chart_status);

					pstmt.setString(8,login_user);
					pstmt.setString(9,client_ip_address);
					pstmt.setString(10,facility_id);
					pstmt.setString(11,login_user);
					pstmt.setString(12,client_ip_address); 
					pstmt.setString(13,facility_id);
					flag1 = pstmt.executeUpdate();
				}

				if(pstmt != null) pstmt.close();

				/* 
					1. chart_num.equals("1") && chart_hdr_insert_yn.equals("N") for new chart and without refresh case
					2. !chart_num.equals("1") for existing chart
					3. show_new_active_yn.equals("N"): For Mixed Dentition Copy case
				*/
				
				ArrayList flag_arr= new ArrayList();
				if(header_tab.equals("B")){
					chart_line_num = "1";
				}

				//To delete the records of the tooth for which Missing tooth is recorded..
				if(pstmt != null) pstmt.close();
				if(perio_comp.equals("MITH") && non_surface_value.equals("1")){
					//pstmt = con.prepareStatement("DELETE FROM OH_PERIODONTAL_CHART_DTL WHERE OPERATING_FACILITY_ID = ? AND PATIENT_ID = ? AND CHART_CODE = ? AND CHART_NUM = ? AND TOOTH_NO = ?");
					pstmt = con.prepareStatement("DELETE FROM OH_PERIODONTAL_CHART_DTL WHERE OPERATING_FACILITY_ID = ? AND PATIENT_ID = ? AND CHART_CODE = ? AND CHART_NUM = ? AND TOOTH_NO = ? AND CHART_LINE_NUM <> '1'");
					pstmt.setString(1,facility_id);
					pstmt.setString(2,patient_id);
					pstmt.setString(3,perio_chart);
					pstmt.setString(4,chart_num);
					pstmt.setString(5,perio_tooth);
					flag_delete=pstmt.executeUpdate();
				}

				if(pstmt != null) pstmt.close();
				if(rs != null) rs.close();
				if(perio_comp.equals("PD") || perio_comp.equals("CEJ")){
					if(DB_insert_yn.equals("Y")){
										
						if(perio_comp.equals("PD")){
							DB_perio_comp = "CEJ";
						}
						else if(perio_comp.equals("CEJ")){
							DB_perio_comp = "PD";
						}

						//get the recorded PD or CEJ values for the tooth
						pstmt = con.prepareStatement("SELECT S1, S2, S3, S4, S5, S6 FROM OH_PERIODONTAL_CHART_DTL WHERE OPERATING_FACILITY_ID = ? AND PATIENT_ID = ? AND CHART_CODE = ? AND TOOTH_NO = ? AND COMPONENT_CODE = ? AND CHART_NUM = ? AND CHART_LINE_NUM = ? ");
				
						pstmt.setString(1,facility_id);
						pstmt.setString(2,patient_id);
						pstmt.setString(3,perio_chart);
						pstmt.setString(4,perio_tooth);
						pstmt.setString(5,DB_perio_comp);
						pstmt.setString(6,chart_num);
						pstmt.setString(7,chart_line_num);
						rs=pstmt.executeQuery();
						while(rs.next()){
							data_exists_yn = "Y";
							s1 = checkForNull(rs.getString("S1"));
							s2 = checkForNull(rs.getString("S2"));
							s3 = checkForNull(rs.getString("S3"));
							s4 = checkForNull(rs.getString("S4"));
							s5 = checkForNull(rs.getString("S5"));
							s6 = checkForNull(rs.getString("S6"));

							if(!s1.equals("") && !bs1.equals("")){
								CAL_bs1 = (Integer.parseInt(s1)+Integer.parseInt(bs1))+"";
							}
							else if(!s1.equals("")&& bs1.equals("")){
								CAL_bs1 = (Integer.parseInt(s1))+"";
							}
							else if(s1.equals("")&& !bs1.equals("")){
								CAL_bs1 = (Integer.parseInt(bs1))+"";
							}
							else{
								CAL_bs1 =  "";
							}

							if(!s2.equals("") && !bs2.equals("")){
								CAL_bs2 = (Integer.parseInt(s2)+Integer.parseInt(bs2))+"";
							}
							else if(!s2.equals("")&& bs2.equals("")){
								CAL_bs2 = (Integer.parseInt(s2))+"";
							}
							else if(s2.equals("")&& !bs2.equals("")){
								CAL_bs2 = (Integer.parseInt(bs2))+"";
							}
							else{
								CAL_bs2 =  "";
							}

							if(!s3.equals("") && !bs3.equals("")){
								CAL_bs3 = (Integer.parseInt(s3)+Integer.parseInt(bs3))+"";
							}
							else if(!s3.equals("")&& bs3.equals("")){
								CAL_bs3 = (Integer.parseInt(s3))+"";
							}
							else if(s3.equals("")&& !bs3.equals("")){
								CAL_bs3 = (Integer.parseInt(bs3))+"";
							}
							else{
								CAL_bs3 =  "";
							}

							if(!s4.equals("") && !ls1.equals("")){
								CAL_ls1 = (Integer.parseInt(s4)+Integer.parseInt(ls1))+"";
							}
							else if(!s4.equals("")&& ls1.equals("")){
								CAL_ls1 = (Integer.parseInt(s4))+"";
							}
							else if(s4.equals("")&& !ls1.equals("")){
								CAL_ls1 = (Integer.parseInt(ls1))+"";
							}
							else{
								CAL_ls1 =  "";
							}

							if(!s5.equals("") && !ls2.equals("")){
								CAL_ls2 = (Integer.parseInt(s5)+Integer.parseInt(ls2))+"";
							}
							else if(!s5.equals("")&& ls2.equals("")){
								CAL_ls2 = (Integer.parseInt(s5))+"";
							}
							else if(s5.equals("")&& !ls2.equals("")){
								CAL_ls2 = (Integer.parseInt(ls2))+"";
							}
							else{
								CAL_ls2 =  "";
							}

							if(!s6.equals("") && !ls3.equals("")){
								CAL_ls3 = (Integer.parseInt(s6)+Integer.parseInt(ls3))+"";
							}
							else if(!s6.equals("")&& ls3.equals("")){
								CAL_ls3 = (Integer.parseInt(s6))+"";
							}
							else if(s6.equals("")&& !ls3.equals("")){
								CAL_ls3 = (Integer.parseInt(ls3))+"";
							}
							else{
								CAL_ls3 =  "";
							}

							/*
							CAL_bs2 = Integer.parseInt(s2)+Integer.parseInt(bs2);
							CAL_bs3 = Integer.parseInt(s3)+Integer.parseInt(bs3);
							CAL_ls1 = Integer.parseInt(s4)+Integer.parseInt(ls1);
							CAL_ls2 = Integer.parseInt(s5)+Integer.parseInt(ls2);
							CAL_ls3 = Integer.parseInt(s6)+Integer.parseInt(ls3);
							*/

							if(pstmt_PDCEJ != null) pstmt_PDCEJ.close();	

							//update the CAL if any of the PD or CEJ are already recorded.
							pstmt_PDCEJ=con.prepareStatement("UPDATE OH_PERIODONTAL_CHART_DTL SET S1 = ?, S2 = ?, S3 = ?, S4 = ?, S5 = ?, S6 = ?, MODIFIED_BY_ID = ?, MODIFIED_DATE = SYSDATE, MODIFIED_AT_WS_NO = ?, MODIFIED_FACILITY_ID = ? WHERE OPERATING_FACILITY_ID = ? AND PATIENT_ID = ? AND CHART_NUM = ? AND CHART_LINE_NUM = ? AND CHART_CODE = ? AND TOOTH_NO = ? AND COMPONENT_CODE = 'CAL'");
							index = 1;
							pstmt_PDCEJ.setString(index++,CAL_bs1);						//11 
							pstmt_PDCEJ.setString(index++,CAL_bs2);						//12 
							pstmt_PDCEJ.setString(index++,CAL_bs3);						//13 
							pstmt_PDCEJ.setString(index++,CAL_ls1);						//14
							pstmt_PDCEJ.setString(index++,CAL_ls2);						//15
							pstmt_PDCEJ.setString(index++,CAL_ls3);	
							pstmt_PDCEJ.setString(index++,login_user);				//31
							pstmt_PDCEJ.setString(index++,client_ip_address); 		//32
							pstmt_PDCEJ.setString(index++,facility_id);				//33//16
							pstmt_PDCEJ.setString(index++,facility_id);				//1  
							pstmt_PDCEJ.setString(index++,patient_id);				//2  
							pstmt_PDCEJ.setString(index++,chart_num);	
							pstmt_PDCEJ.setString(index++,chart_line_num);		//3  
							pstmt_PDCEJ.setString(index++,perio_chart);			    //4   CHART_CODE
							pstmt_PDCEJ.setString(index++,perio_tooth);				//5   TOOTH_NO 
													
							flag_PDCEJ = pstmt_PDCEJ.executeUpdate();

							if(flag_PDCEJ != 0){
								con.commit();
							}else{
								con.rollback();
							}
							if(pstmt_PDCEJ != null) pstmt_PDCEJ.close();	//Common-ICN-0044
						}
					}

					if(data_exists_yn.equals("N")){
						if(DB_insert_yn.equals("Y")){
							/*
							CAL_bs1 = bs1;
							CAL_bs2 = bs2;
							CAL_bs3 = bs3;
							CAL_ls1 = ls1;
							CAL_ls2 = ls2;
							CAL_ls3 = ls3;
							*/

							//if(pstmt_PDCEJ != null) pstmt_PDCEJ.close();	
							
							// insert CAL if PD or CEJ is recorded
							pstmt_PDCEJ=con.prepareStatement("INSERT INTO OH_PERIODONTAL_CHART_DTL (OPERATING_FACILITY_ID, PATIENT_ID, CHART_NUM, CHART_CODE, TOOTH_NO, COMPONENT_CODE, ENCOUNTER_ID, PATIENT_CLASS, VALUE, S1, S2, S3, S4, S5, S6, CHART_LINE_NUM, EPISODE_TYPE, VISIT_ID, EPISODE_ID, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?)");
							index = 1;
							pstmt_PDCEJ.setString(index++,facility_id);				//1  
							pstmt_PDCEJ.setString(index++,patient_id);				//2  
							pstmt_PDCEJ.setString(index++,chart_num);					//3  
							pstmt_PDCEJ.setString(index++,perio_chart);			    //4   CHART_CODE
							pstmt_PDCEJ.setString(index++,perio_tooth);				//5   TOOTH_NO 
							pstmt_PDCEJ.setString(index++,"CAL");				//6   COMPONENT_CODE
							pstmt_PDCEJ.setString(index++,encounter_id);		        //7  
							pstmt_PDCEJ.setString(index++,patient_class);		        //8  
							pstmt_PDCEJ.setString(index++,non_surface_value);			//10 
							pstmt_PDCEJ.setString(index++,bs1);						//11 
							pstmt_PDCEJ.setString(index++,bs2);						//12 
							pstmt_PDCEJ.setString(index++,bs3);						//13 
							pstmt_PDCEJ.setString(index++,ls1);						//14
							pstmt_PDCEJ.setString(index++,ls2);						//15
							pstmt_PDCEJ.setString(index++,ls3);						//16
							pstmt_PDCEJ.setString(index++,chart_line_num);						//17
							pstmt_PDCEJ.setString(index++,episode_type);						//17
							pstmt_PDCEJ.setString(index++,visit_id);						//17
							pstmt_PDCEJ.setString(index++,episode_id);						//17
																					
							pstmt_PDCEJ.setString(index++,login_user);				//28
							pstmt_PDCEJ.setString(index++,client_ip_address);			//29
							pstmt_PDCEJ.setString(index++,facility_id);				//30
							pstmt_PDCEJ.setString(index++,login_user);				//31
							pstmt_PDCEJ.setString(index++,client_ip_address); 		//32
							pstmt_PDCEJ.setString(index++,facility_id);				//33
							flag_PDCEJ = pstmt_PDCEJ.executeUpdate();

							if(flag_PDCEJ != 0){
								con.commit();
							}else{
								con.rollback();
							}
							if(pstmt_PDCEJ != null) pstmt_PDCEJ.close();	//Common-ICN-0044
						}

					}

				}

				if(pstmt != null) pstmt.close();	
				if(rs != null) rs.close();
				sqlInsert="INSERT INTO OH_PERIODONTAL_CHART_DTL (OPERATING_FACILITY_ID, PATIENT_ID, CHART_NUM, CHART_CODE, TOOTH_NO, COMPONENT_CODE, ENCOUNTER_ID, PATIENT_CLASS, VALUE, S1, S2, S3, S4, S5, S6, CHART_LINE_NUM, EPISODE_TYPE, VISIT_ID, EPISODE_ID, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?)";
				pstmt=con.prepareStatement(sqlInsert);
				index = 1;
				pstmt.setString(index++,facility_id);				//1  
				pstmt.setString(index++,patient_id);				//2  
				pstmt.setString(index++,chart_num);					//3  
				pstmt.setString(index++,perio_chart);			    //4   CHART_CODE
				pstmt.setString(index++,perio_tooth);				//5   TOOTH_NO 
				pstmt.setString(index++,perio_comp);				//6   COMPONENT_CODE
				pstmt.setString(index++,encounter_id);		        //7  
				pstmt.setString(index++,patient_class);		        //8  
				pstmt.setString(index++,non_surface_value);			//10 
				pstmt.setString(index++,bs1);						//11 
				pstmt.setString(index++,bs2);						//12 
				pstmt.setString(index++,bs3);						//13 
				pstmt.setString(index++,ls1);						//14
				pstmt.setString(index++,ls2);						//15
				pstmt.setString(index++,ls3);						//16
				pstmt.setString(index++,chart_line_num);						//17
				pstmt.setString(index++,episode_type);						//17
				pstmt.setString(index++,visit_id);						//17
				pstmt.setString(index++,episode_id);						//17
																		
				pstmt.setString(index++,login_user);				//28
				pstmt.setString(index++,client_ip_address);			//29
				pstmt.setString(index++,facility_id);				//30
				pstmt.setString(index++,login_user);				//31
				pstmt.setString(index++,client_ip_address); 		//32
				pstmt.setString(index++,facility_id);				//33
				flag = pstmt.executeUpdate();
				flag_arr.add(""+flag);


				if(!flag_arr.contains("0")){
					commit_flag="Y";
				}else{
					commit_flag="N";
				}
				flag_arr.clear();	//Common-ICN-0044
				MessageManager mm=new MessageManager();
				if(commit_flag.equals("Y") && flag!=0){
					con.commit();
					final java.util.Hashtable mesg = mm.getMessage(locale, "RECORD_INSERTED", "SM") ;
					msg = ((String) mesg.get("message"));
					mesg.clear();	//Common-ICN-0044
				 }else{
					con.rollback();
					final java.util.Hashtable mesg = mm.getMessage(locale, "APP-OH00018", "OH") ;
					msg = ((String) mesg.get("message"));
					System.err.println("error from OHDentalChartServlet :=="+msg);
					mesg.clear();	//Common-ICN-0044
				 }

				 res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode( msg,"UTF-8" ));
	}catch(Exception e){
				try{
					System.err.println("Rollback performed, Err Msg in PerioChartServlet"+e.getMessage());
					con.rollback();
				}catch(Exception e_1){
					System.err.println("PerioChartServlet :Caught Exception during rollback"+e_1);
				}

			    System.err.println("Err Msg in PerioChartServlet"+e.getMessage());
				msg = e.toString();
				res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode( msg,"UTF-8" ));
	}finally{
		try{
				CommonData.clear();		//Common-ICN-0044
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(pstmt_PDCEJ!=null) pstmt_PDCEJ.close();
				if(con!=null) ConnectionManager.returnConnection(con,req);
		}catch(Exception e){}
	  }
    }
 }



