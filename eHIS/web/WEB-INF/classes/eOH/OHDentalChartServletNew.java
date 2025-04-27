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



public class OHDentalChartServletNew extends javax.servlet.http.HttpServlet {
	public void init(ServletConfig config) throws ServletException	{
		super.init(config);
	}

	private String checkForNull(String str){
		return (str!=null && str.intern()!="null")?str:"";
	}

	private String checkForNull(String inputString,String defaultValue){
        return ( inputString == null || inputString.equals("") )    ?   defaultValue    :   inputString;
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
		PreparedStatement pstmt1 = null;
		ResultSet rst			= null;
		String sqlInsert = "";
		String sqlUpdate ="";
		//String sql ="";	//Commented Against Common-ICN-0031
		int flag=0;
		int flag1=0;
		String msg="";
		int index = 1;
		
		String commit_flag = "N";
		String cusp_tip_code_ref = "";
		try{
				con = ConnectionManager.getConnection(req);

				String tooth_range_nos = "";
				String dummy_tooth_no = "";
				String tooth_no = "";
				String arch = "";
				String quadrant = "";
				String treatment_condition = "";
				String treatment_int_ext = "";
				String deciduous_yn = "";
				String supernuerary_yn = "";
				String hide_image_yn = "";
				//String maxilla_site_type = "";
				String tooth_range_nos_arr[] = null;
				String cusp_arr[] = null;//parul 20/08/2009 for 0483
				String cusp_no = "";///parul 20/08/2009 for 0483
			    String multiple_surfaces_applicable ="N";//parul 20/08/2009 for 0483
				
			    /* String supernumerary_yn ="";//Added by Sridevi Joshi on 12/4/2009 for SUPRTH chnages
				String DB_super_key_val = "";//Added by Sridevi Joshi on 1/28/2010 for SUPRTH chnages(IN010894)
				int DB_super_key_val_cnt = 0;//Added by Sridevi Joshi on 1/28/2010 for SUPRTH chnages(IN010894)
				int record_exfolth_count=0; */	//Commented Against Common-ICN-0031				
				
				String super_tooth_ref = "";//Added by Sridevi Joshi on 12/4/2009 for SUPRTH chnages
				String super_tooth_count = "";//Added by Sridevi Joshi on 12/4/2009 for SUPRTH chnages
				String super_tooth_no = "";//Added by Sridevi Joshi on 12/4/2009 for SUPRTH chnages
				String retained_tooth_no = "";//Added by Sridevi Joshi on 12/4/2009 for SUPRTH chnages
				String mapped_tooth_no = "";//Added by Sridevi Joshi on 12/21/2009 for SUPRTH chnages(IN010894)
				String ns_tooth_no = "";//Added by Sridevi Joshi on 12/21/2009 for SUPRTH chnages(IN010894)
				String DB_condition_type = "";//Added by Sridevi Joshi on 12/21/2009 for SUPRTH chnages(IN010894)
				String super_key_num = "";//Added by Sridevi Joshi on 1/21/2010 for SUPRTH chnages(IN010894)
				String sub_parts = "";//Added by Sridevi Joshi on 1/21/2010 for SUPRTH chnages(IN010894)
				int super_key_val = 0;//Added by Sridevi Joshi on 1/21/2009 for SUPRTH chnages(IN010894)
				int suprth_count = 0;//Added by Sridevi Joshi on 1/21/2009 for SUPRTH chnages(IN010894)
				
				
				//String record_exfolth_count = "";//Added by Sridevi Joshi on 12/4/2009 for SUPRTH chnages

		
				String patient_id=checkForNull(req.getParameter("patient_id"));
				String practitioner_id=checkForNull(req.getParameter("ca_practitioner_id"));
				String episode_id=checkForNull(req.getParameter("episode_id"));
				String visit_id=checkForNull(req.getParameter("visit_id"));
				String episode_type=checkForNull(req.getParameter("episode_type"));
				String source_code=checkForNull(req.getParameter("location_code"));
				String source_type=checkForNull(req.getParameter("location_type"));
				String encounter_id=checkForNull(req.getParameter("encounter_id"));
				String patient_class = checkForNull(req.getParameter("patient_class"));
				String chart_num = checkForNull(req.getParameter("chart_num"));
				String chart_line_num="1";
				String tab_name = checkForNull(req.getParameter("tab_name"));
				String show_new_active_yn = checkForNull(req.getParameter( "show_new_active_yn" )) ;
				String header_tab = checkForNull(req.getParameter( "header_tab" )) ;
				String oh_chart_level = checkForNull(req.getParameter( "oh_chart_level" )) ;
				String intraoral_extraoral = "";
				String organ_code = "";
				String sub_organ_code = "";
				String surface_code="";
				
				//added by parul on 12/01/2010 for CRF-422
				String surface_arr[] = null;
				String surface_no = "";

				String tooth_string = "";

				if(oh_chart_level.equals("")){
					oh_chart_level = "F";
				}
				
				if(header_tab.equals("C")){
					treatment_condition = "C";
				}
				else{
					treatment_condition = "T";
				}

				if(tab_name.equals("ET")){
					treatment_int_ext = "E";
					treatment_condition = "T";
				}
				else{
					treatment_int_ext = "I";
				}

				String trmt_category_type=checkForNull(req.getParameter("category"));
				String trmt_category_code = checkForNull(req.getParameter("cat_code"));
				String trmt_code = checkForNull(req.getParameter("treatment"));
				String condition_type = checkForNull(req.getParameter("condition_type"));
				String condition_code = checkForNull(req.getParameter("dental_condition"));
				String RD_Normal_yn = checkForNull(req.getParameter("RD_Normal_yn"));
				//String selected_first_thno = checkForNull(req.getParameter("selected_first_thno")); //Commented Against Common-ICN-0031
				String site_type = checkForNull(req.getParameter("site"));
				String mixed_dentition_YN = checkForNull(req.getParameter("mixed_dentition_YN"));
				String permanent_deciduous_flag = checkForNull(req.getParameter("permanent_deciduous_flag"));
				String tooth_numbering_system = checkForNull(req.getParameter("tooth_numbering_system"));
				String treatment_condition_date = checkForNull(req.getParameter("oh_performed_date"));

				treatment_condition_date = com.ehis.util.DateUtils.convertDate(treatment_condition_date,"DMY",locale,"en");

				//String surface_code = checkForNull(req.getParameter("oh_surface"));
				String cusp_tip = checkForNull(req.getParameter("oh_cusp_tip"));
				String location = checkForNull(req.getParameter("oh_location"));
				String order_id = checkForNull(req.getParameter("order_id"));
				String status = checkForNull(req.getParameter("oh_status"));
				String outcome = checkForNull(req.getParameter("oh_outcome"));
				String chart_hdr_insert_yn = checkForNull(req.getParameter("chart_hdr_insert_yn"));
				String clinical_group_hid = checkForNull(req.getParameter("clinical_group_hid"));
				String clinical_group_code = checkForNull(req.getParameter("clinical_group_code"));
				String remarks = checkForNull(req.getParameter("remarks"));
				//Added by Sharon Crasta on 10/6/2009 for (IN012603)PMG20089-CRF-0700
				//String dentist_comments = checkForNull(req.getParameter( "dentist_comments" )) ;	//Commented Against Common-ICN-0031
				String ref_tooth_no = checkForNull(req.getParameter( "ref_tooth_no" )) ;
				String failure_remarks = checkForNull(req.getParameter( "oh_failure" )) ;
				//
				
				//String remarks = java.net.URLDecoder.decode(checkForNull(req.getParameter("remarks")),"UTF-8");				
				//if(!RD_Normal_yn.equals("D") && condition_type.equals("DECITH")){

				if(condition_type.equals("DECITH")){
					deciduous_yn = "D";
				}
				else if(RD_Normal_yn.equals("D") && condition_type.equals("SUPRTH")){ //if we record DESTH--->SUPRTH
					deciduous_yn = "D";
					supernuerary_yn = "Y";
				}
				else if(RD_Normal_yn.equals("D")){
					deciduous_yn = "D";
				}
				else if(RD_Normal_yn.equals("RD")){
					deciduous_yn = "R";
				}
				else if(!RD_Normal_yn.equals("RD") && condition_type.equals("RTDESTH")){
					deciduous_yn = "R";
				}
				else if(RD_Normal_yn.equals("MR") && condition_type.equals("SUPRTH")){
					deciduous_yn = "M";
					supernuerary_yn = "Y";
				}
				else if(RD_Normal_yn.equals("MR")){
					deciduous_yn = "M";
				}
				else if(condition_type.equals("EXFOLTH") && RD_Normal_yn.equals("NR")){
					deciduous_yn = "N";
					supernuerary_yn = "";
				}
				
				/*else if ((ref_tooth_no.equals("") || ref_tooth_no.equals(null)|| ref_tooth_no.equals("null")) && mixed_dentition_YN.equals("Y") && permanent_deciduous_flag.equals("D")){//added by parul for super changes flag "ref_tooth_no" is to Differentiate  data entry and dental chart
					deciduous_yn = "M";
				}*/
				else{
					deciduous_yn = "";
					supernuerary_yn = "";
				}
				

				 if(site_type.equals("MAXFS")){
					 organ_code=checkForNull(req.getParameter("oh_surface"));
					 sub_organ_code=checkForNull(req.getParameter("oh_sub_parts"));
				 }else{
		             surface_code = checkForNull(req.getParameter("oh_surface"));
					 if(surface_code.equals("")){
						surface_code = checkForNull(req.getParameter("oh_surface_hid"));//Added this by Sridevi Joshi on 8/20/2010 for IN023363...surface is disabled if it is for AllSurfaces in case of Crown. as disabled parameters wont be parsed by form take some hidden variable and assign the value
					 }
				 }

				 System.err.println("surface_code--------"+surface_code);
				//To get AREA depending on the SITE_TYPE
				if(site_type.equals("ARCH")){
					arch =checkForNull(req.getParameter("area"));
				}
				else if(site_type.equals("QUAD")){
					quadrant = checkForNull(req.getParameter("area"));
				}
				else if(site_type.equals("TOOTH")){
					dummy_tooth_no = checkForNull(req.getParameter("area"));
					if(dummy_tooth_no.indexOf(",") != -1){// we are checking index of becoz in condition tooth range we r able to record from menu only on that case site_type will be "Tooth"
						tooth_range_nos = checkForNull(req.getParameter("thrng_nos_ref"));
						tooth_range_nos_arr = tooth_range_nos.split(",");
					}
					else{
						tooth_no = checkForNull(req.getParameter("area"));
						
					}
				}
				else if(site_type.equals("THRNG")){
					tooth_range_nos = checkForNull(req.getParameter("thrng_nos_ref"));
					tooth_range_nos_arr = tooth_range_nos.split(",");
				}else if(site_type.equals("MAXFS")){

					 intraoral_extraoral = checkForNull(req.getParameter("area"));//added by parul for CRF 701 on 23/09/2009
					
					if(sub_organ_code.equals("THAB") || sub_organ_code.equals("THGM")  || sub_organ_code.equals("THAG") ||sub_organ_code.equals("THGAM") ||sub_organ_code.equals("THMF")){//THAB,THGM,THAG,THGAM,THMF
							sub_parts = checkForNull(req.getParameter("oh_selected_sub_parts"));//added by Sridevi Joshi on 2/8/2010 for  IN010894
							if(sub_parts.indexOf("s") != -1){
								super_tooth_ref = sub_parts.substring(sub_parts.indexOf("s"));//added by Sridevi Joshi on 2/8/2010 for  IN010894
							}
							tooth_no = checkForNull(req.getParameter("oh_selected_sub_parts"));//added by parul for CRF 701 on 23/09/2009
							if((permanent_deciduous_flag.equals("P")|| permanent_deciduous_flag.equals("D")) && mixed_dentition_YN.equals("N")){
								if(tooth_no.indexOf("s") != -1){
									//tooth_no=tooth_no.replace("s","");
									tooth_no=tooth_no.substring(0,tooth_no.indexOf("s"));
									supernuerary_yn="Y";
								}else if (tooth_no.indexOf("r") != -1){
									tooth_no=tooth_no.replace("r","");
									deciduous_yn = "R";
								}
						}else if(permanent_deciduous_flag.equals("P") && mixed_dentition_YN.equals("Y")){
							if(tooth_no.indexOf("s") != -1){
									//tooth_no=tooth_no.replace("s","");
									tooth_no=tooth_no.substring(0,tooth_no.indexOf("s"));
									supernuerary_yn="Y";
								}else if (tooth_no.indexOf("r") != -1){
									tooth_no=tooth_no.replace("r","");
									deciduous_yn = "R";
								}else if (tooth_no.indexOf("d") != -1)
								{
									tooth_no=tooth_no.replace("d","");
									deciduous_yn = "D";
								}
						}else if (permanent_deciduous_flag.equals("D") && mixed_dentition_YN.equals("Y")){
							if(tooth_no.indexOf("s") != -1){
									//tooth_no=tooth_no.replace("s","");
									tooth_no=tooth_no.substring(0,tooth_no.indexOf("s"));
									supernuerary_yn="Y";
								}else if (tooth_no.indexOf("r") !=1){
									tooth_no=tooth_no.replace("r","");
									deciduous_yn = "R";
								}else if (tooth_no.indexOf("s") == -1){
										deciduous_yn = "";
										supernuerary_yn="";
								}
						}
					}else if (sub_organ_code.equals("TNGAB") || sub_organ_code.equals("TNGGM") || sub_organ_code.equals("TNGAG") || sub_organ_code.equals("TNGGAM") || sub_organ_code.equals("TNGMF")){//TNGAB,TNGGM,TNGAG,TNGGAM,TNGMF
							tooth_range_nos = checkForNull(req.getParameter("thrng_nos_ref"));
							tooth_range_nos_arr = tooth_range_nos.split(",");
							for(int i=0;i<tooth_range_nos_arr.length;i++){
								tooth_string=tooth_range_nos_arr[i];
								if(tooth_string.indexOf("d") != -1){
									tooth_string=tooth_string.replace("d","");
									deciduous_yn="D";
									tooth_range_nos_arr[i] = tooth_string;
								}
							}

					 }
				}
				else{
					tooth_no = checkForNull(req.getParameter("area"));
				}

				System.err.println("322 OHDentalChartServletNew surface_code:==="+surface_code);
				System.err.println("322 OHDentalChartServletNew surface_ref:==="+checkForNull(req.getParameter("surface_ref")));
                 //added by parul on 12/01/2010 for CRF-442
				if (!surface_code.equals(null)){  
					surface_no = checkForNull(req.getParameter("surface_ref"));
					surface_arr=surface_no.split(",");
				 }

				 System.err.println("322 OHDentalChartServletNew surface_no:==="+surface_no);
				  if (surface_arr.length>1){
					 multiple_surfaces_applicable="Y";
				 }

				 System.err.println("322 OHDentalChartServletNew multiple_surfaces_applicable:==="+multiple_surfaces_applicable);

				//  multiple cusp tip on 20/08/2009
				if (!cusp_tip.equals(null)){  //parul 130908
					cusp_no = checkForNull(req.getParameter("cusptip_ref"));
					cusp_arr=cusp_no.split(",");					
				 }
				 if (cusp_arr.length>1){
					 multiple_surfaces_applicable="Y";
				 }

				/*
				//To get the EPISODE_ID and VISIT_ID
				if(pstmt != null) pstmt.close();
				if(rst != null) rst.close();
				pstmt=con.prepareStatement("SELECT EPISODE_ID, OP_EPISODE_VISIT_NUM FROM PR_ENCOUNTER WHERE ENCOUNTER_ID = ?");
				pstmt.setString(1,encounter_id);
				rst = pstmt.executeQuery();
				while(rst.next()){
					episode_id = rst.getString("EPISODE_ID");
					visit_id = rst.getString("OP_EPISODE_VISIT_NUM");
				}
				*/

				/* Block Added by Sridevi Joshi on 12/4/2009 for SUPRTH chnages*/
					//if(!site_type.equals("MAXFS")){
					if(super_tooth_ref == ""){
						super_tooth_ref = checkForNull(req.getParameter("super_tooth_ref"));//this is to check which super tooth is selected(1st or 2nd) 
					}
					if(!super_tooth_ref.equals("") && !super_tooth_ref.equals("undefined") && !super_tooth_ref.equals("RD")){
						super_tooth_count = super_tooth_ref.substring(1);
					}
					/*if(super_tooth_ref.equals("s1")){
						super_tooth_count = "1";
					}else if(super_tooth_ref.equals("s2")){
						super_tooth_count = "2";
					}*/

					if(!super_tooth_count.equals("")){
						supernuerary_yn = "Y"; 
						super_tooth_no = tooth_no+super_tooth_count;//This is to get the value for new column super_tooth_no(Ex:131 for tooth 13 and super tooth 1)
					}

					
					if(oh_chart_level.equals("E")){
						pstmt=con.prepareStatement("SELECT COUNT(*) RESULT_COUNT FROM OH_RESTORATIVE_CHART_DTL A WHERE PATIENT_ID = ? AND CHART_NUM=? AND TOOTH_NO = ? AND CONDITION_TYPE = 'SUPRTH'");
						pstmt.setString(1,patient_id);
						pstmt.setString(2,chart_num);
						pstmt.setString(3,tooth_no);
						rst = pstmt.executeQuery();
					}
					else{
						pstmt=con.prepareStatement("SELECT COUNT(*) RESULT_COUNT FROM OH_RESTORATIVE_CHART_DTL A WHERE OPERATING_FACILITY_ID=? AND PATIENT_ID = ? AND CHART_NUM=? AND TOOTH_NO = ? AND CONDITION_TYPE = 'SUPRTH'");
						pstmt.setString(1,facility_id);
						pstmt.setString(2,patient_id);
						pstmt.setString(3,chart_num);
						pstmt.setString(4,tooth_no);
						rst = pstmt.executeQuery();
					}

					while(rst!= null && rst.next()){
						suprth_count = Integer.parseInt(checkForNull(rst.getString("RESULT_COUNT")));
					}

					if(suprth_count == 0 && condition_type.equals("SUPRTH")){
						super_key_val = 1;
					}
					else if(suprth_count >= 1 && condition_type.equals("SUPRTH")){
						super_key_val = ++suprth_count;
					}

					if(super_key_val != 0){
						super_key_num = "s"+super_key_val;
					}

					if(!super_tooth_no.equals("")){
						super_key_num = super_tooth_ref;
					}

					if(pstmt != null) pstmt.close();
					if(rst != null) rst.close();

					if(permanent_deciduous_flag.equals("D") && mixed_dentition_YN.equals("Y")){
						if (ref_tooth_no.equals("") || ref_tooth_no.equals(null) || ref_tooth_no.equals("null")){//added by parul for super changes flag "ref_tooth_no" is to Differentiate  data entry and dental chart
						   deciduous_yn = "M";
						   if(condition_type.equals("SUPRTH")){
							   supernuerary_yn = "Y";
						   }
						}
					}

					//added by parul for super changes on 07/01/2010
					/*if(permanent_deciduous_flag.equals("D") && mixed_dentition_YN.equals("Y")){
						//if(record_exfolth_count.equals("2")){
						if(record_exfolth_count == DB_super_key_val_cnt){
							 //if(super_tooth_ref.equals("s1") || super_tooth_ref.equals("s2")){
							 if(!super_tooth_ref.equals("") && !super_tooth_ref.equals("undefined") && !super_tooth_ref.equals("RD")){
							   deciduous_yn = "M";
								supernuerary_yn = "Y";
							   }else if (ref_tooth_no.equals("") && ref_tooth_no.equals(null) && ref_tooth_no.equals("null")){//added by parul for super changes flag "ref_tooth_no" is to Differentiate  data entry and dental chart
								   deciduous_yn = "M";
							   }else{
									if(record_exfolth_count.equals("1")){
										deciduous_yn = "";
										supernuerary_yn = "";
									}else{
										deciduous_yn = "M";
										supernuerary_yn = "";
									}							
							   }
						}
						//else if(record_exfolth_count.equals("1")){//exfoliate-->erupted on that case deciduous_yn should be null becoz it is permanet tooth
						else if(!RD_Normal_yn.equals("D") && !RD_Normal_yn.equals("MR") && !RD_Normal_yn.equals("M") && !RD_Normal_yn.equals("MRP") && !RD_Normal_yn.equals("RD")){
						   //if(!super_tooth_ref.equals("s1") && !super_tooth_ref.equals("s2") && !super_tooth_ref.equals("RD")){
						   if((super_tooth_ref.equals("") || super_tooth_ref.equals("undefined")) && !super_tooth_ref.equals("RD")){
								deciduous_yn = "";
								supernuerary_yn = "";
						   }
						}else{
						  // if(super_tooth_ref.equals("s1") || super_tooth_ref.equals("s2")){
						   if(!super_tooth_ref.equals("") && !super_tooth_ref.equals("undefined") && !super_tooth_ref.equals("RD")){
								deciduous_yn = "M";
								supernuerary_yn = "Y";
						   }
						   else if(RD_Normal_yn.equals("RD")){
								deciduous_yn = "R";
						   }
						   else if(!RD_Normal_yn.equals("RD") && condition_type.equals("RTDESTH")){
								deciduous_yn = "R";
						   }
						   else if (ref_tooth_no.equals("") && ref_tooth_no.equals(null) && ref_tooth_no.equals("null")) {
								   deciduous_yn = "M";
						   }
						   
						  
						}
					}*/
					
					/* Ends Here Added by Sridevi Joshi on 12/4/2009 for SUPRTH chnages*/

					/* Block Added by Sridevi Joshi on 12/4/2009 for RTDESTH chnages*/
				
					if(pstmt != null) pstmt.close();
					if(rst != null) rst.close();
					
					pstmt=con.prepareStatement("SELECT MAPPED_TOOTH_NO FROM OH_TOOTH_LANG_VW WHERE TOOTH_NO = ?");
					pstmt.setString(1,tooth_no);
					rst = pstmt.executeQuery();
				
					while(rst!= null && rst.next()){
						mapped_tooth_no = checkForNull(rst.getString("MAPPED_TOOTH_NO"));
					}

					if(pstmt != null) pstmt.close();
					if(rst != null) rst.close();
					
					pstmt=con.prepareStatement("SELECT NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM  WHERE NUMBERING_SYSTEM = ? AND TOOTH_NO = ?");
					pstmt.setString(1,tooth_numbering_system);
					pstmt.setString(2,mapped_tooth_no);
					rst = pstmt.executeQuery();
				
					while(rst!= null && rst.next()){
						ns_tooth_no = checkForNull(rst.getString("NS_TOOTH_NO"));
					}

					if(super_tooth_ref.equals("RD") && !(mixed_dentition_YN.equals("Y") && permanent_deciduous_flag.equals("D"))){
						retained_tooth_no = mapped_tooth_no;
					}

					pstmt=con.prepareStatement("SELECT CONDITION_TYPE FROM OH_RESTORATIVE_CHART_DTL WHERE OPERATING_FACILITY_ID =? AND PATIENT_ID = ? AND CHART_NUM = ? AND TOOTH_NO = ? AND CONDITION_TYPE ='RTDESTH' AND NVL(COND_CLOSED_YN,'N') = 'N' AND NVL(STATUS,'X') != 'E'");
					pstmt.setString(1,facility_id);
					pstmt.setString(2,patient_id);
					pstmt.setString(3,chart_num);
					pstmt.setString(4,tooth_no);
					rst = pstmt.executeQuery();
				
					while(rst!= null && rst.next()){
						DB_condition_type = checkForNull(rst.getString("CONDITION_TYPE"));
					}
					
					//if(mixed_dentition_YN.equals("Y") && permanent_deciduous_flag.equals("D") && !super_tooth_ref.equals("RD") && !super_tooth_ref.equals("s1") && !super_tooth_ref.equals("s2") && RD_Normal_yn.equals("NR")){
					//if(mixed_dentition_YN.equals("Y") && permanent_deciduous_flag.equals("D") && !super_tooth_ref.equals("RD") && !super_tooth_ref.equals("s1") && !super_tooth_ref.equals("s2") && DB_condition_type.equals("RTDESTH")){
					if(mixed_dentition_YN.equals("Y") && permanent_deciduous_flag.equals("D") && !super_tooth_ref.equals("RD") && (super_tooth_ref.equals("") || super_tooth_ref.equals("undefined")) && DB_condition_type.equals("RTDESTH")){
						//retained_tooth_no = ns_tooth_no;
						retained_tooth_no = mapped_tooth_no;//commented above and Added by Sridevi Joshi on 4/8/2010 for IN020464..retained_tooth_no was going as dissplay tooth no
					}
																						    
				
				/* Ends Here Added by Sridevi Joshi on 12/4/2009 for RTDESTH chnages*/
				/*if(site_type.equals("MAXFS") && header_tab.equals("C")){
					maxilla_site_type = "TOOTH";
				}*/
				
				if(pstmt != null) pstmt.close();
				if(rst != null) rst.close();
				if(oh_chart_level.equals("E")){
					pstmt=con.prepareStatement("SELECT MIXED_DENT_DECIDUOUS_YN FROM  OH_RESTORATIVE_CHART_DTL WHERE PATIENT_ID = ?  AND NVL(STATUS,'X')!='E' AND CHART_NUM = ? AND TOOTH_NO = ?");
					pstmt.setString(1,patient_id);
					pstmt.setString(2,chart_num);
					pstmt.setString(3,tooth_no);
					rst = pstmt.executeQuery();
				}
				else{
					pstmt=con.prepareStatement("SELECT MIXED_DENT_DECIDUOUS_YN FROM  OH_RESTORATIVE_CHART_DTL WHERE PATIENT_ID = ?  AND OPERATING_FACILITY_ID =? AND NVL(STATUS,'X')!='E' AND CHART_NUM = ? AND TOOTH_NO = ?");
					pstmt.setString(1,patient_id);
					pstmt.setString(2,facility_id);
					pstmt.setString(3,chart_num);
					pstmt.setString(4,tooth_no);
					rst = pstmt.executeQuery();
				}
				
				
				//while(rst!= null && rst.next() && (RD_Normal_yn.equals("RD") || deciduous_yn.equals("D"))){ //by Sridevi joshi on 23/12/2008
				while(rst!= null && rst.next() && (RD_Normal_yn.equals("RD") || RD_Normal_yn.equals("D"))){
					deciduous_yn = checkForNull(rst.getString("MIXED_DENT_DECIDUOUS_YN"));
					if(deciduous_yn.equals("R") || deciduous_yn.equals("D")){
						break;
					}
				}
				
				//if((show_new_active_yn.equals("Y") || chart_num.equals("1")) && chart_hdr_insert_yn.equals("Y")){
				if((show_new_active_yn.equals("Y") || chart_num.equals("1")) && chart_hdr_insert_yn.equals("Y")){
					// for a New Chart.
					/*
					Case 1. New chart getting inserted for the 1st time
					Case 2. New chart getting inserted for a Mixed-Dentition Case. Update the old with chart_status as 'C' and insert a new chart.
					*/
					if(pstmt != null) pstmt.close();
					if(rst != null) rst.close();
					
					if(show_new_active_yn.equals("Y") && oh_chart_level.equals("F")){ // Case 2
						sqlUpdate = "UPDATE OH_RESTORATIVE_CHART_HDR SET CHART_STATUS = 'C', CHART_CLOSED_BY=?,CHART_CLOSE_DATE=SYSDATE WHERE OPERATING_FACILITY_ID=? AND PATIENT_ID = ? AND CHART_STATUS='A'";
						pstmt=con.prepareStatement(sqlUpdate);
						pstmt.setString(1,login_user);
						pstmt.setString(2,facility_id);
						pstmt.setString(3,patient_id);
						flag = pstmt.executeUpdate();

						if (flag!=0)//added by parul becoz flag was not commited.
						{
							con.commit();

						}else{
							con.rollback();

						}
					}
					String chart_status = "A";
					String chart_type = checkForNull(req.getParameter("chart_type"));

					if(pstmt != null) pstmt.close();//added by parul 
					if(rst != null) rst.close();//added by parul 
					
					sqlInsert="INSERT INTO OH_RESTORATIVE_CHART_HDR (OPERATING_FACILITY_ID,PATIENT_ID,CHART_NUM,CHART_DATE,CHART_TYPE,CLINICAL_GROUP_CODE,CHART_STATUS,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID) VALUES (?,?,?,SYSDATE,?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?)";
					pstmt=con.prepareStatement(sqlInsert);
					pstmt.setString(1,facility_id);
					pstmt.setString(2,patient_id);
					pstmt.setString(3,chart_num);
					pstmt.setString(4,chart_type);
					pstmt.setString(5,clinical_group_code);
					pstmt.setString(6,chart_status);

					pstmt.setString(7,login_user);
					pstmt.setString(8,client_ip_address);
					pstmt.setString(9,facility_id);
					pstmt.setString(10,login_user);
					pstmt.setString(11,client_ip_address); 
					pstmt.setString(12,facility_id);
					flag1 = pstmt.executeUpdate();		

					if (flag1!=0)//added by parul becoz flag1 was not commited.
					{
						con.commit();
					}else{
						con.rollback();
					}
				}
				if((show_new_active_yn.equals("Y") || (!chart_num.equals("1")))&& chart_hdr_insert_yn.equals("Y")){
				
					// for a New Chart.
					/*
					Case 1. New chart getting inserted for the 1st time
					Case 2. New chart getting inserted for a Mixed-Dentition Case. Update the old with chart_status as 'C' and insert a new chart.
					*/
					if(pstmt != null) pstmt.close();
					if(rst != null) rst.close();
					
					if(show_new_active_yn.equals("Y") && oh_chart_level.equals("F")){ // Case 2
						sqlUpdate = "UPDATE OH_RESTORATIVE_CHART_HDR SET CHART_STATUS = 'C', CHART_CLOSED_BY=?,CHART_CLOSE_DATE=SYSDATE WHERE OPERATING_FACILITY_ID=? AND PATIENT_ID = ? AND CHART_STATUS='A'";
						pstmt=con.prepareStatement(sqlUpdate);
						pstmt.setString(1,login_user);
						pstmt.setString(2,facility_id);
						pstmt.setString(3,patient_id);
						flag = pstmt.executeUpdate();
						if (flag!=0)//added by parul becoz flag was not commited.
						{
							con.commit();

						}else{
							con.rollback();

						}
					}
                 				
					String chart_status = "A";
					String chart_type = checkForNull(req.getParameter("chart_type"));

					if(pstmt != null) pstmt.close();//added by parul 
					if(rst != null) rst.close();//added by parul 
					
					sqlInsert="INSERT INTO OH_RESTORATIVE_CHART_HDR (OPERATING_FACILITY_ID,PATIENT_ID,CHART_NUM,CHART_DATE,CHART_TYPE,CLINICAL_GROUP_CODE,CHART_STATUS,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID) VALUES (?,?,?,SYSDATE,?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?)";
					pstmt=con.prepareStatement(sqlInsert);
					pstmt.setString(1,facility_id);
					pstmt.setString(2,patient_id);
					pstmt.setString(3,chart_num);
					pstmt.setString(4,chart_type);
					pstmt.setString(5,clinical_group_code);
					pstmt.setString(6,chart_status);

					pstmt.setString(7,login_user);
					pstmt.setString(8,client_ip_address);
					pstmt.setString(9,facility_id);
					pstmt.setString(10,login_user);
					pstmt.setString(11,client_ip_address); 
					pstmt.setString(12,facility_id);
					
					flag1 = pstmt.executeUpdate();

					if (flag1!=0)//added by parul becoz flag1 was not commited.
					{
						con.commit();
					}else{
						con.rollback();
					}
				}

				if(pstmt != null) pstmt.close();
				if(rst != null) rst.close();

				/* 
				1. chart_num.equals("1") && chart_hdr_insert_yn.equals("N") for new chart and without refresh case
				2. !chart_num.equals("1") for existing chart
				3. show_new_active_yn.equals("N"): For Mixed Dentition Copy case


				*/
				
				if(site_type.equals("THRNG") || (site_type.equals("TOOTH") && dummy_tooth_no.indexOf(",") != -1) ||  (site_type.equals("MAXFS") && (sub_organ_code.equals("TNGAB") || sub_organ_code.equals("TNGGM") || sub_organ_code.equals("TNGAG") || sub_organ_code.equals("TNGGAM") || sub_organ_code.equals("TNGMF"))) ){//TNGAB,TNGGM,TNGAG,TNGGAM,TNGMF
					// Get the maximum chart_line_num for that chart_num
					if(pstmt != null) pstmt.close();
					if(rst != null) rst.close();
					if(oh_chart_level.equals("E")){
						
						pstmt=con.prepareStatement("SELECT MAX(CHART_LINE_NUM)+1 CHART_LINE_NUM FROM OH_RESTORATIVE_CHART_DTL WHERE PATIENT_ID=? AND CHART_NUM=?");
						pstmt.setString(1,patient_id);
						pstmt.setString(2,chart_num);
						rst = pstmt.executeQuery();
					}
					else{
						pstmt=con.prepareStatement("SELECT MAX(CHART_LINE_NUM)+1 CHART_LINE_NUM FROM OH_RESTORATIVE_CHART_DTL WHERE OPERATING_FACILITY_ID=? AND PATIENT_ID=? AND CHART_NUM=?");
						pstmt.setString(1,facility_id);
						pstmt.setString(2,patient_id);
						pstmt.setString(3,chart_num);
						rst = pstmt.executeQuery();
					}
					while(rst.next()){
						chart_line_num=checkForNull(rst.getString("CHART_LINE_NUM"),"1");
					}

					ArrayList flag_arr= new ArrayList();
					chart_line_num=chart_line_num==null?"1":chart_line_num;
					chart_line_num=chart_line_num.equals("null")?"1":chart_line_num;
					chart_line_num=chart_line_num.equals("0")?"1":chart_line_num;
					chart_line_num=chart_line_num.equals("")?"1":chart_line_num;
					int chart_line_num_int = Integer.parseInt(chart_line_num);
					int chart_line_num_int_for_range_update = Integer.parseInt(chart_line_num);
					StringBuffer tooth_range_chart_line_nums = new StringBuffer();
					StringBuffer tooth_range_col_str = new StringBuffer();
					for(int i=0;i<tooth_range_nos_arr.length;i++){
						chart_line_num=chart_line_num_int+"";

						if(i>0){
							tooth_range_col_str.append(",");
							tooth_range_chart_line_nums.append(",");
						}
						tooth_range_col_str.append(chart_line_num);
						tooth_range_col_str.append("$$");
						tooth_range_col_str.append(tooth_range_nos_arr[i]);
						tooth_range_chart_line_nums.append(chart_line_num);

						
						if(trmt_category_type.equals("BRIDGE") && (i>0 && i<tooth_range_nos_arr.length-1)){
							hide_image_yn = "Y";
						}
						else{
							hide_image_yn = "N";
						}
                       //added by parul on 12/01/2010 for CRF-442
						StringBuffer surface_chart_line_nums= new StringBuffer ();
						StringBuffer surface_range= new StringBuffer ();
                         for (int k=0;k<surface_arr.length;k++){
                             chart_line_num=chart_line_num_int+"";				 
							 if (k>0){
								 surface_range.append(",");
								 surface_chart_line_nums.append(",");
							}
							surface_range.append(chart_line_num);
							surface_range.append("~~");
							surface_range.append(surface_arr[k]);
							surface_chart_line_nums.append(chart_line_num);					
						if(pstmt!=null) pstmt.close();
						if(rst != null) rst.close();
						//pstmt=con.prepareStatement("INSERT INTO OH_RESTORATIVE_CHART_DTL (OPERATING_FACILITY_ID,PATIENT_ID,CHART_NUM,CHART_LINE_NUM,ENCOUNTER_ID,PATIENT_CLASS,TREATMENT_CONDITION,TRMT_CATEGORY_TYPE,TRMT_CATEGORY_CODE,TRMT_CODE,CONDITION_TYPE,CONDITION_CODE,TREATMENT_INT_EXT,TREATMENT_CONDITION_DATE,SITE_TYPE,TOOTH_NO,TOOTH_RANGE,ARCH_SNO,QUADRANT_SNO,SURFACE_CODE,CUSP_TIP_CODE,LOCATION,ORDER_ID,STATUS,TREATMENTS_OUTCOME,REMARKS,MIXED_DENT_DECIDUOUS_YN,SUPERNUMERARY_YN,PRACTITIONER_ID,EPISODE_ID,EPISODE_TYPE,VISIT_ID,SOURCE_CODE,SOURCE_TYPE,HIDE_IMAGE_YN,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,DECODE(?,'ET',TO_DATE(?,'DD/MM/YYYY'),SYSDATE),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?)");
						/* Added by Sridevi Joshi on 12/3/2009 for New changes of SUPRTH*/
						//pstmt=con.prepareStatement("INSERT INTO OH_RESTORATIVE_CHART_DTL (OPERATING_FACILITY_ID,PATIENT_ID,CHART_NUM,CHART_LINE_NUM,ENCOUNTER_ID,PATIENT_CLASS,TREATMENT_CONDITION,TRMT_CATEGORY_TYPE,TRMT_CATEGORY_CODE,TRMT_CODE,CONDITION_TYPE,CONDITION_CODE,TREATMENT_INT_EXT,TREATMENT_CONDITION_DATE,SITE_TYPE,TOOTH_NO,TOOTH_RANGE,ARCH_SNO,QUADRANT_SNO,SURFACE_CODE,CUSP_TIP_CODE,LOCATION,ORDER_ID,STATUS,TREATMENTS_OUTCOME,REMARKS,MIXED_DENT_DECIDUOUS_YN,SUPERNUMERARY_YN,PRACTITIONER_ID,EPISODE_ID,EPISODE_TYPE,VISIT_ID,SOURCE_CODE,SOURCE_TYPE,HIDE_IMAGE_YN,INTRAORAL_EXTRAORAL,ORGAN_CODE,SUB_ORGAN_CODE,SUPER_TOOTH_NO,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,DECODE(?,'ET',TO_DATE(?,'DD/MM/YYYY'),SYSDATE),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?)");

						suprth_count = 0;
						super_key_val = 0;
						super_key_num = "";

						if(oh_chart_level.equals("E")){
							pstmt=con.prepareStatement("SELECT COUNT(*) RESULT_COUNT FROM OH_RESTORATIVE_CHART_DTL A WHERE PATIENT_ID = ? AND CHART_NUM=? AND TOOTH_NO = ? AND CONDITION_TYPE = 'SUPRTH'");
							pstmt.setString(1,patient_id);
							pstmt.setString(2,chart_num);
							pstmt.setString(3,tooth_range_nos_arr[i]);
							rst = pstmt.executeQuery();
						}
						else{
							pstmt=con.prepareStatement("SELECT COUNT(*) RESULT_COUNT FROM OH_RESTORATIVE_CHART_DTL A WHERE OPERATING_FACILITY_ID=? AND PATIENT_ID = ? AND CHART_NUM=? AND TOOTH_NO = ? AND CONDITION_TYPE = 'SUPRTH'");
							pstmt.setString(1,facility_id);
							pstmt.setString(2,patient_id);
							pstmt.setString(3,chart_num);
							pstmt.setString(4,tooth_range_nos_arr[i]);
							rst = pstmt.executeQuery();
						}

						while(rst!= null && rst.next()){
							suprth_count = Integer.parseInt(checkForNull(rst.getString("RESULT_COUNT")));
						}

						if(suprth_count == 0 && condition_type.equals("SUPRTH")){
							super_key_val = 1;
						}
						else if(suprth_count >= 1 && condition_type.equals("SUPRTH")){
							super_key_val = ++suprth_count;
						}

						if(super_key_val != 0){
							super_key_num = "s"+super_key_val;
						}

						/*if(!super_tooth_no.equals("")){
							super_key_num = super_tooth_ref;
						}*/

						pstmt=con.prepareStatement("INSERT INTO OH_RESTORATIVE_CHART_DTL (OPERATING_FACILITY_ID,PATIENT_ID,CHART_NUM,CHART_LINE_NUM,ENCOUNTER_ID,PATIENT_CLASS,TREATMENT_CONDITION,TRMT_CATEGORY_TYPE,TRMT_CATEGORY_CODE,TRMT_CODE,CONDITION_TYPE,CONDITION_CODE,TREATMENT_INT_EXT,TREATMENT_CONDITION_DATE,SITE_TYPE,TOOTH_NO,TOOTH_RANGE,ARCH_SNO,QUADRANT_SNO,SURFACE_CODE,CUSP_TIP_CODE,LOCATION,ORDER_ID,STATUS,TREATMENTS_OUTCOME,FAILURE_REMARKS,REMARKS,MIXED_DENT_DECIDUOUS_YN,SUPERNUMERARY_YN,PRACTITIONER_ID,EPISODE_ID,EPISODE_TYPE,VISIT_ID,SOURCE_CODE,SOURCE_TYPE,HIDE_IMAGE_YN,INTRAORAL_EXTRAORAL,ORGAN_CODE,SUB_ORGAN_CODE,SUPER_TOOTH_NO,RETAINED_TOOTH_NO,SUPER_KEY_NUM,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,DECODE(?,'ET',TO_DATE(?,'DD/MM/YYYY'),SYSDATE),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?)");
					 

						index = 1;
						pstmt.setString(index++,facility_id);			//1
						pstmt.setString(index++,patient_id);			//2
						pstmt.setString(index++,chart_num);				//3
						pstmt.setString(index++,chart_line_num);		//4
						pstmt.setString(index++,encounter_id);			//5
						pstmt.setString(index++,patient_class);			//6
						pstmt.setString(index++,treatment_condition);	//7
						pstmt.setString(index++,trmt_category_type);	//8
						pstmt.setString(index++,trmt_category_code);	//9
						pstmt.setString(index++,trmt_code);				//10
						pstmt.setString(index++,condition_type);		//11
						pstmt.setString(index++,condition_code);		//12
						pstmt.setString(index++,treatment_int_ext);		//13
						pstmt.setString(index++,tab_name);				//14
						pstmt.setString(index++,treatment_condition_date);	//15
						pstmt.setString(index++,site_type);				//16
						pstmt.setString(index++,tooth_range_nos_arr[i]);//17
						pstmt.setString(index++,null); //18 Insert null, the below UPDATE pstmt will update the entire tooth_range for all the chart_line_num's
						pstmt.setString(index++,arch);					//19
						pstmt.setString(index++,quadrant);				//20
						if (multiple_surfaces_applicable.equals("N")) //added by parul on 12/01/2010 for CRF-442
						{
							//pstmt.setString(index++,surface_no);			//21
							pstmt.setString(index++,surface_code);			//21
						}else{
							pstmt.setString(index++,surface_arr[k]);			//21 parul130908
						}

					//	pstmt.setString(index++,surface_code);			//21

						pstmt.setString(index++,cusp_tip);				//22
						pstmt.setString(index++,location);				//23
						pstmt.setString(index++,order_id);				//24
						pstmt.setString(index++,status);				//25
						pstmt.setString(index++,outcome);				//26
						pstmt.setString(index++,failure_remarks);				//26
						pstmt.setString(index++,remarks);				//27
						pstmt.setString(index++,deciduous_yn);				//27
						pstmt.setString(index++,supernuerary_yn);				//27
						pstmt.setString(index++,practitioner_id);				//27
						pstmt.setString(index++,episode_id);					//27
						pstmt.setString(index++,episode_type);					//27
						pstmt.setString(index++,visit_id);					//27
						pstmt.setString(index++,source_code);					//27
						pstmt.setString(index++,source_type);					//27
						pstmt.setString(index++,hide_image_yn);					//27
						pstmt.setString(index++,intraoral_extraoral);					//,
						pstmt.setString(index++,organ_code);					//27
						pstmt.setString(index++,sub_organ_code);					//27
						pstmt.setString(index++,super_tooth_no);			//Added by SRidevi Joshi on 12/3/2009 for SUPRTH changes
						pstmt.setString(index++,retained_tooth_no);			//Added by SRidevi Joshi on 12/17/2009 for RTDESTH changes
						pstmt.setString(index++,super_key_num);			//Added by SRidevi Joshi on 1/20/2010 for CRF-481(IN010894)
						pstmt.setString(index++,login_user);			//28
						pstmt.setString(index++,client_ip_address);		//29
						pstmt.setString(index++,facility_id);			//30
						pstmt.setString(index++,login_user);			//31
						pstmt.setString(index++,client_ip_address);		//32
						pstmt.setString(index++,facility_id);			//33
						flag = pstmt.executeUpdate();
						//chart_line_num_int++;
						flag_arr.add(""+flag);

						if(mixed_dentition_YN.equals("Y") && condition_type.equals("RTDESTH")){
							chart_line_num_int = Integer.parseInt(chart_line_num);
							chart_line_num_int = chart_line_num_int+1;
							chart_line_num = chart_line_num_int+"";

							if(pstmt != null) pstmt.close();//added by parul 
							if(rst != null) rst.close();//added by parul 
							sqlInsert="INSERT INTO OH_RESTORATIVE_CHART_DTL (OPERATING_FACILITY_ID,PATIENT_ID,chart_num,chart_line_num,ENCOUNTER_ID,PATIENT_CLASS,TREATMENT_CONDITION,TRMT_CATEGORY_TYPE,TRMT_CATEGORY_CODE,TRMT_CODE,CONDITION_TYPE,CONDITION_CODE,TREATMENT_INT_EXT,TREATMENT_CONDITION_DATE,SITE_TYPE,TOOTH_NO,TOOTH_RANGE,ARCH_SNO,QUADRANT_SNO,SURFACE_CODE,CUSP_TIP_CODE,LOCATION,ORDER_ID,STATUS,TREATMENTS_OUTCOME,FAILURE_REMARKS,REMARKS,MIXED_DENT_DECIDUOUS_YN,SUPERNUMERARY_YN,PRACTITIONER_ID,EPISODE_ID,EPISODE_TYPE,VISIT_ID,SOURCE_CODE,SOURCE_TYPE,INTRAORAL_EXTRAORAL,ORGAN_CODE,SUB_ORGAN_CODE,RETAINED_TOOTH_NO,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,DECODE(?,'ET',TO_DATE(?,'DD/MM/YYYY'),SYSDATE),?,?,?,?,?,?,?,?,?,?,?,?,?,NULL,?,?,?,?,?,?,?,?,?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?)";
							
							pstmt=con.prepareStatement(sqlInsert);
							index = 1;
							pstmt.setString(index++,facility_id);			//1
							pstmt.setString(index++,patient_id);			//2
							pstmt.setString(index++,chart_num);				//3
							pstmt.setString(index++,chart_line_num);		//4
							pstmt.setString(index++,encounter_id);			//5
							pstmt.setString(index++,patient_class);			//6
							pstmt.setString(index++,treatment_condition);	//7
							pstmt.setString(index++,trmt_category_type);	//8
							pstmt.setString(index++,trmt_category_code);	//9
							pstmt.setString(index++,trmt_code);				//10
							pstmt.setString(index++,"PARERTH");		//11
							pstmt.setString(index++,condition_code);		//12
							pstmt.setString(index++,treatment_int_ext);		//13
							pstmt.setString(index++,tab_name);				//14
							pstmt.setString(index++,treatment_condition_date);	//15
							pstmt.setString(index++,site_type);				//16
							pstmt.setString(index++,tooth_range_nos_arr[i]);//17
							pstmt.setString(index++,null); //18 Insert null, the below UPDATE pstmt will update the entire tooth_range for all the chart_line_num's
							pstmt.setString(index++,arch);					//19
							pstmt.setString(index++,quadrant);				//20
							if (multiple_surfaces_applicable.equals("N"))//added by parul on 12/01/2010 for CRF-442
							{
								pstmt.setString(index++,surface_code);			//21
							}else{
								pstmt.setString(index++,surface_arr[k]);			//21 
							}
							//pstmt.setString(index++,surface_code);			//21

							pstmt.setString(index++,cusp_tip);				//22
							pstmt.setString(index++,location);				//23
							pstmt.setString(index++,order_id);				//24
							pstmt.setString(index++,"Z");				//25
							pstmt.setString(index++,failure_remarks);				//26
							pstmt.setString(index++,outcome);				//26
							pstmt.setString(index++,remarks);				//27
							pstmt.setString(index++,supernuerary_yn);				//27
							pstmt.setString(index++,practitioner_id);				//27
							pstmt.setString(index++,episode_id);					//27
							pstmt.setString(index++,episode_type);					//27
							pstmt.setString(index++,visit_id);					//27
							pstmt.setString(index++,source_code);					//27
							pstmt.setString(index++,source_type);					//27
							pstmt.setString(index++,intraoral_extraoral);					//,
							pstmt.setString(index++,organ_code);					//27
							pstmt.setString(index++,sub_organ_code);					//27
							pstmt.setString(index++,retained_tooth_no);					//27
							pstmt.setString(index++,login_user);			//28
							pstmt.setString(index++,client_ip_address);		//29
							pstmt.setString(index++,facility_id);			//30
							pstmt.setString(index++,login_user);			//31
							pstmt.setString(index++,client_ip_address);		//32
							pstmt.setString(index++,facility_id);			//33
							flag = pstmt.executeUpdate();
							 //chart_line_num_int++;
							flag_arr.add(""+flag);
						}

						if(mixed_dentition_YN.equals("N") && permanent_deciduous_flag.equals("P") && condition_type.equals("RTDESTH")){
							chart_line_num_int = Integer.parseInt(chart_line_num);
							chart_line_num_int = chart_line_num_int+1;
							chart_line_num = chart_line_num_int+"";
						
							if(pstmt != null) pstmt.close();//added by parul 
							if(rst != null) rst.close();//added by parul 
							sqlInsert="INSERT INTO OH_RESTORATIVE_CHART_DTL (OPERATING_FACILITY_ID,PATIENT_ID,CHART_NUM,CHART_LINE_NUM,ENCOUNTER_ID,PATIENT_CLASS,TREATMENT_CONDITION,TRMT_CATEGORY_TYPE,TRMT_CATEGORY_CODE,TRMT_CODE,CONDITION_TYPE,CONDITION_CODE,TREATMENT_INT_EXT,TREATMENT_CONDITION_DATE,SITE_TYPE,TOOTH_NO,TOOTH_RANGE,ARCH_SNO,QUADRANT_SNO,SURFACE_CODE,CUSP_TIP_CODE,LOCATION,ORDER_ID,STATUS,TREATMENTS_OUTCOME,FAILURE_REMARKS,REMARKS,MIXED_DENT_DECIDUOUS_YN,SUPERNUMERARY_YN,PRACTITIONER_ID,EPISODE_ID,EPISODE_TYPE,VISIT_ID,SOURCE_CODE,SOURCE_TYPE,INTRAORAL_EXTRAORAL,ORGAN_CODE,SUB_ORGAN_CODE,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,DECODE(?,'ET',TO_DATE(?,'DD/MM/YYYY'),SYSDATE),?,?,?,?,?,?,?,?,?,?,?,?,?,NULL,?,?,?,?,?,?,?,?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?)";
							
							pstmt=con.prepareStatement(sqlInsert);
							index = 1;
							pstmt.setString(index++,facility_id);			//1
							pstmt.setString(index++,patient_id);			//2
							pstmt.setString(index++,chart_num);				//3
							pstmt.setString(index++,chart_line_num);		//4
							pstmt.setString(index++,encounter_id);			//5
							pstmt.setString(index++,patient_class);			//6
							pstmt.setString(index++,treatment_condition);	//7
							pstmt.setString(index++,trmt_category_type);	//8
							pstmt.setString(index++,trmt_category_code);	//9
							pstmt.setString(index++,trmt_code);				//10
							pstmt.setString(index++,"UNERTH");		//11
							pstmt.setString(index++,condition_code);		//12
							pstmt.setString(index++,treatment_int_ext);		//13
							pstmt.setString(index++,tab_name);				//14
							pstmt.setString(index++,treatment_condition_date);	//15
							pstmt.setString(index++,site_type);				//16
							pstmt.setString(index++,tooth_range_nos_arr[i]);//17
							pstmt.setString(index++,null); //18 Insert null, the below UPDATE pstmt will update the entire tooth_range for all the chart_line_num's
							pstmt.setString(index++,arch);					//19
							pstmt.setString(index++,quadrant);				//20
							if (multiple_surfaces_applicable.equals("N")){//added by parul on 12/01/2010 for CRF-442 
								pstmt.setString(index++,surface_code);			//21
							}else{
								pstmt.setString(index++,surface_arr[k]);			//21 parul130908
							}
							//pstmt.setString(index++,surface_code);			//21

							pstmt.setString(index++,cusp_tip);				//22
							pstmt.setString(index++,location);				//23
							pstmt.setString(index++,order_id);				//24
							pstmt.setString(index++,"Z");				//25
							pstmt.setString(index++,outcome);				//26
							pstmt.setString(index++,failure_remarks);				//26
							pstmt.setString(index++,remarks);				//27
							pstmt.setString(index++,supernuerary_yn);				//27
							pstmt.setString(index++,practitioner_id);				//27
							pstmt.setString(index++,episode_id);					//27
							pstmt.setString(index++,episode_type);					//27
							pstmt.setString(index++,visit_id);					//27
							pstmt.setString(index++,source_code);					//27
							pstmt.setString(index++,source_type);					//27
							pstmt.setString(index++,intraoral_extraoral);					//,
							pstmt.setString(index++,organ_code);					//27
							pstmt.setString(index++,sub_organ_code);					//27
							pstmt.setString(index++,login_user);			//28
							pstmt.setString(index++,client_ip_address);		//29
							pstmt.setString(index++,facility_id);			//30
							pstmt.setString(index++,login_user);			//31
							pstmt.setString(index++,client_ip_address);		//32
							pstmt.setString(index++,facility_id);			//33
							flag = pstmt.executeUpdate();
							// chart_line_num_int++;
							flag_arr.add(""+flag);
						}
						
						chart_line_num_int++;
						if(pstmt1 != null) pstmt1.close();
						if(rst != null) rst.close();
						
						if(condition_type.equals("IMPACTN")){
							if(oh_chart_level.equals("E")){
								//pstmt1=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_DTL SET HIDE_IMAGE_YN = 'Y', COPIED_YN = 'N' WHERE PATIENT_ID = ? AND CHART_NUM = ? AND TOOTH_NO = ? AND NVL(STATUS, 'X') != 'E' AND CONDITION_TYPE IN ('UNERTH','PARERTH')");
								//Commented above and Added Sridevi Joshi on 12/17/2009 for IN017296 to show PARERTH image after recording impaction for 2nd time..
								pstmt1=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_DTL SET HIDE_IMAGE_YN = 'Y', COPIED_YN = 'N' WHERE PATIENT_ID = ? AND CHART_NUM = ? AND TOOTH_NO = ? AND NVL(STATUS, 'X') != 'E' AND CONDITION_TYPE IN ('UNERTH')");
								pstmt1.setString(1,patient_id);
								pstmt1.setString(2,chart_num);
								pstmt1.setString(3,tooth_range_nos_arr[i]);
								flag = pstmt1.executeUpdate();
							}
							else{
								//pstmt1=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_DTL SET HIDE_IMAGE_YN = 'Y', COPIED_YN = 'N' WHERE OPERATING_FACILITY_ID = ? AND PATIENT_ID = ? AND CHART_NUM = ? AND TOOTH_NO = ? AND NVL(STATUS, 'X') != 'E' AND CONDITION_TYPE IN ('UNERTH','PARERTH')");
								//Commented above and Added Sridevi Joshi on 12/17/2009 for IN017296 to show PARERTH image after recording impaction for 2nd time..
								pstmt1=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_DTL SET HIDE_IMAGE_YN = 'Y', COPIED_YN = 'N' WHERE OPERATING_FACILITY_ID = ? AND PATIENT_ID = ? AND CHART_NUM = ? AND TOOTH_NO = ? AND NVL(STATUS, 'X') != 'E' AND CONDITION_TYPE IN ('UNERTH')");
								pstmt1.setString(1,facility_id);
								pstmt1.setString(2,patient_id);
								pstmt1.setString(3,chart_num);
								pstmt1.setString(4,tooth_range_nos_arr[i]);
								flag = pstmt1.executeUpdate();
							}
						}

						if(pstmt1 != null) pstmt1.close();
						if(rst != null) rst.close();

						if(condition_type.equals("PARERTH")){
							if(oh_chart_level.equals("E")){
								pstmt1=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_DTL SET HIDE_IMAGE_YN = 'Y', COPIED_YN = 'N' WHERE PATIENT_ID = ? AND CHART_NUM = ? AND TOOTH_NO = ? AND NVL(STATUS, 'X') != 'E' AND CONDITION_TYPE IN ('UNERTH','EXFOLTH','IMPACTN')");
								pstmt1.setString(1,patient_id);
								pstmt1.setString(2,chart_num);
								pstmt1.setString(3,tooth_range_nos_arr[i]);
								flag = pstmt1.executeUpdate();
							}
							else{
								pstmt1=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_DTL SET HIDE_IMAGE_YN = 'Y', COPIED_YN = 'N' WHERE OPERATING_FACILITY_ID = ? AND PATIENT_ID = ? AND CHART_NUM = ? AND TOOTH_NO = ? AND NVL(STATUS, 'X') != 'E' AND CONDITION_TYPE IN ('UNERTH','EXFOLTH','IMPACTN')");
								pstmt1.setString(1,facility_id);
								pstmt1.setString(2,patient_id);
								pstmt1.setString(3,chart_num);
								pstmt1.setString(4,tooth_range_nos_arr[i]);
								flag = pstmt1.executeUpdate();
							}

						}
						if(pstmt1 != null) pstmt1.close();
						if(rst != null) rst.close();

						if(condition_type.equals("ERUPTH")){
							if(oh_chart_level.equals("E")){
								pstmt1=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_DTL SET HIDE_IMAGE_YN = 'Y', COPIED_YN = 'N' WHERE PATIENT_ID = ? AND CHART_NUM = ? AND TOOTH_NO = ? AND NVL(STATUS, 'X') != 'E' AND CONDITION_TYPE IN ('PARERTH','UNERTH','EXFOLTH','IMPACTN')"); 
								pstmt1.setString(1,patient_id);
								pstmt1.setString(2,chart_num);
								pstmt1.setString(3,tooth_range_nos_arr[i]);
								flag = pstmt1.executeUpdate();
							}
							else{
								pstmt1=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_DTL SET HIDE_IMAGE_YN = 'Y', COPIED_YN = 'N' WHERE OPERATING_FACILITY_ID = ? AND PATIENT_ID = ? AND CHART_NUM = ? AND TOOTH_NO = ? AND NVL(STATUS, 'X') != 'E' AND CONDITION_TYPE IN ('PARERTH','UNERTH','EXFOLTH','IMPACTN')"); 
								pstmt1.setString(1,facility_id);
								pstmt1.setString(2,patient_id);
								pstmt1.setString(3,chart_num);
								pstmt1.setString(4,tooth_range_nos_arr[i]);
								flag = pstmt1.executeUpdate();
							}
						}

						if(pstmt1 != null) pstmt1.close();
						if(rst != null) rst.close();

						/* commented by Sridevi Joshi on 12/18/2009 ...  SUPRTH is not applicable for THRNG
						if(condition_type.equals("EXFOLTH") && supernuerary_yn == "Y"){
							if(oh_chart_level.equals("E")){
								pstmt1=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_DTL SET HIDE_IMAGE_YN = 'Y', COPIED_YN = 'N' WHERE PATIENT_ID = ? AND CHART_NUM = ? AND TOOTH_NO = ? AND NVL(STATUS, 'X') != 'E' AND CONDITION_TYPE = 'SUPRTH'"); 
								pstmt1.setString(1,patient_id);
								pstmt1.setString(2,chart_num);
								pstmt1.setString(3,tooth_range_nos_arr[i]);
								flag = pstmt1.executeUpdate();
							}
							else{
								pstmt1=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_DTL SET HIDE_IMAGE_YN = 'Y', COPIED_YN = 'N' WHERE OPERATING_FACILITY_ID = ? AND PATIENT_ID = ? AND CHART_NUM = ? AND TOOTH_NO = ? AND NVL(STATUS, 'X') != 'E' AND CONDITION_TYPE = 'SUPRTH'"); 
								pstmt1.setString(1,facility_id);
								pstmt1.setString(2,patient_id);
								pstmt1.setString(3,chart_num);
								pstmt1.setString(4,tooth_range_nos_arr[i]);
								flag = pstmt1.executeUpdate();
							}


							if(pstmt1 != null) pstmt1.close();
							if(rst != null) rst.close();//added by parul 

							if(oh_chart_level.equals("E")){
								pstmt1=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_DTL SET SUPERNUMERARY_YN = NULL, COPIED_YN = 'N' WHERE PATIENT_ID = ? AND CHART_NUM = ? AND TOOTH_NO = ? AND NVL(STATUS, 'X') != 'E' AND CONDITION_TYPE = 'EXFOLTH' AND SUPERNUMERARY_YN = 'N'"); 
								pstmt1.setString(1,patient_id);
								pstmt1.setString(2,chart_num);
								pstmt1.setString(3,tooth_range_nos_arr[i]);
								//pstmt1.executeUpdate();
								flag = pstmt1.executeUpdate();//added by parul on 111108

								if(pstmt1 != null) pstmt1.close();//added by parul
								pstmt1=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_DTL SET HIDE_IMAGE_YN = 'Y', COPIED_YN = 'N' WHERE PATIENT_ID = ? AND CHART_NUM = ? AND TOOTH_NO = ? AND NVL(STATUS, 'X') != 'E' AND CONDITION_TYPE NOT IN ('SUPRTH','EXFOLTH') AND SUPERNUMERARY_YN = 'Y'"); 
								pstmt1.setString(1,patient_id);
								pstmt1.setString(2,chart_num);
								pstmt1.setString(3,tooth_range_nos_arr[i]);
								//pstmt.executeUpdate();
								flag = pstmt1.executeUpdate();//added by Sridevi Joshi on 19/11/2008
							}
							else{
								pstmt1=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_DTL SET SUPERNUMERARY_YN = NULL, COPIED_YN = 'N' WHERE OPERATING_FACILITY_ID = ? AND PATIENT_ID = ? AND CHART_NUM = ? AND TOOTH_NO = ? AND NVL(STATUS, 'X') != 'E' AND CONDITION_TYPE = 'EXFOLTH' AND SUPERNUMERARY_YN = 'N'"); 
								pstmt1.setString(1,facility_id);
								pstmt1.setString(2,patient_id);
								pstmt1.setString(3,chart_num);
								pstmt1.setString(4,tooth_range_nos_arr[i]);
								//pstmt1.executeUpdate();
								flag = pstmt1.executeUpdate();//added by parul on 111108

								if(pstmt1 != null) pstmt1.close();//added by parul
								pstmt1=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_DTL SET HIDE_IMAGE_YN = 'Y', COPIED_YN = 'N' WHERE OPERATING_FACILITY_ID = ? AND PATIENT_ID = ? AND CHART_NUM = ? AND TOOTH_NO = ? AND NVL(STATUS, 'X') != 'E' AND CONDITION_TYPE NOT IN ('SUPRTH','EXFOLTH') AND SUPERNUMERARY_YN = 'Y'"); 
								pstmt1.setString(1,facility_id);
								pstmt1.setString(2,patient_id);
								pstmt1.setString(3,chart_num);
								pstmt1.setString(4,tooth_range_nos_arr[i]);
								//pstmt.executeUpdate();
								flag = pstmt1.executeUpdate();//added by Sridevi Joshi on 19/11/2008
							}

						}*/
						else if(condition_type.equals("EXFOLTH")){
							if(pstmt1 != null) pstmt1.close();
							if(rst != null) rst.close();
							if(oh_chart_level.equals("E")){
								pstmt1=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_DTL SET HIDE_IMAGE_YN = 'D', COPIED_YN = 'N' WHERE PATIENT_ID = ? AND CHART_NUM = ? AND TOOTH_NO = ? AND NVL(STATUS, 'X') != 'E' AND CONDITION_TYPE = 'DECITH'"); 
								pstmt1.setString(1,patient_id);
								pstmt1.setString(2,chart_num);
								pstmt1.setString(3,tooth_range_nos_arr[i]);
								flag = pstmt1.executeUpdate();


								if(pstmt1 != null) pstmt1.close();
								pstmt1=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_DTL SET HIDE_IMAGE_YN = 'D', COPIED_YN = 'N' WHERE PATIENT_ID = ? AND CHART_NUM = ? AND TOOTH_NO = ? AND NVL(STATUS, 'X') != 'E' AND CONDITION_TYPE = 'RTDESTH'"); 
								pstmt1.setString(1,patient_id);
								pstmt1.setString(2,chart_num);
								pstmt1.setString(3,tooth_range_nos_arr[i]);
								//pstmt1.executeUpdate();
								flag = pstmt1.executeUpdate();//added by parul on 111108
							
								if(deciduous_yn.equals("R")){
									if(pstmt1 != null) pstmt1.close();//added by parul
									pstmt1=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_DTL SET HIDE_IMAGE_YN = 'Y', COPIED_YN = 'N' WHERE PATIENT_ID = ? AND CHART_NUM = ? AND TOOTH_NO = ? AND NVL(STATUS, 'X') != 'E' AND CONDITION_TYPE NOT IN ('RTDESTH','DECITH','EXFOLTH') AND MIXED_DENT_DECIDUOUS_YN = 'R' AND NVL(STATUS, 'X') != 'Z'"); 
									pstmt1.setString(1,patient_id);
									pstmt1.setString(2,chart_num);
									pstmt1.setString(3,tooth_range_nos_arr[i]);
									//pstmt.executeUpdate();
									flag = pstmt1.executeUpdate();//added by Sridevi Joshi on 19/11/2008
								}
								else{
									if(pstmt1 != null) pstmt1.close();//added by parul
									pstmt1=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_DTL SET HIDE_IMAGE_YN = 'Y', COPIED_YN = 'N' WHERE PATIENT_ID = ? AND CHART_NUM = ? AND TOOTH_NO = ? AND NVL(STATUS, 'X') != 'E' AND CONDITION_TYPE NOT IN ('RTDESTH','DECITH','EXFOLTH') AND (SUPERNUMERARY_YN IS NULL OR SUPERNUMERARY_YN = 'N') AND NVL(MIXED_DENT_DECIDUOUS_YN,'A') <> 'R'"); 
									pstmt1.setString(1,patient_id);
									pstmt1.setString(2,chart_num);
									pstmt1.setString(3,tooth_range_nos_arr[i]);
									//pstmt.executeUpdate();
									flag = pstmt1.executeUpdate();//added by Sridevi Joshi on 19/11/2008
								}
						}
						else{
							pstmt1=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_DTL SET HIDE_IMAGE_YN = 'D', COPIED_YN = 'N' WHERE OPERATING_FACILITY_ID = ? AND PATIENT_ID = ? AND CHART_NUM = ? AND TOOTH_NO = ? AND NVL(STATUS, 'X') != 'E' AND CONDITION_TYPE = 'DECITH'"); 
								pstmt1.setString(1,facility_id);
								pstmt1.setString(2,patient_id);
								pstmt1.setString(3,chart_num);
								pstmt1.setString(4,tooth_range_nos_arr[i]);
								//pstmt1.executeUpdate();
								flag = pstmt1.executeUpdate();//added by parul on 111108


								if(pstmt1 != null) pstmt1.close();
								pstmt1=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_DTL SET HIDE_IMAGE_YN = 'D', COPIED_YN = 'N' WHERE OPERATING_FACILITY_ID = ? AND PATIENT_ID = ? AND CHART_NUM = ? AND TOOTH_NO = ? AND NVL(STATUS, 'X') != 'E' AND CONDITION_TYPE = 'RTDESTH'"); 
								pstmt1.setString(1,facility_id);
								pstmt1.setString(2,patient_id);
								pstmt1.setString(3,chart_num);
								pstmt1.setString(4,tooth_range_nos_arr[i]);
								//pstmt1.executeUpdate();
								flag = pstmt1.executeUpdate();//added by parul on 111108

								if(deciduous_yn.equals("R")){
									if(pstmt1 != null) pstmt1.close();//added by parul
									pstmt1=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_DTL SET HIDE_IMAGE_YN = 'Y', COPIED_YN = 'N' WHERE OPERATING_FACILITY_ID = ? AND PATIENT_ID = ? AND CHART_NUM = ? AND TOOTH_NO = ? AND NVL(STATUS, 'X') != 'E' AND CONDITION_TYPE NOT IN ('RTDESTH','DECITH','EXFOLTH') AND MIXED_DENT_DECIDUOUS_YN = 'R' AND NVL(STATUS, 'X') != 'Z'"); 
									pstmt1.setString(1,facility_id);
									pstmt1.setString(2,patient_id);
									pstmt1.setString(3,chart_num);
									pstmt1.setString(4,tooth_range_nos_arr[i]);
									//pstmt.executeUpdate();
									flag = pstmt1.executeUpdate();//added by Sridevi Joshi on 19/11/2008
								}
								else{
									if(pstmt1 != null) pstmt1.close();//added by parul
									pstmt1=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_DTL SET HIDE_IMAGE_YN = 'Y', COPIED_YN = 'N' WHERE OPERATING_FACILITY_ID = ? AND PATIENT_ID = ? AND CHART_NUM = ? AND TOOTH_NO = ? AND NVL(STATUS, 'X') != 'E' AND CONDITION_TYPE NOT IN ('RTDESTH','DECITH','EXFOLTH') AND (SUPERNUMERARY_YN IS NULL OR SUPERNUMERARY_YN = 'N') AND NVL(MIXED_DENT_DECIDUOUS_YN,'A') <> 'R'"); 
									pstmt1.setString(1,facility_id);
									pstmt1.setString(2,patient_id);
									pstmt1.setString(3,chart_num);
									pstmt1.setString(4,tooth_range_nos_arr[i]);
									//pstmt.executeUpdate();
									flag = pstmt1.executeUpdate();//added by Sridevi Joshi on 19/11/2008
								}
							}
						}
					 }//for super changes
				}
					// Update the Tooth_range
					if(site_type.equals("THRNG") || site_type.equals("MAXFS")){
						if(pstmt!=null) pstmt.close();
						if(rst != null) rst.close();//added by parul 
						//if(!condition_type.equals("MXNTL") && !header_tab.equals("C") ){  // added by yadav for restricting  tooth range updation for Condition tab  for CRF=476
						if(!condition_type.equals("MXNTL")){  // added by yadav for restricting  tooth range updation for Condition tab  for CRF=476
						if(oh_chart_level.equals("E")){
							pstmt=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_DTL SET TOOTH_RANGE = ?, COPIED_YN = 'N' WHERE PATIENT_ID = ? AND CHART_NUM = ? AND CHART_LINE_NUM = ?");
							pstmt.setString(1,tooth_range_col_str.toString());
							int flag2 = 1;
							for(int  i=0;i<tooth_range_nos_arr.length;i++){
								chart_line_num=chart_line_num_int_for_range_update+""; 
								pstmt.setString(2,patient_id);
								pstmt.setString(3,chart_num);
								pstmt.setString(4,chart_line_num);
								flag2 = pstmt.executeUpdate();
								chart_line_num_int_for_range_update++;
								if (flag2!=0)//if block added by parul on111108
								{
									con.commit();
								}else{
										con.rollback();
								}
							}
						}
						}
					
					}
				
					if(!flag_arr.contains("0")){
						commit_flag="Y";
					 }else{
						commit_flag="N";
					 }
					 flag_arr.clear();	//Common-ICN-0044
				}
				else{
					if( (!chart_num.equals("1") && show_new_active_yn.equals("N")) || chart_hdr_insert_yn.equals("N")){ // In case of existing chart_num, get the max chart_line_num
						// Get the maximum chart_line_num for that chart_num
						if(pstmt != null) pstmt.close();
						if(rst != null) rst.close();//added by parul 
						if(oh_chart_level.equals("E")){
							pstmt=con.prepareStatement("SELECT MAX(CHART_LINE_NUM)+1 CHART_LINE_NUM FROM OH_RESTORATIVE_CHART_DTL WHERE PATIENT_ID=? AND CHART_NUM=?");
							pstmt.setString(1,patient_id);
							pstmt.setString(2,chart_num);
							rst = pstmt.executeQuery();
						}
						else{
							pstmt=con.prepareStatement("SELECT MAX(CHART_LINE_NUM)+1 CHART_LINE_NUM FROM OH_RESTORATIVE_CHART_DTL WHERE OPERATING_FACILITY_ID=? AND PATIENT_ID=? AND CHART_NUM=?");
							pstmt.setString(1,facility_id);
							pstmt.setString(2,patient_id);
							pstmt.setString(3,chart_num);
							rst = pstmt.executeQuery();
						}
						while(rst.next()){
							chart_line_num=checkForNull(rst.getString("CHART_LINE_NUM"),"1");
						}
                         
						if(rst != null) rst.close();
						if(pstmt != null) pstmt.close();
					}
					ArrayList flag_arr= new ArrayList();
					chart_line_num=chart_line_num==null?"1":chart_line_num;
					chart_line_num=chart_line_num.equals("null")?"1":chart_line_num;
					chart_line_num=chart_line_num.equals("0")?"1":chart_line_num;
					chart_line_num=chart_line_num.equals("")?"1":chart_line_num;
					int chart_line_num_int = Integer.parseInt(chart_line_num);
					int chart_line_num_int_1 = Integer.parseInt(chart_line_num);
					//added by parul for CRF#0483 on 21/08/2009
					/* StringBuffer cusp_chart_line_nums= new StringBuffer ();
					StringBuffer cusp_tip_code_range= new StringBuffer (); */	//Commented Against Common-ICN-0031
					StringBuffer cusp_range= new StringBuffer ();
					for (int k=0;k<cusp_arr.length;k++){
						 if (k>0){
							 cusp_range.append(",");
						}
						cusp_range.append(cusp_arr[k]);
					}	
					//surface-->2,5
					//cusp-->3,4
					 //added by parul on 201008 for CRF-442
                    StringBuffer surface_chart_line_nums= new StringBuffer ();
					StringBuffer surface_range= new StringBuffer ();
					//StringBuffer cusp_tip_code_range= new StringBuffer ();	//Common-ICN-0044
                         for (int k=0;k<surface_arr.length;k++){
                          chart_line_num=chart_line_num_int_1+"";				 
							 if (k>0){
								 surface_range.append(",");
								 surface_chart_line_nums.append(",");
							}
							surface_range.append(chart_line_num);
							surface_range.append("~~");
							surface_range.append(surface_arr[k]);
							surface_chart_line_nums.append(chart_line_num);
							//StringBuffer cusp_tip_value= new StringBuffer ();
							StringBuffer cusp_tip_value= new StringBuffer ();	
							cusp_tip_value.delete(0, cusp_tip_value.length());
							for (int u=0;u<cusp_arr.length;u++){
									if(rst != null) rst.close();
									if(pstmt != null) pstmt.close();
									pstmt=con.prepareStatement("SELECT B.SURFACE_CODE FROM OH_CUSP_TIP_LANG_VW A, OH_SURFACE_APPL_CUSP_TIP B WHERE A.LANGUAGE_ID=? AND A.CUSP_TIP_CODE = B.CUSP_TIP_CODE and B.TOOTH_NO=? and A.CUSP_TIP_CODE  = ?");
										pstmt.setString(1,locale);
										pstmt.setString(2,tooth_no);
										pstmt.setString(3,cusp_arr[u]);
										rst = pstmt.executeQuery();
										while(rst.next()){
											cusp_tip_code_ref = checkForNull(rst.getString("SURFACE_CODE"));
										}
									System.err.println("1300::cusp_tip_code_ref---------"+cusp_tip_code_ref);
									System.err.println("1300::cusp_tip---------"+cusp_tip);
									System.err.println("1300::cusp_tip[u]---------"+cusp_arr[u]);
									System.err.println("1300::compareTo---------"+cusp_tip_code_ref.compareTo(surface_arr[k]));

									if (site_type.equals("CROWN") || site_type.equals("ROOT")){
										if(cusp_tip_code_ref.compareTo(surface_arr[k]) == 0){
											// if(cusp_tip_value.equals("null") || cusp_tip_value.equals(null) || cusp_tip_value.equals("")){
											System.err.println("cusp_tip_value.length()---------"+cusp_tip_value.length());

											 if(cusp_tip_value.length()==0){
												cusp_tip_value.append(cusp_arr[u]);
											 }else{
												cusp_tip_value.append(",");
												cusp_tip_value.append(cusp_arr[u]);
											 }
											
										}
									}
							}	

						if(rst != null) rst.close();
						if(pstmt != null) pstmt.close();
						//sqlInsert="INSERT INTO OH_RESTORATIVE_CHART_DTL (OPERATING_FACILITY_ID,PATIENT_ID,chart_num,chart_line_num,ENCOUNTER_ID,PATIENT_CLASS,TREATMENT_CONDITION,TRMT_CATEGORY_TYPE,TRMT_CATEGORY_CODE,TRMT_CODE,CONDITION_TYPE,CONDITION_CODE,TREATMENT_INT_EXT,TREATMENT_CONDITION_DATE,SITE_TYPE,TOOTH_NO,TOOTH_RANGE,ARCH_SNO,QUADRANT_SNO,SURFACE_CODE,CUSP_TIP_CODE,LOCATION,ORDER_ID,STATUS,TREATMENTS_OUTCOME,REMARKS,MIXED_DENT_DECIDUOUS_YN,SUPERNUMERARY_YN,PRACTITIONER_ID,EPISODE_ID,EPISODE_TYPE,VISIT_ID,SOURCE_CODE,SOURCE_TYPE,INTRAORAL_EXTRAORAL,ORGAN_CODE,SUB_ORGAN_CODE,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,DECODE(?,'ET',TO_DATE(?,'DD/MM/YYYY'),SYSDATE),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?)";

						/* SUPER_TOOTH_NO added by Sridevi Joshi on 12/7/2009 for SUPRTH new Changes*/
						sqlInsert="INSERT INTO OH_RESTORATIVE_CHART_DTL (OPERATING_FACILITY_ID,PATIENT_ID,chart_num,chart_line_num,ENCOUNTER_ID,PATIENT_CLASS,TREATMENT_CONDITION,TRMT_CATEGORY_TYPE,TRMT_CATEGORY_CODE,TRMT_CODE,CONDITION_TYPE,CONDITION_CODE,TREATMENT_INT_EXT,TREATMENT_CONDITION_DATE,SITE_TYPE,TOOTH_NO,TOOTH_RANGE,ARCH_SNO,QUADRANT_SNO,SURFACE_CODE,CUSP_TIP_CODE,LOCATION,ORDER_ID,STATUS,TREATMENTS_OUTCOME,FAILURE_REMARKS,REMARKS,MIXED_DENT_DECIDUOUS_YN,SUPERNUMERARY_YN,PRACTITIONER_ID,EPISODE_ID,EPISODE_TYPE,VISIT_ID,SOURCE_CODE,SOURCE_TYPE,INTRAORAL_EXTRAORAL,ORGAN_CODE,SUB_ORGAN_CODE,SUPER_TOOTH_NO,RETAINED_TOOTH_NO,SUPER_KEY_NUM,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,DECODE(?,'ET',TO_DATE(?,'DD/MM/YYYY'),SYSDATE),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?)";
					System.err.println("cusp_tip_value.toString()---------"+cusp_tip_value.toString());
					System.err.println("cusp_tip_value.length()---------"+cusp_tip_value.length());

						pstmt=con.prepareStatement(sqlInsert);
						index = 1;
						pstmt.setString(index++,facility_id);				//1  
						pstmt.setString(index++,patient_id);				//2  
						pstmt.setString(index++,chart_num);					//3  
						pstmt.setString(index++,chart_line_num);			//4  
						pstmt.setString(index++,encounter_id);				//5  
						pstmt.setString(index++,patient_class);				//6  
						pstmt.setString(index++,treatment_condition);		//7  
						pstmt.setString(index++,trmt_category_type);		//8  
						pstmt.setString(index++,trmt_category_code);		//9  
						pstmt.setString(index++,trmt_code);					//10 
						pstmt.setString(index++,condition_type);			//11 
						pstmt.setString(index++,condition_code);			//12 
						pstmt.setString(index++,treatment_int_ext);			//13 
						pstmt.setString(index++,tab_name);					//14
						pstmt.setString(index++,treatment_condition_date); //15
						pstmt.setString(index++,site_type);					//16
						pstmt.setString(index++,tooth_no);					//17
						pstmt.setString(index++,tooth_range_nos);			//18
						pstmt.setString(index++,arch);						//19
						pstmt.setString(index++,quadrant);					//20
					//	pstmt.setString(index++,surface_code);
						if (multiple_surfaces_applicable.equals("N")){//added by parul on 19/01/2010 for CRF-442
						//	pstmt.setString(index++,surface_no);			//21
							pstmt.setString(index++,surface_code);			//21
						}else{
							pstmt.setString(index++,surface_arr[k]);			//21 parul130908
						}
						if (cusp_tip_value.length()>0){
						    pstmt.setString(index++,cusp_tip_value.toString());					//22

						}else{
							if (surface_no.equals("*A")){
								 pstmt.setString(index++,cusp_range.toString());					//22
							}else{
								pstmt.setString(index++,null);
							}
						}
						pstmt.setString(index++,location);					//23
						pstmt.setString(index++,order_id);					//24
						pstmt.setString(index++,status);					//25
						pstmt.setString(index++,outcome);					//26
						pstmt.setString(index++,failure_remarks);					//26
						pstmt.setString(index++,remarks);					//27
						pstmt.setString(index++,deciduous_yn);					//27
						pstmt.setString(index++,supernuerary_yn);					//27
						pstmt.setString(index++,practitioner_id);					//27
						pstmt.setString(index++,episode_id);					//27
						pstmt.setString(index++,episode_type);					//27
						pstmt.setString(index++,visit_id);					//27
						pstmt.setString(index++,source_code);					//27
						pstmt.setString(index++,source_type);					//27
						pstmt.setString(index++,intraoral_extraoral);					//,
						pstmt.setString(index++,organ_code);					//27
						pstmt.setString(index++,sub_organ_code);					//27
						pstmt.setString(index++,super_tooth_no);			//Added by SRidevi Joshi on 12/3/2009 for SUPRTH changes
						pstmt.setString(index++,retained_tooth_no);			//Added by SRidevi Joshi on 12/17/2009 for RTDESTH changes
						pstmt.setString(index++,super_key_num);			//Added by SRidevi Joshi on 1/20/2010 for CRF-481(IN010894)
						pstmt.setString(index++,login_user);				//28
						pstmt.setString(index++,client_ip_address);			//29
						pstmt.setString(index++,facility_id);				//30
						pstmt.setString(index++,login_user);				//31
						pstmt.setString(index++,client_ip_address); 		//32
						pstmt.setString(index++,facility_id);				//33
						flag = pstmt.executeUpdate();
						//added by parul on 19/01/2010 for CRF-442(IN010838)
						chart_line_num_int_1++;
						//end
						flag_arr.add(""+flag);

					if(mixed_dentition_YN.equals("Y") && condition_type.equals("RTDESTH")){
						chart_line_num_int = chart_line_num_int+1;
						chart_line_num = chart_line_num_int+"";

						//if(mixed_dentition_YN.equals("Y") && permanent_deciduous_flag.equals("D") && !super_tooth_ref.equals("RD") && !super_tooth_ref.equals("s1") && !super_tooth_ref.equals("s2")){
						if(mixed_dentition_YN.equals("Y") && permanent_deciduous_flag.equals("D") && !super_tooth_ref.equals("RD") && (super_tooth_ref.equals("") || super_tooth_ref.equals("undefined"))){
							//retained_tooth_no = ns_tooth_no;
							retained_tooth_no = mapped_tooth_no;//commented above and Added by Sridevi Joshi on 4/8/2010 for IN020464..retained_tooth_no was going as dissplay tooth no
						}

						if(rst != null) rst.close();
						if(pstmt != null) pstmt.close();
						sqlInsert="INSERT INTO OH_RESTORATIVE_CHART_DTL (OPERATING_FACILITY_ID,PATIENT_ID,chart_num,chart_line_num,ENCOUNTER_ID,PATIENT_CLASS,TREATMENT_CONDITION,TRMT_CATEGORY_TYPE,TRMT_CATEGORY_CODE,TRMT_CODE,CONDITION_TYPE,CONDITION_CODE,TREATMENT_INT_EXT,TREATMENT_CONDITION_DATE,SITE_TYPE,TOOTH_NO,TOOTH_RANGE,ARCH_SNO,QUADRANT_SNO,SURFACE_CODE,CUSP_TIP_CODE,LOCATION,ORDER_ID,STATUS,TREATMENTS_OUTCOME,FAILURE_REMARKS,REMARKS,MIXED_DENT_DECIDUOUS_YN,SUPERNUMERARY_YN,PRACTITIONER_ID,EPISODE_ID,EPISODE_TYPE,VISIT_ID,SOURCE_CODE,SOURCE_TYPE,INTRAORAL_EXTRAORAL,ORGAN_CODE,SUB_ORGAN_CODE,RETAINED_TOOTH_NO,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,DECODE(?,'ET',TO_DATE(?,'DD/MM/YYYY'),SYSDATE),?,?,?,?,?,?,?,?,?,?,?,?,?,NULL,?,?,?,?,?,?,?,?,?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?)";
						
						pstmt=con.prepareStatement(sqlInsert);
						index = 1;
						pstmt.setString(index++,facility_id);				//1  
						pstmt.setString(index++,patient_id);				//2  
						pstmt.setString(index++,chart_num);					//3  
						pstmt.setString(index++,chart_line_num);			//4  
						pstmt.setString(index++,encounter_id);				//5  
						pstmt.setString(index++,patient_class);				//6  
						pstmt.setString(index++,treatment_condition);		//7  
						pstmt.setString(index++,trmt_category_type);		//8  
						pstmt.setString(index++,trmt_category_code);		//9  
						pstmt.setString(index++,trmt_code);					//10 
						pstmt.setString(index++,"PARERTH");			//11 
						pstmt.setString(index++,condition_code);			//12 
						pstmt.setString(index++,treatment_int_ext);			//13 
						pstmt.setString(index++,tab_name);					//14
						pstmt.setString(index++,treatment_condition_date); //15
						pstmt.setString(index++,site_type);					//16
						pstmt.setString(index++,tooth_no);					//17
						pstmt.setString(index++,tooth_range_nos);			//18
						pstmt.setString(index++,arch);						//19
						pstmt.setString(index++,quadrant);					//20
					//	pstmt.setString(index++,surface_code);
						if (multiple_surfaces_applicable.equals("N")){//added by parul on 19/01/2010 for CRF-442
							pstmt.setString(index++,surface_code);			//21
						}else{
							pstmt.setString(index++,surface_arr[k]);			//21 parul130908
						}
						if (cusp_tip_value.length()>0){
						    pstmt.setString(index++,cusp_range.toString());					//22
						}else{
							if (surface_no.equals("*A")){
								 pstmt.setString(index++,cusp_range.toString());					//22
							}else{
								pstmt.setString(index++,null);
							}
						}
						pstmt.setString(index++,location);					//23
						pstmt.setString(index++,order_id);					//24
						pstmt.setString(index++,"Z");					//25
						pstmt.setString(index++,outcome);					//26
						pstmt.setString(index++,failure_remarks);					//26
						pstmt.setString(index++,remarks);					//27
						pstmt.setString(index++,supernuerary_yn);					//27
						pstmt.setString(index++,practitioner_id);					//27
						pstmt.setString(index++,episode_id);					//27
						pstmt.setString(index++,episode_type);					//27
						pstmt.setString(index++,visit_id);					//27
						pstmt.setString(index++,source_code);					//27
						pstmt.setString(index++,source_type);					//27
						pstmt.setString(index++,intraoral_extraoral);					//,
						pstmt.setString(index++,organ_code);					//27
						pstmt.setString(index++,sub_organ_code);					//27
						pstmt.setString(index++,retained_tooth_no);					//Added By Sridevi Joshi on 12/22/2009 for IN010894
						pstmt.setString(index++,login_user);				//28
						pstmt.setString(index++,client_ip_address);			//29
						pstmt.setString(index++,facility_id);				//30
						pstmt.setString(index++,login_user);				//31
						pstmt.setString(index++,client_ip_address); 		//32
						pstmt.setString(index++,facility_id);				//33
						flag = pstmt.executeUpdate();
						//chart_line_num_int++;
						flag_arr.add(""+flag);
					}

					if(mixed_dentition_YN.equals("N") && permanent_deciduous_flag.equals("P") && condition_type.equals("RTDESTH")){
						chart_line_num_int = chart_line_num_int+1;
						chart_line_num = chart_line_num_int+"";
						if(rst != null) rst.close();
						if(pstmt != null) pstmt.close();
						sqlInsert="INSERT INTO OH_RESTORATIVE_CHART_DTL (OPERATING_FACILITY_ID,PATIENT_ID,chart_num,chart_line_num,ENCOUNTER_ID,PATIENT_CLASS,TREATMENT_CONDITION,TRMT_CATEGORY_TYPE,TRMT_CATEGORY_CODE,TRMT_CODE,CONDITION_TYPE,CONDITION_CODE,TREATMENT_INT_EXT,TREATMENT_CONDITION_DATE,SITE_TYPE,TOOTH_NO,TOOTH_RANGE,ARCH_SNO,QUADRANT_SNO,SURFACE_CODE,CUSP_TIP_CODE,LOCATION,ORDER_ID,STATUS,TREATMENTS_OUTCOME,FAILURE_REMARKS,REMARKS,MIXED_DENT_DECIDUOUS_YN,SUPERNUMERARY_YN,PRACTITIONER_ID,EPISODE_ID,EPISODE_TYPE,VISIT_ID,SOURCE_CODE,SOURCE_TYPE,INTRAORAL_EXTRAORAL,ORGAN_CODE,SUB_ORGAN_CODE,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,DECODE(?,'ET',TO_DATE(?,'DD/MM/YYYY'),SYSDATE),?,?,?,?,?,?,?,?,?,?,?,?,?,NULL,?,?,?,?,?,?,?,?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?)";
						
						pstmt=con.prepareStatement(sqlInsert);
						index = 1;
						pstmt.setString(index++,facility_id);				//1  
						pstmt.setString(index++,patient_id);				//2  
						pstmt.setString(index++,chart_num);					//3  
						pstmt.setString(index++,chart_line_num);			//4  
						pstmt.setString(index++,encounter_id);				//5  
						pstmt.setString(index++,patient_class);				//6  
						pstmt.setString(index++,treatment_condition);		//7  
						pstmt.setString(index++,trmt_category_type);		//8  
						pstmt.setString(index++,trmt_category_code);		//9  
						pstmt.setString(index++,trmt_code);					//10 
						pstmt.setString(index++,"UNERTH");			//11 
						pstmt.setString(index++,condition_code);			//12 
						pstmt.setString(index++,treatment_int_ext);			//13 
						pstmt.setString(index++,tab_name);					//14
						pstmt.setString(index++,treatment_condition_date); //15
						pstmt.setString(index++,site_type);					//16
						pstmt.setString(index++,tooth_no);					//17
						pstmt.setString(index++,tooth_range_nos);			//18
						pstmt.setString(index++,arch);						//19
						pstmt.setString(index++,quadrant);					//20
					//	pstmt.setString(index++,surface_code);
					//	pstmt.setString(index++,cusp_tip);					//22
						if (multiple_surfaces_applicable.equals("N")){//added by parul on 19/01/2010 for CRF-442
							pstmt.setString(index++,surface_code);			//21
						}else{
							pstmt.setString(index++,surface_arr[k]);			//21 parul130908
						}
						if (cusp_tip_value.length()>0){
						    pstmt.setString(index++,cusp_range.toString());					//22
						}else{
							if (surface_no.equals("*A")){
								 pstmt.setString(index++,cusp_range.toString());					//22
							}else{
								pstmt.setString(index++,null);
							}
						}
						pstmt.setString(index++,location);					//23
						pstmt.setString(index++,order_id);					//24
						pstmt.setString(index++,"Z");					//25
						pstmt.setString(index++,outcome);					//26
						pstmt.setString(index++,failure_remarks);					//26
						pstmt.setString(index++,remarks);					//27
						pstmt.setString(index++,supernuerary_yn);					//27
						pstmt.setString(index++,practitioner_id);					//27
						pstmt.setString(index++,episode_id);					//27
						pstmt.setString(index++,episode_type);					//27
						pstmt.setString(index++,visit_id);					//27
						pstmt.setString(index++,source_code);					//27
						pstmt.setString(index++,source_type);					//27
						pstmt.setString(index++,intraoral_extraoral);					//,
						pstmt.setString(index++,organ_code);					//27
						pstmt.setString(index++,sub_organ_code);					//27
																				
						pstmt.setString(index++,login_user);				//28
						pstmt.setString(index++,client_ip_address);			//29
						pstmt.setString(index++,facility_id);				//30
						pstmt.setString(index++,login_user);				//31
						pstmt.setString(index++,client_ip_address); 		//32
						pstmt.setString(index++,facility_id);				//33
						flag = pstmt.executeUpdate();
						flag_arr.add(""+flag);
						//chart_line_num_int++;
					}
					
					if(rst != null) rst.close();
					if(pstmt != null) pstmt.close();

					if(condition_type.equals("IMPACTN")){
						if(oh_chart_level.equals("E")){
							//pstmt=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_DTL SET HIDE_IMAGE_YN = 'Y', COPIED_YN = 'N' WHERE PATIENT_ID = ? AND CHART_NUM = ? AND TOOTH_NO = ? AND NVL(STATUS, 'X') != 'E' AND CONDITION_TYPE IN ('UNERTH','PARERTH')");
							//Commented above and Added Sridevi Joshi on 12/17/2009 for IN017296 to show PARERTH image after recording impaction for 2nd time..
							pstmt=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_DTL SET HIDE_IMAGE_YN = 'Y', COPIED_YN = 'N' WHERE PATIENT_ID = ? AND CHART_NUM = ? AND TOOTH_NO = ? AND NVL(STATUS, 'X') != 'E' AND CONDITION_TYPE IN ('UNERTH')");
							pstmt.setString(1,patient_id);
							pstmt.setString(2,chart_num);
							pstmt.setString(3,tooth_no);
							flag = pstmt.executeUpdate();

							//pstmt=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_DTL SET COPIED_YN = 'N', STATUS = 'H' WHERE PATIENT_ID = ? AND CHART_NUM = ? AND TOOTH_NO = ? AND NVL(STATUS, 'X') != 'E' AND NVL(STATUS, 'X') != 'Z' AND CONDITION_TYPE IN ('UNERTH','PARERTH')");
							//Commented above and Added Sridevi Joshi on 12/17/2009 for IN017296 to show PARERTH image after recording impaction for 2nd time..
							pstmt=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_DTL SET COPIED_YN = 'N', STATUS = 'H' WHERE PATIENT_ID = ? AND CHART_NUM = ? AND TOOTH_NO = ? AND NVL(STATUS, 'X') != 'E' AND NVL(STATUS, 'X') != 'Z' AND CONDITION_TYPE IN ('UNERTH')");
							pstmt.setString(1,patient_id);
							pstmt.setString(2,chart_num);
							pstmt.setString(3,tooth_no);
							flag = pstmt.executeUpdate();
						}
						else{
							//pstmt=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_DTL SET HIDE_IMAGE_YN = 'Y', COPIED_YN = 'N' WHERE OPERATING_FACILITY_ID = ? AND PATIENT_ID = ? AND CHART_NUM = ? AND TOOTH_NO = ? AND NVL(STATUS, 'X') != 'E' AND CONDITION_TYPE IN ('UNERTH','PARERTH')");
							//Commented above and Added Sridevi Joshi on 12/17/2009 for IN017296 to show PARERTH image after recording impaction for 2nd time..
							pstmt=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_DTL SET HIDE_IMAGE_YN = 'Y', COPIED_YN = 'N' WHERE OPERATING_FACILITY_ID = ? AND PATIENT_ID = ? AND CHART_NUM = ? AND TOOTH_NO = ? AND NVL(STATUS, 'X') != 'E' AND CONDITION_TYPE IN ('UNERTH')");
							pstmt.setString(1,facility_id);
							pstmt.setString(2,patient_id);
							pstmt.setString(3,chart_num);
							pstmt.setString(4,tooth_no);
							flag = pstmt.executeUpdate();

							//pstmt=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_DTL SET COPIED_YN = 'N', STATUS = 'H' WHERE OPERATING_FACILITY_ID = ? AND PATIENT_ID = ? AND CHART_NUM = ? AND TOOTH_NO = ? AND NVL(STATUS, 'X') != 'E' AND NVL(STATUS, 'X') != 'Z' AND CONDITION_TYPE IN ('UNERTH','PARERTH')");
							//Commented above and Added Sridevi Joshi on 12/17/2009 for IN017296 to show PARERTH image after recording impaction for 2nd time..
							pstmt=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_DTL SET COPIED_YN = 'N', STATUS = 'H' WHERE OPERATING_FACILITY_ID = ? AND PATIENT_ID = ? AND CHART_NUM = ? AND TOOTH_NO = ? AND NVL(STATUS, 'X') != 'E' AND NVL(STATUS, 'X') != 'Z' AND CONDITION_TYPE IN ('UNERTH')");
							pstmt.setString(1,facility_id);
							pstmt.setString(2,patient_id);
							pstmt.setString(3,chart_num);
							pstmt.setString(4,tooth_no);
							flag = pstmt.executeUpdate();
						}
					}

					if(rst != null) rst.close();
					if(pstmt != null) pstmt.close();
					if(condition_type.equals("PARERTH")){
						if(oh_chart_level.equals("E")){
							pstmt=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_DTL SET HIDE_IMAGE_YN = 'Y', COPIED_YN = 'N' WHERE PATIENT_ID = ? AND CHART_NUM = ? AND TOOTH_NO = ? AND NVL(STATUS, 'X') != 'E' AND CONDITION_TYPE IN ('UNERTH','IMPACTN')");
							pstmt.setString(1,patient_id);
							pstmt.setString(2,chart_num);
							pstmt.setString(3,tooth_no);
							flag = pstmt.executeUpdate();

							pstmt=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_DTL SET COPIED_YN = 'N', STATUS = 'H' WHERE PATIENT_ID = ? AND CHART_NUM = ? AND TOOTH_NO = ? AND NVL(STATUS, 'X') != 'E' AND NVL(STATUS, 'X') != 'Z' AND CONDITION_TYPE IN ('UNERTH','IMPACTN')");
							pstmt.setString(1,patient_id);
							pstmt.setString(2,chart_num);
							pstmt.setString(3,tooth_no);
							flag = pstmt.executeUpdate();
						}
						else{
							pstmt=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_DTL SET HIDE_IMAGE_YN = 'Y', COPIED_YN = 'N' WHERE OPERATING_FACILITY_ID = ? AND PATIENT_ID = ? AND CHART_NUM = ? AND TOOTH_NO = ? AND NVL(STATUS, 'X') != 'E' AND CONDITION_TYPE IN ('UNERTH','IMPACTN')");
							pstmt.setString(1,facility_id);
							pstmt.setString(2,patient_id);
							pstmt.setString(3,chart_num);
							pstmt.setString(4,tooth_no);
							flag = pstmt.executeUpdate();

							pstmt=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_DTL SET COPIED_YN = 'N', STATUS = 'H' WHERE OPERATING_FACILITY_ID = ? AND PATIENT_ID = ? AND CHART_NUM = ? AND TOOTH_NO = ? AND NVL(STATUS, 'X') != 'E' AND NVL(STATUS, 'X') != 'Z' AND CONDITION_TYPE IN ('UNERTH','IMPACTN')");
							pstmt.setString(1,facility_id);
							pstmt.setString(2,patient_id);
							pstmt.setString(3,chart_num);
							pstmt.setString(4,tooth_no);
							flag = pstmt.executeUpdate();
						}
					}

					if(rst != null) rst.close();
					if(pstmt != null) pstmt.close();
					if(condition_type.equals("ERUPTH")){
						if(oh_chart_level.equals("E")){
							pstmt=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_DTL SET HIDE_IMAGE_YN = 'Y', COPIED_YN = 'N' WHERE PATIENT_ID = ? AND CHART_NUM = ? AND TOOTH_NO = ? AND NVL(STATUS, 'X') != 'E' AND CONDITION_TYPE IN ('PARERTH','UNERTH','IMPACTN')"); 
							pstmt.setString(1,patient_id);
							pstmt.setString(2,chart_num);
							pstmt.setString(3,tooth_no);
							flag = pstmt.executeUpdate();

							pstmt=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_DTL SET COPIED_YN = 'N', STATUS = 'H' WHERE PATIENT_ID = ? AND CHART_NUM = ? AND TOOTH_NO = ? AND NVL(STATUS, 'X') != 'E' AND NVL(STATUS, 'X') != 'Z' AND CONDITION_TYPE IN ('PARERTH','UNERTH','IMPACTN')"); 
							pstmt.setString(1,patient_id);
							pstmt.setString(2,chart_num);
							pstmt.setString(3,tooth_no);
							flag = pstmt.executeUpdate();
						}
						else{
							pstmt=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_DTL SET HIDE_IMAGE_YN = 'Y', COPIED_YN = 'N' WHERE OPERATING_FACILITY_ID = ? AND PATIENT_ID = ? AND CHART_NUM = ? AND TOOTH_NO = ? AND NVL(STATUS, 'X') != 'E' AND CONDITION_TYPE IN ('PARERTH','UNERTH','IMPACTN')"); 
							pstmt.setString(1,facility_id);
							pstmt.setString(2,patient_id);
							pstmt.setString(3,chart_num);
							pstmt.setString(4,tooth_no);
							flag = pstmt.executeUpdate();

							pstmt=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_DTL SET COPIED_YN = 'N', STATUS = 'H' WHERE OPERATING_FACILITY_ID = ? AND PATIENT_ID = ? AND CHART_NUM = ? AND TOOTH_NO = ? AND NVL(STATUS, 'X') != 'E' AND NVL(STATUS, 'X') != 'Z' AND CONDITION_TYPE IN ('PARERTH','UNERTH','IMPACTN')"); 
							pstmt.setString(1,facility_id);
							pstmt.setString(2,patient_id);
							pstmt.setString(3,chart_num);
							pstmt.setString(4,tooth_no);
							flag = pstmt.executeUpdate();
						}
					}

					if(rst != null) rst.close();
					if(pstmt != null) pstmt.close();
					
					if(condition_type.equals("EXFOLTH") && supernuerary_yn == "Y"){
						if(oh_chart_level.equals("E")){
							if(rst != null) rst.close();
							if(pstmt != null) pstmt.close();
							pstmt=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_DTL SET SUPERNUMERARY_YN = NULL, COPIED_YN = 'N' WHERE PATIENT_ID = ? AND CHART_NUM = ? AND TOOTH_NO = ? AND NVL(STATUS, 'X') != 'E' AND CONDITION_TYPE = 'EXFOLTH' AND SUPERNUMERARY_YN = 'N'"); 
							pstmt.setString(1,patient_id);
							pstmt.setString(2,chart_num);
							pstmt.setString(3,tooth_no);
							flag = pstmt.executeUpdate();

							if(rst != null) rst.close();
							if(pstmt != null) pstmt.close();
							//pstmt=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_DTL SET HIDE_IMAGE_YN = 'Y', COPIED_YN = 'N' WHERE PATIENT_ID = ? AND CHART_NUM = ? AND TOOTH_NO = ? AND NVL(STATUS, 'X') != 'E' AND CONDITION_TYPE NOT IN ('SUPRTH','EXFOLTH') AND SUPERNUMERARY_YN = 'Y'"); 
							//Removed SUPRTH from where cluase for update for SUPRTH record also ..added by Sridevi Joshi on 12/18/2009 for new SUPRTH changes
							pstmt=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_DTL SET HIDE_IMAGE_YN = 'Y', COPIED_YN = 'N' WHERE PATIENT_ID = ? AND CHART_NUM = ? AND TOOTH_NO = ? AND NVL(STATUS, 'X') != 'E' AND CONDITION_TYPE NOT IN ('EXFOLTH') AND SUPERNUMERARY_YN = 'Y' AND NVL(SUPER_TOOTH_NO,'X') = NVL(? ,'X') AND NVL(RETAINED_TOOTH_NO,'X') = NVL(? ,'X')"); 
							pstmt.setString(1,patient_id);
							pstmt.setString(2,chart_num);
							pstmt.setString(3,tooth_no);
							pstmt.setString(4,super_tooth_no);
							pstmt.setString(5,retained_tooth_no);
							flag = pstmt.executeUpdate();
						}
						else{
							if(rst != null) rst.close();
							if(pstmt != null) pstmt.close();
							pstmt=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_DTL SET SUPERNUMERARY_YN = NULL, COPIED_YN = 'N' WHERE OPERATING_FACILITY_ID = ? AND PATIENT_ID = ? AND CHART_NUM = ? AND TOOTH_NO = ? AND NVL(STATUS, 'X') != 'E' AND CONDITION_TYPE = 'EXFOLTH' AND SUPERNUMERARY_YN = 'N'"); 
							pstmt.setString(1,facility_id);
							pstmt.setString(2,patient_id);
							pstmt.setString(3,chart_num);
							pstmt.setString(4,tooth_no);
							flag = pstmt.executeUpdate();

							if(rst != null) rst.close();
							if(pstmt != null) pstmt.close();
							//pstmt=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_DTL SET HIDE_IMAGE_YN = 'Y', COPIED_YN = 'N' WHERE OPERATING_FACILITY_ID = ? AND PATIENT_ID = ? AND CHART_NUM = ? AND TOOTH_NO = ? AND NVL(STATUS, 'X') != 'E' AND CONDITION_TYPE NOT IN ('SUPRTH','EXFOLTH') AND SUPERNUMERARY_YN = 'Y' AND NVL(SUPER_TOOTH_NO,'X') = NVL(? ,'X') AND NVL(RETAINED_TOOTH_NO,'X') = NVL(? ,'X') "); 

							//Removed SUPRTH from where cluase for update for SUPRTH record also ..added by Sridevi Joshi on 12/18/2009 for new SUPRTH changes
							pstmt=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_DTL SET HIDE_IMAGE_YN = 'Y', COPIED_YN = 'N' WHERE OPERATING_FACILITY_ID = ? AND PATIENT_ID = ? AND CHART_NUM = ? AND TOOTH_NO = ? AND NVL(STATUS, 'X') != 'E' AND CONDITION_TYPE NOT IN ('EXFOLTH') AND SUPERNUMERARY_YN = 'Y' AND NVL(SUPER_TOOTH_NO,'X') = NVL(? ,'X') AND NVL(RETAINED_TOOTH_NO,'X') = NVL(? ,'X')"); 
							
							pstmt.setString(1,facility_id);
							pstmt.setString(2,patient_id);
							pstmt.setString(3,chart_num);
							pstmt.setString(4,tooth_no);
							pstmt.setString(5,super_tooth_no);
							pstmt.setString(6,retained_tooth_no);
							flag = pstmt.executeUpdate();

						}
					}
					else if(condition_type.equals("EXFOLTH")){
						if(oh_chart_level.equals("E")){
							if(rst != null) rst.close();
							if(pstmt != null) pstmt.close();
							pstmt=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_DTL SET HIDE_IMAGE_YN = 'D', COPIED_YN = 'N' WHERE PATIENT_ID = ? AND CHART_NUM = ? AND TOOTH_NO = ? AND NVL(STATUS, 'X') != 'E' AND CONDITION_TYPE = 'DECITH'"); 
							pstmt.setString(1,patient_id);
							pstmt.setString(2,chart_num);
							pstmt.setString(3,tooth_no);
							flag = pstmt.executeUpdate();

		
							if(pstmt != null) pstmt.close();
							pstmt=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_DTL SET HIDE_IMAGE_YN = 'R', COPIED_YN = 'N' WHERE PATIENT_ID = ? AND CHART_NUM = ? AND TOOTH_NO = ? AND NVL(STATUS, 'X') != 'E' AND CONDITION_TYPE = 'RTDESTH'"); 
							pstmt.setString(1,patient_id);
							pstmt.setString(2,chart_num);
							pstmt.setString(3,tooth_no);
							flag = pstmt.executeUpdate();
				
							if(deciduous_yn.equals("R")){
								if(pstmt != null) pstmt.close();
								pstmt=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_DTL SET HIDE_IMAGE_YN = 'Y', COPIED_YN = 'N' WHERE PATIENT_ID = ? AND CHART_NUM = ? AND TOOTH_NO = ? AND NVL(STATUS, 'X') != 'E' AND CONDITION_TYPE NOT IN ('RTDESTH','DECITH','EXFOLTH') AND MIXED_DENT_DECIDUOUS_YN = 'R' AND NVL(STATUS, 'X') != 'Z'"); 
								pstmt.setString(1,patient_id);
								pstmt.setString(2,chart_num);
								pstmt.setString(3,tooth_no);
								flag = pstmt.executeUpdate();

							}
							else{
								if(pstmt != null) pstmt.close();
								pstmt=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_DTL SET HIDE_IMAGE_YN = 'Y', COPIED_YN = 'N' WHERE PATIENT_ID = ? AND CHART_NUM = ? AND TOOTH_NO = ? AND NVL(STATUS, 'X') != 'E' AND CONDITION_TYPE NOT IN ('RTDESTH','DECITH','EXFOLTH') AND (SUPERNUMERARY_YN IS NULL OR SUPERNUMERARY_YN = 'N') AND NVL(MIXED_DENT_DECIDUOUS_YN,'A') <> 'R' AND CONDITION_TYPE != 'ERUPTH'"); 
								pstmt.setString(1,patient_id);
								pstmt.setString(2,chart_num);
								pstmt.setString(3,tooth_no);
								flag = pstmt.executeUpdate();
							}

							//Added by Sridevi Joshi on 1/18/2010 for IN010894 -->Exfolth both tooth after SUPRTH in MP/MD chart, SUPRTH  record should be updated for HIDE_IMAGE_YN = 'Y'
							pstmt=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_DTL SET HIDE_IMAGE_YN = 'Y', COPIED_YN = 'N' WHERE OPERATING_FACILITY_ID = ? AND PATIENT_ID = ? AND CHART_NUM = ? AND TOOTH_NO = ? AND NVL(STATUS, 'X') != 'E' AND CONDITION_TYPE  = 'SUPRTH' AND SUPERNUMERARY_YN = 'Y'"); 
							
							pstmt.setString(1,facility_id);
							pstmt.setString(2,patient_id);
							pstmt.setString(3,chart_num);
							pstmt.setString(4,tooth_no);
							//pstmt.setString(5,super_tooth_no);
							//pstmt.setString(6,retained_tooth_no);
							flag = pstmt.executeUpdate();
						}
						else{
							if(rst != null) rst.close();
							if(pstmt != null) pstmt.close();
							pstmt=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_DTL SET HIDE_IMAGE_YN = 'D', COPIED_YN = 'N' WHERE OPERATING_FACILITY_ID = ? AND PATIENT_ID = ? AND CHART_NUM = ? AND TOOTH_NO = ? AND NVL(STATUS, 'X') != 'E' AND CONDITION_TYPE = 'DECITH'"); 
							pstmt.setString(1,facility_id);
							pstmt.setString(2,patient_id);
							pstmt.setString(3,chart_num);
							pstmt.setString(4,tooth_no);
							flag = pstmt.executeUpdate();

		
							if(pstmt != null) pstmt.close();
							pstmt=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_DTL SET HIDE_IMAGE_YN = 'R', COPIED_YN = 'N' WHERE OPERATING_FACILITY_ID = ? AND PATIENT_ID = ? AND CHART_NUM = ? AND TOOTH_NO = ? AND NVL(STATUS, 'X') != 'E' AND CONDITION_TYPE = 'RTDESTH'"); 
							pstmt.setString(1,facility_id);
							pstmt.setString(2,patient_id);
							pstmt.setString(3,chart_num);
							pstmt.setString(4,tooth_no);
							flag = pstmt.executeUpdate();
				
							if(deciduous_yn.equals("R")){
								if(pstmt != null) pstmt.close();
								pstmt=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_DTL SET HIDE_IMAGE_YN = 'Y', COPIED_YN = 'N' WHERE OPERATING_FACILITY_ID = ? AND PATIENT_ID = ? AND CHART_NUM = ? AND TOOTH_NO = ? AND NVL(STATUS, 'X') != 'E' AND CONDITION_TYPE NOT IN ('RTDESTH','DECITH','EXFOLTH') AND MIXED_DENT_DECIDUOUS_YN = 'R' AND NVL(STATUS, 'X') != 'Z'"); 
								pstmt.setString(1,facility_id);
								pstmt.setString(2,patient_id);
								pstmt.setString(3,chart_num);
								pstmt.setString(4,tooth_no);
								flag = pstmt.executeUpdate();
							}
							else{
								if(pstmt != null) pstmt.close();
								pstmt=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_DTL SET HIDE_IMAGE_YN = 'Y', COPIED_YN = 'N' WHERE OPERATING_FACILITY_ID = ? AND PATIENT_ID = ? AND CHART_NUM = ? AND TOOTH_NO = ? AND NVL(STATUS, 'X') != 'E' AND CONDITION_TYPE NOT IN ('RTDESTH','DECITH','EXFOLTH') AND (SUPERNUMERARY_YN IS NULL OR SUPERNUMERARY_YN = 'N') AND NVL(MIXED_DENT_DECIDUOUS_YN,'A') <> 'R' AND CONDITION_TYPE != 'ERUPTH'"); 
								//pstmt=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_DTL SET HIDE_IMAGE_YN = 'Y', COPIED_YN = 'N' WHERE OPERATING_FACILITY_ID = ? AND PATIENT_ID = ? AND CHART_NUM = ? AND TOOTH_NO = ? AND NVL(STATUS, 'X') != 'E' AND CONDITION_TYPE NOT IN ('RTDESTH','DECITH','EXFOLTH') AND NVL(MIXED_DENT_DECIDUOUS_YN,'A') <> 'R' AND CONDITION_TYPE != 'ERUPTH' AND SUPER_TOOTH_NO IS NOT NULL "); 
								pstmt.setString(1,facility_id);
								pstmt.setString(2,patient_id);
								pstmt.setString(3,chart_num);
								pstmt.setString(4,tooth_no);
								flag = pstmt.executeUpdate();
							}

							//Added by Sridevi Joshi on 1/18/2010 for IN010894 -->Exfolth both tooth after SUPRTH in MP/MD chart, SUPRTH  record should be updated for HIDE_IMAGE_YN = 'Y'
							pstmt=con.prepareStatement("UPDATE OH_RESTORATIVE_CHART_DTL SET HIDE_IMAGE_YN = 'Y', COPIED_YN = 'N' WHERE OPERATING_FACILITY_ID = ? AND PATIENT_ID = ? AND CHART_NUM = ? AND TOOTH_NO = ? AND NVL(STATUS, 'X') != 'E' AND CONDITION_TYPE  = 'SUPRTH' AND SUPERNUMERARY_YN = 'Y'"); 
							pstmt.setString(1,facility_id);
							pstmt.setString(2,patient_id);
							pstmt.setString(3,chart_num);
							pstmt.setString(4,tooth_no);
							//pstmt.setString(5,super_tooth_no);
							//pstmt.setString(6,retained_tooth_no);
							flag = pstmt.executeUpdate();
						}
					}

					if(!flag_arr.contains("0")){
						commit_flag="Y";
					 }else{
						commit_flag="N";
					 }
				}//for surface
				flag_arr.clear();	//Common-ICN-0044
			}
				// For Updating the Clinical Group
				flag = 1;
				
				if(rst != null) rst.close();
				if(pstmt != null) pstmt.close();
				if((clinical_group_hid==null || clinical_group_hid.equals("")) && !clinical_group_code.equals("")){
					if(oh_chart_level.equals("E")){
						sqlUpdate = "UPDATE OH_RESTORATIVE_CHART_HDR SET CLINICAL_GROUP_CODE = ? WHERE PATIENT_ID = ? AND CHART_NUM = ?";
						pstmt=con.prepareStatement(sqlUpdate);
						pstmt.setString(1,clinical_group_code);
						pstmt.setString(2,patient_id);
						pstmt.setString(3,chart_num);
						flag = pstmt.executeUpdate();
					}
					else{
						sqlUpdate = "UPDATE OH_RESTORATIVE_CHART_HDR SET CLINICAL_GROUP_CODE = ? WHERE OPERATING_FACILITY_ID=? AND PATIENT_ID = ? AND CHART_NUM = ?";
						pstmt=con.prepareStatement(sqlUpdate);
						pstmt.setString(1,clinical_group_code);
						pstmt.setString(2,facility_id);
						pstmt.setString(3,patient_id);
						pstmt.setString(4,chart_num);
						flag = pstmt.executeUpdate();
					}
				}
				
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
					mesg.clear();	//Common-ICN-0044
				 }

				 res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode( msg,"UTF-8" ));
	}catch(Exception e){
				try{
					System.err.println("Rollback performed, Err Msg in OHDentalChartServletNew"+e.getMessage());
					con.rollback();
				}catch(Exception e_1){
					System.err.println("OHDentalChartServletNew :Caught Exception during rollback"+e_1);
				}

			    System.err.println("Err Msg in OHDentalChartServletNew"+e.getMessage());
				msg = e.toString();
				res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode( msg,"UTF-8" ));
	}finally{
		try{
				CommonData.clear();	//Common-ICN-0044
				if(rst!=null) rst.close();
				if(pstmt!=null) pstmt.close();
				if(pstmt1!=null) pstmt1.close();
				if(con!=null) ConnectionManager.returnConnection(con,req);
		}catch(Exception e){}
	  }
    }
 }



