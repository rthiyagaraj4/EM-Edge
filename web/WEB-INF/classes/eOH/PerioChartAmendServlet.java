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

public class PerioChartAmendServlet extends javax.servlet.http.HttpServlet {
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
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
		HttpSession session=req.getSession(false);
		out=res.getWriter();
					
		masterXMLParse=new eOH.MasterXMLParse();
		
		java.util.Properties prop = null;
		String facility_id			= (String)session.getValue( "facility_id" ) ;
		prop				= (java.util.Properties)session.getValue( "jdbc" ) ;
		String client_ip_address	= prop.getProperty( "client_ip_address" );
		String login_user			= prop.getProperty( "login_user" );
		String locale				= prop.getProperty("LOCALE");
		String msg="";

		//String[] tooth_range_arr = null;	//Commented Against Common-ICN-0031
	
		Connection con = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt_PDCEJ = null;
		ResultSet rs			= null;
		
		int flag=0;
		int flag_PDCEJ=0;
		int index = 1;

		String DB_perio_comp = "";
		String data_exists_yn = "N";
		String CAL_exists_YN = "N";

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

		
		try{
			con = ConnectionManager.getConnection(req);
			String patient_id=checkForNull(req.getParameter("patient_id"));
			String encounter_id=checkForNull(req.getParameter("encounter_id"));
			String patient_class=checkForNull(req.getParameter("patient_class"));
			String episode_type=checkForNull(req.getParameter("episode_type"));
			String episode_id=checkForNull(req.getParameter("episode_id"));
			String visit_id=checkForNull(req.getParameter("visit_id"));

			String chart_num = checkForNull(req.getParameter("chart_num"));
			String chart_line_num = checkForNull(req.getParameter("chart_line_num"));
			String chart_code = checkForNull(req.getParameter("perio_chart"));
			String comp_code = checkForNull(req.getParameter("perio_comp"));
			String tooth_no = checkForNull(req.getParameter("perio_tooth"));
			String surfaces_appl = checkForNull(req.getParameter("surfaces_appl"));
				
			String bs1 = checkForNull(req.getParameter("bs1"));
			String bs2 = checkForNull(req.getParameter("bs2"));
			String bs3 = checkForNull(req.getParameter("bs3"));

			String ls1 = checkForNull(req.getParameter("ls1"));
			String ls2 = checkForNull(req.getParameter("ls2"));
			String ls3 = checkForNull(req.getParameter("ls3"));

			String non_surface_value = checkForNull(req.getParameter("non_surface_value"));
			String DB_insert_yn=checkForNull(req.getParameter("DB_insert_yn"));
			

			if(surfaces_appl.equals("Y")){
				if(comp_code.equals("PD") || comp_code.equals("CEJ")){
					if(DB_insert_yn.equals("Y")){

						if(comp_code.equals("PD")){
							DB_perio_comp = "CEJ";
						}
						else if(comp_code.equals("CEJ")){
							DB_perio_comp = "PD";
						}

						pstmt = con.prepareStatement("SELECT S1, S2, S3, S4, S5, S6 FROM OH_PERIODONTAL_CHART_DTL WHERE OPERATING_FACILITY_ID = ? AND PATIENT_ID = ? AND CHART_CODE = ? AND TOOTH_NO = ? AND CHART_NUM = ? AND CHART_LINE_NUM = ? AND COMPONENT_CODE = 'CAL' ");
					
						pstmt.setString(1,facility_id);
						pstmt.setString(2,patient_id);
						pstmt.setString(3,chart_code);
						pstmt.setString(4,tooth_no);
						pstmt.setString(5,chart_num);
						pstmt.setString(6,chart_line_num);
						rs=pstmt.executeQuery();
						while(rs.next()){
							CAL_exists_YN = "Y";
						}

						if(pstmt != null) pstmt.close();
						if(rs != null) rs.close();

						//update CAL if PD or CEJ is updated
						pstmt = con.prepareStatement("SELECT S1, S2, S3, S4, S5, S6 FROM OH_PERIODONTAL_CHART_DTL WHERE OPERATING_FACILITY_ID = ? AND PATIENT_ID = ? AND CHART_CODE = ? AND TOOTH_NO = ? AND CHART_NUM = ? AND CHART_LINE_NUM = ? AND COMPONENT_CODE = ? ");
					
						pstmt.setString(1,facility_id);
						pstmt.setString(2,patient_id);
						pstmt.setString(3,chart_code);
						pstmt.setString(4,tooth_no);
						pstmt.setString(5,chart_num);
						pstmt.setString(6,chart_line_num);
						pstmt.setString(7,DB_perio_comp);
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
							

							//if(pstmt != null) pstmt.close();

							if(CAL_exists_YN == "N"){
								// insert CAL if PD or CEJ is updated
								pstmt_PDCEJ=con.prepareStatement("INSERT INTO OH_PERIODONTAL_CHART_DTL (OPERATING_FACILITY_ID, PATIENT_ID, CHART_NUM, CHART_CODE, TOOTH_NO, COMPONENT_CODE, ENCOUNTER_ID, PATIENT_CLASS, VALUE, S1, S2, S3, S4, S5, S6, CHART_LINE_NUM, EPISODE_TYPE, VISIT_ID, EPISODE_ID, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?)");
								index = 1;
								pstmt_PDCEJ.setString(index++,facility_id);				//1  
								pstmt_PDCEJ.setString(index++,patient_id);				//2  
								pstmt_PDCEJ.setString(index++,chart_num);					//3  
								pstmt_PDCEJ.setString(index++,chart_code);			    //4   CHART_CODE
								pstmt_PDCEJ.setString(index++,tooth_no);				//5   TOOTH_NO 
								pstmt_PDCEJ.setString(index++,"CAL");				//6   COMPONENT_CODE
								pstmt_PDCEJ.setString(index++,encounter_id);		        //7  
								pstmt_PDCEJ.setString(index++,patient_class);		        //8  
								pstmt_PDCEJ.setString(index++,non_surface_value);			//10 
								pstmt_PDCEJ.setString(index++,CAL_bs1);						//11 
								pstmt_PDCEJ.setString(index++,CAL_bs2);						//12 
								pstmt_PDCEJ.setString(index++,CAL_bs3);						//13 
								pstmt_PDCEJ.setString(index++,CAL_ls1);						//14
								pstmt_PDCEJ.setString(index++,CAL_ls2);						//15
								pstmt_PDCEJ.setString(index++,CAL_ls3);						//16
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
							}
							else{
								pstmt_PDCEJ=con.prepareStatement("UPDATE OH_PERIODONTAL_CHART_DTL SET S1 = ?,S2 = ?,S3 = ?,S4 = ?,S5 = ?,S6 = ?, MODIFIED_BY_ID=?, MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=? WHERE OPERATING_FACILITY_ID=? AND PATIENT_ID = ? AND CHART_NUM=? AND CHART_LINE_NUM = ? AND CHART_CODE = ? AND COMPONENT_CODE ='CAL' AND TOOTH_NO = ?");
								pstmt_PDCEJ.setString(1,CAL_bs1);
								pstmt_PDCEJ.setString(2,CAL_bs2);
								pstmt_PDCEJ.setString(3,CAL_bs3);
								pstmt_PDCEJ.setString(4,CAL_ls1);
								pstmt_PDCEJ.setString(5,CAL_ls2);
								pstmt_PDCEJ.setString(6,CAL_ls3);
								pstmt_PDCEJ.setString(7,login_user);
								pstmt_PDCEJ.setString(8,client_ip_address);
								pstmt_PDCEJ.setString(9,facility_id);
								pstmt_PDCEJ.setString(10,facility_id);
								pstmt_PDCEJ.setString(11,patient_id);
								pstmt_PDCEJ.setString(12,chart_num);
								pstmt_PDCEJ.setString(13,chart_line_num);
								pstmt_PDCEJ.setString(14,chart_code);
								pstmt_PDCEJ.setString(15,tooth_no);
								flag_PDCEJ = pstmt_PDCEJ.executeUpdate();
								if(flag_PDCEJ != 0){
									con.commit();
								}else{
									con.rollback();
								}
							}
							if(pstmt_PDCEJ != null) pstmt_PDCEJ.close();	//Added Against Common-ICN-0031
						}
						if(data_exists_yn.equals("N")){
							if(DB_insert_yn.equals("Y")){
								if(CAL_exists_YN == "N"){
									// insert CAL if PD or CEJ is updated
									pstmt_PDCEJ=con.prepareStatement("INSERT INTO OH_PERIODONTAL_CHART_DTL (OPERATING_FACILITY_ID, PATIENT_ID, CHART_NUM, CHART_CODE, TOOTH_NO, COMPONENT_CODE, ENCOUNTER_ID, PATIENT_CLASS, VALUE, S1, S2, S3, S4, S5, S6, CHART_LINE_NUM, EPISODE_TYPE, VISIT_ID, EPISODE_ID, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?)");
									index = 1;
									pstmt_PDCEJ.setString(index++,facility_id);				//1  
									pstmt_PDCEJ.setString(index++,patient_id);				//2  
									pstmt_PDCEJ.setString(index++,chart_num);					//3  
									pstmt_PDCEJ.setString(index++,chart_code);			    //4   CHART_CODE
									pstmt_PDCEJ.setString(index++,tooth_no);				//5   TOOTH_NO 
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

								}
								else{
									pstmt_PDCEJ=con.prepareStatement("UPDATE OH_PERIODONTAL_CHART_DTL SET S1 = ?,S2 = ?,S3 = ?,S4 = ?,S5 = ?,S6 = ?, MODIFIED_BY_ID=?, MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=? WHERE OPERATING_FACILITY_ID=? AND PATIENT_ID = ? AND CHART_NUM=? AND CHART_LINE_NUM = ? AND CHART_CODE = ? AND COMPONENT_CODE ='CAL' AND TOOTH_NO = ?");

									pstmt_PDCEJ.setString(1,bs1);
									pstmt_PDCEJ.setString(2,bs2);
									pstmt_PDCEJ.setString(3,bs3);
									pstmt_PDCEJ.setString(4,ls1);
									pstmt_PDCEJ.setString(5,ls2);
									pstmt_PDCEJ.setString(6,ls3);
									pstmt_PDCEJ.setString(7,login_user);
									pstmt_PDCEJ.setString(8,client_ip_address);
									pstmt_PDCEJ.setString(9,facility_id);
									pstmt_PDCEJ.setString(10,facility_id);
									pstmt_PDCEJ.setString(11,patient_id);
									pstmt_PDCEJ.setString(12,chart_num);
									pstmt_PDCEJ.setString(13,chart_line_num);
									pstmt_PDCEJ.setString(14,chart_code);
									pstmt_PDCEJ.setString(15,tooth_no);
									flag_PDCEJ = pstmt_PDCEJ.executeUpdate();
									if(flag_PDCEJ != 0){
										con.commit();
									}else{
										con.rollback();
									}
								}
							}
						}
					}
				}
				if(pstmt != null) pstmt.close();	//Added Against Common-ICN-0031
				pstmt=con.prepareStatement("UPDATE OH_PERIODONTAL_CHART_DTL SET S1 = ?,S2 = ?,S3 = ?,S4 = ?,S5 = ?,S6 = ?, MODIFIED_BY_ID=?, MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=? WHERE OPERATING_FACILITY_ID=? AND PATIENT_ID = ? AND CHART_NUM=? AND CHART_CODE = ? AND COMPONENT_CODE = ? AND TOOTH_NO = ?");

				pstmt.setString(1,bs1);
				pstmt.setString(2,bs2);
				pstmt.setString(3,bs3);
				pstmt.setString(4,ls1);
				pstmt.setString(5,ls2);
				pstmt.setString(6,ls3);
				pstmt.setString(7,login_user);
				pstmt.setString(8,client_ip_address);
				pstmt.setString(9,facility_id);
				pstmt.setString(10,facility_id);
				pstmt.setString(11,patient_id);
				pstmt.setString(12,chart_num);
				pstmt.setString(13,chart_code);
				pstmt.setString(14,comp_code);
				pstmt.setString(15,tooth_no);
				flag = pstmt.executeUpdate();
			}
			else{
				if(pstmt != null) pstmt.close();	//Added Against Common-ICN-0031
				pstmt=con.prepareStatement("UPDATE OH_PERIODONTAL_CHART_DTL SET VALUE = ?, MODIFIED_BY_ID=?, MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=? WHERE OPERATING_FACILITY_ID=? AND PATIENT_ID = ? AND CHART_NUM=? AND CHART_CODE = ? AND COMPONENT_CODE = ? AND TOOTH_NO = ?");

				pstmt.setString(1,non_surface_value);
				pstmt.setString(2,login_user);
				pstmt.setString(3,client_ip_address);
				pstmt.setString(4,facility_id);
				pstmt.setString(5,facility_id);
				pstmt.setString(6,patient_id);
				pstmt.setString(7,chart_num);
				pstmt.setString(8,chart_code);
				pstmt.setString(9,comp_code);
				pstmt.setString(10,tooth_no);
				flag = pstmt.executeUpdate();
			}

			MessageManager mm=new MessageManager();
			if(flag!=0){
				con.commit();
				final java.util.Hashtable mesg = mm.getMessage(locale, "RECORD_INSERTED", "SM") ;
				msg = ((String) mesg.get("message"));
				mesg.clear();	//Common-ICN-0044
			}else{
				con.rollback();
				final java.util.Hashtable mesg = mm.getMessage(locale, "APP-OH00018", "OH") ;
				msg = ((String) mesg.get("message"));
				mesg.clear();	//Common-ICN-0044
			}
			res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode( msg,"UTF-8" ));
	}catch(Exception e){
				try{
					System.err.println("Rollback performed, Err Msg in PerioCharttAmendServlet"+e.getMessage());
					con.rollback();
				}catch(Exception e_1){
					System.err.println("PerioCharttAmendServlet :Caught Exception during rollback"+e_1);
				}
			    System.err.println("Err Msg in PerioCharttAmendServlet"+e.getMessage());
				msg = e.toString();
				res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode( msg,"UTF-8" ));
	}finally{
		try{
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(pstmt_PDCEJ!=null) pstmt_PDCEJ.close();
				
				if(con!=null) ConnectionManager.returnConnection(con,req);
		}catch(Exception e){}
	  }
    }
 }



